package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c {
    private BdListView mMA;
    private com.baidu.tbadk.core.dialog.a mMC;
    private PostSearchActivity mMr;
    private View mMz;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mMB = null;
    private View bMM = null;
    private boolean mMD = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mMr = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mMz = this.mMr.findViewById(R.id.history_frame);
        this.mMA = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mMr.getActivity(), this.mMA, BdListViewHelper.HeadType.DEFAULT);
        this.mMB = new com.baidu.tieba.mainentrance.d(this.mMr.getPageContext().getPageActivity(), null);
        this.mMB.tO(false);
        this.mMA.setAdapter((ListAdapter) this.mMB);
        this.bMM = LayoutInflater.from(this.mMr.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mMA.addFooterView(this.bMM);
        this.bMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cWq();
            }
        });
        this.mMA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ar("c12403").dR("fid", c.this.mMr.mForumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", c.this.mMr.mForumName));
                String str = (String) c.this.mMA.getItemAtPosition(i + 1);
                c.this.mMr.QL(str);
                c.this.mMr.xQ(str);
                PostSearchActivity unused = c.this.mMr;
                TiebaStatic.log(new ar("c12842").dR("obj_name", str).dR("obj_source", "3").dR("obj_type", "2").dR("fid", c.this.mMr.mForumId));
            }
        });
        this.mMA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mMr.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWq() {
        if (this.mMC == null) {
            this.mMC = new com.baidu.tbadk.core.dialog.a(this.mMr.getPageContext().getPageActivity()).Au(this.mMr.getPageContext().getString(R.string.alert_clean_history)).a(this.mMr.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mMr.dBA().dBN();
                    c.this.mMA.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mMr.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mMr.getPageContext());
        }
        this.mMC.bqx();
    }

    private void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mMr.getPageContext().getPageActivity(), this.mMz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mMr.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mMr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mMr.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.mMr.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        CY(R.string.new_text_no_search_record);
    }

    public void dBF() {
        this.mMA.setVisibility(8);
        CY(R.string.new_text_no_search_result);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mMD = true;
        this.mMr.showLoadingView(this.mMz, false, this.mMr.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mMD = false;
        this.mMr.hideLoadingView(this.mMz);
    }

    public void bb(ArrayList<String> arrayList) {
        this.mMz.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mMA.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mMA.setVisibility(0);
        this.mMB.setData(arrayList);
        this.mMB.notifyDataSetChanged();
    }

    public void dBG() {
        this.mMz.setVisibility(8);
    }

    public boolean dBH() {
        return this.mMz.getVisibility() == 0 && !this.mMD && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mMr.getPageContext(), this.bMM);
        this.mMB.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mMr.getPageContext(), i);
        }
    }
}

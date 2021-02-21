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
    private PostSearchActivity mMG;
    private View mMO;
    private BdListView mMP;
    private com.baidu.tbadk.core.dialog.a mMR;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mMQ = null;
    private View bMM = null;
    private boolean mMS = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mMG = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mMO = this.mMG.findViewById(R.id.history_frame);
        this.mMP = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mMG.getActivity(), this.mMP, BdListViewHelper.HeadType.DEFAULT);
        this.mMQ = new com.baidu.tieba.mainentrance.d(this.mMG.getPageContext().getPageActivity(), null);
        this.mMQ.tO(false);
        this.mMP.setAdapter((ListAdapter) this.mMQ);
        this.bMM = LayoutInflater.from(this.mMG.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mMP.addFooterView(this.bMM);
        this.bMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cWx();
            }
        });
        this.mMP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ar("c12403").dR("fid", c.this.mMG.mForumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", c.this.mMG.mForumName));
                String str = (String) c.this.mMP.getItemAtPosition(i + 1);
                c.this.mMG.QM(str);
                c.this.mMG.xQ(str);
                PostSearchActivity unused = c.this.mMG;
                TiebaStatic.log(new ar("c12842").dR("obj_name", str).dR("obj_source", "3").dR("obj_type", "2").dR("fid", c.this.mMG.mForumId));
            }
        });
        this.mMP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mMG.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWx() {
        if (this.mMR == null) {
            this.mMR = new com.baidu.tbadk.core.dialog.a(this.mMG.getPageContext().getPageActivity()).Au(this.mMG.getPageContext().getString(R.string.alert_clean_history)).a(this.mMG.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mMG.dBH().dBU();
                    c.this.mMP.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mMG.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mMG.getPageContext());
        }
        this.mMR.bqx();
    }

    private void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mMG.getPageContext().getPageActivity(), this.mMO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mMG.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mMG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mMG.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.mMG.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        CY(R.string.new_text_no_search_record);
    }

    public void dBM() {
        this.mMP.setVisibility(8);
        CY(R.string.new_text_no_search_result);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mMS = true;
        this.mMG.showLoadingView(this.mMO, false, this.mMG.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mMS = false;
        this.mMG.hideLoadingView(this.mMO);
    }

    public void bb(ArrayList<String> arrayList) {
        this.mMO.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mMP.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mMP.setVisibility(0);
        this.mMQ.setData(arrayList);
        this.mMQ.notifyDataSetChanged();
    }

    public void dBN() {
        this.mMO.setVisibility(8);
    }

    public boolean dBO() {
        return this.mMO.getVisibility() == 0 && !this.mMS && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mMG.getPageContext(), this.bMM);
        this.mMQ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mMG.getPageContext(), i);
        }
    }
}

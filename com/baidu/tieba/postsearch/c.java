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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c {
    private PostSearchActivity kFF;
    private View kFO;
    private BdListView kFP;
    private com.baidu.tbadk.core.dialog.a kFR;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d kFQ = null;
    private View beU = null;
    private boolean kFS = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.kFF = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.kFO = this.kFF.findViewById(R.id.history_frame);
        this.kFP = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.kFF.getActivity(), this.kFP, BdListViewHelper.HeadType.DEFAULT);
        this.kFQ = new com.baidu.tieba.mainentrance.d(this.kFF.getPageContext().getPageActivity(), null);
        this.kFQ.qj(false);
        this.kFP.setAdapter((ListAdapter) this.kFQ);
        this.beU = LayoutInflater.from(this.kFF.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.kFP.addFooterView(this.beU);
        this.beU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmr();
            }
        });
        this.kFP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").dh("fid", c.this.kFF.mForumId).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fname", c.this.kFF.mForumName));
                String str = (String) c.this.kFP.getItemAtPosition(i + 1);
                c.this.kFF.KK(str);
                c.this.kFF.sT(str);
                PostSearchActivity unused = c.this.kFF;
                TiebaStatic.log(new an("c12842").dh("obj_name", str).dh("obj_source", "3").dh("obj_type", "2").dh("fid", c.this.kFF.mForumId));
            }
        });
        this.kFP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.kFF.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmr() {
        if (this.kFR == null) {
            this.kFR = new com.baidu.tbadk.core.dialog.a(this.kFF.getPageContext().getPageActivity()).vO(this.kFF.getPageContext().getString(R.string.alert_clean_history)).a(this.kFF.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.kFF.cSU().cTh();
                    c.this.kFP.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.kFF.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.kFF.getPageContext());
        }
        this.kFR.aST();
    }

    private void xC(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kFF.getPageContext().getPageActivity(), this.kFO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kFF.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lV(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.kFF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.kFF.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, this.kFF.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        xC(R.string.new_text_no_search_record);
    }

    public void cSZ() {
        this.kFP.setVisibility(8);
        xC(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.kFS = true;
        this.kFF.showLoadingView(this.kFO, false, this.kFF.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.kFS = false;
        this.kFF.hideLoadingView(this.kFO);
    }

    public void aR(ArrayList<String> arrayList) {
        this.kFO.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.kFP.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.kFP.setVisibility(0);
        this.kFQ.setData(arrayList);
        this.kFQ.notifyDataSetChanged();
    }

    public void cTa() {
        this.kFO.setVisibility(8);
    }

    public boolean cTb() {
        return this.kFO.getVisibility() == 0 && !this.kFS && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.kFF.getPageContext(), this.beU);
        this.kFQ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kFF.getPageContext(), i);
        }
    }
}

package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ab;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    private PostSearchActivity bXM;
    private View bXT;
    private BdListView bXU;
    private com.baidu.tbadk.core.dialog.a bXW;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.i bXV = null;
    private View mFooterView = null;
    private boolean bXX = false;

    public l(PostSearchActivity postSearchActivity, View view) {
        this.bXM = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.bXT = this.bXM.findViewById(com.baidu.tieba.q.history_frame);
        this.bXU = (BdListView) this.mRootView.findViewById(com.baidu.tieba.q.history_list);
        this.bXV = new com.baidu.tieba.mainentrance.i(this.bXM.getPageContext().getPageActivity(), null);
        this.bXV.dB(false);
        this.bXU.setAdapter((ListAdapter) this.bXV);
        this.mFooterView = com.baidu.adp.lib.g.b.hr().inflate(this.bXM.getPageContext().getPageActivity(), com.baidu.tieba.r.home_dialog_search_footer, null);
        this.bXU.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new m(this));
        this.bXU.setOnItemClickListener(new n(this));
        this.bXU.setOnTouchListener(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RM() {
        if (this.bXW == null) {
            this.bXW = new com.baidu.tbadk.core.dialog.a(this.bXM.getPageContext().getPageActivity()).cn(this.bXM.getPageContext().getString(com.baidu.tieba.t.alert_clean_history)).a(this.bXM.getPageContext().getString(com.baidu.tieba.t.clear_all_text), new p(this)).b(this.bXM.getPageContext().getString(com.baidu.tieba.t.alert_no_button), new q(this)).b(this.bXM.getPageContext());
        }
        this.bXW.rL();
    }

    private void fv(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bXM.getPageContext().getPageActivity(), this.bXT, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(com.baidu.tieba.t.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.bXM.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new r(this));
        }
        this.mNoDataView.setTextOption(ab.cv(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        fv(com.baidu.tieba.t.text_no_search_record);
    }

    public void aga() {
        this.bXU.setVisibility(8);
        fv(com.baidu.tieba.t.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void NW() {
        this.bXX = true;
        this.bXM.showLoadingView(this.bXT, false, this.bXM.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds400));
    }

    public void agb() {
        this.bXX = false;
        this.bXM.hideLoadingView(this.bXT);
    }

    public void O(ArrayList<String> arrayList) {
        this.bXT.setVisibility(0);
        agb();
        if (arrayList == null || arrayList.size() == 0) {
            this.bXU.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.bXU.setVisibility(0);
        this.bXV.setData(arrayList);
        this.bXV.notifyDataSetChanged();
    }

    public void agc() {
        this.bXT.setVisibility(8);
    }

    public boolean agd() {
        return this.bXT.getVisibility() == 0 && !this.bXX && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.bXM.getPageContext(), this.mFooterView);
        this.bXV.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bXM.getPageContext(), i);
        }
    }
}

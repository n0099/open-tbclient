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
    private PostSearchActivity bXN;
    private View bXU;
    private BdListView bXV;
    private com.baidu.tbadk.core.dialog.a bXX;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.i bXW = null;
    private View mFooterView = null;
    private boolean bXY = false;

    public l(PostSearchActivity postSearchActivity, View view) {
        this.bXN = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.bXU = this.bXN.findViewById(com.baidu.tieba.q.history_frame);
        this.bXV = (BdListView) this.mRootView.findViewById(com.baidu.tieba.q.history_list);
        this.bXW = new com.baidu.tieba.mainentrance.i(this.bXN.getPageContext().getPageActivity(), null);
        this.bXW.dB(false);
        this.bXV.setAdapter((ListAdapter) this.bXW);
        this.mFooterView = com.baidu.adp.lib.g.b.hr().inflate(this.bXN.getPageContext().getPageActivity(), com.baidu.tieba.r.home_dialog_search_footer, null);
        this.bXV.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new m(this));
        this.bXV.setOnItemClickListener(new n(this));
        this.bXV.setOnTouchListener(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RN() {
        if (this.bXX == null) {
            this.bXX = new com.baidu.tbadk.core.dialog.a(this.bXN.getPageContext().getPageActivity()).cn(this.bXN.getPageContext().getString(com.baidu.tieba.t.alert_clean_history)).a(this.bXN.getPageContext().getString(com.baidu.tieba.t.clear_all_text), new p(this)).b(this.bXN.getPageContext().getString(com.baidu.tieba.t.alert_no_button), new q(this)).b(this.bXN.getPageContext());
        }
        this.bXX.rL();
    }

    private void fv(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bXN.getPageContext().getPageActivity(), this.bXU, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(com.baidu.tieba.t.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.bXN.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new r(this));
        }
        this.mNoDataView.setTextOption(ab.cv(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        fv(com.baidu.tieba.t.text_no_search_record);
    }

    public void agb() {
        this.bXV.setVisibility(8);
        fv(com.baidu.tieba.t.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void NX() {
        this.bXY = true;
        this.bXN.showLoadingView(this.bXU, false, this.bXN.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds400));
    }

    public void agc() {
        this.bXY = false;
        this.bXN.hideLoadingView(this.bXU);
    }

    public void O(ArrayList<String> arrayList) {
        this.bXU.setVisibility(0);
        agc();
        if (arrayList == null || arrayList.size() == 0) {
            this.bXV.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.bXV.setVisibility(0);
        this.bXW.setData(arrayList);
        this.bXW.notifyDataSetChanged();
    }

    public void agd() {
        this.bXU.setVisibility(8);
    }

    public boolean age() {
        return this.bXU.getVisibility() == 0 && !this.bXY && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.bXN.getPageContext(), this.mFooterView);
        this.bXW.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bXN.getPageContext(), i);
        }
    }
}

package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    private PostSearchActivity cDL;
    private View cDS;
    private BdListView cDT;
    private com.baidu.tbadk.core.dialog.a cDV;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.i cDU = null;
    private View mFooterView = null;
    private boolean cDW = false;

    public k(PostSearchActivity postSearchActivity, View view) {
        this.cDL = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.cDS = this.cDL.findViewById(i.f.history_frame);
        this.cDT = (BdListView) this.mRootView.findViewById(i.f.history_list);
        this.cDU = new com.baidu.tieba.mainentrance.i(this.cDL.getPageContext().getPageActivity(), null);
        this.cDU.dJ(false);
        this.cDT.setAdapter((ListAdapter) this.cDU);
        this.mFooterView = LayoutInflater.from(this.cDL.getPageContext().getPageActivity()).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
        this.cDT.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new l(this));
        this.cDT.setOnItemClickListener(new m(this));
        this.cDT.setOnTouchListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uf() {
        if (this.cDV == null) {
            this.cDV = new com.baidu.tbadk.core.dialog.a(this.cDL.getPageContext().getPageActivity()).ct(this.cDL.getPageContext().getString(i.h.alert_clean_history)).a(this.cDL.getPageContext().getString(i.h.clear_all_text), new o(this)).b(this.cDL.getPageContext().getString(i.h.alert_no_button), new p(this)).b(this.cDL.getPageContext());
        }
        this.cDV.sR();
    }

    private void gh(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cDL.getPageContext().getPageActivity(), this.cDS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.cDL.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new q(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        gh(i.h.text_no_search_record);
    }

    public void aoo() {
        this.cDT.setVisibility(8);
        gh(i.h.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void KB() {
        this.cDW = true;
        this.cDL.showLoadingView(this.cDS, false, this.cDL.getResources().getDimensionPixelSize(i.d.ds400));
    }

    public void amT() {
        this.cDW = false;
        this.cDL.hideLoadingView(this.cDS);
    }

    public void ac(ArrayList<String> arrayList) {
        this.cDS.setVisibility(0);
        amT();
        if (arrayList == null || arrayList.size() == 0) {
            this.cDT.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.cDT.setVisibility(0);
        this.cDU.setData(arrayList);
        this.cDU.notifyDataSetChanged();
    }

    public void aop() {
        this.cDS.setVisibility(8);
    }

    public boolean aoq() {
        return this.cDS.getVisibility() == 0 && !this.cDW && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cDL.getPageContext(), this.mFooterView);
        this.cDU.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cDL.getPageContext(), i);
        }
    }
}

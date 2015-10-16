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
    private PostSearchActivity cDW;
    private View cEd;
    private BdListView cEe;
    private com.baidu.tbadk.core.dialog.a cEg;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.i cEf = null;
    private View mFooterView = null;
    private boolean cEh = false;

    public k(PostSearchActivity postSearchActivity, View view) {
        this.cDW = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.cEd = this.cDW.findViewById(i.f.history_frame);
        this.cEe = (BdListView) this.mRootView.findViewById(i.f.history_list);
        this.cEf = new com.baidu.tieba.mainentrance.i(this.cDW.getPageContext().getPageActivity(), null);
        this.cEf.dJ(false);
        this.cEe.setAdapter((ListAdapter) this.cEf);
        this.mFooterView = LayoutInflater.from(this.cDW.getPageContext().getPageActivity()).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
        this.cEe.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new l(this));
        this.cEe.setOnItemClickListener(new m(this));
        this.cEe.setOnTouchListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uf() {
        if (this.cEg == null) {
            this.cEg = new com.baidu.tbadk.core.dialog.a(this.cDW.getPageContext().getPageActivity()).cu(this.cDW.getPageContext().getString(i.h.alert_clean_history)).a(this.cDW.getPageContext().getString(i.h.clear_all_text), new o(this)).b(this.cDW.getPageContext().getString(i.h.alert_no_button), new p(this)).b(this.cDW.getPageContext());
        }
        this.cEg.sR();
    }

    private void gh(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cDW.getPageContext().getPageActivity(), this.cEd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.cDW.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
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
        this.cEe.setVisibility(8);
        gh(i.h.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void KB() {
        this.cEh = true;
        this.cDW.showLoadingView(this.cEd, false, this.cDW.getResources().getDimensionPixelSize(i.d.ds400));
    }

    public void amT() {
        this.cEh = false;
        this.cDW.hideLoadingView(this.cEd);
    }

    public void ac(ArrayList<String> arrayList) {
        this.cEd.setVisibility(0);
        amT();
        if (arrayList == null || arrayList.size() == 0) {
            this.cEe.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.cEe.setVisibility(0);
        this.cEf.setData(arrayList);
        this.cEf.notifyDataSetChanged();
    }

    public void aop() {
        this.cEd.setVisibility(8);
    }

    public boolean aoq() {
        return this.cEd.getVisibility() == 0 && !this.cEh && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cDW.getPageContext(), this.mFooterView);
        this.cEf.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cDW.getPageContext(), i);
        }
    }
}

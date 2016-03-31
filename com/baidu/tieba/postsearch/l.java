package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    private PostSearchActivity dSg;
    private View dSo;
    private BdListView dSp;
    private com.baidu.tbadk.core.dialog.a dSr;
    private com.baidu.tbadk.core.view.p mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.h dSq = null;
    private View bce = null;
    private boolean dSs = false;

    public l(PostSearchActivity postSearchActivity, View view) {
        this.dSg = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.dSo = this.dSg.findViewById(t.g.history_frame);
        this.dSp = (BdListView) this.mRootView.findViewById(t.g.history_list);
        this.dSq = new com.baidu.tieba.mainentrance.h(this.dSg.getPageContext().getPageActivity(), null);
        this.dSq.eV(false);
        this.dSp.setAdapter((ListAdapter) this.dSq);
        this.bce = LayoutInflater.from(this.dSg.getPageContext().getPageActivity()).inflate(t.h.home_dialog_search_footer, (ViewGroup) null);
        this.dSp.addFooterView(this.bce);
        this.bce.setOnClickListener(new m(this));
        this.dSp.setOnItemClickListener(new n(this));
        this.dSp.setOnTouchListener(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeO() {
        if (this.dSr == null) {
            this.dSr = new com.baidu.tbadk.core.dialog.a(this.dSg.getPageContext().getPageActivity()).cC(this.dSg.getPageContext().getString(t.j.alert_clean_history)).a(this.dSg.getPageContext().getString(t.j.clear_all_text), new p(this)).b(this.dSg.getPageContext().getString(t.j.alert_no_button), new q(this)).b(this.dSg.getPageContext());
        }
        this.dSr.up();
    }

    private void gk(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dSg.getPageContext().getPageActivity(), this.dSo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.dSg.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new r(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        gk(t.j.text_no_search_record);
    }

    public void aKF() {
        this.dSp.setVisibility(8);
        gk(t.j.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Ql() {
        this.dSs = true;
        this.dSg.showLoadingView(this.dSo, false, this.dSg.getResources().getDimensionPixelSize(t.e.ds386));
    }

    public void XX() {
        this.dSs = false;
        this.dSg.hideLoadingView(this.dSo);
    }

    public void al(ArrayList<String> arrayList) {
        this.dSo.setVisibility(0);
        XX();
        if (arrayList == null || arrayList.size() == 0) {
            this.dSp.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.dSp.setVisibility(0);
        this.dSq.setData(arrayList);
        this.dSq.notifyDataSetChanged();
    }

    public void aKG() {
        this.dSo.setVisibility(8);
    }

    public boolean aKH() {
        return this.dSo.getVisibility() == 0 && !this.dSs && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.dSg.getPageContext(), this.bce);
        this.dSq.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dSg.getPageContext(), i);
        }
    }
}

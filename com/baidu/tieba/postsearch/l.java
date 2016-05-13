package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    private PostSearchActivity dUY;
    private View dVg;
    private BdListView dVh;
    private com.baidu.tbadk.core.dialog.a dVj;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.h dVi = null;
    private View aYK = null;
    private boolean dVk = false;

    public l(PostSearchActivity postSearchActivity, View view) {
        this.dUY = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.dVg = this.dUY.findViewById(t.g.history_frame);
        this.dVh = (BdListView) this.mRootView.findViewById(t.g.history_list);
        BdListViewHelper.a(this.dUY.getActivity(), this.dVh, BdListViewHelper.HeadType.DEFAULT);
        this.dVi = new com.baidu.tieba.mainentrance.h(this.dUY.getPageContext().getPageActivity(), null);
        this.dVi.ft(false);
        this.dVh.setAdapter((ListAdapter) this.dVi);
        this.aYK = LayoutInflater.from(this.dUY.getPageContext().getPageActivity()).inflate(t.h.home_dialog_search_footer, (ViewGroup) null);
        this.dVh.addFooterView(this.aYK);
        this.aYK.setOnClickListener(new m(this));
        this.dVh.setOnItemClickListener(new n(this));
        this.dVh.setOnTouchListener(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeP() {
        if (this.dVj == null) {
            this.dVj = new com.baidu.tbadk.core.dialog.a(this.dUY.getPageContext().getPageActivity()).cA(this.dUY.getPageContext().getString(t.j.alert_clean_history)).a(this.dUY.getPageContext().getString(t.j.clear_all_text), new p(this)).b(this.dUY.getPageContext().getString(t.j.alert_no_button), new q(this)).b(this.dUY.getPageContext());
        }
        this.dVj.rV();
    }

    private void hb(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dUY.getPageContext().getPageActivity(), this.dVg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.c(this.dUY.getActivity(), t.e.ds320)), NoDataViewFactory.d.cO(t.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.dUY.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new r(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cO(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        hb(t.j.text_no_search_record);
    }

    public void aKM() {
        this.dVh.setVisibility(8);
        hb(t.j.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Pe() {
        this.dVk = true;
        this.dUY.showLoadingView(this.dVg, false, this.dUY.getResources().getDimensionPixelSize(t.e.ds386));
    }

    public void Pf() {
        this.dVk = false;
        this.dUY.hideLoadingView(this.dVg);
    }

    public void ak(ArrayList<String> arrayList) {
        this.dVg.setVisibility(0);
        Pf();
        if (arrayList == null || arrayList.size() == 0) {
            this.dVh.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.dVh.setVisibility(0);
        this.dVi.setData(arrayList);
        this.dVi.notifyDataSetChanged();
    }

    public void aKN() {
        this.dVg.setVisibility(8);
    }

    public boolean aKO() {
        return this.dVg.getVisibility() == 0 && !this.dVk && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.dUY.getPageContext(), this.aYK);
        this.dVi.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dUY.getPageContext(), i);
        }
    }
}

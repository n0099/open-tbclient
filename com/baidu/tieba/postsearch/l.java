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
    private PostSearchActivity dxA;
    private View dxI;
    private BdListView dxJ;
    private com.baidu.tbadk.core.dialog.a dxL;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.h dxK = null;
    private View aXv = null;
    private boolean dxM = false;

    public l(PostSearchActivity postSearchActivity, View view) {
        this.dxA = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.dxI = this.dxA.findViewById(t.g.history_frame);
        this.dxJ = (BdListView) this.mRootView.findViewById(t.g.history_list);
        this.dxK = new com.baidu.tieba.mainentrance.h(this.dxA.getPageContext().getPageActivity(), null);
        this.dxK.ey(false);
        this.dxJ.setAdapter((ListAdapter) this.dxK);
        this.aXv = LayoutInflater.from(this.dxA.getPageContext().getPageActivity()).inflate(t.h.home_dialog_search_footer, (ViewGroup) null);
        this.dxJ.addFooterView(this.aXv);
        this.aXv.setOnClickListener(new m(this));
        this.dxJ.setOnItemClickListener(new n(this));
        this.dxJ.setOnTouchListener(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abs() {
        if (this.dxL == null) {
            this.dxL = new com.baidu.tbadk.core.dialog.a(this.dxA.getPageContext().getPageActivity()).cE(this.dxA.getPageContext().getString(t.j.alert_clean_history)).a(this.dxA.getPageContext().getString(t.j.clear_all_text), new p(this)).b(this.dxA.getPageContext().getString(t.j.alert_no_button), new q(this)).b(this.dxA.getPageContext());
        }
        this.dxL.uj();
    }

    private void fU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dxA.getPageContext().getPageActivity(), this.dxI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.dxA.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new r(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        fU(t.j.text_no_search_record);
    }

    public void aCR() {
        this.dxJ.setVisibility(8);
        fU(t.j.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Ow() {
        this.dxM = true;
        this.dxA.showLoadingView(this.dxI, false, this.dxA.getResources().getDimensionPixelSize(t.e.ds386));
    }

    public void aAV() {
        this.dxM = false;
        this.dxA.hideLoadingView(this.dxI);
    }

    public void ak(ArrayList<String> arrayList) {
        this.dxI.setVisibility(0);
        aAV();
        if (arrayList == null || arrayList.size() == 0) {
            this.dxJ.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.dxJ.setVisibility(0);
        this.dxK.setData(arrayList);
        this.dxK.notifyDataSetChanged();
    }

    public void aCS() {
        this.dxI.setVisibility(8);
    }

    public boolean aCT() {
        return this.dxI.getVisibility() == 0 && !this.dxM && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.dxA.getPageContext(), this.aXv);
        this.dxK.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dxA.getPageContext(), i);
        }
    }
}

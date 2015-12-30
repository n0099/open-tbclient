package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    private PostSearchActivity djG;
    private View djO;
    private BdListView djP;
    private com.baidu.tbadk.core.dialog.a djR;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.i djQ = null;
    private View mFooterView = null;
    private boolean djS = false;

    public l(PostSearchActivity postSearchActivity, View view) {
        this.djG = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.djO = this.djG.findViewById(n.g.history_frame);
        this.djP = (BdListView) this.mRootView.findViewById(n.g.history_list);
        this.djQ = new com.baidu.tieba.mainentrance.i(this.djG.getPageContext().getPageActivity(), null);
        this.djQ.ek(false);
        this.djP.setAdapter((ListAdapter) this.djQ);
        this.mFooterView = LayoutInflater.from(this.djG.getPageContext().getPageActivity()).inflate(n.h.home_dialog_search_footer, (ViewGroup) null);
        this.djP.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new m(this));
        this.djP.setOnItemClickListener(new n(this));
        this.djP.setOnTouchListener(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YH() {
        if (this.djR == null) {
            this.djR = new com.baidu.tbadk.core.dialog.a(this.djG.getPageContext().getPageActivity()).cF(this.djG.getPageContext().getString(n.j.alert_clean_history)).a(this.djG.getPageContext().getString(n.j.clear_all_text), new p(this)).b(this.djG.getPageContext().getString(n.j.alert_no_button), new q(this)).b(this.djG.getPageContext());
        }
        this.djR.tf();
    }

    private void fv(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.djG.getPageContext().getPageActivity(), this.djO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.djG.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new r(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        fv(n.j.text_no_search_record);
    }

    public void awv() {
        this.djP.setVisibility(8);
        fv(n.j.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void MF() {
        this.djS = true;
        this.djG.showLoadingView(this.djO, false, this.djG.getResources().getDimensionPixelSize(n.e.ds386));
    }

    public void auH() {
        this.djS = false;
        this.djG.hideLoadingView(this.djO);
    }

    public void aj(ArrayList<String> arrayList) {
        this.djO.setVisibility(0);
        auH();
        if (arrayList == null || arrayList.size() == 0) {
            this.djP.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.djP.setVisibility(0);
        this.djQ.setData(arrayList);
        this.djQ.notifyDataSetChanged();
    }

    public void aww() {
        this.djO.setVisibility(8);
    }

    public boolean awx() {
        return this.djO.getVisibility() == 0 && !this.djS && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.djG.getPageContext(), this.mFooterView);
        this.djQ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.djG.getPageContext(), i);
        }
    }
}

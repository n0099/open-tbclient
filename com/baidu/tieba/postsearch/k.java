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
public class k {
    private PostSearchActivity deb;
    private View dei;
    private BdListView dej;
    private com.baidu.tbadk.core.dialog.a del;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.i dek = null;
    private View mFooterView = null;
    private boolean dem = false;

    public k(PostSearchActivity postSearchActivity, View view) {
        this.deb = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.dei = this.deb.findViewById(n.f.history_frame);
        this.dej = (BdListView) this.mRootView.findViewById(n.f.history_list);
        this.dek = new com.baidu.tieba.mainentrance.i(this.deb.getPageContext().getPageActivity(), null);
        this.dek.ek(false);
        this.dej.setAdapter((ListAdapter) this.dek);
        this.mFooterView = LayoutInflater.from(this.deb.getPageContext().getPageActivity()).inflate(n.g.home_dialog_search_footer, (ViewGroup) null);
        this.dej.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new l(this));
        this.dej.setOnItemClickListener(new m(this));
        this.dej.setOnTouchListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XC() {
        if (this.del == null) {
            this.del = new com.baidu.tbadk.core.dialog.a(this.deb.getPageContext().getPageActivity()).cC(this.deb.getPageContext().getString(n.i.alert_clean_history)).a(this.deb.getPageContext().getString(n.i.clear_all_text), new o(this)).b(this.deb.getPageContext().getString(n.i.alert_no_button), new p(this)).b(this.deb.getPageContext());
        }
        this.del.tv();
    }

    private void fA(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.deb.getPageContext().getPageActivity(), this.dei, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.deb.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new q(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        fA(n.i.text_no_search_record);
    }

    public void auC() {
        this.dej.setVisibility(8);
        fA(n.i.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void Mm() {
        this.dem = true;
        this.deb.showLoadingView(this.dei, false, this.deb.getResources().getDimensionPixelSize(n.d.ds386));
    }

    public void asV() {
        this.dem = false;
        this.deb.hideLoadingView(this.dei);
    }

    public void aj(ArrayList<String> arrayList) {
        this.dei.setVisibility(0);
        asV();
        if (arrayList == null || arrayList.size() == 0) {
            this.dej.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.dej.setVisibility(0);
        this.dek.setData(arrayList);
        this.dek.notifyDataSetChanged();
    }

    public void auD() {
        this.dei.setVisibility(8);
    }

    public boolean auE() {
        return this.dei.getVisibility() == 0 && !this.dem && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.deb.getPageContext(), this.mFooterView);
        this.dek.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.deb.getPageContext(), i);
        }
    }
}

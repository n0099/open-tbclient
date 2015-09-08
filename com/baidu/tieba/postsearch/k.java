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
    private PostSearchActivity cxd;
    private View cxk;
    private BdListView cxl;
    private com.baidu.tbadk.core.dialog.a cxn;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.f cxm = null;
    private View mFooterView = null;
    private boolean cxo = false;

    public k(PostSearchActivity postSearchActivity, View view) {
        this.cxd = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.cxk = this.cxd.findViewById(i.f.history_frame);
        this.cxl = (BdListView) this.mRootView.findViewById(i.f.history_list);
        this.cxm = new com.baidu.tieba.mainentrance.f(this.cxd.getPageContext().getPageActivity(), null);
        this.cxm.dJ(false);
        this.cxl.setAdapter((ListAdapter) this.cxm);
        this.mFooterView = LayoutInflater.from(this.cxd.getPageContext().getPageActivity()).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
        this.cxl.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new l(this));
        this.cxl.setOnItemClickListener(new m(this));
        this.cxl.setOnTouchListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tw() {
        if (this.cxn == null) {
            this.cxn = new com.baidu.tbadk.core.dialog.a(this.cxd.getPageContext().getPageActivity()).ct(this.cxd.getPageContext().getString(i.h.alert_clean_history)).a(this.cxd.getPageContext().getString(i.h.clear_all_text), new o(this)).b(this.cxd.getPageContext().getString(i.h.alert_no_button), new p(this)).b(this.cxd.getPageContext());
        }
        this.cxn.sU();
    }

    private void gc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cxd.getPageContext().getPageActivity(), this.cxk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cJ(i.h.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.cxd.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new q(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        gc(i.h.text_no_search_record);
    }

    public void ame() {
        this.cxl.setVisibility(8);
        gc(i.h.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void KG() {
        this.cxo = true;
        this.cxd.showLoadingView(this.cxk, false, this.cxd.getResources().getDimensionPixelSize(i.d.ds400));
    }

    public void akM() {
        this.cxo = false;
        this.cxd.hideLoadingView(this.cxk);
    }

    public void aa(ArrayList<String> arrayList) {
        this.cxk.setVisibility(0);
        akM();
        if (arrayList == null || arrayList.size() == 0) {
            this.cxl.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.cxl.setVisibility(0);
        this.cxm.setData(arrayList);
        this.cxm.notifyDataSetChanged();
    }

    public void amf() {
        this.cxk.setVisibility(8);
    }

    public boolean amg() {
        return this.cxk.getVisibility() == 0 && !this.cxo && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cxd.getPageContext(), this.mFooterView);
        this.cxm.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cxd.getPageContext(), i);
        }
    }
}

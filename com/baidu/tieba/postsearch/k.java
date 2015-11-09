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
    private BdListView cFA;
    private com.baidu.tbadk.core.dialog.a cFC;
    private PostSearchActivity cFs;
    private View cFz;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.i cFB = null;
    private View mFooterView = null;
    private boolean cFD = false;

    public k(PostSearchActivity postSearchActivity, View view) {
        this.cFs = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.cFz = this.cFs.findViewById(i.f.history_frame);
        this.cFA = (BdListView) this.mRootView.findViewById(i.f.history_list);
        this.cFB = new com.baidu.tieba.mainentrance.i(this.cFs.getPageContext().getPageActivity(), null);
        this.cFB.dL(false);
        this.cFA.setAdapter((ListAdapter) this.cFB);
        this.mFooterView = LayoutInflater.from(this.cFs.getPageContext().getPageActivity()).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
        this.cFA.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new l(this));
        this.cFA.setOnItemClickListener(new m(this));
        this.cFA.setOnTouchListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uw() {
        if (this.cFC == null) {
            this.cFC = new com.baidu.tbadk.core.dialog.a(this.cFs.getPageContext().getPageActivity()).cu(this.cFs.getPageContext().getString(i.h.alert_clean_history)).a(this.cFs.getPageContext().getString(i.h.clear_all_text), new o(this)).b(this.cFs.getPageContext().getString(i.h.alert_no_button), new p(this)).b(this.cFs.getPageContext());
        }
        this.cFC.sR();
    }

    private void gu(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cFs.getPageContext().getPageActivity(), this.cFz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.cFs.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new q(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        gu(i.h.text_no_search_record);
    }

    public void aoQ() {
        this.cFA.setVisibility(8);
        gu(i.h.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void KN() {
        this.cFD = true;
        this.cFs.showLoadingView(this.cFz, false, this.cFs.getResources().getDimensionPixelSize(i.d.ds400));
    }

    public void anv() {
        this.cFD = false;
        this.cFs.hideLoadingView(this.cFz);
    }

    public void ac(ArrayList<String> arrayList) {
        this.cFz.setVisibility(0);
        anv();
        if (arrayList == null || arrayList.size() == 0) {
            this.cFA.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.cFA.setVisibility(0);
        this.cFB.setData(arrayList);
        this.cFB.notifyDataSetChanged();
    }

    public void aoR() {
        this.cFz.setVisibility(8);
    }

    public boolean aoS() {
        return this.cFz.getVisibility() == 0 && !this.cFD && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.cFs.getPageContext(), this.mFooterView);
        this.cFB.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cFs.getPageContext(), i);
        }
    }
}

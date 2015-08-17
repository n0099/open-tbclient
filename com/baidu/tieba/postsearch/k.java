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
    private PostSearchActivity coG;
    private View coN;
    private BdListView coO;
    private com.baidu.tbadk.core.dialog.a coQ;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.f coP = null;
    private View mFooterView = null;
    private boolean coR = false;

    public k(PostSearchActivity postSearchActivity, View view) {
        this.coG = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.coN = this.coG.findViewById(i.f.history_frame);
        this.coO = (BdListView) this.mRootView.findViewById(i.f.history_list);
        this.coP = new com.baidu.tieba.mainentrance.f(this.coG.getPageContext().getPageActivity(), null);
        this.coP.dE(false);
        this.coO.setAdapter((ListAdapter) this.coP);
        this.mFooterView = LayoutInflater.from(this.coG.getPageContext().getPageActivity()).inflate(i.g.home_dialog_search_footer, (ViewGroup) null);
        this.coO.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new l(this));
        this.coO.setOnItemClickListener(new m(this));
        this.coO.setOnTouchListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tu() {
        if (this.coQ == null) {
            this.coQ = new com.baidu.tbadk.core.dialog.a(this.coG.getPageContext().getPageActivity()).cn(this.coG.getPageContext().getString(i.C0057i.alert_clean_history)).a(this.coG.getPageContext().getString(i.C0057i.clear_all_text), new o(this)).b(this.coG.getPageContext().getString(i.C0057i.alert_no_button), new p(this)).b(this.coG.getPageContext());
        }
        this.coQ.sP();
    }

    private void fT(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.coG.getPageContext().getPageActivity(), this.coN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cD(i.C0057i.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.coG.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new q(this));
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        fT(i.C0057i.text_no_search_record);
    }

    public void ahZ() {
        this.coO.setVisibility(8);
        fT(i.C0057i.no_search_result_record);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void KS() {
        this.coR = true;
        this.coG.showLoadingView(this.coN, false, this.coG.getResources().getDimensionPixelSize(i.d.ds400));
    }

    public void aia() {
        this.coR = false;
        this.coG.hideLoadingView(this.coN);
    }

    public void U(ArrayList<String> arrayList) {
        this.coN.setVisibility(0);
        aia();
        if (arrayList == null || arrayList.size() == 0) {
            this.coO.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.coO.setVisibility(0);
        this.coP.setData(arrayList);
        this.coP.notifyDataSetChanged();
    }

    public void aib() {
        this.coN.setVisibility(8);
    }

    public boolean aic() {
        return this.coN.getVisibility() == 0 && !this.coR && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.coG.getPageContext(), this.mFooterView);
        this.coP.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.coG.getPageContext(), i);
        }
    }
}

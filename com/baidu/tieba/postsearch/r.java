package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends BaseFragment implements BdListView.e {
    private PbListView aWL;
    private PostSearchActivity cDL;
    private BdListView cDY;
    private v cDZ;
    private j cEa;
    private String cEb;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRootView;
    private int mTabType;

    public r() {
        this.mTabType = -1;
        this.cEb = "";
    }

    public r(int i) {
        this.mTabType = -1;
        this.cEb = "";
        this.mTabType = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(i.g.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cDL = (PostSearchActivity) getBaseFragmentActivity();
        this.cDZ = new v(this.cDL.getPageContext());
        this.cDY.setAdapter((ListAdapter) this.cDZ);
        this.aWL = new PbListView(this.cDL.getPageContext().getPageActivity());
        this.aWL.no();
        this.cDY.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        fK(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cDL != null) {
            com.baidu.tbadk.h.a.a(this.cDL.getPageContext(), this.mRootView);
        }
        if (this.aWL != null) {
            this.aWL.cN(i);
        }
        if (this.cDZ != null) {
            this.cDZ.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.ctC == null || jVar.ctC.size() == 0) {
            if (!z || this.cEa == null || this.cEa.ctC == null || this.cEa.ctC.size() == 0) {
                Mg();
                showNoDataView();
                this.cDY.setVisibility(8);
                this.cEa = jVar;
                return;
            }
            if (this.cEa.cDQ.rL() == 1) {
                Me();
                return;
            } else {
                Mf();
                return;
            }
        }
        if (!z || this.cEa == null || this.cEa.ctC == null || this.cEa.ctC.size() == 0) {
            this.cEa = jVar;
        } else {
            this.cEa.cDQ = jVar.cDQ;
            this.cEa.ctC.addAll(jVar.ctC);
        }
        if (this.cEa.cDQ.rL() == 1) {
            Me();
        } else {
            Mf();
        }
        this.cDZ.clear();
        this.cDZ.bj(this.cEa.ctC);
        this.cDZ.notifyDataSetChanged();
        if (!z) {
            this.cDY.setSelection(0);
        }
        this.cDY.setVisibility(0);
    }

    public void fK(boolean z) {
        String str = this.cDL.bUK;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.cEb) || z;
            if (this.cEa == null || (this.cEa != null && !this.cEa.WW() && this.cEa.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.cDL.getResources().getDimensionPixelSize(i.d.ds320));
                this.cDL.aok().X(str, this.mTabType);
                this.cEb = str;
            }
        }
    }

    public void aor() {
        if (this.cEa != null && this.cEa.ctC != null) {
            this.cEa.ctC.clear();
            this.cDZ.clear();
            this.cDZ.bj(this.cEa.ctC);
            this.cDZ.notifyDataSetChanged();
        }
        Mg();
        hideNoDataView();
    }

    private void initView() {
        this.cDY = (BdListView) this.mRootView.findViewById(i.f.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.cEb) && this.cEa != null && this.cEa.isHasMore() && this.cDL.aok().X(this.cEb, this.mTabType)) {
            aos();
        }
    }

    private void aos() {
        this.cDY.setNextPage(this.aWL);
        this.aWL.startLoadData();
    }

    private void Me() {
        this.cDY.setNextPage(this.aWL);
        this.aWL.vy();
        this.aWL.setText(this.cDL.getResources().getString(i.h.pb_load_more));
    }

    private void Mf() {
        this.cDY.setNextPage(this.aWL);
        this.aWL.vy();
        this.aWL.setText(this.cDL.getResources().getString(i.h.list_no_more));
    }

    private void Mg() {
        this.cDY.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cDL.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.cDL.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

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
    private PbListView aWW;
    private PostSearchActivity cDW;
    private BdListView cEj;
    private v cEk;
    private j cEl;
    private String cEm;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRootView;
    private int mTabType;

    public r() {
        this.mTabType = -1;
        this.cEm = "";
    }

    public r(int i) {
        this.mTabType = -1;
        this.cEm = "";
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
        this.cDW = (PostSearchActivity) getBaseFragmentActivity();
        this.cEk = new v(this.cDW.getPageContext());
        this.cEj.setAdapter((ListAdapter) this.cEk);
        this.aWW = new PbListView(this.cDW.getPageContext().getPageActivity());
        this.aWW.no();
        this.cEj.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        fK(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cDW != null) {
            com.baidu.tbadk.h.a.a(this.cDW.getPageContext(), this.mRootView);
        }
        if (this.aWW != null) {
            this.aWW.cN(i);
        }
        if (this.cEk != null) {
            this.cEk.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.ctN == null || jVar.ctN.size() == 0) {
            if (!z || this.cEl == null || this.cEl.ctN == null || this.cEl.ctN.size() == 0) {
                Mg();
                showNoDataView();
                this.cEj.setVisibility(8);
                this.cEl = jVar;
                return;
            }
            if (this.cEl.cEb.rL() == 1) {
                Me();
                return;
            } else {
                Mf();
                return;
            }
        }
        if (!z || this.cEl == null || this.cEl.ctN == null || this.cEl.ctN.size() == 0) {
            this.cEl = jVar;
        } else {
            this.cEl.cEb = jVar.cEb;
            this.cEl.ctN.addAll(jVar.ctN);
        }
        if (this.cEl.cEb.rL() == 1) {
            Me();
        } else {
            Mf();
        }
        this.cEk.clear();
        this.cEk.bj(this.cEl.ctN);
        this.cEk.notifyDataSetChanged();
        if (!z) {
            this.cEj.setSelection(0);
        }
        this.cEj.setVisibility(0);
    }

    public void fK(boolean z) {
        String str = this.cDW.bUV;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.cEm) || z;
            if (this.cEl == null || (this.cEl != null && !this.cEl.WW() && this.cEl.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.cDW.getResources().getDimensionPixelSize(i.d.ds320));
                this.cDW.aok().X(str, this.mTabType);
                this.cEm = str;
            }
        }
    }

    public void aor() {
        if (this.cEl != null && this.cEl.ctN != null) {
            this.cEl.ctN.clear();
            this.cEk.clear();
            this.cEk.bj(this.cEl.ctN);
            this.cEk.notifyDataSetChanged();
        }
        Mg();
        hideNoDataView();
    }

    private void initView() {
        this.cEj = (BdListView) this.mRootView.findViewById(i.f.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.cEm) && this.cEl != null && this.cEl.isHasMore() && this.cDW.aok().X(this.cEm, this.mTabType)) {
            aos();
        }
    }

    private void aos() {
        this.cEj.setNextPage(this.aWW);
        this.aWW.startLoadData();
    }

    private void Me() {
        this.cEj.setNextPage(this.aWW);
        this.aWW.vy();
        this.aWW.setText(this.cDW.getResources().getString(i.h.pb_load_more));
    }

    private void Mf() {
        this.cEj.setNextPage(this.aWW);
        this.aWW.vy();
        this.aWW.setText(this.cDW.getResources().getString(i.h.list_no_more));
    }

    private void Mg() {
        this.cEj.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cDW.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.cDW.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

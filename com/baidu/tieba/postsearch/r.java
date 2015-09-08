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
    private PbListView aXr;
    private PostSearchActivity cxd;
    private BdListView cxq;
    private v cxr;
    private j cxs;
    private String cxt;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private View mRootView;
    private int mTabType;

    public r() {
        this.mTabType = -1;
        this.cxt = "";
    }

    public r(int i) {
        this.mTabType = -1;
        this.cxt = "";
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
        this.cxd = (PostSearchActivity) getBaseFragmentActivity();
        this.cxr = new v(this.cxd.getPageContext());
        this.cxq.setAdapter((ListAdapter) this.cxr);
        this.aXr = new PbListView(this.cxd.getPageContext().getPageActivity());
        this.aXr.nn();
        this.cxq.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        fz(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cxd != null) {
            com.baidu.tbadk.h.a.a(this.cxd.getPageContext(), this.mRootView);
        }
        if (this.aXr != null) {
            this.aXr.cM(i);
        }
        if (this.cxr != null) {
            this.cxr.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.cnV == null || jVar.cnV.size() == 0) {
            if (!z || this.cxs == null || this.cxs.cnV == null || this.cxs.cnV.size() == 0) {
                Mh();
                showNoDataView();
                this.cxq.setVisibility(8);
                this.cxs = jVar;
                return;
            }
            if (this.cxs.cxi.rQ() == 1) {
                Mf();
                return;
            } else {
                Mg();
                return;
            }
        }
        if (!z || this.cxs == null || this.cxs.cnV == null || this.cxs.cnV.size() == 0) {
            this.cxs = jVar;
        } else {
            this.cxs.cxi = jVar.cxi;
            this.cxs.cnV.addAll(jVar.cnV);
        }
        if (this.cxs.cxi.rQ() == 1) {
            Mf();
        } else {
            Mg();
        }
        this.cxr.clear();
        this.cxr.bi(this.cxs.cnV);
        this.cxr.notifyDataSetChanged();
        if (!z) {
            this.cxq.setSelection(0);
        }
        this.cxq.setVisibility(0);
    }

    public void fz(boolean z) {
        String str = this.cxd.bQZ;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.cxt) || z;
            if (this.cxs == null || (this.cxs != null && !this.cxs.Wn() && this.cxs.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.cxd.getResources().getDimensionPixelSize(i.d.ds320));
                this.cxd.ama().V(str, this.mTabType);
                this.cxt = str;
            }
        }
    }

    public void amh() {
        if (this.cxs != null && this.cxs.cnV != null) {
            this.cxs.cnV.clear();
            this.cxr.clear();
            this.cxr.bi(this.cxs.cnV);
            this.cxr.notifyDataSetChanged();
        }
        Mh();
        hideNoDataView();
    }

    private void initView() {
        this.cxq = (BdListView) this.mRootView.findViewById(i.f.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.cxt) && this.cxs != null && this.cxs.isHasMore() && this.cxd.ama().V(this.cxt, this.mTabType)) {
            ami();
        }
    }

    private void ami() {
        this.cxq.setNextPage(this.aXr);
        this.aXr.startLoadData();
    }

    private void Mf() {
        this.cxq.setNextPage(this.aXr);
        this.aXr.vG();
        this.aXr.setText(this.cxd.getResources().getString(i.h.pb_load_more));
    }

    private void Mg() {
        this.cxq.setNextPage(this.aXr);
        this.aXr.vG();
        this.aXr.setText(this.cxd.getResources().getString(i.h.list_no_more));
    }

    private void Mh() {
        this.cxq.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cxd.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cJ(i.h.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.cxd.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

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
import com.baidu.tbadk.core.view.ab;
/* loaded from: classes.dex */
public class s extends BaseFragment implements com.baidu.adp.widget.ListView.x {
    private PbListView aOg;
    private PostSearchActivity bXN;
    private BdListView bYa;
    private w bYb;
    private j bYc;
    private String bYd;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private View mRootView;
    private int mTabType;

    public s() {
        this.mTabType = -1;
        this.bYd = "";
    }

    public s(int i) {
        this.mTabType = -1;
        this.bYd = "";
        this.mTabType = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(com.baidu.tieba.r.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bXN = (PostSearchActivity) getBaseFragmentActivity();
        this.bYb = new w(this.bXN.getPageContext());
        this.bYa.setAdapter((ListAdapter) this.bYb);
        this.aOg = new PbListView(this.bXN.getPageContext().getPageActivity());
        this.aOg.ng();
        this.bYa.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        ev(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bXN != null) {
            com.baidu.tbadk.f.a.a(this.bXN.getPageContext(), this.mRootView);
        }
        if (this.aOg != null) {
            this.aOg.cy(i);
        }
        if (this.bYb != null) {
            this.bYb.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.bWC == null || jVar.bWC.size() == 0) {
            if (!z || this.bYc == null || this.bYc.bWC == null || this.bYc.bWC.size() == 0) {
                LE();
                showNoDataView();
                this.bYa.setVisibility(8);
                this.bYc = jVar;
                return;
            }
            if (this.bYc.bXS.qR() == 1) {
                LC();
                return;
            } else {
                LD();
                return;
            }
        }
        if (!z || this.bYc == null || this.bYc.bWC == null || this.bYc.bWC.size() == 0) {
            this.bYc = jVar;
        } else {
            this.bYc.bXS = jVar.bXS;
            this.bYc.bWC.addAll(jVar.bWC);
        }
        if (this.bYc.bXS.qR() == 1) {
            LC();
        } else {
            LD();
        }
        this.bYb.clear();
        this.bYb.aW(this.bYc.bWC);
        this.bYb.notifyDataSetChanged();
        if (!z) {
            this.bYa.setSelection(0);
        }
        this.bYa.setVisibility(0);
    }

    public void ev(boolean z) {
        String str = this.bXN.bCg;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.bYd) || z;
            if (this.bYc == null || (this.bYc != null && !this.bYc.UE() && this.bYc.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.bXN.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds320));
                this.bXN.afX().P(str, this.mTabType);
                this.bYd = str;
            }
        }
    }

    public void agf() {
        if (this.bYc != null && this.bYc.bWC != null) {
            this.bYc.bWC.clear();
            this.bYb.clear();
            this.bYb.aW(this.bYc.bWC);
            this.bYb.notifyDataSetChanged();
        }
        LE();
        hideNoDataView();
    }

    private void initView() {
        this.bYa = (BdListView) this.mRootView.findViewById(com.baidu.tieba.q.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.bYd) && this.bYc != null && this.bYc.isHasMore() && this.bXN.afX().P(this.bYd, this.mTabType)) {
            agg();
        }
    }

    private void agg() {
        this.bYa.setNextPage(this.aOg);
        this.aOg.startLoadData();
    }

    private void LC() {
        this.bYa.setNextPage(this.aOg);
        this.aOg.ux();
        this.aOg.setText(this.bXN.getResources().getString(com.baidu.tieba.t.pb_load_more));
    }

    private void LD() {
        this.bYa.setNextPage(this.aOg);
        this.aOg.ux();
        this.aOg.setText(this.bXN.getResources().getString(com.baidu.tieba.t.list_no_more));
    }

    private void LE() {
        this.bYa.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bXN.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(com.baidu.tieba.t.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.bXN.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

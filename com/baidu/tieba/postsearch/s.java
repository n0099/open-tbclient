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
    private PbListView aOf;
    private PostSearchActivity bXM;
    private BdListView bXZ;
    private w bYa;
    private j bYb;
    private String bYc;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private View mRootView;
    private int mTabType;

    public s() {
        this.mTabType = -1;
        this.bYc = "";
    }

    public s(int i) {
        this.mTabType = -1;
        this.bYc = "";
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
        this.bXM = (PostSearchActivity) getBaseFragmentActivity();
        this.bYa = new w(this.bXM.getPageContext());
        this.bXZ.setAdapter((ListAdapter) this.bYa);
        this.aOf = new PbListView(this.bXM.getPageContext().getPageActivity());
        this.aOf.ng();
        this.bXZ.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        ev(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bXM != null) {
            com.baidu.tbadk.f.a.a(this.bXM.getPageContext(), this.mRootView);
        }
        if (this.aOf != null) {
            this.aOf.cy(i);
        }
        if (this.bYa != null) {
            this.bYa.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.bWB == null || jVar.bWB.size() == 0) {
            if (!z || this.bYb == null || this.bYb.bWB == null || this.bYb.bWB.size() == 0) {
                LD();
                showNoDataView();
                this.bXZ.setVisibility(8);
                this.bYb = jVar;
                return;
            }
            if (this.bYb.bXR.qR() == 1) {
                LB();
                return;
            } else {
                LC();
                return;
            }
        }
        if (!z || this.bYb == null || this.bYb.bWB == null || this.bYb.bWB.size() == 0) {
            this.bYb = jVar;
        } else {
            this.bYb.bXR = jVar.bXR;
            this.bYb.bWB.addAll(jVar.bWB);
        }
        if (this.bYb.bXR.qR() == 1) {
            LB();
        } else {
            LC();
        }
        this.bYa.clear();
        this.bYa.aW(this.bYb.bWB);
        this.bYa.notifyDataSetChanged();
        if (!z) {
            this.bXZ.setSelection(0);
        }
        this.bXZ.setVisibility(0);
    }

    public void ev(boolean z) {
        String str = this.bXM.bCf;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.bYc) || z;
            if (this.bYb == null || (this.bYb != null && !this.bYb.UD() && this.bYb.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.bXM.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds320));
                this.bXM.afW().P(str, this.mTabType);
                this.bYc = str;
            }
        }
    }

    public void age() {
        if (this.bYb != null && this.bYb.bWB != null) {
            this.bYb.bWB.clear();
            this.bYa.clear();
            this.bYa.aW(this.bYb.bWB);
            this.bYa.notifyDataSetChanged();
        }
        LD();
        hideNoDataView();
    }

    private void initView() {
        this.bXZ = (BdListView) this.mRootView.findViewById(com.baidu.tieba.q.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.bYc) && this.bYb != null && this.bYb.isHasMore() && this.bXM.afW().P(this.bYc, this.mTabType)) {
            agf();
        }
    }

    private void agf() {
        this.bXZ.setNextPage(this.aOf);
        this.aOf.startLoadData();
    }

    private void LB() {
        this.bXZ.setNextPage(this.aOf);
        this.aOf.ux();
        this.aOf.setText(this.bXM.getResources().getString(com.baidu.tieba.t.pb_load_more));
    }

    private void LC() {
        this.bXZ.setNextPage(this.aOf);
        this.aOf.ux();
        this.aOf.setText(this.bXM.getResources().getString(com.baidu.tieba.t.list_no_more));
    }

    private void LD() {
        this.bXZ.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bXM.getPageContext().getPageActivity(), this.mRootView, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(com.baidu.tieba.t.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.bXM.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

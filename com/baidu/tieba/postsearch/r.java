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
    private PbListView aXu;
    private PostSearchActivity coG;
    private BdListView coT;
    private v coU;
    private j coV;
    private String coW;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private View mRootView;
    private int mTabType;

    public r() {
        this.mTabType = -1;
        this.coW = "";
    }

    public r(int i) {
        this.mTabType = -1;
        this.coW = "";
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
        this.coG = (PostSearchActivity) getBaseFragmentActivity();
        this.coU = new v(this.coG.getPageContext());
        this.coT.setAdapter((ListAdapter) this.coU);
        this.aXu = new PbListView(this.coG.getPageContext().getPageActivity());
        this.aXu.nq();
        this.coT.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        eN(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.coG != null) {
            com.baidu.tbadk.f.a.a(this.coG.getPageContext(), this.mRootView);
        }
        if (this.aXu != null) {
            this.aXu.cG(i);
        }
        if (this.coU != null) {
            this.coU.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.cmT == null || jVar.cmT.size() == 0) {
            if (!z || this.coV == null || this.coV.cmT == null || this.coV.cmT.size() == 0) {
                Mq();
                showNoDataView();
                this.coT.setVisibility(8);
                this.coV = jVar;
                return;
            }
            if (this.coV.coL.rT() == 1) {
                Mo();
                return;
            } else {
                Mp();
                return;
            }
        }
        if (!z || this.coV == null || this.coV.cmT == null || this.coV.cmT.size() == 0) {
            this.coV = jVar;
        } else {
            this.coV.coL = jVar.coL;
            this.coV.cmT.addAll(jVar.cmT);
        }
        if (this.coV.coL.rT() == 1) {
            Mo();
        } else {
            Mp();
        }
        this.coU.clear();
        this.coU.ba(this.coV.cmT);
        this.coU.notifyDataSetChanged();
        if (!z) {
            this.coT.setSelection(0);
        }
        this.coT.setVisibility(0);
    }

    public void eN(boolean z) {
        String str = this.coG.bQt;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.coW) || z;
            if (this.coV == null || (this.coV != null && !this.coV.Wl() && this.coV.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.coG.getResources().getDimensionPixelSize(i.d.ds320));
                this.coG.ahV().T(str, this.mTabType);
                this.coW = str;
            }
        }
    }

    public void aid() {
        if (this.coV != null && this.coV.cmT != null) {
            this.coV.cmT.clear();
            this.coU.clear();
            this.coU.ba(this.coV.cmT);
            this.coU.notifyDataSetChanged();
        }
        Mq();
        hideNoDataView();
    }

    private void initView() {
        this.coT = (BdListView) this.mRootView.findViewById(i.f.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.coW) && this.coV != null && this.coV.isHasMore() && this.coG.ahV().T(this.coW, this.mTabType)) {
            aie();
        }
    }

    private void aie() {
        this.coT.setNextPage(this.aXu);
        this.aXu.startLoadData();
    }

    private void Mo() {
        this.coT.setNextPage(this.aXu);
        this.aXu.vB();
        this.aXu.setText(this.coG.getResources().getString(i.C0057i.pb_load_more));
    }

    private void Mp() {
        this.coT.setNextPage(this.aXu);
        this.aXu.vB();
        this.aXu.setText(this.coG.getResources().getString(i.C0057i.list_no_more));
    }

    private void Mq() {
        this.coT.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.coG.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cD(i.C0057i.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.coG.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

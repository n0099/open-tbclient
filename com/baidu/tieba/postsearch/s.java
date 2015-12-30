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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class s extends BaseFragment implements BdListView.e {
    private PbListView aVj;
    private PostSearchActivity djG;
    private BdListView djU;
    private w djV;
    private k djW;
    private String djX;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mRootView;
    private int mTabType;

    public s() {
        this.mTabType = -1;
        this.djX = "";
    }

    public s(int i) {
        this.mTabType = -1;
        this.djX = "";
        this.mTabType = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(n.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.djG = (PostSearchActivity) getBaseFragmentActivity();
        this.djV = new w(this.djG.getPageContext());
        this.djU.setAdapter((ListAdapter) this.djV);
        this.aVj = new PbListView(this.djG.getPageContext().getPageActivity());
        this.aVj.mT();
        this.djU.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        gL(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.djG != null) {
            com.baidu.tbadk.i.a.a(this.djG.getPageContext(), this.mRootView);
        }
        if (this.aVj != null) {
            this.aVj.cP(i);
        }
        if (this.djV != null) {
            this.djV.notifyDataSetChanged();
        }
    }

    public void a(k kVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (kVar == null || kVar.cQY == null || kVar.cQY.size() == 0) {
            if (!z || this.djW == null || this.djW.cQY == null || this.djW.cQY.size() == 0) {
                Om();
                showNoDataView();
                this.djU.setVisibility(8);
                this.djW = kVar;
                return;
            }
            if (this.djW.djM.rO() == 1) {
                Ok();
                return;
            } else {
                Ol();
                return;
            }
        }
        if (!z || this.djW == null || this.djW.cQY == null || this.djW.cQY.size() == 0) {
            this.djW = kVar;
        } else {
            this.djW.djM = kVar.djM;
            this.djW.cQY.addAll(kVar.cQY);
        }
        if (this.djW.djM.rO() == 1) {
            Ok();
        } else {
            Ol();
        }
        this.djV.clear();
        this.djV.bx(this.djW.cQY);
        this.djV.notifyDataSetChanged();
        if (!z) {
            this.djU.setSelection(0);
        }
        this.djU.setVisibility(0);
    }

    public void gL(boolean z) {
        String str = this.djG.cpN;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.djX) || z;
            if (this.djW == null || (this.djW != null && !this.djW.abB() && this.djW.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.djG.getResources().getDimensionPixelSize(n.e.ds320));
                this.djG.awr().ae(str, this.mTabType);
                this.djX = str;
            }
        }
    }

    public void awy() {
        if (this.djW != null && this.djW.cQY != null) {
            this.djW.cQY.clear();
            this.djV.clear();
            this.djV.bx(this.djW.cQY);
            this.djV.notifyDataSetChanged();
        }
        Om();
        hideNoDataView();
    }

    private void initView() {
        this.djU = (BdListView) this.mRootView.findViewById(n.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.djX) && this.djW != null && this.djW.isHasMore() && this.djG.awr().ae(this.djX, this.mTabType)) {
            awz();
        }
    }

    private void awz() {
        this.djU.setNextPage(this.aVj);
        this.aVj.startLoadData();
    }

    private void Ok() {
        this.djU.setNextPage(this.aVj);
        this.aVj.vP();
        this.aVj.setText(this.djG.getResources().getString(n.j.pb_load_more));
    }

    private void Ol() {
        this.djU.setNextPage(this.aVj);
        this.aVj.vP();
        this.aVj.setText(this.djG.getResources().getString(n.j.list_no_more));
    }

    private void Om() {
        this.djU.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.djG.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.djG.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends BaseFragment implements BdListView.e {
    private PbListView aXw;
    private PostSearchActivity dxA;
    private BdListView dxO;
    private w dxP;
    private k dxQ;
    private int dxR;
    private String dxS;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View mRootView;

    public s() {
        this.dxR = -1;
        this.dxS = "";
    }

    public s(int i) {
        this.dxR = -1;
        this.dxS = "";
        this.dxR = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(t.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dxA = (PostSearchActivity) getBaseFragmentActivity();
        this.dxP = new w(this.dxA.getPageContext());
        this.dxO.setAdapter((ListAdapter) this.dxP);
        this.aXw = new PbListView(this.dxA.getPageContext().getPageActivity());
        this.aXw.ni();
        this.dxO.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dxR == this.dxA.aCN().getCurrentTabType()) {
            hh(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dxA != null) {
            com.baidu.tbadk.i.a.a(this.dxA.getPageContext(), this.mRootView);
        }
        if (this.aXw != null) {
            this.aXw.dg(i);
        }
        if (this.dxP != null) {
            this.dxP.notifyDataSetChanged();
        }
    }

    public void a(k kVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (kVar == null || kVar.daF == null || kVar.daF.size() == 0) {
            if (!z || this.dxQ == null || this.dxQ.daF == null || this.dxQ.daF.size() == 0) {
                Qp();
                showNoDataView();
                this.dxO.setVisibility(8);
                this.dxQ = kVar;
                return;
            }
            if (this.dxQ.dxG.sv() == 1) {
                Qn();
                return;
            } else {
                Qo();
                return;
            }
        }
        if (!z || this.dxQ == null || this.dxQ.daF == null || this.dxQ.daF.size() == 0) {
            this.dxQ = kVar;
        } else {
            this.dxQ.dxG = kVar.dxG;
            this.dxQ.daF.addAll(kVar.daF);
        }
        if (this.dxQ.dxG.sv() == 1) {
            Qn();
        } else {
            Qo();
        }
        this.dxP.clear();
        this.dxP.bH(this.dxQ.daF);
        this.dxP.notifyDataSetChanged();
        if (!z) {
            this.dxO.setSelection(0);
        }
        this.dxO.setVisibility(0);
    }

    public void hh(boolean z) {
        String str = this.dxA.cws;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.dxS) || z;
            if (this.dxQ == null || (this.dxQ != null && !this.dxQ.aeH())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.dxA.getResources().getDimensionPixelSize(t.e.ds320));
                this.dxA.aCM().ag(str, this.dxR);
                this.dxS = str;
            }
        }
    }

    public void aCU() {
        if (this.dxQ != null && this.dxQ.daF != null) {
            this.dxQ.daF.clear();
            this.dxP.clear();
            this.dxP.bH(this.dxQ.daF);
            this.dxP.notifyDataSetChanged();
        }
        Qp();
        hideNoDataView();
    }

    private void initView() {
        this.dxO = (BdListView) this.mRootView.findViewById(t.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (!StringUtils.isNull(this.dxS) && this.dxQ != null && this.dxQ.isHasMore() && this.dxA.aCM().ag(this.dxS, this.dxR)) {
            aCV();
        }
    }

    private void aCV() {
        this.dxO.setNextPage(this.aXw);
        this.aXw.xb();
    }

    private void Qn() {
        this.dxO.setNextPage(this.aXw);
        this.aXw.xc();
        this.aXw.setText(this.dxA.getResources().getString(t.j.pb_load_more));
    }

    private void Qo() {
        this.dxO.setNextPage(this.aXw);
        this.aXw.xc();
        this.aXw.setText(this.dxA.getResources().getString(t.j.list_no_more));
    }

    private void Qp() {
        if (this.dxO != null) {
            this.dxO.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dxA.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.dxA.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

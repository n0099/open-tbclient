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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends BaseFragment implements BdListView.e {
    private PbListView bkd;
    private PostSearchActivity dUY;
    private BdListView dVm;
    private w dVn;
    private k dVo;
    private int dVp;
    private String dVq;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private View mRootView;

    public s() {
        this.dVp = -1;
        this.dVq = "";
    }

    public s(int i) {
        this.dVp = -1;
        this.dVq = "";
        this.dVp = i;
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
        this.dUY = (PostSearchActivity) getBaseFragmentActivity();
        this.dVn = new w(this.dUY.getPageContext());
        BdListViewHelper.a(this.dUY.getActivity(), this.dVm, BdListViewHelper.HeadType.HASTAB);
        this.dVm.setAdapter((ListAdapter) this.dVn);
        this.bkd = new PbListView(this.dUY.getPageContext().getPageActivity());
        this.bkd.jn();
        this.dVm.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dVp == this.dUY.aKI().getCurrentTabType()) {
            iE(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dUY != null) {
            com.baidu.tbadk.i.a.a(this.dUY.getPageContext(), this.mRootView);
        }
        if (this.bkd != null) {
            this.bkd.cR(i);
        }
        if (this.dVn != null) {
            this.dVn.notifyDataSetChanged();
        }
    }

    public void a(k kVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (kVar == null || kVar.dyd == null || kVar.dyd.size() == 0) {
            if (!z || this.dVo == null || this.dVo.dyd == null || this.dVo.dyd.size() == 0) {
                Ri();
                showNoDataView();
                this.dVm.setVisibility(8);
                this.dVo = kVar;
                return;
            }
            if (this.dVo.dVe.pK() == 1) {
                Rg();
                return;
            } else {
                Rh();
                return;
            }
        }
        if (!z || this.dVo == null || this.dVo.dyd == null || this.dVo.dyd.size() == 0) {
            this.dVo = kVar;
        } else {
            this.dVo.dVe = kVar.dVe;
            this.dVo.dyd.addAll(kVar.dyd);
        }
        if (this.dVo.dVe.pK() == 1) {
            Rg();
        } else {
            Rh();
        }
        this.dVn.clear();
        this.dVn.cf(this.dVo.dyd);
        this.dVn.notifyDataSetChanged();
        if (!z) {
            this.dVm.setSelection(0);
        }
        this.dVm.setVisibility(0);
    }

    public void iE(boolean z) {
        if (this.dUY != null) {
            String str = this.dUY.cMj;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.dVq) || z;
                if (this.dVo == null || (this.dVo != null && !this.dVo.aij())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.dUY.getResources().getDimensionPixelSize(t.e.ds320));
                    this.dUY.aKH().au(str, this.dVp);
                    this.dVq = str;
                }
            }
        }
    }

    public void aKP() {
        if (this.dVo != null && this.dVo.dyd != null) {
            this.dVo.dyd.clear();
            this.dVn.clear();
            this.dVn.cf(this.dVo.dyd);
            this.dVn.notifyDataSetChanged();
        }
        Ri();
        hideNoDataView();
    }

    private void initView() {
        this.dVm = (BdListView) this.mRootView.findViewById(t.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        if (!StringUtils.isNull(this.dVq) && this.dVo != null && this.dVo.isHasMore() && this.dUY.aKH().au(this.dVq, this.dVp)) {
            aKQ();
        }
    }

    private void aKQ() {
        this.dVm.setNextPage(this.bkd);
        this.bkd.vh();
    }

    private void Rg() {
        this.dVm.setNextPage(this.bkd);
        this.bkd.vi();
        this.bkd.setText(this.dUY.getResources().getString(t.j.pb_load_more));
    }

    private void Rh() {
        this.dVm.setNextPage(this.bkd);
        this.bkd.vi();
        this.bkd.setText(this.dUY.getResources().getString(t.j.list_no_more));
    }

    private void Ri() {
        if (this.dVm != null) {
            this.dVm.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dUY.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.c(this.dUY.getActivity(), t.e.ds320)), NoDataViewFactory.d.cO(t.j.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.dUY.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

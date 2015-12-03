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
public class r extends BaseFragment implements BdListView.e {
    private PbListView aRt;
    private PostSearchActivity deb;
    private BdListView deo;
    private v dep;
    private j deq;
    private String der;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private View mRootView;
    private int mTabType;

    public r() {
        this.mTabType = -1;
        this.der = "";
    }

    public r(int i) {
        this.mTabType = -1;
        this.der = "";
        this.mTabType = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(n.g.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.deb = (PostSearchActivity) getBaseFragmentActivity();
        this.dep = new v(this.deb.getPageContext());
        this.deo.setAdapter((ListAdapter) this.dep);
        this.aRt = new PbListView(this.deb.getPageContext().getPageActivity());
        this.aRt.nv();
        this.deo.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        gF(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.deb != null) {
            com.baidu.tbadk.i.a.a(this.deb.getPageContext(), this.mRootView);
        }
        if (this.aRt != null) {
            this.aRt.cV(i);
        }
        if (this.dep != null) {
            this.dep.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.cME == null || jVar.cME.size() == 0) {
            if (!z || this.deq == null || this.deq.cME == null || this.deq.cME.size() == 0) {
                NT();
                showNoDataView();
                this.deo.setVisibility(8);
                this.deq = jVar;
                return;
            }
            if (this.deq.deg.sf() == 1) {
                NR();
                return;
            } else {
                NS();
                return;
            }
        }
        if (!z || this.deq == null || this.deq.cME == null || this.deq.cME.size() == 0) {
            this.deq = jVar;
        } else {
            this.deq.deg = jVar.deg;
            this.deq.cME.addAll(jVar.cME);
        }
        if (this.deq.deg.sf() == 1) {
            NR();
        } else {
            NS();
        }
        this.dep.clear();
        this.dep.bz(this.deq.cME);
        this.dep.notifyDataSetChanged();
        if (!z) {
            this.deo.setSelection(0);
        }
        this.deo.setVisibility(0);
    }

    public void gF(boolean z) {
        String str = this.deb.clJ;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.der) || z;
            if (this.deq == null || (this.deq != null && !this.deq.aat() && this.deq.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.deb.getResources().getDimensionPixelSize(n.d.ds320));
                this.deb.auy().ad(str, this.mTabType);
                this.der = str;
            }
        }
    }

    public void auF() {
        if (this.deq != null && this.deq.cME != null) {
            this.deq.cME.clear();
            this.dep.clear();
            this.dep.bz(this.deq.cME);
            this.dep.notifyDataSetChanged();
        }
        NT();
        hideNoDataView();
    }

    private void initView() {
        this.deo = (BdListView) this.mRootView.findViewById(n.f.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.der) && this.deq != null && this.deq.isHasMore() && this.deb.auy().ad(this.der, this.mTabType)) {
            auG();
        }
    }

    private void auG() {
        this.deo.setNextPage(this.aRt);
        this.aRt.startLoadData();
    }

    private void NR() {
        this.deo.setNextPage(this.aRt);
        this.aRt.wf();
        this.aRt.setText(this.deb.getResources().getString(n.i.pb_load_more));
    }

    private void NS() {
        this.deo.setNextPage(this.aRt);
        this.aRt.wf();
        this.aRt.setText(this.deb.getResources().getString(n.i.list_no_more));
    }

    private void NT() {
        this.deo.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.deb.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.deb.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

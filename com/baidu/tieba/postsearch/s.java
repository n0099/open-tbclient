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
    private PbListView bcf;
    private PostSearchActivity dSg;
    private BdListView dSu;
    private w dSv;
    private k dSw;
    private int dSx;
    private String dSy;
    private com.baidu.tbadk.core.view.p mNoDataView;
    private View mRootView;

    public s() {
        this.dSx = -1;
        this.dSy = "";
    }

    public s(int i) {
        this.dSx = -1;
        this.dSy = "";
        this.dSx = i;
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
        this.dSg = (PostSearchActivity) getBaseFragmentActivity();
        this.dSv = new w(this.dSg.getPageContext());
        this.dSu.setAdapter((ListAdapter) this.dSv);
        this.bcf = new PbListView(this.dSg.getPageContext().getPageActivity());
        this.bcf.mZ();
        this.dSu.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dSx == this.dSg.aKB().getCurrentTabType()) {
            hU(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dSg != null) {
            com.baidu.tbadk.i.a.a(this.dSg.getPageContext(), this.mRootView);
        }
        if (this.bcf != null) {
            this.bcf.dj(i);
        }
        if (this.dSv != null) {
            this.dSv.notifyDataSetChanged();
        }
    }

    public void a(k kVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (kVar == null || kVar.dvh == null || kVar.dvh.size() == 0) {
            if (!z || this.dSw == null || this.dSw.dvh == null || this.dSw.dvh.size() == 0) {
                Si();
                showNoDataView();
                this.dSu.setVisibility(8);
                this.dSw = kVar;
                return;
            }
            if (this.dSw.dSm.sq() == 1) {
                Sg();
                return;
            } else {
                Sh();
                return;
            }
        }
        if (!z || this.dSw == null || this.dSw.dvh == null || this.dSw.dvh.size() == 0) {
            this.dSw = kVar;
        } else {
            this.dSw.dSm = kVar.dSm;
            this.dSw.dvh.addAll(kVar.dvh);
        }
        if (this.dSw.dSm.sq() == 1) {
            Sg();
        } else {
            Sh();
        }
        this.dSv.clear();
        this.dSv.cd(this.dSw.dvh);
        this.dSv.notifyDataSetChanged();
        if (!z) {
            this.dSu.setSelection(0);
        }
        this.dSu.setVisibility(0);
    }

    public void hU(boolean z) {
        String str = this.dSg.cLn;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.dSy) || z;
            if (this.dSw == null || (this.dSw != null && !this.dSw.aia())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.dSg.getResources().getDimensionPixelSize(t.e.ds320));
                this.dSg.aKA().ap(str, this.dSx);
                this.dSy = str;
            }
        }
    }

    public void aKI() {
        if (this.dSw != null && this.dSw.dvh != null) {
            this.dSw.dvh.clear();
            this.dSv.clear();
            this.dSv.cd(this.dSw.dvh);
            this.dSv.notifyDataSetChanged();
        }
        Si();
        hideNoDataView();
    }

    private void initView() {
        this.dSu = (BdListView) this.mRootView.findViewById(t.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        if (!StringUtils.isNull(this.dSy) && this.dSw != null && this.dSw.isHasMore() && this.dSg.aKA().ap(this.dSy, this.dSx)) {
            aKJ();
        }
    }

    private void aKJ() {
        this.dSu.setNextPage(this.bcf);
        this.bcf.xu();
    }

    private void Sg() {
        this.dSu.setNextPage(this.bcf);
        this.bcf.xv();
        this.bcf.setText(this.dSg.getResources().getString(t.j.pb_load_more));
    }

    private void Sh() {
        this.dSu.setNextPage(this.bcf);
        this.bcf.xv();
        this.bcf.setText(this.dSg.getResources().getString(t.j.list_no_more));
    }

    private void Si() {
        if (this.dSu != null) {
            this.dSu.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dSg.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.dSg.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

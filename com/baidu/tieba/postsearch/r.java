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
    private PbListView aXe;
    private BdListView cFF;
    private v cFG;
    private j cFH;
    private String cFI;
    private PostSearchActivity cFs;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private View mRootView;
    private int mTabType;

    public r() {
        this.mTabType = -1;
        this.cFI = "";
    }

    public r(int i) {
        this.mTabType = -1;
        this.cFI = "";
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
        this.cFs = (PostSearchActivity) getBaseFragmentActivity();
        this.cFG = new v(this.cFs.getPageContext());
        this.cFF.setAdapter((ListAdapter) this.cFG);
        this.aXe = new PbListView(this.cFs.getPageContext().getPageActivity());
        this.aXe.np();
        this.cFF.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        fN(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cFs != null) {
            com.baidu.tbadk.h.a.a(this.cFs.getPageContext(), this.mRootView);
        }
        if (this.aXe != null) {
            this.aXe.cN(i);
        }
        if (this.cFG != null) {
            this.cFG.notifyDataSetChanged();
        }
    }

    public void a(j jVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (jVar == null || jVar.cvj == null || jVar.cvj.size() == 0) {
            if (!z || this.cFH == null || this.cFH.cvj == null || this.cFH.cvj.size() == 0) {
                Ms();
                showNoDataView();
                this.cFF.setVisibility(8);
                this.cFH = jVar;
                return;
            }
            if (this.cFH.cFx.rK() == 1) {
                Mq();
                return;
            } else {
                Mr();
                return;
            }
        }
        if (!z || this.cFH == null || this.cFH.cvj == null || this.cFH.cvj.size() == 0) {
            this.cFH = jVar;
        } else {
            this.cFH.cFx = jVar.cFx;
            this.cFH.cvj.addAll(jVar.cvj);
        }
        if (this.cFH.cFx.rK() == 1) {
            Mq();
        } else {
            Mr();
        }
        this.cFG.clear();
        this.cFG.bn(this.cFH.cvj);
        this.cFG.notifyDataSetChanged();
        if (!z) {
            this.cFF.setSelection(0);
        }
        this.cFF.setVisibility(0);
    }

    public void fN(boolean z) {
        String str = this.cFs.bVw;
        if (!StringUtils.isNull(str)) {
            boolean z2 = !str.equals(this.cFI) || z;
            if (this.cFH == null || (this.cFH != null && !this.cFH.Xn() && this.cFH.isHasMore())) {
                z2 = true;
            }
            if (z2) {
                showLoadingView(this.mRootView, false, this.cFs.getResources().getDimensionPixelSize(i.d.ds320));
                this.cFs.aoM().X(str, this.mTabType);
                this.cFI = str;
            }
        }
    }

    public void aoT() {
        if (this.cFH != null && this.cFH.cvj != null) {
            this.cFH.cvj.clear();
            this.cFG.clear();
            this.cFG.bn(this.cFH.cvj);
            this.cFG.notifyDataSetChanged();
        }
        Ms();
        hideNoDataView();
    }

    private void initView() {
        this.cFF = (BdListView) this.mRootView.findViewById(i.f.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.cFI) && this.cFH != null && this.cFH.isHasMore() && this.cFs.aoM().X(this.cFI, this.mTabType)) {
            aoU();
        }
    }

    private void aoU() {
        this.cFF.setNextPage(this.aXe);
        this.aXe.startLoadData();
    }

    private void Mq() {
        this.cFF.setNextPage(this.aXe);
        this.aXe.vz();
        this.aXe.setText(this.cFs.getResources().getString(i.h.pb_load_more));
    }

    private void Mr() {
        this.cFF.setNextPage(this.aXe);
        this.aXe.vz();
        this.aXe.setText(this.cFs.getResources().getString(i.h.list_no_more));
    }

    private void Ms() {
        this.cFF.setNextPage(null);
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cFs.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.no_search_result_record), null);
            this.mNoDataView.onChangeSkinType(this.cFs.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }
}

package com.baidu.tieba.postsearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView fHm;
    private int gUI;
    private BdListView lGD;
    private e lGE;
    private b lGF;
    private String lGG;
    private PostSearchActivity lGp;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.gUI = -1;
        this.lGG = "";
    }

    public PostSearchListFragment(int i) {
        this.gUI = -1;
        this.lGG = "";
        this.gUI = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.lGp = (PostSearchActivity) getBaseFragmentActivity();
        this.lGE = new e(this.lGp.getPageContext());
        this.lGE.setTabType(this.gUI);
        BdListViewHelper.a(this.lGp.getActivity(), this.lGD, BdListViewHelper.HeadType.HASTAB);
        this.lGD.setAdapter((ListAdapter) this.lGE);
        this.fHm = new PbListView(this.lGp.getPageContext().getPageActivity());
        this.fHm.createView();
        this.lGD.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.gUI == this.lGp.dph().getCurrentTabType()) {
            dpq();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lGp != null) {
            com.baidu.tbadk.r.a.a(this.lGp.getPageContext(), this.mRootView);
        }
        if (this.fHm != null) {
            this.fHm.changeSkin(i);
        }
        if (this.lGE != null) {
            this.lGE.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.lGv == null || bVar.lGv.size() == 0) {
            if (!z || this.lGF == null || this.lGF.lGv == null || this.lGF.lGv.size() == 0) {
                bIk();
                showNoDataView();
                this.lGD.setVisibility(8);
                this.lGF = bVar;
                return;
            }
            if (this.lGF.hUP.beo() == 1) {
                bIi();
                return;
            } else {
                bIj();
                return;
            }
        }
        if (!z || this.lGF == null || this.lGF.lGv == null || this.lGF.lGv.size() == 0) {
            this.lGF = bVar;
        } else {
            this.lGF.hUP = bVar.hUP;
            this.lGF.lGv.addAll(bVar.lGv);
        }
        if (z) {
            dpq();
        }
        if (this.lGF.hUP.beo() == 1) {
            bIi();
        } else {
            bIj();
        }
        this.lGE.setData(this.lGF.lGv);
        this.lGE.notifyDataSetChanged();
        if (!z) {
            this.lGD.setSelection(0);
        }
        this.lGD.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.lGp != null) {
            String str = this.lGp.hXJ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.lGG) || z;
                if (this.lGF == null || (this.lGF != null && !this.lGF.cLC())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.lGp.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.lGp.dpg().bz(str, this.gUI);
                    this.lGG = str;
                }
            }
        }
    }

    public void dpo() {
        if (this.lGF != null && this.lGF.lGv != null) {
            this.lGF.lGv.clear();
            this.lGE.setData(this.lGF.lGv);
            this.lGE.notifyDataSetChanged();
        }
        bIk();
        hideNoDataView();
    }

    private void initView() {
        this.lGD = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.lGG) && this.lGF != null && this.lGF.isHasMore() && this.lGp.dpg().bz(this.lGG, this.gUI)) {
            dpp();
        }
    }

    private void dpp() {
        this.lGD.setNextPage(this.fHm);
        this.fHm.startLoadData();
    }

    private void bIi() {
        this.lGD.setNextPage(this.fHm);
        this.fHm.endLoadData();
        this.fHm.setText(this.lGp.getResources().getString(R.string.pb_load_more));
    }

    private void bIj() {
        this.lGD.setNextPage(this.fHm);
        this.fHm.endLoadData();
        this.fHm.setText(this.lGp.getResources().getString(R.string.list_no_more));
    }

    private void bIk() {
        if (this.lGD != null) {
            this.lGD.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lGp.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lGp.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oW(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.lGp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dpq() {
        if (this.lGp != null) {
            TiebaStatic.log(new aq("c12406").dF("fid", this.lGp.mForumId).dF("fname", this.lGp.mForumName).dF("uid", TbadkCoreApplication.getCurrentAccount()).ai("tab_id", this.gUI));
        }
    }
}

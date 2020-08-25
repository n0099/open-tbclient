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
/* loaded from: classes18.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView fDW;
    private int gQW;
    private BdListView lxB;
    private e lxC;
    private b lxD;
    private String lxE;
    private PostSearchActivity lxn;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.gQW = -1;
        this.lxE = "";
    }

    public PostSearchListFragment(int i) {
        this.gQW = -1;
        this.lxE = "";
        this.gQW = i;
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
        this.lxn = (PostSearchActivity) getBaseFragmentActivity();
        this.lxC = new e(this.lxn.getPageContext());
        this.lxC.setTabType(this.gQW);
        BdListViewHelper.a(this.lxn.getActivity(), this.lxB, BdListViewHelper.HeadType.HASTAB);
        this.lxB.setAdapter((ListAdapter) this.lxC);
        this.fDW = new PbListView(this.lxn.getPageContext().getPageActivity());
        this.fDW.createView();
        this.lxB.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.gQW == this.lxn.dlx().getCurrentTabType()) {
            dlG();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxn != null) {
            com.baidu.tbadk.r.a.a(this.lxn.getPageContext(), this.mRootView);
        }
        if (this.fDW != null) {
            this.fDW.changeSkin(i);
        }
        if (this.lxC != null) {
            this.lxC.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.lxt == null || bVar.lxt.size() == 0) {
            if (!z || this.lxD == null || this.lxD.lxt == null || this.lxD.lxt.size() == 0) {
                bGT();
                showNoDataView();
                this.lxB.setVisibility(8);
                this.lxD = bVar;
                return;
            }
            if (this.lxD.hNJ.bdu() == 1) {
                bGR();
                return;
            } else {
                bGS();
                return;
            }
        }
        if (!z || this.lxD == null || this.lxD.lxt == null || this.lxD.lxt.size() == 0) {
            this.lxD = bVar;
        } else {
            this.lxD.hNJ = bVar.hNJ;
            this.lxD.lxt.addAll(bVar.lxt);
        }
        if (z) {
            dlG();
        }
        if (this.lxD.hNJ.bdu() == 1) {
            bGR();
        } else {
            bGS();
        }
        this.lxC.setData(this.lxD.lxt);
        this.lxC.notifyDataSetChanged();
        if (!z) {
            this.lxB.setSelection(0);
        }
        this.lxB.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.lxn != null) {
            String str = this.lxn.hQD;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.lxE) || z;
                if (this.lxD == null || (this.lxD != null && !this.lxD.cHV())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.lxn.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.lxn.dlw().bz(str, this.gQW);
                    this.lxE = str;
                }
            }
        }
    }

    public void dlE() {
        if (this.lxD != null && this.lxD.lxt != null) {
            this.lxD.lxt.clear();
            this.lxC.setData(this.lxD.lxt);
            this.lxC.notifyDataSetChanged();
        }
        bGT();
        hideNoDataView();
    }

    private void initView() {
        this.lxB = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.lxE) && this.lxD != null && this.lxD.isHasMore() && this.lxn.dlw().bz(this.lxE, this.gQW)) {
            dlF();
        }
    }

    private void dlF() {
        this.lxB.setNextPage(this.fDW);
        this.fDW.startLoadData();
    }

    private void bGR() {
        this.lxB.setNextPage(this.fDW);
        this.fDW.endLoadData();
        this.fDW.setText(this.lxn.getResources().getString(R.string.pb_load_more));
    }

    private void bGS() {
        this.lxB.setNextPage(this.fDW);
        this.fDW.endLoadData();
        this.fDW.setText(this.lxn.getResources().getString(R.string.list_no_more));
    }

    private void bGT() {
        if (this.lxB != null) {
            this.lxB.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lxn.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lxn.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.lxn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dlG() {
        if (this.lxn != null) {
            TiebaStatic.log(new aq("c12406").dD("fid", this.lxn.mForumId).dD("fname", this.lxn.mForumName).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("tab_id", this.gQW));
        }
    }
}

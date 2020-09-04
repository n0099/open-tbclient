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
    private PbListView fEa;
    private int gRa;
    private BdListView lxM;
    private e lxN;
    private b lxO;
    private String lxP;
    private PostSearchActivity lxy;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.gRa = -1;
        this.lxP = "";
    }

    public PostSearchListFragment(int i) {
        this.gRa = -1;
        this.lxP = "";
        this.gRa = i;
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
        this.lxy = (PostSearchActivity) getBaseFragmentActivity();
        this.lxN = new e(this.lxy.getPageContext());
        this.lxN.setTabType(this.gRa);
        BdListViewHelper.a(this.lxy.getActivity(), this.lxM, BdListViewHelper.HeadType.HASTAB);
        this.lxM.setAdapter((ListAdapter) this.lxN);
        this.fEa = new PbListView(this.lxy.getPageContext().getPageActivity());
        this.fEa.createView();
        this.lxM.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.gRa == this.lxy.dlA().getCurrentTabType()) {
            dlJ();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxy != null) {
            com.baidu.tbadk.r.a.a(this.lxy.getPageContext(), this.mRootView);
        }
        if (this.fEa != null) {
            this.fEa.changeSkin(i);
        }
        if (this.lxN != null) {
            this.lxN.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.lxE == null || bVar.lxE.size() == 0) {
            if (!z || this.lxO == null || this.lxO.lxE == null || this.lxO.lxE.size() == 0) {
                bGU();
                showNoDataView();
                this.lxM.setVisibility(8);
                this.lxO = bVar;
                return;
            }
            if (this.lxO.hNP.bdu() == 1) {
                bGS();
                return;
            } else {
                bGT();
                return;
            }
        }
        if (!z || this.lxO == null || this.lxO.lxE == null || this.lxO.lxE.size() == 0) {
            this.lxO = bVar;
        } else {
            this.lxO.hNP = bVar.hNP;
            this.lxO.lxE.addAll(bVar.lxE);
        }
        if (z) {
            dlJ();
        }
        if (this.lxO.hNP.bdu() == 1) {
            bGS();
        } else {
            bGT();
        }
        this.lxN.setData(this.lxO.lxE);
        this.lxN.notifyDataSetChanged();
        if (!z) {
            this.lxM.setSelection(0);
        }
        this.lxM.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.lxy != null) {
            String str = this.lxy.hQJ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.lxP) || z;
                if (this.lxO == null || (this.lxO != null && !this.lxO.cHW())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.lxy.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.lxy.dlz().bz(str, this.gRa);
                    this.lxP = str;
                }
            }
        }
    }

    public void dlH() {
        if (this.lxO != null && this.lxO.lxE != null) {
            this.lxO.lxE.clear();
            this.lxN.setData(this.lxO.lxE);
            this.lxN.notifyDataSetChanged();
        }
        bGU();
        hideNoDataView();
    }

    private void initView() {
        this.lxM = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.lxP) && this.lxO != null && this.lxO.isHasMore() && this.lxy.dlz().bz(this.lxP, this.gRa)) {
            dlI();
        }
    }

    private void dlI() {
        this.lxM.setNextPage(this.fEa);
        this.fEa.startLoadData();
    }

    private void bGS() {
        this.lxM.setNextPage(this.fEa);
        this.fEa.endLoadData();
        this.fEa.setText(this.lxy.getResources().getString(R.string.pb_load_more));
    }

    private void bGT() {
        this.lxM.setNextPage(this.fEa);
        this.fEa.endLoadData();
        this.fEa.setText(this.lxy.getResources().getString(R.string.list_no_more));
    }

    private void bGU() {
        if (this.lxM != null) {
            this.lxM.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lxy.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lxy.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.lxy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dlJ() {
        if (this.lxy != null) {
            TiebaStatic.log(new aq("c12406").dD("fid", this.lxy.mForumId).dD("fname", this.lxy.mForumName).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("tab_id", this.gRa));
        }
    }
}

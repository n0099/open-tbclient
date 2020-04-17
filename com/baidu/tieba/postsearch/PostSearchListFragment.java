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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView ePm;
    private int fWX;
    private BdListView kmN;
    private e kmO;
    private b kmP;
    private String kmQ;
    private PostSearchActivity kmy;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.fWX = -1;
        this.kmQ = "";
    }

    public PostSearchListFragment(int i) {
        this.fWX = -1;
        this.kmQ = "";
        this.fWX = i;
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
        this.kmy = (PostSearchActivity) getBaseFragmentActivity();
        this.kmO = new e(this.kmy.getPageContext());
        this.kmO.setTabType(this.fWX);
        BdListViewHelper.a(this.kmy.getActivity(), this.kmN, BdListViewHelper.HeadType.HASTAB);
        this.kmN.setAdapter((ListAdapter) this.kmO);
        this.ePm = new PbListView(this.kmy.getPageContext().getPageActivity());
        this.ePm.createView();
        this.kmN.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fWX == this.kmy.cLH().getCurrentTabType()) {
            cLQ();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kmy != null) {
            com.baidu.tbadk.q.a.a(this.kmy.getPageContext(), this.mRootView);
        }
        if (this.ePm != null) {
            this.ePm.changeSkin(i);
        }
        if (this.kmO != null) {
            this.kmO.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.kmE == null || bVar.kmE.size() == 0) {
            if (!z || this.kmP == null || this.kmP.kmE == null || this.kmP.kmE.size() == 0) {
                bmq();
                showNoDataView();
                this.kmN.setVisibility(8);
                this.kmP = bVar;
                return;
            }
            if (this.kmP.gTx.aJA() == 1) {
                bmo();
                return;
            } else {
                bmp();
                return;
            }
        }
        if (!z || this.kmP == null || this.kmP.kmE == null || this.kmP.kmE.size() == 0) {
            this.kmP = bVar;
        } else {
            this.kmP.gTx = bVar.gTx;
            this.kmP.kmE.addAll(bVar.kmE);
        }
        if (z) {
            cLQ();
        }
        if (this.kmP.gTx.aJA() == 1) {
            bmo();
        } else {
            bmp();
        }
        this.kmO.setData(this.kmP.kmE);
        this.kmO.notifyDataSetChanged();
        if (!z) {
            this.kmN.setSelection(0);
        }
        this.kmN.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.kmy != null) {
            String str = this.kmy.gWq;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.kmQ) || z;
                if (this.kmP == null || (this.kmP != null && !this.kmP.ciH())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.kmy.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.kmy.cLG().bw(str, this.fWX);
                    this.kmQ = str;
                }
            }
        }
    }

    public void cLO() {
        if (this.kmP != null && this.kmP.kmE != null) {
            this.kmP.kmE.clear();
            this.kmO.setData(this.kmP.kmE);
            this.kmO.notifyDataSetChanged();
        }
        bmq();
        hideNoDataView();
    }

    private void initView() {
        this.kmN = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.kmQ) && this.kmP != null && this.kmP.isHasMore() && this.kmy.cLG().bw(this.kmQ, this.fWX)) {
            cLP();
        }
    }

    private void cLP() {
        this.kmN.setNextPage(this.ePm);
        this.ePm.startLoadData();
    }

    private void bmo() {
        this.kmN.setNextPage(this.ePm);
        this.ePm.endLoadData();
        this.ePm.setText(this.kmy.getResources().getString(R.string.pb_load_more));
    }

    private void bmp() {
        this.kmN.setNextPage(this.ePm);
        this.ePm.endLoadData();
        this.ePm.setText(this.kmy.getResources().getString(R.string.list_no_more));
    }

    private void bmq() {
        if (this.kmN != null) {
            this.kmN.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kmy.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kmy.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.kmy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cLQ() {
        if (this.kmy != null) {
            TiebaStatic.log(new an("c12406").cI("fid", this.kmy.mForumId).cI("fname", this.kmy.mForumName).cI("uid", TbadkCoreApplication.getCurrentAccount()).af("tab_id", this.fWX));
        }
    }
}

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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView gre;
    private int hKL;
    private BdListView mCN;
    private e mCO;
    private b mCP;
    private String mCQ;
    private PostSearchActivity mCz;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hKL = -1;
        this.mCQ = "";
    }

    public PostSearchListFragment(int i) {
        this.hKL = -1;
        this.mCQ = "";
        this.hKL = i;
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
        this.mCz = (PostSearchActivity) getBaseFragmentActivity();
        this.mCO = new e(this.mCz.getPageContext());
        this.mCO.setTabType(this.hKL);
        BdListViewHelper.a(this.mCz.getActivity(), this.mCN, BdListViewHelper.HeadType.HASTAB);
        this.mCN.setAdapter((ListAdapter) this.mCO);
        this.gre = new PbListView(this.mCz.getPageContext().getPageActivity());
        this.gre.createView();
        this.mCN.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hKL == this.mCz.dDs().getCurrentTabType()) {
            dDB();
            bA(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mCz != null) {
            com.baidu.tbadk.r.a.a(this.mCz.getPageContext(), this.mRootView);
        }
        if (this.gre != null) {
            this.gre.changeSkin(i);
        }
        if (this.mCO != null) {
            this.mCO.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mCF == null || bVar.mCF.size() == 0) {
            if (!z || this.mCP == null || this.mCP.mCF == null || this.mCP.mCF.size() == 0) {
                bTa();
                showNoDataView();
                this.mCN.setVisibility(8);
                this.mCP = bVar;
                return;
            }
            if (this.mCP.iNQ.bnF() == 1) {
                XZ();
                return;
            } else {
                Ya();
                return;
            }
        }
        if (!z || this.mCP == null || this.mCP.mCF == null || this.mCP.mCF.size() == 0) {
            this.mCP = bVar;
        } else {
            this.mCP.iNQ = bVar.iNQ;
            this.mCP.mCF.addAll(bVar.mCF);
        }
        if (z) {
            dDB();
        }
        if (this.mCP.iNQ.bnF() == 1) {
            XZ();
        } else {
            Ya();
        }
        this.mCO.setData(this.mCP.mCF);
        this.mCO.notifyDataSetChanged();
        if (!z) {
            this.mCN.setSelection(0);
        }
        this.mCN.setVisibility(0);
    }

    public void bA(boolean z) {
        if (this.mCz != null) {
            String str = this.mCz.iQJ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mCQ) || z;
                if (this.mCP == null || (this.mCP != null && !this.mCP.cZK())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mCz.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mCz.dDr().bE(str, this.hKL);
                    this.mCQ = str;
                }
            }
        }
    }

    public void dDz() {
        if (this.mCP != null && this.mCP.mCF != null) {
            this.mCP.mCF.clear();
            this.mCO.setData(this.mCP.mCF);
            this.mCO.notifyDataSetChanged();
        }
        bTa();
        hideNoDataView();
    }

    private void initView() {
        this.mCN = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mCQ) && this.mCP != null && this.mCP.isHasMore() && this.mCz.dDr().bE(this.mCQ, this.hKL)) {
            dDA();
        }
    }

    private void dDA() {
        this.mCN.setNextPage(this.gre);
        this.gre.startLoadData();
    }

    private void XZ() {
        this.mCN.setNextPage(this.gre);
        this.gre.endLoadData();
        this.gre.setText(this.mCz.getResources().getString(R.string.pb_load_more));
    }

    private void Ya() {
        this.mCN.setNextPage(this.gre);
        this.gre.endLoadData();
        this.gre.setText(this.mCz.getResources().getString(R.string.list_no_more));
    }

    private void bTa() {
        if (this.mCN != null) {
            this.mCN.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mCz.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mCz.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mCz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dDB() {
        if (this.mCz != null) {
            TiebaStatic.log(new ar("c12406").dY("fid", this.mCz.mForumId).dY("fname", this.mCz.mForumName).dY("uid", TbadkCoreApplication.getCurrentAccount()).al("tab_id", this.hKL));
        }
    }
}

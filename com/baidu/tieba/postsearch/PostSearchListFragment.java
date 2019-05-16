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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView dlX;
    private int eca;
    private PostSearchActivity iuE;
    private BdListView iuT;
    private e iuU;
    private b iuV;
    private String iuW;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.eca = -1;
        this.iuW = "";
    }

    public PostSearchListFragment(int i) {
        this.eca = -1;
        this.iuW = "";
        this.eca = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.iuE = (PostSearchActivity) getBaseFragmentActivity();
        this.iuU = new e(this.iuE.getPageContext());
        this.iuU.setTabType(this.eca);
        BdListViewHelper.a(this.iuE.getActivity(), this.iuT, BdListViewHelper.HeadType.HASTAB);
        this.iuT.setAdapter((ListAdapter) this.iuU);
        this.dlX = new PbListView(this.iuE.getPageContext().getPageActivity());
        this.dlX.nG();
        this.iuT.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.eca == this.iuE.cde().getCurrentTabType()) {
            cdn();
            pX(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iuE != null) {
            com.baidu.tbadk.s.a.a(this.iuE.getPageContext(), this.mRootView);
        }
        if (this.dlX != null) {
            this.dlX.iP(i);
        }
        if (this.iuU != null) {
            this.iuU.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iuK == null || bVar.iuK.size() == 0) {
            if (!z || this.iuV == null || this.iuV.iuK == null || this.iuV.iuK.size() == 0) {
                aIG();
                showNoDataView();
                this.iuT.setVisibility(8);
                this.iuV = bVar;
                return;
            }
            if (this.iuV.fkg.acp() == 1) {
                aIE();
                return;
            } else {
                aIF();
                return;
            }
        }
        if (!z || this.iuV == null || this.iuV.iuK == null || this.iuV.iuK.size() == 0) {
            this.iuV = bVar;
        } else {
            this.iuV.fkg = bVar.fkg;
            this.iuV.iuK.addAll(bVar.iuK);
        }
        if (z) {
            cdn();
        }
        if (this.iuV.fkg.acp() == 1) {
            aIE();
        } else {
            aIF();
        }
        this.iuU.clear();
        this.iuU.dX(this.iuV.iuK);
        this.iuU.notifyDataSetChanged();
        if (!z) {
            this.iuT.setSelection(0);
        }
        this.iuT.setVisibility(0);
    }

    public void pX(boolean z) {
        if (this.iuE != null) {
            String str = this.iuE.fmY;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iuW) || z;
                if (this.iuV == null || (this.iuV != null && !this.iuV.bDt())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iuE.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iuE.cdd().bg(str, this.eca);
                    this.iuW = str;
                }
            }
        }
    }

    public void cdl() {
        if (this.iuV != null && this.iuV.iuK != null) {
            this.iuV.iuK.clear();
            this.iuU.clear();
            this.iuU.dX(this.iuV.iuK);
            this.iuU.notifyDataSetChanged();
        }
        aIG();
        hideNoDataView();
    }

    private void initView() {
        this.iuT = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iuW) && this.iuV != null && this.iuV.isHasMore() && this.iuE.cdd().bg(this.iuW, this.eca)) {
            cdm();
        }
    }

    private void cdm() {
        this.iuT.setNextPage(this.dlX);
        this.dlX.ajy();
    }

    private void aIE() {
        this.iuT.setNextPage(this.dlX);
        this.dlX.ajz();
        this.dlX.setText(this.iuE.getResources().getString(R.string.pb_load_more));
    }

    private void aIF() {
        this.iuT.setNextPage(this.dlX);
        this.dlX.ajz();
        this.dlX.setText(this.iuE.getResources().getString(R.string.list_no_more));
    }

    private void aIG() {
        if (this.iuT != null) {
            this.iuT.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iuE.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iuE.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iuE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cdn() {
        if (this.iuE != null) {
            TiebaStatic.log(new am("c12406").bT("fid", this.iuE.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.iuE.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount()).P(MyBookrackActivityConfig.TAB_ID, this.eca));
        }
    }
}

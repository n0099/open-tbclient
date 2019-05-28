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
    private PbListView dlY;
    private int ecb;
    private PostSearchActivity iuH;
    private BdListView iuW;
    private e iuX;
    private b iuY;
    private String iuZ;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.ecb = -1;
        this.iuZ = "";
    }

    public PostSearchListFragment(int i) {
        this.ecb = -1;
        this.iuZ = "";
        this.ecb = i;
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
        this.iuH = (PostSearchActivity) getBaseFragmentActivity();
        this.iuX = new e(this.iuH.getPageContext());
        this.iuX.setTabType(this.ecb);
        BdListViewHelper.a(this.iuH.getActivity(), this.iuW, BdListViewHelper.HeadType.HASTAB);
        this.iuW.setAdapter((ListAdapter) this.iuX);
        this.dlY = new PbListView(this.iuH.getPageContext().getPageActivity());
        this.dlY.nG();
        this.iuW.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.ecb == this.iuH.cdh().getCurrentTabType()) {
            cdq();
            pX(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iuH != null) {
            com.baidu.tbadk.s.a.a(this.iuH.getPageContext(), this.mRootView);
        }
        if (this.dlY != null) {
            this.dlY.iP(i);
        }
        if (this.iuX != null) {
            this.iuX.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iuN == null || bVar.iuN.size() == 0) {
            if (!z || this.iuY == null || this.iuY.iuN == null || this.iuY.iuN.size() == 0) {
                aIJ();
                showNoDataView();
                this.iuW.setVisibility(8);
                this.iuY = bVar;
                return;
            }
            if (this.iuY.fkh.acp() == 1) {
                aIH();
                return;
            } else {
                aII();
                return;
            }
        }
        if (!z || this.iuY == null || this.iuY.iuN == null || this.iuY.iuN.size() == 0) {
            this.iuY = bVar;
        } else {
            this.iuY.fkh = bVar.fkh;
            this.iuY.iuN.addAll(bVar.iuN);
        }
        if (z) {
            cdq();
        }
        if (this.iuY.fkh.acp() == 1) {
            aIH();
        } else {
            aII();
        }
        this.iuX.clear();
        this.iuX.dX(this.iuY.iuN);
        this.iuX.notifyDataSetChanged();
        if (!z) {
            this.iuW.setSelection(0);
        }
        this.iuW.setVisibility(0);
    }

    public void pX(boolean z) {
        if (this.iuH != null) {
            String str = this.iuH.fmZ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iuZ) || z;
                if (this.iuY == null || (this.iuY != null && !this.iuY.bDw())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iuH.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iuH.cdg().bg(str, this.ecb);
                    this.iuZ = str;
                }
            }
        }
    }

    public void cdo() {
        if (this.iuY != null && this.iuY.iuN != null) {
            this.iuY.iuN.clear();
            this.iuX.clear();
            this.iuX.dX(this.iuY.iuN);
            this.iuX.notifyDataSetChanged();
        }
        aIJ();
        hideNoDataView();
    }

    private void initView() {
        this.iuW = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iuZ) && this.iuY != null && this.iuY.isHasMore() && this.iuH.cdg().bg(this.iuZ, this.ecb)) {
            cdp();
        }
    }

    private void cdp() {
        this.iuW.setNextPage(this.dlY);
        this.dlY.ajy();
    }

    private void aIH() {
        this.iuW.setNextPage(this.dlY);
        this.dlY.ajz();
        this.dlY.setText(this.iuH.getResources().getString(R.string.pb_load_more));
    }

    private void aII() {
        this.iuW.setNextPage(this.dlY);
        this.dlY.ajz();
        this.dlY.setText(this.iuH.getResources().getString(R.string.list_no_more));
    }

    private void aIJ() {
        if (this.iuW != null) {
            this.iuW.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iuH.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iuH.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iuH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cdq() {
        if (this.iuH != null) {
            TiebaStatic.log(new am("c12406").bT("fid", this.iuH.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.iuH.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount()).P(MyBookrackActivityConfig.TAB_ID, this.ecb));
        }
    }
}

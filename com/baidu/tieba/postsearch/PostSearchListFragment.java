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
    private PostSearchActivity iuI;
    private BdListView iuX;
    private e iuY;
    private b iuZ;
    private String iva;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.ecb = -1;
        this.iva = "";
    }

    public PostSearchListFragment(int i) {
        this.ecb = -1;
        this.iva = "";
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
        this.iuI = (PostSearchActivity) getBaseFragmentActivity();
        this.iuY = new e(this.iuI.getPageContext());
        this.iuY.setTabType(this.ecb);
        BdListViewHelper.a(this.iuI.getActivity(), this.iuX, BdListViewHelper.HeadType.HASTAB);
        this.iuX.setAdapter((ListAdapter) this.iuY);
        this.dlY = new PbListView(this.iuI.getPageContext().getPageActivity());
        this.dlY.nG();
        this.iuX.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.ecb == this.iuI.cdi().getCurrentTabType()) {
            cdr();
            pY(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iuI != null) {
            com.baidu.tbadk.s.a.a(this.iuI.getPageContext(), this.mRootView);
        }
        if (this.dlY != null) {
            this.dlY.iP(i);
        }
        if (this.iuY != null) {
            this.iuY.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iuO == null || bVar.iuO.size() == 0) {
            if (!z || this.iuZ == null || this.iuZ.iuO == null || this.iuZ.iuO.size() == 0) {
                aIJ();
                showNoDataView();
                this.iuX.setVisibility(8);
                this.iuZ = bVar;
                return;
            }
            if (this.iuZ.fkh.acp() == 1) {
                aIH();
                return;
            } else {
                aII();
                return;
            }
        }
        if (!z || this.iuZ == null || this.iuZ.iuO == null || this.iuZ.iuO.size() == 0) {
            this.iuZ = bVar;
        } else {
            this.iuZ.fkh = bVar.fkh;
            this.iuZ.iuO.addAll(bVar.iuO);
        }
        if (z) {
            cdr();
        }
        if (this.iuZ.fkh.acp() == 1) {
            aIH();
        } else {
            aII();
        }
        this.iuY.clear();
        this.iuY.dX(this.iuZ.iuO);
        this.iuY.notifyDataSetChanged();
        if (!z) {
            this.iuX.setSelection(0);
        }
        this.iuX.setVisibility(0);
    }

    public void pY(boolean z) {
        if (this.iuI != null) {
            String str = this.iuI.fmZ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iva) || z;
                if (this.iuZ == null || (this.iuZ != null && !this.iuZ.bDx())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iuI.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iuI.cdh().bg(str, this.ecb);
                    this.iva = str;
                }
            }
        }
    }

    public void cdp() {
        if (this.iuZ != null && this.iuZ.iuO != null) {
            this.iuZ.iuO.clear();
            this.iuY.clear();
            this.iuY.dX(this.iuZ.iuO);
            this.iuY.notifyDataSetChanged();
        }
        aIJ();
        hideNoDataView();
    }

    private void initView() {
        this.iuX = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iva) && this.iuZ != null && this.iuZ.isHasMore() && this.iuI.cdh().bg(this.iva, this.ecb)) {
            cdq();
        }
    }

    private void cdq() {
        this.iuX.setNextPage(this.dlY);
        this.dlY.ajy();
    }

    private void aIH() {
        this.iuX.setNextPage(this.dlY);
        this.dlY.ajz();
        this.dlY.setText(this.iuI.getResources().getString(R.string.pb_load_more));
    }

    private void aII() {
        this.iuX.setNextPage(this.dlY);
        this.dlY.ajz();
        this.dlY.setText(this.iuI.getResources().getString(R.string.list_no_more));
    }

    private void aIJ() {
        if (this.iuX != null) {
            this.iuX.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iuI.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iuI.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iuI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cdr() {
        if (this.iuI != null) {
            TiebaStatic.log(new am("c12406").bT("fid", this.iuI.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.iuI.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount()).P(MyBookrackActivityConfig.TAB_ID, this.ecb));
        }
    }
}

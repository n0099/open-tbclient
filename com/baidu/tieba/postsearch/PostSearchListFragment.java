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
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private int dRA;
    private PbListView dbr;
    private PostSearchActivity ibZ;
    private BdListView icn;
    private e ico;
    private b icp;
    private String icq;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.dRA = -1;
        this.icq = "";
    }

    public PostSearchListFragment(int i) {
        this.dRA = -1;
        this.icq = "";
        this.dRA = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(d.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ibZ = (PostSearchActivity) getBaseFragmentActivity();
        this.ico = new e(this.ibZ.getPageContext());
        this.ico.setTabType(this.dRA);
        BdListViewHelper.a(this.ibZ.getActivity(), this.icn, BdListViewHelper.HeadType.HASTAB);
        this.icn.setAdapter((ListAdapter) this.ico);
        this.dbr = new PbListView(this.ibZ.getPageContext().getPageActivity());
        this.dbr.oM();
        this.icn.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dRA == this.ibZ.bVd().getCurrentTabType()) {
            bVm();
            pj(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ibZ != null) {
            com.baidu.tbadk.r.a.a(this.ibZ.getPageContext(), this.mRootView);
        }
        if (this.dbr != null) {
            this.dbr.ib(i);
        }
        if (this.ico != null) {
            this.ico.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.icf == null || bVar.icf.size() == 0) {
            if (!z || this.icp == null || this.icp.icf == null || this.icp.icf.size() == 0) {
                aCt();
                showNoDataView();
                this.icn.setVisibility(8);
                this.icp = bVar;
                return;
            }
            if (this.icp.eTV.XH() == 1) {
                aCr();
                return;
            } else {
                aCs();
                return;
            }
        }
        if (!z || this.icp == null || this.icp.icf == null || this.icp.icf.size() == 0) {
            this.icp = bVar;
        } else {
            this.icp.eTV = bVar.eTV;
            this.icp.icf.addAll(bVar.icf);
        }
        if (z) {
            bVm();
        }
        if (this.icp.eTV.XH() == 1) {
            aCr();
        } else {
            aCs();
        }
        this.ico.clear();
        this.ico.dN(this.icp.icf);
        this.ico.notifyDataSetChanged();
        if (!z) {
            this.icn.setSelection(0);
        }
        this.icn.setVisibility(0);
    }

    public void pj(boolean z) {
        if (this.ibZ != null) {
            String str = this.ibZ.eWT;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.icq) || z;
                if (this.icp == null || (this.icp != null && !this.icp.bvL())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.ibZ.getResources().getDimensionPixelSize(d.e.ds320));
                    this.ibZ.bVc().bk(str, this.dRA);
                    this.icq = str;
                }
            }
        }
    }

    public void bVk() {
        if (this.icp != null && this.icp.icf != null) {
            this.icp.icf.clear();
            this.ico.clear();
            this.ico.dN(this.icp.icf);
            this.ico.notifyDataSetChanged();
        }
        aCt();
        hideNoDataView();
    }

    private void initView() {
        this.icn = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.icq) && this.icp != null && this.icp.isHasMore() && this.ibZ.bVc().bk(this.icq, this.dRA)) {
            bVl();
        }
    }

    private void bVl() {
        this.icn.setNextPage(this.dbr);
        this.dbr.aez();
    }

    private void aCr() {
        this.icn.setNextPage(this.dbr);
        this.dbr.aeA();
        this.dbr.setText(this.ibZ.getResources().getString(d.j.pb_load_more));
    }

    private void aCs() {
        this.icn.setNextPage(this.dbr);
        this.dbr.aeA();
        this.dbr.setText(this.ibZ.getResources().getString(d.j.list_no_more));
    }

    private void aCt() {
        if (this.icn != null) {
            this.icn.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ibZ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.ibZ.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.ibZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bVm() {
        if (this.ibZ != null) {
            TiebaStatic.log(new am("c12406").bJ(ImageViewerConfig.FORUM_ID, this.ibZ.mForumId).bJ(ImageViewerConfig.FORUM_NAME, this.ibZ.mForumName).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T(MyBookrackActivityConfig.TAB_ID, this.dRA));
        }
    }
}

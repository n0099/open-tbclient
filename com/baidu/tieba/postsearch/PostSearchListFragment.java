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
    private int dRB;
    private PbListView dbs;
    private PostSearchActivity ica;
    private BdListView ico;
    private e icp;
    private b icq;
    private String icr;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.dRB = -1;
        this.icr = "";
    }

    public PostSearchListFragment(int i) {
        this.dRB = -1;
        this.icr = "";
        this.dRB = i;
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
        this.ica = (PostSearchActivity) getBaseFragmentActivity();
        this.icp = new e(this.ica.getPageContext());
        this.icp.setTabType(this.dRB);
        BdListViewHelper.a(this.ica.getActivity(), this.ico, BdListViewHelper.HeadType.HASTAB);
        this.ico.setAdapter((ListAdapter) this.icp);
        this.dbs = new PbListView(this.ica.getPageContext().getPageActivity());
        this.dbs.oM();
        this.ico.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dRB == this.ica.bVd().getCurrentTabType()) {
            bVm();
            pj(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ica != null) {
            com.baidu.tbadk.r.a.a(this.ica.getPageContext(), this.mRootView);
        }
        if (this.dbs != null) {
            this.dbs.ib(i);
        }
        if (this.icp != null) {
            this.icp.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.icg == null || bVar.icg.size() == 0) {
            if (!z || this.icq == null || this.icq.icg == null || this.icq.icg.size() == 0) {
                aCt();
                showNoDataView();
                this.ico.setVisibility(8);
                this.icq = bVar;
                return;
            }
            if (this.icq.eTW.XH() == 1) {
                aCr();
                return;
            } else {
                aCs();
                return;
            }
        }
        if (!z || this.icq == null || this.icq.icg == null || this.icq.icg.size() == 0) {
            this.icq = bVar;
        } else {
            this.icq.eTW = bVar.eTW;
            this.icq.icg.addAll(bVar.icg);
        }
        if (z) {
            bVm();
        }
        if (this.icq.eTW.XH() == 1) {
            aCr();
        } else {
            aCs();
        }
        this.icp.clear();
        this.icp.dN(this.icq.icg);
        this.icp.notifyDataSetChanged();
        if (!z) {
            this.ico.setSelection(0);
        }
        this.ico.setVisibility(0);
    }

    public void pj(boolean z) {
        if (this.ica != null) {
            String str = this.ica.eWU;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.icr) || z;
                if (this.icq == null || (this.icq != null && !this.icq.bvL())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.ica.getResources().getDimensionPixelSize(d.e.ds320));
                    this.ica.bVc().bk(str, this.dRB);
                    this.icr = str;
                }
            }
        }
    }

    public void bVk() {
        if (this.icq != null && this.icq.icg != null) {
            this.icq.icg.clear();
            this.icp.clear();
            this.icp.dN(this.icq.icg);
            this.icp.notifyDataSetChanged();
        }
        aCt();
        hideNoDataView();
    }

    private void initView() {
        this.ico = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.icr) && this.icq != null && this.icq.isHasMore() && this.ica.bVc().bk(this.icr, this.dRB)) {
            bVl();
        }
    }

    private void bVl() {
        this.ico.setNextPage(this.dbs);
        this.dbs.aez();
    }

    private void aCr() {
        this.ico.setNextPage(this.dbs);
        this.dbs.aeA();
        this.dbs.setText(this.ica.getResources().getString(d.j.pb_load_more));
    }

    private void aCs() {
        this.ico.setNextPage(this.dbs);
        this.dbs.aeA();
        this.dbs.setText(this.ica.getResources().getString(d.j.list_no_more));
    }

    private void aCt() {
        if (this.ico != null) {
            this.ico.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ica.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.ica.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.ica.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bVm() {
        if (this.ica != null) {
            TiebaStatic.log(new am("c12406").bJ(ImageViewerConfig.FORUM_ID, this.ica.mForumId).bJ(ImageViewerConfig.FORUM_NAME, this.ica.mForumName).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T(MyBookrackActivityConfig.TAB_ID, this.dRB));
        }
    }
}

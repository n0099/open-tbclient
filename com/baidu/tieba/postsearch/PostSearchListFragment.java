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
    private int dSj;
    private PbListView dbn;
    private BdListView icB;
    private e icC;
    private b icD;
    private String icE;
    private PostSearchActivity icn;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.dSj = -1;
        this.icE = "";
    }

    public PostSearchListFragment(int i) {
        this.dSj = -1;
        this.icE = "";
        this.dSj = i;
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
        this.icn = (PostSearchActivity) getBaseFragmentActivity();
        this.icC = new e(this.icn.getPageContext());
        this.icC.setTabType(this.dSj);
        BdListViewHelper.a(this.icn.getActivity(), this.icB, BdListViewHelper.HeadType.HASTAB);
        this.icB.setAdapter((ListAdapter) this.icC);
        this.dbn = new PbListView(this.icn.getPageContext().getPageActivity());
        this.dbn.oM();
        this.icB.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.dSj == this.icn.bVh().getCurrentTabType()) {
            bVq();
            pj(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.icn != null) {
            com.baidu.tbadk.r.a.a(this.icn.getPageContext(), this.mRootView);
        }
        if (this.dbn != null) {
            this.dbn.ic(i);
        }
        if (this.icC != null) {
            this.icC.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.ict == null || bVar.ict.size() == 0) {
            if (!z || this.icD == null || this.icD.ict == null || this.icD.ict.size() == 0) {
                aCw();
                showNoDataView();
                this.icB.setVisibility(8);
                this.icD = bVar;
                return;
            }
            if (this.icD.eUj.XK() == 1) {
                aCu();
                return;
            } else {
                aCv();
                return;
            }
        }
        if (!z || this.icD == null || this.icD.ict == null || this.icD.ict.size() == 0) {
            this.icD = bVar;
        } else {
            this.icD.eUj = bVar.eUj;
            this.icD.ict.addAll(bVar.ict);
        }
        if (z) {
            bVq();
        }
        if (this.icD.eUj.XK() == 1) {
            aCu();
        } else {
            aCv();
        }
        this.icC.clear();
        this.icC.dQ(this.icD.ict);
        this.icC.notifyDataSetChanged();
        if (!z) {
            this.icB.setSelection(0);
        }
        this.icB.setVisibility(0);
    }

    public void pj(boolean z) {
        if (this.icn != null) {
            String str = this.icn.eXh;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.icE) || z;
                if (this.icD == null || (this.icD != null && !this.icD.bvO())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.icn.getResources().getDimensionPixelSize(d.e.ds320));
                    this.icn.bVg().bk(str, this.dSj);
                    this.icE = str;
                }
            }
        }
    }

    public void bVo() {
        if (this.icD != null && this.icD.ict != null) {
            this.icD.ict.clear();
            this.icC.clear();
            this.icC.dQ(this.icD.ict);
            this.icC.notifyDataSetChanged();
        }
        aCw();
        hideNoDataView();
    }

    private void initView() {
        this.icB = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.icE) && this.icD != null && this.icD.isHasMore() && this.icn.bVg().bk(this.icE, this.dSj)) {
            bVp();
        }
    }

    private void bVp() {
        this.icB.setNextPage(this.dbn);
        this.dbn.aeC();
    }

    private void aCu() {
        this.icB.setNextPage(this.dbn);
        this.dbn.aeD();
        this.dbn.setText(this.icn.getResources().getString(d.j.pb_load_more));
    }

    private void aCv() {
        this.icB.setNextPage(this.dbn);
        this.dbn.aeD();
        this.dbn.setText(this.icn.getResources().getString(d.j.list_no_more));
    }

    private void aCw() {
        if (this.icB != null) {
            this.icB.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.icn.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.icn.getActivity(), d.e.ds320)), NoDataViewFactory.d.hU(d.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.icn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bVq() {
        if (this.icn != null) {
            TiebaStatic.log(new am("c12406").bJ(ImageViewerConfig.FORUM_ID, this.icn.mForumId).bJ(ImageViewerConfig.FORUM_NAME, this.icn.mForumName).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T(MyBookrackActivityConfig.TAB_ID, this.dSj));
        }
    }
}

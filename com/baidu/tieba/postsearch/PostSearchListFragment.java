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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private int bWY;
    private PbListView blb;
    private PostSearchActivity fSQ;
    private BdListView fTg;
    private e fTh;
    private b fTi;
    private String fTj;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.bWY = -1;
        this.fTj = "";
    }

    public PostSearchListFragment(int i) {
        this.bWY = -1;
        this.fTj = "";
        this.bWY = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(d.i.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fSQ = (PostSearchActivity) getBaseFragmentActivity();
        this.fTh = new e(this.fSQ.getPageContext());
        this.fTh.setTabType(this.bWY);
        BdListViewHelper.a(this.fSQ.getActivity(), this.fTg, BdListViewHelper.HeadType.HASTAB);
        this.fTg.setAdapter((ListAdapter) this.fTh);
        this.blb = new PbListView(this.fSQ.getPageContext().getPageActivity());
        this.blb.kA();
        this.fTg.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.bWY == this.fSQ.bhW().getCurrentTabType()) {
            bif();
            lA(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fSQ != null) {
            com.baidu.tbadk.n.a.a(this.fSQ.getPageContext(), this.mRootView);
        }
        if (this.blb != null) {
            this.blb.dv(i);
        }
        if (this.fTh != null) {
            this.fTh.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.fSX == null || bVar.fSX.size() == 0) {
            if (!z || this.fTi == null || this.fTi.fSX == null || this.fTi.fSX.size() == 0) {
                Qq();
                showNoDataView();
                this.fTg.setVisibility(8);
                this.fTi = bVar;
                return;
            }
            if (this.fTi.fSY.rc() == 1) {
                Qo();
                return;
            } else {
                Qp();
                return;
            }
        }
        if (!z || this.fTi == null || this.fTi.fSX == null || this.fTi.fSX.size() == 0) {
            this.fTi = bVar;
        } else {
            this.fTi.fSY = bVar.fSY;
            this.fTi.fSX.addAll(bVar.fSX);
        }
        if (z) {
            bif();
        }
        if (this.fTi.fSY.rc() == 1) {
            Qo();
        } else {
            Qp();
        }
        this.fTh.clear();
        this.fTh.db(this.fTi.fSX);
        this.fTh.notifyDataSetChanged();
        if (!z) {
            this.fTg.setSelection(0);
        }
        this.fTg.setVisibility(0);
    }

    public void lA(boolean z) {
        if (this.fSQ != null) {
            String str = this.fSQ.cVN;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.fTj) || z;
                if (this.fTi == null || (this.fTi != null && !this.fTi.aGI())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.fSQ.getResources().getDimensionPixelSize(d.e.ds320));
                    this.fSQ.bhV().aE(str, this.bWY);
                    this.fTj = str;
                }
            }
        }
    }

    public void bid() {
        if (this.fTi != null && this.fTi.fSX != null) {
            this.fTi.fSX.clear();
            this.fTh.clear();
            this.fTh.db(this.fTi.fSX);
            this.fTh.notifyDataSetChanged();
        }
        Qq();
        hideNoDataView();
    }

    private void initView() {
        this.fTg = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.fTj) && this.fTi != null && this.fTi.isHasMore() && this.fSQ.bhV().aE(this.fTj, this.bWY)) {
            bie();
        }
    }

    private void bie() {
        this.fTg.setNextPage(this.blb);
        this.blb.wR();
    }

    private void Qo() {
        this.fTg.setNextPage(this.blb);
        this.blb.wS();
        this.blb.setText(this.fSQ.getResources().getString(d.k.pb_load_more));
    }

    private void Qp() {
        this.fTg.setNextPage(this.blb);
        this.blb.wS();
        this.blb.setText(this.fSQ.getResources().getString(d.k.list_no_more));
    }

    private void Qq() {
        if (this.fTg != null) {
            this.fTg.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fSQ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fSQ.getActivity(), d.e.ds320)), NoDataViewFactory.d.m16do(d.k.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.fSQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bif() {
        if (this.fSQ != null) {
            TiebaStatic.log(new al("c12406").ac(ImageViewerConfig.FORUM_ID, this.fSQ.mForumId).ac(ImageViewerConfig.FORUM_NAME, this.fSQ.mForumName).ac("uid", TbadkCoreApplication.getCurrentAccount()).r(MyBookrackActivityConfig.TAB_ID, this.bWY));
        }
    }
}

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
    private int bWV;
    private PbListView blb;
    private PostSearchActivity fSN;
    private BdListView fTd;
    private e fTe;
    private b fTf;
    private String fTg;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.bWV = -1;
        this.fTg = "";
    }

    public PostSearchListFragment(int i) {
        this.bWV = -1;
        this.fTg = "";
        this.bWV = i;
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
        this.fSN = (PostSearchActivity) getBaseFragmentActivity();
        this.fTe = new e(this.fSN.getPageContext());
        this.fTe.setTabType(this.bWV);
        BdListViewHelper.a(this.fSN.getActivity(), this.fTd, BdListViewHelper.HeadType.HASTAB);
        this.fTd.setAdapter((ListAdapter) this.fTe);
        this.blb = new PbListView(this.fSN.getPageContext().getPageActivity());
        this.blb.kA();
        this.fTd.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.bWV == this.fSN.bhW().getCurrentTabType()) {
            bif();
            lA(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fSN != null) {
            com.baidu.tbadk.n.a.a(this.fSN.getPageContext(), this.mRootView);
        }
        if (this.blb != null) {
            this.blb.dv(i);
        }
        if (this.fTe != null) {
            this.fTe.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.fSU == null || bVar.fSU.size() == 0) {
            if (!z || this.fTf == null || this.fTf.fSU == null || this.fTf.fSU.size() == 0) {
                Qq();
                showNoDataView();
                this.fTd.setVisibility(8);
                this.fTf = bVar;
                return;
            }
            if (this.fTf.fSV.rc() == 1) {
                Qo();
                return;
            } else {
                Qp();
                return;
            }
        }
        if (!z || this.fTf == null || this.fTf.fSU == null || this.fTf.fSU.size() == 0) {
            this.fTf = bVar;
        } else {
            this.fTf.fSV = bVar.fSV;
            this.fTf.fSU.addAll(bVar.fSU);
        }
        if (z) {
            bif();
        }
        if (this.fTf.fSV.rc() == 1) {
            Qo();
        } else {
            Qp();
        }
        this.fTe.clear();
        this.fTe.db(this.fTf.fSU);
        this.fTe.notifyDataSetChanged();
        if (!z) {
            this.fTd.setSelection(0);
        }
        this.fTd.setVisibility(0);
    }

    public void lA(boolean z) {
        if (this.fSN != null) {
            String str = this.fSN.cVK;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.fTg) || z;
                if (this.fTf == null || (this.fTf != null && !this.fTf.aGI())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.fSN.getResources().getDimensionPixelSize(d.e.ds320));
                    this.fSN.bhV().aE(str, this.bWV);
                    this.fTg = str;
                }
            }
        }
    }

    public void bid() {
        if (this.fTf != null && this.fTf.fSU != null) {
            this.fTf.fSU.clear();
            this.fTe.clear();
            this.fTe.db(this.fTf.fSU);
            this.fTe.notifyDataSetChanged();
        }
        Qq();
        hideNoDataView();
    }

    private void initView() {
        this.fTd = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.fTg) && this.fTf != null && this.fTf.isHasMore() && this.fSN.bhV().aE(this.fTg, this.bWV)) {
            bie();
        }
    }

    private void bie() {
        this.fTd.setNextPage(this.blb);
        this.blb.wR();
    }

    private void Qo() {
        this.fTd.setNextPage(this.blb);
        this.blb.wS();
        this.blb.setText(this.fSN.getResources().getString(d.k.pb_load_more));
    }

    private void Qp() {
        this.fTd.setNextPage(this.blb);
        this.blb.wS();
        this.blb.setText(this.fSN.getResources().getString(d.k.list_no_more));
    }

    private void Qq() {
        if (this.fTd != null) {
            this.fTd.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fSN.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fSN.getActivity(), d.e.ds320)), NoDataViewFactory.d.m16do(d.k.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.fSN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bif() {
        if (this.fSN != null) {
            TiebaStatic.log(new al("c12406").ac(ImageViewerConfig.FORUM_ID, this.fSN.mForumId).ac(ImageViewerConfig.FORUM_NAME, this.fSN.mForumName).ac("uid", TbadkCoreApplication.getCurrentAccount()).r(MyBookrackActivityConfig.TAB_ID, this.bWV));
        }
    }
}

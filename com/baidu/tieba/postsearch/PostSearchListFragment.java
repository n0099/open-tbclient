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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView buU;
    private int chY;
    private b gjA;
    private String gjB;
    private PostSearchActivity gjj;
    private BdListView gjy;
    private e gjz;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.chY = -1;
        this.gjB = "";
    }

    public PostSearchListFragment(int i) {
        this.chY = -1;
        this.gjB = "";
        this.chY = i;
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
        this.gjj = (PostSearchActivity) getBaseFragmentActivity();
        this.gjz = new e(this.gjj.getPageContext());
        this.gjz.setTabType(this.chY);
        BdListViewHelper.a(this.gjj.getActivity(), this.gjy, BdListViewHelper.HeadType.HASTAB);
        this.gjy.setAdapter((ListAdapter) this.gjz);
        this.buU = new PbListView(this.gjj.getPageContext().getPageActivity());
        this.buU.nn();
        this.gjy.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.chY == this.gjj.bny().getCurrentTabType()) {
            bnH();
            lR(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gjj != null) {
            com.baidu.tbadk.n.a.a(this.gjj.getPageContext(), this.mRootView);
        }
        if (this.buU != null) {
            this.buU.dz(i);
        }
        if (this.gjz != null) {
            this.gjz.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gjq == null || bVar.gjq.size() == 0) {
            if (!z || this.gjA == null || this.gjA.gjq == null || this.gjA.gjq.size() == 0) {
                Uf();
                showNoDataView();
                this.gjy.setVisibility(8);
                this.gjA = bVar;
                return;
            }
            if (this.gjA.deY.uF() == 1) {
                Ud();
                return;
            } else {
                Ue();
                return;
            }
        }
        if (!z || this.gjA == null || this.gjA.gjq == null || this.gjA.gjq.size() == 0) {
            this.gjA = bVar;
        } else {
            this.gjA.deY = bVar.deY;
            this.gjA.gjq.addAll(bVar.gjq);
        }
        if (z) {
            bnH();
        }
        if (this.gjA.deY.uF() == 1) {
            Ud();
        } else {
            Ue();
        }
        this.gjz.clear();
        this.gjz.dn(this.gjA.gjq);
        this.gjz.notifyDataSetChanged();
        if (!z) {
            this.gjy.setSelection(0);
        }
        this.gjy.setVisibility(0);
    }

    public void lR(boolean z) {
        if (this.gjj != null) {
            String str = this.gjj.dhV;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gjB) || z;
                if (this.gjA == null || (this.gjA != null && !this.gjA.aMh())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gjj.getResources().getDimensionPixelSize(d.e.ds320));
                    this.gjj.bnx().aI(str, this.chY);
                    this.gjB = str;
                }
            }
        }
    }

    public void bnF() {
        if (this.gjA != null && this.gjA.gjq != null) {
            this.gjA.gjq.clear();
            this.gjz.clear();
            this.gjz.dn(this.gjA.gjq);
            this.gjz.notifyDataSetChanged();
        }
        Uf();
        hideNoDataView();
    }

    private void initView() {
        this.gjy = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gjB) && this.gjA != null && this.gjA.isHasMore() && this.gjj.bnx().aI(this.gjB, this.chY)) {
            bnG();
        }
    }

    private void bnG() {
        this.gjy.setNextPage(this.buU);
        this.buU.AH();
    }

    private void Ud() {
        this.gjy.setNextPage(this.buU);
        this.buU.AI();
        this.buU.setText(this.gjj.getResources().getString(d.k.pb_load_more));
    }

    private void Ue() {
        this.gjy.setNextPage(this.buU);
        this.buU.AI();
        this.buU.setText(this.gjj.getResources().getString(d.k.list_no_more));
    }

    private void Uf() {
        if (this.gjy != null) {
            this.gjy.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gjj.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.gjj.getActivity(), d.e.ds320)), NoDataViewFactory.d.ds(d.k.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gjj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bnH() {
        if (this.gjj != null) {
            TiebaStatic.log(new an("c12406").ah(ImageViewerConfig.FORUM_ID, this.gjj.mForumId).ah(ImageViewerConfig.FORUM_NAME, this.gjj.mForumName).ah("uid", TbadkCoreApplication.getCurrentAccount()).r(MyBookrackActivityConfig.TAB_ID, this.chY));
        }
    }
}

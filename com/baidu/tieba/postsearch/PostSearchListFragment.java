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
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView btv;
    private int cfO;
    private b gfA;
    private String gfB;
    private PostSearchActivity gfi;
    private BdListView gfy;
    private e gfz;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cfO = -1;
        this.gfB = "";
    }

    public PostSearchListFragment(int i) {
        this.cfO = -1;
        this.gfB = "";
        this.cfO = i;
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
        this.gfi = (PostSearchActivity) getBaseFragmentActivity();
        this.gfz = new e(this.gfi.getPageContext());
        this.gfz.setTabType(this.cfO);
        BdListViewHelper.a(this.gfi.getActivity(), this.gfy, BdListViewHelper.HeadType.HASTAB);
        this.gfy.setAdapter((ListAdapter) this.gfz);
        this.btv = new PbListView(this.gfi.getPageContext().getPageActivity());
        this.btv.nn();
        this.gfy.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cfO == this.gfi.bmU().getCurrentTabType()) {
            bnd();
            lH(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gfi != null) {
            com.baidu.tbadk.n.a.a(this.gfi.getPageContext(), this.mRootView);
        }
        if (this.btv != null) {
            this.btv.dy(i);
        }
        if (this.gfz != null) {
            this.gfz.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gfp == null || bVar.gfp.size() == 0) {
            if (!z || this.gfA == null || this.gfA.gfp == null || this.gfA.gfp.size() == 0) {
                TL();
                showNoDataView();
                this.gfy.setVisibility(8);
                this.gfA = bVar;
                return;
            }
            if (this.gfA.gfq.ux() == 1) {
                TJ();
                return;
            } else {
                TK();
                return;
            }
        }
        if (!z || this.gfA == null || this.gfA.gfp == null || this.gfA.gfp.size() == 0) {
            this.gfA = bVar;
        } else {
            this.gfA.gfq = bVar.gfq;
            this.gfA.gfp.addAll(bVar.gfp);
        }
        if (z) {
            bnd();
        }
        if (this.gfA.gfq.ux() == 1) {
            TJ();
        } else {
            TK();
        }
        this.gfz.clear();
        this.gfz.dj(this.gfA.gfp);
        this.gfz.notifyDataSetChanged();
        if (!z) {
            this.gfy.setSelection(0);
        }
        this.gfy.setVisibility(0);
    }

    public void lH(boolean z) {
        if (this.gfi != null) {
            String str = this.gfi.dge;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gfB) || z;
                if (this.gfA == null || (this.gfA != null && !this.gfA.aLB())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gfi.getResources().getDimensionPixelSize(d.e.ds320));
                    this.gfi.bmT().aH(str, this.cfO);
                    this.gfB = str;
                }
            }
        }
    }

    public void bnb() {
        if (this.gfA != null && this.gfA.gfp != null) {
            this.gfA.gfp.clear();
            this.gfz.clear();
            this.gfz.dj(this.gfA.gfp);
            this.gfz.notifyDataSetChanged();
        }
        TL();
        hideNoDataView();
    }

    private void initView() {
        this.gfy = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gfB) && this.gfA != null && this.gfA.isHasMore() && this.gfi.bmT().aH(this.gfB, this.cfO)) {
            bnc();
        }
    }

    private void bnc() {
        this.gfy.setNextPage(this.btv);
        this.btv.Ar();
    }

    private void TJ() {
        this.gfy.setNextPage(this.btv);
        this.btv.As();
        this.btv.setText(this.gfi.getResources().getString(d.k.pb_load_more));
    }

    private void TK() {
        this.gfy.setNextPage(this.btv);
        this.btv.As();
        this.btv.setText(this.gfi.getResources().getString(d.k.list_no_more));
    }

    private void TL() {
        if (this.gfy != null) {
            this.gfy.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gfi.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.gfi.getActivity(), d.e.ds320)), NoDataViewFactory.d.dr(d.k.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gfi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bnd() {
        if (this.gfi != null) {
            TiebaStatic.log(new am("c12406").ah(ImageViewerConfig.FORUM_ID, this.gfi.mForumId).ah(ImageViewerConfig.FORUM_NAME, this.gfi.mForumName).ah("uid", TbadkCoreApplication.getCurrentAccount()).r(MyBookrackActivityConfig.TAB_ID, this.cfO));
        }
    }
}

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
    private PbListView bvA;
    private int cjG;
    private PostSearchActivity gjK;
    private BdListView gjZ;
    private e gka;
    private b gkb;
    private String gkc;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cjG = -1;
        this.gkc = "";
    }

    public PostSearchListFragment(int i) {
        this.cjG = -1;
        this.gkc = "";
        this.cjG = i;
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
        this.gjK = (PostSearchActivity) getBaseFragmentActivity();
        this.gka = new e(this.gjK.getPageContext());
        this.gka.setTabType(this.cjG);
        BdListViewHelper.a(this.gjK.getActivity(), this.gjZ, BdListViewHelper.HeadType.HASTAB);
        this.gjZ.setAdapter((ListAdapter) this.gka);
        this.bvA = new PbListView(this.gjK.getPageContext().getPageActivity());
        this.bvA.np();
        this.gjZ.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cjG == this.gjK.blR().getCurrentTabType()) {
            bma();
            lC(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gjK != null) {
            com.baidu.tbadk.o.a.a(this.gjK.getPageContext(), this.mRootView);
        }
        if (this.bvA != null) {
            this.bvA.dC(i);
        }
        if (this.gka != null) {
            this.gka.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gjR == null || bVar.gjR.size() == 0) {
            if (!z || this.gkb == null || this.gkb.gjR == null || this.gkb.gjR.size() == 0) {
                Un();
                showNoDataView();
                this.gjZ.setVisibility(8);
                this.gkb = bVar;
                return;
            }
            if (this.gkb.dhO.us() == 1) {
                Ul();
                return;
            } else {
                Um();
                return;
            }
        }
        if (!z || this.gkb == null || this.gkb.gjR == null || this.gkb.gjR.size() == 0) {
            this.gkb = bVar;
        } else {
            this.gkb.dhO = bVar.dhO;
            this.gkb.gjR.addAll(bVar.gjR);
        }
        if (z) {
            bma();
        }
        if (this.gkb.dhO.us() == 1) {
            Ul();
        } else {
            Um();
        }
        this.gka.clear();
        this.gka.dj(this.gkb.gjR);
        this.gka.notifyDataSetChanged();
        if (!z) {
            this.gjZ.setSelection(0);
        }
        this.gjZ.setVisibility(0);
    }

    public void lC(boolean z) {
        if (this.gjK != null) {
            String str = this.gjK.dkL;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gkc) || z;
                if (this.gkb == null || (this.gkb != null && !this.gkb.aNh())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gjK.getResources().getDimensionPixelSize(d.e.ds320));
                    this.gjK.blQ().aE(str, this.cjG);
                    this.gkc = str;
                }
            }
        }
    }

    public void blY() {
        if (this.gkb != null && this.gkb.gjR != null) {
            this.gkb.gjR.clear();
            this.gka.clear();
            this.gka.dj(this.gkb.gjR);
            this.gka.notifyDataSetChanged();
        }
        Un();
        hideNoDataView();
    }

    private void initView() {
        this.gjZ = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gkc) && this.gkb != null && this.gkb.isHasMore() && this.gjK.blQ().aE(this.gkc, this.cjG)) {
            blZ();
        }
    }

    private void blZ() {
        this.gjZ.setNextPage(this.bvA);
        this.bvA.Ax();
    }

    private void Ul() {
        this.gjZ.setNextPage(this.bvA);
        this.bvA.Ay();
        this.bvA.setText(this.gjK.getResources().getString(d.j.pb_load_more));
    }

    private void Um() {
        this.gjZ.setNextPage(this.bvA);
        this.bvA.Ay();
        this.bvA.setText(this.gjK.getResources().getString(d.j.list_no_more));
    }

    private void Un() {
        if (this.gjZ != null) {
            this.gjZ.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gjK.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.gjK.getActivity(), d.e.ds320)), NoDataViewFactory.d.du(d.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gjK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bma() {
        if (this.gjK != null) {
            TiebaStatic.log(new an("c12406").af(ImageViewerConfig.FORUM_ID, this.gjK.mForumId).af(ImageViewerConfig.FORUM_NAME, this.gjK.mForumName).af("uid", TbadkCoreApplication.getCurrentAccount()).r(MyBookrackActivityConfig.TAB_ID, this.cjG));
        }
    }
}

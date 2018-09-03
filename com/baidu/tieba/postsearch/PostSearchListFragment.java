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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView bvC;
    private int cjD;
    private PostSearchActivity gjJ;
    private BdListView gjY;
    private e gjZ;
    private b gka;
    private String gkb;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cjD = -1;
        this.gkb = "";
    }

    public PostSearchListFragment(int i) {
        this.cjD = -1;
        this.gkb = "";
        this.cjD = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(f.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gjJ = (PostSearchActivity) getBaseFragmentActivity();
        this.gjZ = new e(this.gjJ.getPageContext());
        this.gjZ.setTabType(this.cjD);
        BdListViewHelper.a(this.gjJ.getActivity(), this.gjY, BdListViewHelper.HeadType.HASTAB);
        this.gjY.setAdapter((ListAdapter) this.gjZ);
        this.bvC = new PbListView(this.gjJ.getPageContext().getPageActivity());
        this.bvC.np();
        this.gjY.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cjD == this.gjJ.blO().getCurrentTabType()) {
            blX();
            lC(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gjJ != null) {
            com.baidu.tbadk.o.a.a(this.gjJ.getPageContext(), this.mRootView);
        }
        if (this.bvC != null) {
            this.bvC.dB(i);
        }
        if (this.gjZ != null) {
            this.gjZ.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gjQ == null || bVar.gjQ.size() == 0) {
            if (!z || this.gka == null || this.gka.gjQ == null || this.gka.gjQ.size() == 0) {
                Uq();
                showNoDataView();
                this.gjY.setVisibility(8);
                this.gka = bVar;
                return;
            }
            if (this.gka.dhM.ur() == 1) {
                Uo();
                return;
            } else {
                Up();
                return;
            }
        }
        if (!z || this.gka == null || this.gka.gjQ == null || this.gka.gjQ.size() == 0) {
            this.gka = bVar;
        } else {
            this.gka.dhM = bVar.dhM;
            this.gka.gjQ.addAll(bVar.gjQ);
        }
        if (z) {
            blX();
        }
        if (this.gka.dhM.ur() == 1) {
            Uo();
        } else {
            Up();
        }
        this.gjZ.clear();
        this.gjZ.dj(this.gka.gjQ);
        this.gjZ.notifyDataSetChanged();
        if (!z) {
            this.gjY.setSelection(0);
        }
        this.gjY.setVisibility(0);
    }

    public void lC(boolean z) {
        if (this.gjJ != null) {
            String str = this.gjJ.dkJ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gkb) || z;
                if (this.gka == null || (this.gka != null && !this.gka.aNe())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gjJ.getResources().getDimensionPixelSize(f.e.ds320));
                    this.gjJ.blN().aE(str, this.cjD);
                    this.gkb = str;
                }
            }
        }
    }

    public void blV() {
        if (this.gka != null && this.gka.gjQ != null) {
            this.gka.gjQ.clear();
            this.gjZ.clear();
            this.gjZ.dj(this.gka.gjQ);
            this.gjZ.notifyDataSetChanged();
        }
        Uq();
        hideNoDataView();
    }

    private void initView() {
        this.gjY = (BdListView) this.mRootView.findViewById(f.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gkb) && this.gka != null && this.gka.isHasMore() && this.gjJ.blN().aE(this.gkb, this.cjD)) {
            blW();
        }
    }

    private void blW() {
        this.gjY.setNextPage(this.bvC);
        this.bvC.Av();
    }

    private void Uo() {
        this.gjY.setNextPage(this.bvC);
        this.bvC.Aw();
        this.bvC.setText(this.gjJ.getResources().getString(f.j.pb_load_more));
    }

    private void Up() {
        this.gjY.setNextPage(this.bvC);
        this.bvC.Aw();
        this.bvC.setText(this.gjJ.getResources().getString(f.j.list_no_more));
    }

    private void Uq() {
        if (this.gjY != null) {
            this.gjY.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gjJ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.gjJ.getActivity(), f.e.ds320)), NoDataViewFactory.d.dt(f.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gjJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void blX() {
        if (this.gjJ != null) {
            TiebaStatic.log(new an("c12406").ae(ImageViewerConfig.FORUM_ID, this.gjJ.mForumId).ae(ImageViewerConfig.FORUM_NAME, this.gjJ.mForumName).ae("uid", TbadkCoreApplication.getCurrentAccount()).r(MyBookrackActivityConfig.TAB_ID, this.cjD));
        }
    }
}

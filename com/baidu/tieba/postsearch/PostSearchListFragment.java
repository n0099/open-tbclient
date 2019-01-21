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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView bPn;
    private int cEL;
    private PostSearchActivity gKP;
    private BdListView gLe;
    private e gLf;
    private b gLg;
    private String gLh;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cEL = -1;
        this.gLh = "";
    }

    public PostSearchListFragment(int i) {
        this.cEL = -1;
        this.gLh = "";
        this.cEL = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(e.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gKP = (PostSearchActivity) getBaseFragmentActivity();
        this.gLf = new e(this.gKP.getPageContext());
        this.gLf.setTabType(this.cEL);
        BdListViewHelper.a(this.gKP.getActivity(), this.gLe, BdListViewHelper.HeadType.HASTAB);
        this.gLe.setAdapter((ListAdapter) this.gLf);
        this.bPn = new PbListView(this.gKP.getPageContext().getPageActivity());
        this.bPn.oH();
        this.gLe.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cEL == this.gKP.bus().getCurrentTabType()) {
            buB();
            mK(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gKP != null) {
            com.baidu.tbadk.o.a.a(this.gKP.getPageContext(), this.mRootView);
        }
        if (this.bPn != null) {
            this.bPn.ey(i);
        }
        if (this.gLf != null) {
            this.gLf.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gKW == null || bVar.gKW.size() == 0) {
            if (!z || this.gLg == null || this.gLg.gKW == null || this.gLg.gKW.size() == 0) {
                abA();
                showNoDataView();
                this.gLe.setVisibility(8);
                this.gLg = bVar;
                return;
            }
            if (this.gLg.dGW.zc() == 1) {
                aby();
                return;
            } else {
                abz();
                return;
            }
        }
        if (!z || this.gLg == null || this.gLg.gKW == null || this.gLg.gKW.size() == 0) {
            this.gLg = bVar;
        } else {
            this.gLg.dGW = bVar.dGW;
            this.gLg.gKW.addAll(bVar.gKW);
        }
        if (z) {
            buB();
        }
        if (this.gLg.dGW.zc() == 1) {
            aby();
        } else {
            abz();
        }
        this.gLf.clear();
        this.gLf.dC(this.gLg.gKW);
        this.gLf.notifyDataSetChanged();
        if (!z) {
            this.gLe.setSelection(0);
        }
        this.gLe.setVisibility(0);
    }

    public void mK(boolean z) {
        if (this.gKP != null) {
            String str = this.gKP.dJR;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gLh) || z;
                if (this.gLg == null || (this.gLg != null && !this.gLg.aVj())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gKP.getResources().getDimensionPixelSize(e.C0210e.ds320));
                    this.gKP.bur().aP(str, this.cEL);
                    this.gLh = str;
                }
            }
        }
    }

    public void buz() {
        if (this.gLg != null && this.gLg.gKW != null) {
            this.gLg.gKW.clear();
            this.gLf.clear();
            this.gLf.dC(this.gLg.gKW);
            this.gLf.notifyDataSetChanged();
        }
        abA();
        hideNoDataView();
    }

    private void initView() {
        this.gLe = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gLh) && this.gLg != null && this.gLg.isHasMore() && this.gKP.bur().aP(this.gLh, this.cEL)) {
            buA();
        }
    }

    private void buA() {
        this.gLe.setNextPage(this.bPn);
        this.bPn.Fp();
    }

    private void aby() {
        this.gLe.setNextPage(this.bPn);
        this.bPn.Fq();
        this.bPn.setText(this.gKP.getResources().getString(e.j.pb_load_more));
    }

    private void abz() {
        this.gLe.setNextPage(this.bPn);
        this.bPn.Fq();
        this.bPn.setText(this.gKP.getResources().getString(e.j.list_no_more));
    }

    private void abA() {
        if (this.gLe != null) {
            this.gLe.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gKP.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gKP.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gKP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void buB() {
        if (this.gKP != null) {
            TiebaStatic.log(new am("c12406").aB(ImageViewerConfig.FORUM_ID, this.gKP.mForumId).aB(ImageViewerConfig.FORUM_NAME, this.gKP.mForumName).aB("uid", TbadkCoreApplication.getCurrentAccount()).y(MyBookrackActivityConfig.TAB_ID, this.cEL));
        }
    }
}

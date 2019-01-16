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
    private PbListView bPm;
    private int cEK;
    private PostSearchActivity gKO;
    private BdListView gLd;
    private e gLe;
    private b gLf;
    private String gLg;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cEK = -1;
        this.gLg = "";
    }

    public PostSearchListFragment(int i) {
        this.cEK = -1;
        this.gLg = "";
        this.cEK = i;
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
        this.gKO = (PostSearchActivity) getBaseFragmentActivity();
        this.gLe = new e(this.gKO.getPageContext());
        this.gLe.setTabType(this.cEK);
        BdListViewHelper.a(this.gKO.getActivity(), this.gLd, BdListViewHelper.HeadType.HASTAB);
        this.gLd.setAdapter((ListAdapter) this.gLe);
        this.bPm = new PbListView(this.gKO.getPageContext().getPageActivity());
        this.bPm.oH();
        this.gLd.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cEK == this.gKO.bus().getCurrentTabType()) {
            buB();
            mK(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gKO != null) {
            com.baidu.tbadk.o.a.a(this.gKO.getPageContext(), this.mRootView);
        }
        if (this.bPm != null) {
            this.bPm.ey(i);
        }
        if (this.gLe != null) {
            this.gLe.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gKV == null || bVar.gKV.size() == 0) {
            if (!z || this.gLf == null || this.gLf.gKV == null || this.gLf.gKV.size() == 0) {
                abA();
                showNoDataView();
                this.gLd.setVisibility(8);
                this.gLf = bVar;
                return;
            }
            if (this.gLf.dGV.zc() == 1) {
                aby();
                return;
            } else {
                abz();
                return;
            }
        }
        if (!z || this.gLf == null || this.gLf.gKV == null || this.gLf.gKV.size() == 0) {
            this.gLf = bVar;
        } else {
            this.gLf.dGV = bVar.dGV;
            this.gLf.gKV.addAll(bVar.gKV);
        }
        if (z) {
            buB();
        }
        if (this.gLf.dGV.zc() == 1) {
            aby();
        } else {
            abz();
        }
        this.gLe.clear();
        this.gLe.dC(this.gLf.gKV);
        this.gLe.notifyDataSetChanged();
        if (!z) {
            this.gLd.setSelection(0);
        }
        this.gLd.setVisibility(0);
    }

    public void mK(boolean z) {
        if (this.gKO != null) {
            String str = this.gKO.dJQ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gLg) || z;
                if (this.gLf == null || (this.gLf != null && !this.gLf.aVj())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gKO.getResources().getDimensionPixelSize(e.C0210e.ds320));
                    this.gKO.bur().aP(str, this.cEK);
                    this.gLg = str;
                }
            }
        }
    }

    public void buz() {
        if (this.gLf != null && this.gLf.gKV != null) {
            this.gLf.gKV.clear();
            this.gLe.clear();
            this.gLe.dC(this.gLf.gKV);
            this.gLe.notifyDataSetChanged();
        }
        abA();
        hideNoDataView();
    }

    private void initView() {
        this.gLd = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gLg) && this.gLf != null && this.gLf.isHasMore() && this.gKO.bur().aP(this.gLg, this.cEK)) {
            buA();
        }
    }

    private void buA() {
        this.gLd.setNextPage(this.bPm);
        this.bPm.Fp();
    }

    private void aby() {
        this.gLd.setNextPage(this.bPm);
        this.bPm.Fq();
        this.bPm.setText(this.gKO.getResources().getString(e.j.pb_load_more));
    }

    private void abz() {
        this.gLd.setNextPage(this.bPm);
        this.bPm.Fq();
        this.bPm.setText(this.gKO.getResources().getString(e.j.list_no_more));
    }

    private void abA() {
        if (this.gLd != null) {
            this.gLd.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gKO.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gKO.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gKO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void buB() {
        if (this.gKO != null) {
            TiebaStatic.log(new am("c12406").aB(ImageViewerConfig.FORUM_ID, this.gKO.mForumId).aB(ImageViewerConfig.FORUM_NAME, this.gKO.mForumName).aB("uid", TbadkCoreApplication.getCurrentAccount()).y(MyBookrackActivityConfig.TAB_ID, this.cEK));
        }
    }
}

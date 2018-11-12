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
    private PbListView bKJ;
    private int czh;
    private PostSearchActivity gAd;
    private BdListView gAs;
    private e gAt;
    private b gAu;
    private String gAv;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.czh = -1;
        this.gAv = "";
    }

    public PostSearchListFragment(int i) {
        this.czh = -1;
        this.gAv = "";
        this.czh = i;
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
        this.gAd = (PostSearchActivity) getBaseFragmentActivity();
        this.gAt = new e(this.gAd.getPageContext());
        this.gAt.setTabType(this.czh);
        BdListViewHelper.a(this.gAd.getActivity(), this.gAs, BdListViewHelper.HeadType.HASTAB);
        this.gAs.setAdapter((ListAdapter) this.gAt);
        this.bKJ = new PbListView(this.gAd.getPageContext().getPageActivity());
        this.bKJ.oE();
        this.gAs.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.czh == this.gAd.brf().getCurrentTabType()) {
            bro();
            mE(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gAd != null) {
            com.baidu.tbadk.o.a.a(this.gAd.getPageContext(), this.mRootView);
        }
        if (this.bKJ != null) {
            this.bKJ.ek(i);
        }
        if (this.gAt != null) {
            this.gAt.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gAk == null || bVar.gAk.size() == 0) {
            if (!z || this.gAu == null || this.gAu.gAk == null || this.gAu.gAk.size() == 0) {
                ZV();
                showNoDataView();
                this.gAs.setVisibility(8);
                this.gAu = bVar;
                return;
            }
            if (this.gAu.dwZ.xL() == 1) {
                ZT();
                return;
            } else {
                ZU();
                return;
            }
        }
        if (!z || this.gAu == null || this.gAu.gAk == null || this.gAu.gAk.size() == 0) {
            this.gAu = bVar;
        } else {
            this.gAu.dwZ = bVar.dwZ;
            this.gAu.gAk.addAll(bVar.gAk);
        }
        if (z) {
            bro();
        }
        if (this.gAu.dwZ.xL() == 1) {
            ZT();
        } else {
            ZU();
        }
        this.gAt.clear();
        this.gAt.dw(this.gAu.gAk);
        this.gAt.notifyDataSetChanged();
        if (!z) {
            this.gAs.setSelection(0);
        }
        this.gAs.setVisibility(0);
    }

    public void mE(boolean z) {
        if (this.gAd != null) {
            String str = this.gAd.dzU;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gAv) || z;
                if (this.gAu == null || (this.gAu != null && !this.gAu.aSe())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gAd.getResources().getDimensionPixelSize(e.C0200e.ds320));
                    this.gAd.bre().aN(str, this.czh);
                    this.gAv = str;
                }
            }
        }
    }

    public void brm() {
        if (this.gAu != null && this.gAu.gAk != null) {
            this.gAu.gAk.clear();
            this.gAt.clear();
            this.gAt.dw(this.gAu.gAk);
            this.gAt.notifyDataSetChanged();
        }
        ZV();
        hideNoDataView();
    }

    private void initView() {
        this.gAs = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gAv) && this.gAu != null && this.gAu.isHasMore() && this.gAd.bre().aN(this.gAv, this.czh)) {
            brn();
        }
    }

    private void brn() {
        this.gAs.setNextPage(this.bKJ);
        this.bKJ.DY();
    }

    private void ZT() {
        this.gAs.setNextPage(this.bKJ);
        this.bKJ.DZ();
        this.bKJ.setText(this.gAd.getResources().getString(e.j.pb_load_more));
    }

    private void ZU() {
        this.gAs.setNextPage(this.bKJ);
        this.bKJ.DZ();
        this.bKJ.setText(this.gAd.getResources().getString(e.j.list_no_more));
    }

    private void ZV() {
        if (this.gAs != null) {
            this.gAs.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gAd.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gAd.getActivity(), e.C0200e.ds320)), NoDataViewFactory.d.ec(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gAd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bro() {
        if (this.gAd != null) {
            TiebaStatic.log(new am("c12406").ax(ImageViewerConfig.FORUM_ID, this.gAd.mForumId).ax(ImageViewerConfig.FORUM_NAME, this.gAd.mForumName).ax("uid", TbadkCoreApplication.getCurrentAccount()).x(MyBookrackActivityConfig.TAB_ID, this.czh));
        }
    }
}

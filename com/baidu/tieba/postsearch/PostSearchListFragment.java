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
    private PbListView bBr;
    private int cpv;
    private PostSearchActivity grb;
    private BdListView grq;
    private e grr;
    private b grs;
    private String grt;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cpv = -1;
        this.grt = "";
    }

    public PostSearchListFragment(int i) {
        this.cpv = -1;
        this.grt = "";
        this.cpv = i;
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
        this.grb = (PostSearchActivity) getBaseFragmentActivity();
        this.grr = new e(this.grb.getPageContext());
        this.grr.setTabType(this.cpv);
        BdListViewHelper.a(this.grb.getActivity(), this.grq, BdListViewHelper.HeadType.HASTAB);
        this.grq.setAdapter((ListAdapter) this.grr);
        this.bBr = new PbListView(this.grb.getPageContext().getPageActivity());
        this.bBr.ov();
        this.grq.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cpv == this.grb.bou().getCurrentTabType()) {
            boD();
            mb(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.grb != null) {
            com.baidu.tbadk.o.a.a(this.grb.getPageContext(), this.mRootView);
        }
        if (this.bBr != null) {
            this.bBr.dM(i);
        }
        if (this.grr != null) {
            this.grr.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gri == null || bVar.gri.size() == 0) {
            if (!z || this.grs == null || this.grs.gri == null || this.grs.gri.size() == 0) {
                Wd();
                showNoDataView();
                this.grq.setVisibility(8);
                this.grs = bVar;
                return;
            }
            if (this.grs.dnE.vu() == 1) {
                Wb();
                return;
            } else {
                Wc();
                return;
            }
        }
        if (!z || this.grs == null || this.grs.gri == null || this.grs.gri.size() == 0) {
            this.grs = bVar;
        } else {
            this.grs.dnE = bVar.dnE;
            this.grs.gri.addAll(bVar.gri);
        }
        if (z) {
            boD();
        }
        if (this.grs.dnE.vu() == 1) {
            Wb();
        } else {
            Wc();
        }
        this.grr.clear();
        this.grr.dk(this.grs.gri);
        this.grr.notifyDataSetChanged();
        if (!z) {
            this.grq.setSelection(0);
        }
        this.grq.setVisibility(0);
    }

    public void mb(boolean z) {
        if (this.grb != null) {
            String str = this.grb.dqC;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.grt) || z;
                if (this.grs == null || (this.grs != null && !this.grs.aPt())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.grb.getResources().getDimensionPixelSize(e.C0141e.ds320));
                    this.grb.bot().aJ(str, this.cpv);
                    this.grt = str;
                }
            }
        }
    }

    public void boB() {
        if (this.grs != null && this.grs.gri != null) {
            this.grs.gri.clear();
            this.grr.clear();
            this.grr.dk(this.grs.gri);
            this.grr.notifyDataSetChanged();
        }
        Wd();
        hideNoDataView();
    }

    private void initView() {
        this.grq = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.grt) && this.grs != null && this.grs.isHasMore() && this.grb.bot().aJ(this.grt, this.cpv)) {
            boC();
        }
    }

    private void boC() {
        this.grq.setNextPage(this.bBr);
        this.bBr.BI();
    }

    private void Wb() {
        this.grq.setNextPage(this.bBr);
        this.bBr.BJ();
        this.bBr.setText(this.grb.getResources().getString(e.j.pb_load_more));
    }

    private void Wc() {
        this.grq.setNextPage(this.bBr);
        this.bBr.BJ();
        this.bBr.setText(this.grb.getResources().getString(e.j.list_no_more));
    }

    private void Wd() {
        if (this.grq != null) {
            this.grq.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.grb.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.grb.getActivity(), e.C0141e.ds320)), NoDataViewFactory.d.dE(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.grb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void boD() {
        if (this.grb != null) {
            TiebaStatic.log(new am("c12406").al(ImageViewerConfig.FORUM_ID, this.grb.mForumId).al(ImageViewerConfig.FORUM_NAME, this.grb.mForumName).al("uid", TbadkCoreApplication.getCurrentAccount()).w(MyBookrackActivityConfig.TAB_ID, this.cpv));
        }
    }
}

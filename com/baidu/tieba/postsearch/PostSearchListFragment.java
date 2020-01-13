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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView ehe;
    private int fpl;
    private BdListView jAa;
    private e jAb;
    private b jAc;
    private String jAd;
    private PostSearchActivity jzL;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.fpl = -1;
        this.jAd = "";
    }

    public PostSearchListFragment(int i) {
        this.fpl = -1;
        this.jAd = "";
        this.fpl = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.jzL = (PostSearchActivity) getBaseFragmentActivity();
        this.jAb = new e(this.jzL.getPageContext());
        this.jAb.setTabType(this.fpl);
        BdListViewHelper.a(this.jzL.getActivity(), this.jAa, BdListViewHelper.HeadType.HASTAB);
        this.jAa.setAdapter((ListAdapter) this.jAb);
        this.ehe = new PbListView(this.jzL.getPageContext().getPageActivity());
        this.ehe.createView();
        this.jAa.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fpl == this.jzL.czc().getCurrentTabType()) {
            czl();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jzL != null) {
            com.baidu.tbadk.q.a.a(this.jzL.getPageContext(), this.mRootView);
        }
        if (this.ehe != null) {
            this.ehe.changeSkin(i);
        }
        if (this.jAb != null) {
            this.jAb.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.jzR == null || bVar.jzR.size() == 0) {
            if (!z || this.jAc == null || this.jAc.jzR == null || this.jAc.jzR.size() == 0) {
                bbc();
                showNoDataView();
                this.jAa.setVisibility(8);
                this.jAc = bVar;
                return;
            }
            if (this.jAc.ghs.ayR() == 1) {
                bba();
                return;
            } else {
                bbb();
                return;
            }
        }
        if (!z || this.jAc == null || this.jAc.jzR == null || this.jAc.jzR.size() == 0) {
            this.jAc = bVar;
        } else {
            this.jAc.ghs = bVar.ghs;
            this.jAc.jzR.addAll(bVar.jzR);
        }
        if (z) {
            czl();
        }
        if (this.jAc.ghs.ayR() == 1) {
            bba();
        } else {
            bbb();
        }
        this.jAb.clear();
        this.jAb.ed(this.jAc.jzR);
        this.jAb.notifyDataSetChanged();
        if (!z) {
            this.jAa.setSelection(0);
        }
        this.jAa.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.jzL != null) {
            String str = this.jzL.gkm;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.jAd) || z;
                if (this.jAc == null || (this.jAc != null && !this.jAc.bWk())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.jzL.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.jzL.czb().bo(str, this.fpl);
                    this.jAd = str;
                }
            }
        }
    }

    public void czj() {
        if (this.jAc != null && this.jAc.jzR != null) {
            this.jAc.jzR.clear();
            this.jAb.clear();
            this.jAb.ed(this.jAc.jzR);
            this.jAb.notifyDataSetChanged();
        }
        bbc();
        hideNoDataView();
    }

    private void initView() {
        this.jAa = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.jAd) && this.jAc != null && this.jAc.isHasMore() && this.jzL.czb().bo(this.jAd, this.fpl)) {
            czk();
        }
    }

    private void czk() {
        this.jAa.setNextPage(this.ehe);
        this.ehe.startLoadData();
    }

    private void bba() {
        this.jAa.setNextPage(this.ehe);
        this.ehe.endLoadData();
        this.ehe.setText(this.jzL.getResources().getString(R.string.pb_load_more));
    }

    private void bbb() {
        this.jAa.setNextPage(this.ehe);
        this.ehe.endLoadData();
        this.ehe.setText(this.jzL.getResources().getString(R.string.list_no_more));
    }

    private void bbc() {
        if (this.jAa != null) {
            this.jAa.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jzL.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jzL.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.jzL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void czl() {
        if (this.jzL != null) {
            TiebaStatic.log(new an("c12406").cp("fid", this.jzL.mForumId).cp("fname", this.jzL.mForumName).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("tab_id", this.fpl));
        }
    }
}

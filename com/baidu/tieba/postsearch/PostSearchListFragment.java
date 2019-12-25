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
/* loaded from: classes8.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView egU;
    private int fmc;
    private b jwA;
    private String jwB;
    private PostSearchActivity jwj;
    private BdListView jwy;
    private e jwz;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.fmc = -1;
        this.jwB = "";
    }

    public PostSearchListFragment(int i) {
        this.fmc = -1;
        this.jwB = "";
        this.fmc = i;
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
        this.jwj = (PostSearchActivity) getBaseFragmentActivity();
        this.jwz = new e(this.jwj.getPageContext());
        this.jwz.setTabType(this.fmc);
        BdListViewHelper.a(this.jwj.getActivity(), this.jwy, BdListViewHelper.HeadType.HASTAB);
        this.jwy.setAdapter((ListAdapter) this.jwz);
        this.egU = new PbListView(this.jwj.getPageContext().getPageActivity());
        this.egU.createView();
        this.jwy.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fmc == this.jwj.cxV().getCurrentTabType()) {
            cye();
            rG(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jwj != null) {
            com.baidu.tbadk.q.a.a(this.jwj.getPageContext(), this.mRootView);
        }
        if (this.egU != null) {
            this.egU.changeSkin(i);
        }
        if (this.jwz != null) {
            this.jwz.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.jwp == null || bVar.jwp.size() == 0) {
            if (!z || this.jwA == null || this.jwA.jwp == null || this.jwA.jwp.size() == 0) {
                baH();
                showNoDataView();
                this.jwy.setVisibility(8);
                this.jwA = bVar;
                return;
            }
            if (this.jwA.gei.ayy() == 1) {
                baF();
                return;
            } else {
                baG();
                return;
            }
        }
        if (!z || this.jwA == null || this.jwA.jwp == null || this.jwA.jwp.size() == 0) {
            this.jwA = bVar;
        } else {
            this.jwA.gei = bVar.gei;
            this.jwA.jwp.addAll(bVar.jwp);
        }
        if (z) {
            cye();
        }
        if (this.jwA.gei.ayy() == 1) {
            baF();
        } else {
            baG();
        }
        this.jwz.clear();
        this.jwz.ed(this.jwA.jwp);
        this.jwz.notifyDataSetChanged();
        if (!z) {
            this.jwy.setSelection(0);
        }
        this.jwy.setVisibility(0);
    }

    public void rG(boolean z) {
        if (this.jwj != null) {
            String str = this.jwj.ghc;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.jwB) || z;
                if (this.jwA == null || (this.jwA != null && !this.jwA.bVb())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.jwj.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.jwj.cxU().bn(str, this.fmc);
                    this.jwB = str;
                }
            }
        }
    }

    public void cyc() {
        if (this.jwA != null && this.jwA.jwp != null) {
            this.jwA.jwp.clear();
            this.jwz.clear();
            this.jwz.ed(this.jwA.jwp);
            this.jwz.notifyDataSetChanged();
        }
        baH();
        hideNoDataView();
    }

    private void initView() {
        this.jwy = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.jwB) && this.jwA != null && this.jwA.isHasMore() && this.jwj.cxU().bn(this.jwB, this.fmc)) {
            cyd();
        }
    }

    private void cyd() {
        this.jwy.setNextPage(this.egU);
        this.egU.startLoadData();
    }

    private void baF() {
        this.jwy.setNextPage(this.egU);
        this.egU.endLoadData();
        this.egU.setText(this.jwj.getResources().getString(R.string.pb_load_more));
    }

    private void baG() {
        this.jwy.setNextPage(this.egU);
        this.egU.endLoadData();
        this.egU.setText(this.jwj.getResources().getString(R.string.list_no_more));
    }

    private void baH() {
        if (this.jwy != null) {
            this.jwy.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jwj.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jwj.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.jwj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cye() {
        if (this.jwj != null) {
            TiebaStatic.log(new an("c12406").cp("fid", this.jwj.mForumId).cp("fname", this.jwj.mForumName).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("tab_id", this.fmc));
        }
    }
}

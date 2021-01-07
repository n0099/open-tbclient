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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView gCf;
    private int hWZ;
    private PostSearchActivity mHR;
    private BdListView mIg;
    private e mIh;
    private b mIi;
    private String mIj;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hWZ = -1;
        this.mIj = "";
    }

    public PostSearchListFragment(int i) {
        this.hWZ = -1;
        this.mIj = "";
        this.hWZ = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mHR = (PostSearchActivity) getBaseFragmentActivity();
        this.mIh = new e(this.mHR.getPageContext());
        this.mIh.setTabType(this.hWZ);
        BdListViewHelper.a(this.mHR.getActivity(), this.mIg, BdListViewHelper.HeadType.HASTAB);
        this.mIg.setAdapter((ListAdapter) this.mIh);
        this.gCf = new PbListView(this.mHR.getPageContext().getPageActivity());
        this.gCf.createView();
        this.mIg.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hWZ == this.mHR.dDj().getCurrentTabType()) {
            dDs();
            bx(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mHR != null) {
            com.baidu.tbadk.r.a.a(this.mHR.getPageContext(), this.mRootView);
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
        if (this.mIh != null) {
            this.mIh.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mHX == null || bVar.mHX.size() == 0) {
            if (!z || this.mIi == null || this.mIi.mHX == null || this.mIi.mHX.size() == 0) {
                bVG();
                showNoDataView();
                this.mIg.setVisibility(8);
                this.mIi = bVar;
                return;
            }
            if (this.mIi.jad.bqg() == 1) {
                Zh();
                return;
            } else {
                Zi();
                return;
            }
        }
        if (!z || this.mIi == null || this.mIi.mHX == null || this.mIi.mHX.size() == 0) {
            this.mIi = bVar;
        } else {
            this.mIi.jad = bVar.jad;
            this.mIi.mHX.addAll(bVar.mHX);
        }
        if (z) {
            dDs();
        }
        if (this.mIi.jad.bqg() == 1) {
            Zh();
        } else {
            Zi();
        }
        this.mIh.setData(this.mIi.mHX);
        this.mIh.notifyDataSetChanged();
        if (!z) {
            this.mIg.setSelection(0);
        }
        this.mIg.setVisibility(0);
    }

    public void bx(boolean z) {
        if (this.mHR != null) {
            String str = this.mHR.jcX;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mIj) || z;
                if (this.mIi == null || (this.mIi != null && !this.mIi.cZy())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mHR.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mHR.dDi().bL(str, this.hWZ);
                    this.mIj = str;
                }
            }
        }
    }

    public void dDq() {
        if (this.mIi != null && this.mIi.mHX != null) {
            this.mIi.mHX.clear();
            this.mIh.setData(this.mIi.mHX);
            this.mIh.notifyDataSetChanged();
        }
        bVG();
        hideNoDataView();
    }

    private void initView() {
        this.mIg = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mIj) && this.mIi != null && this.mIi.isHasMore() && this.mHR.dDi().bL(this.mIj, this.hWZ)) {
            dDr();
        }
    }

    private void dDr() {
        this.mIg.setNextPage(this.gCf);
        this.gCf.startLoadData();
    }

    private void Zh() {
        this.mIg.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.setText(this.mHR.getResources().getString(R.string.pb_load_more));
    }

    private void Zi() {
        this.mIg.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.setText(this.mHR.getResources().getString(R.string.list_no_more));
    }

    private void bVG() {
        if (this.mIg != null) {
            this.mIg.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mHR.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mHR.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mHR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dDs() {
        if (this.mHR != null) {
            TiebaStatic.log(new aq("c12406").dX("fid", this.mHR.mForumId).dX("fname", this.mHR.mForumName).dX("uid", TbadkCoreApplication.getCurrentAccount()).an("tab_id", this.hWZ));
        }
    }
}

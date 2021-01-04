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
    private PostSearchActivity mHS;
    private BdListView mIh;
    private e mIi;
    private b mIj;
    private String mIk;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hWZ = -1;
        this.mIk = "";
    }

    public PostSearchListFragment(int i) {
        this.hWZ = -1;
        this.mIk = "";
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
        this.mHS = (PostSearchActivity) getBaseFragmentActivity();
        this.mIi = new e(this.mHS.getPageContext());
        this.mIi.setTabType(this.hWZ);
        BdListViewHelper.a(this.mHS.getActivity(), this.mIh, BdListViewHelper.HeadType.HASTAB);
        this.mIh.setAdapter((ListAdapter) this.mIi);
        this.gCf = new PbListView(this.mHS.getPageContext().getPageActivity());
        this.gCf.createView();
        this.mIh.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hWZ == this.mHS.dDi().getCurrentTabType()) {
            dDr();
            bx(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mHS != null) {
            com.baidu.tbadk.r.a.a(this.mHS.getPageContext(), this.mRootView);
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
        if (this.mIi != null) {
            this.mIi.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mHY == null || bVar.mHY.size() == 0) {
            if (!z || this.mIj == null || this.mIj.mHY == null || this.mIj.mHY.size() == 0) {
                bVF();
                showNoDataView();
                this.mIh.setVisibility(8);
                this.mIj = bVar;
                return;
            }
            if (this.mIj.jad.bqf() == 1) {
                Zg();
                return;
            } else {
                Zh();
                return;
            }
        }
        if (!z || this.mIj == null || this.mIj.mHY == null || this.mIj.mHY.size() == 0) {
            this.mIj = bVar;
        } else {
            this.mIj.jad = bVar.jad;
            this.mIj.mHY.addAll(bVar.mHY);
        }
        if (z) {
            dDr();
        }
        if (this.mIj.jad.bqf() == 1) {
            Zg();
        } else {
            Zh();
        }
        this.mIi.setData(this.mIj.mHY);
        this.mIi.notifyDataSetChanged();
        if (!z) {
            this.mIh.setSelection(0);
        }
        this.mIh.setVisibility(0);
    }

    public void bx(boolean z) {
        if (this.mHS != null) {
            String str = this.mHS.jcX;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mIk) || z;
                if (this.mIj == null || (this.mIj != null && !this.mIj.cZx())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mHS.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mHS.dDh().bL(str, this.hWZ);
                    this.mIk = str;
                }
            }
        }
    }

    public void dDp() {
        if (this.mIj != null && this.mIj.mHY != null) {
            this.mIj.mHY.clear();
            this.mIi.setData(this.mIj.mHY);
            this.mIi.notifyDataSetChanged();
        }
        bVF();
        hideNoDataView();
    }

    private void initView() {
        this.mIh = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mIk) && this.mIj != null && this.mIj.isHasMore() && this.mHS.dDh().bL(this.mIk, this.hWZ)) {
            dDq();
        }
    }

    private void dDq() {
        this.mIh.setNextPage(this.gCf);
        this.gCf.startLoadData();
    }

    private void Zg() {
        this.mIh.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.setText(this.mHS.getResources().getString(R.string.pb_load_more));
    }

    private void Zh() {
        this.mIh.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.setText(this.mHS.getResources().getString(R.string.list_no_more));
    }

    private void bVF() {
        if (this.mIh != null) {
            this.mIh.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mHS.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mHS.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mHS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dDr() {
        if (this.mHS != null) {
            TiebaStatic.log(new aq("c12406").dX("fid", this.mHS.mForumId).dX("fname", this.mHS.mForumName).dX("uid", TbadkCoreApplication.getCurrentAccount()).an("tab_id", this.hWZ));
        }
    }
}

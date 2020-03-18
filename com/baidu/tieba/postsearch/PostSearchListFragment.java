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
/* loaded from: classes11.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView elM;
    private int fsC;
    private BdListView jCI;
    private e jCJ;
    private b jCK;
    private String jCL;
    private PostSearchActivity jCt;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.fsC = -1;
        this.jCL = "";
    }

    public PostSearchListFragment(int i) {
        this.fsC = -1;
        this.jCL = "";
        this.fsC = i;
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
        this.jCt = (PostSearchActivity) getBaseFragmentActivity();
        this.jCJ = new e(this.jCt.getPageContext());
        this.jCJ.setTabType(this.fsC);
        BdListViewHelper.a(this.jCt.getActivity(), this.jCI, BdListViewHelper.HeadType.HASTAB);
        this.jCI.setAdapter((ListAdapter) this.jCJ);
        this.elM = new PbListView(this.jCt.getPageContext().getPageActivity());
        this.elM.createView();
        this.jCI.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fsC == this.jCt.cAW().getCurrentTabType()) {
            cBf();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jCt != null) {
            com.baidu.tbadk.q.a.a(this.jCt.getPageContext(), this.mRootView);
        }
        if (this.elM != null) {
            this.elM.changeSkin(i);
        }
        if (this.jCJ != null) {
            this.jCJ.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.jCz == null || bVar.jCz.size() == 0) {
            if (!z || this.jCK == null || this.jCK.jCz == null || this.jCK.jCz.size() == 0) {
                bdz();
                showNoDataView();
                this.jCI.setVisibility(8);
                this.jCK = bVar;
                return;
            }
            if (this.jCK.gkq.aBn() == 1) {
                bdx();
                return;
            } else {
                bdy();
                return;
            }
        }
        if (!z || this.jCK == null || this.jCK.jCz == null || this.jCK.jCz.size() == 0) {
            this.jCK = bVar;
        } else {
            this.jCK.gkq = bVar.gkq;
            this.jCK.jCz.addAll(bVar.jCz);
        }
        if (z) {
            cBf();
        }
        if (this.jCK.gkq.aBn() == 1) {
            bdx();
        } else {
            bdy();
        }
        this.jCJ.setData(this.jCK.jCz);
        this.jCJ.notifyDataSetChanged();
        if (!z) {
            this.jCI.setSelection(0);
        }
        this.jCI.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.jCt != null) {
            String str = this.jCt.gnk;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.jCL) || z;
                if (this.jCK == null || (this.jCK != null && !this.jCK.bYg())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.jCt.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.jCt.cAV().bm(str, this.fsC);
                    this.jCL = str;
                }
            }
        }
    }

    public void cBd() {
        if (this.jCK != null && this.jCK.jCz != null) {
            this.jCK.jCz.clear();
            this.jCJ.setData(this.jCK.jCz);
            this.jCJ.notifyDataSetChanged();
        }
        bdz();
        hideNoDataView();
    }

    private void initView() {
        this.jCI = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.jCL) && this.jCK != null && this.jCK.isHasMore() && this.jCt.cAV().bm(this.jCL, this.fsC)) {
            cBe();
        }
    }

    private void cBe() {
        this.jCI.setNextPage(this.elM);
        this.elM.startLoadData();
    }

    private void bdx() {
        this.jCI.setNextPage(this.elM);
        this.elM.endLoadData();
        this.elM.setText(this.jCt.getResources().getString(R.string.pb_load_more));
    }

    private void bdy() {
        this.jCI.setNextPage(this.elM);
        this.elM.endLoadData();
        this.elM.setText(this.jCt.getResources().getString(R.string.list_no_more));
    }

    private void bdz() {
        if (this.jCI != null) {
            this.jCI.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jCt.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jCt.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.jCt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cBf() {
        if (this.jCt != null) {
            TiebaStatic.log(new an("c12406").cx("fid", this.jCt.mForumId).cx("fname", this.jCt.mForumName).cx("uid", TbadkCoreApplication.getCurrentAccount()).X("tab_id", this.fsC));
        }
    }
}

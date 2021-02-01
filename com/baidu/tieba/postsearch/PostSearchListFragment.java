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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView gAi;
    private int hWN;
    private BdListView mMF;
    private e mMG;
    private b mMH;
    private String mMI;
    private PostSearchActivity mMr;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hWN = -1;
        this.mMI = "";
    }

    public PostSearchListFragment(int i) {
        this.hWN = -1;
        this.mMI = "";
        this.hWN = i;
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
        this.mMr = (PostSearchActivity) getBaseFragmentActivity();
        this.mMG = new e(this.mMr.getPageContext());
        this.mMG.setTabType(this.hWN);
        BdListViewHelper.a(this.mMr.getActivity(), this.mMF, BdListViewHelper.HeadType.HASTAB);
        this.mMF.setAdapter((ListAdapter) this.mMG);
        this.gAi = new PbListView(this.mMr.getPageContext().getPageActivity());
        this.gAi.createView();
        this.mMF.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hWN == this.mMr.dBB().getCurrentTabType()) {
            dBK();
            by(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mMr != null) {
            com.baidu.tbadk.r.a.a(this.mMr.getPageContext(), this.mRootView);
        }
        if (this.gAi != null) {
            this.gAi.changeSkin(i);
        }
        if (this.mMG != null) {
            this.mMG.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mMx == null || bVar.mMx.size() == 0) {
            if (!z || this.mMH == null || this.mMH.mMx == null || this.mMH.mMx.size() == 0) {
                bSr();
                showNoDataView();
                this.mMF.setVisibility(8);
                this.mMH = bVar;
                return;
            }
            if (this.mMH.jbd.bmF() == 1) {
                WX();
                return;
            } else {
                WY();
                return;
            }
        }
        if (!z || this.mMH == null || this.mMH.mMx == null || this.mMH.mMx.size() == 0) {
            this.mMH = bVar;
        } else {
            this.mMH.jbd = bVar.jbd;
            this.mMH.mMx.addAll(bVar.mMx);
        }
        if (z) {
            dBK();
        }
        if (this.mMH.jbd.bmF() == 1) {
            WX();
        } else {
            WY();
        }
        this.mMG.setData(this.mMH.mMx);
        this.mMG.notifyDataSetChanged();
        if (!z) {
            this.mMF.setSelection(0);
        }
        this.mMF.setVisibility(0);
    }

    public void by(boolean z) {
        if (this.mMr != null) {
            String str = this.mMr.jdX;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mMI) || z;
                if (this.mMH == null || (this.mMH != null && !this.mMH.cXE())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mMr.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mMr.dBA().bM(str, this.hWN);
                    this.mMI = str;
                }
            }
        }
    }

    public void dBI() {
        if (this.mMH != null && this.mMH.mMx != null) {
            this.mMH.mMx.clear();
            this.mMG.setData(this.mMH.mMx);
            this.mMG.notifyDataSetChanged();
        }
        bSr();
        hideNoDataView();
    }

    private void initView() {
        this.mMF = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mMI) && this.mMH != null && this.mMH.isHasMore() && this.mMr.dBA().bM(this.mMI, this.hWN)) {
            dBJ();
        }
    }

    private void dBJ() {
        this.mMF.setNextPage(this.gAi);
        this.gAi.startLoadData();
    }

    private void WX() {
        this.mMF.setNextPage(this.gAi);
        this.gAi.endLoadData();
        this.gAi.setText(this.mMr.getResources().getString(R.string.pb_load_more));
    }

    private void WY() {
        this.mMF.setNextPage(this.gAi);
        this.gAi.endLoadData();
        this.gAi.setText(this.mMr.getResources().getString(R.string.list_no_more));
    }

    private void bSr() {
        if (this.mMF != null) {
            this.mMF.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mMr.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mMr.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mMr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dBK() {
        if (this.mMr != null) {
            TiebaStatic.log(new ar("c12406").dR("fid", this.mMr.mForumId).dR("fname", this.mMr.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("tab_id", this.hWN));
        }
    }
}

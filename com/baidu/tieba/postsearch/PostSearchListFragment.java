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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView fsC;
    private int gEw;
    private PostSearchActivity lgS;
    private BdListView lhg;
    private e lhh;
    private b lhi;
    private String lhj;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.gEw = -1;
        this.lhj = "";
    }

    public PostSearchListFragment(int i) {
        this.gEw = -1;
        this.lhj = "";
        this.gEw = i;
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
        this.lgS = (PostSearchActivity) getBaseFragmentActivity();
        this.lhh = new e(this.lgS.getPageContext());
        this.lhh.setTabType(this.gEw);
        BdListViewHelper.a(this.lgS.getActivity(), this.lhg, BdListViewHelper.HeadType.HASTAB);
        this.lhg.setAdapter((ListAdapter) this.lhh);
        this.fsC = new PbListView(this.lgS.getPageContext().getPageActivity());
        this.fsC.createView();
        this.lhg.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.gEw == this.lgS.dat().getCurrentTabType()) {
            daC();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lgS != null) {
            com.baidu.tbadk.r.a.a(this.lgS.getPageContext(), this.mRootView);
        }
        if (this.fsC != null) {
            this.fsC.changeSkin(i);
        }
        if (this.lhh != null) {
            this.lhh.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.lgY == null || bVar.lgY.size() == 0) {
            if (!z || this.lhi == null || this.lhi.lgY == null || this.lhi.lgY.size() == 0) {
                bxU();
                showNoDataView();
                this.lhg.setVisibility(8);
                this.lhi = bVar;
                return;
            }
            if (this.lhi.hAv.aVb() == 1) {
                bxS();
                return;
            } else {
                bxT();
                return;
            }
        }
        if (!z || this.lhi == null || this.lhi.lgY == null || this.lhi.lgY.size() == 0) {
            this.lhi = bVar;
        } else {
            this.lhi.hAv = bVar.hAv;
            this.lhi.lgY.addAll(bVar.lgY);
        }
        if (z) {
            daC();
        }
        if (this.lhi.hAv.aVb() == 1) {
            bxS();
        } else {
            bxT();
        }
        this.lhh.setData(this.lhi.lgY);
        this.lhh.notifyDataSetChanged();
        if (!z) {
            this.lhg.setSelection(0);
        }
        this.lhg.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.lgS != null) {
            String str = this.lgS.hDo;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.lhj) || z;
                if (this.lhi == null || (this.lhi != null && !this.lhi.cxe())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.lgS.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.lgS.das().bu(str, this.gEw);
                    this.lhj = str;
                }
            }
        }
    }

    public void daA() {
        if (this.lhi != null && this.lhi.lgY != null) {
            this.lhi.lgY.clear();
            this.lhh.setData(this.lhi.lgY);
            this.lhh.notifyDataSetChanged();
        }
        bxU();
        hideNoDataView();
    }

    private void initView() {
        this.lhg = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.lhj) && this.lhi != null && this.lhi.isHasMore() && this.lgS.das().bu(this.lhj, this.gEw)) {
            daB();
        }
    }

    private void daB() {
        this.lhg.setNextPage(this.fsC);
        this.fsC.startLoadData();
    }

    private void bxS() {
        this.lhg.setNextPage(this.fsC);
        this.fsC.endLoadData();
        this.fsC.setText(this.lgS.getResources().getString(R.string.pb_load_more));
    }

    private void bxT() {
        this.lhg.setNextPage(this.fsC);
        this.fsC.endLoadData();
        this.fsC.setText(this.lgS.getResources().getString(R.string.list_no_more));
    }

    private void bxU() {
        if (this.lhg != null) {
            this.lhg.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lgS.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lgS.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mF(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.lgS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void daC() {
        if (this.lgS != null) {
            TiebaStatic.log(new ap("c12406").dn("fid", this.lgS.mForumId).dn("fname", this.lgS.mForumName).dn("uid", TbadkCoreApplication.getCurrentAccount()).ah("tab_id", this.gEw));
        }
    }
}

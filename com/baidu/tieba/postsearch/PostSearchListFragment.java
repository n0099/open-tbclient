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
/* loaded from: classes6.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView dwJ;
    private int evx;
    private PostSearchActivity iCR;
    private BdListView iDg;
    private e iDh;
    private b iDi;
    private String iDj;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.evx = -1;
        this.iDj = "";
    }

    public PostSearchListFragment(int i) {
        this.evx = -1;
        this.iDj = "";
        this.evx = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.iCR = (PostSearchActivity) getBaseFragmentActivity();
        this.iDh = new e(this.iCR.getPageContext());
        this.iDh.setTabType(this.evx);
        BdListViewHelper.a(this.iCR.getActivity(), this.iDg, BdListViewHelper.HeadType.HASTAB);
        this.iDg.setAdapter((ListAdapter) this.iDh);
        this.dwJ = new PbListView(this.iCR.getPageContext().getPageActivity());
        this.dwJ.createView();
        this.iDg.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.evx == this.iCR.cee().getCurrentTabType()) {
            cen();
            pX(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iCR != null) {
            com.baidu.tbadk.s.a.a(this.iCR.getPageContext(), this.mRootView);
        }
        if (this.dwJ != null) {
            this.dwJ.changeSkin(i);
        }
        if (this.iDh != null) {
            this.iDh.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iCX == null || bVar.iCX.size() == 0) {
            if (!z || this.iDi == null || this.iDi.iCX == null || this.iDi.iCX.size() == 0) {
                aKk();
                showNoDataView();
                this.iDg.setVisibility(8);
                this.iDi = bVar;
                return;
            }
            if (this.iDi.fqD.ahA() == 1) {
                aKi();
                return;
            } else {
                aKj();
                return;
            }
        }
        if (!z || this.iDi == null || this.iDi.iCX == null || this.iDi.iCX.size() == 0) {
            this.iDi = bVar;
        } else {
            this.iDi.fqD = bVar.fqD;
            this.iDi.iCX.addAll(bVar.iCX);
        }
        if (z) {
            cen();
        }
        if (this.iDi.fqD.ahA() == 1) {
            aKi();
        } else {
            aKj();
        }
        this.iDh.clear();
        this.iDh.el(this.iDi.iCX);
        this.iDh.notifyDataSetChanged();
        if (!z) {
            this.iDg.setSelection(0);
        }
        this.iDg.setVisibility(0);
    }

    public void pX(boolean z) {
        if (this.iCR != null) {
            String str = this.iCR.ftx;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iDj) || z;
                if (this.iDi == null || (this.iDi != null && !this.iDi.bDR())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iCR.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iCR.ced().be(str, this.evx);
                    this.iDj = str;
                }
            }
        }
    }

    public void cel() {
        if (this.iDi != null && this.iDi.iCX != null) {
            this.iDi.iCX.clear();
            this.iDh.clear();
            this.iDh.el(this.iDi.iCX);
            this.iDh.notifyDataSetChanged();
        }
        aKk();
        hideNoDataView();
    }

    private void initView() {
        this.iDg = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iDj) && this.iDi != null && this.iDi.isHasMore() && this.iCR.ced().be(this.iDj, this.evx)) {
            cem();
        }
    }

    private void cem() {
        this.iDg.setNextPage(this.dwJ);
        this.dwJ.startLoadData();
    }

    private void aKi() {
        this.iDg.setNextPage(this.dwJ);
        this.dwJ.endLoadData();
        this.dwJ.setText(this.iCR.getResources().getString(R.string.pb_load_more));
    }

    private void aKj() {
        this.iDg.setNextPage(this.dwJ);
        this.dwJ.endLoadData();
        this.dwJ.setText(this.iCR.getResources().getString(R.string.list_no_more));
    }

    private void aKk() {
        if (this.iDg != null) {
            this.iDg.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iCR.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iCR.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iL(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iCR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cen() {
        if (this.iCR != null) {
            TiebaStatic.log(new an("c12406").bS("fid", this.iCR.mForumId).bS("fname", this.iCR.mForumName).bS("uid", TbadkCoreApplication.getCurrentAccount()).O("tab_id", this.evx));
        }
    }
}

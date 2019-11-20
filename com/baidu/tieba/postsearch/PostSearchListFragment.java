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
    private PbListView dvS;
    private int euG;
    private PostSearchActivity iCa;
    private BdListView iCp;
    private e iCq;
    private b iCr;
    private String iCs;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.euG = -1;
        this.iCs = "";
    }

    public PostSearchListFragment(int i) {
        this.euG = -1;
        this.iCs = "";
        this.euG = i;
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
        this.iCa = (PostSearchActivity) getBaseFragmentActivity();
        this.iCq = new e(this.iCa.getPageContext());
        this.iCq.setTabType(this.euG);
        BdListViewHelper.a(this.iCa.getActivity(), this.iCp, BdListViewHelper.HeadType.HASTAB);
        this.iCp.setAdapter((ListAdapter) this.iCq);
        this.dvS = new PbListView(this.iCa.getPageContext().getPageActivity());
        this.dvS.createView();
        this.iCp.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.euG == this.iCa.cec().getCurrentTabType()) {
            cel();
            pX(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iCa != null) {
            com.baidu.tbadk.s.a.a(this.iCa.getPageContext(), this.mRootView);
        }
        if (this.dvS != null) {
            this.dvS.changeSkin(i);
        }
        if (this.iCq != null) {
            this.iCq.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iCg == null || bVar.iCg.size() == 0) {
            if (!z || this.iCr == null || this.iCr.iCg == null || this.iCr.iCg.size() == 0) {
                aKi();
                showNoDataView();
                this.iCp.setVisibility(8);
                this.iCr = bVar;
                return;
            }
            if (this.iCr.fpM.ahy() == 1) {
                aKg();
                return;
            } else {
                aKh();
                return;
            }
        }
        if (!z || this.iCr == null || this.iCr.iCg == null || this.iCr.iCg.size() == 0) {
            this.iCr = bVar;
        } else {
            this.iCr.fpM = bVar.fpM;
            this.iCr.iCg.addAll(bVar.iCg);
        }
        if (z) {
            cel();
        }
        if (this.iCr.fpM.ahy() == 1) {
            aKg();
        } else {
            aKh();
        }
        this.iCq.clear();
        this.iCq.el(this.iCr.iCg);
        this.iCq.notifyDataSetChanged();
        if (!z) {
            this.iCp.setSelection(0);
        }
        this.iCp.setVisibility(0);
    }

    public void pX(boolean z) {
        if (this.iCa != null) {
            String str = this.iCa.fsG;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iCs) || z;
                if (this.iCr == null || (this.iCr != null && !this.iCr.bDP())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iCa.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iCa.ceb().be(str, this.euG);
                    this.iCs = str;
                }
            }
        }
    }

    public void cej() {
        if (this.iCr != null && this.iCr.iCg != null) {
            this.iCr.iCg.clear();
            this.iCq.clear();
            this.iCq.el(this.iCr.iCg);
            this.iCq.notifyDataSetChanged();
        }
        aKi();
        hideNoDataView();
    }

    private void initView() {
        this.iCp = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iCs) && this.iCr != null && this.iCr.isHasMore() && this.iCa.ceb().be(this.iCs, this.euG)) {
            cek();
        }
    }

    private void cek() {
        this.iCp.setNextPage(this.dvS);
        this.dvS.startLoadData();
    }

    private void aKg() {
        this.iCp.setNextPage(this.dvS);
        this.dvS.endLoadData();
        this.dvS.setText(this.iCa.getResources().getString(R.string.pb_load_more));
    }

    private void aKh() {
        this.iCp.setNextPage(this.dvS);
        this.dvS.endLoadData();
        this.dvS.setText(this.iCa.getResources().getString(R.string.list_no_more));
    }

    private void aKi() {
        if (this.iCp != null) {
            this.iCp.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iCa.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iCa.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iK(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iCa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cel() {
        if (this.iCa != null) {
            TiebaStatic.log(new an("c12406").bS("fid", this.iCa.mForumId).bS("fname", this.iCa.mForumName).bS("uid", TbadkCoreApplication.getCurrentAccount()).O("tab_id", this.euG));
        }
    }
}

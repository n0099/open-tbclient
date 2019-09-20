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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView dpz;
    private int eio;
    private BdListView iEK;
    private e iEL;
    private b iEM;
    private String iEN;
    private PostSearchActivity iEv;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.eio = -1;
        this.iEN = "";
    }

    public PostSearchListFragment(int i) {
        this.eio = -1;
        this.iEN = "";
        this.eio = i;
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
        this.iEv = (PostSearchActivity) getBaseFragmentActivity();
        this.iEL = new e(this.iEv.getPageContext());
        this.iEL.setTabType(this.eio);
        BdListViewHelper.a(this.iEv.getActivity(), this.iEK, BdListViewHelper.HeadType.HASTAB);
        this.iEK.setAdapter((ListAdapter) this.iEL);
        this.dpz = new PbListView(this.iEv.getPageContext().getPageActivity());
        this.dpz.nZ();
        this.iEK.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.eio == this.iEv.chf().getCurrentTabType()) {
            cho();
            qq(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iEv != null) {
            com.baidu.tbadk.s.a.a(this.iEv.getPageContext(), this.mRootView);
        }
        if (this.dpz != null) {
            this.dpz.iY(i);
        }
        if (this.iEL != null) {
            this.iEL.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iEB == null || bVar.iEB.size() == 0) {
            if (!z || this.iEM == null || this.iEM.iEB == null || this.iEM.iEB.size() == 0) {
                aKQ();
                showNoDataView();
                this.iEK.setVisibility(8);
                this.iEM = bVar;
                return;
            }
            if (this.iEM.frr.adw() == 1) {
                aKO();
                return;
            } else {
                aKP();
                return;
            }
        }
        if (!z || this.iEM == null || this.iEM.iEB == null || this.iEM.iEB.size() == 0) {
            this.iEM = bVar;
        } else {
            this.iEM.frr = bVar.frr;
            this.iEM.iEB.addAll(bVar.iEB);
        }
        if (z) {
            cho();
        }
        if (this.iEM.frr.adw() == 1) {
            aKO();
        } else {
            aKP();
        }
        this.iEL.clear();
        this.iEL.dY(this.iEM.iEB);
        this.iEL.notifyDataSetChanged();
        if (!z) {
            this.iEK.setSelection(0);
        }
        this.iEK.setVisibility(0);
    }

    public void qq(boolean z) {
        if (this.iEv != null) {
            String str = this.iEv.fuk;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iEN) || z;
                if (this.iEM == null || (this.iEM != null && !this.iEM.bHg())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iEv.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iEv.che().bj(str, this.eio);
                    this.iEN = str;
                }
            }
        }
    }

    public void chm() {
        if (this.iEM != null && this.iEM.iEB != null) {
            this.iEM.iEB.clear();
            this.iEL.clear();
            this.iEL.dY(this.iEM.iEB);
            this.iEL.notifyDataSetChanged();
        }
        aKQ();
        hideNoDataView();
    }

    private void initView() {
        this.iEK = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iEN) && this.iEM != null && this.iEM.isHasMore() && this.iEv.che().bj(this.iEN, this.eio)) {
            chn();
        }
    }

    private void chn() {
        this.iEK.setNextPage(this.dpz);
        this.dpz.akR();
    }

    private void aKO() {
        this.iEK.setNextPage(this.dpz);
        this.dpz.akS();
        this.dpz.setText(this.iEv.getResources().getString(R.string.pb_load_more));
    }

    private void aKP() {
        this.iEK.setNextPage(this.dpz);
        this.dpz.akS();
        this.dpz.setText(this.iEv.getResources().getString(R.string.list_no_more));
    }

    private void aKQ() {
        if (this.iEK != null) {
            this.iEK.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iEv.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iEv.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iQ(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iEv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cho() {
        if (this.iEv != null) {
            TiebaStatic.log(new an("c12406").bT("fid", this.iEv.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.iEv.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount()).P(MyBookrackActivityConfig.TAB_ID, this.eio));
        }
    }
}

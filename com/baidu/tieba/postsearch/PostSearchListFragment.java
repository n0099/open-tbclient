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
    private PbListView dnN;
    private int egE;
    private PostSearchActivity iCd;
    private BdListView iCs;
    private e iCt;
    private b iCu;
    private String iCv;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.egE = -1;
        this.iCv = "";
    }

    public PostSearchListFragment(int i) {
        this.egE = -1;
        this.iCv = "";
        this.egE = i;
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
        this.iCd = (PostSearchActivity) getBaseFragmentActivity();
        this.iCt = new e(this.iCd.getPageContext());
        this.iCt.setTabType(this.egE);
        BdListViewHelper.a(this.iCd.getActivity(), this.iCs, BdListViewHelper.HeadType.HASTAB);
        this.iCs.setAdapter((ListAdapter) this.iCt);
        this.dnN = new PbListView(this.iCd.getPageContext().getPageActivity());
        this.dnN.nZ();
        this.iCs.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.egE == this.iCd.cgr().getCurrentTabType()) {
            cgA();
            qn(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iCd != null) {
            com.baidu.tbadk.s.a.a(this.iCd.getPageContext(), this.mRootView);
        }
        if (this.dnN != null) {
            this.dnN.iV(i);
        }
        if (this.iCt != null) {
            this.iCt.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iCj == null || bVar.iCj.size() == 0) {
            if (!z || this.iCu == null || this.iCu.iCj == null || this.iCu.iCj.size() == 0) {
                aKm();
                showNoDataView();
                this.iCs.setVisibility(8);
                this.iCu = bVar;
                return;
            }
            if (this.iCu.fpE.ads() == 1) {
                aKk();
                return;
            } else {
                aKl();
                return;
            }
        }
        if (!z || this.iCu == null || this.iCu.iCj == null || this.iCu.iCj.size() == 0) {
            this.iCu = bVar;
        } else {
            this.iCu.fpE = bVar.fpE;
            this.iCu.iCj.addAll(bVar.iCj);
        }
        if (z) {
            cgA();
        }
        if (this.iCu.fpE.ads() == 1) {
            aKk();
        } else {
            aKl();
        }
        this.iCt.clear();
        this.iCt.dY(this.iCu.iCj);
        this.iCt.notifyDataSetChanged();
        if (!z) {
            this.iCs.setSelection(0);
        }
        this.iCs.setVisibility(0);
    }

    public void qn(boolean z) {
        if (this.iCd != null) {
            String str = this.iCd.fsx;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iCv) || z;
                if (this.iCu == null || (this.iCu != null && !this.iCu.bGs())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iCd.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iCd.cgq().bh(str, this.egE);
                    this.iCv = str;
                }
            }
        }
    }

    public void cgy() {
        if (this.iCu != null && this.iCu.iCj != null) {
            this.iCu.iCj.clear();
            this.iCt.clear();
            this.iCt.dY(this.iCu.iCj);
            this.iCt.notifyDataSetChanged();
        }
        aKm();
        hideNoDataView();
    }

    private void initView() {
        this.iCs = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iCv) && this.iCu != null && this.iCu.isHasMore() && this.iCd.cgq().bh(this.iCv, this.egE)) {
            cgz();
        }
    }

    private void cgz() {
        this.iCs.setNextPage(this.dnN);
        this.dnN.akF();
    }

    private void aKk() {
        this.iCs.setNextPage(this.dnN);
        this.dnN.akG();
        this.dnN.setText(this.iCd.getResources().getString(R.string.pb_load_more));
    }

    private void aKl() {
        this.iCs.setNextPage(this.dnN);
        this.dnN.akG();
        this.dnN.setText(this.iCd.getResources().getString(R.string.list_no_more));
    }

    private void aKm() {
        if (this.iCs != null) {
            this.iCs.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iCd.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iCd.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iCd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cgA() {
        if (this.iCd != null) {
            TiebaStatic.log(new an("c12406").bT("fid", this.iCd.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.iCd.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount()).P(MyBookrackActivityConfig.TAB_ID, this.egE));
        }
    }
}

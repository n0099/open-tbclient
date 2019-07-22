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
    private PbListView dnG;
    private int egx;
    private PostSearchActivity iAZ;
    private BdListView iBo;
    private e iBp;
    private b iBq;
    private String iBr;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.egx = -1;
        this.iBr = "";
    }

    public PostSearchListFragment(int i) {
        this.egx = -1;
        this.iBr = "";
        this.egx = i;
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
        this.iAZ = (PostSearchActivity) getBaseFragmentActivity();
        this.iBp = new e(this.iAZ.getPageContext());
        this.iBp.setTabType(this.egx);
        BdListViewHelper.a(this.iAZ.getActivity(), this.iBo, BdListViewHelper.HeadType.HASTAB);
        this.iBo.setAdapter((ListAdapter) this.iBp);
        this.dnG = new PbListView(this.iAZ.getPageContext().getPageActivity());
        this.dnG.nZ();
        this.iBo.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.egx == this.iAZ.cfZ().getCurrentTabType()) {
            cgi();
            qm(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iAZ != null) {
            com.baidu.tbadk.s.a.a(this.iAZ.getPageContext(), this.mRootView);
        }
        if (this.dnG != null) {
            this.dnG.iV(i);
        }
        if (this.iBp != null) {
            this.iBp.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.iBf == null || bVar.iBf.size() == 0) {
            if (!z || this.iBq == null || this.iBq.iBf == null || this.iBq.iBf.size() == 0) {
                aKk();
                showNoDataView();
                this.iBo.setVisibility(8);
                this.iBq = bVar;
                return;
            }
            if (this.iBq.fpe.adr() == 1) {
                aKi();
                return;
            } else {
                aKj();
                return;
            }
        }
        if (!z || this.iBq == null || this.iBq.iBf == null || this.iBq.iBf.size() == 0) {
            this.iBq = bVar;
        } else {
            this.iBq.fpe = bVar.fpe;
            this.iBq.iBf.addAll(bVar.iBf);
        }
        if (z) {
            cgi();
        }
        if (this.iBq.fpe.adr() == 1) {
            aKi();
        } else {
            aKj();
        }
        this.iBp.clear();
        this.iBp.dZ(this.iBq.iBf);
        this.iBp.notifyDataSetChanged();
        if (!z) {
            this.iBo.setSelection(0);
        }
        this.iBo.setVisibility(0);
    }

    public void qm(boolean z) {
        if (this.iAZ != null) {
            String str = this.iAZ.frY;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.iBr) || z;
                if (this.iBq == null || (this.iBq != null && !this.iBq.bGe())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.iAZ.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.iAZ.cfY().bh(str, this.egx);
                    this.iBr = str;
                }
            }
        }
    }

    public void cgg() {
        if (this.iBq != null && this.iBq.iBf != null) {
            this.iBq.iBf.clear();
            this.iBp.clear();
            this.iBp.dZ(this.iBq.iBf);
            this.iBp.notifyDataSetChanged();
        }
        aKk();
        hideNoDataView();
    }

    private void initView() {
        this.iBo = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.iBr) && this.iBq != null && this.iBq.isHasMore() && this.iAZ.cfY().bh(this.iBr, this.egx)) {
            cgh();
        }
    }

    private void cgh() {
        this.iBo.setNextPage(this.dnG);
        this.dnG.akD();
    }

    private void aKi() {
        this.iBo.setNextPage(this.dnG);
        this.dnG.akE();
        this.dnG.setText(this.iAZ.getResources().getString(R.string.pb_load_more));
    }

    private void aKj() {
        this.iBo.setNextPage(this.dnG);
        this.dnG.akE();
        this.dnG.setText(this.iAZ.getResources().getString(R.string.list_no_more));
    }

    private void aKk() {
        if (this.iBo != null) {
            this.iBo.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iAZ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iAZ.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.iAZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cgi() {
        if (this.iAZ != null) {
            TiebaStatic.log(new an("c12406").bT("fid", this.iAZ.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.iAZ.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount()).P(MyBookrackActivityConfig.TAB_ID, this.egx));
        }
    }
}

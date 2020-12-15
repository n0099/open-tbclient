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
/* loaded from: classes24.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView grg;
    private int hKN;
    private PostSearchActivity mCB;
    private BdListView mCP;
    private e mCQ;
    private b mCR;
    private String mCS;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hKN = -1;
        this.mCS = "";
    }

    public PostSearchListFragment(int i) {
        this.hKN = -1;
        this.mCS = "";
        this.hKN = i;
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
        this.mCB = (PostSearchActivity) getBaseFragmentActivity();
        this.mCQ = new e(this.mCB.getPageContext());
        this.mCQ.setTabType(this.hKN);
        BdListViewHelper.a(this.mCB.getActivity(), this.mCP, BdListViewHelper.HeadType.HASTAB);
        this.mCP.setAdapter((ListAdapter) this.mCQ);
        this.grg = new PbListView(this.mCB.getPageContext().getPageActivity());
        this.grg.createView();
        this.mCP.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hKN == this.mCB.dDt().getCurrentTabType()) {
            dDC();
            bA(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mCB != null) {
            com.baidu.tbadk.r.a.a(this.mCB.getPageContext(), this.mRootView);
        }
        if (this.grg != null) {
            this.grg.changeSkin(i);
        }
        if (this.mCQ != null) {
            this.mCQ.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mCH == null || bVar.mCH.size() == 0) {
            if (!z || this.mCR == null || this.mCR.mCH == null || this.mCR.mCH.size() == 0) {
                bTb();
                showNoDataView();
                this.mCP.setVisibility(8);
                this.mCR = bVar;
                return;
            }
            if (this.mCR.iNS.bnF() == 1) {
                XZ();
                return;
            } else {
                Ya();
                return;
            }
        }
        if (!z || this.mCR == null || this.mCR.mCH == null || this.mCR.mCH.size() == 0) {
            this.mCR = bVar;
        } else {
            this.mCR.iNS = bVar.iNS;
            this.mCR.mCH.addAll(bVar.mCH);
        }
        if (z) {
            dDC();
        }
        if (this.mCR.iNS.bnF() == 1) {
            XZ();
        } else {
            Ya();
        }
        this.mCQ.setData(this.mCR.mCH);
        this.mCQ.notifyDataSetChanged();
        if (!z) {
            this.mCP.setSelection(0);
        }
        this.mCP.setVisibility(0);
    }

    public void bA(boolean z) {
        if (this.mCB != null) {
            String str = this.mCB.iQL;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mCS) || z;
                if (this.mCR == null || (this.mCR != null && !this.mCR.cZL())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mCB.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mCB.dDs().bE(str, this.hKN);
                    this.mCS = str;
                }
            }
        }
    }

    public void dDA() {
        if (this.mCR != null && this.mCR.mCH != null) {
            this.mCR.mCH.clear();
            this.mCQ.setData(this.mCR.mCH);
            this.mCQ.notifyDataSetChanged();
        }
        bTb();
        hideNoDataView();
    }

    private void initView() {
        this.mCP = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mCS) && this.mCR != null && this.mCR.isHasMore() && this.mCB.dDs().bE(this.mCS, this.hKN)) {
            dDB();
        }
    }

    private void dDB() {
        this.mCP.setNextPage(this.grg);
        this.grg.startLoadData();
    }

    private void XZ() {
        this.mCP.setNextPage(this.grg);
        this.grg.endLoadData();
        this.grg.setText(this.mCB.getResources().getString(R.string.pb_load_more));
    }

    private void Ya() {
        this.mCP.setNextPage(this.grg);
        this.grg.endLoadData();
        this.grg.setText(this.mCB.getResources().getString(R.string.list_no_more));
    }

    private void bTb() {
        if (this.mCP != null) {
            this.mCP.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mCB.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mCB.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mCB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dDC() {
        if (this.mCB != null) {
            TiebaStatic.log(new ar("c12406").dY("fid", this.mCB.mForumId).dY("fname", this.mCB.mForumName).dY("uid", TbadkCoreApplication.getCurrentAccount()).al("tab_id", this.hKN));
        }
    }
}

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
    private PbListView ePr;
    private int fXc;
    private PostSearchActivity kmC;
    private BdListView kmR;
    private e kmS;
    private b kmT;
    private String kmU;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.fXc = -1;
        this.kmU = "";
    }

    public PostSearchListFragment(int i) {
        this.fXc = -1;
        this.kmU = "";
        this.fXc = i;
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
        this.kmC = (PostSearchActivity) getBaseFragmentActivity();
        this.kmS = new e(this.kmC.getPageContext());
        this.kmS.setTabType(this.fXc);
        BdListViewHelper.a(this.kmC.getActivity(), this.kmR, BdListViewHelper.HeadType.HASTAB);
        this.kmR.setAdapter((ListAdapter) this.kmS);
        this.ePr = new PbListView(this.kmC.getPageContext().getPageActivity());
        this.ePr.createView();
        this.kmR.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fXc == this.kmC.cLE().getCurrentTabType()) {
            cLN();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kmC != null) {
            com.baidu.tbadk.q.a.a(this.kmC.getPageContext(), this.mRootView);
        }
        if (this.ePr != null) {
            this.ePr.changeSkin(i);
        }
        if (this.kmS != null) {
            this.kmS.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.kmI == null || bVar.kmI.size() == 0) {
            if (!z || this.kmT == null || this.kmT.kmI == null || this.kmT.kmI.size() == 0) {
                bmo();
                showNoDataView();
                this.kmR.setVisibility(8);
                this.kmT = bVar;
                return;
            }
            if (this.kmT.gTD.aJy() == 1) {
                bmm();
                return;
            } else {
                bmn();
                return;
            }
        }
        if (!z || this.kmT == null || this.kmT.kmI == null || this.kmT.kmI.size() == 0) {
            this.kmT = bVar;
        } else {
            this.kmT.gTD = bVar.gTD;
            this.kmT.kmI.addAll(bVar.kmI);
        }
        if (z) {
            cLN();
        }
        if (this.kmT.gTD.aJy() == 1) {
            bmm();
        } else {
            bmn();
        }
        this.kmS.setData(this.kmT.kmI);
        this.kmS.notifyDataSetChanged();
        if (!z) {
            this.kmR.setSelection(0);
        }
        this.kmR.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.kmC != null) {
            String str = this.kmC.gWw;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.kmU) || z;
                if (this.kmT == null || (this.kmT != null && !this.kmT.ciF())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.kmC.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.kmC.cLD().bw(str, this.fXc);
                    this.kmU = str;
                }
            }
        }
    }

    public void cLL() {
        if (this.kmT != null && this.kmT.kmI != null) {
            this.kmT.kmI.clear();
            this.kmS.setData(this.kmT.kmI);
            this.kmS.notifyDataSetChanged();
        }
        bmo();
        hideNoDataView();
    }

    private void initView() {
        this.kmR = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.kmU) && this.kmT != null && this.kmT.isHasMore() && this.kmC.cLD().bw(this.kmU, this.fXc)) {
            cLM();
        }
    }

    private void cLM() {
        this.kmR.setNextPage(this.ePr);
        this.ePr.startLoadData();
    }

    private void bmm() {
        this.kmR.setNextPage(this.ePr);
        this.ePr.endLoadData();
        this.ePr.setText(this.kmC.getResources().getString(R.string.pb_load_more));
    }

    private void bmn() {
        this.kmR.setNextPage(this.ePr);
        this.ePr.endLoadData();
        this.ePr.setText(this.kmC.getResources().getString(R.string.list_no_more));
    }

    private void bmo() {
        if (this.kmR != null) {
            this.kmR.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kmC.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kmC.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.kmC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cLN() {
        if (this.kmC != null) {
            TiebaStatic.log(new an("c12406").cI("fid", this.kmC.mForumId).cI("fname", this.kmC.mForumName).cI("uid", TbadkCoreApplication.getCurrentAccount()).af("tab_id", this.fXc));
        }
    }
}

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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView fnt;
    private int gyV;
    private PostSearchActivity kZB;
    private BdListView kZQ;
    private e kZR;
    private b kZS;
    private String kZT;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.gyV = -1;
        this.kZT = "";
    }

    public PostSearchListFragment(int i) {
        this.gyV = -1;
        this.kZT = "";
        this.gyV = i;
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
        this.kZB = (PostSearchActivity) getBaseFragmentActivity();
        this.kZR = new e(this.kZB.getPageContext());
        this.kZR.setTabType(this.gyV);
        BdListViewHelper.a(this.kZB.getActivity(), this.kZQ, BdListViewHelper.HeadType.HASTAB);
        this.kZQ.setAdapter((ListAdapter) this.kZR);
        this.fnt = new PbListView(this.kZB.getPageContext().getPageActivity());
        this.fnt.createView();
        this.kZQ.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.gyV == this.kZB.cXm().getCurrentTabType()) {
            cXv();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kZB != null) {
            com.baidu.tbadk.r.a.a(this.kZB.getPageContext(), this.mRootView);
        }
        if (this.fnt != null) {
            this.fnt.changeSkin(i);
        }
        if (this.kZR != null) {
            this.kZR.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.kZH == null || bVar.kZH.size() == 0) {
            if (!z || this.kZS == null || this.kZS.kZH == null || this.kZS.kZH.size() == 0) {
                buL();
                showNoDataView();
                this.kZQ.setVisibility(8);
                this.kZS = bVar;
                return;
            }
            if (this.kZS.huJ.aRf() == 1) {
                buJ();
                return;
            } else {
                buK();
                return;
            }
        }
        if (!z || this.kZS == null || this.kZS.kZH == null || this.kZS.kZH.size() == 0) {
            this.kZS = bVar;
        } else {
            this.kZS.huJ = bVar.huJ;
            this.kZS.kZH.addAll(bVar.kZH);
        }
        if (z) {
            cXv();
        }
        if (this.kZS.huJ.aRf() == 1) {
            buJ();
        } else {
            buK();
        }
        this.kZR.setData(this.kZS.kZH);
        this.kZR.notifyDataSetChanged();
        if (!z) {
            this.kZQ.setSelection(0);
        }
        this.kZQ.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.kZB != null) {
            String str = this.kZB.hxA;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.kZT) || z;
                if (this.kZS == null || (this.kZS != null && !this.kZS.ctc())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.kZB.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.kZB.cXl().bw(str, this.gyV);
                    this.kZT = str;
                }
            }
        }
    }

    public void cXt() {
        if (this.kZS != null && this.kZS.kZH != null) {
            this.kZS.kZH.clear();
            this.kZR.setData(this.kZS.kZH);
            this.kZR.notifyDataSetChanged();
        }
        buL();
        hideNoDataView();
    }

    private void initView() {
        this.kZQ = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.kZT) && this.kZS != null && this.kZS.isHasMore() && this.kZB.cXl().bw(this.kZT, this.gyV)) {
            cXu();
        }
    }

    private void cXu() {
        this.kZQ.setNextPage(this.fnt);
        this.fnt.startLoadData();
    }

    private void buJ() {
        this.kZQ.setNextPage(this.fnt);
        this.fnt.endLoadData();
        this.fnt.setText(this.kZB.getResources().getString(R.string.pb_load_more));
    }

    private void buK() {
        this.kZQ.setNextPage(this.fnt);
        this.fnt.endLoadData();
        this.fnt.setText(this.kZB.getResources().getString(R.string.list_no_more));
    }

    private void buL() {
        if (this.kZQ != null) {
            this.kZQ.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kZB.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kZB.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mm(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.kZB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cXv() {
        if (this.kZB != null) {
            TiebaStatic.log(new ao("c12406").dk("fid", this.kZB.mForumId).dk("fname", this.kZB.mForumName).dk("uid", TbadkCoreApplication.getCurrentAccount()).ag("tab_id", this.gyV));
        }
    }
}

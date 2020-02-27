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
    private PbListView eli;
    private int frP;
    private PostSearchActivity jAG;
    private BdListView jAV;
    private e jAW;
    private b jAX;
    private String jAY;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.frP = -1;
        this.jAY = "";
    }

    public PostSearchListFragment(int i) {
        this.frP = -1;
        this.jAY = "";
        this.frP = i;
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
        this.jAG = (PostSearchActivity) getBaseFragmentActivity();
        this.jAW = new e(this.jAG.getPageContext());
        this.jAW.setTabType(this.frP);
        BdListViewHelper.a(this.jAG.getActivity(), this.jAV, BdListViewHelper.HeadType.HASTAB);
        this.jAV.setAdapter((ListAdapter) this.jAW);
        this.eli = new PbListView(this.jAG.getPageContext().getPageActivity());
        this.eli.createView();
        this.jAV.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.frP == this.jAG.cAz().getCurrentTabType()) {
            cAI();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jAG != null) {
            com.baidu.tbadk.q.a.a(this.jAG.getPageContext(), this.mRootView);
        }
        if (this.eli != null) {
            this.eli.changeSkin(i);
        }
        if (this.jAW != null) {
            this.jAW.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.jAM == null || bVar.jAM.size() == 0) {
            if (!z || this.jAX == null || this.jAX.jAM == null || this.jAX.jAM.size() == 0) {
                bdr();
                showNoDataView();
                this.jAV.setVisibility(8);
                this.jAX = bVar;
                return;
            }
            if (this.jAX.gjt.aBi() == 1) {
                bdp();
                return;
            } else {
                bdq();
                return;
            }
        }
        if (!z || this.jAX == null || this.jAX.jAM == null || this.jAX.jAM.size() == 0) {
            this.jAX = bVar;
        } else {
            this.jAX.gjt = bVar.gjt;
            this.jAX.jAM.addAll(bVar.jAM);
        }
        if (z) {
            cAI();
        }
        if (this.jAX.gjt.aBi() == 1) {
            bdp();
        } else {
            bdq();
        }
        this.jAW.setData(this.jAX.jAM);
        this.jAW.notifyDataSetChanged();
        if (!z) {
            this.jAV.setSelection(0);
        }
        this.jAV.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.jAG != null) {
            String str = this.jAG.gmn;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.jAY) || z;
                if (this.jAX == null || (this.jAX != null && !this.jAX.bXL())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.jAG.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.jAG.cAy().bm(str, this.frP);
                    this.jAY = str;
                }
            }
        }
    }

    public void cAG() {
        if (this.jAX != null && this.jAX.jAM != null) {
            this.jAX.jAM.clear();
            this.jAW.setData(this.jAX.jAM);
            this.jAW.notifyDataSetChanged();
        }
        bdr();
        hideNoDataView();
    }

    private void initView() {
        this.jAV = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.jAY) && this.jAX != null && this.jAX.isHasMore() && this.jAG.cAy().bm(this.jAY, this.frP)) {
            cAH();
        }
    }

    private void cAH() {
        this.jAV.setNextPage(this.eli);
        this.eli.startLoadData();
    }

    private void bdp() {
        this.jAV.setNextPage(this.eli);
        this.eli.endLoadData();
        this.eli.setText(this.jAG.getResources().getString(R.string.pb_load_more));
    }

    private void bdq() {
        this.jAV.setNextPage(this.eli);
        this.eli.endLoadData();
        this.eli.setText(this.jAG.getResources().getString(R.string.list_no_more));
    }

    private void bdr() {
        if (this.jAV != null) {
            this.jAV.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jAG.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jAG.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.jAG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cAI() {
        if (this.jAG != null) {
            TiebaStatic.log(new an("c12406").cy("fid", this.jAG.mForumId).cy("fname", this.jAG.mForumName).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("tab_id", this.frP));
        }
    }
}

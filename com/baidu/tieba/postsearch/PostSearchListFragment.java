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
    private PbListView elj;
    private int frQ;
    private PostSearchActivity jAI;
    private BdListView jAX;
    private e jAY;
    private b jAZ;
    private String jBa;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.frQ = -1;
        this.jBa = "";
    }

    public PostSearchListFragment(int i) {
        this.frQ = -1;
        this.jBa = "";
        this.frQ = i;
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
        this.jAI = (PostSearchActivity) getBaseFragmentActivity();
        this.jAY = new e(this.jAI.getPageContext());
        this.jAY.setTabType(this.frQ);
        BdListViewHelper.a(this.jAI.getActivity(), this.jAX, BdListViewHelper.HeadType.HASTAB);
        this.jAX.setAdapter((ListAdapter) this.jAY);
        this.elj = new PbListView(this.jAI.getPageContext().getPageActivity());
        this.elj.createView();
        this.jAX.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.frQ == this.jAI.cAB().getCurrentTabType()) {
            cAK();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jAI != null) {
            com.baidu.tbadk.q.a.a(this.jAI.getPageContext(), this.mRootView);
        }
        if (this.elj != null) {
            this.elj.changeSkin(i);
        }
        if (this.jAY != null) {
            this.jAY.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.jAO == null || bVar.jAO.size() == 0) {
            if (!z || this.jAZ == null || this.jAZ.jAO == null || this.jAZ.jAO.size() == 0) {
                bdt();
                showNoDataView();
                this.jAX.setVisibility(8);
                this.jAZ = bVar;
                return;
            }
            if (this.jAZ.gjv.aBk() == 1) {
                bdr();
                return;
            } else {
                bds();
                return;
            }
        }
        if (!z || this.jAZ == null || this.jAZ.jAO == null || this.jAZ.jAO.size() == 0) {
            this.jAZ = bVar;
        } else {
            this.jAZ.gjv = bVar.gjv;
            this.jAZ.jAO.addAll(bVar.jAO);
        }
        if (z) {
            cAK();
        }
        if (this.jAZ.gjv.aBk() == 1) {
            bdr();
        } else {
            bds();
        }
        this.jAY.setData(this.jAZ.jAO);
        this.jAY.notifyDataSetChanged();
        if (!z) {
            this.jAX.setSelection(0);
        }
        this.jAX.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.jAI != null) {
            String str = this.jAI.gmp;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.jBa) || z;
                if (this.jAZ == null || (this.jAZ != null && !this.jAZ.bXN())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.jAI.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.jAI.cAA().bm(str, this.frQ);
                    this.jBa = str;
                }
            }
        }
    }

    public void cAI() {
        if (this.jAZ != null && this.jAZ.jAO != null) {
            this.jAZ.jAO.clear();
            this.jAY.setData(this.jAZ.jAO);
            this.jAY.notifyDataSetChanged();
        }
        bdt();
        hideNoDataView();
    }

    private void initView() {
        this.jAX = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.jBa) && this.jAZ != null && this.jAZ.isHasMore() && this.jAI.cAA().bm(this.jBa, this.frQ)) {
            cAJ();
        }
    }

    private void cAJ() {
        this.jAX.setNextPage(this.elj);
        this.elj.startLoadData();
    }

    private void bdr() {
        this.jAX.setNextPage(this.elj);
        this.elj.endLoadData();
        this.elj.setText(this.jAI.getResources().getString(R.string.pb_load_more));
    }

    private void bds() {
        this.jAX.setNextPage(this.elj);
        this.elj.endLoadData();
        this.elj.setText(this.jAI.getResources().getString(R.string.list_no_more));
    }

    private void bdt() {
        if (this.jAX != null) {
            this.jAX.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jAI.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jAI.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.jAI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cAK() {
        if (this.jAI != null) {
            TiebaStatic.log(new an("c12406").cy("fid", this.jAI.mForumId).cy("fname", this.jAI.mForumName).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("tab_id", this.frQ));
        }
    }
}

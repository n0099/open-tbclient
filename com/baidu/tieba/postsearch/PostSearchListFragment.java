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
    private PbListView fbY;
    private int glW;
    private BdListView kEM;
    private e kEN;
    private b kEO;
    private String kEP;
    private PostSearchActivity kEx;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.glW = -1;
        this.kEP = "";
    }

    public PostSearchListFragment(int i) {
        this.glW = -1;
        this.kEP = "";
        this.glW = i;
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
        this.kEx = (PostSearchActivity) getBaseFragmentActivity();
        this.kEN = new e(this.kEx.getPageContext());
        this.kEN.setTabType(this.glW);
        BdListViewHelper.a(this.kEx.getActivity(), this.kEM, BdListViewHelper.HeadType.HASTAB);
        this.kEM.setAdapter((ListAdapter) this.kEN);
        this.fbY = new PbListView(this.kEx.getPageContext().getPageActivity());
        this.fbY.createView();
        this.kEM.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.glW == this.kEx.cSF().getCurrentTabType()) {
            cSO();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kEx != null) {
            com.baidu.tbadk.q.a.a(this.kEx.getPageContext(), this.mRootView);
        }
        if (this.fbY != null) {
            this.fbY.changeSkin(i);
        }
        if (this.kEN != null) {
            this.kEN.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.kED == null || bVar.kED.size() == 0) {
            if (!z || this.kEO == null || this.kEO.kED == null || this.kEO.kED.size() == 0) {
                brM();
                showNoDataView();
                this.kEM.setVisibility(8);
                this.kEO = bVar;
                return;
            }
            if (this.kEO.hip.aPt() == 1) {
                brK();
                return;
            } else {
                brL();
                return;
            }
        }
        if (!z || this.kEO == null || this.kEO.kED == null || this.kEO.kED.size() == 0) {
            this.kEO = bVar;
        } else {
            this.kEO.hip = bVar.hip;
            this.kEO.kED.addAll(bVar.kED);
        }
        if (z) {
            cSO();
        }
        if (this.kEO.hip.aPt() == 1) {
            brK();
        } else {
            brL();
        }
        this.kEN.setData(this.kEO.kED);
        this.kEN.notifyDataSetChanged();
        if (!z) {
            this.kEM.setSelection(0);
        }
        this.kEM.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.kEx != null) {
            String str = this.kEx.hli;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.kEP) || z;
                if (this.kEO == null || (this.kEO != null && !this.kEO.cpd())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.kEx.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.kEx.cSE().bx(str, this.glW);
                    this.kEP = str;
                }
            }
        }
    }

    public void cSM() {
        if (this.kEO != null && this.kEO.kED != null) {
            this.kEO.kED.clear();
            this.kEN.setData(this.kEO.kED);
            this.kEN.notifyDataSetChanged();
        }
        brM();
        hideNoDataView();
    }

    private void initView() {
        this.kEM = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.kEP) && this.kEO != null && this.kEO.isHasMore() && this.kEx.cSE().bx(this.kEP, this.glW)) {
            cSN();
        }
    }

    private void cSN() {
        this.kEM.setNextPage(this.fbY);
        this.fbY.startLoadData();
    }

    private void brK() {
        this.kEM.setNextPage(this.fbY);
        this.fbY.endLoadData();
        this.fbY.setText(this.kEx.getResources().getString(R.string.pb_load_more));
    }

    private void brL() {
        this.kEM.setNextPage(this.fbY);
        this.fbY.endLoadData();
        this.fbY.setText(this.kEx.getResources().getString(R.string.list_no_more));
    }

    private void brM() {
        if (this.kEM != null) {
            this.kEM.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kEx.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kEx.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lT(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.kEx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cSO() {
        if (this.kEx != null) {
            TiebaStatic.log(new an("c12406").dh("fid", this.kEx.mForumId).dh("fname", this.kEx.mForumName).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("tab_id", this.glW));
        }
    }
}

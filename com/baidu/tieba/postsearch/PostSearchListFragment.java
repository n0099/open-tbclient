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
/* loaded from: classes23.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView giV;
    private int hBg;
    private NoDataView mNoDataView;
    private View mRootView;
    private BdListView moJ;
    private e moK;
    private b moL;
    private String moM;
    private PostSearchActivity mov;

    public PostSearchListFragment() {
        this.hBg = -1;
        this.moM = "";
    }

    public PostSearchListFragment(int i) {
        this.hBg = -1;
        this.moM = "";
        this.hBg = i;
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
        this.mov = (PostSearchActivity) getBaseFragmentActivity();
        this.moK = new e(this.mov.getPageContext());
        this.moK.setTabType(this.hBg);
        BdListViewHelper.a(this.mov.getActivity(), this.moJ, BdListViewHelper.HeadType.HASTAB);
        this.moJ.setAdapter((ListAdapter) this.moK);
        this.giV = new PbListView(this.mov.getPageContext().getPageActivity());
        this.giV.createView();
        this.moJ.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hBg == this.mov.dyb().getCurrentTabType()) {
            dyk();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mov != null) {
            com.baidu.tbadk.r.a.a(this.mov.getPageContext(), this.mRootView);
        }
        if (this.giV != null) {
            this.giV.changeSkin(i);
        }
        if (this.moK != null) {
            this.moK.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.moB == null || bVar.moB.size() == 0) {
            if (!z || this.moL == null || this.moL.moB == null || this.moL.moB.size() == 0) {
                bPp();
                showNoDataView();
                this.moJ.setVisibility(8);
                this.moL = bVar;
                return;
            }
            if (this.moL.iCY.bks() == 1) {
                Vz();
                return;
            } else {
                VA();
                return;
            }
        }
        if (!z || this.moL == null || this.moL.moB == null || this.moL.moB.size() == 0) {
            this.moL = bVar;
        } else {
            this.moL.iCY = bVar.iCY;
            this.moL.moB.addAll(bVar.moB);
        }
        if (z) {
            dyk();
        }
        if (this.moL.iCY.bks() == 1) {
            Vz();
        } else {
            VA();
        }
        this.moK.setData(this.moL.moB);
        this.moK.notifyDataSetChanged();
        if (!z) {
            this.moJ.setSelection(0);
        }
        this.moJ.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.mov != null) {
            String str = this.mov.iFR;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.moM) || z;
                if (this.moL == null || (this.moL != null && !this.moL.cUy())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mov.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mov.dya().bC(str, this.hBg);
                    this.moM = str;
                }
            }
        }
    }

    public void dyi() {
        if (this.moL != null && this.moL.moB != null) {
            this.moL.moB.clear();
            this.moK.setData(this.moL.moB);
            this.moK.notifyDataSetChanged();
        }
        bPp();
        hideNoDataView();
    }

    private void initView() {
        this.moJ = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.moM) && this.moL != null && this.moL.isHasMore() && this.mov.dya().bC(this.moM, this.hBg)) {
            dyj();
        }
    }

    private void dyj() {
        this.moJ.setNextPage(this.giV);
        this.giV.startLoadData();
    }

    private void Vz() {
        this.moJ.setNextPage(this.giV);
        this.giV.endLoadData();
        this.giV.setText(this.mov.getResources().getString(R.string.pb_load_more));
    }

    private void VA() {
        this.moJ.setNextPage(this.giV);
        this.giV.endLoadData();
        this.giV.setText(this.mov.getResources().getString(R.string.list_no_more));
    }

    private void bPp() {
        if (this.moJ != null) {
            this.moJ.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mov.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mov.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qo(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mov.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dyk() {
        if (this.mov != null) {
            TiebaStatic.log(new ar("c12406").dR("fid", this.mov.mForumId).dR("fname", this.mov.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount()).ak("tab_id", this.hBg));
        }
    }
}

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView fTv;
    private int hjG;
    private PostSearchActivity lVD;
    private BdListView lVR;
    private e lVS;
    private b lVT;
    private String lVU;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hjG = -1;
        this.lVU = "";
    }

    public PostSearchListFragment(int i) {
        this.hjG = -1;
        this.lVU = "";
        this.hjG = i;
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
        this.lVD = (PostSearchActivity) getBaseFragmentActivity();
        this.lVS = new e(this.lVD.getPageContext());
        this.lVS.setTabType(this.hjG);
        BdListViewHelper.a(this.lVD.getActivity(), this.lVR, BdListViewHelper.HeadType.HASTAB);
        this.lVR.setAdapter((ListAdapter) this.lVS);
        this.fTv = new PbListView(this.lVD.getPageContext().getPageActivity());
        this.fTv.createView();
        this.lVR.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hjG == this.lVD.dsS().getCurrentTabType()) {
            dtb();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lVD != null) {
            com.baidu.tbadk.r.a.a(this.lVD.getPageContext(), this.mRootView);
        }
        if (this.fTv != null) {
            this.fTv.changeSkin(i);
        }
        if (this.lVS != null) {
            this.lVS.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.lVJ == null || bVar.lVJ.size() == 0) {
            if (!z || this.lVT == null || this.lVT.lVJ == null || this.lVT.lVJ.size() == 0) {
                bKU();
                showNoDataView();
                this.lVR.setVisibility(8);
                this.lVT = bVar;
                return;
            }
            if (this.lVT.ijO.bgX() == 1) {
                SI();
                return;
            } else {
                SJ();
                return;
            }
        }
        if (!z || this.lVT == null || this.lVT.lVJ == null || this.lVT.lVJ.size() == 0) {
            this.lVT = bVar;
        } else {
            this.lVT.ijO = bVar.ijO;
            this.lVT.lVJ.addAll(bVar.lVJ);
        }
        if (z) {
            dtb();
        }
        if (this.lVT.ijO.bgX() == 1) {
            SI();
        } else {
            SJ();
        }
        this.lVS.setData(this.lVT.lVJ);
        this.lVS.notifyDataSetChanged();
        if (!z) {
            this.lVR.setSelection(0);
        }
        this.lVR.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.lVD != null) {
            String str = this.lVD.imJ;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.lVU) || z;
                if (this.lVT == null || (this.lVT != null && !this.lVT.cPk())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.lVD.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.lVD.dsR().bA(str, this.hjG);
                    this.lVU = str;
                }
            }
        }
    }

    public void dsZ() {
        if (this.lVT != null && this.lVT.lVJ != null) {
            this.lVT.lVJ.clear();
            this.lVS.setData(this.lVT.lVJ);
            this.lVS.notifyDataSetChanged();
        }
        bKU();
        hideNoDataView();
    }

    private void initView() {
        this.lVR = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.lVU) && this.lVT != null && this.lVT.isHasMore() && this.lVD.dsR().bA(this.lVU, this.hjG)) {
            dta();
        }
    }

    private void dta() {
        this.lVR.setNextPage(this.fTv);
        this.fTv.startLoadData();
    }

    private void SI() {
        this.lVR.setNextPage(this.fTv);
        this.fTv.endLoadData();
        this.fTv.setText(this.lVD.getResources().getString(R.string.pb_load_more));
    }

    private void SJ() {
        this.lVR.setNextPage(this.fTv);
        this.fTv.endLoadData();
        this.fTv.setText(this.lVD.getResources().getString(R.string.list_no_more));
    }

    private void bKU() {
        if (this.lVR != null) {
            this.lVR.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lVD.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lVD.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pv(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.lVD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dtb() {
        if (this.lVD != null) {
            TiebaStatic.log(new aq("c12406").dK("fid", this.lVD.mForumId).dK("fname", this.lVD.mForumName).dK("uid", TbadkCoreApplication.getCurrentAccount()).aj("tab_id", this.hjG));
        }
    }
}

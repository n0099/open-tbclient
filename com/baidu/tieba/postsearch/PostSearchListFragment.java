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
/* loaded from: classes8.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView gAw;
    private int hXb;
    private PostSearchActivity mMG;
    private BdListView mMU;
    private e mMV;
    private b mMW;
    private String mMX;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hXb = -1;
        this.mMX = "";
    }

    public PostSearchListFragment(int i) {
        this.hXb = -1;
        this.mMX = "";
        this.hXb = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mMG = (PostSearchActivity) getBaseFragmentActivity();
        this.mMV = new e(this.mMG.getPageContext());
        this.mMV.setTabType(this.hXb);
        BdListViewHelper.a(this.mMG.getActivity(), this.mMU, BdListViewHelper.HeadType.HASTAB);
        this.mMU.setAdapter((ListAdapter) this.mMV);
        this.gAw = new PbListView(this.mMG.getPageContext().getPageActivity());
        this.gAw.createView();
        this.mMU.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hXb == this.mMG.dBI().getCurrentTabType()) {
            dBR();
            by(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mMG != null) {
            com.baidu.tbadk.r.a.a(this.mMG.getPageContext(), this.mRootView);
        }
        if (this.gAw != null) {
            this.gAw.changeSkin(i);
        }
        if (this.mMV != null) {
            this.mMV.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mMM == null || bVar.mMM.size() == 0) {
            if (!z || this.mMW == null || this.mMW.mMM == null || this.mMW.mMM.size() == 0) {
                bSy();
                showNoDataView();
                this.mMU.setVisibility(8);
                this.mMW = bVar;
                return;
            }
            if (this.mMW.jbr.bmF() == 1) {
                WX();
                return;
            } else {
                WY();
                return;
            }
        }
        if (!z || this.mMW == null || this.mMW.mMM == null || this.mMW.mMM.size() == 0) {
            this.mMW = bVar;
        } else {
            this.mMW.jbr = bVar.jbr;
            this.mMW.mMM.addAll(bVar.mMM);
        }
        if (z) {
            dBR();
        }
        if (this.mMW.jbr.bmF() == 1) {
            WX();
        } else {
            WY();
        }
        this.mMV.setData(this.mMW.mMM);
        this.mMV.notifyDataSetChanged();
        if (!z) {
            this.mMU.setSelection(0);
        }
        this.mMU.setVisibility(0);
    }

    public void by(boolean z) {
        if (this.mMG != null) {
            String str = this.mMG.jel;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mMX) || z;
                if (this.mMW == null || (this.mMW != null && !this.mMW.cXL())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mMG.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mMG.dBH().bM(str, this.hXb);
                    this.mMX = str;
                }
            }
        }
    }

    public void dBP() {
        if (this.mMW != null && this.mMW.mMM != null) {
            this.mMW.mMM.clear();
            this.mMV.setData(this.mMW.mMM);
            this.mMV.notifyDataSetChanged();
        }
        bSy();
        hideNoDataView();
    }

    private void initView() {
        this.mMU = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mMX) && this.mMW != null && this.mMW.isHasMore() && this.mMG.dBH().bM(this.mMX, this.hXb)) {
            dBQ();
        }
    }

    private void dBQ() {
        this.mMU.setNextPage(this.gAw);
        this.gAw.startLoadData();
    }

    private void WX() {
        this.mMU.setNextPage(this.gAw);
        this.gAw.endLoadData();
        this.gAw.setText(this.mMG.getResources().getString(R.string.pb_load_more));
    }

    private void WY() {
        this.mMU.setNextPage(this.gAw);
        this.gAw.endLoadData();
        this.gAw.setText(this.mMG.getResources().getString(R.string.list_no_more));
    }

    private void bSy() {
        if (this.mMU != null) {
            this.mMU.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mMG.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mMG.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mMG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dBR() {
        if (this.mMG != null) {
            TiebaStatic.log(new ar("c12406").dR("fid", this.mMG.mForumId).dR("fname", this.mMG.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("tab_id", this.hXb));
        }
    }
}

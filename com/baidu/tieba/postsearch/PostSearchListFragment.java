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
    private PbListView gdy;
    private int hvC;
    private NoDataView mNoDataView;
    private View mRootView;
    private PostSearchActivity mic;
    private BdListView mis;
    private e mit;
    private b miu;
    private String miv;

    public PostSearchListFragment() {
        this.hvC = -1;
        this.miv = "";
    }

    public PostSearchListFragment(int i) {
        this.hvC = -1;
        this.miv = "";
        this.hvC = i;
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
        this.mic = (PostSearchActivity) getBaseFragmentActivity();
        this.mit = new e(this.mic.getPageContext());
        this.mit.setTabType(this.hvC);
        BdListViewHelper.a(this.mic.getActivity(), this.mis, BdListViewHelper.HeadType.HASTAB);
        this.mis.setAdapter((ListAdapter) this.mit);
        this.gdy = new PbListView(this.mic.getPageContext().getPageActivity());
        this.gdy.createView();
        this.mis.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hvC == this.mic.dvZ().getCurrentTabType()) {
            dwi();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mic != null) {
            com.baidu.tbadk.r.a.a(this.mic.getPageContext(), this.mRootView);
        }
        if (this.gdy != null) {
            this.gdy.changeSkin(i);
        }
        if (this.mit != null) {
            this.mit.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mij == null || bVar.mij.size() == 0) {
            if (!z || this.miu == null || this.miu.mij == null || this.miu.mij.size() == 0) {
                bNw();
                showNoDataView();
                this.mis.setVisibility(8);
                this.miu = bVar;
                return;
            }
            if (this.miu.iwm.biQ() == 1) {
                TI();
                return;
            } else {
                TJ();
                return;
            }
        }
        if (!z || this.miu == null || this.miu.mij == null || this.miu.mij.size() == 0) {
            this.miu = bVar;
        } else {
            this.miu.iwm = bVar.iwm;
            this.miu.mij.addAll(bVar.mij);
        }
        if (z) {
            dwi();
        }
        if (this.miu.iwm.biQ() == 1) {
            TI();
        } else {
            TJ();
        }
        this.mit.setData(this.miu.mij);
        this.mit.notifyDataSetChanged();
        if (!z) {
            this.mis.setSelection(0);
        }
        this.mis.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.mic != null) {
            String str = this.mic.izg;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.miv) || z;
                if (this.miu == null || (this.miu != null && !this.miu.cSr())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mic.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mic.dvY().bB(str, this.hvC);
                    this.miv = str;
                }
            }
        }
    }

    public void dwg() {
        if (this.miu != null && this.miu.mij != null) {
            this.miu.mij.clear();
            this.mit.setData(this.miu.mij);
            this.mit.notifyDataSetChanged();
        }
        bNw();
        hideNoDataView();
    }

    private void initView() {
        this.mis = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.miv) && this.miu != null && this.miu.isHasMore() && this.mic.dvY().bB(this.miv, this.hvC)) {
            dwh();
        }
    }

    private void dwh() {
        this.mis.setNextPage(this.gdy);
        this.gdy.startLoadData();
    }

    private void TI() {
        this.mis.setNextPage(this.gdy);
        this.gdy.endLoadData();
        this.gdy.setText(this.mic.getResources().getString(R.string.pb_load_more));
    }

    private void TJ() {
        this.mis.setNextPage(this.gdy);
        this.gdy.endLoadData();
        this.gdy.setText(this.mic.getResources().getString(R.string.list_no_more));
    }

    private void bNw() {
        if (this.mis != null) {
            this.mis.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mic.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mic.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pG(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mic.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dwi() {
        if (this.mic != null) {
            TiebaStatic.log(new aq("c12406").dR("fid", this.mic.mForumId).dR("fname", this.mic.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount()).aj("tab_id", this.hvC));
        }
    }
}

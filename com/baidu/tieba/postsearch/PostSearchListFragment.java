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
    private PbListView gjo;
    private int hBz;
    private NoDataView mNoDataView;
    private View mRootView;
    private PostSearchActivity moa;
    private BdListView mop;
    private e moq;
    private b mor;
    private String mos;

    public PostSearchListFragment() {
        this.hBz = -1;
        this.mos = "";
    }

    public PostSearchListFragment(int i) {
        this.hBz = -1;
        this.mos = "";
        this.hBz = i;
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
        this.moa = (PostSearchActivity) getBaseFragmentActivity();
        this.moq = new e(this.moa.getPageContext());
        this.moq.setTabType(this.hBz);
        BdListViewHelper.a(this.moa.getActivity(), this.mop, BdListViewHelper.HeadType.HASTAB);
        this.mop.setAdapter((ListAdapter) this.moq);
        this.gjo = new PbListView(this.moa.getPageContext().getPageActivity());
        this.gjo.createView();
        this.mop.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hBz == this.moa.dyB().getCurrentTabType()) {
            dyK();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.moa != null) {
            com.baidu.tbadk.r.a.a(this.moa.getPageContext(), this.mRootView);
        }
        if (this.gjo != null) {
            this.gjo.changeSkin(i);
        }
        if (this.moq != null) {
            this.moq.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mog == null || bVar.mog.size() == 0) {
            if (!z || this.mor == null || this.mor.mog == null || this.mor.mog.size() == 0) {
                bPW();
                showNoDataView();
                this.mop.setVisibility(8);
                this.mor = bVar;
                return;
            }
            if (this.mor.iCj.blq() == 1) {
                Wi();
                return;
            } else {
                Wj();
                return;
            }
        }
        if (!z || this.mor == null || this.mor.mog == null || this.mor.mog.size() == 0) {
            this.mor = bVar;
        } else {
            this.mor.iCj = bVar.iCj;
            this.mor.mog.addAll(bVar.mog);
        }
        if (z) {
            dyK();
        }
        if (this.mor.iCj.blq() == 1) {
            Wi();
        } else {
            Wj();
        }
        this.moq.setData(this.mor.mog);
        this.moq.notifyDataSetChanged();
        if (!z) {
            this.mop.setSelection(0);
        }
        this.mop.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.moa != null) {
            String str = this.moa.iFd;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mos) || z;
                if (this.mor == null || (this.mor != null && !this.mor.cUS())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.moa.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.moa.dyA().bD(str, this.hBz);
                    this.mos = str;
                }
            }
        }
    }

    public void dyI() {
        if (this.mor != null && this.mor.mog != null) {
            this.mor.mog.clear();
            this.moq.setData(this.mor.mog);
            this.moq.notifyDataSetChanged();
        }
        bPW();
        hideNoDataView();
    }

    private void initView() {
        this.mop = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mos) && this.mor != null && this.mor.isHasMore() && this.moa.dyA().bD(this.mos, this.hBz)) {
            dyJ();
        }
    }

    private void dyJ() {
        this.mop.setNextPage(this.gjo);
        this.gjo.startLoadData();
    }

    private void Wi() {
        this.mop.setNextPage(this.gjo);
        this.gjo.endLoadData();
        this.gjo.setText(this.moa.getResources().getString(R.string.pb_load_more));
    }

    private void Wj() {
        this.mop.setNextPage(this.gjo);
        this.gjo.endLoadData();
        this.gjo.setText(this.moa.getResources().getString(R.string.list_no_more));
    }

    private void bPW() {
        if (this.mop != null) {
            this.mop.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.moa.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.moa.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pQ(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.moa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dyK() {
        if (this.moa != null) {
            TiebaStatic.log(new aq("c12406").dR("fid", this.moa.mForumId).dR("fname", this.moa.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount()).al("tab_id", this.hBz));
        }
    }
}

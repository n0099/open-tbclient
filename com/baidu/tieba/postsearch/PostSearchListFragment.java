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
    private PbListView fcj;
    private int gmh;
    private PostSearchActivity kFF;
    private BdListView kFU;
    private e kFV;
    private b kFW;
    private String kFX;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.gmh = -1;
        this.kFX = "";
    }

    public PostSearchListFragment(int i) {
        this.gmh = -1;
        this.kFX = "";
        this.gmh = i;
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
        this.kFF = (PostSearchActivity) getBaseFragmentActivity();
        this.kFV = new e(this.kFF.getPageContext());
        this.kFV.setTabType(this.gmh);
        BdListViewHelper.a(this.kFF.getActivity(), this.kFU, BdListViewHelper.HeadType.HASTAB);
        this.kFU.setAdapter((ListAdapter) this.kFV);
        this.fcj = new PbListView(this.kFF.getPageContext().getPageActivity());
        this.fcj.createView();
        this.kFU.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.gmh == this.kFF.cSV().getCurrentTabType()) {
            cTe();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kFF != null) {
            com.baidu.tbadk.q.a.a(this.kFF.getPageContext(), this.mRootView);
        }
        if (this.fcj != null) {
            this.fcj.changeSkin(i);
        }
        if (this.kFV != null) {
            this.kFV.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.kFL == null || bVar.kFL.size() == 0) {
            if (!z || this.kFW == null || this.kFW.kFL == null || this.kFW.kFL.size() == 0) {
                brO();
                showNoDataView();
                this.kFU.setVisibility(8);
                this.kFW = bVar;
                return;
            }
            if (this.kFW.hiA.aPt() == 1) {
                brM();
                return;
            } else {
                brN();
                return;
            }
        }
        if (!z || this.kFW == null || this.kFW.kFL == null || this.kFW.kFL.size() == 0) {
            this.kFW = bVar;
        } else {
            this.kFW.hiA = bVar.hiA;
            this.kFW.kFL.addAll(bVar.kFL);
        }
        if (z) {
            cTe();
        }
        if (this.kFW.hiA.aPt() == 1) {
            brM();
        } else {
            brN();
        }
        this.kFV.setData(this.kFW.kFL);
        this.kFV.notifyDataSetChanged();
        if (!z) {
            this.kFU.setSelection(0);
        }
        this.kFU.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.kFF != null) {
            String str = this.kFF.hlt;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.kFX) || z;
                if (this.kFW == null || (this.kFW != null && !this.kFW.cpm())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.kFF.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.kFF.cSU().bx(str, this.gmh);
                    this.kFX = str;
                }
            }
        }
    }

    public void cTc() {
        if (this.kFW != null && this.kFW.kFL != null) {
            this.kFW.kFL.clear();
            this.kFV.setData(this.kFW.kFL);
            this.kFV.notifyDataSetChanged();
        }
        brO();
        hideNoDataView();
    }

    private void initView() {
        this.kFU = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.kFX) && this.kFW != null && this.kFW.isHasMore() && this.kFF.cSU().bx(this.kFX, this.gmh)) {
            cTd();
        }
    }

    private void cTd() {
        this.kFU.setNextPage(this.fcj);
        this.fcj.startLoadData();
    }

    private void brM() {
        this.kFU.setNextPage(this.fcj);
        this.fcj.endLoadData();
        this.fcj.setText(this.kFF.getResources().getString(R.string.pb_load_more));
    }

    private void brN() {
        this.kFU.setNextPage(this.fcj);
        this.fcj.endLoadData();
        this.fcj.setText(this.kFF.getResources().getString(R.string.list_no_more));
    }

    private void brO() {
        if (this.kFU != null) {
            this.kFU.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kFF.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kFF.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lV(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.kFF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cTe() {
        if (this.kFF != null) {
            TiebaStatic.log(new an("c12406").dh("fid", this.kFF.mForumId).dh("fname", this.kFF.mForumName).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("tab_id", this.gmh));
        }
    }
}

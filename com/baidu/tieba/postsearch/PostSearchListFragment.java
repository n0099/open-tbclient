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
/* loaded from: classes7.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView gCf;
    private int hYK;
    private NoDataView mNoDataView;
    private PostSearchActivity mOI;
    private BdListView mOW;
    private e mOX;
    private b mOY;
    private String mOZ;
    private View mRootView;

    public PostSearchListFragment() {
        this.hYK = -1;
        this.mOZ = "";
    }

    public PostSearchListFragment(int i) {
        this.hYK = -1;
        this.mOZ = "";
        this.hYK = i;
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
        this.mOI = (PostSearchActivity) getBaseFragmentActivity();
        this.mOX = new e(this.mOI.getPageContext());
        this.mOX.setTabType(this.hYK);
        BdListViewHelper.a(this.mOI.getActivity(), this.mOW, BdListViewHelper.HeadType.HASTAB);
        this.mOW.setAdapter((ListAdapter) this.mOX);
        this.gCf = new PbListView(this.mOI.getPageContext().getPageActivity());
        this.gCf.createView();
        this.mOW.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hYK == this.mOI.dBQ().getCurrentTabType()) {
            dBZ();
            by(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mOI != null) {
            com.baidu.tbadk.r.a.a(this.mOI.getPageContext(), this.mRootView);
        }
        if (this.gCf != null) {
            this.gCf.changeSkin(i);
        }
        if (this.mOX != null) {
            this.mOX.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mOO == null || bVar.mOO.size() == 0) {
            if (!z || this.mOY == null || this.mOY.mOO == null || this.mOY.mOO.size() == 0) {
                bSE();
                showNoDataView();
                this.mOW.setVisibility(8);
                this.mOY = bVar;
                return;
            }
            if (this.mOY.jda.bmH() == 1) {
                Xa();
                return;
            } else {
                Xb();
                return;
            }
        }
        if (!z || this.mOY == null || this.mOY.mOO == null || this.mOY.mOO.size() == 0) {
            this.mOY = bVar;
        } else {
            this.mOY.jda = bVar.jda;
            this.mOY.mOO.addAll(bVar.mOO);
        }
        if (z) {
            dBZ();
        }
        if (this.mOY.jda.bmH() == 1) {
            Xa();
        } else {
            Xb();
        }
        this.mOX.setData(this.mOY.mOO);
        this.mOX.notifyDataSetChanged();
        if (!z) {
            this.mOW.setSelection(0);
        }
        this.mOW.setVisibility(0);
    }

    public void by(boolean z) {
        if (this.mOI != null) {
            String str = this.mOI.jfU;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mOZ) || z;
                if (this.mOY == null || (this.mOY != null && !this.mOY.cXS())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mOI.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mOI.dBP().bM(str, this.hYK);
                    this.mOZ = str;
                }
            }
        }
    }

    public void dBX() {
        if (this.mOY != null && this.mOY.mOO != null) {
            this.mOY.mOO.clear();
            this.mOX.setData(this.mOY.mOO);
            this.mOX.notifyDataSetChanged();
        }
        bSE();
        hideNoDataView();
    }

    private void initView() {
        this.mOW = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mOZ) && this.mOY != null && this.mOY.isHasMore() && this.mOI.dBP().bM(this.mOZ, this.hYK)) {
            dBY();
        }
    }

    private void dBY() {
        this.mOW.setNextPage(this.gCf);
        this.gCf.startLoadData();
    }

    private void Xa() {
        this.mOW.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.setText(this.mOI.getResources().getString(R.string.pb_load_more));
    }

    private void Xb() {
        this.mOW.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.setText(this.mOI.getResources().getString(R.string.list_no_more));
    }

    private void bSE() {
        if (this.mOW != null) {
            this.mOW.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mOI.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mOI.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pA(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mOI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dBZ() {
        if (this.mOI != null) {
            TiebaStatic.log(new ar("c12406").dR("fid", this.mOI.mForumId).dR("fname", this.mOI.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount()).aq("tab_id", this.hYK));
        }
    }
}

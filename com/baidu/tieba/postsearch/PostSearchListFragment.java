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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView bOy;
    private int cCZ;
    private PostSearchActivity gGT;
    private BdListView gHi;
    private e gHj;
    private b gHk;
    private String gHl;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cCZ = -1;
        this.gHl = "";
    }

    public PostSearchListFragment(int i) {
        this.cCZ = -1;
        this.gHl = "";
        this.cCZ = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(e.h.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gGT = (PostSearchActivity) getBaseFragmentActivity();
        this.gHj = new e(this.gGT.getPageContext());
        this.gHj.setTabType(this.cCZ);
        BdListViewHelper.a(this.gGT.getActivity(), this.gHi, BdListViewHelper.HeadType.HASTAB);
        this.gHi.setAdapter((ListAdapter) this.gHj);
        this.bOy = new PbListView(this.gGT.getPageContext().getPageActivity());
        this.bOy.oD();
        this.gHi.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cCZ == this.gGT.bsX().getCurrentTabType()) {
            btg();
            mH(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGT != null) {
            com.baidu.tbadk.o.a.a(this.gGT.getPageContext(), this.mRootView);
        }
        if (this.bOy != null) {
            this.bOy.ey(i);
        }
        if (this.gHj != null) {
            this.gHj.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gHa == null || bVar.gHa.size() == 0) {
            if (!z || this.gHk == null || this.gHk.gHa == null || this.gHk.gHa.size() == 0) {
                abb();
                showNoDataView();
                this.gHi.setVisibility(8);
                this.gHk = bVar;
                return;
            }
            if (this.gHk.dDy.yP() == 1) {
                aaZ();
                return;
            } else {
                aba();
                return;
            }
        }
        if (!z || this.gHk == null || this.gHk.gHa == null || this.gHk.gHa.size() == 0) {
            this.gHk = bVar;
        } else {
            this.gHk.dDy = bVar.dDy;
            this.gHk.gHa.addAll(bVar.gHa);
        }
        if (z) {
            btg();
        }
        if (this.gHk.dDy.yP() == 1) {
            aaZ();
        } else {
            aba();
        }
        this.gHj.clear();
        this.gHj.dA(this.gHk.gHa);
        this.gHj.notifyDataSetChanged();
        if (!z) {
            this.gHi.setSelection(0);
        }
        this.gHi.setVisibility(0);
    }

    public void mH(boolean z) {
        if (this.gGT != null) {
            String str = this.gGT.dGt;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gHl) || z;
                if (this.gHk == null || (this.gHk != null && !this.gHk.aTV())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gGT.getResources().getDimensionPixelSize(e.C0210e.ds320));
                    this.gGT.bsW().aO(str, this.cCZ);
                    this.gHl = str;
                }
            }
        }
    }

    public void bte() {
        if (this.gHk != null && this.gHk.gHa != null) {
            this.gHk.gHa.clear();
            this.gHj.clear();
            this.gHj.dA(this.gHk.gHa);
            this.gHj.notifyDataSetChanged();
        }
        abb();
        hideNoDataView();
    }

    private void initView() {
        this.gHi = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gHl) && this.gHk != null && this.gHk.isHasMore() && this.gGT.bsW().aO(this.gHl, this.cCZ)) {
            btf();
        }
    }

    private void btf() {
        this.gHi.setNextPage(this.bOy);
        this.bOy.Fc();
    }

    private void aaZ() {
        this.gHi.setNextPage(this.bOy);
        this.bOy.Fd();
        this.bOy.setText(this.gGT.getResources().getString(e.j.pb_load_more));
    }

    private void aba() {
        this.gHi.setNextPage(this.bOy);
        this.bOy.Fd();
        this.bOy.setText(this.gGT.getResources().getString(e.j.list_no_more));
    }

    private void abb() {
        if (this.gHi != null) {
            this.gHi.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gGT.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gGT.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gGT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void btg() {
        if (this.gGT != null) {
            TiebaStatic.log(new am("c12406").aA(ImageViewerConfig.FORUM_ID, this.gGT.mForumId).aA(ImageViewerConfig.FORUM_NAME, this.gGT.mForumName).aA("uid", TbadkCoreApplication.getCurrentAccount()).x(MyBookrackActivityConfig.TAB_ID, this.cCZ));
        }
    }
}

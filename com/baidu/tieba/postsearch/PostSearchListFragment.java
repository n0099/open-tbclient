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
    private PbListView bOB;
    private int cDZ;
    private PostSearchActivity gJK;
    private BdListView gJZ;
    private e gKa;
    private b gKb;
    private String gKc;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.cDZ = -1;
        this.gKc = "";
    }

    public PostSearchListFragment(int i) {
        this.cDZ = -1;
        this.gKc = "";
        this.cDZ = i;
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
        this.gJK = (PostSearchActivity) getBaseFragmentActivity();
        this.gKa = new e(this.gJK.getPageContext());
        this.gKa.setTabType(this.cDZ);
        BdListViewHelper.a(this.gJK.getActivity(), this.gJZ, BdListViewHelper.HeadType.HASTAB);
        this.gJZ.setAdapter((ListAdapter) this.gKa);
        this.bOB = new PbListView(this.gJK.getPageContext().getPageActivity());
        this.bOB.oD();
        this.gJZ.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.cDZ == this.gJK.btJ().getCurrentTabType()) {
            btS();
            mK(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gJK != null) {
            com.baidu.tbadk.o.a.a(this.gJK.getPageContext(), this.mRootView);
        }
        if (this.bOB != null) {
            this.bOB.ey(i);
        }
        if (this.gKa != null) {
            this.gKa.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.gJR == null || bVar.gJR.size() == 0) {
            if (!z || this.gKb == null || this.gKb.gJR == null || this.gKb.gJR.size() == 0) {
                abd();
                showNoDataView();
                this.gJZ.setVisibility(8);
                this.gKb = bVar;
                return;
            }
            if (this.gKb.dGm.yP() == 1) {
                abb();
                return;
            } else {
                abc();
                return;
            }
        }
        if (!z || this.gKb == null || this.gKb.gJR == null || this.gKb.gJR.size() == 0) {
            this.gKb = bVar;
        } else {
            this.gKb.dGm = bVar.dGm;
            this.gKb.gJR.addAll(bVar.gJR);
        }
        if (z) {
            btS();
        }
        if (this.gKb.dGm.yP() == 1) {
            abb();
        } else {
            abc();
        }
        this.gKa.clear();
        this.gKa.dB(this.gKb.gJR);
        this.gKa.notifyDataSetChanged();
        if (!z) {
            this.gJZ.setSelection(0);
        }
        this.gJZ.setVisibility(0);
    }

    public void mK(boolean z) {
        if (this.gJK != null) {
            String str = this.gJK.dJh;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.gKc) || z;
                if (this.gKb == null || (this.gKb != null && !this.gKb.aUJ())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.gJK.getResources().getDimensionPixelSize(e.C0210e.ds320));
                    this.gJK.btI().aP(str, this.cDZ);
                    this.gKc = str;
                }
            }
        }
    }

    public void btQ() {
        if (this.gKb != null && this.gKb.gJR != null) {
            this.gKb.gJR.clear();
            this.gKa.clear();
            this.gKa.dB(this.gKb.gJR);
            this.gKa.notifyDataSetChanged();
        }
        abd();
        hideNoDataView();
    }

    private void initView() {
        this.gJZ = (BdListView) this.mRootView.findViewById(e.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.gKc) && this.gKb != null && this.gKb.isHasMore() && this.gJK.btI().aP(this.gKc, this.cDZ)) {
            btR();
        }
    }

    private void btR() {
        this.gJZ.setNextPage(this.bOB);
        this.bOB.Fc();
    }

    private void abb() {
        this.gJZ.setNextPage(this.bOB);
        this.bOB.Fd();
        this.bOB.setText(this.gJK.getResources().getString(e.j.pb_load_more));
    }

    private void abc() {
        this.gJZ.setNextPage(this.bOB);
        this.bOB.Fd();
        this.bOB.setText(this.gJK.getResources().getString(e.j.list_no_more));
    }

    private void abd() {
        if (this.gJZ != null) {
            this.gJZ.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gJK.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gJK.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.gJK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void btS() {
        if (this.gJK != null) {
            TiebaStatic.log(new am("c12406").aA(ImageViewerConfig.FORUM_ID, this.gJK.mForumId).aA(ImageViewerConfig.FORUM_NAME, this.gJK.mForumName).aA("uid", TbadkCoreApplication.getCurrentAccount()).x(MyBookrackActivityConfig.TAB_ID, this.cDZ));
        }
    }
}

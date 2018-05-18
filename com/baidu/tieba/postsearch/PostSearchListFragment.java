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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private int bXL;
    private PbListView blq;
    private PostSearchActivity fTT;
    private BdListView fUj;
    private e fUk;
    private b fUl;
    private String fUm;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.bXL = -1;
        this.fUm = "";
    }

    public PostSearchListFragment(int i) {
        this.bXL = -1;
        this.fUm = "";
        this.bXL = i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(d.i.post_search_list_fragment, (ViewGroup) null);
        initView();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fTT = (PostSearchActivity) getBaseFragmentActivity();
        this.fUk = new e(this.fTT.getPageContext());
        this.fUk.setTabType(this.bXL);
        BdListViewHelper.a(this.fTT.getActivity(), this.fUj, BdListViewHelper.HeadType.HASTAB);
        this.fUj.setAdapter((ListAdapter) this.fUk);
        this.blq = new PbListView(this.fTT.getPageContext().getPageActivity());
        this.blq.kz();
        this.fUj.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.bXL == this.fTT.bhW().getCurrentTabType()) {
            bif();
            lB(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fTT != null) {
            com.baidu.tbadk.n.a.a(this.fTT.getPageContext(), this.mRootView);
        }
        if (this.blq != null) {
            this.blq.dw(i);
        }
        if (this.fUk != null) {
            this.fUk.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.fUa == null || bVar.fUa.size() == 0) {
            if (!z || this.fUl == null || this.fUl.fUa == null || this.fUl.fUa.size() == 0) {
                Qn();
                showNoDataView();
                this.fUj.setVisibility(8);
                this.fUl = bVar;
                return;
            }
            if (this.fUl.fUb.rb() == 1) {
                Ql();
                return;
            } else {
                Qm();
                return;
            }
        }
        if (!z || this.fUl == null || this.fUl.fUa == null || this.fUl.fUa.size() == 0) {
            this.fUl = bVar;
        } else {
            this.fUl.fUb = bVar.fUb;
            this.fUl.fUa.addAll(bVar.fUa);
        }
        if (z) {
            bif();
        }
        if (this.fUl.fUb.rb() == 1) {
            Ql();
        } else {
            Qm();
        }
        this.fUk.clear();
        this.fUk.de(this.fUl.fUa);
        this.fUk.notifyDataSetChanged();
        if (!z) {
            this.fUj.setSelection(0);
        }
        this.fUj.setVisibility(0);
    }

    public void lB(boolean z) {
        if (this.fTT != null) {
            String str = this.fTT.cWR;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.fUm) || z;
                if (this.fUl == null || (this.fUl != null && !this.fUl.aGG())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.fTT.getResources().getDimensionPixelSize(d.e.ds320));
                    this.fTT.bhV().aE(str, this.bXL);
                    this.fUm = str;
                }
            }
        }
    }

    public void bid() {
        if (this.fUl != null && this.fUl.fUa != null) {
            this.fUl.fUa.clear();
            this.fUk.clear();
            this.fUk.de(this.fUl.fUa);
            this.fUk.notifyDataSetChanged();
        }
        Qn();
        hideNoDataView();
    }

    private void initView() {
        this.fUj = (BdListView) this.mRootView.findViewById(d.g.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.fUm) && this.fUl != null && this.fUl.isHasMore() && this.fTT.bhV().aE(this.fUm, this.bXL)) {
            bie();
        }
    }

    private void bie() {
        this.fUj.setNextPage(this.blq);
        this.blq.wQ();
    }

    private void Ql() {
        this.fUj.setNextPage(this.blq);
        this.blq.wR();
        this.blq.setText(this.fTT.getResources().getString(d.k.pb_load_more));
    }

    private void Qm() {
        this.fUj.setNextPage(this.blq);
        this.blq.wR();
        this.blq.setText(this.fTT.getResources().getString(d.k.list_no_more));
    }

    private void Qn() {
        if (this.fUj != null) {
            this.fUj.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fTT.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fTT.getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.k.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.fTT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void bif() {
        if (this.fTT != null) {
            TiebaStatic.log(new al("c12406").ac(ImageViewerConfig.FORUM_ID, this.fTT.mForumId).ac(ImageViewerConfig.FORUM_NAME, this.fTT.mForumName).ac("uid", TbadkCoreApplication.getCurrentAccount()).r(MyBookrackActivityConfig.TAB_ID, this.bXL));
        }
    }
}

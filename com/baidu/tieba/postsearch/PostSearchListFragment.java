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
    private PbListView elw;
    private int fsd;
    private PostSearchActivity jAU;
    private BdListView jBj;
    private e jBk;
    private b jBl;
    private String jBm;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.fsd = -1;
        this.jBm = "";
    }

    public PostSearchListFragment(int i) {
        this.fsd = -1;
        this.jBm = "";
        this.fsd = i;
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
        this.jAU = (PostSearchActivity) getBaseFragmentActivity();
        this.jBk = new e(this.jAU.getPageContext());
        this.jBk.setTabType(this.fsd);
        BdListViewHelper.a(this.jAU.getActivity(), this.jBj, BdListViewHelper.HeadType.HASTAB);
        this.jBj.setAdapter((ListAdapter) this.jBk);
        this.elw = new PbListView(this.jAU.getPageContext().getPageActivity());
        this.elw.createView();
        this.jBj.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fsd == this.jAU.cAC().getCurrentTabType()) {
            cAL();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jAU != null) {
            com.baidu.tbadk.q.a.a(this.jAU.getPageContext(), this.mRootView);
        }
        if (this.elw != null) {
            this.elw.changeSkin(i);
        }
        if (this.jBk != null) {
            this.jBk.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.jBa == null || bVar.jBa.size() == 0) {
            if (!z || this.jBl == null || this.jBl.jBa == null || this.jBl.jBa.size() == 0) {
                bdu();
                showNoDataView();
                this.jBj.setVisibility(8);
                this.jBl = bVar;
                return;
            }
            if (this.jBl.gjI.aBk() == 1) {
                bds();
                return;
            } else {
                bdt();
                return;
            }
        }
        if (!z || this.jBl == null || this.jBl.jBa == null || this.jBl.jBa.size() == 0) {
            this.jBl = bVar;
        } else {
            this.jBl.gjI = bVar.gjI;
            this.jBl.jBa.addAll(bVar.jBa);
        }
        if (z) {
            cAL();
        }
        if (this.jBl.gjI.aBk() == 1) {
            bds();
        } else {
            bdt();
        }
        this.jBk.setData(this.jBl.jBa);
        this.jBk.notifyDataSetChanged();
        if (!z) {
            this.jBj.setSelection(0);
        }
        this.jBj.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.jAU != null) {
            String str = this.jAU.gmC;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.jBm) || z;
                if (this.jBl == null || (this.jBl != null && !this.jBl.bXO())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.jAU.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.jAU.cAB().bm(str, this.fsd);
                    this.jBm = str;
                }
            }
        }
    }

    public void cAJ() {
        if (this.jBl != null && this.jBl.jBa != null) {
            this.jBl.jBa.clear();
            this.jBk.setData(this.jBl.jBa);
            this.jBk.notifyDataSetChanged();
        }
        bdu();
        hideNoDataView();
    }

    private void initView() {
        this.jBj = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.jBm) && this.jBl != null && this.jBl.isHasMore() && this.jAU.cAB().bm(this.jBm, this.fsd)) {
            cAK();
        }
    }

    private void cAK() {
        this.jBj.setNextPage(this.elw);
        this.elw.startLoadData();
    }

    private void bds() {
        this.jBj.setNextPage(this.elw);
        this.elw.endLoadData();
        this.elw.setText(this.jAU.getResources().getString(R.string.pb_load_more));
    }

    private void bdt() {
        this.jBj.setNextPage(this.elw);
        this.elw.endLoadData();
        this.elw.setText(this.jAU.getResources().getString(R.string.list_no_more));
    }

    private void bdu() {
        if (this.jBj != null) {
            this.jBj.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jAU.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jAU.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.jAU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void cAL() {
        if (this.jAU != null) {
            TiebaStatic.log(new an("c12406").cy("fid", this.jAU.mForumId).cy("fname", this.jAU.mForumName).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("tab_id", this.fsd));
        }
    }
}

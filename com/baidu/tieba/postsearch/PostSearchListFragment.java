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
/* loaded from: classes7.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView gxy;
    private int hSs;
    private BdListView mDA;
    private e mDB;
    private b mDC;
    private String mDD;
    private PostSearchActivity mDk;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.hSs = -1;
        this.mDD = "";
    }

    public PostSearchListFragment(int i) {
        this.hSs = -1;
        this.mDD = "";
        this.hSs = i;
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
        this.mDk = (PostSearchActivity) getBaseFragmentActivity();
        this.mDB = new e(this.mDk.getPageContext());
        this.mDB.setTabType(this.hSs);
        BdListViewHelper.a(this.mDk.getActivity(), this.mDA, BdListViewHelper.HeadType.HASTAB);
        this.mDA.setAdapter((ListAdapter) this.mDB);
        this.gxy = new PbListView(this.mDk.getPageContext().getPageActivity());
        this.gxy.createView();
        this.mDA.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.hSs == this.mDk.dzr().getCurrentTabType()) {
            dzA();
            bt(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mDk != null) {
            com.baidu.tbadk.r.a.a(this.mDk.getPageContext(), this.mRootView);
        }
        if (this.gxy != null) {
            this.gxy.changeSkin(i);
        }
        if (this.mDB != null) {
            this.mDB.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.mDq == null || bVar.mDq.size() == 0) {
            if (!z || this.mDC == null || this.mDC.mDq == null || this.mDC.mDq.size() == 0) {
                bRO();
                showNoDataView();
                this.mDA.setVisibility(8);
                this.mDC = bVar;
                return;
            }
            if (this.mDC.iVw.bmm() == 1) {
                Vo();
                return;
            } else {
                Vp();
                return;
            }
        }
        if (!z || this.mDC == null || this.mDC.mDq == null || this.mDC.mDq.size() == 0) {
            this.mDC = bVar;
        } else {
            this.mDC.iVw = bVar.iVw;
            this.mDC.mDq.addAll(bVar.mDq);
        }
        if (z) {
            dzA();
        }
        if (this.mDC.iVw.bmm() == 1) {
            Vo();
        } else {
            Vp();
        }
        this.mDB.setData(this.mDC.mDq);
        this.mDB.notifyDataSetChanged();
        if (!z) {
            this.mDA.setSelection(0);
        }
        this.mDA.setVisibility(0);
    }

    public void bt(boolean z) {
        if (this.mDk != null) {
            String str = this.mDk.iYq;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.mDD) || z;
                if (this.mDC == null || (this.mDC != null && !this.mDC.cVG())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.mDk.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.mDk.dzq().bL(str, this.hSs);
                    this.mDD = str;
                }
            }
        }
    }

    public void dzy() {
        if (this.mDC != null && this.mDC.mDq != null) {
            this.mDC.mDq.clear();
            this.mDB.setData(this.mDC.mDq);
            this.mDB.notifyDataSetChanged();
        }
        bRO();
        hideNoDataView();
    }

    private void initView() {
        this.mDA = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.mDD) && this.mDC != null && this.mDC.isHasMore() && this.mDk.dzq().bL(this.mDD, this.hSs)) {
            dzz();
        }
    }

    private void dzz() {
        this.mDA.setNextPage(this.gxy);
        this.gxy.startLoadData();
    }

    private void Vo() {
        this.mDA.setNextPage(this.gxy);
        this.gxy.endLoadData();
        this.gxy.setText(this.mDk.getResources().getString(R.string.pb_load_more));
    }

    private void Vp() {
        this.mDA.setNextPage(this.gxy);
        this.gxy.endLoadData();
        this.gxy.setText(this.mDk.getResources().getString(R.string.list_no_more));
    }

    private void bRO() {
        if (this.mDA != null) {
            this.mDA.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mDk.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mDk.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pu(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.mDk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void dzA() {
        if (this.mDk != null) {
            TiebaStatic.log(new aq("c12406").dW("fid", this.mDk.mForumId).dW("fname", this.mDk.mForumName).dW("uid", TbadkCoreApplication.getCurrentAccount()).an("tab_id", this.hSs));
        }
    }
}

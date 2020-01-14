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
/* loaded from: classes9.dex */
public class PostSearchListFragment extends BaseFragment implements BdListView.e {
    private PbListView ehe;
    private int fpl;
    private BdListView jAf;
    private e jAg;
    private b jAh;
    private String jAi;
    private PostSearchActivity jzQ;
    private NoDataView mNoDataView;
    private View mRootView;

    public PostSearchListFragment() {
        this.fpl = -1;
        this.jAi = "";
    }

    public PostSearchListFragment(int i) {
        this.fpl = -1;
        this.jAi = "";
        this.fpl = i;
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
        this.jzQ = (PostSearchActivity) getBaseFragmentActivity();
        this.jAg = new e(this.jzQ.getPageContext());
        this.jAg.setTabType(this.fpl);
        BdListViewHelper.a(this.jzQ.getActivity(), this.jAf, BdListViewHelper.HeadType.HASTAB);
        this.jAf.setAdapter((ListAdapter) this.jAg);
        this.ehe = new PbListView(this.jzQ.getPageContext().getPageActivity());
        this.ehe.createView();
        this.jAf.setOnSrollToBottomListener(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.fpl == this.jzQ.cze().getCurrentTabType()) {
            czn();
            requestData(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jzQ != null) {
            com.baidu.tbadk.q.a.a(this.jzQ.getPageContext(), this.mRootView);
        }
        if (this.ehe != null) {
            this.ehe.changeSkin(i);
        }
        if (this.jAg != null) {
            this.jAg.notifyDataSetChanged();
        }
    }

    public void a(b bVar, boolean z) {
        hideNoDataView();
        hideLoadingView(this.mRootView);
        if (bVar == null || bVar.jzW == null || bVar.jzW.size() == 0) {
            if (!z || this.jAh == null || this.jAh.jzW == null || this.jAh.jzW.size() == 0) {
                bbc();
                showNoDataView();
                this.jAf.setVisibility(8);
                this.jAh = bVar;
                return;
            }
            if (this.jAh.ghs.ayR() == 1) {
                bba();
                return;
            } else {
                bbb();
                return;
            }
        }
        if (!z || this.jAh == null || this.jAh.jzW == null || this.jAh.jzW.size() == 0) {
            this.jAh = bVar;
        } else {
            this.jAh.ghs = bVar.ghs;
            this.jAh.jzW.addAll(bVar.jzW);
        }
        if (z) {
            czn();
        }
        if (this.jAh.ghs.ayR() == 1) {
            bba();
        } else {
            bbb();
        }
        this.jAg.clear();
        this.jAg.ed(this.jAh.jzW);
        this.jAg.notifyDataSetChanged();
        if (!z) {
            this.jAf.setSelection(0);
        }
        this.jAf.setVisibility(0);
    }

    public void requestData(boolean z) {
        if (this.jzQ != null) {
            String str = this.jzQ.gkm;
            if (!StringUtils.isNull(str)) {
                boolean z2 = !str.equals(this.jAi) || z;
                if (this.jAh == null || (this.jAh != null && !this.jAh.bWk())) {
                    z2 = true;
                }
                if (z2) {
                    showLoadingView(this.mRootView, false, this.jzQ.getResources().getDimensionPixelSize(R.dimen.ds320));
                    this.jzQ.czd().bo(str, this.fpl);
                    this.jAi = str;
                }
            }
        }
    }

    public void czl() {
        if (this.jAh != null && this.jAh.jzW != null) {
            this.jAh.jzW.clear();
            this.jAg.clear();
            this.jAg.ed(this.jAh.jzW);
            this.jAg.notifyDataSetChanged();
        }
        bbc();
        hideNoDataView();
    }

    private void initView() {
        this.jAf = (BdListView) this.mRootView.findViewById(R.id.result_list);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!StringUtils.isNull(this.jAi) && this.jAh != null && this.jAh.isHasMore() && this.jzQ.czd().bo(this.jAi, this.fpl)) {
            czm();
        }
    }

    private void czm() {
        this.jAf.setNextPage(this.ehe);
        this.ehe.startLoadData();
    }

    private void bba() {
        this.jAf.setNextPage(this.ehe);
        this.ehe.endLoadData();
        this.ehe.setText(this.jzQ.getResources().getString(R.string.pb_load_more));
    }

    private void bbb() {
        this.jAf.setNextPage(this.ehe);
        this.ehe.endLoadData();
        this.ehe.setText(this.jzQ.getResources().getString(R.string.list_no_more));
    }

    private void bbc() {
        if (this.jAf != null) {
            this.jAf.setNextPage(null);
        }
    }

    private void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jzQ.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jzQ.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.text_no_search_result), null);
            this.mNoDataView.onChangeSkinType(this.jzQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    private void czn() {
        if (this.jzQ != null) {
            TiebaStatic.log(new an("c12406").cp("fid", this.jzQ.mForumId).cp("fname", this.jzQ.mForumName).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("tab_id", this.fpl));
        }
    }
}

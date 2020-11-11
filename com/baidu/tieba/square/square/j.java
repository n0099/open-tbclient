package com.baidu.tieba.square.square;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView ghD;
    private TbPageContext<Object> iwh;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView mTy;
    private g mTz;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iwh = null;
        this.mTy = null;
        this.mPullView = null;
        this.mTz = null;
        this.iwh = tbPageContext;
        this.mRoot = view;
        this.mTy = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.mTy.setOnKeyListener(onKeyListener);
        if (this.iwh.getOrignalPage() instanceof f) {
            this.mTy.setOnItemClickListener((f) this.iwh.getOrignalPage());
        }
        this.mTz = new g(tbPageContext);
        this.mTy.setAdapter((ListAdapter) this.mTz);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.mTy.setPullRefresh(this.mPullView);
        this.ghD = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.mTz.a(hVar);
                    this.mTz.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.mTy.completePullRefreshPostDelayed(0L);
    }

    public void E(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iwh.showToast(str, true);
        }
    }

    public void dIS() {
        this.ghD.setVisibility(0);
    }

    public void dIT() {
        this.ghD.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.ghD.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.ghD.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iwh.getLayoutMode().setNightMode(i == 1);
        this.iwh.getLayoutMode().onModeChanged(this.mRoot);
        this.mTz.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.ghD.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mTy.removeHeaderView(this.mNoDataView);
        }
    }

    public void CQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iwh.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.pQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pQ(i));
        this.mNoDataView.onChangeSkinType(this.iwh, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mTy.removeHeaderView(this.mNoDataView);
        this.mTy.addHeaderView(this.mNoDataView);
    }
}

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
/* loaded from: classes22.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView ghk;
    private TbPageContext<Object> iwW;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView mUs;
    private g mUt;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iwW = null;
        this.mUs = null;
        this.mPullView = null;
        this.mUt = null;
        this.iwW = tbPageContext;
        this.mRoot = view;
        this.mUs = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.mUs.setOnKeyListener(onKeyListener);
        if (this.iwW.getOrignalPage() instanceof f) {
            this.mUs.setOnItemClickListener((f) this.iwW.getOrignalPage());
        }
        this.mUt = new g(tbPageContext);
        this.mUs.setAdapter((ListAdapter) this.mUt);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.mUs.setPullRefresh(this.mPullView);
        this.ghk = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.mUt.a(hVar);
                    this.mUt.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.mUs.completePullRefreshPostDelayed(0L);
    }

    public void F(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iwW.showToast(str, true);
        }
    }

    public void dIJ() {
        this.ghk.setVisibility(0);
    }

    public void dIK() {
        this.ghk.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.ghk.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.ghk.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iwW.getLayoutMode().setNightMode(i == 1);
        this.iwW.getLayoutMode().onModeChanged(this.mRoot);
        this.mUt.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.ghk.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mUs.removeHeaderView(this.mNoDataView);
        }
    }

    public void Do(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iwW.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.qo(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.qo(i));
        this.mNoDataView.onChangeSkinType(this.iwW, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mUs.removeHeaderView(this.mNoDataView);
        this.mUs.addHeaderView(this.mNoDataView);
    }
}

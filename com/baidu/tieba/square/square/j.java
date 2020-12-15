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
    private NoNetworkView gpw;
    private TbPageContext<Object> iHQ;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView nit;
    private g niu;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iHQ = null;
        this.nit = null;
        this.mPullView = null;
        this.niu = null;
        this.iHQ = tbPageContext;
        this.mRoot = view;
        this.nit = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.nit.setOnKeyListener(onKeyListener);
        if (this.iHQ.getOrignalPage() instanceof f) {
            this.nit.setOnItemClickListener((f) this.iHQ.getOrignalPage());
        }
        this.niu = new g(tbPageContext);
        this.nit.setAdapter((ListAdapter) this.niu);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.nit.setPullRefresh(this.mPullView);
        this.gpw = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.niu.a(hVar);
                    this.niu.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.nit.completePullRefreshPostDelayed(0L);
    }

    public void F(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iHQ.showToast(str, true);
        }
    }

    public void dOa() {
        this.gpw.setVisibility(0);
    }

    public void dOb() {
        this.gpw.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gpw.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gpw.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iHQ.getLayoutMode().setNightMode(i == 1);
        this.iHQ.getLayoutMode().onModeChanged(this.mRoot);
        this.niu.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gpw.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.nit.removeHeaderView(this.mNoDataView);
        }
    }

    public void Ed(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iHQ.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.qP(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(i));
        this.mNoDataView.onChangeSkinType(this.iHQ, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.nit.removeHeaderView(this.mNoDataView);
        this.nit.addHeaderView(this.mNoDataView);
    }
}

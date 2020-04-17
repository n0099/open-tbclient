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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView gAG;
    private TbPageContext<Object> gNq;
    private BdListView kOW;
    private g kOX;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.gNq = null;
        this.kOW = null;
        this.mPullView = null;
        this.kOX = null;
        this.gNq = tbPageContext;
        this.mRoot = view;
        this.kOW = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.kOW.setOnKeyListener(onKeyListener);
        if (this.gNq.getOrignalPage() instanceof f) {
            this.kOW.setOnItemClickListener((f) this.gNq.getOrignalPage());
        }
        this.kOX = new g(tbPageContext);
        this.kOW.setAdapter((ListAdapter) this.kOX);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.kOW.setPullRefresh(this.mPullView);
        this.gAG = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.kOX.a(hVar);
                    this.kOX.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.kOW.completePullRefreshPostDelayed(0L);
    }

    public void z(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.gNq.showToast(str, true);
        }
    }

    public void cVm() {
        this.gAG.setVisibility(0);
    }

    public void cVn() {
        this.gAG.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gAG.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gAG.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.gNq.getLayoutMode().setNightMode(i == 1);
        this.gNq.getLayoutMode().onModeChanged(this.mRoot);
        this.kOX.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gAG.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.kOW.removeHeaderView(this.mNoDataView);
        }
    }

    public void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gNq.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lr(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lr(i));
        this.mNoDataView.onChangeSkinType(this.gNq, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.kOW.removeHeaderView(this.mNoDataView);
        this.kOW.addHeaderView(this.mNoDataView);
    }
}

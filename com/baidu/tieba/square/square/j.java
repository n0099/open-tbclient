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
    private NoNetworkView gAM;
    private TbPageContext<Object> gNw;
    private BdListView kPa;
    private g kPb;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.gNw = null;
        this.kPa = null;
        this.mPullView = null;
        this.kPb = null;
        this.gNw = tbPageContext;
        this.mRoot = view;
        this.kPa = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.kPa.setOnKeyListener(onKeyListener);
        if (this.gNw.getOrignalPage() instanceof f) {
            this.kPa.setOnItemClickListener((f) this.gNw.getOrignalPage());
        }
        this.kPb = new g(tbPageContext);
        this.kPa.setAdapter((ListAdapter) this.kPb);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.kPa.setPullRefresh(this.mPullView);
        this.gAM = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.kPb.a(hVar);
                    this.kPb.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.kPa.completePullRefreshPostDelayed(0L);
    }

    public void z(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.gNw.showToast(str, true);
        }
    }

    public void cVk() {
        this.gAM.setVisibility(0);
    }

    public void cVl() {
        this.gAM.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gAM.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gAM.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.gNw.getLayoutMode().setNightMode(i == 1);
        this.gNw.getLayoutMode().onModeChanged(this.mRoot);
        this.kPb.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gAM.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.kPa.removeHeaderView(this.mNoDataView);
        }
    }

    public void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gNw.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lr(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lr(i));
        this.mNoDataView.onChangeSkinType(this.gNw, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.kPa.removeHeaderView(this.mNoDataView);
        this.kPa.addHeaderView(this.mNoDataView);
    }
}

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
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.base.d<Object> {
    private NoNetworkView gyk;
    private TbPageContext<Object> iVp;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView ntB;
    private g ntC;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iVp = null;
        this.ntB = null;
        this.mPullView = null;
        this.ntC = null;
        this.iVp = tbPageContext;
        this.mRoot = view;
        this.ntB = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.ntB.setOnKeyListener(onKeyListener);
        if (this.iVp.getOrignalPage() instanceof f) {
            this.ntB.setOnItemClickListener((f) this.iVp.getOrignalPage());
        }
        this.ntC = new g(tbPageContext);
        this.ntB.setAdapter((ListAdapter) this.ntC);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.ntB.setPullRefresh(this.mPullView);
        this.gyk = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.ntC.a(hVar);
                    this.ntC.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.ntB.completePullRefreshPostDelayed(0L);
    }

    public void N(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iVp.showToast(str, true);
        }
    }

    public void dMu() {
        this.gyk.setVisibility(0);
    }

    public void dMv() {
        this.gyk.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gyk.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gyk.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iVp.getLayoutMode().setNightMode(i == 1);
        this.iVp.getLayoutMode().onModeChanged(this.mRoot);
        this.ntC.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gyk.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ntB.removeHeaderView(this.mNoDataView);
        }
    }

    public void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iVp.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.pz(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(i));
        this.mNoDataView.onChangeSkinType(this.iVp, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.ntB.removeHeaderView(this.mNoDataView);
        this.ntB.addHeaderView(this.mNoDataView);
    }
}

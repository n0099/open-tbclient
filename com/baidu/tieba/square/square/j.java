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
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView fSu;
    private TbPageContext<Object> gbi;
    private BdListView kcn;
    private g kco;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.gbi = null;
        this.kcn = null;
        this.mPullView = null;
        this.kco = null;
        this.gbi = tbPageContext;
        this.mRoot = view;
        this.kcn = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.kcn.setOnKeyListener(onKeyListener);
        if (this.gbi.getOrignalPage() instanceof f) {
            this.kcn.setOnItemClickListener((f) this.gbi.getOrignalPage());
        }
        this.kco = new g(tbPageContext);
        this.kcn.setAdapter((ListAdapter) this.kco);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.kcn.setPullRefresh(this.mPullView);
        this.fSu = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.kco.a(hVar);
                    this.kco.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.kcn.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.gbi.showToast(str, true);
        }
    }

    public void cIp() {
        this.fSu.setVisibility(0);
    }

    public void cIq() {
        this.fSu.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fSu.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fSu.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.gbi.getLayoutMode().setNightMode(i == 1);
        this.gbi.getLayoutMode().onModeChanged(this.mRoot);
        this.kco.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fSu.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.kcn.removeHeaderView(this.mNoDataView);
        }
    }

    public void wi(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gbi.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.kQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(i));
        this.mNoDataView.onChangeSkinType(this.gbi, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.kcn.removeHeaderView(this.mNoDataView);
        this.kcn.addHeaderView(this.mNoDataView);
    }
}

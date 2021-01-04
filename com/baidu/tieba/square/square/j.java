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
    private NoNetworkView gzT;
    private TbPageContext<Object> iUb;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView nnY;
    private g nnZ;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iUb = null;
        this.nnY = null;
        this.mPullView = null;
        this.nnZ = null;
        this.iUb = tbPageContext;
        this.mRoot = view;
        this.nnY = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.nnY.setOnKeyListener(onKeyListener);
        if (this.iUb.getOrignalPage() instanceof f) {
            this.nnY.setOnItemClickListener((f) this.iUb.getOrignalPage());
        }
        this.nnZ = new g(tbPageContext);
        this.nnY.setAdapter((ListAdapter) this.nnZ);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.nnY.setPullRefresh(this.mPullView);
        this.gzT = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.nnZ.a(hVar);
                    this.nnZ.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.nnY.completePullRefreshPostDelayed(0L);
    }

    public void F(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iUb.showToast(str, true);
        }
    }

    public void dNS() {
        this.gzT.setVisibility(0);
    }

    public void dNT() {
        this.gzT.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gzT.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gzT.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iUb.getLayoutMode().setNightMode(i == 1);
        this.iUb.getLayoutMode().onModeChanged(this.mRoot);
        this.nnZ.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gzT.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.nnY.removeHeaderView(this.mNoDataView);
        }
    }

    public void En(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iUb.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.ra(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ra(i));
        this.mNoDataView.onChangeSkinType(this.iUb, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.nnY.removeHeaderView(this.mNoDataView);
        this.nnY.addHeaderView(this.mNoDataView);
    }
}

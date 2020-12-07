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
    private NoNetworkView gpu;
    private TbPageContext<Object> iHO;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView nir;
    private g nis;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iHO = null;
        this.nir = null;
        this.mPullView = null;
        this.nis = null;
        this.iHO = tbPageContext;
        this.mRoot = view;
        this.nir = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.nir.setOnKeyListener(onKeyListener);
        if (this.iHO.getOrignalPage() instanceof f) {
            this.nir.setOnItemClickListener((f) this.iHO.getOrignalPage());
        }
        this.nis = new g(tbPageContext);
        this.nir.setAdapter((ListAdapter) this.nis);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.nir.setPullRefresh(this.mPullView);
        this.gpu = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.nis.a(hVar);
                    this.nis.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.nir.completePullRefreshPostDelayed(0L);
    }

    public void F(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iHO.showToast(str, true);
        }
    }

    public void dNZ() {
        this.gpu.setVisibility(0);
    }

    public void dOa() {
        this.gpu.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gpu.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gpu.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iHO.getLayoutMode().setNightMode(i == 1);
        this.iHO.getLayoutMode().onModeChanged(this.mRoot);
        this.nis.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gpu.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.nir.removeHeaderView(this.mNoDataView);
        }
    }

    public void Ed(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iHO.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.qP(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.qP(i));
        this.mNoDataView.onChangeSkinType(this.iHO, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.nir.removeHeaderView(this.mNoDataView);
        this.nir.addHeaderView(this.mNoDataView);
    }
}

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
    private NoNetworkView fVM;
    private TbPageContext<Object> geg;
    private BdListView kfd;
    private g kfe;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.geg = null;
        this.kfd = null;
        this.mPullView = null;
        this.kfe = null;
        this.geg = tbPageContext;
        this.mRoot = view;
        this.kfd = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.kfd.setOnKeyListener(onKeyListener);
        if (this.geg.getOrignalPage() instanceof f) {
            this.kfd.setOnItemClickListener((f) this.geg.getOrignalPage());
        }
        this.kfe = new g(tbPageContext);
        this.kfd.setAdapter((ListAdapter) this.kfe);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.kfd.setPullRefresh(this.mPullView);
        this.fVM = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.kfe.a(hVar);
                    this.kfe.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.kfd.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.geg.showToast(str, true);
        }
    }

    public void cKq() {
        this.fVM.setVisibility(0);
    }

    public void cKr() {
        this.fVM.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fVM.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fVM.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.geg.getLayoutMode().setNightMode(i == 1);
        this.geg.getLayoutMode().onModeChanged(this.mRoot);
        this.kfe.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fVM.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.kfd.removeHeaderView(this.mNoDataView);
        }
    }

    public void ww(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.geg.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lh(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(i));
        this.mNoDataView.onChangeSkinType(this.geg, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.kfd.removeHeaderView(this.mNoDataView);
        this.kfd.addHeaderView(this.mNoDataView);
    }
}

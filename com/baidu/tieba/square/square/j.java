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
    private NoNetworkView fUO;
    private TbPageContext<Object> gdj;
    private BdListView kdm;
    private g kdn;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.gdj = null;
        this.kdm = null;
        this.mPullView = null;
        this.kdn = null;
        this.gdj = tbPageContext;
        this.mRoot = view;
        this.kdm = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.kdm.setOnKeyListener(onKeyListener);
        if (this.gdj.getOrignalPage() instanceof f) {
            this.kdm.setOnItemClickListener((f) this.gdj.getOrignalPage());
        }
        this.kdn = new g(tbPageContext);
        this.kdm.setAdapter((ListAdapter) this.kdn);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.kdm.setPullRefresh(this.mPullView);
        this.fUO = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.kdn.a(hVar);
                    this.kdn.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.kdm.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.gdj.showToast(str, true);
        }
    }

    public void cJT() {
        this.fUO.setVisibility(0);
    }

    public void cJU() {
        this.fUO.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fUO.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fUO.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.gdj.getLayoutMode().setNightMode(i == 1);
        this.gdj.getLayoutMode().onModeChanged(this.mRoot);
        this.kdn.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fUO.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.kdm.removeHeaderView(this.mNoDataView);
        }
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gdj.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lh(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(i));
        this.mNoDataView.onChangeSkinType(this.gdj, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.kdm.removeHeaderView(this.mNoDataView);
        this.kdm.addHeaderView(this.mNoDataView);
    }
}

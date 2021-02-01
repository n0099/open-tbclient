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
    private NoNetworkView gxW;
    private TbPageContext<Object> iVb;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView ntb;
    private g ntc;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iVb = null;
        this.ntb = null;
        this.mPullView = null;
        this.ntc = null;
        this.iVb = tbPageContext;
        this.mRoot = view;
        this.ntb = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.ntb.setOnKeyListener(onKeyListener);
        if (this.iVb.getOrignalPage() instanceof f) {
            this.ntb.setOnItemClickListener((f) this.iVb.getOrignalPage());
        }
        this.ntc = new g(tbPageContext);
        this.ntb.setAdapter((ListAdapter) this.ntc);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.ntb.setPullRefresh(this.mPullView);
        this.gxW = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.ntc.a(hVar);
                    this.ntc.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.ntb.completePullRefreshPostDelayed(0L);
    }

    public void N(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iVb.showToast(str, true);
        }
    }

    public void dMm() {
        this.gxW.setVisibility(0);
    }

    public void dMn() {
        this.gxW.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gxW.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gxW.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iVb.getLayoutMode().setNightMode(i == 1);
        this.iVb.getLayoutMode().onModeChanged(this.mRoot);
        this.ntc.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gxW.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ntb.removeHeaderView(this.mNoDataView);
        }
    }

    public void CY(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iVb.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.pz(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pz(i));
        this.mNoDataView.onChangeSkinType(this.iVb, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.ntb.removeHeaderView(this.mNoDataView);
        this.ntb.addHeaderView(this.mNoDataView);
    }
}

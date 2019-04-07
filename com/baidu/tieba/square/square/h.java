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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class h extends com.baidu.adp.base.c<Object> {
    private View bub;
    private NoNetworkView eCe;
    private TbPageContext<Object> eKd;
    private BdListView iCJ;
    private e iCK;
    private NoDataView mNoDataView;
    i mPullView;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.eKd = null;
        this.iCJ = null;
        this.mPullView = null;
        this.iCK = null;
        this.eKd = tbPageContext;
        this.bub = view;
        this.iCJ = (BdListView) this.bub.findViewById(d.g.square_list);
        this.iCJ.setOnKeyListener(onKeyListener);
        if (this.eKd.getOrignalPage() instanceof SquareActivity) {
            this.iCJ.setOnItemClickListener((SquareActivity) this.eKd.getOrignalPage());
        }
        this.iCK = new e(tbPageContext);
        this.iCJ.setAdapter((ListAdapter) this.iCK);
        this.mPullView = new i(tbPageContext);
        this.iCJ.setPullRefresh(this.mPullView);
        this.eCe = (NoNetworkView) this.bub.findViewById(d.g.view_no_network);
    }

    public View getRootView() {
        return this.bub;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.iCK.a(fVar);
                    this.iCK.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void pD() {
        this.iCJ.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        pD();
        if (!z && str != null) {
            this.eKd.showToast(str, true);
        }
    }

    public void cdk() {
        this.eCe.setVisibility(0);
    }

    public void cdl() {
        this.eCe.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eCe.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eCe.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.eKd.getLayoutMode().setNightMode(i == 1);
        this.eKd.getLayoutMode().onModeChanged(this.bub);
        this.iCK.onChangeSkinType(i);
        this.mPullView.ib(i);
        this.eCe.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.iCJ.removeHeaderView(this.mNoDataView);
        }
    }

    public void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eKd.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds240)), NoDataViewFactory.d.hT(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(i));
        this.mNoDataView.onChangeSkinType(this.eKd, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.iCJ.removeHeaderView(this.mNoDataView);
        this.iCJ.addHeaderView(this.mNoDataView);
    }
}

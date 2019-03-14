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
    private View btY;
    private NoNetworkView eCt;
    private TbPageContext<Object> eKr;
    private BdListView iCZ;
    private e iDa;
    private NoDataView mNoDataView;
    i mPullView;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.eKr = null;
        this.iCZ = null;
        this.mPullView = null;
        this.iDa = null;
        this.eKr = tbPageContext;
        this.btY = view;
        this.iCZ = (BdListView) this.btY.findViewById(d.g.square_list);
        this.iCZ.setOnKeyListener(onKeyListener);
        if (this.eKr.getOrignalPage() instanceof SquareActivity) {
            this.iCZ.setOnItemClickListener((SquareActivity) this.eKr.getOrignalPage());
        }
        this.iDa = new e(tbPageContext);
        this.iCZ.setAdapter((ListAdapter) this.iDa);
        this.mPullView = new i(tbPageContext);
        this.iCZ.setPullRefresh(this.mPullView);
        this.eCt = (NoNetworkView) this.btY.findViewById(d.g.view_no_network);
    }

    public View getRootView() {
        return this.btY;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.iDa.a(fVar);
                    this.iDa.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void pD() {
        this.iCZ.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        pD();
        if (!z && str != null) {
            this.eKr.showToast(str, true);
        }
    }

    public void cdo() {
        this.eCt.setVisibility(0);
    }

    public void cdp() {
        this.eCt.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eCt.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eCt.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.eKr.getLayoutMode().setNightMode(i == 1);
        this.eKr.getLayoutMode().onModeChanged(this.btY);
        this.iDa.onChangeSkinType(i);
        this.mPullView.ic(i);
        this.eCt.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.iCZ.removeHeaderView(this.mNoDataView);
        }
    }

    public void nS(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eKr.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds240)), NoDataViewFactory.d.hU(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(i));
        this.mNoDataView.onChangeSkinType(this.eKr, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.iCZ.removeHeaderView(this.mNoDataView);
        this.iCZ.addHeaderView(this.mNoDataView);
    }
}

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
    private View buc;
    private NoNetworkView eCf;
    private TbPageContext<Object> eKe;
    private BdListView iCK;
    private e iCL;
    private NoDataView mNoDataView;
    i mPullView;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.eKe = null;
        this.iCK = null;
        this.mPullView = null;
        this.iCL = null;
        this.eKe = tbPageContext;
        this.buc = view;
        this.iCK = (BdListView) this.buc.findViewById(d.g.square_list);
        this.iCK.setOnKeyListener(onKeyListener);
        if (this.eKe.getOrignalPage() instanceof SquareActivity) {
            this.iCK.setOnItemClickListener((SquareActivity) this.eKe.getOrignalPage());
        }
        this.iCL = new e(tbPageContext);
        this.iCK.setAdapter((ListAdapter) this.iCL);
        this.mPullView = new i(tbPageContext);
        this.iCK.setPullRefresh(this.mPullView);
        this.eCf = (NoNetworkView) this.buc.findViewById(d.g.view_no_network);
    }

    public View getRootView() {
        return this.buc;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.iCL.a(fVar);
                    this.iCL.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void pD() {
        this.iCK.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        pD();
        if (!z && str != null) {
            this.eKe.showToast(str, true);
        }
    }

    public void cdk() {
        this.eCf.setVisibility(0);
    }

    public void cdl() {
        this.eCf.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eCf.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eCf.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.eKe.getLayoutMode().setNightMode(i == 1);
        this.eKe.getLayoutMode().onModeChanged(this.buc);
        this.iCL.onChangeSkinType(i);
        this.mPullView.ib(i);
        this.eCf.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.iCK.removeHeaderView(this.mNoDataView);
        }
    }

    public void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eKe.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds240)), NoDataViewFactory.d.hT(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(i));
        this.mNoDataView.onChangeSkinType(this.eKe, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.iCK.removeHeaderView(this.mNoDataView);
        this.iCK.addHeaderView(this.mNoDataView);
    }
}

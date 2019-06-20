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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class h extends com.baidu.adp.base.c<Object> {
    private View bBg;
    private NoNetworkView eRV;
    private TbPageContext<Object> fao;
    private BdListView iVE;
    private e iVF;
    private NoDataView mNoDataView;
    i mPullView;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.fao = null;
        this.iVE = null;
        this.mPullView = null;
        this.iVF = null;
        this.fao = tbPageContext;
        this.bBg = view;
        this.iVE = (BdListView) this.bBg.findViewById(R.id.square_list);
        this.iVE.setOnKeyListener(onKeyListener);
        if (this.fao.getOrignalPage() instanceof SquareActivity) {
            this.iVE.setOnItemClickListener((SquareActivity) this.fao.getOrignalPage());
        }
        this.iVF = new e(tbPageContext);
        this.iVE.setAdapter((ListAdapter) this.iVF);
        this.mPullView = new i(tbPageContext);
        this.iVE.setPullRefresh(this.mPullView);
        this.eRV = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.bBg;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.iVF.a(fVar);
                    this.iVF.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void oy() {
        this.iVE.completePullRefreshPostDelayed(0L);
    }

    public void x(boolean z, String str) {
        oy();
        if (!z && str != null) {
            this.fao.showToast(str, true);
        }
    }

    public void clr() {
        this.eRV.setVisibility(0);
    }

    public void cls() {
        this.eRV.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eRV.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eRV.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.fao.getLayoutMode().setNightMode(i == 1);
        this.fao.getLayoutMode().onModeChanged(this.bBg);
        this.iVF.onChangeSkinType(i);
        this.mPullView.iP(i);
        this.eRV.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.iVE.removeHeaderView(this.mNoDataView);
        }
    }

    public void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fao.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.iH(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.fao, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.iVE.removeHeaderView(this.mNoDataView);
        this.iVE.addHeaderView(this.mNoDataView);
    }
}

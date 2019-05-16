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
    private NoNetworkView eRU;
    private TbPageContext<Object> fan;
    private BdListView iVy;
    private e iVz;
    private NoDataView mNoDataView;
    i mPullView;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.fan = null;
        this.iVy = null;
        this.mPullView = null;
        this.iVz = null;
        this.fan = tbPageContext;
        this.bBg = view;
        this.iVy = (BdListView) this.bBg.findViewById(R.id.square_list);
        this.iVy.setOnKeyListener(onKeyListener);
        if (this.fan.getOrignalPage() instanceof SquareActivity) {
            this.iVy.setOnItemClickListener((SquareActivity) this.fan.getOrignalPage());
        }
        this.iVz = new e(tbPageContext);
        this.iVy.setAdapter((ListAdapter) this.iVz);
        this.mPullView = new i(tbPageContext);
        this.iVy.setPullRefresh(this.mPullView);
        this.eRU = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.bBg;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.iVz.a(fVar);
                    this.iVz.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void oy() {
        this.iVy.completePullRefreshPostDelayed(0L);
    }

    public void x(boolean z, String str) {
        oy();
        if (!z && str != null) {
            this.fan.showToast(str, true);
        }
    }

    public void clo() {
        this.eRU.setVisibility(0);
    }

    public void clp() {
        this.eRU.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eRU.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eRU.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.fan.getLayoutMode().setNightMode(i == 1);
        this.fan.getLayoutMode().onModeChanged(this.bBg);
        this.iVz.onChangeSkinType(i);
        this.mPullView.iP(i);
        this.eRU.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.iVy.removeHeaderView(this.mNoDataView);
        }
    }

    public void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fan.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.iH(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.onChangeSkinType(this.fan, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.iVy.removeHeaderView(this.mNoDataView);
        this.iVy.addHeaderView(this.mNoDataView);
    }
}

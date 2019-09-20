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
    private NoNetworkView eYL;
    private TbPageContext<Object> fhC;
    private BdListView jft;
    private e jfu;
    private NoDataView mNoDataView;
    i mPullView;
    private View mRoot;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.fhC = null;
        this.jft = null;
        this.mPullView = null;
        this.jfu = null;
        this.fhC = tbPageContext;
        this.mRoot = view;
        this.jft = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.jft.setOnKeyListener(onKeyListener);
        if (this.fhC.getOrignalPage() instanceof SquareActivity) {
            this.jft.setOnItemClickListener((SquareActivity) this.fhC.getOrignalPage());
        }
        this.jfu = new e(tbPageContext);
        this.jft.setAdapter((ListAdapter) this.jfu);
        this.mPullView = new i(tbPageContext);
        this.jft.setPullRefresh(this.mPullView);
        this.eYL = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.jfu.a(fVar);
                    this.jfu.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void oU() {
        this.jft.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        oU();
        if (!z && str != null) {
            this.fhC.showToast(str, true);
        }
    }

    public void cpo() {
        this.eYL.setVisibility(0);
    }

    public void cpp() {
        this.eYL.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eYL.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eYL.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.fhC.getLayoutMode().setNightMode(i == 1);
        this.fhC.getLayoutMode().onModeChanged(this.mRoot);
        this.jfu.onChangeSkinType(i);
        this.mPullView.iY(i);
        this.eYL.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.jft.removeHeaderView(this.mNoDataView);
        }
    }

    public void pb(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fhC.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.iQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(i));
        this.mNoDataView.onChangeSkinType(this.fhC, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.jft.removeHeaderView(this.mNoDataView);
        this.jft.addHeaderView(this.mNoDataView);
    }
}

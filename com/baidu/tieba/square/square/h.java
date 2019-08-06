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
    private NoNetworkView eXf;
    private TbPageContext<Object> ffP;
    private BdListView jcY;
    private e jcZ;
    private NoDataView mNoDataView;
    i mPullView;
    private View mRoot;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.ffP = null;
        this.jcY = null;
        this.mPullView = null;
        this.jcZ = null;
        this.ffP = tbPageContext;
        this.mRoot = view;
        this.jcY = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.jcY.setOnKeyListener(onKeyListener);
        if (this.ffP.getOrignalPage() instanceof SquareActivity) {
            this.jcY.setOnItemClickListener((SquareActivity) this.ffP.getOrignalPage());
        }
        this.jcZ = new e(tbPageContext);
        this.jcY.setAdapter((ListAdapter) this.jcZ);
        this.mPullView = new i(tbPageContext);
        this.jcY.setPullRefresh(this.mPullView);
        this.eXf = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.jcZ.a(fVar);
                    this.jcZ.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void oT() {
        this.jcY.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        oT();
        if (!z && str != null) {
            this.ffP.showToast(str, true);
        }
    }

    public void coB() {
        this.eXf.setVisibility(0);
    }

    public void coC() {
        this.eXf.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eXf.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eXf.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.ffP.getLayoutMode().setNightMode(i == 1);
        this.ffP.getLayoutMode().onModeChanged(this.mRoot);
        this.jcZ.onChangeSkinType(i);
        this.mPullView.iV(i);
        this.eXf.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.jcY.removeHeaderView(this.mNoDataView);
        }
    }

    public void oX(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ffP.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.iN(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.onChangeSkinType(this.ffP, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.jcY.removeHeaderView(this.mNoDataView);
        this.jcY.addHeaderView(this.mNoDataView);
    }
}

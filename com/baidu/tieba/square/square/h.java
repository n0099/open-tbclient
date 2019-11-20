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
    private NoNetworkView faF;
    private TbPageContext<Object> fjz;
    private BdListView jet;
    private e jeu;
    private NoDataView mNoDataView;
    i mPullView;
    private View mRoot;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.fjz = null;
        this.jet = null;
        this.mPullView = null;
        this.jeu = null;
        this.fjz = tbPageContext;
        this.mRoot = view;
        this.jet = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.jet.setOnKeyListener(onKeyListener);
        if (this.fjz.getOrignalPage() instanceof SquareActivity) {
            this.jet.setOnItemClickListener((SquareActivity) this.fjz.getOrignalPage());
        }
        this.jeu = new e(tbPageContext);
        this.jet.setAdapter((ListAdapter) this.jeu);
        this.mPullView = new i(tbPageContext);
        this.jet.setPullRefresh(this.mPullView);
        this.faF = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.jeu.a(fVar);
                    this.jeu.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.jet.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.fjz.showToast(str, true);
        }
    }

    public void cnd() {
        this.faF.setVisibility(0);
    }

    public void cne() {
        this.faF.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.faF.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.faF.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.fjz.getLayoutMode().setNightMode(i == 1);
        this.fjz.getLayoutMode().onModeChanged(this.mRoot);
        this.jeu.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.faF.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.jet.removeHeaderView(this.mNoDataView);
        }
    }

    public void ub(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fjz.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.iK(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(i));
        this.mNoDataView.onChangeSkinType(this.fjz, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.jet.removeHeaderView(this.mNoDataView);
        this.jet.addHeaderView(this.mNoDataView);
    }
}

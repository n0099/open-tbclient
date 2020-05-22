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
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView fan;
    private TbPageContext<Object> hci;
    private BdListView lhq;
    private g lhr;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.hci = null;
        this.lhq = null;
        this.mPullView = null;
        this.lhr = null;
        this.hci = tbPageContext;
        this.mRoot = view;
        this.lhq = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.lhq.setOnKeyListener(onKeyListener);
        if (this.hci.getOrignalPage() instanceof f) {
            this.lhq.setOnItemClickListener((f) this.hci.getOrignalPage());
        }
        this.lhr = new g(tbPageContext);
        this.lhq.setAdapter((ListAdapter) this.lhr);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.lhq.setPullRefresh(this.mPullView);
        this.fan = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.lhr.a(hVar);
                    this.lhr.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.lhq.completePullRefreshPostDelayed(0L);
    }

    public void z(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.hci.showToast(str, true);
        }
    }

    public void dco() {
        this.fan.setVisibility(0);
    }

    public void dcp() {
        this.fan.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fan.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fan.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.hci.getLayoutMode().setNightMode(i == 1);
        this.hci.getLayoutMode().onModeChanged(this.mRoot);
        this.lhr.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fan.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.lhq.removeHeaderView(this.mNoDataView);
        }
    }

    public void xA(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hci.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lT(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lT(i));
        this.mNoDataView.onChangeSkinType(this.hci, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.lhq.removeHeaderView(this.mNoDataView);
        this.lhq.addHeaderView(this.mNoDataView);
    }
}

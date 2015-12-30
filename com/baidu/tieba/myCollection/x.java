package com.baidu.tieba.myCollection;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x {
    BaseFragmentActivity aJl;
    private RelativeLayout bKF;
    private BdListView bmy;
    private p cyg;
    private com.baidu.tbadk.core.dialog.a cyh = null;
    a.b cyi = null;
    private boolean cyj = false;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.t mPullView;

    public x(s sVar, View view) {
        this.aJl = null;
        this.bmy = null;
        this.mNoDataView = null;
        this.cyg = null;
        this.bKF = null;
        this.mProgressBar = null;
        this.aJl = sVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(n.g.progress);
        this.bKF = (RelativeLayout) view.findViewById(n.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.aJl.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(this.aJl.getPageContext().getPageActivity(), n.e.ds80)), NoDataViewFactory.d.C(n.j.mark_nodata, n.j.mark_nodata_2), null);
        this.cyg = new p(sVar.getPageContext());
        this.cyg.ajp();
        this.mPullView = new com.baidu.tbadk.core.view.t(sVar.getPageContext());
        this.bmy = (BdListView) view.findViewById(n.g.list);
        this.bmy.setPullRefresh(this.mPullView);
        this.mPullView.a(sVar);
        this.bmy.setAdapter((ListAdapter) this.cyg);
        this.bmy.setOnSrollToBottomListener(sVar);
        this.bmy.setOnItemClickListener(sVar);
        this.cyg.x(sVar);
    }

    public void b(a.b bVar) {
        this.cyi = bVar;
    }

    public void changeEditState(boolean z) {
        this.cyg.setEditState(z);
        this.cyg.notifyDataSetChanged();
    }

    public int ajl() {
        return n.g.home_lv_markitem_delete;
    }

    public void ka(int i) {
        if (i == 0) {
            this.bmy.nb();
            return;
        }
        this.cyg.eB(true);
        this.cyg.notifyDataSetChanged();
    }

    public void Pe() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cyg.eB(true);
        if (str != null) {
            this.aJl.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aju() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.aju() < 20) {
                this.cyg.setHasMore(false);
                this.cyg.eC(aVar.isFirst() ? false : true);
            } else {
                this.cyg.setHasMore(true);
                this.cyg.eC(true);
            }
            this.cyg.setData(aVar.ajt());
            a(aVar, z);
        }
        this.cyg.eB(false);
        this.cyg.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bu(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.bmy.removeHeaderView(this.mNoDataView);
            this.cyg.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.aJl.getPageContext());
        this.bmy.removeHeaderView(this.mNoDataView);
        this.bmy.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void ajr() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.aJl.getPageContext());
        }
    }

    public void startSync() {
        this.aJl.showLoadingDialog(this.aJl.getPageContext().getString(n.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.aJl.closeLoadingDialog();
        if (z) {
            this.cyg.ajp();
        }
        if (str != null) {
            this.aJl.showToast(str);
        }
        if (z2) {
            ajm();
        }
        this.cyg.notifyDataSetChanged();
    }

    public void Lq() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.aJl.showToast(this.aJl.getPageContext().getString(n.j.del_mark_success));
            if (aVar == null || aVar.ajt() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.ajt().size() == 0) {
                aVar.f(true);
            } else {
                this.cyg.setData(aVar.ajt());
            }
        } else {
            this.aJl.showToast(str);
        }
        this.cyg.eC(false);
        this.mProgressBar.setVisibility(8);
    }

    public void R(ArrayList<MarkData> arrayList) {
        this.cyg.setData(arrayList);
    }

    private void ajm() {
        if (this.cyh == null) {
            this.cyh = new com.baidu.tbadk.core.dialog.a(this.aJl.getPageContext().getPageActivity());
            this.cyh.cE(this.aJl.getPageContext().getString(n.j.sync_mark_fail));
            this.cyh.cF(this.aJl.getPageContext().getString(n.j.neterror));
            if (this.cyi != null) {
                this.cyh.a(this.aJl.getPageContext().getString(n.j.retry_rightnow), this.cyi);
            }
            this.cyh.b(this.aJl.getPageContext().getString(n.j.confirm), new y(this));
            this.cyh.b(this.aJl.getPageContext());
            this.cyh.aj(true);
        }
        this.cyh.tf();
    }

    public void onChangeSkinType(int i) {
        this.aJl.getLayoutMode().k(this.bKF);
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aJl.getPageContext(), i);
            as.j(this.mNoDataView, n.d.mark_item_bg);
        }
    }

    public void ajn() {
        this.cyg.ajp();
        this.cyg.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.cyh != null) {
            this.cyh.dismiss();
            this.cyh = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.cyg.ajo();
    }

    public void completePullRefresh() {
        if (this.bmy != null) {
            this.bmy.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.cyj;
    }

    public void bu(boolean z) {
        this.cyj = z;
    }
}

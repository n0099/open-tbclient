package com.baidu.tieba.myCollection;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    BaseFragmentActivity aFU;
    private BdListView bby;
    private RelativeLayout bro;
    private m cbE;
    private com.baidu.tbadk.core.dialog.a cbF = null;
    a.b cbG = null;
    private boolean cbH = false;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public u(p pVar, View view) {
        this.aFU = null;
        this.bby = null;
        this.mNoDataView = null;
        this.cbE = null;
        this.bro = null;
        this.mProgressBar = null;
        this.aFU = pVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(i.f.progress);
        this.bro = (RelativeLayout) view.findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.aFU.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(this.aFU.getPageContext().getPageActivity(), i.d.ds80)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.cbE = new m(pVar.getPageContext());
        this.cbE.adt();
        this.mPullView = new com.baidu.tbadk.core.view.r(pVar.getPageContext());
        this.bby = (BdListView) view.findViewById(i.f.list);
        this.bby.setPullRefresh(this.mPullView);
        this.mPullView.a(pVar);
        this.bby.setAdapter((ListAdapter) this.cbE);
        this.bby.setOnSrollToBottomListener(pVar);
        this.bby.setOnItemClickListener(pVar);
        this.cbE.x(pVar);
    }

    public void b(a.b bVar) {
        this.cbG = bVar;
    }

    public void changeEditState(boolean z) {
        this.cbE.setEditState(z);
        this.cbE.notifyDataSetChanged();
    }

    public int adp() {
        return i.f.home_lv_markitem_delete;
    }

    public void iy(int i) {
        if (i == 0) {
            this.bby.nw();
            return;
        }
        this.cbE.dY(true);
        this.cbE.notifyDataSetChanged();
    }

    public void MS() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cbE.dY(true);
        if (str != null) {
            this.aFU.showToast(str);
        }
        if (aVar != null) {
            if (aVar.adz() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.adz() < 20) {
                this.cbE.setHasMore(false);
                this.cbE.dZ(aVar.isFirst() ? false : true);
            } else {
                this.cbE.setHasMore(true);
                this.cbE.dZ(true);
            }
            this.cbE.setData(aVar.ady());
            if (aVar.getCount() > 0) {
                this.mNoDataView.setVisibility(8);
                this.bby.removeHeaderView(this.mNoDataView);
                this.cbE.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.mNoDataView.e(this.aFU.getPageContext());
                this.bby.removeHeaderView(this.mNoDataView);
                this.bby.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
            }
        }
        this.cbE.dY(false);
        this.cbE.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bj(false);
        }
    }

    public void adw() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.aFU.getPageContext());
        }
    }

    public void startSync() {
        this.aFU.showLoadingDialog(this.aFU.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.aFU.closeLoadingDialog();
        if (z) {
            this.cbE.adt();
        }
        if (str != null) {
            this.aFU.showToast(str);
        }
        if (z2) {
            adq();
        }
        this.cbE.notifyDataSetChanged();
    }

    public void Jm() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.aFU.showToast(this.aFU.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.ady() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.ady().size() == 0) {
                aVar.f(true);
            } else {
                this.cbE.setData(aVar.ady());
            }
        } else {
            this.aFU.showToast(str);
        }
        this.cbE.dZ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.cbE.setData(arrayList);
    }

    private void adq() {
        if (this.cbF == null) {
            this.cbF = new com.baidu.tbadk.core.dialog.a(this.aFU.getPageContext().getPageActivity());
            this.cbF.ct(this.aFU.getPageContext().getString(i.h.sync_mark_fail));
            this.cbF.cu(this.aFU.getPageContext().getString(i.h.neterror));
            if (this.cbG != null) {
                this.cbF.a(this.aFU.getPageContext().getString(i.h.retry_rightnow), this.cbG);
            }
            this.cbF.b(this.aFU.getPageContext().getString(i.h.confirm), new v(this));
            this.cbF.b(this.aFU.getPageContext());
            this.cbF.ak(true);
        }
        this.cbF.sO();
    }

    public void onChangeSkinType(int i) {
        this.aFU.getLayoutMode().k(this.bro);
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aFU.getPageContext(), i);
            an.j(this.mNoDataView, i.c.mark_item_bg);
        }
    }

    public void adr() {
        this.cbE.adt();
        this.cbE.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.cbF != null) {
            this.cbF.dismiss();
            this.cbF = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.cbE.ads();
    }

    public void completePullRefresh() {
        if (this.bby != null) {
            this.bby.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.cbH;
    }

    public void bj(boolean z) {
        this.cbH = z;
    }
}

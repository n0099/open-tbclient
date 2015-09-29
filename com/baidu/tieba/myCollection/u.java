package com.baidu.tieba.myCollection;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    BaseFragmentActivity aFJ;
    private BdListView bbn;
    private RelativeLayout brd;
    private m cbt;
    private com.baidu.tbadk.core.dialog.a cbu = null;
    a.b cbv = null;
    private boolean cbw = false;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public u(p pVar, View view) {
        this.aFJ = null;
        this.bbn = null;
        this.mNoDataView = null;
        this.cbt = null;
        this.brd = null;
        this.mProgressBar = null;
        this.aFJ = pVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(i.f.progress);
        this.brd = (RelativeLayout) view.findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.aFJ.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(this.aFJ.getPageContext().getPageActivity(), i.d.ds80)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.cbt = new m(pVar.getPageContext());
        this.cbt.adx();
        this.mPullView = new com.baidu.tbadk.core.view.r(pVar.getPageContext());
        this.bbn = (BdListView) view.findViewById(i.f.list);
        this.bbn.setPullRefresh(this.mPullView);
        this.mPullView.a(pVar);
        this.bbn.setAdapter((ListAdapter) this.cbt);
        this.bbn.setOnSrollToBottomListener(pVar);
        this.bbn.setOnItemClickListener(pVar);
        this.cbt.x(pVar);
    }

    public void b(a.b bVar) {
        this.cbv = bVar;
    }

    public void changeEditState(boolean z) {
        this.cbt.setEditState(z);
        this.cbt.notifyDataSetChanged();
    }

    public int adt() {
        return i.f.home_lv_markitem_delete;
    }

    public void iy(int i) {
        if (i == 0) {
            this.bbn.nw();
            return;
        }
        this.cbt.dY(true);
        this.cbt.notifyDataSetChanged();
    }

    public void MW() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cbt.dY(true);
        if (str != null) {
            this.aFJ.showToast(str);
        }
        if (aVar != null) {
            if (aVar.adD() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.adD() < 20) {
                this.cbt.setHasMore(false);
                this.cbt.dZ(aVar.isFirst() ? false : true);
            } else {
                this.cbt.setHasMore(true);
                this.cbt.dZ(true);
            }
            this.cbt.setData(aVar.adC());
            if (aVar.getCount() > 0) {
                this.mNoDataView.setVisibility(8);
                this.bbn.removeHeaderView(this.mNoDataView);
                this.cbt.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.mNoDataView.e(this.aFJ.getPageContext());
                this.bbn.removeHeaderView(this.mNoDataView);
                this.bbn.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
            }
        }
        this.cbt.dY(false);
        this.cbt.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bj(false);
        }
    }

    public void adA() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.aFJ.getPageContext());
        }
    }

    public void startSync() {
        this.aFJ.showLoadingDialog(this.aFJ.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.aFJ.closeLoadingDialog();
        if (z) {
            this.cbt.adx();
        }
        if (str != null) {
            this.aFJ.showToast(str);
        }
        if (z2) {
            adu();
        }
        this.cbt.notifyDataSetChanged();
    }

    public void Jq() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.aFJ.showToast(this.aFJ.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.adC() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.adC().size() == 0) {
                aVar.f(true);
            } else {
                this.cbt.setData(aVar.adC());
            }
        } else {
            this.aFJ.showToast(str);
        }
        this.cbt.dZ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.cbt.setData(arrayList);
    }

    private void adu() {
        if (this.cbu == null) {
            this.cbu = new com.baidu.tbadk.core.dialog.a(this.aFJ.getPageContext().getPageActivity());
            this.cbu.cs(this.aFJ.getPageContext().getString(i.h.sync_mark_fail));
            this.cbu.ct(this.aFJ.getPageContext().getString(i.h.neterror));
            if (this.cbv != null) {
                this.cbu.a(this.aFJ.getPageContext().getString(i.h.retry_rightnow), this.cbv);
            }
            this.cbu.b(this.aFJ.getPageContext().getString(i.h.confirm), new v(this));
            this.cbu.b(this.aFJ.getPageContext());
            this.cbu.ak(true);
        }
        this.cbu.sR();
    }

    public void onChangeSkinType(int i) {
        this.aFJ.getLayoutMode().k(this.brd);
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aFJ.getPageContext(), i);
            am.j(this.mNoDataView, i.c.mark_item_bg);
        }
    }

    public void adv() {
        this.cbt.adx();
        this.cbt.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.cbu != null) {
            this.cbu.dismiss();
            this.cbu = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.cbt.adw();
    }

    public void completePullRefresh() {
        if (this.bbn != null) {
            this.bbn.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.cbw;
    }

    public void bj(boolean z) {
        this.cbw = z;
    }
}

package com.baidu.tieba.myCollection;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    BaseFragmentActivity aGQ;
    private m bXH;
    private BdListView bbt;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private ProgressBar mProgressBar;
    private z mPullView;
    private RelativeLayout boe = null;
    private com.baidu.tbadk.core.dialog.a bXI = null;
    a.b bXJ = null;
    private boolean bXK = false;

    public u(p pVar, View view) {
        this.aGQ = null;
        this.bbt = null;
        this.mNoDataView = null;
        this.bXH = null;
        this.mProgressBar = null;
        this.aGQ = pVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(i.f.progress);
        this.mNoDataView = NoDataViewFactory.a(this.aGQ.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(this.aGQ.getPageContext().getPageActivity(), i.d.ds80)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.bXH = new m(pVar.getPageContext());
        this.bXH.acf();
        this.mPullView = new z(pVar.getPageContext());
        this.bbt = (BdListView) view.findViewById(i.f.list);
        this.bbt.setPullRefresh(this.mPullView);
        this.mPullView.a(pVar);
        this.bbt.setAdapter((ListAdapter) this.bXH);
        this.bbt.setOnSrollToBottomListener(pVar);
        this.bbt.setOnItemClickListener(pVar);
        this.bXH.w(pVar);
    }

    public void b(a.b bVar) {
        this.bXJ = bVar;
    }

    public void changeEditState(boolean z) {
        this.bXH.setEditState(z);
        this.bXH.notifyDataSetChanged();
    }

    public int acb() {
        return i.f.home_lv_markitem_delete;
    }

    public void iq(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bXH.dX(true);
        this.bXH.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void MX() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.bXH.dX(true);
        if (str != null) {
            this.aGQ.showToast(str);
        }
        if (aVar != null) {
            if (aVar.ack() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.ack() < 20) {
                this.bXH.setHasMore(false);
                this.bXH.dY(aVar.isFirst() ? false : true);
            } else {
                this.bXH.setHasMore(true);
                this.bXH.dY(true);
            }
            this.bXH.setData(aVar.acj());
            if (aVar.getCount() > 0) {
                this.mNoDataView.setVisibility(8);
                this.bbt.removeHeaderView(this.mNoDataView);
                this.bXH.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.mNoDataView.e(this.aGQ.getPageContext());
                this.bbt.removeHeaderView(this.mNoDataView);
                this.bbt.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
            }
        }
        this.bXH.dX(false);
        this.bXH.notifyDataSetChanged();
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bl(false);
        }
    }

    public void ach() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.aGQ.getPageContext());
        }
    }

    public void startSync() {
        this.aGQ.showLoadingDialog(this.aGQ.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.aGQ.closeLoadingDialog();
        if (z) {
            this.bXH.acf();
        }
        if (str != null) {
            this.aGQ.showToast(str);
        }
        if (z2) {
            acc();
        }
        this.bXH.notifyDataSetChanged();
    }

    public void Jv() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.aGQ.showToast(this.aGQ.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.acj() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.acj().size() == 0) {
                aVar.f(true);
            } else {
                this.bXH.setData(aVar.acj());
            }
        } else {
            this.aGQ.showToast(str);
        }
        this.bXH.dY(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.bXH.setData(arrayList);
    }

    private void acc() {
        if (this.bXI == null) {
            this.bXI = new com.baidu.tbadk.core.dialog.a(this.aGQ.getPageContext().getPageActivity());
            this.bXI.cs(this.aGQ.getPageContext().getString(i.h.sync_mark_fail));
            this.bXI.ct(this.aGQ.getPageContext().getString(i.h.neterror));
            if (this.bXJ != null) {
                this.bXI.a(this.aGQ.getPageContext().getString(i.h.retry_rightnow), this.bXJ);
            }
            this.bXI.b(this.aGQ.getPageContext().getString(i.h.confirm), new v(this));
            this.bXI.b(this.aGQ.getPageContext());
            this.bXI.ak(true);
        }
        this.bXI.sU();
    }

    public void onChangeSkinType(int i) {
        this.aGQ.getLayoutMode().k(this.boe);
        if (this.mPullView != null) {
            this.mPullView.cM(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aGQ.getPageContext(), i);
        }
    }

    public void acd() {
        this.bXH.acf();
        this.bXH.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bXI != null) {
            this.bXI.dismiss();
            this.bXI = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bXH.ace();
    }

    public void completePullRefresh() {
        if (this.bbt != null) {
            this.bbt.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.bXK;
    }

    public void bl(boolean z) {
        this.bXK = z;
    }
}

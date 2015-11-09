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
    BaseFragmentActivity aEO;
    private BdListView bcc;
    private RelativeLayout brS;
    private m ccf;
    private com.baidu.tbadk.core.dialog.a ccg = null;
    a.b cch = null;
    private boolean cci = false;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public u(p pVar, View view) {
        this.aEO = null;
        this.bcc = null;
        this.mNoDataView = null;
        this.ccf = null;
        this.brS = null;
        this.mProgressBar = null;
        this.aEO = pVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(i.f.progress);
        this.brS = (RelativeLayout) view.findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.aEO.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(this.aEO.getPageContext().getPageActivity(), i.d.ds80)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.ccf = new m(pVar.getPageContext());
        this.ccf.adO();
        this.mPullView = new com.baidu.tbadk.core.view.r(pVar.getPageContext());
        this.bcc = (BdListView) view.findViewById(i.f.list);
        this.bcc.setPullRefresh(this.mPullView);
        this.mPullView.a(pVar);
        this.bcc.setAdapter((ListAdapter) this.ccf);
        this.bcc.setOnSrollToBottomListener(pVar);
        this.bcc.setOnItemClickListener(pVar);
        this.ccf.x(pVar);
    }

    public void b(a.b bVar) {
        this.cch = bVar;
    }

    public void changeEditState(boolean z) {
        this.ccf.setEditState(z);
        this.ccf.notifyDataSetChanged();
    }

    public int adK() {
        return i.f.home_lv_markitem_delete;
    }

    public void iL(int i) {
        if (i == 0) {
            this.bcc.nx();
            return;
        }
        this.ccf.ea(true);
        this.ccf.notifyDataSetChanged();
    }

    public void Nk() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.ccf.ea(true);
        if (str != null) {
            this.aEO.showToast(str);
        }
        if (aVar != null) {
            if (aVar.adU() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.adU() < 20) {
                this.ccf.setHasMore(false);
                this.ccf.eb(aVar.isFirst() ? false : true);
            } else {
                this.ccf.setHasMore(true);
                this.ccf.eb(true);
            }
            this.ccf.setData(aVar.adT());
            if (aVar.getCount() > 0) {
                this.mNoDataView.setVisibility(8);
                this.bcc.removeHeaderView(this.mNoDataView);
                this.ccf.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.mNoDataView.e(this.aEO.getPageContext());
                this.bcc.removeHeaderView(this.mNoDataView);
                this.bcc.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
            }
        }
        this.ccf.ea(false);
        this.ccf.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bm(false);
        }
    }

    public void adR() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.aEO.getPageContext());
        }
    }

    public void startSync() {
        this.aEO.showLoadingDialog(this.aEO.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.aEO.closeLoadingDialog();
        if (z) {
            this.ccf.adO();
        }
        if (str != null) {
            this.aEO.showToast(str);
        }
        if (z2) {
            adL();
        }
        this.ccf.notifyDataSetChanged();
    }

    public void JC() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.aEO.showToast(this.aEO.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.adT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.adT().size() == 0) {
                aVar.f(true);
            } else {
                this.ccf.setData(aVar.adT());
            }
        } else {
            this.aEO.showToast(str);
        }
        this.ccf.eb(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.ccf.setData(arrayList);
    }

    private void adL() {
        if (this.ccg == null) {
            this.ccg = new com.baidu.tbadk.core.dialog.a(this.aEO.getPageContext().getPageActivity());
            this.ccg.ct(this.aEO.getPageContext().getString(i.h.sync_mark_fail));
            this.ccg.cu(this.aEO.getPageContext().getString(i.h.neterror));
            if (this.cch != null) {
                this.ccg.a(this.aEO.getPageContext().getString(i.h.retry_rightnow), this.cch);
            }
            this.ccg.b(this.aEO.getPageContext().getString(i.h.confirm), new v(this));
            this.ccg.b(this.aEO.getPageContext());
            this.ccg.ak(true);
        }
        this.ccg.sR();
    }

    public void onChangeSkinType(int i) {
        this.aEO.getLayoutMode().k(this.brS);
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aEO.getPageContext(), i);
            an.j(this.mNoDataView, i.c.mark_item_bg);
        }
    }

    public void adM() {
        this.ccf.adO();
        this.ccf.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.ccg != null) {
            this.ccg.dismiss();
            this.ccg = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.ccf.adN();
    }

    public void completePullRefresh() {
        if (this.bcc != null) {
            this.bcc.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.cci;
    }

    public void bm(boolean z) {
        this.cci = z;
    }
}

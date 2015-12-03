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
    BaseFragmentActivity aHN;
    private RelativeLayout bGY;
    private BdListView biH;
    private p cuf;
    private com.baidu.tbadk.core.dialog.a cug = null;
    a.b cuh = null;
    private boolean cui = false;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.s mPullView;

    public x(s sVar, View view) {
        this.aHN = null;
        this.biH = null;
        this.mNoDataView = null;
        this.cuf = null;
        this.bGY = null;
        this.mProgressBar = null;
        this.aHN = sVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(n.f.progress);
        this.bGY = (RelativeLayout) view.findViewById(n.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.aHN.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.d(this.aHN.getPageContext().getPageActivity(), n.d.ds80)), NoDataViewFactory.d.D(n.i.mark_nodata, n.i.mark_nodata_2), null);
        this.cuf = new p(sVar.getPageContext());
        this.cuf.aic();
        this.mPullView = new com.baidu.tbadk.core.view.s(sVar.getPageContext());
        this.biH = (BdListView) view.findViewById(n.f.list);
        this.biH.setPullRefresh(this.mPullView);
        this.mPullView.a(sVar);
        this.biH.setAdapter((ListAdapter) this.cuf);
        this.biH.setOnSrollToBottomListener(sVar);
        this.biH.setOnItemClickListener(sVar);
        this.cuf.x(sVar);
    }

    public void b(a.b bVar) {
        this.cuh = bVar;
    }

    public void changeEditState(boolean z) {
        this.cuf.setEditState(z);
        this.cuf.notifyDataSetChanged();
    }

    public int ahY() {
        return n.f.home_lv_markitem_delete;
    }

    public void jC(int i) {
        if (i == 0) {
            this.biH.nD();
            return;
        }
        this.cuf.eC(true);
        this.cuf.notifyDataSetChanged();
    }

    public void OM() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cuf.eC(true);
        if (str != null) {
            this.aHN.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aih() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.aih() < 20) {
                this.cuf.setHasMore(false);
                this.cuf.eD(aVar.isFirst() ? false : true);
            } else {
                this.cuf.setHasMore(true);
                this.cuf.eD(true);
            }
            this.cuf.setData(aVar.aig());
            if (aVar.getCount() > 0) {
                this.mNoDataView.setVisibility(8);
                this.biH.removeHeaderView(this.mNoDataView);
                this.cuf.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.mNoDataView.e(this.aHN.getPageContext());
                this.biH.removeHeaderView(this.mNoDataView);
                this.biH.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
            }
        }
        this.cuf.eC(false);
        this.cuf.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bu(false);
        }
    }

    public void aie() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.aHN.getPageContext());
        }
    }

    public void startSync() {
        this.aHN.showLoadingDialog(this.aHN.getPageContext().getString(n.i.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.aHN.closeLoadingDialog();
        if (z) {
            this.cuf.aic();
        }
        if (str != null) {
            this.aHN.showToast(str);
        }
        if (z2) {
            ahZ();
        }
        this.cuf.notifyDataSetChanged();
    }

    public void KX() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.aHN.showToast(this.aHN.getPageContext().getString(n.i.del_mark_success));
            if (aVar == null || aVar.aig() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aig().size() == 0) {
                aVar.f(true);
            } else {
                this.cuf.setData(aVar.aig());
            }
        } else {
            this.aHN.showToast(str);
        }
        this.cuf.eD(false);
        this.mProgressBar.setVisibility(8);
    }

    public void S(ArrayList<MarkData> arrayList) {
        this.cuf.setData(arrayList);
    }

    private void ahZ() {
        if (this.cug == null) {
            this.cug = new com.baidu.tbadk.core.dialog.a(this.aHN.getPageContext().getPageActivity());
            this.cug.cB(this.aHN.getPageContext().getString(n.i.sync_mark_fail));
            this.cug.cC(this.aHN.getPageContext().getString(n.i.neterror));
            if (this.cuh != null) {
                this.cug.a(this.aHN.getPageContext().getString(n.i.retry_rightnow), this.cuh);
            }
            this.cug.b(this.aHN.getPageContext().getString(n.i.confirm), new y(this));
            this.cug.b(this.aHN.getPageContext());
            this.cug.am(true);
        }
        this.cug.tv();
    }

    public void onChangeSkinType(int i) {
        this.aHN.getLayoutMode().k(this.bGY);
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aHN.getPageContext(), i);
            as.j(this.mNoDataView, n.c.mark_item_bg);
        }
    }

    public void aia() {
        this.cuf.aic();
        this.cuf.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.cug != null) {
            this.cug.dismiss();
            this.cug = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.cuf.aib();
    }

    public void completePullRefresh() {
        if (this.biH != null) {
            this.biH.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.cui;
    }

    public void bu(boolean z) {
        this.cui = z;
    }
}

package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class j {
    private TextView aEs;
    private LinearLayout aPn;
    private BdListView bby;
    EditMarkActivity cbD;
    private m cbE;
    private com.baidu.tbadk.core.dialog.a cbF = null;
    a.b cbG = null;
    private boolean cbH = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public j(EditMarkActivity editMarkActivity) {
        this.cbD = null;
        this.bby = null;
        this.mNoDataView = null;
        this.cbE = null;
        this.aEs = null;
        this.aPn = null;
        this.mProgressBar = null;
        this.cbD = editMarkActivity;
        editMarkActivity.setContentView(i.g.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(i.f.progress);
        this.aPn = (LinearLayout) editMarkActivity.findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cbD.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds160)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.aPn.addView(this.mNoDataView, 1);
        this.cbE = new m(editMarkActivity.getPageContext());
        this.cbE.ea(false);
        this.cbE.adt();
        this.mPullView = new com.baidu.tbadk.core.view.r(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bby = (BdListView) editMarkActivity.findViewById(i.f.list);
        this.bby.setAdapter((ListAdapter) this.cbE);
        this.bby.setPullRefresh(this.mPullView);
        this.bby.setOnSrollToBottomListener(editMarkActivity);
        this.bby.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(i.h.my_mark));
        this.aEs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(i.h.edit));
        this.aEs.setOnClickListener(editMarkActivity);
        this.aEs.setVisibility(4);
        this.cbE.x(editMarkActivity);
    }

    public TextView ado() {
        return this.aEs;
    }

    public void b(a.b bVar) {
        this.cbG = bVar;
    }

    public void changeEditState() {
        if (!this.cbE.FR()) {
            this.cbE.setEditState(true);
            this.aEs.setText(i.h.done);
            an.g(this.aEs, TbadkCoreApplication.m411getInst().getSkinType());
            this.cbE.notifyDataSetChanged();
            return;
        }
        this.cbE.setEditState(false);
        this.aEs.setText(i.h.edit);
        an.i(this.aEs, TbadkCoreApplication.m411getInst().getSkinType());
        this.cbE.notifyDataSetChanged();
    }

    public boolean IN() {
        return this.cbE.FR();
    }

    public int adp() {
        return i.f.home_lv_markitem_delete;
    }

    public void iy(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.cbE.dY(true);
        this.cbE.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void MS() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cbE.dY(true);
        if (str != null) {
            this.cbD.showToast(str);
        }
        if (aVar != null) {
            if (aVar.adz() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.adz() < 20) {
                this.cbE.setHasMore(false);
                this.cbE.dZ(!aVar.isFirst());
            } else {
                this.cbE.setHasMore(true);
                this.cbE.dZ(true);
            }
            this.cbE.ea(true);
            this.cbE.setData(aVar.ady());
            if (aVar.getCount() > 0) {
                this.aEs.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bby.setVisibility(0);
                this.cbE.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.aEs.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bby.setVisibility(8);
            }
        }
        this.cbE.dY(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bj(false);
        }
    }

    public void startSync() {
        this.cbD.showLoadingDialog(this.cbD.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.cbD.closeLoadingDialog();
        if (z) {
            this.cbE.adt();
        }
        if (str != null) {
            this.cbD.showToast(str);
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
            this.cbD.showToast(this.cbD.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.ady() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.ady().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.cbE.setData(aVar.ady());
                this.cbE.ea(true);
            }
        } else {
            this.cbD.showToast(str);
        }
        this.cbE.dZ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.cbE.setData(arrayList);
    }

    private void adq() {
        if (this.cbF == null) {
            this.cbF = new com.baidu.tbadk.core.dialog.a(this.cbD.getPageContext().getPageActivity());
            this.cbF.ct(this.cbD.getPageContext().getString(i.h.sync_mark_fail));
            this.cbF.cu(this.cbD.getPageContext().getString(i.h.neterror));
            if (this.cbG != null) {
                this.cbF.a(this.cbD.getPageContext().getString(i.h.retry_rightnow), this.cbG);
            }
            this.cbF.b(this.cbD.getPageContext().getString(i.h.confirm), new k(this));
            this.cbF.b(this.cbD.getPageContext());
            this.cbF.ak(true);
        }
        this.cbF.sO();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cbD.getPageContext(), i);
        this.cbD.getLayoutMode().k(this.aPn);
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cbD.getPageContext(), i);
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

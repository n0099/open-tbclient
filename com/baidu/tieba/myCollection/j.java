package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class j {
    private TextView aEh;
    private LinearLayout aPc;
    private BdListView bbn;
    EditMarkActivity cbs;
    private m cbt;
    private com.baidu.tbadk.core.dialog.a cbu = null;
    a.b cbv = null;
    private boolean cbw = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public j(EditMarkActivity editMarkActivity) {
        this.cbs = null;
        this.bbn = null;
        this.mNoDataView = null;
        this.cbt = null;
        this.aEh = null;
        this.aPc = null;
        this.mProgressBar = null;
        this.cbs = editMarkActivity;
        editMarkActivity.setContentView(i.g.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(i.f.progress);
        this.aPc = (LinearLayout) editMarkActivity.findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cbs.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds160)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.aPc.addView(this.mNoDataView, 1);
        this.cbt = new m(editMarkActivity.getPageContext());
        this.cbt.ea(false);
        this.cbt.adx();
        this.mPullView = new com.baidu.tbadk.core.view.r(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bbn = (BdListView) editMarkActivity.findViewById(i.f.list);
        this.bbn.setAdapter((ListAdapter) this.cbt);
        this.bbn.setPullRefresh(this.mPullView);
        this.bbn.setOnSrollToBottomListener(editMarkActivity);
        this.bbn.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(i.h.my_mark));
        this.aEh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(i.h.edit));
        this.aEh.setOnClickListener(editMarkActivity);
        this.aEh.setVisibility(4);
        this.cbt.x(editMarkActivity);
    }

    public TextView ads() {
        return this.aEh;
    }

    public void b(a.b bVar) {
        this.cbv = bVar;
    }

    public void changeEditState() {
        if (!this.cbt.FV()) {
            this.cbt.setEditState(true);
            this.aEh.setText(i.h.done);
            am.g(this.aEh, TbadkCoreApplication.m411getInst().getSkinType());
            this.cbt.notifyDataSetChanged();
            return;
        }
        this.cbt.setEditState(false);
        this.aEh.setText(i.h.edit);
        am.i(this.aEh, TbadkCoreApplication.m411getInst().getSkinType());
        this.cbt.notifyDataSetChanged();
    }

    public boolean IR() {
        return this.cbt.FV();
    }

    public int adt() {
        return i.f.home_lv_markitem_delete;
    }

    public void iy(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.cbt.dY(true);
        this.cbt.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void MW() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cbt.dY(true);
        if (str != null) {
            this.cbs.showToast(str);
        }
        if (aVar != null) {
            if (aVar.adD() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.adD() < 20) {
                this.cbt.setHasMore(false);
                this.cbt.dZ(!aVar.isFirst());
            } else {
                this.cbt.setHasMore(true);
                this.cbt.dZ(true);
            }
            this.cbt.ea(true);
            this.cbt.setData(aVar.adC());
            if (aVar.getCount() > 0) {
                this.aEh.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bbn.setVisibility(0);
                this.cbt.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.aEh.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bbn.setVisibility(8);
            }
        }
        this.cbt.dY(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bj(false);
        }
    }

    public void startSync() {
        this.cbs.showLoadingDialog(this.cbs.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.cbs.closeLoadingDialog();
        if (z) {
            this.cbt.adx();
        }
        if (str != null) {
            this.cbs.showToast(str);
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
            this.cbs.showToast(this.cbs.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.adC() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.adC().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.cbt.setData(aVar.adC());
                this.cbt.ea(true);
            }
        } else {
            this.cbs.showToast(str);
        }
        this.cbt.dZ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.cbt.setData(arrayList);
    }

    private void adu() {
        if (this.cbu == null) {
            this.cbu = new com.baidu.tbadk.core.dialog.a(this.cbs.getPageContext().getPageActivity());
            this.cbu.cs(this.cbs.getPageContext().getString(i.h.sync_mark_fail));
            this.cbu.ct(this.cbs.getPageContext().getString(i.h.neterror));
            if (this.cbv != null) {
                this.cbu.a(this.cbs.getPageContext().getString(i.h.retry_rightnow), this.cbv);
            }
            this.cbu.b(this.cbs.getPageContext().getString(i.h.confirm), new k(this));
            this.cbu.b(this.cbs.getPageContext());
            this.cbu.ak(true);
        }
        this.cbu.sR();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cbs.getPageContext(), i);
        this.cbs.getLayoutMode().k(this.aPc);
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cbs.getPageContext(), i);
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

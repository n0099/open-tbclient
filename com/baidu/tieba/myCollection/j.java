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
    private TextView aDm;
    private LinearLayout aPv;
    private BdListView bcc;
    EditMarkActivity cce;
    private m ccf;
    private com.baidu.tbadk.core.dialog.a ccg = null;
    a.b cch = null;
    private boolean cci = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public j(EditMarkActivity editMarkActivity) {
        this.cce = null;
        this.bcc = null;
        this.mNoDataView = null;
        this.ccf = null;
        this.aDm = null;
        this.aPv = null;
        this.mProgressBar = null;
        this.cce = editMarkActivity;
        editMarkActivity.setContentView(i.g.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(i.f.progress);
        this.aPv = (LinearLayout) editMarkActivity.findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cce.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds160)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.aPv.addView(this.mNoDataView, 1);
        this.ccf = new m(editMarkActivity.getPageContext());
        this.ccf.ec(false);
        this.ccf.adO();
        this.mPullView = new com.baidu.tbadk.core.view.r(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bcc = (BdListView) editMarkActivity.findViewById(i.f.list);
        this.bcc.setAdapter((ListAdapter) this.ccf);
        this.bcc.setPullRefresh(this.mPullView);
        this.bcc.setOnSrollToBottomListener(editMarkActivity);
        this.bcc.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(i.h.my_mark));
        this.aDm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(i.h.edit));
        this.aDm.setOnClickListener(editMarkActivity);
        this.aDm.setVisibility(4);
        this.ccf.x(editMarkActivity);
    }

    public TextView adJ() {
        return this.aDm;
    }

    public void b(a.b bVar) {
        this.cch = bVar;
    }

    public void changeEditState() {
        if (!this.ccf.FO()) {
            this.ccf.setEditState(true);
            this.aDm.setText(i.h.done);
            an.g(this.aDm, TbadkCoreApplication.m411getInst().getSkinType());
            this.ccf.notifyDataSetChanged();
            return;
        }
        this.ccf.setEditState(false);
        this.aDm.setText(i.h.edit);
        an.i(this.aDm, TbadkCoreApplication.m411getInst().getSkinType());
        this.ccf.notifyDataSetChanged();
    }

    public boolean Jd() {
        return this.ccf.FO();
    }

    public int adK() {
        return i.f.home_lv_markitem_delete;
    }

    public void iL(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.ccf.ea(true);
        this.ccf.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Nk() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.ccf.ea(true);
        if (str != null) {
            this.cce.showToast(str);
        }
        if (aVar != null) {
            if (aVar.adU() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.adU() < 20) {
                this.ccf.setHasMore(false);
                this.ccf.eb(!aVar.isFirst());
            } else {
                this.ccf.setHasMore(true);
                this.ccf.eb(true);
            }
            this.ccf.ec(true);
            this.ccf.setData(aVar.adT());
            if (aVar.getCount() > 0) {
                this.aDm.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bcc.setVisibility(0);
                this.ccf.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.aDm.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bcc.setVisibility(8);
            }
        }
        this.ccf.ea(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bm(false);
        }
    }

    public void startSync() {
        this.cce.showLoadingDialog(this.cce.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.cce.closeLoadingDialog();
        if (z) {
            this.ccf.adO();
        }
        if (str != null) {
            this.cce.showToast(str);
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
            this.cce.showToast(this.cce.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.adT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.adT().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.ccf.setData(aVar.adT());
                this.ccf.ec(true);
            }
        } else {
            this.cce.showToast(str);
        }
        this.ccf.eb(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.ccf.setData(arrayList);
    }

    private void adL() {
        if (this.ccg == null) {
            this.ccg = new com.baidu.tbadk.core.dialog.a(this.cce.getPageContext().getPageActivity());
            this.ccg.ct(this.cce.getPageContext().getString(i.h.sync_mark_fail));
            this.ccg.cu(this.cce.getPageContext().getString(i.h.neterror));
            if (this.cch != null) {
                this.ccg.a(this.cce.getPageContext().getString(i.h.retry_rightnow), this.cch);
            }
            this.ccg.b(this.cce.getPageContext().getString(i.h.confirm), new k(this));
            this.ccg.b(this.cce.getPageContext());
            this.ccg.ak(true);
        }
        this.ccg.sR();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cce.getPageContext(), i);
        this.cce.getLayoutMode().k(this.aPv);
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cce.getPageContext(), i);
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

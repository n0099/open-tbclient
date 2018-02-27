package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.d;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class c {
    private TextView bRT;
    private LinearLayout dvt;
    private BdListView exW;
    EditMarkActivity fye;
    private e fyf;
    private com.baidu.tbadk.core.dialog.a fyg = null;
    a.b fyh = null;
    private boolean fyi = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fye = null;
        this.exW = null;
        this.mNoDataView = null;
        this.fyf = null;
        this.bRT = null;
        this.dvt = null;
        this.mProgressBar = null;
        this.fye = editMarkActivity;
        editMarkActivity.setContentView(d.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.dvt = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fye.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.aC(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.dvt.addView(this.mNoDataView, 1);
        this.fyf = new e(editMarkActivity.getPageContext());
        this.fyf.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.exW = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.exW.setAdapter((ListAdapter) this.fyf);
        this.exW.setPullRefresh(this.mPullView);
        this.exW.setOnSrollToBottomListener(editMarkActivity);
        this.exW.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.j.my_mark));
        this.bRT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.j.edit));
        this.bRT.setOnClickListener(editMarkActivity);
        this.bRT.setVisibility(4);
        this.fyf.y(editMarkActivity);
    }

    public TextView aXO() {
        return this.bRT;
    }

    public void c(a.b bVar) {
        this.fyh = bVar;
    }

    public void aXP() {
        if (!this.fyf.Un()) {
            this.fyf.cX(true);
            this.bRT.setText(d.j.done);
            aj.e(this.bRT, TbadkCoreApplication.getInst().getSkinType());
            this.fyf.notifyDataSetChanged();
            return;
        }
        this.fyf.cX(false);
        this.bRT.setText(d.j.edit);
        aj.g(this.bRT, TbadkCoreApplication.getInst().getSkinType());
        this.fyf.notifyDataSetChanged();
    }

    public boolean aqH() {
        return this.fyf.Un();
    }

    public int aXQ() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fyf.setRefreshing(true);
        this.fyf.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aIG() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyf.setRefreshing(true);
        if (str != null) {
            this.fye.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYd() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYd() < 20) {
                this.fyf.setHasMore(false);
                this.fyf.jr(aVar.isFirst() ? false : true);
            } else {
                this.fyf.setHasMore(true);
                this.fyf.jr(true);
            }
            this.fyf.setData(aVar.aYc());
            if (aVar.getCount() > 0) {
                this.bRT.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.exW.setVisibility(0);
                this.fyf.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bRT.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.exW.setVisibility(8);
            }
        }
        this.fyf.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            ct(false);
        }
    }

    public void startSync() {
        this.fye.showLoadingDialog(this.fye.getPageContext().getString(d.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fye.closeLoadingDialog();
        if (str != null) {
            this.fye.showToast(str);
        }
        if (z2) {
            aXR();
        }
        this.fyf.notifyDataSetChanged();
    }

    public void arA() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fye.showToast(this.fye.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aYc() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aYc().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fyf.setData(aVar.aYc());
            }
        } else {
            this.fye.showToast(str);
        }
        this.fyf.jr(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ah(ArrayList<MarkData> arrayList) {
        this.fyf.setData(arrayList);
    }

    private void aXR() {
        if (this.fyg == null) {
            this.fyg = new com.baidu.tbadk.core.dialog.a(this.fye.getPageContext().getPageActivity());
            this.fyg.dj(this.fye.getPageContext().getString(d.j.sync_mark_fail));
            this.fyg.dk(this.fye.getPageContext().getString(d.j.neterror));
            if (this.fyh != null) {
                this.fyg.a(this.fye.getPageContext().getString(d.j.retry_rightnow), this.fyh);
            }
            this.fyg.b(this.fye.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fyg.b(this.fye.getPageContext());
            this.fyg.ba(true);
        }
        this.fyg.AU();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fye.getPageContext(), i);
        this.fye.getLayoutMode().aM(this.dvt);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fye.getPageContext(), i);
        }
    }

    public void aXS() {
        this.fyf.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fyg != null) {
            this.fyg.dismiss();
            this.fyg = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.exW != null) {
            this.exW.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyi;
    }

    public void ct(boolean z) {
        this.fyi = z;
    }
}

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
    private TextView bSg;
    private LinearLayout dvF;
    private BdListView eyi;
    EditMarkActivity fyq;
    private e fyr;
    private com.baidu.tbadk.core.dialog.a fys = null;
    a.b fyt = null;
    private boolean fyu = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fyq = null;
        this.eyi = null;
        this.mNoDataView = null;
        this.fyr = null;
        this.bSg = null;
        this.dvF = null;
        this.mProgressBar = null;
        this.fyq = editMarkActivity;
        editMarkActivity.setContentView(d.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.dvF = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fyq.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.aC(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.dvF.addView(this.mNoDataView, 1);
        this.fyr = new e(editMarkActivity.getPageContext());
        this.fyr.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.eyi = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.eyi.setAdapter((ListAdapter) this.fyr);
        this.eyi.setPullRefresh(this.mPullView);
        this.eyi.setOnSrollToBottomListener(editMarkActivity);
        this.eyi.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.j.my_mark));
        this.bSg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.j.edit));
        this.bSg.setOnClickListener(editMarkActivity);
        this.bSg.setVisibility(4);
        this.fyr.y(editMarkActivity);
    }

    public TextView aXP() {
        return this.bSg;
    }

    public void c(a.b bVar) {
        this.fyt = bVar;
    }

    public void aXQ() {
        if (!this.fyr.Uo()) {
            this.fyr.cX(true);
            this.bSg.setText(d.j.done);
            aj.e(this.bSg, TbadkCoreApplication.getInst().getSkinType());
            this.fyr.notifyDataSetChanged();
            return;
        }
        this.fyr.cX(false);
        this.bSg.setText(d.j.edit);
        aj.g(this.bSg, TbadkCoreApplication.getInst().getSkinType());
        this.fyr.notifyDataSetChanged();
    }

    public boolean aqI() {
        return this.fyr.Uo();
    }

    public int aXR() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fyr.setRefreshing(true);
        this.fyr.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aIH() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyr.setRefreshing(true);
        if (str != null) {
            this.fyq.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYe() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYe() < 20) {
                this.fyr.setHasMore(false);
                this.fyr.jr(aVar.isFirst() ? false : true);
            } else {
                this.fyr.setHasMore(true);
                this.fyr.jr(true);
            }
            this.fyr.setData(aVar.aYd());
            if (aVar.getCount() > 0) {
                this.bSg.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.eyi.setVisibility(0);
                this.fyr.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bSg.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.eyi.setVisibility(8);
            }
        }
        this.fyr.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            ct(false);
        }
    }

    public void startSync() {
        this.fyq.showLoadingDialog(this.fyq.getPageContext().getString(d.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fyq.closeLoadingDialog();
        if (str != null) {
            this.fyq.showToast(str);
        }
        if (z2) {
            aXS();
        }
        this.fyr.notifyDataSetChanged();
    }

    public void arB() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fyq.showToast(this.fyq.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aYd() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aYd().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fyr.setData(aVar.aYd());
            }
        } else {
            this.fyq.showToast(str);
        }
        this.fyr.jr(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ah(ArrayList<MarkData> arrayList) {
        this.fyr.setData(arrayList);
    }

    private void aXS() {
        if (this.fys == null) {
            this.fys = new com.baidu.tbadk.core.dialog.a(this.fyq.getPageContext().getPageActivity());
            this.fys.dj(this.fyq.getPageContext().getString(d.j.sync_mark_fail));
            this.fys.dk(this.fyq.getPageContext().getString(d.j.neterror));
            if (this.fyt != null) {
                this.fys.a(this.fyq.getPageContext().getString(d.j.retry_rightnow), this.fyt);
            }
            this.fys.b(this.fyq.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fys.b(this.fyq.getPageContext());
            this.fys.ba(true);
        }
        this.fys.AU();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fyq.getPageContext(), i);
        this.fyq.getLayoutMode().aM(this.dvF);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fyq.getPageContext(), i);
        }
    }

    public void aXT() {
        this.fyr.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fys != null) {
            this.fys.dismiss();
            this.fys = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.eyi != null) {
            this.eyi.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyu;
    }

    public void ct(boolean z) {
        this.fyu = z;
    }
}

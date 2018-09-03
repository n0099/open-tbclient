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
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.f;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class c {
    private TextView bmv;
    private LinearLayout cZh;
    private BdListView dFw;
    EditMarkActivity fjF;
    private e fjG;
    private com.baidu.tbadk.core.dialog.a fjH = null;
    a.b fjI = null;
    private boolean fjJ = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fjF = null;
        this.dFw = null;
        this.mNoDataView = null;
        this.fjG = null;
        this.bmv = null;
        this.cZh = null;
        this.mProgressBar = null;
        this.fjF = editMarkActivity;
        editMarkActivity.setContentView(f.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(f.g.progress);
        this.cZh = (LinearLayout) editMarkActivity.findViewById(f.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fjF.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(f.e.ds160)), NoDataViewFactory.d.E(f.j.mark_nodata, f.j.mark_nodata_2), null);
        this.cZh.addView(this.mNoDataView, 1);
        this.fjG = new e(editMarkActivity.getPageContext());
        this.fjG.notifyDataSetChanged();
        this.mPullView = new h(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dFw = (BdListView) editMarkActivity.findViewById(f.g.list);
        this.dFw.setAdapter((ListAdapter) this.fjG);
        this.dFw.setPullRefresh(this.mPullView);
        this.dFw.setOnSrollToBottomListener(editMarkActivity);
        this.dFw.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(f.j.my_mark));
        this.bmv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(f.j.edit));
        this.bmv.setOnClickListener(editMarkActivity);
        this.bmv.setVisibility(4);
        this.fjG.A(editMarkActivity);
    }

    public TextView aWF() {
        return this.bmv;
    }

    public void c(a.b bVar) {
        this.fjI = bVar;
    }

    public void aWG() {
        if (!this.fjG.QV()) {
            this.fjG.cy(true);
            this.bmv.setText(f.j.done);
            am.d(this.bmv, TbadkCoreApplication.getInst().getSkinType());
            this.fjG.notifyDataSetChanged();
            return;
        }
        this.fjG.cy(false);
        this.bmv.setText(f.j.edit);
        am.f(this.bmv, TbadkCoreApplication.getInst().getSkinType());
        this.fjG.notifyDataSetChanged();
    }

    public boolean aoT() {
        return this.fjG.QV();
    }

    public int aWH() {
        return f.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fjG.setRefreshing(true);
        this.fjG.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void azg() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fjG.setRefreshing(true);
        if (str != null) {
            this.fjF.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aWU() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aWU() < 20) {
                this.fjG.setHasMore(false);
                this.fjG.iU(aVar.isFirst() ? false : true);
            } else {
                this.fjG.setHasMore(true);
                this.fjG.iU(true);
            }
            this.fjG.setData(aVar.aWT());
            if (aVar.getCount() > 0) {
                this.bmv.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dFw.setVisibility(0);
                this.fjG.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bmv.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dFw.setVisibility(8);
            }
        }
        this.fjG.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bR(false);
        }
    }

    public void startSync() {
        this.fjF.showLoadingDialog(this.fjF.getPageContext().getString(f.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fjF.closeLoadingDialog();
        if (str != null) {
            this.fjF.showToast(str);
        }
        if (z2) {
            aWI();
        }
        this.fjG.notifyDataSetChanged();
    }

    public void apS() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fjF.showToast(this.fjF.getPageContext().getString(f.j.delete_success));
            if (aVar == null || aVar.aWT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aWT().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fjG.setData(aVar.aWT());
            }
        } else {
            this.fjF.showToast(str);
        }
        this.fjG.iU(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fjG.setData(arrayList);
    }

    private void aWI() {
        if (this.fjH == null) {
            this.fjH = new com.baidu.tbadk.core.dialog.a(this.fjF.getPageContext().getPageActivity());
            this.fjH.dA(this.fjF.getPageContext().getString(f.j.sync_mark_fail));
            this.fjH.dB(this.fjF.getPageContext().getString(f.j.neterror));
            if (this.fjI != null) {
                this.fjH.a(this.fjF.getPageContext().getString(f.j.retry_rightnow), this.fjI);
            }
            this.fjH.b(this.fjF.getPageContext().getString(f.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fjH.b(this.fjF.getPageContext());
            this.fjH.aw(true);
        }
        this.fjH.xe();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fjF.getPageContext(), i);
        this.fjF.getLayoutMode().onModeChanged(this.cZh);
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fjF.getPageContext(), i);
        }
    }

    public void aWJ() {
        this.fjG.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fjH != null) {
            this.fjH.dismiss();
            this.fjH = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dFw != null) {
            this.dFw.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fjJ;
    }

    public void bR(boolean z) {
        this.fjJ = z;
    }
}

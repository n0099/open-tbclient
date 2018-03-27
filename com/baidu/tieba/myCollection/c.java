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
    private TextView bRW;
    private LinearLayout dvw;
    private BdListView eyn;
    EditMarkActivity fyu;
    private e fyv;
    private com.baidu.tbadk.core.dialog.a fyw = null;
    a.b fyx = null;
    private boolean fyy = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fyu = null;
        this.eyn = null;
        this.mNoDataView = null;
        this.fyv = null;
        this.bRW = null;
        this.dvw = null;
        this.mProgressBar = null;
        this.fyu = editMarkActivity;
        editMarkActivity.setContentView(d.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.dvw = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fyu.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.aC(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.dvw.addView(this.mNoDataView, 1);
        this.fyv = new e(editMarkActivity.getPageContext());
        this.fyv.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.eyn = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.eyn.setAdapter((ListAdapter) this.fyv);
        this.eyn.setPullRefresh(this.mPullView);
        this.eyn.setOnSrollToBottomListener(editMarkActivity);
        this.eyn.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.j.my_mark));
        this.bRW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.j.edit));
        this.bRW.setOnClickListener(editMarkActivity);
        this.bRW.setVisibility(4);
        this.fyv.y(editMarkActivity);
    }

    public TextView aXP() {
        return this.bRW;
    }

    public void c(a.b bVar) {
        this.fyx = bVar;
    }

    public void aXQ() {
        if (!this.fyv.Uo()) {
            this.fyv.cX(true);
            this.bRW.setText(d.j.done);
            aj.e(this.bRW, TbadkCoreApplication.getInst().getSkinType());
            this.fyv.notifyDataSetChanged();
            return;
        }
        this.fyv.cX(false);
        this.bRW.setText(d.j.edit);
        aj.g(this.bRW, TbadkCoreApplication.getInst().getSkinType());
        this.fyv.notifyDataSetChanged();
    }

    public boolean aqI() {
        return this.fyv.Uo();
    }

    public int aXR() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fyv.setRefreshing(true);
        this.fyv.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aIH() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyv.setRefreshing(true);
        if (str != null) {
            this.fyu.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYe() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYe() < 20) {
                this.fyv.setHasMore(false);
                this.fyv.jw(aVar.isFirst() ? false : true);
            } else {
                this.fyv.setHasMore(true);
                this.fyv.jw(true);
            }
            this.fyv.setData(aVar.aYd());
            if (aVar.getCount() > 0) {
                this.bRW.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.eyn.setVisibility(0);
                this.fyv.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bRW.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.eyn.setVisibility(8);
            }
        }
        this.fyv.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            ct(false);
        }
    }

    public void startSync() {
        this.fyu.showLoadingDialog(this.fyu.getPageContext().getString(d.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fyu.closeLoadingDialog();
        if (str != null) {
            this.fyu.showToast(str);
        }
        if (z2) {
            aXS();
        }
        this.fyv.notifyDataSetChanged();
    }

    public void arB() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fyu.showToast(this.fyu.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aYd() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aYd().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fyv.setData(aVar.aYd());
            }
        } else {
            this.fyu.showToast(str);
        }
        this.fyv.jw(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ah(ArrayList<MarkData> arrayList) {
        this.fyv.setData(arrayList);
    }

    private void aXS() {
        if (this.fyw == null) {
            this.fyw = new com.baidu.tbadk.core.dialog.a(this.fyu.getPageContext().getPageActivity());
            this.fyw.dj(this.fyu.getPageContext().getString(d.j.sync_mark_fail));
            this.fyw.dk(this.fyu.getPageContext().getString(d.j.neterror));
            if (this.fyx != null) {
                this.fyw.a(this.fyu.getPageContext().getString(d.j.retry_rightnow), this.fyx);
            }
            this.fyw.b(this.fyu.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fyw.b(this.fyu.getPageContext());
            this.fyw.ba(true);
        }
        this.fyw.AV();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fyu.getPageContext(), i);
        this.fyu.getLayoutMode().aM(this.dvw);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fyu.getPageContext(), i);
        }
    }

    public void aXT() {
        this.fyv.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fyw != null) {
            this.fyw.dismiss();
            this.fyw = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.eyn != null) {
            this.eyn.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyy;
    }

    public void ct(boolean z) {
        this.fyy = z;
    }
}

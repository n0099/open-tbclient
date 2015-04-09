package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BdListView aZy;
    private TextView auy;
    private LinearLayout axr;
    EditMarkActivity bEb;
    private h bEc;
    private com.baidu.tbadk.core.dialog.a bEd = null;
    com.baidu.tbadk.core.dialog.d bEe = null;
    private boolean bEf = false;
    private NavigationBar mNavigationBar;
    private s mNoDataView;
    private ProgressBar mProgressBar;
    private ag mPullView;

    public f(EditMarkActivity editMarkActivity) {
        this.bEb = null;
        this.aZy = null;
        this.mNoDataView = null;
        this.bEc = null;
        this.auy = null;
        this.axr = null;
        this.mProgressBar = null;
        this.bEb = editMarkActivity;
        editMarkActivity.setContentView(w.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(v.progress);
        this.axr = (LinearLayout) editMarkActivity.findViewById(v.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bEb.getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.ds160)), com.baidu.tbadk.core.view.w.r(y.mark_nodata, y.mark_nodata_2), null);
        this.axr.addView(this.mNoDataView, 1);
        this.bEc = new h(editMarkActivity);
        this.bEc.dx(false);
        this.bEc.Yg();
        this.mPullView = new ag(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.aZy = (BdListView) editMarkActivity.findViewById(v.list);
        this.aZy.setAdapter((ListAdapter) this.bEc);
        this.aZy.setPullRefresh(this.mPullView);
        this.aZy.setOnSrollToBottomListener(editMarkActivity);
        this.aZy.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(y.my_mark));
        this.auy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(y.edit));
        this.auy.setOnClickListener(editMarkActivity);
        this.auy.setVisibility(4);
        this.bEc.s(editMarkActivity);
    }

    public TextView Yb() {
        return this.auy;
    }

    public void a(com.baidu.tbadk.core.dialog.d dVar) {
        this.bEe = dVar;
    }

    public void Yc() {
        if (!this.bEc.Eo()) {
            this.bEc.setEditState(true);
            this.auy.setText(y.done);
            ba.g(this.auy, TbadkCoreApplication.m411getInst().getSkinType());
            this.bEc.notifyDataSetChanged();
            return;
        }
        this.bEc.setEditState(false);
        this.auy.setText(y.edit);
        ba.i(this.auy, TbadkCoreApplication.m411getInst().getSkinType());
        this.bEc.notifyDataSetChanged();
    }

    public boolean Hu() {
        return this.bEc.Eo();
    }

    public int Yd() {
        return v.home_lv_markitem_delete;
    }

    public void gY(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bEc.setRefreshing(true);
        this.bEc.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Qw() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.bEc.setRefreshing(true);
        if (str != null) {
            this.bEb.showToast(str);
        }
        if (aVar != null) {
            if (aVar.Yk() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.Yk() < 20) {
                this.bEc.setHasMore(false);
                this.bEc.dw(!aVar.isFirst());
            } else {
                this.bEc.setHasMore(true);
                this.bEc.dw(true);
            }
            this.bEc.dx(true);
            this.bEc.p(aVar.Yj());
            if (aVar.getCount() > 0) {
                this.auy.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.aZy.setVisibility(0);
                this.bEc.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.auy.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.aZy.setVisibility(8);
            }
        }
        this.bEc.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !Bl()) {
            showLoading();
        }
        if (Bl()) {
            aV(false);
        }
    }

    public void startSync() {
        this.bEb.showLoadingDialog(this.bEb.getPageContext().getString(y.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bEb.closeLoadingDialog();
        if (z) {
            this.bEc.Yg();
        }
        if (str != null) {
            this.bEb.showToast(str);
        }
        if (z2) {
            Ye();
        }
        this.bEc.notifyDataSetChanged();
    }

    public void HS() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bEb.showToast(this.bEb.getPageContext().getString(y.del_mark_success));
            if (aVar == null || aVar.Yj() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.Yj().size() == 0) {
                aVar.e(true);
            } else {
                this.bEc.p(aVar.Yj());
                this.bEc.dx(true);
            }
        } else {
            this.bEb.showToast(str);
        }
        this.bEc.dw(false);
        this.mProgressBar.setVisibility(8);
    }

    public void J(ArrayList<MarkData> arrayList) {
        this.bEc.p(arrayList);
    }

    private void Ye() {
        if (this.bEd == null) {
            this.bEd = new com.baidu.tbadk.core.dialog.a(this.bEb.getPageContext().getPageActivity());
            this.bEd.bZ(this.bEb.getPageContext().getString(y.sync_mark_fail));
            this.bEd.ca(this.bEb.getPageContext().getString(y.neterror));
            if (this.bEe != null) {
                this.bEd.a(this.bEb.getPageContext().getString(y.retry_rightnow), this.bEe);
            }
            this.bEd.b(this.bEb.getPageContext().getString(y.confirm), new g(this));
            this.bEd.b(this.bEb.getPageContext());
            this.bEd.ad(true);
        }
        this.bEd.re();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bEb.getPageContext(), i);
        this.bEb.getLayoutMode().h(this.axr);
        if (this.mPullView != null) {
            this.mPullView.ct(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bEb.getPageContext(), i);
        }
    }

    public void Yf() {
        this.bEc.Yg();
        this.bEc.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bEd != null) {
            this.bEd.dismiss();
            this.bEd = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bEc.WU();
    }

    public void mW() {
        if (this.aZy != null) {
            this.aZy.mW();
        }
    }

    public boolean Bl() {
        return this.bEf;
    }

    public void aV(boolean z) {
        this.bEf = z;
    }
}

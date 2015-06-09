package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.al;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private LinearLayout aIr;
    private TextView awc;
    EditMarkActivity bGX;
    private h bGY;
    private com.baidu.tbadk.core.dialog.a bGZ = null;
    com.baidu.tbadk.core.dialog.d bHa = null;
    private boolean bHb = false;
    private BdListView bcg;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private ProgressBar mProgressBar;
    private al mPullView;

    public f(EditMarkActivity editMarkActivity) {
        this.bGX = null;
        this.bcg = null;
        this.mNoDataView = null;
        this.bGY = null;
        this.awc = null;
        this.aIr = null;
        this.mProgressBar = null;
        this.bGX = editMarkActivity;
        editMarkActivity.setContentView(r.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(q.progress);
        this.aIr = (LinearLayout) editMarkActivity.findViewById(q.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bGX.getPageContext().getPageActivity(), null, aa.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(o.ds160)), ab.s(t.mark_nodata, t.mark_nodata_2), null);
        this.aIr.addView(this.mNoDataView, 1);
        this.bGY = new h(editMarkActivity);
        this.bGY.dJ(false);
        this.bGY.ZH();
        this.mPullView = new al(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bcg = (BdListView) editMarkActivity.findViewById(q.list);
        this.bcg.setAdapter((ListAdapter) this.bGY);
        this.bcg.setPullRefresh(this.mPullView);
        this.bcg.setOnSrollToBottomListener(editMarkActivity);
        this.bcg.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(t.my_mark));
        this.awc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(t.edit));
        this.awc.setOnClickListener(editMarkActivity);
        this.awc.setVisibility(4);
        this.bGY.r(editMarkActivity);
    }

    public TextView ZB() {
        return this.awc;
    }

    public void a(com.baidu.tbadk.core.dialog.d dVar) {
        this.bHa = dVar;
    }

    public void ZC() {
        if (!this.bGY.Fc()) {
            this.bGY.setEditState(true);
            this.awc.setText(t.done);
            ay.g(this.awc, TbadkCoreApplication.m411getInst().getSkinType());
            this.bGY.notifyDataSetChanged();
            return;
        }
        this.bGY.setEditState(false);
        this.awc.setText(t.edit);
        ay.i(this.awc, TbadkCoreApplication.m411getInst().getSkinType());
        this.bGY.notifyDataSetChanged();
    }

    public boolean Iv() {
        return this.bGY.Fc();
    }

    public int ZD() {
        return q.home_lv_markitem_delete;
    }

    public void hp(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bGY.dH(true);
        this.bGY.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void RL() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.bGY.dH(true);
        if (str != null) {
            this.bGX.showToast(str);
        }
        if (aVar != null) {
            if (aVar.ZL() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.ZL() < 20) {
                this.bGY.setHasMore(false);
                this.bGY.dI(!aVar.isFirst());
            } else {
                this.bGY.setHasMore(true);
                this.bGY.dI(true);
            }
            this.bGY.dJ(true);
            this.bGY.setData(aVar.ZK());
            if (aVar.getCount() > 0) {
                this.awc.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bcg.setVisibility(0);
                this.bGY.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.awc.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bcg.setVisibility(8);
            }
        }
        this.bGY.dH(false);
        this.mProgressBar.setVisibility(8);
        if (z && !BY()) {
            showLoading();
        }
        if (BY()) {
            bc(false);
        }
    }

    public void startSync() {
        this.bGX.showLoadingDialog(this.bGX.getPageContext().getString(t.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bGX.closeLoadingDialog();
        if (z) {
            this.bGY.ZH();
        }
        if (str != null) {
            this.bGX.showToast(str);
        }
        if (z2) {
            ZE();
        }
        this.bGY.notifyDataSetChanged();
    }

    public void IT() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bGX.showToast(this.bGX.getPageContext().getString(t.del_mark_success));
            if (aVar == null || aVar.ZK() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.ZK().size() == 0) {
                aVar.e(true);
            } else {
                this.bGY.setData(aVar.ZK());
                this.bGY.dJ(true);
            }
        } else {
            this.bGX.showToast(str);
        }
        this.bGY.dI(false);
        this.mProgressBar.setVisibility(8);
    }

    public void G(ArrayList<MarkData> arrayList) {
        this.bGY.setData(arrayList);
    }

    private void ZE() {
        if (this.bGZ == null) {
            this.bGZ = new com.baidu.tbadk.core.dialog.a(this.bGX.getPageContext().getPageActivity());
            this.bGZ.cm(this.bGX.getPageContext().getString(t.sync_mark_fail));
            this.bGZ.cn(this.bGX.getPageContext().getString(t.neterror));
            if (this.bHa != null) {
                this.bGZ.a(this.bGX.getPageContext().getString(t.retry_rightnow), this.bHa);
            }
            this.bGZ.b(this.bGX.getPageContext().getString(t.confirm), new g(this));
            this.bGZ.b(this.bGX.getPageContext());
            this.bGZ.ah(true);
        }
        this.bGZ.rL();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bGX.getPageContext(), i);
        this.bGX.getLayoutMode().j(this.aIr);
        if (this.mPullView != null) {
            this.mPullView.cy(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bGX.getPageContext(), i);
        }
    }

    public void ZF() {
        this.bGY.ZH();
        this.bGY.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bGZ != null) {
            this.bGZ.dismiss();
            this.bGZ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bGY.ZG();
    }

    public void completePullRefresh() {
        if (this.bcg != null) {
            this.bcg.completePullRefresh();
        }
    }

    public boolean BY() {
        return this.bHb;
    }

    public void bc(boolean z) {
        this.bHb = z;
    }
}

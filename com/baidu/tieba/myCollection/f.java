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
    private LinearLayout aIq;
    private TextView awb;
    EditMarkActivity bGW;
    private h bGX;
    private com.baidu.tbadk.core.dialog.a bGY = null;
    com.baidu.tbadk.core.dialog.d bGZ = null;
    private boolean bHa = false;
    private BdListView bcf;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private ProgressBar mProgressBar;
    private al mPullView;

    public f(EditMarkActivity editMarkActivity) {
        this.bGW = null;
        this.bcf = null;
        this.mNoDataView = null;
        this.bGX = null;
        this.awb = null;
        this.aIq = null;
        this.mProgressBar = null;
        this.bGW = editMarkActivity;
        editMarkActivity.setContentView(r.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(q.progress);
        this.aIq = (LinearLayout) editMarkActivity.findViewById(q.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bGW.getPageContext().getPageActivity(), null, aa.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(o.ds160)), ab.s(t.mark_nodata, t.mark_nodata_2), null);
        this.aIq.addView(this.mNoDataView, 1);
        this.bGX = new h(editMarkActivity);
        this.bGX.dJ(false);
        this.bGX.ZG();
        this.mPullView = new al(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bcf = (BdListView) editMarkActivity.findViewById(q.list);
        this.bcf.setAdapter((ListAdapter) this.bGX);
        this.bcf.setPullRefresh(this.mPullView);
        this.bcf.setOnSrollToBottomListener(editMarkActivity);
        this.bcf.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(t.my_mark));
        this.awb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(t.edit));
        this.awb.setOnClickListener(editMarkActivity);
        this.awb.setVisibility(4);
        this.bGX.r(editMarkActivity);
    }

    public TextView ZA() {
        return this.awb;
    }

    public void a(com.baidu.tbadk.core.dialog.d dVar) {
        this.bGZ = dVar;
    }

    public void ZB() {
        if (!this.bGX.Fb()) {
            this.bGX.setEditState(true);
            this.awb.setText(t.done);
            ay.g(this.awb, TbadkCoreApplication.m411getInst().getSkinType());
            this.bGX.notifyDataSetChanged();
            return;
        }
        this.bGX.setEditState(false);
        this.awb.setText(t.edit);
        ay.i(this.awb, TbadkCoreApplication.m411getInst().getSkinType());
        this.bGX.notifyDataSetChanged();
    }

    public boolean Iu() {
        return this.bGX.Fb();
    }

    public int ZC() {
        return q.home_lv_markitem_delete;
    }

    public void hp(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bGX.dH(true);
        this.bGX.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void RK() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.bGX.dH(true);
        if (str != null) {
            this.bGW.showToast(str);
        }
        if (aVar != null) {
            if (aVar.ZK() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.ZK() < 20) {
                this.bGX.setHasMore(false);
                this.bGX.dI(!aVar.isFirst());
            } else {
                this.bGX.setHasMore(true);
                this.bGX.dI(true);
            }
            this.bGX.dJ(true);
            this.bGX.setData(aVar.ZJ());
            if (aVar.getCount() > 0) {
                this.awb.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bcf.setVisibility(0);
                this.bGX.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.awb.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bcf.setVisibility(8);
            }
        }
        this.bGX.dH(false);
        this.mProgressBar.setVisibility(8);
        if (z && !BX()) {
            showLoading();
        }
        if (BX()) {
            bc(false);
        }
    }

    public void startSync() {
        this.bGW.showLoadingDialog(this.bGW.getPageContext().getString(t.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bGW.closeLoadingDialog();
        if (z) {
            this.bGX.ZG();
        }
        if (str != null) {
            this.bGW.showToast(str);
        }
        if (z2) {
            ZD();
        }
        this.bGX.notifyDataSetChanged();
    }

    public void IS() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bGW.showToast(this.bGW.getPageContext().getString(t.del_mark_success));
            if (aVar == null || aVar.ZJ() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.ZJ().size() == 0) {
                aVar.e(true);
            } else {
                this.bGX.setData(aVar.ZJ());
                this.bGX.dJ(true);
            }
        } else {
            this.bGW.showToast(str);
        }
        this.bGX.dI(false);
        this.mProgressBar.setVisibility(8);
    }

    public void G(ArrayList<MarkData> arrayList) {
        this.bGX.setData(arrayList);
    }

    private void ZD() {
        if (this.bGY == null) {
            this.bGY = new com.baidu.tbadk.core.dialog.a(this.bGW.getPageContext().getPageActivity());
            this.bGY.cm(this.bGW.getPageContext().getString(t.sync_mark_fail));
            this.bGY.cn(this.bGW.getPageContext().getString(t.neterror));
            if (this.bGZ != null) {
                this.bGY.a(this.bGW.getPageContext().getString(t.retry_rightnow), this.bGZ);
            }
            this.bGY.b(this.bGW.getPageContext().getString(t.confirm), new g(this));
            this.bGY.b(this.bGW.getPageContext());
            this.bGY.ah(true);
        }
        this.bGY.rL();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bGW.getPageContext(), i);
        this.bGW.getLayoutMode().j(this.aIq);
        if (this.mPullView != null) {
            this.mPullView.cy(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bGW.getPageContext(), i);
        }
    }

    public void ZE() {
        this.bGX.ZG();
        this.bGX.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bGY != null) {
            this.bGY.dismiss();
            this.bGY = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bGX.ZF();
    }

    public void completePullRefresh() {
        if (this.bcf != null) {
            this.bcf.completePullRefresh();
        }
    }

    public boolean BX() {
        return this.bHa;
    }

    public void bc(boolean z) {
        this.bHa = z;
    }
}

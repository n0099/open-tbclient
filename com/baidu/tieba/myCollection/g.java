package com.baidu.tieba.myCollection;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    private TextView amB;
    private BdListView auo;
    EditMarkActivity byt;
    private i byu;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private LinearLayout mParent;
    private ProgressBar mProgressBar;
    private ak mPullView;
    private Dialog byv = null;
    DialogInterface.OnClickListener brX = null;
    private boolean byw = false;

    public g(EditMarkActivity editMarkActivity) {
        this.byt = null;
        this.auo = null;
        this.mNoDataView = null;
        this.byu = null;
        this.amB = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.byt = editMarkActivity;
        editMarkActivity.setContentView(com.baidu.tieba.x.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(w.progress);
        this.mParent = (LinearLayout) editMarkActivity.findViewById(w.parent);
        this.mNoDataView = NoDataViewFactory.a(this.byt.getPageContext().getPageActivity(), null, aa.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkApplication.getInst().getResources().getDimension(u.ds160)), ab.t(z.mark_nodata, z.mark_nodata_2), null);
        this.mParent.addView(this.mNoDataView, 1);
        this.byu = new i(editMarkActivity);
        this.byu.dK(false);
        this.byu.WC();
        this.mPullView = new ak(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.auo = (BdListView) editMarkActivity.findViewById(w.list);
        this.auo.setAdapter((ListAdapter) this.byu);
        this.auo.setPullRefresh(this.mPullView);
        this.auo.setOnSrollToBottomListener(editMarkActivity);
        this.auo.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(z.my_mark));
        this.amB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(z.edit));
        this.amB.setOnClickListener(editMarkActivity);
        this.amB.setVisibility(4);
        this.byu.y(editMarkActivity);
    }

    public TextView Wx() {
        return this.amB;
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.brX = onClickListener;
    }

    public void Wy() {
        if (!this.byu.AT()) {
            this.byu.setEditState(true);
            this.amB.setText(z.done);
            bc.g(this.amB, TbadkApplication.getInst().getSkinType());
            this.byu.notifyDataSetChanged();
            return;
        }
        this.byu.setEditState(false);
        this.amB.setText(z.edit);
        bc.i(this.amB, TbadkApplication.getInst().getSkinType());
        this.byu.notifyDataSetChanged();
    }

    public int Wz() {
        return w.home_lv_markitem_delete;
    }

    public void gW(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.byu.dI(true);
        this.byu.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Ou() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tbadk.baseEditMark.a aVar, boolean z) {
        this.byu.dI(true);
        if (str != null) {
            this.byt.showToast(str);
        }
        if (aVar != null) {
            if (aVar.kY() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.kY() < 20) {
                this.byu.setHasMore(false);
                this.byu.dJ(!aVar.isFirst());
            } else {
                this.byu.setHasMore(true);
                this.byu.dJ(true);
            }
            this.byu.dK(true);
            this.byu.s(aVar.kX());
            if (aVar.getCount() > 0) {
                this.amB.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.auo.setVisibility(0);
                this.byu.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.amB.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.auo.setVisibility(8);
            }
        }
        this.byu.dI(false);
        this.mProgressBar.setVisibility(8);
        if (z && !xR()) {
            showLoading();
        }
        if (xR()) {
            aR(false);
        }
    }

    public void startSync() {
        this.byt.showLoadingDialog(this.byt.getPageContext().getString(z.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.byt.closeLoadingDialog();
        if (z) {
            this.byu.WC();
        }
        if (str != null) {
            this.byt.showToast(str);
        }
        if (z2) {
            WA();
        }
        this.byu.notifyDataSetChanged();
    }

    public void DH() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tbadk.baseEditMark.a aVar) {
        if (z) {
            this.byt.showToast(this.byt.getPageContext().getString(z.del_mark_success));
            if (aVar == null || aVar.kX() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.kX().size() == 0) {
                aVar.c((Boolean) true);
            } else {
                this.byu.s(aVar.kX());
                this.byu.dK(true);
            }
        } else {
            this.byt.showToast(str);
        }
        this.byu.dJ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void H(ArrayList<MarkData> arrayList) {
        this.byu.s(arrayList);
    }

    private void WA() {
        if (this.byv == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.byt.getPageContext().getPageActivity());
            builder.setTitle(this.byt.getPageContext().getString(z.sync_mark_fail));
            builder.setMessage(this.byt.getPageContext().getString(z.neterror));
            if (this.brX != null) {
                builder.setPositiveButton(this.byt.getPageContext().getString(z.retry_rightnow), this.brX);
            }
            builder.setNegativeButton(this.byt.getPageContext().getString(z.confirm), new h(this));
            this.byv = builder.create();
            this.byv.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.k.a(this.byv, this.byt.getPageContext());
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.byt.getPageContext(), i);
        this.byt.getLayoutMode().h(this.mParent);
        if (this.mPullView != null) {
            this.mPullView.cs(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.byt.getPageContext(), i);
        }
    }

    public void WB() {
        this.byu.WC();
        this.byu.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.byv != null) {
            com.baidu.adp.lib.g.k.b(this.byv, this.byt.getPageContext());
            this.byv = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.byu.Ub();
    }

    public void jB() {
        if (this.auo != null) {
            this.auo.jB();
        }
    }

    public boolean xR() {
        return this.byw;
    }

    public void aR(boolean z) {
        this.byw = z;
    }
}

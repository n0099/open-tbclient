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
    private TextView amE;
    private BdListView aur;
    EditMarkActivity byu;
    private i byv;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private LinearLayout mParent;
    private ProgressBar mProgressBar;
    private ak mPullView;
    private Dialog byw = null;
    DialogInterface.OnClickListener brY = null;
    private boolean byx = false;

    public g(EditMarkActivity editMarkActivity) {
        this.byu = null;
        this.aur = null;
        this.mNoDataView = null;
        this.byv = null;
        this.amE = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.byu = editMarkActivity;
        editMarkActivity.setContentView(com.baidu.tieba.x.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(w.progress);
        this.mParent = (LinearLayout) editMarkActivity.findViewById(w.parent);
        this.mNoDataView = NoDataViewFactory.a(this.byu.getPageContext().getPageActivity(), null, aa.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkApplication.getInst().getResources().getDimension(u.ds160)), ab.t(z.mark_nodata, z.mark_nodata_2), null);
        this.mParent.addView(this.mNoDataView, 1);
        this.byv = new i(editMarkActivity);
        this.byv.dK(false);
        this.byv.WH();
        this.mPullView = new ak(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.aur = (BdListView) editMarkActivity.findViewById(w.list);
        this.aur.setAdapter((ListAdapter) this.byv);
        this.aur.setPullRefresh(this.mPullView);
        this.aur.setOnSrollToBottomListener(editMarkActivity);
        this.aur.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(z.my_mark));
        this.amE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(z.edit));
        this.amE.setOnClickListener(editMarkActivity);
        this.amE.setVisibility(4);
        this.byv.y(editMarkActivity);
    }

    public TextView WC() {
        return this.amE;
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.brY = onClickListener;
    }

    public void WD() {
        if (!this.byv.AZ()) {
            this.byv.setEditState(true);
            this.amE.setText(z.done);
            bc.g(this.amE, TbadkApplication.getInst().getSkinType());
            this.byv.notifyDataSetChanged();
            return;
        }
        this.byv.setEditState(false);
        this.amE.setText(z.edit);
        bc.i(this.amE, TbadkApplication.getInst().getSkinType());
        this.byv.notifyDataSetChanged();
    }

    public int WE() {
        return w.home_lv_markitem_delete;
    }

    public void gW(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.byv.dI(true);
        this.byv.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Oz() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tbadk.baseEditMark.a aVar, boolean z) {
        this.byv.dI(true);
        if (str != null) {
            this.byu.showToast(str);
        }
        if (aVar != null) {
            if (aVar.lf() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.lf() < 20) {
                this.byv.setHasMore(false);
                this.byv.dJ(!aVar.isFirst());
            } else {
                this.byv.setHasMore(true);
                this.byv.dJ(true);
            }
            this.byv.dK(true);
            this.byv.s(aVar.le());
            if (aVar.getCount() > 0) {
                this.amE.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.aur.setVisibility(0);
                this.byv.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.amE.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.aur.setVisibility(8);
            }
        }
        this.byv.dI(false);
        this.mProgressBar.setVisibility(8);
        if (z && !xX()) {
            showLoading();
        }
        if (xX()) {
            aR(false);
        }
    }

    public void startSync() {
        this.byu.showLoadingDialog(this.byu.getPageContext().getString(z.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.byu.closeLoadingDialog();
        if (z) {
            this.byv.WH();
        }
        if (str != null) {
            this.byu.showToast(str);
        }
        if (z2) {
            WF();
        }
        this.byv.notifyDataSetChanged();
    }

    public void DN() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            this.byu.showToast(this.byu.getPageContext().getString(z.del_mark_success));
            this.byv.s(arrayList);
            this.byv.dK(true);
            if (arrayList.size() == 0) {
                this.amE.setText(z.edit);
                this.amE.setVisibility(4);
                this.byv.setEditState(false);
                this.mNoDataView.setVisibility(0);
                this.aur.setVisibility(8);
            }
        } else {
            this.byu.showToast(str);
        }
        this.mProgressBar.setVisibility(8);
    }

    public void H(ArrayList<MarkData> arrayList) {
        this.byv.s(arrayList);
    }

    private void WF() {
        if (this.byw == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.byu.getPageContext().getPageActivity());
            builder.setTitle(this.byu.getPageContext().getString(z.sync_mark_fail));
            builder.setMessage(this.byu.getPageContext().getString(z.neterror));
            if (this.brY != null) {
                builder.setPositiveButton(this.byu.getPageContext().getString(z.retry_rightnow), this.brY);
            }
            builder.setNegativeButton(this.byu.getPageContext().getString(z.confirm), new h(this));
            this.byw = builder.create();
            this.byw.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.k.a(this.byw, this.byu.getPageContext());
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.byu.getPageContext(), i);
        this.byu.getLayoutMode().h(this.mParent);
        if (this.mPullView != null) {
            this.mPullView.cs(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.byu.getPageContext(), i);
        }
    }

    public void WG() {
        this.byv.WH();
        this.byv.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.byw != null) {
            com.baidu.adp.lib.g.k.b(this.byw, this.byu.getPageContext());
            this.byw = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.byv.Ug();
    }

    public void jI() {
        if (this.aur != null) {
            this.aur.jI();
        }
    }

    public boolean xX() {
        return this.byx;
    }

    public void aR(boolean z) {
        this.byx = z;
    }
}

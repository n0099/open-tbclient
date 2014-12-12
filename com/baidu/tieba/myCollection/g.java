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
import com.baidu.tbadk.core.util.ax;
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
    private TextView alK;
    private BdListView ats;
    EditMarkActivity bwL;
    private i bwM;
    private NavigationBar mNavigationBar;
    private x mNoDataView;
    private LinearLayout mParent;
    private ProgressBar mProgressBar;
    private ak mPullView;
    private Dialog bwN = null;
    DialogInterface.OnClickListener bqA = null;
    private boolean bwO = false;

    public g(EditMarkActivity editMarkActivity) {
        this.bwL = null;
        this.ats = null;
        this.mNoDataView = null;
        this.bwM = null;
        this.alK = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bwL = editMarkActivity;
        editMarkActivity.setContentView(com.baidu.tieba.x.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(w.progress);
        this.mParent = (LinearLayout) editMarkActivity.findViewById(w.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bwL.getPageContext().getPageActivity(), null, aa.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkApplication.getInst().getResources().getDimension(u.ds160)), ab.t(z.mark_nodata, z.mark_nodata_2), null);
        this.mParent.addView(this.mNoDataView, 1);
        this.bwM = new i(editMarkActivity);
        this.bwM.dE(false);
        this.bwM.Wc();
        this.mPullView = new ak(editMarkActivity.getPageContext().getPageActivity());
        this.mPullView.a(editMarkActivity);
        this.ats = (BdListView) editMarkActivity.findViewById(w.list);
        this.ats.setAdapter((ListAdapter) this.bwM);
        this.ats.setPullRefresh(this.mPullView);
        this.ats.setOnSrollToBottomListener(editMarkActivity);
        this.ats.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(z.my_mark));
        this.alK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(z.edit));
        this.alK.setOnClickListener(editMarkActivity);
        this.alK.setVisibility(4);
        this.bwM.x(editMarkActivity);
    }

    public TextView VX() {
        return this.alK;
    }

    public void c(DialogInterface.OnClickListener onClickListener) {
        this.bqA = onClickListener;
    }

    public void VY() {
        if (!this.bwM.Ay()) {
            this.bwM.setEditState(true);
            this.alK.setText(z.done);
            ax.g(this.alK, TbadkApplication.getInst().getSkinType());
            this.bwM.notifyDataSetChanged();
            return;
        }
        this.bwM.setEditState(false);
        this.alK.setText(z.edit);
        ax.i(this.alK, TbadkApplication.getInst().getSkinType());
        this.bwM.notifyDataSetChanged();
    }

    public int VZ() {
        return w.home_lv_markitem_delete;
    }

    public void gN(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bwM.dC(true);
        this.bwM.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Od() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tbadk.baseEditMark.a aVar, boolean z) {
        this.bwM.dC(true);
        if (str != null) {
            this.bwL.showToast(str);
        }
        if (aVar != null) {
            if (aVar.lf() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.lf() < 20) {
                this.bwM.setHasMore(false);
                this.bwM.dD(!aVar.isFirst());
            } else {
                this.bwM.setHasMore(true);
                this.bwM.dD(true);
            }
            this.bwM.dE(true);
            this.bwM.r(aVar.le());
            if (aVar.getCount() > 0) {
                this.alK.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.ats.setVisibility(0);
                this.bwM.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.alK.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.ats.setVisibility(8);
            }
        }
        this.bwM.dC(false);
        this.mProgressBar.setVisibility(8);
        if (z && !xH()) {
            showLoading();
        }
        if (xH()) {
            aP(false);
        }
    }

    public void startSync() {
        this.bwL.showLoadingDialog(this.bwL.getPageContext().getString(z.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bwL.closeLoadingDialog();
        if (z) {
            this.bwM.Wc();
        }
        if (str != null) {
            this.bwL.showToast(str);
        }
        if (z2) {
            Wa();
        }
        this.bwM.notifyDataSetChanged();
    }

    public void Do() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            this.bwL.showToast(this.bwL.getPageContext().getString(z.del_mark_success));
            this.bwM.r(arrayList);
            this.bwM.dE(true);
            if (arrayList.size() == 0) {
                this.alK.setText(z.edit);
                this.alK.setVisibility(4);
                this.bwM.setEditState(false);
                this.mNoDataView.setVisibility(0);
                this.ats.setVisibility(8);
            }
        } else {
            this.bwL.showToast(str);
        }
        this.mProgressBar.setVisibility(8);
    }

    public void G(ArrayList<MarkData> arrayList) {
        this.bwM.r(arrayList);
    }

    private void Wa() {
        if (this.bwN == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.bwL.getPageContext().getPageActivity());
            builder.setTitle(this.bwL.getPageContext().getString(z.sync_mark_fail));
            builder.setMessage(this.bwL.getPageContext().getString(z.neterror));
            if (this.bqA != null) {
                builder.setPositiveButton(this.bwL.getPageContext().getString(z.retry_rightnow), this.bqA);
            }
            builder.setNegativeButton(this.bwL.getPageContext().getString(z.confirm), new h(this));
            this.bwN = builder.create();
            this.bwN.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.k.a(this.bwN, this.bwL.getPageContext());
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bwL.getPageContext(), i);
        this.bwL.getLayoutMode().h(this.mParent);
        if (this.mPullView != null) {
            this.mPullView.cl(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bwL.getPageContext(), i);
        }
    }

    public void Wb() {
        this.bwM.Wc();
        this.bwM.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bwN != null) {
            com.baidu.adp.lib.g.k.b(this.bwN, this.bwL.getPageContext());
            this.bwN = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bwM.TK();
    }

    public void jJ() {
        if (this.ats != null) {
            this.ats.jJ();
        }
    }

    public boolean xH() {
        return this.bwO;
    }

    public void aP(boolean z) {
        this.bwO = z;
    }
}

package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tbadk.core.view.y Yc;
    private TextView aek;
    private com.baidu.tbadk.core.view.o ahO;
    private BdListView aof;
    EditMarkActivity bAX;
    private j bAY;
    private NavigationBar mNavigationBar;
    private LinearLayout mParent;
    private ProgressBar mProgressBar;
    private Dialog bAZ = null;
    DialogInterface.OnClickListener aNs = null;
    private boolean bBa = false;

    public h(EditMarkActivity editMarkActivity) {
        this.bAX = null;
        this.aof = null;
        this.ahO = null;
        this.bAY = null;
        this.aek = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bAX = editMarkActivity;
        editMarkActivity.setContentView(com.baidu.tieba.w.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(com.baidu.tieba.v.progress);
        this.mParent = (LinearLayout) editMarkActivity.findViewById(com.baidu.tieba.v.parent);
        this.ahO = NoDataViewFactory.a(this.bAX, null, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkApplication.m251getInst().getResources().getDimension(com.baidu.tieba.t.ds160)), com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.mark_nodata, com.baidu.tieba.y.mark_nodata_2), null);
        this.mParent.addView(this.ahO, 1);
        this.bAY = new j(editMarkActivity);
        this.bAY.es(false);
        this.bAY.ZG();
        this.Yc = new com.baidu.tbadk.core.view.y(editMarkActivity);
        this.Yc.a(editMarkActivity);
        this.aof = (BdListView) editMarkActivity.findViewById(com.baidu.tieba.v.list);
        this.aof.setAdapter((ListAdapter) this.bAY);
        this.aof.setPullRefresh(this.Yc);
        this.aof.setOnSrollToBottomListener(editMarkActivity);
        this.aof.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(com.baidu.tieba.y.my_mark));
        this.aek = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(com.baidu.tieba.y.edit));
        this.aek.setOnClickListener(editMarkActivity);
        this.aek.setVisibility(4);
        this.bAY.w(editMarkActivity);
    }

    public TextView Zz() {
        return this.aek;
    }

    public void f(DialogInterface.OnClickListener onClickListener) {
        this.aNs = onClickListener;
    }

    public void ZA() {
        if (!this.bAY.xd()) {
            this.bAY.setEditState(true);
            this.aek.setText(com.baidu.tieba.y.done);
            com.baidu.tbadk.core.util.aw.f(this.aek, TbadkApplication.m251getInst().getSkinType());
            this.bAY.notifyDataSetChanged();
            return;
        }
        this.bAY.setEditState(false);
        this.aek.setText(com.baidu.tieba.y.edit);
        com.baidu.tbadk.core.util.aw.h(this.aek, TbadkApplication.m251getInst().getSkinType());
        this.bAY.notifyDataSetChanged();
    }

    public int ZB() {
        return com.baidu.tieba.v.home_lv_markitem_delete;
    }

    public void gU(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bAY.eq(true);
        this.bAY.notifyDataSetChanged();
    }

    public void ZC() {
        this.mProgressBar.setVisibility(0);
    }

    public void ZD() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.model.j jVar, boolean z) {
        this.bAY.eq(true);
        if (str != null) {
            this.bAX.showToast(str);
        }
        if (jVar != null) {
            if (jVar.Tj() == 0 && !z) {
                jVar.getCount();
            }
            if (jVar.Tj() < 20) {
                this.bAY.setHasMore(false);
                this.bAY.er(!jVar.isFirst());
            } else {
                this.bAY.setHasMore(true);
                this.bAY.er(true);
            }
            this.bAY.es(true);
            this.bAY.setData(jVar.Ti());
            if (jVar.getCount() > 0) {
                this.aek.setVisibility(0);
                this.ahO.setVisibility(8);
                this.aof.setVisibility(0);
                this.bAY.notifyDataSetChanged();
            } else if (jVar.getCount() == 0 && !z) {
                this.aek.setVisibility(4);
                this.ahO.setVisibility(0);
                this.aof.setVisibility(8);
            }
        }
        this.bAY.eq(false);
        this.mProgressBar.setVisibility(8);
        if (z && !tV()) {
            ZC();
        }
        if (tV()) {
            aC(false);
        }
    }

    public void startSync() {
        this.bAX.showLoadingDialog(this.bAX.getString(com.baidu.tieba.y.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bAX.closeLoadingDialog();
        if (z) {
            this.bAY.ZG();
        }
        if (str != null) {
            this.bAX.showToast(str);
        }
        if (z2) {
            ZE();
        }
        this.bAY.notifyDataSetChanged();
    }

    public void CN() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            this.bAX.showToast(this.bAX.getString(com.baidu.tieba.y.del_mark_success));
            this.bAY.setData(arrayList);
            this.bAY.es(true);
            if (arrayList.size() == 0) {
                this.aek.setText(com.baidu.tieba.y.edit);
                this.aek.setVisibility(4);
                this.bAY.setEditState(false);
                this.ahO.setVisibility(0);
                this.aof.setVisibility(8);
            }
        } else {
            this.bAX.showToast(str);
        }
        this.mProgressBar.setVisibility(8);
    }

    public void D(ArrayList<MarkData> arrayList) {
        this.bAY.setData(arrayList);
    }

    private void ZE() {
        if (this.bAZ == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.bAX);
            builder.setTitle(this.bAX.getString(com.baidu.tieba.y.sync_mark_fail));
            builder.setMessage(this.bAX.getString(com.baidu.tieba.y.neterror));
            if (this.aNs != null) {
                builder.setPositiveButton(this.bAX.getString(com.baidu.tieba.y.retry_rightnow), this.aNs);
            }
            builder.setNegativeButton(this.bAX.getString(com.baidu.tieba.y.confirm), new i(this));
            this.bAZ = builder.create();
            this.bAZ.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.j.a(this.bAZ, this.bAX);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bAX.getLayoutMode().h(this.mParent);
        if (this.Yc != null) {
            this.Yc.bM(i);
        }
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
    }

    public void ZF() {
        this.bAY.ZG();
        this.bAY.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bAZ != null) {
            com.baidu.adp.lib.g.j.b(this.bAZ, this.bAX);
            this.bAZ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bAY.Sy();
    }

    public void hN() {
        if (this.aof != null) {
            this.aof.hN();
        }
    }

    public boolean tV() {
        return this.bBa;
    }

    public void aC(boolean z) {
        this.bBa = z;
    }
}

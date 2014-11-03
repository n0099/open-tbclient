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
    private com.baidu.tbadk.core.view.y Yg;
    private TextView aes;
    private com.baidu.tbadk.core.view.o ahX;
    private BdListView aoo;
    EditMarkActivity bBl;
    private j bBm;
    private NavigationBar mNavigationBar;
    private LinearLayout mParent;
    private ProgressBar mProgressBar;
    private Dialog bBn = null;
    DialogInterface.OnClickListener aNG = null;
    private boolean bBo = false;

    public h(EditMarkActivity editMarkActivity) {
        this.bBl = null;
        this.aoo = null;
        this.ahX = null;
        this.bBm = null;
        this.aes = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bBl = editMarkActivity;
        editMarkActivity.setContentView(com.baidu.tieba.w.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(com.baidu.tieba.v.progress);
        this.mParent = (LinearLayout) editMarkActivity.findViewById(com.baidu.tieba.v.parent);
        this.ahX = NoDataViewFactory.a(this.bBl, null, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkApplication.m251getInst().getResources().getDimension(com.baidu.tieba.t.ds160)), com.baidu.tbadk.core.view.s.q(com.baidu.tieba.y.mark_nodata, com.baidu.tieba.y.mark_nodata_2), null);
        this.mParent.addView(this.ahX, 1);
        this.bBm = new j(editMarkActivity);
        this.bBm.es(false);
        this.bBm.ZI();
        this.Yg = new com.baidu.tbadk.core.view.y(editMarkActivity);
        this.Yg.a(editMarkActivity);
        this.aoo = (BdListView) editMarkActivity.findViewById(com.baidu.tieba.v.list);
        this.aoo.setAdapter((ListAdapter) this.bBm);
        this.aoo.setPullRefresh(this.Yg);
        this.aoo.setOnSrollToBottomListener(editMarkActivity);
        this.aoo.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(com.baidu.tieba.y.my_mark));
        this.aes = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(com.baidu.tieba.y.edit));
        this.aes.setOnClickListener(editMarkActivity);
        this.aes.setVisibility(4);
        this.bBm.w(editMarkActivity);
    }

    public TextView ZC() {
        return this.aes;
    }

    public void f(DialogInterface.OnClickListener onClickListener) {
        this.aNG = onClickListener;
    }

    public void ZD() {
        if (!this.bBm.xf()) {
            this.bBm.setEditState(true);
            this.aes.setText(com.baidu.tieba.y.done);
            com.baidu.tbadk.core.util.aw.f(this.aes, TbadkApplication.m251getInst().getSkinType());
            this.bBm.notifyDataSetChanged();
            return;
        }
        this.bBm.setEditState(false);
        this.aes.setText(com.baidu.tieba.y.edit);
        com.baidu.tbadk.core.util.aw.h(this.aes, TbadkApplication.m251getInst().getSkinType());
        this.bBm.notifyDataSetChanged();
    }

    public int ZE() {
        return com.baidu.tieba.v.home_lv_markitem_delete;
    }

    public void gU(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bBm.eq(true);
        this.bBm.notifyDataSetChanged();
    }

    public void ZF() {
        this.mProgressBar.setVisibility(0);
    }

    public void Hx() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.model.j jVar, boolean z) {
        this.bBm.eq(true);
        if (str != null) {
            this.bBl.showToast(str);
        }
        if (jVar != null) {
            if (jVar.Tm() == 0 && !z) {
                jVar.getCount();
            }
            if (jVar.Tm() < 20) {
                this.bBm.setHasMore(false);
                this.bBm.er(!jVar.isFirst());
            } else {
                this.bBm.setHasMore(true);
                this.bBm.er(true);
            }
            this.bBm.es(true);
            this.bBm.setData(jVar.Tl());
            if (jVar.getCount() > 0) {
                this.aes.setVisibility(0);
                this.ahX.setVisibility(8);
                this.aoo.setVisibility(0);
                this.bBm.notifyDataSetChanged();
            } else if (jVar.getCount() == 0 && !z) {
                this.aes.setVisibility(4);
                this.ahX.setVisibility(0);
                this.aoo.setVisibility(8);
            }
        }
        this.bBm.eq(false);
        this.mProgressBar.setVisibility(8);
        if (z && !tX()) {
            ZF();
        }
        if (tX()) {
            aC(false);
        }
    }

    public void startSync() {
        this.bBl.showLoadingDialog(this.bBl.getString(com.baidu.tieba.y.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bBl.closeLoadingDialog();
        if (z) {
            this.bBm.ZI();
        }
        if (str != null) {
            this.bBl.showToast(str);
        }
        if (z2) {
            ZG();
        }
        this.bBm.notifyDataSetChanged();
    }

    public void CP() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            this.bBl.showToast(this.bBl.getString(com.baidu.tieba.y.del_mark_success));
            this.bBm.setData(arrayList);
            this.bBm.es(true);
            if (arrayList.size() == 0) {
                this.aes.setText(com.baidu.tieba.y.edit);
                this.aes.setVisibility(4);
                this.bBm.setEditState(false);
                this.ahX.setVisibility(0);
                this.aoo.setVisibility(8);
            }
        } else {
            this.bBl.showToast(str);
        }
        this.mProgressBar.setVisibility(8);
    }

    public void E(ArrayList<MarkData> arrayList) {
        this.bBm.setData(arrayList);
    }

    private void ZG() {
        if (this.bBn == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.bBl);
            builder.setTitle(this.bBl.getString(com.baidu.tieba.y.sync_mark_fail));
            builder.setMessage(this.bBl.getString(com.baidu.tieba.y.neterror));
            if (this.aNG != null) {
                builder.setPositiveButton(this.bBl.getString(com.baidu.tieba.y.retry_rightnow), this.aNG);
            }
            builder.setNegativeButton(this.bBl.getString(com.baidu.tieba.y.confirm), new i(this));
            this.bBn = builder.create();
            this.bBn.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.j.a(this.bBn, this.bBl);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bBl.getLayoutMode().h(this.mParent);
        if (this.Yg != null) {
            this.Yg.bM(i);
        }
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
    }

    public void ZH() {
        this.bBm.ZI();
        this.bBm.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bBn != null) {
            com.baidu.adp.lib.g.j.b(this.bBn, this.bBl);
            this.bBn = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bBm.SB();
    }

    public void hN() {
        if (this.aoo != null) {
            this.aoo.hN();
        }
    }

    public boolean tX() {
        return this.bBo;
    }

    public void aC(boolean z) {
        this.bBo = z;
    }
}

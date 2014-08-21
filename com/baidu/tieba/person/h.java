package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {
    EditMarkActivity a;
    private BdListView c;
    private com.baidu.tbadk.core.view.v d;
    private LinearLayout e;
    private j f;
    private TextView g;
    private LinearLayout h;
    private ProgressBar i;
    private NavigationBar l;
    private Dialog j = null;
    DialogInterface.OnClickListener b = null;
    private boolean k = false;

    public h(EditMarkActivity editMarkActivity) {
        this.a = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = editMarkActivity;
        editMarkActivity.setContentView(com.baidu.tieba.v.edit_mark_activity);
        this.i = (ProgressBar) editMarkActivity.findViewById(com.baidu.tieba.u.progress);
        this.h = (LinearLayout) editMarkActivity.findViewById(com.baidu.tieba.u.parent);
        this.e = (LinearLayout) editMarkActivity.findViewById(com.baidu.tieba.u.no_data_container);
        this.f = new j(editMarkActivity);
        this.f.d(false);
        this.f.b();
        this.d = new com.baidu.tbadk.core.view.v(editMarkActivity);
        this.d.a(editMarkActivity);
        this.c = (BdListView) editMarkActivity.findViewById(com.baidu.tieba.u.list);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setPullRefresh(this.d);
        this.c.setOnSrollToBottomListener(editMarkActivity);
        this.c.setOnItemClickListener(editMarkActivity);
        this.l = (NavigationBar) editMarkActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l.a(editMarkActivity.getResources().getString(com.baidu.tieba.x.my_mark));
        this.g = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(com.baidu.tieba.x.edit));
        this.g.setOnClickListener(editMarkActivity);
        this.g.setVisibility(4);
        this.f.a(editMarkActivity);
    }

    public TextView a() {
        return this.g;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.b = onClickListener;
    }

    public void b() {
        if (!this.f.c()) {
            this.f.e(true);
            this.g.setText(com.baidu.tieba.x.done);
            com.baidu.tbadk.core.util.ay.g(this.g, TbadkApplication.m252getInst().getSkinType());
            this.f.notifyDataSetChanged();
            return;
        }
        this.f.e(false);
        this.g.setText(com.baidu.tieba.x.edit);
        com.baidu.tbadk.core.util.ay.i(this.g, TbadkApplication.m252getInst().getSkinType());
        this.f.notifyDataSetChanged();
    }

    public int c() {
        return com.baidu.tieba.u.home_lv_markitem_delete;
    }

    public void a(int i) {
        if (i == 0) {
            this.i.setVisibility(0);
        }
        this.f.b(true);
        this.f.notifyDataSetChanged();
    }

    public void d() {
        this.i.setVisibility(0);
    }

    public void e() {
        this.i.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.model.j jVar, boolean z) {
        this.f.b(true);
        if (str != null) {
            a(str);
        }
        if (jVar != null) {
            if (jVar.h() == 0 && !z) {
                jVar.g();
            }
            if (jVar.h() < 20) {
                this.f.a(false);
                this.f.c(!jVar.e());
            } else {
                this.f.a(true);
                this.f.c(true);
            }
            this.f.a(jVar.f());
            this.f.d(true);
            this.f.b();
            if (jVar.g() > 0) {
                this.g.setVisibility(0);
                this.e.setVisibility(8);
                this.c.setVisibility(0);
                this.f.notifyDataSetChanged();
            } else if (jVar.g() == 0 && !z) {
                this.g.setVisibility(4);
                this.e.setVisibility(0);
                this.c.setVisibility(8);
            }
        }
        this.f.b(false);
        this.i.setVisibility(8);
        if (z && !k()) {
            d();
        }
        if (k()) {
            a(false);
        }
    }

    public void a(String str) {
        this.a.showToast(str);
    }

    public void f() {
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.x.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.a.closeLoadingDialog();
        if (z) {
            this.f.b();
        }
        if (str != null) {
            this.a.showToast(str);
        }
        if (z2) {
            l();
        }
        this.f.notifyDataSetChanged();
    }

    public void g() {
        this.i.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            this.a.showToast(this.a.getString(com.baidu.tieba.x.del_mark_success));
            this.f.a(arrayList);
            this.f.d(true);
            this.f.b();
            if (arrayList.size() == 0) {
                this.g.setText(com.baidu.tieba.x.edit);
                this.g.setVisibility(4);
                this.f.e(false);
                this.e.setVisibility(0);
                this.c.setVisibility(8);
            }
        } else {
            this.a.showToast(str);
        }
        this.f.notifyDataSetChanged();
        this.i.setVisibility(8);
    }

    public void a(ArrayList<MarkData> arrayList) {
        if (arrayList != null) {
            this.f.a(arrayList);
            this.f.b();
            this.f.notifyDataSetChanged();
        }
    }

    private void l() {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(this.a.getString(com.baidu.tieba.x.sync_mark_fail));
            builder.setMessage(this.a.getString(com.baidu.tieba.x.neterror));
            if (this.b != null) {
                builder.setPositiveButton(this.a.getString(com.baidu.tieba.x.retry_rightnow), this.b);
            }
            builder.setNegativeButton(this.a.getString(com.baidu.tieba.x.confirm), new i(this));
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.e.e.a(this.j, this.a);
    }

    public void b(int i) {
        this.l.c(i);
        this.a.getLayoutMode().a((View) this.h);
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void h() {
        this.f.b();
        this.f.notifyDataSetChanged();
    }

    public void i() {
        if (this.j != null) {
            com.baidu.adp.lib.e.e.b(this.j, this.a);
            this.j = null;
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        this.f.a();
    }

    public void j() {
        if (this.c != null) {
            this.c.d();
        }
    }

    public boolean k() {
        return this.k;
    }

    public void a(boolean z) {
        this.k = z;
    }
}

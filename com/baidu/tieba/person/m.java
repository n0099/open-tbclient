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
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class m {
    EditMarkActivity a;
    private BdListView c;
    private com.baidu.tbadk.core.view.q d;
    private LinearLayout e;
    private o f;
    private TextView g;
    private LinearLayout h;
    private ProgressBar i;
    private NavigationBar l;
    private Dialog j = null;
    DialogInterface.OnClickListener b = null;
    private boolean k = false;

    public m(EditMarkActivity editMarkActivity) {
        this.a = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = editMarkActivity;
        editMarkActivity.setContentView(com.baidu.tieba.a.i.edit_mark_activity);
        this.i = (ProgressBar) editMarkActivity.findViewById(com.baidu.tieba.a.h.progress);
        this.h = (LinearLayout) editMarkActivity.findViewById(com.baidu.tieba.a.h.parent);
        this.e = (LinearLayout) editMarkActivity.findViewById(com.baidu.tieba.a.h.no_data_container);
        this.f = new o(editMarkActivity);
        this.f.d(false);
        this.f.b();
        this.d = new com.baidu.tbadk.core.view.q(editMarkActivity);
        this.d.a(editMarkActivity);
        this.c = (BdListView) editMarkActivity.findViewById(com.baidu.tieba.a.h.list);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setPullRefresh(this.d);
        this.c.setOnSrollToBottomListener(editMarkActivity);
        this.c.setOnItemClickListener(editMarkActivity);
        this.l = (NavigationBar) editMarkActivity.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l.a(editMarkActivity.getResources().getString(com.baidu.tieba.a.k.my_mark));
        this.g = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(com.baidu.tieba.a.k.edit));
        this.g.setOnClickListener(editMarkActivity);
        this.g.setVisibility(4);
        this.f.a(editMarkActivity);
    }

    public final TextView a() {
        return this.g;
    }

    public final void b() {
        if (!this.f.c()) {
            this.f.e(true);
            this.g.setText(com.baidu.tieba.a.k.done);
            com.baidu.tbadk.core.util.ba.g(this.g, TbadkApplication.j().l());
            this.f.notifyDataSetChanged();
            return;
        }
        this.f.e(false);
        this.g.setText(com.baidu.tieba.a.k.edit);
        com.baidu.tbadk.core.util.ba.h(this.g, TbadkApplication.j().l());
        this.f.notifyDataSetChanged();
    }

    public final void a(int i) {
        if (i == 0) {
            this.i.setVisibility(0);
        }
        this.f.b(true);
        this.f.notifyDataSetChanged();
    }

    public final void c() {
        this.i.setVisibility(8);
    }

    public final void a(String str, com.baidu.tieba.model.k kVar, boolean z) {
        this.f.b(true);
        if (str != null) {
            this.a.showToast(str);
        }
        if (kVar != null) {
            if (kVar.h() == 0 && !z) {
                kVar.g();
            }
            if (kVar.h() < 20) {
                this.f.a(false);
                this.f.c(!kVar.e());
            } else {
                this.f.a(true);
                this.f.c(true);
            }
            this.f.a(kVar.f());
            this.f.d(true);
            this.f.b();
            if (kVar.g() > 0) {
                this.g.setVisibility(0);
                this.e.setVisibility(8);
                this.c.setVisibility(0);
                this.f.notifyDataSetChanged();
            } else if (kVar.g() == 0 && !z) {
                this.g.setVisibility(4);
                this.e.setVisibility(0);
                this.c.setVisibility(8);
            }
        }
        this.f.b(false);
        this.i.setVisibility(8);
        if (z && !this.k) {
            this.i.setVisibility(0);
        }
        if (this.k) {
            this.k = false;
        }
    }

    public final void a(boolean z, String str, boolean z2) {
        this.a.closeLoadingDialog();
        if (z) {
            this.f.b();
        }
        if (str != null) {
            this.a.showToast(str);
        }
        if (z2) {
            if (this.j == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
                builder.setTitle(this.a.getString(com.baidu.tieba.a.k.sync_mark_fail));
                builder.setMessage(this.a.getString(com.baidu.tieba.a.k.sync_mark_fail_con));
                if (this.b != null) {
                    builder.setPositiveButton(this.a.getString(com.baidu.tieba.a.k.retry_rightnow), this.b);
                }
                builder.setNegativeButton(this.a.getString(com.baidu.tieba.a.k.confirm), new n(this));
                this.j = builder.create();
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.show();
        }
        this.f.notifyDataSetChanged();
    }

    public final void d() {
        this.i.setVisibility(0);
    }

    public final void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            this.a.showToast(this.a.getString(com.baidu.tieba.a.k.del_mark_success));
            this.f.a(arrayList);
            this.f.d(true);
            this.f.b();
            if (arrayList.size() == 0) {
                this.g.setText(com.baidu.tieba.a.k.edit);
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

    public final void a(ArrayList<MarkData> arrayList) {
        if (arrayList != null) {
            this.f.a(arrayList);
            this.f.b();
            this.f.notifyDataSetChanged();
        }
    }

    public final void b(int i) {
        this.l.b(i);
        this.a.getLayoutMode().a(this.h);
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public final void e() {
        this.f.b();
        this.f.notifyDataSetChanged();
    }

    public final void f() {
        if (this.j != null) {
            this.j.dismiss();
            this.j = null;
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        this.f.a();
    }

    public final void g() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public final void a(boolean z) {
        this.k = z;
    }
}

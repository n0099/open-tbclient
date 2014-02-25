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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad {
    EditMarkActivity a;
    private BdListView c;
    private com.baidu.tieba.view.ct d;
    private LinearLayout e;
    private af f;
    private TextView g;
    private LinearLayout h;
    private ProgressBar i;
    private NavigationBar l;
    private Dialog j = null;
    DialogInterface.OnClickListener b = null;
    private boolean k = false;

    public ad(EditMarkActivity editMarkActivity) {
        this.a = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = editMarkActivity;
        editMarkActivity.setContentView(R.layout.edit_mark_activity);
        this.i = (ProgressBar) editMarkActivity.findViewById(R.id.progress);
        this.h = (LinearLayout) editMarkActivity.findViewById(R.id.parent);
        this.e = (LinearLayout) editMarkActivity.findViewById(R.id.no_data_container);
        this.f = new af(editMarkActivity);
        this.f.d(false);
        this.f.b();
        this.d = new com.baidu.tieba.view.ct(editMarkActivity);
        this.d.a(editMarkActivity);
        this.c = (BdListView) editMarkActivity.findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setPullRefresh(this.d);
        this.c.setOnSrollToBottomListener(editMarkActivity);
        this.c.setOnItemClickListener(editMarkActivity);
        this.l = (NavigationBar) editMarkActivity.findViewById(R.id.view_navigation_bar);
        this.l.a(editMarkActivity.getResources().getString(R.string.my_mark));
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(R.string.edit));
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
            this.g.setText(R.string.done);
            com.baidu.tieba.util.bq.h(this.g, TiebaApplication.g().al());
            this.f.notifyDataSetChanged();
            return;
        }
        this.f.e(false);
        this.g.setText(R.string.edit);
        com.baidu.tieba.util.bq.j(this.g, TiebaApplication.g().al());
        this.f.notifyDataSetChanged();
    }

    public int c() {
        return R.id.home_lv_markitem_delete;
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

    public void a(String str, com.baidu.tieba.model.g gVar, boolean z) {
        this.f.b(true);
        if (str != null) {
            a(str);
        }
        if (gVar != null) {
            if (gVar.h() == 0 && !z) {
                gVar.g();
            }
            if (gVar.h() < 20) {
                this.f.a(false);
                this.f.c(!gVar.e());
            } else {
                this.f.a(true);
                this.f.c(true);
            }
            this.f.a(gVar.f());
            this.f.d(true);
            this.f.b();
            if (gVar.g() > 0) {
                this.g.setVisibility(0);
                this.e.setVisibility(8);
                this.c.setVisibility(0);
                this.f.notifyDataSetChanged();
            } else if (gVar.g() == 0 && !z) {
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
        this.a.showLoadingDialog(this.a.getString(R.string.syncing));
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
            this.a.showToast(this.a.getString(R.string.del_mark_success));
            this.f.a(arrayList);
            this.f.d(true);
            this.f.b();
            if (arrayList.size() == 0) {
                this.g.setText(R.string.edit);
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
            builder.setTitle(this.a.getString(R.string.sync_mark_fail));
            builder.setMessage(this.a.getString(R.string.sync_mark_fail_con));
            if (this.b != null) {
                builder.setPositiveButton(this.a.getString(R.string.retry_rightnow), this.b);
            }
            builder.setNegativeButton(this.a.getString(R.string.confirm), new ae(this));
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
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
            this.j.dismiss();
            this.j = null;
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        this.f.a();
    }

    public void j() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public boolean k() {
        return this.k;
    }

    public void a(boolean z) {
        this.k = z;
    }
}

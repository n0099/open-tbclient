package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    Context f2164a;
    private ListView c;
    private com.baidu.tieba.home.v d;
    private Button e;
    private RelativeLayout f;
    private ProgressBar g;
    private NavigationBar i;
    private Dialog h = null;
    DialogInterface.OnClickListener b = null;

    public aa(EditMarkActivity editMarkActivity) {
        this.f2164a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f2164a = editMarkActivity;
        editMarkActivity.setContentView(R.layout.edit_mark_activity);
        this.g = (ProgressBar) editMarkActivity.findViewById(R.id.progress);
        this.f = (RelativeLayout) editMarkActivity.findViewById(R.id.parent);
        this.d = new com.baidu.tieba.home.v(editMarkActivity);
        this.d.c(false);
        this.d.b();
        this.c = (ListView) editMarkActivity.findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.d);
        this.c.setOnItemClickListener(editMarkActivity);
        this.i = (NavigationBar) editMarkActivity.findViewById(R.id.view_navigation_bar);
        this.i.a(editMarkActivity.getResources().getString(R.string.my_mark));
        this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(R.string.edit));
        this.e.setOnClickListener(editMarkActivity);
        this.e.setVisibility(4);
        this.d.a(editMarkActivity);
    }

    public Button a() {
        return this.e;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.b = onClickListener;
    }

    public void b() {
        if (!this.d.c()) {
            this.d.d(true);
            this.e.setText(R.string.done);
            com.baidu.tieba.util.bb.h(this.e, TiebaApplication.g().as());
            this.d.notifyDataSetChanged();
            return;
        }
        this.d.d(false);
        this.e.setText(R.string.edit);
        com.baidu.tieba.util.bb.g(this.e, TiebaApplication.g().as());
        this.d.notifyDataSetChanged();
    }

    public int c() {
        return R.id.home_lv_markitem_delete;
    }

    public void a(int i) {
        if (i == 0) {
            this.g.setVisibility(0);
        }
        this.d.b(true);
        this.d.notifyDataSetChanged();
    }

    public void d() {
        this.g.setVisibility(0);
    }

    public void e() {
        this.g.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.model.o oVar, Boolean bool) {
        this.d.b(true);
        if (str != null) {
            a(str);
        }
        if (oVar.e() == 0 && !bool.booleanValue() && oVar.d() > 0) {
            a(this.f2164a.getString(R.string.no_more_mark));
        }
        if (oVar.d() < 20) {
            this.d.a(false);
        }
        this.d.a(oVar.c());
        this.d.c(true);
        this.d.b();
        if (oVar.d() > 0) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(4);
        }
        this.g.setVisibility(8);
        this.d.b(false);
        this.d.notifyDataSetChanged();
        if (bool.booleanValue()) {
            d();
        }
    }

    public void a(String str) {
        ((com.baidu.tieba.j) this.f2164a).a(str);
    }

    public void f() {
        ((com.baidu.tieba.j) this.f2164a).b(this.f2164a.getString(R.string.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        ((com.baidu.tieba.j) this.f2164a).j();
        if (z) {
            this.d.b();
        }
        if (str != null) {
            ((com.baidu.tieba.j) this.f2164a).a(str);
        }
        if (z2) {
            j();
        }
        this.d.notifyDataSetChanged();
    }

    public void g() {
        this.g.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            ((com.baidu.tieba.j) this.f2164a).a(this.f2164a.getString(R.string.del_mark_success));
            this.d.a(arrayList);
            this.d.c(true);
            this.d.b();
            if (arrayList.size() == 0) {
                this.e.setText(R.string.edit);
                this.e.setVisibility(4);
                this.d.d(false);
            }
        } else {
            ((com.baidu.tieba.j) this.f2164a).a(str);
        }
        this.d.notifyDataSetChanged();
        this.g.setVisibility(8);
    }

    public void a(ArrayList<MarkData> arrayList) {
        if (arrayList != null) {
            this.d.a(arrayList);
            this.d.b();
            this.d.notifyDataSetChanged();
        }
    }

    private void j() {
        if (this.h == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f2164a);
            builder.setTitle(this.f2164a.getString(R.string.sync_mark_fail));
            builder.setMessage(this.f2164a.getString(R.string.sync_mark_fail_con));
            if (this.b != null) {
                builder.setPositiveButton(this.f2164a.getString(R.string.retry_rightnow), this.b);
            }
            builder.setNegativeButton(this.f2164a.getString(R.string.confirm), new ab(this));
            this.h = builder.create();
            this.h.setCanceledOnTouchOutside(true);
        }
        this.h.show();
    }

    public void b(int i) {
        com.baidu.tieba.util.bb.a(this.f, i);
        this.i.b(i);
        if (this.d.c()) {
            com.baidu.tieba.util.bb.h(this.e, i);
        } else {
            com.baidu.tieba.util.bb.g(this.e, i);
        }
        this.d.notifyDataSetChanged();
        if (i == 1) {
            this.c.setDivider(this.f2164a.getResources().getDrawable(R.drawable.list_divider_1));
            this.c.setSelector(R.drawable.list_selector_1);
        } else {
            this.c.setDivider(this.f2164a.getResources().getDrawable(R.drawable.list_divider));
            this.c.setSelector(R.drawable.list_selector);
        }
        this.d.notifyDataSetChanged();
    }

    public void h() {
        this.d.b();
        this.d.notifyDataSetChanged();
    }

    public void i() {
        if (this.h != null) {
            this.h.dismiss();
            this.h = null;
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        this.d.a();
    }
}

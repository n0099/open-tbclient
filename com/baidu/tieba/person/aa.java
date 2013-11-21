package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    Context f2191a;
    private ListView c;
    private FrameLayout d;
    private TextView e;
    private com.baidu.tieba.home.af f;
    private TextView g;
    private LinearLayout h;
    private ProgressBar i;
    private NavigationBar l;
    private Dialog j = null;
    private int k = 0;
    DialogInterface.OnClickListener b = null;

    public aa(EditMarkActivity editMarkActivity) {
        this.f2191a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f2191a = editMarkActivity;
        editMarkActivity.setContentView(R.layout.edit_mark_activity);
        this.i = (ProgressBar) editMarkActivity.findViewById(R.id.progress);
        this.h = (LinearLayout) editMarkActivity.findViewById(R.id.parent);
        this.d = (FrameLayout) editMarkActivity.findViewById(R.id.empty_textview_container);
        this.e = (TextView) editMarkActivity.findViewById(R.id.empty_textview);
        this.f = new com.baidu.tieba.home.af(editMarkActivity);
        this.f.c(false);
        this.f.b();
        this.c = (ListView) editMarkActivity.findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.f);
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
            this.f.d(true);
            this.g.setText(R.string.done);
            com.baidu.tieba.util.bd.g(this.g, TiebaApplication.g().ap());
            this.f.notifyDataSetChanged();
            return;
        }
        this.f.d(false);
        this.g.setText(R.string.edit);
        com.baidu.tieba.util.bd.i(this.g, TiebaApplication.g().ap());
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

    public void a(String str, com.baidu.tieba.model.o oVar, Boolean bool) {
        this.f.b(true);
        if (str != null) {
            a(str);
        }
        if (oVar != null) {
            if (oVar.e() == 0 && !bool.booleanValue() && oVar.d() > 0) {
                a(this.f2191a.getString(R.string.no_more_mark));
            }
            this.k = oVar.d();
            if (oVar.d() < 20) {
                this.f.a(false);
            }
            this.f.a(oVar.c());
            this.f.c(true);
            this.f.b();
            if (oVar.d() > 0) {
                this.g.setVisibility(0);
                this.d.setVisibility(8);
                this.f.notifyDataSetChanged();
            } else if (oVar.d() == 0 && !bool.booleanValue()) {
                this.g.setVisibility(4);
                this.d.setVisibility(0);
            }
        } else if (this.k > 0) {
            this.g.setVisibility(0);
            this.d.setVisibility(8);
            this.f.notifyDataSetChanged();
        } else {
            this.g.setVisibility(4);
            this.d.setVisibility(0);
        }
        this.f.b(false);
        this.i.setVisibility(8);
        if (bool.booleanValue()) {
            d();
        }
    }

    public void a(String str) {
        ((com.baidu.tieba.j) this.f2191a).showToast(str);
    }

    public void e() {
        ((com.baidu.tieba.j) this.f2191a).showLoadingDialog(this.f2191a.getString(R.string.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        ((com.baidu.tieba.j) this.f2191a).closeLoadingDialog();
        if (z) {
            this.f.b();
        }
        if (str != null) {
            ((com.baidu.tieba.j) this.f2191a).showToast(str);
        }
        if (z2) {
            i();
        }
        this.f.notifyDataSetChanged();
    }

    public void f() {
        this.i.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList<MarkData> arrayList) {
        if (z) {
            ((com.baidu.tieba.j) this.f2191a).showToast(this.f2191a.getString(R.string.del_mark_success));
            this.f.a(arrayList);
            this.f.c(true);
            this.f.b();
            if (arrayList.size() == 0) {
                this.g.setText(R.string.edit);
                this.g.setVisibility(4);
                this.f.d(false);
                this.d.setVisibility(0);
            }
        } else {
            ((com.baidu.tieba.j) this.f2191a).showToast(str);
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

    private void i() {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f2191a);
            builder.setTitle(this.f2191a.getString(R.string.sync_mark_fail));
            builder.setMessage(this.f2191a.getString(R.string.sync_mark_fail_con));
            if (this.b != null) {
                builder.setPositiveButton(this.f2191a.getString(R.string.retry_rightnow), this.b);
            }
            builder.setNegativeButton(this.f2191a.getString(R.string.confirm), new ab(this));
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void b(int i) {
        com.baidu.tieba.util.bd.a(this.h, i);
        this.l.c(i);
        this.f.notifyDataSetChanged();
        if (i == 1) {
            this.c.setDivider(this.f2191a.getResources().getDrawable(R.drawable.list_divider_1));
            this.c.setSelector(R.drawable.list_selector_1);
            this.e.setTextColor(this.f2191a.getResources().getColor(R.color.person_post_header_uname_1));
        } else {
            this.c.setDivider(this.f2191a.getResources().getDrawable(R.drawable.list_divider));
            this.c.setSelector(R.drawable.list_selector);
            this.e.setTextColor(this.f2191a.getResources().getColor(R.color.person_post_header_uname));
        }
        this.f.notifyDataSetChanged();
    }

    public void g() {
        this.f.b();
        this.f.notifyDataSetChanged();
    }

    public void h() {
        if (this.j != null) {
            this.j.dismiss();
            this.j = null;
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        this.f.a();
    }
}

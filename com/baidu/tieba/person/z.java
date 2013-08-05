package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    Context f1621a;
    private ListView c;
    private com.baidu.tieba.home.w d;
    private ImageView e;
    private Button f;
    private RelativeLayout g;
    private LinearLayout h;
    private TextView i;
    private ProgressBar j;
    private Dialog k = null;
    DialogInterface.OnClickListener b = null;

    public z(EditMarkActivity editMarkActivity) {
        this.f1621a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.f1621a = editMarkActivity;
        editMarkActivity.setContentView(R.layout.edit_mark_activity);
        this.j = (ProgressBar) editMarkActivity.findViewById(R.id.progress);
        this.g = (RelativeLayout) editMarkActivity.findViewById(R.id.parent);
        this.h = (LinearLayout) editMarkActivity.findViewById(R.id.title);
        this.i = (TextView) editMarkActivity.findViewById(R.id.title_text);
        this.d = new com.baidu.tieba.home.w(editMarkActivity);
        this.d.c(false);
        this.d.b();
        this.c = (ListView) editMarkActivity.findViewById(R.id.list);
        this.c.setAdapter((ListAdapter) this.d);
        this.c.setOnItemClickListener(editMarkActivity);
        this.e = (ImageView) editMarkActivity.findViewById(R.id.back);
        this.e.setOnClickListener(editMarkActivity);
        this.f = (Button) editMarkActivity.findViewById(R.id.edit);
        this.f.setOnClickListener(editMarkActivity);
        this.f.setVisibility(4);
        this.d.a(editMarkActivity);
    }

    public ImageView a() {
        return this.e;
    }

    public Button b() {
        return this.f;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.b = onClickListener;
    }

    public void c() {
        if (!this.d.c()) {
            this.d.d(true);
            this.f.setText(R.string.done);
            com.baidu.tieba.util.ah.h((TextView) this.f, TiebaApplication.f().au());
            this.d.notifyDataSetChanged();
            return;
        }
        this.d.d(false);
        this.f.setText(R.string.edit);
        com.baidu.tieba.util.ah.g((TextView) this.f, TiebaApplication.f().au());
        this.d.notifyDataSetChanged();
    }

    public int d() {
        return R.id.home_lv_markitem_delete;
    }

    public void a(int i) {
        if (i == 0) {
            this.j.setVisibility(0);
        }
        this.d.b(true);
        this.d.notifyDataSetChanged();
    }

    public void a(String str, com.baidu.tieba.model.f fVar) {
        if (str != null) {
            ((com.baidu.tieba.g) this.f1621a).a(str);
        }
        if (fVar.d() == 0) {
            ((com.baidu.tieba.g) this.f1621a).a(this.f1621a.getString(R.string.no_more_mark));
        }
        if (fVar.c() < 20) {
            this.d.a(false);
        }
        this.d.a(fVar.b());
        this.d.c(true);
        this.d.b();
        if (fVar.c() > 0) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(4);
        }
        this.j.setVisibility(8);
        this.d.b(false);
        this.d.notifyDataSetChanged();
    }

    public void e() {
        ((com.baidu.tieba.g) this.f1621a).b(this.f1621a.getString(R.string.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        ((com.baidu.tieba.g) this.f1621a).h();
        if (z) {
            this.d.b();
            this.d.notifyDataSetChanged();
        }
        if (str != null) {
            ((com.baidu.tieba.g) this.f1621a).a(str);
        }
        if (z2) {
            i();
        }
    }

    public void f() {
        this.j.setVisibility(0);
    }

    public void a(boolean z, String str, ArrayList arrayList) {
        if (z) {
            ((com.baidu.tieba.g) this.f1621a).a(this.f1621a.getString(R.string.del_mark_success));
            this.d.a(arrayList);
            this.d.c(true);
            this.d.b();
            if (arrayList.size() == 0) {
                this.f.setText(R.string.edit);
                this.f.setVisibility(4);
                this.d.d(false);
            }
            this.d.notifyDataSetChanged();
        } else {
            ((com.baidu.tieba.g) this.f1621a).a(str);
        }
        this.j.setVisibility(8);
    }

    public void a(ArrayList arrayList) {
        if (arrayList != null) {
            this.d.a(arrayList);
            this.d.b();
            this.d.notifyDataSetChanged();
            this.f.setVisibility(4);
        }
    }

    private void i() {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1621a);
            builder.setTitle(this.f1621a.getString(R.string.sync_mark_fail));
            builder.setMessage(this.f1621a.getString(R.string.sync_mark_fail_con));
            if (this.b != null) {
                builder.setPositiveButton(this.f1621a.getString(R.string.retry_rightnow), this.b);
            }
            builder.setNegativeButton(this.f1621a.getString(R.string.confirm), new aa(this));
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(true);
        }
        this.k.show();
    }

    public void b(int i) {
        com.baidu.tieba.util.ah.a(this.g, i);
        com.baidu.tieba.util.ah.d(this.h, i);
        com.baidu.tieba.util.ah.f(this.i, i);
        com.baidu.tieba.util.ah.a(this.e, i);
        if (this.d.c()) {
            com.baidu.tieba.util.ah.h((TextView) this.f, i);
        } else {
            com.baidu.tieba.util.ah.g((TextView) this.f, i);
        }
        this.d.notifyDataSetChanged();
        if (i == 1) {
            this.c.setDivider(this.f1621a.getResources().getDrawable(R.drawable.list_divider_1));
            this.c.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.c.setDivider(this.f1621a.getResources().getDrawable(R.drawable.list_divider));
        this.c.setSelector(R.drawable.list_selector);
    }

    public void g() {
        this.d.b();
        this.d.notifyDataSetChanged();
    }

    public void h() {
        if (this.k != null) {
            this.k.dismiss();
            this.k = null;
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        this.d.a();
    }
}

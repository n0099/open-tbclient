package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditMarkActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.home.ab c = null;
    private com.baidu.tieba.b.j d = null;
    private ListView e = null;
    private Button f = null;
    private Button g = null;
    private RelativeLayout h = null;
    private LinearLayout i = null;
    private TextView j = null;
    private ae k = null;
    private ad l = null;
    private ac m = null;
    private ProgressBar n = null;
    private Dialog o = null;
    private int p = -1;

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EditMarkActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_mark_activity);
        this.d = new com.baidu.tieba.b.j();
        k();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.h, i);
        com.baidu.tieba.c.ae.c(this.i, i);
        com.baidu.tieba.c.ae.c(this.j, i);
        com.baidu.tieba.c.ae.e((TextView) this.f, i);
        com.baidu.tieba.c.ae.d((TextView) this.g, i);
        this.c.notifyDataSetChanged();
        if (i == 1) {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.e.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.e.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.e.setSelector(R.drawable.list_selector);
    }

    private void i() {
        if (o() < 0) {
            n();
            return;
        }
        l();
        if (this.d.c() == 0 || o() < 0) {
            n();
        } else {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.o == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.sync_mark_fail));
            builder.setMessage(getString(R.string.sync_mark_fail_con));
            builder.setPositiveButton(getString(R.string.retry_rightnow), new w(this));
            builder.setNegativeButton(getString(R.string.confirm), new x(this));
            this.o = builder.create();
            this.o.setCanceledOnTouchOutside(true);
        }
        this.o.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.o != null) {
            this.o.dismiss();
            this.o = null;
        }
        if (this.k != null) {
            this.k.a();
        }
        if (this.m != null) {
            this.m.a();
        }
        if (this.l != null) {
            this.l.a();
        }
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        this.c.a();
    }

    private void k() {
        this.n = (ProgressBar) findViewById(R.id.progress);
        this.h = (RelativeLayout) findViewById(R.id.parent);
        this.i = (LinearLayout) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.title_text);
        this.c = new com.baidu.tieba.home.ab(this, this.d.b());
        this.c.c(false);
        this.c.b();
        this.e = (ListView) findViewById(R.id.list);
        this.e.setAdapter((ListAdapter) this.c);
        this.e.setOnItemClickListener(new y(this));
        this.f = (Button) findViewById(R.id.back);
        this.f.setOnClickListener(new z(this));
        this.g = (Button) findViewById(R.id.edit);
        this.g.setOnClickListener(new aa(this));
        if (this.d.b().size() == 0) {
            this.g.setVisibility(4);
        }
        this.c.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void l() {
        this.d.a(com.baidu.tieba.c.k.r());
        ArrayList b = this.d.b();
        if (b != null) {
            this.c.a(b);
            this.c.b();
            this.c.notifyDataSetInvalidated();
            this.g.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.k != null) {
            this.k.a();
        }
        this.k = new ae(this, null);
        this.k.execute(new com.baidu.tieba.b.j[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.l != null) {
            this.l.a();
        }
        this.l = new ad(this, this.d.a());
        this.l.execute(new Boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (this.m != null) {
            this.m.a();
        }
        this.m = new ac(this, str, i);
        this.m.execute(new Boolean[0]);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1700001:
                    com.baidu.tieba.a.ae aeVar = (com.baidu.tieba.a.ae) intent.getSerializableExtra("mark");
                    if (aeVar != null && this.d.b().size() > this.p && this.p >= 0) {
                        ((com.baidu.tieba.a.ae) this.d.b().get(this.p)).d(aeVar.g());
                        this.c.notifyDataSetChanged();
                        this.c.b();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 1) {
            switch (i) {
                case 1700001:
                    if (this.d.b().size() > this.p && this.p >= 0) {
                        this.d.b().remove(this.p);
                        this.c.notifyDataSetChanged();
                        this.c.b();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        return getSharedPreferences("settings", 0).getInt("uploac_mark_offset", 399);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        SharedPreferences.Editor edit = getSharedPreferences("settings", 0).edit();
        edit.putInt("uploac_mark_offset", i);
        edit.commit();
    }
}

package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EditBarActivity extends com.baidu.tieba.j {
    private NavigationBar c;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.e f2156a = null;
    private ListView b = null;
    private Button d = null;
    private TextView e = null;
    private i f = null;
    private ProgressBar g = null;
    private g j = null;
    private int k = -1;
    private String l = null;
    private h m = null;
    private RelativeLayout n = null;
    private String o = null;
    private int p = 0;

    public static void a(Activity activity, int i, String str, int i2) {
        Intent intent = new Intent(activity, EditBarActivity.class);
        if (str != null) {
            intent.putExtra("view_user_id", str);
            intent.putExtra("user_sex", i2);
        }
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_bar_activity);
        c();
        d();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.m != null) {
            this.m.cancel();
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        super.onDestroy();
    }

    private void b() {
        if (this.j != null) {
            this.j.cancel();
        }
        this.j = new g(this, null);
        this.j.setPriority(3);
        this.j.execute(new Object[0]);
    }

    private void c() {
        this.f2156a = new com.baidu.tieba.model.e();
        this.o = getIntent().getStringExtra("view_user_id");
        this.p = getIntent().getIntExtra("user_sex", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.c.b(i);
        com.baidu.tieba.util.bb.a(this.n, i);
        this.f.notifyDataSetChanged();
        if (i == 1) {
            this.b.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.b.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.b.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.b.setSelector(R.drawable.list_selector);
    }

    private void d() {
        this.n = (RelativeLayout) findViewById(R.id.parent);
        this.c = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.e = this.c.a("");
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.edit));
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.f = new i(this, this.f2156a, this.p);
        this.f.a(new d(this));
        this.b = (ListView) findViewById(R.id.list);
        this.b.setAdapter((ListAdapter) this.f);
        this.b.setOnItemClickListener(new e(this));
        this.d.setOnClickListener(new f(this));
        if (this.o != null) {
            this.d.setVisibility(4);
            if (this.p == 2) {
                this.e.setText(getString(R.string.her_attention_forums));
            } else if (this.p == 1) {
                this.e.setText(getString(R.string.his_attention_forums));
            } else {
                this.e.setText(getString(R.string.ta_attention_forums));
            }
            this.f.b(false);
            return;
        }
        this.e.setText(getString(R.string.my_bar));
        this.f.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.b();
            if (this.f.c()) {
                this.d.setVisibility(4);
                this.f.a(false);
            } else if (this.o == null) {
                this.d.setVisibility(0);
            }
        }
    }
}

package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EditBarActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.b f1588a = null;
    private ListView b = null;
    private ImageView c = null;
    private Button d = null;
    private j e = null;
    private ProgressBar f = null;
    private h g = null;
    private int j = -1;
    private String k = null;
    private i l = null;
    private RelativeLayout m = null;
    private LinearLayout n = null;
    private TextView o = null;
    private String p = null;
    private int q = 0;

    public static void a(Activity activity, int i, String str, int i2) {
        Intent intent = new Intent(activity, EditBarActivity.class);
        if (str != null) {
            intent.putExtra("view_user_id", str);
            intent.putExtra("user_sex", i2);
        }
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_bar_activity);
        c();
        d();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.l != null) {
            this.l.cancel();
        }
        if (this.f != null) {
            this.f.setVisibility(8);
        }
        super.onDestroy();
    }

    private void b() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.g = new h(this, null);
        this.g.setPriority(3);
        this.g.execute(new Object[0]);
    }

    private void c() {
        this.f1588a = new com.baidu.tieba.model.b();
        this.p = getIntent().getStringExtra("view_user_id");
        this.q = getIntent().getIntExtra("user_sex", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ao.a(this.m, i);
        com.baidu.tieba.util.ao.d(this.n, i);
        com.baidu.tieba.util.ao.f(this.o, i);
        com.baidu.tieba.util.ao.a(this.c, i);
        com.baidu.tieba.util.ao.g((TextView) this.d, i);
        this.e.notifyDataSetChanged();
        if (i == 1) {
            this.b.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.b.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.b.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.b.setSelector(R.drawable.list_selector);
    }

    private void d() {
        this.m = (RelativeLayout) findViewById(R.id.parent);
        this.n = (LinearLayout) findViewById(R.id.title);
        this.o = (TextView) findViewById(R.id.title_text);
        this.f = (ProgressBar) findViewById(R.id.progress);
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(new d(this));
        this.e = new j(this, this.f1588a, this.q);
        this.e.a(new e(this));
        this.b = (ListView) findViewById(R.id.list);
        this.b.setAdapter((ListAdapter) this.e);
        this.b.setOnItemClickListener(new f(this));
        this.d = (Button) findViewById(R.id.edit);
        this.d.setOnClickListener(new g(this));
        if (this.p != null) {
            this.d.setVisibility(4);
            if (this.q == 2) {
                this.o.setText(getString(R.string.her_attention_forums));
            } else if (this.q == 1) {
                this.o.setText(getString(R.string.his_attention_forums));
            } else {
                this.o.setText(getString(R.string.ta_attention_forums));
            }
            this.e.b(false);
            return;
        }
        this.o.setText(getString(R.string.my_bar));
        this.e.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.e != null) {
            this.e.b();
            if (this.e.c()) {
                this.d.setVisibility(4);
                this.e.a(false);
            } else if (this.p == null) {
                this.d.setVisibility(0);
            }
        }
    }
}

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
    private com.baidu.tieba.model.b f1550a = null;
    private ListView b = null;
    private ImageView c = null;
    private Button d = null;
    private j e = null;
    private ProgressBar f = null;
    private h g = null;
    private int j = -1;
    private i k = null;
    private RelativeLayout l = null;
    private LinearLayout m = null;
    private TextView n = null;
    private String o = null;

    public static void a(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, EditBarActivity.class);
        if (str != null) {
            intent.putExtra("view_user_id", str);
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
        if (this.k != null) {
            this.k.cancel();
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
        this.f1550a = new com.baidu.tieba.model.b();
        this.o = getIntent().getStringExtra("view_user_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.a(this.l, i);
        com.baidu.tieba.util.ah.d(this.m, i);
        com.baidu.tieba.util.ah.f(this.n, i);
        com.baidu.tieba.util.ah.a(this.c, i);
        com.baidu.tieba.util.ah.g((TextView) this.d, i);
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
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.m = (LinearLayout) findViewById(R.id.title);
        this.n = (TextView) findViewById(R.id.title_text);
        this.f = (ProgressBar) findViewById(R.id.progress);
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(new d(this));
        this.e = new j(this, this.f1550a);
        this.e.a(new e(this));
        this.b = (ListView) findViewById(R.id.list);
        this.b.setAdapter((ListAdapter) this.e);
        this.b.setOnItemClickListener(new f(this));
        this.d = (Button) findViewById(R.id.edit);
        this.d.setOnClickListener(new g(this));
        if (this.o != null) {
            this.d.setVisibility(4);
            this.n.setText(getString(R.string.its_bar));
            this.e.b(false);
            return;
        }
        this.n.setText(getString(R.string.my_bar));
        this.e.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.e != null) {
            this.e.b();
            if (this.e.c()) {
                this.d.setVisibility(4);
                this.e.a(false);
            } else if (this.o == null) {
                this.d.setVisibility(0);
            }
        }
    }
}

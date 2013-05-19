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
public class EditBarActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.c.b c = null;
    private ListView d = null;
    private ImageView e = null;
    private Button f = null;
    private i g = null;
    private ProgressBar h = null;
    private g i = null;
    private int j = -1;
    private h k = null;
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
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.edit_bar_activity);
        c();
        d();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.h != null) {
            this.h.setVisibility(8);
        }
        super.onDestroy();
    }

    private void b() {
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = new g(this, null);
        this.i.setPriority(3);
        this.i.execute(new Object[0]);
    }

    private void c() {
        this.c = new com.baidu.tieba.c.b();
        this.o = getIntent().getStringExtra("view_user_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.a(this.l, i);
        com.baidu.tieba.d.ac.d(this.m, i);
        com.baidu.tieba.d.ac.f(this.n, i);
        com.baidu.tieba.d.ac.a(this.e, i);
        com.baidu.tieba.d.ac.g((TextView) this.f, i);
        this.g.notifyDataSetChanged();
        if (i == 1) {
            this.d.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.d.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.d.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.d.setSelector(R.drawable.list_selector);
    }

    private void d() {
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.m = (LinearLayout) findViewById(R.id.title);
        this.n = (TextView) findViewById(R.id.title_text);
        this.h = (ProgressBar) findViewById(R.id.progress);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(new c(this));
        this.g = new i(this, this.c);
        this.g.a(new d(this));
        this.d = (ListView) findViewById(R.id.list);
        this.d.setAdapter((ListAdapter) this.g);
        this.d.setOnItemClickListener(new e(this));
        this.f = (Button) findViewById(R.id.edit);
        this.f.setOnClickListener(new f(this));
        if (this.o != null) {
            this.f.setVisibility(4);
            this.n.setText(getString(R.string.its_bar));
            this.g.b(false);
            return;
        }
        this.n.setText(getString(R.string.my_bar));
        this.g.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.g != null) {
            this.g.b();
            if (this.g.c()) {
                this.f.setVisibility(4);
                this.g.a(false);
            } else if (this.o == null) {
                this.f.setVisibility(0);
            }
        }
    }
}

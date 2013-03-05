package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtListActivity extends com.baidu.tieba.e {
    private EditText c = null;
    private Button d = null;
    private Button e = null;
    private ListView f = null;
    private Handler g = new Handler();
    private i h = null;
    private j i = null;
    private com.baidu.tieba.b.a j = null;
    private k k = null;
    private String l = null;
    private ProgressBar m = null;
    private RelativeLayout n = null;
    private RelativeLayout o = null;
    private TextView p = null;
    private Runnable q = new a(this);
    private Runnable r = new b(this);

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, AtListActivity.class), i);
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("name");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_list_activity);
        a(bundle);
        i();
        c((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.a(this.n, i);
        com.baidu.tieba.c.ae.c(this.o, i);
        com.baidu.tieba.c.ae.c(this.p, i);
        com.baidu.tieba.c.ae.e((TextView) this.e, i);
        this.k.notifyDataSetChanged();
        if (i == 1) {
            this.f.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.f.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.f.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.f.setSelector(R.drawable.list_selector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.h != null) {
            this.h.a();
        }
        if (this.i != null) {
            this.i.a();
        }
        this.g.removeCallbacks(this.q);
        this.g.removeCallbacks(this.r);
        if (this.k != null) {
            this.k.a();
            if (this.k.c() != null) {
                this.k.c().b();
            }
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        super.onDestroy();
    }

    private void i() {
        this.n = (RelativeLayout) findViewById(R.id.parent);
        this.o = (RelativeLayout) findViewById(R.id.title);
        this.p = (TextView) findViewById(R.id.title_text);
        this.m = (ProgressBar) findViewById(R.id.progress);
        this.c = (EditText) findViewById(R.id.at_search_edit);
        this.c.addTextChangedListener(new d(this));
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new e(this));
        this.d = (Button) findViewById(R.id.at_search_del);
        this.d.setOnClickListener(new f(this));
        this.f = (ListView) findViewById(R.id.list);
        this.k = new k(this, false, true);
        this.f.setAdapter((ListAdapter) this.k);
        this.f.setOnItemClickListener(new g(this));
        this.f.setOnScrollListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!isFinishing()) {
            this.k.a((ArrayList) null);
            if (this.h != null) {
                this.h.a();
            }
            if (str == null || str.length() == 0) {
                if (this.j.a() != null) {
                    this.k.a(this.j.a().a());
                } else {
                    this.k.a((ArrayList) null);
                    if (this.i == null) {
                        this.i = new j(this, null);
                        this.i.execute("");
                    }
                }
            } else {
                this.h = new i(this, null);
                this.h.execute(str);
                if (this.i == null && this.j.a() == null) {
                    this.i = new j(this, null);
                    this.i.execute("");
                }
            }
            this.k.notifyDataSetInvalidated();
            this.f.setSelection(0);
        }
    }

    private void a(Bundle bundle) {
        this.j = new com.baidu.tieba.b.a();
    }
}

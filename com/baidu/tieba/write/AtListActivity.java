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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtListActivity extends com.baidu.tieba.e {
    private EditText b = null;
    private Button c = null;
    private Button d = null;
    private ListView e = null;
    private Handler f = new Handler();
    private i g = null;
    private j h = null;
    private com.baidu.tieba.b.a i = null;
    private k j = null;
    private String k = null;
    private ProgressBar l = null;
    private Runnable m = new a(this);
    private Runnable n = new b(this);

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("name");
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, AtListActivity.class), i);
    }

    private void a(Bundle bundle) {
        this.i = new com.baidu.tieba.b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (isFinishing()) {
            return;
        }
        this.j.a((ArrayList) null);
        if (this.g != null) {
            this.g.a();
        }
        if (str != null && str.length() != 0) {
            this.g = new i(this, null);
            this.g.execute(str);
            if (this.h == null && this.i.a() == null) {
                this.h = new j(this, null);
                this.h.execute("");
            }
        } else if (this.i.a() != null) {
            this.j.a(this.i.a().a());
        } else {
            this.j.a((ArrayList) null);
            if (this.h == null) {
                this.h = new j(this, null);
                this.h.execute("");
            }
        }
        this.j.notifyDataSetInvalidated();
        this.e.setSelection(0);
    }

    private void g() {
        this.l = (ProgressBar) findViewById(R.id.progress);
        this.b = (EditText) findViewById(R.id.at_search_edit);
        this.b.addTextChangedListener(new d(this));
        this.d = (Button) findViewById(R.id.back);
        this.d.setOnClickListener(new e(this));
        this.c = (Button) findViewById(R.id.at_search_del);
        this.c.setOnClickListener(new f(this));
        this.e = (ListView) findViewById(R.id.list);
        this.j = new k(this, false);
        this.e.setAdapter((ListAdapter) this.j);
        this.e.setOnItemClickListener(new g(this));
        this.e.setOnScrollListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_list_activity);
        a(bundle);
        g();
        c((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.a();
        }
        if (this.h != null) {
            this.h.a();
        }
        this.f.removeCallbacks(this.m);
        this.f.removeCallbacks(this.n);
        if (this.j != null) {
            this.j.a();
            if (this.j.c() != null) {
                this.j.c().b();
            }
        }
        if (this.l != null) {
            this.l.setVisibility(8);
        }
        super.onDestroy();
    }
}

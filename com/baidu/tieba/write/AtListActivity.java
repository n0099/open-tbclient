package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AtListActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private EditText f1538a = null;
    private Button b = null;
    private ImageView c = null;
    private ListView d = null;
    private Handler e = new Handler();
    private i f = null;
    private j g = null;
    private com.baidu.tieba.model.a j = null;
    private k k = null;
    private String l = null;
    private ProgressBar m = null;
    private RelativeLayout n = null;
    private RelativeLayout o = null;
    private TextView p = null;
    private Runnable q = new a(this);
    private Runnable r = new b(this);

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, AtListActivity.class);
        if (i == 1200011) {
            intent.putExtra("keyboard", false);
        }
        activity.startActivityForResult(intent, i);
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("name_show");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.at_list_activity);
        a(bundle);
        b();
        c((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.a(this.n, i);
        com.baidu.tieba.util.x.d(this.o, i);
        com.baidu.tieba.util.x.f(this.p, i);
        com.baidu.tieba.util.x.a(this.c, i);
        this.k.notifyDataSetChanged();
        if (i == 1) {
            this.d.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            this.d.setSelector(R.drawable.list_selector_1);
            return;
        }
        this.d.setDivider(getResources().getDrawable(R.drawable.list_divider));
        this.d.setSelector(R.drawable.list_selector);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.f != null) {
            this.f.cancel();
        }
        if (this.g != null) {
            this.g.cancel();
        }
        this.e.removeCallbacks(this.q);
        this.e.removeCallbacks(this.r);
        if (this.k != null) {
            this.k.a();
            if (this.k.b() != null) {
                this.k.b().b();
            }
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        super.onDestroy();
    }

    private void b() {
        this.n = (RelativeLayout) findViewById(R.id.parent);
        this.o = (RelativeLayout) findViewById(R.id.title);
        this.p = (TextView) findViewById(R.id.title_text);
        this.m = (ProgressBar) findViewById(R.id.progress);
        this.f1538a = (EditText) findViewById(R.id.at_search_edit);
        this.f1538a.addTextChangedListener(new d(this));
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(new e(this));
        this.b = (Button) findViewById(R.id.at_search_del);
        this.b.setOnClickListener(new f(this));
        this.d = (ListView) findViewById(R.id.list);
        this.k = new k(this, false, true);
        this.d.setAdapter((ListAdapter) this.k);
        this.d.setOnItemClickListener(new g(this));
        this.d.setOnScrollListener(new h(this));
        if (!getIntent().getBooleanExtra("keyboard", true) && this.f1538a.getParent() != null) {
            ((View) this.f1538a.getParent()).setFocusable(true);
            ((View) this.f1538a.getParent()).setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!isFinishing()) {
            this.k.a(null);
            if (this.f != null) {
                this.f.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.j.a() != null) {
                    this.k.a(this.j.a().a());
                } else {
                    this.k.a(null);
                    if (this.g == null) {
                        this.g = new j(this, null);
                        this.g.setPriority(3);
                        this.g.execute("");
                    }
                }
            } else {
                this.f = new i(this, null);
                this.f.setPriority(2);
                this.f.execute(str);
                if (this.g == null && this.j.a() == null) {
                    this.g = new j(this, null);
                    this.g.setPriority(3);
                    this.g.execute("");
                }
            }
            this.k.notifyDataSetInvalidated();
            this.d.setSelection(0);
        }
    }

    private void a(Bundle bundle) {
        this.j = new com.baidu.tieba.model.a();
    }
}

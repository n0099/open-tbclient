package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtListActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList f1885a = new ArrayList();
    private com.baidu.tieba.ab r;
    private LinearLayout s;
    private LinearLayout t;
    private ImageView u;
    private EditText b = null;
    private Button c = null;
    private ImageView d = null;
    private ListView e = null;
    private Handler f = new Handler();
    private i g = null;
    private j j = null;
    private com.baidu.tieba.model.a k = null;
    private k l = null;
    private String m = null;
    private ProgressBar n = null;
    private RelativeLayout o = null;
    private RelativeLayout p = null;
    private TextView q = null;
    private Runnable v = new a(this);
    private Runnable w = new b(this);

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, AtListActivity.class);
        if (i == 12011) {
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
        this.r = new com.baidu.tieba.ab(this, R.drawable.individual_center_like, R.drawable.individual_center_like_1);
        a(bundle);
        b();
        c((String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.r.a(i);
        com.baidu.tieba.util.ao.a(this.o, i);
        com.baidu.tieba.util.ao.d(this.p, i);
        com.baidu.tieba.util.ao.f(this.q, i);
        com.baidu.tieba.util.ao.a(this.d, i);
        this.l.notifyDataSetChanged();
        if (i == 1) {
            this.e.setDivider(getResources().getDrawable(R.drawable.list_divider_1));
            com.baidu.tieba.util.ao.g(this.s, (int) R.drawable.inputbox_topbg_1);
            this.t.setBackgroundResource(R.drawable.inputbox_top_1);
            this.u.setImageResource(R.drawable.icon_head_bar_search_1);
            this.b.setTextColor(-11446171);
            this.b.setHintTextColor(-11446171);
            this.c.setBackgroundResource(R.drawable.search_delete_button_1);
            return;
        }
        this.e.setDivider(getResources().getDrawable(R.drawable.list_divider));
        com.baidu.tieba.util.ao.g(this.s, (int) R.drawable.tabbar_bj_tab);
        this.t.setBackgroundResource(R.drawable.inputbox_top);
        this.u.setImageResource(R.drawable.icon_head_bar_search);
        this.b.setTextColor(-5921112);
        this.b.setHintTextColor(-5921112);
        this.c.setBackgroundResource(R.drawable.search_delete_button);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.r.a();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.r.b();
    }

    public void a(boolean z) {
        if (z) {
            this.e.setVisibility(8);
            this.r.b(0);
            return;
        }
        this.e.setVisibility(0);
        this.r.b(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
        this.f.removeCallbacks(this.v);
        this.f.removeCallbacks(this.w);
        if (this.l != null) {
            this.l.a();
            if (this.l.b() != null) {
                this.l.b().b();
            }
        }
        if (this.n != null) {
            this.n.setVisibility(8);
        }
        super.onDestroy();
    }

    private void b() {
        this.o = (RelativeLayout) findViewById(R.id.parent);
        this.p = (RelativeLayout) findViewById(R.id.title);
        this.q = (TextView) findViewById(R.id.title_text);
        this.n = (ProgressBar) findViewById(R.id.progress);
        this.s = (LinearLayout) findViewById(R.id.search);
        this.t = (LinearLayout) findViewById(R.id.search_tap_text_layout);
        this.u = (ImageView) findViewById(R.id.at_search_logo);
        this.b = (EditText) findViewById(R.id.at_search_edit);
        this.b.addTextChangedListener(new d(this));
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new e(this));
        this.c = (Button) findViewById(R.id.at_search_del);
        this.c.setOnClickListener(new f(this));
        this.e = (ListView) findViewById(R.id.list);
        this.l = new k(this, false, true);
        this.e.setAdapter((ListAdapter) this.l);
        this.e.setOnItemClickListener(new g(this));
        this.e.setOnScrollListener(new h(this));
        if (!getIntent().getBooleanExtra("keyboard", true) && this.b.getParent() != null) {
            ((View) this.b.getParent()).setFocusable(true);
            ((View) this.b.getParent()).setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!isFinishing()) {
            this.l.a(null);
            if (this.g != null) {
                this.g.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.k.a() != null) {
                    this.l.a(this.k.a().a());
                } else {
                    this.l.a(null);
                    if (this.j == null) {
                        this.j = new j(this, null);
                        this.j.setPriority(3);
                        this.j.execute("");
                    }
                }
            } else {
                this.g = new i(this, null);
                this.g.setPriority(2);
                this.g.execute(str);
                if (this.j == null && this.k.a() == null) {
                    this.j = new j(this, null);
                    this.j.setPriority(3);
                    this.j.execute("");
                }
            }
            this.l.notifyDataSetInvalidated();
            this.e.setSelection(0);
        }
    }

    private void a(Bundle bundle) {
        this.k = new com.baidu.tieba.model.a();
    }
}

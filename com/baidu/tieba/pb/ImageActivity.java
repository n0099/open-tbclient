package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageActivity extends com.baidu.tieba.e {
    private ProgressBar c = null;
    private ArrayList d = null;
    private int e = -1;
    private int f = -1;
    private boolean g = false;
    private String h = null;
    private i i = null;
    private Button j = null;
    private Button k = null;
    private TextView l = null;
    private LinearLayout m = null;
    private MultiImageView n = null;
    private View.OnClickListener o = null;
    private com.baidu.tieba.view.a p = null;
    private android.support.v4.view.aj q = null;
    private AlphaAnimation r = null;
    private boolean s = true;
    private boolean t = false;
    private h u = null;
    private long v = 0;
    private HashMap w = null;
    private String x = null;
    private String y = null;
    private String z = null;
    private String A = null;

    public static void a(Context context, ArrayList arrayList, int i, com.baidu.tieba.b.p pVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (pVar != null) {
                if (pVar.a() != null && pVar.a().a() != null) {
                    intent.putExtra("fname", pVar.a().a().c());
                    intent.putExtra("fid", pVar.a().a().b());
                }
                if (pVar.a() != null && pVar.a().b() != null) {
                    intent.putExtra("tid", pVar.a().b().a());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, ArrayList arrayList, int i, int i2, boolean z, com.baidu.tieba.a.v vVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("count", i2);
            intent.putExtra("hasnext", z);
            intent.putExtra("pv_type", "photo");
            if (vVar != null) {
                intent.putExtra("nexttitle", vVar.g());
                intent.putExtra("fname", vVar.i());
                intent.putExtra("fid", vVar.j());
                intent.putExtra("tid", vVar.c());
            }
            ((Activity) context).startActivityForResult(intent, 1400001);
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.b().a((com.baidu.tieba.e) this);
        setContentView(R.layout.image_activity);
        a(bundle);
        m();
        l();
    }

    public String i() {
        return this.x;
    }

    public String j() {
        return this.y;
    }

    public String k() {
        return this.z;
    }

    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        if (i == 1) {
            this.n.setBackgroundColor(com.baidu.tieba.c.ad.d(i));
        } else {
            this.n.setBackgroundColor(-16777216);
        }
    }

    private void l() {
        this.u = new h(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.imagepb.pageadded");
        registerReceiver(this.u, intentFilter);
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.n.b();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.n.a();
    }

    @Override // com.baidu.tieba.e
    public void b() {
        this.n.c();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        TiebaApplication.b().b((com.baidu.tieba.e) this);
        a(this.e, this.e);
        p();
        this.n.c();
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.c != null) {
            this.c.setVisibility(8);
        }
        unregisterReceiver(this.u);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.e);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void m() {
        this.o = new d(this);
        this.q = new f(this);
        this.p = new g(this);
        this.m = (LinearLayout) findViewById(R.id.title);
        this.c = (ProgressBar) findViewById(R.id.progress);
        this.j = (Button) findViewById(R.id.save);
        this.j.setOnClickListener(this.o);
        this.k = (Button) findViewById(R.id.back);
        this.k.setOnClickListener(this.o);
        this.l = (TextView) findViewById(R.id.titel_text);
        this.n = (MultiImageView) findViewById(R.id.viewpager);
        this.n.setPageMargin(com.baidu.tieba.c.ah.a(this, 8.0f));
        this.n.a(2, com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g());
        this.n.setOnPageChangeListener(this.q);
        this.n.setUrlData(this.d);
        this.n.setItemOnclickListener(this.o);
        this.n.a(o(), false);
        this.n.setOnScrollOutListener(this.p);
        this.n.setHasNext(this.g);
        this.n.setNextTitle(this.h);
        a(this.e, this.e);
        n();
    }

    public void n() {
        String str;
        if (this.d != null) {
            String str2 = String.valueOf(String.valueOf(this.e + 1)) + "/";
            if (this.f > 0) {
                str = String.valueOf(str2) + this.f;
            } else {
                str = String.valueOf(str2) + this.d.size();
            }
            if (this.e == this.f) {
                this.l.setText(getString(R.string.image_recommend));
                this.j.setVisibility(4);
                return;
            }
            this.l.setText(str);
            this.j.setVisibility(0);
        }
    }

    public int o() {
        if (this.d != null && this.d.size() > 0) {
            int size = this.d.size();
            if (this.e >= size) {
                this.e = size - 1;
            }
            if (this.e < 0) {
                this.e = 0;
            }
        } else {
            this.e = 0;
        }
        return this.e;
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.d = bundle.getStringArrayList("url");
            this.e = bundle.getInt("index", -1);
            this.f = bundle.getInt("count", -1);
            this.g = bundle.getBoolean("hasnext", false);
            this.h = bundle.getString("nexttitle");
            this.x = bundle.getString("fid");
            this.y = bundle.getString("tid");
            this.z = bundle.getString("fname");
            this.A = bundle.getString("pv_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.d = intent.getStringArrayListExtra("url");
                this.e = intent.getIntExtra("index", -1);
                this.f = intent.getIntExtra("count", -1);
                this.g = intent.getBooleanExtra("hasnext", false);
                this.h = intent.getStringExtra("nexttitle");
                this.x = intent.getStringExtra("fid");
                this.y = intent.getStringExtra("tid");
                this.z = intent.getStringExtra("fname");
                this.A = intent.getStringExtra("pv_type");
            }
        }
        this.w = new HashMap();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.d);
        bundle.putInt("index", this.e);
        bundle.putInt("count", this.f);
        bundle.putBoolean("hasNext", this.g);
        bundle.putString("nexttitle", this.h);
        bundle.putString("fid", this.x);
        bundle.putString("tid", this.y);
        bundle.putString("fname", this.z);
        bundle.putString("pv_type", this.A);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.n.a(this.e, true);
    }

    public void a(int i, int i2) {
        synchronized (this.w) {
            if (System.nanoTime() - this.v > 300000000 && this.d != null && i < this.d.size()) {
                this.w.put((String) this.d.get(i), true);
            }
            this.v = System.nanoTime();
            if (this.d != null && i2 < this.d.size() && this.w.get(this.d.get(i2)) == null) {
                this.w.put((String) this.d.get(i2), false);
            }
        }
        if (this.w.size() >= 100) {
            p();
        }
    }

    private void p() {
        if (this.w != null) {
            synchronized (this.w) {
                if (this.w.size() > 0) {
                    int i = 0;
                    for (Map.Entry entry : this.w.entrySet()) {
                        if (((Boolean) entry.getValue()).booleanValue()) {
                            i++;
                        }
                    }
                    TiebaApplication.b().a(i, this.w.size(), this.A);
                    this.w.clear();
                }
            }
        }
    }
}

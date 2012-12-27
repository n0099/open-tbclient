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
    private ProgressBar b = null;
    private ArrayList c = null;
    private int d = -1;
    private int e = -1;
    private boolean f = false;
    private String g = null;
    private i h = null;
    private Button i = null;
    private Button j = null;
    private TextView k = null;
    private LinearLayout l = null;
    private MultiImageView m = null;
    private View.OnClickListener n = null;
    private com.baidu.tieba.view.a o = null;
    private android.support.v4.view.aj p = null;
    private AlphaAnimation q = null;
    private boolean r = true;
    private boolean s = false;
    private h t = null;
    private long u = 0;
    private HashMap v = null;
    private String w = null;
    private String x = null;
    private String y = null;
    private String z = null;

    public void a(int i, int i2) {
        synchronized (this.v) {
            if (System.nanoTime() - this.u > 300000000 && this.c != null && i < this.c.size()) {
                this.v.put((String) this.c.get(i), true);
            }
            this.u = System.nanoTime();
            if (this.c != null && i2 < this.c.size() && this.v.get(this.c.get(i2)) == null) {
                this.v.put((String) this.c.get(i2), false);
            }
        }
        if (this.v.size() >= 100) {
            n();
        }
    }

    public static void a(Context context, ArrayList arrayList, int i, int i2, boolean z, com.baidu.tieba.a.u uVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        intent.putStringArrayListExtra("url", arrayList);
        intent.putExtra("index", i);
        intent.putExtra("count", i2);
        intent.putExtra("hasnext", z);
        intent.putExtra("pv_type", "photo");
        if (uVar != null) {
            intent.putExtra("nexttitle", uVar.g());
            intent.putExtra("fname", uVar.i());
            intent.putExtra("fid", uVar.j());
            intent.putExtra("tid", uVar.c());
        }
        ((Activity) context).startActivityForResult(intent, 1400001);
    }

    public static void a(Context context, ArrayList arrayList, int i, com.baidu.tieba.b.n nVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        intent.putStringArrayListExtra("url", arrayList);
        intent.putExtra("index", i);
        intent.putExtra("is_pv", true);
        intent.putExtra("pv_type", "pb");
        if (nVar != null) {
            if (nVar.a() != null && nVar.a().a() != null) {
                intent.putExtra("fname", nVar.a().a().c());
                intent.putExtra("fid", nVar.a().a().b());
            }
            if (nVar.a() != null && nVar.a().b() != null) {
                intent.putExtra("tid", nVar.a().b().a());
            }
        }
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getStringArrayList("url");
            this.d = bundle.getInt("index", -1);
            this.e = bundle.getInt("count", -1);
            this.f = bundle.getBoolean("hasnext", false);
            this.g = bundle.getString("nexttitle");
            this.w = bundle.getString("fid");
            this.x = bundle.getString("tid");
            this.y = bundle.getString("fname");
            this.z = bundle.getString("pv_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.c = intent.getStringArrayListExtra("url");
                this.d = intent.getIntExtra("index", -1);
                this.e = intent.getIntExtra("count", -1);
                this.f = intent.getBooleanExtra("hasnext", false);
                this.g = intent.getStringExtra("nexttitle");
                this.w = intent.getStringExtra("fid");
                this.x = intent.getStringExtra("tid");
                this.y = intent.getStringExtra("fname");
                this.z = intent.getStringExtra("pv_type");
            }
        }
        this.v = new HashMap();
    }

    private void j() {
        this.t = new h(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.imagepb.pageadded");
        registerReceiver(this.t, intentFilter);
    }

    private void k() {
        this.n = new d(this);
        this.p = new f(this);
        this.o = new g(this);
        this.l = (LinearLayout) findViewById(R.id.title);
        this.b = (ProgressBar) findViewById(R.id.progress);
        this.i = (Button) findViewById(R.id.save);
        this.i.setOnClickListener(this.n);
        this.j = (Button) findViewById(R.id.back);
        this.j.setOnClickListener(this.n);
        this.k = (TextView) findViewById(R.id.titel_text);
        this.m = (MultiImageView) findViewById(R.id.viewpager);
        this.m.setPageMargin(com.baidu.tieba.c.ag.a((Context) this, 8.0f));
        this.m.a(2, com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g());
        this.m.setOnPageChangeListener(this.p);
        this.m.setUrlData(this.c);
        this.m.setItemOnclickListener(this.n);
        this.m.a(m(), false);
        this.m.setOnScrollOutListener(this.o);
        this.m.setHasNext(this.f);
        this.m.setNextTitle(this.g);
        a(this.d, this.d);
        l();
    }

    public void l() {
        if (this.c != null) {
            String str = String.valueOf(String.valueOf(this.d + 1)) + "/";
            String str2 = this.e > 0 ? String.valueOf(str) + this.e : String.valueOf(str) + this.c.size();
            if (this.d == this.e) {
                this.k.setText(getString(R.string.image_recommend));
                this.i.setVisibility(4);
                return;
            }
            this.k.setText(str2);
            this.i.setVisibility(0);
        }
    }

    public int m() {
        if (this.c == null || this.c.size() <= 0) {
            this.d = 0;
        } else {
            int size = this.c.size();
            if (this.d >= size) {
                this.d = size - 1;
            }
            if (this.d < 0) {
                this.d = 0;
            }
        }
        return this.d;
    }

    private void n() {
        if (this.v == null) {
            return;
        }
        synchronized (this.v) {
            if (this.v.size() > 0) {
                int i = 0;
                for (Map.Entry entry : this.v.entrySet()) {
                    if (((Boolean) entry.getValue()).booleanValue()) {
                        i++;
                    }
                }
                TiebaApplication.a().a(i, this.v.size(), this.z);
                this.v.clear();
            }
        }
    }

    @Override // com.baidu.tieba.e
    public void a() {
        this.m.c();
    }

    public String g() {
        return this.w;
    }

    public String h() {
        return this.x;
    }

    public String i() {
        return this.y;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.m.a(this.d, true);
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.a().a((com.baidu.tieba.e) this);
        setContentView(R.layout.image_activity);
        a(bundle);
        k();
        j();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        TiebaApplication.a().b((com.baidu.tieba.e) this);
        a(this.d, this.d);
        n();
        this.m.c();
        if (this.h != null) {
            this.h.a();
            this.h = null;
        }
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        unregisterReceiver(this.t);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.d);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.b();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.m.a();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.c);
        bundle.putInt("index", this.d);
        bundle.putInt("count", this.e);
        bundle.putBoolean("hasNext", this.f);
        bundle.putString("nexttitle", this.g);
        bundle.putString("fid", this.w);
        bundle.putString("tid", this.x);
        bundle.putString("fname", this.y);
        bundle.putString("pv_type", this.z);
    }
}

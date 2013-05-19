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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageActivity extends com.baidu.tieba.e {
    private ProgressBar c = null;
    private int d = 0;
    private ArrayList e = null;
    private int f = -1;
    private int g = -1;
    private boolean h = false;
    private String i = null;
    private j j = null;
    private Button k = null;
    private Button l = null;
    private TextView m = null;
    private LinearLayout n = null;
    private MultiImageView o = null;
    private View.OnClickListener p = null;
    private com.baidu.tieba.view.a q = null;
    private android.support.v4.view.aj r = null;
    private AlphaAnimation s = null;
    private boolean t = true;
    private boolean u = false;
    private i v = null;
    private a w = null;
    private long x = 0;
    private HashMap y = null;
    private String z = null;
    private String A = null;
    private String B = null;
    private String C = null;
    private boolean D = false;

    public static void a(Context context, ArrayList arrayList, int i, com.baidu.tieba.c.bd bdVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (bdVar != null) {
                if (bdVar.a() != null && bdVar.a().a() != null) {
                    intent.putExtra("fname", bdVar.a().a().b());
                    intent.putExtra("fid", bdVar.a().a().a());
                }
                if (bdVar.a() != null && bdVar.a().b() != null) {
                    intent.putExtra("tid", bdVar.a().b().a());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, ArrayList arrayList, int i, com.baidu.tieba.a.al alVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (alVar != null) {
                if (alVar.a() != null) {
                    intent.putExtra("fname", alVar.a().b());
                    intent.putExtra("fid", alVar.a().a());
                }
                if (alVar.b() != null) {
                    intent.putExtra("tid", alVar.b().a());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, ArrayList arrayList, int i, int i2, boolean z, com.baidu.tieba.a.x xVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("need_broadcast", true);
            intent.putExtra("count", i2);
            intent.putExtra("hasnext", z);
            intent.putExtra("pv_type", "photo");
            if (xVar != null) {
                intent.putExtra("nexttitle", xVar.g());
                intent.putExtra("fname", xVar.i());
                intent.putExtra("fid", xVar.j());
                intent.putExtra("tid", xVar.c());
            }
            ((Activity) context).startActivityForResult(intent, 1400001);
        }
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.d().a((com.baidu.tieba.e) this);
        setContentView(R.layout.image_activity);
        a(bundle);
        n();
        m();
        if (!this.D) {
            String c = c((String) this.e.get(this.e.size() - 1));
            if (c == null) {
                this.m.setVisibility(8);
            }
            this.w = new a(this.e, this.B, this.A, c);
            this.w.a(new d(this));
            this.w.a();
        }
    }

    public String b() {
        return this.z;
    }

    public String c() {
        return this.A;
    }

    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        if (i == 1) {
            this.o.setBackgroundColor(com.baidu.tieba.d.ac.d(i));
        } else {
            this.o.setBackgroundColor(-16777216);
        }
    }

    public String d() {
        return this.B;
    }

    private void m() {
        if (this.D) {
            this.v = new i(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.imagepb.pageadded");
            registerReceiver(this.v, intentFilter);
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.o.b();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.o.a();
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a
    public void a_() {
        this.o.c();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        TiebaApplication.d().b((com.baidu.tieba.e) this);
        a(this.f, this.f);
        q();
        this.o.c();
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        if (this.c != null) {
            this.c.setVisibility(8);
        }
        if (this.D) {
            unregisterReceiver(this.v);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.f);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void n() {
        this.p = new e(this);
        this.r = new g(this);
        this.q = new h(this);
        this.n = (LinearLayout) findViewById(R.id.title);
        this.c = (ProgressBar) findViewById(R.id.progress);
        this.k = (Button) findViewById(R.id.save);
        this.k.setOnClickListener(this.p);
        this.l = (Button) findViewById(R.id.back);
        this.l.setOnClickListener(this.p);
        this.m = (TextView) findViewById(R.id.titel_text);
        this.o = (MultiImageView) findViewById(R.id.viewpager);
        this.o.setPageMargin(com.baidu.tieba.d.ag.a(this, 8.0f));
        this.o.a(2, com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g());
        this.o.setOnPageChangeListener(this.r);
        this.o.setUrlData(this.e);
        this.o.setItemOnclickListener(this.p);
        this.o.a(p(), false);
        this.o.setOnScrollOutListener(this.q);
        this.o.setHasNext(this.h);
        this.o.setNextTitle(this.i);
        a(this.f, this.f);
        o();
    }

    public void o() {
        String str;
        if (this.e != null) {
            String str2 = String.valueOf(String.valueOf(this.f + 1 + this.d)) + "/";
            if (this.g > 0) {
                str = String.valueOf(str2) + this.g;
            } else if (!this.D) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.e.size();
            }
            if (this.o.getHasNext() && this.f == this.o.getItemNum() - 1) {
                this.m.setText(getString(R.string.image_recommend));
                this.k.setVisibility(4);
                return;
            }
            this.m.setText(str);
            this.k.setVisibility(0);
        }
    }

    public int p() {
        if (this.e != null && this.e.size() > 0) {
            int size = this.e.size();
            if (this.f >= size) {
                this.f = size - 1;
            }
            if (this.f < 0) {
                this.f = 0;
            }
        } else {
            this.f = 0;
        }
        return this.f;
    }

    private void a(Bundle bundle) {
        this.D = getIntent().getBooleanExtra("need_broadcast", false);
        if (bundle != null) {
            this.e = bundle.getStringArrayList("url");
            this.f = bundle.getInt("index", -1);
            this.g = bundle.getInt("count", -1);
            this.h = bundle.getBoolean("hasnext", false);
            this.i = bundle.getString("nexttitle");
            this.z = bundle.getString("fid");
            this.A = bundle.getString("tid");
            this.B = bundle.getString("fname");
            this.C = bundle.getString("pv_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.e = intent.getStringArrayListExtra("url");
                this.f = intent.getIntExtra("index", -1);
                this.g = intent.getIntExtra("count", -1);
                this.h = intent.getBooleanExtra("hasnext", false);
                this.i = intent.getStringExtra("nexttitle");
                this.z = intent.getStringExtra("fid");
                this.A = intent.getStringExtra("tid");
                this.B = intent.getStringExtra("fname");
                this.C = intent.getStringExtra("pv_type");
            }
        }
        this.y = new HashMap();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.e);
        bundle.putInt("index", this.f);
        bundle.putInt("count", this.g);
        bundle.putBoolean("hasNext", this.h);
        bundle.putString("nexttitle", this.i);
        bundle.putString("fid", this.z);
        bundle.putString("tid", this.A);
        bundle.putString("fname", this.B);
        bundle.putString("pv_type", this.C);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.o.a(this.f, true);
    }

    public void a(int i, int i2) {
        synchronized (this.y) {
            if (System.nanoTime() - this.x > 300000000 && this.e != null && i < this.e.size()) {
                this.y.put((String) this.e.get(i), true);
            }
            this.x = System.nanoTime();
            if (this.e != null && i2 < this.e.size() && this.y.get(this.e.get(i2)) == null) {
                this.y.put((String) this.e.get(i2), false);
            }
        }
        if (this.y.size() >= 100) {
            q();
        }
    }

    private void q() {
        if (this.y != null) {
            synchronized (this.y) {
                if (this.y.size() > 0) {
                    int i = 0;
                    for (Map.Entry entry : this.y.entrySet()) {
                        if (((Boolean) entry.getValue()).booleanValue()) {
                            i++;
                        }
                    }
                    TiebaApplication.d().a(i, this.y.size(), this.C);
                    this.y.clear();
                }
            }
        }
    }

    private String c(String str) {
        int lastIndexOf;
        int indexOf;
        String e = com.baidu.tieba.d.ad.e(str);
        if (e != null) {
            if (e.indexOf(".baidu.com") != -1 && (lastIndexOf = e.lastIndexOf("/")) != -1 && (indexOf = e.indexOf(".", lastIndexOf)) != -1) {
                return e.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return e;
    }
}

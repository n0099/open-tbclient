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
public class ImageActivity extends com.baidu.tieba.g {

    /* renamed from: a */
    private ProgressBar f1186a = null;
    private int b = 0;
    private ArrayList c = null;
    private int d = -1;
    private int e = -1;
    private boolean f = false;
    private String g = null;
    private j j = null;
    private Button k = null;
    private Button l = null;
    private TextView m = null;
    private LinearLayout n = null;
    private MultiImageView o = null;
    private View.OnClickListener p = null;
    private com.baidu.tieba.view.a q = null;
    private android.support.v4.view.bq r = null;
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

    public static void a(Context context, ArrayList arrayList, int i, com.baidu.tieba.model.bg bgVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (bgVar != null) {
                if (bgVar.a() != null && bgVar.a().a() != null) {
                    intent.putExtra("fname", bgVar.a().a().b());
                    intent.putExtra("fid", bgVar.a().a().a());
                }
                if (bgVar.a() != null && bgVar.a().b() != null) {
                    intent.putExtra("tid", bgVar.a().b().a());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, ArrayList arrayList, int i, com.baidu.tieba.data.aj ajVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (ajVar != null) {
                if (ajVar.a() != null) {
                    intent.putExtra("fname", ajVar.a().b());
                    intent.putExtra("fid", ajVar.a().a());
                }
                if (ajVar.b() != null) {
                    intent.putExtra("tid", ajVar.b().a());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, ArrayList arrayList, int i, int i2, boolean z, com.baidu.tieba.data.w wVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("need_broadcast", true);
            intent.putExtra("count", i2);
            intent.putExtra("hasnext", z);
            intent.putExtra("pv_type", "photo");
            if (wVar != null) {
                intent.putExtra("nexttitle", wVar.g());
                intent.putExtra("fname", wVar.i());
                intent.putExtra("fid", wVar.j());
                intent.putExtra("tid", wVar.c());
            }
            ((Activity) context).startActivityForResult(intent, 1400001);
        }
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.f().a((com.baidu.tieba.g) this);
        setContentView(R.layout.image_activity);
        a(bundle);
        n();
        m();
        if (!this.D) {
            String c = c((String) this.c.get(this.c.size() - 1));
            if (c == null) {
                this.m.setVisibility(8);
            }
            this.w = new a(this.c, this.B, this.A, c);
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

    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        if (i == 1) {
            this.o.setBackgroundColor(com.baidu.tieba.util.x.d(i));
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

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        this.o.b();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.o.a();
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a
    public void a_() {
        this.o.c();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        TiebaApplication.f().b((com.baidu.tieba.g) this);
        b(this.d, this.d);
        q();
        this.o.c();
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        if (this.f1186a != null) {
            this.f1186a.setVisibility(8);
        }
        if (this.D) {
            unregisterReceiver(this.v);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
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

    private void n() {
        this.p = new e(this);
        this.r = new g(this);
        this.q = new h(this);
        this.n = (LinearLayout) findViewById(R.id.title);
        this.f1186a = (ProgressBar) findViewById(R.id.progress);
        this.k = (Button) findViewById(R.id.save);
        this.k.setOnClickListener(this.p);
        this.l = (Button) findViewById(R.id.back);
        this.l.setOnClickListener(this.p);
        this.m = (TextView) findViewById(R.id.titel_text);
        this.o = (MultiImageView) findViewById(R.id.viewpager);
        this.o.setPageMargin(com.baidu.tieba.util.ab.a(this, 8.0f));
        this.o.a(2, com.baidu.tieba.data.g.h() * com.baidu.tieba.data.g.h());
        this.o.setOnPageChangeListener(this.r);
        this.o.setUrlData(this.c);
        this.o.setItemOnclickListener(this.p);
        this.o.a(p(), false);
        this.o.setOnScrollOutListener(this.q);
        this.o.setHasNext(this.f);
        this.o.setNextTitle(this.g);
        b(this.d, this.d);
        o();
    }

    public void o() {
        String str;
        if (this.c != null) {
            String str2 = String.valueOf(String.valueOf(this.d + 1 + this.b)) + "/";
            if (this.e > 0) {
                str = String.valueOf(str2) + this.e;
            } else if (!this.D) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.c.size();
            }
            if (this.o.getHasNext() && this.d == this.o.getItemNum() - 1) {
                this.m.setText(getString(R.string.image_recommend));
                this.k.setVisibility(4);
                return;
            }
            this.m.setText(str);
            this.k.setVisibility(0);
        }
    }

    public int p() {
        if (this.c != null && this.c.size() > 0) {
            int size = this.c.size();
            if (this.d >= size) {
                this.d = size - 1;
            }
            if (this.d < 0) {
                this.d = 0;
            }
        } else {
            this.d = 0;
        }
        return this.d;
    }

    private void a(Bundle bundle) {
        this.D = getIntent().getBooleanExtra("need_broadcast", false);
        if (bundle != null) {
            this.c = bundle.getStringArrayList("url");
            this.d = bundle.getInt("index", -1);
            this.e = bundle.getInt("count", -1);
            this.f = bundle.getBoolean("hasnext", false);
            this.g = bundle.getString("nexttitle");
            this.z = bundle.getString("fid");
            this.A = bundle.getString("tid");
            this.B = bundle.getString("fname");
            this.C = bundle.getString("pv_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.c = intent.getStringArrayListExtra("url");
                this.d = intent.getIntExtra("index", -1);
                this.e = intent.getIntExtra("count", -1);
                this.f = intent.getBooleanExtra("hasnext", false);
                this.g = intent.getStringExtra("nexttitle");
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
        bundle.putStringArrayList("url", this.c);
        bundle.putInt("index", this.d);
        bundle.putInt("count", this.e);
        bundle.putBoolean("hasNext", this.f);
        bundle.putString("nexttitle", this.g);
        bundle.putString("fid", this.z);
        bundle.putString("tid", this.A);
        bundle.putString("fname", this.B);
        bundle.putString("pv_type", this.C);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.o.a(this.d, true);
    }

    public void b(int i, int i2) {
        synchronized (this.y) {
            if (System.nanoTime() - this.x > 300000000 && this.c != null && i < this.c.size()) {
                this.y.put((String) this.c.get(i), true);
            }
            this.x = System.nanoTime();
            if (this.c != null && i2 < this.c.size() && this.y.get(this.c.get(i2)) == null) {
                this.y.put((String) this.c.get(i2), false);
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
                    TiebaApplication.f().a(i, this.y.size(), this.C);
                    this.y.clear();
                }
            }
        }
    }

    private String c(String str) {
        int lastIndexOf;
        int indexOf;
        String e = com.baidu.tieba.util.y.e(str);
        if (e != null) {
            if (e.indexOf(".baidu.com") != -1 && (lastIndexOf = e.lastIndexOf("/")) != -1 && (indexOf = e.indexOf(".", lastIndexOf)) != -1) {
                return e.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return e;
    }
}

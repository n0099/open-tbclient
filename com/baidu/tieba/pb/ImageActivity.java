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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.MultiImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageActivity extends com.baidu.tieba.j {
    private FrameLayout D;
    private ProgressBar a = null;
    private int b = 0;
    private ArrayList<String> c = null;
    private int d = -1;
    private int e = -1;
    private boolean f = false;
    private String g = null;
    private j h = null;
    private TextView i = null;
    private ImageView j = null;
    private TextView k = null;
    private NavigationBar l = null;
    private MultiImageView m = null;
    private View.OnClickListener n = null;
    private com.baidu.tieba.view.a o = null;
    private android.support.v4.view.bq p = null;
    private AlphaAnimation q = null;
    private boolean r = true;
    private boolean s = false;
    private i t = null;
    private a u = null;
    private long v = 0;
    private HashMap<String, Boolean> w = null;
    private String x = null;
    private String y = null;
    private String z = null;
    private String A = null;
    private boolean B = false;
    private boolean C = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(ImageActivity imageActivity, int i) {
        int i2 = imageActivity.b + i;
        imageActivity.b = i2;
        return i2;
    }

    public static void a(Context context, ArrayList<String> arrayList, int i, com.baidu.tieba.model.bv bvVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra(SocialConstants.PARAM_URL, arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (bvVar != null) {
                if (bvVar.a() != null && bvVar.a().c() != null) {
                    intent.putExtra("fname", bvVar.a().c().getName());
                    intent.putExtra("fid", bvVar.a().c().getId());
                }
                if (bvVar.a() != null && bvVar.a().d() != null) {
                    intent.putExtra("tid", bvVar.a().d().a());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, ArrayList<String> arrayList, int i, com.baidu.tieba.data.ao aoVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra(SocialConstants.PARAM_URL, arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (aoVar != null) {
                intent.putExtra("isCdn", aoVar.m() == 1);
                if (aoVar.c() != null) {
                    intent.putExtra("fname", aoVar.c().getName());
                    intent.putExtra("fid", aoVar.c().getId());
                }
                if (aoVar.d() != null) {
                    intent.putExtra("tid", aoVar.d().a());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, ArrayList<String> arrayList, int i, int i2, boolean z, com.baidu.tieba.data.ac acVar) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra(SocialConstants.PARAM_URL, arrayList);
            intent.putExtra("index", i);
            intent.putExtra("need_broadcast", true);
            intent.putExtra("count", i2);
            intent.putExtra("hasnext", z);
            intent.putExtra("pv_type", "photo");
            intent.putExtra("isCdn", true);
            if (acVar != null) {
                intent.putExtra("isCdn", acVar.m() == 1);
                intent.putExtra("nexttitle", acVar.g());
                intent.putExtra("fname", acVar.i());
                intent.putExtra("fid", acVar.j());
                intent.putExtra("tid", acVar.c());
            }
            ((Activity) context).startActivityForResult(intent, 14001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.h().a((com.baidu.tieba.j) this);
        setContentView(R.layout.image_activity_2);
        a(bundle);
        e();
        d();
        if (!this.B) {
            String a = a(this.c.get(this.c.size() - 1));
            if (a == null) {
                this.l.setVisibility(8);
            }
            this.u = new a(this.c, this.z, this.y, a);
            this.u.a(new d(this));
            this.u.a();
        }
    }

    public String a() {
        return this.x;
    }

    public String b() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.m.setBackgroundColor(com.baidu.tieba.util.bs.d(i));
        } else {
            this.m.setBackgroundColor(-16777216);
        }
        this.l.c(i);
    }

    public String c() {
        return this.z;
    }

    private void d() {
        if (this.B) {
            this.t = new i(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.imagepb.pageadded");
            registerReceiver(this.t, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.m.a();
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void releaseResouce() {
        this.m.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        TiebaApplication.h().b((com.baidu.tieba.j) this);
        a(this.d, this.d);
        h();
        this.m.c();
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        if (this.a != null) {
            this.a.setVisibility(8);
        }
        if (this.B) {
            unregisterReceiver(this.t);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
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

    private void e() {
        this.n = new e(this);
        this.p = new g(this);
        this.o = new h(this);
        this.l = (NavigationBar) findViewById(R.id.navigation_bar);
        this.D = (FrameLayout) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.image_activity_save_button, this.n);
        this.j = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = this.l.a("");
        this.a = (ProgressBar) findViewById(R.id.progress);
        this.i = (TextView) findViewById(R.id.save);
        this.i.setClickable(false);
        this.m = (MultiImageView) findViewById(R.id.viewpager);
        this.m.setIsFromCDN(this.C);
        this.m.setPageMargin(com.baidu.adp.lib.g.g.a((Context) this, 8.0f));
        this.m.a(2, com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i());
        this.m.setOnPageChangeListener(this.p);
        this.m.setUrlData(this.c);
        this.m.setItemOnclickListener(this.n);
        this.m.a(g(), false);
        this.m.setOnScrollOutListener(this.o);
        this.m.setHasNext(this.f);
        this.m.setNextTitle(this.g);
        a(this.d, this.d);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        if (this.c != null) {
            String str2 = String.valueOf(this.d + 1 + this.b) + "/";
            if (this.e > 0) {
                str = str2 + this.e;
            } else if (!this.B) {
                str = str2 + "...";
            } else {
                str = str2 + this.c.size();
            }
            if (this.m.getHasNext() && this.d == this.m.getItemNum() - 1) {
                this.k.setText(getString(R.string.image_recommend));
                this.i.setVisibility(4);
                return;
            }
            this.k.setText(str);
            this.i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
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
        this.B = getIntent().getBooleanExtra("need_broadcast", false);
        if (bundle != null) {
            this.c = bundle.getStringArrayList(SocialConstants.PARAM_URL);
            this.d = bundle.getInt("index", -1);
            this.e = bundle.getInt("count", -1);
            this.f = bundle.getBoolean("hasnext", false);
            this.g = bundle.getString("nexttitle");
            this.x = bundle.getString("fid");
            this.y = bundle.getString("tid");
            this.z = bundle.getString("fname");
            this.A = bundle.getString("pv_type");
            this.C = bundle.getBoolean("isCdn", false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.c = intent.getStringArrayListExtra(SocialConstants.PARAM_URL);
                this.d = intent.getIntExtra("index", -1);
                this.e = intent.getIntExtra("count", -1);
                this.f = intent.getBooleanExtra("hasnext", false);
                this.g = intent.getStringExtra("nexttitle");
                this.x = intent.getStringExtra("fid");
                this.y = intent.getStringExtra("tid");
                this.z = intent.getStringExtra("fname");
                this.A = intent.getStringExtra("pv_type");
                this.C = intent.getBooleanExtra("isCdn", false);
            }
        }
        this.w = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(SocialConstants.PARAM_URL, this.c);
        bundle.putInt("index", this.d);
        bundle.putInt("count", this.e);
        bundle.putBoolean("hasNext", this.f);
        bundle.putString("nexttitle", this.g);
        bundle.putString("fid", this.x);
        bundle.putString("tid", this.y);
        bundle.putString("fname", this.z);
        bundle.putString("pv_type", this.A);
        bundle.putBoolean("isCdn", false);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.m.a(this.d, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.w) {
            if (System.nanoTime() - this.v > 300000000 && this.c != null && i < this.c.size()) {
                this.w.put(this.c.get(i), true);
            }
            this.v = System.nanoTime();
            if (this.c != null && i2 < this.c.size() && this.w.get(this.c.get(i2)) == null) {
                this.w.put(this.c.get(i2), false);
            }
        }
        if (this.w.size() >= 100) {
            h();
        }
    }

    private void h() {
        if (this.w != null) {
            synchronized (this.w) {
                if (this.w.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.w.entrySet()) {
                        i = entry.getValue().booleanValue() ? i + 1 : i;
                    }
                    TiebaApplication.h().a(i, this.w.size(), this.A);
                    this.w.clear();
                }
            }
        }
    }

    private String a(String str) {
        int lastIndexOf;
        int indexOf;
        String e = com.baidu.tieba.util.bu.e(str);
        if (e != null) {
            if (e.indexOf(".baidu.com") != -1 && (lastIndexOf = e.lastIndexOf("/")) != -1 && (indexOf = e.indexOf(".", lastIndexOf)) != -1) {
                return e.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return e;
    }
}

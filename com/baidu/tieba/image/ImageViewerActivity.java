package com.baidu.tieba.image;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends com.baidu.tbadk.a implements com.baidu.tbadk.coreExtra.data.e {
    private FrameLayout D;
    private String E;
    private ProgressBar a = null;
    private int b = 0;
    private ArrayList<String> c = null;
    private int d = -1;
    private int e = -1;
    private boolean f = false;
    private String g = null;
    private k h = null;
    private TextView i = null;
    private View j = null;
    private TextView k = null;
    private NavigationBar l = null;
    private MultiImageView m = null;
    private View.OnClickListener n = null;
    private com.baidu.tbadk.core.view.a o = null;
    private ViewPager.OnPageChangeListener p = null;
    private AlphaAnimation q = null;
    private boolean r = true;
    private boolean s = false;
    private j t = null;
    private a u = null;
    private long v = 0;
    private HashMap<String, Boolean> w = null;
    private String x = null;
    private String y = null;
    private String z = null;
    private String A = null;
    private boolean B = false;
    private boolean C = false;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010000, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.j().a(this);
        setContentView(com.baidu.tieba.a.i.image_activity_2);
        this.B = getIntent().getBooleanExtra("need_broadcast", false);
        if (bundle != null) {
            this.c = bundle.getStringArrayList("url");
            this.d = bundle.getInt("index", -1);
            this.e = bundle.getInt("count", -1);
            this.f = bundle.getBoolean("hasnext", false);
            this.g = bundle.getString("nexttile");
            this.x = bundle.getString("fid");
            this.y = bundle.getString("tid");
            this.z = bundle.getString("fname");
            this.A = bundle.getString("pv_type");
            this.C = bundle.getBoolean("isCdn", false);
            this.E = bundle.getString("last_id");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.c = intent.getStringArrayListExtra("url");
                this.d = intent.getIntExtra("index", -1);
                this.e = intent.getIntExtra("count", -1);
                this.f = intent.getBooleanExtra("hasnext", false);
                this.g = intent.getStringExtra("nexttile");
                this.x = intent.getStringExtra("fid");
                this.y = intent.getStringExtra("tid");
                this.z = intent.getStringExtra("fname");
                this.A = intent.getStringExtra("pv_type");
                this.C = intent.getBooleanExtra("isCdn", false);
                this.E = intent.getStringExtra("last_id");
            }
        }
        this.e = this.c.size();
        this.w = new HashMap<>();
        this.n = new f(this);
        this.p = new h(this);
        this.o = new i(this);
        this.l = (NavigationBar) findViewById(com.baidu.tieba.a.h.navigation_bar);
        this.D = (FrameLayout) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.image_activity_save_button, this.n);
        this.j = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = this.l.a("");
        this.a = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.i = (TextView) findViewById(com.baidu.tieba.a.h.save);
        this.i.setClickable(false);
        this.m = (MultiImageView) findViewById(com.baidu.tieba.a.h.viewpager);
        this.m.setIsFromCDN(this.C);
        this.m.setPageMargin(com.baidu.adp.lib.util.i.a((Context) this, 8.0f));
        this.m.a(2, n.u() * n.u());
        this.m.setOnPageChangeListener(this.p);
        this.m.setUrlData(this.c);
        this.m.setItemOnclickListener(this.n);
        this.m.a(e(), false);
        this.m.setOnScrollOutListener(this.o);
        this.m.setHasNext(this.f);
        this.m.setNextTitle(this.g);
        a(this.d, this.d);
        d();
        if (this.B) {
            this.t = new j(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.data.d.a());
            registerReceiver(this.t, intentFilter);
        }
        if (!this.B) {
            String e = bc.e(this.E);
            if (e != null) {
                if (e.indexOf(".baidu.com") == -1) {
                    e = null;
                } else {
                    int lastIndexOf = e.lastIndexOf("/");
                    if (lastIndexOf == -1) {
                        e = null;
                    } else {
                        int indexOf = e.indexOf(".", lastIndexOf);
                        e = indexOf == -1 ? null : e.substring(lastIndexOf + 1, indexOf);
                    }
                }
            }
            if (e == null) {
                this.l.setVisibility(8);
            }
            this.u = new a(this.c, this.z, this.y, e);
            this.u.a(new e(this));
            this.u.a();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.data.e
    public final String a() {
        return this.x;
    }

    @Override // com.baidu.tbadk.coreExtra.data.e
    public final String b() {
        return this.y;
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.m.setBackgroundColor(ba.d(i));
        } else {
            this.m.setBackgroundColor(-16777216);
        }
        this.l.b(i);
    }

    @Override // com.baidu.tbadk.coreExtra.data.e
    public final String c() {
        return this.z;
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.b();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.m.a();
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a
    public void releaseResouce() {
        this.m.c();
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TbadkApplication.j().b(this);
        a(this.d, this.d);
        f();
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

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
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

    public void d() {
        String str;
        if (this.c != null) {
            String str2 = String.valueOf(String.valueOf(this.d + 1 + this.b)) + "/";
            if (this.e > 0) {
                str = String.valueOf(str2) + this.e;
            } else if (!this.B) {
                str = String.valueOf(str2) + "...";
            } else {
                str = String.valueOf(str2) + this.c.size();
            }
            if (this.m.getHasNext() && this.d == this.m.getItemNum() - 1) {
                this.k.setText(getString(com.baidu.tieba.a.k.image_recommend));
                this.i.setVisibility(4);
                return;
            }
            this.k.setText(str);
            this.i.setVisibility(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x001c, code lost:
        if (r2.d < 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e() {
        if (this.c != null && this.c.size() > 0) {
            int size = this.c.size();
            if (this.d >= size) {
                this.d = size - 1;
            }
        }
        this.d = 0;
        return this.d;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("url", this.c);
        bundle.putInt("index", this.d);
        bundle.putInt("count", this.e);
        bundle.putBoolean("hasnext", this.f);
        bundle.putString("nexttile", this.g);
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
            f();
        }
    }

    private void f() {
        if (this.w == null) {
            return;
        }
        synchronized (this.w) {
            if (this.w.size() > 0) {
                int i = 0;
                for (Map.Entry<String, Boolean> entry : this.w.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        i++;
                    }
                }
                TbadkApplication.j().a(i, this.w.size(), this.A);
                this.w.clear();
            }
        }
    }
}

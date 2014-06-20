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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageViewerActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.data.e {
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
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfig.IMAGE_VIEWER_CUSTOM_CMD, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m252getInst().addRemoteActivity(this);
        setContentView(w.image_activity_2);
        a(bundle);
        e();
        d();
        if (!this.B) {
            String a = a(this.E);
            if (a == null) {
                this.l.setVisibility(8);
            }
            this.u = new a(this.c, this.z, this.y, a);
            this.u.a(new e(this));
            this.u.a();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.data.e
    public String a() {
        return this.x;
    }

    @Override // com.baidu.tbadk.coreExtra.data.e
    public String b() {
        return this.y;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (i == 1) {
            this.m.setBackgroundColor(be.d(i));
        } else {
            this.m.setBackgroundColor(-16777216);
        }
        this.l.c(i);
    }

    @Override // com.baidu.tbadk.coreExtra.data.e
    public String c() {
        return this.z;
    }

    private void d() {
        if (this.B) {
            this.t = new j(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.data.d.a());
            registerReceiver(this.t, intentFilter);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.b();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.m.a();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        this.m.c();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TbadkApplication.m252getInst().delRemoteActivity(this);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
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
        this.n = new f(this);
        this.p = new h(this);
        this.o = new i(this);
        this.l = (NavigationBar) findViewById(v.navigation_bar);
        this.D = (FrameLayout) this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.image_activity_save_button, this.n);
        this.j = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = this.l.a("");
        this.a = (ProgressBar) findViewById(v.progress);
        this.i = (TextView) findViewById(v.save);
        this.i.setClickable(false);
        this.m = (MultiImageView) findViewById(v.viewpager);
        this.m.setIsFromCDN(this.C);
        this.m.setPageMargin(com.baidu.adp.lib.util.k.a((Context) this, 8.0f));
        this.m.a(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
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

    public void f() {
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
                this.k.setText(getString(y.image_recommend));
                this.i.setVisibility(4);
                return;
            }
            this.k.setText(str);
            this.i.setVisibility(0);
        }
    }

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
        if (this.E == null) {
            this.E = this.e > 0 ? this.c.get(this.e - 1) : "";
        }
        this.w = new HashMap<>();
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
            h();
        }
    }

    private void h() {
        if (this.w != null) {
            synchronized (this.w) {
                if (this.w.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.w.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkApplication.m252getInst().sendImagePv(i, this.w.size(), this.A);
                    this.w.clear();
                }
            }
        }
    }

    private String a(String str) {
        int lastIndexOf;
        int indexOf;
        String e = bg.e(str);
        if (e != null) {
            if (e.indexOf(".baidu.com") != -1 && (lastIndexOf = e.lastIndexOf("/")) != -1 && (indexOf = e.indexOf(".", lastIndexOf)) != -1) {
                return e.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return e;
    }
}

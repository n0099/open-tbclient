package com.baidu.tieba.write;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity {
    private static String[] a = null;
    private int A;
    private String B;
    private HashMap<String, Bitmap> D;
    private HashMap<String, ImageView> E;
    private RadioButton j;
    private RadioButton k;
    private View o;
    private LinearLayout x;
    private ImageView b = null;
    private Bitmap c = null;
    private TextView d = null;
    private View e = null;
    private HorizontalScrollView f = null;
    private ProgressBar g = null;
    private bt h = null;
    private bq i = null;
    private LinearLayout l = null;
    private LinearLayout m = null;
    private TextView n = null;
    private NavigationBar p = null;
    private Bitmap q = null;
    private bu r = null;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private boolean v = true;
    private String w = null;
    private boolean y = false;
    private boolean z = false;
    private final Handler C = new Handler();
    private final Object F = new Object();
    private final View.OnClickListener G = new bi(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.bj.class, WriteImageActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.a.f.a().b("motu_sdk") == 1 || com.baidu.tbadk.tbplugin.m.a().d("motusdk") == null) {
            this.v = false;
        } else {
            this.v = true;
        }
        TbadkApplication.m252getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.write_image_activity);
        Intent intent = getIntent();
        this.A = intent.getIntExtra("request", 0);
        this.u = intent.getIntExtra("display_size", 0);
        this.B = intent.getStringExtra("finish_text");
        BdLog.d("WriteImageActivity", "onCreate", this.B);
        if (this.v) {
            TbadkApplication.m252getInst().sendImagePv(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.z = true;
        }
        if (this.A == 12002 || this.A == 12001) {
            d();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.A, intent.getData(), com.baidu.tbadk.core.util.bf.a().e(), this.u);
            } else {
                TiebaPrepareImageService.StartService(this.A, null, com.baidu.tbadk.core.util.bf.a().e(), this.u);
            }
            e();
        } else {
            d();
            c();
        }
        a = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.h != null) {
            this.h.cancel();
        }
        this.b.setImageBitmap(null);
        b();
    }

    private void b() {
        synchronized (this.F) {
            if (this.E != null) {
                for (Map.Entry<String, ImageView> entry : this.E.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageBitmap(null);
                    }
                }
                this.E.clear();
                this.E = null;
            }
            if (this.D != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.D.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.D.clear();
                this.D = null;
            }
        }
    }

    public void c() {
        if (this.h != null) {
            this.h.cancel();
        }
        this.h = new bt(this, null);
        this.h.execute(new Object[0]);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        releaseResouce();
        super.onDestroy();
        if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        if (this.q != null && !this.q.isRecycled()) {
            this.q.recycle();
            this.q = null;
        }
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        this.g.setVisibility(8);
        if (this.A == 12002 || this.A == 12001) {
            unregisterReceiver(this.r);
        }
        TbadkApplication.m252getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.G.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.e);
        this.p.c(i);
        if (i == 1) {
            if (this.d.isEnabled()) {
                com.baidu.tbadk.core.util.bc.e((View) this.d, com.baidu.tieba.u.navi_done_text_bg_1);
                this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.s.navi_done_text_1));
                return;
            }
            com.baidu.tbadk.core.util.bc.e((View) this.d, com.baidu.tieba.u.btn_titlebar_finish_d_1);
            this.d.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text_d_1));
        } else if (this.d.isEnabled()) {
            com.baidu.tbadk.core.util.bc.e((View) this.d, com.baidu.tieba.u.navi_done_text_bg);
            this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.s.navi_done_text));
        } else {
            com.baidu.tbadk.core.util.bc.e((View) this.d, com.baidu.tieba.u.btn_titlebar_finish_d);
            this.d.setTextColor(getResources().getColor(com.baidu.tieba.s.navi_done_text_d));
        }
    }

    private void d() {
        this.e = findViewById(com.baidu.tieba.v.write_image_root_layout);
        this.g = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.g.setVisibility(8);
        this.b = (ImageView) findViewById(com.baidu.tieba.v.image);
        this.b.setOnClickListener(new bj(this));
        this.b.setImageBitmap(this.c);
        this.f = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.p = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.p.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bk(this));
        this.d = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.B, new bl(this));
        if (TextUtils.isEmpty(this.B)) {
            if (this.z || this.A != 12003) {
                this.d.setText(getString(com.baidu.tieba.y.done));
                com.baidu.tbadk.core.util.bc.g(this.d, TbadkApplication.m252getInst().getSkinType());
            } else {
                this.d.setText(getString(com.baidu.tieba.y.delete));
                com.baidu.tbadk.core.util.bc.k(this.d, TbadkApplication.m252getInst().getSkinType());
            }
        } else {
            this.d.setText(this.B);
        }
        this.x = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.s = com.baidu.adp.lib.util.k.a((Context) this, 2.0f);
        this.n = this.p.a(getString(com.baidu.tieba.y.beautify));
        this.m = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.l = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.j = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.k = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        bm bmVar = new bm(this);
        this.j.setOnCheckedChangeListener(bmVar);
        this.k.setOnCheckedChangeListener(bmVar);
        this.j.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.v.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.v.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.v.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.v.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bn bnVar = new bn(this);
        button.setOnClickListener(bnVar);
        button2.setOnClickListener(bnVar);
        button3.setOnClickListener(bnVar);
        button4.setOnClickListener(bnVar);
        this.m.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.v) {
            this.k.setPadding(0, this.k.getPaddingTop(), this.k.getPaddingRight(), this.k.getPaddingBottom());
            this.k.setChecked(true);
            this.f.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public void a(String str) {
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = new bq(this, null);
        this.i.execute(str);
    }

    public boolean b(String str) {
        try {
            com.baidu.tbadk.core.util.x.a(TbConfig.LOCAL_PIC_DIR, str, this.q, 90);
            this.b.setImageBitmap(null);
            int i = 100;
            if (this.u > 0) {
                i = this.u;
            }
            Bitmap a2 = com.baidu.tbadk.core.util.g.a(this.q, i);
            if (a2 != null && com.baidu.tbadk.core.util.x.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, a2, 80) != null) {
                new com.baidu.tbadk.core.util.az("motu_pic", String.valueOf(this.t)).start();
                return true;
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    public void a(String[] strArr) {
        if (this.D != null && strArr != null) {
            this.x.removeAllViews();
            this.m.setVisibility(0);
            View inflate = getLayoutInflater().inflate(com.baidu.tieba.w.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.v.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = getLayoutInflater().inflate(com.baidu.tieba.w.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.v.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.v.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.k.a(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new bo(this, substring, i2));
                    this.o = imageView2;
                } else {
                    imageView2.setOnClickListener(new bp(this, substring, i2));
                }
                this.x.addView(inflate2);
                synchronized (this.F) {
                    this.E.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            c("normal");
        }
    }

    public void c(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.w != null && (imageView = this.E.get(this.w)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.s, this.s, this.s, this.s);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            if (this.E != null) {
                ImageView imageView2 = this.E.get(str);
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(com.baidu.tieba.u.bg_choose_filter);
                    imageView2.setPadding(this.s, this.s, this.s, this.s);
                    Object tag2 = imageView2.getTag();
                    if (tag2 instanceof TextView) {
                        ((TextView) tag2).setSelected(true);
                    }
                }
                this.w = str;
            }
        }
    }

    private void e() {
        this.r = new bu(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.r, intentFilter);
    }
}

package com.baidu.tieba.write;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends com.baidu.tbadk.a {
    private static String[] a = null;
    private String A;
    private HashMap<String, Bitmap> B;
    private HashMap<String, ImageView> C;
    private RadioButton j;
    private RadioButton k;
    private LinearLayout w;
    private int z;
    private ImageView b = null;
    private Bitmap c = null;
    private TextView d = null;
    private View e = null;
    private HorizontalScrollView f = null;
    private ProgressBar g = null;
    private bn h = null;
    private bm i = null;
    private LinearLayout l = null;
    private LinearLayout m = null;
    private TextView n = null;
    private NavigationBar o = null;
    private Bitmap p = null;
    private bo q = null;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private boolean u = true;
    private String v = null;
    private boolean x = false;
    private boolean y = false;
    private final Object D = new Object();
    private final View.OnClickListener E = new be(this);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.aw.class, WriteImageActivity.class);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.a.f.a().b("motu_sdk") == 1) {
            this.u = false;
        } else {
            this.u = true;
        }
        TbadkApplication.j().a(this);
        setContentView(com.baidu.tieba.a.i.write_image_activity);
        Intent intent = getIntent();
        this.z = intent.getIntExtra("request", 0);
        this.t = intent.getIntExtra("display_size", 0);
        this.A = intent.getStringExtra("finish_text");
        com.baidu.adp.lib.util.f.e("WriteImageActivity", "onCreate", this.A);
        if (this.u) {
            TbadkApplication.j().a(1, 1, "motu_pic");
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.y = true;
        }
        if (this.z == 12002 || this.z == 12001) {
            c();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.z, intent.getData(), com.baidu.tbadk.core.util.bd.a().e(), this.t);
            } else {
                TiebaPrepareImageService.a(this.z, null, com.baidu.tbadk.core.util.bd.a().e(), this.t);
            }
            this.q = new bo(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tbadk.core.data.n.t());
            registerReceiver(this.q, intentFilter);
        } else {
            c();
            b();
        }
        a = getResources().getStringArray(com.baidu.tieba.a.c.fiter_name);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.b.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.h == null) {
            this.h = new bn(this, (byte) 0);
            this.h.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a
    public void releaseResouce() {
        if (this.h != null) {
            this.h.cancel();
        }
        this.b.setImageBitmap(null);
        synchronized (this.D) {
            if (this.C != null) {
                for (Map.Entry<String, ImageView> entry : this.C.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageBitmap(null);
                    }
                }
                this.C.clear();
                this.C = null;
            }
            if (this.B != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.B.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.B.clear();
                this.B = null;
            }
        }
    }

    public void b() {
        if (this.h != null) {
            this.h.cancel();
        }
        this.h = new bn(this, (byte) 0);
        this.h.execute(new Object[0]);
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        releaseResouce();
        super.onDestroy();
        if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        if (this.p != null && !this.p.isRecycled()) {
            this.p.recycle();
            this.p = null;
        }
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        this.g.setVisibility(8);
        if (this.z == 12002 || this.z == 12001) {
            unregisterReceiver(this.q);
        }
        TbadkApplication.j().b(this);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.E.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.e);
        this.o.b(i);
        if (i == 1) {
            if (this.d.isEnabled()) {
                com.baidu.tbadk.core.util.ba.e((View) this.d, com.baidu.tieba.a.g.navi_done_text_bg_1);
                this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.navi_done_text_1));
                return;
            }
            com.baidu.tbadk.core.util.ba.e((View) this.d, com.baidu.tieba.a.g.btn_titlebar_finish_d_1);
            this.d.setTextColor(getResources().getColor(com.baidu.tieba.a.e.navi_done_text_d_1));
        } else if (this.d.isEnabled()) {
            com.baidu.tbadk.core.util.ba.e((View) this.d, com.baidu.tieba.a.g.navi_done_text_bg);
            this.d.setTextColor(getResources().getColorStateList(com.baidu.tieba.a.e.navi_done_text));
        } else {
            com.baidu.tbadk.core.util.ba.e((View) this.d, com.baidu.tieba.a.g.btn_titlebar_finish_d);
            this.d.setTextColor(getResources().getColor(com.baidu.tieba.a.e.navi_done_text_d));
        }
    }

    private void c() {
        this.e = findViewById(com.baidu.tieba.a.h.write_image_root_layout);
        this.g = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.g.setVisibility(8);
        this.b = (ImageView) findViewById(com.baidu.tieba.a.h.image);
        this.b.setOnClickListener(new bf(this));
        this.b.setImageBitmap(this.c);
        this.f = (HorizontalScrollView) findViewById(com.baidu.tieba.a.h.filters_layout);
        this.o = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bg(this));
        this.d = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.A, new bh(this));
        if (TextUtils.isEmpty(this.A)) {
            if (this.y || this.z != 12003) {
                this.d.setText(getString(com.baidu.tieba.a.k.done));
                com.baidu.tbadk.core.util.ba.g(this.d, TbadkApplication.j().l());
            } else {
                this.d.setText(getString(com.baidu.tieba.a.k.delete));
                com.baidu.tbadk.core.util.ba.i(this.d, TbadkApplication.j().l());
            }
        } else {
            this.d.setText(this.A);
        }
        this.w = (LinearLayout) findViewById(com.baidu.tieba.a.h.filters);
        this.r = com.baidu.adp.lib.util.i.a((Context) this, 2.0f);
        this.n = this.o.a(getString(com.baidu.tieba.a.k.beautify));
        this.m = (LinearLayout) findViewById(com.baidu.tieba.a.h.beautify_rotate);
        this.l = (LinearLayout) findViewById(com.baidu.tieba.a.h.rotate);
        this.j = (RadioButton) findViewById(com.baidu.tieba.a.h.beautify_btn);
        this.k = (RadioButton) findViewById(com.baidu.tieba.a.h.rotate_btn);
        bi biVar = new bi(this);
        this.j.setOnCheckedChangeListener(biVar);
        this.k.setOnCheckedChangeListener(biVar);
        this.j.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.a.h.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.a.h.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.a.h.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.a.h.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bj bjVar = new bj(this);
        button.setOnClickListener(bjVar);
        button2.setOnClickListener(bjVar);
        button3.setOnClickListener(bjVar);
        button4.setOnClickListener(bjVar);
        this.m.setVisibility(0);
        if (Build.VERSION.SDK_INT < 7 || !this.u) {
            this.k.setPadding(0, this.k.getPaddingTop(), this.k.getPaddingRight(), this.k.getPaddingBottom());
            this.k.setChecked(true);
            this.f.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public static /* synthetic */ void b(WriteImageActivity writeImageActivity, String str) {
        if (writeImageActivity.i != null) {
            writeImageActivity.i.cancel();
        }
        writeImageActivity.i = new bm(writeImageActivity, (byte) 0);
        writeImageActivity.i.execute(str);
    }

    public boolean a(String str) {
        try {
            com.baidu.tbadk.core.util.w.a("photos", str, this.p, 90);
            this.b.setImageBitmap(null);
            int i = 100;
            if (this.t > 0) {
                i = this.t;
            }
            Bitmap a2 = com.baidu.tbadk.core.util.g.a(this.p, i);
            if (a2 != null && com.baidu.tbadk.core.util.w.a((String) null, "tieba_resized_image_display", a2, 80) != null) {
                new com.baidu.tbadk.core.util.ax("motu_pic", String.valueOf(this.s)).start();
                return true;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    public static /* synthetic */ void a(WriteImageActivity writeImageActivity, String[] strArr) {
        if (writeImageActivity.B == null || strArr == null) {
            return;
        }
        writeImageActivity.w.removeAllViews();
        writeImageActivity.m.setVisibility(0);
        View inflate = writeImageActivity.getLayoutInflater().inflate(com.baidu.tieba.a.i.filter_item, (ViewGroup) null);
        inflate.findViewById(com.baidu.tieba.a.h.filter_immage);
        inflate.findViewById(com.baidu.tieba.a.h.filter_text);
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate2 = writeImageActivity.getLayoutInflater().inflate(com.baidu.tieba.a.i.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.tieba.a.h.filter_immage);
            TextView textView = (TextView) inflate2.findViewById(com.baidu.tieba.a.h.filter_text);
            textView.setText(substring2);
            imageView.setImageResource(com.baidu.tbadk.coreExtra.view.j.a(substring));
            imageView.setTag(textView);
            int i3 = i2 + 1;
            if (substring.equals("normal")) {
                imageView.setOnClickListener(new bk(writeImageActivity, substring, i2));
            } else {
                imageView.setOnClickListener(new bl(writeImageActivity, substring, i2));
            }
            writeImageActivity.w.addView(inflate2);
            synchronized (writeImageActivity.D) {
                writeImageActivity.C.put(substring, imageView);
            }
            i++;
            i2 = i3;
        }
        writeImageActivity.b("normal");
    }

    public void b(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.v != null && (imageView = this.C.get(this.v)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.r, this.r, this.r, this.r);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.C.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.a.g.bg_choose_filter);
                imageView2.setPadding(this.r, this.r, this.r, this.r);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.v = str;
        }
    }
}

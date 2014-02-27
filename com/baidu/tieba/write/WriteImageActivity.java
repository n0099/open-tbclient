package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends com.baidu.tieba.f {
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
    private bt h = null;
    private bs i = null;
    private LinearLayout l = null;
    private LinearLayout m = null;
    private TextView n = null;
    private NavigationBar o = null;
    private Bitmap p = null;
    private bu q = null;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private boolean u = true;
    private String v = null;
    private boolean x = false;
    private boolean y = false;
    private final Object D = new Object();
    private final View.OnClickListener E = new bk(this);

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        a(activity, i, i2, uri, str, str2, antiData, 0, null, null);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4) {
        if (antiData != null && antiData.getIfpost() == 0) {
            BdUtilHelper.a((Context) activity, antiData.getForbid_info());
            return;
        }
        Intent intent = new Intent(activity, WriteImageActivity.class);
        intent.putExtra("request", i);
        if ((activity instanceof FrsActivity) || (activity instanceof ImagePbActivity) || (activity instanceof FrsImageActivity)) {
            intent.putExtra("from", "frs");
        }
        intent.putExtra("forumid", str);
        intent.putExtra("foruimname", str2);
        intent.putExtra("display_size", i3);
        if (str3 != null) {
            intent.putExtra("finish_text", str3);
        }
        if (str4 != null) {
            intent.putExtra("cancel_text", str4);
        }
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.u = false;
        } else {
            this.u = true;
        }
        TiebaApplication.g().a(this);
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.z = intent.getIntExtra("request", 0);
        this.t = intent.getIntExtra("display_size", 0);
        this.A = intent.getStringExtra("finish_text");
        com.baidu.adp.lib.util.e.e("WriteImageActivity", "onCreate", this.A);
        if (this.u) {
            WriteMultiImgsActivity.a(1, 1);
        }
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.y = true;
        }
        if (this.z == 12002 || this.z == 12001) {
            c();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.z, intent.getData(), com.baidu.tieba.util.bv.a().e(), this.t);
            } else {
                TiebaPrepareImageService.a(this.z, null, com.baidu.tieba.util.bv.a().e(), this.t);
            }
            this.q = new bu(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.data.i.b());
            registerReceiver(this.q, intentFilter);
        } else {
            c();
            b();
        }
        a = getResources().getStringArray(R.array.fiter_name);
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.b.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.h == null) {
            this.h = new bt(this, (byte) 0);
            this.h.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a
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
        this.h = new bt(this, (byte) 0);
        this.h.execute(new Object[0]);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
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
        TiebaApplication.g().b(this);
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.E.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.e);
        this.o.b(i);
        if (i == 1) {
            if (this.d.isEnabled()) {
                com.baidu.tieba.util.bq.e((View) this.d, (int) R.drawable.navi_done_text_bg_1);
                this.d.setTextColor(getResources().getColorStateList(R.color.navi_done_text_1));
                return;
            }
            com.baidu.tieba.util.bq.e((View) this.d, (int) R.drawable.btn_titlebar_finish_d_1);
            this.d.setTextColor(getResources().getColor(R.color.navi_done_text_d_1));
        } else if (this.d.isEnabled()) {
            com.baidu.tieba.util.bq.e((View) this.d, (int) R.drawable.navi_done_text_bg);
            this.d.setTextColor(getResources().getColorStateList(R.color.navi_done_text));
        } else {
            com.baidu.tieba.util.bq.e((View) this.d, (int) R.drawable.btn_titlebar_finish_d);
            this.d.setTextColor(getResources().getColor(R.color.navi_done_text_d));
        }
    }

    private void c() {
        this.e = findViewById(R.id.write_image_root_layout);
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.g.setVisibility(8);
        this.b = (ImageView) findViewById(R.id.image);
        this.b.setOnClickListener(new bl(this));
        this.b.setImageBitmap(this.c);
        this.f = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.o = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new bm(this));
        this.d = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.A, new bn(this));
        if (TextUtils.isEmpty(this.A)) {
            if (this.y || this.z != 12003) {
                this.d.setText(getString(R.string.done));
                com.baidu.tieba.util.bq.h(this.d, TiebaApplication.g().ae());
            } else {
                this.d.setText(getString(R.string.delete));
                com.baidu.tieba.util.bq.j(this.d, TiebaApplication.g().ae());
            }
        } else {
            this.d.setText(this.A);
        }
        this.w = (LinearLayout) findViewById(R.id.filters);
        this.r = BdUtilHelper.a((Context) this, 2.0f);
        this.n = this.o.a(getString(R.string.beautify));
        this.m = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.l = (LinearLayout) findViewById(R.id.rotate);
        this.j = (RadioButton) findViewById(R.id.beautify_btn);
        this.k = (RadioButton) findViewById(R.id.rotate_btn);
        bo boVar = new bo(this);
        this.j.setOnCheckedChangeListener(boVar);
        this.k.setOnCheckedChangeListener(boVar);
        this.j.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        bp bpVar = new bp(this);
        button.setOnClickListener(bpVar);
        button2.setOnClickListener(bpVar);
        button3.setOnClickListener(bpVar);
        button4.setOnClickListener(bpVar);
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
        writeImageActivity.i = new bs(writeImageActivity, (byte) 0);
        writeImageActivity.i.execute(str);
    }

    public boolean a(String str) {
        try {
            com.baidu.tieba.util.af.a("photos", str, this.p, 90);
            this.b.setImageBitmap(null);
            int i = 100;
            if (this.t > 0) {
                i = this.t;
            }
            Bitmap a2 = com.baidu.tieba.util.n.a(this.p, i);
            if (a2 != null && com.baidu.tieba.util.af.a((String) null, "tieba_resized_image_display", a2, 80) != null) {
                new com.baidu.tieba.account.ax("motu_pic", String.valueOf(this.s)).start();
                return true;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    public static /* synthetic */ void a(WriteImageActivity writeImageActivity, String[] strArr) {
        if (writeImageActivity.B == null || strArr == null) {
            return;
        }
        writeImageActivity.w.removeAllViews();
        writeImageActivity.m.setVisibility(0);
        View inflate = writeImageActivity.getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
        inflate.findViewById(R.id.filter_immage);
        inflate.findViewById(R.id.filter_text);
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate2 = writeImageActivity.getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.filter_immage);
            TextView textView = (TextView) inflate2.findViewById(R.id.filter_text);
            textView.setText(substring2);
            imageView.setImageResource(v.a(substring));
            imageView.setTag(textView);
            int i3 = i2 + 1;
            if (substring.equals("normal")) {
                imageView.setOnClickListener(new bq(writeImageActivity, substring, i2));
            } else {
                imageView.setOnClickListener(new br(writeImageActivity, substring, i2));
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
                imageView2.setBackgroundResource(R.drawable.bg_choose_filter);
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

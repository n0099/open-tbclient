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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.bx;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends com.baidu.tieba.j {
    private static String[] a = null;
    private HashMap<String, Bitmap> A;
    private HashMap<String, ImageView> B;
    private RadioButton i;
    private RadioButton j;
    private LinearLayout v;
    private int y;
    private String z;
    private ImageView b = null;
    private Bitmap c = null;
    private TextView d = null;
    private HorizontalScrollView e = null;
    private ProgressBar f = null;
    private aw g = null;
    private av h = null;
    private LinearLayout k = null;
    private LinearLayout l = null;
    private TextView m = null;
    private NavigationBar n = null;
    private Bitmap o = null;
    private ax p = null;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private boolean t = true;
    private String u = null;
    private boolean w = false;
    private boolean x = false;
    private final Object C = new Object();
    private final View.OnClickListener D = new au(this);

    public static void a(Activity activity, Bitmap bitmap, int i) {
        Intent intent = new Intent(activity, WriteImageActivity.class);
        if (bitmap != null) {
            intent.putExtra("request", i);
            activity.startActivityForResult(intent, 12003);
        }
    }

    public static void a(Activity activity, int i) {
        Intent intent = new Intent(activity, WriteImageActivity.class);
        intent.putExtra("request", i);
        activity.startActivityForResult(intent, 12003);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        a(activity, i, i2, uri, str, str2, antiData, 0, null, null);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4) {
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.g.g.a((Context) activity, antiData.getForbid_info());
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

    public static void a(Activity activity, int i, int i2, Uri uri) {
        Intent intent = new Intent(activity, WriteImageActivity.class);
        intent.putExtra("request", i);
        if ((activity instanceof FrsActivity) || (activity instanceof ImagePbActivity) || (activity instanceof FrsImageActivity)) {
            intent.putExtra("from", "frs");
        }
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.h().a((com.baidu.tieba.j) this);
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.y = intent.getIntExtra("request", 0);
        this.s = intent.getIntExtra("display_size", 0);
        this.z = intent.getStringExtra("finish_text");
        com.baidu.adp.lib.g.e.e("WriteImageActivity", "onCreate", this.z);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.x = true;
        }
        if (this.y == 12002 || this.y == 12001) {
            d();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.y, intent.getData(), bx.a().e(), this.s);
            } else {
                TiebaPrepareImageService.a(this.y, null, bx.a().e(), this.s);
            }
            e();
        } else {
            d();
            c();
        }
        a = getResources().getStringArray(R.array.fiter_name);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.t = false;
        } else {
            this.t = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.b.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.g == null) {
            this.g = new aw(this, null);
            this.g.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void releaseResouce() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.b.setImageBitmap(null);
        b();
    }

    private void b() {
        synchronized (this.C) {
            if (this.B != null) {
                for (Map.Entry<String, ImageView> entry : this.B.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageBitmap(null);
                    }
                }
                this.B.clear();
                this.B = null;
            }
            if (this.A != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.A.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.A.clear();
                this.A = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.g = new aw(this, null);
        this.g.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        releaseResouce();
        super.onDestroy();
        if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        if (this.o != null && !this.o.isRecycled()) {
            this.o.recycle();
            this.o = null;
        }
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        this.f.setVisibility(8);
        if (this.y == 12002 || this.y == 12001) {
            unregisterReceiver(this.p);
        }
        TiebaApplication.h().b((com.baidu.tieba.j) this);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.D.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.n.c(i);
    }

    private void d() {
        this.f = (ProgressBar) findViewById(R.id.progress);
        this.f.setVisibility(8);
        this.b = (ImageView) findViewById(R.id.image);
        this.b.setOnClickListener(new an(this));
        this.b.setImageBitmap(this.c);
        this.e = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.n = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ao(this));
        this.d = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.z, new ap(this));
        if (TextUtils.isEmpty(this.z)) {
            if (this.x || this.y != 12003) {
                this.d.setText(getString(R.string.done));
                bs.h(this.d, TiebaApplication.h().al());
            } else {
                this.d.setText(getString(R.string.delete));
                bs.l(this.d, TiebaApplication.h().al());
            }
        } else {
            this.d.setText(this.z);
        }
        this.v = (LinearLayout) findViewById(R.id.filters);
        this.q = com.baidu.adp.lib.g.g.a((Context) this, 2.0f);
        this.m = this.n.a(getString(R.string.beautify));
        this.l = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.k = (LinearLayout) findViewById(R.id.rotate);
        this.i = (RadioButton) findViewById(R.id.beautify_btn);
        this.j = (RadioButton) findViewById(R.id.rotate_btn);
        aq aqVar = new aq(this);
        this.i.setOnCheckedChangeListener(aqVar);
        this.j.setOnCheckedChangeListener(aqVar);
        this.i.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        ar arVar = new ar(this);
        button.setOnClickListener(arVar);
        button2.setOnClickListener(arVar);
        button3.setOnClickListener(arVar);
        button4.setOnClickListener(arVar);
        if (Build.VERSION.SDK_INT < 7 || !this.t) {
            this.l.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.h != null) {
            this.h.cancel();
        }
        this.h = new av(this, null);
        this.h.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        try {
            com.baidu.tieba.util.ad.a("photos", str, this.o, 90);
            this.b.setImageBitmap(null);
            int i = 100;
            if (this.s > 0) {
                i = this.s;
            }
            Bitmap a2 = com.baidu.tieba.util.n.a(this.o, i);
            if (a2 != null && com.baidu.tieba.util.ad.a((String) null, "tieba_resized_image_display", a2, 80) != null) {
                new com.baidu.tieba.account.av("motu_pic", String.valueOf(this.r)).start();
                return true;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        if (this.A != null && strArr != null) {
            this.v.removeAllViews();
            this.l.setVisibility(0);
            View inflate = getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.filter_immage);
            TextView textView = (TextView) inflate.findViewById(R.id.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(R.id.filter_immage);
                ((TextView) inflate2.findViewById(R.id.filter_text)).setText(substring2);
                imageView2.setImageBitmap(this.A.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new as(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new at(this, substring, i2));
                }
                this.v.addView(inflate2);
                synchronized (this.C) {
                    this.B.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            c("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.u != null && (imageView = this.B.get(this.u)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.q, this.q, this.q, this.q);
            }
            ImageView imageView2 = this.B.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.q, this.q, this.q, this.q);
            }
            this.u = str;
        }
    }

    private void e() {
        this.p = new ax(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.p, intentFilter);
    }
}

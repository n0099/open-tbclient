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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f2654a = null;
    private String A;
    private String B;
    private HashMap<String, Bitmap> C;
    private HashMap<String, ImageView> D;
    private RadioButton j;
    private RadioButton k;
    private LinearLayout w;
    private int z;
    private ImageView b = null;
    private Bitmap c = null;
    private ImageView d = null;
    private TextView e = null;
    private HorizontalScrollView f = null;
    private ProgressBar g = null;
    private ay h = null;
    private ax i = null;
    private LinearLayout l = null;
    private LinearLayout m = null;
    private TextView n = null;
    private NavigationBar o = null;
    private Bitmap p = null;
    private az q = null;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private boolean u = true;
    private String v = null;
    private boolean x = false;
    private boolean y = false;
    private final Object E = new Object();
    private final View.OnClickListener F = new aw(this);

    public static void a(Activity activity, Bitmap bitmap, int i) {
        Intent intent = new Intent(activity, WriteImageActivity.class);
        if (bitmap != null) {
            intent.putExtra("request", i);
            activity.startActivityForResult(intent, 12003);
        }
    }

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        a(activity, i, i2, uri, str, str2, antiData, 0, null, null);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, AntiData antiData, int i3, String str3, String str4) {
        if (antiData != null && antiData.getIfpost() == 0) {
            UtilHelper.a((Context) activity, antiData.getForbid_info());
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
        TiebaApplication.g().a((com.baidu.tieba.j) this);
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.z = intent.getIntExtra("request", 0);
        this.t = intent.getIntExtra("display_size", 0);
        this.A = intent.getStringExtra("finish_text");
        this.B = intent.getStringExtra("cancel_text");
        bg.e("WriteImageActivity", "onCreate", this.A);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.y = true;
        }
        if (this.z == 12002 || this.z == 12001) {
            d();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.z, intent.getData(), bf.a().e(), this.t);
            } else {
                TiebaPrepareImageService.a(this.z, null, bf.a().e(), this.t);
            }
            e();
        } else {
            d();
            c();
        }
        f2654a = getResources().getStringArray(R.array.fiter_name);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.u = false;
        } else {
            this.u = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.b.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.h == null) {
            this.h = new ay(this, null);
            this.h.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void releaseResouce() {
        if (this.h != null) {
            this.h.cancel();
        }
        this.b.setImageBitmap(null);
        b();
    }

    private void b() {
        synchronized (this.E) {
            if (this.D != null) {
                for (Map.Entry<String, ImageView> entry : this.D.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageBitmap(null);
                    }
                }
                this.D.clear();
                this.D = null;
            }
            if (this.C != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.C.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.C.clear();
                this.C = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.h != null) {
            this.h.cancel();
        }
        this.h = new ay(this, null);
        this.h.execute(new Object[0]);
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
        TiebaApplication.g().b((com.baidu.tieba.j) this);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.F.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.o.c(i);
    }

    private void d() {
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.g.setVisibility(8);
        this.b = (ImageView) findViewById(R.id.image);
        this.b.setOnClickListener(new ap(this));
        this.b.setImageBitmap(this.c);
        this.f = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.o = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.d = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aq(this));
        this.e = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.A, new ar(this));
        if (TextUtils.isEmpty(this.A)) {
            if (this.y || this.z != 12003) {
                this.e.setText(getString(R.string.done));
                com.baidu.tieba.util.bd.g(this.e, TiebaApplication.g().ap());
            } else {
                this.e.setText(getString(R.string.delete));
                com.baidu.tieba.util.bd.k(this.e, TiebaApplication.g().ap());
            }
        } else {
            this.e.setText(this.A);
        }
        this.w = (LinearLayout) findViewById(R.id.filters);
        this.r = UtilHelper.a((Context) this, 2.0f);
        this.n = this.o.a(getString(R.string.beautify));
        this.m = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.l = (LinearLayout) findViewById(R.id.rotate);
        this.j = (RadioButton) findViewById(R.id.beautify_btn);
        this.k = (RadioButton) findViewById(R.id.rotate_btn);
        as asVar = new as(this);
        this.j.setOnCheckedChangeListener(asVar);
        this.k.setOnCheckedChangeListener(asVar);
        this.j.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        at atVar = new at(this);
        button.setOnClickListener(atVar);
        button2.setOnClickListener(atVar);
        button3.setOnClickListener(atVar);
        button4.setOnClickListener(atVar);
        if (Build.VERSION.SDK_INT < 7 || !this.u) {
            this.m.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = new ax(this, null);
        this.i.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        try {
            com.baidu.tieba.util.af.a("photos", str, this.p, 90);
            this.b.setImageBitmap(null);
            int i = 100;
            if (this.t > 0) {
                i = this.t;
            }
            Bitmap a2 = com.baidu.tieba.util.m.a(this.p, i);
            if (a2 != null && com.baidu.tieba.util.af.a((String) null, "tieba_resized_image_display", a2, 80) != null) {
                new com.baidu.tieba.account.ah("motu_pic", String.valueOf(this.s)).start();
                return true;
            }
        } catch (Exception e) {
            bg.b(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        if (this.C != null && strArr != null) {
            this.w.removeAllViews();
            this.m.setVisibility(0);
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
                imageView2.setImageBitmap(this.C.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new au(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new av(this, substring, i2));
                }
                this.w.addView(inflate2);
                synchronized (this.E) {
                    this.D.put(substring, imageView2);
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
            if (this.v != null && (imageView = this.D.get(this.v)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.r, this.r, this.r, this.r);
            }
            ImageView imageView2 = this.D.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.r, this.r, this.r, this.r);
            }
            this.v = str;
        }
    }

    private void e() {
        this.q = new az(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.q, intentFilter);
    }
}

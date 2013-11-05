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
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f2620a = null;
    private int B;
    private String C;
    private String D;
    private HashMap<String, Bitmap> E;
    private HashMap<String, ImageView> F;
    private RadioButton m;
    private RadioButton n;
    private LinearLayout y;
    private ImageView b = null;
    private Bitmap c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private HorizontalScrollView g = null;
    private ProgressBar j = null;
    private be k = null;
    private bd l = null;
    private LinearLayout o = null;
    private LinearLayout p = null;
    private TextView q = null;
    private Bitmap r = null;
    private bf s = null;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private boolean w = true;
    private String x = null;
    private boolean z = false;
    private boolean A = false;
    private final Object G = new Object();
    private final View.OnClickListener H = new bc(this);

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
        this.B = intent.getIntExtra("request", 0);
        this.v = intent.getIntExtra("display_size", 0);
        this.C = intent.getStringExtra("finish_text");
        this.D = intent.getStringExtra("cancel_text");
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.A = true;
        }
        if (this.B == 12002 || this.B == 12001) {
            e();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.B, intent.getData(), com.baidu.tieba.util.bd.a().e(), this.v);
            } else {
                TiebaPrepareImageService.a(this.B, null, com.baidu.tieba.util.bd.a().e(), this.v);
            }
            f();
        } else {
            e();
            d();
        }
        f2620a = getResources().getStringArray(R.array.fiter_name);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.w = false;
        } else {
            this.w = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.b.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.k == null) {
            this.k = new be(this, null);
            this.k.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void a_() {
        if (this.k != null) {
            this.k.cancel();
        }
        this.b.setImageBitmap(null);
        c();
    }

    private void c() {
        synchronized (this.G) {
            if (this.F != null) {
                for (Map.Entry<String, ImageView> entry : this.F.entrySet()) {
                    ImageView value = entry.getValue();
                    if (value != null) {
                        value.setImageBitmap(null);
                    }
                }
                this.F.clear();
                this.F = null;
            }
            if (this.E != null) {
                for (Map.Entry<String, Bitmap> entry2 : this.E.entrySet()) {
                    Bitmap value2 = entry2.getValue();
                    if (value2 != null && !value2.isRecycled()) {
                        value2.recycle();
                    }
                }
                this.E.clear();
                this.E = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new be(this, null);
        this.k.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.a();
        a_();
        super.onDestroy();
        if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
        if (this.r != null && !this.r.isRecycled()) {
            this.r.recycle();
            this.r = null;
        }
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.j.setVisibility(8);
        if (this.B == 12002 || this.B == 12001) {
            unregisterReceiver(this.s);
        }
        TiebaApplication.g().b((com.baidu.tieba.j) this);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.H.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void e() {
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.j.setVisibility(8);
        this.b = (ImageView) findViewById(R.id.image);
        this.b.setOnClickListener(new av(this));
        this.b.setImageBitmap(this.c);
        this.f = (LinearLayout) findViewById(R.id.title);
        this.g = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.d = (Button) findViewById(R.id.back);
        this.d.setOnClickListener(new aw(this));
        if (!TextUtils.isEmpty(this.D)) {
            this.d.setText(this.D);
        }
        this.e = (Button) findViewById(R.id.delete);
        if (TextUtils.isEmpty(this.C)) {
            if (this.A || this.B != 12003) {
                this.e.setText(getString(R.string.done));
            }
        } else {
            this.e.setText(this.C);
        }
        this.e.setOnClickListener(new ax(this));
        this.y = (LinearLayout) findViewById(R.id.filters);
        this.t = UtilHelper.a((Context) this, 2.0f);
        this.q = (TextView) findViewById(R.id.editimage_title);
        this.p = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.o = (LinearLayout) findViewById(R.id.rotate);
        this.m = (RadioButton) findViewById(R.id.beautify_btn);
        this.n = (RadioButton) findViewById(R.id.rotate_btn);
        ay ayVar = new ay(this);
        this.m.setOnCheckedChangeListener(ayVar);
        this.n.setOnCheckedChangeListener(ayVar);
        this.m.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        az azVar = new az(this);
        button.setOnClickListener(azVar);
        button2.setOnClickListener(azVar);
        button3.setOnClickListener(azVar);
        button4.setOnClickListener(azVar);
        if (Build.VERSION.SDK_INT < 7 || !this.w) {
            this.p.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.l != null) {
            this.l.cancel();
        }
        this.l = new bd(this, null);
        this.l.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(String str) {
        try {
            com.baidu.tieba.util.w.a("photos", str, this.r, 90);
            this.b.setImageBitmap(null);
            int i = 100;
            if (this.v > 0) {
                i = this.v;
            }
            Bitmap a2 = com.baidu.tieba.util.e.a(this.r, i);
            if (a2 != null && com.baidu.tieba.util.w.a((String) null, "tieba_resized_image_display", a2, 80) != null) {
                new com.baidu.tieba.account.ah("motu_pic", String.valueOf(this.u)).start();
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        if (this.E != null && strArr != null) {
            this.y.removeAllViews();
            this.p.setVisibility(0);
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
                imageView2.setImageBitmap(this.E.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new ba(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new bb(this, substring, i2));
                }
                this.y.addView(inflate2);
                synchronized (this.G) {
                    this.F.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            e("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.x != null && (imageView = this.F.get(this.x)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.t, this.t, this.t, this.t);
            }
            ImageView imageView2 = this.F.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.t, this.t, this.t, this.t);
            }
            this.x = str;
        }
    }

    private void f() {
        this.s = new bf(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.s, intentFilter);
    }
}

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
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends com.baidu.tieba.g {

    /* renamed from: a */
    private static String[] f1867a = null;
    private int A;
    private HashMap B;
    private HashMap C;
    private RadioButton m;
    private RadioButton n;
    private LinearLayout x;
    private ImageView b = null;
    private Bitmap c = null;
    private Button d = null;
    private Button e = null;
    private LinearLayout f = null;
    private HorizontalScrollView g = null;
    private ProgressBar j = null;
    private ay k = null;
    private ax l = null;
    private LinearLayout o = null;
    private LinearLayout p = null;
    private TextView q = null;
    private Bitmap r = null;
    private az s = null;
    private int t = 0;
    private int u = 0;
    private boolean v = true;
    private String w = null;
    private boolean y = false;
    private boolean z = false;
    private View.OnClickListener D = new ap(this);

    public static void a(Activity activity, Bitmap bitmap, int i) {
        Intent intent = new Intent(activity, WriteImageActivity.class);
        if (bitmap != null) {
            intent.putExtra("request", i);
            activity.startActivityForResult(intent, 12003);
        }
    }

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, AntiData antiData) {
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.tieba.util.am.a((Context) activity, antiData.getForbid_info());
            return;
        }
        Intent intent = new Intent(activity, WriteImageActivity.class);
        intent.putExtra("request", i);
        if ((activity instanceof FrsActivity) || (activity instanceof ImagePbActivity) || (activity instanceof FrsImageActivity)) {
            intent.putExtra("from", "frs");
        }
        intent.putExtra("forumid", str);
        intent.putExtra("foruimname", str2);
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

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.f().a((com.baidu.tieba.g) this);
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.A = intent.getIntExtra("request", 0);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.z = true;
        }
        if (this.A == 12002 || this.A == 12001) {
            k();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.A, intent.getData(), TiebaApplication.f().aF());
            } else {
                TiebaPrepareImageService.a(this.A, null, TiebaApplication.f().aF());
            }
            l();
        } else {
            k();
            d();
        }
        f1867a = getResources().getStringArray(R.array.fiter_name);
        this.v = TiebaApplication.f().v();
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.b.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.k == null) {
            this.k = new ay(this, null);
            this.k.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a
    public void a_() {
        if (this.k != null) {
            this.k.cancel();
        }
        this.b.setImageBitmap(null);
        c();
    }

    private void c() {
        if (this.C != null) {
            for (Map.Entry entry : this.C.entrySet()) {
                ImageView imageView = (ImageView) entry.getValue();
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
            }
            this.C.clear();
            this.C = null;
        }
        if (this.B != null) {
            for (Map.Entry entry2 : this.B.entrySet()) {
                Bitmap bitmap = (Bitmap) entry2.getValue();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.B.clear();
            this.B = null;
        }
    }

    public void d() {
        if (this.k != null) {
            this.k.cancel();
        }
        this.k = new ay(this, null);
        this.k.execute(new Object[0]);
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
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
        if (this.A == 12002 || this.A == 12001) {
            unregisterReceiver(this.s);
        }
        TiebaApplication.f().b((com.baidu.tieba.g) this);
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.D.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void k() {
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.j.setVisibility(8);
        this.b = (ImageView) findViewById(R.id.image);
        this.b.setOnClickListener(new aq(this));
        this.b.setImageBitmap(this.c);
        this.f = (LinearLayout) findViewById(R.id.title);
        this.g = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.d = (Button) findViewById(R.id.back);
        this.d.setOnClickListener(new ar(this));
        this.e = (Button) findViewById(R.id.delete);
        if (this.z || this.A != 12003) {
            this.e.setText(getString(R.string.done));
        }
        this.e.setOnClickListener(new as(this));
        this.x = (LinearLayout) findViewById(R.id.filters);
        this.t = com.baidu.tieba.util.am.a((Context) this, 2.0f);
        this.q = (TextView) findViewById(R.id.editimage_title);
        this.p = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.o = (LinearLayout) findViewById(R.id.rotate);
        this.m = (RadioButton) findViewById(R.id.beautify_btn);
        this.n = (RadioButton) findViewById(R.id.rotate_btn);
        at atVar = new at(this);
        this.m.setOnCheckedChangeListener(atVar);
        this.n.setOnCheckedChangeListener(atVar);
        this.m.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        au auVar = new au(this);
        button.setOnClickListener(auVar);
        button2.setOnClickListener(auVar);
        button3.setOnClickListener(auVar);
        button4.setOnClickListener(auVar);
        if (Build.VERSION.SDK_INT < 7 || !this.v) {
            this.p.setVisibility(8);
        }
    }

    public void c(String str) {
        if (this.l != null) {
            this.l.cancel();
        }
        this.l = new ax(this, null);
        this.l.execute(str);
    }

    public boolean d(String str) {
        try {
            com.baidu.tieba.util.p.a("photos", str, this.r, 90);
            this.b.setImageBitmap(null);
            Bitmap a2 = com.baidu.tieba.util.e.a(this.r, 100);
            if (a2 != null && com.baidu.tieba.util.p.a(null, "tieba_resized_image_display", a2, 80) != null) {
                new com.baidu.tieba.account.ag("motu_pic", String.valueOf(this.u)).start();
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    public void a(String[] strArr) {
        if (this.B != null && strArr != null) {
            this.x.removeAllViews();
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
                imageView2.setImageBitmap((Bitmap) this.B.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new av(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new aw(this, substring, i2));
                }
                this.x.addView(inflate2);
                this.C.put(substring, imageView2);
                i++;
                i2 = i3;
            }
            e("normal");
        }
    }

    public void e(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.w != null && (imageView = (ImageView) this.C.get(this.w)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.t, this.t, this.t, this.t);
            }
            ImageView imageView2 = (ImageView) this.C.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.t, this.t, this.t, this.t);
            }
            this.w = str;
        }
    }

    private void l() {
        this.s = new az(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.s, intentFilter);
    }
}

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
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.service.TiebaPrepareImageService;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends com.baidu.tieba.e {
    private static String[] b = null;
    private HashMap A;
    private HashMap B;
    private RadioButton l;
    private RadioButton m;
    private LinearLayout w;
    private int z;
    private ImageView c = null;
    private Bitmap d = null;
    private Button e = null;
    private Button f = null;
    private LinearLayout g = null;
    private HorizontalScrollView h = null;
    private ProgressBar i = null;
    private ay j = null;
    private ax k = null;
    private LinearLayout n = null;
    private LinearLayout o = null;
    private TextView p = null;
    private Bitmap q = null;
    private az r = null;
    private int s = 0;
    private int t = 0;
    private boolean u = true;
    private String v = null;
    private boolean x = false;
    private boolean y = false;
    private View.OnClickListener C = new ap(this);

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, com.baidu.tieba.a.b bVar) {
        if (bVar != null && bVar.a() == 0) {
            com.baidu.tieba.c.ag.a((Context) activity, bVar.e());
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

    public static void a(Activity activity, int i, int i2, Uri uri, String str, String str2, String str3, com.baidu.tieba.a.b bVar) {
        if (bVar != null && bVar.a() == 0) {
            com.baidu.tieba.c.ag.a((Context) activity, bVar.e());
            return;
        }
        Intent intent = new Intent(activity, WriteImageActivity.class);
        intent.putExtra("request", i);
        if ((activity instanceof FrsActivity) || (activity instanceof ImagePbActivity) || (activity instanceof FrsImageActivity)) {
            intent.putExtra("from", "frs");
        }
        intent.putExtra("forumid", str);
        intent.putExtra("foruimname", str2);
        intent.putExtra("threadid", str3);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, Bitmap bitmap, int i) {
        Intent intent = new Intent(activity, WriteImageActivity.class);
        if (bitmap != null) {
            intent.putExtra("request", i);
            activity.startActivityForResult(intent, 1200003);
        }
    }

    public void a(String[] strArr) {
        if (this.A == null || strArr == null) {
            return;
        }
        this.w.removeAllViews();
        this.o.setVisibility(0);
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
            imageView2.setImageBitmap((Bitmap) this.A.get(substring));
            int i3 = i2 + 1;
            if (substring.equals("normal")) {
                imageView2.setOnClickListener(new av(this, substring, i2));
            } else {
                imageView2.setOnClickListener(new aw(this, substring, i2));
            }
            this.w.addView(inflate2);
            this.B.put(substring, imageView2);
            i++;
            i2 = i3;
        }
        e("normal");
    }

    public void c(String str) {
        if (this.k != null) {
            this.k.a();
        }
        this.k = new ax(this, null);
        this.k.execute(str);
    }

    public boolean d(String str) {
        try {
            com.baidu.tieba.c.o.a("photos", str, this.q, 90);
            this.c.setImageBitmap(null);
            Bitmap a = com.baidu.tieba.c.e.a(this.q, 100);
            if (a != null && com.baidu.tieba.c.o.a(null, "tieba_resized_image_display", a, 80) != null) {
                new com.baidu.tieba.account.ak("motu_pic", String.valueOf(this.t)).start();
                return true;
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    public void e(String str) {
        ImageView imageView;
        if (str == null) {
            return;
        }
        if (this.v != null && (imageView = (ImageView) this.B.get(this.v)) != null) {
            imageView.setBackgroundDrawable(null);
            imageView.setPadding(this.s, this.s, this.s, this.s);
        }
        ImageView imageView2 = (ImageView) this.B.get(str);
        if (imageView2 != null) {
            imageView2.setBackgroundResource(R.drawable.round_corner);
            imageView2.setPadding(this.s, this.s, this.s, this.s);
        }
        this.v = str;
    }

    private void h() {
        if (this.B != null) {
            for (Map.Entry entry : this.B.entrySet()) {
                ImageView imageView = (ImageView) entry.getValue();
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
            }
            this.B.clear();
            this.B = null;
        }
        if (this.A != null) {
            for (Map.Entry entry2 : this.A.entrySet()) {
                Bitmap bitmap = (Bitmap) entry2.getValue();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.A.clear();
            this.A = null;
        }
    }

    public void i() {
        if (this.j != null) {
            this.j.a();
        }
        this.j = new ay(this, null);
        this.j.execute(new Object[0]);
    }

    private void j() {
        this.i = (ProgressBar) findViewById(R.id.progress);
        this.i.setVisibility(8);
        this.c = (ImageView) findViewById(R.id.image);
        this.c.setOnClickListener(new aq(this));
        this.c.setImageBitmap(this.d);
        this.g = (LinearLayout) findViewById(R.id.title);
        this.h = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new ar(this));
        this.f = (Button) findViewById(R.id.delete);
        if (this.y || this.z != 1200003) {
            this.f.setText(getString(R.string.done));
        }
        this.f.setOnClickListener(new as(this));
        this.w = (LinearLayout) findViewById(R.id.filters);
        this.s = com.baidu.tieba.c.ag.a((Context) this, 2.0f);
        this.p = (TextView) findViewById(R.id.editimage_title);
        this.o = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.n = (LinearLayout) findViewById(R.id.rotate);
        this.l = (RadioButton) findViewById(R.id.beautify_btn);
        this.m = (RadioButton) findViewById(R.id.rotate_btn);
        at atVar = new at(this);
        this.l.setOnCheckedChangeListener(atVar);
        this.m.setOnCheckedChangeListener(atVar);
        this.l.setChecked(true);
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
        if (Build.VERSION.SDK_INT < 7 || !this.u) {
            this.o.setVisibility(8);
        }
    }

    private void k() {
        this.r = new az(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.r, intentFilter);
    }

    @Override // com.baidu.tieba.e
    public void a() {
        if (this.j != null) {
            this.j.a();
        }
        this.c.setImageBitmap(null);
        h();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.a().a((com.baidu.tieba.e) this);
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.z = intent.getIntExtra("request", 0);
        if (intent.getStringExtra("from") != null && intent.getStringExtra("from").equals("frs")) {
            this.y = true;
        }
        if (this.z == 1200002 || this.z == 1200001) {
            j();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.z, intent.getData(), TiebaApplication.a().ak());
            } else {
                TiebaPrepareImageService.a(this.z, null, TiebaApplication.a().ak());
            }
            k();
        } else {
            j();
            i();
        }
        b = getResources().getStringArray(R.array.fiter_name);
        this.u = TiebaApplication.a().k();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        a();
        super.onDestroy();
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
        if (this.q != null && !this.q.isRecycled()) {
            this.q.recycle();
            this.q = null;
        }
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        this.i.setVisibility(8);
        if (this.z == 1200002 || this.z == 1200001) {
            unregisterReceiver(this.r);
        }
        TiebaApplication.a().b((com.baidu.tieba.e) this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.C.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.c.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.j == null) {
            this.j = new ay(this, null);
            this.j.execute(new Object[0]);
        }
    }
}

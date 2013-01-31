package com.baidu.tieba.person;

import android.app.Activity;
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
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.view.EditHeadImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends com.baidu.tieba.e {
    public static String c = "delete";
    public static String d = "change";
    public static String e = "file_name";
    private static String[] f = null;
    private LinearLayout B;
    private int D;
    private HashMap E;
    private HashMap F;
    private RadioButton q;
    private RadioButton r;
    private EditHeadImageView g = null;
    private Bitmap h = null;
    private Button i = null;
    private Button j = null;
    private Button k = null;
    private Button l = null;
    private HorizontalScrollView m = null;
    private ProgressBar n = null;
    private t o = null;
    private s p = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private v u = null;
    private Bitmap v = null;
    private u w = null;
    private int x = 0;
    private int y = 0;
    private boolean z = true;
    private String A = null;
    private boolean C = false;

    public static void a(Activity activity, int i, int i2, Uri uri, com.baidu.tieba.a.a aVar) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i);
        intent.putExtra("account_data", aVar);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.b().a((com.baidu.tieba.e) this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.D = intent.getIntExtra("request", 0);
        if (this.D == 1200002 || this.D == 1200001) {
            m();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.D, intent.getData(), TiebaApplication.b().an());
            } else {
                TiebaPrepareImageService.a(this.D, null, TiebaApplication.b().an());
            }
            n();
        } else {
            m();
            k();
        }
        f = getResources().getStringArray(R.array.fiter_name);
        this.z = TiebaApplication.b().m();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.g.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.o == null) {
            this.o = new t(this, null);
            this.o.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.e
    public void b() {
        if (this.o != null) {
            this.o.a();
        }
        this.g.setImageBitmap(null);
        j();
    }

    private void j() {
        if (this.F != null) {
            for (Map.Entry entry : this.F.entrySet()) {
                ImageView imageView = (ImageView) entry.getValue();
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
            }
            this.F.clear();
            this.F = null;
        }
        if (this.E != null) {
            for (Map.Entry entry2 : this.E.entrySet()) {
                Bitmap bitmap = (Bitmap) entry2.getValue();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.E.clear();
            this.E = null;
        }
    }

    public void k() {
        if (this.o != null) {
            this.o.a();
        }
        this.o = new t(this, null);
        this.o.execute(new Object[0]);
        com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) getIntent().getSerializableExtra("account_data");
        if (aVar != null) {
            TiebaApplication.a(aVar);
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        b();
        super.onDestroy();
        this.g.j();
        if (this.h != null && !this.h.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        if (this.u != null) {
            this.u.a();
        }
        if (this.v != null && !this.v.isRecycled()) {
            this.v.recycle();
            this.v = null;
        }
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        this.n.setVisibility(8);
        if (this.D == 1200002 || this.D == 1200001) {
            unregisterReceiver(this.w);
        }
        TiebaApplication.b().b((com.baidu.tieba.e) this);
    }

    public void l() {
        if (this.u != null) {
            this.u.a();
        }
        this.u = new v(this, null);
        this.u.execute(new String[0]);
    }

    private void m() {
        this.n = (ProgressBar) findViewById(R.id.progress);
        this.n.setVisibility(8);
        this.g = (EditHeadImageView) findViewById(R.id.image);
        this.g.setImageBitmap(this.h);
        this.m = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.i = (Button) findViewById(R.id.back);
        this.i.setOnClickListener(new k(this));
        this.l = (Button) findViewById(R.id.show_button);
        this.l.setOnClickListener(new l(this));
        this.k = (Button) findViewById(R.id.hide_button);
        this.k.setVisibility(0);
        this.k.setOnClickListener(new m(this));
        this.j = (Button) findViewById(R.id.delete);
        this.j.setOnClickListener(new n(this));
        this.B = (LinearLayout) findViewById(R.id.filters);
        this.x = com.baidu.tieba.c.ah.a(this, 2.0f);
        this.t = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.s = (LinearLayout) findViewById(R.id.rotate);
        this.q = (RadioButton) findViewById(R.id.beautify_btn);
        this.r = (RadioButton) findViewById(R.id.rotate_btn);
        o oVar = new o(this);
        this.q.setOnCheckedChangeListener(oVar);
        this.r.setOnCheckedChangeListener(oVar);
        this.q.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        p pVar = new p(this);
        button.setOnClickListener(pVar);
        button2.setOnClickListener(pVar);
        button3.setOnClickListener(pVar);
        button4.setOnClickListener(pVar);
        if (Build.VERSION.SDK_INT < 7 || !this.z) {
            this.t.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    public void c(String str) {
        if (this.p != null) {
            this.p.a();
        }
        this.p = new s(this, null);
        this.p.execute(str);
    }

    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tieba.c.o.a(null, str, bitmap, 90);
            if (this.C) {
                new com.baidu.tieba.account.ak("motu_pic", String.valueOf(this.y)).start();
            }
            return true;
        } catch (Exception e2) {
            com.baidu.tieba.c.af.b(getClass().getName(), "saveFile", e2.toString());
            return false;
        }
    }

    public void a(String[] strArr) {
        if (this.E != null && strArr != null) {
            this.B.removeAllViews();
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
                imageView2.setImageBitmap((Bitmap) this.E.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new q(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new r(this, substring, i2));
                }
                this.B.addView(inflate2);
                this.F.put(substring, imageView2);
                i++;
                i2 = i3;
            }
            d("normal");
        }
    }

    public void d(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.A != null && (imageView = (ImageView) this.F.get(this.A)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.x, this.x, this.x, this.x);
            }
            ImageView imageView2 = (ImageView) this.F.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.x, this.x, this.x, this.x);
            }
            this.A = str;
        }
    }

    private void n() {
        this.w = new u(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.w, intentFilter);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}

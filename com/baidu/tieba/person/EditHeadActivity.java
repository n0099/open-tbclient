package com.baidu.tieba.person;

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
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.view.EditHeadImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends com.baidu.tieba.e {
    public static String b = "delete";
    public static String c = "change";
    public static String d = "file_name";
    private static String[] e = null;
    private LinearLayout A;
    private int C;
    private HashMap D;
    private HashMap E;
    private RadioButton p;
    private RadioButton q;
    private EditHeadImageView f = null;
    private Bitmap g = null;
    private Button h = null;
    private Button i = null;
    private Button j = null;
    private Button k = null;
    private HorizontalScrollView l = null;
    private ProgressBar m = null;
    private r n = null;
    private q o = null;
    private LinearLayout r = null;
    private LinearLayout s = null;
    private t t = null;
    private Bitmap u = null;
    private s v = null;
    private int w = 0;
    private int x = 0;
    private boolean y = true;
    private String z = null;
    private boolean B = false;

    public static void a(Activity activity, int i, int i2, Uri uri, com.baidu.tieba.a.a aVar) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i);
        intent.putExtra("account_data", aVar);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    public void a(String[] strArr) {
        if (this.D == null || strArr == null) {
            return;
        }
        this.A.removeAllViews();
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
            imageView2.setImageBitmap((Bitmap) this.D.get(substring));
            int i3 = i2 + 1;
            if (substring.equals("normal")) {
                imageView2.setOnClickListener(new o(this, substring, i2));
            } else {
                imageView2.setOnClickListener(new p(this, substring, i2));
            }
            this.A.addView(inflate2);
            this.E.put(substring, imageView2);
            i++;
            i2 = i3;
        }
        d("normal");
    }

    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tieba.c.o.a(null, str, bitmap, 90);
            if (this.B) {
                new com.baidu.tieba.account.ak("motu_pic", String.valueOf(this.x)).start();
            }
            return true;
        } catch (Exception e2) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "saveFile", e2.toString());
            return false;
        }
    }

    public void c(String str) {
        if (this.o != null) {
            this.o.a();
        }
        this.o = new q(this, null);
        this.o.execute(str);
    }

    public void d(String str) {
        ImageView imageView;
        if (str == null) {
            return;
        }
        if (this.z != null && (imageView = (ImageView) this.E.get(this.z)) != null) {
            imageView.setBackgroundDrawable(null);
            imageView.setPadding(this.w, this.w, this.w, this.w);
        }
        ImageView imageView2 = (ImageView) this.E.get(str);
        if (imageView2 != null) {
            imageView2.setBackgroundResource(R.drawable.round_corner);
            imageView2.setPadding(this.w, this.w, this.w, this.w);
        }
        this.z = str;
    }

    private void h() {
        if (this.E != null) {
            for (Map.Entry entry : this.E.entrySet()) {
                ImageView imageView = (ImageView) entry.getValue();
                if (imageView != null) {
                    imageView.setImageBitmap(null);
                }
            }
            this.E.clear();
            this.E = null;
        }
        if (this.D != null) {
            for (Map.Entry entry2 : this.D.entrySet()) {
                Bitmap bitmap = (Bitmap) entry2.getValue();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.D.clear();
            this.D = null;
        }
    }

    public void i() {
        if (this.n != null) {
            this.n.a();
        }
        this.n = new r(this, null);
        this.n.execute(new Object[0]);
        com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) getIntent().getSerializableExtra("account_data");
        if (aVar != null) {
            TiebaApplication.a(aVar);
        }
    }

    public void j() {
        if (this.t != null) {
            this.t.a();
        }
        this.t = new t(this, null);
        this.t.execute(new String[0]);
    }

    private void k() {
        this.m = (ProgressBar) findViewById(R.id.progress);
        this.m.setVisibility(8);
        this.f = (EditHeadImageView) findViewById(R.id.image);
        this.f.setImageBitmap(this.g);
        this.l = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.h = (Button) findViewById(R.id.back);
        this.h.setOnClickListener(new i(this));
        this.k = (Button) findViewById(R.id.show_button);
        this.k.setOnClickListener(new j(this));
        this.j = (Button) findViewById(R.id.hide_button);
        this.j.setVisibility(0);
        this.j.setOnClickListener(new k(this));
        this.i = (Button) findViewById(R.id.delete);
        this.i.setOnClickListener(new l(this));
        this.A = (LinearLayout) findViewById(R.id.filters);
        this.w = com.baidu.tieba.c.ag.a((Context) this, 2.0f);
        this.s = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.r = (LinearLayout) findViewById(R.id.rotate);
        this.p = (RadioButton) findViewById(R.id.beautify_btn);
        this.q = (RadioButton) findViewById(R.id.rotate_btn);
        m mVar = new m(this);
        this.p.setOnCheckedChangeListener(mVar);
        this.q.setOnCheckedChangeListener(mVar);
        this.p.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        n nVar = new n(this);
        button.setOnClickListener(nVar);
        button2.setOnClickListener(nVar);
        button3.setOnClickListener(nVar);
        button4.setOnClickListener(nVar);
        if (Build.VERSION.SDK_INT < 7 || !this.y) {
            this.s.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    private void l() {
        this.v = new s(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.v, intentFilter);
    }

    @Override // com.baidu.tieba.e
    public void a() {
        if (this.n != null) {
            this.n.a();
        }
        this.f.setImageBitmap(null);
        h();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.a().a((com.baidu.tieba.e) this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.C = intent.getIntExtra("request", 0);
        if (this.C == 1200002 || this.C == 1200001) {
            k();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.C, intent.getData(), TiebaApplication.a().ak());
            } else {
                TiebaPrepareImageService.a(this.C, null, TiebaApplication.a().ak());
            }
            l();
        } else {
            k();
            i();
        }
        e = getResources().getStringArray(R.array.fiter_name);
        this.y = TiebaApplication.a().k();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        a();
        super.onDestroy();
        this.f.j();
        if (this.g != null && !this.g.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
        if (this.t != null) {
            this.t.a();
        }
        if (this.u != null && !this.u.isRecycled()) {
            this.u.recycle();
            this.u = null;
        }
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        this.m.setVisibility(8);
        if (this.C == 1200002 || this.C == 1200001) {
            unregisterReceiver(this.v);
        }
        TiebaApplication.a().b((com.baidu.tieba.e) this);
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

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.f.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.n == null) {
            this.n = new r(this, null);
            this.n.execute(new Object[0]);
        }
    }
}

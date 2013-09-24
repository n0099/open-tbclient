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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.EditHeadImageView;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    public static String f1639a = "delete";
    public static String b = "change";
    public static String c = "file_name";
    private static String[] d = null;
    private LinearLayout B;
    private int D;
    private HashMap<String, Bitmap> E;
    private HashMap<String, ImageView> F;
    private RadioButton q;
    private RadioButton r;
    private EditHeadImageView e = null;
    private Bitmap f = null;
    private Button g = null;
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

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i);
        intent.putExtra("account_data", accountData);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().a((com.baidu.tieba.j) this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.D = intent.getIntExtra("request", 0);
        if (this.D == 12002 || this.D == 12001) {
            m();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.D, intent.getData(), com.baidu.tieba.util.au.a().e());
            } else {
                TiebaPrepareImageService.a(this.D, null, com.baidu.tieba.util.au.a().e());
            }
            n();
        } else {
            m();
            d();
        }
        d = getResources().getStringArray(R.array.fiter_name);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.z = false;
        } else {
            this.z = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.e.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.o == null) {
            this.o = new t(this, null);
            this.o.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void a_() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.e.setImageBitmap(null);
        c();
    }

    private void c() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.o = new t(this, null);
        this.o.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra("account_data");
        if (accountData != null) {
            TiebaApplication.a(accountData, getBaseContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        a_();
        super.onDestroy();
        this.e.j();
        if (this.f != null && !this.f.isRecycled()) {
            this.f.recycle();
            this.f = null;
        }
        if (this.u != null) {
            this.u.cancel();
        }
        if (this.v != null && !this.v.isRecycled()) {
            this.v.recycle();
            this.v = null;
        }
        if (this.o != null) {
            this.o.cancel();
            this.o = null;
        }
        this.n.setVisibility(8);
        if (this.D == 12002 || this.D == 12001) {
            unregisterReceiver(this.w);
        }
        TiebaApplication.g().b((com.baidu.tieba.j) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.u != null) {
            this.u.cancel();
        }
        this.u = new v(this, null);
        this.u.execute(new String[0]);
    }

    private void m() {
        this.n = (ProgressBar) findViewById(R.id.progress);
        this.n.setVisibility(8);
        this.e = (EditHeadImageView) findViewById(R.id.image);
        this.e.setImageBitmap(this.f);
        this.m = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.g = (Button) findViewById(R.id.back);
        this.g.setOnClickListener(new k(this));
        this.l = (Button) findViewById(R.id.show_button);
        this.l.setOnClickListener(new l(this));
        this.k = (Button) findViewById(R.id.hide_button);
        this.k.setVisibility(0);
        this.k.setOnClickListener(new m(this));
        this.j = (Button) findViewById(R.id.delete);
        this.j.setOnClickListener(new n(this));
        this.B = (LinearLayout) findViewById(R.id.filters);
        this.x = UtilHelper.a((Context) this, 2.0f);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.p != null) {
            this.p.cancel();
        }
        this.p = new s(this, null);
        this.p.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tieba.util.p.a(null, str, bitmap, 90);
            if (this.C) {
                new com.baidu.tieba.account.ag("motu_pic", String.valueOf(this.y)).start();
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "saveFile", e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                imageView2.setImageBitmap(this.E.get(substring));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.A != null && (imageView = this.F.get(this.A)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.x, this.x, this.x, this.x);
            }
            ImageView imageView2 = this.F.get(str);
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

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}

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
import com.baidu.tieba.view.EditHeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends com.baidu.tieba.j {
    public static String a = "resourceid";
    public static String b = "pic_info";
    public static String c = "delete";
    public static String d = "change";
    public static String e = "file_name";
    private static String[] f = null;
    private LinearLayout C;
    private int E;
    private HashMap<String, Bitmap> F;
    private HashMap<String, ImageView> G;
    private NavigationBar H;
    private RadioButton q;
    private RadioButton r;
    private EditHeadImageView g = null;
    private Bitmap h = null;
    private int i = 0;
    private TextView j = null;
    private Button k = null;
    private Button l = null;
    private HorizontalScrollView m = null;
    private ProgressBar n = null;
    private v o = null;
    private u p = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private x u = null;
    private TextView v = null;
    private Bitmap w = null;
    private w x = null;
    private int y = 0;
    private int z = 0;
    private boolean A = true;
    private String B = null;
    private boolean D = false;

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData, int i3) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i);
        intent.putExtra("account_data", accountData);
        intent.putExtra("edit_type", i3);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData) {
        a(activity, i, i2, uri, accountData, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.h().a((com.baidu.tieba.j) this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.i = intent.getIntExtra("edit_type", 0);
        this.E = intent.getIntExtra("request", 0);
        if (this.E == 12002 || this.E == 12001) {
            e();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.E, intent.getData(), com.baidu.tieba.util.bx.a().e());
            } else {
                TiebaPrepareImageService.a(this.E, null, com.baidu.tieba.util.bx.a().e());
            }
            f();
        } else {
            e();
            c();
        }
        f = getResources().getStringArray(R.array.fiter_name);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.A = false;
        } else {
            this.A = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.g.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.o == null) {
            this.o = new v(this, null);
            this.o.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.H.c(i);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void releaseResouce() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.g.setImageBitmap(null);
        b();
    }

    private void b() {
        if (this.G != null) {
            for (Map.Entry<String, ImageView> entry : this.G.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageBitmap(null);
                }
            }
            this.G.clear();
            this.G = null;
        }
        if (this.F != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.F.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.F.clear();
            this.F = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.o = new v(this, null);
        this.o.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra("account_data");
        if (accountData != null) {
            TiebaApplication.a(accountData, getBaseContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.g.j();
        if (this.h != null && !this.h.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        if (this.u != null) {
            this.u.cancel();
        }
        if (this.w != null && !this.w.isRecycled()) {
            this.w.recycle();
            this.w = null;
        }
        if (this.o != null) {
            this.o.cancel();
            this.o = null;
        }
        this.n.setVisibility(8);
        if (this.E == 12002 || this.E == 12001) {
            unregisterReceiver(this.x);
        }
        TiebaApplication.h().b((com.baidu.tieba.j) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.u != null) {
            this.u.cancel();
        }
        this.u = new x(this, null);
        this.u.execute(new String[0]);
    }

    private void e() {
        this.H = (NavigationBar) findViewById(R.id.navigation_bar);
        this.n = (ProgressBar) findViewById(R.id.progress);
        this.n.setVisibility(8);
        this.g = (EditHeadImageView) findViewById(R.id.image);
        this.g.setImageBitmap(this.h);
        this.m = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.H.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.l = (Button) findViewById(R.id.show_button);
        this.l.setOnClickListener(new m(this));
        this.k = (Button) findViewById(R.id.hide_button);
        this.k.setVisibility(0);
        this.k.setOnClickListener(new n(this));
        this.j = this.H.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.done), new o(this));
        this.j.setEnabled(false);
        this.v = this.H.a(getString(R.string.beautify));
        if (this.i == 2) {
            this.v.setText(getString(R.string.beautify));
            this.j.setText(getString(R.string.done));
        }
        this.C = (LinearLayout) findViewById(R.id.filters);
        this.y = com.baidu.adp.lib.g.g.a((Context) this, 2.0f);
        this.t = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.s = (LinearLayout) findViewById(R.id.rotate);
        this.q = (RadioButton) findViewById(R.id.beautify_btn);
        this.r = (RadioButton) findViewById(R.id.rotate_btn);
        q qVar = new q(this);
        this.q.setOnCheckedChangeListener(qVar);
        this.r.setOnCheckedChangeListener(qVar);
        this.q.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        r rVar = new r(this);
        button.setOnClickListener(rVar);
        button2.setOnClickListener(rVar);
        button3.setOnClickListener(rVar);
        button4.setOnClickListener(rVar);
        if (Build.VERSION.SDK_INT < 7 || !this.A) {
            this.t.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.p != null) {
            this.p.cancel();
        }
        this.p = new u(this, null);
        this.p.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tieba.util.ad.a((String) null, str, bitmap, 80);
            if (this.D) {
                new com.baidu.tieba.account.av("motu_pic", String.valueOf(this.z)).start();
            }
            return true;
        } catch (Exception e2) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "saveFile", e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        if (this.F != null && strArr != null) {
            this.C.removeAllViews();
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
                imageView2.setImageBitmap(this.F.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new s(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new t(this, substring, i2));
                }
                this.C.addView(inflate2);
                this.G.put(substring, imageView2);
                i++;
                i2 = i3;
            }
            b("normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.B != null && (imageView = this.G.get(this.B)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.y, this.y, this.y, this.y);
            }
            ImageView imageView2 = this.G.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.y, this.y, this.y, this.y);
            }
            this.B = str;
        }
    }

    private void f() {
        this.x = new w(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.x, intentFilter);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}

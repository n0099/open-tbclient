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
    private LinearLayout D;
    private int F;
    private HashMap<String, Bitmap> G;
    private HashMap<String, ImageView> H;
    private NavigationBar I;
    private RadioButton r;
    private RadioButton s;
    private EditHeadImageView g = null;
    private Bitmap h = null;
    private int i = 0;
    private ImageView j = null;
    private TextView k = null;
    private Button l = null;
    private Button m = null;
    private HorizontalScrollView n = null;
    private ProgressBar o = null;
    private v p = null;
    private u q = null;
    private LinearLayout t = null;
    private LinearLayout u = null;
    private x v = null;
    private TextView w = null;
    private Bitmap x = null;
    private w y = null;
    private int z = 0;
    private int A = 0;
    private boolean B = true;
    private String C = null;
    private boolean E = false;

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
        this.F = intent.getIntExtra("request", 0);
        if (this.F == 12002 || this.F == 12001) {
            e();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.F, intent.getData(), com.baidu.tieba.util.bd.a().e());
            } else {
                TiebaPrepareImageService.a(this.F, null, com.baidu.tieba.util.bd.a().e());
            }
            f();
        } else {
            e();
            c();
        }
        f = getResources().getStringArray(R.array.fiter_name);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.B = false;
        } else {
            this.B = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.g.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.p == null) {
            this.p = new v(this, null);
            this.p.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.I.c(i);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void releaseResouce() {
        if (this.p != null) {
            this.p.cancel();
        }
        this.g.setImageBitmap(null);
        b();
    }

    private void b() {
        if (this.H != null) {
            for (Map.Entry<String, ImageView> entry : this.H.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageBitmap(null);
                }
            }
            this.H.clear();
            this.H = null;
        }
        if (this.G != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.G.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.G.clear();
            this.G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.p != null) {
            this.p.cancel();
        }
        this.p = new v(this, null);
        this.p.execute(new Object[0]);
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
        if (this.v != null) {
            this.v.cancel();
        }
        if (this.x != null && !this.x.isRecycled()) {
            this.x.recycle();
            this.x = null;
        }
        if (this.p != null) {
            this.p.cancel();
            this.p = null;
        }
        this.o.setVisibility(8);
        if (this.F == 12002 || this.F == 12001) {
            unregisterReceiver(this.y);
        }
        TiebaApplication.h().b((com.baidu.tieba.j) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.v != null) {
            this.v.cancel();
        }
        this.v = new x(this, null);
        this.v.execute(new String[0]);
    }

    private void e() {
        this.I = (NavigationBar) findViewById(R.id.navigation_bar);
        this.o = (ProgressBar) findViewById(R.id.progress);
        this.o.setVisibility(8);
        this.g = (EditHeadImageView) findViewById(R.id.image);
        this.g.setImageBitmap(this.h);
        this.n = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.j = this.I.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.m = (Button) findViewById(R.id.show_button);
        this.m.setOnClickListener(new m(this));
        this.l = (Button) findViewById(R.id.hide_button);
        this.l.setVisibility(0);
        this.l.setOnClickListener(new n(this));
        this.k = this.I.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.done), new o(this));
        this.k.setEnabled(false);
        this.w = this.I.a(getString(R.string.beautify));
        if (this.i == 2) {
            this.w.setText(getString(R.string.beautify));
            this.k.setText(getString(R.string.done));
        }
        this.D = (LinearLayout) findViewById(R.id.filters);
        this.z = com.baidu.adp.lib.h.g.a((Context) this, 2.0f);
        this.u = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.t = (LinearLayout) findViewById(R.id.rotate);
        this.r = (RadioButton) findViewById(R.id.beautify_btn);
        this.s = (RadioButton) findViewById(R.id.rotate_btn);
        q qVar = new q(this);
        this.r.setOnCheckedChangeListener(qVar);
        this.s.setOnCheckedChangeListener(qVar);
        this.r.setChecked(true);
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
        if (Build.VERSION.SDK_INT < 7 || !this.B) {
            this.u.setVisibility(8);
            this.m.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.q != null) {
            this.q.cancel();
        }
        this.q = new u(this, null);
        this.q.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tieba.util.y.a((String) null, str, bitmap, 80);
            if (this.E) {
                new com.baidu.tieba.account.av("motu_pic", String.valueOf(this.A)).start();
            }
            return true;
        } catch (Exception e2) {
            com.baidu.tieba.util.be.b(getClass().getName(), "saveFile", e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        if (this.G != null && strArr != null) {
            this.D.removeAllViews();
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
                imageView2.setImageBitmap(this.G.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new s(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new t(this, substring, i2));
                }
                this.D.addView(inflate2);
                this.H.put(substring, imageView2);
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
            if (this.C != null && (imageView = this.H.get(this.C)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.z, this.z, this.z, this.z);
            }
            ImageView imageView2 = this.H.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.z, this.z, this.z, this.z);
            }
            this.C = str;
        }
    }

    private void f() {
        this.y = new w(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.y, intentFilter);
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

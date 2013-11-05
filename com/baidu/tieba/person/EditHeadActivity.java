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
    public static String f2157a = "resourceid";
    public static String b = "pic_info";
    public static String c = "delete";
    public static String d = "change";
    public static String e = "file_name";
    private static String[] f = null;
    private LinearLayout F;
    private int H;
    private HashMap<String, Bitmap> I;
    private HashMap<String, ImageView> J;
    private RadioButton t;
    private RadioButton u;
    private EditHeadImageView g = null;
    private Bitmap j = null;
    private int k = 0;
    private Button l = null;
    private Button m = null;
    private Button n = null;
    private Button o = null;
    private HorizontalScrollView p = null;
    private ProgressBar q = null;
    private v r = null;
    private u s = null;
    private LinearLayout v = null;
    private LinearLayout w = null;
    private x x = null;
    private TextView y = null;
    private Bitmap z = null;
    private w A = null;
    private int B = 0;
    private int C = 0;
    private boolean D = true;
    private String E = null;
    private boolean G = false;

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
        TiebaApplication.g().a((com.baidu.tieba.j) this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.k = intent.getIntExtra("edit_type", 0);
        this.H = intent.getIntExtra("request", 0);
        if (this.H == 12002 || this.H == 12001) {
            f();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.H, intent.getData(), com.baidu.tieba.util.bd.a().e());
            } else {
                TiebaPrepareImageService.a(this.H, null, com.baidu.tieba.util.bd.a().e());
            }
            n();
        } else {
            f();
            d();
        }
        f = getResources().getStringArray(R.array.fiter_name);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.D = false;
        } else {
            this.D = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.g.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.r == null) {
            this.r = new v(this, null);
            this.r.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void a_() {
        if (this.r != null) {
            this.r.cancel();
        }
        this.g.setImageBitmap(null);
        c();
    }

    private void c() {
        if (this.J != null) {
            for (Map.Entry<String, ImageView> entry : this.J.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageBitmap(null);
                }
            }
            this.J.clear();
            this.J = null;
        }
        if (this.I != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.I.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.I.clear();
            this.I = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.r != null) {
            this.r.cancel();
        }
        this.r = new v(this, null);
        this.r.execute(new Object[0]);
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
        this.g.j();
        if (this.j != null && !this.j.isRecycled()) {
            this.j.recycle();
            this.j = null;
        }
        if (this.x != null) {
            this.x.cancel();
        }
        if (this.z != null && !this.z.isRecycled()) {
            this.z.recycle();
            this.z = null;
        }
        if (this.r != null) {
            this.r.cancel();
            this.r = null;
        }
        this.q.setVisibility(8);
        if (this.H == 12002 || this.H == 12001) {
            unregisterReceiver(this.A);
        }
        TiebaApplication.g().b((com.baidu.tieba.j) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.x != null) {
            this.x.cancel();
        }
        this.x = new x(this, null);
        this.x.execute(new String[0]);
    }

    private void f() {
        this.q = (ProgressBar) findViewById(R.id.progress);
        this.q.setVisibility(8);
        this.g = (EditHeadImageView) findViewById(R.id.image);
        this.g.setImageBitmap(this.j);
        this.p = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.l = (Button) findViewById(R.id.back);
        this.l.setOnClickListener(new l(this));
        this.o = (Button) findViewById(R.id.show_button);
        this.o.setOnClickListener(new m(this));
        this.n = (Button) findViewById(R.id.hide_button);
        this.n.setVisibility(0);
        this.n.setOnClickListener(new n(this));
        this.m = (Button) findViewById(R.id.delete);
        this.m.setEnabled(false);
        this.y = (TextView) findViewById(R.id.editimage_title);
        if (this.k == 2) {
            this.y.setText(getString(R.string.beautify));
            this.m.setText(getString(R.string.done));
        }
        this.m.setOnClickListener(new o(this));
        this.F = (LinearLayout) findViewById(R.id.filters);
        this.B = UtilHelper.a((Context) this, 2.0f);
        this.w = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.v = (LinearLayout) findViewById(R.id.rotate);
        this.t = (RadioButton) findViewById(R.id.beautify_btn);
        this.u = (RadioButton) findViewById(R.id.rotate_btn);
        q qVar = new q(this);
        this.t.setOnCheckedChangeListener(qVar);
        this.u.setOnCheckedChangeListener(qVar);
        this.t.setChecked(true);
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
        if (Build.VERSION.SDK_INT < 7 || !this.D) {
            this.w.setVisibility(8);
            this.o.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.s != null) {
            this.s.cancel();
        }
        this.s = new u(this, null);
        this.s.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tieba.util.w.a((String) null, str, bitmap, 90);
            if (this.G) {
                new com.baidu.tieba.account.ah("motu_pic", String.valueOf(this.C)).start();
            }
            return true;
        } catch (Exception e2) {
            com.baidu.tieba.util.be.b(getClass().getName(), "saveFile", e2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        if (this.I != null && strArr != null) {
            this.F.removeAllViews();
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
                imageView2.setImageBitmap(this.I.get(substring));
                int i3 = i2 + 1;
                if (substring.equals("normal")) {
                    imageView2.setOnClickListener(new s(this, substring, i2));
                } else {
                    imageView2.setOnClickListener(new t(this, substring, i2));
                }
                this.F.addView(inflate2);
                this.J.put(substring, imageView2);
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
            if (this.E != null && (imageView = this.J.get(this.E)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.B, this.B, this.B, this.B);
            }
            ImageView imageView2 = this.J.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.B, this.B, this.B, this.B);
            }
            this.E = str;
        }
    }

    private void n() {
        this.A = new w(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.image.resized");
        registerReceiver(this.A, intentFilter);
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            j();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}

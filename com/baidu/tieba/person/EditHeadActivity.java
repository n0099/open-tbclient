package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.view.EditHeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.write.WriteMultiImgsActivity;
import com.slidingmenu.lib.R;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends com.baidu.tieba.f {
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
    private y o = null;
    private x p = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private aa u = null;
    private TextView v = null;
    private Bitmap w = null;
    private z x = null;
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

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.MOTU) == 1) {
            this.A = false;
        } else {
            this.A = true;
        }
        TiebaApplication.g().a(this);
        setContentView(R.layout.edit_head_activity);
        Intent intent = getIntent();
        this.i = intent.getIntExtra("edit_type", 0);
        this.E = intent.getIntExtra("request", 0);
        if (this.E == 12002 || this.E == 12001) {
            c();
            if (intent.getData() != null) {
                TiebaPrepareImageService.a(this.E, intent.getData(), com.baidu.tieba.util.bv.a().e());
            } else {
                TiebaPrepareImageService.a(this.E, null, com.baidu.tieba.util.bv.a().e());
            }
            this.x = new z(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.data.i.b());
            registerReceiver(this.x, intentFilter);
        } else {
            c();
            b();
        }
        f = getResources().getStringArray(R.array.fiter_name);
        if (this.A) {
            WriteMultiImgsActivity.a(1, 1);
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable drawable = this.g.getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null && this.o == null) {
            this.o = new y(this, (byte) 0);
            this.o.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.H.b(i);
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a
    public void releaseResouce() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.g.setImageBitmap(null);
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

    public void b() {
        if (this.o != null) {
            this.o.cancel();
        }
        this.o = new y(this, (byte) 0);
        this.o.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra("account_data");
        if (accountData != null) {
            TiebaApplication.a(accountData, getBaseContext());
        }
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.g.i();
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
        TiebaApplication.g().b(this);
    }

    public static /* synthetic */ void o(EditHeadActivity editHeadActivity) {
        if (editHeadActivity.u != null) {
            editHeadActivity.u.cancel();
        }
        editHeadActivity.u = new aa(editHeadActivity, (byte) 0);
        editHeadActivity.u.execute(new String[0]);
    }

    private void c() {
        this.H = (NavigationBar) findViewById(R.id.navigation_bar);
        this.n = (ProgressBar) findViewById(R.id.progress);
        this.n.setVisibility(8);
        this.g = (EditHeadImageView) findViewById(R.id.image);
        this.g.setImageBitmap(this.h);
        this.m = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.H.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new o(this));
        this.l = (Button) findViewById(R.id.show_button);
        this.l.setOnClickListener(new p(this));
        this.k = (Button) findViewById(R.id.hide_button);
        this.k.setVisibility(0);
        this.k.setOnClickListener(new q(this));
        this.j = this.H.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.done), new r(this));
        this.j.setEnabled(false);
        this.v = this.H.a(getString(R.string.beautify));
        if (this.i == 2) {
            this.v.setText(getString(R.string.beautify));
            this.j.setText(getString(R.string.done));
        }
        this.C = (LinearLayout) findViewById(R.id.filters);
        this.y = BdUtilHelper.a((Context) this, 2.0f);
        this.t = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.s = (LinearLayout) findViewById(R.id.rotate);
        this.q = (RadioButton) findViewById(R.id.beautify_btn);
        this.r = (RadioButton) findViewById(R.id.rotate_btn);
        t tVar = new t(this);
        this.q.setOnCheckedChangeListener(tVar);
        this.r.setOnCheckedChangeListener(tVar);
        this.q.setChecked(true);
        Button button = (Button) findViewById(R.id.rotate_left);
        Button button2 = (Button) findViewById(R.id.rotate_right);
        Button button3 = (Button) findViewById(R.id.rotate_left_right);
        Button button4 = (Button) findViewById(R.id.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        u uVar = new u(this);
        button.setOnClickListener(uVar);
        button2.setOnClickListener(uVar);
        button3.setOnClickListener(uVar);
        button4.setOnClickListener(uVar);
    }

    public static /* synthetic */ void a(EditHeadActivity editHeadActivity, String str) {
        if (editHeadActivity.p != null) {
            editHeadActivity.p.cancel();
        }
        editHeadActivity.p = new x(editHeadActivity, (byte) 0);
        editHeadActivity.p.execute(str);
    }

    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tieba.util.af.a((String) null, str, bitmap, 80);
            if (this.D) {
                new com.baidu.tieba.account.ax("motu_pic", String.valueOf(this.z)).start();
            }
            return true;
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "saveFile", e2.toString());
            return false;
        }
    }

    public static /* synthetic */ void a(EditHeadActivity editHeadActivity, String[] strArr) {
        if (editHeadActivity.F == null || strArr == null) {
            return;
        }
        editHeadActivity.C.removeAllViews();
        View inflate = editHeadActivity.getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
        inflate.findViewById(R.id.filter_immage);
        inflate.findViewById(R.id.filter_text);
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate2 = editHeadActivity.getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.filter_immage);
            TextView textView = (TextView) inflate2.findViewById(R.id.filter_text);
            textView.setText(substring2);
            imageView.setImageResource(com.baidu.tieba.write.v.a(substring));
            imageView.setTag(textView);
            int i3 = i2 + 1;
            if (substring.equals("normal")) {
                imageView.setOnClickListener(new v(editHeadActivity, substring, i2));
            } else {
                imageView.setOnClickListener(new w(editHeadActivity, substring, i2));
            }
            editHeadActivity.C.addView(inflate2);
            editHeadActivity.G.put(substring, imageView);
            i++;
            i2 = i3;
        }
        editHeadActivity.a("normal");
    }

    public void a(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.B != null && (imageView = this.G.get(this.B)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.y, this.y, this.y, this.y);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.G.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(R.drawable.round_corner);
                imageView2.setPadding(this.y, this.y, this.y, this.y);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.B = str;
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
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

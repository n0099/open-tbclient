package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class VcodeActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private WriteData f1865a = null;
    private ImageView b = null;
    private Button c = null;
    private ImageView d = null;
    private EditText e = null;
    private ProgressBar f = null;
    private s g = null;
    private r j = null;
    private InputMethodManager k = null;
    private DialogInterface.OnCancelListener l = null;
    private RelativeLayout m = null;
    private LinearLayout n = null;
    private TextView o = null;

    public static void a(Activity activity, WriteData writeData, int i) {
        if (writeData != null) {
            Intent intent = new Intent(activity, VcodeActivity.class);
            intent.putExtra("model", writeData);
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, WriteData writeData, boolean z, int i) {
        if (writeData != null) {
            Intent intent = new Intent(activity, VcodeActivity.class);
            intent.putExtra("model", writeData);
            intent.putExtra("is_ad", z);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        b();
        a(bundle);
        c(this.f1865a.getVcodeUrl());
    }

    private void a(Bundle bundle) {
        this.l = new n(this);
        if (bundle != null) {
            this.f1865a = (WriteData) bundle.getSerializable("model");
        } else {
            this.f1865a = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.k = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.f != null) {
            this.f.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.f1865a);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        int i2;
        super.a(i);
        com.baidu.tieba.util.ah.a(this.m, i);
        com.baidu.tieba.util.ah.d(this.n, i);
        com.baidu.tieba.util.ah.a(this.b, i);
        com.baidu.tieba.util.ah.g((TextView) this.c, i);
        if (i == 1) {
            i2 = com.baidu.tieba.util.ah.a(i);
        } else {
            i2 = -12895429;
        }
        this.o.setTextColor(i2);
    }

    private void b() {
        this.m = (RelativeLayout) findViewById(R.id.parent);
        this.n = (LinearLayout) findViewById(R.id.title);
        this.o = (TextView) findViewById(R.id.info);
        this.b = (ImageView) findViewById(R.id.back);
        this.b.setOnClickListener(new o(this));
        this.c = (Button) findViewById(R.id.post);
        this.c.setOnClickListener(new p(this));
        this.e = (EditText) findViewById(R.id.input);
        this.d = (ImageView) findViewById(R.id.vcode_image);
        this.d.setImageBitmap(null);
        this.d.setOnClickListener(new q(this));
        this.f = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.j != null) {
            this.j.cancel();
        }
        this.f.setVisibility(0);
        this.d.setImageBitmap(null);
        this.j = new r(this, null);
        this.j.setPriority(3);
        this.j.execute(str);
    }
}

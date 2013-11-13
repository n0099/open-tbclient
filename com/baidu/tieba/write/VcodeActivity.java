package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class VcodeActivity extends com.baidu.tieba.j {
    private WriteData b = null;
    private ImageView c = null;
    private TextView d = null;
    private ImageView e = null;
    private EditText f = null;
    private ProgressBar g = null;
    private s h = null;
    private r i = null;
    private InputMethodManager j = null;
    private DialogInterface.OnCancelListener k = null;
    private RelativeLayout l = null;
    private TextView m = null;

    /* renamed from: a  reason: collision with root package name */
    protected NavigationBar f2669a = null;
    private View.OnClickListener n = new o(this);
    private View.OnClickListener o = new p(this);

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
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        a();
        a(bundle);
        a(this.b.getVcodeUrl());
    }

    private void a(Bundle bundle) {
        this.k = new n(this);
        if (bundle != null) {
            this.b = (WriteData) bundle.getSerializable("model");
        } else {
            this.b = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.j = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.cancel();
        }
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.b);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        bd.a(this.l, i);
        this.f2669a.c(i);
        bd.h(this.d, i);
        if (i == 1) {
            i2 = bd.a(i);
        } else {
            i2 = -12895429;
        }
        this.m.setTextColor(i2);
    }

    private void a() {
        this.l = (RelativeLayout) findViewById(R.id.parent);
        this.f2669a = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.m = (TextView) findViewById(R.id.info);
        this.c = this.f2669a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.n);
        this.d = this.f2669a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.o);
        this.f = (EditText) findViewById(R.id.input);
        this.e = (ImageView) findViewById(R.id.vcode_image);
        this.e.setImageBitmap(null);
        this.e.setOnClickListener(new q(this));
        this.g = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.i != null) {
            this.i.cancel();
        }
        this.g.setVisibility(0);
        this.e.setImageBitmap(null);
        this.i = new r(this, null);
        this.i.setPriority(3);
        this.i.execute(str);
    }
}

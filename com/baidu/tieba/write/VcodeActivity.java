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
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class VcodeActivity extends com.baidu.tieba.f {
    private WriteData b = null;
    private TextView c = null;
    private ImageView d = null;
    private EditText e = null;
    private ProgressBar f = null;
    private ao g = null;
    private an h = null;
    private InputMethodManager i = null;
    private DialogInterface.OnCancelListener j = null;
    private RelativeLayout k = null;
    private TextView l = null;
    protected NavigationBar a = null;
    private final View.OnClickListener m = new aj(this);
    private final View.OnClickListener n = new ak(this);

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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        a();
        a(bundle);
        a(this.b.getVcodeUrl());
    }

    private void a(Bundle bundle) {
        this.j = new al(this);
        if (bundle != null) {
            this.b = (WriteData) bundle.getSerializable("model");
        } else {
            this.b = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.i = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.h != null) {
            this.h.cancel();
        }
        if (this.f != null) {
            this.f.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.b);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tieba.util.bq.a(this.k, i);
        this.a.c(i);
        com.baidu.tieba.util.bq.h(this.c, i);
        if (i == 1) {
            i2 = com.baidu.tieba.util.bq.a(i);
        } else {
            i2 = -12895429;
        }
        this.l.setTextColor(i2);
    }

    private void a() {
        this.k = (RelativeLayout) findViewById(R.id.parent);
        this.a = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.l = (TextView) findViewById(R.id.info);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.m);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.n);
        this.e = (EditText) findViewById(R.id.input);
        this.d = (ImageView) findViewById(R.id.vcode_image);
        this.d.setImageBitmap(null);
        this.d.setOnClickListener(new am(this));
        this.f = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.h != null) {
            this.h.cancel();
        }
        this.f.setVisibility(0);
        this.d.setImageBitmap(null);
        this.h = new an(this, null);
        this.h.setPriority(3);
        this.h.execute(str);
    }
}

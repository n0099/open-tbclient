package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class VcodeActivity extends com.baidu.tbadk.a {
    private WriteData b = null;
    private TextView c = null;
    private ImageView d = null;
    private EditText e = null;
    private ProgressBar f = null;
    private af g = null;
    private ae h = null;
    private InputMethodManager i = null;
    private DialogInterface.OnCancelListener j = null;
    private RelativeLayout k = null;
    private TextView l = null;
    protected NavigationBar a = null;
    private final View.OnClickListener m = new aa(this);
    private final View.OnClickListener n = new ab(this);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.au.class, VcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.vcode_activity);
        this.k = (RelativeLayout) findViewById(com.baidu.tieba.a.h.parent);
        this.a = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.l = (TextView) findViewById(com.baidu.tieba.a.h.info);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.m);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.a.k.send), this.n);
        this.e = (EditText) findViewById(com.baidu.tieba.a.h.input);
        this.d = (ImageView) findViewById(com.baidu.tieba.a.h.vcode_image);
        this.d.setImageBitmap(null);
        this.d.setOnClickListener(new ad(this));
        this.f = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
        this.j = new ac(this);
        if (bundle != null) {
            this.b = (WriteData) bundle.getSerializable("model");
        } else {
            this.b = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.i = (InputMethodManager) getSystemService("input_method");
        a(this.b.getVcodeUrl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ba.a(this.k, i);
        this.a.b(i);
        com.baidu.tbadk.core.util.ba.g(this.c, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.ba.a(i);
        } else {
            i2 = -12895429;
        }
        this.l.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.h != null) {
            this.h.cancel();
        }
        this.f.setVisibility(0);
        this.d.setImageBitmap(null);
        this.h = new ae(this, (byte) 0);
        this.h.setPriority(3);
        this.h.execute(str);
    }
}

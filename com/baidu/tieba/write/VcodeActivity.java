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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity {
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
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.bg.class, VcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.vcode_activity);
        a();
        a(bundle);
        a(this.b.getVcodeUrl());
    }

    private void a(Bundle bundle) {
        this.j = new ac(this);
        if (bundle != null) {
            this.b = (WriteData) bundle.getSerializable("model");
        } else {
            this.b = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.i = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.bc.a(this.k, i);
        this.a.c(i);
        com.baidu.tbadk.core.util.bc.g(this.c, i);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.bc.a(i);
        } else {
            i2 = -12895429;
        }
        this.l.setTextColor(i2);
    }

    private void a() {
        this.k = (RelativeLayout) findViewById(com.baidu.tieba.r.parent);
        this.a = (NavigationBar) findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.l = (TextView) findViewById(com.baidu.tieba.r.info);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.m);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.u.send), this.n);
        this.e = (EditText) findViewById(com.baidu.tieba.r.input);
        this.d = (ImageView) findViewById(com.baidu.tieba.r.vcode_image);
        this.d.setImageBitmap(null);
        this.d.setOnClickListener(new ad(this));
        this.f = (ProgressBar) findViewById(com.baidu.tieba.r.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.h != null) {
            this.h.cancel();
        }
        this.f.setVisibility(0);
        this.d.setImageBitmap(null);
        this.h = new ae(this, null);
        this.h.setPriority(3);
        this.h.execute(str);
    }
}

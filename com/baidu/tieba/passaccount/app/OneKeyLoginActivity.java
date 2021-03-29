package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tieba.R;
import d.b.i0.a2.b.a;
import d.b.i0.a2.b.b;
import d.b.i0.a2.b.c;
import d.b.i0.a2.b.d;
import d.b.i0.a2.b.e;
import d.b.i0.a2.b.f;
import d.b.i0.a2.b.g;
/* loaded from: classes3.dex */
public class OneKeyLoginActivity extends BaseActivity {
    public a controller;
    public c oneKeyLoginData;
    public String shareModelJSONStr;
    public b view;

    private void initData() {
        this.shareModelJSONStr = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
        c cVar = new c();
        this.oneKeyLoginData = cVar;
        cVar.f51922a = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
        this.oneKeyLoginData.f51923b = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
        this.oneKeyLoginData.f51924c = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
        this.oneKeyLoginData.f51925d = this.shareModelJSONStr;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25061) {
            this.controller.c(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.view.a(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_one_key_login);
        View findViewById = findViewById(R.id.root_view);
        initData();
        if (TextUtils.isEmpty(this.shareModelJSONStr)) {
            this.view = new e(getPageContext(), findViewById);
            this.controller = new d(getPageContext(), this.view);
        } else {
            this.view = new g(getPageContext(), findViewById);
            this.controller = new f(getPageContext(), this.view);
        }
        this.view.c(this.oneKeyLoginData);
        this.controller.j(this.oneKeyLoginData);
        this.controller.i(false);
        this.controller.k(d.b.h0.b.d.k());
    }
}

package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tieba.R;
import d.a.n0.c2.b.a;
import d.a.n0.c2.b.b;
import d.a.n0.c2.b.c;
import d.a.n0.c2.b.d;
import d.a.n0.c2.b.e;
import d.a.n0.c2.b.f;
import d.a.n0.c2.b.g;
/* loaded from: classes4.dex */
public class OneKeyLoginActivity extends BaseActivity {
    public a controller;
    public c oneKeyLoginData;
    public String shareModelJSONStr;
    public b view;

    private void initData() {
        this.shareModelJSONStr = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
        c cVar = new c();
        this.oneKeyLoginData = cVar;
        cVar.f52370a = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
        this.oneKeyLoginData.f52371b = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
        this.oneKeyLoginData.f52372c = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
        this.oneKeyLoginData.f52373d = this.shareModelJSONStr;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 25061) {
            this.controller.c(i3);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.view.a(i2);
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
        this.controller.k(d.a.m0.b.d.l());
    }
}

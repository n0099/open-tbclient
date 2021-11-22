package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import b.a.r0.i2.b.a;
import b.a.r0.i2.b.b;
import b.a.r0.i2.b.c;
import b.a.r0.i2.b.d;
import b.a.r0.i2.b.e;
import b.a.r0.i2.b.f;
import b.a.r0.i2.b.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class OneKeyLoginActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a controller;
    public c oneKeyLoginData;
    public String shareModelJSONStr;
    public b view;

    public OneKeyLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.shareModelJSONStr = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
            c cVar = new c();
            this.oneKeyLoginData = cVar;
            cVar.f19398a = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
            this.oneKeyLoginData.f19399b = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
            this.oneKeyLoginData.f19400c = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
            this.oneKeyLoginData.f19401d = this.shareModelJSONStr;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25061) {
                this.controller.c(i3);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.view.a(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
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
            this.controller.k(b.a.q0.b.d.o());
        }
    }
}

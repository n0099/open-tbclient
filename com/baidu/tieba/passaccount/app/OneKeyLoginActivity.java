package com.baidu.tieba.passaccount.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rn7;
import com.repackage.sn7;
import com.repackage.tn7;
import com.repackage.un7;
import com.repackage.vn7;
import com.repackage.wn7;
import com.repackage.xn7;
/* loaded from: classes3.dex */
public class OneKeyLoginActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rn7 controller;
    public tn7 oneKeyLoginData;
    public String shareModelJSONStr;

    /* renamed from: view  reason: collision with root package name */
    public sn7 f1009view;

    public OneKeyLoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.shareModelJSONStr = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
            tn7 tn7Var = new tn7();
            this.oneKeyLoginData = tn7Var;
            tn7Var.a = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
            this.oneKeyLoginData.b = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
            this.oneKeyLoginData.c = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
            this.oneKeyLoginData.d = this.shareModelJSONStr;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 25061) {
                this.controller.c(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.f1009view.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0045);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091adb);
            initData();
            if (TextUtils.isEmpty(this.shareModelJSONStr)) {
                this.f1009view = new vn7(getPageContext(), findViewById);
                this.controller = new un7(getPageContext(), this.f1009view);
            } else {
                this.f1009view = new xn7(getPageContext(), findViewById);
                this.controller = new wn7(getPageContext(), this.f1009view);
            }
            this.f1009view.c(this.oneKeyLoginData);
            this.controller.j(this.oneKeyLoginData);
            this.controller.i(false);
            this.controller.k(UbsABTestHelper.isFirstLoginTestB());
        }
    }
}

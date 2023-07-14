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
import com.baidu.tieba.dd9;
import com.baidu.tieba.ed9;
import com.baidu.tieba.fd9;
import com.baidu.tieba.gd9;
import com.baidu.tieba.hd9;
import com.baidu.tieba.id9;
import com.baidu.tieba.jd9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class OneKeyLoginActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public fd9 b;
    public ed9 c;
    public dd9 d;

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

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = getIntent().getStringExtra(LoginDialogActivityConfig.SHARE_MODEL_JSON_STRING);
            fd9 fd9Var = new fd9();
            this.b = fd9Var;
            fd9Var.a = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_ENCRYPT_PHONE_NUM);
            this.b.b = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_OPERATOR);
            this.b.c = getIntent().getStringExtra(LoginDialogActivityConfig.ONE_KEY_LOGIN_SIGN);
            this.b.d = this.a;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 25061) {
                this.d.c(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            this.c.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0049);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091f6a);
            initData();
            if (TextUtils.isEmpty(this.a)) {
                this.c = new hd9(getPageContext(), findViewById);
                this.d = new gd9(getPageContext(), this.c);
            } else {
                this.c = new jd9(getPageContext(), findViewById);
                this.d = new id9(getPageContext(), this.c);
            }
            this.c.c(this.b);
            this.d.j(this.b);
            this.d.i(false);
            this.d.k(UbsABTestHelper.isFirstLoginTestB());
        }
    }
}

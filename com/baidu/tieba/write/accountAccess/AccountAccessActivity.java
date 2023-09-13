package com.baidu.tieba.write.accountAccess;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.nza;
import com.baidu.tieba.oza;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AccountAccessActivity extends BaseActivity<AccountAccessActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public transient /* synthetic */ FieldHolder $fh;
    public oza a;
    public nza b;
    public NewWriteModel c;
    public AccessState d;
    public WriteData e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797208937, "Lcom/baidu/tieba/write/accountAccess/AccountAccessActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-797208937, "Lcom/baidu/tieba/write/accountAccess/AccountAccessActivity;");
                return;
            }
        }
        f = TbConfig.TIEBA_ADDRESS + "mo/q/account/access";
        g = TbConfig.TIEBA_ADDRESS + "account/access/cancel";
        h = TbConfig.TIEBA_ADDRESS + "account/access/input_focus";
        i = TbConfig.TIEBA_ADDRESS + "account/access/valid_success";
        j = TbConfig.TIEBA_ADDRESS + "account/access/feedback";
        k = TbConfig.TIEBA_ADDRESS + "account/access/feedback";
    }

    public AccountAccessActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.a.k();
        }
    }

    public String o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AccessState accessState = this.d;
            if (accessState != null && accessState.getUserInfo() != null) {
                return String.format("%s?token=%s&type=%s&strMobile=%s&strEmail=%s", f, this.d.getToken(), this.d.getType(), this.d.getUserInfo().strMobile, this.d.getUserInfo().strEmail);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 12006) {
                    setResult(-1, intent);
                }
            } else if (i3 == 0 && i2 == 12006) {
                setResult(0, intent);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new oza(this);
            Intent intent = getIntent();
            if (intent == null) {
                return;
            }
            this.d = (AccessState) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_ACCESS_STATE);
            WriteData writeData = (WriteData) intent.getSerializableExtra(AccountAccessActivityConfig.KEY_WRITE_DATA);
            this.e = writeData;
            if (writeData != null && this.d != null) {
                NewWriteModel newWriteModel = new NewWriteModel(this);
                this.c = newWriteModel;
                newWriteModel.setWriteData(this.e);
                if (this.e.getWriteImagesInfo() != null) {
                    NewWriteModel newWriteModel2 = this.c;
                    if (this.e.getWriteImagesInfo().size() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    newWriteModel2.i0(z);
                }
                nza nzaVar = new nza(this.a, this.c);
                this.b = nzaVar;
                this.a.l(nzaVar);
                this.b.h(o1());
                return;
            }
            finish();
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jt9 extends gt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jt9 a;

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        public a(jt9 jt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jt9Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
                this.a.f();
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.b.closeLoadingDialog();
                BaseActivity baseActivity = this.a.b;
                baseActivity.showToast(String.format(baseActivity.getString(R.string.obfuscated_res_0x7f0f0f31), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jt9(TbPageContext tbPageContext, ht9 ht9Var) {
        super(tbPageContext, ht9Var, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ht9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ht9) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.gt9
    public void j(it9 it9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, it9Var) == null) {
            this.e = it9Var;
        }
    }

    @Override // com.baidu.tieba.gt9
    public void n(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.n(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f091733) {
                s();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091af2) {
                t();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09018b) {
                r();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091e35) {
                u();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BaseActivity baseActivity = this.b;
            BrowserHelper.startWebActivity((Context) baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0f28), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
            PassportSDK passportSDK = PassportSDK.getInstance();
            BaseActivity baseActivity = this.b;
            passportSDK.loadOneKeyLogin(baseActivity, ot9.j(baseActivity, this.e.c), new a(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BaseActivity baseActivity = this.b;
            BrowserHelper.startWebActivity((Context) baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0f2c), "http://privacy.baidu.com/mdetail?id=288", false);
        }
    }

    public final void t() {
        it9 it9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (it9Var = this.e) == null) {
            return;
        }
        int a2 = it9Var.a();
        if (a2 != 1) {
            if (a2 != 2) {
                if (a2 == 3) {
                    BaseActivity baseActivity = this.b;
                    BrowserHelper.startWebActivity((Context) baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0f2b), "https://wap.cmpassport.com/resources/html/contract.html", false);
                    return;
                }
                return;
            }
            BaseActivity baseActivity2 = this.b;
            BrowserHelper.startWebActivity((Context) baseActivity2, baseActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0f2a), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false);
            return;
        }
        BaseActivity baseActivity3 = this.b;
        BrowserHelper.startWebActivity((Context) baseActivity3, baseActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0f29), "https://ms.zzx9.cn/html/oauth/protocol2.html", false);
    }
}

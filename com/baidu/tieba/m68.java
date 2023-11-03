package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.dto.AccountToolsDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.searchbox.yy.gameassist.interfaces.LoginModifyPwdServices;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* loaded from: classes7.dex */
public class m68 implements LoginModifyPwdServices {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements AccountToolsCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function1 a;

        public a(m68 m68Var, Function1 function1) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m68Var, function1};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function1;
        }

        @Override // com.baidu.sapi2.callback.SapiWebCallback
        public void onFinish(SapiResult sapiResult) {
            Function1 function1;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) && (function1 = this.a) != null) {
                function1.invoke(sapiResult.getResultMsg());
            }
        }
    }

    public m68() {
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

    @Override // com.baidu.searchbox.yy.gameassist.interfaces.LoginModifyPwdServices
    public void openModifyPwd(@NonNull Context context, @Nullable Function1<? super String, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, function1) == null) {
            AccountToolsDTO accountToolsDTO = new AccountToolsDTO();
            accountToolsDTO.context = context;
            accountToolsDTO.toolsType = 5;
            if (!SapiAccountManager.getInstance().isLogin()) {
                ToastUtil.show(R.string.obfuscated_res_0x7f0f1122 + "");
                return;
            }
            PassportSDK.getInstance().loadAccountTools(accountToolsDTO, new a(this, function1));
        }
    }
}

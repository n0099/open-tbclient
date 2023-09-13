package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class ob4 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String c;

    public abstract boolean k(@NonNull rb4 rb4Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ob4(ec3 ec3Var, String str, String str2) {
        super(ec3Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = str2;
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            qa2 U = uw2.T().U();
            if (U == null) {
                h82.c(this.c, "fragment manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            sb4 sb4Var = (sb4) U.n(e74.class);
            if (sb4Var == null) {
                h82.c(this.c, "fragment is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            return k(sb4Var.b(), unitedSchemeEntity, callbackHandler);
        }
        return invokeLLLL.booleanValue;
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler) == null) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }
}

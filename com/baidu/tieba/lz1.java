package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lz1 extends iz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lz1(h73 h73Var) {
        super(h73Var, "/swanAPI/canvas/insert");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h73) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            i12 k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                k32.c("SwanAppCanvas", "insert action parse model is null");
                return false;
            } else if (context == null) {
                k32.c("SwanAppCanvas", "context is null");
                unitedSchemeEntity.result = l(1001);
                return false;
            } else {
                String str = k.b;
                qw2 qw2Var = k.h;
                if (!TextUtils.isEmpty(str) && qw2Var != null && qw2Var.h()) {
                    c22 w = new k22(context, k).w();
                    boolean a = w.a();
                    if (!a) {
                        k32.c("SwanAppCanvas", "insert canvas fail: " + w.b);
                    }
                    j(unitedSchemeEntity, callbackHandler, a);
                    return a;
                }
                k32.c("SwanAppCanvas", "canvas id is empty or position is null");
                unitedSchemeEntity.result = l(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}

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
/* loaded from: classes6.dex */
public class t02 extends q02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t02(q83 q83Var) {
        super(q83Var, "/swanAPI/canvas/insert");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((q83) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            q22 k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                t42.c("SwanAppCanvas", "insert action parse model is null");
                return false;
            } else if (context == null) {
                t42.c("SwanAppCanvas", "context is null");
                unitedSchemeEntity.result = l(1001);
                return false;
            } else {
                String str = k.b;
                zx2 zx2Var = k.h;
                if (!TextUtils.isEmpty(str) && zx2Var != null && zx2Var.h()) {
                    k32 insert = new t32(context, k).insert();
                    boolean a = insert.a();
                    if (!a) {
                        t42.c("SwanAppCanvas", "insert canvas fail: " + insert.b);
                    }
                    j(unitedSchemeEntity, callbackHandler, a);
                    return a;
                }
                t42.c("SwanAppCanvas", "canvas id is empty or position is null");
                unitedSchemeEntity.result = l(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}

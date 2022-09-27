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
/* loaded from: classes5.dex */
public class qw1 extends iw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qw1(i43 i43Var) {
        super(i43Var, "/swanAPI/canvas/update");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i43) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            iy1 k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                l02.c("SwanAppCanvas", "update action parse model is null");
                return false;
            }
            String str = k.b;
            rt2 rt2Var = k.h;
            if (!TextUtils.isEmpty(str) && rt2Var != null && rt2Var.h()) {
                lz1 lz1Var = (lz1) yz1.a(k);
                if (lz1Var == null) {
                    l02.c("SwanAppCanvas", "update canvas fail: fina a null component");
                    unitedSchemeEntity.result = l(1001);
                    return false;
                }
                cz1 update = lz1Var.update((lz1) k);
                boolean a = update.a();
                if (!a) {
                    l02.c("SwanAppCanvas", "update canvas fail: " + update.b);
                }
                j(unitedSchemeEntity, callbackHandler, a);
                return a;
            }
            l02.c("SwanAppCanvas", "some params invalid");
            unitedSchemeEntity.result = l(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}

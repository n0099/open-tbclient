package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class iz1 extends k43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iz1(i43 i43Var) {
        super(i43Var, "/swanAPI/button");
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

    @Override // com.baidu.tieba.k43
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/button" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, l33 l33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, l33Var)) == null) {
            if (i53.b) {
                Log.d("Component-Action-Button", "insert");
            }
            jz1 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-Button", "model is null");
                return false;
            }
            cz1 insert = new hz1(context, q).insert();
            boolean a = insert.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, l33 l33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, l33Var)) == null) {
            if (i53.b) {
                Log.d("Component-Action-Button", "remove");
            }
            jz1 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-Button", "model is null");
                return false;
            }
            hz1 hz1Var = (hz1) yz1.a(q);
            if (hz1Var == null) {
                String str2 = "can't find button component:#" + q.b;
                l02.c("Component-Action-Button", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            cz1 B = hz1Var.B();
            boolean a = B.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, l33 l33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, l33Var)) == null) {
            if (i53.b) {
                Log.d("Component-Action-Button", "update");
            }
            jz1 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-Button", "model is null");
                return false;
            }
            hz1 hz1Var = (hz1) yz1.a(q);
            if (hz1Var == null) {
                String str2 = "can't find button component:#" + q.b;
                l02.c("Component-Action-Button", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            cz1 update = hz1Var.update((hz1) q);
            boolean a = update.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final jz1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-Button", "params is null");
                return null;
            }
            jz1 jz1Var = new jz1();
            try {
                jz1Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                l02.d("Component-Action-Button", "model parse exception:", e);
            }
            return jz1Var;
        }
        return (jz1) invokeL.objValue;
    }
}

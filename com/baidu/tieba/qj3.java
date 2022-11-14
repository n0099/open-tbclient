package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qj3 extends e53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.e53
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj3(c53 c53Var) {
        super(c53Var, "/swanAPI/animView");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c53Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c53) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final a02 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                f12.c("SwanAppAction", "params is null");
                return null;
            }
            a02 a02Var = new a02();
            try {
                a02Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                f12.d("SwanAppAction", "model parse exception:", e);
            }
            return a02Var;
        }
        return (a02) invokeL.objValue;
    }

    @Override // com.baidu.tieba.e53
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, f43 f43Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, f43Var)) == null) {
            a02 q = q(unitedSchemeEntity);
            if (q == null) {
                lb3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                f12.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.j()) {
                lb3.b("animView", 1001, "parse insert params, but invalid", 201, "parse insert params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                f12.c("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.t, f43Var);
                if (TextUtils.isEmpty(r)) {
                    lb3.b("animView", 1001, "AnimConfData is invalid", 201, "parse insert params, anim data is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (sp2.U().N()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        lb3.b("animView", 1001, "parse insert params, anim data is not json", 201, "parse insert params, anim data is not json");
                        if (c63.b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                wz1 insert = new zz1(context, q, r).insert();
                boolean a = insert.a();
                f12.i("AbsSwanAppWidget", "insert anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    lb3.b("animView", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "insert anim view, but failure: " + insert.b, 1001, "insert anim view, but failure: " + insert.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
                    f12.c("AbsSwanAppWidget", "insert anim view, but failure: " + insert.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.e53
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, f43 f43Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, f43Var)) == null) {
            a02 q = q(unitedSchemeEntity);
            if (q == null) {
                lb3.b("animView", 1001, "update, model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                f12.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                lb3.b("animView", 1001, "parse update params, but invalid", 201, "parse update params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                f12.c("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                zz1 zz1Var = (zz1) s02.a(q);
                if (zz1Var == null) {
                    lb3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    f12.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                wz1 update = zz1Var.update((zz1) q);
                boolean a = update.a();
                f12.b("AbsSwanAppWidget", "update anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    lb3.b("animView", 2001, "update anim view, but failure: " + update.b, 1001, "update anim view, but failure: " + update.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
                    f12.c("AbsSwanAppWidget", "update anim view, but failure: " + update.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.e53
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, f43 f43Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, f43Var)) == null) {
            a02 q = q(unitedSchemeEntity);
            if (q == null) {
                lb3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                f12.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                lb3.b("animView", 1001, "parse remove params, but invalid", 201, "parse remove params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                f12.c("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                zz1 zz1Var = (zz1) s02.a(q);
                if (zz1Var == null) {
                    lb3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    f12.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                wz1 B = zz1Var.B();
                boolean a = B.a();
                f12.i("AbsSwanAppWidget", "remove anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    lb3.b("animView", 2001, "remove anim view, but failure: " + B.b, 1001, "remove anim view, but failure: " + B.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
                    f12.c("AbsSwanAppWidget", "remove anim view, but failure: " + B.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final String r(String str, f43 f43Var) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, f43Var)) == null) {
            if (!TextUtils.isEmpty(str) && f43Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = nb3.M(str, f43Var.b);
                    } else {
                        L = nb3.L(str, f43Var, f43Var.k0());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (!jk4.y(file)) {
                        return null;
                    }
                    return jk4.E(file);
                } catch (Exception e) {
                    if (c63.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}

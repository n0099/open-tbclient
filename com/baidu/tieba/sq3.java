package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
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
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class sq3 extends gc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gc3
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/animView");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ec3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final c72 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("SwanAppAction", "params is null");
                return null;
            }
            c72 c72Var = new c72();
            try {
                c72Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                h82.d("SwanAppAction", "model parse exception:", e);
            }
            return c72Var;
        }
        return (c72) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gc3
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            c72 q = q(unitedSchemeEntity);
            if (q == null) {
                ni3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.j()) {
                ni3.b("animView", 1001, "parse insert params, but invalid", 201, "parse insert params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.t, hb3Var);
                if (TextUtils.isEmpty(r)) {
                    ni3.b("animView", 1001, "AnimConfData is invalid", 201, "parse insert params, anim data is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (uw2.T().M()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        ni3.b("animView", 1001, "parse insert params, anim data is not json", 201, "parse insert params, anim data is not json");
                        if (ed3.b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                y62 insert = new b72(context, q, r).insert();
                boolean a = insert.a();
                h82.i("AbsSwanAppWidget", "insert anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    ni3.b("animView", 2009, "insert anim view, but failure: " + insert.b, 1001, "insert anim view, but failure: " + insert.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
                    h82.c("AbsSwanAppWidget", "insert anim view, but failure: " + insert.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.gc3
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            c72 q = q(unitedSchemeEntity);
            if (q == null) {
                ni3.b("animView", 1001, "update, model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                ni3.b("animView", 1001, "parse update params, but invalid", 201, "parse update params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                b72 b72Var = (b72) u72.a(q);
                if (b72Var == null) {
                    ni3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    h82.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                y62 update = b72Var.update((b72) q);
                boolean a = update.a();
                h82.b("AbsSwanAppWidget", "update anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    ni3.b("animView", 2001, "update anim view, but failure: " + update.b, 1001, "update anim view, but failure: " + update.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
                    h82.c("AbsSwanAppWidget", "update anim view, but failure: " + update.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.gc3
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            c72 q = q(unitedSchemeEntity);
            if (q == null) {
                ni3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                ni3.b("animView", 1001, "parse remove params, but invalid", 201, "parse remove params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                b72 b72Var = (b72) u72.a(q);
                if (b72Var == null) {
                    ni3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    h82.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                y62 B = b72Var.B();
                boolean a = B.a();
                h82.i("AbsSwanAppWidget", "remove anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    ni3.b("animView", 2001, "remove anim view, but failure: " + B.b, 1001, "remove anim view, but failure: " + B.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
                    h82.c("AbsSwanAppWidget", "remove anim view, but failure: " + B.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final String r(String str, hb3 hb3Var) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hb3Var)) == null) {
            if (!TextUtils.isEmpty(str) && hb3Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = pi3.M(str, hb3Var.b);
                    } else {
                        L = pi3.L(str, hb3Var, hb3Var.k0());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (!lr4.y(file)) {
                        return null;
                    }
                    return lr4.E(file);
                } catch (Exception e) {
                    if (ed3.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}

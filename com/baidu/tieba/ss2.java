package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ss2 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ss2(h73 h73Var) {
        super(h73Var, "/swanAPI/map");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
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
            if (h83.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.h83
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, k63 k63Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, k63Var)) == null) {
            if (h83.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            k32.i("map", "handleSubAction " + str);
            ts2 a = ts2.a(unitedSchemeEntity, callbackHandler);
            char c = 65535;
            switch (str.hashCode()) {
                case -2079680864:
                    if (str.equals("/swanAPI/map/translateMarker")) {
                        c = 3;
                        break;
                    }
                    break;
                case -2068557416:
                    if (str.equals("/swanAPI/map/getCenterLocation")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -398143716:
                    if (str.equals("/swanAPI/map/getScale")) {
                        c = 7;
                        break;
                    }
                    break;
                case 51993511:
                    if (str.equals("/swanAPI/map/openLocation")) {
                        c = 4;
                        break;
                    }
                    break;
                case 379323012:
                    if (str.equals("/swanAPI/map/create")) {
                        c = 0;
                        break;
                    }
                    break;
                case 515840866:
                    if (str.equals("/swanAPI/map/getRegion")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 797006348:
                    if (str.equals("/swanAPI/map/remove")) {
                        c = 2;
                        break;
                    }
                    break;
                case 892770897:
                    if (str.equals("/swanAPI/map/update")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1007473955:
                    if (str.equals("/swanAPI/map/includePoints")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1142165295:
                    if (str.equals("/swanAPI/map/openWalkNavigation")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1256916873:
                    if (str.equals("/swanAPI/map/moveToLocation")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1475857524:
                    if (str.equals("/swanAPI/map/chooseLocation")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    ws2 j = j(unitedSchemeEntity, ws2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return rp2.J().g(context, j, a, k63Var);
                case 1:
                    ws2 j2 = j(unitedSchemeEntity, ws2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return rp2.J().o(context, j2, a, k63Var);
                case 2:
                    ws2 j3 = j(unitedSchemeEntity, ws2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return rp2.J().l(context, j3, a, k63Var);
                case 3:
                    zs2 zs2Var = (zs2) j(unitedSchemeEntity, zs2.class);
                    if (k(zs2Var, a)) {
                        return false;
                    }
                    return rp2.J().j(context, zs2Var, a, k63Var);
                case 4:
                    ys2 ys2Var = (ys2) j(unitedSchemeEntity, ys2.class);
                    if (k(ys2Var, a)) {
                        return false;
                    }
                    return rp2.J().h(context, ys2Var, a, k63Var);
                case 5:
                    ws2 j4 = j(unitedSchemeEntity, ws2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return rp2.J().m(context, j4, a, k63Var);
                case 6:
                    vs2 vs2Var = (vs2) j(unitedSchemeEntity, vs2.class);
                    if (k(vs2Var, a)) {
                        return false;
                    }
                    return rp2.J().b(context, vs2Var, a, k63Var);
                case 7:
                    ws2 j5 = j(unitedSchemeEntity, ws2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return rp2.J().c(context, j5, a, k63Var);
                case '\b':
                    ws2 j6 = j(unitedSchemeEntity, ws2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return rp2.J().n(context, j6, a, k63Var);
                case '\t':
                    ws2 j7 = j(unitedSchemeEntity, ws2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return rp2.J().k(context, j7, a, k63Var);
                case '\n':
                    us2 us2Var = (us2) j(unitedSchemeEntity, us2.class);
                    if (k(us2Var, a)) {
                        return false;
                    }
                    return rp2.J().e(context, us2Var, a, k63Var);
                case 11:
                    at2 at2Var = (at2) j(unitedSchemeEntity, at2.class);
                    if (k(at2Var, a)) {
                        return false;
                    }
                    return rp2.J().a(context, at2Var, a, k63Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, k63Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends ws2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        T newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, cls)) == null) {
            T t = null;
            if (unitedSchemeEntity == null) {
                return null;
            }
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            if (params != null && !params.isEmpty()) {
                String str = params.get("params");
                if (str == null) {
                    k32.c("map", "params string is empty");
                    return null;
                }
                try {
                    jSONObject = new JSONObject(str);
                    newInstance = cls.newInstance();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    newInstance.a(jSONObject);
                    return newInstance;
                } catch (Exception e2) {
                    e = e2;
                    t = newInstance;
                    e.printStackTrace();
                    k32.c("map", "params json parse error");
                    return t;
                }
            }
            k32.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(ws2 ws2Var, ts2 ts2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ws2Var, ts2Var)) == null) {
            if (ws2Var == null) {
                k32.c("map", "parse error, model is null");
                ts2Var.d(202);
                return true;
            }
            if (j63.K().q().z0()) {
                ws2Var.c = cm3.c().h();
            }
            if (TextUtils.isEmpty(ws2Var.c)) {
                String B = ek3.B();
                if (!TextUtils.isEmpty(B)) {
                    ws2Var.c = B;
                }
                k32.o("map", "webView id is empty, use current webView");
            }
            if (ek3.m(ws2Var.c) == null) {
                ts2Var.d(202);
                k32.c("map", "can not find weiView by id " + ws2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

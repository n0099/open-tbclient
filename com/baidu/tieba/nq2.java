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
/* loaded from: classes5.dex */
public class nq2 extends c63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nq2(c53 c53Var) {
        super(c53Var, "/swanAPI/map");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.c63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, f43Var)) == null) {
            if (c63.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.c63
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, f43 f43Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, f43Var)) == null) {
            if (c63.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            f12.i("map", "handleSubAction " + str);
            oq2 a = oq2.a(unitedSchemeEntity, callbackHandler);
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
                    rq2 j = j(unitedSchemeEntity, rq2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return mn2.J().g(context, j, a, f43Var);
                case 1:
                    rq2 j2 = j(unitedSchemeEntity, rq2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return mn2.J().update(context, j2, a, f43Var);
                case 2:
                    rq2 j3 = j(unitedSchemeEntity, rq2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return mn2.J().l(context, j3, a, f43Var);
                case 3:
                    uq2 uq2Var = (uq2) j(unitedSchemeEntity, uq2.class);
                    if (k(uq2Var, a)) {
                        return false;
                    }
                    return mn2.J().j(context, uq2Var, a, f43Var);
                case 4:
                    tq2 tq2Var = (tq2) j(unitedSchemeEntity, tq2.class);
                    if (k(tq2Var, a)) {
                        return false;
                    }
                    return mn2.J().h(context, tq2Var, a, f43Var);
                case 5:
                    rq2 j4 = j(unitedSchemeEntity, rq2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return mn2.J().m(context, j4, a, f43Var);
                case 6:
                    qq2 qq2Var = (qq2) j(unitedSchemeEntity, qq2.class);
                    if (k(qq2Var, a)) {
                        return false;
                    }
                    return mn2.J().b(context, qq2Var, a, f43Var);
                case 7:
                    rq2 j5 = j(unitedSchemeEntity, rq2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return mn2.J().c(context, j5, a, f43Var);
                case '\b':
                    rq2 j6 = j(unitedSchemeEntity, rq2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return mn2.J().n(context, j6, a, f43Var);
                case '\t':
                    rq2 j7 = j(unitedSchemeEntity, rq2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return mn2.J().k(context, j7, a, f43Var);
                case '\n':
                    pq2 pq2Var = (pq2) j(unitedSchemeEntity, pq2.class);
                    if (k(pq2Var, a)) {
                        return false;
                    }
                    return mn2.J().e(context, pq2Var, a, f43Var);
                case 11:
                    vq2 vq2Var = (vq2) j(unitedSchemeEntity, vq2.class);
                    if (k(vq2Var, a)) {
                        return false;
                    }
                    return mn2.J().a(context, vq2Var, a, f43Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, f43Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends rq2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    f12.c("map", "params string is empty");
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
                    f12.c("map", "params json parse error");
                    return t;
                }
            }
            f12.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(rq2 rq2Var, oq2 oq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, rq2Var, oq2Var)) == null) {
            if (rq2Var == null) {
                f12.c("map", "parse error, model is null");
                oq2Var.d(202);
                return true;
            }
            if (e43.K().q().y0()) {
                rq2Var.c = xj3.c().h();
            }
            if (TextUtils.isEmpty(rq2Var.c)) {
                String B = zh3.B();
                if (!TextUtils.isEmpty(B)) {
                    rq2Var.c = B;
                }
                f12.o("map", "webView id is empty, use current webView");
            }
            if (zh3.m(rq2Var.c) == null) {
                oq2Var.d(202);
                f12.c("map", "can not find weiView by id " + rq2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

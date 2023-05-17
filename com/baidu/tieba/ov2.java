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
/* loaded from: classes6.dex */
public class ov2 extends db3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ov2(da3 da3Var) {
        super(da3Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {da3Var};
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

    @Override // com.baidu.tieba.db3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g93Var)) == null) {
            if (db3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.db3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, g93 g93Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, g93Var)) == null) {
            if (db3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            g62.i("map", "handleSubAction " + str);
            pv2 a = pv2.a(unitedSchemeEntity, callbackHandler);
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
                    sv2 j = j(unitedSchemeEntity, sv2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return ns2.J().g(context, j, a, g93Var);
                case 1:
                    sv2 j2 = j(unitedSchemeEntity, sv2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return ns2.J().update(context, j2, a, g93Var);
                case 2:
                    sv2 j3 = j(unitedSchemeEntity, sv2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return ns2.J().l(context, j3, a, g93Var);
                case 3:
                    vv2 vv2Var = (vv2) j(unitedSchemeEntity, vv2.class);
                    if (k(vv2Var, a)) {
                        return false;
                    }
                    return ns2.J().j(context, vv2Var, a, g93Var);
                case 4:
                    uv2 uv2Var = (uv2) j(unitedSchemeEntity, uv2.class);
                    if (k(uv2Var, a)) {
                        return false;
                    }
                    return ns2.J().h(context, uv2Var, a, g93Var);
                case 5:
                    sv2 j4 = j(unitedSchemeEntity, sv2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return ns2.J().m(context, j4, a, g93Var);
                case 6:
                    rv2 rv2Var = (rv2) j(unitedSchemeEntity, rv2.class);
                    if (k(rv2Var, a)) {
                        return false;
                    }
                    return ns2.J().b(context, rv2Var, a, g93Var);
                case 7:
                    sv2 j5 = j(unitedSchemeEntity, sv2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return ns2.J().c(context, j5, a, g93Var);
                case '\b':
                    sv2 j6 = j(unitedSchemeEntity, sv2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return ns2.J().n(context, j6, a, g93Var);
                case '\t':
                    sv2 j7 = j(unitedSchemeEntity, sv2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return ns2.J().k(context, j7, a, g93Var);
                case '\n':
                    qv2 qv2Var = (qv2) j(unitedSchemeEntity, qv2.class);
                    if (k(qv2Var, a)) {
                        return false;
                    }
                    return ns2.J().e(context, qv2Var, a, g93Var);
                case 11:
                    wv2 wv2Var = (wv2) j(unitedSchemeEntity, wv2.class);
                    if (k(wv2Var, a)) {
                        return false;
                    }
                    return ns2.J().a(context, wv2Var, a, g93Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, g93Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends sv2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    g62.c("map", "params string is empty");
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
                    g62.c("map", "params json parse error");
                    return t;
                }
            }
            g62.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(sv2 sv2Var, pv2 pv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sv2Var, pv2Var)) == null) {
            if (sv2Var == null) {
                g62.c("map", "parse error, model is null");
                pv2Var.d(202);
                return true;
            }
            if (f93.K().q().y0()) {
                sv2Var.c = yo3.c().h();
            }
            if (TextUtils.isEmpty(sv2Var.c)) {
                String B = an3.B();
                if (!TextUtils.isEmpty(B)) {
                    sv2Var.c = B;
                }
                g62.o("map", "webView id is empty, use current webView");
            }
            if (an3.m(sv2Var.c) == null) {
                pv2Var.d(202);
                g62.c("map", "can not find weiView by id " + sv2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

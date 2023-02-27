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
public class uv2 extends jb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uv2(ja3 ja3Var) {
        super(ja3Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ja3Var};
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

    @Override // com.baidu.tieba.jb3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, m93Var)) == null) {
            if (jb3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.jb3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, m93 m93Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, m93Var)) == null) {
            if (jb3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            m62.i("map", "handleSubAction " + str);
            vv2 a = vv2.a(unitedSchemeEntity, callbackHandler);
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
                    yv2 j = j(unitedSchemeEntity, yv2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return ts2.J().g(context, j, a, m93Var);
                case 1:
                    yv2 j2 = j(unitedSchemeEntity, yv2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return ts2.J().update(context, j2, a, m93Var);
                case 2:
                    yv2 j3 = j(unitedSchemeEntity, yv2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return ts2.J().l(context, j3, a, m93Var);
                case 3:
                    bw2 bw2Var = (bw2) j(unitedSchemeEntity, bw2.class);
                    if (k(bw2Var, a)) {
                        return false;
                    }
                    return ts2.J().j(context, bw2Var, a, m93Var);
                case 4:
                    aw2 aw2Var = (aw2) j(unitedSchemeEntity, aw2.class);
                    if (k(aw2Var, a)) {
                        return false;
                    }
                    return ts2.J().h(context, aw2Var, a, m93Var);
                case 5:
                    yv2 j4 = j(unitedSchemeEntity, yv2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return ts2.J().m(context, j4, a, m93Var);
                case 6:
                    xv2 xv2Var = (xv2) j(unitedSchemeEntity, xv2.class);
                    if (k(xv2Var, a)) {
                        return false;
                    }
                    return ts2.J().b(context, xv2Var, a, m93Var);
                case 7:
                    yv2 j5 = j(unitedSchemeEntity, yv2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return ts2.J().c(context, j5, a, m93Var);
                case '\b':
                    yv2 j6 = j(unitedSchemeEntity, yv2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return ts2.J().n(context, j6, a, m93Var);
                case '\t':
                    yv2 j7 = j(unitedSchemeEntity, yv2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return ts2.J().k(context, j7, a, m93Var);
                case '\n':
                    wv2 wv2Var = (wv2) j(unitedSchemeEntity, wv2.class);
                    if (k(wv2Var, a)) {
                        return false;
                    }
                    return ts2.J().e(context, wv2Var, a, m93Var);
                case 11:
                    cw2 cw2Var = (cw2) j(unitedSchemeEntity, cw2.class);
                    if (k(cw2Var, a)) {
                        return false;
                    }
                    return ts2.J().a(context, cw2Var, a, m93Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, m93Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends yv2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    m62.c("map", "params string is empty");
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
                    m62.c("map", "params json parse error");
                    return t;
                }
            }
            m62.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(yv2 yv2Var, vv2 vv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, yv2Var, vv2Var)) == null) {
            if (yv2Var == null) {
                m62.c("map", "parse error, model is null");
                vv2Var.d(202);
                return true;
            }
            if (l93.K().q().y0()) {
                yv2Var.c = ep3.c().h();
            }
            if (TextUtils.isEmpty(yv2Var.c)) {
                String B = gn3.B();
                if (!TextUtils.isEmpty(B)) {
                    yv2Var.c = B;
                }
                m62.o("map", "webView id is empty, use current webView");
            }
            if (gn3.m(yv2Var.c) == null) {
                vv2Var.d(202);
                m62.c("map", "can not find weiView by id " + yv2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

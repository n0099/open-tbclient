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
/* loaded from: classes7.dex */
public class ps2 extends e83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ps2(e73 e73Var) {
        super(e73Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e73Var};
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

    @Override // com.baidu.tieba.e83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h63Var)) == null) {
            if (e83.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.e83
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h63 h63Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, h63Var)) == null) {
            if (e83.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            h32.i("map", "handleSubAction " + str);
            qs2 a = qs2.a(unitedSchemeEntity, callbackHandler);
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
                    ts2 j = j(unitedSchemeEntity, ts2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return op2.J().g(context, j, a, h63Var);
                case 1:
                    ts2 j2 = j(unitedSchemeEntity, ts2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return op2.J().o(context, j2, a, h63Var);
                case 2:
                    ts2 j3 = j(unitedSchemeEntity, ts2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return op2.J().l(context, j3, a, h63Var);
                case 3:
                    ws2 ws2Var = (ws2) j(unitedSchemeEntity, ws2.class);
                    if (k(ws2Var, a)) {
                        return false;
                    }
                    return op2.J().j(context, ws2Var, a, h63Var);
                case 4:
                    vs2 vs2Var = (vs2) j(unitedSchemeEntity, vs2.class);
                    if (k(vs2Var, a)) {
                        return false;
                    }
                    return op2.J().h(context, vs2Var, a, h63Var);
                case 5:
                    ts2 j4 = j(unitedSchemeEntity, ts2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return op2.J().m(context, j4, a, h63Var);
                case 6:
                    ss2 ss2Var = (ss2) j(unitedSchemeEntity, ss2.class);
                    if (k(ss2Var, a)) {
                        return false;
                    }
                    return op2.J().b(context, ss2Var, a, h63Var);
                case 7:
                    ts2 j5 = j(unitedSchemeEntity, ts2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return op2.J().c(context, j5, a, h63Var);
                case '\b':
                    ts2 j6 = j(unitedSchemeEntity, ts2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return op2.J().n(context, j6, a, h63Var);
                case '\t':
                    ts2 j7 = j(unitedSchemeEntity, ts2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return op2.J().k(context, j7, a, h63Var);
                case '\n':
                    rs2 rs2Var = (rs2) j(unitedSchemeEntity, rs2.class);
                    if (k(rs2Var, a)) {
                        return false;
                    }
                    return op2.J().e(context, rs2Var, a, h63Var);
                case 11:
                    xs2 xs2Var = (xs2) j(unitedSchemeEntity, xs2.class);
                    if (k(xs2Var, a)) {
                        return false;
                    }
                    return op2.J().a(context, xs2Var, a, h63Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, h63Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends ts2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    h32.c("map", "params string is empty");
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
                    h32.c("map", "params json parse error");
                    return t;
                }
            }
            h32.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(ts2 ts2Var, qs2 qs2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ts2Var, qs2Var)) == null) {
            if (ts2Var == null) {
                h32.c("map", "parse error, model is null");
                qs2Var.d(202);
                return true;
            }
            if (g63.K().q().z0()) {
                ts2Var.c = zl3.c().h();
            }
            if (TextUtils.isEmpty(ts2Var.c)) {
                String B = bk3.B();
                if (!TextUtils.isEmpty(B)) {
                    ts2Var.c = B;
                }
                h32.o("map", "webView id is empty, use current webView");
            }
            if (bk3.m(ts2Var.c) == null) {
                qs2Var.d(202);
                h32.c("map", "can not find weiView by id " + ts2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

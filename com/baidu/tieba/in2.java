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
/* loaded from: classes4.dex */
public class in2 extends x23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public in2(x13 x13Var) {
        super(x13Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x13Var};
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

    @Override // com.baidu.tieba.x23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, a13Var)) == null) {
            if (x23.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.x23
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, a13 a13Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, a13Var)) == null) {
            if (x23.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            ay1.i("map", "handleSubAction " + str);
            jn2 a = jn2.a(unitedSchemeEntity, callbackHandler);
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
                    mn2 j = j(unitedSchemeEntity, mn2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return hk2.J().g(context, j, a, a13Var);
                case 1:
                    mn2 j2 = j(unitedSchemeEntity, mn2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return hk2.J().update(context, j2, a, a13Var);
                case 2:
                    mn2 j3 = j(unitedSchemeEntity, mn2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return hk2.J().l(context, j3, a, a13Var);
                case 3:
                    pn2 pn2Var = (pn2) j(unitedSchemeEntity, pn2.class);
                    if (k(pn2Var, a)) {
                        return false;
                    }
                    return hk2.J().j(context, pn2Var, a, a13Var);
                case 4:
                    on2 on2Var = (on2) j(unitedSchemeEntity, on2.class);
                    if (k(on2Var, a)) {
                        return false;
                    }
                    return hk2.J().h(context, on2Var, a, a13Var);
                case 5:
                    mn2 j4 = j(unitedSchemeEntity, mn2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return hk2.J().m(context, j4, a, a13Var);
                case 6:
                    ln2 ln2Var = (ln2) j(unitedSchemeEntity, ln2.class);
                    if (k(ln2Var, a)) {
                        return false;
                    }
                    return hk2.J().b(context, ln2Var, a, a13Var);
                case 7:
                    mn2 j5 = j(unitedSchemeEntity, mn2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return hk2.J().c(context, j5, a, a13Var);
                case '\b':
                    mn2 j6 = j(unitedSchemeEntity, mn2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return hk2.J().n(context, j6, a, a13Var);
                case '\t':
                    mn2 j7 = j(unitedSchemeEntity, mn2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return hk2.J().k(context, j7, a, a13Var);
                case '\n':
                    kn2 kn2Var = (kn2) j(unitedSchemeEntity, kn2.class);
                    if (k(kn2Var, a)) {
                        return false;
                    }
                    return hk2.J().e(context, kn2Var, a, a13Var);
                case 11:
                    qn2 qn2Var = (qn2) j(unitedSchemeEntity, qn2.class);
                    if (k(qn2Var, a)) {
                        return false;
                    }
                    return hk2.J().a(context, qn2Var, a, a13Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, a13Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends mn2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    ay1.c("map", "params string is empty");
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
                    ay1.c("map", "params json parse error");
                    return t;
                }
            }
            ay1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(mn2 mn2Var, jn2 jn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, mn2Var, jn2Var)) == null) {
            if (mn2Var == null) {
                ay1.c("map", "parse error, model is null");
                jn2Var.d(202);
                return true;
            }
            if (z03.K().q().y0()) {
                mn2Var.c = sg3.c().h();
            }
            if (TextUtils.isEmpty(mn2Var.c)) {
                String B = ue3.B();
                if (!TextUtils.isEmpty(B)) {
                    mn2Var.c = B;
                }
                ay1.o("map", "webView id is empty, use current webView");
            }
            if (ue3.m(mn2Var.c) == null) {
                jn2Var.d(202);
                ay1.c("map", "can not find weiView by id " + mn2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

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
public class up2 extends j53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up2(j43 j43Var) {
        super(j43Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j43Var};
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

    @Override // com.baidu.tieba.j53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            if (j53.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.j53
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, m33 m33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, m33Var)) == null) {
            if (j53.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            m02.i("map", "handleSubAction " + str);
            vp2 a = vp2.a(unitedSchemeEntity, callbackHandler);
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
                    yp2 j = j(unitedSchemeEntity, yp2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return tm2.J().g(context, j, a, m33Var);
                case 1:
                    yp2 j2 = j(unitedSchemeEntity, yp2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return tm2.J().update(context, j2, a, m33Var);
                case 2:
                    yp2 j3 = j(unitedSchemeEntity, yp2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return tm2.J().l(context, j3, a, m33Var);
                case 3:
                    bq2 bq2Var = (bq2) j(unitedSchemeEntity, bq2.class);
                    if (k(bq2Var, a)) {
                        return false;
                    }
                    return tm2.J().j(context, bq2Var, a, m33Var);
                case 4:
                    aq2 aq2Var = (aq2) j(unitedSchemeEntity, aq2.class);
                    if (k(aq2Var, a)) {
                        return false;
                    }
                    return tm2.J().h(context, aq2Var, a, m33Var);
                case 5:
                    yp2 j4 = j(unitedSchemeEntity, yp2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return tm2.J().m(context, j4, a, m33Var);
                case 6:
                    xp2 xp2Var = (xp2) j(unitedSchemeEntity, xp2.class);
                    if (k(xp2Var, a)) {
                        return false;
                    }
                    return tm2.J().b(context, xp2Var, a, m33Var);
                case 7:
                    yp2 j5 = j(unitedSchemeEntity, yp2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return tm2.J().c(context, j5, a, m33Var);
                case '\b':
                    yp2 j6 = j(unitedSchemeEntity, yp2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return tm2.J().n(context, j6, a, m33Var);
                case '\t':
                    yp2 j7 = j(unitedSchemeEntity, yp2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return tm2.J().k(context, j7, a, m33Var);
                case '\n':
                    wp2 wp2Var = (wp2) j(unitedSchemeEntity, wp2.class);
                    if (k(wp2Var, a)) {
                        return false;
                    }
                    return tm2.J().e(context, wp2Var, a, m33Var);
                case 11:
                    cq2 cq2Var = (cq2) j(unitedSchemeEntity, cq2.class);
                    if (k(cq2Var, a)) {
                        return false;
                    }
                    return tm2.J().a(context, cq2Var, a, m33Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, m33Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public yp2 j(UnitedSchemeEntity unitedSchemeEntity, Class cls) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        yp2 yp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, cls)) == null) {
            yp2 yp2Var2 = null;
            if (unitedSchemeEntity == null) {
                return null;
            }
            HashMap params = unitedSchemeEntity.getParams();
            if (params != null && !params.isEmpty()) {
                String str = (String) params.get("params");
                if (str == null) {
                    m02.c("map", "params string is empty");
                    return null;
                }
                try {
                    jSONObject = new JSONObject(str);
                    yp2Var = (yp2) cls.newInstance();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    yp2Var.a(jSONObject);
                    return yp2Var;
                } catch (Exception e2) {
                    e = e2;
                    yp2Var2 = yp2Var;
                    e.printStackTrace();
                    m02.c("map", "params json parse error");
                    return yp2Var2;
                }
            }
            m02.c("map", "entity get Params is empty");
            return null;
        }
        return (yp2) invokeLL.objValue;
    }

    public final boolean k(yp2 yp2Var, vp2 vp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, yp2Var, vp2Var)) == null) {
            if (yp2Var == null) {
                m02.c("map", "parse error, model is null");
                vp2Var.d(202);
                return true;
            }
            if (l33.K().q().y0()) {
                yp2Var.c = ej3.c().h();
            }
            if (TextUtils.isEmpty(yp2Var.c)) {
                String B = gh3.B();
                if (!TextUtils.isEmpty(B)) {
                    yp2Var.c = B;
                }
                m02.o("map", "webView id is empty, use current webView");
            }
            if (gh3.m(yp2Var.c) == null) {
                vp2Var.d(202);
                m02.c("map", "can not find weiView by id " + yp2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

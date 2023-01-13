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
public class rq2 extends g63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rq2(g53 g53Var) {
        super(g53Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g53Var};
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

    @Override // com.baidu.tieba.g63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j43Var)) == null) {
            if (g63.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.g63
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, j43 j43Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, j43Var)) == null) {
            if (g63.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            j12.i("map", "handleSubAction " + str);
            sq2 a = sq2.a(unitedSchemeEntity, callbackHandler);
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
                    vq2 j = j(unitedSchemeEntity, vq2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return qn2.J().g(context, j, a, j43Var);
                case 1:
                    vq2 j2 = j(unitedSchemeEntity, vq2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return qn2.J().update(context, j2, a, j43Var);
                case 2:
                    vq2 j3 = j(unitedSchemeEntity, vq2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return qn2.J().l(context, j3, a, j43Var);
                case 3:
                    yq2 yq2Var = (yq2) j(unitedSchemeEntity, yq2.class);
                    if (k(yq2Var, a)) {
                        return false;
                    }
                    return qn2.J().j(context, yq2Var, a, j43Var);
                case 4:
                    xq2 xq2Var = (xq2) j(unitedSchemeEntity, xq2.class);
                    if (k(xq2Var, a)) {
                        return false;
                    }
                    return qn2.J().h(context, xq2Var, a, j43Var);
                case 5:
                    vq2 j4 = j(unitedSchemeEntity, vq2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return qn2.J().m(context, j4, a, j43Var);
                case 6:
                    uq2 uq2Var = (uq2) j(unitedSchemeEntity, uq2.class);
                    if (k(uq2Var, a)) {
                        return false;
                    }
                    return qn2.J().b(context, uq2Var, a, j43Var);
                case 7:
                    vq2 j5 = j(unitedSchemeEntity, vq2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return qn2.J().c(context, j5, a, j43Var);
                case '\b':
                    vq2 j6 = j(unitedSchemeEntity, vq2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return qn2.J().n(context, j6, a, j43Var);
                case '\t':
                    vq2 j7 = j(unitedSchemeEntity, vq2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return qn2.J().k(context, j7, a, j43Var);
                case '\n':
                    tq2 tq2Var = (tq2) j(unitedSchemeEntity, tq2.class);
                    if (k(tq2Var, a)) {
                        return false;
                    }
                    return qn2.J().e(context, tq2Var, a, j43Var);
                case 11:
                    zq2 zq2Var = (zq2) j(unitedSchemeEntity, zq2.class);
                    if (k(zq2Var, a)) {
                        return false;
                    }
                    return qn2.J().a(context, zq2Var, a, j43Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, j43Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends vq2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    j12.c("map", "params string is empty");
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
                    j12.c("map", "params json parse error");
                    return t;
                }
            }
            j12.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(vq2 vq2Var, sq2 sq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, vq2Var, sq2Var)) == null) {
            if (vq2Var == null) {
                j12.c("map", "parse error, model is null");
                sq2Var.d(202);
                return true;
            }
            if (i43.K().q().y0()) {
                vq2Var.c = bk3.c().h();
            }
            if (TextUtils.isEmpty(vq2Var.c)) {
                String B = di3.B();
                if (!TextUtils.isEmpty(B)) {
                    vq2Var.c = B;
                }
                j12.o("map", "webView id is empty, use current webView");
            }
            if (di3.m(vq2Var.c) == null) {
                sq2Var.d(202);
                j12.c("map", "can not find weiView by id " + vq2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

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
public class tp2 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp2(i43 i43Var) {
        super(i43Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
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

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (i53.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.i53
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, l33 l33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, l33Var)) == null) {
            if (i53.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            l02.i("map", "handleSubAction " + str);
            up2 a = up2.a(unitedSchemeEntity, callbackHandler);
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
                    xp2 j = j(unitedSchemeEntity, xp2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return sm2.J().g(context, j, a, l33Var);
                case 1:
                    xp2 j2 = j(unitedSchemeEntity, xp2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return sm2.J().update(context, j2, a, l33Var);
                case 2:
                    xp2 j3 = j(unitedSchemeEntity, xp2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return sm2.J().l(context, j3, a, l33Var);
                case 3:
                    aq2 aq2Var = (aq2) j(unitedSchemeEntity, aq2.class);
                    if (k(aq2Var, a)) {
                        return false;
                    }
                    return sm2.J().j(context, aq2Var, a, l33Var);
                case 4:
                    zp2 zp2Var = (zp2) j(unitedSchemeEntity, zp2.class);
                    if (k(zp2Var, a)) {
                        return false;
                    }
                    return sm2.J().h(context, zp2Var, a, l33Var);
                case 5:
                    xp2 j4 = j(unitedSchemeEntity, xp2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return sm2.J().m(context, j4, a, l33Var);
                case 6:
                    wp2 wp2Var = (wp2) j(unitedSchemeEntity, wp2.class);
                    if (k(wp2Var, a)) {
                        return false;
                    }
                    return sm2.J().b(context, wp2Var, a, l33Var);
                case 7:
                    xp2 j5 = j(unitedSchemeEntity, xp2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return sm2.J().c(context, j5, a, l33Var);
                case '\b':
                    xp2 j6 = j(unitedSchemeEntity, xp2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return sm2.J().n(context, j6, a, l33Var);
                case '\t':
                    xp2 j7 = j(unitedSchemeEntity, xp2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return sm2.J().k(context, j7, a, l33Var);
                case '\n':
                    vp2 vp2Var = (vp2) j(unitedSchemeEntity, vp2.class);
                    if (k(vp2Var, a)) {
                        return false;
                    }
                    return sm2.J().e(context, vp2Var, a, l33Var);
                case 11:
                    bq2 bq2Var = (bq2) j(unitedSchemeEntity, bq2.class);
                    if (k(bq2Var, a)) {
                        return false;
                    }
                    return sm2.J().a(context, bq2Var, a, l33Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, l33Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends xp2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    l02.c("map", "params string is empty");
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
                    l02.c("map", "params json parse error");
                    return t;
                }
            }
            l02.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(xp2 xp2Var, up2 up2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, xp2Var, up2Var)) == null) {
            if (xp2Var == null) {
                l02.c("map", "parse error, model is null");
                up2Var.d(202);
                return true;
            }
            if (k33.K().q().y0()) {
                xp2Var.c = dj3.c().h();
            }
            if (TextUtils.isEmpty(xp2Var.c)) {
                String B = fh3.B();
                if (!TextUtils.isEmpty(B)) {
                    xp2Var.c = B;
                }
                l02.o("map", "webView id is empty, use current webView");
            }
            if (fh3.m(xp2Var.c) == null) {
                up2Var.d(202);
                l02.c("map", "can not find weiView by id " + xp2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

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
public class lx2 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lx2(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (ad3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ad3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, db3 db3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, db3Var)) == null) {
            if (ad3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            d82.i("map", "handleSubAction " + str);
            mx2 a = mx2.a(unitedSchemeEntity, callbackHandler);
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
                    px2 j = j(unitedSchemeEntity, px2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return ku2.J().g(context, j, a, db3Var);
                case 1:
                    px2 j2 = j(unitedSchemeEntity, px2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return ku2.J().update(context, j2, a, db3Var);
                case 2:
                    px2 j3 = j(unitedSchemeEntity, px2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return ku2.J().l(context, j3, a, db3Var);
                case 3:
                    sx2 sx2Var = (sx2) j(unitedSchemeEntity, sx2.class);
                    if (k(sx2Var, a)) {
                        return false;
                    }
                    return ku2.J().j(context, sx2Var, a, db3Var);
                case 4:
                    rx2 rx2Var = (rx2) j(unitedSchemeEntity, rx2.class);
                    if (k(rx2Var, a)) {
                        return false;
                    }
                    return ku2.J().h(context, rx2Var, a, db3Var);
                case 5:
                    px2 j4 = j(unitedSchemeEntity, px2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return ku2.J().m(context, j4, a, db3Var);
                case 6:
                    ox2 ox2Var = (ox2) j(unitedSchemeEntity, ox2.class);
                    if (k(ox2Var, a)) {
                        return false;
                    }
                    return ku2.J().b(context, ox2Var, a, db3Var);
                case 7:
                    px2 j5 = j(unitedSchemeEntity, px2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return ku2.J().c(context, j5, a, db3Var);
                case '\b':
                    px2 j6 = j(unitedSchemeEntity, px2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return ku2.J().n(context, j6, a, db3Var);
                case '\t':
                    px2 j7 = j(unitedSchemeEntity, px2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return ku2.J().k(context, j7, a, db3Var);
                case '\n':
                    nx2 nx2Var = (nx2) j(unitedSchemeEntity, nx2.class);
                    if (k(nx2Var, a)) {
                        return false;
                    }
                    return ku2.J().e(context, nx2Var, a, db3Var);
                case 11:
                    tx2 tx2Var = (tx2) j(unitedSchemeEntity, tx2.class);
                    if (k(tx2Var, a)) {
                        return false;
                    }
                    return ku2.J().a(context, tx2Var, a, db3Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, db3Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends px2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    d82.c("map", "params string is empty");
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
                    d82.c("map", "params json parse error");
                    return t;
                }
            }
            d82.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(px2 px2Var, mx2 mx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, px2Var, mx2Var)) == null) {
            if (px2Var == null) {
                d82.c("map", "parse error, model is null");
                mx2Var.d(202);
                return true;
            }
            if (cb3.K().q().y0()) {
                px2Var.c = vq3.c().h();
            }
            if (TextUtils.isEmpty(px2Var.c)) {
                String B = xo3.B();
                if (!TextUtils.isEmpty(B)) {
                    px2Var.c = B;
                }
                d82.o("map", "webView id is empty, use current webView");
            }
            if (xo3.m(px2Var.c) == null) {
                mx2Var.d(202);
                d82.c("map", "can not find weiView by id " + px2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

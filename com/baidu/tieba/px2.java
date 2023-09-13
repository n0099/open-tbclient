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
public class px2 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px2(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ed3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            h82.i("map", "handleSubAction " + str);
            qx2 a = qx2.a(unitedSchemeEntity, callbackHandler);
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
                    tx2 j = j(unitedSchemeEntity, tx2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return ou2.J().g(context, j, a, hb3Var);
                case 1:
                    tx2 j2 = j(unitedSchemeEntity, tx2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return ou2.J().update(context, j2, a, hb3Var);
                case 2:
                    tx2 j3 = j(unitedSchemeEntity, tx2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return ou2.J().l(context, j3, a, hb3Var);
                case 3:
                    wx2 wx2Var = (wx2) j(unitedSchemeEntity, wx2.class);
                    if (k(wx2Var, a)) {
                        return false;
                    }
                    return ou2.J().j(context, wx2Var, a, hb3Var);
                case 4:
                    vx2 vx2Var = (vx2) j(unitedSchemeEntity, vx2.class);
                    if (k(vx2Var, a)) {
                        return false;
                    }
                    return ou2.J().h(context, vx2Var, a, hb3Var);
                case 5:
                    tx2 j4 = j(unitedSchemeEntity, tx2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return ou2.J().m(context, j4, a, hb3Var);
                case 6:
                    sx2 sx2Var = (sx2) j(unitedSchemeEntity, sx2.class);
                    if (k(sx2Var, a)) {
                        return false;
                    }
                    return ou2.J().b(context, sx2Var, a, hb3Var);
                case 7:
                    tx2 j5 = j(unitedSchemeEntity, tx2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return ou2.J().c(context, j5, a, hb3Var);
                case '\b':
                    tx2 j6 = j(unitedSchemeEntity, tx2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return ou2.J().n(context, j6, a, hb3Var);
                case '\t':
                    tx2 j7 = j(unitedSchemeEntity, tx2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return ou2.J().k(context, j7, a, hb3Var);
                case '\n':
                    rx2 rx2Var = (rx2) j(unitedSchemeEntity, rx2.class);
                    if (k(rx2Var, a)) {
                        return false;
                    }
                    return ou2.J().e(context, rx2Var, a, hb3Var);
                case 11:
                    xx2 xx2Var = (xx2) j(unitedSchemeEntity, xx2.class);
                    if (k(xx2Var, a)) {
                        return false;
                    }
                    return ou2.J().a(context, xx2Var, a, hb3Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, hb3Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends tx2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    h82.c("map", "params string is empty");
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
                    h82.c("map", "params json parse error");
                    return t;
                }
            }
            h82.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(tx2 tx2Var, qx2 qx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tx2Var, qx2Var)) == null) {
            if (tx2Var == null) {
                h82.c("map", "parse error, model is null");
                qx2Var.d(202);
                return true;
            }
            if (gb3.K().q().y0()) {
                tx2Var.c = zq3.c().h();
            }
            if (TextUtils.isEmpty(tx2Var.c)) {
                String B = bp3.B();
                if (!TextUtils.isEmpty(B)) {
                    tx2Var.c = B;
                }
                h82.o("map", "webView id is empty, use current webView");
            }
            if (bp3.m(tx2Var.c) == null) {
                qx2Var.d(202);
                h82.c("map", "can not find weiView by id " + tx2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

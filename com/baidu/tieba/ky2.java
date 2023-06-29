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
public class ky2 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ky2(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var};
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

    @Override // com.baidu.tieba.zd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            if (zd3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zd3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, cc3 cc3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, cc3Var)) == null) {
            if (zd3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            c92.i("map", "handleSubAction " + str);
            ly2 a = ly2.a(unitedSchemeEntity, callbackHandler);
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
                    oy2 j = j(unitedSchemeEntity, oy2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return jv2.J().g(context, j, a, cc3Var);
                case 1:
                    oy2 j2 = j(unitedSchemeEntity, oy2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return jv2.J().update(context, j2, a, cc3Var);
                case 2:
                    oy2 j3 = j(unitedSchemeEntity, oy2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return jv2.J().l(context, j3, a, cc3Var);
                case 3:
                    ry2 ry2Var = (ry2) j(unitedSchemeEntity, ry2.class);
                    if (k(ry2Var, a)) {
                        return false;
                    }
                    return jv2.J().j(context, ry2Var, a, cc3Var);
                case 4:
                    qy2 qy2Var = (qy2) j(unitedSchemeEntity, qy2.class);
                    if (k(qy2Var, a)) {
                        return false;
                    }
                    return jv2.J().h(context, qy2Var, a, cc3Var);
                case 5:
                    oy2 j4 = j(unitedSchemeEntity, oy2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return jv2.J().m(context, j4, a, cc3Var);
                case 6:
                    ny2 ny2Var = (ny2) j(unitedSchemeEntity, ny2.class);
                    if (k(ny2Var, a)) {
                        return false;
                    }
                    return jv2.J().b(context, ny2Var, a, cc3Var);
                case 7:
                    oy2 j5 = j(unitedSchemeEntity, oy2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return jv2.J().c(context, j5, a, cc3Var);
                case '\b':
                    oy2 j6 = j(unitedSchemeEntity, oy2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return jv2.J().n(context, j6, a, cc3Var);
                case '\t':
                    oy2 j7 = j(unitedSchemeEntity, oy2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return jv2.J().k(context, j7, a, cc3Var);
                case '\n':
                    my2 my2Var = (my2) j(unitedSchemeEntity, my2.class);
                    if (k(my2Var, a)) {
                        return false;
                    }
                    return jv2.J().e(context, my2Var, a, cc3Var);
                case 11:
                    sy2 sy2Var = (sy2) j(unitedSchemeEntity, sy2.class);
                    if (k(sy2Var, a)) {
                        return false;
                    }
                    return jv2.J().a(context, sy2Var, a, cc3Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, cc3Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends oy2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    c92.c("map", "params string is empty");
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
                    c92.c("map", "params json parse error");
                    return t;
                }
            }
            c92.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(oy2 oy2Var, ly2 ly2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, oy2Var, ly2Var)) == null) {
            if (oy2Var == null) {
                c92.c("map", "parse error, model is null");
                ly2Var.d(202);
                return true;
            }
            if (bc3.K().q().y0()) {
                oy2Var.c = ur3.c().h();
            }
            if (TextUtils.isEmpty(oy2Var.c)) {
                String B = wp3.B();
                if (!TextUtils.isEmpty(B)) {
                    oy2Var.c = B;
                }
                c92.o("map", "webView id is empty, use current webView");
            }
            if (wp3.m(oy2Var.c) == null) {
                ly2Var.d(202);
                c92.c("map", "can not find weiView by id " + oy2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

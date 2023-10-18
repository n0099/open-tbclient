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
/* loaded from: classes8.dex */
public class xr2 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xr2(m63 m63Var) {
        super(m63Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
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

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (m73.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, p53 p53Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, p53Var)) == null) {
            if (m73.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            p22.i("map", "handleSubAction " + str);
            yr2 a = yr2.a(unitedSchemeEntity, callbackHandler);
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
                    bs2 j = j(unitedSchemeEntity, bs2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return wo2.J().g(context, j, a, p53Var);
                case 1:
                    bs2 j2 = j(unitedSchemeEntity, bs2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return wo2.J().o(context, j2, a, p53Var);
                case 2:
                    bs2 j3 = j(unitedSchemeEntity, bs2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return wo2.J().l(context, j3, a, p53Var);
                case 3:
                    es2 es2Var = (es2) j(unitedSchemeEntity, es2.class);
                    if (k(es2Var, a)) {
                        return false;
                    }
                    return wo2.J().j(context, es2Var, a, p53Var);
                case 4:
                    ds2 ds2Var = (ds2) j(unitedSchemeEntity, ds2.class);
                    if (k(ds2Var, a)) {
                        return false;
                    }
                    return wo2.J().h(context, ds2Var, a, p53Var);
                case 5:
                    bs2 j4 = j(unitedSchemeEntity, bs2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return wo2.J().m(context, j4, a, p53Var);
                case 6:
                    as2 as2Var = (as2) j(unitedSchemeEntity, as2.class);
                    if (k(as2Var, a)) {
                        return false;
                    }
                    return wo2.J().b(context, as2Var, a, p53Var);
                case 7:
                    bs2 j5 = j(unitedSchemeEntity, bs2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return wo2.J().c(context, j5, a, p53Var);
                case '\b':
                    bs2 j6 = j(unitedSchemeEntity, bs2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return wo2.J().n(context, j6, a, p53Var);
                case '\t':
                    bs2 j7 = j(unitedSchemeEntity, bs2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return wo2.J().k(context, j7, a, p53Var);
                case '\n':
                    zr2 zr2Var = (zr2) j(unitedSchemeEntity, zr2.class);
                    if (k(zr2Var, a)) {
                        return false;
                    }
                    return wo2.J().e(context, zr2Var, a, p53Var);
                case 11:
                    fs2 fs2Var = (fs2) j(unitedSchemeEntity, fs2.class);
                    if (k(fs2Var, a)) {
                        return false;
                    }
                    return wo2.J().a(context, fs2Var, a, p53Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, p53Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends bs2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    p22.c("map", "params string is empty");
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
                    p22.c("map", "params json parse error");
                    return t;
                }
            }
            p22.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(bs2 bs2Var, yr2 yr2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bs2Var, yr2Var)) == null) {
            if (bs2Var == null) {
                p22.c("map", "parse error, model is null");
                yr2Var.d(202);
                return true;
            }
            if (o53.K().q().z0()) {
                bs2Var.c = hl3.c().h();
            }
            if (TextUtils.isEmpty(bs2Var.c)) {
                String B = jj3.B();
                if (!TextUtils.isEmpty(B)) {
                    bs2Var.c = B;
                }
                p22.o("map", "webView id is empty, use current webView");
            }
            if (jj3.m(bs2Var.c) == null) {
                yr2Var.d(202);
                p22.c("map", "can not find weiView by id " + bs2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

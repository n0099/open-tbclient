package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wa2 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa2(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/sConsole");
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
                Log.d("ConsoleAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.zd3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, cc3 cc3Var) {
        InterceptResult invokeLLLLL;
        boolean optBoolean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, cc3Var)) == null) {
            if (zd3.b) {
                Log.d("ConsoleAction", "handleSubAction subAction: " + str);
            }
            if (!z82.a() && !c92.f() && !TextUtils.equals(str, "/swanAPI/sConsole/debugSwitch")) {
                return super.i(context, unitedSchemeEntity, callbackHandler, str, cc3Var);
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            char c = 65535;
            switch (str.hashCode()) {
                case -1923550429:
                    if (str.equals("/swanAPI/sConsole/sanIncData2Console")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1792428120:
                    if (str.equals("/swanAPI/sConsole/sanFullData2Console")) {
                        c = 4;
                        break;
                    }
                    break;
                case -797920904:
                    if (str.equals("/swanAPI/sConsole/hide")) {
                        c = 2;
                        break;
                    }
                    break;
                case -797593805:
                    if (str.equals("/swanAPI/sConsole/show")) {
                        c = 1;
                        break;
                    }
                    break;
                case -161927599:
                    if (str.equals("/swanAPI/sConsole/postMessage")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1089933937:
                    if (str.equals("/swanAPI/sConsole/debugSwitch")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2136057821:
                    if (str.equals("/swanAPI/sConsole/getSanDataFromActiveSlave")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (optParamsAsJo != null && (optBoolean = optParamsAsJo.optBoolean("enableDebug")) != z82.a()) {
                        z82.c(context, optBoolean);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        c92.i("ConsoleAction", " sConsole switch：" + optParamsAsJo.optBoolean("enableDebug"));
                    }
                    return true;
                case 1:
                    px2.T().q().O(true);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    c92.i("ConsoleAction", "sConsole show");
                    return true;
                case 2:
                    px2.T().q().O(false);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    c92.i("ConsoleAction", "sConsole hide");
                    return true;
                case 3:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        c92.i("ConsoleAction", "send san inc data");
                        xa2.d(optParamsAsJo.toString());
                    } else {
                        c92.c("ConsoleAction", "san inc data is null");
                    }
                    return true;
                case 4:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        c92.i("ConsoleAction", "send san full data");
                        xa2.c(optParamsAsJo.toString());
                    } else {
                        c92.c("ConsoleAction", "san full data is null");
                    }
                    return true;
                case 5:
                    c92.i("ConsoleAction", "request san full data");
                    xa2.b();
                    return true;
                case 6:
                    lt1 h = kv2.h();
                    if (h != null) {
                        h.c(optParamsAsJo);
                    }
                    return true;
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, cc3Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }
}

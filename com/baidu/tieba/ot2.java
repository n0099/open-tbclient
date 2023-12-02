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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ot2 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot2(h73 h73Var) {
        super(h73Var, "/swanAPI/backgroundAudio");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (unitedSchemeEntity != null) {
                nt2.b("AudioBGPlayerAction", "#handle entity.uri=" + unitedSchemeEntity.getUri());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.h83
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, k63 k63Var) {
        InterceptResult invokeLLLLL;
        kt2 b;
        char c;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, k63Var)) == null) {
            if (k63Var == null) {
                qd3.b("audio", 2001, "SwanApp is null", 1001, "SwanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            nt2.b("AudioBGPlayerAction", "#handleSubAction subAction=" + str + " entity.uri=" + unitedSchemeEntity.getUri());
            JSONObject j = j(unitedSchemeEntity.getParam("params"));
            if (j == null) {
                qd3.b("audio", 2001, "param is null", 201, "param is null");
                k32.c("backgroundAudio", "param is null!");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            mt2 Q = k63Var.Q();
            if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
                b = kt2.b(j, new kt2());
            } else {
                b = kt2.b(j, Q.q());
            }
            nt2.b("AudioBGPlayerAction", "#handleSubAction playerParams=" + b);
            JSONObject jSONObject = null;
            switch (str.hashCode()) {
                case 312101659:
                    if (str.equals("/swanAPI/backgroundAudio/getParamsSync")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 335869926:
                    if (str.equals("/swanAPI/backgroundAudio/open")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 335895760:
                    if (str.equals("/swanAPI/backgroundAudio/play")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 335978516:
                    if (str.equals("/swanAPI/backgroundAudio/seek")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 335993246:
                    if (str.equals("/swanAPI/backgroundAudio/stop")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 820188005:
                    if (str.equals("/swanAPI/backgroundAudio/update")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1822525402:
                    if (str.equals("/swanAPI/backgroundAudio/pause")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    k32.i("backgroundAudio", "open, audioId " + b.a);
                    Q.z(b, callbackHandler);
                    z = true;
                    break;
                case 1:
                    k32.i("backgroundAudio", "update, audioId " + b.a);
                    Q.M(b);
                    z = true;
                    break;
                case 2:
                    k32.i("backgroundAudio", "play, audioId " + b.a);
                    Q.F();
                    z = true;
                    break;
                case 3:
                    k32.i("backgroundAudio", "pause, audioId " + b.a);
                    Q.A();
                    z = true;
                    break;
                case 4:
                    k32.i("backgroundAudio", "seek, audioId " + b.a + " position " + b.l);
                    Q.G(b.l);
                    z = true;
                    break;
                case 5:
                    k32.i("backgroundAudio", "stop, audioId " + b.a);
                    Q.L();
                    z = true;
                    break;
                case 6:
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(b.m, Q.t(b.m));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        return true;
                    } catch (JSONException e) {
                        qd3.b("audio", 2009, "json exception", -1, "");
                        k32.c("backgroundAudio", "getParams error " + e.toString());
                        nt2.c("backgroundAudio", "getParamsSync error", e);
                        break;
                    }
                default:
                    z = false;
                    break;
            }
            nt2.b("AudioBGPlayerAction", "#handleSubAction invokeSuccess=" + z);
            if (z) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
            return super.i(context, unitedSchemeEntity, callbackHandler, str, k63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e) {
                    if (h83.b) {
                        Log.d("AudioBGPlayerAction", Log.getStackTraceString(e));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.pb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class xu2 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ wu2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ vu2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ k63 h;
        public final /* synthetic */ xu2 i;

        public a(xu2 xu2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, wu2 wu2Var, String str, Context context, vu2 vu2Var, String str2, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu2Var, callbackHandler, unitedSchemeEntity, wu2Var, str, context, vu2Var, str2, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xu2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = wu2Var;
            this.d = str;
            this.e = context;
            this.f = vu2Var;
            this.g = str2;
            this.h = k63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    ib3.p(nb3Var, this.a, this.b);
                    if (nb3Var == null) {
                        b = 10001;
                    } else {
                        b = nb3Var.b();
                    }
                    this.i.o(this.c, b, ib3.f(b));
                } else if (av2.k().q(this.d)) {
                    this.i.o(this.c, 2001, "error execute time");
                    k32.c("record", "error execute time");
                } else {
                    this.i.r(this.e, this.b, this.a, this.d, this.f, this.c, this.g, this.h.b);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements n13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ vu2 e;
        public final /* synthetic */ wu2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ xu2 i;

        public b(xu2 xu2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, vu2 vu2Var, wu2 wu2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu2Var, callbackHandler, unitedSchemeEntity, str, context, vu2Var, wu2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xu2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
            this.d = context;
            this.e = vu2Var;
            this.f = wu2Var;
            this.g = str2;
            this.h = str3;
        }

        @Override // com.baidu.tieba.n13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (h83.b) {
                    Log.d("AudioRecordAction", str + "");
                }
                this.i.p(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            }
        }

        @Override // com.baidu.tieba.n13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (h83.b) {
                    Log.d("AudioRecordAction", str + "");
                }
                k32.c("record", str);
                this.i.o(this.f, 10005, "system deny");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xu2(h73 h73Var) {
        super(h73Var, "/swanAPI/recorder");
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
            if (h83.b) {
                Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            av2.k().t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            av2.k().A();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            av2.k().F();
            av2.x();
        }
    }

    @Override // com.baidu.tieba.h83
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, k63 k63Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, k63Var)) == null) {
            if (h83.b) {
                Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
            }
            if (k63Var == null) {
                k32.c("record", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (h83.b) {
                    Log.d("AudioRecordAction", "record --- illegal swanApp");
                }
                return false;
            }
            if (k63Var.o0()) {
                if (h83.b) {
                    Log.d("AudioRecordAction", "AudioRecordAction does not supported when app is invisible.");
                }
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -944894266) {
                    if (hashCode == 731105865 && str.equals("/swanAPI/recorder/resume")) {
                        c = 1;
                    }
                } else if (str.equals("/swanAPI/recorder/start")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                        return false;
                    }
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
            }
            if (TextUtils.isEmpty(k63Var.b)) {
                k32.c("record", "aiapp id is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                if (h83.b) {
                    Log.d("AudioRecordAction", "record --- none swanApp id");
                }
                return false;
            } else if (!av2.k().p(str)) {
                return false;
            } else {
                JSONObject q = q(unitedSchemeEntity.getParam("params"));
                if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                    k32.c("record", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                    return false;
                }
                vu2 a2 = vu2.a(q, av2.k().j());
                if (a2 == null) {
                    k32.c("record", "error params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                    return false;
                }
                JSONObject c2 = a2.c();
                if (c2 != null) {
                    k32.c("record", "error params");
                    unitedSchemeEntity.result = c2;
                    return false;
                }
                wu2 a3 = wu2.a(callbackHandler, unitedSchemeEntity, a2.g, av2.k().i());
                String x = sd3.x(k63Var.b);
                if (TextUtils.isEmpty(x)) {
                    k32.c("record", "none tmp path");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    k32.c("record", "handle action, but context is not Activity");
                    return false;
                } else {
                    k63Var.f0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, a3, str, context, a2, x, k63Var));
                    if (h83.b) {
                        Log.d("AudioRecordAction", "subAction is : " + str);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final void o(wu2 wu2Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, wu2Var, i, str) == null) {
            if (wu2Var != null && !TextUtils.isEmpty(wu2.h)) {
                wu2Var.d(i, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, i);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                xr2.V().v(new lg2("recorderError", hashMap));
            } catch (JSONException e) {
                k32.d("record", "json error", e);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, vu2 vu2Var, wu2 wu2Var, String str2, String str3) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{callbackHandler, unitedSchemeEntity, str, context, vu2Var, wu2Var, str2, str3}) == null) {
            switch (str.hashCode()) {
                case -948211622:
                    if (str.equals("/swanAPI/recorder/pause")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -944894266:
                    if (str.equals("/swanAPI/recorder/start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 731105865:
                    if (str.equals("/swanAPI/recorder/resume")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 2047729950:
                    if (str.equals("/swanAPI/recorder/stop")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c == 3) {
                            k32.i("record", "stop");
                            v();
                            return;
                        }
                        return;
                    }
                    k32.i("record", DownloadStatisticConstants.UBC_TYPE_RESUME);
                    t();
                    return;
                }
                k32.i("record", DownloadStatisticConstants.UBC_TYPE_PAUSE);
                s();
                return;
            }
            u(context, vu2Var, wu2Var, str2, str3);
        }
    }

    public final JSONObject q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e) {
                    if (h83.b) {
                        Log.d("AudioRecordAction", Log.getStackTraceString(e));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, vu2 vu2Var, wu2 wu2Var, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, unitedSchemeEntity, callbackHandler, str, vu2Var, wu2Var, str2, str3}) == null) {
            m13.g(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(this, callbackHandler, unitedSchemeEntity, str, context, vu2Var, wu2Var, str2, str3));
        }
    }

    public final void u(Context context, vu2 vu2Var, wu2 wu2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, vu2Var, wu2Var, str, str2) == null) {
            k32.i("record", "init");
            av2.k().l(str, vu2Var, context, wu2Var, str2);
            k32.i("record", "start");
            av2.k().D(true);
        }
    }
}

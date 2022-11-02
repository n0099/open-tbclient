package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.j93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rs2 extends b63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ qs2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ ps2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ e43 h;
        public final /* synthetic */ rs2 i;

        public a(rs2 rs2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, qs2 qs2Var, String str, Context context, ps2 ps2Var, String str2, e43 e43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs2Var, callbackHandler, unitedSchemeEntity, qs2Var, str, context, ps2Var, str2, e43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = rs2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = qs2Var;
            this.d = str;
            this.e = context;
            this.f = ps2Var;
            this.g = str2;
            this.h = e43Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (!c93.h(h93Var)) {
                    c93.p(h93Var, this.a, this.b);
                    if (h93Var == null) {
                        b = 10001;
                    } else {
                        b = h93Var.b();
                    }
                    this.i.o(this.c, b, c93.f(b));
                } else if (us2.k().q(this.d)) {
                    this.i.o(this.c, 2001, "error execute time");
                    e12.c("record", "error execute time");
                } else {
                    this.i.r(this.e, this.b, this.a, this.d, this.f, this.c, this.g, this.h.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ps2 e;
        public final /* synthetic */ qs2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ rs2 i;

        public b(rs2 rs2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, ps2 ps2Var, qs2 qs2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs2Var, callbackHandler, unitedSchemeEntity, str, context, ps2Var, qs2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = rs2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
            this.d = context;
            this.e = ps2Var;
            this.f = qs2Var;
            this.g = str2;
            this.h = str3;
        }

        @Override // com.baidu.tieba.hz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (b63.b) {
                    Log.d("AudioRecordAction", str + "");
                }
                this.i.p(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            }
        }

        @Override // com.baidu.tieba.hz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (b63.b) {
                    Log.d("AudioRecordAction", str + "");
                }
                e12.c("record", str);
                this.i.o(this.f, 10005, "system deny");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rs2(b53 b53Var) {
        super(b53Var, "/swanAPI/recorder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
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

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            if (b63.b) {
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
            us2.k().t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            us2.k().A();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            us2.k().F();
            us2.x();
        }
    }

    @Override // com.baidu.tieba.b63
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e43 e43Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, e43Var)) == null) {
            if (b63.b) {
                Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
            }
            if (e43Var == null) {
                e12.c("record", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (b63.b) {
                    Log.d("AudioRecordAction", "record --- illegal swanApp");
                }
                return false;
            }
            if (e43Var.n0()) {
                if (b63.b) {
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
            if (TextUtils.isEmpty(e43Var.b)) {
                e12.c("record", "aiapp id is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                if (b63.b) {
                    Log.d("AudioRecordAction", "record --- none swanApp id");
                }
                return false;
            } else if (!us2.k().p(str)) {
                return false;
            } else {
                JSONObject q = q(unitedSchemeEntity.getParam("params"));
                if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                    e12.c("record", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                    return false;
                }
                ps2 a2 = ps2.a(q, us2.k().j());
                if (a2 == null) {
                    e12.c("record", "error params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                    return false;
                }
                JSONObject c2 = a2.c();
                if (c2 != null) {
                    e12.c("record", "error params");
                    unitedSchemeEntity.result = c2;
                    return false;
                }
                qs2 a3 = qs2.a(callbackHandler, unitedSchemeEntity, a2.g, us2.k().i());
                String x = mb3.x(e43Var.b);
                if (TextUtils.isEmpty(x)) {
                    e12.c("record", "none tmp path");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    e12.c("record", "handle action, but context is not Activity");
                    return false;
                } else {
                    e43Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, a3, str, context, a2, x, e43Var));
                    if (b63.b) {
                        Log.d("AudioRecordAction", "subAction is : " + str);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final void o(qs2 qs2Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, qs2Var, i, str) == null) {
            if (qs2Var != null && !TextUtils.isEmpty(qs2.h)) {
                qs2Var.d(i, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, i);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                rp2.U().u(new fe2("recorderError", hashMap));
            } catch (JSONException e) {
                e12.d("record", "json error", e);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, ps2 ps2Var, qs2 qs2Var, String str2, String str3) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{callbackHandler, unitedSchemeEntity, str, context, ps2Var, qs2Var, str2, str3}) == null) {
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
                            e12.i("record", IntentConfig.STOP);
                            v();
                            return;
                        }
                        return;
                    }
                    e12.i("record", "resume");
                    t();
                    return;
                }
                e12.i("record", "pause");
                s();
                return;
            }
            u(context, ps2Var, qs2Var, str2, str3);
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
                    if (b63.b) {
                        Log.d("AudioRecordAction", Log.getStackTraceString(e));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, ps2 ps2Var, qs2 qs2Var, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, unitedSchemeEntity, callbackHandler, str, ps2Var, qs2Var, str2, str3}) == null) {
            gz2.h(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(this, callbackHandler, unitedSchemeEntity, str, context, ps2Var, qs2Var, str2, str3));
        }
    }

    public final void u(Context context, ps2 ps2Var, qs2 qs2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, ps2Var, qs2Var, str, str2) == null) {
            e12.i("record", "init");
            us2.k().l(str, ps2Var, context, qs2Var, str2);
            e12.i("record", "start");
            us2.k().D(true);
        }
    }
}

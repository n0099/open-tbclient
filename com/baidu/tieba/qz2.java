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
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qz2 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ pz2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ oz2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ db3 h;
        public final /* synthetic */ qz2 i;

        public a(qz2 qz2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, pz2 pz2Var, String str, Context context, oz2 oz2Var, String str2, db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz2Var, callbackHandler, unitedSchemeEntity, pz2Var, str, context, oz2Var, str2, db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = qz2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = pz2Var;
            this.d = str;
            this.e = context;
            this.f = oz2Var;
            this.g = str2;
            this.h = db3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    bg3.p(gg3Var, this.a, this.b);
                    if (gg3Var == null) {
                        b = 10001;
                    } else {
                        b = gg3Var.b();
                    }
                    this.i.o(this.c, b, bg3.f(b));
                } else if (tz2.k().q(this.d)) {
                    this.i.o(this.c, 2001, "error execute time");
                    d82.c("record", "error execute time");
                } else {
                    this.i.r(this.e, this.b, this.a, this.d, this.f, this.c, this.g, this.h.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ oz2 e;
        public final /* synthetic */ pz2 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ qz2 i;

        public b(qz2 qz2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, oz2 oz2Var, pz2 pz2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz2Var, callbackHandler, unitedSchemeEntity, str, context, oz2Var, pz2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = qz2Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
            this.d = context;
            this.e = oz2Var;
            this.f = pz2Var;
            this.g = str2;
            this.h = str3;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (ad3.b) {
                    Log.d("AudioRecordAction", str + "");
                }
                this.i.p(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
            }
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (ad3.b) {
                    Log.d("AudioRecordAction", str + "");
                }
                d82.c("record", str);
                this.i.o(this.f, 10005, "system deny");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qz2(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/recorder");
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
            tz2.k().t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            tz2.k().A();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            tz2.k().F();
            tz2.x();
        }
    }

    @Override // com.baidu.tieba.ad3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, db3 db3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, db3Var)) == null) {
            if (ad3.b) {
                Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
            }
            if (db3Var == null) {
                d82.c("record", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (ad3.b) {
                    Log.d("AudioRecordAction", "record --- illegal swanApp");
                }
                return false;
            }
            if (db3Var.n0()) {
                if (ad3.b) {
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
            if (TextUtils.isEmpty(db3Var.b)) {
                d82.c("record", "aiapp id is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                if (ad3.b) {
                    Log.d("AudioRecordAction", "record --- none swanApp id");
                }
                return false;
            } else if (!tz2.k().p(str)) {
                return false;
            } else {
                JSONObject q = q(unitedSchemeEntity.getParam("params"));
                if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                    d82.c("record", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                    return false;
                }
                oz2 a2 = oz2.a(q, tz2.k().j());
                if (a2 == null) {
                    d82.c("record", "error params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                    return false;
                }
                JSONObject c2 = a2.c();
                if (c2 != null) {
                    d82.c("record", "error params");
                    unitedSchemeEntity.result = c2;
                    return false;
                }
                pz2 a3 = pz2.a(callbackHandler, unitedSchemeEntity, a2.g, tz2.k().i());
                String x = li3.x(db3Var.b);
                if (TextUtils.isEmpty(x)) {
                    d82.c("record", "none tmp path");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    d82.c("record", "handle action, but context is not Activity");
                    return false;
                } else {
                    db3Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, a3, str, context, a2, x, db3Var));
                    if (ad3.b) {
                        Log.d("AudioRecordAction", "subAction is : " + str);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final void o(pz2 pz2Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, pz2Var, i, str) == null) {
            if (pz2Var != null && !TextUtils.isEmpty(pz2.h)) {
                pz2Var.d(i, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(StatConstants.KEY_EXT_ERR_CODE, i);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                qw2.T().u(new el2("recorderError", hashMap));
            } catch (JSONException e) {
                d82.d("record", "json error", e);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, oz2 oz2Var, pz2 pz2Var, String str2, String str3) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{callbackHandler, unitedSchemeEntity, str, context, oz2Var, pz2Var, str2, str3}) == null) {
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
                            d82.i("record", "stop");
                            v();
                            return;
                        }
                        return;
                    }
                    d82.i("record", DownloadStatisticConstants.UBC_TYPE_RESUME);
                    t();
                    return;
                }
                d82.i("record", DownloadStatisticConstants.UBC_TYPE_PAUSE);
                s();
                return;
            }
            u(context, oz2Var, pz2Var, str2, str3);
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
                    if (ad3.b) {
                        Log.d("AudioRecordAction", Log.getStackTraceString(e));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, oz2 oz2Var, pz2 pz2Var, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, unitedSchemeEntity, callbackHandler, str, oz2Var, pz2Var, str2, str3}) == null) {
            f63.h(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(this, callbackHandler, unitedSchemeEntity, str, context, oz2Var, pz2Var, str2, str3));
        }
    }

    public final void u(Context context, oz2 oz2Var, pz2 pz2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, oz2Var, pz2Var, str, str2) == null) {
            d82.i("record", "init");
            tz2.k().l(str, oz2Var, context, pz2Var, str2);
            d82.i("record", "start");
            tz2.k().D(true);
        }
    }
}

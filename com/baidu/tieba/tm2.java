package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.dh3;
import com.baidu.tieba.si2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tm2 extends vd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements rq3<bh3<dh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ JSONObject d;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, context, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<dh3.e> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                if (wg3.h(bh3Var)) {
                    try {
                        tm2.l(this.c, this.d);
                        UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(this.d, 0));
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                        return;
                    }
                }
                wg3.p(bh3Var, this.a, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tm2(vc3 vc3Var) {
        super(vc3Var, "/swanAPI/debug/getDebugConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vc3Var};
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

    public static JSONObject k(String str, Object obj) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            jSONObject.put("value", obj);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v51 */
    public static void l(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        ?? r1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, jSONObject) == null) {
            String string = context.getString(R.string.obfuscated_res_0x7f0f016a);
            boolean s = x73.s();
            mm2.a(s);
            jSONObject.put("loadCts", k(string, Integer.valueOf(s ? 1 : 0)));
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f014d);
            boolean r = x73.r();
            mm2.a(r);
            jSONObject.put("emitLive", k(string2, Integer.valueOf(r ? 1 : 0)));
            String string3 = context.getString(R.string.obfuscated_res_0x7f0f014b);
            boolean o = x73.o();
            mm2.a(o);
            jSONObject.put("emitHttps", k(string3, Integer.valueOf(o ? 1 : 0)));
            String string4 = context.getString(R.string.obfuscated_res_0x7f0f017e);
            boolean y = x73.y();
            mm2.a(y);
            jSONObject.put("useExtension", k(string4, Integer.valueOf(y ? 1 : 0)));
            String string5 = context.getString(R.string.obfuscated_res_0x7f0f0149);
            if (!x73.w() && !x73.A()) {
                r1 = 1;
            } else {
                r1 = 0;
            }
            mm2.a(r1);
            jSONObject.put("emitDomain", k(string5, Integer.valueOf((int) r1)));
            String string6 = context.getString(R.string.obfuscated_res_0x7f0f0154);
            boolean q = x73.q();
            mm2.a(q);
            jSONObject.put("emitWss", k(string6, Integer.valueOf(q ? 1 : 0)));
            String string7 = context.getString(R.string.obfuscated_res_0x7f0f014c);
            boolean x = x73.x();
            mm2.a(x);
            jSONObject.put("emitLaunchMode", k(string7, Integer.valueOf(x ? 1 : 0)));
            jSONObject.put("debugEnvData", k(context.getString(R.string.obfuscated_res_0x7f0f0161), x73.g()));
            String string8 = context.getString(R.string.obfuscated_res_0x7f0f0152);
            boolean k = x73.k();
            mm2.a(k);
            jSONObject.put("emitReplaceSwanCore", k(string8, Integer.valueOf(k ? 1 : 0)));
            String string9 = context.getString(R.string.obfuscated_res_0x7f0f0150);
            boolean h = x73.h();
            mm2.a(h);
            jSONObject.put("emitReplaceGameCore", k(string9, Integer.valueOf(h ? 1 : 0)));
            String string10 = context.getString(R.string.obfuscated_res_0x7f0f0151);
            boolean p = x73.p();
            mm2.a(p);
            jSONObject.put("emitReplaceJsNative", k(string10, Integer.valueOf(p ? 1 : 0)));
            boolean d = si2.v.d();
            String string11 = context.getString(R.string.obfuscated_res_0x7f0f0153);
            mm2.a(d);
            jSONObject.put("emitReplaceV8Core", k(string11, Integer.valueOf(d ? 1 : 0)));
            String string12 = context.getString(R.string.obfuscated_res_0x7f0f014f);
            boolean m = om2.m();
            mm2.a(m);
            jSONObject.put("emitReplaceDynamicLib", k(string12, Integer.valueOf(m ? 1 : 0)));
            jSONObject.put("emitHostEnv", k(context.getString(R.string.obfuscated_res_0x7f0f014a), Integer.valueOf(x73.t())));
            String string13 = context.getString(R.string.obfuscated_res_0x7f0f0171);
            boolean a2 = rm2.a();
            mm2.a(a2);
            jSONObject.put("openStabilityCollector", k(string13, Integer.valueOf(a2 ? 1 : 0)));
            String string14 = context.getString(R.string.obfuscated_res_0x7f0f0170);
            boolean a3 = qm2.a();
            mm2.a(a3);
            jSONObject.put("openPerformanceTesting", k(string14, Integer.valueOf(a3 ? 1 : 0)));
            String string15 = context.getString(R.string.obfuscated_res_0x7f0f014e);
            boolean k2 = nm2.k();
            mm2.a(k2);
            jSONObject.put("emitReplaceDependency", k(string15, Integer.valueOf(k2 ? 1 : 0)));
        }
    }

    public static boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, unitedSchemeEntity, callbackHandler, yb3Var)) == null) {
            yb3Var.e0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, context, new JSONObject()));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, unitedSchemeEntity, callbackHandler)) == null) {
            JSONObject jSONObject = new JSONObject();
            y82.i("getDebugConfig", "swangame getDebugConfig");
            if (!vd3.b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject a2 = vd3.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                y82.c("getDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!TextUtils.equals(a2.optString("category"), "swanGame")) {
                y82.c("getDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    boolean o = x73.o();
                    mm2.a(o);
                    jSONObject.put("emitHttps", o ? 1 : 0);
                    boolean q = x73.q();
                    mm2.a(q);
                    jSONObject.put("emitWss", q ? 1 : 0);
                    jSONObject.put("debugEnvData", x73.g());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.vd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, yb3Var)) == null) {
            y82.i("getDebugConfig", "swan getDebugConfig");
            int k = xb3.K().k();
            if (k != 0) {
                if (k != 1) {
                    y82.c("getDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "frame type error");
                    return false;
                }
                return n(unitedSchemeEntity, callbackHandler);
            }
            return m(context, unitedSchemeEntity, callbackHandler, yb3Var);
        }
        return invokeLLLL.booleanValue;
    }
}

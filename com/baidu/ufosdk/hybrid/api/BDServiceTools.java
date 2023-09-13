package com.baidu.ufosdk.hybrid.api;

import android.content.Context;
import android.os.Bundle;
import com.baidu.ar.pose.PoseAR;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.jni.TtsLogLoad;
import com.baidu.ufosdk.b;
import com.baidu.ufosdk.k1;
import com.baidu.ufosdk.o;
import com.baidu.ufosdk.p;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class BDServiceTools implements IBridgeApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BDServiceTools() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void getClientEnvType(Context context, p pVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, pVar, oVar) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TtsLogLoad.KEY_OS, b.e(context));
                oVar.a(jSONObject);
            } catch (Throwable unused) {
                oVar.a("10102", "Unknow Exception!");
            }
        }
    }

    public static void startHostService(Context context, p pVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, pVar, oVar) == null) {
            try {
                JSONObject jSONObject = new JSONObject(pVar.d);
                jSONObject.optInt("from", -1);
                String optString = jSONObject.optString("scheme", "");
                Bundle bundle = new Bundle();
                bundle.putInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, 103);
                bundle.putString("bd_scheme", optString);
                b.a(context, bundle);
                oVar.a((JSONObject) null);
            } catch (Exception e) {
                e.printStackTrace();
                b.f.post(new k1(R.string.obfuscated_res_0x7f0f072b, 0));
                oVar.a("10102", "Unknow Exception!");
            }
        }
    }
}

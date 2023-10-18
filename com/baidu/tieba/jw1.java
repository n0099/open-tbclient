package com.baidu.tieba;

import android.media.AudioManager;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jw1 extends wv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioManager f;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "VolumeApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qx1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#setMediaVolume", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                p22.c("VolumeApi", "swan activity is null");
                return new qx1(1001, "swan activity is null");
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            try {
                float parseFloat = Float.parseFloat(((JSONObject) t.second).optString("value"));
                if (this.f == null) {
                    this.f = (AudioManager) w.getSystemService("audio");
                }
                int streamMaxVolume = this.f.getStreamMaxVolume(3);
                int z = z(parseFloat, streamMaxVolume);
                if (z >= 0 && z <= streamMaxVolume) {
                    try {
                        this.f.setStreamVolume(3, z, 1);
                        return qx1.f();
                    } catch (SecurityException unused) {
                        return new qx1(1001, "Cannot set volume under silent mode.");
                    }
                }
                return new qx1(202, "value is illegal.");
            } catch (NumberFormatException unused2) {
                p22.c("VolumeApi", "illegal argument type");
                return new qx1(202, "value is illegal.");
            }
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r("#getMediaVolume", false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                return new qx1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                p22.c("VolumeApi", "swan activity is null");
                return new qx1(1001, "swan activity is null");
            }
            if (this.f == null) {
                this.f = (AudioManager) w.getSystemService("audio");
            }
            float streamMaxVolume = this.f.getStreamMaxVolume(3);
            float streamVolume = this.f.getStreamVolume(3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", streamVolume / streamMaxVolume);
                return new qx1(0, jSONObject);
            } catch (JSONException unused) {
                return new qx1(1001, "make result json error");
            }
        }
        return (qx1) invokeV.objValue;
    }

    public final int z(float f, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)})) == null) {
            int round = Math.round(i * f);
            if (round == 0 && f > 0.0f) {
                return 1;
            }
            return round;
        }
        return invokeCommon.intValue;
    }
}

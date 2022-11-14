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
public class yu1 extends lu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioManager f;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "VolumeApi" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yu1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public fw1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#getMediaVolume", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                return new fw1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                f12.c("VolumeApi", "swan activity is null");
                return new fw1(1001, "swan activity is null");
            }
            if (this.f == null) {
                this.f = (AudioManager) w.getSystemService("audio");
            }
            float streamMaxVolume = this.f.getStreamMaxVolume(3);
            float streamVolume = this.f.getStreamVolume(3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", streamVolume / streamMaxVolume);
                return new fw1(0, jSONObject);
            } catch (JSONException unused) {
                return new fw1(1001, "make result json error");
            }
        }
        return (fw1) invokeV.objValue;
    }

    public final int y(float f, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)})) == null) {
            int round = Math.round(i * f);
            if (round == 0 && f > 0.0f) {
                return 1;
            }
            return round;
        }
        return invokeCommon.intValue;
    }

    public fw1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setMediaVolume", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                return new fw1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                f12.c("VolumeApi", "swan activity is null");
                return new fw1(1001, "swan activity is null");
            }
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            try {
                float parseFloat = Float.parseFloat(((JSONObject) s.second).optString("value"));
                if (this.f == null) {
                    this.f = (AudioManager) w.getSystemService("audio");
                }
                int streamMaxVolume = this.f.getStreamMaxVolume(3);
                int y = y(parseFloat, streamMaxVolume);
                if (y >= 0 && y <= streamMaxVolume) {
                    try {
                        this.f.setStreamVolume(3, y, 1);
                        return fw1.f();
                    } catch (SecurityException unused) {
                        return new fw1(1001, "Cannot set volume under silent mode.");
                    }
                }
                return new fw1(202, "value is illegal.");
            } catch (NumberFormatException unused2) {
                f12.c("VolumeApi", "illegal argument type");
                return new fw1(202, "value is illegal.");
            }
        }
        return (fw1) invokeL.objValue;
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rq4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948130260, "Lcom/baidu/tieba/rq4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948130260, "Lcom/baidu/tieba/rq4;");
                return;
            }
        }
        a = qp1.a;
    }

    public static void a(String str, String str2, String str3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, str, str2, str3, jSONObject) == null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                    jSONObject2.put("vtype", str3);
                    jSONObject.putOpt("videoId", str);
                    jSONObject2.put("data", jSONObject.toString());
                } catch (JSONException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
                g62.b("VideoStatusEventHelper", "Video dispatch Params : " + jSONObject2.toString());
                no3.d(str2, str, "video", str3, jSONObject2);
            } else if (a) {
                Log.e("VideoStatusEventHelper", "dispatchNetStatusEvent failed slaveId: " + str2 + " ,videoId: " + str);
            }
        }
    }

    public static void b(String str, String str2, String str3, int i, int i2) {
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (TextUtils.isEmpty(str3)) {
                format = "0";
            } else {
                format = new DecimalFormat("#.###").format(Double.parseDouble(str3) / 1000.0d);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("duration", Float.valueOf(Float.parseFloat(format)));
                jSONObject.putOpt("width", Integer.valueOf(xm3.O(i)));
                jSONObject.putOpt("height", Integer.valueOf(xm3.O(i2)));
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            a(str, str2, "loadedmetadata", jSONObject);
        }
    }

    public static void c(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, str2, z) == null) {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            try {
                jSONObject.putOpt("fullscreen", str3);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            a(str, str2, "fullscreenchange", jSONObject);
        }
    }
}

package com.baidu.tieba;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q14 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f)) == null) ? f <= 1.0f && f >= 0.0f : invokeF.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038965, "Lcom/baidu/tieba/q14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038965, "Lcom/baidu/tieba/q14;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("494433", ".mp3");
        a.put("524946", ".wav");
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String e = e();
            if (j() && !TextUtils.isEmpty(e)) {
                return e;
            }
            return AppRuntime.getAppContext().getCacheDir().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (bArr != null && bArr.length > 0) {
                for (byte b : bArr) {
                    String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                    if (upperCase.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(upperCase);
                }
                String sb2 = sb.toString();
                if (eo1.a) {
                    Log.e("AudioDataUtils", "audio buffer header: " + sb2);
                }
                return sb2;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) throws MalformedURLException {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str2 = str.substring(lastIndexOf);
            } else {
                str2 = "";
            }
            return "/" + u73.g0() + "/" + str.hashCode() + str2;
        }
        return (String) invokeL.objValue;
    }

    public static o14 c(r14 r14Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, r14Var)) == null) {
            o14 o14Var = new o14();
            o14Var.a = r14Var.b;
            o14Var.e = r14Var.autoplay;
            o14Var.f = r14Var.loop;
            o14Var.c = r14Var.src;
            o14Var.d = r14Var.startTime;
            o14Var.g = r14Var.obeyMuteSwitch;
            o14Var.i = r14Var.volume;
            o14Var.j = i().toString();
            return o14Var;
        }
        return (o14) invokeL.objValue;
    }

    public static String h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr != null && 3 <= bArr.length) {
                byte[] bArr2 = new byte[3];
                for (int i = 0; i < 3; i++) {
                    bArr2[i] = bArr[i];
                }
                return a.get(a(bArr2));
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = ek2.p() + "/usr";
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                Log.e("AudioDataUtils", "create targetFile dir error, path is " + file.getAbsolutePath(), new Throwable());
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return File.separator + "bdata" + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return "mounted".equals(Environment.getExternalStorageState());
        }
        return invokeV.booleanValue;
    }

    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("onCanplay", "canplay");
                jSONObject.put("onPlay", "play");
                jSONObject.put("onEnded", "ended");
                jSONObject.put(MissionEvent.MESSAGE_PAUSE, "pause");
                jSONObject.put("onSeeking", "seeking");
                jSONObject.put("onSeeked", "seeked");
                jSONObject.put(MissionEvent.MESSAGE_STOP, "stop");
                jSONObject.put("onError", "error");
                jSONObject.put("onTimeUpdate", "timeupdate");
                jSONObject.put("onBufferingUpdate", "buffered");
                jSONObject.put("onWaiting", "waiting");
            } catch (Exception e) {
                if (eo1.a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}

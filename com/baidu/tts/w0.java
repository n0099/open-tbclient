package com.baidu.tts;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aperf.bosuploader.FileUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
/* loaded from: classes9.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, bArr, i)) == null) {
            int i2 = 0;
            for (int i3 = i; i3 < i + 4; i3++) {
                i2 += (bArr[i3] & 255) << (i3 * 8);
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static v1 a(boolean z, int i, String str, w1 w1Var) {
        InterceptResult invokeCommon;
        d a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, w1Var})) == null) {
            if (!z) {
                a = z0.a().a(u0.i);
                a.b = i;
                a.c = str;
                a.a = null;
            } else {
                a = z0.a().a(u0.O);
                a.b = i;
                a.c = str;
                a.a = null;
            }
            v1 v1Var = new v1(l0.e, w1Var, a);
            LoggerProxy.d("ChunkDataHandler", "setTtsError = " + a.c);
            return v1Var;
        }
        return (v1) invokeCommon.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UUID.randomUUID().toString();
        }
        return (String) invokeV.objValue;
    }

    public static HostnameVerifier b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return new p1();
        }
        return (HostnameVerifier) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Android");
            sb.append("&");
            sb.append(Build.MODEL);
            sb.append("&");
            sb.append(Build.VERSION.RELEASE);
            sb.append("&");
            sb.append(String.valueOf(Build.VERSION.SDK_INT));
            sb.append("&");
            Pattern pattern = l2.a;
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
                i = 1;
            } else {
                i = 3;
            }
            sb.append(i);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            return str + "_" + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, strArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            for (int i = 0; i < strArr.length; i++) {
                sb.append("_");
                sb.append("%s");
            }
            return String.format(sb.toString(), strArr);
        }
        return (String) invokeLL.objValue;
    }

    public static String a(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, hashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String str : hashMap.keySet()) {
                String str2 = hashMap.get(str);
                if (str2 == null) {
                    str2 = "";
                }
                if (i == 0) {
                    sb.append(String.format("%s=%s", str, URLEncoder.encode(str2, StandardCharsets.UTF_8.name())));
                } else {
                    sb.append(String.format("&%s=%s", str, URLEncoder.encode(str2, StandardCharsets.UTF_8.name())));
                }
                i++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, closeable) != null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str == null || str.trim().length() <= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str == null) {
                str = "";
            }
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[bytes.length + 1];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(new byte[]{0}, 0, bArr, bytes.length, 1);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65544, null, z, str) != null) || z) {
            return;
        }
        throw new AssertionError(str);
    }

    public static boolean a(Context context, String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, Long.valueOf(j)})) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            return edit.commit();
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                Log.i(FileUtil.TAG, "create dest dir failed , dest dir exists！" + str);
                return false;
            } else if (file.mkdirs()) {
                Log.i(FileUtil.TAG, "create ok！" + str);
                return true;
            } else {
                Log.e(FileUtil.TAG, "create failed！" + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static byte[] a(int i, int i2, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65547, null, i, i2, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            int length = bArr.length + 4;
            byte[] bArr2 = new byte[length + 4];
            bArr2[0] = (byte) (length & 255);
            bArr2[1] = (byte) ((length >> 8) & 255);
            bArr2[2] = (byte) ((length >> 16) & 255);
            bArr2[3] = (byte) ((length >> 24) & 255);
            bArr2[4] = 1;
            bArr2[5] = (byte) i2;
            bArr2[6] = 0;
            bArr2[7] = (byte) i;
            System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
            return bArr2;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean matches;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            try {
                String trim = str.trim();
                if (trim.equals("")) {
                    matches = false;
                } else {
                    matches = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$").matcher(trim).matches();
                }
                if (!matches) {
                    return false;
                }
                String str2 = "ping6 -c 1 -W 1 " + str;
                Process exec = Runtime.getRuntime().exec(str2);
                Process exec2 = Runtime.getRuntime().exec(str2);
                Process exec3 = Runtime.getRuntime().exec(str2);
                int waitFor = exec.waitFor();
                int waitFor2 = exec2.waitFor();
                int waitFor3 = exec3.waitFor();
                if (waitFor != 0 && waitFor2 != 0 && waitFor3 != 0) {
                    LoggerProxy.d("ping6", " status = " + waitFor + " status1 = " + waitFor2 + " status2 =" + waitFor3);
                    return false;
                }
                return true;
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

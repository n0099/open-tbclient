package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
/* loaded from: classes5.dex */
public class n41 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String a() {
        InterceptResult invokeV;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.getDefault());
            switch (lowerCase.hashCode()) {
                case -1443430368:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_SMARTISAN)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1245779295:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_GIONEE)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1206476313:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_HUAWEI)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -759499589:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_XIAOMI)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3418016:
                    if (lowerCase.equals("oppo")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3620012:
                    if (lowerCase.equals("vivo")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 103777484:
                    if (lowerCase.equals("meizu")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 105170387:
                    if (lowerCase.equals(RomUtils.MANUFACTURER_NUBIA)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    String e = e("ro.build.version.emui");
                    b = e;
                    if (!TextUtils.isEmpty(e)) {
                        a = "EMUI";
                        return "EMUI";
                    }
                    return d();
                case 1:
                    String e2 = e("ro.miui.ui.version.name");
                    b = e2;
                    if (!TextUtils.isEmpty(e2)) {
                        a = "MIUI";
                        return "MIUI";
                    }
                    return d();
                case 2:
                    String e3 = e("ro.build.version.opporom");
                    b = e3;
                    if (!TextUtils.isEmpty(e3)) {
                        a = "OPPO";
                        return "OPPO";
                    }
                    return d();
                case 3:
                    String e4 = e("ro.vivo.os.version");
                    b = e4;
                    if (!TextUtils.isEmpty(e4)) {
                        a = "VIVO";
                        return "VIVO";
                    }
                    return d();
                case 4:
                    String e5 = e("ro.smartisan.version");
                    b = e5;
                    if (!TextUtils.isEmpty(e5)) {
                        a = "SMARTISAN";
                        return "SMARTISAN";
                    }
                    return d();
                case 5:
                    String e6 = e(RomUtils.KEY_VERSION_GIONEE);
                    b = e6;
                    if (!TextUtils.isEmpty(e6)) {
                        a = RomUtils.ROM_GIONEE;
                        return RomUtils.ROM_GIONEE;
                    }
                    return d();
                case 6:
                    String e7 = e(RomUtils.KEY_VERSION_NUBIA);
                    b = e7;
                    if (!TextUtils.isEmpty(e7)) {
                        a = RomUtils.ROM_NUBIA;
                        return RomUtils.ROM_NUBIA;
                    }
                    return d();
                case 7:
                    if (Build.DISPLAY.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                        a = "FLYME";
                        return "FLYME";
                    }
                    return d();
                default:
                    return d();
            }
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return Build.PRODUCT;
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = a;
            if (str == null) {
                return a();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String str = Build.DISPLAY;
            b = str;
            if (str.toUpperCase(Locale.getDefault()).contains("FLYME")) {
                a = "FLYME";
            } else {
                b = "unknown";
                a = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0064: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
                    try {
                        String readLine = bufferedReader.readLine();
                        bufferedReader.close();
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return readLine;
                    } catch (IOException e2) {
                        e = e2;
                        Log.e("Rom", "Unable to read prop " + str, e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader3 = bufferedReader2;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader3 != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}

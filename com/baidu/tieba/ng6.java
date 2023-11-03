package com.baidu.tieba;

import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class ng6 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948001548, "Lcom/baidu/tieba/ng6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948001548, "Lcom/baidu/tieba/ng6;");
                return;
            }
        }
        a = new HashMap<>();
    }

    @NonNull
    public static Map<String, String> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            HashMap hashMap = new HashMap();
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (!vj6.a(queryParameterNames)) {
                for (String str : queryParameterNames) {
                    hashMap.put("{" + str + "}", uri.getQueryParameter(str));
                }
            }
            hashMap.putAll(b());
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, String> b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (vj6.b(a)) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                a.put("{device.cuid}", inst.getCuid());
                a.put("{device.imei}", inst.getImei());
                a.put("{device.shoubaiCuid}", inst.getCuidGalaxy2());
                a.put("{device.brand}", Build.BRAND);
                a.put("{device.platform}", "Android");
                a.put("{device.clientVersion}", TbConfig.getVersion());
                a.put("{device.zid}", inst.getZid());
                a.put("{device.sign}", "tiebaclient!!!");
                a.put("{device.clientType}", "2");
                HashMap<String, String> hashMap = a;
                String str2 = "1";
                if (TbSingleton.getInstance().getSyncYYSwitch()) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("{device.is_yy_user}", str);
                a.put("{device.androidId}", inst.getAndroidId());
                a.put("{device.imsi}", inst.getIMsi());
                a.put("{device.model}", DeviceInfoHelper.getModel());
                a.put("{device.pkgName}", inst.getPackageName());
                HashMap<String, String> hashMap2 = a;
                hashMap2.put("{device.network}", BdNetTypeUtil.netType() + "");
                HashMap<String, String> hashMap3 = a;
                hashMap3.put("{device.carrier}", BdNetTypeUtil.curOperatorType() + "");
                a.put("{device.manufacturer}", DeviceInfoUtil.getDevicesManufacturer());
                a.put("{device.hardware}", Build.HARDWARE);
                a.put("{device.board}", Build.BOARD);
                HashMap<String, String> hashMap4 = a;
                if (!DeviceInfoUtil.isSupportGyroScope(inst)) {
                    str2 = "0";
                }
                hashMap4.put("{device.imu}", str2);
                a.put("{baiduId}", TbSingleton.getInstance().getBaiduIdForAnti());
                a.put("{user.tbs}", inst.getTbs());
                a.put("{client_version}", TbConfig.getVersion());
                a.put("{client_type}", "2");
                a.put("{User-Agent}", WebviewHelper.getGlobalUserAgent());
            }
            return a;
        }
        return (Map) invokeV.objValue;
    }

    public static String c(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, str)) == null) {
            String str3 = "";
            if (map != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        str2 = map.getOrDefault(str, "");
                    } else if (map.containsKey(str)) {
                        str2 = map.get(str);
                    }
                    str3 = str2;
                } catch (Exception unused) {
                    return str3;
                }
            }
            return Uri.encode(str3);
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, str)) == null) {
            if (map == null) {
                return "";
            }
            if (Build.VERSION.SDK_INT >= 24) {
                return map.getOrDefault(str, "");
            }
            if (!map.containsKey(str)) {
                return "";
            }
            return map.get(str);
        }
        return (String) invokeLL.objValue;
    }
}

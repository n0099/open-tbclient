package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Application;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.behavior.record.api.IBehaviorApi;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.security.CacheDeviceInfo;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ki {
    public static /* synthetic */ Interceptable $ic;
    public static final Application a;
    public static final DeviceInfoManager b;
    @NonNull
    public static final Map<String, String> c;
    public static ni d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309263, "Lcom/baidu/tieba/ki;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309263, "Lcom/baidu/tieba/ki;");
                return;
            }
        }
        a = BdBaseApplication.getInst();
        b = DeviceInfoManager.INSTANCE;
        c = new HashMap();
    }

    @NonNull
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return d(CacheDeviceInfo.JSON_KEY_ANDROID_ID);
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return d("ie");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d("isi");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return d("ma");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d(CacheDeviceInfo.JSON_KEY_MANUFACTURER);
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return d("md");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return d("oi");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return d("ci");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return d("ov");
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public static String d(@NonNull String str) {
        InterceptResult invokeL;
        DeviceIdBag androidId;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ni niVar = d;
            String str2 = "";
            if (niVar != null && niVar.isBrowseMode()) {
                return "";
            }
            String str3 = c.get(str);
            if (str3 != null) {
                return str3;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3112) {
                if (hashCode != 3174) {
                    if (hashCode != 3333) {
                        if (hashCode != 3356) {
                            if (hashCode != 3476) {
                                if (hashCode != 3479) {
                                    if (hashCode != 3489) {
                                        if (hashCode != 3546) {
                                            if (hashCode != 3559) {
                                                if (hashCode == 104575 && str.equals("isi")) {
                                                    c2 = '\t';
                                                }
                                            } else if (str.equals("ov")) {
                                                c2 = '\b';
                                            }
                                        } else if (str.equals("oi")) {
                                            c2 = 7;
                                        }
                                    } else if (str.equals(CacheDeviceInfo.JSON_KEY_MANUFACTURER)) {
                                        c2 = 5;
                                    }
                                } else if (str.equals("md")) {
                                    c2 = 6;
                                }
                            } else if (str.equals("ma")) {
                                c2 = 2;
                            }
                        } else if (str.equals("ie")) {
                            c2 = 1;
                        }
                    } else if (str.equals("hm")) {
                        c2 = 4;
                    }
                } else if (str.equals("ci")) {
                    c2 = 3;
                }
            } else if (str.equals(CacheDeviceInfo.JSON_KEY_ANDROID_ID)) {
                c2 = 0;
            }
            switch (c2) {
                case 0:
                    androidId = b.getAndroidId(a, "初始化", "定位问题，安全保障，个性化展示");
                    str2 = Config.NULL_DEVICE_ID;
                    break;
                case 1:
                    androidId = b.getIMEI(a, "初始化", "定位问题，安全保障，个性化展示");
                    str2 = Config.NULL_DEVICE_ID;
                    break;
                case 2:
                    androidId = b.getMacAddress(a, "初始化", "定位问题，安全保障，个性化展示");
                    break;
                case 3:
                    androidId = b.getOperator(a, "初始化", "定位问题，安全保障，个性化展示");
                    break;
                case 4:
                    androidId = b.getHarmonyVersion(a, "初始化", "定位问题，安全保障，个性化展示");
                    break;
                case 5:
                    androidId = b.getManufacturer("初始化", "定位问题，安全保障，个性化展示");
                    break;
                case 6:
                    androidId = b.getModel("初始化", "定位问题，安全保障，个性化展示");
                    break;
                case 7:
                    androidId = b.getOAID("初始化", "定位问题，安全保障，个性化展示");
                    break;
                case '\b':
                    androidId = b.getOsVersion("初始化", "定位问题，安全保障，个性化展示");
                    break;
                case '\t':
                    androidId = new DeviceIdBag();
                    try {
                        TbadkCore tbadkCore = (TbadkCore) ServiceManager.getService(TbadkCore.SERVICE_REFERENCE);
                        if (tbadkCore.permissionUtilIsAgreePrivacyPolicy() && tbadkCore.permissionUtilCheckReadPhoneState(a) && (telephonyManager = (TelephonyManager) a.getSystemService("phone")) != null) {
                            androidId.deviceId = ApiReplaceUtil.getSubscriberId(telephonyManager);
                            ((IBehaviorApi) ServiceManager.getService(IBehaviorApi.SERVICE_REFERENCE)).addBehavior(1, "isi", "tieba", "tieba");
                            break;
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + str);
            }
            String h = h(androidId, str2);
            c.put(str, h);
            return h;
        }
        return (String) invokeL.objValue;
    }

    public static String h(@NonNull DeviceIdBag deviceIdBag, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, deviceIdBag, str)) == null) {
            if (!TextUtils.isEmpty(deviceIdBag.deviceId)) {
                return deviceIdBag.deviceId;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            DisplayMetrics displayMetrics = BdBaseApplication.getInst().getResources().getDisplayMetrics();
            int i = 0;
            String[] strArr = {String.valueOf(displayMetrics.widthPixels), String.valueOf(displayMetrics.heightPixels), "android", ((TbadkCore) ServiceManager.getService(TbadkCore.SERVICE_REFERENCE)).tbConfigGetVersion(), String.valueOf(displayMetrics.densityDpi)};
            StringBuilder sb = new StringBuilder();
            String str = "";
            while (i < 5) {
                String str2 = strArr[i];
                sb.append(str);
                sb.append(str2);
                i++;
                str = "_";
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void m(ni niVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, niVar) == null) {
            d = niVar;
        }
    }
}

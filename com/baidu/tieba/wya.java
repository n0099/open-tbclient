package com.baidu.tieba;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static void w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, context) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Intent a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        public /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.getIntExtra("level", 0);
            }
            return invokeV.intValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.getIntExtra("scale", 0);
            }
            return invokeV.intValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.getIntExtra("temperature", 0);
            }
            return invokeV.intValue;
        }

        public final int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.getIntExtra("voltage", 0);
            }
            return invokeV.intValue;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String p = p();
                if (!TextUtils.isEmpty(p)) {
                    jSONObject.put("os", p);
                }
                String i = i(context);
                if (!TextUtils.isEmpty(i)) {
                    jSONObject.put("imei", i);
                }
                String m = m(context);
                if (!TextUtils.isEmpty(m)) {
                    jSONObject.put("meid", m);
                }
                String j = j(context);
                if (!TextUtils.isEmpty(j)) {
                    jSONObject.put(BaseStatisContent.IMSI, j);
                }
                String k = k(context);
                if (!TextUtils.isEmpty(k)) {
                    jSONObject.put("mac", k);
                }
                String h = h(context);
                if (!TextUtils.isEmpty(h)) {
                    jSONObject.put("iccid", h);
                }
                String s = s();
                if (!TextUtils.isEmpty(s)) {
                    jSONObject.put("serial", s);
                }
                String c = c(context);
                if (!TextUtils.isEmpty(c)) {
                    jSONObject.put("androidid", c);
                }
                String f = f();
                if (!TextUtils.isEmpty(f)) {
                    jSONObject.put("cpu", f);
                }
                String o = o();
                if (!TextUtils.isEmpty(o)) {
                    jSONObject.put("model", o);
                }
                String r = r();
                if (!TextUtils.isEmpty(r)) {
                    jSONObject.put("sdcard", r);
                }
                String q = q(context);
                if (!TextUtils.isEmpty(q)) {
                    jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, q);
                }
                String u = u(context);
                if (!TextUtils.isEmpty(u)) {
                    jSONObject.put(YyLiveRoomConfig.KEY_SSID, u);
                }
                String v = v(context);
                if (!TextUtils.isEmpty(v)) {
                    jSONObject.put("bssid", v);
                }
                String g = g();
                if (!TextUtils.isEmpty(g)) {
                    jSONObject.put("deviceName", g);
                }
                String e = e(context);
                if (!TextUtils.isEmpty(e)) {
                    jSONObject.put("connecttype", e);
                }
                try {
                    str = b(context);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("ua", str);
                }
                double d = d(context);
                jSONObject.put("batterymaxcapacity", String.valueOf(d));
                jSONObject.put("batterycurrentcapacity", String.valueOf(d));
                b bVar = new b(context, null);
                jSONObject.put("batterycurrentvoltage", bVar.h());
                jSONObject.put("batterycurrenttemperature", bVar.g());
                jSONObject.put("batterycurrentcapacity", (d * bVar.e()) / bVar.f());
                return jSONObject.toString();
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName) && packageName.contains("com.sina.weibo")) {
                str = "weibo";
            } else {
                str = "ssosdk";
            }
            sb.append(Build.MANUFACTURER);
            sb.append("-");
            sb.append(Build.MODEL);
            sb.append("__");
            sb.append(str);
            sb.append("__");
            try {
                sb.append("1.0".replaceAll("\\s+", "_"));
            } catch (Exception unused) {
                sb.append("unknown");
            }
            sb.append("__");
            sb.append("android");
            sb.append("__android");
            sb.append(Build.VERSION.RELEASE);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str2 = "none";
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
            }
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2G";
                            str2 = str;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "3G";
                            str2 = str;
                            break;
                        case 13:
                            str = "4G";
                            str2 = str;
                            break;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    str = "wifi";
                    str2 = str;
                }
                return str2;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return ApiReplaceUtil.getSimSerialNumber((TelephonyManager) context.getSystemService("phone"));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return ApiReplaceUtil.getSubscriberId((TelephonyManager) context.getSystemService("phone"));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                return ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                return new String(a(context).getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getSSID();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getBSSID();
                }
                return "";
            } catch (SecurityException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static double d(Context context) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
            } catch (Exception unused) {
                obj = null;
            }
            try {
                return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, "battery.capacity")).doubleValue();
            } catch (Exception unused2) {
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                return String.valueOf(displayMetrics.widthPixels) + "*" + String.valueOf(displayMetrics.heightPixels);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                return Build.CPU_ABI;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                return Build.BRAND;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            try {
                return Build.MODEL;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            try {
                return "Android " + Build.VERSION.RELEASE;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @TargetApi(26)
    public static String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            try {
                return Build.getSerial();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return l();
            }
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                    return "";
                }
                return ApiReplaceUtil.getMacAddress(connectionInfo);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = ApiReplaceUtil.getHardwareAddress(networkInterface);
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return t();
            }
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}

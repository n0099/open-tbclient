package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class wm {
    public static /* synthetic */ Interceptable $ic;
    public static wm q;
    public static HashMap<String, Integer> r;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public SharedPreferences l;
    public String m;
    public Context n;
    public String o;
    public boolean p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448320919, "Lcom/baidu/tieba/wm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448320919, "Lcom/baidu/tieba/wm;");
                return;
            }
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        r = hashMap;
        hashMap.put("WIFI", 1);
        r.put("3GNET", 21);
        r.put("3GWAP", 22);
        r.put("CMNET", 31);
        r.put("UNINET", 32);
        r.put("CTNET", 33);
        r.put("CMWAP", 41);
        r.put("UNIWAP", 42);
        r.put("CTWAP", 43);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "BaiduIdentityManager [mUid=" + this.a + ", mEnUid=" + this.b + ", mUa=" + this.c + ", mEnUa=" + this.d + ", mTn=" + s() + ", mLastTn=" + q() + ", mModel=" + this.g + ", mManufacturer=" + this.h + ", mOSVersion=" + this.i + ", mDeviceInfo=" + this.j + ", mEnDeviceInfo=" + this.k + ", mSettings=" + this.l + ", mVersionName=" + this.m + ", mCtv=" + this.o + ", mProcessedUa=" + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public wm(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = false;
        this.n = context;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            String string = this.l.getString(BaiduIdentityManager.KEY_TN_TRACE, "");
            if (!TextUtils.isEmpty(string)) {
                str = string + "_" + str;
            }
            SharedPreferences.Editor edit = this.l.edit();
            edit.putString(BaiduIdentityManager.KEY_TN_TRACE, str);
            edit.apply();
        }
    }

    public static synchronized wm p() {
        InterceptResult invokeV;
        wm wmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (wm.class) {
                if (q == null) {
                    q = new wm(AppRuntime.getAppContext());
                }
                wmVar = q;
            }
            return wmVar;
        }
        return (wm) invokeV.objValue;
    }

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f == null) {
                this.f = r(this.n);
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.e == null) {
                this.e = t(this.n);
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (this) {
                this.c = u(this.n);
                this.d = new String(Base64Encoder.B64Encode(this.c.getBytes()));
            }
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return g(str, "cfrom", "tieba");
        }
        return (String) invokeL.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return g(str, "from", s());
        }
        return (String) invokeL.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return g(str, "pkgname", this.n.getPackageName());
        }
        return (String) invokeL.objValue;
    }

    public final String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            return CommonParam.getCUID(context);
        }
        return (String) invokeL.objValue;
    }

    public final String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            if (!TextUtils.isEmpty("")) {
                return "";
            }
            return "757b";
        }
        return (String) invokeL.objValue;
    }

    public final String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "0.8";
            }
        }
        return (String) invokeL.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String g = g(g(h(str, BaiduIdentityManager.PARAM_SERVICE), "uid", new String(Base64Encoder.B64Encode("0".getBytes()))), "from", "757b");
            String d = d(d(d(null, "uid"), "ua"), "ut");
            String g2 = g(g(g(g(g(g, "ua", o(new String(Base64Encoder.B64Encode("320_480_android_0.8_1".getBytes())))), "ut", o(new String(Base64Encoder.B64Encode((j(zi.g(), null) + "_" + j(zi.k(), "0.0") + "_" + Build.VERSION.SDK_INT + "_" + j(zi.f(), null)).getBytes())))), BaiduIdentityManager.PARAM_OSNAME, BaiduIdentityManager.VALUE_OSNAME), BaiduIdentityManager.PARAM_OSBRANCH, "a0"), "pkgname", this.n.getPackageName());
            int B64GetVersion = Base64Encoder.B64GetVersion();
            if (B64GetVersion == 0) {
                str2 = "1";
            } else {
                str2 = B64GetVersion + "";
            }
            if (!TextUtils.isEmpty(d) && !TextUtils.equals(str2, "1")) {
                g2 = g(g2, BaiduIdentityManager.PARAM_CEN, d);
            }
            g(str, "network", NetworkParam.NET_TYPE_ID_DISCONNECT);
            g(g2, "cfrom", "757b");
            g(g2, "typeid", "0");
            return g2;
        }
        return (String) invokeL.objValue;
    }

    public final String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2.replace("_", "-");
            }
            return str + "_" + str2.replace("_", "-");
        }
        return (String) invokeLL.objValue;
    }

    public final String e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            if (z) {
                String m = m();
                if (TextUtils.equals(m, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                    return g(str, "network", PreferenceManager.getDefaultSharedPreferences(this.n.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, NetworkParam.NET_TYPE_ID_DISCONNECT));
                }
                if (!TextUtils.isEmpty(m)) {
                    if (!TextUtils.equals(m, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.n.getApplicationContext()).edit();
                        edit.putString(NetworkParam.LAST_NETWORK_TYPE, m);
                        edit.apply();
                    }
                    return g(str, "network", m);
                }
                return str;
            }
            return g(str, "network", m());
        }
        return (String) invokeLZ.objValue;
    }

    public String g(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            return UrlUtil.addParam(str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }

    public final String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            return g(str, "service", str2);
        }
        return (String) invokeLL.objValue;
    }

    public final String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "NUL";
            }
            if (!TextUtils.isEmpty(str)) {
                return str.replace("_", "-");
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ConnectManager connectManager = new ConnectManager(this.n);
            String netType = connectManager.getNetType();
            int subType = connectManager.getSubType();
            Integer num = 5;
            if (!TextUtils.isEmpty(netType)) {
                Integer num2 = r.get(netType.toUpperCase());
                if (num2 != null) {
                    num = num2;
                }
                return num + "_" + subType;
            }
            return num + "_" + subType;
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String str = this.g + "_" + this.i + "_" + Build.VERSION.SDK_INT + "_" + this.h;
            DefaultLog.getInstance().c(TitanDownloadService.TAG, "device info : " + str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, context)) == null) {
            String string = this.l.getString(BaiduIdentityManager.KEY_LAST_TN, "");
            String l = l(context);
            if (!(!TextUtils.equals(string, l)) && !TextUtils.isEmpty(string)) {
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.c(TitanDownloadService.TAG, "load tn from local, lastTn = " + string);
                return string;
            }
            SharedPreferences.Editor edit = this.l.edit();
            edit.putString(BaiduIdentityManager.KEY_LAST_TN, l);
            edit.apply();
            i(l);
            ew8 defaultLog2 = DefaultLog.getInstance();
            defaultLog2.c(TitanDownloadService.TAG, "load tn from apk, lastTn = " + l);
            return l;
        }
        return (String) invokeL.objValue;
    }

    public final String u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) {
            int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
            String str = String.valueOf(displayWidth) + "_" + DeviceUtil.ScreenInfo.getDisplayHeight(context) + "_android_" + this.m + "_" + DeviceUtil.ScreenInfo.getDensityDpi(context);
            DefaultLog.getInstance().c(TitanDownloadService.TAG, "ua = " + str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
            String string = this.l.getString("uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                String k = k(context);
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.c(TitanDownloadService.TAG, "new generated uid " + k);
                SharedPreferences.Editor edit = this.l.edit();
                edit.putString("uid_v3", k);
                edit.apply();
                return k;
            }
            ew8 defaultLog2 = DefaultLog.getInstance();
            defaultLog2.c(TitanDownloadService.TAG, "load uid from local " + string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
            String str = "";
            String string = this.l.getString("tnconfig", "");
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty("")) {
                    str = q();
                }
                SharedPreferences.Editor edit = this.l.edit();
                edit.putString("tnconfig", str);
                edit.apply();
                string = str;
            } else {
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.c(TitanDownloadService.TAG, "load tn from local, tn = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                return "757b";
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public String z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            try {
                if (!this.p) {
                    x();
                }
                return g(a(e(f(g(g(c(g(str, "uid", o(this.b))), "ua", o(this.c)), "ut", o(this.j))), false)), "typeid", "0");
            } catch (Throwable unused) {
                return b(str);
            }
        }
        return (String) invokeL.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.l = this.n.getSharedPreferences("identity", 0);
            String v = v(this.n);
            this.a = v;
            if (!TextUtils.isEmpty(v)) {
                this.b = new String(Base64Encoder.B64Encode(this.a.getBytes()));
            }
            String g = zi.g();
            this.g = g;
            if (TextUtils.isEmpty(g)) {
                this.g = "NUL";
            } else {
                this.g = this.g.replace("_", "-");
            }
            String f = zi.f();
            this.h = f;
            if (TextUtils.isEmpty(f)) {
                this.h = "NUL";
            } else {
                this.h = this.h.replace("_", "-");
            }
            String k = zi.k();
            this.i = k;
            if (TextUtils.isEmpty(k)) {
                this.i = "0.0";
            } else {
                this.i = this.i.replace("_", "-");
            }
            this.j = n();
            this.k = new String(Base64Encoder.B64Encode(this.j.getBytes()));
            this.m = w(this.n);
            y();
            int B64GetVersion = Base64Encoder.B64GetVersion();
            if (B64GetVersion == 0) {
                this.o = "1";
            } else {
                this.o = B64GetVersion + "";
            }
            this.p = true;
        }
    }
}

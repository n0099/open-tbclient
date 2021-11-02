package com.bun.miitmdid.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class sysParamters {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile sysParamters f61224e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f61225a;

    /* renamed from: b  reason: collision with root package name */
    public String f61226b;

    /* renamed from: c  reason: collision with root package name */
    public String f61227c;

    /* renamed from: d  reason: collision with root package name */
    public String f61228d;
    @Keep
    public String sdk_version;
    @Keep
    public String sdk_vname;

    public sysParamters() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61228d = "Android";
        this.sdk_version = "10011";
        this.sdk_vname = "1.0.11";
    }

    public static PackageInfo a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0);
            } catch (Exception unused) {
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static sysParamters a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f61224e == null) {
                synchronized (sysParamters.class) {
                    if (f61224e == null) {
                        f61224e = new sysParamters();
                    }
                }
            }
            return f61224e;
        }
        return (sysParamters) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return "0.1.100";
            }
            PackageInfo a2 = a(context, context.getPackageName());
            if (a2 == null) {
                return null;
            }
            return a2.versionName;
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            ApplicationInfo applicationInfo = b.a().getApplicationInfo();
            return (applicationInfo == null || TextUtils.isEmpty(applicationInfo.packageName)) ? h() : applicationInfo.packageName;
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b.a().getPackageName() : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f61225a)) {
                String a2 = a(b.a());
                this.f61225a = a2;
                return a2;
            }
            return this.f61225a;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sdk_version : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.f61226b)) {
                String str = Build.MODEL;
                this.f61226b = str;
                String replace = str.replace(" ", "-");
                this.f61226b = replace;
                return replace;
            }
            return this.f61226b;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f61227c)) {
                String encode = Uri.encode(Build.MANUFACTURER);
                this.f61227c = encode;
                return encode;
            }
            return this.f61227c;
        }
        return (String) invokeV.objValue;
    }
}

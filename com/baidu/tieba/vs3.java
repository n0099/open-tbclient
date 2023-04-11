package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
@SuppressLint({"MissingPermission", "HardwareIds"})
/* loaded from: classes6.dex */
public class vs3 implements xs3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xs3
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948251315, "Lcom/baidu/tieba/vs3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948251315, "Lcom/baidu/tieba/vs3;");
                return;
            }
        }
        a = eo1.a;
    }

    public vs3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.xs3
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xs3
    public String c(Context context) {
        InterceptResult invokeL;
        String meid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        meid = "";
                    } else {
                        meid = telephonyManager.getMeid();
                    }
                    if (TextUtils.isEmpty(meid)) {
                        return "";
                    }
                    return meid;
                } catch (Exception e) {
                    u42.o("DeviceInfoImpl", "getMeid: catch " + e + "\n" + Log.getStackTraceString(e));
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xs3
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = ApiReplaceUtil.getDeviceId(telephonyManager);
                    if (!TextUtils.isEmpty(deviceId)) {
                        return deviceId;
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        deviceId = ApiReplaceUtil.getImei(telephonyManager);
                    }
                    if (TextUtils.isEmpty(deviceId)) {
                        return "";
                    }
                    return deviceId;
                }
            } catch (Exception e) {
                u42.o("DeviceInfoImpl", "getImei: catch " + e + "\n" + Log.getStackTraceString(e));
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xs3
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        String deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (a) {
                    Log.d("DeviceInfoImpl", "android 29 can not get imei");
                }
                return "";
            }
            Application c = br2.c();
            if (ContextCompat.checkSelfPermission(c, com.kuaishou.weapon.p0.h.c) != 0) {
                return "";
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
                if (telephonyManager == null) {
                    deviceId = "";
                } else {
                    deviceId = ApiReplaceUtil.getDeviceId(telephonyManager);
                }
                if (TextUtils.isEmpty(deviceId)) {
                    return "";
                }
                return deviceId;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}

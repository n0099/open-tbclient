package com.bun.miitmdid.provider.nubia;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.e0;
/* loaded from: classes11.dex */
public class NubiaIdentityImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NubiaIdentityImpl";
    public static Uri uri;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-570988164, "Lcom/bun/miitmdid/provider/nubia/NubiaIdentityImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-570988164, "Lcom/bun/miitmdid/provider/nubia/NubiaIdentityImpl;");
                return;
            }
        }
        uri = Uri.parse("content://cn.nubia.identity/identity");
    }

    public NubiaIdentityImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Object generalMethod(Context context, String str, @Nullable String str2, String str3, Class<?> cls) {
        InterceptResult invokeLLLLL;
        Bundle call;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, context, str, str2, str3, cls)) == null) {
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                    if (acquireContentProviderClient == null) {
                        e0.d(TAG, "generalMethod: contentResolver is null");
                        return null;
                    }
                    call = acquireContentProviderClient.call(str, str2, null);
                    if (i2 >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    call = context.getContentResolver().call(uri, str, str2, (Bundle) null);
                }
                if (call == null) {
                    e0.d(TAG, "generalMethod: bundle is null");
                    return null;
                } else if (call.getInt("code", -1) == 0) {
                    e0.c(TAG, "generalMethod: success");
                    if (cls == Boolean.class) {
                        return Boolean.valueOf(call.getBoolean(str3, false));
                    }
                    if (cls == String.class) {
                        return call.getString(str3, "");
                    }
                    return null;
                } else {
                    String string = call.getString("message");
                    e0.d(TAG, "generalMethod: failed:" + string);
                    return null;
                }
            } catch (Exception e2) {
                e0.d(TAG, "generalMethod: Exception: " + e2.getMessage());
                return null;
            }
        }
        return invokeLLLLL.objValue;
    }

    public static String getAAID(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            Object generalMethod = generalMethod(context, "getAAID", str, "id", String.class);
            return generalMethod == null ? "" : (String) generalMethod;
        }
        return (String) invokeLL.objValue;
    }

    public static String getOAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Object generalMethod = generalMethod(context, "getOAID", null, "id", String.class);
            return generalMethod == null ? "" : (String) generalMethod;
        }
        return (String) invokeL.objValue;
    }

    public static String getVAID(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            Object generalMethod = generalMethod(context, "getVAID", str, "id", String.class);
            return generalMethod == null ? "" : (String) generalMethod;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isSupported(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            Object generalMethod = generalMethod(context, "isSupport", null, "issupport", Boolean.class);
            if (generalMethod == null) {
                return false;
            }
            return ((Boolean) generalMethod).booleanValue();
        }
        return invokeL.booleanValue;
    }
}

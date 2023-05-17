package com.bun.miitmdid.provider.nubia;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.f0;
@Keep
/* loaded from: classes8.dex */
public class NubiaIdentityImpl {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final String TAG = "NubiaIdentityImpl";
    @Keep
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                int i = Build.VERSION.SDK_INT;
                if (i >= 17) {
                    ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                    if (acquireContentProviderClient == null) {
                        f0.d(TAG, "generalMethod: contentResolver is null");
                        return null;
                    }
                    call = acquireContentProviderClient.call(str, str2, null);
                    if (i >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    call = context.getContentResolver().call(uri, str, str2, (Bundle) null);
                }
                if (call == null) {
                    f0.d(TAG, "generalMethod: bundle is null");
                    return null;
                } else if (call.getInt("code", -1) == 0) {
                    f0.c(TAG, "generalMethod: success");
                    if (cls == Boolean.class) {
                        return Boolean.valueOf(call.getBoolean(str3, false));
                    }
                    if (cls == String.class) {
                        return call.getString(str3, "");
                    }
                    return null;
                } else {
                    String string = call.getString("message");
                    f0.d(TAG, "generalMethod: failed:" + string);
                    return null;
                }
            } catch (Exception e) {
                f0.d(TAG, "generalMethod: Exception: " + e.getMessage());
                return null;
            }
        }
        return invokeLLLLL.objValue;
    }

    @Keep
    public static native String getAAID(Context context, String str);

    @Keep
    public static native String getOAID(Context context);

    @Keep
    public static native String getVAID(Context context, String str);

    @Keep
    public static native boolean isSupported(Context context);
}

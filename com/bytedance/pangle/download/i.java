package com.bytedance.pangle.download;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.webkit.ProxyConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f62256a;

    /* renamed from: b  reason: collision with root package name */
    public static a f62257b;

    /* renamed from: c  reason: collision with root package name */
    public static String f62258c;

    /* renamed from: d  reason: collision with root package name */
    public static int f62259d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1012230869, "Lcom/bytedance/pangle/download/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1012230869, "Lcom/bytedance/pangle/download/i;");
                return;
            }
        }
        f62256a = Build.VERSION.SDK_INT > 19;
        f62258c = "";
        f62259d = -1;
        f62257b = new a();
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        DisplayMetrics displayMetrics;
        DisplayMetrics displayMetrics2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (TextUtils.isEmpty(f62258c) && context != null) {
                int i2 = 0;
                int i3 = (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) ? 0 : displayMetrics.widthPixels;
                if (context != null && (displayMetrics2 = context.getResources().getDisplayMetrics()) != null) {
                    i2 = displayMetrics2.heightPixels;
                }
                if (i3 > 0 && i2 > 0) {
                    f62258c = i3 + ProxyConfig.MATCH_ALL_SCHEMES + i2;
                }
            }
            return f62258c;
        }
        return (String) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f62259d == -1 && context != null) {
                f62259d = context.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
            }
            return f62259d;
        }
        return invokeL.intValue;
    }
}

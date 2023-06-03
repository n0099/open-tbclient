package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075452, "Lcom/baidu/tieba/r83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075452, "Lcom/baidu/tieba/r83;");
                return;
            }
        }
        a = is1.a;
    }

    public static void a(Message message) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, message) == null) {
            if (a) {
                Log.e("ChannelMsgProcessor", "MSG_TYPE_CS_DELEGATION");
            }
            int i = message.arg1;
            Bundle bundle2 = (Bundle) message.obj;
            String str = "";
            String str2 = null;
            if (bundle2 != null) {
                str2 = bundle2.getString("ai_apps_delegation_name", null);
                str = bundle2.getString("ai_apps_observer_id", "");
                bundle = bundle2.getBundle("ai_apps_data");
            } else {
                bundle = null;
            }
            z73.a(i, str2, str, bundle);
        }
    }

    public static void b(Message message) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, message) == null) {
            Bundle bundle2 = (Bundle) message.obj;
            String str = "";
            String str2 = null;
            if (bundle2 != null) {
                str2 = bundle2.getString("ai_apps_delegation_name", null);
                str = bundle2.getString("ai_apps_observer_id", "");
                bundle = bundle2.getBundle("ai_apps_data");
            } else {
                bundle = null;
            }
            z73.a(-1000, str2, str, bundle);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, message) == null) {
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                if (!a) {
                    return;
                }
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            Bundle bundle = (Bundle) obj;
            b83 b83Var = new b83(bundle.getString("key_observer_id", ""));
            b83Var.setResult(bundle.getBundle("key_result_data"));
            c83.b().c(b83Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, message) == null) {
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                if (!a) {
                    return;
                }
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            Bundle bundle = (Bundle) obj;
            b83 b83Var = new b83(bundle.getString("key_observer_id", ""));
            b83Var.setResult(bundle.getBundle("key_result_data"));
            c83.b().c(b83Var);
        }
    }

    public static void e(int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, bundle) == null) {
            o83 e = o83.e();
            q83 q83Var = new q83(126, bundle);
            q83Var.a(i);
            e.h(q83Var);
        }
    }

    public static void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bundle) == null) {
            o83.e().h(new q83(21, bundle));
        }
    }
}

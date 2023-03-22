package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class n70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SharedPreferences a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Object c;

        public a(SharedPreferences sharedPreferences, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedPreferences, str, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sharedPreferences;
            this.b = str;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n70.n(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Set c;

        public b(Context context, String str, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = str;
            this.c = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getSharedPreferences("track_sp", 0).edit().putStringSet(this.b, this.c).apply();
            }
        }
    }

    public static int g(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, context, str, i)) == null) {
            return context.getSharedPreferences("track_sp", 0).getInt(str, i);
        }
        return invokeLLI.intValue;
    }

    public static Set<String> h(Context context, String str, Set<String> set) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, set)) == null) {
            return context.getSharedPreferences("track_sp", 0).getStringSet(str, set);
        }
        return (Set) invokeLLL.objValue;
    }

    public static void i(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, null, context, i, i2) == null) {
            l(context, i + "real_time_track", i2);
        }
    }

    public static void l(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65547, null, context, str, i) == null) {
            p(context, str, Integer.valueOf(i));
        }
    }

    public static Set<String> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return h(context, "track_connection", new HashSet());
        }
        return (Set) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return g(context, "login_open_type", -1);
        }
        return invokeL.intValue;
    }

    public static Set<String> d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return h(context, "track_request", new HashSet());
        }
        return (Set) invokeL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (g(context, "track_upload_state", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            if (g(context, i + "real_time_track", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void j(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, context, i) == null) {
            l(context, "track_upload_state", i);
        }
    }

    public static void k(Context context, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, set) == null) {
            q(context, "track_connection", set);
        }
    }

    public static void m(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, context, i) == null) {
            l(context, "login_open_type", i);
        }
    }

    public static void o(Context context, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, set) == null) {
            q(context, "track_request", set);
        }
    }

    public static void n(SharedPreferences sharedPreferences, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, sharedPreferences, str, obj) == null) {
            if (obj instanceof Boolean) {
                sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            } else if (obj instanceof Integer) {
                sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
            } else if (obj instanceof Long) {
                sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
            } else if (obj instanceof Float) {
                sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
            } else if (obj instanceof String) {
                sharedPreferences.edit().putString(str, (String) obj).apply();
            }
        }
    }

    public static void p(Context context, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, str, obj) == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("track_sp", 0);
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    n80.a(context).b(new a(sharedPreferences, str, obj));
                } else {
                    n(sharedPreferences, str, obj);
                }
            } catch (Throwable th) {
                q80.b("TrackUtils", th.getMessage());
            }
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void q(Context context, String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, str, set) == null) {
            try {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    n80.a(context).b(new b(context, str, set));
                } else {
                    context.getSharedPreferences("track_sp", 0).edit().putStringSet(str, set).apply();
                }
            } catch (Throwable th) {
                q80.b("TrackUtils", th.getMessage());
            }
        }
    }
}

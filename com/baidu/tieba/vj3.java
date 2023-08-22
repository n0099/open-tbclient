package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tieba.lh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes8.dex */
public class vj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static Set<String> b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lh3.b bVar = new lh3.b(10010);
                bVar.l(String.valueOf(vj3.c));
                bVar.k(this.a);
                bVar.j(String.valueOf(this.b));
                bVar.h(db3.g0());
                bVar.m();
                if (this.b == 3) {
                    int unused = vj3.c = 0;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mv3<Pair<String, File>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(vj3 vj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mv3
        /* renamed from: a */
        public void run(@NonNull Pair<String, File> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                if (vj3.b != null && pair.first != null && vj3.b.contains(pair.first)) {
                    new uj3(ku2.c(), pair.first).clearAll();
                    return;
                }
                File file = pair.second;
                if (file != null) {
                    hr4.L(file);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Callable<SharedPreferences> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ vj3 e;

        public c(vj3 vj3Var, uj3 uj3Var, long j, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj3Var, uj3Var, Long.valueOf(j), context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vj3Var;
            this.a = uj3Var;
            this.b = j;
            this.c = context;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public SharedPreferences call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.a.setCustomMeta(this.b | 1)) {
                    return null;
                }
                String l = this.e.l(this.c, this.d);
                if (vj3.a) {
                    Log.i("SwanExtensionApiImpl", String.format("customMeta=%d, name=%s, spName=%s", Long.valueOf(this.b), this.d, l));
                }
                if (l == null) {
                    return null;
                }
                return this.c.getSharedPreferences(l, 0);
            }
            return (SharedPreferences) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final vj3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-344557974, "Lcom/baidu/tieba/vj3$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-344557974, "Lcom/baidu/tieba/vj3$d;");
                    return;
                }
            }
            a = new vj3(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948242666, "Lcom/baidu/tieba/vj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948242666, "Lcom/baidu/tieba/vj3;");
                return;
            }
        }
        a = nr1.a;
        b = new CopyOnWriteArraySet();
        c = 0;
    }

    public vj3() {
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

    public static vj3 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return d.a;
        }
        return (vj3) invokeV.objValue;
    }

    public /* synthetic */ vj3(a aVar) {
        this();
    }

    public final fr4 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return new nr4(str);
        }
        return (fr4) invokeL.objValue;
    }

    public void g(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, set, z) == null) {
            h(str, set, z);
            oj2.c(new File(uj3.c()), str, SwanKV.PREFS_SUFFIX, set, z, new b(this));
        }
    }

    public void h(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, set, z) == null) {
            oj2.b(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ActivityChooserModel.HISTORY_FILE_EXTENSION, set, z);
        }
    }

    public final void m(Context context, String str, @NonNull uj3 uj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, uj3Var) == null) {
            long customMeta = uj3Var.getCustomMeta();
            if ((customMeta & 1) == 1) {
                return;
            }
            uj3Var.importFromSharedPreferences(new c(this, uj3Var, customMeta, context, str));
        }
    }

    @AnyThread
    public static void i(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, str) == null) {
            xn3.f().execute(new a(str, i));
        }
    }

    @NonNull
    @AnyThread
    public fr4 k(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, context, str, z)) == null) {
            try {
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                uj3 uj3Var = new uj3(context, str, i);
                b.add(str);
                m(context, str, uj3Var);
                if (c > 0) {
                    i(3, str);
                }
                return uj3Var;
            } catch (NoClassDefFoundError | UnsatisfiedLinkError e) {
                if (a) {
                    Log.e("SwanExtensionApiImpl", "getSharedPrefsImpl", e);
                }
                c++;
                i(2, str);
                return f(str);
            }
        }
        return (fr4) invokeLLZ.objValue;
    }

    @Nullable
    public final String l(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            if (str == null) {
                str = context.getPackageName() + "_preferences";
            }
            if ("default".equals(str)) {
                if (nr4.d(context, str).exists()) {
                    return str;
                }
                str = context.getPackageName() + "_preferences";
            }
            if (nr4.d(context, str).exists()) {
                return str;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}

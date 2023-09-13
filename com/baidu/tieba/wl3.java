package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.l63;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wl3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public c b;
    public final l63.a c;

    /* loaded from: classes8.dex */
    public class a implements l63.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl3 a;

        public a(wl3 wl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl3Var;
        }

        @Override // com.baidu.tieba.l63.a
        public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 700 && iArr.length > 0 && iArr[0] == 0 && this.a.b != null) {
                this.a.b.a(this.a.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final wl3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-314081843, "Lcom/baidu/tieba/wl3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-314081843, "Lcom/baidu/tieba/wl3$b;");
                    return;
                }
            }
            a = new wl3(null);
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Vibrator a;

        public c(@NonNull Vibrator vibrator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vibrator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vibrator;
        }

        @SuppressLint({"MissingPermission"})
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                try {
                    if (on3.j()) {
                        this.a.vibrate(VibrationEffect.createOneShot(j, -1));
                        return;
                    }
                    this.a.vibrate(j);
                } catch (Exception unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948274379, "Lcom/baidu/tieba/wl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948274379, "Lcom/baidu/tieba/wl3;");
                return;
            }
        }
        d = rr1.a;
    }

    public static wl3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return b.a;
        }
        return (wl3) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!on3.h()) {
                return true;
            }
            Context appContext = AppRuntime.getAppContext();
            if (appContext != null && ContextCompat.checkSelfPermission(appContext, "android.permission.VIBRATE") == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e(400L);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(15L);
        }
    }

    public wl3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.c = new a(this);
        Vibrator vibrator = (Vibrator) AppRuntime.getAppContext().getSystemService("vibrator");
        if (vibrator != null) {
            this.b = new c(vibrator);
        }
    }

    public /* synthetic */ wl3(a aVar) {
        this();
    }

    @SuppressLint({"BDThrowableCheck"})
    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.a = j;
            if (this.b == null) {
                if (!d) {
                    return;
                }
                throw new RuntimeException("not support vibration");
            } else if (c()) {
                this.b.a(this.a);
            } else {
                String[] strArr = {"android.permission.VIBRATE"};
                SwanAppActivity w = gb3.K().w();
                if (w != null) {
                    w.z(700, strArr, this.c);
                }
            }
        }
    }
}

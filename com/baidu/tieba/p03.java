package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.i43;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
/* loaded from: classes5.dex */
public final class p03 extends hp2<p03> implements o03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public final q03 b;
    public final String c;
    public final Set<xi3<i43.a>> d;
    public final Set<xi3<p03>> e;
    public final Set<String> f;
    public final Set<Integer> g;
    public Exception h;
    public long i;
    public boolean j;
    public final Runnable k;

    public p03 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this : (p03) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p03 a;

        public a(p03 p03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (this.a.b) {
                this.a.b.b0(this.a, this.a.W());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008182, "Lcom/baidu/tieba/p03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008182, "Lcom/baidu/tieba/p03;");
                return;
            }
        }
        l = ok1.a;
    }

    public Exception N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (Exception) invokeV.objValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.h != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.i < 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.aj3
    public /* bridge */ /* synthetic */ aj3 a() {
        Y();
        return this;
    }

    public p03 call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return call(o03.n0);
        }
        return (p03) invokeV.objValue;
    }

    public p03(@NonNull q03 q03Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q03Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = null;
        this.i = 0L;
        this.j = false;
        this.k = new a(this);
        this.b = q03Var;
        if (TextUtils.isEmpty(str)) {
            str2 = UUID.randomUUID().toString();
        } else {
            str2 = str;
        }
        this.c = str2;
        if (l) {
            U("IpcSession", "host=" + q03Var + " id=" + str + " mId=" + this.c);
        }
    }

    public p03 F(xi3<p03> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xi3Var)) == null) {
            H(this.e, xi3Var);
            return this;
        }
        return (p03) invokeL.objValue;
    }

    public p03 G(xi3<i43.a> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var)) == null) {
            H(this.d, xi3Var);
            return this;
        }
        return (p03) invokeL.objValue;
    }

    public p03 I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            synchronized (this.b) {
                this.g.add(Integer.valueOf(i));
                Y();
            }
            return this;
        }
        return (p03) invokeI.objValue;
    }

    public p03 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this.b) {
                this.f.add(str);
                Y();
            }
            return this;
        }
        return (p03) invokeL.objValue;
    }

    public p03 K(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            synchronized (this.b) {
                this.j = z;
                Y();
            }
            return this;
        }
        return (p03) invokeZ.objValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && l) {
            Log.i("IpcSession", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public static String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                ActivityManager activityManager = (ActivityManager) AppRuntime.getAppContext().getSystemService("activity");
                if (activityManager == null) {
                    return "ActivityManager=null";
                }
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return "RunningAppProcessInfoList=null";
                }
                StringBuilder sb = new StringBuilder();
                String str = "";
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null) {
                        sb.append(str);
                        sb.append(runningAppProcessInfo.processName);
                        str = ",";
                    }
                }
                return sb.toString();
            } catch (Exception e) {
                return e.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public final <CallBackT> p03 H(@NonNull Set<CallBackT> set, CallBackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, callbackt)) == null) {
            synchronized (this.b) {
                if (Z() && callbackt != null) {
                    set.add(callbackt);
                }
            }
            return this;
        }
        return (p03) invokeLL.objValue;
    }

    public final void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            T(str + ": " + str2);
        }
    }

    public final w03 L() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Bundle D = D();
            D.putString("ipc_session_id", this.c);
            D.putLong("ipc_session_timeout", this.i);
            D.putInt("ipc_session_repal", SwanAppProcessInfo.current().index);
            D.putString("ipc_topic", this.b.X(this));
            w03 w03Var = new w03(V(), D);
            w03Var.p(true);
            if (SwanAppProcessInfo.current().isSwanService && !this.j) {
                z = false;
            } else {
                z = true;
            }
            w03Var.f(z);
            for (Integer num : this.g) {
                int intValue = num.intValue();
                if (SwanAppProcessInfo.checkProcessId(intValue)) {
                    w03Var.a(intValue);
                }
            }
            for (String str : this.f) {
                if (!TextUtils.isEmpty(str)) {
                    w03Var.c(str);
                }
            }
            if (l) {
                U("createMsg", "msgCooker=" + w03Var + " bundle=" + D);
            }
            return w03Var;
        }
        return (w03) invokeV.objValue;
    }

    public p03 M(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, exc)) == null) {
            synchronized (this.b) {
                if (!R()) {
                    d43.M().removeCallbacks(this.k);
                    this.i = -1L;
                    this.h = exc;
                    this.d.clear();
                    for (xi3<p03> xi3Var : this.e) {
                        xi3Var.a(this);
                    }
                    this.e.clear();
                    this.j = false;
                    this.f.clear();
                    this.g.clear();
                    b();
                }
            }
            return this;
        }
        return (p03) invokeL.objValue;
    }

    public long S(long j) {
        InterceptResult invokeJ;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
            synchronized (this.b) {
                if (Z()) {
                    this.i = Math.max(Math.max(j, o03.n0), this.i);
                    Handler M = d43.M();
                    if (this.i > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        M.removeCallbacks(this.k);
                        M.postDelayed(this.k, this.i);
                    }
                }
                j2 = this.i;
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    public final int V() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            boolean z = SwanAppProcessInfo.current().isSwanService;
            if (z) {
                i = 111;
            } else {
                i = 11;
            }
            if (l) {
                U("msgType", "service=" + z + " msgType=" + i);
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hp2
    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                str = "IpcSession: id=" + this.c + " timeout=" + this.i;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public Exception W() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (l) {
                j = System.nanoTime();
            } else {
                j = 0;
            }
            TimeoutException timeoutException = new TimeoutException("#ipcHttpTimeout session=" + this + " processList=" + O());
            if (l) {
                Log.d("IpcSession", "#newIpcTimeoutException 耗时(ms): " + ((System.nanoTime() - j) / 1000000.0d));
            }
            return timeoutException;
        }
        return (Exception) invokeV.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.b) {
                if (!R() && !P() && !TextUtils.isEmpty(this.c)) {
                    z = true;
                } else {
                    z = false;
                }
                if (l) {
                    U("valid", z + " isFinished=" + R() + " hasException=" + this.h + " id=" + this.c);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean X(i43.a aVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, aVar)) == null) {
            synchronized (this.b) {
                if (Z() && !this.d.isEmpty() && aVar != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    for (xi3<i43.a> xi3Var : this.d) {
                        xi3Var.a(aVar);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public p03 call(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j)) == null) {
            synchronized (this.b) {
                if (l) {
                    U(NotificationCompat.CATEGORY_CALL, "timeoutAtLeast=" + j);
                }
                if (Z()) {
                    long S = S(j);
                    if (l) {
                        U(NotificationCompat.CATEGORY_CALL, "joinTimeout=" + S);
                    }
                    u03.e().h(L());
                    b();
                } else {
                    this.b.b0(this, new IllegalStateException("invalid session call"));
                }
                Y();
            }
            return this;
        }
        return (p03) invokeJ.objValue;
    }
}

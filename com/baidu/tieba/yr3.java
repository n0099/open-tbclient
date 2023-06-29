package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkCode;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class yr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Long> a;
    public final HashMap<String, String> b;
    public boolean c;
    public boolean d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2.a a;
        public final /* synthetic */ yr3 b;

        public a(yr3 yr3Var, zw2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr3Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr3Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.j(this.a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948339727, "Lcom/baidu/tieba/yr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948339727, "Lcom/baidu/tieba/yr3;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            this.b.clear();
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.d = true;
            }
        }
    }

    public synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d = false;
            this.c = false;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            wo3.d(new a(this, bc3.K().q().W()), "WebStaticRecorder", IMLikeRequest.TIME_INTERVAL, TimeUnit.MILLISECONDS);
        }
    }

    public yr3() {
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
        this.a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = false;
        this.d = false;
    }

    public synchronized void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            synchronized (this) {
                if (!this.d) {
                    this.b.put(str, str2);
                }
            }
        }
    }

    public synchronized void h(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048582, this, str, j) == null) {
            synchronized (this) {
                if (!this.a.containsKey(str)) {
                    this.a.put(str, Long.valueOf(j));
                }
            }
        }
    }

    public synchronized boolean d(@NonNull String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                containsKey = this.a.containsKey(str);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized void g(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                if (!this.d && !this.a.containsKey(str)) {
                    this.a.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    public final synchronized void j(zw2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                this.c = true;
                h53.r(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB);
                HybridUbcFlow p = h53.p(DeepLinkCode.OpenAppSource.OPEN_SOURCE_WEB);
                p.E("type", "naWebdegrade");
                for (Map.Entry<String, Long> entry : this.a.entrySet()) {
                    c92.i("WebStaticRecorder", "submit: event key: " + entry.getKey() + " value " + entry.getValue());
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(entry.getKey());
                    ubcFlowEvent.h(entry.getValue().longValue());
                    p.F(ubcFlowEvent);
                }
                for (Map.Entry<String, String> entry2 : this.b.entrySet()) {
                    c92.i("WebStaticRecorder", "submit: ext key: " + entry2.getKey() + " value " + entry2.getValue());
                    p.D(entry2.getKey(), entry2.getValue());
                }
                String h = p.h("fmpArrived");
                if (TextUtils.isEmpty(h)) {
                    h = "0";
                }
                p.D("fmpArrived", h);
                p.D("launchID", aVar.V());
                p.D("scheme", aVar.W());
                p.D("appid", aVar.H());
                p.D("page", ur3.c().b());
                long j = aVar.s0().getLong("click_time", 0L);
                if (j > 0) {
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("user_action");
                    ubcFlowEvent2.h(j);
                    p.F(ubcFlowEvent2);
                }
                p.A();
                b();
            }
        }
    }
}

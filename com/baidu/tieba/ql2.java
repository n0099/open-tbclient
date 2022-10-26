package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ql2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap a;
    public final HashMap b;
    public boolean c;
    public boolean d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2.a a;
        public final /* synthetic */ ql2 b;

        public a(ql2 ql2Var, jo2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql2Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ql2Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948095602, "Lcom/baidu/tieba/ql2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948095602, "Lcom/baidu/tieba/ql2;");
                return;
            }
        }
        e = wj1.a;
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

    public synchronized boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            gg3.k(new a(this, l33.K().q().W()), "VideoStaticRecorder");
        }
    }

    public ql2() {
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
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = false;
        this.d = false;
    }

    public synchronized void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            synchronized (this) {
                if (!this.d) {
                    this.b.put(str, str2);
                }
            }
        }
    }

    public synchronized boolean d(String str) {
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

    public synchronized boolean e(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                containsKey = this.b.containsKey(str);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                if (e) {
                    Log.i("VideoStaticRecorder", "inline video record: action " + str);
                }
                if (!this.d && !this.a.containsKey(str)) {
                    this.a.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    public synchronized void i(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j) == null) {
            synchronized (this) {
                if (e) {
                    Log.i("VideoStaticRecorder", "inline video record: action " + str);
                }
                if (!this.a.containsKey(str)) {
                    this.a.put(str, Long.valueOf(j));
                }
            }
        }
    }

    public final synchronized void j(jo2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                this.c = true;
                boolean equals = TextUtils.equals("1", (CharSequence) this.b.get("autoPlay"));
                boolean equals2 = TextUtils.equals("1", (CharSequence) this.b.get("playMethod"));
                if (e) {
                    Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
                }
                if (!equals && !equals2) {
                    b();
                    return;
                }
                rw2.r("video");
                HybridUbcFlow p = rw2.p("video");
                for (Map.Entry entry : this.a.entrySet()) {
                    m02.i("VideoStaticRecorder", "submit: event key: " + ((String) entry.getKey()) + " value " + entry.getValue());
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent((String) entry.getKey());
                    ubcFlowEvent.h(((Long) entry.getValue()).longValue());
                    p.F(ubcFlowEvent);
                }
                for (Map.Entry entry2 : this.b.entrySet()) {
                    m02.i("VideoStaticRecorder", "submit: ext key: " + ((String) entry2.getKey()) + " value " + ((String) entry2.getValue()));
                    p.D((String) entry2.getKey(), (String) entry2.getValue());
                }
                String h = p.h("fmpArrived");
                if (TextUtils.isEmpty(h)) {
                    h = "0";
                }
                p.D("fmpArrived", h);
                long l = aVar.l("launch_time", 0L);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_start");
                ubcFlowEvent2.h(l);
                p.F(ubcFlowEvent2);
                p.D("launchID", aVar.V());
                p.D("scheme", aVar.W());
                p.D("appid", aVar.H());
                p.D("page", aVar.e0());
                long j = aVar.s0().getLong("click_time", 0L);
                if (j > 0) {
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("user_action");
                    ubcFlowEvent3.h(j);
                    p.F(ubcFlowEvent3);
                }
                p.A();
                b();
            }
        }
    }
}

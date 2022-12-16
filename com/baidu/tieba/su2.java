package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class su2 implements r52, t52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile su2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public lu2 c;

    /* loaded from: classes6.dex */
    public class a implements Action<b33> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su2 a;

        public a(su2 su2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(b33 b33Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b33Var) == null) {
                this.a.f(new tu2(b33Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163833, "Lcom/baidu/tieba/su2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163833, "Lcom/baidu/tieba/su2;");
                return;
            }
        }
        d = e43.v;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            nu2.a();
        }
    }

    @NonNull
    public static su2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (su2.class) {
                    if (e == null) {
                        e = new su2();
                    }
                }
            }
            return e;
        }
        return (su2) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new vu2(11));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            f(new vu2(12, null, 0L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new vu2(9, null, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            f(new vu2(7));
        }
    }

    public su2() {
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
        this.b = false;
        this.c = new mu2();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", b33.class, 0, new a(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.b) {
            return;
        }
        f(new vu2(13, null, 4000L, false));
        if (d) {
            Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=4000");
        }
    }

    @Override // com.baidu.tieba.t52
    public void a(nq1 nq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nq1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            f(new xu2(nq1Var, true));
        }
    }

    @Override // com.baidu.tieba.t52
    public void b(nq1 nq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nq1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            f(new xu2(nq1Var, false));
        }
    }

    public final void f(vu2 vu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vu2Var) == null) {
            this.c.a(vu2Var);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || !sa3.d) {
            return;
        }
        if (z) {
            k();
        } else {
            j();
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
            if (z) {
                ru2.k();
                oa3.z();
                this.b = false;
            }
        }
    }

    public void h(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (d) {
                StringBuilder sb = new StringBuilder();
                sb.append("change to ");
                if (z) {
                    str = NotificationCompat.WearableExtender.KEY_BACKGROUND;
                } else {
                    str = Constant.FOREGROUND;
                }
                sb.append(str);
                Log.d("SwanAppPageMonitor", sb.toString());
            }
            f(new uu2(z));
        }
    }

    public void m() {
        vu2 vu2Var;
        bp2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = ln2.g0().n();
            if (d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + n);
            }
            if (this.a) {
                if (rp2.U().getActivity() != null && (W = d43.K().q().W()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - W.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        xf3 xf3Var = new xf3();
                        xf3Var.k(5L);
                        xf3Var.i(40L);
                        xf3Var.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        fb3 fb3Var = new fb3();
                        fb3Var.q(xa3.n(W.G()));
                        fb3Var.p(xf3Var);
                        fb3Var.r(W);
                        xa3.R(fb3Var);
                    }
                }
                vu2Var = new vu2(1, null, n, true);
                this.a = false;
                t42.b().e(n);
                this.b = false;
                if (sa3.d) {
                    f(vu2Var);
                }
            } else {
                vu2Var = null;
            }
            if (d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + n);
            }
            if (!sa3.d) {
                if (vu2Var == null) {
                    vu2Var = new vu2(1, null, n);
                }
                f(vu2Var);
            }
        }
    }

    @Override // com.baidu.tieba.r52
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
                return;
            }
            f(new vu2(3));
        }
    }
}

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
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r13 implements qc2, sc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile r13 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public k13 c;

    /* loaded from: classes7.dex */
    public class a implements Action<aa3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r13 a;

        public a(r13 r13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r13Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(aa3 aa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aa3Var) == null) {
                this.a.f(new s13(aa3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068725, "Lcom/baidu/tieba/r13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068725, "Lcom/baidu/tieba/r13;");
                return;
            }
        }
        d = db3.v;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            m13.a();
        }
    }

    @NonNull
    public static r13 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (r13.class) {
                    if (e == null) {
                        e = new r13();
                    }
                }
            }
            return e;
        }
        return (r13) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new u13(11));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            f(new u13(12, null, 0L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new u13(9, null, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            f(new u13(7));
        }
    }

    public r13() {
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
        this.c = new l13();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", aa3.class, 0, new a(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.b) {
            return;
        }
        f(new u13(13, null, 4000L, false));
        if (d) {
            Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=4000");
        }
    }

    @Override // com.baidu.tieba.sc2
    public void a(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mx1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            f(new w13(mx1Var, true));
        }
    }

    @Override // com.baidu.tieba.sc2
    public void b(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mx1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            f(new w13(mx1Var, false));
        }
    }

    public final void f(u13 u13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u13Var) == null) {
            this.c.a(u13Var);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || !rh3.d) {
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
                q13.k();
                nh3.z();
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
            f(new t13(z));
        }
    }

    public void m() {
        u13 u13Var;
        aw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = ku2.g0().n();
            if (d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + n);
            }
            if (this.a) {
                if (qw2.T().getActivity() != null && (W = cb3.K().q().W()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - W.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        wm3 wm3Var = new wm3();
                        wm3Var.k(5L);
                        wm3Var.i(40L);
                        wm3Var.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        ei3 ei3Var = new ei3();
                        ei3Var.q(wh3.n(W.G()));
                        ei3Var.p(wm3Var);
                        ei3Var.r(W);
                        wh3.R(ei3Var);
                    }
                }
                u13Var = new u13(1, null, n, true);
                this.a = false;
                sb2.b().e(n);
                this.b = false;
                if (rh3.d) {
                    f(u13Var);
                }
            } else {
                u13Var = null;
            }
            if (d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + n);
            }
            if (!rh3.d) {
                if (u13Var == null) {
                    u13Var = new u13(1, null, n);
                }
                f(u13Var);
            }
        }
    }

    @Override // com.baidu.tieba.qc2
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
                return;
            }
            f(new u13(3));
        }
    }
}

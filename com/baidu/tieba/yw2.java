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
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yw2 implements x72, z72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile yw2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public rw2 c;

    /* loaded from: classes9.dex */
    public class a implements Action<h53> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yw2 a;

        public a(yw2 yw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yw2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h53Var) == null) {
                this.a.f(new zw2(h53Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948344501, "Lcom/baidu/tieba/yw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948344501, "Lcom/baidu/tieba/yw2;");
                return;
            }
        }
        d = k63.v;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            tw2.a();
        }
    }

    @NonNull
    public static yw2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (yw2.class) {
                    if (e == null) {
                        e = new yw2();
                    }
                }
            }
            return e;
        }
        return (yw2) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new bx2(11));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            f(new bx2(12, null, 0L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new bx2(9, null, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            f(new bx2(7));
        }
    }

    public yw2() {
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
        this.c = new sw2();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", h53.class, 0, new a(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.b) {
            return;
        }
        f(new bx2(13, null, 4000L, false));
        if (d) {
            Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=4000");
        }
    }

    @Override // com.baidu.tieba.z72
    public void a(us1 us1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, us1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            f(new dx2(us1Var, true));
        }
    }

    @Override // com.baidu.tieba.z72
    public void b(us1 us1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            f(new dx2(us1Var, false));
        }
    }

    public final void f(bx2 bx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bx2Var) == null) {
            this.c.a(bx2Var);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || !yc3.d) {
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
                xw2.k();
                uc3.z();
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
            f(new ax2(z));
        }
    }

    public void m() {
        bx2 bx2Var;
        hr2.a X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = rp2.g0().n();
            if (d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + n);
            }
            if (this.a) {
                if (xr2.V().getActivity() != null && (X = j63.K().q().X()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - X.O();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        di3 di3Var = new di3();
                        di3Var.k(5L);
                        di3Var.i(40L);
                        di3Var.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        ld3 ld3Var = new ld3();
                        ld3Var.q(dd3.n(X.H()));
                        ld3Var.p(di3Var);
                        ld3Var.r(X);
                        dd3.R(ld3Var);
                    }
                }
                bx2Var = new bx2(1, null, n, true);
                this.a = false;
                z62.b().e(n);
                this.b = false;
                if (yc3.d) {
                    f(bx2Var);
                }
            } else {
                bx2Var = null;
            }
            if (d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + n);
            }
            if (!yc3.d) {
                if (bx2Var == null) {
                    bx2Var = new bx2(1, null, n);
                }
                f(bx2Var);
            }
        }
    }

    @Override // com.baidu.tieba.x72
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
                return;
            }
            f(new bx2(3));
        }
    }
}

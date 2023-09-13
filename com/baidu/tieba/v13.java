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
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v13 implements uc2, wc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile v13 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public o13 c;

    /* loaded from: classes8.dex */
    public class a implements Action<ea3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v13 a;

        public a(v13 v13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v13Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(ea3 ea3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ea3Var) == null) {
                this.a.f(new w13(ea3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948187889, "Lcom/baidu/tieba/v13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948187889, "Lcom/baidu/tieba/v13;");
                return;
            }
        }
        d = hb3.v;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            q13.a();
        }
    }

    @NonNull
    public static v13 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (v13.class) {
                    if (e == null) {
                        e = new v13();
                    }
                }
            }
            return e;
        }
        return (v13) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new y13(11));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            f(new y13(12, null, 0L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new y13(9, null, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            f(new y13(7));
        }
    }

    public v13() {
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
        this.c = new p13();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", ea3.class, 0, new a(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.b) {
            return;
        }
        f(new y13(13, null, 4000L, false));
        if (d) {
            Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=4000");
        }
    }

    @Override // com.baidu.tieba.wc2
    public void a(qx1 qx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qx1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            f(new a23(qx1Var, true));
        }
    }

    @Override // com.baidu.tieba.wc2
    public void b(qx1 qx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qx1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            f(new a23(qx1Var, false));
        }
    }

    public final void f(y13 y13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y13Var) == null) {
            this.c.a(y13Var);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || !vh3.d) {
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
                u13.k();
                rh3.z();
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
            f(new x13(z));
        }
    }

    public void m() {
        y13 y13Var;
        ew2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = ou2.g0().n();
            if (d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + n);
            }
            if (this.a) {
                if (uw2.T().getActivity() != null && (W = gb3.K().q().W()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - W.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        an3 an3Var = new an3();
                        an3Var.k(5L);
                        an3Var.i(40L);
                        an3Var.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        ii3 ii3Var = new ii3();
                        ii3Var.q(ai3.n(W.G()));
                        ii3Var.p(an3Var);
                        ii3Var.r(W);
                        ai3.R(ii3Var);
                    }
                }
                y13Var = new y13(1, null, n, true);
                this.a = false;
                wb2.b().e(n);
                this.b = false;
                if (vh3.d) {
                    f(y13Var);
                }
            } else {
                y13Var = null;
            }
            if (d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + n);
            }
            if (!vh3.d) {
                if (y13Var == null) {
                    y13Var = new y13(1, null, n);
                }
                f(y13Var);
            }
        }
    }

    @Override // com.baidu.tieba.uc2
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
                return;
            }
            f(new y13(3));
        }
    }
}

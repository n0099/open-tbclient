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
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j23 implements id2, kd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile j23 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public c23 c;

    /* loaded from: classes6.dex */
    public class a implements Action<sa3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j23 a;

        public a(j23 j23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j23Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(sa3 sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sa3Var) == null) {
                this.a.f(new k23(sa3Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947831358, "Lcom/baidu/tieba/j23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947831358, "Lcom/baidu/tieba/j23;");
                return;
            }
        }
        d = vb3.v;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            e23.a();
        }
    }

    @NonNull
    public static j23 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (j23.class) {
                    if (e == null) {
                        e = new j23();
                    }
                }
            }
            return e;
        }
        return (j23) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new m23(11));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            f(new m23(12, null, 0L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new m23(9, null, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            f(new m23(7));
        }
    }

    public j23() {
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
        this.c = new d23();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", sa3.class, 0, new a(this));
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.b) {
            return;
        }
        f(new m23(13, null, 4000L, false));
        if (d) {
            Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=4000");
        }
    }

    @Override // com.baidu.tieba.kd2
    public void a(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ey1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            f(new o23(ey1Var, true));
        }
    }

    @Override // com.baidu.tieba.kd2
    public void b(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ey1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            f(new o23(ey1Var, false));
        }
    }

    public final void f(m23 m23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m23Var) == null) {
            this.c.a(m23Var);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || !ji3.d) {
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
                i23.k();
                fi3.z();
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
            f(new l23(z));
        }
    }

    public void m() {
        m23 m23Var;
        sw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = cv2.g0().n();
            if (d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + n);
            }
            if (this.a) {
                if (ix2.T().getActivity() != null && (W = ub3.K().q().W()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - W.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        on3 on3Var = new on3();
                        on3Var.k(5L);
                        on3Var.i(40L);
                        on3Var.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        wi3 wi3Var = new wi3();
                        wi3Var.q(oi3.n(W.G()));
                        wi3Var.p(on3Var);
                        wi3Var.r(W);
                        oi3.R(wi3Var);
                    }
                }
                m23Var = new m23(1, null, n, true);
                this.a = false;
                kc2.b().e(n);
                this.b = false;
                if (ji3.d) {
                    f(m23Var);
                }
            } else {
                m23Var = null;
            }
            if (d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + n);
            }
            if (!ji3.d) {
                if (m23Var == null) {
                    m23Var = new m23(1, null, n);
                }
                f(m23Var);
            }
        }
    }

    @Override // com.baidu.tieba.id2
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
                return;
            }
            f(new m23(3));
        }
    }
}

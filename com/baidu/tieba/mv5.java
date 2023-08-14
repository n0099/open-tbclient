package com.baidu.tieba;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.event.AppBackgroundSwitchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class mv5 {
    public static /* synthetic */ Interceptable $ic;
    public static mv5 j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public long c;
    public long d;
    public int e;
    public AtomicBoolean f;
    public boolean g;
    public Handler h;
    public Runnable i;

    /* loaded from: classes7.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv5 a;

        public a(mv5 mv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mv5Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 5) {
                    if (!Boolean.TRUE.equals(message.obj)) {
                        this.a.n();
                        return false;
                    }
                    this.a.q();
                    this.a.m();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv5 a;

        public b(mv5 mv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mv5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mv5 mv5Var = this.a;
                if (mv5Var.f == null) {
                    mv5Var.f = new AtomicBoolean(false);
                }
                if (this.a.f.get()) {
                    return;
                }
                this.a.f.set(true);
                if (this.a.l(true)) {
                    TbadkCoreApplication.getInst().fixOppoTimeout();
                    MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.TRUE));
                    MutiProcessManager.publishEvent(new AppBackgroundSwitchEvent(true));
                    TiebaStaticHelper.setCurrentActivity(null);
                    TiebaStatic.save();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(mv5 mv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p05.c().b();
            }
        }
    }

    public mv5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0;
        this.f = null;
        this.g = false;
        this.h = new Handler(Looper.getMainLooper(), new a(this));
        this.i = new b(this);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (l(false)) {
                if (!this.g) {
                    return true;
                }
                Intent intent = new Intent("com.tieba.baidu.notifyprocess");
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra("message", true);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
                return false;
            }
            Intent intent2 = new Intent("com.tieba.baidu.notifyprocess");
            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent2.putExtra("message", false);
            TbadkCoreApplication.getInst().sendBroadcast(intent2);
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            return TbadkCoreApplication.getInst().isMainProcess(z);
        }
        return invokeZ.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g = !z;
        }
    }

    public static mv5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (j == null) {
                synchronized (mv5.class) {
                    if (j == null) {
                        j = new mv5();
                    }
                }
            }
            return j;
        }
        return (mv5) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e++;
            p();
            IdleHandlerManager.getInstance().addOrRunTask("CornerManager", new c(this));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e--;
            p();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a = 0;
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AtomicBoolean atomicBoolean = this.f;
            if (atomicBoolean == null) {
                return true;
            }
            return atomicBoolean.get();
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AtomicBoolean atomicBoolean = this.f;
            if (atomicBoolean == null) {
                return false;
            }
            return atomicBoolean.get();
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AsyncService.INSTANCE.sendRunnable(this.i);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Handler handler = this.h;
            handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.TRUE), 1000L);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b = System.currentTimeMillis();
            new EnterForePvThread().start();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            AsyncService.INSTANCE.removeRunnable(this.i);
            if (this.f == null) {
                this.f = new AtomicBoolean(true);
            }
            if (!this.f.get()) {
                return;
            }
            this.f.set(false);
            this.a++;
            if (l(true)) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = this.b;
                if ((currentTimeMillis - j2 > 3600000 || j2 == 0) && PermissionUtil.isAgreePrivacyPolicy()) {
                    s();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.FALSE));
                MutiProcessManager.publishEvent(new AppBackgroundSwitchEvent(false));
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.e < 0) {
                this.e = 0;
            }
            if (l(true) && this.c == 0 && this.e > 0) {
                this.c = System.nanoTime();
                this.d = System.currentTimeMillis();
            }
            this.h.removeMessages(5);
            if (this.e == 0) {
                SpeedStats.getInstance().onAppBackground();
                r();
                return;
            }
            AtomicBoolean atomicBoolean = this.f;
            if (atomicBoolean == null || atomicBoolean.get()) {
                SpeedStats.getInstance().onAppForeground();
                Handler handler = this.h;
                handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.e == 0 && this.c > 0) {
            long nanoTime = ((System.nanoTime() - this.c) / 1000000) / 1000;
            if (nanoTime >= TbadkCoreApplication.getInst().getUseTimeInterval()) {
                if (PermissionUtil.isAgreePrivacyPolicy()) {
                    new PvThread("use", String.valueOf(nanoTime)).start();
                }
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "use", null, 1, "st_param", String.valueOf(nanoTime));
            }
            this.c = 0L;
            this.d = 0L;
        }
    }
}

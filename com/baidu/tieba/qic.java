package com.baidu.tieba;

import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class qic {
    public static /* synthetic */ Interceptable $ic;
    public static int u;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer a;
    public int b;
    public AtomicInteger c;
    public WeakReference<mic> d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public long m;
    public long n;
    public long o;
    public long p;
    public AtomicLong q;
    public AtomicLong r;
    public AtomicLong s;
    public AtomicBoolean t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948094238, "Lcom/baidu/tieba/qic;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948094238, "Lcom/baidu/tieba/qic;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qic a;

        public a(qic qicVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qicVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qicVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a.e) {
                    qic.k(this.a);
                    int i = ((System.currentTimeMillis() - this.a.r.get()) > 600L ? 1 : ((System.currentTimeMillis() - this.a.r.get()) == 600L ? 0 : -1));
                    if (i <= 0 || this.a.f || this.a.g == -1 || this.a.r.get() == 0) {
                        if (i < 0 && this.a.f) {
                            this.a.g = -1;
                            this.a.f = false;
                            this.a.v(AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED);
                        }
                    } else {
                        this.a.f = true;
                        this.a.v(AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED);
                    }
                    if (this.a.b % 20 == 0) {
                        this.a.v(6000);
                        this.a.k = 0;
                    }
                    if (this.a.b % 20 == 0) {
                        this.a.v(6001);
                        this.a.l = 0;
                    }
                    if (this.a.b % 30 == 0 && this.a.t.get()) {
                        long currentTimeMillis = System.currentTimeMillis() - this.a.q.get();
                        if (currentTimeMillis > 2000 && this.a.q.get() >= this.a.r.get() && this.a.r.get() > 0) {
                            TLog.g(this, "[draw] may block, elapse " + currentTimeMillis + "ms after drawStart");
                            this.a.t.set(false);
                        }
                    }
                    if (this.a.b % 50 == 0 && this.a.s.get() > 1500) {
                        TLog.g(this, "[draw] max cost: " + this.a.s.get());
                        this.a.s.set(0L);
                    }
                    if (this.a.b % 50 != 0) {
                        return;
                    }
                    this.a.v(AuthCode.StatusCode.PERMISSION_NOT_EXIST);
                    this.a.m = 0L;
                    this.a.n = 0L;
                    this.a.b = 0;
                    return;
                }
                this.a.e = false;
                this.a.m = 0L;
                this.a.n = 0L;
                this.a.l = 0;
            }
        }
    }

    public qic() {
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
        this.a = null;
        this.b = 0;
        this.c = new AtomicInteger(0);
        this.d = new WeakReference<>(null);
        this.e = true;
        this.f = false;
        this.g = -1;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.q = new AtomicLong(0L);
        this.r = new AtomicLong(0L);
        this.s = new AtomicLong(0L);
        this.t = new AtomicBoolean(false);
    }

    public static /* synthetic */ int k(qic qicVar) {
        int i = qicVar.b;
        qicVar.b = i + 1;
        return i;
    }

    public void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.r.set(j);
            long j2 = this.r.get() - this.q.get();
            if (j2 >= this.s.get()) {
                this.s.set(j2);
            }
        }
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.q.set(j);
            this.t.set(true);
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.k = i;
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.g = i;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.n += i;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m += i;
        }
    }

    public void x(mic micVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, micVar) == null) {
            this.d = new WeakReference<>(micVar);
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = i;
            v(6002);
        }
    }

    public void y(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            this.i = i;
            this.j = i2;
            v(AuthCode.StatusCode.CERT_FINGERPRINT_ERROR);
        }
    }

    public static int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return u;
        }
        return invokeV.intValue;
    }

    public void F() {
        Timer timer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (timer = this.a) != null) {
            timer.cancel();
            this.a = null;
            this.e = true;
            this.p = 0L;
            this.o = 0L;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l++;
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.c.set(i);
            TLog.g(this, String.format(Locale.getDefault(), "QualityMonitor playTaskId %d", Integer.valueOf(this.c.get())));
            TLog.g(this, "QualityMonitor start");
            if (this.a == null) {
                Timer timer = new Timer();
                this.a = timer;
                timer.schedule(new a(this), 1000L, 100L);
            }
            TLog.g(this, "QualityMonitor start");
        }
    }

    public final void v(int i) {
        mic micVar;
        float currentTimeMillis;
        float currentTimeMillis2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || (micVar = this.d.get()) == null) {
            return;
        }
        Message message = null;
        switch (i) {
            case 6000:
                message = Message.obtain(null, 6000, this.k, 0);
                break;
            case 6001:
                if (this.p == 0) {
                    currentTimeMillis = 2.0f;
                } else {
                    currentTimeMillis = (float) ((System.currentTimeMillis() - this.p) / 1000);
                }
                int i2 = (int) (this.l / currentTimeMillis);
                u = i2;
                message = Message.obtain(null, 6001, i2, 0);
                this.p = System.currentTimeMillis();
                break;
            case 6002:
                message = Message.obtain(null, 6002, this.h, 0);
                break;
            case AuthCode.StatusCode.CERT_FINGERPRINT_ERROR /* 6003 */:
                message = Message.obtain(null, AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, this.i, this.j);
                TLog.g(this, String.format(Locale.getDefault(), "QualityMonitor output size %d * %d  , taskId %d", Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.c.get())));
                break;
            case AuthCode.StatusCode.PERMISSION_NOT_EXIST /* 6004 */:
                if (this.o == 0) {
                    currentTimeMillis2 = 5.0f;
                } else {
                    currentTimeMillis2 = (float) ((System.currentTimeMillis() - this.o) / 1000);
                }
                message = Message.obtain(null, AuthCode.StatusCode.PERMISSION_NOT_EXIST, (int) (((float) (this.m * 8)) / currentTimeMillis2), (int) (((float) (this.n * 8)) / currentTimeMillis2));
                this.o = System.currentTimeMillis();
                break;
            case AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED /* 6005 */:
                message = Message.obtain(null, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, this.f ? 1 : 0, this.g);
                break;
            case AuthCode.StatusCode.PERMISSION_EXPIRED /* 6006 */:
                message = Message.obtain(null, AuthCode.StatusCode.PERMISSION_EXPIRED, 1, this.g);
                break;
        }
        micVar.a(message, this.c.get());
    }
}

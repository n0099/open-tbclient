package com.baidu.tieba;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.cgb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class kgb implements cgb {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] h;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public HandlerThread b;
    public String c;
    public int d;
    public cgb.a e;
    public final Handler.Callback f;
    public AtomicInteger g;

    /* loaded from: classes6.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kgb a;

        public a(kgb kgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kgbVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                switch (message.what) {
                    case -10004:
                        this.a.e.onResume();
                        return false;
                    case -10003:
                        this.a.e.onPause();
                        return false;
                    case -10002:
                        this.a.m();
                        return false;
                    case -10001:
                        this.a.l();
                        return false;
                    default:
                        this.a.e.handleMessage(message);
                        return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947913539, "Lcom/baidu/tieba/kgb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947913539, "Lcom/baidu/tieba/kgb;");
                return;
            }
        }
        h = new String[]{"None", "Ready", "Running", "Paused", "Stopped"};
    }

    @Override // com.baidu.tieba.cgb
    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g.get();
        }
        return invokeV.intValue;
    }

    public Handler k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (Handler) invokeV.objValue;
    }

    public kgb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
        this.b = null;
        this.c = "yythread";
        this.d = -2;
        this.e = null;
        this.f = new a(this);
        this.g = new AtomicInteger(1);
        if (str != null) {
            this.c = str;
        }
    }

    public static int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i > 19) {
                i = 19;
            } else if (i < -8) {
                i = -8;
            }
            return ((i - 19) * 9) / (-27);
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.cgb
    public void b(cgb.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.e = aVar;
            if (aVar != null) {
                return;
            }
            throw new RuntimeException("mCallback is not set!");
        }
    }

    @Override // com.baidu.tieba.cgb
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d = i;
            synchronized (this) {
                if (this.b != null) {
                    this.b.setPriority(this.d);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cgb
    public boolean e(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, runnable)) == null) {
            return sendMessage(Message.obtain((Handler) null, runnable));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cgb
    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return a(i, 0L);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.cgb
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            synchronized (this) {
                if (this.g.get() != 4) {
                    this.a.removeMessages(i);
                }
            }
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            synchronized (this) {
                this.g.set(i);
            }
        }
    }

    @Override // com.baidu.tieba.cgb
    public boolean sendMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, message)) == null) {
            return q(message, 0L);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cgb
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (str != null) {
                this.c = str;
            }
            synchronized (this) {
                if (this.b != null) {
                    this.b.setName(this.c);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cgb
    public boolean a(int i, long j) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            synchronized (this) {
                int i2 = this.g.get();
                if (i2 != 2 && i2 != 3) {
                    Object[] objArr = new Object[3];
                    if (this.b != null) {
                        str = this.b.getName();
                    } else {
                        str = this.c;
                    }
                    objArr[0] = str;
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = h[i2];
                    TLog.c(this, String.format("[%s] sendEmptyMessageDelayed(%d) failed. mThreadStatus = %s", objArr));
                    return false;
                }
                return this.a.sendEmptyMessageDelayed(i, j);
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.cgb
    public void c() {
        int i;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                i = this.g.get();
                if (i != 4) {
                    this.g.set(4);
                    this.a.removeMessages(-10002);
                    this.a.sendEmptyMessage(-10002);
                } else {
                    Object[] objArr = new Object[2];
                    if (this.b != null) {
                        str = this.b.getName();
                    } else {
                        str = this.c;
                    }
                    objArr[0] = str;
                    objArr[1] = h[i];
                    TLog.l(this, String.format("[%s] already stopped? mThreadStatus = %s", objArr));
                }
            }
            if (i != 4) {
                try {
                    if (this.b != null) {
                        i2 = this.b.getThreadId();
                    } else {
                        i2 = 0;
                    }
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.b.quitSafely();
                    }
                    int threadId = this.b.getThreadId();
                    this.b.join();
                    TLog.g(this, String.format("[%s] tid %d, stop HandlerThread(%d).", this.b.getName(), Integer.valueOf(i2), Integer.valueOf(threadId)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    this.b = null;
                    this.a = null;
                }
            }
        }
    }

    @Override // com.baidu.tieba.cgb
    public void start() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.e != null) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this) {
                    this.g.set(2);
                    HandlerThread handlerThread = new HandlerThread(this.c, this.d);
                    this.b = handlerThread;
                    handlerThread.setPriority(n(this.d));
                    this.b.start();
                    this.a = new Handler(this.b.getLooper(), this.f);
                    StringBuilder sb = new StringBuilder();
                    sb.append(PreferencesUtil.LEFT_MOUNT);
                    sb.append(this.c);
                    sb.append("] tid ");
                    if (this.b != null) {
                        i = this.b.getThreadId();
                    } else {
                        i = 0;
                    }
                    sb.append(i);
                    sb.append(this.a.toString());
                    TLog.g(this, sb.toString());
                    this.a.sendEmptyMessage(-10001);
                }
                TLog.l(this, this.c + " YYThread start cost :" + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            throw new RuntimeException("mCallback is null");
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int myTid = Process.myTid();
            Thread currentThread = Thread.currentThread();
            TLog.g(this, PreferencesUtil.LEFT_MOUNT + currentThread.getName() + PreferencesUtil.RIGHT_MOUNT + " sdk_ver:" + Build.VERSION.SDK_INT + " tid:" + myTid + " " + currentThread.getId() + " priority" + Process.getThreadPriority(myTid) + " " + currentThread.getPriority());
            this.e.onStart();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e.onStop();
            if (Build.VERSION.SDK_INT < 18) {
                this.b.quit();
            } else {
                this.b.quitSafely();
            }
            Process.myTid();
            TLog.g(this, String.format("[%s] thread internalStop", Thread.currentThread().getName()));
        }
    }

    public void o() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                int i = this.g.get();
                if (i == 2) {
                    this.g.set(3);
                    this.a.removeMessages(-10003);
                    this.a.sendEmptyMessage(-10003);
                } else {
                    Object[] objArr = new Object[2];
                    if (this.b != null) {
                        str = this.b.getName();
                    } else {
                        str = this.c;
                    }
                    objArr[0] = str;
                    objArr[1] = h[i];
                    TLog.l(this, String.format("[%s] already paused? mThreadStatus = %s", objArr));
                }
            }
        }
    }

    public void p() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                int i = this.g.get();
                if (i == 3) {
                    this.g.set(2);
                    this.a.removeMessages(-10004);
                    this.a.sendEmptyMessage(-10004);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(PreferencesUtil.LEFT_MOUNT);
                    if (this.b != null) {
                        str = this.b.getName();
                    } else {
                        str = this.c;
                    }
                    sb.append(str);
                    sb.append(" ]");
                    sb.append(" already resumed? mThreadStatus = ");
                    sb.append(h[i]);
                    TLog.l(this, sb.toString());
                }
            }
        }
    }

    public boolean q(Message message, long j) {
        InterceptResult invokeLJ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, message, j)) == null) {
            synchronized (this) {
                int i = this.g.get();
                if (i != 2 && i != 3) {
                    Object[] objArr = new Object[2];
                    if (this.b != null) {
                        str = this.b.getName();
                    } else {
                        str = this.c;
                    }
                    objArr[0] = str;
                    objArr[1] = h[i];
                    TLog.c(this, String.format("[%s] sendMessageDelayed() failed. mThreadStatus = %s", objArr));
                    return false;
                }
                return this.a.sendMessageDelayed(message, j);
            }
        }
        return invokeLJ.booleanValue;
    }
}

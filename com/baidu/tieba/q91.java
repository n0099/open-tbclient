package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q91 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q91 f;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public Handler b;
    public int c;
    public int d;
    public Runnable e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q91 a;

        public a(q91 q91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q91Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                aa1.g("开始重试");
                if (r91.n()) {
                    aa1.g("重试成功");
                    this.a.c = 0;
                    this.a.a.quitSafely();
                    this.a.b.removeCallbacks(this);
                    return;
                }
                q91.c(this.a);
                if (this.a.c >= 3) {
                    this.a.c = 0;
                    aa1.g("重试三次结束重试");
                    this.a.a.quitSafely();
                    this.a.b.removeCallbacks(this);
                    return;
                }
                aa1.g("重试失败继续重试");
                this.a.b.postDelayed(this, this.a.d);
            }
        }
    }

    public q91() {
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
        this.d = 10000;
        this.e = new a(this);
    }

    public static /* synthetic */ int c(q91 q91Var) {
        int i = q91Var.c;
        q91Var.c = i + 1;
        return i;
    }

    public static q91 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f == null) {
                synchronized (q91.class) {
                    if (f == null) {
                        f = new q91();
                    }
                }
            }
            return f;
        }
        return (q91) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            aa1.g("触发重试");
            HandlerThread handlerThread = new HandlerThread("StatisticsReload");
            this.a = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.a.getLooper());
            this.b = handler;
            handler.postDelayed(this.e, this.d);
        }
    }
}

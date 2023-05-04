package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class og1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile og1 f;
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
        public final /* synthetic */ og1 a;

        public a(og1 og1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = og1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yg1.g("开始重试");
                if (pg1.n()) {
                    yg1.g("重试成功");
                    this.a.c = 0;
                    this.a.a.quitSafely();
                    this.a.b.removeCallbacks(this);
                    return;
                }
                og1.c(this.a);
                if (this.a.c < 3) {
                    yg1.g("重试失败继续重试");
                    this.a.b.postDelayed(this, this.a.d);
                    return;
                }
                this.a.c = 0;
                yg1.g("重试三次结束重试");
                this.a.a.quitSafely();
                this.a.b.removeCallbacks(this);
            }
        }
    }

    public og1() {
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

    public static og1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f == null) {
                synchronized (og1.class) {
                    if (f == null) {
                        f = new og1();
                    }
                }
            }
            return f;
        }
        return (og1) invokeV.objValue;
    }

    public static /* synthetic */ int c(og1 og1Var) {
        int i = og1Var.c;
        og1Var.c = i + 1;
        return i;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yg1.g("触发重试");
            HandlerThread handlerThread = new HandlerThread("StatisticsReload");
            this.a = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.a.getLooper());
            this.b = handler;
            handler.postDelayed(this.e, this.d);
        }
    }
}

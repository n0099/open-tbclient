package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nb1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nb1 f;
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
        public final /* synthetic */ nb1 a;

        public a(nb1 nb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nb1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xb1.g("开始重试");
                if (ob1.n()) {
                    xb1.g("重试成功");
                    this.a.c = 0;
                    this.a.a.quitSafely();
                    this.a.b.removeCallbacks(this);
                    return;
                }
                nb1.c(this.a);
                if (this.a.c >= 3) {
                    this.a.c = 0;
                    xb1.g("重试三次结束重试");
                    this.a.a.quitSafely();
                    this.a.b.removeCallbacks(this);
                    return;
                }
                xb1.g("重试失败继续重试");
                this.a.b.postDelayed(this, this.a.d);
            }
        }
    }

    public nb1() {
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

    public static /* synthetic */ int c(nb1 nb1Var) {
        int i = nb1Var.c;
        nb1Var.c = i + 1;
        return i;
    }

    public static nb1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f == null) {
                synchronized (nb1.class) {
                    if (f == null) {
                        f = new nb1();
                    }
                }
            }
            return f;
        }
        return (nb1) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xb1.g("触发重试");
            HandlerThread handlerThread = new HandlerThread("StatisticsReload");
            this.a = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.a.getLooper());
            this.b = handler;
            handler.postDelayed(this.e, this.d);
        }
    }
}

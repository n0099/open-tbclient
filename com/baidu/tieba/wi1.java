package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wi1 extends aj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public long d;
    public V8ExceptionInfo e;
    public int f;

    public wi1() {
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
        this.c = false;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = null;
            this.d = 0L;
            this.f = -1;
        }
    }

    @Override // com.baidu.tieba.aj1
    public synchronized void a(int i, V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, v8ExceptionInfo) == null) {
            synchronized (this) {
                if (this.e == null && v8ExceptionInfo != null) {
                    this.e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
                    this.f = i;
                    if (this.b != null) {
                        this.b.a();
                    }
                }
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                if (this.b != null && this.d > 0 && this.e != null) {
                    if (System.currentTimeMillis() - this.e.exceptionTime > this.a && this.e.exceptionTime > this.d) {
                        this.b.b(new zi1(this.f, this.e, this.d));
                        d();
                    }
                    return;
                }
                Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            }
        }
    }

    public synchronized void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (this) {
                this.c = z;
                if (z) {
                    this.d = j;
                    this.e = null;
                }
            }
        }
    }
}

package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class tp3 implements sp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<rp3> a;
    public rp3 b;

    public tp3() {
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
        this.a = new ArrayDeque();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.a) {
                if (this.b != null) {
                    return;
                }
                e();
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.b != null) {
                    this.b.a();
                    this.b = null;
                }
                this.a.clear();
            }
        }
    }

    @Override // com.baidu.tieba.sp3
    public void a(rp3 rp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rp3Var) == null) {
            synchronized (this.a) {
                if (rp3Var == this.b) {
                    e();
                }
            }
        }
    }

    public void d(rp3 rp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rp3Var) == null) {
            if (rp3Var != null) {
                synchronized (this.a) {
                    Queue<rp3> queue = this.a;
                    rp3Var.b(this);
                    queue.offer(rp3Var);
                }
            }
            b();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.a) {
                this.b = null;
                if (this.a.isEmpty()) {
                    return;
                }
                rp3 poll = this.a.poll();
                this.b = poll;
                if (poll == null) {
                    e();
                } else {
                    xo3.a0(poll);
                }
            }
        }
    }
}

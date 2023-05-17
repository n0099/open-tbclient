package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class po0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final long b;
    public final long c;
    public long d;
    public volatile boolean e;
    public volatile boolean f;
    public long g;
    public long h;
    @SuppressLint({"HandlerLeak"})
    public final Handler i;

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ po0 a;

        public a(po0 po0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = po0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                synchronized (this.a) {
                    if (!this.a.e && !this.a.f) {
                        long elapsedRealtime = this.a.d - SystemClock.elapsedRealtime();
                        this.a.a = elapsedRealtime;
                        if (elapsedRealtime <= this.a.g) {
                            this.a.l();
                            this.a.f = true;
                        } else {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            this.a.m(elapsedRealtime);
                            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            long j2 = 0;
                            if (elapsedRealtime < this.a.c) {
                                j = elapsedRealtime - elapsedRealtime3;
                                if (j < 0) {
                                    sendMessageDelayed(obtainMessage(1), j2);
                                }
                            } else {
                                j = this.a.c - elapsedRealtime3;
                                while (j < 0) {
                                    j += this.a.c;
                                }
                            }
                            j2 = j;
                            sendMessageDelayed(obtainMessage(1), j2);
                        }
                    }
                }
            }
        }
    }

    public po0(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = false;
        this.i = new a(this);
        this.c = j2;
        this.a = j;
        this.b = j;
        this.h = j;
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.h = j;
        }
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.e = true;
                this.i.removeCallbacksAndMessages(null);
            }
        }
    }

    public final synchronized long j() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                j = this.b - this.h;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public final synchronized long k() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                j = this.a - this.g;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public final synchronized po0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.f) {
                    return this;
                }
                this.e = false;
                if (this.a <= 0) {
                    l();
                    this.f = true;
                    return this;
                }
                this.d = SystemClock.elapsedRealtime() + this.a;
                this.i.sendMessage(this.i.obtainMessage(1));
                return this;
            }
        }
        return (po0) invokeV.objValue;
    }

    public final synchronized po0 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f) {
                    return this;
                }
                this.e = false;
                if (this.a <= this.g) {
                    l();
                    this.f = true;
                    return this;
                }
                this.d = SystemClock.elapsedRealtime() + this.a;
                this.i.sendMessage(this.i.obtainMessage(1));
                return this;
            }
        }
        return (po0) invokeV.objValue;
    }
}

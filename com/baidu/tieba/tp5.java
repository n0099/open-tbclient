package com.baidu.tieba;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class tp5 extends sp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;
    public HashMap<String, String> E;
    public boolean b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public boolean s;
    public int t;
    public long u;
    public int v;
    public long w;
    public long x;
    public boolean y;
    public long z;

    public tp5() {
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
        this.i = 0L;
        this.j = 0L;
        this.n = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = false;
        this.E = new HashMap<>();
    }

    public tp5(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = 0L;
        this.j = 0L;
        this.n = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = false;
        this.E = new HashMap<>();
        if (responsedMessage == null) {
            return;
        }
        this.a = i;
        this.s = z;
        if (z) {
            this.r = responsedMessage.getDownSize();
            this.A = responsedMessage.getOrginalMessage().getClientLogID();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
            x6 x6Var = responsedMessage.performanceData;
            this.w = x6Var.k;
            this.x = x6Var.l;
            this.t = x6Var.i;
            this.u = x6Var.j;
        } else {
            this.q = responsedMessage.getDownSize();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
        }
        this.c = j;
        this.d = j4;
        this.e = j2;
        this.o = j3;
        this.m = j5;
        this.b = !responsedMessage.hasError();
        x6 x6Var2 = responsedMessage.performanceData;
        this.f = x6Var2.a;
        this.g = x6Var2.b;
        this.h = x6Var2.c;
        this.i = x6Var2.d;
        this.j = x6Var2.e;
        this.k = x6Var2.f;
        this.l = x6Var2.g;
        long j7 = x6Var2.h;
        this.n = j7;
        this.n = j7 + (responsedMessage.getProcessTime() - responsedMessage.getStartTime());
        this.v = responsedMessage.getError();
        this.y = z2;
        this.p = j6;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !rd.isEmpty(str) && !rd.isEmpty(str2)) {
            this.E.put(str, str2);
        }
    }

    public void c() {
        wp5 wp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (wp5Var = (wp5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            wp5Var.a(this);
        }
    }

    public void d(int i) {
        wp5 wp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (wp5Var = (wp5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            wp5Var.b(this, i);
        }
    }

    public void e(boolean z) {
        wp5 wp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (wp5Var = (wp5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            wp5Var.c(this, z);
        }
    }
}

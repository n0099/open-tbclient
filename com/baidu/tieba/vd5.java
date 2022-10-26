package com.baidu.tieba;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class vd5 extends ud5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;
    public HashMap E;
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

    public vd5() {
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
        this.E = new HashMap();
    }

    public vd5(int i, boolean z, ResponsedMessage responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
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
        this.E = new HashMap();
        if (responsedMessage == null) {
            return;
        }
        this.a = i;
        this.s = z;
        if (z) {
            this.r = responsedMessage.getDownSize();
            this.A = responsedMessage.getOrginalMessage().getClientLogID();
            this.z = responsedMessage.getOrginalMessage().getSquencedId();
            xb xbVar = responsedMessage.performanceData;
            this.w = xbVar.k;
            this.x = xbVar.l;
            this.t = xbVar.i;
            this.u = xbVar.j;
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
        xb xbVar2 = responsedMessage.performanceData;
        this.f = xbVar2.a;
        this.g = xbVar2.b;
        this.h = xbVar2.c;
        this.i = xbVar2.d;
        this.j = xbVar2.e;
        this.k = xbVar2.f;
        this.l = xbVar2.g;
        long j7 = xbVar2.h;
        this.n = j7;
        this.n = j7 + (responsedMessage.getProcessTime() - responsedMessage.getStartTime());
        this.v = responsedMessage.getError();
        this.y = z2;
        this.p = j6;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !ej.isEmpty(str) && !ej.isEmpty(str2)) {
            this.E.put(str, str2);
        }
    }

    public void c() {
        zd5 zd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (zd5Var = (zd5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            zd5Var.b(this);
        }
    }

    public void d(int i) {
        zd5 zd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (zd5Var = (zd5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            zd5Var.c(this, i);
        }
    }

    public void e(boolean z) {
        zd5 zd5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (zd5Var = (zd5) PerformanceLoggerHelper.getInstance().getLoggerWithType(this.a)) != null) {
            zd5Var.d(this, z);
        }
    }
}

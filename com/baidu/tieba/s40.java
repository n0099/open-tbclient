package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class s40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public long b;
    public long c;
    public int d;
    public String e;
    public boolean f;
    public byte[] g;
    public long h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public boolean p;
    public List<m40> q;
    public String r;
    public long s;
    public long t;

    public s40() {
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
        this.a = new byte[0];
        this.b = System.currentTimeMillis();
        this.c = 10000L;
        this.d = -1;
        this.e = "";
        this.f = false;
        this.g = new byte[0];
        this.h = 60000L;
        this.i = -1L;
        this.j = -1L;
        this.k = -1;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1L;
        this.p = false;
        this.q = new ArrayList();
        this.r = "";
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.n) {
                return "Request correlationId : " + this.o + ", serviceId :" + this.i + ", methodId :" + this.j + ", connectState :" + this.k + ", isNotify :" + this.f + ", bodySize :" + this.a.length;
            }
            return "Response correlationId : " + this.o + ", serviceId :" + this.i + ", methodId :" + this.j + ", errorCode :" + this.d + ", errorMsg :" + this.e + ", intervalMs :" + this.h + ", isNotify :" + this.f + ", bodySize :" + this.g.length;
        }
        return (String) invokeV.objValue;
    }
}

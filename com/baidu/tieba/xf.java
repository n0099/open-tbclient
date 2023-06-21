package com.baidu.tieba;

import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public long d;
    public int e;
    public long f;
    public long g;
    public String h;
    public int i;
    public int j;
    public String k;
    public String l;
    public BDHttpDnsResult.ResolveType m;
    public boolean n;
    public BDHttpDnsResult.ResolveStatus o;
    public String p;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public int v;
    public long w;
    public long x;
    public long y;

    public xf() {
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
        this.a = -1L;
        this.b = -1L;
        this.c = -1L;
        this.d = -1L;
        this.e = 0;
        this.f = -1L;
        this.g = -1L;
        this.h = "";
        this.i = -1;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
    }
}

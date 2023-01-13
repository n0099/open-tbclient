package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class j2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public k3 r;
    public boolean s;
    @Deprecated
    public boolean t;
    public int u;

    public j2() {
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
        this.a = 8;
        this.b = 8;
        this.c = 8;
        this.d = 0;
        this.e = 16;
        this.f = 0;
        this.g = 0;
        this.h = true;
        this.i = false;
        this.j = true;
        this.k = false;
        this.l = 1;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 16;
        this.r = new i3();
        this.s = false;
        this.t = false;
        this.u = Integer.MAX_VALUE;
    }
}

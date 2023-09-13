package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class v1 extends d2<v1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l0 a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte[] g;
    public i0 h;
    public final w1 i;
    public final d j;
    public r0 k;
    public double l;
    public boolean m;

    public v1(l0 l0Var, w1 w1Var, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l0Var, w1Var, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = r0.c;
        this.a = l0Var;
        this.i = w1Var;
        this.j = dVar;
    }
}

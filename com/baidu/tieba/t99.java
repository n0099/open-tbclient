package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class t99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aa9 a;
    public HashSet b;
    public HashSet c;
    public HashSet d;
    public HashSet e;
    public HashSet f;
    public HashSet g;
    public HashMap h;
    public HashMap i;
    public HashMap j;
    public HashSet k;
    public HashSet l;
    public HashMap m;
    public HashMap n;
    public HashMap o;

    public t99() {
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
        this.a = new aa9();
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashSet();
        this.l = new HashSet();
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = new HashMap();
    }
}

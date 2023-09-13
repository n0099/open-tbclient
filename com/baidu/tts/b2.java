package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
/* loaded from: classes9.dex */
public class b2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final a2 c;
    public c0 d;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final v1 a;
        public final /* synthetic */ b2 b;

        public a(b2 b2Var, v1 v1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b2Var, v1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b2Var;
            this.a = v1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a2 a2Var = this.b.c;
                v1 v1Var = this.a;
                a2Var.getClass();
                synchronized (a2.class) {
                    try {
                        if (v1Var != null) {
                            l0 l0Var = v1Var.a;
                            if (l0Var == l0.c) {
                                int i = v1Var.k.a;
                                r1 r1Var = a2Var.e;
                                int i2 = r1Var.h;
                                int i3 = r1Var.f;
                                int i4 = r1Var.g;
                                if (i != a2Var.d.getSampleRate() || a2Var.v != i2 || a2Var.s != i3 || a2Var.t != i4) {
                                    a2Var.e.a = i;
                                    a2Var.b();
                                    a2Var.a();
                                    a2Var.d.play();
                                }
                                float f = a2Var.e.e;
                                if (a2Var.u != f) {
                                    a2Var.u = f;
                                    a2Var.d.setVolume(f);
                                }
                                if (Math.abs(v1Var.f) == 1) {
                                    a2Var.c(v1Var);
                                }
                                c2 c2Var = a2Var.f;
                                c2Var.f = v1Var.d;
                                c2Var.a += v1Var.g.length;
                                c2Var.e = 0;
                                a2Var.a(v1Var);
                                if (!a2Var.d(v1Var)) {
                                }
                            } else if (l0Var == l0.b) {
                                v1Var.a().d = a2Var.f.f;
                                a2Var.b(v1Var);
                            }
                        } else {
                            LoggerProxy.d(a2Var.b, "put responseBag=null");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public b2(String str, r1 r1Var, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, r1Var, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = w0.a("PlayExecutor", str);
        this.b = str;
        this.c = new a2(str, r1Var, mVar);
    }
}

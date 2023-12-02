package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes8.dex */
public final class tlc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public byte[] H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public long R;
    public byte[] S;

    /* renamed from: T  reason: collision with root package name */
    public int f1158T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public byte[] Z;
    public int a;
    public int b;
    public final klc c;
    public byte[] d;
    public final int[] e;
    public final int[] f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final qlc k;
    public final qlc l;
    public final qlc m;
    public final int[] n;
    public final int[] o;
    public final int[] p;
    public final int[] q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public byte[] z;

    public tlc() {
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
        this.a = 0;
        this.c = new klc();
        this.e = new int[3240];
        this.f = new int[3240];
        this.k = new qlc();
        this.l = new qlc();
        this.m = new qlc();
        this.n = new int[3];
        this.o = new int[3];
        this.p = new int[6];
        this.q = new int[]{16, 15, 11, 4};
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.Q = 0;
        this.R = 0L;
        this.S = new byte[0];
        this.f1158T = 0;
    }

    public static void a(tlc tlcVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, tlcVar) == null) {
            int i = tlcVar.a;
            if (i != 0) {
                if (i == 11) {
                    return;
                }
                tlcVar.a = 11;
                klc.b(tlcVar.c);
                return;
            }
            throw new IllegalStateException("State MUST be initialized");
        }
    }

    public static int b(klc klcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, klcVar)) == null) {
            if (klc.i(klcVar, 1) == 0) {
                return 16;
            }
            int i = klc.i(klcVar, 3);
            if (i != 0) {
                return i + 17;
            }
            int i2 = klc.i(klcVar, 3);
            if (i2 == 0) {
                return 17;
            }
            return i2 + 8;
        }
        return invokeL.intValue;
    }

    public static void c(tlc tlcVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tlcVar, inputStream) == null) {
            if (tlcVar.a == 0) {
                klc.e(tlcVar.c, inputStream);
                int b = b(tlcVar.c);
                if (b != 9) {
                    int i = 1 << b;
                    tlcVar.P = i;
                    tlcVar.O = i - 16;
                    tlcVar.a = 1;
                    return;
                }
                throw new BrotliRuntimeException("Invalid 'windowBits' code");
            }
            throw new IllegalStateException("State MUST be uninitialized");
        }
    }
}

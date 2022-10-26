package com.bun.miitmdid;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static boolean b;
    public static AtomicLong c;
    public static boolean d;
    public static boolean e;
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2135478975, "Lcom/bun/miitmdid/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2135478975, "Lcom/bun/miitmdid/e$a;");
                    return;
                }
            }
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.i.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.p.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c.g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[c.k.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[c.v.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[c.w.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[c.l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[c.f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[c.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[c.r.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[c.j.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[c.e.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[c.d.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[c.o.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[c.m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[c.q.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[c.t.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[c.u.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2134063330, "Lcom/bun/miitmdid/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2134063330, "Lcom/bun/miitmdid/e;");
                return;
            }
        }
        c = new AtomicLong(5000L);
        d = true;
        e = true;
        f = true;
    }

    public e(boolean z, long j) {
        AtomicLong atomicLong;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f0.a(z);
        if (j <= 0) {
            atomicLong = c;
            j = 5000;
        } else {
            atomicLong = c;
        }
        atomicLong.set(j);
    }

    public e(boolean z, long j, boolean z2, boolean z3, boolean z4) {
        AtomicLong atomicLong;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        f0.a(z);
        if (j <= 0) {
            atomicLong = c;
            j = 5000;
        } else {
            atomicLong = c;
        }
        atomicLong.set(j);
        a(z2, z3, z4);
    }

    public static native int a();

    public static native boolean a(Context context, String str);

    public final native int a(int i, IdSupplier idSupplier);

    public native int a(Context context, IIdentifierListener iIdentifierListener);

    public native void a(boolean z, boolean z2, boolean z3);
}

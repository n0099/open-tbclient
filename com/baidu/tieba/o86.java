package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* loaded from: classes5.dex */
public interface o86 {

    /* loaded from: classes5.dex */
    public interface a {
        void a(t66 t66Var, long j, t86 t86Var, n66 n66Var);
    }

    float a(t66 t66Var, long j, t86 t86Var, n66 n66Var);

    void b(t66 t66Var);

    void clear();

    void update(int i, int i2);

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d a;
        public IntRange b;

        public b(d dVar, IntRange range) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, range};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(range, "range");
            this.a = dVar;
            this.b = range;
        }

        public final d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (d) invokeV.objValue;
        }

        public final IntRange b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (IntRange) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public d b;
        public d c;
        public boolean d;

        public c(int i, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, boolean z, boolean z2, boolean z3, boolean z4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), dVar, dVar2, dVar3, dVar4, dVar5, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = dVar2;
            this.c = dVar5;
            this.d = z4;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ c(int i, d dVar, d dVar2, d dVar3, d dVar4, d dVar5, boolean z, boolean z2, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(r1, r3, r5, r6, r7, r4, r8, r9, r10, (i2 & 512) == 0 ? z4 : false);
            int i3;
            d dVar6;
            d dVar7;
            d dVar8;
            d dVar9;
            boolean z5;
            boolean z6;
            boolean z7;
            if ((i2 & 1) != 0) {
                i3 = 0;
            } else {
                i3 = i;
            }
            if ((i2 & 2) != 0) {
                dVar6 = null;
            } else {
                dVar6 = dVar;
            }
            if ((i2 & 4) != 0) {
                dVar7 = null;
            } else {
                dVar7 = dVar2;
            }
            if ((i2 & 8) != 0) {
                dVar8 = null;
            } else {
                dVar8 = dVar3;
            }
            if ((i2 & 16) != 0) {
                dVar9 = null;
            } else {
                dVar9 = dVar4;
            }
            d dVar10 = (i2 & 32) == 0 ? dVar5 : null;
            if ((i2 & 64) != 0) {
                z5 = false;
            } else {
                z5 = z;
            }
            if ((i2 & 128) != 0) {
                z6 = false;
            } else {
                z6 = z2;
            }
            if ((i2 & 256) != 0) {
                z7 = false;
            } else {
                z7 = z3;
            }
        }

        public final d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (d) invokeV.objValue;
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.d;
            }
            return invokeV.booleanValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public final d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c;
            }
            return (d) invokeV.objValue;
        }

        public final void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.b = dVar;
            }
        }

        public final void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.d = z;
            }
        }

        public final void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.a = i;
            }
        }

        public final void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
                this.c = dVar;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final t66 a;
        public final long b;
        public int c;
        public int d;
        public final int e;
        public final int f;
        public int g;
        public final int h;
        public long i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-591048708, "Lcom/baidu/tieba/o86$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-591048708, "Lcom/baidu/tieba/o86$d;");
            }
        }

        public d(t66 item, long j, int i, int i2, int i3, int i4, int i5, int i6, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {item, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(item, "item");
            this.a = item;
            this.b = j;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = j2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ d(t66 t66Var, long j, int i, int i2, int i3, int i4, int i5, int i6, long j2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(t66Var, j, i, i2, i3, i4, r10, r11, r12);
            int i8;
            int i9;
            long j3;
            if ((i7 & 64) != 0) {
                i8 = -1;
            } else {
                i8 = i5;
            }
            if ((i7 & 128) != 0) {
                i9 = 0;
            } else {
                i9 = i6;
            }
            if ((i7 & 256) != 0) {
                j3 = 0;
            } else {
                j3 = j2;
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c + this.f;
            }
            return invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.g;
            }
            return invokeV.intValue;
        }

        public final t66 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (t66) invokeV.objValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.d + this.e;
            }
            return invokeV.intValue;
        }

        public final long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.b + this.i;
            }
            return invokeV.longValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                t66 t66Var = null;
                if (obj instanceof d) {
                    dVar = (d) obj;
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    t66Var = dVar.a;
                }
                return Intrinsics.areEqual(t66Var, this.a);
            }
            return invokeL.booleanValue;
        }

        public final void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.g = i;
            }
        }

        public final void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                this.c = i;
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return (((((((((((((((((((((this.a.hashCode() * 31) + com.baidu.tieba.a.a(this.b)) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + com.baidu.tieba.a.a(this.i)) * 31) + a()) * 31) + e()) * 31) + com.baidu.tieba.a.a(f());
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "{time: " + this.b + ", range: [" + this.c + IStringUtil.TOP_PATH + (this.c + this.f) + "], index: " + this.g + ", w: " + this.e + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d o1, d o2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, o1, o2)) == null) {
                Intrinsics.checkNotNullParameter(o1, "o1");
                Intrinsics.checkNotNullParameter(o2, "o2");
                return o2.g() - o1.g();
            }
            return invokeLL.intValue;
        }
    }
}

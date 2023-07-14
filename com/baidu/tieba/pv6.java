package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
/* loaded from: classes7.dex */
public final class pv6 implements Comparable<pv6> {
    public static /* synthetic */ Interceptable $ic;
    public static final a p;
    public static final pv6 q;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final long b;
    public final String c;
    public CharSequence d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public Long k;
    public yca l;
    public int m;
    public float n;
    public float o;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final pv6 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (pv6) invokeV.objValue;
            }
            return pv6.q;
        }

        public final pv6 b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                return new pv6(Long.MIN_VALUE, j, "", "", 0, 0, 0, 0, 0, 0, null, null, 0, 0.0f, 16256, null);
            }
            return (pv6) invokeJ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075545, "Lcom/baidu/tieba/pv6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075545, "Lcom/baidu/tieba/pv6;");
                return;
            }
        }
        a aVar = new a(null);
        p = aVar;
        q = aVar.b(Long.MAX_VALUE);
    }

    public pv6(long j, long j2, String content, CharSequence contentSpan, int i, int i2, int i3, int i4, int i5, int i6, Long l, yca postData, int i7, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), content, contentSpan, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), l, postData, Integer.valueOf(i7), Float.valueOf(f)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentSpan, "contentSpan");
        Intrinsics.checkNotNullParameter(postData, "postData");
        this.a = j;
        this.b = j2;
        this.c = content;
        this.d = contentSpan;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
        this.j = i6;
        this.k = l;
        this.l = postData;
        this.m = i7;
        this.n = f;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ pv6(long j, long j2, String str, CharSequence charSequence, int i, int i2, int i3, int i4, int i5, int i6, Long l, yca ycaVar, int i7, float f, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, str, charSequence, i, i2, i3, r13, r14, r15, r16, r17, r18, r19);
        int i9;
        int i10;
        int i11;
        Long l2;
        yca ycaVar2;
        int i12;
        float f2;
        if ((i8 & 128) != 0) {
            i9 = 0;
        } else {
            i9 = i4;
        }
        if ((i8 & 256) != 0) {
            i10 = 1;
        } else {
            i10 = i5;
        }
        if ((i8 & 512) != 0) {
            i11 = 0;
        } else {
            i11 = i6;
        }
        if ((i8 & 1024) != 0) {
            l2 = null;
        } else {
            l2 = l;
        }
        if ((i8 & 2048) != 0) {
            ycaVar2 = new yca();
        } else {
            ycaVar2 = ycaVar;
        }
        if ((i8 & 4096) != 0) {
            i12 = 0;
        } else {
            i12 = i7;
        }
        if ((i8 & 8192) != 0) {
            f2 = 0.0f;
        } else {
            f2 = f;
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final CharSequence d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (CharSequence) invokeV.objValue;
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return invokeV.floatValue;
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return invokeV.floatValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public final yca l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (yca) invokeV.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final Long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.k;
        }
        return (Long) invokeV.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.h > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(pv6 other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            return (int) (this.b - other.b);
        }
        return invokeL.intValue;
    }

    public final void r(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.o = f;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Danmaku{id: " + this.a + ", content: " + StringsKt___StringsKt.take(this.c, 5) + ", position: " + this.b + ", mode: " + this.e + ", rank: " + this.j + '}';
        }
        return (String) invokeV.objValue;
    }
}

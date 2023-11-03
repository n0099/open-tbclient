package com.baidu.tieba;

import androidx.annotation.Px;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public int t;
    public int u;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s0() {
        this(null, 0, 0, 0, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 2097151, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Float) objArr[6]).floatValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), ((Integer) objArr[9]).intValue(), ((Integer) objArr[10]).intValue(), ((Integer) objArr[11]).intValue(), ((Integer) objArr[12]).intValue(), ((Integer) objArr[13]).intValue(), ((Integer) objArr[14]).intValue(), ((Integer) objArr[15]).intValue(), ((Integer) objArr[16]).intValue(), ((Integer) objArr[17]).intValue(), ((Boolean) objArr[18]).booleanValue(), ((Integer) objArr[19]).intValue(), ((Integer) objArr[20]).intValue(), ((Integer) objArr[21]).intValue(), (DefaultConstructorMarker) objArr[22]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final s0 a(String str, int i, int i2, int i3, int i4, int i5, @Px float f, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z, int i17, int i18) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Boolean.valueOf(z), Integer.valueOf(i17), Integer.valueOf(i18)})) == null) ? new s0(str, i, i2, i3, i4, i5, f, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, z, i17, i18) : (s0) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof s0) {
                s0 s0Var = (s0) obj;
                return Intrinsics.areEqual(this.a, s0Var.a) && this.b == s0Var.b && this.c == s0Var.c && this.d == s0Var.d && this.e == s0Var.e && this.f == s0Var.f && Intrinsics.areEqual((Object) Float.valueOf(this.g), (Object) Float.valueOf(s0Var.g)) && this.h == s0Var.h && this.i == s0Var.i && this.j == s0Var.j && this.k == s0Var.k && this.l == s0Var.l && this.m == s0Var.m && this.n == s0Var.n && this.o == s0Var.o && this.p == s0Var.p && this.q == s0Var.q && this.r == s0Var.r && this.s == s0Var.s && this.t == s0Var.t && this.u == s0Var.u;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v19, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            String str = this.a;
            int hashCode = (((((((((((((((((((((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31;
            boolean z = this.s;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((((hashCode + i) * 31) + this.t) * 31) + this.u;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return "TabBadgeConfig(badgeText=" + this.a + ", badgeGravity=" + this.b + ", badgeSolidColor=" + this.c + ", badgeStrokeColor=" + this.d + ", badgeStrokeWidth=" + this.e + ", badgeTextColor=" + this.f + ", badgeTextSize=" + this.g + ", badgeCircleRadius=" + this.h + ", badgeRadius=" + this.i + ", badgeOffsetX=" + this.j + ", badgeOffsetY=" + this.k + ", badgeCircleOffsetX=" + this.l + ", badgeCircleOffsetY=" + this.m + ", badgePaddingLeft=" + this.n + ", badgePaddingRight=" + this.o + ", badgePaddingTop=" + this.p + ", badgePaddingBottom=" + this.q + ", badgeAnchorChildIndex=" + this.r + ", badgeIgnoreChildPadding=" + this.s + ", badgeMinHeight=" + this.t + ", badgeMinWidth=" + this.u + ')';
        }
        return (String) invokeV.objValue;
    }

    public s0(String str, int i, int i2, int i3, int i4, int i5, @Px float f, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z, int i17, int i18) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Boolean.valueOf(z), Integer.valueOf(i17), Integer.valueOf(i18)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i19 = newInitContext.flag;
            if ((i19 & 1) != 0) {
                int i20 = i19 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = f;
        this.h = i6;
        this.i = i7;
        this.j = i8;
        this.k = i9;
        this.l = i10;
        this.m = i11;
        this.n = i12;
        this.o = i13;
        this.p = i14;
        this.q = i15;
        this.r = i16;
        this.s = z;
        this.t = i17;
        this.u = i18;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ s0(String str, int i, int i2, int i3, int i4, int i5, float f, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r4, r6, r7, r9, r10, r11, r12, r13, r14, r15, r5, r8, r16, r17, r18, r19, r20, r0);
        String str2;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        float f2;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        boolean z2;
        int i36;
        int i37;
        if ((i19 & 1) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i19 & 2) != 0) {
            i20 = 17;
        } else {
            i20 = i;
        }
        if ((i19 & 4) != 0) {
            i21 = -65536;
        } else {
            i21 = i2;
        }
        if ((i19 & 8) != 0) {
            i22 = 0;
        } else {
            i22 = i3;
        }
        if ((i19 & 16) != 0) {
            i23 = 0;
        } else {
            i23 = i4;
        }
        if ((i19 & 32) != 0) {
            i24 = -1;
        } else {
            i24 = i5;
        }
        if ((i19 & 64) != 0) {
            f2 = 12 * r0.h();
        } else {
            f2 = f;
        }
        if ((i19 & 128) != 0) {
            i25 = r0.i() * 4;
        } else {
            i25 = i6;
        }
        if ((i19 & 256) != 0) {
            i26 = r0.i() * 10;
        } else {
            i26 = i7;
        }
        if ((i19 & 512) != 0) {
            i27 = 0;
        } else {
            i27 = i8;
        }
        if ((i19 & 1024) != 0) {
            i28 = 0;
        } else {
            i28 = i9;
        }
        if ((i19 & 2048) != 0) {
            i29 = 0;
        } else {
            i29 = i10;
        }
        if ((i19 & 4096) != 0) {
            i30 = 0;
        } else {
            i30 = i11;
        }
        if ((i19 & 8192) != 0) {
            i31 = r0.i() * 4;
        } else {
            i31 = i12;
        }
        if ((i19 & 16384) != 0) {
            i32 = r0.i() * 4;
        } else {
            i32 = i13;
        }
        if ((i19 & 32768) != 0) {
            i33 = 0;
        } else {
            i33 = i14;
        }
        if ((i19 & 65536) != 0) {
            i34 = 0;
        } else {
            i34 = i15;
        }
        if ((i19 & 131072) != 0) {
            i35 = -1;
        } else {
            i35 = i16;
        }
        if ((i19 & 262144) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i19 & 524288) != 0) {
            i36 = -2;
        } else {
            i36 = i17;
        }
        if ((i19 & 1048576) != 0) {
            i37 = -1;
        } else {
            i37 = i18;
        }
    }

    public final void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.h = i;
        }
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b = i;
        }
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.s = z;
        }
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.t = i;
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.u = i;
        }
    }

    public final void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.j = i;
        }
    }

    public final void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.k = i;
        }
    }

    public final void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.q = i;
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.n = i;
        }
    }

    public final void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o = i;
        }
    }

    public final void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.p = i;
        }
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.i = i;
        }
    }

    public final void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.c = i;
        }
    }

    public final void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
        }
    }

    public final void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.e = i;
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a = str;
        }
    }

    public final void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f = i;
        }
    }

    public final void R(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
            this.g = f;
        }
    }

    public final void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.r = i;
        }
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.l = i;
        }
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.m = i;
        }
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final float w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.g;
        }
        return invokeV.floatValue;
    }
}

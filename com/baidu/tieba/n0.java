package com.baidu.tieba;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.angcyo.tablayout.DslBadgeDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public class n0 extends DslBadgeDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s0 L;
    public String M;

    public n0() {
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
        this.L = new s0(null, 0, 0, 0, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 2097151, null);
    }

    @Override // com.angcyo.tablayout.DslBadgeDrawable, com.angcyo.tablayout.AbsDslDrawable
    public void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ee7.DslTabLayout);
            H(obtainStyledAttributes.getColor(15, this.L.r()));
            this.L.M(w());
            v0(obtainStyledAttributes.getColor(19, this.L.v()));
            this.L.Q(Z());
            I(obtainStyledAttributes.getColor(16, this.L.s()));
            this.L.N(x());
            J(obtainStyledAttributes.getDimensionPixelOffset(17, this.L.t()));
            this.L.O(y());
            l0(obtainStyledAttributes.getInt(4, this.L.g()));
            this.L.B(R());
            o0(obtainStyledAttributes.getDimensionPixelOffset(8, this.L.k()));
            this.L.F(S());
            p0(obtainStyledAttributes.getDimensionPixelOffset(9, this.L.l()));
            this.L.G(T());
            i0(obtainStyledAttributes.getDimensionPixelOffset(1, this.L.k()));
            this.L.y(O());
            j0(obtainStyledAttributes.getDimensionPixelOffset(2, this.L.l()));
            this.L.z(P());
            k0(obtainStyledAttributes.getDimensionPixelOffset(3, this.L.f()));
            this.L.A(Q());
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(14, this.L.q());
            q(dimensionPixelOffset);
            this.L.L(dimensionPixelOffset);
            r0(obtainStyledAttributes.getDimensionPixelOffset(11, this.L.n()));
            this.L.I(V());
            s0(obtainStyledAttributes.getDimensionPixelOffset(12, this.L.o()));
            this.L.J(W());
            t0(obtainStyledAttributes.getDimensionPixelOffset(13, this.L.p()));
            this.L.K(X());
            q0(obtainStyledAttributes.getDimensionPixelOffset(10, this.L.m()));
            this.L.H(U());
            this.M = obtainStyledAttributes.getString(18);
            w0(obtainStyledAttributes.getDimensionPixelOffset(20, (int) this.L.w()));
            this.L.R(c0());
            s0 s0Var = this.L;
            s0Var.x(obtainStyledAttributes.getInteger(0, s0Var.c()));
            s0 s0Var2 = this.L;
            s0Var2.C(obtainStyledAttributes.getBoolean(5, s0Var2.h()));
            s0 s0Var3 = this.L;
            s0Var3.E(obtainStyledAttributes.getLayoutDimension(7, s0Var3.j()));
            s0 s0Var4 = this.L;
            s0Var4.D(obtainStyledAttributes.getLayoutDimension(6, s0Var4.i()));
            obtainStyledAttributes.recycle();
            super.k(context, attributeSet);
        }
    }

    public final s0 x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.L;
        }
        return (s0) invokeV.objValue;
    }

    public final String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    public final void z0(s0 badgeConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, badgeConfig) == null) {
            Intrinsics.checkNotNullParameter(badgeConfig, "badgeConfig");
            H(badgeConfig.r());
            I(badgeConfig.s());
            J(badgeConfig.t());
            v0(badgeConfig.v());
            l0(badgeConfig.g());
            o0(badgeConfig.k());
            p0(badgeConfig.l());
            i0(badgeConfig.d());
            j0(badgeConfig.e());
            k0(badgeConfig.f());
            r0(badgeConfig.n());
            s0(badgeConfig.o());
            t0(badgeConfig.p());
            q0(badgeConfig.m());
            w0(badgeConfig.w());
            q(badgeConfig.q());
            m0(badgeConfig.i());
            n0(badgeConfig.j());
            u0(badgeConfig.u());
        }
    }
}

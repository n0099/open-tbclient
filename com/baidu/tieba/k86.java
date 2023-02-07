package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i86;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class k86 extends i86<k86> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l86 s;
    public float t;
    public boolean u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <K> k86(K k, j86<K> j86Var) {
        super(k, j86Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k, j86Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], (j86) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = null;
        this.t = Float.MAX_VALUE;
        this.u = false;
    }

    @Override // com.baidu.tieba.i86
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l();
            this.s.g(e());
            super.h();
        }
    }

    @Override // com.baidu.tieba.i86
    public boolean j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (this.u) {
                float f = this.t;
                if (f != Float.MAX_VALUE) {
                    this.s.e(f);
                    this.t = Float.MAX_VALUE;
                }
                this.b = this.s.a();
                this.a = 0.0f;
                this.u = false;
                return true;
            }
            if (this.t != Float.MAX_VALUE) {
                this.s.a();
                long j2 = j / 2;
                i86.h h = this.s.h(this.b, this.a, j2);
                this.s.e(this.t);
                this.t = Float.MAX_VALUE;
                i86.h h2 = this.s.h(h.a, h.b, j2);
                this.b = h2.a;
                this.a = h2.b;
            } else {
                i86.h h3 = this.s.h(this.b, this.a, j);
                this.b = h3.a;
                this.a = h3.b;
            }
            float max = Math.max(this.b, this.h);
            this.b = max;
            float min = Math.min(max, this.g);
            this.b = min;
            if (!k(min, this.a)) {
                return false;
            }
            this.b = this.s.a();
            this.a = 0.0f;
            return true;
        }
        return invokeJ.booleanValue;
    }

    public boolean k(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return this.s.c(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l86 l86Var = this.s;
            if (l86Var != null) {
                double a = l86Var.a();
                if (a <= this.g) {
                    if (a >= this.h) {
                        return;
                    }
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            }
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public k86 m(l86 l86Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l86Var)) == null) {
            this.s = l86Var;
            return this;
        }
        return (k86) invokeL.objValue;
    }
}

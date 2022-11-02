package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class mz9<T> implements hz9<T>, nz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final r1a a;
    public final mz9<?> b;
    public iz9 c;
    public long d;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mz9() {
        this(null, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((mz9) objArr[0], ((Boolean) objArr[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mz9(mz9<?> mz9Var) {
        this(mz9Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((mz9) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j >= 0) {
                synchronized (this) {
                    if (this.c != null) {
                        this.c.request(j);
                        return;
                    }
                    c(j);
                    return;
                }
            }
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
    }

    public void f(iz9 iz9Var) {
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iz9Var) == null) {
            synchronized (this) {
                j = this.d;
                this.c = iz9Var;
                if (this.b != null && j == Long.MIN_VALUE) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                this.b.f(this.c);
            } else if (j == Long.MIN_VALUE) {
                this.c.request(Long.MAX_VALUE);
            } else {
                this.c.request(j);
            }
        }
    }

    public mz9(mz9<?> mz9Var, boolean z) {
        r1a r1aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mz9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = Long.MIN_VALUE;
        this.b = mz9Var;
        if (z && mz9Var != null) {
            r1aVar = mz9Var.a;
        } else {
            r1aVar = new r1a();
        }
        this.a = r1aVar;
    }

    public final void b(nz9 nz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nz9Var) == null) {
            this.a.a(nz9Var);
        }
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            long j2 = this.d;
            if (j2 == Long.MIN_VALUE) {
                this.d = j;
                return;
            }
            long j3 = j2 + j;
            if (j3 < 0) {
                this.d = Long.MAX_VALUE;
            } else {
                this.d = j3;
            }
        }
    }

    @Override // com.baidu.tieba.nz9
    public final boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.isUnsubscribed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nz9
    public final void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.unsubscribe();
        }
    }
}

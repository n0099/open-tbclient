package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class yac<T> implements tac<T>, zac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kdc a;
    public final yac<?> b;
    public uac c;
    public long d;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yac() {
        this(null, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((yac) objArr[0], ((Boolean) objArr[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public yac(yac<?> yacVar) {
        this(yacVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yacVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((yac) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
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

    public void f(uac uacVar) {
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uacVar) == null) {
            synchronized (this) {
                j = this.d;
                this.c = uacVar;
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

    public yac(yac<?> yacVar, boolean z) {
        kdc kdcVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yacVar, Boolean.valueOf(z)};
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
        this.b = yacVar;
        if (z && yacVar != null) {
            kdcVar = yacVar.a;
        } else {
            kdcVar = new kdc();
        }
        this.a = kdcVar;
    }

    public final void b(zac zacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zacVar) == null) {
            this.a.a(zacVar);
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

    @Override // com.baidu.tieba.zac
    public final boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.isUnsubscribed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zac
    public final void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.unsubscribe();
        }
    }
}

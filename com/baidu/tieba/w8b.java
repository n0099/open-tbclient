package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Incorrect class signature, class is equals to this class: <TResult:Ljava/lang/Object;>Lcom/baidu/tieba/w8b<TTResult;>; */
/* loaded from: classes8.dex */
public final class w8b<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object a;
    public boolean b;
    public TResult c;
    public Exception d;
    public List<k9b<TResult>> e;

    public w8b() {
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
        this.a = new Object();
        this.e = new ArrayList();
    }

    public final Exception c() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.a) {
                exc = this.d;
            }
            return exc;
        }
        return (Exception) invokeV.objValue;
    }

    public final TResult d() {
        InterceptResult invokeV;
        TResult tresult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.a) {
                if (this.d == null) {
                    tresult = this.c;
                } else {
                    throw new RuntimeException(this.d);
                }
            }
            return tresult;
        }
        return (TResult) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.a) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.a) {
                if (this.b) {
                    e();
                    if (this.d == null) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final w8b<TResult> a(k9b<TResult> k9bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k9bVar)) == null) {
            synchronized (this.a) {
                if (!this.b) {
                    this.e.add(k9bVar);
                } else {
                    k9bVar.a(this);
                }
            }
            return this;
        }
        return (w8b) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.a) {
                for (k9b<TResult> k9bVar : this.e) {
                    try {
                        k9bVar.a(this);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
                this.e = null;
            }
        }
    }
}

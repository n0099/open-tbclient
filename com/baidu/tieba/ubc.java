package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes8.dex */
public final class ubc implements m7c, u7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final m7c a;
    public u7c b;
    public boolean c;

    public ubc(m7c m7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m7cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m7cVar;
    }

    @Override // com.baidu.tieba.m7c
    public void onSubscribe(u7c u7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, u7cVar) == null) {
            this.b = u7cVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                z7c.e(th);
                u7cVar.unsubscribe();
                onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.u7c
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.c && !this.b.isUnsubscribed()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m7c
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c) {
            return;
        }
        this.c = true;
        try {
            this.a.onCompleted();
        } catch (Throwable th) {
            z7c.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.unsubscribe();
        }
    }

    @Override // com.baidu.tieba.m7c
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            bcc.j(th);
            if (this.c) {
                return;
            }
            this.c = true;
            try {
                this.a.onError(th);
            } catch (Throwable th2) {
                z7c.e(th2);
                throw new OnErrorFailedException(new CompositeException(th, th2));
            }
        }
    }
}

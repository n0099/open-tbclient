package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
/* loaded from: classes7.dex */
public class nsc<T> extends joc<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final joc<? super T> e;
    public boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nsc(joc<? super T> jocVar) {
        super(jocVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jocVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((joc) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = jocVar;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void g(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            wsc.c().b().a(th);
            try {
                this.e.onError(th);
                try {
                    unsubscribe();
                } catch (Throwable th2) {
                    tsc.j(th2);
                    throw new OnErrorFailedException(th2);
                }
            } catch (OnErrorNotImplementedException e) {
                try {
                    unsubscribe();
                    throw e;
                } catch (Throwable th3) {
                    tsc.j(th3);
                    throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
                }
            } catch (Throwable th4) {
                tsc.j(th4);
                try {
                    unsubscribe();
                    throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
                } catch (Throwable th5) {
                    tsc.j(th5);
                    throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // com.baidu.tieba.eoc
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.f) {
            this.f = true;
            try {
                this.e.onCompleted();
                try {
                    unsubscribe();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    poc.e(th);
                    tsc.j(th);
                    throw new OnCompletedFailedException(th.getMessage(), th);
                } catch (Throwable th2) {
                    try {
                        unsubscribe();
                        throw th2;
                    } finally {
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.eoc
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            poc.e(th);
            if (!this.f) {
                this.f = true;
                g(th);
            }
        }
    }

    @Override // com.baidu.tieba.eoc
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            try {
                if (!this.f) {
                    this.e.onNext(t);
                }
            } catch (Throwable th) {
                poc.f(th, this);
            }
        }
    }
}

package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public class sbc<T> implements sac.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tac<? super T> a;
    public final sac<T> b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends yac<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final yac<? super T> e;
        public final tac<? super T> f;
        public boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yac<? super T> yacVar, tac<? super T> tacVar) {
            super(yacVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yacVar, tacVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((yac) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yacVar;
            this.f = tacVar;
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.g) {
                return;
            }
            try {
                this.f.onCompleted();
                this.g = true;
                this.e.onCompleted();
            } catch (Throwable th) {
                ebc.f(th, this);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.g) {
                    gfc.j(th);
                    return;
                }
                this.g = true;
                try {
                    this.f.onError(th);
                    this.e.onError(th);
                } catch (Throwable th2) {
                    ebc.e(th2);
                    this.e.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        @Override // com.baidu.tieba.tac
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) != null) || this.g) {
                return;
            }
            try {
                this.f.onNext(t);
                this.e.onNext(t);
            } catch (Throwable th) {
                ebc.g(th, this, t);
            }
        }
    }

    public sbc(sac<T> sacVar, tac<? super T> tacVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sacVar, tacVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = sacVar;
        this.a = tacVar;
    }

    public void call(yac<? super T> yacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
            this.b.O(new a(yacVar, this.a));
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}

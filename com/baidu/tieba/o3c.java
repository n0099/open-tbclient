package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class o3c<T> implements y1c.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y1c<T> a;
    public final i2c<? super T> b;
    public final i2c<Throwable> c;

    /* loaded from: classes7.dex */
    public static final class a<T> extends z1c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final z1c<? super T> b;
        public final i2c<? super T> c;
        public final i2c<Throwable> d;

        public a(z1c<? super T> z1cVar, i2c<? super T> i2cVar, i2c<Throwable> i2cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z1cVar, i2cVar, i2cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z1cVar;
            this.c = i2cVar;
            this.d = i2cVar2;
        }

        @Override // com.baidu.tieba.z1c
        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.d.call(th);
                    this.b.b(th);
                } catch (Throwable th2) {
                    g2c.e(th2);
                    this.b.b(new CompositeException(th, th2));
                }
            }
        }

        @Override // com.baidu.tieba.z1c
        public void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                    this.b.c(t);
                } catch (Throwable th) {
                    g2c.h(th, this, t);
                }
            }
        }
    }

    public o3c(y1c<T> y1cVar, i2c<? super T> i2cVar, i2c<Throwable> i2cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y1cVar, i2cVar, i2cVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = y1cVar;
        this.b = i2cVar;
        this.c = i2cVar2;
    }

    public void call(z1c<? super T> z1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z1cVar) == null) {
            a aVar = new a(z1cVar, this.b, this.c);
            z1cVar.a(aVar);
            this.a.j(aVar);
        }
    }

    @Override // com.baidu.tieba.y1c.c, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((z1c) ((z1c) obj));
    }
}

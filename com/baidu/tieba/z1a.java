package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes6.dex */
public class z1a implements yx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yx9 a;
    public boolean b;
    public volatile boolean c;
    public a d;

    /* loaded from: classes6.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object[] a;
        public int b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                int i = this.b;
                Object[] objArr = this.a;
                if (objArr == null) {
                    objArr = new Object[16];
                    this.a = objArr;
                } else if (i == objArr.length) {
                    Object[] objArr2 = new Object[(i >> 2) + i];
                    System.arraycopy(objArr, 0, objArr2, 0, i);
                    this.a = objArr2;
                    objArr = objArr2;
                }
                objArr[i] = obj;
                this.b = i + 1;
            }
        }
    }

    public z1a(yx9 yx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yx9Var;
    }

    @Override // com.baidu.tieba.yx9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.c) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.b) {
                a aVar = this.d;
                if (aVar == null) {
                    aVar = new a();
                    this.d = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.b = true;
            this.a.onCompleted();
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            jy9.e(th);
            if (this.c) {
                return;
            }
            synchronized (this) {
                if (this.c) {
                    return;
                }
                this.c = true;
                if (this.b) {
                    a aVar = this.d;
                    if (aVar == null) {
                        aVar = new a();
                        this.d = aVar;
                    }
                    aVar.a(NotificationLite.c(th));
                    return;
                }
                this.b = true;
                this.a.onError(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0031, code lost:
        continue;
     */
    @Override // com.baidu.tieba.yx9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(Object obj) {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) != null) || this.c) {
            return;
        }
        synchronized (this) {
            if (this.c) {
                return;
            }
            if (this.b) {
                a aVar = this.d;
                if (aVar == null) {
                    aVar = new a();
                    this.d = aVar;
                }
                aVar.a(NotificationLite.h(obj));
                return;
            }
            this.b = true;
            try {
                this.a.onNext(obj);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.d;
                        if (aVar2 == null) {
                            this.b = false;
                            return;
                        }
                        this.d = null;
                        for (Object obj2 : aVar2.a) {
                            if (obj2 == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.a, obj2)) {
                                    this.c = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.c = true;
                                jy9.e(th);
                                this.a.onError(OnErrorThrowable.addValueAsLastCause(th, obj));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.c = true;
                jy9.g(th2, this.a, obj);
            }
        }
    }
}

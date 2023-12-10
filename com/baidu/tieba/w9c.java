package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class w9c {
    public static /* synthetic */ Interceptable $ic;
    public static final w9c e;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> a;
    public volatile boolean b;
    public volatile boolean c;
    public y9c d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948226856, "Lcom/baidu/tieba/w9c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948226856, "Lcom/baidu/tieba/w9c;");
                return;
            }
        }
        e = new w9c();
    }

    public w9c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.get();
        }
        return (Context) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(l9c l9cVar, boolean z) {
        this.d.d(l9cVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Runnable runnable, l9c l9cVar) {
        if (this.b) {
            runnable.run();
        } else if (l9cVar != null) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
            l9cVar.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public void b(final l9c<String> l9cVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l9cVar, z) == null) {
            d(new Runnable() { // from class: com.baidu.tieba.h9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        w9c.this.e(l9cVar, z);
                    }
                }
            }, l9cVar);
        }
    }

    public final void d(final Runnable runnable, final l9c<?> l9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, runnable, l9cVar) == null) {
            jac.b(new Runnable() { // from class: com.baidu.tieba.g9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        w9c.this.g(runnable, l9cVar);
                    }
                }
            });
        }
    }

    public void c(final aac aacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aacVar) == null) {
            jac.b(new Runnable() { // from class: com.baidu.tieba.f9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        w9c.this.f(aacVar);
                    }
                }
            });
        }
    }

    public final void f(aac aacVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aacVar) == null) && !this.b) {
            this.b = true;
            this.a = new WeakReference<>(aacVar.a);
            this.c = aacVar.b;
            this.d = new y9c(aacVar.a);
            if (this.c) {
                b(null, true);
            }
        }
    }
}

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
public class v9c {
    public static /* synthetic */ Interceptable $ic;
    public static final v9c e;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> a;
    public volatile boolean b;
    public volatile boolean c;
    public x9c d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948197065, "Lcom/baidu/tieba/v9c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948197065, "Lcom/baidu/tieba/v9c;");
                return;
            }
        }
        e = new v9c();
    }

    public v9c() {
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
    public /* synthetic */ void e(k9c k9cVar, boolean z) {
        this.d.d(k9cVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Runnable runnable, k9c k9cVar) {
        if (this.b) {
            runnable.run();
        } else if (k9cVar != null) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
            k9cVar.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public void b(final k9c<String> k9cVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k9cVar, z) == null) {
            d(new Runnable() { // from class: com.baidu.tieba.g9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        v9c.this.e(k9cVar, z);
                    }
                }
            }, k9cVar);
        }
    }

    public final void d(final Runnable runnable, final k9c<?> k9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, runnable, k9cVar) == null) {
            iac.b(new Runnable() { // from class: com.baidu.tieba.f9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        v9c.this.g(runnable, k9cVar);
                    }
                }
            });
        }
    }

    public void c(final z9c z9cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z9cVar) == null) {
            iac.b(new Runnable() { // from class: com.baidu.tieba.e9c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        v9c.this.f(z9cVar);
                    }
                }
            });
        }
    }

    public final void f(z9c z9cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, z9cVar) == null) && !this.b) {
            this.b = true;
            this.a = new WeakReference<>(z9cVar.a);
            this.c = z9cVar.b;
            this.d = new x9c(z9cVar.a);
            if (this.c) {
                b(null, true);
            }
        }
    }
}

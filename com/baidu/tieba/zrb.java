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
/* loaded from: classes9.dex */
public class zrb {
    public static /* synthetic */ Interceptable $ic;
    public static final zrb e;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> a;
    public volatile boolean b;
    public volatile boolean c;
    public bsb d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948370975, "Lcom/baidu/tieba/zrb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948370975, "Lcom/baidu/tieba/zrb;");
                return;
            }
        }
        e = new zrb();
    }

    public zrb() {
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
    public /* synthetic */ void e(orb orbVar, boolean z) {
        this.d.d(orbVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Runnable runnable, orb orbVar) {
        if (this.b) {
            runnable.run();
        } else if (orbVar != null) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
            orbVar.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public void b(final orb<String> orbVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, orbVar, z) == null) {
            d(new Runnable() { // from class: com.baidu.tieba.krb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zrb.this.e(orbVar, z);
                    }
                }
            }, orbVar);
        }
    }

    public final void d(final Runnable runnable, final orb<?> orbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, runnable, orbVar) == null) {
            msb.b(new Runnable() { // from class: com.baidu.tieba.jrb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zrb.this.g(runnable, orbVar);
                    }
                }
            });
        }
    }

    public void c(final dsb dsbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dsbVar) == null) {
            msb.b(new Runnable() { // from class: com.baidu.tieba.irb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zrb.this.f(dsbVar);
                    }
                }
            });
        }
    }

    public final void f(dsb dsbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dsbVar) == null) && !this.b) {
            this.b = true;
            this.a = new WeakReference<>(dsbVar.a);
            this.c = dsbVar.b;
            this.d = new bsb(dsbVar.a);
            if (this.c) {
                b(null, true);
            }
        }
    }
}

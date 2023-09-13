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
/* loaded from: classes6.dex */
public class kwb {
    public static /* synthetic */ Interceptable $ic;
    public static final kwb e;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> a;
    public volatile boolean b;
    public volatile boolean c;
    public mwb d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947928915, "Lcom/baidu/tieba/kwb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947928915, "Lcom/baidu/tieba/kwb;");
                return;
            }
        }
        e = new kwb();
    }

    public kwb() {
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
    public /* synthetic */ void e(zvb zvbVar, boolean z) {
        this.d.d(zvbVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Runnable runnable, zvb zvbVar) {
        if (this.b) {
            runnable.run();
        } else if (zvbVar != null) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
            zvbVar.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public void b(final zvb<String> zvbVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zvbVar, z) == null) {
            d(new Runnable() { // from class: com.baidu.tieba.vvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kwb.this.e(zvbVar, z);
                    }
                }
            }, zvbVar);
        }
    }

    public final void d(final Runnable runnable, final zvb<?> zvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, runnable, zvbVar) == null) {
            xwb.b(new Runnable() { // from class: com.baidu.tieba.uvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kwb.this.g(runnable, zvbVar);
                    }
                }
            });
        }
    }

    public void c(final owb owbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, owbVar) == null) {
            xwb.b(new Runnable() { // from class: com.baidu.tieba.tvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kwb.this.f(owbVar);
                    }
                }
            });
        }
    }

    public final void f(owb owbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, owbVar) == null) && !this.b) {
            this.b = true;
            this.a = new WeakReference<>(owbVar.a);
            this.c = owbVar.b;
            this.d = new mwb(owbVar.a);
            if (this.c) {
                b(null, true);
            }
        }
    }
}

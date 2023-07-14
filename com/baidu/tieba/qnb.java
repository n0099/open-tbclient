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
/* loaded from: classes7.dex */
public class qnb {
    public static /* synthetic */ Interceptable $ic;
    public static final qnb e;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> a;
    public volatile boolean b;
    public volatile boolean c;
    public snb d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948099012, "Lcom/baidu/tieba/qnb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948099012, "Lcom/baidu/tieba/qnb;");
                return;
            }
        }
        e = new qnb();
    }

    public qnb() {
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
    public /* synthetic */ void e(fnb fnbVar, boolean z) {
        this.d.d(fnbVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Runnable runnable, fnb fnbVar) {
        if (this.b) {
            runnable.run();
        } else if (fnbVar != null) {
            HonorPushErrorEnum honorPushErrorEnum = HonorPushErrorEnum.ERROR_NOT_INITIALIZED;
            fnbVar.onFailure(honorPushErrorEnum.getErrorCode(), honorPushErrorEnum.getMessage());
        }
    }

    public void b(final fnb<String> fnbVar, final boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fnbVar, z) == null) {
            d(new Runnable() { // from class: com.baidu.tieba.bnb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        qnb.this.e(fnbVar, z);
                    }
                }
            }, fnbVar);
        }
    }

    public final void d(final Runnable runnable, final fnb<?> fnbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, runnable, fnbVar) == null) {
            dob.b(new Runnable() { // from class: com.baidu.tieba.anb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        qnb.this.g(runnable, fnbVar);
                    }
                }
            });
        }
    }

    public void c(final unb unbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unbVar) == null) {
            dob.b(new Runnable() { // from class: com.baidu.tieba.zmb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        qnb.this.f(unbVar);
                    }
                }
            });
        }
    }

    public final void f(unb unbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, unbVar) == null) && !this.b) {
            this.b = true;
            this.a = new WeakReference<>(unbVar.a);
            this.c = unbVar.b;
            this.d = new snb(unbVar.a);
            if (this.c) {
                b(null, true);
            }
        }
    }
}

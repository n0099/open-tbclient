package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nub<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vtb<TResult> a;

    public nub() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new vtb<>();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            vtb<TResult> vtbVar = this.a;
            synchronized (vtbVar.a) {
                if (!vtbVar.b) {
                    vtbVar.b = true;
                    vtbVar.d = exc;
                    vtbVar.a.notifyAll();
                    vtbVar.b();
                }
            }
        }
    }

    public void b(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tresult) == null) {
            vtb<TResult> vtbVar = this.a;
            synchronized (vtbVar.a) {
                if (!vtbVar.b) {
                    vtbVar.b = true;
                    vtbVar.c = tresult;
                    vtbVar.a.notifyAll();
                    vtbVar.b();
                }
            }
        }
    }
}

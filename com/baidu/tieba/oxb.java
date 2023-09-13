package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oxb<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wwb<TResult> a;

    public oxb() {
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
        this.a = new wwb<>();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            wwb<TResult> wwbVar = this.a;
            synchronized (wwbVar.a) {
                if (!wwbVar.b) {
                    wwbVar.b = true;
                    wwbVar.d = exc;
                    wwbVar.a.notifyAll();
                    wwbVar.b();
                }
            }
        }
    }

    public void b(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tresult) == null) {
            wwb<TResult> wwbVar = this.a;
            synchronized (wwbVar.a) {
                if (!wwbVar.b) {
                    wwbVar.b = true;
                    wwbVar.c = tresult;
                    wwbVar.a.notifyAll();
                    wwbVar.b();
                }
            }
        }
    }
}

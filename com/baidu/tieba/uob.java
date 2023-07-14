package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uob<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final cob<TResult> a;

    public uob() {
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
        this.a = new cob<>();
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            cob<TResult> cobVar = this.a;
            synchronized (cobVar.a) {
                if (!cobVar.b) {
                    cobVar.b = true;
                    cobVar.d = exc;
                    cobVar.a.notifyAll();
                    cobVar.b();
                }
            }
        }
    }

    public void b(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tresult) == null) {
            cob<TResult> cobVar = this.a;
            synchronized (cobVar.a) {
                if (!cobVar.b) {
                    cobVar.b = true;
                    cobVar.c = tresult;
                    cobVar.a.notifyAll();
                    cobVar.b();
                }
            }
        }
    }
}

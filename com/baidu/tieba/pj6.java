package com.baidu.tieba;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mj6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pj6 implements oj6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pj6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public oj6 a;

    public pj6() {
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

    public static pj6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (pj6.class) {
                    if (b == null) {
                        b = new pj6();
                    }
                }
            }
            return b;
        }
        return (pj6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj6
    public WebResourceResponse a(String str, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, webResourceRequest)) == null) {
            oj6 oj6Var = this.a;
            if (oj6Var == null) {
                return null;
            }
            return oj6Var.a(str, webResourceRequest);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public void c(mj6.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && aVar != null) {
            this.a = aVar.b();
        }
    }
}

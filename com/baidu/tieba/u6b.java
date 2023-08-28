package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.ExperimentalCronetEngine;
import com.baidu.turbonet.net.ExperimentalUrlRequest;
import com.baidu.turbonet.net.RequestFinishedInfo;
import com.baidu.turbonet.net.UrlRequest;
import java.util.Collection;
import java.util.concurrent.Executor;
/* loaded from: classes8.dex */
public abstract class u6b extends ExperimentalCronetEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract r7b g(String str, UrlRequest.Callback callback, Executor executor, int i, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, @Nullable RequestFinishedInfo.Listener listener, int i4);

    public u6b() {
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

    @Override // com.baidu.turbonet.net.ExperimentalCronetEngine
    public ExperimentalUrlRequest.Builder f(String str, UrlRequest.Callback callback, Executor executor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, callback, executor)) == null) {
            return new s7b(str, callback, executor, this);
        }
        return (ExperimentalUrlRequest.Builder) invokeLLL.objValue;
    }
}

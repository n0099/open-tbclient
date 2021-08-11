package com.baidu.webkit.sdk.system;

import android.os.Build;
import android.webkit.TracingConfig;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.TracingConfig;
import com.baidu.webkit.sdk.TracingController;
import java.io.OutputStream;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class TracingControllerImpl extends TracingController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TracingControllerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.webkit.sdk.TracingController
    public boolean isTracing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return android.webkit.TracingController.getInstance().isTracing();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.TracingController
    public void start(@NonNull TracingConfig tracingConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tracingConfig) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        android.webkit.TracingController.getInstance().start(new TracingConfig.Builder().addCategories(tracingConfig.getPredefinedCategories()).addCategories(tracingConfig.getCustomIncludedCategories()).setTracingMode(tracingConfig.getTracingMode()).build());
    }

    @Override // com.baidu.webkit.sdk.TracingController
    public boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, outputStream, executor)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return android.webkit.TracingController.getInstance().stop(outputStream, executor);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}

package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
/* loaded from: classes7.dex */
public final class zp3 implements RequestListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r82 a;

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, map) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, th, map) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, map) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, str, str2, z) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public zp3(r82 r82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = r82Var;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String str) {
        r82 r82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (r82Var = this.a) != null) {
            r82Var.onCancel(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        r82 r82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{imageRequest, str, th, Boolean.valueOf(z)}) == null) && (r82Var = this.a) != null) {
            r82Var.c(imageRequest, th);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        r82 r82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{imageRequest, obj, str, Boolean.valueOf(z)}) == null) && (r82Var = this.a) != null) {
            r82Var.a(imageRequest);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        r82 r82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageRequest, str, z) == null) && (r82Var = this.a) != null) {
            r82Var.b(imageRequest);
        }
    }
}

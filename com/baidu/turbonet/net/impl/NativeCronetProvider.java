package com.baidu.turbonet.net.impl;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h6b;
import com.baidu.tieba.x5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.CronetProvider;
import com.baidu.turbonet.net.ExperimentalCronetEngine;
import com.baidu.turbonet.net.TurbonetEngine;
import java.util.Arrays;
import org.chromium.base.annotations.UsedByReflection;
/* loaded from: classes9.dex */
public class NativeCronetProvider extends CronetProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.turbonet.net.CronetProvider
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "App-Packaged-Cronet-Provider" : (String) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.CronetProvider
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @UsedByReflection("CronetProvider.java")
    public NativeCronetProvider(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.turbonet.net.CronetProvider
    public TurbonetEngine.Builder b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new ExperimentalCronetEngine.Builder(new h6b(this.a));
        }
        return (TurbonetEngine.Builder) invokeV.objValue;
    }

    @Override // com.baidu.turbonet.net.CronetProvider
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return x5b.a();
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.a});
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj != this && (!(obj instanceof NativeCronetProvider) || !this.a.equals(((NativeCronetProvider) obj).a))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

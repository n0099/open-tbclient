package com.baidu.tieba;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.IResourcesFetcher_ResourcesFetcherManager_Provider;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class je1 {
    public static /* synthetic */ Interceptable $ic;
    public static je1 b;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public kk1<IResourcesFetcher> a;

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ik1 b2 = ik1.b();
            this.a = b2;
            b2.a(new IResourcesFetcher_ResourcesFetcherManager_Provider());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947880307, "Lcom/baidu/tieba/je1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947880307, "Lcom/baidu/tieba/je1;");
                return;
            }
        }
        b = new je1();
    }

    public je1() {
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
        e();
    }

    public static je1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (je1) invokeV.objValue;
    }

    public Resources b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.get().getGlobalResources();
        }
        return (Resources) invokeV.objValue;
    }

    public Resources[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.get().getWrapperResources();
        }
        return (Resources[]) invokeV.objValue;
    }

    public Resources a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (hf1.a()) {
                Log.i("NPS-ResourcesFetcher", "resourcesFetcherHolder class=" + this.a.getClass());
            }
            return this.a.get().getBaseContextResources();
        }
        return (Resources) invokeV.objValue;
    }
}

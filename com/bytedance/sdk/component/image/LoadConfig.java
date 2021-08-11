package com.bytedance.sdk.component.image;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
/* loaded from: classes9.dex */
public class LoadConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IKeyGenerator f64706a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f64707b;

    /* renamed from: c  reason: collision with root package name */
    public IHttpClient f64708c;

    /* renamed from: d  reason: collision with root package name */
    public IMemoryCache f64709d;

    /* renamed from: e  reason: collision with root package name */
    public IRawCache f64710e;

    /* renamed from: f  reason: collision with root package name */
    public IDiskCache f64711f;

    /* renamed from: g  reason: collision with root package name */
    public ILog f64712g;

    /* renamed from: h  reason: collision with root package name */
    public CacheConfig f64713h;

    /* renamed from: com.bytedance.sdk.component.image.LoadConfig$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class ConfigBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IKeyGenerator f64714a;

        /* renamed from: b  reason: collision with root package name */
        public ExecutorService f64715b;

        /* renamed from: c  reason: collision with root package name */
        public IHttpClient f64716c;

        /* renamed from: d  reason: collision with root package name */
        public IMemoryCache f64717d;

        /* renamed from: e  reason: collision with root package name */
        public IRawCache f64718e;

        /* renamed from: f  reason: collision with root package name */
        public IDiskCache f64719f;

        /* renamed from: g  reason: collision with root package name */
        public ILog f64720g;

        /* renamed from: h  reason: collision with root package name */
        public CacheConfig f64721h;

        public ConfigBuilder() {
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

        public LoadConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LoadConfig(this, null) : (LoadConfig) invokeV.objValue;
        }

        public ConfigBuilder cacheConfig(CacheConfig cacheConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheConfig)) == null) {
                this.f64721h = cacheConfig;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder diskCache(IDiskCache iDiskCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iDiskCache)) == null) {
                this.f64719f = iDiskCache;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder httpClient(IHttpClient iHttpClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iHttpClient)) == null) {
                this.f64716c = iHttpClient;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder keyGenerator(IKeyGenerator iKeyGenerator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iKeyGenerator)) == null) {
                this.f64714a = iKeyGenerator;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder log(ILog iLog) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iLog)) == null) {
                this.f64720g = iLog;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder memoryCache(IMemoryCache iMemoryCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iMemoryCache)) == null) {
                this.f64717d = iMemoryCache;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder rawCache(IRawCache iRawCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iRawCache)) == null) {
                this.f64718e = iRawCache;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder threadPool(ExecutorService executorService) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, executorService)) == null) {
                this.f64715b = executorService;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }
    }

    public /* synthetic */ LoadConfig(ConfigBuilder configBuilder, AnonymousClass1 anonymousClass1) {
        this(configBuilder);
    }

    public static LoadConfig getDefaultConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new ConfigBuilder().build() : (LoadConfig) invokeL.objValue;
    }

    public CacheConfig getCacheConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64713h : (CacheConfig) invokeV.objValue;
    }

    public IDiskCache getDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64711f : (IDiskCache) invokeV.objValue;
    }

    public IHttpClient getHttpClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64708c : (IHttpClient) invokeV.objValue;
    }

    public IKeyGenerator getKeyGenerator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64706a : (IKeyGenerator) invokeV.objValue;
    }

    public ILog getLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64712g : (ILog) invokeV.objValue;
    }

    public IMemoryCache getMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64709d : (IMemoryCache) invokeV.objValue;
    }

    public IRawCache getRawCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64710e : (IRawCache) invokeV.objValue;
    }

    public ExecutorService getThreadPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64707b : (ExecutorService) invokeV.objValue;
    }

    public LoadConfig(ConfigBuilder configBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {configBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64706a = configBuilder.f64714a;
        this.f64707b = configBuilder.f64715b;
        this.f64708c = configBuilder.f64716c;
        this.f64709d = configBuilder.f64717d;
        this.f64710e = configBuilder.f64718e;
        this.f64711f = configBuilder.f64719f;
        this.f64713h = configBuilder.f64721h;
        this.f64712g = configBuilder.f64720g;
    }
}

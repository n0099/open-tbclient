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
    public IKeyGenerator f64906a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f64907b;

    /* renamed from: c  reason: collision with root package name */
    public IHttpClient f64908c;

    /* renamed from: d  reason: collision with root package name */
    public IMemoryCache f64909d;

    /* renamed from: e  reason: collision with root package name */
    public IRawCache f64910e;

    /* renamed from: f  reason: collision with root package name */
    public IDiskCache f64911f;

    /* renamed from: g  reason: collision with root package name */
    public ILog f64912g;

    /* renamed from: h  reason: collision with root package name */
    public CacheConfig f64913h;

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
        public IKeyGenerator f64914a;

        /* renamed from: b  reason: collision with root package name */
        public ExecutorService f64915b;

        /* renamed from: c  reason: collision with root package name */
        public IHttpClient f64916c;

        /* renamed from: d  reason: collision with root package name */
        public IMemoryCache f64917d;

        /* renamed from: e  reason: collision with root package name */
        public IRawCache f64918e;

        /* renamed from: f  reason: collision with root package name */
        public IDiskCache f64919f;

        /* renamed from: g  reason: collision with root package name */
        public ILog f64920g;

        /* renamed from: h  reason: collision with root package name */
        public CacheConfig f64921h;

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
                this.f64921h = cacheConfig;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder diskCache(IDiskCache iDiskCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iDiskCache)) == null) {
                this.f64919f = iDiskCache;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder httpClient(IHttpClient iHttpClient) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iHttpClient)) == null) {
                this.f64916c = iHttpClient;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder keyGenerator(IKeyGenerator iKeyGenerator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iKeyGenerator)) == null) {
                this.f64914a = iKeyGenerator;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder log(ILog iLog) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iLog)) == null) {
                this.f64920g = iLog;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder memoryCache(IMemoryCache iMemoryCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iMemoryCache)) == null) {
                this.f64917d = iMemoryCache;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder rawCache(IRawCache iRawCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iRawCache)) == null) {
                this.f64918e = iRawCache;
                return this;
            }
            return (ConfigBuilder) invokeL.objValue;
        }

        public ConfigBuilder threadPool(ExecutorService executorService) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, executorService)) == null) {
                this.f64915b = executorService;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64913h : (CacheConfig) invokeV.objValue;
    }

    public IDiskCache getDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64911f : (IDiskCache) invokeV.objValue;
    }

    public IHttpClient getHttpClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64908c : (IHttpClient) invokeV.objValue;
    }

    public IKeyGenerator getKeyGenerator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64906a : (IKeyGenerator) invokeV.objValue;
    }

    public ILog getLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f64912g : (ILog) invokeV.objValue;
    }

    public IMemoryCache getMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64909d : (IMemoryCache) invokeV.objValue;
    }

    public IRawCache getRawCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64910e : (IRawCache) invokeV.objValue;
    }

    public ExecutorService getThreadPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64907b : (ExecutorService) invokeV.objValue;
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
        this.f64906a = configBuilder.f64914a;
        this.f64907b = configBuilder.f64915b;
        this.f64908c = configBuilder.f64916c;
        this.f64909d = configBuilder.f64917d;
        this.f64910e = configBuilder.f64918e;
        this.f64911f = configBuilder.f64919f;
        this.f64913h = configBuilder.f64921h;
        this.f64912g = configBuilder.f64920g;
    }
}

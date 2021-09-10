package com.bytedance.sdk.component.image.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.CacheConfig;
import com.bytedance.sdk.component.image.IDiskCache;
import com.bytedance.sdk.component.image.IHttpClient;
import com.bytedance.sdk.component.image.IKeyGenerator;
import com.bytedance.sdk.component.image.IMemoryCache;
import com.bytedance.sdk.component.image.IRawCache;
import com.bytedance.sdk.component.image.LoadConfig;
import com.bytedance.sdk.component.image.c.a.b.e;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f65202a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<a>> f65203b;

    /* renamed from: c  reason: collision with root package name */
    public final LoadConfig f65204c;

    /* renamed from: d  reason: collision with root package name */
    public IMemoryCache f65205d;

    /* renamed from: e  reason: collision with root package name */
    public IRawCache f65206e;

    /* renamed from: f  reason: collision with root package name */
    public IDiskCache f65207f;

    /* renamed from: g  reason: collision with root package name */
    public IHttpClient f65208g;

    /* renamed from: h  reason: collision with root package name */
    public IKeyGenerator f65209h;

    /* renamed from: i  reason: collision with root package name */
    public ExecutorService f65210i;

    /* renamed from: j  reason: collision with root package name */
    public CacheConfig f65211j;

    public b(Context context, LoadConfig loadConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, loadConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65203b = new ConcurrentHashMap();
        this.f65204c = (LoadConfig) d.a(loadConfig);
        CacheConfig cacheConfig = loadConfig.getCacheConfig();
        this.f65211j = cacheConfig;
        if (cacheConfig == null) {
            this.f65211j = CacheConfig.getDefault(context);
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (b) d.a(f65202a, "ImageFactory was not initialized!") : (b) invokeV.objValue;
    }

    private IMemoryCache i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            IMemoryCache memoryCache = this.f65204c.getMemoryCache();
            if (memoryCache != null) {
                return com.bytedance.sdk.component.image.c.a.b.a.a(memoryCache);
            }
            return com.bytedance.sdk.component.image.c.a.b.a.a(this.f65211j.getMemoryCacheSize());
        }
        return (IMemoryCache) invokeV.objValue;
    }

    private IRawCache j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            IRawCache rawCache = this.f65204c.getRawCache();
            return rawCache != null ? rawCache : e.a(this.f65211j.getMemoryCacheSize());
        }
        return (IRawCache) invokeV.objValue;
    }

    private IDiskCache k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            IDiskCache diskCache = this.f65204c.getDiskCache();
            return diskCache != null ? diskCache : new com.bytedance.sdk.component.image.c.a.a.b(this.f65211j.getCacheDir(), this.f65211j.getFileCacheSize(), g());
        }
        return (IDiskCache) invokeV.objValue;
    }

    private IHttpClient l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            IHttpClient httpClient = this.f65204c.getHttpClient();
            return httpClient == null ? com.bytedance.sdk.component.image.b.b.a() : httpClient;
        }
        return (IHttpClient) invokeV.objValue;
    }

    private IKeyGenerator m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            IKeyGenerator keyGenerator = this.f65204c.getKeyGenerator();
            return keyGenerator != null ? keyGenerator : com.bytedance.sdk.component.image.a.b.a();
        }
        return (IKeyGenerator) invokeV.objValue;
    }

    private ExecutorService n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ExecutorService threadPool = this.f65204c.getThreadPool();
            return threadPool != null ? threadPool : com.bytedance.sdk.component.image.a.c.a();
        }
        return (ExecutorService) invokeV.objValue;
    }

    public IMemoryCache b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f65205d == null) {
                this.f65205d = i();
            }
            return this.f65205d;
        }
        return (IMemoryCache) invokeV.objValue;
    }

    public IRawCache c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f65206e == null) {
                this.f65206e = j();
            }
            return this.f65206e;
        }
        return (IRawCache) invokeV.objValue;
    }

    public IDiskCache d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f65207f == null) {
                this.f65207f = k();
            }
            return this.f65207f;
        }
        return (IDiskCache) invokeV.objValue;
    }

    public IHttpClient e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f65208g == null) {
                this.f65208g = l();
            }
            return this.f65208g;
        }
        return (IHttpClient) invokeV.objValue;
    }

    public IKeyGenerator f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f65209h == null) {
                this.f65209h = m();
            }
            return this.f65209h;
        }
        return (IKeyGenerator) invokeV.objValue;
    }

    public ExecutorService g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f65210i == null) {
                this.f65210i = n();
            }
            return this.f65210i;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public Map<String, List<a>> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f65203b : (Map) invokeV.objValue;
    }

    public static synchronized void a(Context context, LoadConfig loadConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, loadConfig) == null) {
            synchronized (b.class) {
                f65202a = new b(context, loadConfig);
                c.a(loadConfig.getLog());
            }
        }
    }

    public com.bytedance.sdk.component.image.c.b.a a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            ImageView.ScaleType f2 = aVar.f();
            if (f2 == null) {
                f2 = com.bytedance.sdk.component.image.c.b.a.f65212a;
            }
            Bitmap.Config g2 = aVar.g();
            if (g2 == null) {
                g2 = com.bytedance.sdk.component.image.c.b.a.f65213b;
            }
            return new com.bytedance.sdk.component.image.c.b.a(aVar.h(), aVar.i(), f2, g2);
        }
        return (com.bytedance.sdk.component.image.c.b.a) invokeL.objValue;
    }
}

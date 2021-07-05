package com.bytedance.sdk.component.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.video.a.a.b;
import com.bytedance.sdk.component.video.d.c;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
@RequiresApi(api = 23)
/* loaded from: classes6.dex */
public class a extends MediaDataSource {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f28807a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.component.video.a.a.a f28808b;

    /* renamed from: c  reason: collision with root package name */
    public long f28809c;

    /* renamed from: d  reason: collision with root package name */
    public Context f28810d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.component.video.b.a f28811e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2068815615, "Lcom/bytedance/sdk/component/video/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2068815615, "Lcom/bytedance/sdk/component/video/a/a;");
                return;
            }
        }
        f28807a = new ConcurrentHashMap<>();
    }

    public a(Context context, com.bytedance.sdk.component.video.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28808b = null;
        this.f28809c = -2147483648L;
        this.f28810d = context;
        this.f28811e = aVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f28808b == null) {
            this.f28808b = new b(this.f28810d, this.f28811e);
        }
    }

    public com.bytedance.sdk.component.video.b.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28811e : (com.bytedance.sdk.component.video.b.a) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.b("SdkMediaDataSource", "close: ", this.f28811e.b());
            com.bytedance.sdk.component.video.a.a.a aVar = this.f28808b;
            if (aVar != null) {
                aVar.a();
            }
            f28807a.remove(this.f28811e.c());
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b();
            if (this.f28809c == -2147483648L) {
                if (this.f28810d == null || TextUtils.isEmpty(this.f28811e.b())) {
                    return -1L;
                }
                this.f28809c = this.f28808b.b();
                c.a("SdkMediaDataSource", "getSize: " + this.f28809c);
            }
            return this.f28809c;
        }
        return invokeV.longValue;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            b();
            int a2 = this.f28808b.a(j, bArr, i2, i3);
            c.a("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i2 + " size =" + a2 + "  current = " + Thread.currentThread());
            return a2;
        }
        return invokeCommon.intValue;
    }

    public static a a(Context context, com.bytedance.sdk.component.video.b.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, aVar)) == null) {
            a aVar2 = new a(context, aVar);
            f28807a.put(aVar.c(), aVar2);
            return aVar2;
        }
        return (a) invokeLL.objValue;
    }
}

package com.bytedance.sdk.component.d.c.a.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.c.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public class b implements com.bytedance.sdk.component.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f28747a;

    /* renamed from: b  reason: collision with root package name */
    public a f28748b;

    public b(File file, long j, ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Long.valueOf(j), executorService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28747a = j;
        try {
            this.f28748b = a.a(file, 20210302, 1, j, executorService);
        } catch (IOException e2) {
            com.bytedance.sdk.component.d.c.c.a("LruCountDiskCache", e2.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.d.c.a.a
    public boolean a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr)) != null) {
            return invokeLL.booleanValue;
        }
        a aVar = this.f28748b;
        if (aVar == null || bArr == null || str == null) {
            return false;
        }
        a.C0322a c0322a = null;
        Closeable closeable2 = null;
        try {
            try {
                a.C0322a b2 = aVar.b(str);
                try {
                    if (b2 == null) {
                        com.bytedance.sdk.component.d.c.c.a("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.d.c.c.a.a(null);
                        return false;
                    }
                    OutputStream a2 = b2.a(0);
                    if (a2 == a.f28721c) {
                        com.bytedance.sdk.component.d.c.c.a("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.d.c.c.a.a(a2);
                        return false;
                    }
                    a2.write(bArr);
                    b2.a();
                    this.f28748b.a();
                    com.bytedance.sdk.component.d.c.c.a.a(a2);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    closeable = null;
                    c0322a = b2;
                    try {
                        com.bytedance.sdk.component.d.c.c.a("LruCountDiskCache", e.toString());
                        if (c0322a != null) {
                            try {
                                c0322a.b();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.d.c.c.a.a(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        com.bytedance.sdk.component.d.c.c.a.a(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.d.c.c.a.a(closeable2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            closeable = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.d.c.a.a
    @Nullable
    public byte[] a(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        a aVar = this.f28748b;
        InputStream inputStream2 = null;
        if (aVar == null || str == null) {
            return null;
        }
        try {
            a.c a2 = aVar.a(str);
            if (a2 == null) {
                com.bytedance.sdk.component.d.c.c.a.a(null);
                com.bytedance.sdk.component.d.c.c.a.a(null);
                return null;
            }
            inputStream = a2.a(0);
            if (inputStream != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        } catch (IOException e2) {
                            e = e2;
                            com.bytedance.sdk.component.d.c.c.b("LruCountDiskCache", e.toString());
                            com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                            com.bytedance.sdk.component.d.c.c.a.a(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        com.bytedance.sdk.component.d.c.c.a.a(inputStream2);
                        com.bytedance.sdk.component.d.c.c.a.a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                    com.bytedance.sdk.component.d.c.c.b("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                    com.bytedance.sdk.component.d.c.c.a.a(byteArrayOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    com.bytedance.sdk.component.d.c.c.a.a(inputStream2);
                    com.bytedance.sdk.component.d.c.c.a.a(byteArrayOutputStream);
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.d.c.c.a.a(inputStream);
            com.bytedance.sdk.component.d.c.c.a.a(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e4) {
            e = e4;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.d.c.c.a.a(inputStream2);
            com.bytedance.sdk.component.d.c.c.a.a(byteArrayOutputStream);
            throw th;
        }
    }
}

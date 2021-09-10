package com.bytedance.sdk.component.image.c.a.a;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IDiskCache;
import com.bytedance.sdk.component.image.c.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes9.dex */
public class b implements IDiskCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f65168a;

    /* renamed from: b  reason: collision with root package name */
    public a f65169b;

    public b(File file, long j2, ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Long.valueOf(j2), executorService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65168a = j2;
        try {
            this.f65169b = a.a(file, 20210302, 1, j2, executorService);
        } catch (IOException e2) {
            com.bytedance.sdk.component.image.c.c.a("LruCountDiskCache", e2.toString());
        }
    }

    @Override // com.bytedance.sdk.component.image.IDiskCache
    public InputStream getCacheStream(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            a aVar = this.f65169b;
            if (aVar == null) {
                return null;
            }
            try {
                a.c a2 = aVar.a(str);
                if (a2 != null) {
                    return a2.a(0);
                }
            } catch (IOException e2) {
                com.bytedance.sdk.component.image.c.c.a("LruCountDiskCache", e2.getMessage());
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.image.IDiskCache
    public boolean remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                return this.f65169b.c(str);
            } catch (IOException e2) {
                com.bytedance.sdk.component.image.c.c.a("LruCountDiskCache", e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.component.image.IDiskCache
    public boolean removeForce(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                this.f65169b.c(str);
                return false;
            } catch (IOException e2) {
                com.bytedance.sdk.component.image.c.c.a("LruCountDiskCache", e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    public boolean a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048579, this, str, bArr)) != null) {
            return invokeLL.booleanValue;
        }
        a aVar = this.f65169b;
        if (aVar == null || bArr == null || str == null) {
            return false;
        }
        a.C1889a c1889a = null;
        Closeable closeable2 = null;
        try {
            try {
                a.C1889a b2 = aVar.b(str);
                try {
                    if (b2 == null) {
                        com.bytedance.sdk.component.image.c.c.a("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.image.c.c.a.a(null);
                        return false;
                    }
                    OutputStream a2 = b2.a(0);
                    if (a2 == a.f65141c) {
                        com.bytedance.sdk.component.image.c.c.a("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.image.c.c.a.a(a2);
                        return false;
                    }
                    a2.write(bArr);
                    b2.a();
                    this.f65169b.a();
                    com.bytedance.sdk.component.image.c.c.a.a(a2);
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    closeable = null;
                    c1889a = b2;
                    try {
                        com.bytedance.sdk.component.image.c.c.a("LruCountDiskCache", e.toString());
                        if (c1889a != null) {
                            try {
                                c1889a.b();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.image.c.c.a.a(closeable);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        com.bytedance.sdk.component.image.c.c.a.a(closeable2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.image.c.c.a.a(closeable2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            closeable = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.component.image.c.a.a
    @Nullable
    public byte[] a(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        a aVar = this.f65169b;
        InputStream inputStream2 = null;
        if (aVar == null || str == null) {
            return null;
        }
        try {
            a.c a2 = aVar.a(str);
            if (a2 == null) {
                com.bytedance.sdk.component.image.c.c.a.a(null);
                com.bytedance.sdk.component.image.c.c.a.a(null);
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
                            com.bytedance.sdk.component.image.c.c.b("LruCountDiskCache", e.toString());
                            com.bytedance.sdk.component.image.c.c.a.a(inputStream);
                            com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        com.bytedance.sdk.component.image.c.c.a.a(inputStream2);
                        com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                    com.bytedance.sdk.component.image.c.c.b("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.image.c.c.a.a(inputStream);
                    com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    inputStream2 = inputStream;
                    com.bytedance.sdk.component.image.c.c.a.a(inputStream2);
                    com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.image.c.c.a.a(inputStream);
            com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e4) {
            e = e4;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.image.c.c.a.a(inputStream2);
            com.bytedance.sdk.component.image.c.c.a.a(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.image.c.a.a
    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f65169b.a((long) (this.f65168a * d2));
        }
    }
}

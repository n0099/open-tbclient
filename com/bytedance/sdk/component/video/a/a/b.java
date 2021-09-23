package com.bytedance.sdk.component.video.a.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.e;
import com.bytedance.sdk.component.b.b.f;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.video.d.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f65578a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f65579b;

    /* renamed from: c  reason: collision with root package name */
    public File f65580c;

    /* renamed from: d  reason: collision with root package name */
    public File f65581d;

    /* renamed from: e  reason: collision with root package name */
    public long f65582e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f65583f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f65584g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f65585h;

    /* renamed from: i  reason: collision with root package name */
    public RandomAccessFile f65586i;

    /* renamed from: j  reason: collision with root package name */
    public final com.bytedance.sdk.component.video.b.a f65587j;

    public b(Context context, com.bytedance.sdk.component.video.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65578a = -2147483648L;
        this.f65579b = new Object();
        this.f65582e = 0L;
        this.f65583f = -1L;
        this.f65584g = false;
        this.f65585h = false;
        this.f65586i = null;
        this.f65587j = aVar;
        try {
            this.f65580c = com.bytedance.sdk.component.video.d.b.b(aVar.d(), aVar.c());
            this.f65581d = com.bytedance.sdk.component.video.d.b.c(aVar.d(), aVar.c());
            if (d()) {
                this.f65586i = new RandomAccessFile(this.f65581d, r.f42342a);
            } else {
                this.f65586i = new RandomAccessFile(this.f65580c, "rw");
            }
            if (d()) {
                return;
            }
            this.f65582e = this.f65580c.length();
            c();
        } catch (Throwable unused) {
            c.b("VideoCacheImpl", "Error using file ", aVar.b(), " as disc cache");
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f65581d.exists() : invokeV.booleanValue;
    }

    private long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (d()) {
                return this.f65581d.length();
            }
            return this.f65580c.length();
        }
        return invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            synchronized (this.f65579b) {
                if (d()) {
                    c.b("VideoCacheImpl", "complete: isCompleted ", this.f65587j.b(), this.f65587j.c());
                } else if (this.f65580c.renameTo(this.f65581d)) {
                    if (this.f65586i != null) {
                        this.f65586i.close();
                    }
                    this.f65586i = new RandomAccessFile(this.f65581d, "rw");
                    c.b("VideoCacheImpl", "complete: rename ", this.f65587j.c(), this.f65587j.b());
                } else {
                    throw new IOException("Error renaming file " + this.f65580c + " to " + this.f65581d + " for completion!");
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.video.a.a.a
    public long b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d()) {
                this.f65578a = this.f65581d.length();
            } else {
                synchronized (this.f65579b) {
                    int i2 = 0;
                    do {
                        if (this.f65578a == -2147483648L) {
                            try {
                                c.a("VideoCacheImpl", "totalLength: wait");
                                i2 += 15;
                                this.f65579b.wait(5L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                                throw new IOException("total length InterruptException");
                            }
                        }
                    } while (i2 <= 20000);
                    return -1L;
                }
            }
            c.b("VideoCacheImpl", "totalLength= ", Long.valueOf(this.f65578a));
            return this.f65578a;
        }
        return invokeV.longValue;
    }

    public void c() {
        w.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w wVar = com.bytedance.sdk.component.video.a.b.a.f65590b;
            if (wVar != null) {
                aVar = wVar.y();
            } else {
                aVar = new w.a();
            }
            aVar.a(this.f65587j.g(), TimeUnit.MILLISECONDS).b(this.f65587j.h(), TimeUnit.MILLISECONDS).c(this.f65587j.i(), TimeUnit.MILLISECONDS);
            w a2 = aVar.a();
            c.b("VideoCacheImpl", "RANGE, bytes=", Long.valueOf(this.f65582e), " file hash=", this.f65587j.c());
            z.a aVar2 = new z.a();
            a2.a(aVar2.a("RANGE", "bytes=" + this.f65582e + "-").a(this.f65587j.b()).a().d()).a(new f(this) { // from class: com.bytedance.sdk.component.video.a.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65588a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65588a = this;
                }

                @Override // com.bytedance.sdk.component.b.b.f
                public void onFailure(e eVar, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, eVar, iOException) == null) {
                        this.f65588a.f65585h = false;
                        this.f65588a.f65578a = -1L;
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:127:0x015b A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:44:0x0131 A[Catch: all -> 0x01c1, TryCatch #1 {all -> 0x01c1, blocks: (B:10:0x001f, B:13:0x0029, B:32:0x0079, B:33:0x0085, B:35:0x00a0, B:37:0x00ab, B:42:0x00c0, B:44:0x0131, B:45:0x0137, B:53:0x015f, B:57:0x01a5, B:46:0x0138, B:47:0x0153, B:48:0x0154), top: B:116:0x001f }] */
                @Override // com.bytedance.sdk.component.b.b.f
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(e eVar, ab abVar) throws IOException {
                    ac acVar;
                    boolean z;
                    boolean z2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, abVar) != null) {
                        return;
                    }
                    if (abVar != null) {
                        InputStream inputStream = null;
                        try {
                            try {
                                this.f65588a.f65585h = abVar.d();
                                if (this.f65588a.f65585h) {
                                    acVar = abVar.h();
                                    try {
                                        if (this.f65588a.f65585h && acVar != null) {
                                            this.f65588a.f65578a = acVar.b() + this.f65588a.f65582e;
                                            inputStream = acVar.c();
                                        }
                                        if (inputStream != null) {
                                            byte[] bArr = new byte[8192];
                                            long j2 = this.f65588a.f65582e;
                                            long j3 = 0;
                                            long j4 = 0;
                                            int i2 = 0;
                                            while (true) {
                                                int read = inputStream.read(bArr, i2, 8192 - i2);
                                                z = true;
                                                if (read == -1) {
                                                    break;
                                                }
                                                i2 += read;
                                                j4 += read;
                                                if (j4 % 8192 != j3 && j4 != this.f65588a.f65578a - this.f65588a.f65582e) {
                                                    z2 = false;
                                                    c.b("VideoCacheImpl", "Write segment,execAppend =", Boolean.valueOf(z2), " offset=", Integer.valueOf(i2), " totalLength = ", Long.valueOf(this.f65588a.f65578a), " saveSize =", Long.valueOf(j4), " startSaved=", Long.valueOf(this.f65588a.f65582e), " fileHash=", this.f65588a.f65587j.c(), " url=", this.f65588a.f65587j.b());
                                                    if (!z2) {
                                                        synchronized (this.f65588a.f65579b) {
                                                            com.bytedance.sdk.component.video.d.b.a(this.f65588a.f65586i, bArr, Long.valueOf(j2).intValue(), i2, this.f65588a.f65587j.c());
                                                        }
                                                        j2 += i2;
                                                        i2 = 0;
                                                    }
                                                    j3 = 0;
                                                }
                                                z2 = true;
                                                c.b("VideoCacheImpl", "Write segment,execAppend =", Boolean.valueOf(z2), " offset=", Integer.valueOf(i2), " totalLength = ", Long.valueOf(this.f65588a.f65578a), " saveSize =", Long.valueOf(j4), " startSaved=", Long.valueOf(this.f65588a.f65582e), " fileHash=", this.f65588a.f65587j.c(), " url=", this.f65588a.f65587j.b());
                                                if (!z2) {
                                                }
                                                j3 = 0;
                                            }
                                            Object[] objArr = new Object[10];
                                            objArr[0] = "Write segment,Write over, startIndex =";
                                            objArr[1] = Long.valueOf(this.f65588a.f65582e);
                                            objArr[2] = " totalLength = ";
                                            objArr[3] = Long.valueOf(this.f65588a.f65578a);
                                            objArr[4] = " saveSize = ";
                                            objArr[5] = Long.valueOf(j4);
                                            objArr[6] = " writeEndSegment =";
                                            if (j4 != this.f65588a.f65578a - this.f65588a.f65582e) {
                                                z = false;
                                            }
                                            objArr[7] = Boolean.valueOf(z);
                                            objArr[8] = " url=";
                                            objArr[9] = this.f65588a.f65587j.b();
                                            c.b("VideoCacheImpl", objArr);
                                        } else {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                    return;
                                                }
                                            }
                                            if (acVar != null) {
                                                acVar.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            if (this.f65588a.f65585h && this.f65588a.f65580c.length() == this.f65588a.f65578a) {
                                                this.f65588a.f();
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            this.f65588a.f65585h = false;
                                            this.f65588a.f65578a = this.f65588a.f65583f;
                                            th.printStackTrace();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (acVar != null) {
                                                acVar.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            if (this.f65588a.f65585h && this.f65588a.f65580c.length() == this.f65588a.f65578a) {
                                                this.f65588a.f();
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th3) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable th4) {
                                                    th4.printStackTrace();
                                                    throw th3;
                                                }
                                            }
                                            if (acVar != null) {
                                                acVar.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            if (this.f65588a.f65585h && this.f65588a.f65580c.length() == this.f65588a.f65578a) {
                                                this.f65588a.f();
                                            }
                                            throw th3;
                                        }
                                    }
                                } else {
                                    this.f65588a.f65585h = false;
                                    this.f65588a.f65578a = this.f65588a.f65583f;
                                    acVar = null;
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (acVar != null) {
                                    acVar.close();
                                }
                                if (abVar != null) {
                                    abVar.close();
                                }
                                if (this.f65588a.f65585h && this.f65588a.f65580c.length() == this.f65588a.f65578a) {
                                    this.f65588a.f();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                acVar = null;
                            }
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    } else {
                        this.f65588a.f65585h = false;
                        b bVar = this.f65588a;
                        bVar.f65578a = bVar.f65583f;
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // com.bytedance.sdk.component.video.a.a.a
    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            try {
                if (j2 == this.f65578a) {
                    return -1;
                }
                int i4 = 0;
                int i5 = 0;
                while (!this.f65584g) {
                    synchronized (this.f65579b) {
                        long e2 = e();
                        if (j2 < e2) {
                            c.a("VideoCacheImpl", "read:  read " + j2 + " success");
                            this.f65586i.seek(j2);
                            i5 = this.f65586i.read(bArr, i2, i3);
                        } else {
                            c.b("VideoCacheImpl", "read: wait at ", Long.valueOf(j2), "  file size = ", Long.valueOf(e2));
                            i4 += 33;
                            this.f65579b.wait(33L);
                        }
                    }
                    if (i5 > 0) {
                        return i5;
                    }
                    if (i4 >= 20000) {
                        throw new SocketTimeoutException();
                    }
                }
                return -1;
            } catch (Throwable th) {
                if (th instanceof IOException) {
                    throw th;
                }
                throw new IOException();
            }
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.bytedance.sdk.component.video.a.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (!this.f65584g) {
                    this.f65586i.close();
                }
            } finally {
                this.f65584g = true;
            }
            this.f65584g = true;
        }
    }
}

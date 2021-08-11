package com.bytedance.sdk.component.video.a.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f64900a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.component.video.b.a f64901b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f64902c;

    /* renamed from: d  reason: collision with root package name */
    public File f64903d;

    /* renamed from: e  reason: collision with root package name */
    public File f64904e;

    /* renamed from: f  reason: collision with root package name */
    public final List<InterfaceC1887a> f64905f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f64906g;

    /* renamed from: com.bytedance.sdk.component.video.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1887a {
        void a(com.bytedance.sdk.component.video.b.a aVar, int i2);

        void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str);

        void b(com.bytedance.sdk.component.video.b.a aVar, int i2);
    }

    public a(Context context, com.bytedance.sdk.component.video.b.a aVar) {
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
        this.f64902c = false;
        this.f64903d = null;
        this.f64904e = null;
        this.f64905f = new ArrayList();
        this.f64906g = false;
        this.f64900a = context;
        this.f64901b = aVar;
        this.f64903d = com.bytedance.sdk.component.video.d.b.b(aVar.d(), aVar.c());
        this.f64904e = com.bytedance.sdk.component.video.d.b.c(aVar.d(), aVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                this.f64904e.delete();
                this.f64903d.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65548, this) != null) {
            return;
        }
        try {
            if (this.f64903d.renameTo(this.f64904e)) {
                return;
            }
            throw new IOException("Error renaming file " + this.f64903d + " to " + this.f64904e + " for completion!");
        } finally {
        }
    }

    private void b() {
        w.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            w wVar = com.bytedance.sdk.component.video.a.b.a.f64899b;
            if (wVar != null) {
                aVar = wVar.y();
            } else {
                aVar = new w.a();
            }
            aVar.a(this.f64901b.g(), TimeUnit.MILLISECONDS).b(this.f64901b.h(), TimeUnit.MILLISECONDS).c(this.f64901b.i(), TimeUnit.MILLISECONDS);
            w a2 = aVar.a();
            z.a aVar2 = new z.a();
            long length = this.f64903d.length();
            if (this.f64901b.j()) {
                aVar2.a("RANGE", "bytes=" + length + "-").a(this.f64901b.b()).a().d();
            } else {
                aVar2.a("RANGE", "bytes=" + length + "-" + this.f64901b.e()).a(this.f64901b.b()).a().d();
            }
            a2.a(aVar2.d()).a(new f(this, length) { // from class: com.bytedance.sdk.component.video.a.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f64907a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f64908b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(length)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64908b = this;
                    this.f64907a = length;
                }

                @Override // com.bytedance.sdk.component.b.b.f
                public void onFailure(e eVar, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, eVar, iOException) == null) {
                        a aVar3 = this.f64908b;
                        aVar3.a(aVar3.f64901b, 601, iOException.getMessage());
                        com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:42:0x00f8, code lost:
                    r21.f64908b.b(r21.f64908b.f64901b, r23.c());
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x0107, code lost:
                    if (r15 == null) goto L62;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:44:0x0109, code lost:
                    r15.close();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x010d, code lost:
                    r0 = e;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:0x0110, code lost:
                    if (r14 == null) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:0x0112, code lost:
                    r14.close();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:49:0x0115, code lost:
                    if (r23 == null) goto L66;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x0117, code lost:
                    r23.close();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x011a, code lost:
                    com.bytedance.sdk.component.video.d.c.b("VideoPreload", "Pre finally ", r21.f64908b.f64901b.b(), " Preload size=", java.lang.Long.valueOf(r21.f64908b.f64901b.e()));
                 */
                /* JADX WARN: Removed duplicated region for block: B:106:0x023f A[Catch: IOException -> 0x023b, TryCatch #10 {IOException -> 0x023b, blocks: (B:102:0x0237, B:106:0x023f, B:108:0x0244, B:109:0x0247), top: B:148:0x0237 }] */
                /* JADX WARN: Removed duplicated region for block: B:108:0x0244 A[Catch: IOException -> 0x023b, TryCatch #10 {IOException -> 0x023b, blocks: (B:102:0x0237, B:106:0x023f, B:108:0x0244, B:109:0x0247), top: B:148:0x0237 }] */
                /* JADX WARN: Removed duplicated region for block: B:148:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:153:0x0179 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:62:0x0161 A[Catch: all -> 0x01ad, TryCatch #9 {all -> 0x01ad, blocks: (B:26:0x0088, B:37:0x00d3, B:38:0x00e7, B:40:0x00f0, B:42:0x00f8, B:54:0x014b, B:56:0x0153, B:62:0x0161, B:64:0x017d, B:66:0x0189, B:68:0x0197, B:69:0x019c), top: B:147:0x0086 }] */
                /* JADX WARN: Removed duplicated region for block: B:99:0x022a A[Catch: all -> 0x0272, TryCatch #2 {all -> 0x0272, blocks: (B:97:0x0218, B:99:0x022a, B:100:0x022e), top: B:134:0x0218 }] */
                @Override // com.bytedance.sdk.component.b.b.f
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(e eVar, ab abVar) throws IOException {
                    int i2;
                    ac acVar;
                    InputStream inputStream;
                    InputStream inputStream2;
                    ac acVar2;
                    long j2;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, abVar) == null) {
                        long j3 = this.f64907a;
                        try {
                            if (abVar != null) {
                                boolean d2 = abVar.d();
                                if (!d2) {
                                    this.f64908b.a(this.f64908b.f64901b, abVar.c(), abVar.e());
                                    if (abVar != null) {
                                        try {
                                            abVar.close();
                                        } catch (IOException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                            return;
                                        }
                                    }
                                    c.b("VideoPreload", "Pre finally ", this.f64908b.f64901b.b(), " Preload size=", Long.valueOf(this.f64908b.f64901b.e()));
                                } else {
                                    abVar.h();
                                    try {
                                        acVar2 = abVar.h();
                                        if (!d2 || acVar2 == null) {
                                            j2 = 0;
                                            inputStream = null;
                                        } else {
                                            j2 = this.f64907a + acVar2.b();
                                            inputStream = acVar2.c();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        acVar = acVar2;
                                        i2 = 601;
                                        inputStream = null;
                                        try {
                                            th.printStackTrace();
                                            this.f64908b.c();
                                            a aVar3 = this.f64908b;
                                            com.bytedance.sdk.component.video.b.a aVar4 = this.f64908b.f64901b;
                                            if (abVar != null) {
                                            }
                                            aVar3.a(aVar4, i2, th.getMessage());
                                            if (inputStream != null) {
                                            }
                                            if (acVar != null) {
                                            }
                                            if (abVar != null) {
                                            }
                                            c.b("VideoPreload", "Pre finally ", this.f64908b.f64901b.b(), " Preload size=", Long.valueOf(this.f64908b.f64901b.e()));
                                            com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                        } catch (Throwable th2) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                    com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                                    throw th2;
                                                }
                                            }
                                            if (acVar != null) {
                                                acVar.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            c.b("VideoPreload", "Pre finally ", this.f64908b.f64901b.b(), " Preload size=", Long.valueOf(this.f64908b.f64901b.e()));
                                            com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                            throw th2;
                                        }
                                    }
                                    try {
                                        if (inputStream == null) {
                                            this.f64908b.a(this.f64908b.f64901b, abVar.c(), abVar.e());
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e4) {
                                                    e = e4;
                                                    e.printStackTrace();
                                                    com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                                    return;
                                                }
                                            }
                                            if (acVar2 != null) {
                                                acVar2.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            c.b("VideoPreload", "Pre finally ", this.f64908b.f64901b.b(), " Preload size=", Long.valueOf(this.f64908b.f64901b.e()));
                                        } else {
                                            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f64908b.f64903d, "rw");
                                            byte[] bArr = new byte[8192];
                                            int i3 = 0;
                                            long j4 = 0;
                                            while (true) {
                                                int read = inputStream.read(bArr, i3, 8192 - i3);
                                                if (read != -1) {
                                                    if (this.f64908b.f64902c) {
                                                        break;
                                                    }
                                                    i3 += read;
                                                    j4 += read;
                                                    if (j4 % 8192 != 0 && j4 != j2 - this.f64907a) {
                                                        z = false;
                                                        if (!z) {
                                                            com.bytedance.sdk.component.video.d.b.a(randomAccessFile, bArr, Long.valueOf(j3).intValue(), i3, this.f64908b.f64901b.c());
                                                            j3 += i3;
                                                            i3 = 0;
                                                        }
                                                    }
                                                    z = true;
                                                    if (!z) {
                                                    }
                                                } else {
                                                    if (this.f64908b.f64901b.j() && j2 == this.f64908b.f64903d.length()) {
                                                        this.f64908b.d();
                                                    }
                                                    this.f64908b.a(this.f64908b.f64901b, abVar.c());
                                                    inputStream2 = inputStream;
                                                }
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        acVar = acVar2;
                                        i2 = 601;
                                        th.printStackTrace();
                                        this.f64908b.c();
                                        a aVar32 = this.f64908b;
                                        com.bytedance.sdk.component.video.b.a aVar42 = this.f64908b.f64901b;
                                        if (abVar != null) {
                                        }
                                        aVar32.a(aVar42, i2, th.getMessage());
                                        if (inputStream != null) {
                                        }
                                        if (acVar != null) {
                                        }
                                        if (abVar != null) {
                                        }
                                        c.b("VideoPreload", "Pre finally ", this.f64908b.f64901b.b(), " Preload size=", Long.valueOf(this.f64908b.f64901b.e()));
                                        com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                    }
                                }
                                com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                return;
                            }
                            i2 = 601;
                            try {
                                this.f64908b.a(this.f64908b.f64901b, 601, "Network link failed.");
                                inputStream2 = null;
                                acVar2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                acVar = null;
                                inputStream = null;
                                th.printStackTrace();
                                this.f64908b.c();
                                a aVar322 = this.f64908b;
                                com.bytedance.sdk.component.video.b.a aVar422 = this.f64908b.f64901b;
                                if (abVar != null) {
                                    i2 = abVar.c();
                                }
                                aVar322.a(aVar422, i2, th.getMessage());
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5) {
                                        e = e5;
                                        e.printStackTrace();
                                        com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                    }
                                }
                                if (acVar != null) {
                                    acVar.close();
                                }
                                if (abVar != null) {
                                    abVar.close();
                                }
                                c.b("VideoPreload", "Pre finally ", this.f64908b.f64901b.b(), " Preload size=", Long.valueOf(this.f64908b.f64901b.e()));
                                com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e6) {
                                    e = e6;
                                    e.printStackTrace();
                                    com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                                }
                            }
                            if (acVar2 != null) {
                                acVar2.close();
                            }
                            if (abVar != null) {
                                abVar.close();
                            }
                            c.b("VideoPreload", "Pre finally ", this.f64908b.f64901b.b(), " Preload size=", Long.valueOf(this.f64908b.f64901b.e()));
                        } catch (Throwable th5) {
                            th = th5;
                            i2 = 601;
                        }
                        com.bytedance.sdk.component.video.a.b.a.a(this.f64908b.f64901b);
                    }
                }
            });
        }
    }

    public void a(InterfaceC1887a interfaceC1887a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1887a) == null) {
            if (this.f64906g) {
                synchronized (InterfaceC1887a.class) {
                    this.f64905f.add(interfaceC1887a);
                }
                return;
            }
            this.f64905f.add(interfaceC1887a);
            if (!this.f64904e.exists() && (this.f64901b.j() || this.f64903d.length() < this.f64901b.e())) {
                this.f64906g = true;
                this.f64901b.a(0);
                b();
                return;
            }
            c.a("VideoPreload", "Cache file is exist");
            this.f64901b.a(1);
            a(this.f64901b, 200);
            com.bytedance.sdk.component.video.a.b.a.a(this.f64901b);
        }
    }

    public com.bytedance.sdk.component.video.b.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64901b : (com.bytedance.sdk.component.video.b.a) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f64902c = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, i2) == null) {
            synchronized (InterfaceC1887a.class) {
                for (InterfaceC1887a interfaceC1887a : this.f64905f) {
                    if (interfaceC1887a != null) {
                        interfaceC1887a.a(aVar, i2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, this, aVar, i2, str) == null) {
            synchronized (InterfaceC1887a.class) {
                for (InterfaceC1887a interfaceC1887a : this.f64905f) {
                    if (interfaceC1887a != null) {
                        interfaceC1887a.a(aVar, i2, str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.bytedance.sdk.component.video.b.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, aVar, i2) == null) {
            synchronized (InterfaceC1887a.class) {
                for (InterfaceC1887a interfaceC1887a : this.f64905f) {
                    if (interfaceC1887a != null) {
                        interfaceC1887a.b(aVar, i2);
                    }
                }
            }
        }
    }
}

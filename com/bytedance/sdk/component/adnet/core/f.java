package com.bytedance.sdk.component.adnet.core;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.face.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes9.dex */
public class f implements com.bytedance.sdk.component.adnet.face.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f63927a;

    /* renamed from: b  reason: collision with root package name */
    public long f63928b;

    /* renamed from: c  reason: collision with root package name */
    public final File f63929c;

    /* renamed from: d  reason: collision with root package name */
    public final int f63930d;

    public f(File file, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63927a = new LinkedHashMap(16, 0.75f, true);
        this.f63928b = 0L;
        this.f63929c = file;
        this.f63930d = i2;
    }

    private String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            int length = str.length() / 2;
            String valueOf = String.valueOf(str.substring(0, length).hashCode());
            return valueOf + String.valueOf(str.substring(length).hashCode());
        }
        return (String) invokeL.objValue;
    }

    private void e(String str) {
        a remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, str) == null) || (remove = this.f63927a.remove(str)) == null) {
            return;
        }
        this.f63928b -= remove.f63931a;
    }

    @Override // com.bytedance.sdk.component.adnet.face.a
    public synchronized a.C1878a a(String str) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return (a.C1878a) invokeL.objValue;
        }
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVar = this.f63927a.get(str);
            if (aVar == null) {
                return null;
            }
            File c2 = c(str);
            try {
                bVar = new b(new BufferedInputStream(a(c2)), c2.length());
                try {
                    a a2 = a.a(bVar);
                    if (!TextUtils.equals(str, a2.f63932b)) {
                        o.b("%s: key=%s, found=%s", c2.getAbsolutePath(), str, a2.f63932b);
                        e(str);
                        bVar.close();
                        try {
                            bVar.close();
                        } catch (Throwable unused) {
                        }
                        return null;
                    }
                    a.C1878a a3 = aVar.a(a(bVar, bVar.a()));
                    bVar.close();
                    try {
                        bVar.close();
                    } catch (Throwable unused2) {
                    }
                    return a3;
                } catch (Throwable th) {
                    th = th;
                    o.b("%s: %s", c2.getAbsolutePath(), th.toString());
                    b(str);
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                bVar = null;
            }
        }
    }

    public synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                boolean delete = c(str).delete();
                e(str);
                if (!delete) {
                    o.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
                }
            }
        }
    }

    public File c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new File(this.f63929c, d(str)) : (File) invokeL.objValue;
    }

    @VisibleForTesting
    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f63931a;

        /* renamed from: b  reason: collision with root package name */
        public final String f63932b;

        /* renamed from: c  reason: collision with root package name */
        public final String f63933c;

        /* renamed from: d  reason: collision with root package name */
        public final long f63934d;

        /* renamed from: e  reason: collision with root package name */
        public final long f63935e;

        /* renamed from: f  reason: collision with root package name */
        public final long f63936f;

        /* renamed from: g  reason: collision with root package name */
        public final long f63937g;

        /* renamed from: h  reason: collision with root package name */
        public final List<Header> f63938h;

        public a(String str, String str2, long j2, long j3, long j4, long j5, List<Header> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f63932b = str;
            this.f63933c = "".equals(str2) ? null : str2;
            this.f63934d = j2;
            this.f63935e = j3;
            this.f63936f = j4;
            this.f63937g = j5;
            this.f63938h = list;
        }

        public static List<Header> a(a.C1878a c1878a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c1878a)) == null) {
                List<Header> list = c1878a.f64011i;
                return list != null ? list : com.bytedance.sdk.component.adnet.d.b.a(c1878a.f64010h);
            }
            return (List) invokeL.objValue;
        }

        public static a a(b bVar) throws Throwable {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
                if (f.a((InputStream) bVar) == 538247942) {
                    return new a(f.a(bVar), f.a(bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b(bVar));
                }
                throw new IOException();
            }
            return (a) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str, a.C1878a c1878a) {
            this(str, c1878a.f64005c, c1878a.f64006d, c1878a.f64007e, c1878a.f64008f, c1878a.f64009g, a(c1878a));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, c1878a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Long) objArr2[4]).longValue(), ((Long) objArr2[5]).longValue(), (List) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a.C1878a a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                a.C1878a c1878a = new a.C1878a();
                c1878a.f64004b = bArr;
                c1878a.f64005c = this.f63933c;
                c1878a.f64006d = this.f63934d;
                c1878a.f64007e = this.f63935e;
                c1878a.f64008f = this.f63936f;
                c1878a.f64009g = this.f63937g;
                c1878a.f64010h = com.bytedance.sdk.component.adnet.d.b.a(this.f63938h);
                c1878a.f64011i = Collections.unmodifiableList(this.f63938h);
                return c1878a;
            }
            return (a.C1878a) invokeL.objValue;
        }

        public boolean a(OutputStream outputStream) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream)) == null) {
                try {
                    f.a(outputStream, 538247942);
                    f.a(outputStream, this.f63932b);
                    f.a(outputStream, this.f63933c == null ? "" : this.f63933c);
                    f.a(outputStream, this.f63934d);
                    f.a(outputStream, this.f63935e);
                    f.a(outputStream, this.f63936f);
                    f.a(outputStream, this.f63937g);
                    f.a(this.f63938h, outputStream);
                    outputStream.flush();
                    return true;
                } catch (Throwable th) {
                    o.b(FormattableUtils.SIMPLEST_FORMAT, th.toString());
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes9.dex */
    public static class b extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f63939a;

        /* renamed from: b  reason: collision with root package name */
        public long f63940b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InputStream inputStream, long j2) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63939a = j2;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63939a - this.f63940b : invokeV.longValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int read = super.read();
                if (read != -1) {
                    this.f63940b++;
                }
                return read;
            }
            return invokeV.intValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
                int read = super.read(bArr, i2, i3);
                if (read != -1) {
                    this.f63940b += read;
                }
                return read;
            }
            return invokeLII.intValue;
        }
    }

    public static int c(InputStream inputStream) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, inputStream)) == null) {
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            throw new EOFException();
        }
        return invokeL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(File file) {
        this(file, 5242880);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((File) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.f63928b < this.f63930d) {
            return;
        }
        if (o.f63980a) {
            o.a("Pruning old cache entries.", new Object[0]);
        }
        long j2 = this.f63928b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f63927a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (c(value.f63932b).delete()) {
                this.f63928b -= value.f63931a;
            } else {
                String str = value.f63932b;
                o.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i2++;
            if (((float) this.f63928b) < this.f63930d * 0.9f) {
                break;
            }
        }
        if (o.f63980a) {
            o.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f63928b - j2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    @VisibleForTesting
    public OutputStream b(File file) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, file)) == null) ? new FileOutputStream(file) : (OutputStream) invokeL.objValue;
    }

    public static long b(InputStream inputStream) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, inputStream)) == null) ? ((c(inputStream) & 255) << 0) | 0 | ((c(inputStream) & 255) << 8) | ((c(inputStream) & 255) << 16) | ((c(inputStream) & 255) << 24) | ((c(inputStream) & 255) << 32) | ((c(inputStream) & 255) << 40) | ((c(inputStream) & 255) << 48) | ((255 & c(inputStream)) << 56) : invokeL.longValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.a
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!this.f63929c.exists()) {
                    if (!this.f63929c.mkdirs()) {
                        o.c("Unable to create cache dir %s", this.f63929c.getAbsolutePath());
                    }
                    return;
                }
                File[] listFiles = this.f63929c.listFiles();
                if (listFiles == null) {
                    return;
                }
                for (File file : listFiles) {
                    long length = file.length();
                    b bVar = new b(new BufferedInputStream(a(file)), length);
                    try {
                        a a2 = a.a(bVar);
                        a2.f63931a = length;
                        a(a2.f63932b, a2);
                    } catch (Throwable unused) {
                    }
                    bVar.close();
                }
            }
        }
    }

    public static List<Header> b(b bVar) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bVar)) == null) {
            int a2 = a((InputStream) bVar);
            if (a2 >= 0) {
                List<Header> emptyList = a2 == 0 ? Collections.emptyList() : new ArrayList<>();
                for (int i2 = 0; i2 < a2; i2++) {
                    emptyList.add(new Header(a(bVar).intern(), a(bVar).intern()));
                }
                return emptyList;
            }
            throw new IOException("readHeaderList size=" + a2);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.face.a
    public synchronized void a(String str, a.C1878a c1878a) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, str, c1878a) != null) {
            return;
        }
        synchronized (this) {
            if (this.f63928b + c1878a.f64004b.length > this.f63930d && c1878a.f64004b.length > this.f63930d * 0.9f) {
                return;
            }
            File c2 = c(str);
            BufferedOutputStream bufferedOutputStream = null;
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(b(c2));
                try {
                    a aVar = new a(str, c1878a);
                    if (aVar.a(bufferedOutputStream2)) {
                        bufferedOutputStream2.write(c1878a.f64004b);
                        aVar.f63931a = c2.length();
                        a(str, aVar);
                        b();
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused) {
                        }
                        return;
                    }
                    bufferedOutputStream2.close();
                    o.b("Failed to write header for %s", c2.getAbsolutePath());
                    throw new IOException();
                } catch (Throwable unused2) {
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (!c2.delete()) {
                        o.b("Could not clean up file %s", c2.getAbsolutePath());
                    }
                }
            } catch (Throwable unused4) {
            }
        }
    }

    private void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, aVar) == null) {
            if (!this.f63927a.containsKey(str)) {
                this.f63928b += aVar.f63931a;
            } else {
                this.f63928b += aVar.f63931a - this.f63927a.get(str).f63931a;
            }
            this.f63927a.put(str, aVar);
        }
    }

    @VisibleForTesting
    public static byte[] a(b bVar, long j2) throws Throwable {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65545, null, bVar, j2)) == null) {
            long a2 = bVar.a();
            if (j2 >= 0 && j2 <= a2) {
                int i2 = (int) j2;
                if (i2 == j2) {
                    byte[] bArr = new byte[i2];
                    new DataInputStream(bVar).readFully(bArr);
                    return bArr;
                }
            }
            throw new IOException("streamToBytes length=" + j2 + ", maxLength=" + a2);
        }
        return (byte[]) invokeLJ.objValue;
    }

    @VisibleForTesting
    public InputStream a(File file) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? new FileInputStream(file) : (InputStream) invokeL.objValue;
    }

    public static void a(OutputStream outputStream, int i2) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, outputStream, i2) == null) {
            outputStream.write((i2 >> 0) & 255);
            outputStream.write((i2 >> 8) & 255);
            outputStream.write((i2 >> 16) & 255);
            outputStream.write((i2 >> 24) & 255);
        }
    }

    public static int a(InputStream inputStream) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) ? (c(inputStream) << 24) | (c(inputStream) << 0) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16) : invokeL.intValue;
    }

    public static void a(OutputStream outputStream, long j2) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, outputStream, j2) == null) {
            outputStream.write((byte) (j2 >>> 0));
            outputStream.write((byte) (j2 >>> 8));
            outputStream.write((byte) (j2 >>> 16));
            outputStream.write((byte) (j2 >>> 24));
            outputStream.write((byte) (j2 >>> 32));
            outputStream.write((byte) (j2 >>> 40));
            outputStream.write((byte) (j2 >>> 48));
            outputStream.write((byte) (j2 >>> 56));
        }
    }

    public static void a(OutputStream outputStream, String str) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, outputStream, str) == null) {
            byte[] bytes = str.getBytes("UTF-8");
            a(outputStream, bytes.length);
            outputStream.write(bytes, 0, bytes.length);
        }
    }

    public static String a(b bVar) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? new String(a(bVar, b((InputStream) bVar)), "UTF-8") : (String) invokeL.objValue;
    }

    public static void a(List<Header> list, OutputStream outputStream) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, list, outputStream) == null) {
            if (list != null) {
                a(outputStream, list.size());
                for (Header header : list) {
                    a(outputStream, header.getName());
                    a(outputStream, header.getValue());
                }
                return;
            }
            a(outputStream, 0);
        }
    }
}

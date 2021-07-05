package com.bytedance.sdk.component.adnet.core;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
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
/* loaded from: classes6.dex */
public class f implements com.bytedance.sdk.component.adnet.face.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f27877a;

    /* renamed from: b  reason: collision with root package name */
    public long f27878b;

    /* renamed from: c  reason: collision with root package name */
    public final File f27879c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27880d;

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
        this.f27877a = new LinkedHashMap(16, 0.75f, true);
        this.f27878b = 0L;
        this.f27879c = file;
        this.f27880d = i2;
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
        if (!(interceptable == null || interceptable.invokeL(65551, this, str) == null) || (remove = this.f27877a.remove(str)) == null) {
            return;
        }
        this.f27878b -= remove.f27881a;
    }

    @Override // com.bytedance.sdk.component.adnet.face.a
    public synchronized a.C0316a a(String str) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return (a.C0316a) invokeL.objValue;
        }
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVar = this.f27877a.get(str);
            if (aVar == null) {
                return null;
            }
            File c2 = c(str);
            try {
                bVar = new b(new BufferedInputStream(a(c2)), c2.length());
                try {
                    a a2 = a.a(bVar);
                    if (!TextUtils.equals(str, a2.f27882b)) {
                        o.b("%s: key=%s, found=%s", c2.getAbsolutePath(), str, a2.f27882b);
                        e(str);
                        bVar.close();
                        try {
                            bVar.close();
                        } catch (Throwable unused) {
                        }
                        return null;
                    }
                    a.C0316a a3 = aVar.a(a(bVar, bVar.a()));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new File(this.f27879c, d(str)) : (File) invokeL.objValue;
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f27881a;

        /* renamed from: b  reason: collision with root package name */
        public final String f27882b;

        /* renamed from: c  reason: collision with root package name */
        public final String f27883c;

        /* renamed from: d  reason: collision with root package name */
        public final long f27884d;

        /* renamed from: e  reason: collision with root package name */
        public final long f27885e;

        /* renamed from: f  reason: collision with root package name */
        public final long f27886f;

        /* renamed from: g  reason: collision with root package name */
        public final long f27887g;

        /* renamed from: h  reason: collision with root package name */
        public final List<Header> f27888h;

        public a(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f27882b = str;
            this.f27883c = "".equals(str2) ? null : str2;
            this.f27884d = j;
            this.f27885e = j2;
            this.f27886f = j3;
            this.f27887g = j4;
            this.f27888h = list;
        }

        public static List<Header> a(a.C0316a c0316a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c0316a)) == null) {
                List<Header> list = c0316a.f27964i;
                return list != null ? list : com.bytedance.sdk.component.adnet.d.c.a(c0316a.f27963h);
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
        public a(String str, a.C0316a c0316a) {
            this(str, c0316a.f27958c, c0316a.f27959d, c0316a.f27960e, c0316a.f27961f, c0316a.f27962g, a(c0316a));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, c0316a};
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

        public a.C0316a a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                a.C0316a c0316a = new a.C0316a();
                c0316a.f27957b = bArr;
                c0316a.f27958c = this.f27883c;
                c0316a.f27959d = this.f27884d;
                c0316a.f27960e = this.f27885e;
                c0316a.f27961f = this.f27886f;
                c0316a.f27962g = this.f27887g;
                c0316a.f27963h = com.bytedance.sdk.component.adnet.d.c.a(this.f27888h);
                c0316a.f27964i = Collections.unmodifiableList(this.f27888h);
                return c0316a;
            }
            return (a.C0316a) invokeL.objValue;
        }

        public boolean a(OutputStream outputStream) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream)) == null) {
                try {
                    f.a(outputStream, 538247942);
                    f.a(outputStream, this.f27882b);
                    f.a(outputStream, this.f27883c == null ? "" : this.f27883c);
                    f.a(outputStream, this.f27884d);
                    f.a(outputStream, this.f27885e);
                    f.a(outputStream, this.f27886f);
                    f.a(outputStream, this.f27887g);
                    f.a(this.f27888h, outputStream);
                    outputStream.flush();
                    return true;
                } catch (Throwable th) {
                    o.b("%s", th.toString());
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class b extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f27889a;

        /* renamed from: b  reason: collision with root package name */
        public long f27890b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InputStream inputStream, long j) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, Long.valueOf(j)};
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
            this.f27889a = j;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27889a - this.f27890b : invokeV.longValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int read = super.read();
                if (read != -1) {
                    this.f27890b++;
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
                    this.f27890b += read;
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
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.f27878b < this.f27880d) {
            return;
        }
        if (o.f27929a) {
            o.a("Pruning old cache entries.", new Object[0]);
        }
        long j = this.f27878b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f27877a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (c(value.f27882b).delete()) {
                this.f27878b -= value.f27881a;
            } else {
                String str = value.f27882b;
                o.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i2++;
            if (((float) this.f27878b) < this.f27880d * 0.9f) {
                break;
            }
        }
        if (o.f27929a) {
            o.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f27878b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
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
                if (!this.f27879c.exists()) {
                    if (!this.f27879c.mkdirs()) {
                        o.c("Unable to create cache dir %s", this.f27879c.getAbsolutePath());
                    }
                    return;
                }
                File[] listFiles = this.f27879c.listFiles();
                if (listFiles == null) {
                    return;
                }
                for (File file : listFiles) {
                    long length = file.length();
                    b bVar = new b(new BufferedInputStream(a(file)), length);
                    try {
                        a a2 = a.a(bVar);
                        a2.f27881a = length;
                        a(a2.f27882b, a2);
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
    public synchronized void a(String str, a.C0316a c0316a) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, str, c0316a) != null) {
            return;
        }
        synchronized (this) {
            if (this.f27878b + c0316a.f27957b.length > this.f27880d && c0316a.f27957b.length > this.f27880d * 0.9f) {
                return;
            }
            File c2 = c(str);
            BufferedOutputStream bufferedOutputStream = null;
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(b(c2));
                try {
                    a aVar = new a(str, c0316a);
                    if (aVar.a(bufferedOutputStream2)) {
                        bufferedOutputStream2.write(c0316a.f27957b);
                        aVar.f27881a = c2.length();
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
            if (!this.f27877a.containsKey(str)) {
                this.f27878b += aVar.f27881a;
            } else {
                this.f27878b += aVar.f27881a - this.f27877a.get(str).f27881a;
            }
            this.f27877a.put(str, aVar);
        }
    }

    @VisibleForTesting
    public static byte[] a(b bVar, long j) throws Throwable {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65545, null, bVar, j)) == null) {
            long a2 = bVar.a();
            if (j >= 0 && j <= a2) {
                int i2 = (int) j;
                if (i2 == j) {
                    byte[] bArr = new byte[i2];
                    new DataInputStream(bVar).readFully(bArr);
                    return bArr;
                }
            }
            throw new IOException("streamToBytes length=" + j + ", maxLength=" + a2);
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
        if (interceptable == null || interceptable.invokeLI(65540, null, outputStream, i2) == null) {
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

    public static void a(OutputStream outputStream, long j) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, outputStream, j) == null) {
            outputStream.write((byte) (j >>> 0));
            outputStream.write((byte) (j >>> 8));
            outputStream.write((byte) (j >>> 16));
            outputStream.write((byte) (j >>> 24));
            outputStream.write((byte) (j >>> 32));
            outputStream.write((byte) (j >>> 40));
            outputStream.write((byte) (j >>> 48));
            outputStream.write((byte) (j >>> 56));
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

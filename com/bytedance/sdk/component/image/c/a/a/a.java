package com.bytedance.sdk.component.image.c.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes9.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f65451a;

    /* renamed from: c  reason: collision with root package name */
    public static final OutputStream f65452c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f65453b;

    /* renamed from: d  reason: collision with root package name */
    public final File f65454d;

    /* renamed from: e  reason: collision with root package name */
    public final File f65455e;

    /* renamed from: f  reason: collision with root package name */
    public final File f65456f;

    /* renamed from: g  reason: collision with root package name */
    public final File f65457g;

    /* renamed from: h  reason: collision with root package name */
    public final int f65458h;

    /* renamed from: i  reason: collision with root package name */
    public long f65459i;

    /* renamed from: j  reason: collision with root package name */
    public final int f65460j;
    public long k;
    public Writer l;
    public final LinkedHashMap<String, b> m;
    public int n;
    public long o;
    public long p;
    public final Callable<Void> q;

    /* renamed from: com.bytedance.sdk.component.image.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public final class C1893a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65462a;

        /* renamed from: b  reason: collision with root package name */
        public final b f65463b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f65464c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65465d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f65466e;

        /* renamed from: com.bytedance.sdk.component.image.c.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1894a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C1893a f65467a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f65467a.f65465d = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.flush();
                    } catch (IOException unused) {
                        this.f65467a.f65465d = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(i2);
                    } catch (IOException unused) {
                        this.f65467a.f65465d = true;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1894a(C1893a c1893a, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1893a, outputStream};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((OutputStream) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f65467a = c1893a;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    } catch (IOException unused) {
                        this.f65467a.f65465d = true;
                    }
                }
            }
        }

        public C1893a(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65462a = aVar;
            this.f65463b = bVar;
            this.f65464c = bVar.f65471d ? null : new boolean[aVar.f65460j];
        }

        public void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f65462a.a(this, false);
            }
        }

        public OutputStream a(int i2) throws IOException {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C1894a c1894a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f65462a.f65460j) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f65462a.f65460j);
                }
                synchronized (this.f65462a) {
                    if (this.f65463b.f65472e == this) {
                        if (!this.f65463b.f65471d) {
                            this.f65464c[i2] = true;
                        }
                        File b2 = this.f65463b.b(i2);
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused) {
                            this.f65462a.f65454d.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(b2);
                            } catch (FileNotFoundException unused2) {
                                return a.f65452c;
                            }
                        }
                        c1894a = new C1894a(fileOutputStream);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c1894a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f65465d) {
                    this.f65462a.a(this, false);
                    this.f65462a.c(this.f65463b.f65469b);
                } else {
                    this.f65462a.a(this, true);
                }
                this.f65466e = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65468a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65469b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f65470c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65471d;

        /* renamed from: e  reason: collision with root package name */
        public C1893a f65472e;

        /* renamed from: f  reason: collision with root package name */
        public long f65473f;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65468a = aVar;
            this.f65469b = str;
            this.f65470c = new long[aVar.f65460j];
        }

        private IOException b(String[] strArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        public File b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                File file = this.f65468a.f65454d;
                return new File(file, this.f65469b + "." + i2 + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public String a() throws IOException {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j2 : this.f65470c) {
                    sb.append(' ');
                    sb.append(j2);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, strArr) == null) {
                if (strArr.length == this.f65468a.f65460j) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        try {
                            this.f65470c[i2] = Long.parseLong(strArr[i2]);
                        } catch (NumberFormatException unused) {
                            throw b(strArr);
                        }
                    }
                    return;
                }
                throw b(strArr);
            }
        }

        public File a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                File file = this.f65468a.f65454d;
                return new File(file, this.f65469b + "." + i2);
            }
            return (File) invokeI.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class c implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65474a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65475b;

        /* renamed from: c  reason: collision with root package name */
        public final long f65476c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f65477d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f65478e;

        public InputStream a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f65477d[i2] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.f65477d) {
                    com.bytedance.sdk.component.image.c.c.a.a(inputStream);
                }
            }
        }

        public c(a aVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j2), inputStreamArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65474a = aVar;
            this.f65475b = str;
            this.f65476c = j2;
            this.f65477d = inputStreamArr;
            this.f65478e = jArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1668615237, "Lcom/bytedance/sdk/component/image/c/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1668615237, "Lcom/bytedance/sdk/component/image/c/a/a/a;");
                return;
            }
        }
        f65451a = Pattern.compile("[a-z0-9_-]{1,120}");
        f65452c = new OutputStream() { // from class: com.bytedance.sdk.component.image.c.a.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.io.OutputStream
            public void write(int i2) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                }
            }
        };
    }

    public a(File file, int i2, int i3, long j2, ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0L;
        this.m = new LinkedHashMap<>(0, 0.75f, true);
        this.o = -1L;
        this.p = 0L;
        this.q = new Callable<Void>(this) { // from class: com.bytedance.sdk.component.image.c.a.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65461a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65461a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (this.f65461a) {
                        if (this.f65461a.l == null) {
                            return null;
                        }
                        this.f65461a.h();
                        if (this.f65461a.f()) {
                            this.f65461a.e();
                            this.f65461a.n = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.f65454d = file;
        this.f65458h = i2;
        this.f65455e = new File(file, "journal");
        this.f65456f = new File(file, "journal.tmp");
        this.f65457g = new File(file, "journal.bkp");
        this.f65460j = i3;
        this.f65459i = j2;
        this.f65453b = executorService;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.l == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            long j2 = this.f65459i;
            long j3 = this.o;
            if (j3 >= 0) {
                j2 = j3;
            }
            while (this.k > j2) {
                c(this.m.entrySet().iterator().next().getKey());
            }
            this.o = -1L;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.l == null) {
                    return;
                }
                Iterator it = new ArrayList(this.m.values()).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.f65472e != null) {
                        bVar.f65472e.b();
                    }
                }
                h();
                this.l.close();
                this.l = null;
            }
        }
    }

    private void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65547, this) != null) {
            return;
        }
        com.bytedance.sdk.component.image.c.a.a.c cVar = new com.bytedance.sdk.component.image.c.a.a.c(new FileInputStream(this.f65455e), d.f65487a);
        try {
            String a2 = cVar.a();
            String a3 = cVar.a();
            String a4 = cVar.a();
            String a5 = cVar.a();
            String a6 = cVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f65458h).equals(a4) || !Integer.toString(this.f65460j).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i2 = 0;
            while (true) {
                try {
                    d(cVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.n = i2 - this.m.size();
                    if (cVar.b()) {
                        e();
                    } else {
                        this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f65455e, true), d.f65487a));
                    }
                    com.bytedance.sdk.component.image.c.c.a.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.image.c.c.a.a(cVar);
            throw th;
        }
    }

    private void d(String str) throws IOException {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int i2 = indexOf + 1;
                int indexOf2 = str.indexOf(32, i2);
                if (indexOf2 == -1) {
                    substring = str.substring(i2);
                    if (indexOf == 6 && str.startsWith("REMOVE")) {
                        this.m.remove(substring);
                        return;
                    }
                } else {
                    substring = str.substring(i2, indexOf2);
                }
                b bVar = this.m.get(substring);
                if (bVar == null) {
                    bVar = new b(substring);
                    this.m.put(substring, bVar);
                }
                if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                    String[] split = str.substring(indexOf2 + 1).split(" ");
                    bVar.f65471d = true;
                    bVar.f65472e = null;
                    bVar.a(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    bVar.f65472e = new C1893a(bVar);
                    return;
                } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                    return;
                } else {
                    throw new IOException("unexpected journal line: " + str);
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            synchronized (this) {
                if (this.l != null) {
                    this.l.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f65456f), d.f65487a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write("1");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f65458h));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f65460j));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(StringUtils.LF);
                for (b bVar : this.m.values()) {
                    if (bVar.f65472e != null) {
                        bufferedWriter.write("DIRTY " + bVar.f65469b + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + bVar.f65469b + bVar.a() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f65455e.exists()) {
                    a(this.f65455e, this.f65457g, true);
                }
                a(this.f65456f, this.f65455e, false);
                this.f65457g.delete();
                this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f65455e, true), d.f65487a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            int i2 = this.n;
            return i2 >= 2000 && i2 >= this.m.size();
        }
        return invokeV.booleanValue;
    }

    public C1893a b(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? a(str, -1L) : (C1893a) invokeL.objValue;
    }

    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close();
            d.a(this.f65454d);
        }
    }

    public static a a(File file, int i2, int i3, long j2, ExecutorService executorService) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), executorService})) == null) {
            if (j2 > 0) {
                if (i3 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            a(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i2, i3, j2, executorService);
                    if (aVar.f65455e.exists()) {
                        try {
                            aVar.c();
                            aVar.d();
                            return aVar;
                        } catch (IOException e2) {
                            com.bytedance.sdk.component.image.c.c.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.b();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j2, executorService);
                    aVar2.e();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (a) invokeCommon.objValue;
    }

    private void d() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            a(this.f65456f);
            Iterator<b> it = this.m.values().iterator();
            while (it.hasNext()) {
                b next = it.next();
                int i2 = 0;
                if (next.f65472e != null) {
                    next.f65472e = null;
                    while (i2 < this.f65460j) {
                        a(next.a(i2));
                        a(next.b(i2));
                        i2++;
                    }
                    it.remove();
                } else {
                    while (i2 < this.f65460j) {
                        this.k += next.f65470c[i2];
                        i2++;
                    }
                }
            }
        }
    }

    public synchronized boolean c(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                g();
                e(str);
                b bVar = this.m.get(str);
                if (bVar != null && bVar.f65472e == null) {
                    for (int i2 = 0; i2 < this.f65460j; i2++) {
                        File a2 = bVar.a(i2);
                        if (a2.exists() && !a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                        this.k -= bVar.f65470c[i2];
                        bVar.f65470c[i2] = 0;
                    }
                    this.n++;
                    this.l.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.m.remove(str);
                    if (f()) {
                        this.f65453b.submit(this.q);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void a(File file) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, null, file, file2, z) == null) {
            if (z) {
                a(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    private void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, str) == null) || f65451a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized c a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                g();
                e(str);
                b bVar = this.m.get(str);
                if (bVar == null) {
                    return null;
                }
                if (bVar.f65471d) {
                    InputStream[] inputStreamArr = new InputStream[this.f65460j];
                    for (int i2 = 0; i2 < this.f65460j; i2++) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                        } catch (FileNotFoundException unused) {
                            for (int i3 = 0; i3 < this.f65460j && inputStreamArr[i3] != null; i3++) {
                                com.bytedance.sdk.component.image.c.c.a.a(inputStreamArr[i3]);
                            }
                            return null;
                        }
                    }
                    this.n++;
                    this.l.append((CharSequence) ("READ " + str + '\n'));
                    if (f()) {
                        this.f65453b.submit(this.q);
                    }
                    return new c(str, bVar.f65473f, inputStreamArr, bVar.f65470c);
                }
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    private synchronized C1893a a(String str, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, str, j2)) == null) {
            synchronized (this) {
                g();
                e(str);
                b bVar = this.m.get(str);
                if (j2 == -1 || (bVar != null && bVar.f65473f == j2)) {
                    if (bVar != null) {
                        if (bVar.f65472e != null) {
                            return null;
                        }
                    } else {
                        bVar = new b(str);
                        this.m.put(str, bVar);
                    }
                    C1893a c1893a = new C1893a(bVar);
                    bVar.f65472e = c1893a;
                    Writer writer = this.l;
                    writer.write("DIRTY " + str + '\n');
                    this.l.flush();
                    return c1893a;
                }
                return null;
            }
        }
        return (C1893a) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C1893a c1893a, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, c1893a, z) == null) {
            synchronized (this) {
                b bVar = c1893a.f65463b;
                if (bVar.f65472e == c1893a) {
                    if (z && !bVar.f65471d) {
                        for (int i2 = 0; i2 < this.f65460j; i2++) {
                            if (c1893a.f65464c[i2]) {
                                if (!bVar.b(i2).exists()) {
                                    c1893a.b();
                                    return;
                                }
                            } else {
                                c1893a.b();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.f65460j; i3++) {
                        File b2 = bVar.b(i3);
                        if (z) {
                            if (b2.exists()) {
                                File a2 = bVar.a(i3);
                                b2.renameTo(a2);
                                long j2 = bVar.f65470c[i3];
                                long length = a2.length();
                                bVar.f65470c[i3] = length;
                                this.k = (this.k - j2) + length;
                            }
                        } else {
                            a(b2);
                        }
                    }
                    this.n++;
                    bVar.f65472e = null;
                    if (!(bVar.f65471d | z)) {
                        this.m.remove(bVar.f65469b);
                        this.l.write("REMOVE " + bVar.f65469b + '\n');
                    } else {
                        bVar.f65471d = true;
                        this.l.write("CLEAN " + bVar.f65469b + bVar.a() + '\n');
                        if (z) {
                            long j3 = this.p;
                            this.p = 1 + j3;
                            bVar.f65473f = j3;
                        }
                    }
                    this.l.flush();
                    if (this.k > this.f65459i || f()) {
                        this.f65453b.submit(this.q);
                    }
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public synchronized void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                g();
                h();
                this.l.flush();
            }
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.o = j2;
            this.f65453b.submit(this.q);
        }
    }
}

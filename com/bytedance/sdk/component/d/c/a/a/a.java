package com.bytedance.sdk.component.d.c.a.a;

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
/* loaded from: classes6.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f28610a;

    /* renamed from: c  reason: collision with root package name */
    public static final OutputStream f28611c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f28612b;

    /* renamed from: d  reason: collision with root package name */
    public final File f28613d;

    /* renamed from: e  reason: collision with root package name */
    public final File f28614e;

    /* renamed from: f  reason: collision with root package name */
    public final File f28615f;

    /* renamed from: g  reason: collision with root package name */
    public final File f28616g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28617h;

    /* renamed from: i  reason: collision with root package name */
    public long f28618i;
    public final int j;
    public long k;
    public Writer l;
    public final LinkedHashMap<String, b> m;
    public int n;
    public long o;
    public long p;
    public final Callable<Void> q;

    /* renamed from: com.bytedance.sdk.component.d.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C0322a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28620a;

        /* renamed from: b  reason: collision with root package name */
        public final b f28621b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f28622c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28623d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28624e;

        /* renamed from: com.bytedance.sdk.component.d.c.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0323a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0322a f28625a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f28625a.f28623d = true;
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
                        this.f28625a.f28623d = true;
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
                        this.f28625a.f28623d = true;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0323a(C0322a c0322a, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0322a, outputStream};
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
                this.f28625a = c0322a;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    } catch (IOException unused) {
                        this.f28625a.f28623d = true;
                    }
                }
            }
        }

        public C0322a(a aVar, b bVar) {
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
            this.f28620a = aVar;
            this.f28621b = bVar;
            this.f28622c = bVar.f28629d ? null : new boolean[aVar.j];
        }

        public void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f28620a.a(this, false);
            }
        }

        public OutputStream a(int i2) throws IOException {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C0323a c0323a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f28620a.j) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f28620a.j);
                }
                synchronized (this.f28620a) {
                    if (this.f28621b.f28630e == this) {
                        if (!this.f28621b.f28629d) {
                            this.f28622c[i2] = true;
                        }
                        File b2 = this.f28621b.b(i2);
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused) {
                            this.f28620a.f28613d.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(b2);
                            } catch (FileNotFoundException unused2) {
                                return a.f28611c;
                            }
                        }
                        c0323a = new C0323a(fileOutputStream);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c0323a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void a() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f28623d) {
                    this.f28620a.a(this, false);
                    this.f28620a.c(this.f28621b.f28627b);
                } else {
                    this.f28620a.a(this, true);
                }
                this.f28624e = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28626a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28627b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f28628c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28629d;

        /* renamed from: e  reason: collision with root package name */
        public C0322a f28630e;

        /* renamed from: f  reason: collision with root package name */
        public long f28631f;

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
            this.f28626a = aVar;
            this.f28627b = str;
            this.f28628c = new long[aVar.j];
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
                File file = this.f28626a.f28613d;
                return new File(file, this.f28627b + "." + i2 + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public String a() throws IOException {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.f28628c) {
                    sb.append(' ');
                    sb.append(j);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, strArr) == null) {
                if (strArr.length == this.f28626a.j) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        try {
                            this.f28628c[i2] = Long.parseLong(strArr[i2]);
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
                File file = this.f28626a.f28613d;
                return new File(file, this.f28627b + "." + i2);
            }
            return (File) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class c implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28632a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28633b;

        /* renamed from: c  reason: collision with root package name */
        public final long f28634c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f28635d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f28636e;

        public InputStream a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f28635d[i2] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.f28635d) {
                    com.bytedance.sdk.component.d.c.c.a.a(inputStream);
                }
            }
        }

        public c(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j), inputStreamArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28632a = aVar;
            this.f28633b = str;
            this.f28634c = j;
            this.f28635d = inputStreamArr;
            this.f28636e = jArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(397394258, "Lcom/bytedance/sdk/component/d/c/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(397394258, "Lcom/bytedance/sdk/component/d/c/a/a/a;");
                return;
            }
        }
        f28610a = Pattern.compile("[a-z0-9_-]{1,120}");
        f28611c = new OutputStream() { // from class: com.bytedance.sdk.component.d.c.a.a.a.2
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

    public a(File file, int i2, int i3, long j, ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), executorService};
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
        this.q = new Callable<Void>(this) { // from class: com.bytedance.sdk.component.d.c.a.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f28619a;

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
                this.f28619a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (this.f28619a) {
                        if (this.f28619a.l == null) {
                            return null;
                        }
                        this.f28619a.h();
                        if (this.f28619a.f()) {
                            this.f28619a.e();
                            this.f28619a.n = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.f28613d = file;
        this.f28617h = i2;
        this.f28614e = new File(file, "journal");
        this.f28615f = new File(file, "journal.tmp");
        this.f28616g = new File(file, "journal.bkp");
        this.j = i3;
        this.f28618i = j;
        this.f28612b = executorService;
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
            long j = this.f28618i;
            long j2 = this.o;
            if (j2 >= 0) {
                j = j2;
            }
            while (this.k > j) {
                c(this.m.entrySet().iterator().next().getKey());
            }
            this.o = -1L;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.l == null) {
                    return;
                }
                Iterator it = new ArrayList(this.m.values()).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.f28630e != null) {
                        bVar.f28630e.b();
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
        com.bytedance.sdk.component.d.c.a.a.c cVar = new com.bytedance.sdk.component.d.c.a.a.c(new FileInputStream(this.f28614e), d.f28645a);
        try {
            String a2 = cVar.a();
            String a3 = cVar.a();
            String a4 = cVar.a();
            String a5 = cVar.a();
            String a6 = cVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f28617h).equals(a4) || !Integer.toString(this.j).equals(a5) || !"".equals(a6)) {
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
                        this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28614e, true), d.f28645a));
                    }
                    com.bytedance.sdk.component.d.c.c.a.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.d.c.c.a.a(cVar);
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
                    bVar.f28629d = true;
                    bVar.f28630e = null;
                    bVar.a(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    bVar.f28630e = new C0322a(bVar);
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
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28615f), d.f28645a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f28617h));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.j));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (b bVar : this.m.values()) {
                    if (bVar.f28630e != null) {
                        bufferedWriter.write("DIRTY " + bVar.f28627b + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + bVar.f28627b + bVar.a() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f28614e.exists()) {
                    a(this.f28614e, this.f28616g, true);
                }
                a(this.f28615f, this.f28614e, false);
                this.f28616g.delete();
                this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f28614e, true), d.f28645a));
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

    public C0322a b(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? a(str, -1L) : (C0322a) invokeL.objValue;
    }

    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            close();
            d.a(this.f28613d);
        }
    }

    public static a a(File file, int i2, int i3, long j, ExecutorService executorService) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), executorService})) == null) {
            if (j > 0) {
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
                    a aVar = new a(file, i2, i3, j, executorService);
                    if (aVar.f28614e.exists()) {
                        try {
                            aVar.c();
                            aVar.d();
                            return aVar;
                        } catch (IOException e2) {
                            com.bytedance.sdk.component.d.c.c.a("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.b();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j, executorService);
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
            a(this.f28615f);
            Iterator<b> it = this.m.values().iterator();
            while (it.hasNext()) {
                b next = it.next();
                int i2 = 0;
                if (next.f28630e != null) {
                    next.f28630e = null;
                    while (i2 < this.j) {
                        a(next.a(i2));
                        a(next.b(i2));
                        i2++;
                    }
                    it.remove();
                } else {
                    while (i2 < this.j) {
                        this.k += next.f28628c[i2];
                        i2++;
                    }
                }
            }
        }
    }

    public synchronized boolean c(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                g();
                e(str);
                b bVar = this.m.get(str);
                if (bVar != null && bVar.f28630e == null) {
                    for (int i2 = 0; i2 < this.j; i2++) {
                        File a2 = bVar.a(i2);
                        if (a2.exists() && !a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                        this.k -= bVar.f28628c[i2];
                        bVar.f28628c[i2] = 0;
                    }
                    this.n++;
                    this.l.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.m.remove(str);
                    if (f()) {
                        this.f28612b.submit(this.q);
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
        if (!(interceptable == null || interceptable.invokeL(65554, this, str) == null) || f28610a.matcher(str).matches()) {
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
                if (bVar.f28629d) {
                    InputStream[] inputStreamArr = new InputStream[this.j];
                    for (int i2 = 0; i2 < this.j; i2++) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                        } catch (FileNotFoundException unused) {
                            for (int i3 = 0; i3 < this.j && inputStreamArr[i3] != null; i3++) {
                                com.bytedance.sdk.component.d.c.c.a.a(inputStreamArr[i3]);
                            }
                            return null;
                        }
                    }
                    this.n++;
                    this.l.append((CharSequence) ("READ " + str + '\n'));
                    if (f()) {
                        this.f28612b.submit(this.q);
                    }
                    return new c(str, bVar.f28631f, inputStreamArr, bVar.f28628c);
                }
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    private synchronized C0322a a(String str, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, str, j)) == null) {
            synchronized (this) {
                g();
                e(str);
                b bVar = this.m.get(str);
                if (j == -1 || (bVar != null && bVar.f28631f == j)) {
                    if (bVar != null) {
                        if (bVar.f28630e != null) {
                            return null;
                        }
                    } else {
                        bVar = new b(str);
                        this.m.put(str, bVar);
                    }
                    C0322a c0322a = new C0322a(bVar);
                    bVar.f28630e = c0322a;
                    Writer writer = this.l;
                    writer.write("DIRTY " + str + '\n');
                    this.l.flush();
                    return c0322a;
                }
                return null;
            }
        }
        return (C0322a) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0322a c0322a, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, c0322a, z) == null) {
            synchronized (this) {
                b bVar = c0322a.f28621b;
                if (bVar.f28630e == c0322a) {
                    if (z && !bVar.f28629d) {
                        for (int i2 = 0; i2 < this.j; i2++) {
                            if (c0322a.f28622c[i2]) {
                                if (!bVar.b(i2).exists()) {
                                    c0322a.b();
                                    return;
                                }
                            } else {
                                c0322a.b();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.j; i3++) {
                        File b2 = bVar.b(i3);
                        if (z) {
                            if (b2.exists()) {
                                File a2 = bVar.a(i3);
                                b2.renameTo(a2);
                                long j = bVar.f28628c[i3];
                                long length = a2.length();
                                bVar.f28628c[i3] = length;
                                this.k = (this.k - j) + length;
                            }
                        } else {
                            a(b2);
                        }
                    }
                    this.n++;
                    bVar.f28630e = null;
                    if (!(bVar.f28629d | z)) {
                        this.m.remove(bVar.f28627b);
                        this.l.write("REMOVE " + bVar.f28627b + '\n');
                    } else {
                        bVar.f28629d = true;
                        this.l.write("CLEAN " + bVar.f28627b + bVar.a() + '\n');
                        if (z) {
                            long j2 = this.p;
                            this.p = 1 + j2;
                            bVar.f28631f = j2;
                        }
                    }
                    this.l.flush();
                    if (this.k > this.f28618i || f()) {
                        this.f28612b.submit(this.q);
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
}

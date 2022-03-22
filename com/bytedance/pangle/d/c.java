package com.bytedance.pangle.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.util.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileInputStream a;

    /* renamed from: b  reason: collision with root package name */
    public a f38042b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f38043c;

    /* renamed from: d  reason: collision with root package name */
    public C1917c[] f38044d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C1917c> f38045e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final short f38046b;

        /* renamed from: c  reason: collision with root package name */
        public final short f38047c;

        /* renamed from: d  reason: collision with root package name */
        public final int f38048d;

        /* renamed from: e  reason: collision with root package name */
        public final long f38049e;

        /* renamed from: f  reason: collision with root package name */
        public final long f38050f;

        /* renamed from: g  reason: collision with root package name */
        public final long f38051g;

        /* renamed from: h  reason: collision with root package name */
        public final int f38052h;
        public final short i;
        public final short j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        public /* synthetic */ a(FileChannel fileChannel, byte b2) {
            this(fileChannel);
        }

        public a(FileChannel fileChannel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileChannel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new byte[16];
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(this.a));
            byte[] bArr = this.a;
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b2 = bArr[4];
                c.a(b2, 2, "bad elf class: " + ((int) this.a[4]));
                byte b3 = this.a[5];
                c.a(b3, 2, "bad elf data encoding: " + ((int) this.a[5]));
                ByteBuffer allocate = ByteBuffer.allocate(this.a[4] == 1 ? 36 : 48);
                allocate.order(this.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                c.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.f38046b = allocate.getShort();
                this.f38047c = allocate.getShort();
                int i3 = allocate.getInt();
                this.f38048d = i3;
                c.a(i3, 1, "bad elf version: " + this.f38048d);
                byte b4 = this.a[4];
                if (b4 == 1) {
                    this.f38049e = allocate.getInt();
                    this.f38050f = allocate.getInt();
                    this.f38051g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f38049e = allocate.getLong();
                    this.f38050f = allocate.getLong();
                    this.f38051g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f38052h = allocate.getInt();
                this.i = allocate.getShort();
                this.j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.a[0]), Byte.valueOf(this.a[1]), Byte.valueOf(this.a[2]), Byte.valueOf(this.a[3])));
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38053b;

        /* renamed from: c  reason: collision with root package name */
        public final long f38054c;

        /* renamed from: d  reason: collision with root package name */
        public final long f38055d;

        /* renamed from: e  reason: collision with root package name */
        public final long f38056e;

        /* renamed from: f  reason: collision with root package name */
        public final long f38057f;

        /* renamed from: g  reason: collision with root package name */
        public final long f38058g;

        /* renamed from: h  reason: collision with root package name */
        public final long f38059h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i, byte b2) {
            this(byteBuffer, i);
        }

        public b(ByteBuffer byteBuffer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i == 1) {
                this.a = byteBuffer.getInt();
                this.f38054c = byteBuffer.getInt();
                this.f38055d = byteBuffer.getInt();
                this.f38056e = byteBuffer.getInt();
                this.f38057f = byteBuffer.getInt();
                this.f38058g = byteBuffer.getInt();
                this.f38053b = byteBuffer.getInt();
                this.f38059h = byteBuffer.getInt();
            } else if (i == 2) {
                this.a = byteBuffer.getInt();
                this.f38053b = byteBuffer.getInt();
                this.f38054c = byteBuffer.getLong();
                this.f38055d = byteBuffer.getLong();
                this.f38056e = byteBuffer.getLong();
                this.f38057f = byteBuffer.getLong();
                this.f38058g = byteBuffer.getLong();
                this.f38059h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1917c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38060b;

        /* renamed from: c  reason: collision with root package name */
        public final long f38061c;

        /* renamed from: d  reason: collision with root package name */
        public final long f38062d;

        /* renamed from: e  reason: collision with root package name */
        public final long f38063e;

        /* renamed from: f  reason: collision with root package name */
        public final long f38064f;

        /* renamed from: g  reason: collision with root package name */
        public final int f38065g;

        /* renamed from: h  reason: collision with root package name */
        public final int f38066h;
        public final long i;
        public final long j;
        public String k;

        public /* synthetic */ C1917c(ByteBuffer byteBuffer, int i, byte b2) {
            this(byteBuffer, i);
        }

        public C1917c(ByteBuffer byteBuffer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i == 1) {
                this.a = byteBuffer.getInt();
                this.f38060b = byteBuffer.getInt();
                this.f38061c = byteBuffer.getInt();
                this.f38062d = byteBuffer.getInt();
                this.f38063e = byteBuffer.getInt();
                this.f38064f = byteBuffer.getInt();
                this.f38065g = byteBuffer.getInt();
                this.f38066h = byteBuffer.getInt();
                this.i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else if (i == 2) {
                this.a = byteBuffer.getInt();
                this.f38060b = byteBuffer.getInt();
                this.f38061c = byteBuffer.getLong();
                this.f38062d = byteBuffer.getLong();
                this.f38063e = byteBuffer.getLong();
                this.f38064f = byteBuffer.getLong();
                this.f38065g = byteBuffer.getInt();
                this.f38066h = byteBuffer.getInt();
                this.i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.k = null;
        }
    }

    public c(File file) {
        C1917c[] c1917cArr;
        C1917c[] c1917cArr2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38042b = null;
        this.f38043c = null;
        this.f38044d = null;
        this.f38045e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f38042b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f38042b.j);
        allocate.order(this.f38042b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f38042b.f38050f);
        this.f38043c = new b[this.f38042b.k];
        for (int i3 = 0; i3 < this.f38043c.length; i3++) {
            b(channel, allocate, "failed to read phdr.");
            this.f38043c[i3] = new b(allocate, this.f38042b.a[4], (byte) 0);
        }
        channel.position(this.f38042b.f38051g);
        allocate.limit(this.f38042b.l);
        this.f38044d = new C1917c[this.f38042b.m];
        int i4 = 0;
        while (true) {
            c1917cArr = this.f38044d;
            if (i4 >= c1917cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f38044d[i4] = new C1917c(allocate, this.f38042b.a[4], (byte) 0);
            i4++;
        }
        short s = this.f38042b.n;
        if (s > 0) {
            C1917c c1917c = c1917cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c1917c.f38064f);
            this.a.getChannel().position(c1917c.f38063e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c1917c.k);
            for (C1917c c1917c2 : this.f38044d) {
                allocate2.position(c1917c2.a);
                String a2 = a(allocate2);
                c1917c2.k = a2;
                this.f38045e.put(a2, c1917c2);
            }
        }
    }

    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, fileChannel, byteBuffer, str) == null) {
            byteBuffer.rewind();
            int read = fileChannel.read(byteBuffer);
            if (read == byteBuffer.limit()) {
                byteBuffer.flip();
                return;
            }
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.close();
            this.f38045e.clear();
            this.f38043c = null;
            this.f38044d = null;
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            try {
                f.a(new c(file));
                return true;
            } catch (IOException unused) {
                f.a(null);
                return false;
            } catch (Throwable th) {
                f.a(null);
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteBuffer)) == null) {
            byte[] array = byteBuffer.array();
            int position = byteBuffer.position();
            while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
                byteBuffer.position(byteBuffer.position() + 1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName(HTTP.ASCII));
        }
        return (String) invokeL.objValue;
    }

    public static /* synthetic */ void a(int i, int i2, String str) {
        if (i <= 0 || i > i2) {
            throw new IOException(str);
        }
    }
}

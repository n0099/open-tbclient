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
/* loaded from: classes2.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileInputStream a;

    /* renamed from: b  reason: collision with root package name */
    public a f52981b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f52982c;

    /* renamed from: d  reason: collision with root package name */
    public C2038c[] f52983d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C2038c> f52984e;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final short f52985b;

        /* renamed from: c  reason: collision with root package name */
        public final short f52986c;

        /* renamed from: d  reason: collision with root package name */
        public final int f52987d;

        /* renamed from: e  reason: collision with root package name */
        public final long f52988e;

        /* renamed from: f  reason: collision with root package name */
        public final long f52989f;

        /* renamed from: g  reason: collision with root package name */
        public final long f52990g;

        /* renamed from: h  reason: collision with root package name */
        public final int f52991h;

        /* renamed from: i  reason: collision with root package name */
        public final short f52992i;

        /* renamed from: j  reason: collision with root package name */
        public final short f52993j;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.f52985b = allocate.getShort();
                this.f52986c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f52987d = i4;
                c.a(i4, 1, "bad elf version: " + this.f52987d);
                byte b4 = this.a[4];
                if (b4 == 1) {
                    this.f52988e = allocate.getInt();
                    this.f52989f = allocate.getInt();
                    this.f52990g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f52988e = allocate.getLong();
                    this.f52989f = allocate.getLong();
                    this.f52990g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f52991h = allocate.getInt();
                this.f52992i = allocate.getShort();
                this.f52993j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.a[0]), Byte.valueOf(this.a[1]), Byte.valueOf(this.a[2]), Byte.valueOf(this.a[3])));
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f52994b;

        /* renamed from: c  reason: collision with root package name */
        public final long f52995c;

        /* renamed from: d  reason: collision with root package name */
        public final long f52996d;

        /* renamed from: e  reason: collision with root package name */
        public final long f52997e;

        /* renamed from: f  reason: collision with root package name */
        public final long f52998f;

        /* renamed from: g  reason: collision with root package name */
        public final long f52999g;

        /* renamed from: h  reason: collision with root package name */
        public final long f53000h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public b(ByteBuffer byteBuffer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i2 == 1) {
                this.a = byteBuffer.getInt();
                this.f52995c = byteBuffer.getInt();
                this.f52996d = byteBuffer.getInt();
                this.f52997e = byteBuffer.getInt();
                this.f52998f = byteBuffer.getInt();
                this.f52999g = byteBuffer.getInt();
                this.f52994b = byteBuffer.getInt();
                this.f53000h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f52994b = byteBuffer.getInt();
                this.f52995c = byteBuffer.getLong();
                this.f52996d = byteBuffer.getLong();
                this.f52997e = byteBuffer.getLong();
                this.f52998f = byteBuffer.getLong();
                this.f52999g = byteBuffer.getLong();
                this.f53000h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2038c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53001b;

        /* renamed from: c  reason: collision with root package name */
        public final long f53002c;

        /* renamed from: d  reason: collision with root package name */
        public final long f53003d;

        /* renamed from: e  reason: collision with root package name */
        public final long f53004e;

        /* renamed from: f  reason: collision with root package name */
        public final long f53005f;

        /* renamed from: g  reason: collision with root package name */
        public final int f53006g;

        /* renamed from: h  reason: collision with root package name */
        public final int f53007h;

        /* renamed from: i  reason: collision with root package name */
        public final long f53008i;

        /* renamed from: j  reason: collision with root package name */
        public final long f53009j;
        public String k;

        public /* synthetic */ C2038c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C2038c(ByteBuffer byteBuffer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i2 == 1) {
                this.a = byteBuffer.getInt();
                this.f53001b = byteBuffer.getInt();
                this.f53002c = byteBuffer.getInt();
                this.f53003d = byteBuffer.getInt();
                this.f53004e = byteBuffer.getInt();
                this.f53005f = byteBuffer.getInt();
                this.f53006g = byteBuffer.getInt();
                this.f53007h = byteBuffer.getInt();
                this.f53008i = byteBuffer.getInt();
                this.f53009j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f53001b = byteBuffer.getInt();
                this.f53002c = byteBuffer.getLong();
                this.f53003d = byteBuffer.getLong();
                this.f53004e = byteBuffer.getLong();
                this.f53005f = byteBuffer.getLong();
                this.f53006g = byteBuffer.getInt();
                this.f53007h = byteBuffer.getInt();
                this.f53008i = byteBuffer.getLong();
                this.f53009j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.k = null;
        }
    }

    public c(File file) {
        C2038c[] c2038cArr;
        C2038c[] c2038cArr2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52981b = null;
        this.f52982c = null;
        this.f52983d = null;
        this.f52984e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f52981b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f52981b.f52993j);
        allocate.order(this.f52981b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f52981b.f52989f);
        this.f52982c = new b[this.f52981b.k];
        for (int i4 = 0; i4 < this.f52982c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f52982c[i4] = new b(allocate, this.f52981b.a[4], (byte) 0);
        }
        channel.position(this.f52981b.f52990g);
        allocate.limit(this.f52981b.l);
        this.f52983d = new C2038c[this.f52981b.m];
        int i5 = 0;
        while (true) {
            c2038cArr = this.f52983d;
            if (i5 >= c2038cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f52983d[i5] = new C2038c(allocate, this.f52981b.a[4], (byte) 0);
            i5++;
        }
        short s = this.f52981b.n;
        if (s > 0) {
            C2038c c2038c = c2038cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c2038c.f53005f);
            this.a.getChannel().position(c2038c.f53004e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c2038c.k);
            for (C2038c c2038c2 : this.f52983d) {
                allocate2.position(c2038c2.a);
                String a2 = a(allocate2);
                c2038c2.k = a2;
                this.f52984e.put(a2, c2038c2);
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
            this.f52984e.clear();
            this.f52982c = null;
            this.f52983d = null;
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

    public static /* synthetic */ void a(int i2, int i3, String str) {
        if (i2 <= 0 || i2 > i3) {
            throw new IOException(str);
        }
    }
}

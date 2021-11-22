package com.bytedance.pangle.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.util.g;
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
/* loaded from: classes11.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FileInputStream f62181a;

    /* renamed from: b  reason: collision with root package name */
    public a f62182b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f62183c;

    /* renamed from: d  reason: collision with root package name */
    public C1880c[] f62184d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C1880c> f62185e;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f62186a;

        /* renamed from: b  reason: collision with root package name */
        public final short f62187b;

        /* renamed from: c  reason: collision with root package name */
        public final short f62188c;

        /* renamed from: d  reason: collision with root package name */
        public final int f62189d;

        /* renamed from: e  reason: collision with root package name */
        public final long f62190e;

        /* renamed from: f  reason: collision with root package name */
        public final long f62191f;

        /* renamed from: g  reason: collision with root package name */
        public final long f62192g;

        /* renamed from: h  reason: collision with root package name */
        public final int f62193h;

        /* renamed from: i  reason: collision with root package name */
        public final short f62194i;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62186a = new byte[16];
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(this.f62186a));
            byte[] bArr = this.f62186a;
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b2 = bArr[4];
                c.a(b2, 2, "bad elf class: " + ((int) this.f62186a[4]));
                byte b3 = this.f62186a[5];
                c.a(b3, 2, "bad elf data encoding: " + ((int) this.f62186a[5]));
                ByteBuffer allocate = ByteBuffer.allocate(this.f62186a[4] == 1 ? 36 : 48);
                allocate.order(this.f62186a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                c.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.f62187b = allocate.getShort();
                this.f62188c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f62189d = i4;
                c.a(i4, 1, "bad elf version: " + this.f62189d);
                byte b4 = this.f62186a[4];
                if (b4 == 1) {
                    this.f62190e = allocate.getInt();
                    this.f62191f = allocate.getInt();
                    this.f62192g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f62190e = allocate.getLong();
                    this.f62191f = allocate.getLong();
                    this.f62192g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.f62186a[4]));
                }
                this.f62193h = allocate.getInt();
                this.f62194i = allocate.getShort();
                this.j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.f62186a[0]), Byte.valueOf(this.f62186a[1]), Byte.valueOf(this.f62186a[2]), Byte.valueOf(this.f62186a[3])));
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f62195a;

        /* renamed from: b  reason: collision with root package name */
        public final int f62196b;

        /* renamed from: c  reason: collision with root package name */
        public final long f62197c;

        /* renamed from: d  reason: collision with root package name */
        public final long f62198d;

        /* renamed from: e  reason: collision with root package name */
        public final long f62199e;

        /* renamed from: f  reason: collision with root package name */
        public final long f62200f;

        /* renamed from: g  reason: collision with root package name */
        public final long f62201g;

        /* renamed from: h  reason: collision with root package name */
        public final long f62202h;

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
                this.f62195a = byteBuffer.getInt();
                this.f62197c = byteBuffer.getInt();
                this.f62198d = byteBuffer.getInt();
                this.f62199e = byteBuffer.getInt();
                this.f62200f = byteBuffer.getInt();
                this.f62201g = byteBuffer.getInt();
                this.f62196b = byteBuffer.getInt();
                this.f62202h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.f62195a = byteBuffer.getInt();
                this.f62196b = byteBuffer.getInt();
                this.f62197c = byteBuffer.getLong();
                this.f62198d = byteBuffer.getLong();
                this.f62199e = byteBuffer.getLong();
                this.f62200f = byteBuffer.getLong();
                this.f62201g = byteBuffer.getLong();
                this.f62202h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1880c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f62203a;

        /* renamed from: b  reason: collision with root package name */
        public final int f62204b;

        /* renamed from: c  reason: collision with root package name */
        public final long f62205c;

        /* renamed from: d  reason: collision with root package name */
        public final long f62206d;

        /* renamed from: e  reason: collision with root package name */
        public final long f62207e;

        /* renamed from: f  reason: collision with root package name */
        public final long f62208f;

        /* renamed from: g  reason: collision with root package name */
        public final int f62209g;

        /* renamed from: h  reason: collision with root package name */
        public final int f62210h;

        /* renamed from: i  reason: collision with root package name */
        public final long f62211i;
        public final long j;
        public String k;

        public /* synthetic */ C1880c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C1880c(ByteBuffer byteBuffer, int i2) {
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
                this.f62203a = byteBuffer.getInt();
                this.f62204b = byteBuffer.getInt();
                this.f62205c = byteBuffer.getInt();
                this.f62206d = byteBuffer.getInt();
                this.f62207e = byteBuffer.getInt();
                this.f62208f = byteBuffer.getInt();
                this.f62209g = byteBuffer.getInt();
                this.f62210h = byteBuffer.getInt();
                this.f62211i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.f62203a = byteBuffer.getInt();
                this.f62204b = byteBuffer.getInt();
                this.f62205c = byteBuffer.getLong();
                this.f62206d = byteBuffer.getLong();
                this.f62207e = byteBuffer.getLong();
                this.f62208f = byteBuffer.getLong();
                this.f62209g = byteBuffer.getInt();
                this.f62210h = byteBuffer.getInt();
                this.f62211i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.k = null;
        }
    }

    public c(File file) {
        C1880c[] c1880cArr;
        C1880c[] c1880cArr2;
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
        this.f62182b = null;
        this.f62183c = null;
        this.f62184d = null;
        this.f62185e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f62181a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f62182b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f62182b.j);
        allocate.order(this.f62182b.f62186a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f62182b.f62191f);
        this.f62183c = new b[this.f62182b.k];
        for (int i4 = 0; i4 < this.f62183c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f62183c[i4] = new b(allocate, this.f62182b.f62186a[4], (byte) 0);
        }
        channel.position(this.f62182b.f62192g);
        allocate.limit(this.f62182b.l);
        this.f62184d = new C1880c[this.f62182b.m];
        int i5 = 0;
        while (true) {
            c1880cArr = this.f62184d;
            if (i5 >= c1880cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f62184d[i5] = new C1880c(allocate, this.f62182b.f62186a[4], (byte) 0);
            i5++;
        }
        short s = this.f62182b.n;
        if (s > 0) {
            C1880c c1880c = c1880cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c1880c.f62208f);
            this.f62181a.getChannel().position(c1880c.f62207e);
            b(this.f62181a.getChannel(), allocate2, "failed to read section: " + c1880c.k);
            for (C1880c c1880c2 : this.f62184d) {
                allocate2.position(c1880c2.f62203a);
                String a2 = a(allocate2);
                c1880c2.k = a2;
                this.f62185e.put(a2, c1880c2);
            }
        }
    }

    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, fileChannel, byteBuffer, str) == null) {
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
            this.f62181a.close();
            this.f62185e.clear();
            this.f62183c = null;
            this.f62184d = null;
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            try {
                g.a(new c(file));
                return true;
            } catch (IOException unused) {
                g.a(null);
                return false;
            } catch (Throwable th) {
                g.a(null);
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

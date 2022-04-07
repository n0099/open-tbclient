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
/* loaded from: classes4.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileInputStream a;
    public a b;
    public b[] c;
    public C0257c[] d;
    public final Map<String, C0257c> e;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;
        public final short b;
        public final short c;
        public final int d;
        public final long e;
        public final long f;
        public final long g;
        public final int h;
        public final short i;
        public final short j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        public /* synthetic */ a(FileChannel fileChannel, byte b) {
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
                byte b = bArr[4];
                c.a(b, 2, "bad elf class: " + ((int) this.a[4]));
                byte b2 = this.a[5];
                c.a(b2, 2, "bad elf data encoding: " + ((int) this.a[5]));
                ByteBuffer allocate = ByteBuffer.allocate(this.a[4] == 1 ? 36 : 48);
                allocate.order(this.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                c.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.b = allocate.getShort();
                this.c = allocate.getShort();
                int i3 = allocate.getInt();
                this.d = i3;
                c.a(i3, 1, "bad elf version: " + this.d);
                byte b3 = this.a[4];
                if (b3 == 1) {
                    this.e = allocate.getInt();
                    this.f = allocate.getInt();
                    this.g = allocate.getInt();
                } else if (b3 == 2) {
                    this.e = allocate.getLong();
                    this.f = allocate.getLong();
                    this.g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.h = allocate.getInt();
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

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final long h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i, byte b) {
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
                this.c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
            } else if (i == 2) {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.f = byteBuffer.getLong();
                this.g = byteBuffer.getLong();
                this.h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0257c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final int b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final int g;
        public final int h;
        public final long i;
        public final long j;
        public String k;

        public /* synthetic */ C0257c(ByteBuffer byteBuffer, int i, byte b) {
            this(byteBuffer, i);
        }

        public C0257c(ByteBuffer byteBuffer, int i) {
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
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getInt();
                this.d = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.f = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else if (i == 2) {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.c = byteBuffer.getLong();
                this.d = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.f = byteBuffer.getLong();
                this.g = byteBuffer.getInt();
                this.h = byteBuffer.getInt();
                this.i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.k = null;
        }
    }

    public c(File file) {
        C0257c[] c0257cArr;
        C0257c[] c0257cArr2;
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.b.j);
        allocate.order(this.b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.b.f);
        this.c = new b[this.b.k];
        for (int i3 = 0; i3 < this.c.length; i3++) {
            b(channel, allocate, "failed to read phdr.");
            this.c[i3] = new b(allocate, this.b.a[4], (byte) 0);
        }
        channel.position(this.b.g);
        allocate.limit(this.b.l);
        this.d = new C0257c[this.b.m];
        int i4 = 0;
        while (true) {
            c0257cArr = this.d;
            if (i4 >= c0257cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.d[i4] = new C0257c(allocate, this.b.a[4], (byte) 0);
            i4++;
        }
        short s = this.b.n;
        if (s > 0) {
            C0257c c0257c = c0257cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c0257c.f);
            this.a.getChannel().position(c0257c.e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c0257c.k);
            for (C0257c c0257c2 : this.d) {
                allocate2.position(c0257c2.a);
                String a2 = a(allocate2);
                c0257c2.k = a2;
                this.e.put(a2, c0257c2);
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
            this.e.clear();
            this.c = null;
            this.d = null;
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

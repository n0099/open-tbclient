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
    public final FileInputStream f61282a;

    /* renamed from: b  reason: collision with root package name */
    public a f61283b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f61284c;

    /* renamed from: d  reason: collision with root package name */
    public C1841c[] f61285d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C1841c> f61286e;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f61287a;

        /* renamed from: b  reason: collision with root package name */
        public final short f61288b;

        /* renamed from: c  reason: collision with root package name */
        public final short f61289c;

        /* renamed from: d  reason: collision with root package name */
        public final int f61290d;

        /* renamed from: e  reason: collision with root package name */
        public final long f61291e;

        /* renamed from: f  reason: collision with root package name */
        public final long f61292f;

        /* renamed from: g  reason: collision with root package name */
        public final long f61293g;

        /* renamed from: h  reason: collision with root package name */
        public final int f61294h;

        /* renamed from: i  reason: collision with root package name */
        public final short f61295i;
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
            this.f61287a = new byte[16];
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(this.f61287a));
            byte[] bArr = this.f61287a;
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b2 = bArr[4];
                c.a(b2, 2, "bad elf class: " + ((int) this.f61287a[4]));
                byte b3 = this.f61287a[5];
                c.a(b3, 2, "bad elf data encoding: " + ((int) this.f61287a[5]));
                ByteBuffer allocate = ByteBuffer.allocate(this.f61287a[4] == 1 ? 36 : 48);
                allocate.order(this.f61287a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                c.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.f61288b = allocate.getShort();
                this.f61289c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f61290d = i4;
                c.a(i4, 1, "bad elf version: " + this.f61290d);
                byte b4 = this.f61287a[4];
                if (b4 == 1) {
                    this.f61291e = allocate.getInt();
                    this.f61292f = allocate.getInt();
                    this.f61293g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f61291e = allocate.getLong();
                    this.f61292f = allocate.getLong();
                    this.f61293g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.f61287a[4]));
                }
                this.f61294h = allocate.getInt();
                this.f61295i = allocate.getShort();
                this.j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.f61287a[0]), Byte.valueOf(this.f61287a[1]), Byte.valueOf(this.f61287a[2]), Byte.valueOf(this.f61287a[3])));
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f61296a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61297b;

        /* renamed from: c  reason: collision with root package name */
        public final long f61298c;

        /* renamed from: d  reason: collision with root package name */
        public final long f61299d;

        /* renamed from: e  reason: collision with root package name */
        public final long f61300e;

        /* renamed from: f  reason: collision with root package name */
        public final long f61301f;

        /* renamed from: g  reason: collision with root package name */
        public final long f61302g;

        /* renamed from: h  reason: collision with root package name */
        public final long f61303h;

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
                this.f61296a = byteBuffer.getInt();
                this.f61298c = byteBuffer.getInt();
                this.f61299d = byteBuffer.getInt();
                this.f61300e = byteBuffer.getInt();
                this.f61301f = byteBuffer.getInt();
                this.f61302g = byteBuffer.getInt();
                this.f61297b = byteBuffer.getInt();
                this.f61303h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.f61296a = byteBuffer.getInt();
                this.f61297b = byteBuffer.getInt();
                this.f61298c = byteBuffer.getLong();
                this.f61299d = byteBuffer.getLong();
                this.f61300e = byteBuffer.getLong();
                this.f61301f = byteBuffer.getLong();
                this.f61302g = byteBuffer.getLong();
                this.f61303h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1841c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f61304a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61305b;

        /* renamed from: c  reason: collision with root package name */
        public final long f61306c;

        /* renamed from: d  reason: collision with root package name */
        public final long f61307d;

        /* renamed from: e  reason: collision with root package name */
        public final long f61308e;

        /* renamed from: f  reason: collision with root package name */
        public final long f61309f;

        /* renamed from: g  reason: collision with root package name */
        public final int f61310g;

        /* renamed from: h  reason: collision with root package name */
        public final int f61311h;

        /* renamed from: i  reason: collision with root package name */
        public final long f61312i;
        public final long j;
        public String k;

        public /* synthetic */ C1841c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C1841c(ByteBuffer byteBuffer, int i2) {
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
                this.f61304a = byteBuffer.getInt();
                this.f61305b = byteBuffer.getInt();
                this.f61306c = byteBuffer.getInt();
                this.f61307d = byteBuffer.getInt();
                this.f61308e = byteBuffer.getInt();
                this.f61309f = byteBuffer.getInt();
                this.f61310g = byteBuffer.getInt();
                this.f61311h = byteBuffer.getInt();
                this.f61312i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.f61304a = byteBuffer.getInt();
                this.f61305b = byteBuffer.getInt();
                this.f61306c = byteBuffer.getLong();
                this.f61307d = byteBuffer.getLong();
                this.f61308e = byteBuffer.getLong();
                this.f61309f = byteBuffer.getLong();
                this.f61310g = byteBuffer.getInt();
                this.f61311h = byteBuffer.getInt();
                this.f61312i = byteBuffer.getLong();
                this.j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.k = null;
        }
    }

    public c(File file) {
        C1841c[] c1841cArr;
        C1841c[] c1841cArr2;
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
        this.f61283b = null;
        this.f61284c = null;
        this.f61285d = null;
        this.f61286e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f61282a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f61283b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f61283b.j);
        allocate.order(this.f61283b.f61287a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f61283b.f61292f);
        this.f61284c = new b[this.f61283b.k];
        for (int i4 = 0; i4 < this.f61284c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f61284c[i4] = new b(allocate, this.f61283b.f61287a[4], (byte) 0);
        }
        channel.position(this.f61283b.f61293g);
        allocate.limit(this.f61283b.l);
        this.f61285d = new C1841c[this.f61283b.m];
        int i5 = 0;
        while (true) {
            c1841cArr = this.f61285d;
            if (i5 >= c1841cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f61285d[i5] = new C1841c(allocate, this.f61283b.f61287a[4], (byte) 0);
            i5++;
        }
        short s = this.f61283b.n;
        if (s > 0) {
            C1841c c1841c = c1841cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c1841c.f61309f);
            this.f61282a.getChannel().position(c1841c.f61308e);
            b(this.f61282a.getChannel(), allocate2, "failed to read section: " + c1841c.k);
            for (C1841c c1841c2 : this.f61285d) {
                allocate2.position(c1841c2.f61304a);
                String a2 = a(allocate2);
                c1841c2.k = a2;
                this.f61286e.put(a2, c1841c2);
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
            this.f61282a.close();
            this.f61286e.clear();
            this.f61284c = null;
            this.f61285d = null;
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

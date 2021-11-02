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
    public final FileInputStream f61283a;

    /* renamed from: b  reason: collision with root package name */
    public a f61284b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f61285c;

    /* renamed from: d  reason: collision with root package name */
    public C1841c[] f61286d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C1841c> f61287e;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f61288a;

        /* renamed from: b  reason: collision with root package name */
        public final short f61289b;

        /* renamed from: c  reason: collision with root package name */
        public final short f61290c;

        /* renamed from: d  reason: collision with root package name */
        public final int f61291d;

        /* renamed from: e  reason: collision with root package name */
        public final long f61292e;

        /* renamed from: f  reason: collision with root package name */
        public final long f61293f;

        /* renamed from: g  reason: collision with root package name */
        public final long f61294g;

        /* renamed from: h  reason: collision with root package name */
        public final int f61295h;

        /* renamed from: i  reason: collision with root package name */
        public final short f61296i;
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
            this.f61288a = new byte[16];
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(this.f61288a));
            byte[] bArr = this.f61288a;
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b2 = bArr[4];
                c.a(b2, 2, "bad elf class: " + ((int) this.f61288a[4]));
                byte b3 = this.f61288a[5];
                c.a(b3, 2, "bad elf data encoding: " + ((int) this.f61288a[5]));
                ByteBuffer allocate = ByteBuffer.allocate(this.f61288a[4] == 1 ? 36 : 48);
                allocate.order(this.f61288a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                c.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.f61289b = allocate.getShort();
                this.f61290c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f61291d = i4;
                c.a(i4, 1, "bad elf version: " + this.f61291d);
                byte b4 = this.f61288a[4];
                if (b4 == 1) {
                    this.f61292e = allocate.getInt();
                    this.f61293f = allocate.getInt();
                    this.f61294g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f61292e = allocate.getLong();
                    this.f61293f = allocate.getLong();
                    this.f61294g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.f61288a[4]));
                }
                this.f61295h = allocate.getInt();
                this.f61296i = allocate.getShort();
                this.j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.f61288a[0]), Byte.valueOf(this.f61288a[1]), Byte.valueOf(this.f61288a[2]), Byte.valueOf(this.f61288a[3])));
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f61297a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61298b;

        /* renamed from: c  reason: collision with root package name */
        public final long f61299c;

        /* renamed from: d  reason: collision with root package name */
        public final long f61300d;

        /* renamed from: e  reason: collision with root package name */
        public final long f61301e;

        /* renamed from: f  reason: collision with root package name */
        public final long f61302f;

        /* renamed from: g  reason: collision with root package name */
        public final long f61303g;

        /* renamed from: h  reason: collision with root package name */
        public final long f61304h;

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
                this.f61297a = byteBuffer.getInt();
                this.f61299c = byteBuffer.getInt();
                this.f61300d = byteBuffer.getInt();
                this.f61301e = byteBuffer.getInt();
                this.f61302f = byteBuffer.getInt();
                this.f61303g = byteBuffer.getInt();
                this.f61298b = byteBuffer.getInt();
                this.f61304h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.f61297a = byteBuffer.getInt();
                this.f61298b = byteBuffer.getInt();
                this.f61299c = byteBuffer.getLong();
                this.f61300d = byteBuffer.getLong();
                this.f61301e = byteBuffer.getLong();
                this.f61302f = byteBuffer.getLong();
                this.f61303g = byteBuffer.getLong();
                this.f61304h = byteBuffer.getLong();
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
        public final int f61305a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61306b;

        /* renamed from: c  reason: collision with root package name */
        public final long f61307c;

        /* renamed from: d  reason: collision with root package name */
        public final long f61308d;

        /* renamed from: e  reason: collision with root package name */
        public final long f61309e;

        /* renamed from: f  reason: collision with root package name */
        public final long f61310f;

        /* renamed from: g  reason: collision with root package name */
        public final int f61311g;

        /* renamed from: h  reason: collision with root package name */
        public final int f61312h;

        /* renamed from: i  reason: collision with root package name */
        public final long f61313i;
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
                this.f61305a = byteBuffer.getInt();
                this.f61306b = byteBuffer.getInt();
                this.f61307c = byteBuffer.getInt();
                this.f61308d = byteBuffer.getInt();
                this.f61309e = byteBuffer.getInt();
                this.f61310f = byteBuffer.getInt();
                this.f61311g = byteBuffer.getInt();
                this.f61312h = byteBuffer.getInt();
                this.f61313i = byteBuffer.getInt();
                this.j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.f61305a = byteBuffer.getInt();
                this.f61306b = byteBuffer.getInt();
                this.f61307c = byteBuffer.getLong();
                this.f61308d = byteBuffer.getLong();
                this.f61309e = byteBuffer.getLong();
                this.f61310f = byteBuffer.getLong();
                this.f61311g = byteBuffer.getInt();
                this.f61312h = byteBuffer.getInt();
                this.f61313i = byteBuffer.getLong();
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
        this.f61284b = null;
        this.f61285c = null;
        this.f61286d = null;
        this.f61287e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f61283a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f61284b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f61284b.j);
        allocate.order(this.f61284b.f61288a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f61284b.f61293f);
        this.f61285c = new b[this.f61284b.k];
        for (int i4 = 0; i4 < this.f61285c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f61285c[i4] = new b(allocate, this.f61284b.f61288a[4], (byte) 0);
        }
        channel.position(this.f61284b.f61294g);
        allocate.limit(this.f61284b.l);
        this.f61286d = new C1841c[this.f61284b.m];
        int i5 = 0;
        while (true) {
            c1841cArr = this.f61286d;
            if (i5 >= c1841cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f61286d[i5] = new C1841c(allocate, this.f61284b.f61288a[4], (byte) 0);
            i5++;
        }
        short s = this.f61284b.n;
        if (s > 0) {
            C1841c c1841c = c1841cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c1841c.f61310f);
            this.f61283a.getChannel().position(c1841c.f61309e);
            b(this.f61283a.getChannel(), allocate2, "failed to read section: " + c1841c.k);
            for (C1841c c1841c2 : this.f61286d) {
                allocate2.position(c1841c2.f61305a);
                String a2 = a(allocate2);
                c1841c2.k = a2;
                this.f61287e.put(a2, c1841c2);
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
            this.f61283a.close();
            this.f61287e.clear();
            this.f61285c = null;
            this.f61286d = null;
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

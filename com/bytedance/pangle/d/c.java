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
/* loaded from: classes3.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileInputStream a;

    /* renamed from: b  reason: collision with root package name */
    public a f53193b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f53194c;

    /* renamed from: d  reason: collision with root package name */
    public C2054c[] f53195d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C2054c> f53196e;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final short f53197b;

        /* renamed from: c  reason: collision with root package name */
        public final short f53198c;

        /* renamed from: d  reason: collision with root package name */
        public final int f53199d;

        /* renamed from: e  reason: collision with root package name */
        public final long f53200e;

        /* renamed from: f  reason: collision with root package name */
        public final long f53201f;

        /* renamed from: g  reason: collision with root package name */
        public final long f53202g;

        /* renamed from: h  reason: collision with root package name */
        public final int f53203h;

        /* renamed from: i  reason: collision with root package name */
        public final short f53204i;

        /* renamed from: j  reason: collision with root package name */
        public final short f53205j;
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
                this.f53197b = allocate.getShort();
                this.f53198c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f53199d = i4;
                c.a(i4, 1, "bad elf version: " + this.f53199d);
                byte b4 = this.a[4];
                if (b4 == 1) {
                    this.f53200e = allocate.getInt();
                    this.f53201f = allocate.getInt();
                    this.f53202g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f53200e = allocate.getLong();
                    this.f53201f = allocate.getLong();
                    this.f53202g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f53203h = allocate.getInt();
                this.f53204i = allocate.getShort();
                this.f53205j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.a[0]), Byte.valueOf(this.a[1]), Byte.valueOf(this.a[2]), Byte.valueOf(this.a[3])));
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53206b;

        /* renamed from: c  reason: collision with root package name */
        public final long f53207c;

        /* renamed from: d  reason: collision with root package name */
        public final long f53208d;

        /* renamed from: e  reason: collision with root package name */
        public final long f53209e;

        /* renamed from: f  reason: collision with root package name */
        public final long f53210f;

        /* renamed from: g  reason: collision with root package name */
        public final long f53211g;

        /* renamed from: h  reason: collision with root package name */
        public final long f53212h;

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
                this.f53207c = byteBuffer.getInt();
                this.f53208d = byteBuffer.getInt();
                this.f53209e = byteBuffer.getInt();
                this.f53210f = byteBuffer.getInt();
                this.f53211g = byteBuffer.getInt();
                this.f53206b = byteBuffer.getInt();
                this.f53212h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f53206b = byteBuffer.getInt();
                this.f53207c = byteBuffer.getLong();
                this.f53208d = byteBuffer.getLong();
                this.f53209e = byteBuffer.getLong();
                this.f53210f = byteBuffer.getLong();
                this.f53211g = byteBuffer.getLong();
                this.f53212h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2054c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53213b;

        /* renamed from: c  reason: collision with root package name */
        public final long f53214c;

        /* renamed from: d  reason: collision with root package name */
        public final long f53215d;

        /* renamed from: e  reason: collision with root package name */
        public final long f53216e;

        /* renamed from: f  reason: collision with root package name */
        public final long f53217f;

        /* renamed from: g  reason: collision with root package name */
        public final int f53218g;

        /* renamed from: h  reason: collision with root package name */
        public final int f53219h;

        /* renamed from: i  reason: collision with root package name */
        public final long f53220i;

        /* renamed from: j  reason: collision with root package name */
        public final long f53221j;
        public String k;

        public /* synthetic */ C2054c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C2054c(ByteBuffer byteBuffer, int i2) {
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
                this.f53213b = byteBuffer.getInt();
                this.f53214c = byteBuffer.getInt();
                this.f53215d = byteBuffer.getInt();
                this.f53216e = byteBuffer.getInt();
                this.f53217f = byteBuffer.getInt();
                this.f53218g = byteBuffer.getInt();
                this.f53219h = byteBuffer.getInt();
                this.f53220i = byteBuffer.getInt();
                this.f53221j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f53213b = byteBuffer.getInt();
                this.f53214c = byteBuffer.getLong();
                this.f53215d = byteBuffer.getLong();
                this.f53216e = byteBuffer.getLong();
                this.f53217f = byteBuffer.getLong();
                this.f53218g = byteBuffer.getInt();
                this.f53219h = byteBuffer.getInt();
                this.f53220i = byteBuffer.getLong();
                this.f53221j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.k = null;
        }
    }

    public c(File file) {
        C2054c[] c2054cArr;
        C2054c[] c2054cArr2;
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
        this.f53193b = null;
        this.f53194c = null;
        this.f53195d = null;
        this.f53196e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f53193b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f53193b.f53205j);
        allocate.order(this.f53193b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f53193b.f53201f);
        this.f53194c = new b[this.f53193b.k];
        for (int i4 = 0; i4 < this.f53194c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f53194c[i4] = new b(allocate, this.f53193b.a[4], (byte) 0);
        }
        channel.position(this.f53193b.f53202g);
        allocate.limit(this.f53193b.l);
        this.f53195d = new C2054c[this.f53193b.m];
        int i5 = 0;
        while (true) {
            c2054cArr = this.f53195d;
            if (i5 >= c2054cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f53195d[i5] = new C2054c(allocate, this.f53193b.a[4], (byte) 0);
            i5++;
        }
        short s = this.f53193b.n;
        if (s > 0) {
            C2054c c2054c = c2054cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c2054c.f53217f);
            this.a.getChannel().position(c2054c.f53216e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c2054c.k);
            for (C2054c c2054c2 : this.f53195d) {
                allocate2.position(c2054c2.a);
                String a2 = a(allocate2);
                c2054c2.k = a2;
                this.f53196e.put(a2, c2054c2);
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
            this.f53196e.clear();
            this.f53194c = null;
            this.f53195d = null;
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

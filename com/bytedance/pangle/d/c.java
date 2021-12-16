package com.bytedance.pangle.d;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes2.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileInputStream a;

    /* renamed from: b  reason: collision with root package name */
    public a f55071b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f55072c;

    /* renamed from: d  reason: collision with root package name */
    public C2013c[] f55073d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C2013c> f55074e;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final short f55075b;

        /* renamed from: c  reason: collision with root package name */
        public final short f55076c;

        /* renamed from: d  reason: collision with root package name */
        public final int f55077d;

        /* renamed from: e  reason: collision with root package name */
        public final long f55078e;

        /* renamed from: f  reason: collision with root package name */
        public final long f55079f;

        /* renamed from: g  reason: collision with root package name */
        public final long f55080g;

        /* renamed from: h  reason: collision with root package name */
        public final int f55081h;

        /* renamed from: i  reason: collision with root package name */
        public final short f55082i;

        /* renamed from: j  reason: collision with root package name */
        public final short f55083j;

        /* renamed from: k  reason: collision with root package name */
        public final short f55084k;
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
                this.f55075b = allocate.getShort();
                this.f55076c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f55077d = i4;
                c.a(i4, 1, "bad elf version: " + this.f55077d);
                byte b4 = this.a[4];
                if (b4 == 1) {
                    this.f55078e = allocate.getInt();
                    this.f55079f = allocate.getInt();
                    this.f55080g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f55078e = allocate.getLong();
                    this.f55079f = allocate.getLong();
                    this.f55080g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f55081h = allocate.getInt();
                this.f55082i = allocate.getShort();
                this.f55083j = allocate.getShort();
                this.f55084k = allocate.getShort();
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
        public final int f55085b;

        /* renamed from: c  reason: collision with root package name */
        public final long f55086c;

        /* renamed from: d  reason: collision with root package name */
        public final long f55087d;

        /* renamed from: e  reason: collision with root package name */
        public final long f55088e;

        /* renamed from: f  reason: collision with root package name */
        public final long f55089f;

        /* renamed from: g  reason: collision with root package name */
        public final long f55090g;

        /* renamed from: h  reason: collision with root package name */
        public final long f55091h;

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
                this.f55086c = byteBuffer.getInt();
                this.f55087d = byteBuffer.getInt();
                this.f55088e = byteBuffer.getInt();
                this.f55089f = byteBuffer.getInt();
                this.f55090g = byteBuffer.getInt();
                this.f55085b = byteBuffer.getInt();
                this.f55091h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f55085b = byteBuffer.getInt();
                this.f55086c = byteBuffer.getLong();
                this.f55087d = byteBuffer.getLong();
                this.f55088e = byteBuffer.getLong();
                this.f55089f = byteBuffer.getLong();
                this.f55090g = byteBuffer.getLong();
                this.f55091h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2013c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f55092b;

        /* renamed from: c  reason: collision with root package name */
        public final long f55093c;

        /* renamed from: d  reason: collision with root package name */
        public final long f55094d;

        /* renamed from: e  reason: collision with root package name */
        public final long f55095e;

        /* renamed from: f  reason: collision with root package name */
        public final long f55096f;

        /* renamed from: g  reason: collision with root package name */
        public final int f55097g;

        /* renamed from: h  reason: collision with root package name */
        public final int f55098h;

        /* renamed from: i  reason: collision with root package name */
        public final long f55099i;

        /* renamed from: j  reason: collision with root package name */
        public final long f55100j;

        /* renamed from: k  reason: collision with root package name */
        public String f55101k;

        public /* synthetic */ C2013c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C2013c(ByteBuffer byteBuffer, int i2) {
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
                this.f55092b = byteBuffer.getInt();
                this.f55093c = byteBuffer.getInt();
                this.f55094d = byteBuffer.getInt();
                this.f55095e = byteBuffer.getInt();
                this.f55096f = byteBuffer.getInt();
                this.f55097g = byteBuffer.getInt();
                this.f55098h = byteBuffer.getInt();
                this.f55099i = byteBuffer.getInt();
                this.f55100j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f55092b = byteBuffer.getInt();
                this.f55093c = byteBuffer.getLong();
                this.f55094d = byteBuffer.getLong();
                this.f55095e = byteBuffer.getLong();
                this.f55096f = byteBuffer.getLong();
                this.f55097g = byteBuffer.getInt();
                this.f55098h = byteBuffer.getInt();
                this.f55099i = byteBuffer.getLong();
                this.f55100j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.f55101k = null;
        }
    }

    public c(File file) {
        C2013c[] c2013cArr;
        C2013c[] c2013cArr2;
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
        this.f55071b = null;
        this.f55072c = null;
        this.f55073d = null;
        this.f55074e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f55071b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f55071b.f55083j);
        allocate.order(this.f55071b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f55071b.f55079f);
        this.f55072c = new b[this.f55071b.f55084k];
        for (int i4 = 0; i4 < this.f55072c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f55072c[i4] = new b(allocate, this.f55071b.a[4], (byte) 0);
        }
        channel.position(this.f55071b.f55080g);
        allocate.limit(this.f55071b.l);
        this.f55073d = new C2013c[this.f55071b.m];
        int i5 = 0;
        while (true) {
            c2013cArr = this.f55073d;
            if (i5 >= c2013cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f55073d[i5] = new C2013c(allocate, this.f55071b.a[4], (byte) 0);
            i5++;
        }
        short s = this.f55071b.n;
        if (s > 0) {
            C2013c c2013c = c2013cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c2013c.f55096f);
            this.a.getChannel().position(c2013c.f55095e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c2013c.f55101k);
            for (C2013c c2013c2 : this.f55073d) {
                allocate2.position(c2013c2.a);
                String a2 = a(allocate2);
                c2013c2.f55101k = a2;
                this.f55074e.put(a2, c2013c2);
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
            this.f55074e.clear();
            this.f55072c = null;
            this.f55073d = null;
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

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
    public a f55075b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f55076c;

    /* renamed from: d  reason: collision with root package name */
    public C2021c[] f55077d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C2021c> f55078e;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final short f55079b;

        /* renamed from: c  reason: collision with root package name */
        public final short f55080c;

        /* renamed from: d  reason: collision with root package name */
        public final int f55081d;

        /* renamed from: e  reason: collision with root package name */
        public final long f55082e;

        /* renamed from: f  reason: collision with root package name */
        public final long f55083f;

        /* renamed from: g  reason: collision with root package name */
        public final long f55084g;

        /* renamed from: h  reason: collision with root package name */
        public final int f55085h;

        /* renamed from: i  reason: collision with root package name */
        public final short f55086i;

        /* renamed from: j  reason: collision with root package name */
        public final short f55087j;

        /* renamed from: k  reason: collision with root package name */
        public final short f55088k;
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
                this.f55079b = allocate.getShort();
                this.f55080c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f55081d = i4;
                c.a(i4, 1, "bad elf version: " + this.f55081d);
                byte b4 = this.a[4];
                if (b4 == 1) {
                    this.f55082e = allocate.getInt();
                    this.f55083f = allocate.getInt();
                    this.f55084g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f55082e = allocate.getLong();
                    this.f55083f = allocate.getLong();
                    this.f55084g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f55085h = allocate.getInt();
                this.f55086i = allocate.getShort();
                this.f55087j = allocate.getShort();
                this.f55088k = allocate.getShort();
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
        public final int f55089b;

        /* renamed from: c  reason: collision with root package name */
        public final long f55090c;

        /* renamed from: d  reason: collision with root package name */
        public final long f55091d;

        /* renamed from: e  reason: collision with root package name */
        public final long f55092e;

        /* renamed from: f  reason: collision with root package name */
        public final long f55093f;

        /* renamed from: g  reason: collision with root package name */
        public final long f55094g;

        /* renamed from: h  reason: collision with root package name */
        public final long f55095h;

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
                this.f55090c = byteBuffer.getInt();
                this.f55091d = byteBuffer.getInt();
                this.f55092e = byteBuffer.getInt();
                this.f55093f = byteBuffer.getInt();
                this.f55094g = byteBuffer.getInt();
                this.f55089b = byteBuffer.getInt();
                this.f55095h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f55089b = byteBuffer.getInt();
                this.f55090c = byteBuffer.getLong();
                this.f55091d = byteBuffer.getLong();
                this.f55092e = byteBuffer.getLong();
                this.f55093f = byteBuffer.getLong();
                this.f55094g = byteBuffer.getLong();
                this.f55095h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2021c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f55096b;

        /* renamed from: c  reason: collision with root package name */
        public final long f55097c;

        /* renamed from: d  reason: collision with root package name */
        public final long f55098d;

        /* renamed from: e  reason: collision with root package name */
        public final long f55099e;

        /* renamed from: f  reason: collision with root package name */
        public final long f55100f;

        /* renamed from: g  reason: collision with root package name */
        public final int f55101g;

        /* renamed from: h  reason: collision with root package name */
        public final int f55102h;

        /* renamed from: i  reason: collision with root package name */
        public final long f55103i;

        /* renamed from: j  reason: collision with root package name */
        public final long f55104j;

        /* renamed from: k  reason: collision with root package name */
        public String f55105k;

        public /* synthetic */ C2021c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C2021c(ByteBuffer byteBuffer, int i2) {
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
                this.f55096b = byteBuffer.getInt();
                this.f55097c = byteBuffer.getInt();
                this.f55098d = byteBuffer.getInt();
                this.f55099e = byteBuffer.getInt();
                this.f55100f = byteBuffer.getInt();
                this.f55101g = byteBuffer.getInt();
                this.f55102h = byteBuffer.getInt();
                this.f55103i = byteBuffer.getInt();
                this.f55104j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f55096b = byteBuffer.getInt();
                this.f55097c = byteBuffer.getLong();
                this.f55098d = byteBuffer.getLong();
                this.f55099e = byteBuffer.getLong();
                this.f55100f = byteBuffer.getLong();
                this.f55101g = byteBuffer.getInt();
                this.f55102h = byteBuffer.getInt();
                this.f55103i = byteBuffer.getLong();
                this.f55104j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.f55105k = null;
        }
    }

    public c(File file) {
        C2021c[] c2021cArr;
        C2021c[] c2021cArr2;
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
        this.f55075b = null;
        this.f55076c = null;
        this.f55077d = null;
        this.f55078e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f55075b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f55075b.f55087j);
        allocate.order(this.f55075b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f55075b.f55083f);
        this.f55076c = new b[this.f55075b.f55088k];
        for (int i4 = 0; i4 < this.f55076c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f55076c[i4] = new b(allocate, this.f55075b.a[4], (byte) 0);
        }
        channel.position(this.f55075b.f55084g);
        allocate.limit(this.f55075b.l);
        this.f55077d = new C2021c[this.f55075b.m];
        int i5 = 0;
        while (true) {
            c2021cArr = this.f55077d;
            if (i5 >= c2021cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f55077d[i5] = new C2021c(allocate, this.f55075b.a[4], (byte) 0);
            i5++;
        }
        short s = this.f55075b.n;
        if (s > 0) {
            C2021c c2021c = c2021cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c2021c.f55100f);
            this.a.getChannel().position(c2021c.f55099e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c2021c.f55105k);
            for (C2021c c2021c2 : this.f55077d) {
                allocate2.position(c2021c2.a);
                String a2 = a(allocate2);
                c2021c2.f55105k = a2;
                this.f55078e.put(a2, c2021c2);
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
            this.f55078e.clear();
            this.f55076c = null;
            this.f55077d = null;
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

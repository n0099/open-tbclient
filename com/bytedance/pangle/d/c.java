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
/* loaded from: classes7.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileInputStream a;

    /* renamed from: b  reason: collision with root package name */
    public a f51612b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f51613c;

    /* renamed from: d  reason: collision with root package name */
    public C2030c[] f51614d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C2030c> f51615e;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final short f51616b;

        /* renamed from: c  reason: collision with root package name */
        public final short f51617c;

        /* renamed from: d  reason: collision with root package name */
        public final int f51618d;

        /* renamed from: e  reason: collision with root package name */
        public final long f51619e;

        /* renamed from: f  reason: collision with root package name */
        public final long f51620f;

        /* renamed from: g  reason: collision with root package name */
        public final long f51621g;

        /* renamed from: h  reason: collision with root package name */
        public final int f51622h;

        /* renamed from: i  reason: collision with root package name */
        public final short f51623i;

        /* renamed from: j  reason: collision with root package name */
        public final short f51624j;
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
                this.f51616b = allocate.getShort();
                this.f51617c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f51618d = i4;
                c.a(i4, 1, "bad elf version: " + this.f51618d);
                byte b4 = this.a[4];
                if (b4 == 1) {
                    this.f51619e = allocate.getInt();
                    this.f51620f = allocate.getInt();
                    this.f51621g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f51619e = allocate.getLong();
                    this.f51620f = allocate.getLong();
                    this.f51621g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f51622h = allocate.getInt();
                this.f51623i = allocate.getShort();
                this.f51624j = allocate.getShort();
                this.k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.a[0]), Byte.valueOf(this.a[1]), Byte.valueOf(this.a[2]), Byte.valueOf(this.a[3])));
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f51625b;

        /* renamed from: c  reason: collision with root package name */
        public final long f51626c;

        /* renamed from: d  reason: collision with root package name */
        public final long f51627d;

        /* renamed from: e  reason: collision with root package name */
        public final long f51628e;

        /* renamed from: f  reason: collision with root package name */
        public final long f51629f;

        /* renamed from: g  reason: collision with root package name */
        public final long f51630g;

        /* renamed from: h  reason: collision with root package name */
        public final long f51631h;

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
                this.f51626c = byteBuffer.getInt();
                this.f51627d = byteBuffer.getInt();
                this.f51628e = byteBuffer.getInt();
                this.f51629f = byteBuffer.getInt();
                this.f51630g = byteBuffer.getInt();
                this.f51625b = byteBuffer.getInt();
                this.f51631h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f51625b = byteBuffer.getInt();
                this.f51626c = byteBuffer.getLong();
                this.f51627d = byteBuffer.getLong();
                this.f51628e = byteBuffer.getLong();
                this.f51629f = byteBuffer.getLong();
                this.f51630g = byteBuffer.getLong();
                this.f51631h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2030c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f51632b;

        /* renamed from: c  reason: collision with root package name */
        public final long f51633c;

        /* renamed from: d  reason: collision with root package name */
        public final long f51634d;

        /* renamed from: e  reason: collision with root package name */
        public final long f51635e;

        /* renamed from: f  reason: collision with root package name */
        public final long f51636f;

        /* renamed from: g  reason: collision with root package name */
        public final int f51637g;

        /* renamed from: h  reason: collision with root package name */
        public final int f51638h;

        /* renamed from: i  reason: collision with root package name */
        public final long f51639i;

        /* renamed from: j  reason: collision with root package name */
        public final long f51640j;
        public String k;

        public /* synthetic */ C2030c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C2030c(ByteBuffer byteBuffer, int i2) {
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
                this.f51632b = byteBuffer.getInt();
                this.f51633c = byteBuffer.getInt();
                this.f51634d = byteBuffer.getInt();
                this.f51635e = byteBuffer.getInt();
                this.f51636f = byteBuffer.getInt();
                this.f51637g = byteBuffer.getInt();
                this.f51638h = byteBuffer.getInt();
                this.f51639i = byteBuffer.getInt();
                this.f51640j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f51632b = byteBuffer.getInt();
                this.f51633c = byteBuffer.getLong();
                this.f51634d = byteBuffer.getLong();
                this.f51635e = byteBuffer.getLong();
                this.f51636f = byteBuffer.getLong();
                this.f51637g = byteBuffer.getInt();
                this.f51638h = byteBuffer.getInt();
                this.f51639i = byteBuffer.getLong();
                this.f51640j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.k = null;
        }
    }

    public c(File file) {
        C2030c[] c2030cArr;
        C2030c[] c2030cArr2;
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
        this.f51612b = null;
        this.f51613c = null;
        this.f51614d = null;
        this.f51615e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f51612b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f51612b.f51624j);
        allocate.order(this.f51612b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f51612b.f51620f);
        this.f51613c = new b[this.f51612b.k];
        for (int i4 = 0; i4 < this.f51613c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f51613c[i4] = new b(allocate, this.f51612b.a[4], (byte) 0);
        }
        channel.position(this.f51612b.f51621g);
        allocate.limit(this.f51612b.l);
        this.f51614d = new C2030c[this.f51612b.m];
        int i5 = 0;
        while (true) {
            c2030cArr = this.f51614d;
            if (i5 >= c2030cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f51614d[i5] = new C2030c(allocate, this.f51612b.a[4], (byte) 0);
            i5++;
        }
        short s = this.f51612b.n;
        if (s > 0) {
            C2030c c2030c = c2030cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c2030c.f51636f);
            this.a.getChannel().position(c2030c.f51635e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c2030c.k);
            for (C2030c c2030c2 : this.f51614d) {
                allocate2.position(c2030c2.a);
                String a2 = a(allocate2);
                c2030c2.k = a2;
                this.f51615e.put(a2, c2030c2);
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
            this.f51615e.clear();
            this.f51613c = null;
            this.f51614d = null;
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

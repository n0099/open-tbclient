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
/* loaded from: classes12.dex */
public final class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileInputStream a;

    /* renamed from: b  reason: collision with root package name */
    public a f54491b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f54492c;

    /* renamed from: d  reason: collision with root package name */
    public C1952c[] f54493d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, C1952c> f54494e;

    /* loaded from: classes12.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final short f54495b;

        /* renamed from: c  reason: collision with root package name */
        public final short f54496c;

        /* renamed from: d  reason: collision with root package name */
        public final int f54497d;

        /* renamed from: e  reason: collision with root package name */
        public final long f54498e;

        /* renamed from: f  reason: collision with root package name */
        public final long f54499f;

        /* renamed from: g  reason: collision with root package name */
        public final long f54500g;

        /* renamed from: h  reason: collision with root package name */
        public final int f54501h;

        /* renamed from: i  reason: collision with root package name */
        public final short f54502i;

        /* renamed from: j  reason: collision with root package name */
        public final short f54503j;

        /* renamed from: k  reason: collision with root package name */
        public final short f54504k;
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
                this.f54495b = allocate.getShort();
                this.f54496c = allocate.getShort();
                int i4 = allocate.getInt();
                this.f54497d = i4;
                c.a(i4, 1, "bad elf version: " + this.f54497d);
                byte b4 = this.a[4];
                if (b4 == 1) {
                    this.f54498e = allocate.getInt();
                    this.f54499f = allocate.getInt();
                    this.f54500g = allocate.getInt();
                } else if (b4 == 2) {
                    this.f54498e = allocate.getLong();
                    this.f54499f = allocate.getLong();
                    this.f54500g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f54501h = allocate.getInt();
                this.f54502i = allocate.getShort();
                this.f54503j = allocate.getShort();
                this.f54504k = allocate.getShort();
                this.l = allocate.getShort();
                this.m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.a[0]), Byte.valueOf(this.a[1]), Byte.valueOf(this.a[2]), Byte.valueOf(this.a[3])));
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f54505b;

        /* renamed from: c  reason: collision with root package name */
        public final long f54506c;

        /* renamed from: d  reason: collision with root package name */
        public final long f54507d;

        /* renamed from: e  reason: collision with root package name */
        public final long f54508e;

        /* renamed from: f  reason: collision with root package name */
        public final long f54509f;

        /* renamed from: g  reason: collision with root package name */
        public final long f54510g;

        /* renamed from: h  reason: collision with root package name */
        public final long f54511h;

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
                this.f54506c = byteBuffer.getInt();
                this.f54507d = byteBuffer.getInt();
                this.f54508e = byteBuffer.getInt();
                this.f54509f = byteBuffer.getInt();
                this.f54510g = byteBuffer.getInt();
                this.f54505b = byteBuffer.getInt();
                this.f54511h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f54505b = byteBuffer.getInt();
                this.f54506c = byteBuffer.getLong();
                this.f54507d = byteBuffer.getLong();
                this.f54508e = byteBuffer.getLong();
                this.f54509f = byteBuffer.getLong();
                this.f54510g = byteBuffer.getLong();
                this.f54511h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C1952c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f54512b;

        /* renamed from: c  reason: collision with root package name */
        public final long f54513c;

        /* renamed from: d  reason: collision with root package name */
        public final long f54514d;

        /* renamed from: e  reason: collision with root package name */
        public final long f54515e;

        /* renamed from: f  reason: collision with root package name */
        public final long f54516f;

        /* renamed from: g  reason: collision with root package name */
        public final int f54517g;

        /* renamed from: h  reason: collision with root package name */
        public final int f54518h;

        /* renamed from: i  reason: collision with root package name */
        public final long f54519i;

        /* renamed from: j  reason: collision with root package name */
        public final long f54520j;

        /* renamed from: k  reason: collision with root package name */
        public String f54521k;

        public /* synthetic */ C1952c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        public C1952c(ByteBuffer byteBuffer, int i2) {
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
                this.f54512b = byteBuffer.getInt();
                this.f54513c = byteBuffer.getInt();
                this.f54514d = byteBuffer.getInt();
                this.f54515e = byteBuffer.getInt();
                this.f54516f = byteBuffer.getInt();
                this.f54517g = byteBuffer.getInt();
                this.f54518h = byteBuffer.getInt();
                this.f54519i = byteBuffer.getInt();
                this.f54520j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.f54512b = byteBuffer.getInt();
                this.f54513c = byteBuffer.getLong();
                this.f54514d = byteBuffer.getLong();
                this.f54515e = byteBuffer.getLong();
                this.f54516f = byteBuffer.getLong();
                this.f54517g = byteBuffer.getInt();
                this.f54518h = byteBuffer.getInt();
                this.f54519i = byteBuffer.getLong();
                this.f54520j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.f54521k = null;
        }
    }

    public c(File file) {
        C1952c[] c1952cArr;
        C1952c[] c1952cArr2;
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
        this.f54491b = null;
        this.f54492c = null;
        this.f54493d = null;
        this.f54494e = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f54491b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f54491b.f54503j);
        allocate.order(this.f54491b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f54491b.f54499f);
        this.f54492c = new b[this.f54491b.f54504k];
        for (int i4 = 0; i4 < this.f54492c.length; i4++) {
            b(channel, allocate, "failed to read phdr.");
            this.f54492c[i4] = new b(allocate, this.f54491b.a[4], (byte) 0);
        }
        channel.position(this.f54491b.f54500g);
        allocate.limit(this.f54491b.l);
        this.f54493d = new C1952c[this.f54491b.m];
        int i5 = 0;
        while (true) {
            c1952cArr = this.f54493d;
            if (i5 >= c1952cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f54493d[i5] = new C1952c(allocate, this.f54491b.a[4], (byte) 0);
            i5++;
        }
        short s = this.f54491b.n;
        if (s > 0) {
            C1952c c1952c = c1952cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c1952c.f54516f);
            this.a.getChannel().position(c1952c.f54515e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c1952c.f54521k);
            for (C1952c c1952c2 : this.f54493d) {
                allocate2.position(c1952c2.a);
                String a2 = a(allocate2);
                c1952c2.f54521k = a2;
                this.f54494e.put(a2, c1952c2);
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
            this.f54494e.clear();
            this.f54492c = null;
            this.f54493d = null;
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

package com.bytedance.pangle.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteBuffer a;
        public final byte[] b;

        public a(ByteBuffer byteBuffer, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = byteBuffer;
            this.b = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final ByteBuffer b;
        public final MessageDigest c;
        public final byte[] d;
        public final byte[] e;

        public /* synthetic */ b(byte[] bArr, ByteBuffer byteBuffer, byte b) {
            this(bArr, byteBuffer);
        }

        @Override // com.bytedance.pangle.f.j
        public final void a(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                byteBuffer.position();
                int remaining = byteBuffer.remaining();
                while (remaining > 0) {
                    int min = Math.min(remaining, 4096 - this.a);
                    byteBuffer.limit(byteBuffer.position() + min);
                    this.c.update(byteBuffer);
                    remaining -= min;
                    int i = this.a + min;
                    this.a = i;
                    if (i == 4096) {
                        MessageDigest messageDigest = this.c;
                        byte[] bArr = this.d;
                        messageDigest.digest(bArr, 0, bArr.length);
                        this.b.put(this.d);
                        this.c.update(this.e);
                        this.a = 0;
                    }
                }
            }
        }

        public final void b() {
            int position;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (position = this.b.position() % 4096) == 0) {
                return;
            }
            this.b.put(ByteBuffer.allocate(4096 - position));
        }

        public b(byte[] bArr, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = new byte[32];
            this.e = bArr;
            this.b = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.c = messageDigest;
            messageDigest.update(this.e);
            this.a = 0;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-294140437, "Lcom/bytedance/pangle/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-294140437, "Lcom/bytedance/pangle/f/g;");
                return;
            }
        }
        a = new byte[8];
    }

    public static a a(RandomAccessFile randomAccessFile, m mVar, i iVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, randomAccessFile, mVar, iVar)) == null) {
            int[] a2 = a(randomAccessFile.length() - (mVar.c - mVar.b));
            int i = a2[a2.length - 1];
            int i2 = i + 4096;
            ByteBuffer a3 = iVar.a(i2);
            a3.order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer a4 = a(a3, 0, i);
            int i3 = i + 64;
            ByteBuffer a5 = a(a3, i, i3);
            ByteBuffer a6 = a(a3, i3, i2);
            byte[] bArr = new byte[32];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            long j = mVar.b;
            if (j % 4096 == 0) {
                long j2 = mVar.c;
                if ((j2 - j) % 4096 == 0) {
                    long j3 = j2 - j;
                    int[] a7 = a(randomAccessFile.length() - j3);
                    if (a4 != null) {
                        byte[] a8 = a(randomAccessFile, mVar, a, a7, a4);
                        if (wrap != null) {
                            wrap.put(a8);
                            wrap.flip();
                        }
                    }
                    if (a5 != null) {
                        a5.order(ByteOrder.LITTLE_ENDIAN);
                        long length = randomAccessFile.length();
                        byte[] bArr2 = a;
                        if (bArr2.length == 8) {
                            a5.put("TrueBrew".getBytes());
                            a5.put((byte) 1);
                            a5.put((byte) 0);
                            a5.put((byte) 12);
                            a5.put((byte) 7);
                            a5.putShort((short) 1);
                            a5.putShort((short) 1);
                            a5.putInt(0);
                            a5.putInt(0);
                            a5.putLong(length);
                            a5.put((byte) 2);
                            a5.put((byte) 0);
                            a5.put(bArr2);
                            a(a5, 22);
                            a5.flip();
                        } else {
                            throw new IllegalArgumentException("salt is not 8 bytes long");
                        }
                    }
                    if (a6 != null) {
                        a6.order(ByteOrder.LITTLE_ENDIAN);
                        long j4 = mVar.b;
                        long j5 = mVar.d;
                        a6.putInt(24);
                        a6.putShort((short) 1);
                        a(a6, 2);
                        a6.putLong(j4);
                        a6.putLong(j3);
                        a6.putInt(20);
                        a6.putShort((short) 2);
                        a(a6, 2);
                        a6.putLong(j5 + 16);
                        a6.putInt(c(j4));
                        a(a6, 4);
                        a6.flip();
                    }
                    a3.position(i3 + a6.limit());
                    a3.putInt(a6.limit() + 64 + 4);
                    a3.flip();
                    return new a(a3, bArr);
                }
                throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.c - mVar.b));
            }
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.b);
        }
        return (a) invokeLLL.objValue;
    }

    public static long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) ? ((j + 4096) - 1) / 4096 : invokeJ.longValue;
    }

    public static int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j)) == null) {
            int i = (int) j;
            if (i == j) {
                return i;
            }
            throw new ArithmeticException("integer overflow");
        }
        return invokeJ.intValue;
    }

    public static void a(j jVar, k kVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, jVar, kVar, i) == null) {
            long a2 = kVar.a();
            long j = 0;
            while (a2 > 0) {
                int min = (int) Math.min(a2, i);
                kVar.a(jVar, j, min);
                long j2 = min;
                j += j2;
                a2 -= j2;
            }
        }
    }

    public static byte[] a(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65541, null, randomAccessFile, mVar, bArr, iArr, byteBuffer)) == null) {
            b bVar = new b(bArr, a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), (byte) 0);
            a(bVar, new l(randomAccessFile.getFD(), 0L, mVar.b), 1048576);
            long j = mVar.d + 16;
            FileDescriptor fd = randomAccessFile.getFD();
            long j2 = mVar.c;
            a(bVar, new l(fd, j2, j - j2), 1048576);
            ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
            order.putInt(c(mVar.b));
            order.flip();
            bVar.a(order);
            long j3 = j + 4;
            a(bVar, new l(randomAccessFile.getFD(), j3, randomAccessFile.length() - j3), 1048576);
            int length = (int) (randomAccessFile.length() % 4096);
            if (length != 0) {
                bVar.a(ByteBuffer.allocate(4096 - length));
            }
            bVar.a();
            bVar.b();
            for (int length2 = iArr.length - 3; length2 >= 0; length2--) {
                int i = length2 + 1;
                ByteBuffer a2 = a(byteBuffer, iArr[i], iArr[length2 + 2]);
                ByteBuffer a3 = a(byteBuffer, iArr[length2], iArr[i]);
                h hVar = new h(a2);
                b bVar2 = new b(bArr, a3, (byte) 0);
                a(bVar2, hVar, 4096);
                bVar2.a();
                bVar2.b();
            }
            byte[] bArr2 = new byte[32];
            b bVar3 = new b(bArr, ByteBuffer.wrap(bArr2), (byte) 0);
            bVar3.a(a(byteBuffer, 0, 4096));
            bVar3.a();
            return bArr2;
        }
        return (byte[]) invokeLLLLL.objValue;
    }

    public static int[] a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j)) == null) {
            ArrayList arrayList = new ArrayList();
            do {
                j = b(j) * 32;
                arrayList.add(Long.valueOf(b(j) * 4096));
            } while (j > 4096);
            int[] iArr = new int[arrayList.size() + 1];
            int i = 0;
            iArr[0] = 0;
            while (i < arrayList.size()) {
                int i2 = i + 1;
                iArr[i2] = iArr[i] + c(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
                i = i2;
            }
            return iArr;
        }
        return (int[]) invokeJ.objValue;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, byteBuffer, i, i2)) == null) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.position(0);
            duplicate.limit(i2);
            duplicate.position(i);
            return duplicate.slice();
        }
        return (ByteBuffer) invokeLII.objValue;
    }

    public static void a(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer, i) == null) {
            byteBuffer.position(byteBuffer.position() + i);
        }
    }
}

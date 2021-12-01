package com.bytedance.pangle.f;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes12.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MessageDigest[] a;

        public a(MessageDigest[] messageDigestArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageDigestArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.f.j
        public final void a(ByteBuffer byteBuffer) {
            MessageDigest[] messageDigestArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
                ByteBuffer slice = byteBuffer.slice();
                for (MessageDigest messageDigest : this.a) {
                    slice.position(0);
                    messageDigest.update(slice);
                }
            }
        }
    }

    public static m a(RandomAccessFile randomAccessFile, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, randomAccessFile, i2)) == null) {
            Pair<ByteBuffer, Long> a2 = a(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) a2.first;
            long longValue = ((Long) a2.second).longValue();
            if (!s.a(randomAccessFile, longValue)) {
                long a3 = a(byteBuffer, longValue);
                Pair<ByteBuffer, Long> a4 = a(randomAccessFile, a3);
                return new m(c((ByteBuffer) a4.first, i2), ((Long) a4.second).longValue(), a3, longValue, byteBuffer);
            }
            throw new n("ZIP64 APK not supported");
        }
        return (m) invokeLI.objValue;
    }

    public static int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i2, i3)) == null) {
            if (i2 == 1) {
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        return -1;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i3)));
                }
                return 0;
            } else if (i2 == 2) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return 0;
                    }
                    if (i3 != 3) {
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i3)));
                    }
                }
                return 1;
            } else if (i2 == 3) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            return 0;
                        }
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i3)));
                    }
                    return -1;
                }
                return 1;
            } else {
                throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i2)));
            }
        }
        return invokeII.intValue;
    }

    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
            if (i2 == 513 || i2 == 514) {
                return "EC";
            }
            if (i2 != 769) {
                if (i2 != 1057) {
                    if (i2 != 1059) {
                        if (i2 != 1061) {
                            switch (i2) {
                                case 257:
                                case 258:
                                case 259:
                                case 260:
                                    return "RSA";
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
                            }
                        }
                        return "DSA";
                    }
                    return "EC";
                }
                return "RSA";
            }
            return "DSA";
        }
        return (String) invokeI.objValue;
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) {
            if (i2 != 513) {
                if (i2 != 514) {
                    if (i2 != 769) {
                        if (i2 != 1057) {
                            if (i2 != 1059) {
                                if (i2 != 1061) {
                                    switch (i2) {
                                        case 257:
                                            return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                        case 258:
                                            return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                        case 259:
                                            break;
                                        case 260:
                                            return Pair.create("SHA512withRSA", null);
                                        default:
                                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
                                    }
                                }
                            }
                        }
                        return Pair.create("SHA256withRSA", null);
                    }
                    return Pair.create("SHA256withDSA", null);
                }
                return Pair.create("SHA512withECDSA", null);
            }
            return Pair.create("SHA256withECDSA", null);
        }
        return (Pair) invokeI.objValue;
    }

    public static int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return 32;
                    }
                    throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
                }
                return 64;
            }
            return 32;
        }
        return invokeI.intValue;
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, byteBuffer, i2)) == null) {
            c(byteBuffer);
            ByteBuffer a2 = a(byteBuffer, byteBuffer.capacity() - 24);
            int i3 = 0;
            while (a2.hasRemaining()) {
                i3++;
                if (a2.remaining() >= 8) {
                    long j2 = a2.getLong();
                    if (j2 >= 4 && j2 <= 2147483647L) {
                        int i4 = (int) j2;
                        int position = a2.position() + i4;
                        if (i4 <= a2.remaining()) {
                            if (a2.getInt() == i2) {
                                return b(a2, i4 - 4);
                            }
                            a2.position(position);
                        } else {
                            throw new n("APK Signing Block entry #" + i3 + " size out of range: " + i4 + ", available: " + a2.remaining());
                        }
                    } else {
                        throw new n("APK Signing Block entry #" + i3 + " size out of range: " + j2);
                    }
                } else {
                    throw new n("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i3)));
                }
            }
            throw new n("No block with ID " + i2 + " in APK Signing Block.");
        }
        return (ByteBuffer) invokeLI.objValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return "SHA-256";
                    }
                    throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
                }
                return "SHA-512";
            }
            return "SHA-256";
        }
        return (String) invokeI.objValue;
    }

    public static ByteBuffer b(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, byteBuffer, i2)) == null) {
            if (i2 >= 0) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                int i3 = i2 + position;
                if (i3 >= position && i3 <= limit) {
                    byteBuffer.limit(i3);
                    try {
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        byteBuffer.position(i3);
                        return slice;
                    } finally {
                        byteBuffer.limit(limit);
                    }
                }
                throw new BufferUnderflowException();
            }
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i2)));
        }
        return (ByteBuffer) invokeLI.objValue;
    }

    @RequiresApi(api = 21)
    public static void a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, map, randomAccessFile, mVar) == null) {
            if (!map.isEmpty()) {
                ArrayMap arrayMap = new ArrayMap();
                boolean z = true;
                if (map.containsKey(1)) {
                    arrayMap.put(1, map.get(1));
                }
                if (map.containsKey(2)) {
                    arrayMap.put(2, map.get(2));
                }
                boolean z2 = false;
                if (!arrayMap.isEmpty()) {
                    try {
                        a(arrayMap, randomAccessFile.getFD(), mVar);
                        z = false;
                    } catch (IOException e2) {
                        throw new SecurityException("Cannot get FD", e2);
                    }
                }
                if (map.containsKey(3)) {
                    a(map.get(3), randomAccessFile, mVar);
                } else {
                    z2 = z;
                }
                if (z2) {
                    throw new SecurityException("No known digest exists for integrity check");
                }
                return;
            }
            throw new SecurityException("No digests provided");
        }
    }

    public static byte[] b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, byteBuffer)) == null) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    byte[] bArr = new byte[i2];
                    byteBuffer.get(bArr);
                    return bArr;
                }
                throw new IOException("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
            }
            throw new IOException("Negative length");
        }
        return (byte[]) invokeL.objValue;
    }

    public static void c(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, byteBuffer) == null) && byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static void a(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, map, fileDescriptor, mVar) == null) {
            l lVar = new l(fileDescriptor, 0L, mVar.f54587b);
            long j2 = mVar.f54588c;
            l lVar2 = new l(fileDescriptor, j2, mVar.f54589d - j2);
            ByteBuffer duplicate = mVar.f54590e.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            long j3 = mVar.f54587b;
            s.c(duplicate);
            int position = duplicate.position() + 16;
            if (j3 >= 0 && j3 <= 4294967295L) {
                duplicate.putInt(duplicate.position() + position, (int) j3);
                h hVar = new h(duplicate);
                int size = map.size();
                int[] iArr = new int[size];
                int i2 = 0;
                for (Integer num : map.keySet()) {
                    iArr[i2] = num.intValue();
                    i2++;
                }
                try {
                    byte[][] a2 = a(iArr, new k[]{lVar, lVar2, hVar});
                    for (int i3 = 0; i3 < size; i3++) {
                        int i4 = iArr[i3];
                        if (!MessageDigest.isEqual(map.get(Integer.valueOf(i4)), a2[i3])) {
                            throw new SecurityException(b(i4) + " digest of contents did not verify");
                        }
                    }
                    return;
                } catch (DigestException e2) {
                    throw new SecurityException("Failed to compute digest(s) of contents", e2);
                }
            }
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j3)));
        }
    }

    public static byte[][] a(int[] iArr, k[] kVarArr) {
        InterceptResult invokeLL;
        int i2;
        long j2;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, iArr, kVarArr)) == null) {
            long j3 = 0;
            long j4 = 0;
            int i3 = 0;
            while (true) {
                i2 = 3;
                j2 = 1048576;
                if (i3 >= 3) {
                    break;
                }
                j4 += ((kVarArr[i3].a() + 1048576) - 1) / 1048576;
                i3++;
            }
            if (j4 < 2097151) {
                int i4 = (int) j4;
                byte[][] bArr = new byte[iArr.length];
                for (int i5 = 0; i5 < iArr.length; i5++) {
                    byte[] bArr2 = new byte[(e(iArr[i5]) * i4) + 5];
                    bArr2[0] = 90;
                    a(i4, bArr2);
                    bArr[i5] = bArr2;
                }
                byte[] bArr3 = new byte[5];
                bArr3[0] = -91;
                int length = iArr.length;
                MessageDigest[] messageDigestArr = new MessageDigest[length];
                for (int i6 = 0; i6 < iArr.length; i6++) {
                    String b2 = b(iArr[i6]);
                    try {
                        messageDigestArr[i6] = MessageDigest.getInstance(b2);
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(b2 + " digest not supported", e2);
                    }
                }
                a aVar = new a(messageDigestArr);
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i7 < i2) {
                    k kVar = kVarArr[i7];
                    long j5 = j3;
                    int i10 = i9;
                    a aVar2 = aVar;
                    long a2 = kVar.a();
                    while (a2 > j3) {
                        int min = (int) Math.min(a2, j2);
                        a(min, bArr3);
                        for (int i11 = 0; i11 < length; i11++) {
                            messageDigestArr[i11].update(bArr3);
                        }
                        a aVar3 = aVar2;
                        long j6 = j5;
                        try {
                            kVar.a(aVar3, j6, min);
                            aVar2 = aVar3;
                            k kVar2 = kVar;
                            int i12 = 0;
                            while (i12 < iArr.length) {
                                int i13 = iArr[i12];
                                byte[] bArr4 = bArr3;
                                byte[] bArr5 = bArr[i12];
                                int e3 = e(i13);
                                int i14 = length;
                                MessageDigest[] messageDigestArr2 = messageDigestArr;
                                int digest = messageDigestArr[i12].digest(bArr5, (i10 * e3) + 5, e3);
                                if (digest != e3) {
                                    throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                                }
                                i12++;
                                bArr3 = bArr4;
                                length = i14;
                                messageDigestArr = messageDigestArr2;
                            }
                            long j7 = min;
                            long j8 = j6 + j7;
                            a2 -= j7;
                            i10++;
                            j3 = 0;
                            j2 = 1048576;
                            kVar = kVar2;
                            bArr3 = bArr3;
                            j5 = j8;
                        } catch (IOException e4) {
                            throw new DigestException("Failed to digest chunk #" + i10 + " of section #" + i8, e4);
                        }
                    }
                    i8++;
                    i7++;
                    i9 = i10;
                    aVar = aVar2;
                    j3 = 0;
                    i2 = 3;
                    j2 = 1048576;
                }
                byte[][] bArr6 = new byte[iArr.length];
                for (int i15 = 0; i15 < iArr.length; i15++) {
                    int i16 = iArr[i15];
                    byte[] bArr7 = bArr[i15];
                    String b3 = b(i16);
                    try {
                        bArr6[i15] = MessageDigest.getInstance(b3).digest(bArr7);
                    } catch (NoSuchAlgorithmException e5) {
                        throw new RuntimeException(b3 + " digest not supported", e5);
                    }
                }
                return bArr6;
            }
            throw new DigestException("Too many chunks: ".concat(String.valueOf(j4)));
        }
        return (byte[][]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, long j2, m mVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{bArr, Long.valueOf(j2), mVar})) == null) {
            if (bArr.length == 40) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                order.position(32);
                if (order.getLong() == j2 - (mVar.f54588c - mVar.f54587b)) {
                    return Arrays.copyOfRange(bArr, 0, 32);
                }
                throw new SecurityException("APK content size did not verify");
            }
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static void a(byte[] bArr, RandomAccessFile randomAccessFile, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, bArr, randomAccessFile, mVar) == null) {
            try {
                if (Arrays.equals(a(bArr, randomAccessFile.length(), mVar), g.a(randomAccessFile, mVar, new i() { // from class: com.bytedance.pangle.f.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.pangle.f.i
                    public final ByteBuffer a(int i2) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) ? ByteBuffer.allocate(i2) : (ByteBuffer) invokeI.objValue;
                    }
                }).f54579b)) {
                    return;
                }
                throw new SecurityException("APK verity digest of contents did not verify");
            } catch (IOException | DigestException | NoSuchAlgorithmException e2) {
                throw new SecurityException("Error during verification", e2);
            }
        }
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, randomAccessFile)) == null) {
            Pair<ByteBuffer, Long> a2 = s.a(randomAccessFile);
            if (a2 != null) {
                return a2;
            }
            throw new n("Not an APK file: ZIP End of Central Directory record not found");
        }
        return (Pair) invokeL.objValue;
    }

    public static long a(ByteBuffer byteBuffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, byteBuffer, j2)) == null) {
            long a2 = s.a(byteBuffer);
            if (a2 <= j2) {
                if (s.b(byteBuffer) + a2 == j2) {
                    return a2;
                }
                throw new n("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            throw new n("ZIP Central Directory offset out of range: " + a2 + ". ZIP End of Central Directory offset: " + j2);
        }
        return invokeLJ.longValue;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) ? b(a(i2), a(i3)) : invokeII.intValue;
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 513) {
                if (i2 != 514) {
                    if (i2 != 769) {
                        if (i2 == 1057 || i2 == 1059 || i2 == 1061) {
                            return 3;
                        }
                        switch (i2) {
                            case 257:
                            case 259:
                                return 1;
                            case 258:
                            case 260:
                                return 2;
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
                        }
                    }
                    return 1;
                }
                return 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, byteBuffer, i2)) == null) {
            if (i2 >= 8) {
                int capacity = byteBuffer.capacity();
                if (i2 <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(i2);
                        byteBuffer.position(8);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        return slice;
                    } finally {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                    }
                }
                throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
            }
            throw new IllegalArgumentException("end < start: " + i2 + " < 8");
        }
        return (ByteBuffer) invokeLI.objValue;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, byteBuffer)) == null) {
            if (byteBuffer.remaining() >= 4) {
                int i2 = byteBuffer.getInt();
                if (i2 >= 0) {
                    if (i2 <= byteBuffer.remaining()) {
                        return b(byteBuffer, i2);
                    }
                    throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Negative length");
            }
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static void a(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i2, bArr) == null) {
            bArr[1] = (byte) (i2 & 255);
            bArr[2] = (byte) ((i2 >>> 8) & 255);
            bArr[3] = (byte) ((i2 >>> 16) & 255);
            bArr[4] = (byte) ((i2 >>> 24) & 255);
        }
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, randomAccessFile, j2)) == null) {
            if (j2 >= 32) {
                ByteBuffer allocate = ByteBuffer.allocate(24);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.seek(j2 - allocate.capacity());
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (allocate.getLong(8) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
                    long j3 = allocate.getLong(0);
                    if (j3 < allocate.capacity() || j3 > 2147483639) {
                        throw new n("APK Signing Block size out of range: ".concat(String.valueOf(j3)));
                    }
                    int i2 = (int) (8 + j3);
                    long j4 = j2 - i2;
                    if (j4 >= 0) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                        allocate2.order(ByteOrder.LITTLE_ENDIAN);
                        randomAccessFile.seek(j4);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        long j5 = allocate2.getLong(0);
                        if (j5 == j3) {
                            return Pair.create(allocate2, Long.valueOf(j4));
                        }
                        throw new n("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
                    }
                    throw new n("APK Signing Block offset out of range: ".concat(String.valueOf(j4)));
                }
                throw new n("No APK Signing Block before ZIP Central Directory");
            }
            throw new n("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j2)));
        }
        return (Pair) invokeLJ.objValue;
    }
}

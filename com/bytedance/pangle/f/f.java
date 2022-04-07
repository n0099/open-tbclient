package com.bytedance.pangle.f;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
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
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    public static m a(RandomAccessFile randomAccessFile, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, randomAccessFile, i)) == null) {
            Pair<ByteBuffer, Long> a2 = a(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) a2.first;
            long longValue = ((Long) a2.second).longValue();
            if (!s.a(randomAccessFile, longValue)) {
                long a3 = a(byteBuffer, longValue);
                Pair<ByteBuffer, Long> a4 = a(randomAccessFile, a3);
                return new m(c((ByteBuffer) a4.first, i), ((Long) a4.second).longValue(), a3, longValue, byteBuffer);
            }
            throw new n("ZIP64 APK not supported");
        }
        return (m) invokeLI.objValue;
    }

    public static int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i, i2)) == null) {
            if (i == 1) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return -1;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
                return 0;
            } else if (i == 2) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return 0;
                    }
                    if (i2 != 3) {
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                    }
                }
                return 1;
            } else if (i == 3) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return 0;
                        }
                        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                    }
                    return -1;
                }
                return 1;
            } else {
                throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
            }
        }
        return invokeII.intValue;
    }

    public static String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            if (i == 513 || i == 514) {
                return "EC";
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                                case 260:
                                    return RSAUtil.ALGORITHM_RSA;
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                            }
                        }
                        return "DSA";
                    }
                    return "EC";
                }
                return RSAUtil.ALGORITHM_RSA;
            }
            return "DSA";
        }
        return (String) invokeI.objValue;
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i)) == null) {
            if (i != 513) {
                if (i != 514) {
                    if (i != 769) {
                        if (i != 1057) {
                            if (i != 1059) {
                                if (i != 1061) {
                                    switch (i) {
                                        case 257:
                                            return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                                            return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                                            break;
                                        case 260:
                                            return Pair.create("SHA512withRSA", null);
                                        default:
                                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
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

    public static int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return 32;
                    }
                    throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
                }
                return 64;
            }
            return 32;
        }
        return invokeI.intValue;
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, byteBuffer, i)) == null) {
            c(byteBuffer);
            ByteBuffer a2 = a(byteBuffer, byteBuffer.capacity() - 24);
            int i2 = 0;
            while (a2.hasRemaining()) {
                i2++;
                if (a2.remaining() >= 8) {
                    long j = a2.getLong();
                    if (j >= 4 && j <= 2147483647L) {
                        int i3 = (int) j;
                        int position = a2.position() + i3;
                        if (i3 <= a2.remaining()) {
                            if (a2.getInt() == i) {
                                return b(a2, i3 - 4);
                            }
                            a2.position(position);
                        } else {
                            throw new n("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + a2.remaining());
                        }
                    } else {
                        throw new n("APK Signing Block entry #" + i2 + " size out of range: " + j);
                    }
                } else {
                    throw new n("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
                }
            }
            throw new n("No block with ID " + i + " in APK Signing Block.");
        }
        return (ByteBuffer) invokeLI.objValue;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return "SHA-256";
                    }
                    throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
                }
                return "SHA-512";
            }
            return "SHA-256";
        }
        return (String) invokeI.objValue;
    }

    public static ByteBuffer b(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, byteBuffer, i)) == null) {
            if (i >= 0) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                int i2 = i + position;
                if (i2 >= position && i2 <= limit) {
                    byteBuffer.limit(i2);
                    try {
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        byteBuffer.position(i2);
                        return slice;
                    } finally {
                        byteBuffer.limit(limit);
                    }
                }
                throw new BufferUnderflowException();
            }
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
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
                    } catch (IOException e) {
                        throw new SecurityException("Cannot get FD", e);
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
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    byte[] bArr = new byte[i];
                    byteBuffer.get(bArr);
                    return bArr;
                }
                throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
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
            l lVar = new l(fileDescriptor, 0L, mVar.b);
            long j = mVar.c;
            l lVar2 = new l(fileDescriptor, j, mVar.d - j);
            ByteBuffer duplicate = mVar.e.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            long j2 = mVar.b;
            s.c(duplicate);
            int position = duplicate.position() + 16;
            if (j2 >= 0 && j2 <= 4294967295L) {
                duplicate.putInt(duplicate.position() + position, (int) j2);
                h hVar = new h(duplicate);
                int size = map.size();
                int[] iArr = new int[size];
                int i = 0;
                for (Integer num : map.keySet()) {
                    iArr[i] = num.intValue();
                    i++;
                }
                try {
                    byte[][] a2 = a(iArr, new k[]{lVar, lVar2, hVar});
                    for (int i2 = 0; i2 < size; i2++) {
                        int i3 = iArr[i2];
                        if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), a2[i2])) {
                            throw new SecurityException(b(i3) + " digest of contents did not verify");
                        }
                    }
                    return;
                } catch (DigestException e) {
                    throw new SecurityException("Failed to compute digest(s) of contents", e);
                }
            }
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j2)));
        }
    }

    public static byte[][] a(int[] iArr, k[] kVarArr) {
        InterceptResult invokeLL;
        int i;
        long j;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, iArr, kVarArr)) == null) {
            long j2 = 0;
            long j3 = 0;
            int i2 = 0;
            while (true) {
                i = 3;
                j = 1048576;
                if (i2 >= 3) {
                    break;
                }
                j3 += ((kVarArr[i2].a() + 1048576) - 1) / 1048576;
                i2++;
            }
            if (j3 < 2097151) {
                int i3 = (int) j3;
                byte[][] bArr = new byte[iArr.length];
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    byte[] bArr2 = new byte[(e(iArr[i4]) * i3) + 5];
                    bArr2[0] = 90;
                    a(i3, bArr2);
                    bArr[i4] = bArr2;
                }
                byte[] bArr3 = new byte[5];
                bArr3[0] = -91;
                int length = iArr.length;
                MessageDigest[] messageDigestArr = new MessageDigest[length];
                for (int i5 = 0; i5 < iArr.length; i5++) {
                    String b = b(iArr[i5]);
                    try {
                        messageDigestArr[i5] = MessageDigest.getInstance(b);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(b + " digest not supported", e);
                    }
                }
                a aVar = new a(messageDigestArr);
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i6 < i) {
                    k kVar = kVarArr[i6];
                    long j4 = j2;
                    int i9 = i8;
                    a aVar2 = aVar;
                    long a2 = kVar.a();
                    while (a2 > j2) {
                        int min = (int) Math.min(a2, j);
                        a(min, bArr3);
                        for (int i10 = 0; i10 < length; i10++) {
                            messageDigestArr[i10].update(bArr3);
                        }
                        a aVar3 = aVar2;
                        long j5 = j4;
                        try {
                            kVar.a(aVar3, j5, min);
                            aVar2 = aVar3;
                            k kVar2 = kVar;
                            int i11 = 0;
                            while (i11 < iArr.length) {
                                int i12 = iArr[i11];
                                byte[] bArr4 = bArr3;
                                byte[] bArr5 = bArr[i11];
                                int e2 = e(i12);
                                int i13 = length;
                                MessageDigest[] messageDigestArr2 = messageDigestArr;
                                int digest = messageDigestArr[i11].digest(bArr5, (i9 * e2) + 5, e2);
                                if (digest != e2) {
                                    throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                                }
                                i11++;
                                bArr3 = bArr4;
                                length = i13;
                                messageDigestArr = messageDigestArr2;
                            }
                            long j6 = min;
                            long j7 = j5 + j6;
                            a2 -= j6;
                            i9++;
                            j2 = 0;
                            j = 1048576;
                            kVar = kVar2;
                            bArr3 = bArr3;
                            j4 = j7;
                        } catch (IOException e3) {
                            throw new DigestException("Failed to digest chunk #" + i9 + " of section #" + i7, e3);
                        }
                    }
                    i7++;
                    i6++;
                    i8 = i9;
                    aVar = aVar2;
                    j2 = 0;
                    i = 3;
                    j = 1048576;
                }
                byte[][] bArr6 = new byte[iArr.length];
                for (int i14 = 0; i14 < iArr.length; i14++) {
                    int i15 = iArr[i14];
                    byte[] bArr7 = bArr[i14];
                    String b2 = b(i15);
                    try {
                        bArr6[i14] = MessageDigest.getInstance(b2).digest(bArr7);
                    } catch (NoSuchAlgorithmException e4) {
                        throw new RuntimeException(b2 + " digest not supported", e4);
                    }
                }
                return bArr6;
            }
            throw new DigestException("Too many chunks: ".concat(String.valueOf(j3)));
        }
        return (byte[][]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, long j, m mVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{bArr, Long.valueOf(j), mVar})) == null) {
            if (bArr.length == 40) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                order.position(32);
                if (order.getLong() == j - (mVar.c - mVar.b)) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.pangle.f.i
                    public final ByteBuffer a(int i) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) ? ByteBuffer.allocate(i) : (ByteBuffer) invokeI.objValue;
                    }
                }).b)) {
                    return;
                }
                throw new SecurityException("APK verity digest of contents did not verify");
            } catch (IOException | DigestException | NoSuchAlgorithmException e) {
                throw new SecurityException("Error during verification", e);
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

    public static long a(ByteBuffer byteBuffer, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, byteBuffer, j)) == null) {
            long a2 = s.a(byteBuffer);
            if (a2 <= j) {
                if (s.b(byteBuffer) + a2 == j) {
                    return a2;
                }
                throw new n("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            throw new n("ZIP Central Directory offset out of range: " + a2 + ". ZIP End of Central Directory offset: " + j);
        }
        return invokeLJ.longValue;
    }

    public static int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i, i2)) == null) ? b(a(i), a(i2)) : invokeII.intValue;
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i != 513) {
                if (i != 514) {
                    if (i != 769) {
                        if (i == 1057 || i == 1059 || i == 1061) {
                            return 3;
                        }
                        switch (i) {
                            case 257:
                            case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                                return 1;
                            case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                            case 260:
                                return 2;
                            default:
                                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
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

    public static ByteBuffer a(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, byteBuffer, i)) == null) {
            if (i >= 8) {
                int capacity = byteBuffer.capacity();
                if (i <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(i);
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
                throw new IllegalArgumentException("end > capacity: " + i + " > " + capacity);
            }
            throw new IllegalArgumentException("end < start: " + i + " < 8");
        }
        return (ByteBuffer) invokeLI.objValue;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, byteBuffer)) == null) {
            if (byteBuffer.remaining() >= 4) {
                int i = byteBuffer.getInt();
                if (i >= 0) {
                    if (i <= byteBuffer.remaining()) {
                        return b(byteBuffer, i);
                    }
                    throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Negative length");
            }
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static void a(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, bArr) == null) {
            bArr[1] = (byte) (i & 255);
            bArr[2] = (byte) ((i >>> 8) & 255);
            bArr[3] = (byte) ((i >>> 16) & 255);
            bArr[4] = (byte) ((i >>> 24) & 255);
        }
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, randomAccessFile, j)) == null) {
            if (j >= 32) {
                ByteBuffer allocate = ByteBuffer.allocate(24);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.seek(j - allocate.capacity());
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (allocate.getLong(8) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
                    long j2 = allocate.getLong(0);
                    if (j2 < allocate.capacity() || j2 > 2147483639) {
                        throw new n("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
                    }
                    int i = (int) (8 + j2);
                    long j3 = j - i;
                    if (j3 >= 0) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(i);
                        allocate2.order(ByteOrder.LITTLE_ENDIAN);
                        randomAccessFile.seek(j3);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        long j4 = allocate2.getLong(0);
                        if (j4 == j2) {
                            return Pair.create(allocate2, Long.valueOf(j3));
                        }
                        throw new n("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                    }
                    throw new n("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
                }
                throw new n("No APK Signing Block before ZIP Central Directory");
            }
            throw new n("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
        }
        return (Pair) invokeLJ.objValue;
    }
}

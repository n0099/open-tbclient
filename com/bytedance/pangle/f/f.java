package com.bytedance.pangle.f;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes9.dex */
public final class f {
    public static final HashMap<String, SparseArray<m>> a = new HashMap<>();

    /* loaded from: classes9.dex */
    public static class a implements j {
        public final MessageDigest[] a;

        public a(MessageDigest[] messageDigestArr) {
            this.a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.f.j
        public final void a(ByteBuffer byteBuffer) {
            MessageDigest[] messageDigestArr;
            ByteBuffer slice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.a) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    public static int a(int i) {
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

    public static String c(int i) {
        if (i != 513 && i != 514) {
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                                case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                                case 260:
                                    return "RSA";
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
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
        return "EC";
    }

    public static int a(int i, int i2) {
        int a2 = a(i);
        int a3 = a(i2);
        if (a2 != 1) {
            if (a2 != 2) {
                if (a2 == 3) {
                    if (a3 == 1) {
                        return 1;
                    }
                    if (a3 == 2) {
                        return -1;
                    }
                    if (a3 == 3) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(a2)));
            }
            if (a3 != 1) {
                if (a3 == 2) {
                    return 0;
                }
                if (a3 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
                }
            }
            return 1;
        } else if (a3 == 1) {
            return 0;
        } else {
            if (a3 == 2 || a3 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(a3)));
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
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

    public static ByteBuffer a(ByteBuffer byteBuffer, int i) {
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

    public static void a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) ((i >>> 24) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0237  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, RandomAccessFile randomAccessFile, int... iArr) {
        Pair<ByteBuffer, Long> a2;
        boolean z;
        ByteBuffer byteBuffer;
        Pair pair;
        long j;
        long j2;
        String str2 = str;
        a.put(str2, new SparseArray<>());
        if (randomAccessFile.length() < 22) {
            a2 = null;
        } else {
            a2 = s.a(randomAccessFile, 0);
            if (a2 == null) {
                a2 = s.a(randomAccessFile, 65535);
            }
        }
        if (a2 != null) {
            ByteBuffer byteBuffer2 = (ByteBuffer) a2.first;
            long longValue = ((Long) a2.second).longValue();
            long j3 = longValue - 20;
            if (j3 >= 0) {
                randomAccessFile.seek(j3);
                if (randomAccessFile.readInt() == 1347094023) {
                    z = true;
                    if (z) {
                        s.a(byteBuffer2);
                        long a3 = s.a(byteBuffer2, byteBuffer2.position() + 16);
                        if (a3 <= longValue) {
                            s.a(byteBuffer2);
                            if (s.a(byteBuffer2, byteBuffer2.position() + 12) + a3 == longValue) {
                                if (a3 >= 32) {
                                    ByteBuffer allocate = ByteBuffer.allocate(24);
                                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                                    randomAccessFile.seek(a3 - allocate.capacity());
                                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                                    if (allocate.getLong(8) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
                                        long j4 = allocate.getLong(0);
                                        if (j4 >= allocate.capacity() && j4 <= 2147483639) {
                                            int i = (int) (8 + j4);
                                            byteBuffer = byteBuffer2;
                                            long j5 = a3 - i;
                                            if (j5 >= 0) {
                                                ByteBuffer allocate2 = ByteBuffer.allocate(i);
                                                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                                                randomAccessFile.seek(j5);
                                                randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                                                long j6 = allocate2.getLong(0);
                                                if (j6 == j4) {
                                                    pair = Pair.create(allocate2, Long.valueOf(j5));
                                                } else {
                                                    throw new n("APK Signing Block sizes in header and footer do not match: " + j6 + " vs " + j4);
                                                }
                                            } else {
                                                throw new n("APK Signing Block offset out of range: ".concat(String.valueOf(j5)));
                                            }
                                        } else {
                                            throw new n("APK Signing Block size out of range: ".concat(String.valueOf(j4)));
                                        }
                                    } else {
                                        byteBuffer = byteBuffer2;
                                        pair = null;
                                    }
                                    if (pair == null) {
                                        return;
                                    }
                                    ByteBuffer byteBuffer3 = (ByteBuffer) pair.first;
                                    long longValue2 = ((Long) pair.second).longValue();
                                    if (byteBuffer3.order() == ByteOrder.LITTLE_ENDIAN) {
                                        ByteBuffer a4 = a(byteBuffer3, byteBuffer3.capacity() - 24);
                                        HashSet hashSet = new HashSet();
                                        for (int i2 = 0; i2 < 2; i2++) {
                                            hashSet.add(Integer.valueOf(iArr[i2]));
                                        }
                                        for (int i3 = 8; a4.hasRemaining() && a4.remaining() >= i3; i3 = 8) {
                                            long j7 = a4.getLong();
                                            if (j7 >= 4 && j7 <= 2147483647L) {
                                                int i4 = (int) j7;
                                                int position = a4.position() + i4;
                                                if (i4 > a4.remaining()) {
                                                    return;
                                                }
                                                int i5 = a4.getInt();
                                                if (hashSet.contains(Integer.valueOf(i5))) {
                                                    j = a3;
                                                    j2 = longValue;
                                                    a.get(str2).put(i5, new m(b(a4, i4 - 4), longValue2, a3, longValue, byteBuffer));
                                                } else {
                                                    j = a3;
                                                    j2 = longValue;
                                                }
                                                a4.position(position);
                                                str2 = str;
                                                a3 = j;
                                                longValue = j2;
                                            } else {
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                                }
                                throw new n("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(a3)));
                            }
                            throw new n("ZIP Central Directory is not immediately followed by End of Central Directory");
                        }
                        throw new n("ZIP Central Directory offset out of range: " + a3 + ". ZIP End of Central Directory offset: " + longValue);
                    }
                    throw new n("ZIP64 APK not supported");
                }
            }
            z = false;
            if (z) {
            }
        } else {
            throw new n("Not an APK file: ZIP End of Central Directory record not found");
        }
    }

    public static void a(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, m mVar) {
        l lVar = new l(fileDescriptor, 0L, mVar.b);
        long j = mVar.c;
        l lVar2 = new l(fileDescriptor, j, mVar.d - j);
        ByteBuffer duplicate = mVar.e.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        long j2 = mVar.b;
        s.a(duplicate);
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

    @RequiresApi(api = 21)
    public static void a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, m mVar) {
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
                try {
                    if (!Arrays.equals(a(map.get(3), randomAccessFile.length(), mVar), g.a(randomAccessFile, mVar, new i() { // from class: com.bytedance.pangle.f.f.1
                        @Override // com.bytedance.pangle.f.i
                        public final ByteBuffer a(int i) {
                            return ByteBuffer.allocate(i);
                        }
                    }).b)) {
                        throw new SecurityException("APK verity digest of contents did not verify");
                    }
                } catch (IOException | DigestException | NoSuchAlgorithmException e2) {
                    throw new SecurityException("Error during verification", e2);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                return;
            }
            throw new SecurityException("No known digest exists for integrity check");
        }
        throw new SecurityException("No digests provided");
    }

    public static byte[] a(byte[] bArr, long j, m mVar) {
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

    public static byte[][] a(int[] iArr, k[] kVarArr) {
        int i;
        long j;
        MessageDigest messageDigest;
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
                            if (digest == e2) {
                                i11++;
                                bArr3 = bArr4;
                                length = i13;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
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

    public static String b(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
                }
                return "SHA-256";
            }
            return "SHA-512";
        }
        return "SHA-256";
    }

    public static int e(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
                }
                return 32;
            }
            return 64;
        }
        return 32;
    }

    public static ByteBuffer b(ByteBuffer byteBuffer, int i) {
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

    public static byte[] b(ByteBuffer byteBuffer) {
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

    public static Pair<String, ? extends AlgorithmParameterSpec> d(int i) {
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
}

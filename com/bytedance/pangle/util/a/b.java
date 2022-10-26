package com.bytedance.pangle.util.a;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.bytedance.pangle.util.e;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1350639546, "Lcom/bytedance/pangle/util/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1350639546, "Lcom/bytedance/pangle/util/a/b;");
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, byteBuffer, i)) == null) {
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

    public static boolean a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, byteBuffer)) == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                ByteBuffer a2 = a(byteBuffer, byteBuffer.capacity() - 24);
                int i = 0;
                while (a2.hasRemaining()) {
                    i++;
                    if (a2.remaining() >= 8) {
                        long j = a2.getLong();
                        if (j >= 4 && j <= 2147483647L) {
                            int i2 = (int) j;
                            int position = a2.position() + i2;
                            if (i2 <= a2.remaining()) {
                                int i3 = a2.getInt();
                                if (i3 == -262969152) {
                                    a = "V3";
                                    return true;
                                } else if (i3 == 1896449818) {
                                    a = "V2";
                                    return true;
                                } else {
                                    a2.position(position);
                                }
                            } else {
                                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + a2.remaining());
                            }
                        } else {
                            throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
                        }
                    } else {
                        throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:5:0x0008, B:13:0x002d, B:15:0x0043, B:20:0x0054, B:22:0x0066, B:26:0x007e, B:28:0x00b1, B:30:0x00be, B:34:0x00d2, B:36:0x00dc, B:38:0x00ff, B:40:0x0111, B:42:0x0125, B:43:0x0140, B:44:0x0141, B:45:0x0150, B:46:0x0151, B:47:0x0160, B:48:0x0161, B:49:0x0168, B:50:0x0169, B:51:0x0178, B:52:0x0179, B:53:0x0180, B:54:0x0181, B:55:0x019c, B:56:0x019d, B:57:0x01a4, B:58:0x01a5, B:59:0x01ac, B:8:0x001d, B:11:0x0024), top: B:67:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019d A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:5:0x0008, B:13:0x002d, B:15:0x0043, B:20:0x0054, B:22:0x0066, B:26:0x007e, B:28:0x00b1, B:30:0x00be, B:34:0x00d2, B:36:0x00dc, B:38:0x00ff, B:40:0x0111, B:42:0x0125, B:43:0x0140, B:44:0x0141, B:45:0x0150, B:46:0x0151, B:47:0x0160, B:48:0x0161, B:49:0x0168, B:50:0x0169, B:51:0x0178, B:52:0x0179, B:53:0x0180, B:54:0x0181, B:55:0x019c, B:56:0x019d, B:57:0x01a4, B:58:0x01a5, B:59:0x01ac, B:8:0x001d, B:11:0x0024), top: B:67:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] a(File file) {
        InterceptResult invokeL;
        String str;
        RandomAccessFile randomAccessFile;
        Pair a2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            String str2 = "";
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                if (randomAccessFile.length() < 22) {
                    a2 = null;
                } else {
                    a2 = c.a(randomAccessFile, 0);
                    if (a2 == null) {
                        a2 = c.a(randomAccessFile, 65535);
                    }
                }
            } catch (Exception unused) {
                str = "";
            }
            if (a2 != null) {
                ByteBuffer byteBuffer = (ByteBuffer) a2.first;
                long longValue = ((Long) a2.second).longValue();
                long j = longValue - 20;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        z = true;
                        if (z) {
                            c.a(byteBuffer);
                            long a3 = c.a(byteBuffer, byteBuffer.position() + 16);
                            if (a3 <= longValue) {
                                c.a(byteBuffer);
                                if (c.a(byteBuffer, byteBuffer.position() + 12) + a3 == longValue) {
                                    if (a3 >= 32) {
                                        ByteBuffer allocate = ByteBuffer.allocate(24);
                                        allocate.order(ByteOrder.LITTLE_ENDIAN);
                                        randomAccessFile.seek(a3 - allocate.capacity());
                                        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                                        if (allocate.getLong(8) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
                                            long j2 = allocate.getLong(0);
                                            if (j2 >= allocate.capacity() && j2 <= 2147483639) {
                                                int i = (int) (8 + j2);
                                                long j3 = a3 - i;
                                                if (j3 >= 0) {
                                                    ByteBuffer allocate2 = ByteBuffer.allocate(i);
                                                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                                                    randomAccessFile.seek(j3);
                                                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                                                    long j4 = allocate2.getLong(0);
                                                    if (j4 == j2) {
                                                        ByteBuffer byteBuffer2 = (ByteBuffer) Pair.create(allocate2, Long.valueOf(j3)).first;
                                                        if (a(byteBuffer2)) {
                                                            String a4 = e.a(byteBuffer2.array());
                                                            str = "";
                                                            str2 = a4;
                                                        } else {
                                                            str = "without v2 & v3 signature.";
                                                        }
                                                        return new String[]{str2, a, str};
                                                    }
                                                    throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                                                }
                                                throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
                                            }
                                            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
                                        }
                                        throw new Exception("No APK Signing Block before ZIP Central Directory");
                                    }
                                    throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(a3)));
                                }
                                throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
                            }
                            throw new Exception("ZIP Central Directory offset out of range: " + a3 + ". ZIP End of Central Directory offset: " + longValue);
                        }
                        throw new Exception("ZIP64 APK not supported");
                    }
                }
                z = false;
                if (z) {
                }
            } else {
                throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
            }
        } else {
            return (String[]) invokeL.objValue;
        }
    }
}

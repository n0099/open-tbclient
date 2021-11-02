package com.bytedance.pangle.f;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
/* loaded from: classes11.dex */
public abstract class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, randomAccessFile)) == null) {
            if (randomAccessFile.length() < 22) {
                return null;
            }
            Pair<ByteBuffer, Long> a2 = a(randomAccessFile, 0);
            return a2 != null ? a2 : a(randomAccessFile, 65535);
        }
        return (Pair) invokeL.objValue;
    }

    public static long b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, byteBuffer)) == null) {
            c(byteBuffer);
            return a(byteBuffer, byteBuffer.position() + 12);
        }
        return invokeL.longValue;
    }

    public static void c(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, byteBuffer) == null) && byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int d(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            c(byteBuffer);
            int capacity = byteBuffer.capacity();
            if (capacity < 22) {
                return -1;
            }
            int i2 = capacity - 22;
            int min = Math.min(i2, 65535);
            for (int i3 = 0; i3 <= min; i3++) {
                int i4 = i2 - i3;
                if (byteBuffer.getInt(i4) == 101010256 && (byteBuffer.getShort(i4 + 20) & UShort.MAX_VALUE) == i3) {
                    return i4;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, randomAccessFile, i2)) == null) {
            if (i2 >= 0 && i2 <= 65535) {
                long length = randomAccessFile.length();
                if (length < 22) {
                    return null;
                }
                ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                long capacity = length - allocate.capacity();
                randomAccessFile.seek(capacity);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                int d2 = d(allocate);
                if (d2 == -1) {
                    return null;
                }
                allocate.position(d2);
                ByteBuffer slice = allocate.slice();
                slice.order(ByteOrder.LITTLE_ENDIAN);
                return Pair.create(slice, Long.valueOf(capacity + d2));
            }
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i2)));
        }
        return (Pair) invokeLI.objValue;
    }

    public static final boolean a(RandomAccessFile randomAccessFile, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, randomAccessFile, j)) == null) {
            long j2 = j - 20;
            if (j2 < 0) {
                return false;
            }
            randomAccessFile.seek(j2);
            return randomAccessFile.readInt() == 1347094023;
        }
        return invokeLJ.booleanValue;
    }

    public static long a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, byteBuffer)) == null) {
            c(byteBuffer);
            return a(byteBuffer, byteBuffer.position() + 16);
        }
        return invokeL.longValue;
    }

    public static long a(ByteBuffer byteBuffer, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, byteBuffer, i2)) == null) ? byteBuffer.getInt(i2) & 4294967295L : invokeLI.longValue;
    }
}

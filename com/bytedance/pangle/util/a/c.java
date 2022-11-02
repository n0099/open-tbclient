package com.bytedance.pangle.util.a;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;
import kotlin.UShort;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, byteBuffer, i)) == null) {
            return byteBuffer.getInt(i) & 4294967295L;
        }
        return invokeLI.longValue;
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, randomAccessFile, i)) == null) {
            if (i >= 0 && i <= 65535) {
                long length = randomAccessFile.length();
                if (length < 22) {
                    return null;
                }
                ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                long capacity = length - allocate.capacity();
                randomAccessFile.seek(capacity);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                int b = b(allocate);
                if (b == -1) {
                    return null;
                }
                allocate.position(b);
                ByteBuffer slice = allocate.slice();
                slice.order(ByteOrder.LITTLE_ENDIAN);
                return Pair.create(slice, Long.valueOf(capacity + b));
            }
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        return (Pair) invokeLI.objValue;
    }

    public static void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, byteBuffer) != null) || byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            return;
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static void a(ZipFile zipFile) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, zipFile) != null) || zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (Throwable unused) {
        }
    }

    public static int b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            a(byteBuffer);
            int capacity = byteBuffer.capacity();
            if (capacity < 22) {
                return -1;
            }
            int i = capacity - 22;
            int min = Math.min(i, 65535);
            for (int i2 = 0; i2 <= min; i2++) {
                int i3 = i - i2;
                if (byteBuffer.getInt(i3) == 101010256 && (byteBuffer.getShort(i3 + 20) & UShort.MAX_VALUE) == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}

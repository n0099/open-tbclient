package com.bytedance.pangle.f;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
/* loaded from: classes7.dex */
public abstract class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public static int b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
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

    public static void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, byteBuffer) == null) && byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static long a(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, byteBuffer, i)) == null) ? byteBuffer.getInt(i) & 4294967295L : invokeLI.longValue;
    }
}

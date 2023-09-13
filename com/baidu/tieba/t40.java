package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public final class t40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, byteBuffer, byteBuffer2, byteBuffer3, i) == null) {
            if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
                throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
            }
            for (int i2 = 0; i2 < i; i2++) {
                byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
            }
        }
    }
}

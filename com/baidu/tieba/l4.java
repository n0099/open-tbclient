package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
/* loaded from: classes7.dex */
public final class l4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        long j;
        long j2;
        long j3;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, bArr, i, i2)) == null) {
            long j4 = (i2 & 4294967295L) ^ (i * (-4132994306676758123L));
            for (int i3 = 0; i3 < i / 8; i3++) {
                int i4 = i3 * 8;
                long j5 = ((bArr[i4 + 0] & 255) + ((bArr[i4 + 1] & 255) << 8) + ((bArr[i4 + 2] & 255) << 16) + ((bArr[i4 + 3] & 255) << 24) + ((bArr[i4 + 4] & 255) << 32) + ((bArr[i4 + 5] & 255) << 40) + ((bArr[i4 + 6] & 255) << 48) + ((bArr[i4 + 7] & 255) << 56)) * (-4132994306676758123L);
                j4 = (j4 ^ ((j5 ^ (j5 >>> 47)) * (-4132994306676758123L))) * (-4132994306676758123L);
            }
            switch (i % 8) {
                case 1:
                    j = -4132994306676758123L;
                    j4 = (j4 ^ (bArr[i & (-8)] & 255)) * (-4132994306676758123L);
                    break;
                case 2:
                    j2 = (bArr[(i & (-8)) + 1] & 255) << 8;
                    j4 ^= j2;
                    j = -4132994306676758123L;
                    break;
                case 3:
                    j2 = (bArr[(i & (-8)) + 2] & 255) << 16;
                    j4 ^= j2;
                    j = -4132994306676758123L;
                    break;
                case 4:
                    j2 = (bArr[(i & (-8)) + 3] & 255) << 24;
                    j4 ^= j2;
                    j = -4132994306676758123L;
                    break;
                case 5:
                    j2 = (bArr[(i & (-8)) + 4] & 255) << 32;
                    j4 ^= j2;
                    j = -4132994306676758123L;
                    break;
                case 6:
                    j3 = bArr[(i & (-8)) + 5] & 255;
                    c = '(';
                    j2 = j3 << c;
                    j4 ^= j2;
                    j = -4132994306676758123L;
                    break;
                case 7:
                    j3 = bArr[(i & (-8)) + 6] & 255;
                    c = TransactionIdCreater.FILL_BYTE;
                    j2 = j3 << c;
                    j4 ^= j2;
                    j = -4132994306676758123L;
                    break;
                default:
                    j = -4132994306676758123L;
                    break;
            }
            long j6 = (j4 ^ (j4 >>> 47)) * j;
            return j6 ^ (j6 >>> 47);
        }
        return invokeLII.longValue;
    }
}

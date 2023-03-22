package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes6.dex */
public class r30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] a;
    public final byte[] b;
    public final int c;
    public int d;
    public int e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r30() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public r30(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new int[4];
        this.b = new byte[16];
        this.c = i;
        f();
    }

    public static int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i)) == null) ? (int) (d(bArr, i, 4) & 4294967295L) : invokeLI.intValue;
    }

    public static long d(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i, i2)) == null) {
            if (i2 <= 8) {
                long j = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    j |= (bArr[i + i3] & 255) << (i3 * 8);
                }
                return j;
            }
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        return invokeLII.longValue;
    }

    public void b(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, bArr, i, i2) == null) || i2 <= 0) {
            return;
        }
        this.d += i2;
        int i3 = i + i2;
        int i4 = this.e;
        if (i4 + i2 < 16) {
            System.arraycopy(bArr, i, this.b, i4, i2);
            this.e += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = 16 - i4;
            System.arraycopy(bArr, i, this.b, i4, i5);
            e(this.b, 0);
            i += i5;
        }
        int i6 = i3 - 16;
        while (i <= i6) {
            e(bArr, i);
            i += 16;
        }
        if (i < i3) {
            int i7 = i3 - i;
            this.e = i7;
            System.arraycopy(bArr, i, this.b, 0, i7);
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = 0;
            int rotateLeft = (this.d > 16 ? Integer.rotateLeft(this.a[0], 1) + Integer.rotateLeft(this.a[1], 7) + Integer.rotateLeft(this.a[2], 12) + Integer.rotateLeft(this.a[3], 18) : this.a[2] + XXHash32.PRIME5) + this.d;
            int i2 = this.e - 4;
            while (i <= i2) {
                rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.b, i) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
                i += 4;
            }
            while (i < this.e) {
                rotateLeft = Integer.rotateLeft(rotateLeft + ((this.b[i] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
                i++;
            }
            int i3 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
            int i4 = (i3 ^ (i3 >>> 13)) * XXHash32.PRIME3;
            return (i4 ^ (i4 >>> 16)) & 4294967295L;
        }
        return invokeV.longValue;
    }

    public final void e(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i) == null) {
            int[] iArr = this.a;
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            int rotateLeft = Integer.rotateLeft(i2 + (a(bArr, i) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft2 = Integer.rotateLeft(i3 + (a(bArr, i + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft3 = Integer.rotateLeft(i4 + (a(bArr, i + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft4 = Integer.rotateLeft(i5 + (a(bArr, i + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int[] iArr2 = this.a;
            iArr2[0] = rotateLeft;
            iArr2[1] = rotateLeft2;
            iArr2[2] = rotateLeft3;
            iArr2[3] = rotateLeft4;
            this.e = 0;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int[] iArr = this.a;
            int i = this.c;
            iArr[0] = i + XXHash32.PRIME1 + XXHash32.PRIME2;
            iArr[1] = XXHash32.PRIME2 + i;
            iArr[2] = i;
            iArr[3] = i - XXHash32.PRIME1;
        }
    }
}

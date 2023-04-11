package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes5.dex */
public final class mz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public qz f;
    public nz g;
    public int h;
    public boolean i;

    public mz(jz jzVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jzVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = 1;
        this.i = false;
        this.b = i;
        this.c = i;
        this.e = i;
        this.a = new byte[i * 2];
        this.g = new lz(jzVar);
        this.f = new pz(this.b);
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = this.d + i;
            qz qzVar = this.f;
            if (qzVar == null || this.i) {
                return i2;
            }
            int i3 = this.c;
            int i4 = this.b;
            if (i3 != i4) {
                int i5 = this.e;
                return i2 < i5 ? i5 : (i2 + i4) - ((i2 - i5) % i4);
            }
            return i2 + qzVar.a(i2);
        }
        return invokeI.intValue;
    }

    public final int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (bArr == null || i3 == 0) {
                return 0;
            }
            int i4 = this.h;
            if (i4 == 2 || i4 == 3 || i3 % this.c == 0 || i4 == 6) {
                if (this.i) {
                    this.g.h(bArr, i, i3, bArr2, i2);
                } else {
                    this.g.f(bArr, i, i3, bArr2, i2);
                }
                return i3;
            } else if (this.f != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.c + " bytes");
            } else {
                throw new IllegalBlockSizeException("Input length not multiple of " + this.c + " bytes");
            }
        }
        return invokeCommon.intValue;
    }

    public void c(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), bArr, bArr2, secureRandom}) == null) {
            boolean z = i == 2 || i == 4;
            this.i = z;
            if (this.h == 0) {
                if (bArr2 != null) {
                    throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
                }
            } else if (bArr2 == null) {
                if (z) {
                    throw new InvalidAlgorithmParameterException("Parameters missing");
                }
                if (secureRandom == null) {
                    secureRandom = kz.b;
                }
                bArr2 = new byte[this.b];
                secureRandom.nextBytes(bArr2);
            }
            this.d = 0;
            this.e = this.b;
            this.g.a(this.i, "", bArr, bArr2);
        }
    }

    public int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        InterceptResult invokeCommon;
        int a;
        byte[] bArr3;
        int i4;
        qz qzVar;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)})) == null) {
            int i5 = this.d + i2;
            int i6 = this.c;
            int i7 = this.b;
            if (i6 != i7) {
                int i8 = this.e;
                a = i5 < i8 ? i8 - i5 : i7 - ((i5 - i8) % i7);
            } else {
                qz qzVar2 = this.f;
                a = qzVar2 != null ? qzVar2.a(i5) : 0;
            }
            if (a > 0 && a != this.b && this.f != null && this.i) {
                throw new IllegalBlockSizeException("Input length must be multiple of " + this.b + " when decrypting with padded cipher");
            }
            int i9 = (this.i || this.f == null) ? i5 : i5 + a;
            if (bArr2 != null) {
                int length = bArr2.length - i3;
                if (((!this.i || this.f == null) && length < i9) || (this.i && length < i9 - this.b)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i9 + " bytes needed");
                }
                if (this.d == 0 && (this.i || this.f == null)) {
                    bArr3 = bArr;
                    i4 = i;
                } else {
                    byte[] bArr4 = new byte[i9];
                    int i10 = this.d;
                    if (i10 != 0) {
                        System.arraycopy(this.a, 0, bArr4, 0, i10);
                    }
                    if (i2 != 0) {
                        System.arraycopy(bArr, i, bArr4, this.d, i2);
                    }
                    if (!this.i && (qzVar = this.f) != null) {
                        qzVar.a(bArr4, i5, a);
                    }
                    bArr3 = bArr4;
                    i4 = 0;
                }
                if (this.i) {
                    if (length < i9) {
                        this.g.e();
                    }
                    byte[] bArr5 = new byte[i5];
                    b = b(bArr3, i4, bArr5, 0, i5);
                    qz qzVar3 = this.f;
                    if (qzVar3 != null && (b = qzVar3.b(bArr5, 0, b)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    }
                    if (bArr2.length - i3 < b) {
                        this.g.g();
                        throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + b + " bytes needed");
                    }
                    for (int i11 = 0; i11 < b; i11++) {
                        bArr2[i3 + i11] = bArr5[i11];
                    }
                } else {
                    b = b(bArr3, i4, bArr2, i3, i9);
                }
                this.d = 0;
                this.e = this.b;
                if (this.h != 0) {
                    this.g.c();
                }
                return b;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        return invokeCommon.intValue;
    }

    public byte[] e(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        int a;
        byte[] bArr2;
        int d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
            byte[] bArr3 = null;
            try {
                a = a(i2);
                bArr2 = new byte[a];
                d = d(bArr, i, i2, bArr2, 0);
            } catch (ShortBufferException unused) {
            }
            if (d < a) {
                bArr3 = new byte[d];
                if (d != 0) {
                    System.arraycopy(bArr2, 0, bArr3, 0, d);
                }
                return bArr3;
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }
}

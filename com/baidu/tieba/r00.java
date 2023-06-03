package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidKeyException;
/* loaded from: classes7.dex */
public class r00 extends t00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] d;
    public byte[] e;
    public byte[] f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r00(p00 p00Var) {
        super(p00Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p00Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((p00) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = null;
        int i3 = this.b;
        this.e = new byte[i3];
        this.d = new byte[i3];
    }

    @Override // com.baidu.tieba.t00
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, bArr, bArr2}) == null) {
            if (bArr == null || bArr2 == null || bArr2.length != this.b) {
                throw new InvalidKeyException("Internal error");
            }
            this.c = bArr2;
            c();
            this.a.e(z, str, bArr);
        }
    }

    @Override // com.baidu.tieba.t00
    public void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i4 = i2 + i;
            while (i < i4) {
                for (int i5 = 0; i5 < this.b; i5++) {
                    this.e[i5] = (byte) (bArr[i5 + i] ^ this.d[i5]);
                }
                this.a.f(this.e, 0, bArr2, i3);
                System.arraycopy(bArr2, i3, this.d, 0, this.b);
                int i6 = this.b;
                i += i6;
                i3 += i6;
            }
        }
    }

    @Override // com.baidu.tieba.t00
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            System.arraycopy(this.c, 0, this.d, 0, this.b);
        }
    }

    @Override // com.baidu.tieba.t00
    public void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i5 = i2 + i;
            byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.b) ? null : (byte[]) bArr.clone();
            while (i < i5) {
                this.a.j(bArr, i, this.e, 0);
                int i6 = 0;
                while (true) {
                    i4 = this.b;
                    if (i6 >= i4) {
                        break;
                    }
                    bArr2[i6 + i3] = (byte) (this.e[i6] ^ this.d[i6]);
                    i6++;
                }
                byte[] bArr4 = this.d;
                if (bArr3 == null) {
                    System.arraycopy(bArr, i, bArr4, 0, i4);
                } else {
                    System.arraycopy(bArr3, i, bArr4, 0, i4);
                }
                int i7 = this.b;
                i += i7;
                i3 += i7;
            }
        }
    }

    @Override // com.baidu.tieba.t00
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f == null) {
                this.f = new byte[this.b];
            }
            System.arraycopy(this.d, 0, this.f, 0, this.b);
        }
    }

    @Override // com.baidu.tieba.t00
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            System.arraycopy(this.f, 0, this.d, 0, this.b);
        }
    }
}

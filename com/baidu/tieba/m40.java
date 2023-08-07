package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes6.dex */
public final class m40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public o40 c;
    public byte[] d;
    public int e;
    public t40 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947922560, "Lcom/baidu/tieba/m40;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947922560, "Lcom/baidu/tieba/m40;");
        }
    }

    public m40() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 2;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    throw new NoSuchPaddingException("Padding " + i + " not supported");
                }
            }
            this.b = i2;
        }
    }

    public void b(int i, t40 t40Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, t40Var) == null) {
            try {
                c(i, t40Var, null);
            } catch (InvalidAlgorithmParameterException e) {
                InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
                invalidKeyException.initCause(e);
                throw invalidKeyException;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(int i, t40 t40Var, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, t40Var, algorithmParameterSpec) != null) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new InvalidKeyException("Unknown mode: " + i);
                    }
                }
            }
            z = false;
            if (t40Var instanceof t40) {
                throw new InvalidKeyException("only support helios key");
            }
            this.a = z ? 1 : 4;
            this.f = t40Var;
            int a = l40.a(t40Var.b());
            this.e = 0;
            int i2 = this.b;
            if (i2 == 1) {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.c = o40.b(3, a);
                this.d = new byte[a];
                return;
            } else if (i2 != 2) {
                throw new InvalidKeyException("PEAO not supported");
            } else {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                o40 b = o40.b(this.a > 2 ? 1 : 2, a);
                this.c = b;
                if (z) {
                    this.d = new byte[b.a()];
                    return;
                } else {
                    this.d = new byte[a];
                    return;
                }
            }
        }
        z = true;
        if (t40Var instanceof t40) {
        }
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.e;
            byte[] bArr = this.d;
            if (i > bArr.length) {
                throw new IllegalBlockSizeException("Data must not be longer than " + this.d.length + " bytes");
            }
            try {
                int i2 = this.a;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                return this.c.c(l40.e(l40.d(bArr, 0, i), this.f));
                            }
                            throw new AssertionError("Internal error");
                        }
                        throw new UnsupportedOperationException("only verify supported");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                throw new UnsupportedOperationException("only verify supported");
            } finally {
                this.e = 0;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public byte[] e(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
            f(bArr, i, i2);
            return d();
        }
        return (byte[]) invokeLII.objValue;
    }

    public final void f(byte[] bArr, int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, bArr, i, i2) == null) || i2 == 0 || bArr == null) {
            return;
        }
        int i4 = this.e;
        int i5 = i4 + i2;
        byte[] bArr2 = this.d;
        if (i5 > bArr2.length) {
            i3 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            i3 = this.e + i2;
        }
        this.e = i3;
    }
}

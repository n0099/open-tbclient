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
/* loaded from: classes7.dex */
public final class o50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public q50 c;
    public byte[] d;
    public int e;
    public v50 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947983103, "Lcom/baidu/tieba/o50;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947983103, "Lcom/baidu/tieba/o50;");
        }
    }

    public o50() {
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

    public void b(int i, v50 v50Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, v50Var) == null) {
            try {
                c(i, v50Var, null);
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
    public final void c(int i, v50 v50Var, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, v50Var, algorithmParameterSpec) != null) {
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
            if (v50Var instanceof v50) {
                throw new InvalidKeyException("only support helios key");
            }
            this.a = z ? 1 : 4;
            this.f = v50Var;
            int a = n50.a(v50Var.b());
            this.e = 0;
            int i2 = this.b;
            if (i2 == 1) {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.c = q50.b(3, a);
                this.d = new byte[a];
                return;
            } else if (i2 != 2) {
                throw new InvalidKeyException("PEAO not supported");
            } else {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                q50 b = q50.b(this.a > 2 ? 1 : 2, a);
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
        if (v50Var instanceof v50) {
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
                                return this.c.c(n50.e(n50.d(bArr, 0, i), this.f));
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

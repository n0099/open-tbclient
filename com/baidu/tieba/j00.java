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
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes6.dex */
public final class j00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public m00 c;
    public byte[] d;
    public int e;
    public k00 f;
    public String g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947829343, "Lcom/baidu/tieba/j00;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947829343, "Lcom/baidu/tieba/j00;");
        }
    }

    public j00() {
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
        this.g = "SHA-1";
        this.b = "PKCS1Padding";
    }

    public void a(int i, k00 k00Var, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, k00Var, secureRandom) == null) {
            try {
                b(i, k00Var, secureRandom, null);
            } catch (InvalidAlgorithmParameterException e) {
                InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
                invalidKeyException.initCause(e);
                throw invalidKeyException;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(int i, k00 k00Var, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), k00Var, secureRandom, algorithmParameterSpec}) != null) {
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
            if (k00Var instanceof k00) {
                throw new InvalidKeyException("only support helios key");
            }
            this.a = z ? 1 : 4;
            this.f = k00Var;
            int a = i00.a(k00Var.a());
            this.e = 0;
            String str = this.b;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.c = m00.b(3, a, secureRandom);
                this.d = new byte[a];
                return;
            } else if (str == "PKCS1Padding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                m00 b = m00.b(this.a > 2 ? 1 : 2, a, secureRandom);
                this.c = b;
                if (z) {
                    this.d = new byte[b.a()];
                    return;
                } else {
                    this.d = new byte[a];
                    return;
                }
            } else {
                int i2 = this.a;
                if (i2 == 3 || i2 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.g, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                } else {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                }
                m00 c = m00.c(4, a, secureRandom, oAEPParameterSpec);
                this.c = c;
                if (z) {
                    this.d = new byte[c.a()];
                    return;
                } else {
                    this.d = new byte[a];
                    return;
                }
            }
        }
        z = true;
        if (k00Var instanceof k00) {
        }
    }

    public final byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
                                return this.c.h(i00.e(i00.d(bArr, 0, i), this.f));
                            }
                            throw new AssertionError("Internal error");
                        }
                        throw new UnsupportedOperationException("only verify supported");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                return i00.e(this.c.g(bArr, 0, i), this.f);
            } finally {
                this.e = 0;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public byte[] d(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            f(bArr, i, i2);
            return c();
        }
        return (byte[]) invokeLII.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            String str2 = "NoPadding";
            if (!str.equalsIgnoreCase("NoPadding")) {
                str2 = "PKCS1Padding";
                if (!str.equalsIgnoreCase("PKCS1Padding")) {
                    String lowerCase = str.toLowerCase(Locale.ENGLISH);
                    if (lowerCase.equals("oaeppadding")) {
                        this.b = "OAEP";
                        return;
                    } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                        throw new NoSuchPaddingException("Padding " + str + " not supported");
                    } else {
                        this.b = "OAEP";
                        this.g = str.substring(8, str.length() - 14);
                        throw new NoSuchPaddingException("MessageDigest not available for " + str);
                    }
                }
            }
            this.b = str2;
        }
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

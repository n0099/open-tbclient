package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public static final o a;
    public transient /* synthetic */ FieldHolder $fh;
    public final Signature[] b;
    public final int c;
    public final ArraySet d;
    public final Signature[] e;
    public final int[] f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-294140189, "Lcom/bytedance/pangle/f/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-294140189, "Lcom/bytedance/pangle/f/o;");
                return;
            }
        }
        a = new o(null, 0, null, null, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signatureArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Signature[]) objArr2[0], ((Integer) objArr2[1]).intValue(), (Signature[]) objArr2[2], (int[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static ArraySet a(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, signatureArr)) == null) {
            ArraySet arraySet = new ArraySet(signatureArr.length);
            for (Signature signature : signatureArr) {
                Method a2 = com.bytedance.pangle.a.a.a.a(Signature.class, "getPublicKey", new Class[0]);
                if (a2 != null && a2.isAccessible()) {
                    try {
                        arraySet.add((PublicKey) a2.invoke(signature, new Object[0]));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return arraySet;
        }
        return (ArraySet) invokeL.objValue;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            if (this.c != oVar.c || !a(this.b, oVar.b)) {
                return false;
            }
            ArraySet arraySet = this.d;
            if (arraySet != null) {
                if (!arraySet.equals(oVar.d)) {
                    return false;
                }
            } else if (oVar.d != null) {
                return false;
            }
            if (Arrays.equals(this.e, oVar.e) && Arrays.equals(this.f, oVar.f)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public o(Signature[] signatureArr, int i, ArraySet arraySet, Signature[] signatureArr2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signatureArr, Integer.valueOf(i), arraySet, signatureArr2, iArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = signatureArr;
        this.c = i;
        this.d = arraySet;
        this.e = signatureArr2;
        this.f = iArr;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i, a(signatureArr), signatureArr2, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signatureArr, Integer.valueOf(i), signatureArr2, iArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Signature[]) objArr2[0], ((Integer) objArr2[1]).intValue(), (ArraySet) objArr2[2], (Signature[]) objArr2[3], (int[]) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, bArr2)) == null) {
            if (bArr.length != bArr2.length) {
                return false;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, signatureArr, signatureArr2)) == null) {
            if (signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.c.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.c.a((Object[]) signatureArr2, (Object[]) signatureArr)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int hashCode = ((Arrays.hashCode(this.b) * 31) + this.c) * 31;
            ArraySet arraySet = this.d;
            if (arraySet != null) {
                i = arraySet.hashCode();
            } else {
                i = 0;
            }
            return ((((hashCode + i) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f);
        }
        return invokeV.intValue;
    }
}

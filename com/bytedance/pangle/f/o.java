package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public static final o a;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Signature[] f51705b;

    /* renamed from: c  reason: collision with root package name */
    public final int f51706c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final ArraySet<PublicKey> f51707d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Signature[] f51708e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final int[] f51709f;

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

    public o(Signature[] signatureArr, int i2, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signatureArr, Integer.valueOf(i2), arraySet, signatureArr2, iArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51705b = signatureArr;
        this.f51706c = i2;
        this.f51707d = arraySet;
        this.f51708e = signatureArr2;
        this.f51709f = iArr;
    }

    public static ArraySet<PublicKey> a(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, signatureArr)) == null) {
            ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
            for (Signature signature : signatureArr) {
                Method a2 = com.bytedance.pangle.a.a.a.a(Signature.class, "getPublicKey", new Class[0]);
                if (a2 != null && a2.isAccessible()) {
                    try {
                        arraySet.add((PublicKey) a2.invoke(signature, new Object[0]));
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            return arraySet;
        }
        return (ArraySet) invokeL.objValue;
    }

    public static boolean b(Signature[] signatureArr, Signature[] signatureArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, signatureArr, signatureArr2)) == null) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Signature[] signatureArr3 = new Signature[signatureArr.length];
            for (int i2 = 0; i2 < signatureArr.length; i2++) {
                signatureArr3[i2] = a(certificateFactory, signatureArr[i2]);
            }
            Signature[] signatureArr4 = new Signature[signatureArr2.length];
            for (int i3 = 0; i3 < signatureArr2.length; i3++) {
                signatureArr4[i3] = a(certificateFactory, signatureArr2[i3]);
            }
            return a(signatureArr3, signatureArr4);
        }
        return invokeLL.booleanValue;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof o) {
                o oVar = (o) obj;
                if (this.f51706c == oVar.f51706c && a(this.f51705b, oVar.f51705b)) {
                    ArraySet<PublicKey> arraySet = this.f51707d;
                    if (arraySet != null) {
                        if (!arraySet.equals(oVar.f51707d)) {
                            return false;
                        }
                    } else if (oVar.f51707d != null) {
                        return false;
                    }
                    return Arrays.equals(this.f51708e, oVar.f51708e) && Arrays.equals(this.f51709f, oVar.f51709f);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int hashCode = ((Arrays.hashCode(this.f51705b) * 31) + this.f51706c) * 31;
            ArraySet<PublicKey> arraySet = this.f51707d;
            return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f51708e)) * 31) + Arrays.hashCode(this.f51709f);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(Signature[] signatureArr, int i2, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i2, a(signatureArr), signatureArr2, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signatureArr, Integer.valueOf(i2), signatureArr2, iArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Signature[]) objArr2[0], ((Integer) objArr2[1]).intValue(), (ArraySet) objArr2[2], (Signature[]) objArr2[3], (int[]) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Signature[]) objArr2[0], ((Integer) objArr2[1]).intValue(), (Signature[]) objArr2[2], (int[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, signatureArr, signatureArr2)) == null) ? signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.b.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.b.a((Object[]) signatureArr2, (Object[]) signatureArr) : invokeLL.booleanValue;
    }

    public static Signature a(CertificateFactory certificateFactory, Signature signature) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, certificateFactory, signature)) == null) {
            Signature signature2 = new Signature(((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getEncoded());
            int length = signature2.toByteArray().length;
            int length2 = signature.toByteArray().length;
            if (Math.abs(length - length2) <= 2) {
                return signature2;
            }
            throw new CertificateException("Bounced cert length looks fishy; before " + length2 + ", after " + length);
        }
        return (Signature) invokeLL.objValue;
    }
}

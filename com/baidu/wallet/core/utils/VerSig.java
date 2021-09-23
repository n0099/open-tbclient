package com.baidu.wallet.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.armor.SafePay;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
/* loaded from: classes8.dex */
public final class VerSig {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f61135a = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public VerSig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("MD5".equalsIgnoreCase(str)) {
                return 4;
            }
            if ("SHA-1".equalsIgnoreCase(str)) {
                return 5;
            }
            if ("SHA-256".equalsIgnoreCase(str)) {
                return 11;
            }
            if ("SHA-384".equalsIgnoreCase(str)) {
                return 12;
            }
            return "SHA-512".equalsIgnoreCase(str) ? 13 : 0;
        }
        return invokeL.intValue;
    }

    public static boolean verify(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return false;
            }
            return verify(str.getBytes(), str2.getBytes(), str3);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bArr, bArr2, str)) == null) {
            if (bArr == null || bArr2 == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    byte[] digest = MessageDigest.getInstance(str.toUpperCase()).digest(bArr2);
                    if (SafePay.getInstance().rsaVerify(0, a(str), digest.length, digest, Base64.decode(bArr, 0)) != 0) {
                        return false;
                    }
                } catch (Throwable unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}

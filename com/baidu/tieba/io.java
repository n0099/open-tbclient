package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public class io {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            if (bArr == null) {
                return "";
            }
            return new String(bArr, Charset.forName("UTF-8"));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new byte[0];
            }
            return str.getBytes(Charset.forName("UTF-8"));
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null) {
                return new byte[0];
            }
            return Base64.encode(bArr, 2);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr != null && bArr.length != 0) {
                return Base64.decode(bArr, 2);
            }
            return new byte[0];
        }
        return (byte[]) invokeL.objValue;
    }
}

package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
/* loaded from: classes8.dex */
public class tv {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] a;
    public static byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            byte[] bArr = a;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(sv.a).modPow(new BigInteger(sv.b), new BigInteger(sv.e)).toByteArray();
            a = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            byte[] bArr = b;
            if (bArr != null) {
                return bArr;
            }
            byte[] byteArray = new BigInteger(sv.c).modPow(new BigInteger(sv.d), new BigInteger(sv.e)).toByteArray();
            b = byteArray;
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }
}

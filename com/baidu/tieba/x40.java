package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
import javax.crypto.BadPaddingException;
/* loaded from: classes6.dex */
public final class x40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, bArr, i, i2)) == null) {
            if (i == 0 && i2 == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] b(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws BadPaddingException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bArr, bigInteger, bigInteger2)) == null) {
            return f(d(bArr, bigInteger).modPow(bigInteger2, bigInteger), c(bigInteger));
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static int c(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bigInteger)) == null) {
            return (bigInteger.bitLength() + 7) >> 3;
        }
        return invokeL.intValue;
    }

    public static BigInteger d(byte[] bArr, BigInteger bigInteger) throws BadPaddingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bigInteger)) == null) {
            BigInteger bigInteger2 = new BigInteger(1, bArr);
            if (bigInteger2.compareTo(bigInteger) < 0) {
                return bigInteger2;
            }
            throw new BadPaddingException("Message is larger than modulus");
        }
        return (BigInteger) invokeLL.objValue;
    }

    public static byte[] e(byte[] bArr, w40 w40Var) throws BadPaddingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, w40Var)) == null) {
            return b(bArr, w40Var.b(), w40Var.a());
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] f(BigInteger bigInteger, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bigInteger, i)) == null) {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (length == i) {
                return byteArray;
            }
            if (length == i + 1 && byteArray[0] == 0) {
                byte[] bArr = new byte[i];
                System.arraycopy(byteArray, 1, bArr, 0, i);
                return bArr;
            } else if (length >= i) {
                return null;
            } else {
                byte[] bArr2 = new byte[i];
                System.arraycopy(byteArray, 0, bArr2, i - length, length);
                return bArr2;
            }
        }
        return (byte[]) invokeLI.objValue;
    }
}

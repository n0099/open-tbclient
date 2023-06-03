package com.baidubce.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class ConvertUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] CHUNK_SEPARATOR;
    public static final char[] DIGITS_LOWER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1173842940, "Lcom/baidubce/util/ConvertUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1173842940, "Lcom/baidubce/util/ConvertUtils;");
                return;
            }
        }
        DIGITS_LOWER = new char[]{TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        CHUNK_SEPARATOR = new byte[]{13, 10};
    }

    public ConvertUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] decodeHex(char[] cArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cArr)) == null) {
            int length = cArr.length;
            if ((length & 1) == 0) {
                byte[] bArr = new byte[length >> 1];
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i + 1;
                    i = i3 + 1;
                    bArr[i2] = (byte) (((toDigit(cArr[i], i) << 4) | toDigit(cArr[i3], i3)) & 255);
                    i2++;
                }
                return bArr;
            }
            throw new IOException("Odd number of characters.");
        }
        return (byte[]) invokeL.objValue;
    }

    public static char[] encodeHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            char[] cArr = DIGITS_LOWER;
            int length = bArr.length;
            char[] cArr2 = new char[length << 1];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
                i = i3 + 1;
                cArr2[i3] = cArr[bArr[i2] & 15];
            }
            return cArr2;
        }
        return (char[]) invokeL.objValue;
    }

    public static byte[] inputStreamToByte(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public static int toDigit(char c, int i) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            int digit = Character.digit(c, 16);
            if (digit != -1) {
                return digit;
            }
            throw new IOException("Illegal hexadecimal character " + c + " at index " + i);
        }
        return invokeCommon.intValue;
    }
}

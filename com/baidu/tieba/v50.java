package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public class v50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return i != 5 ? -1 : 0;
                        }
                        return 1;
                    }
                    return 3;
                }
                return 4;
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 3) {
                        if (i != 4) {
                            return i != 6 ? -1 : 1;
                        }
                        return 2;
                    }
                    return 3;
                }
                return 4;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    public v50(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    public byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte b : str.getBytes()) {
                char c = (char) b;
                if (!Character.isWhitespace(c)) {
                    byteArrayOutputStream.write((byte) Character.toUpperCase(c));
                }
            }
            if (this.b) {
                if (byteArrayOutputStream.size() % 8 != 0) {
                    return null;
                }
            } else {
                while (byteArrayOutputStream.size() % 8 != 0) {
                    byteArrayOutputStream.write(61);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.reset();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (int i = 0; i < byteArray.length / 8; i++) {
                short[] sArr = new short[8];
                int[] iArr = new int[5];
                int i2 = 8;
                for (int i3 = 0; i3 < 8; i3++) {
                    int i4 = (i * 8) + i3;
                    if (((char) byteArray[i4]) == '=') {
                        break;
                    }
                    sArr[i3] = (short) this.a.indexOf(byteArray[i4]);
                    if (sArr[i3] < 0) {
                        return null;
                    }
                    i2--;
                }
                int d = d(i2);
                if (d < 0) {
                    return null;
                }
                iArr[0] = (sArr[0] << 3) | (sArr[1] >> 2);
                iArr[1] = ((sArr[1] & 3) << 6) | (sArr[2] << 1) | (sArr[3] >> 4);
                iArr[2] = ((sArr[3] & 15) << 4) | ((sArr[4] >> 1) & 15);
                iArr[3] = (sArr[4] << 7) | (sArr[5] << 2) | (sArr[6] >> 3);
                iArr[4] = sArr[7] | ((sArr[6] & 7) << 5);
                for (int i5 = 0; i5 < d; i5++) {
                    try {
                        dataOutputStream.writeByte((byte) (iArr[i5] & 255));
                    } catch (IOException unused) {
                    }
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public String c(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < (bArr.length + 4) / 5; i2++) {
                short[] sArr = new short[5];
                int[] iArr = new int[8];
                int i3 = 5;
                for (int i4 = 0; i4 < 5; i4++) {
                    int i5 = (i2 * 5) + i4;
                    if (i5 < bArr.length) {
                        sArr[i4] = (short) (bArr[i5] & 255);
                    } else {
                        sArr[i4] = 0;
                        i3--;
                    }
                }
                int a = a(i3);
                iArr[0] = (byte) ((sArr[0] >> 3) & 31);
                iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
                iArr[2] = (byte) ((sArr[1] >> 1) & 31);
                iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
                iArr[4] = (byte) (((sArr[2] & 15) << 1) | ((sArr[3] >> 7) & 1));
                iArr[5] = (byte) ((sArr[3] >> 2) & 31);
                iArr[6] = (byte) (((sArr[4] >> 5) & 7) | ((sArr[3] & 3) << 3));
                iArr[7] = (byte) (sArr[4] & 31);
                int i6 = 0;
                while (true) {
                    i = 8 - a;
                    if (i6 >= i) {
                        break;
                    }
                    char charAt = this.a.charAt(iArr[i6]);
                    if (this.c) {
                        charAt = Character.toLowerCase(charAt);
                    }
                    byteArrayOutputStream.write(charAt);
                    i6++;
                }
                if (this.b) {
                    while (i < 8) {
                        byteArrayOutputStream.write(61);
                        i++;
                    }
                }
            }
            return new String(byteArrayOutputStream.toByteArray());
        }
        return (String) invokeL.objValue;
    }
}

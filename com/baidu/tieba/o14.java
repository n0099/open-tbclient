package com.baidu.tieba;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes7.dex */
public class o14 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public static final byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979383, "Lcom/baidu/tieba/o14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979383, "Lcom/baidu/tieba/o14;");
                return;
            }
        }
        a = new byte[]{48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, QCodec.UNDERSCORE, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};
        b = new byte[128];
        int i = 0;
        while (true) {
            byte[] bArr = a;
            if (i < bArr.length) {
                b[bArr[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    public o14() {
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

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
                str = str + "$";
            }
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[(bytes.length / 3) * 4];
            int i = 0;
            int i2 = 0;
            while (i < bytes.length) {
                byte[] bArr2 = a;
                bArr[i2] = bArr2[(bytes[i] & Cea608Decoder.CC_IMPLICIT_DATA_HEADER) >> 2];
                int i3 = i + 1;
                bArr[i2 + 1] = bArr2[((bytes[i] & 3) << 4) + ((bytes[i3] & 240) >> 4)];
                int i4 = i + 2;
                bArr[i2 + 2] = bArr2[((bytes[i3] & 15) << 2) + ((bytes[i4] & ExifInterface.MARKER_SOF0) >> 6)];
                bArr[i2 + 3] = bArr2[bytes[i4] & 63];
                i += 3;
                i2 += 4;
            }
            return new String(bArr);
        }
        return (String) invokeL.objValue;
    }
}

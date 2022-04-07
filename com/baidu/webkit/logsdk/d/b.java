package com.baidu.webkit.logsdk.d;

import android.util.Base64;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public int b;
    public int c;
    public byte[] d;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str.getBytes();
    }

    public static String a(String str, String str2) {
        String str3;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                b bVar = new b(str2);
                byte[] decode = Base64.decode(str.getBytes(), 0);
                byte[] bArr = bVar.d;
                bVar.b = 0;
                bVar.c = 0;
                if (bVar.a == null) {
                    bVar.a = new byte[256];
                }
                for (int i = 0; i < 256; i++) {
                    bVar.a[i] = (byte) i;
                }
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < 256; i4++) {
                    i3 = ((bArr[i2] & 255) + bVar.a[i4] + i3) & 255;
                    byte b = bVar.a[i4];
                    byte[] bArr2 = bVar.a;
                    bArr2[i4] = bArr2[i3];
                    bVar.a[i3] = b;
                    i2 = (i2 + 1) % bArr.length;
                }
                int length = decode.length;
                byte[] bArr3 = new byte[length];
                int length2 = decode.length;
                int i5 = length2 + 0;
                if (i5 > decode.length) {
                    str3 = "input buffer too short, buffer length=" + decode.length + ", input length=" + i5;
                } else if (i5 <= length) {
                    for (int i6 = 0; i6 < length2; i6++) {
                        int i7 = (bVar.b + 1) & 255;
                        bVar.b = i7;
                        int i8 = (bVar.a[i7] + bVar.c) & 255;
                        bVar.c = i8;
                        byte b2 = bVar.a[i7];
                        bVar.a[i7] = bVar.a[i8];
                        bVar.a[i8] = b2;
                        int i9 = i6 + 0;
                        bArr3[i9] = (byte) (bVar.a[(bVar.a[i7] + bVar.a[i8]) & 255] ^ decode[i9]);
                    }
                    return new String(bArr3);
                } else {
                    str3 = "output buffer too short, buffer length=" + decode.length + ", output length=" + i5;
                }
                Log.e("BdLogRC4Utils", str3);
                return new String(bArr3);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}

package com.baidu.webkit.logsdk.d;

import android.util.Base64;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f27417a;

    /* renamed from: b  reason: collision with root package name */
    public int f27418b;

    /* renamed from: c  reason: collision with root package name */
    public int f27419c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f27420d;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27420d = str.getBytes();
    }

    public static String a(String str, String str2) {
        String str3;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                b bVar = new b(str2);
                byte[] decode = Base64.decode(str.getBytes(), 0);
                byte[] bArr = bVar.f27420d;
                bVar.f27418b = 0;
                bVar.f27419c = 0;
                if (bVar.f27417a == null) {
                    bVar.f27417a = new byte[256];
                }
                for (int i2 = 0; i2 < 256; i2++) {
                    bVar.f27417a[i2] = (byte) i2;
                }
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < 256; i5++) {
                    i4 = ((bArr[i3] & 255) + bVar.f27417a[i5] + i4) & 255;
                    byte b2 = bVar.f27417a[i5];
                    byte[] bArr2 = bVar.f27417a;
                    bArr2[i5] = bArr2[i4];
                    bVar.f27417a[i4] = b2;
                    i3 = (i3 + 1) % bArr.length;
                }
                int length = decode.length;
                byte[] bArr3 = new byte[length];
                int length2 = decode.length;
                int i6 = length2 + 0;
                if (i6 > decode.length) {
                    str3 = "input buffer too short, buffer length=" + decode.length + ", input length=" + i6;
                } else if (i6 <= length) {
                    for (int i7 = 0; i7 < length2; i7++) {
                        int i8 = (bVar.f27418b + 1) & 255;
                        bVar.f27418b = i8;
                        int i9 = (bVar.f27417a[i8] + bVar.f27419c) & 255;
                        bVar.f27419c = i9;
                        byte b3 = bVar.f27417a[i8];
                        bVar.f27417a[i8] = bVar.f27417a[i9];
                        bVar.f27417a[i9] = b3;
                        int i10 = i7 + 0;
                        bArr3[i10] = (byte) (bVar.f27417a[(bVar.f27417a[i8] + bVar.f27417a[i9]) & 255] ^ decode[i10]);
                    }
                    return new String(bArr3);
                } else {
                    str3 = "output buffer too short, buffer length=" + decode.length + ", output length=" + i6;
                }
                Log.e("BdLogRC4Utils", str3);
                return new String(bArr3);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}

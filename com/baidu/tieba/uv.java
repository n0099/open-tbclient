package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
/* loaded from: classes7.dex */
public final class uv {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static byte[] b;
    public static final uv c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319276, "Lcom/baidu/tieba/uv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319276, "Lcom/baidu/tieba/uv;");
                return;
            }
        }
        c = new uv();
        a = new int[]{219, 74, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 53, TTAdConstant.IMAGE_MODE_LIVE, 242, 116, 193, MatroskaExtractor.ID_TRACK_ENTRY, 134, 57, MatroskaExtractor.ID_PIXEL_WIDTH, 41, 16, 150, 94, 233, 21, 62, 77, 117, 76, 201, 232, 66, 209, 249, 34, 66, 113, 52, 203};
    }

    public uv() {
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

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() % 2 == 0) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 1; i < str.length(); i += 2) {
                        arrayList.add(Byte.valueOf((byte) Integer.parseInt("" + str.charAt(i - 1) + "" + str.charAt(i), CharsKt__CharJVMKt.checkRadix(16))));
                    }
                    if (arrayList.size() <= 16) {
                        return "";
                    }
                    if (b == null) {
                        b = new byte[a.length];
                        int length = a.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            byte[] bArr = b;
                            if (bArr == null) {
                                Intrinsics.throwNpe();
                            }
                            bArr[i2] = (byte) a[i2];
                        }
                    }
                    byte[] byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList.subList(0, 16));
                    byte[] bArr2 = b;
                    if (bArr2 == null) {
                        Intrinsics.throwNpe();
                    }
                    String a2 = ot.a(b(byteArray, bArr2, CollectionsKt___CollectionsKt.toByteArray(arrayList.subList(16, arrayList.size()))));
                    Intrinsics.checkExpressionValueIsNotNull(a2, "StringUtils.bytes2Str(decodeBytes)");
                    return a2;
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2, bArr3)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.c);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
            return cipher.doFinal(bArr3);
        }
        return (byte[]) invokeLLL.objValue;
    }
}

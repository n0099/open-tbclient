package com.bytedance.sdk.openadsdk.core.i;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.o;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public abstract class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // com.bytedance.sdk.openadsdk.core.i.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Context a2 = o.a();
                return a(MessageDigest.getInstance("SHA1").digest(a2.getPackageManager().getPackageInfo(a2.getPackageName(), 64).signatures[0].toByteArray())).toUpperCase();
            } catch (Throwable unused) {
                return "0000000000000000000000000000000000000000";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.i.b
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            char[] charArray = "0123456789abcdef".toCharArray();
            char[] cArr = new char[bArr.length * 2];
            for (byte b2 = 0; b2 < bArr.length; b2 = (byte) (b2 + 1)) {
                int i2 = bArr[b2] & 255;
                int i3 = b2 * 2;
                cArr[i3] = charArray[i2 >>> 4];
                cArr[i3 + 1] = charArray[i2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }
}

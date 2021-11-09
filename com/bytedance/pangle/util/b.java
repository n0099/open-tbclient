package com.bytedance.pangle.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes11.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f61516a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1401944984, "Lcom/bytedance/pangle/util/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1401944984, "Lcom/bytedance/pangle/util/b;");
                return;
            }
        }
        f61516a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
                return a(mac.doFinal(str.getBytes()));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; bArr != null && i2 < bArr.length; i2++) {
                String hexString = Integer.toHexString(bArr[i2] & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString().toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static void a(Request.Builder builder, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, builder, str, str2, str3) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.CHINA);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date());
            builder.addHeader("Authorization", "HMAC-SHA256 Credential=" + str2 + ",SignedHeaders=" + ("X-Mars-Date".toLowerCase() + ";") + ",Signature=" + a(("X-Mars-Date".toLowerCase() + ":" + format.replaceAll("\\s", "") + StringUtils.LF) + d.a(str), a(format, str3)));
            builder.addHeader("X-mars-date", format);
        }
    }
}

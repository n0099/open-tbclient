package com.bytedance.sdk.component.video.d;

import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final MessageDigest f28849a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f28850b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2068726242, "Lcom/bytedance/sdk/component/video/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2068726242, "Lcom/bytedance/sdk/component/video/d/a;");
                return;
            }
        }
        f28849a = a();
        f28850b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static MessageDigest a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            try {
                return MessageDigest.getInstance(PackageTable.MD5);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (MessageDigest) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        byte[] digest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            MessageDigest messageDigest = f28849a;
            if (messageDigest == null || TextUtils.isEmpty(str)) {
                return "";
            }
            byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
            synchronized (a.class) {
                digest = messageDigest.digest(bytes);
            }
            return a(digest);
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            char[] cArr = new char[bArr.length << 1];
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                char[] cArr2 = f28850b;
                cArr[i2] = cArr2[(b2 & 240) >> 4];
                i2 = i3 + 1;
                cArr[i3] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }
}

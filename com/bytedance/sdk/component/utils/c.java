package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, ArrayList<String>> f28783a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1410335973, "Lcom/bytedance/sdk/component/utils/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1410335973, "Lcom/bytedance/sdk/component/utils/c;");
                return;
            }
        }
        f28783a = new HashMap<>();
    }

    public static ArrayList<String> a(Context context, String str) {
        InterceptResult invokeLL;
        Signature[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            ArrayList<String> arrayList = null;
            if (context != null && str != null) {
                String packageName = context.getPackageName();
                if (packageName == null) {
                    return null;
                }
                if (f28783a.get(str) != null) {
                    return f28783a.get(str);
                }
                arrayList = new ArrayList<>();
                try {
                    for (Signature signature : b(context, packageName)) {
                        String str2 = "error!";
                        if ("MD5".equals(str)) {
                            str2 = a(signature, "MD5");
                        } else if ("SHA1".equals(str)) {
                            str2 = a(signature, "SHA1");
                        } else if ("SHA256".equals(str)) {
                            str2 = a(signature, "SHA256");
                        }
                        arrayList.add(str2);
                    }
                } catch (Exception e2) {
                    j.b(e2.toString());
                }
                f28783a.put(str, arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static Signature[] b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 64).signatures;
            } catch (Exception e2) {
                j.b(e2.toString());
                return null;
            }
        }
        return (Signature[]) invokeLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> a2 = a(context, "SHA1");
            if (a2 != null && a2.size() != 0) {
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    sb.append(a2.get(i2));
                    if (i2 < a2.size() - 1) {
                        sb.append(",");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(Signature signature, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, signature, str)) == null) {
            byte[] byteArray = signature.toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                        sb.append(":");
                    }
                    return sb.substring(0, sb.length() - 1).toString();
                }
                return "error!";
            } catch (Exception e2) {
                j.b(e2.toString());
                return "error!";
            }
        }
        return (String) invokeLL.objValue;
    }
}

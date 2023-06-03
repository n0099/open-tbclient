package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Locale;
/* loaded from: classes8.dex */
public class vdb {
    public static /* synthetic */ Interceptable $ic;
    public static final String[][] a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65543, null, z)) == null) ? z ? "https://raqweb.yy.com/" : "https://raq.yy.com/" : (String) invokeZ.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            if (i != 444111001) {
                switch (i) {
                    case 444222000:
                        return "参数为空，请检查";
                    case 444222001:
                        return "请求操作类型错误";
                    case 444222002:
                        return "请求操作附带参数为空";
                    case 444222003:
                        return "请求操作附带参数错误";
                    default:
                        switch (i) {
                            case 444222104:
                                return "授权APP返回的请求码出错";
                            case 444222105:
                                return "Json格式错误";
                            default:
                                return "未知错误";
                        }
                }
            }
            return "成功";
        }
        return (String) invokeI.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948238357, "Lcom/baidu/tieba/vdb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948238357, "Lcom/baidu/tieba/vdb;");
                return;
            }
        }
        a = new String[][]{new String[]{"com.duowan.mobile", "7.10.0"}};
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        String[][] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                boolean z = false;
                for (String[] strArr2 : a) {
                    if (strArr2.length > 1) {
                        String str = strArr2[0];
                        try {
                            if (udb.a(context.getPackageManager().getPackageInfo(str, 1).versionName, strArr2[1]) >= 0) {
                                Intent intent = new Intent();
                                intent.setClassName(str, "com.yy.udbauth.open.activity.AgentActivity");
                                if (udb.e(context, intent)) {
                                    return 0;
                                }
                            }
                            z = true;
                        } catch (Exception unused) {
                            z = false;
                        }
                    }
                }
                if (!z) {
                    return 1;
                }
                return 2;
            } catch (Exception unused2) {
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                for (Signature signature : signatureArr) {
                    if (signature != null) {
                        byteArrayOutputStream.write(signature.toByteArray());
                    }
                }
                byteArrayOutputStream.flush();
                String f = f(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return f;
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                        return "";
                    } catch (IOException unused2) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            char[] cArr = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                char[] cArr2 = new char[digest.length * 2];
                int i = 0;
                for (byte b : digest) {
                    int i2 = i + 1;
                    cArr2[i] = cArr[(b >>> 4) & 15];
                    i = i2 + 1;
                    cArr2[i2] = cArr[b & 15];
                }
                return new String(cArr2);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            return String.format(Locale.getDefault(), "%s?appId=%s&appType=android&appSign=%s&appDeviceid=%s&grantType=code&callbackType=uri&redirectUri=%s&state=%s", "https://thirdlogin.yy.com/open/oauth/authorize.do", str, b(context), tdb.a(context), g(z), str2);
        }
        return (String) invokeCommon.objValue;
    }

    public static Bundle d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appid", str);
            bundle.putString("appname", udb.b(context, context.getPackageName()));
            bundle.putString("appver", udb.c(context));
            bundle.putString("appdeviceid", tdb.a(context));
            bundle.putString(BaseStatisContent.SDKVER, "1.0.0");
            return bundle;
        }
        return (Bundle) invokeLL.objValue;
    }

    public static Intent e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            for (String[] strArr : a) {
                String str = strArr[0];
                Intent intent = new Intent();
                intent.setClassName(str, "com.yy.udbauth.open.activity.AgentActivity");
                if (udb.e(context, intent)) {
                    return intent;
                }
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }
}

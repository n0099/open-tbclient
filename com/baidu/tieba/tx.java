package com.baidu.tieba;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
/* loaded from: classes8.dex */
public final class tx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448318377, "Lcom/baidu/tieba/tx;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448318377, "Lcom/baidu/tieba/tx;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        MessageDigest messageDigest;
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    dataInputStream = new DataInputStream(new FileInputStream(str));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[131072];
                while (true) {
                    int read = dataInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String b = b(messageDigest.digest(), "");
                try {
                    dataInputStream.close();
                } catch (Exception unused) {
                }
                return b;
            } catch (Exception e2) {
                e = e2;
                dataInputStream2 = dataInputStream;
                e.printStackTrace();
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String processTypeString = WebKitFactory.getProcessTypeString();
            if (TextUtils.isEmpty(processTypeString) || !processTypeString.equals("1")) {
                Boolean bool = Boolean.FALSE;
                WebViewFactoryProvider provider = WebViewFactory.getProvider();
                if (provider != null) {
                    bool = (Boolean) provider.getStaticWebSeting(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE);
                }
                return bool.booleanValue();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = activeNetworkInfo.getType();
                if (activeNetworkInfo.isAvailable() && 1 == type) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(View view2) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view2)) == null) {
            if (view2 == null || (parent = view2.getParent()) == null || view2.getVisibility() != 0) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(view2);
            int childCount = viewGroup.getChildCount();
            if (indexOfChild == childCount - 1) {
                return true;
            }
            for (int i = indexOfChild + 1; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0 && childAt.getHeight() > 0 && childAt.getWidth() > 0 && view2.getHeight() > 0 && view2.getWidth() > 0 && childAt.getWidth() >= view2.getWidth() && childAt.getHeight() >= view2.getHeight()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                return URLEncoder.encode(new String(sx.a(str.getBytes())), "UTF-8");
            } catch (Exception e) {
                Log.printStackTrace(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}

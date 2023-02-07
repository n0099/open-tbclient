package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public final class ur9 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static boolean b;
    public static StringBuffer c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends wr9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.baidu.tieba.wr9
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                stringBuffer.append(simpleDateFormat.format(new Date()));
                stringBuffer.append("\t");
                stringBuffer.append(this.a);
                stringBuffer.append("\t");
                stringBuffer.append(this.b);
                stringBuffer.append("\t");
                stringBuffer.append(this.c);
                zr9.d(stringBuffer.toString(), com.baidu.ubs.analytics.d.a.c, ur9.c.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948220749, "Lcom/baidu/tieba/ur9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948220749, "Lcom/baidu/tieba/ur9;");
                return;
            }
        }
        c = new StringBuffer();
        if (tq9.h() != null) {
            a = !com.baidu.ubs.analytics.d.a.a();
            b = true;
            c.append("ABsdkLog-");
            c.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            c.append("_");
            try {
                c.append(c(pr9.g(tq9.h().getContext()).getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                cs9.d(e);
            } catch (Exception e2) {
                cs9.d(e2);
            }
            c.append(".log");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (a) {
                Log.w("BaiDuUbs", str);
            }
            d("w", "BaiDuUbs", str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            if (a) {
                Log.e("BaiDuUbs", str);
            }
            d("e", "BaiDuUbs", str);
        }
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr != null && bArr.length > 0) {
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) != null) || !b) {
            return;
        }
        vr9.a(new a(str, str2, str3));
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return c.toString();
        }
        return (String) invokeV.objValue;
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class o20 {
    public static /* synthetic */ Interceptable $ic;
    public static o20 g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Map<String, String> b;
    public String c;
    public String d;
    public String e;
    public p20 f;

    public o20() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = " ";
        this.c = null;
        this.d = null;
        this.b = new ConcurrentHashMap();
    }

    public static o20 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g == null) {
                synchronized (o20.class) {
                    if (g == null) {
                        g = new o20();
                    }
                }
            }
            return g;
        }
        return (o20) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (e20.d().d()) {
                if (this.f == null) {
                    this.f = new p20();
                }
                return this.f.a();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.e)) {
                return OkHttpNetworkFetcher.DEFAULT_USER_AGENT;
            }
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str3 = "";
            } else {
                str3 = str + "/";
            }
            return str3 + str2;
        }
        return (String) invokeLL.objValue;
    }

    public String c(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, strArr)) == null) {
            if (str == null) {
                return str;
            }
            j(str);
            String str2 = str + strArr;
            String str3 = this.b.get(str2);
            if (str3 == null) {
                str3 = d(AppRuntime.getAppContext(), str, strArr);
            }
            this.b.put(str2, str3);
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                str2 = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return a(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public final String d(Context context, String str, String... strArr) {
        InterceptResult invokeLLL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, strArr)) == null) {
            q20 d = e20.d();
            String b = d.b();
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(this.c)) {
                this.c = h(context);
            }
            sb2.append(str);
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                sb2.append(this.a);
                sb2.append(e);
            }
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2)) {
                        sb2.append(this.a);
                        sb2.append(str2);
                    }
                }
            }
            if (!TextUtils.isEmpty(b)) {
                sb2.append(this.a);
                sb2.append(b);
            }
            if (d.c()) {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = i();
                }
                sb2.append(this.a);
                sb2.append(this.d);
            }
            try {
                sb = sb2.toString().replaceFirst("(^.*$)", "$1 " + this.c);
            } catch (Exception unused) {
                sb2.append(this.a);
                sb2.append(this.c);
                sb = sb2.toString();
            }
            d.a(sb, strArr);
            return sb;
        }
        return (String) invokeLLL.objValue;
    }

    public final String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            String b = b(null, AppIdentityManager.getInstance().getUserAgentIdentity());
            String c = new m20().c(context);
            String e = new g20().e();
            return a(b, c + " (Baidu; P1 " + e + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (String) invokeL.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String appName = AppIdentityManager.getInstance().getAppName();
            String schemeHeader = e20.d().getSchemeHeader();
            StringBuilder sb = new StringBuilder();
            sb.append("bdapp/1.0");
            sb.append(this.a);
            sb.append("(");
            sb.append(appName);
            if (!TextUtils.isEmpty(schemeHeader)) {
                sb.append(ParamableElem.DIVIDE_PARAM);
                sb.append(this.a);
                sb.append(schemeHeader);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(str)) {
            this.e = str;
        }
    }
}

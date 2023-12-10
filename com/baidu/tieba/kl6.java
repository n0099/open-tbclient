package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tieba.a4b;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class kl6 {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static b c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, z3b> a;
    @Nullable
    public Context b;

    /* loaded from: classes7.dex */
    public interface b {
        boolean a(@NonNull String str);
    }

    /* loaded from: classes7.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.kl6.b
        public boolean a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947916980, "Lcom/baidu/tieba/kl6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947916980, "Lcom/baidu/tieba/kl6;");
                return;
            }
        }
        c = new a();
    }

    public kl6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
    }

    @NonNull
    public static String c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void f(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, webView) == null) {
            webView.setTag(R.id.obfuscated_res_0x7f092509, null);
            webView.setTag(R.id.obfuscated_res_0x7f0924b4, null);
        }
    }

    public static void h(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bVar) == null) {
            c = bVar;
        }
    }

    public void a(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, webView) == null) {
            this.b = webView.getContext();
            webView.setTag(R.id.obfuscated_res_0x7f092509, this);
        }
    }

    public static void g(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, webView) == null) {
            Object tag = webView.getTag(R.id.obfuscated_res_0x7f092509);
            if (!(tag instanceof kl6)) {
                return;
            }
            boolean z = true;
            Object tag2 = webView.getTag(R.id.obfuscated_res_0x7f0924b4);
            if (tag2 == null) {
                webView.setTag(R.id.obfuscated_res_0x7f0924b4, Boolean.FALSE);
            } else if (tag2 instanceof Boolean) {
                z = ((Boolean) tag2).booleanValue();
            }
            ((kl6) tag).i(webView.getUrl(), z);
        }
    }

    public final boolean d(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null || str.length() == 0) {
                return false;
            }
            if (!URLUtil.isAssetUrl(str) && !URLUtil.isFileUrl(str) && !URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || !d(str) || !c.a(str)) {
            return;
        }
        z3b remove = this.a.remove(c(str));
        if (remove == null) {
            return;
        }
        Monitor.a.c(remove, a4b.b.a).k();
    }

    public static void k(@NonNull WebView webView, boolean z, @NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{webView, Boolean.valueOf(z), map}) == null) {
            Object tag = webView.getTag(R.id.obfuscated_res_0x7f092509);
            if (!(tag instanceof kl6)) {
                return;
            }
            String url = webView.getUrl();
            kl6 kl6Var = (kl6) tag;
            if (z) {
                map.put("webviewWhiteType", "1");
                kl6Var.b(url, map);
                return;
            }
            kl6Var.j(url);
        }
    }

    public void b(@Nullable String str, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) != null) || !d(str) || !c.a(str)) {
            return;
        }
        z3b remove = this.a.remove(c(str));
        if (remove == null) {
            return;
        }
        Monitor.a.c(remove, a4b.a.a).b(e(str, map));
    }

    @NonNull
    public final Map<String, String> e(@NonNull String str, @Nullable Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, map)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue().toString());
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public void i(@Nullable String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048580, this, str, z) != null) || !d(str) || !c.a(str)) {
            return;
        }
        String c2 = c(str);
        z3b z3bVar = this.a.get(c2);
        String str3 = "webview_landing_page_white_first_show";
        if (z3bVar != null) {
            boolean equals = TextUtils.equals(z3bVar.l2(), "webview_landing_page_white_first_show");
            HashMap hashMap = new HashMap();
            if (equals == z) {
                str2 = "当前event已存在，手动报错";
            } else {
                str2 = "reshow二次展示时，首次还未展示，上报白屏";
            }
            hashMap.put("reason", str2);
            hashMap.put("webviewWhiteType", "4");
            b(str, hashMap);
        }
        if (!z) {
            str3 = "webview_landing_page_white_reshow";
        }
        z3b z3bVar2 = new z3b(c2, AlbumActivityConfig.FROM_WEB_VIEW, str3);
        this.a.put(c2, z3bVar2);
        Map<String, String> e = e(str, null);
        e.put("webviewWhiteType", "2");
        j4b<m4b> c3 = Monitor.a.c(z3bVar2, a4b.c.a);
        c3.f(e);
        c3.g();
    }
}

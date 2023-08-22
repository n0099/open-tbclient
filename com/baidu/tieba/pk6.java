package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.CheckWebResProxySwitch;
import com.baidu.tieba.browser.core.webview.flyweight.FlyWeightConfig;
import com.baidu.tieba.browser.core.webview.flyweight.loader.ImageLoader;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes7.dex */
public class pk6 implements rk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ok6 a;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ok6 a;

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

        public rk6 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new pk6(this);
            }
            return (rk6) invokeV.objValue;
        }

        public void c(ok6 ok6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ok6Var) == null) {
                this.a = ok6Var;
            }
        }
    }

    public pk6(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar.a;
    }

    @Override // com.baidu.tieba.rk6
    public WebResourceResponse a(String str, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, webResourceRequest)) == null) {
            if (webResourceRequest == null || !TextUtils.equals("GET", webResourceRequest.getMethod())) {
                return null;
            }
            String uri = webResourceRequest.getUrl().toString();
            if (!URLUtil.isNetworkUrl(uri)) {
                return null;
            }
            if (CheckWebResProxySwitch.isOn() && !uri.contains("tieba-ares.cdn") && !uri.contains("bdstatic.com") && !uri.contains(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE) && !uri.contains("tieba.com") && !uri.contains("baidu-int.com")) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("Proxy", "非贴吧url，不代理网络请求：" + uri);
                return null;
            }
            ok6 ok6Var = this.a;
            if (ok6Var != null && !ok6Var.a(str)) {
                return null;
            }
            return c(str, uri, webResourceRequest.getRequestHeaders());
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public final WebResourceResponse b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            qk6 qk6Var = ek6.b().get(str);
            if (qk6Var != null) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("Proxy", "PreFetch命中缓存，返回数据：" + qk6Var);
                if (qk6Var.b()) {
                    ek6.b().remove(str);
                }
                if (qk6Var.c()) {
                    return qk6Var.a();
                }
                ek6.b().remove(str);
                return null;
            }
            return null;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final WebResourceResponse c(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, map)) == null) {
            if (fk6.b().c(str2)) {
                long currentTimeMillis = System.currentTimeMillis();
                fk6.b().d(str2, 5000L);
                im6.b("Proxy", "当前已有请求，等待一下，waitTime = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b(str2);
            } else if (ek6.b().contains(str2)) {
                return b(str2);
            } else {
                if (FlyWeightConfig.c(str2, map)) {
                    String c = pm6.c(str2);
                    if (ek6.b().contains(c)) {
                        return b(c);
                    }
                    return lk6.g().b(str, str2, map);
                } else if (FlyWeightConfig.a(str2)) {
                    return ImageLoader.d(str, str2, map);
                } else {
                    return null;
                }
            }
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }
}

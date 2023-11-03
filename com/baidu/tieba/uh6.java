package com.baidu.tieba;

import android.text.Html;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.sapi2.SapiWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Codec;
/* loaded from: classes8.dex */
public class uh6 extends th6<WebResourceResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jh6<Pair<String, Map<String, String>>, Response> b;

    /* loaded from: classes8.dex */
    public class a implements xjc<Response, Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ uh6 c;

        public a(uh6 uh6Var, String str, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh6Var, str, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uh6Var;
            this.a = str;
            this.b = map;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xjc
        /* renamed from: b */
        public void a(Response response, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, exc) == null) {
                if (this.c.l(response) && response.body() != null && exc == null) {
                    try {
                        this.c.j(this.a, response, this.b);
                        TbLog hybridLog = HybridLog.getInstance();
                        hybridLog.i("PreFetch", "sendASyncRequest，预取成功:" + this.a + " headers:" + this.b);
                    } catch (IOException e) {
                        BdLog.e(e);
                    }
                }
                mh6.b().e(this.a);
            }
        }
    }

    public uh6() {
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
        this.b = new nh6();
    }

    public void p(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, map) == null) {
            mh6.b().a(str);
            Map<String, String> h = h(map);
            this.b.b(Pair.create(str, h), new a(this, str, h));
        }
    }

    @Override // com.baidu.tieba.th6
    public boolean e(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, map)) == null) {
            if (!URLUtil.isHttpsUrl(str2) && !URLUtil.isHttpUrl(str2)) {
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public final void o(String str, WebResourceResponse webResourceResponse, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, str, webResourceResponse, bArr) == null) && !vj6.d(bArr)) {
            lh6.b().put(str, new xh6(str, webResourceResponse, bArr));
        }
    }

    public final Map<String, String> h(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            CookieSyncManager.createInstance(ri6.b());
            String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
            if (!TextUtils.isEmpty(cookie)) {
                String str = map.get("Cookie");
                if (!TextUtils.isEmpty(str)) {
                    if (str.endsWith(ParamableElem.DIVIDE_PARAM)) {
                        cookie = str + cookie;
                    } else {
                        cookie = str + ParamableElem.DIVIDE_PARAM + cookie;
                    }
                }
                map.put("Cookie", cookie);
            }
            return map;
        }
        return (Map) invokeL.objValue;
    }

    public final Map<String, String> i(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, response)) == null) {
            Set<String> names = response.headers().names();
            HashMap hashMap = new HashMap();
            for (String str : names) {
                hashMap.put(str, response.header(str));
            }
            hashMap.put("access-control-allow-origin", "*");
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final String k(ResponseBody responseBody) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responseBody)) == null) {
            MediaType contentType = responseBody.contentType();
            if (contentType == null) {
                return "";
            }
            String mediaType = contentType.toString();
            if (TextUtils.isEmpty(mediaType) || (split = mediaType.split(ParamableElem.DIVIDE_PARAM)) == null || split.length <= 0 || TextUtils.isEmpty(split[0])) {
                return "";
            }
            return split[0].trim();
        }
        return (String) invokeL.objValue;
    }

    public final WebResourceResponse j(String str, Response response, Map<String, String> map) throws IOException {
        InterceptResult invokeLLL;
        ResponseBody body;
        WebResourceResponse webResourceResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, response, map)) == null) {
            if (response == null || !response.isSuccessful() || (body = response.body()) == null) {
                return null;
            }
            byte[] bytes = body.bytes();
            String k = k(body);
            if (dh6.isOn()) {
                webResourceResponse = new WebResourceResponse(k, response.header(Http2Codec.ENCODING, null), new ByteArrayInputStream(bytes));
            } else {
                webResourceResponse = new WebResourceResponse(k, response.header(Http2Codec.ENCODING, Util.UTF_8.name()), new ByteArrayInputStream(bytes));
            }
            webResourceResponse.setStatusCodeAndReasonPhrase(response.code(), com.baidu.mobads.sdk.internal.bx.k);
            Map<String, String> i = i(response);
            if (map.containsKey("tieba-response-via")) {
                i.put("tieba-response-via", PrefetchEvent.MODULE);
                i.put("tieba-response-time", String.valueOf(System.currentTimeMillis()));
            }
            webResourceResponse.setResponseHeaders(i);
            o(str, webResourceResponse, bytes);
            if (response.cacheResponse() != null) {
                pj6.c("PreFetch", "hit network cache：" + str);
            } else {
                pj6.c("PreFetch", "hit network：" + str);
            }
            if (map.containsKey("BdLoadMode") && TextUtils.equals(SapiWebView.DATA_MIME_TYPE, k)) {
                n(response, bytes);
            }
            return webResourceResponse;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public final boolean l(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, response)) == null) {
            if (response == null || !response.isSuccessful() || response.isRedirect() || response.body() == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.th6
    /* renamed from: m */
    public WebResourceResponse c(String str, String str2, Map<String, String> map) {
        InterceptResult invokeLLL;
        WebResourceResponse webResourceResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, str2, map)) == null) {
            mh6.b().a(str2);
            try {
                Map<String, String> h = h(map);
                webResourceResponse = j(str2, this.b.a(Pair.create(str2, h)), h);
            } catch (Exception e) {
                e.printStackTrace();
                webResourceResponse = null;
            }
            mh6.b().e(str2);
            return webResourceResponse;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public final void n(Response response, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, response, bArr) == null) {
            try {
                qh6 qh6Var = new qh6(response.request().isHttps());
                qh6Var.c("link", new ph6());
                qh6Var.c(ARPMessageType.ARPMessageParamKeys.MAP_NPC_KEY_NAME, new rh6());
                Html.fromHtml(new String(bArr), null, qh6Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

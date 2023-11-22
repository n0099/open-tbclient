package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes8.dex */
public class wba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebView a;
    public BdUniqueId b;
    public jsa c;
    public Map<String, Boolean> d;
    public Map<String, String> e;
    public Map<String, String> f;
    public String g;
    public HttpMessageListener h;

    /* loaded from: classes8.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wba a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wba wbaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wbaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wbaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x018b  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            String str2;
            String str3;
            int i;
            boolean z;
            int i2;
            String str4;
            String str5;
            String p;
            StringBuilder sb;
            String str6;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof QuickWebViewHttpResMsg)) {
                return;
            }
            QuickWebViewHttpResMsg quickWebViewHttpResMsg = (QuickWebViewHttpResMsg) httpResponsedMessage;
            int i3 = 0;
            String str7 = null;
            if (!(quickWebViewHttpResMsg.getOrginalMessage() instanceof QuickWebViewHttpReqMsg)) {
                str = "";
                str2 = null;
                str3 = null;
                i = 0;
            } else {
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = (QuickWebViewHttpReqMsg) quickWebViewHttpResMsg.getOrginalMessage();
                boolean z2 = quickWebViewHttpReqMsg.isFromRequestByNative;
                if (StringUtils.isNull(quickWebViewHttpReqMsg.url)) {
                    str = "";
                    str2 = null;
                    str3 = null;
                    i = z2;
                } else {
                    String str8 = quickWebViewHttpReqMsg.url;
                    str = quickWebViewHttpReqMsg.module;
                    str3 = quickWebViewHttpReqMsg.urlSign;
                    String str9 = quickWebViewHttpReqMsg.jsCallbackMethod;
                    if (TextUtils.isEmpty(str9) && z2 == 0) {
                        str9 = (String) this.a.e.remove(str3);
                        i3 = 1;
                    }
                    z = ((Boolean) this.a.d.remove(str3)).booleanValue();
                    str7 = str9;
                    str2 = str8;
                    i2 = z2;
                    if (!quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                        str5 = quickWebViewHttpResMsg.getResult();
                        str4 = BasicPushStatus.SUCCESS_CODE;
                    } else {
                        str4 = quickWebViewHttpResMsg.getError() + "";
                        str5 = "\"\"";
                    }
                    p = xba.n().p(str);
                    if (p == null) {
                        p = "0.0.0.0";
                    }
                    sb = new StringBuilder();
                    sb.append("{");
                    sb.append("\"status\":");
                    sb.append("\"");
                    sb.append(str4);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"data\":");
                    sb.append(str5);
                    sb.append(",");
                    sb.append("\"cache_version\":");
                    sb.append("\"");
                    sb.append(p);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"cache\":");
                    sb.append("\"");
                    sb.append(i3);
                    sb.append("\"");
                    sb.append(",");
                    sb.append("\"fromPreRequest\":");
                    sb.append("\"");
                    sb.append(i2 ^ 1);
                    sb.append("\"");
                    sb.append("}");
                    Log.d("QuickWebViewHttpProxy", "网络请求结果：fromPreRequest=" + (i2 ^ 1));
                    if (i2 != 0 && !z) {
                        if (StringUtils.isNull(str7)) {
                            Log.d("QuickWebViewHttpProxy", "请求完成：预请求-收到网络请求结果（" + httpResponsedMessage.getStatusCode() + "），缓存请求结果：url=" + str2);
                            this.a.f.put(str3, sb.toString());
                            return;
                        }
                        Log.d("QuickWebViewHttpProxy", "请求完成：预请求-收到网络请求结果（" + httpResponsedMessage.getStatusCode() + "），开始回调js函数(" + str7 + ")：url=" + str2);
                        this.a.l(str7, sb.toString());
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("请求完成：");
                    if (i2 == 0) {
                        str6 = "端能力";
                    } else {
                        str6 = "预请求";
                    }
                    sb2.append(str6);
                    sb2.append("-收到网络请求结果（");
                    sb2.append(httpResponsedMessage.getStatusCode());
                    sb2.append("），开始回调端能力：url=");
                    sb2.append(str2);
                    Log.d("QuickWebViewHttpProxy", sb2.toString());
                    this.a.i(str2, sb.toString());
                }
            }
            z = false;
            i2 = i;
            if (!quickWebViewHttpResMsg.isSuccess()) {
            }
            str4 = quickWebViewHttpResMsg.getError() + "";
            str5 = "\"\"";
            p = xba.n().p(str);
            if (p == null) {
            }
            sb = new StringBuilder();
            sb.append("{");
            sb.append("\"status\":");
            sb.append("\"");
            sb.append(str4);
            sb.append("\"");
            sb.append(",");
            sb.append("\"data\":");
            sb.append(str5);
            sb.append(",");
            sb.append("\"cache_version\":");
            sb.append("\"");
            sb.append(p);
            sb.append("\"");
            sb.append(",");
            sb.append("\"cache\":");
            sb.append("\"");
            sb.append(i3);
            sb.append("\"");
            sb.append(",");
            sb.append("\"fromPreRequest\":");
            sb.append("\"");
            sb.append(i2 ^ 1);
            sb.append("\"");
            sb.append("}");
            Log.d("QuickWebViewHttpProxy", "网络请求结果：fromPreRequest=" + (i2 ^ 1));
            if (i2 != 0) {
            }
            StringBuilder sb22 = new StringBuilder();
            sb22.append("请求完成：");
            if (i2 == 0) {
            }
            sb22.append(str6);
            sb22.append("-收到网络请求结果（");
            sb22.append(httpResponsedMessage.getStatusCode());
            sb22.append("），开始回调端能力：url=");
            sb22.append(str2);
            Log.d("QuickWebViewHttpProxy", sb22.toString());
            this.a.i(str2, sb.toString());
        }
    }

    public wba(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.h = new a(this, CmdConfigHttp.CMD_WEB_HTTP_PROXY);
        this.a = webView;
        this.g = webView.getSettings().getUserAgentString();
        BdUniqueId gen = BdUniqueId.gen();
        this.b = gen;
        this.h.setTag(gen);
        this.h.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.h);
    }

    public void n(jsa jsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsaVar) == null) {
            this.c = jsaVar;
        }
    }

    public void k(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, quickWebViewBridgeData, str, z) == null) {
            Log.d("QuickWebViewHttpProxy", "端能力请求：" + quickWebViewBridgeData.url);
            f(quickWebViewBridgeData, str, z);
        }
    }

    public final void f(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048576, this, quickWebViewBridgeData, str, z) == null) && quickWebViewBridgeData != null && !StringUtils.isNull(quickWebViewBridgeData.url) && !StringUtils.isNull(quickWebViewBridgeData.type)) {
            String g = g(quickWebViewBridgeData.url);
            String remove = this.f.remove(g);
            if (!TextUtils.isEmpty(remove) && str != null) {
                Log.d("QuickWebViewHttpProxy", "请求完成：命中预请求缓存-执行js回调，url=" + quickWebViewBridgeData.url);
                l(str, remove);
            } else if (!TextUtils.isEmpty(remove) && z) {
                Log.d("QuickWebViewHttpProxy", "请求完成：命中预请求缓存-执行端能力回调，url=" + quickWebViewBridgeData.url);
                i(quickWebViewBridgeData.url, remove);
            } else {
                if (this.d.containsKey(g)) {
                    if (!TextUtils.isEmpty(str)) {
                        Log.d("QuickWebViewHttpProxy", "加入等待队列：重复的请求-js回调函数-等待网络结果完成后回调，url=" + quickWebViewBridgeData.url);
                        this.e.put(g, str);
                        return;
                    } else if (z) {
                        Log.d("QuickWebViewHttpProxy", "加入等待队列：重复的请求-端能力-等待网络结果完成后回调，url=" + quickWebViewBridgeData.url);
                        this.d.put(g, Boolean.TRUE);
                        return;
                    }
                }
                StringBuilder sb = new StringBuilder();
                if (z) {
                    str2 = "端能力";
                } else {
                    str2 = "预请求";
                }
                sb.append(str2);
                sb.append("-正在发起网络请求：");
                sb.append(quickWebViewBridgeData.url);
                Log.d("QuickWebViewHttpProxy", sb.toString());
                this.d.put(g, Boolean.valueOf(z));
                m(quickWebViewBridgeData, str, z, g);
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                Uri parse = Uri.parse(str);
                String str2 = parse.getScheme() + "://" + parse.getAuthority() + parse.getPath();
                TreeSet<String> treeSet = new TreeSet(parse.getQueryParameterNames());
                StringBuilder sb = new StringBuilder();
                boolean z = true;
                for (String str3 : treeSet) {
                    if (z) {
                        z = false;
                        sb.append("?");
                        sb.append(str3);
                        sb.append("=");
                        sb.append(parse.getQueryParameter(str3));
                    } else {
                        sb.append("&");
                        sb.append(str3);
                        sb.append("=");
                        sb.append(parse.getQueryParameter(str3));
                    }
                }
                return wd.c(str2 + ((Object) sb));
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().removeMessage(this.b);
            this.d.clear();
            this.d = null;
            this.e.clear();
            this.e = null;
            this.f.clear();
            this.f = null;
        }
    }

    public final void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("result", str2);
            linkedHashMap.put("NotificationKey", str);
            this.c.i(this.a, "RequestByNativeToH5", linkedHashMap);
        }
    }

    public void j(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, quickWebViewBridgeData, str) == null) {
            Log.d("QuickWebViewHttpProxy", "预请求：" + quickWebViewBridgeData.url);
            f(quickWebViewBridgeData, str, false);
        }
    }

    public final void l(String str, String str2) {
        WebView webView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && (webView = this.a) != null) {
            webView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    public final void m(QuickWebViewBridgeData quickWebViewBridgeData, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{quickWebViewBridgeData, str, Boolean.valueOf(z), str2}) == null) {
            QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
            quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
            quickWebViewHttpReqMsg.urlSign = str2;
            quickWebViewHttpReqMsg.module = quickWebViewBridgeData.module;
            quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
            quickWebViewHttpReqMsg.jsCallbackMethod = str;
            quickWebViewHttpReqMsg.setTag(this.b);
            quickWebViewHttpReqMsg.isFromRequestByNative = z;
            CookieSyncManager.createInstance(this.a.getContext());
            String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
            if (!TextUtils.isEmpty(cookie)) {
                HashMap<String, String> headers = quickWebViewHttpReqMsg.getHeaders();
                if (headers != null) {
                    String str3 = headers.get("Cookie");
                    if (!TextUtils.isEmpty(str3)) {
                        if (str3.endsWith(ParamableElem.DIVIDE_PARAM)) {
                            cookie = str3 + cookie;
                        } else {
                            cookie = str3 + ParamableElem.DIVIDE_PARAM + cookie;
                        }
                    }
                    quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                } else {
                    quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                }
            }
            quickWebViewHttpReqMsg.setUserAgent(this.g);
            quickWebViewHttpReqMsg.addCookie("cache_version", xba.n().p(quickWebViewBridgeData.module));
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_WEB_HTTP_PROXY, quickWebViewBridgeData.url);
            tbHttpMessageTask.setResponsedClass(QuickWebViewHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setPriority(4);
            if (quickWebViewBridgeData.type.toLowerCase().equals(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND)) {
                Map<String, String> map = quickWebViewBridgeData.data;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : quickWebViewBridgeData.data.entrySet()) {
                        quickWebViewHttpReqMsg.addParam(entry.getKey(), entry.getValue());
                    }
                }
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            } else {
                tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            }
            MessageManager.getInstance().sendMessage(quickWebViewHttpReqMsg, tbHttpMessageTask);
        }
    }
}

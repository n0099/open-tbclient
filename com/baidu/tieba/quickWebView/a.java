package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
public class a {
    private String mSg;
    private final WebView mWebView;
    private HashSet<String> mSd = new HashSet<>();
    private HashMap<String, String> mSe = new HashMap<>();
    private HashMap<String, String> mSf = new HashMap<>();
    private HttpMessageListener fbX = new HttpMessageListener(1003364) { // from class: com.baidu.tieba.quickWebView.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0113  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0116  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            boolean z;
            String str2;
            String str3;
            String str4;
            String Rl;
            boolean z2;
            if (httpResponsedMessage instanceof QuickWebViewHttpResMsg) {
                String str5 = "";
                QuickWebViewHttpResMsg quickWebViewHttpResMsg = (QuickWebViewHttpResMsg) httpResponsedMessage;
                if (quickWebViewHttpResMsg.getOrginalMessage() instanceof QuickWebViewHttpReqMsg) {
                    QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = (QuickWebViewHttpReqMsg) quickWebViewHttpResMsg.getOrginalMessage();
                    if (!StringUtils.isNull(quickWebViewHttpReqMsg.url)) {
                        str2 = quickWebViewHttpReqMsg.url;
                        long j = quickWebViewHttpReqMsg.begin;
                        str5 = quickWebViewHttpReqMsg.module;
                        str = quickWebViewHttpReqMsg.jsCallbackMethod;
                        if (TextUtils.isEmpty(str)) {
                            str = (String) a.this.mSe.remove(str2);
                            if (!TextUtils.isEmpty(str)) {
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        a.this.mSd.remove(str2);
                        z = z2;
                        if (!quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                            str3 = BasicPushStatus.SUCCESS_CODE;
                            str4 = quickWebViewHttpResMsg.getResult();
                        } else {
                            str3 = quickWebViewHttpResMsg.getError() + "";
                            str4 = "\"\"";
                        }
                        int i = z ? 1 : 0;
                        Rl = b.dCX().Rl(str5);
                        if (Rl == null) {
                            Rl = "0.0.0.0";
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("{");
                        sb.append("\"status\":");
                        sb.append("\"");
                        sb.append(str3);
                        sb.append("\"");
                        sb.append(",");
                        sb.append("\"data\":");
                        sb.append(str4);
                        sb.append(",");
                        sb.append("\"cache_version\":");
                        sb.append("\"");
                        sb.append(Rl);
                        sb.append("\"");
                        sb.append(",");
                        sb.append("\"cache\":");
                        sb.append("\"");
                        sb.append(i);
                        sb.append("\"");
                        sb.append("}");
                        if (!StringUtils.isNull(str)) {
                            a.this.mSf.put(str2, sb.toString());
                            return;
                        } else {
                            a.this.runJsMethod(str, sb.toString());
                            return;
                        }
                    }
                }
                str = null;
                z = false;
                str2 = null;
                if (!quickWebViewHttpResMsg.isSuccess()) {
                }
                str3 = quickWebViewHttpResMsg.getError() + "";
                str4 = "\"\"";
                if (z) {
                }
                Rl = b.dCX().Rl(str5);
                if (Rl == null) {
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("{");
                sb2.append("\"status\":");
                sb2.append("\"");
                sb2.append(str3);
                sb2.append("\"");
                sb2.append(",");
                sb2.append("\"data\":");
                sb2.append(str4);
                sb2.append(",");
                sb2.append("\"cache_version\":");
                sb2.append("\"");
                sb2.append(Rl);
                sb2.append("\"");
                sb2.append(",");
                sb2.append("\"cache\":");
                sb2.append("\"");
                sb2.append(i);
                sb2.append("\"");
                sb2.append("}");
                if (!StringUtils.isNull(str)) {
                }
            }
        }
    };
    private BdUniqueId fIy = BdUniqueId.gen();

    public a(WebView webView) {
        this.mWebView = webView;
        this.mSg = webView.getSettings().getUserAgentString();
        this.fbX.setTag(this.fIy);
        this.fbX.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fbX);
    }

    public void a(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        String str2;
        if (quickWebViewBridgeData != null && !StringUtils.isNull(quickWebViewBridgeData.url) && !StringUtils.isNull(quickWebViewBridgeData.type)) {
            String remove = this.mSf.remove(quickWebViewBridgeData.url);
            if (!StringUtils.isNull(remove) && str != null) {
                runJsMethod(str, remove);
            } else if (this.mSd.contains(quickWebViewBridgeData.url)) {
                if (!TextUtils.isEmpty(str)) {
                    this.mSe.put(quickWebViewBridgeData.url, str);
                }
            } else {
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
                quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
                quickWebViewHttpReqMsg.module = quickWebViewBridgeData.module;
                quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
                quickWebViewHttpReqMsg.jsCallbackMethod = str;
                quickWebViewHttpReqMsg.setTag(this.fIy);
                CookieSyncManager.createInstance(this.mWebView.getContext());
                String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
                if (!TextUtils.isEmpty(cookie)) {
                    HashMap<String, String> headers = quickWebViewHttpReqMsg.getHeaders();
                    if (headers != null) {
                        String str3 = headers.get(SM.COOKIE);
                        if (TextUtils.isEmpty(str3)) {
                            str2 = cookie;
                        } else if (str3.endsWith(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                            str2 = str3 + cookie;
                        } else {
                            str2 = str3 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + cookie;
                        }
                        quickWebViewHttpReqMsg.addHeader(SM.COOKIE, str2);
                    } else {
                        quickWebViewHttpReqMsg.addHeader(SM.COOKIE, cookie);
                    }
                }
                quickWebViewHttpReqMsg.setUserAgent(this.mSg);
                quickWebViewHttpReqMsg.addCookie("cache_version", b.dCX().Rl(quickWebViewBridgeData.module));
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003364, quickWebViewBridgeData.url);
                tbHttpMessageTask.setResponsedClass(QuickWebViewHttpResMsg.class);
                tbHttpMessageTask.setIsNeedAddCommenParam(false);
                tbHttpMessageTask.setIsUseCurrentBDUSS(false);
                tbHttpMessageTask.setPriority(4);
                if (quickWebViewBridgeData.type.toLowerCase().equals("post")) {
                    if (quickWebViewBridgeData.data != null && !quickWebViewBridgeData.data.isEmpty()) {
                        for (Map.Entry<String, String> entry : quickWebViewBridgeData.data.entrySet()) {
                            quickWebViewHttpReqMsg.addParam(entry.getKey(), entry.getValue());
                        }
                    }
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
                } else {
                    tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
                }
                MessageManager.getInstance().sendMessage(quickWebViewHttpReqMsg, tbHttpMessageTask);
                this.mSd.add(quickWebViewBridgeData.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runJsMethod(String str, String str2) {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.fIy);
        MessageManager.getInstance().removeMessage(this.fIy);
        this.mSd.clear();
        this.mSd = null;
        this.mSe.clear();
        this.mSe = null;
        this.mSf.clear();
        this.mSf = null;
    }
}

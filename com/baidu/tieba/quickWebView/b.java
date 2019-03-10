package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private final QuickWebView eyl;
    private String ifQ;
    private HashSet<String> ifN = new HashSet<>();
    private HashMap<String, String> ifO = new HashMap<>();
    private HashMap<String, String> ifP = new HashMap<>();
    private HttpMessageListener bKq = new HttpMessageListener(CmdConfigHttp.CMD_WEB_HTTP_PROXY) { // from class: com.baidu.tieba.quickWebView.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0109  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            String str2;
            boolean z;
            String str3;
            if (httpResponsedMessage instanceof QuickWebViewHttpResMsg) {
                QuickWebViewHttpResMsg quickWebViewHttpResMsg = (QuickWebViewHttpResMsg) httpResponsedMessage;
                if (quickWebViewHttpResMsg.getOrginalMessage() instanceof QuickWebViewHttpReqMsg) {
                    QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = (QuickWebViewHttpReqMsg) quickWebViewHttpResMsg.getOrginalMessage();
                    if (!StringUtils.isNull(quickWebViewHttpReqMsg.url)) {
                        str2 = quickWebViewHttpReqMsg.url;
                        long j = quickWebViewHttpReqMsg.begin;
                        str = quickWebViewHttpReqMsg.jsCallbackMethod;
                        if (TextUtils.isEmpty(str)) {
                            str = (String) b.this.ifO.remove(str2);
                            if (!TextUtils.isEmpty(str)) {
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        b.this.ifN.remove(str2);
                        String str4 = "\"\"";
                        if (!quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                            str3 = BasicPushStatus.SUCCESS_CODE;
                            str4 = quickWebViewHttpResMsg.getResult();
                        } else {
                            str3 = quickWebViewHttpResMsg.getError() + "";
                        }
                        int i = z ? 1 : 0;
                        String bWj = c.bWi().bWj();
                        StringBuilder sb = new StringBuilder();
                        sb.append("{");
                        sb.append("\"status\":");
                        sb.append("\"");
                        sb.append(str3);
                        sb.append("\"");
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append("\"data\":");
                        sb.append(str4);
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append("\"cache_version\":");
                        sb.append("\"");
                        sb.append(bWj);
                        sb.append("\"");
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append("\"cache\":");
                        sb.append("\"");
                        sb.append(i);
                        sb.append("\"");
                        sb.append("}");
                        if (!StringUtils.isNull(str)) {
                            b.this.ifP.put(str2, sb.toString());
                            return;
                        } else {
                            b.this.runJsMethod(str, sb.toString());
                            return;
                        }
                    }
                }
                str = null;
                str2 = null;
                z = false;
                String str42 = "\"\"";
                if (!quickWebViewHttpResMsg.isSuccess()) {
                }
                str3 = quickWebViewHttpResMsg.getError() + "";
                if (z) {
                }
                String bWj2 = c.bWi().bWj();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("{");
                sb2.append("\"status\":");
                sb2.append("\"");
                sb2.append(str3);
                sb2.append("\"");
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append("\"data\":");
                sb2.append(str42);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb2.append("\"cache_version\":");
                sb2.append("\"");
                sb2.append(bWj2);
                sb2.append("\"");
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
    private BdUniqueId cnX = BdUniqueId.gen();

    public b(QuickWebView quickWebView) {
        this.eyl = quickWebView;
        this.ifQ = quickWebView.getSettings().getUserAgentString();
        this.bKq.setTag(this.cnX);
        this.bKq.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bKq);
    }

    public void a(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        String str2;
        if (quickWebViewBridgeData != null && !StringUtils.isNull(quickWebViewBridgeData.url) && !StringUtils.isNull(quickWebViewBridgeData.type)) {
            String remove = this.ifP.remove(quickWebViewBridgeData.url);
            if (!StringUtils.isNull(remove) && str != null) {
                runJsMethod(str, remove);
            } else if (this.ifN.contains(quickWebViewBridgeData.url)) {
                if (!TextUtils.isEmpty(str)) {
                    this.ifO.put(quickWebViewBridgeData.url, str);
                }
            } else {
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
                quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
                quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
                quickWebViewHttpReqMsg.jsCallbackMethod = str;
                quickWebViewHttpReqMsg.setTag(this.cnX);
                CookieSyncManager.createInstance(this.eyl.getContext());
                String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
                if (!TextUtils.isEmpty(cookie)) {
                    HashMap<String, String> headers = quickWebViewHttpReqMsg.getHeaders();
                    if (headers != null) {
                        String str3 = headers.get("Cookie");
                        if (TextUtils.isEmpty(str3)) {
                            str2 = cookie;
                        } else if (str3.endsWith(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                            str2 = str3 + cookie;
                        } else {
                            str2 = str3 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + cookie;
                        }
                        quickWebViewHttpReqMsg.addHeader("Cookie", str2);
                    } else {
                        quickWebViewHttpReqMsg.addHeader("Cookie", cookie);
                    }
                }
                quickWebViewHttpReqMsg.setUserAgent(this.ifQ);
                quickWebViewHttpReqMsg.addCookie("cache_version", c.bWi().bWj());
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_WEB_HTTP_PROXY, quickWebViewBridgeData.url);
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
                this.ifN.add(quickWebViewBridgeData.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runJsMethod(String str, String str2) {
        if (this.eyl != null) {
            this.eyl.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.cnX);
        MessageManager.getInstance().removeMessage(this.cnX);
        this.ifN.clear();
        this.ifN = null;
        this.ifO.clear();
        this.ifO = null;
        this.ifP.clear();
        this.ifP = null;
    }
}

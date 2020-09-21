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
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
public class b {
    private final QuickWebView hxM;
    private String lJO;
    private HashSet<String> lJL = new HashSet<>();
    private HashMap<String, String> lJM = new HashMap<>();
    private HashMap<String, String> lJN = new HashMap<>();
    private HttpMessageListener emP = new HttpMessageListener(1003364) { // from class: com.baidu.tieba.quickWebView.b.1
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
                            str = (String) b.this.lJM.remove(str2);
                            if (!TextUtils.isEmpty(str)) {
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        b.this.lJL.remove(str2);
                        String str4 = "\"\"";
                        if (!quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                            str3 = BasicPushStatus.SUCCESS_CODE;
                            str4 = quickWebViewHttpResMsg.getResult();
                        } else {
                            str3 = quickWebViewHttpResMsg.getError() + "";
                        }
                        int i = z ? 1 : 0;
                        String dqp = c.dqo().dqp();
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
                        sb.append(dqp);
                        sb.append("\"");
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append("\"cache\":");
                        sb.append("\"");
                        sb.append(i);
                        sb.append("\"");
                        sb.append("}");
                        if (!StringUtils.isNull(str)) {
                            b.this.lJN.put(str2, sb.toString());
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
                String dqp2 = c.dqo().dqp();
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
                sb2.append(dqp2);
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
    private BdUniqueId eSq = BdUniqueId.gen();

    public b(QuickWebView quickWebView) {
        this.hxM = quickWebView;
        this.lJO = quickWebView.getSettings().getUserAgentString();
        this.emP.setTag(this.eSq);
        this.emP.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.emP);
    }

    public void a(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        String str2;
        if (quickWebViewBridgeData != null && !StringUtils.isNull(quickWebViewBridgeData.url) && !StringUtils.isNull(quickWebViewBridgeData.type)) {
            String remove = this.lJN.remove(quickWebViewBridgeData.url);
            if (!StringUtils.isNull(remove) && str != null) {
                runJsMethod(str, remove);
            } else if (this.lJL.contains(quickWebViewBridgeData.url)) {
                if (!TextUtils.isEmpty(str)) {
                    this.lJM.put(quickWebViewBridgeData.url, str);
                }
            } else {
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
                quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
                quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
                quickWebViewHttpReqMsg.jsCallbackMethod = str;
                quickWebViewHttpReqMsg.setTag(this.eSq);
                CookieSyncManager.createInstance(this.hxM.getContext());
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
                quickWebViewHttpReqMsg.setUserAgent(this.lJO);
                quickWebViewHttpReqMsg.addCookie("cache_version", c.dqo().dqp());
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
                this.lJL.add(quickWebViewBridgeData.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runJsMethod(String str, String str2) {
        if (this.hxM != null) {
            this.hxM.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.eSq);
        MessageManager.getInstance().removeMessage(this.eSq);
        this.lJL.clear();
        this.lJL = null;
        this.lJM.clear();
        this.lJM = null;
        this.lJN.clear();
        this.lJN = null;
    }
}

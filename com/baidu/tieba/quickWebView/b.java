package com.baidu.tieba.quickWebView;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpReqMsg;
import com.baidu.tieba.quickWebView.message.QuickWebViewHttpResMsg;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private final QuickWebView bZn;
    private String fAv;
    private HashSet<String> fAr = new HashSet<>();
    private HashMap<String, String> fAs = new HashMap<>();
    private HashMap<String, String> fAt = new HashMap<>();
    private HttpMessageListener dJU = new HttpMessageListener(CmdConfigHttp.CMD_WEB_HTTP_PROXY) { // from class: com.baidu.tieba.quickWebView.b.1
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
                            str = (String) b.this.fAs.remove(str2);
                            if (!TextUtils.isEmpty(str)) {
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        b.this.fAr.remove(str2);
                        String str4 = "\"\"";
                        if (!quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                            str3 = "200";
                            str4 = quickWebViewHttpResMsg.getResult();
                        } else {
                            str3 = quickWebViewHttpResMsg.getError() + "";
                        }
                        int i = z ? 1 : 0;
                        String bfq = c.bfp().bfq();
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
                        sb.append(bfq);
                        sb.append("\"");
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append("\"cache\":");
                        sb.append("\"");
                        sb.append(i);
                        sb.append("\"");
                        sb.append("}");
                        if (!StringUtils.isNull(str)) {
                            b.this.fAt.put(str2, sb.toString());
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
                String bfq2 = c.bfp().bfq();
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
                sb2.append(bfq2);
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
    private String fAu = ".tieba.baidu.com";
    private BdUniqueId aPk = BdUniqueId.gen();

    public b(QuickWebView quickWebView) {
        this.bZn = quickWebView;
        this.fAv = quickWebView.getSettings().getUserAgentString();
        this.dJU.setTag(this.aPk);
        this.dJU.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.dJU);
    }

    public void a(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        if (quickWebViewBridgeData != null && !StringUtils.isNull(quickWebViewBridgeData.url) && !StringUtils.isNull(quickWebViewBridgeData.type)) {
            String remove = this.fAt.remove(quickWebViewBridgeData.url);
            if (!StringUtils.isNull(remove) && str != null) {
                runJsMethod(str, remove);
            } else if (this.fAr.contains(quickWebViewBridgeData.url)) {
                if (!TextUtils.isEmpty(str)) {
                    this.fAs.put(quickWebViewBridgeData.url, str);
                }
            } else {
                String currentBduss = TbadkCoreApplication.getCurrentBduss();
                String str2 = null;
                if (com.baidu.tbadk.core.a.a.oU().cn(TbadkCoreApplication.getCurrentBduss()) != null) {
                    str2 = e.d(TbadkCoreApplication.getCurrentAccountInfo());
                }
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
                quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
                quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
                quickWebViewHttpReqMsg.jsCallbackMethod = str;
                quickWebViewHttpReqMsg.setTag(this.aPk);
                quickWebViewHttpReqMsg.addCookie("BDUSS", currentBduss);
                quickWebViewHttpReqMsg.addCookie("STOKEN", str2);
                quickWebViewHttpReqMsg.addCookie("domain", this.fAu);
                quickWebViewHttpReqMsg.setUserAgent(this.fAv);
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
                this.fAr.add(quickWebViewBridgeData.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runJsMethod(String str, String str2) {
        if (this.bZn != null) {
            this.bZn.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.aPk);
        MessageManager.getInstance().removeMessage(this.aPk);
        this.fAr.clear();
        this.fAr = null;
        this.fAs.clear();
        this.fAs = null;
        this.fAt.clear();
        this.fAt = null;
    }
}

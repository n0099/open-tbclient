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
    private final QuickWebView bZz;
    private String fAJ;
    private HashSet<String> fAF = new HashSet<>();
    private HashMap<String, String> fAG = new HashMap<>();
    private HashMap<String, String> fAH = new HashMap<>();
    private HttpMessageListener dKi = new HttpMessageListener(CmdConfigHttp.CMD_WEB_HTTP_PROXY) { // from class: com.baidu.tieba.quickWebView.b.1
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
                            str = (String) b.this.fAG.remove(str2);
                            if (!TextUtils.isEmpty(str)) {
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        b.this.fAF.remove(str2);
                        String str4 = "\"\"";
                        if (!quickWebViewHttpResMsg.isSuccess() && !TextUtils.isEmpty(quickWebViewHttpResMsg.getResult())) {
                            str3 = "200";
                            str4 = quickWebViewHttpResMsg.getResult();
                        } else {
                            str3 = quickWebViewHttpResMsg.getError() + "";
                        }
                        int i = z ? 1 : 0;
                        String bfv = c.bfu().bfv();
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
                        sb.append(bfv);
                        sb.append("\"");
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb.append("\"cache\":");
                        sb.append("\"");
                        sb.append(i);
                        sb.append("\"");
                        sb.append("}");
                        if (!StringUtils.isNull(str)) {
                            b.this.fAH.put(str2, sb.toString());
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
                String bfv2 = c.bfu().bfv();
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
                sb2.append(bfv2);
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
    private String fAI = ".tieba.baidu.com";
    private BdUniqueId aPx = BdUniqueId.gen();

    public b(QuickWebView quickWebView) {
        this.bZz = quickWebView;
        this.fAJ = quickWebView.getSettings().getUserAgentString();
        this.dKi.setTag(this.aPx);
        this.dKi.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.dKi);
    }

    public void a(QuickWebViewBridgeData quickWebViewBridgeData, String str) {
        if (quickWebViewBridgeData != null && !StringUtils.isNull(quickWebViewBridgeData.url) && !StringUtils.isNull(quickWebViewBridgeData.type)) {
            String remove = this.fAH.remove(quickWebViewBridgeData.url);
            if (!StringUtils.isNull(remove) && str != null) {
                runJsMethod(str, remove);
            } else if (this.fAF.contains(quickWebViewBridgeData.url)) {
                if (!TextUtils.isEmpty(str)) {
                    this.fAG.put(quickWebViewBridgeData.url, str);
                }
            } else {
                String currentBduss = TbadkCoreApplication.getCurrentBduss();
                String str2 = null;
                if (com.baidu.tbadk.core.a.a.pb().co(TbadkCoreApplication.getCurrentBduss()) != null) {
                    str2 = e.d(TbadkCoreApplication.getCurrentAccountInfo());
                }
                QuickWebViewHttpReqMsg quickWebViewHttpReqMsg = new QuickWebViewHttpReqMsg();
                quickWebViewHttpReqMsg.url = quickWebViewBridgeData.url;
                quickWebViewHttpReqMsg.begin = quickWebViewBridgeData.begin;
                quickWebViewHttpReqMsg.jsCallbackMethod = str;
                quickWebViewHttpReqMsg.setTag(this.aPx);
                quickWebViewHttpReqMsg.addCookie("BDUSS", currentBduss);
                quickWebViewHttpReqMsg.addCookie("STOKEN", str2);
                quickWebViewHttpReqMsg.addCookie("domain", this.fAI);
                quickWebViewHttpReqMsg.setUserAgent(this.fAJ);
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
                this.fAF.add(quickWebViewBridgeData.url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runJsMethod(String str, String str2) {
        if (this.bZz != null) {
            this.bZz.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    public void onDestory() {
        MessageManager.getInstance().unRegisterListener(this.aPx);
        MessageManager.getInstance().removeMessage(this.aPx);
        this.fAF.clear();
        this.fAF = null;
        this.fAG.clear();
        this.fAG = null;
        this.fAH.clear();
        this.fAH = null;
    }
}

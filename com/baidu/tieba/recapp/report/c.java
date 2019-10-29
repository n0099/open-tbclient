package com.baidu.tieba.recapp.report;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
public class c {
    private static c iNL;
    private CustomMessageListener iNN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && c.this.iNM != null) {
                c.this.iNM.cgK();
            }
        }
    };
    private d iNM = new g();

    public static c cgI() {
        if (iNL == null) {
            synchronized (c.class) {
                if (iNL == null) {
                    iNL = new c();
                }
            }
        }
        return iNL;
    }

    private boolean cgJ() {
        return com.baidu.adp.lib.b.d.ft().af("ad_log_open") != 0;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.iNN);
    }

    public void a(b bVar) {
        if (cgJ() && bVar != null && this.iNM != null) {
            if (j.isNetWorkAvailable()) {
                this.iNM.b(bVar);
            } else {
                this.iNM.c(bVar);
            }
        }
    }

    public void f(String str, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    sb.append(String.format("&%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            HttpMessageTask httpMessageTask = new HttpMessageTask(1003062, str + sb.toString());
            httpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            httpMessageTask.setResponsedClass(HttpResponsedMessage.class);
            AdUploadHttpRequest adUploadHttpRequest = new AdUploadHttpRequest(new ArrayList());
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.bUC;
            }
            adUploadHttpRequest.addHeader(SM.COOKIE, cookie);
            MessageManager.getInstance().sendMessage(adUploadHttpRequest, httpMessageTask);
        }
    }
}

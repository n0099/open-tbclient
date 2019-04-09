package com.baidu.tieba.recapp.report;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private static c imn;
    private CustomMessageListener imp = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.recapp.report.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.kY() && c.this.imo != null) {
                c.this.imo.bXC();
            }
        }
    };
    private d imo = new g();

    public static c bXA() {
        if (imn == null) {
            synchronized (c.class) {
                if (imn == null) {
                    imn = new c();
                }
            }
        }
        return imn;
    }

    private boolean bXB() {
        return com.baidu.adp.lib.b.d.iQ().aO("ad_log_open") != 0;
    }

    private c() {
        MessageManager.getInstance().registerListener(this.imp);
    }

    public void a(b bVar) {
        if (bXB() && bVar != null && this.imo != null) {
            if (j.kY()) {
                this.imo.b(bVar);
            } else {
                this.imo.c(bVar);
            }
        }
    }

    public void e(String str, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    sb.append(String.format("&%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, str + sb.toString());
            httpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            httpMessageTask.setResponsedClass(HttpResponsedMessage.class);
            AdUploadHttpRequest adUploadHttpRequest = new AdUploadHttpRequest(new ArrayList());
            String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = com.baidu.tbadk.browser.a.btJ;
            }
            adUploadHttpRequest.addHeader("Cookie", cookie);
            MessageManager.getInstance().sendMessage(adUploadHttpRequest, httpMessageTask);
        }
    }
}

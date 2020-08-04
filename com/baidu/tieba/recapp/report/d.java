package com.baidu.tieba.recapp.report;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.switchs.AdUploadSwitch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
public class d {
    private static d lrq;
    private CustomMessageListener lrs = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.recapp.report.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.isNetWorkAvailable() && d.this.lrr != null) {
                d.this.lrr.dda();
            }
        }
    };
    private e lrr = new h();

    public static d dcY() {
        if (lrq == null) {
            synchronized (d.class) {
                if (lrq == null) {
                    lrq = new d();
                }
            }
        }
        return lrq;
    }

    private boolean dcZ() {
        return SwitchManager.getInstance().findType(AdUploadSwitch.KEY) != 0;
    }

    private d() {
        MessageManager.getInstance().registerListener(this.lrs);
    }

    public void a(c cVar) {
        if (dcZ() && cVar != null && this.lrr != null) {
            if (j.isNetWorkAvailable()) {
                this.lrr.b(cVar);
            } else {
                this.lrr.c(cVar);
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
                cookie = com.baidu.tbadk.browser.a.dIZ;
            }
            adUploadHttpRequest.addHeader(SM.COOKIE, cookie);
            MessageManager.getInstance().sendMessage(adUploadHttpRequest, httpMessageTask);
        }
    }
}

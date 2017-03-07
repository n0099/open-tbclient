package com.baidu.tieba.recapp.report;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private static b fct;
    private CustomMessageListener fcv = new c(this, 2000994);
    private d fcu = new f();

    public static b aZQ() {
        if (fct == null) {
            synchronized (b.class) {
                if (fct == null) {
                    fct = new b();
                }
            }
        }
        return fct;
    }

    private boolean aZR() {
        return com.baidu.adp.lib.b.e.eT().ab("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.fcv);
    }

    public void a(a aVar) {
        if (aZR() && aVar != null && this.fcu != null) {
            if (i.he()) {
                this.fcu.b(aVar);
            } else {
                this.fcu.c(aVar);
            }
        }
    }

    public void c(String str, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    sb.append(String.format("&%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, String.valueOf(str) + sb.toString());
            httpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            httpMessageTask.setResponsedClass(HttpResponsedMessage.class);
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(new ArrayList()), httpMessageTask);
        }
    }
}

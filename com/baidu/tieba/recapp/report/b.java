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
    private static b eGL;
    private CustomMessageListener eGN = new c(this, 2000994);
    private d eGM = new f();

    public static b aUO() {
        if (eGL == null) {
            synchronized (b.class) {
                if (eGL == null) {
                    eGL = new b();
                }
            }
        }
        return eGL;
    }

    private boolean aUP() {
        return com.baidu.adp.lib.c.e.cT().Z("ad_log_open") == 1;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.eGN);
    }

    public void a(a aVar) {
        if (aUP() && aVar != null && this.eGM != null) {
            if (i.fr()) {
                this.eGM.b(aVar);
            } else {
                this.eGM.c(aVar);
            }
        }
    }

    public void b(String str, HashMap<String, String> hashMap) {
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

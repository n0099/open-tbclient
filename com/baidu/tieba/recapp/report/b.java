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
    private static b fbZ;
    private CustomMessageListener fcb = new c(this, 2000994);
    private d fca = new f();

    public static b aYZ() {
        if (fbZ == null) {
            synchronized (b.class) {
                if (fbZ == null) {
                    fbZ = new b();
                }
            }
        }
        return fbZ;
    }

    private boolean aZa() {
        return com.baidu.adp.lib.b.e.eZ().Y("ad_log_open") != 0;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.fcb);
    }

    public void a(a aVar) {
        if (aZa() && aVar != null && this.fca != null) {
            if (i.hk()) {
                this.fca.b(aVar);
            } else {
                this.fca.c(aVar);
            }
        }
    }

    public void d(String str, HashMap<String, String> hashMap) {
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

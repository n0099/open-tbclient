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
    private static b fdP;
    private CustomMessageListener fdR = new c(this, 2000994);
    private d fdQ = new f();

    public static b baz() {
        if (fdP == null) {
            synchronized (b.class) {
                if (fdP == null) {
                    fdP = new b();
                }
            }
        }
        return fdP;
    }

    private boolean baA() {
        return com.baidu.adp.lib.b.e.eY().Y("ad_log_open") != 0;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.fdR);
    }

    public void a(a aVar) {
        if (baA() && aVar != null && this.fdQ != null) {
            if (i.hj()) {
                this.fdQ.b(aVar);
            } else {
                this.fdQ.c(aVar);
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

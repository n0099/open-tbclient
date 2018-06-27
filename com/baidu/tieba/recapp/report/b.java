package com.baidu.tieba.recapp.report;

import android.text.TextUtils;
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
public class b {
    private static b gsG;
    private CustomMessageListener gsI = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.recapp.report.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.jD() && b.this.gsH != null) {
                b.this.gsH.bpF();
            }
        }
    };
    private c gsH = new f();

    public static b bpD() {
        if (gsG == null) {
            synchronized (b.class) {
                if (gsG == null) {
                    gsG = new b();
                }
            }
        }
        return gsG;
    }

    private boolean bpE() {
        return com.baidu.adp.lib.b.d.hv().aw("ad_log_open") != 0;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gsI);
    }

    public void a(a aVar) {
        if (bpE() && aVar != null && this.gsH != null) {
            if (j.jD()) {
                this.gsH.b(aVar);
            } else {
                this.gsH.c(aVar);
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
            HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, str + sb.toString());
            httpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            httpMessageTask.setResponsedClass(HttpResponsedMessage.class);
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(new ArrayList()), httpMessageTask);
        }
    }
}

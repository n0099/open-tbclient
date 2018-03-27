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
    private static b gHv;
    private CustomMessageListener gHx = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.recapp.report.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && j.oJ() && b.this.gHw != null) {
                b.this.gHw.boZ();
            }
        }
    };
    private c gHw = new f();

    public static b boX() {
        if (gHv == null) {
            synchronized (b.class) {
                if (gHv == null) {
                    gHv = new b();
                }
            }
        }
        return gHv;
    }

    private boolean boY() {
        return com.baidu.adp.lib.b.d.mA().an("ad_log_open") != 0;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.gHx);
    }

    public void a(a aVar) {
        if (boY() && aVar != null && this.gHw != null) {
            if (j.oJ()) {
                this.gHw.b(aVar);
            } else {
                this.gHw.c(aVar);
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
            HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, str + sb.toString());
            httpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            httpMessageTask.setResponsedClass(HttpResponsedMessage.class);
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(new ArrayList()), httpMessageTask);
        }
    }
}

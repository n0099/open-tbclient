package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements c {
    private HttpMessageListener cRV = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        f.this.dk(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<a> gHA = new ArrayList<>();
    private TbHttpMessageTask gHz;

    public f() {
        aVv();
        MessageManager.getInstance().registerListener(this.cRV);
    }

    private void aVv() {
        this.gHz = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.gHz.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.gHz.setIsNeedAddCommenParam(true);
        this.gHz.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.Ft())) {
                this.gHz.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bpa();
        }
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void boZ() {
        bpa();
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bpa() {
        if (v.D(this.gHA) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.gHA), this.gHz);
            this.gHA.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(List<a> list) {
        if (v.D(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (v.D(this.gHA) >= 20) {
                this.gHA.remove(0);
            }
            this.gHA.add(aVar);
        }
    }
}

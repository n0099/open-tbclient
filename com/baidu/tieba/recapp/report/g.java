package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g implements d {
    private TbHttpMessageTask jLU;
    private HttpMessageListener jLT = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        g.this.ea(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<b> jLV = new ArrayList<>();

    public g() {
        brE();
        MessageManager.getInstance().registerListener(this.jLT);
    }

    private void brE() {
        this.jLU = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.jLU.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.jLU.setIsNeedAddCommenParam(true);
        this.jLU.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(b bVar) {
        if (bVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.aJc())) {
                this.jLU.setUrl("http://als.baidu.com/clog/clog");
            }
            d(bVar);
            cDs();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void cDr() {
        cDs();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(b bVar) {
        if (bVar != null) {
            d(bVar);
        }
    }

    private void cDs() {
        if (v.getCount(this.jLV) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.jLV), this.jLU);
            this.jLV.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(List<b> list) {
        if (v.getCount(list) > 0) {
            for (b bVar : list) {
                if (bVar != null) {
                    d(bVar);
                }
            }
        }
    }

    private void d(b bVar) {
        if (bVar != null) {
            if (v.getCount(this.jLV) >= 20) {
                this.jLV.remove(0);
            }
            this.jLV.add(bVar);
        }
    }
}

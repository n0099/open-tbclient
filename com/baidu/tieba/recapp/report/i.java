package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i implements f {
    private TbHttpMessageTask nad;
    private HttpMessageListener nac = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        i.this.fN(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> nae = new ArrayList<>();

    public i() {
        acb();
        MessageManager.getInstance().registerListener(this.nac);
    }

    private void acb() {
        this.nad = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.nad.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.nad.setIsNeedAddCommenParam(true);
        this.nad.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.f
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.bwa())) {
                this.nad.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            dEF();
        }
    }

    @Override // com.baidu.tieba.recapp.report.f
    public void dEE() {
        dEF();
    }

    @Override // com.baidu.tieba.recapp.report.f
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void dEF() {
        if (y.getCount(this.nae) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.nae), this.nad);
            this.nae.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(List<c> list) {
        if (y.getCount(list) > 0) {
            for (c cVar : list) {
                if (cVar != null) {
                    d(cVar);
                }
            }
        }
    }

    private void d(c cVar) {
        if (cVar != null) {
            if (y.getCount(this.nae) >= 20) {
                this.nae.remove(0);
            }
            this.nae.add(cVar);
        }
    }
}

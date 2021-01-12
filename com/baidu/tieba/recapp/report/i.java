package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i implements f {
    private TbHttpMessageTask mOe;
    private HttpMessageListener mOd = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        i.this.fP(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> mOf = new ArrayList<>();

    public i() {
        aak();
        MessageManager.getInstance().registerListener(this.mOd);
    }

    private void aak() {
        this.mOe = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.mOe.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.mOe.setIsNeedAddCommenParam(true);
        this.mOe.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.f
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.bvE())) {
                this.mOe.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            dCh();
        }
    }

    @Override // com.baidu.tieba.recapp.report.f
    public void dCg() {
        dCh();
    }

    @Override // com.baidu.tieba.recapp.report.f
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void dCh() {
        if (x.getCount(this.mOf) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.mOf), this.mOe);
            this.mOf.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(List<c> list) {
        if (x.getCount(list) > 0) {
            for (c cVar : list) {
                if (cVar != null) {
                    d(cVar);
                }
            }
        }
    }

    private void d(c cVar) {
        if (cVar != null) {
            if (x.getCount(this.mOf) >= 20) {
                this.mOf.remove(0);
            }
            this.mOf.add(cVar);
        }
    }
}

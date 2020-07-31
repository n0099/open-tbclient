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
public class h implements e {
    private TbHttpMessageTask lru;
    private HttpMessageListener lrt = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.eR(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> lrv = new ArrayList<>();

    public h() {
        bNV();
        MessageManager.getInstance().registerListener(this.lrt);
    }

    private void bNV() {
        this.lru = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.lru.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.lru.setIsNeedAddCommenParam(true);
        this.lru.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.bdL())) {
                this.lru.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            ddb();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void dda() {
        ddb();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void ddb() {
        if (x.getCount(this.lrv) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.lrv), this.lru);
            this.lrv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(List<c> list) {
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
            if (x.getCount(this.lrv) >= 20) {
                this.lrv.remove(0);
            }
            this.lrv.add(cVar);
        }
    }
}

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
public class h implements e {
    private TbHttpMessageTask msP;
    private HttpMessageListener msO = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.ft(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> msQ = new ArrayList<>();

    public h() {
        cgj();
        MessageManager.getInstance().registerListener(this.msO);
    }

    private void cgj() {
        this.msP = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.msP.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.msP.setIsNeedAddCommenParam(true);
        this.msP.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.brO())) {
                this.msP.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            dyQ();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void dyP() {
        dyQ();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void dyQ() {
        if (y.getCount(this.msQ) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.msQ), this.msP);
            this.msQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ft(List<c> list) {
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
            if (y.getCount(this.msQ) >= 20) {
                this.msQ.remove(0);
            }
            this.msQ.add(cVar);
        }
    }
}

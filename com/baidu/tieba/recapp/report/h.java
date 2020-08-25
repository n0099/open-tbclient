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
/* loaded from: classes2.dex */
public class h implements e {
    private TbHttpMessageTask lHR;
    private HttpMessageListener lHQ = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.eZ(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> lHS = new ArrayList<>();

    public h() {
        bXV();
        MessageManager.getInstance().registerListener(this.lHQ);
    }

    private void bXV() {
        this.lHR = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.lHR.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.lHR.setIsNeedAddCommenParam(true);
        this.lHR.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.bmr())) {
                this.lHR.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            dol();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void dok() {
        dol();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void dol() {
        if (y.getCount(this.lHS) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.lHS), this.lHR);
            this.lHS.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eZ(List<c> list) {
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
            if (y.getCount(this.lHS) >= 20) {
                this.lHS.remove(0);
            }
            this.lHS.add(cVar);
        }
    }
}

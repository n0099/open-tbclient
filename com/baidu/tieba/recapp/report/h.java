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
public class h implements e {
    private TbHttpMessageTask kQi;
    private HttpMessageListener kQh = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.ex(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> kQj = new ArrayList<>();

    public h() {
        bHH();
        MessageManager.getInstance().registerListener(this.kQh);
    }

    private void bHH() {
        this.kQi = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.kQi.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.kQi.setIsNeedAddCommenParam(true);
        this.kQi.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.aXJ())) {
                this.kQi.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            cVD();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void cVC() {
        cVD();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void cVD() {
        if (v.getCount(this.kQj) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.kQj), this.kQi);
            this.kQj.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(List<c> list) {
        if (v.getCount(list) > 0) {
            for (c cVar : list) {
                if (cVar != null) {
                    d(cVar);
                }
            }
        }
    }

    private void d(c cVar) {
        if (cVar != null) {
            if (v.getCount(this.kQj) >= 20) {
                this.kQj.remove(0);
            }
            this.kQj.add(cVar);
        }
    }
}

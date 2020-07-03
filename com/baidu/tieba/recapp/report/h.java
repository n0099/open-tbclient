package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h implements e {
    private TbHttpMessageTask lkb;
    private HttpMessageListener lka = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.eL(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> lkc = new ArrayList<>();

    public h() {
        bKL();
        MessageManager.getInstance().registerListener(this.lka);
    }

    private void bKL() {
        this.lkb = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.lkb.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.lkb.setIsNeedAddCommenParam(true);
        this.lkb.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.aZO())) {
                this.lkb.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            cZT();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void cZS() {
        cZT();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void cZT() {
        if (w.getCount(this.lkc) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.lkc), this.lkb);
            this.lkc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(List<c> list) {
        if (w.getCount(list) > 0) {
            for (c cVar : list) {
                if (cVar != null) {
                    d(cVar);
                }
            }
        }
    }

    private void d(c cVar) {
        if (cVar != null) {
            if (w.getCount(this.lkc) >= 20) {
                this.lkc.remove(0);
            }
            this.lkc.add(cVar);
        }
    }
}

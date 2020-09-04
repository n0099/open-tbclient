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
    private TbHttpMessageTask lIe;
    private HttpMessageListener lId = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
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
    private ArrayList<c> lIf = new ArrayList<>();

    public h() {
        bXW();
        MessageManager.getInstance().registerListener(this.lId);
    }

    private void bXW() {
        this.lIe = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.lIe.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.lIe.setIsNeedAddCommenParam(true);
        this.lIe.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.bmr())) {
                this.lIe.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            doo();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void don() {
        doo();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void doo() {
        if (y.getCount(this.lIf) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.lIf), this.lIe);
            this.lIf.clear();
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
            if (y.getCount(this.lIf) >= 20) {
                this.lIf.remove(0);
            }
            this.lIf.add(cVar);
        }
    }
}

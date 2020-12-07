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
    private TbHttpMessageTask mNB;
    private HttpMessageListener mNA = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.fP(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> mNC = new ArrayList<>();

    public h() {
        acn();
        MessageManager.getInstance().registerListener(this.mNA);
    }

    private void acn() {
        this.mNB = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.mNB.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.mNB.setIsNeedAddCommenParam(true);
        this.mNB.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.bxe())) {
                this.mNB.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            dGi();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void dGh() {
        dGi();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void dGi() {
        if (y.getCount(this.mNC) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.mNC), this.mNB);
            this.mNC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(List<c> list) {
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
            if (y.getCount(this.mNC) >= 20) {
                this.mNC.remove(0);
            }
            this.mNC.add(cVar);
        }
    }
}

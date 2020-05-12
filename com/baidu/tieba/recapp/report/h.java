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
    private TbHttpMessageTask kxg;
    private HttpMessageListener kxf = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.eo(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> kxh = new ArrayList<>();

    public h() {
        bBl();
        MessageManager.getInstance().registerListener(this.kxf);
    }

    private void bBl() {
        this.kxg = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.kxg.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.kxg.setIsNeedAddCommenParam(true);
        this.kxg.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.aRB())) {
                this.kxg.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            cOm();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void cOl() {
        cOm();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void cOm() {
        if (v.getCount(this.kxh) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.kxh), this.kxg);
            this.kxh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(List<c> list) {
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
            if (v.getCount(this.kxh) >= 20) {
                this.kxh.remove(0);
            }
            this.kxh.add(cVar);
        }
    }
}

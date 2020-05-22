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
    private TbHttpMessageTask kOZ;
    private HttpMessageListener kOY = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        h.this.ev(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<c> kPa = new ArrayList<>();

    public h() {
        bHF();
        MessageManager.getInstance().registerListener(this.kOY);
    }

    private void bHF() {
        this.kOZ = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.kOZ.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.kOZ.setIsNeedAddCommenParam(true);
        this.kOZ.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void b(c cVar) {
        if (cVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.aXI())) {
                this.kOZ.setUrl("http://als.baidu.com/clog/clog");
            }
            d(cVar);
            cVn();
        }
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void cVm() {
        cVn();
    }

    @Override // com.baidu.tieba.recapp.report.e
    public void c(c cVar) {
        if (cVar != null) {
            d(cVar);
        }
    }

    private void cVn() {
        if (v.getCount(this.kPa) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.kPa), this.kOZ);
            this.kPa.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(List<c> list) {
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
            if (v.getCount(this.kPa) >= 20) {
                this.kPa.remove(0);
            }
            this.kPa.add(cVar);
        }
    }
}

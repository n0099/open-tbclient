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
public class g implements d {
    private TbHttpMessageTask iNa;
    private HttpMessageListener iMZ = new HttpMessageListener(1003062) { // from class: com.baidu.tieba.recapp.report.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        g.this.em(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<b> iNb = new ArrayList<>();

    public g() {
        aXX();
        MessageManager.getInstance().registerListener(this.iMZ);
    }

    private void aXX() {
        this.iNa = new TbHttpMessageTask(1003062, "https://als.baidu.com/clog/clog");
        this.iNa.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.iNa.setIsNeedAddCommenParam(true);
        this.iNa.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(b bVar) {
        if (bVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.aoR())) {
                this.iNa.setUrl("http://als.baidu.com/clog/clog");
            }
            d(bVar);
            cgJ();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void cgI() {
        cgJ();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(b bVar) {
        if (bVar != null) {
            d(bVar);
        }
    }

    private void cgJ() {
        if (v.getCount(this.iNb) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.iNb), this.iNa);
            this.iNb.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em(List<b> list) {
        if (v.getCount(list) > 0) {
            for (b bVar : list) {
                if (bVar != null) {
                    d(bVar);
                }
            }
        }
    }

    private void d(b bVar) {
        if (bVar != null) {
            if (v.getCount(this.iNb) >= 20) {
                this.iNb.remove(0);
            }
            this.iNb.add(bVar);
        }
    }
}

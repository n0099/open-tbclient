package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g implements d {
    private TbHttpMessageTask iFf;
    private HttpMessageListener eni = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        g.this.dY(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<b> iFg = new ArrayList<>();

    public g() {
        aVw();
        MessageManager.getInstance().registerListener(this.eni);
    }

    private void aVw() {
        this.iFf = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.iFf.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.iFf.setIsNeedAddCommenParam(true);
        this.iFf.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(b bVar) {
        if (bVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.akV())) {
                this.iFf.setUrl("http://als.baidu.com/clog/clog");
            }
            d(bVar);
            cfJ();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void cfI() {
        cfJ();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(b bVar) {
        if (bVar != null) {
            d(bVar);
        }
    }

    private void cfJ() {
        if (v.Z(this.iFg) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.iFg), this.iFf);
            this.iFg.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dY(List<b> list) {
        if (v.Z(list) > 0) {
            for (b bVar : list) {
                if (bVar != null) {
                    d(bVar);
                }
            }
        }
    }

    private void d(b bVar) {
        if (bVar != null) {
            if (v.Z(this.iFg) >= 20) {
                this.iFg.remove(0);
            }
            this.iFg.add(bVar);
        }
    }
}

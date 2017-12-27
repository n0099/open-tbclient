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
public class f implements c {
    private TbHttpMessageTask gPF;
    private HttpMessageListener cJJ = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        f.this.dv(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<a> gPG = new ArrayList<>();

    public f() {
        aTD();
        MessageManager.getInstance().registerListener(this.cJJ);
    }

    private void aTD() {
        this.gPF = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.gPF.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.gPF.setIsNeedAddCommenParam(true);
        this.gPF.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.Ff())) {
                this.gPF.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bul();
        }
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void buk() {
        bul();
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bul() {
        if (v.F(this.gPG) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.gPG), this.gPF);
            this.gPG.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(List<a> list) {
        if (v.F(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (v.F(this.gPG) >= 20) {
                this.gPG.remove(0);
            }
            this.gPG.add(aVar);
        }
    }
}

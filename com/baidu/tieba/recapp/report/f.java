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
    private TbHttpMessageTask fOK;
    private HttpMessageListener bMH = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        f.this.cY(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<a> fOL = new ArrayList<>();

    public f() {
        aLG();
        MessageManager.getInstance().registerListener(this.bMH);
    }

    private void aLG() {
        this.fOK = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fOK.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fOK.setIsNeedAddCommenParam(true);
        this.fOK.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xw())) {
                this.fOK.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bjN();
        }
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void bjM() {
        bjN();
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bjN() {
        if (v.u(this.fOL) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fOL), this.fOK);
            this.fOL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(List<a> list) {
        if (v.u(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (v.u(this.fOL) >= 20) {
                this.fOL.remove(0);
            }
            this.fOL.add(aVar);
        }
    }
}

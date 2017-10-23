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
    private TbHttpMessageTask fFV;
    private HttpMessageListener bFy = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        f.this.cW(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<a> fFW = new ArrayList<>();

    public f() {
        aJk();
        MessageManager.getInstance().registerListener(this.bFy);
    }

    private void aJk() {
        this.fFV = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fFV.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fFV.setIsNeedAddCommenParam(true);
        this.fFV.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xp())) {
                this.fFV.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bgB();
        }
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void bgA() {
        bgB();
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bgB() {
        if (v.t(this.fFW) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fFW), this.fFV);
            this.fFW.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(List<a> list) {
        if (v.t(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (v.t(this.fFW) >= 20) {
                this.fFW.remove(0);
            }
            this.fFW.add(aVar);
        }
    }
}

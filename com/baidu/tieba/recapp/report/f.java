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
    private TbHttpMessageTask gbI;
    private HttpMessageListener bUY = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        f.this.dk(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<a> gbJ = new ArrayList<>();

    public f() {
        aMB();
        MessageManager.getInstance().registerListener(this.bUY);
    }

    private void aMB() {
        this.gbI = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.gbI.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.gbI.setIsNeedAddCommenParam(true);
        this.gbI.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xG())) {
                this.gbI.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bmD();
        }
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void bmC() {
        bmD();
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bmD() {
        if (v.v(this.gbJ) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.gbJ), this.gbI);
            this.gbJ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(List<a> list) {
        if (v.v(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (v.v(this.gbJ) >= 20) {
                this.gbJ.remove(0);
            }
            this.gbJ.add(aVar);
        }
    }
}

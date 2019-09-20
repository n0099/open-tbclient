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
    private TbHttpMessageTask iOY;
    private HttpMessageListener etZ = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        g.this.dZ(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<b> iOZ = new ArrayList<>();

    public g() {
        aXY();
        MessageManager.getInstance().registerListener(this.etZ);
    }

    private void aXY() {
        this.iOY = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.iOY.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.iOY.setIsNeedAddCommenParam(true);
        this.iOY.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(b bVar) {
        if (bVar != null) {
            com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.amo())) {
                this.iOY.setUrl("http://als.baidu.com/clog/clog");
            }
            d(bVar);
            cjH();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void cjG() {
        cjH();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(b bVar) {
        if (bVar != null) {
            d(bVar);
        }
    }

    private void cjH() {
        if (v.Z(this.iOZ) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.iOZ), this.iOY);
            this.iOZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ(List<b> list) {
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
            if (v.Z(this.iOZ) >= 20) {
                this.iOZ.remove(0);
            }
            this.iOZ.add(bVar);
        }
    }
}

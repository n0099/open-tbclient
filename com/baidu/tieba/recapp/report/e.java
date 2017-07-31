package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e implements c {
    private TbHttpMessageTask fIK;
    private HttpMessageListener bAp = new HttpMessageListener(CmdConfigHttp.CMD_AD_UPLOAD) { // from class: com.baidu.tieba.recapp.report.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (!(httpResponsedMessage.getError() == 0)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof AdUploadHttpRequest) {
                        e.this.cZ(((AdUploadHttpRequest) orginalMessage).getDataArray());
                    }
                }
            }
        }
    };
    private ArrayList<a> fIL = new ArrayList<>();

    public e() {
        aIW();
        MessageManager.getInstance().registerListener(this.bAp);
    }

    private void aIW() {
        this.fIK = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fIK.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fIK.setIsNeedAddCommenParam(true);
        this.fIK.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xV())) {
                this.fIK.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            biq();
        }
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void bip() {
        biq();
    }

    @Override // com.baidu.tieba.recapp.report.c
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void biq() {
        if (u.u(this.fIL) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fIL), this.fIK);
            this.fIL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(List<a> list) {
        if (u.u(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (u.u(this.fIL) >= 20) {
                this.fIL.remove(0);
            }
            this.fIL.add(aVar);
        }
    }
}

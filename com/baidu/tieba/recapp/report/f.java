package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    private TbHttpMessageTask fcx;
    private HttpMessageListener bnv = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fcy = new ArrayList<>();

    public f() {
        aZT();
        MessageManager.getInstance().registerListener(this.bnv);
    }

    private void aZT() {
        this.fcx = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fcx.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fcx.setIsNeedAddCommenParam(true);
        this.fcx.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xH())) {
                this.fcx.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            aZU();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aZS() {
        aZU();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aZU() {
        if (x.p(this.fcy) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fcy), this.fcx);
            this.fcy.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(List<a> list) {
        if (x.p(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (x.p(this.fcy) >= 20) {
                this.fcy.remove(0);
            }
            this.fcy.add(aVar);
        }
    }
}

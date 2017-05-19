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
    private TbHttpMessageTask fcd;
    private HttpMessageListener bqc = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fce = new ArrayList<>();

    public f() {
        aCc();
        MessageManager.getInstance().registerListener(this.bqc);
    }

    private void aCc() {
        this.fcd = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fcd.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fcd.setIsNeedAddCommenParam(true);
        this.fcd.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xr())) {
                this.fcd.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            aZc();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aZb() {
        aZc();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aZc() {
        if (x.q(this.fce) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fce), this.fcd);
            this.fce.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(List<a> list) {
        if (x.q(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (x.q(this.fce) >= 20) {
                this.fce.remove(0);
            }
            this.fce.add(aVar);
        }
    }
}

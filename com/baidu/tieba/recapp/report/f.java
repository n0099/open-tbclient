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
    private TbHttpMessageTask eOO;
    private HttpMessageListener eON = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> eOP = new ArrayList<>();

    public f() {
        aYv();
        MessageManager.getInstance().registerListener(this.eON);
    }

    private void aYv() {
        this.eOO = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.eOO.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.eOO.setIsNeedAddCommenParam(true);
        this.eOO.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xr())) {
                this.eOO.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            aYw();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aYu() {
        aYw();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aYw() {
        if (x.s(this.eOP) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.eOP), this.eOO);
            this.eOP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(List<a> list) {
        if (x.s(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (x.s(this.eOP) >= 20) {
                this.eOP.remove(0);
            }
            this.eOP.add(aVar);
        }
    }
}

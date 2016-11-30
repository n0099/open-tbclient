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
    private TbHttpMessageTask flr;
    private HttpMessageListener flq = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fls = new ArrayList<>();

    public f() {
        beI();
        MessageManager.getInstance().registerListener(this.flq);
    }

    private void beI() {
        this.flr = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.flr.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.flr.setIsNeedAddCommenParam(true);
        this.flr.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xE())) {
                this.flr.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            beJ();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void beH() {
        beJ();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void beJ() {
        if (x.s(this.fls) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fls), this.flr);
            this.fls.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(List<a> list) {
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
            if (x.s(this.fls) >= 20) {
                this.fls.remove(0);
            }
            this.fls.add(aVar);
        }
    }
}

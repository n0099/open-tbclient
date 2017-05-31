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
    private TbHttpMessageTask fkh;
    private HttpMessageListener brj = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fki = new ArrayList<>();

    public f() {
        aCX();
        MessageManager.getInstance().registerListener(this.brj);
    }

    private void aCX() {
        this.fkh = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fkh.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fkh.setIsNeedAddCommenParam(true);
        this.fkh.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xk())) {
                this.fkh.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bav();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void bau() {
        bav();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bav() {
        if (x.q(this.fki) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fki), this.fkh);
            this.fki.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(List<a> list) {
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
            if (x.q(this.fki) >= 20) {
                this.fki.remove(0);
            }
            this.fki.add(aVar);
        }
    }
}

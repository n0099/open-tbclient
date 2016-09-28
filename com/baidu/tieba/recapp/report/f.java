package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    private TbHttpMessageTask fdZ;
    private HttpMessageListener fdY = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fea = new ArrayList<>();

    public f() {
        bch();
        MessageManager.getInstance().registerListener(this.fdY);
    }

    private void bch() {
        this.fdZ = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/dalog/logForC");
        this.fdZ.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fdZ.setIsNeedAddCommenParam(true);
        this.fdZ.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xz())) {
                this.fdZ.setUrl("http://als.baidu.com/dalog/logForC");
            }
            d(aVar);
            bci();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void bcg() {
        bci();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bci() {
        if (y.s(this.fea) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fea), this.fdZ);
            this.fea.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(List<a> list) {
        if (y.s(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (y.s(this.fea) >= 20) {
                this.fea.remove(0);
            }
            this.fea.add(aVar);
        }
    }
}

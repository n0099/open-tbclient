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
    private TbHttpMessageTask fdT;
    private HttpMessageListener bno = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fdU = new ArrayList<>();

    public f() {
        aDW();
        MessageManager.getInstance().registerListener(this.bno);
    }

    private void aDW() {
        this.fdT = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fdT.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fdT.setIsNeedAddCommenParam(true);
        this.fdT.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.yd())) {
                this.fdT.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            baC();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void baB() {
        baC();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void baC() {
        if (x.p(this.fdU) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fdU), this.fdT);
            this.fdU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(List<a> list) {
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
            if (x.p(this.fdU) >= 20) {
                this.fdU.remove(0);
            }
            this.fdU.add(aVar);
        }
    }
}

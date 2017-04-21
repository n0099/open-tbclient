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
    private TbHttpMessageTask fgk;
    private HttpMessageListener bpF = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fgl = new ArrayList<>();

    public f() {
        aEX();
        MessageManager.getInstance().registerListener(this.bpF);
    }

    private void aEX() {
        this.fgk = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fgk.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fgk.setIsNeedAddCommenParam(true);
        this.fgk.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.yd())) {
                this.fgk.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bbD();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void bbC() {
        bbD();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bbD() {
        if (x.p(this.fgl) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fgl), this.fgk);
            this.fgl.clear();
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
            if (x.p(this.fgl) >= 20) {
                this.fgl.remove(0);
            }
            this.fgl.add(aVar);
        }
    }
}

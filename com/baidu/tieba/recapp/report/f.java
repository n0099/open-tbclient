package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    private TbHttpMessageTask eYq;
    private HttpMessageListener bgK = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> eYr = new ArrayList<>();

    public f() {
        bal();
        MessageManager.getInstance().registerListener(this.bgK);
    }

    private void bal() {
        this.eYq = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.eYq.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.eYq.setIsNeedAddCommenParam(true);
        this.eYq.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xl())) {
                this.eYq.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            bam();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void bak() {
        bam();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bam() {
        if (w.r(this.eYr) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.eYr), this.eYq);
            this.eYr.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(List<a> list) {
        if (w.r(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (w.r(this.eYr) >= 20) {
                this.eYr.remove(0);
            }
            this.eYr.add(aVar);
        }
    }
}

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
    private TbHttpMessageTask fbh;
    private HttpMessageListener fbg = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fbi = new ArrayList<>();

    public f() {
        bbx();
        MessageManager.getInstance().registerListener(this.fbg);
    }

    private void bbx() {
        this.fbh = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/dalog/logForC");
        this.fbh.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fbh.setIsNeedAddCommenParam(true);
        this.fbh.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xx())) {
                this.fbh.setUrl("http://als.baidu.com/dalog/logForC");
            }
            d(aVar);
            bby();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void bbw() {
        bby();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void bby() {
        if (y.s(this.fbi) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fbi), this.fbh);
            this.fbi.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(List<a> list) {
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
            if (y.s(this.fbi) >= 20) {
                this.fbi.remove(0);
            }
            this.fbi.add(aVar);
        }
    }
}

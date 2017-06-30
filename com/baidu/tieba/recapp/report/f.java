package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    private TbHttpMessageTask fuy;
    private HttpMessageListener buW = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> fuz = new ArrayList<>();

    public f() {
        aGP();
        MessageManager.getInstance().registerListener(this.buW);
    }

    private void aGP() {
        this.fuy = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.fuy.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.fuy.setIsNeedAddCommenParam(true);
        this.fuy.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
            if (!(adAdSense == null || adAdSense.xC())) {
                this.fuy.setUrl("http://als.baidu.com/clog/clog");
            }
            d(aVar);
            beF();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void beE() {
        beF();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void beF() {
        if (z.s(this.fuz) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.fuz), this.fuy);
            this.fuz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(List<a> list) {
        if (z.s(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (z.s(this.fuz) >= 20) {
                this.fuz.remove(0);
            }
            this.fuz.add(aVar);
        }
    }
}

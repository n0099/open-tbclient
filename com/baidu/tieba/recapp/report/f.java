package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    private TbHttpMessageTask dCL;
    private HttpMessageListener dCK = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> dCM = new ArrayList<>();

    public f() {
        aEN();
        MessageManager.getInstance().registerListener(this.dCK);
    }

    private void aEN() {
        this.dCL = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.dCL.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.dCL.setIsNeedAddCommenParam(true);
        this.dCL.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            aEO();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aEM() {
        aEO();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aEO() {
        if (x.o(this.dCM) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.dCM), this.dCL);
            this.dCM.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(List<a> list) {
        if (x.o(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (x.o(this.dCM) >= 20) {
                this.dCM.remove(0);
            }
            this.dCM.add(aVar);
        }
    }
}

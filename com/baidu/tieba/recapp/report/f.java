package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    private TbHttpMessageTask eGQ;
    private HttpMessageListener eGP = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> eGR = new ArrayList<>();

    public f() {
        aUR();
        MessageManager.getInstance().registerListener(this.eGP);
    }

    private void aUR() {
        this.eGQ = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.eGQ.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.eGQ.setIsNeedAddCommenParam(true);
        this.eGQ.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            aUS();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aUQ() {
        aUS();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aUS() {
        if (y.s(this.eGR) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.eGR), this.eGQ);
            this.eGR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(List<a> list) {
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
            if (y.s(this.eGR) >= 20) {
                this.eGR.remove(0);
            }
            this.eGR.add(aVar);
        }
    }
}

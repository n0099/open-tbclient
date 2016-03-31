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
    private TbHttpMessageTask dUD;
    private HttpMessageListener dUC = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> dUE = new ArrayList<>();

    public f() {
        aLF();
        MessageManager.getInstance().registerListener(this.dUC);
    }

    private void aLF() {
        this.dUD = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.dUD.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.dUD.setIsNeedAddCommenParam(true);
        this.dUD.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            aLG();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aLE() {
        aLG();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aLG() {
        if (y.p(this.dUE) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.dUE), this.dUD);
            this.dUE.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(List<a> list) {
        if (y.p(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (y.p(this.dUE) >= 20) {
                this.dUE.remove(0);
            }
            this.dUE.add(aVar);
        }
    }
}

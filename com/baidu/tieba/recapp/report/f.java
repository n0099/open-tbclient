package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    private TbHttpMessageTask cHW;
    private HttpMessageListener cHV = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> cHX = new ArrayList<>();

    public f() {
        apJ();
        MessageManager.getInstance().registerListener(this.cHV);
    }

    private void apJ() {
        this.cHW = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.cHW.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.cHW.setIsNeedAddCommenParam(true);
        this.cHW.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            apK();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void apI() {
        apK();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void apK() {
        if (u.l(this.cHX) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.cHX), this.cHW);
            this.cHX.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(List<a> list) {
        if (u.l(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (u.l(this.cHX) >= 20) {
                this.cHX.remove(0);
            }
            this.cHX.add(aVar);
        }
    }
}

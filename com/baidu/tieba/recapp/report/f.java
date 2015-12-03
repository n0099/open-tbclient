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
    private TbHttpMessageTask dia;
    private HttpMessageListener dhZ = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> dib = new ArrayList<>();

    public f() {
        avX();
        MessageManager.getInstance().registerListener(this.dhZ);
    }

    private void avX() {
        this.dia = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.dia.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.dia.setIsNeedAddCommenParam(true);
        this.dia.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            avY();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void avW() {
        avY();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void avY() {
        if (y.k(this.dib) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.dib), this.dia);
            this.dib.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(List<a> list) {
        if (y.k(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (y.k(this.dib) >= 20) {
                this.dib.remove(0);
            }
            this.dib.add(aVar);
        }
    }
}

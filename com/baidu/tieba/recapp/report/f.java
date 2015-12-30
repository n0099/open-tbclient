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
    private TbHttpMessageTask dnH;
    private HttpMessageListener dnG = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> dnI = new ArrayList<>();

    public f() {
        axQ();
        MessageManager.getInstance().registerListener(this.dnG);
    }

    private void axQ() {
        this.dnH = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.dnH.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.dnH.setIsNeedAddCommenParam(true);
        this.dnH.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            axR();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void axP() {
        axR();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void axR() {
        if (y.l(this.dnI) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.dnI), this.dnH);
            this.dnI.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(List<a> list) {
        if (y.l(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (y.l(this.dnI) >= 20) {
                this.dnI.remove(0);
            }
            this.dnI.add(aVar);
        }
    }
}

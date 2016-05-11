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
    private TbHttpMessageTask dXv;
    private HttpMessageListener dXu = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> dXw = new ArrayList<>();

    public f() {
        aLJ();
        MessageManager.getInstance().registerListener(this.dXu);
    }

    private void aLJ() {
        this.dXv = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.dXv.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.dXv.setIsNeedAddCommenParam(true);
        this.dXv.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            aLK();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aLI() {
        aLK();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aLK() {
        if (y.r(this.dXw) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.dXw), this.dXv);
            this.dXw.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(List<a> list) {
        if (y.r(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (y.r(this.dXw) >= 20) {
                this.dXw.remove(0);
            }
            this.dXw.add(aVar);
        }
    }
}

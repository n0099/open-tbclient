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
    private TbHttpMessageTask cJs;
    private HttpMessageListener cJr = new g(this, CmdConfigHttp.CMD_AD_UPLOAD);
    private ArrayList<a> cJt = new ArrayList<>();

    public f() {
        aql();
        MessageManager.getInstance().registerListener(this.cJr);
    }

    private void aql() {
        this.cJs = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "http://als.baidu.com/dalog/logForC");
        this.cJs.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.cJs.setIsNeedAddCommenParam(true);
        this.cJs.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void b(a aVar) {
        if (aVar != null) {
            d(aVar);
            aqm();
        }
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void aqk() {
        aqm();
    }

    @Override // com.baidu.tieba.recapp.report.d
    public void c(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    private void aqm() {
        if (u.m(this.cJt) > 0) {
            MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.cJt), this.cJs);
            this.cJt.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(List<a> list) {
        if (u.m(list) > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    d(aVar);
                }
            }
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            if (u.m(this.cJt) >= 20) {
                this.cJt.remove(0);
            }
            this.cJt.add(aVar);
        }
    }
}

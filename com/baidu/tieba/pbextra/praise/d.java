package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private boolean dXi;
    private boolean isAuthor;
    private String jRg;
    private int jRh;
    private int jRi;
    private int jRj;
    private final List<com.baidu.tieba.pbextra.praise.a> jRk;
    private a jRl;
    private final HttpMessageListener jRm;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cJ(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jRh;
        dVar.jRh = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jRg = "";
        this.dXi = true;
        this.jRh = 1;
        this.jRi = 0;
        this.jRj = 0;
        this.jRk = new ArrayList(100);
        this.jRl = null;
        this.jRm = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jRl != null) {
                        d.this.jRl.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jRl != null) {
                        d.this.jRl.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jRl != null) {
                            d.this.jRl.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jRk.add(aVar);
                        }
                    }
                    d.this.jRj = d.this.jRk.size();
                    d.this.jRi = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jRh > 5) {
                        i = 1003;
                    }
                    if (d.this.jRj >= d.this.jRi) {
                        i = 1002;
                    }
                    if (d.this.jRl != null) {
                        d.this.jRl.a(d.this.jRi, d.this.jRk, i, d.this.jRi - d.this.jRj);
                    }
                }
            }
        };
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jRg = "";
        this.dXi = true;
        this.jRh = 1;
        this.jRi = 0;
        this.jRj = 0;
        this.jRk = new ArrayList(100);
        this.jRl = null;
        this.jRm = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jRl != null) {
                        d.this.jRl.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jRl != null) {
                        d.this.jRl.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jRl != null) {
                            d.this.jRl.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jRk.add(aVar2);
                        }
                    }
                    d.this.jRj = d.this.jRk.size();
                    d.this.jRi = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jRh > 5) {
                        i = 1003;
                    }
                    if (d.this.jRj >= d.this.jRi) {
                        i = 1002;
                    }
                    if (d.this.jRl != null) {
                        d.this.jRl.a(d.this.jRi, d.this.jRk, i, d.this.jRi - d.this.jRj);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jRg = str3;
        this.jRl = aVar;
        this.dXi = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jRm);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean cCp() {
        return this.dXi;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dXi);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jRg);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jRi);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jRm);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cFO() {
        return this.jRg;
    }

    public void As(int i) {
        this.jRi = i;
    }

    public com.baidu.tieba.pbextra.praise.a At(int i) {
        if (i <= -1 || i >= this.jRk.size()) {
            return null;
        }
        return this.jRk.get(i);
    }

    public void Au(int i) {
        cFP();
    }

    private void cFP() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jRh + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

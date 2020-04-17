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
    private boolean dXd;
    private boolean isAuthor;
    private String jRc;
    private int jRd;
    private int jRe;
    private int jRf;
    private final List<com.baidu.tieba.pbextra.praise.a> jRg;
    private a jRh;
    private final HttpMessageListener jRi;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cJ(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jRd;
        dVar.jRd = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jRc = "";
        this.dXd = true;
        this.jRd = 1;
        this.jRe = 0;
        this.jRf = 0;
        this.jRg = new ArrayList(100);
        this.jRh = null;
        this.jRi = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jRh != null) {
                        d.this.jRh.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jRh != null) {
                        d.this.jRh.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jRh != null) {
                            d.this.jRh.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jRg.add(aVar);
                        }
                    }
                    d.this.jRf = d.this.jRg.size();
                    d.this.jRe = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jRd > 5) {
                        i = 1003;
                    }
                    if (d.this.jRf >= d.this.jRe) {
                        i = 1002;
                    }
                    if (d.this.jRh != null) {
                        d.this.jRh.a(d.this.jRe, d.this.jRg, i, d.this.jRe - d.this.jRf);
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
        this.jRc = "";
        this.dXd = true;
        this.jRd = 1;
        this.jRe = 0;
        this.jRf = 0;
        this.jRg = new ArrayList(100);
        this.jRh = null;
        this.jRi = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jRh != null) {
                        d.this.jRh.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jRh != null) {
                        d.this.jRh.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jRh != null) {
                            d.this.jRh.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jRg.add(aVar2);
                        }
                    }
                    d.this.jRf = d.this.jRg.size();
                    d.this.jRe = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jRd > 5) {
                        i = 1003;
                    }
                    if (d.this.jRf >= d.this.jRe) {
                        i = 1002;
                    }
                    if (d.this.jRh != null) {
                        d.this.jRh.a(d.this.jRe, d.this.jRg, i, d.this.jRe - d.this.jRf);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jRc = str3;
        this.jRh = aVar;
        this.dXd = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jRi);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean cCr() {
        return this.dXd;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dXd);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jRc);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jRe);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jRi);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cFQ() {
        return this.jRc;
    }

    public void As(int i) {
        this.jRe = i;
    }

    public com.baidu.tieba.pbextra.praise.a At(int i) {
        if (i <= -1 || i >= this.jRg.size()) {
            return null;
        }
        return this.jRg.get(i);
    }

    public void Au(int i) {
        cFR();
    }

    private void cFR() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jRd + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

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
/* loaded from: classes16.dex */
public class d {
    private boolean eKT;
    private boolean isAuthor;
    private String lcL;
    private int lcM;
    private int lcN;
    private int lcO;
    private final List<com.baidu.tieba.pbextra.praise.a> lcP;
    private a lcQ;
    private final HttpMessageListener lcR;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes16.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cO(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.lcM;
        dVar.lcM = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.lcL = "";
        this.eKT = true;
        this.lcM = 1;
        this.lcN = 0;
        this.lcO = 0;
        this.lcP = new ArrayList(100);
        this.lcQ = null;
        this.lcR = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lcQ != null) {
                        d.this.lcQ.cO(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lcQ != null) {
                        d.this.lcQ.cO(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lcQ != null) {
                            d.this.lcQ.cO(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.lcP.add(aVar);
                        }
                    }
                    d.this.lcO = d.this.lcP.size();
                    d.this.lcN = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lcM > 5) {
                        i = 1003;
                    }
                    if (d.this.lcO >= d.this.lcN) {
                        i = 1002;
                    }
                    if (d.this.lcQ != null) {
                        d.this.lcQ.a(d.this.lcN, d.this.lcP, i, d.this.lcN - d.this.lcO);
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
        this.lcL = "";
        this.eKT = true;
        this.lcM = 1;
        this.lcN = 0;
        this.lcO = 0;
        this.lcP = new ArrayList(100);
        this.lcQ = null;
        this.lcR = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lcQ != null) {
                        d.this.lcQ.cO(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lcQ != null) {
                        d.this.lcQ.cO(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lcQ != null) {
                            d.this.lcQ.cO(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.lcP.add(aVar2);
                        }
                    }
                    d.this.lcO = d.this.lcP.size();
                    d.this.lcN = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lcM > 5) {
                        i = 1003;
                    }
                    if (d.this.lcO >= d.this.lcN) {
                        i = 1002;
                    }
                    if (d.this.lcQ != null) {
                        d.this.lcQ.a(d.this.lcN, d.this.lcP, i, d.this.lcN - d.this.lcO);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.lcL = str3;
        this.lcQ = aVar;
        this.eKT = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.lcR);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dcx() {
        return this.eKT;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.eKT);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.lcL);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.lcN);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.lcR);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dgi() {
        return this.lcL;
    }

    public void Fb(int i) {
        this.lcN = i;
    }

    public com.baidu.tieba.pbextra.praise.a Fc(int i) {
        if (i <= -1 || i >= this.lcP.size()) {
            return null;
        }
        return this.lcP.get(i);
    }

    public void Fd(int i) {
        dgj();
    }

    private void dgj() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.lcM + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

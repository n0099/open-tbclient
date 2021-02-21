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
/* loaded from: classes2.dex */
public class d {
    private boolean fBK;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;
    private String mrM;
    private int mrN;
    private int mrO;
    private int mrP;
    private final List<com.baidu.tieba.pbextra.praise.a> mrQ;
    private a mrR;
    private final HttpMessageListener mrS;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cP(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.mrN;
        dVar.mrN = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.mrM = "";
        this.fBK = true;
        this.mrN = 1;
        this.mrO = 0;
        this.mrP = 0;
        this.mrQ = new ArrayList(100);
        this.mrR = null;
        this.mrS = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mrR != null) {
                        d.this.mrR.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mrR != null) {
                        d.this.mrR.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mrR != null) {
                            d.this.mrR.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.mrQ.add(aVar);
                        }
                    }
                    d.this.mrP = d.this.mrQ.size();
                    d.this.mrO = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mrN > 5) {
                        i = 1003;
                    }
                    if (d.this.mrP >= d.this.mrO) {
                        i = 1002;
                    }
                    if (d.this.mrR != null) {
                        d.this.mrR.a(d.this.mrO, d.this.mrQ, i, d.this.mrO - d.this.mrP);
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
        this.mrM = "";
        this.fBK = true;
        this.mrN = 1;
        this.mrO = 0;
        this.mrP = 0;
        this.mrQ = new ArrayList(100);
        this.mrR = null;
        this.mrS = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mrR != null) {
                        d.this.mrR.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mrR != null) {
                        d.this.mrR.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mrR != null) {
                            d.this.mrR.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.mrQ.add(aVar2);
                        }
                    }
                    d.this.mrP = d.this.mrQ.size();
                    d.this.mrO = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mrN > 5) {
                        i = 1003;
                    }
                    if (d.this.mrP >= d.this.mrO) {
                        i = 1002;
                    }
                    if (d.this.mrR != null) {
                        d.this.mrR.a(d.this.mrO, d.this.mrQ, i, d.this.mrO - d.this.mrP);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.mrM = str3;
        this.mrR = aVar;
        this.fBK = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.mrS);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dsG() {
        return this.fBK;
    }

    public void k(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fBK);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void m(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void n(Bundle bundle, String str) {
        bundle.putString(str, this.mrM);
    }

    public void o(Bundle bundle, String str) {
        bundle.putInt(str, this.mrO);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.mrS);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dwm() {
        return this.mrM;
    }

    public void GI(int i) {
        this.mrO = i;
    }

    public com.baidu.tieba.pbextra.praise.a GJ(int i) {
        if (i <= -1 || i >= this.mrQ.size()) {
            return null;
        }
        return this.mrQ.get(i);
    }

    public void GK(int i) {
        dwn();
    }

    private void dwn() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.mrN + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

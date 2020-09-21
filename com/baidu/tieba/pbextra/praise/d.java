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
/* loaded from: classes21.dex */
public class d {
    private boolean eNo;
    private boolean isAuthor;
    private String llJ;
    private int llK;
    private int llL;
    private int llM;
    private final List<com.baidu.tieba.pbextra.praise.a> llN;
    private a llO;
    private final HttpMessageListener llP;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cR(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.llK;
        dVar.llK = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.llJ = "";
        this.eNo = true;
        this.llK = 1;
        this.llL = 0;
        this.llM = 0;
        this.llN = new ArrayList(100);
        this.llO = null;
        this.llP = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.llO != null) {
                        d.this.llO.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.llO != null) {
                        d.this.llO.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.llO != null) {
                            d.this.llO.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.llN.add(aVar);
                        }
                    }
                    d.this.llM = d.this.llN.size();
                    d.this.llL = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.llK > 5) {
                        i = 1003;
                    }
                    if (d.this.llM >= d.this.llL) {
                        i = 1002;
                    }
                    if (d.this.llO != null) {
                        d.this.llO.a(d.this.llL, d.this.llN, i, d.this.llL - d.this.llM);
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
        this.llJ = "";
        this.eNo = true;
        this.llK = 1;
        this.llL = 0;
        this.llM = 0;
        this.llN = new ArrayList(100);
        this.llO = null;
        this.llP = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.llO != null) {
                        d.this.llO.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.llO != null) {
                        d.this.llO.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.llO != null) {
                            d.this.llO.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.llN.add(aVar2);
                        }
                    }
                    d.this.llM = d.this.llN.size();
                    d.this.llL = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.llK > 5) {
                        i = 1003;
                    }
                    if (d.this.llM >= d.this.llL) {
                        i = 1002;
                    }
                    if (d.this.llO != null) {
                        d.this.llO.a(d.this.llL, d.this.llN, i, d.this.llL - d.this.llM);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.llJ = str3;
        this.llO = aVar;
        this.eNo = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.llP);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dgc() {
        return this.eNo;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.eNo);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.llJ);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.llL);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.llP);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String djM() {
        return this.llJ;
    }

    public void FC(int i) {
        this.llL = i;
    }

    public com.baidu.tieba.pbextra.praise.a FD(int i) {
        if (i <= -1 || i >= this.llN.size()) {
            return null;
        }
        return this.llN.get(i);
    }

    public void FE(int i) {
        djN();
    }

    private void djN() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.llK + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

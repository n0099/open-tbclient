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
    private boolean fmT;
    private boolean isAuthor;
    private String lTK;
    private int lTL;
    private int lTM;
    private int lTN;
    private final List<com.baidu.tieba.pbextra.praise.a> lTO;
    private a lTP;
    private final HttpMessageListener lTQ;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cT(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.lTL;
        dVar.lTL = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.lTK = "";
        this.fmT = true;
        this.lTL = 1;
        this.lTM = 0;
        this.lTN = 0;
        this.lTO = new ArrayList(100);
        this.lTP = null;
        this.lTQ = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lTP != null) {
                        d.this.lTP.cT(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lTP != null) {
                        d.this.lTP.cT(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lTP != null) {
                            d.this.lTP.cT(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.lTO.add(aVar);
                        }
                    }
                    d.this.lTN = d.this.lTO.size();
                    d.this.lTM = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lTL > 5) {
                        i = 1003;
                    }
                    if (d.this.lTN >= d.this.lTM) {
                        i = 1002;
                    }
                    if (d.this.lTP != null) {
                        d.this.lTP.a(d.this.lTM, d.this.lTO, i, d.this.lTM - d.this.lTN);
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
        this.lTK = "";
        this.fmT = true;
        this.lTL = 1;
        this.lTM = 0;
        this.lTN = 0;
        this.lTO = new ArrayList(100);
        this.lTP = null;
        this.lTQ = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lTP != null) {
                        d.this.lTP.cT(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lTP != null) {
                        d.this.lTP.cT(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lTP != null) {
                            d.this.lTP.cT(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.lTO.add(aVar2);
                        }
                    }
                    d.this.lTN = d.this.lTO.size();
                    d.this.lTM = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lTL > 5) {
                        i = 1003;
                    }
                    if (d.this.lTN >= d.this.lTM) {
                        i = 1002;
                    }
                    if (d.this.lTP != null) {
                        d.this.lTP.a(d.this.lTM, d.this.lTO, i, d.this.lTM - d.this.lTN);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.lTK = str3;
        this.lTP = aVar;
        this.fmT = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.lTQ);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean doV() {
        return this.fmT;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fmT);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.lTK);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.lTM);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.lTQ);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dsF() {
        return this.lTK;
    }

    public void Hm(int i) {
        this.lTM = i;
    }

    public com.baidu.tieba.pbextra.praise.a Hn(int i) {
        if (i <= -1 || i >= this.lTO.size()) {
            return null;
        }
        return this.lTO.get(i);
    }

    public void Ho(int i) {
        dsG();
    }

    private void dsG() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.lTL + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

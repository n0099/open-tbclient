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
    private boolean eKX;
    private boolean isAuthor;
    private String lcS;
    private int lcT;
    private int lcU;
    private int lcV;
    private final List<com.baidu.tieba.pbextra.praise.a> lcW;
    private a lcX;
    private final HttpMessageListener lcY;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes16.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cP(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.lcT;
        dVar.lcT = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.lcS = "";
        this.eKX = true;
        this.lcT = 1;
        this.lcU = 0;
        this.lcV = 0;
        this.lcW = new ArrayList(100);
        this.lcX = null;
        this.lcY = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lcX != null) {
                        d.this.lcX.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lcX != null) {
                        d.this.lcX.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lcX != null) {
                            d.this.lcX.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.lcW.add(aVar);
                        }
                    }
                    d.this.lcV = d.this.lcW.size();
                    d.this.lcU = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lcT > 5) {
                        i = 1003;
                    }
                    if (d.this.lcV >= d.this.lcU) {
                        i = 1002;
                    }
                    if (d.this.lcX != null) {
                        d.this.lcX.a(d.this.lcU, d.this.lcW, i, d.this.lcU - d.this.lcV);
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
        this.lcS = "";
        this.eKX = true;
        this.lcT = 1;
        this.lcU = 0;
        this.lcV = 0;
        this.lcW = new ArrayList(100);
        this.lcX = null;
        this.lcY = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lcX != null) {
                        d.this.lcX.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lcX != null) {
                        d.this.lcX.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lcX != null) {
                            d.this.lcX.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.lcW.add(aVar2);
                        }
                    }
                    d.this.lcV = d.this.lcW.size();
                    d.this.lcU = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lcT > 5) {
                        i = 1003;
                    }
                    if (d.this.lcV >= d.this.lcU) {
                        i = 1002;
                    }
                    if (d.this.lcX != null) {
                        d.this.lcX.a(d.this.lcU, d.this.lcW, i, d.this.lcU - d.this.lcV);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.lcS = str3;
        this.lcX = aVar;
        this.eKX = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.lcY);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dcy() {
        return this.eKX;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.eKX);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.lcS);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.lcU);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.lcY);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dgj() {
        return this.lcS;
    }

    public void Fb(int i) {
        this.lcU = i;
    }

    public com.baidu.tieba.pbextra.praise.a Fc(int i) {
        if (i <= -1 || i >= this.lcW.size()) {
            return null;
        }
        return this.lcW.get(i);
    }

    public void Fd(int i) {
        dgk();
    }

    private void dgk() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.lcT + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

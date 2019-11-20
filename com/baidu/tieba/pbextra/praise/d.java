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
/* loaded from: classes4.dex */
public class d {
    private boolean cEK;
    private String iiH;
    private int iiI;
    private int iiJ;
    private int iiK;
    private final List<com.baidu.tieba.pbextra.praise.a> iiL;
    private a iiM;
    private final HttpMessageListener iiN;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void bh(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.iiI;
        dVar.iiI = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.iiH = "";
        this.cEK = true;
        this.iiI = 1;
        this.iiJ = 0;
        this.iiK = 0;
        this.iiL = new ArrayList(100);
        this.iiM = null;
        this.iiN = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.iiM != null) {
                        d.this.iiM.bh(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.iiM != null) {
                        d.this.iiM.bh(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.iiM != null) {
                            d.this.iiM.bh(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.iiL.add(aVar);
                        }
                    }
                    d.this.iiK = d.this.iiL.size();
                    d.this.iiJ = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.iiI > 5) {
                        i = 1003;
                    }
                    if (d.this.iiK >= d.this.iiJ) {
                        i = 1002;
                    }
                    if (d.this.iiM != null) {
                        d.this.iiM.a(d.this.iiJ, d.this.iiL, i, d.this.iiJ - d.this.iiK);
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
        this.iiH = "";
        this.cEK = true;
        this.iiI = 1;
        this.iiJ = 0;
        this.iiK = 0;
        this.iiL = new ArrayList(100);
        this.iiM = null;
        this.iiN = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.iiM != null) {
                        d.this.iiM.bh(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.iiM != null) {
                        d.this.iiM.bh(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.iiM != null) {
                            d.this.iiM.bh(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.iiL.add(aVar2);
                        }
                    }
                    d.this.iiK = d.this.iiL.size();
                    d.this.iiJ = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.iiI > 5) {
                        i = 1003;
                    }
                    if (d.this.iiK >= d.this.iiJ) {
                        i = 1002;
                    }
                    if (d.this.iiM != null) {
                        d.this.iiM.a(d.this.iiJ, d.this.iiL, i, d.this.iiJ - d.this.iiK);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.iiH = str3;
        this.iiM = aVar;
        this.cEK = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.iiN);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bWU() {
        return this.cEK;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cEK);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.iiH);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.iiJ);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.iiN);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String bYS() {
        return this.iiH;
    }

    public void xl(int i) {
        this.iiJ = i;
    }

    public com.baidu.tieba.pbextra.praise.a xm(int i) {
        if (i <= -1 || i >= this.iiL.size()) {
            return null;
        }
        return this.iiL.get(i);
    }

    public void xn(int i) {
        bYT();
    }

    private void bYT() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.iiI + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

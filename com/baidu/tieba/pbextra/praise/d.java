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
    private boolean eud;
    private boolean isAuthor;
    private String kDR;
    private int kDS;
    private int kDT;
    private int kDU;
    private final List<com.baidu.tieba.pbextra.praise.a> kDV;
    private a kDW;
    private final HttpMessageListener kDX;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cL(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.kDS;
        dVar.kDS = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.kDR = "";
        this.eud = true;
        this.kDS = 1;
        this.kDT = 0;
        this.kDU = 0;
        this.kDV = new ArrayList(100);
        this.kDW = null;
        this.kDX = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kDW != null) {
                        d.this.kDW.cL(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kDW != null) {
                        d.this.kDW.cL(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kDW != null) {
                            d.this.kDW.cL(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.kDV.add(aVar);
                        }
                    }
                    d.this.kDU = d.this.kDV.size();
                    d.this.kDT = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kDS > 5) {
                        i = 1003;
                    }
                    if (d.this.kDU >= d.this.kDT) {
                        i = 1002;
                    }
                    if (d.this.kDW != null) {
                        d.this.kDW.a(d.this.kDT, d.this.kDV, i, d.this.kDT - d.this.kDU);
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
        this.kDR = "";
        this.eud = true;
        this.kDS = 1;
        this.kDT = 0;
        this.kDU = 0;
        this.kDV = new ArrayList(100);
        this.kDW = null;
        this.kDX = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kDW != null) {
                        d.this.kDW.cL(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kDW != null) {
                        d.this.kDW.cL(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kDW != null) {
                            d.this.kDW.cL(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.kDV.add(aVar2);
                        }
                    }
                    d.this.kDU = d.this.kDV.size();
                    d.this.kDT = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kDS > 5) {
                        i = 1003;
                    }
                    if (d.this.kDU >= d.this.kDT) {
                        i = 1002;
                    }
                    if (d.this.kDW != null) {
                        d.this.kDW.a(d.this.kDT, d.this.kDV, i, d.this.kDT - d.this.kDU);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.kDR = str3;
        this.kDW = aVar;
        this.eud = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.kDX);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean cNT() {
        return this.eud;
    }

    public void h(Bundle bundle, String str) {
        bundle.putBoolean(str, this.eud);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.kDR);
    }

    public void l(Bundle bundle, String str) {
        bundle.putInt(str, this.kDT);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.kDX);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cRu() {
        return this.kDR;
    }

    public void Ch(int i) {
        this.kDT = i;
    }

    public com.baidu.tieba.pbextra.praise.a Ci(int i) {
        if (i <= -1 || i >= this.kDV.size()) {
            return null;
        }
        return this.kDV.get(i);
    }

    public void Cj(int i) {
        cRv();
    }

    private void cRv() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.kDS + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

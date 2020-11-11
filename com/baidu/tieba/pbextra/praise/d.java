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
/* loaded from: classes22.dex */
public class d {
    private boolean fnL;
    private boolean isAuthor;
    private final HttpMessageListener lTA;
    private String lTu;
    private int lTv;
    private int lTw;
    private int lTx;
    private final List<com.baidu.tieba.pbextra.praise.a> lTy;
    private a lTz;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cR(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.lTv;
        dVar.lTv = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.lTu = "";
        this.fnL = true;
        this.lTv = 1;
        this.lTw = 0;
        this.lTx = 0;
        this.lTy = new ArrayList(100);
        this.lTz = null;
        this.lTA = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lTz != null) {
                        d.this.lTz.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lTz != null) {
                        d.this.lTz.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lTz != null) {
                            d.this.lTz.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.lTy.add(aVar);
                        }
                    }
                    d.this.lTx = d.this.lTy.size();
                    d.this.lTw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lTv > 5) {
                        i = 1003;
                    }
                    if (d.this.lTx >= d.this.lTw) {
                        i = 1002;
                    }
                    if (d.this.lTz != null) {
                        d.this.lTz.a(d.this.lTw, d.this.lTy, i, d.this.lTw - d.this.lTx);
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
        this.lTu = "";
        this.fnL = true;
        this.lTv = 1;
        this.lTw = 0;
        this.lTx = 0;
        this.lTy = new ArrayList(100);
        this.lTz = null;
        this.lTA = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lTz != null) {
                        d.this.lTz.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lTz != null) {
                        d.this.lTz.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lTz != null) {
                            d.this.lTz.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.lTy.add(aVar2);
                        }
                    }
                    d.this.lTx = d.this.lTy.size();
                    d.this.lTw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lTv > 5) {
                        i = 1003;
                    }
                    if (d.this.lTx >= d.this.lTw) {
                        i = 1002;
                    }
                    if (d.this.lTz != null) {
                        d.this.lTz.a(d.this.lTw, d.this.lTy, i, d.this.lTw - d.this.lTx);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.lTu = str3;
        this.lTz = aVar;
        this.fnL = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.lTA);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dpv() {
        return this.fnL;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fnL);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.lTu);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.lTw);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.lTA);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dtf() {
        return this.lTu;
    }

    public void GO(int i) {
        this.lTw = i;
    }

    public com.baidu.tieba.pbextra.praise.a GP(int i) {
        if (i <= -1 || i >= this.lTy.size()) {
            return null;
        }
        return this.lTy.get(i);
    }

    public void GQ(int i) {
        dtg();
    }

    private void dtg() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.lTv + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

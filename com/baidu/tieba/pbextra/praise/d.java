package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private boolean aDj;
    private String fBO;
    private int fBP;
    private int fBQ;
    private int fBR;
    private final List<com.baidu.tieba.pbextra.praise.a> fBS;
    private a fBT;
    private final HttpMessageListener fBU;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fBP;
        dVar.fBP = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fBO = "";
        this.aDj = true;
        this.fBP = 1;
        this.fBQ = 0;
        this.fBR = 0;
        this.fBS = new ArrayList(100);
        this.fBT = null;
        this.fBU = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fBT != null) {
                        d.this.fBT.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fBT != null) {
                        d.this.fBT.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fBT != null) {
                            d.this.fBT.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fBS.add(aVar);
                        }
                    }
                    d.this.fBR = d.this.fBS.size();
                    d.this.fBQ = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fBP > 5) {
                        i = 1003;
                    }
                    if (d.this.fBR >= d.this.fBQ) {
                        i = 1002;
                    }
                    if (d.this.fBT != null) {
                        d.this.fBT.a(d.this.fBQ, d.this.fBS, i, d.this.fBQ - d.this.fBR);
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
        this.fBO = "";
        this.aDj = true;
        this.fBP = 1;
        this.fBQ = 0;
        this.fBR = 0;
        this.fBS = new ArrayList(100);
        this.fBT = null;
        this.fBU = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fBT != null) {
                        d.this.fBT.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fBT != null) {
                        d.this.fBT.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fBT != null) {
                            d.this.fBT.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fBS.add(aVar2);
                        }
                    }
                    d.this.fBR = d.this.fBS.size();
                    d.this.fBQ = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fBP > 5) {
                        i = 1003;
                    }
                    if (d.this.fBR >= d.this.fBQ) {
                        i = 1002;
                    }
                    if (d.this.fBT != null) {
                        d.this.fBT.a(d.this.fBQ, d.this.fBS, i, d.this.fBQ - d.this.fBR);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fBO = str3;
        this.fBT = aVar;
        this.aDj = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fBU);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bbs() {
        return this.aDj;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aDj);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.fBO);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.fBQ);
    }

    public void bdr() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fBU);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bds() {
        return this.fBO;
    }

    public void qW(int i) {
        this.fBQ = i;
    }

    public com.baidu.tieba.pbextra.praise.a qX(int i) {
        if (i <= -1 || i >= this.fBS.size()) {
            return null;
        }
        return this.fBS.get(i);
    }

    public void qY(int i) {
        bdt();
    }

    private void bdt() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fBP + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

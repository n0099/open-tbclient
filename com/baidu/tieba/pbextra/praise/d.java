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
    private String fBR;
    private int fBS;
    private int fBT;
    private int fBU;
    private final List<com.baidu.tieba.pbextra.praise.a> fBV;
    private a fBW;
    private final HttpMessageListener fBX;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fBS;
        dVar.fBS = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fBR = "";
        this.aDj = true;
        this.fBS = 1;
        this.fBT = 0;
        this.fBU = 0;
        this.fBV = new ArrayList(100);
        this.fBW = null;
        this.fBX = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fBW != null) {
                        d.this.fBW.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fBW != null) {
                        d.this.fBW.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fBW != null) {
                            d.this.fBW.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fBV.add(aVar);
                        }
                    }
                    d.this.fBU = d.this.fBV.size();
                    d.this.fBT = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fBS > 5) {
                        i = 1003;
                    }
                    if (d.this.fBU >= d.this.fBT) {
                        i = 1002;
                    }
                    if (d.this.fBW != null) {
                        d.this.fBW.a(d.this.fBT, d.this.fBV, i, d.this.fBT - d.this.fBU);
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
        this.fBR = "";
        this.aDj = true;
        this.fBS = 1;
        this.fBT = 0;
        this.fBU = 0;
        this.fBV = new ArrayList(100);
        this.fBW = null;
        this.fBX = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fBW != null) {
                        d.this.fBW.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fBW != null) {
                        d.this.fBW.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fBW != null) {
                            d.this.fBW.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fBV.add(aVar2);
                        }
                    }
                    d.this.fBU = d.this.fBV.size();
                    d.this.fBT = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fBS > 5) {
                        i = 1003;
                    }
                    if (d.this.fBU >= d.this.fBT) {
                        i = 1002;
                    }
                    if (d.this.fBW != null) {
                        d.this.fBW.a(d.this.fBT, d.this.fBV, i, d.this.fBT - d.this.fBU);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fBR = str3;
        this.fBW = aVar;
        this.aDj = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fBX);
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
        bundle.putString(str, this.fBR);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.fBT);
    }

    public void bdr() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fBX);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bds() {
        return this.fBR;
    }

    public void qW(int i) {
        this.fBT = i;
    }

    public com.baidu.tieba.pbextra.praise.a qX(int i) {
        if (i <= -1 || i >= this.fBV.size()) {
            return null;
        }
        return this.fBV.get(i);
    }

    public void qY(int i) {
        bdt();
    }

    private void bdt() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fBS + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

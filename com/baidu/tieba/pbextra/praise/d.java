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
    private boolean aDk;
    private String fCU;
    private int fCV;
    private int fCW;
    private int fCX;
    private final List<com.baidu.tieba.pbextra.praise.a> fCY;
    private a fCZ;
    private final HttpMessageListener fDa;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fCV;
        dVar.fCV = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fCU = "";
        this.aDk = true;
        this.fCV = 1;
        this.fCW = 0;
        this.fCX = 0;
        this.fCY = new ArrayList(100);
        this.fCZ = null;
        this.fDa = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fCZ != null) {
                        d.this.fCZ.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fCZ != null) {
                        d.this.fCZ.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fCZ != null) {
                            d.this.fCZ.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fCY.add(aVar);
                        }
                    }
                    d.this.fCX = d.this.fCY.size();
                    d.this.fCW = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fCV > 5) {
                        i = 1003;
                    }
                    if (d.this.fCX >= d.this.fCW) {
                        i = 1002;
                    }
                    if (d.this.fCZ != null) {
                        d.this.fCZ.a(d.this.fCW, d.this.fCY, i, d.this.fCW - d.this.fCX);
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
        this.fCU = "";
        this.aDk = true;
        this.fCV = 1;
        this.fCW = 0;
        this.fCX = 0;
        this.fCY = new ArrayList(100);
        this.fCZ = null;
        this.fDa = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fCZ != null) {
                        d.this.fCZ.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fCZ != null) {
                        d.this.fCZ.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fCZ != null) {
                            d.this.fCZ.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fCY.add(aVar2);
                        }
                    }
                    d.this.fCX = d.this.fCY.size();
                    d.this.fCW = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fCV > 5) {
                        i = 1003;
                    }
                    if (d.this.fCX >= d.this.fCW) {
                        i = 1002;
                    }
                    if (d.this.fCZ != null) {
                        d.this.fCZ.a(d.this.fCW, d.this.fCY, i, d.this.fCW - d.this.fCX);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fCU = str3;
        this.fCZ = aVar;
        this.aDk = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fDa);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bbs() {
        return this.aDk;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aDk);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.fCU);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.fCW);
    }

    public void bdr() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fDa);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bds() {
        return this.fCU;
    }

    public void qV(int i) {
        this.fCW = i;
    }

    public com.baidu.tieba.pbextra.praise.a qW(int i) {
        if (i <= -1 || i >= this.fCY.size()) {
            return null;
        }
        return this.fCY.get(i);
    }

    public void qX(int i) {
        bdt();
    }

    private void bdt() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fCV + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

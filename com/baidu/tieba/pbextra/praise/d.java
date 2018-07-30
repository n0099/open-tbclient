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
    private boolean aMC;
    private String fSC;
    private int fSD;
    private int fSE;
    private int fSF;
    private final List<com.baidu.tieba.pbextra.praise.a> fSG;
    private a fSH;
    private final HttpMessageListener fSI;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fSD;
        dVar.fSD = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fSC = "";
        this.aMC = true;
        this.fSD = 1;
        this.fSE = 0;
        this.fSF = 0;
        this.fSG = new ArrayList(100);
        this.fSH = null;
        this.fSI = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fSH != null) {
                        d.this.fSH.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fSH != null) {
                        d.this.fSH.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fSH != null) {
                            d.this.fSH.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fSG.add(aVar);
                        }
                    }
                    d.this.fSF = d.this.fSG.size();
                    d.this.fSE = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fSD > 5) {
                        i = 1003;
                    }
                    if (d.this.fSF >= d.this.fSE) {
                        i = 1002;
                    }
                    if (d.this.fSH != null) {
                        d.this.fSH.a(d.this.fSE, d.this.fSG, i, d.this.fSE - d.this.fSF);
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
        this.fSC = "";
        this.aMC = true;
        this.fSD = 1;
        this.fSE = 0;
        this.fSF = 0;
        this.fSG = new ArrayList(100);
        this.fSH = null;
        this.fSI = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fSH != null) {
                        d.this.fSH.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fSH != null) {
                        d.this.fSH.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fSH != null) {
                            d.this.fSH.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fSG.add(aVar2);
                        }
                    }
                    d.this.fSF = d.this.fSG.size();
                    d.this.fSE = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fSD > 5) {
                        i = 1003;
                    }
                    if (d.this.fSF >= d.this.fSE) {
                        i = 1002;
                    }
                    if (d.this.fSH != null) {
                        d.this.fSH.a(d.this.fSE, d.this.fSG, i, d.this.fSE - d.this.fSF);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fSC = str3;
        this.fSH = aVar;
        this.aMC = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fSI);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bft() {
        return this.aMC;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aMC);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.fSC);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.fSE);
    }

    public void bhq() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fSI);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bhr() {
        return this.fSC;
    }

    public void rn(int i) {
        this.fSE = i;
    }

    public com.baidu.tieba.pbextra.praise.a ro(int i) {
        if (i <= -1 || i >= this.fSG.size()) {
            return null;
        }
        return this.fSG.get(i);
    }

    public void rp(int i) {
        bhs();
    }

    private void bhs() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fSD + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

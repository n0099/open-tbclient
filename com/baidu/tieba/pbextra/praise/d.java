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
    private boolean fhR;
    private boolean isAuthor;
    private int lNA;
    private int lNB;
    private final List<com.baidu.tieba.pbextra.praise.a> lNC;
    private a lND;
    private final HttpMessageListener lNE;
    private String lNy;
    private int lNz;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cR(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.lNz;
        dVar.lNz = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.lNy = "";
        this.fhR = true;
        this.lNz = 1;
        this.lNA = 0;
        this.lNB = 0;
        this.lNC = new ArrayList(100);
        this.lND = null;
        this.lNE = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lND != null) {
                        d.this.lND.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lND != null) {
                        d.this.lND.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lND != null) {
                            d.this.lND.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.lNC.add(aVar);
                        }
                    }
                    d.this.lNB = d.this.lNC.size();
                    d.this.lNA = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lNz > 5) {
                        i = 1003;
                    }
                    if (d.this.lNB >= d.this.lNA) {
                        i = 1002;
                    }
                    if (d.this.lND != null) {
                        d.this.lND.a(d.this.lNA, d.this.lNC, i, d.this.lNA - d.this.lNB);
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
        this.lNy = "";
        this.fhR = true;
        this.lNz = 1;
        this.lNA = 0;
        this.lNB = 0;
        this.lNC = new ArrayList(100);
        this.lND = null;
        this.lNE = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lND != null) {
                        d.this.lND.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lND != null) {
                        d.this.lND.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lND != null) {
                            d.this.lND.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.lNC.add(aVar2);
                        }
                    }
                    d.this.lNB = d.this.lNC.size();
                    d.this.lNA = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lNz > 5) {
                        i = 1003;
                    }
                    if (d.this.lNB >= d.this.lNA) {
                        i = 1002;
                    }
                    if (d.this.lND != null) {
                        d.this.lND.a(d.this.lNA, d.this.lNC, i, d.this.lNA - d.this.lNB);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.lNy = str3;
        this.lND = aVar;
        this.fhR = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.lNE);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dmS() {
        return this.fhR;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fhR);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.lNy);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.lNA);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.lNE);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dqD() {
        return this.lNy;
    }

    public void GB(int i) {
        this.lNA = i;
    }

    public com.baidu.tieba.pbextra.praise.a GC(int i) {
        if (i <= -1 || i >= this.lNC.size()) {
            return null;
        }
        return this.lNC.get(i);
    }

    public void GD(int i) {
        dqE();
    }

    private void dqE() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.lNz + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

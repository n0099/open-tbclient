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
/* loaded from: classes2.dex */
public class d {
    private boolean fDj;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;
    private String mtP;
    private int mtQ;
    private int mtR;
    private int mtS;
    private final List<com.baidu.tieba.pbextra.praise.a> mtT;
    private a mtU;
    private final HttpMessageListener mtV;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cT(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.mtQ;
        dVar.mtQ = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.mtP = "";
        this.fDj = true;
        this.mtQ = 1;
        this.mtR = 0;
        this.mtS = 0;
        this.mtT = new ArrayList(100);
        this.mtU = null;
        this.mtV = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mtU != null) {
                        d.this.mtU.cT(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mtU != null) {
                        d.this.mtU.cT(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mtU != null) {
                            d.this.mtU.cT(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.mtT.add(aVar);
                        }
                    }
                    d.this.mtS = d.this.mtT.size();
                    d.this.mtR = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mtQ > 5) {
                        i = 1003;
                    }
                    if (d.this.mtS >= d.this.mtR) {
                        i = 1002;
                    }
                    if (d.this.mtU != null) {
                        d.this.mtU.a(d.this.mtR, d.this.mtT, i, d.this.mtR - d.this.mtS);
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
        this.mtP = "";
        this.fDj = true;
        this.mtQ = 1;
        this.mtR = 0;
        this.mtS = 0;
        this.mtT = new ArrayList(100);
        this.mtU = null;
        this.mtV = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mtU != null) {
                        d.this.mtU.cT(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mtU != null) {
                        d.this.mtU.cT(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mtU != null) {
                            d.this.mtU.cT(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.mtT.add(aVar2);
                        }
                    }
                    d.this.mtS = d.this.mtT.size();
                    d.this.mtR = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mtQ > 5) {
                        i = 1003;
                    }
                    if (d.this.mtS >= d.this.mtR) {
                        i = 1002;
                    }
                    if (d.this.mtU != null) {
                        d.this.mtU.a(d.this.mtR, d.this.mtT, i, d.this.mtR - d.this.mtS);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.mtP = str3;
        this.mtU = aVar;
        this.fDj = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.mtV);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dsP() {
        return this.fDj;
    }

    public void k(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fDj);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void m(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void n(Bundle bundle, String str) {
        bundle.putString(str, this.mtP);
    }

    public void o(Bundle bundle, String str) {
        bundle.putInt(str, this.mtR);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.mtV);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dwv() {
        return this.mtP;
    }

    public void GL(int i) {
        this.mtR = i;
    }

    public com.baidu.tieba.pbextra.praise.a GM(int i) {
        if (i <= -1 || i >= this.mtT.size()) {
            return null;
        }
        return this.mtT.get(i);
    }

    public void GN(int i) {
        dww();
    }

    private void dww() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.mtQ + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

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
/* loaded from: classes4.dex */
public class d {
    private boolean csr;
    private String ihN;
    private int ihO;
    private int ihP;
    private int ihQ;
    private final List<com.baidu.tieba.pbextra.praise.a> ihR;
    private a ihS;
    private final HttpMessageListener ihT;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ihO;
        dVar.ihO = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ihN = "";
        this.csr = true;
        this.ihO = 1;
        this.ihP = 0;
        this.ihQ = 0;
        this.ihR = new ArrayList(100);
        this.ihS = null;
        this.ihT = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ihS != null) {
                        d.this.ihS.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ihS != null) {
                        d.this.ihS.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ihS != null) {
                            d.this.ihS.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.ihR.add(aVar);
                        }
                    }
                    d.this.ihQ = d.this.ihR.size();
                    d.this.ihP = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ihO > 5) {
                        i = 1003;
                    }
                    if (d.this.ihQ >= d.this.ihP) {
                        i = 1002;
                    }
                    if (d.this.ihS != null) {
                        d.this.ihS.a(d.this.ihP, d.this.ihR, i, d.this.ihP - d.this.ihQ);
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
        this.ihN = "";
        this.csr = true;
        this.ihO = 1;
        this.ihP = 0;
        this.ihQ = 0;
        this.ihR = new ArrayList(100);
        this.ihS = null;
        this.ihT = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ihS != null) {
                        d.this.ihS.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ihS != null) {
                        d.this.ihS.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ihS != null) {
                            d.this.ihS.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.ihR.add(aVar2);
                        }
                    }
                    d.this.ihQ = d.this.ihR.size();
                    d.this.ihP = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ihO > 5) {
                        i = 1003;
                    }
                    if (d.this.ihQ >= d.this.ihP) {
                        i = 1002;
                    }
                    if (d.this.ihS != null) {
                        d.this.ihS.a(d.this.ihP, d.this.ihR, i, d.this.ihP - d.this.ihQ);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ihN = str3;
        this.ihS = aVar;
        this.csr = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ihT);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bYP() {
        return this.csr;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.csr);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.ihN);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.ihP);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ihT);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String caM() {
        return this.ihN;
    }

    public void yC(int i) {
        this.ihP = i;
    }

    public com.baidu.tieba.pbextra.praise.a yD(int i) {
        if (i <= -1 || i >= this.ihR.size()) {
            return null;
        }
        return this.ihR.get(i);
    }

    public void yE(int i) {
        caN();
    }

    private void caN() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ihO + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

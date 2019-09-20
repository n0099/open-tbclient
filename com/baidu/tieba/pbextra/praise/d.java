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
    private boolean cts;
    private String ikO;
    private int ikP;
    private int ikQ;
    private int ikR;
    private final List<com.baidu.tieba.pbextra.praise.a> ikS;
    private a ikT;
    private final HttpMessageListener ikU;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ikP;
        dVar.ikP = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ikO = "";
        this.cts = true;
        this.ikP = 1;
        this.ikQ = 0;
        this.ikR = 0;
        this.ikS = new ArrayList(100);
        this.ikT = null;
        this.ikU = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ikT != null) {
                        d.this.ikT.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ikT != null) {
                        d.this.ikT.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ikT != null) {
                            d.this.ikT.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.ikS.add(aVar);
                        }
                    }
                    d.this.ikR = d.this.ikS.size();
                    d.this.ikQ = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ikP > 5) {
                        i = 1003;
                    }
                    if (d.this.ikR >= d.this.ikQ) {
                        i = 1002;
                    }
                    if (d.this.ikT != null) {
                        d.this.ikT.a(d.this.ikQ, d.this.ikS, i, d.this.ikQ - d.this.ikR);
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
        this.ikO = "";
        this.cts = true;
        this.ikP = 1;
        this.ikQ = 0;
        this.ikR = 0;
        this.ikS = new ArrayList(100);
        this.ikT = null;
        this.ikU = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ikT != null) {
                        d.this.ikT.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ikT != null) {
                        d.this.ikT.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ikT != null) {
                            d.this.ikT.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.ikS.add(aVar2);
                        }
                    }
                    d.this.ikR = d.this.ikS.size();
                    d.this.ikQ = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ikP > 5) {
                        i = 1003;
                    }
                    if (d.this.ikR >= d.this.ikQ) {
                        i = 1002;
                    }
                    if (d.this.ikT != null) {
                        d.this.ikT.a(d.this.ikQ, d.this.ikS, i, d.this.ikQ - d.this.ikR);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ikO = str3;
        this.ikT = aVar;
        this.cts = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ikU);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bZU() {
        return this.cts;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cts);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.ikO);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.ikQ);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ikU);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String cbS() {
        return this.ikO;
    }

    public void yH(int i) {
        this.ikQ = i;
    }

    public com.baidu.tieba.pbextra.praise.a yI(int i) {
        if (i <= -1 || i >= this.ikS.size()) {
            return null;
        }
        return this.ikS.get(i);
    }

    public void yJ(int i) {
        cbT();
    }

    private void cbT() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ikP + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

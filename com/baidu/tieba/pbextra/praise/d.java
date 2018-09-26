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
    private boolean aPR;
    private String fZK;
    private int fZL;
    private int fZM;
    private int fZN;
    private final List<com.baidu.tieba.pbextra.praise.a> fZO;
    private a fZP;
    private final HttpMessageListener fZQ;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fZL;
        dVar.fZL = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fZK = "";
        this.aPR = true;
        this.fZL = 1;
        this.fZM = 0;
        this.fZN = 0;
        this.fZO = new ArrayList(100);
        this.fZP = null;
        this.fZQ = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fZP != null) {
                        d.this.fZP.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fZP != null) {
                        d.this.fZP.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fZP != null) {
                            d.this.fZP.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fZO.add(aVar);
                        }
                    }
                    d.this.fZN = d.this.fZO.size();
                    d.this.fZM = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fZL > 5) {
                        i = 1003;
                    }
                    if (d.this.fZN >= d.this.fZM) {
                        i = 1002;
                    }
                    if (d.this.fZP != null) {
                        d.this.fZP.a(d.this.fZM, d.this.fZO, i, d.this.fZM - d.this.fZN);
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
        this.fZK = "";
        this.aPR = true;
        this.fZL = 1;
        this.fZM = 0;
        this.fZN = 0;
        this.fZO = new ArrayList(100);
        this.fZP = null;
        this.fZQ = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fZP != null) {
                        d.this.fZP.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fZP != null) {
                        d.this.fZP.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fZP != null) {
                            d.this.fZP.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fZO.add(aVar2);
                        }
                    }
                    d.this.fZN = d.this.fZO.size();
                    d.this.fZM = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fZL > 5) {
                        i = 1003;
                    }
                    if (d.this.fZN >= d.this.fZM) {
                        i = 1002;
                    }
                    if (d.this.fZP != null) {
                        d.this.fZP.a(d.this.fZM, d.this.fZO, i, d.this.fZM - d.this.fZN);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fZK = str3;
        this.fZP = aVar;
        this.aPR = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fZQ);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bhS() {
        return this.aPR;
    }

    public void d(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aPR);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.fZK);
    }

    public void h(Bundle bundle, String str) {
        bundle.putInt(str, this.fZM);
    }

    public void bjM() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fZQ);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bjN() {
        return this.fZK;
    }

    public void rK(int i) {
        this.fZM = i;
    }

    public com.baidu.tieba.pbextra.praise.a rL(int i) {
        if (i <= -1 || i >= this.fZO.size()) {
            return null;
        }
        return this.fZO.get(i);
    }

    public void rM(int i) {
        bjO();
    }

    private void bjO() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fZL + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

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
    private boolean eZv;
    private boolean isAuthor;
    private String lBb;
    private int lBc;
    private int lBd;
    private int lBe;
    private final List<com.baidu.tieba.pbextra.praise.a> lBf;
    private a lBg;
    private final HttpMessageListener lBh;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cR(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.lBc;
        dVar.lBc = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.lBb = "";
        this.eZv = true;
        this.lBc = 1;
        this.lBd = 0;
        this.lBe = 0;
        this.lBf = new ArrayList(100);
        this.lBg = null;
        this.lBh = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lBg != null) {
                        d.this.lBg.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lBg != null) {
                        d.this.lBg.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lBg != null) {
                            d.this.lBg.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.lBf.add(aVar);
                        }
                    }
                    d.this.lBe = d.this.lBf.size();
                    d.this.lBd = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lBc > 5) {
                        i = 1003;
                    }
                    if (d.this.lBe >= d.this.lBd) {
                        i = 1002;
                    }
                    if (d.this.lBg != null) {
                        d.this.lBg.a(d.this.lBd, d.this.lBf, i, d.this.lBd - d.this.lBe);
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
        this.lBb = "";
        this.eZv = true;
        this.lBc = 1;
        this.lBd = 0;
        this.lBe = 0;
        this.lBf = new ArrayList(100);
        this.lBg = null;
        this.lBh = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.lBg != null) {
                        d.this.lBg.cR(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.lBg != null) {
                        d.this.lBg.cR(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.lBg != null) {
                            d.this.lBg.cR(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.lBf.add(aVar2);
                        }
                    }
                    d.this.lBe = d.this.lBf.size();
                    d.this.lBd = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.lBc > 5) {
                        i = 1003;
                    }
                    if (d.this.lBe >= d.this.lBd) {
                        i = 1002;
                    }
                    if (d.this.lBg != null) {
                        d.this.lBg.a(d.this.lBd, d.this.lBf, i, d.this.lBd - d.this.lBe);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.lBb = str3;
        this.lBg = aVar;
        this.eZv = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.lBh);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean djL() {
        return this.eZv;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.eZv);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.lBb);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.lBd);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.lBh);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dnw() {
        return this.lBb;
    }

    public void Gi(int i) {
        this.lBd = i;
    }

    public com.baidu.tieba.pbextra.praise.a Gj(int i) {
        if (i <= -1 || i >= this.lBf.size()) {
            return null;
        }
        return this.lBf.get(i);
    }

    public void Gk(int i) {
        dnx();
    }

    private void dnx() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.lBc + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

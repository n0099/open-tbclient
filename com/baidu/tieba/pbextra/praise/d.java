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
/* loaded from: classes9.dex */
public class d {
    private boolean elr;
    private boolean isAuthor;
    private String kkf;
    private int kkg;
    private int kkh;
    private int kki;
    private final List<com.baidu.tieba.pbextra.praise.a> kkj;
    private a kkk;
    private final HttpMessageListener kkl;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cK(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.kkg;
        dVar.kkg = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.kkf = "";
        this.elr = true;
        this.kkg = 1;
        this.kkh = 0;
        this.kki = 0;
        this.kkj = new ArrayList(100);
        this.kkk = null;
        this.kkl = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kkk != null) {
                        d.this.kkk.cK(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kkk != null) {
                        d.this.kkk.cK(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kkk != null) {
                            d.this.kkk.cK(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.kkj.add(aVar);
                        }
                    }
                    d.this.kki = d.this.kkj.size();
                    d.this.kkh = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kkg > 5) {
                        i = 1003;
                    }
                    if (d.this.kki >= d.this.kkh) {
                        i = 1002;
                    }
                    if (d.this.kkk != null) {
                        d.this.kkk.a(d.this.kkh, d.this.kkj, i, d.this.kkh - d.this.kki);
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
        this.kkf = "";
        this.elr = true;
        this.kkg = 1;
        this.kkh = 0;
        this.kki = 0;
        this.kkj = new ArrayList(100);
        this.kkk = null;
        this.kkl = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kkk != null) {
                        d.this.kkk.cK(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kkk != null) {
                        d.this.kkk.cK(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kkk != null) {
                            d.this.kkk.cK(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.kkj.add(aVar2);
                        }
                    }
                    d.this.kki = d.this.kkj.size();
                    d.this.kkh = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kkg > 5) {
                        i = 1003;
                    }
                    if (d.this.kki >= d.this.kkh) {
                        i = 1002;
                    }
                    if (d.this.kkk != null) {
                        d.this.kkk.a(d.this.kkh, d.this.kkj, i, d.this.kkh - d.this.kki);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.kkf = str3;
        this.kkk = aVar;
        this.elr = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.kkl);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean cJC() {
        return this.elr;
    }

    public void h(Bundle bundle, String str) {
        bundle.putBoolean(str, this.elr);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.kkf);
    }

    public void l(Bundle bundle, String str) {
        bundle.putInt(str, this.kkh);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.kkl);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cNd() {
        return this.kkf;
    }

    public void Bf(int i) {
        this.kkh = i;
    }

    public com.baidu.tieba.pbextra.praise.a Bg(int i) {
        if (i <= -1 || i >= this.kkj.size()) {
            return null;
        }
        return this.kkj.get(i);
    }

    public void Bh(int i) {
        cNe();
    }

    private void cNe() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.kkg + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

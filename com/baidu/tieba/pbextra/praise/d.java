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
    private boolean fzv;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;
    private final List<com.baidu.tieba.pbextra.praise.a> miA;
    private a miB;
    private final HttpMessageListener miC;
    private String miw;
    private int mix;
    private int miy;
    private int miz;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cP(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.mix;
        dVar.mix = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.miw = "";
        this.fzv = true;
        this.mix = 1;
        this.miy = 0;
        this.miz = 0;
        this.miA = new ArrayList(100);
        this.miB = null;
        this.miC = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.miB != null) {
                        d.this.miB.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.miB != null) {
                        d.this.miB.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.miB != null) {
                            d.this.miB.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.miA.add(aVar);
                        }
                    }
                    d.this.miz = d.this.miA.size();
                    d.this.miy = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mix > 5) {
                        i = 1003;
                    }
                    if (d.this.miz >= d.this.miy) {
                        i = 1002;
                    }
                    if (d.this.miB != null) {
                        d.this.miB.a(d.this.miy, d.this.miA, i, d.this.miy - d.this.miz);
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
        this.miw = "";
        this.fzv = true;
        this.mix = 1;
        this.miy = 0;
        this.miz = 0;
        this.miA = new ArrayList(100);
        this.miB = null;
        this.miC = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.miB != null) {
                        d.this.miB.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.miB != null) {
                        d.this.miB.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.miB != null) {
                            d.this.miB.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.miA.add(aVar2);
                        }
                    }
                    d.this.miz = d.this.miA.size();
                    d.this.miy = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mix > 5) {
                        i = 1003;
                    }
                    if (d.this.miz >= d.this.miy) {
                        i = 1002;
                    }
                    if (d.this.miB != null) {
                        d.this.miB.a(d.this.miy, d.this.miA, i, d.this.miy - d.this.miz);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.miw = str3;
        this.miB = aVar;
        this.fzv = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.miC);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dql() {
        return this.fzv;
    }

    public void k(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fzv);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void m(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void n(Bundle bundle, String str) {
        bundle.putString(str, this.miw);
    }

    public void o(Bundle bundle, String str) {
        bundle.putInt(str, this.miy);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.miC);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dtW() {
        return this.miw;
    }

    public void Gq(int i) {
        this.miy = i;
    }

    public com.baidu.tieba.pbextra.praise.a Gr(int i) {
        if (i <= -1 || i >= this.miA.size()) {
            return null;
        }
        return this.miA.get(i);
    }

    public void Gs(int i) {
        dtX();
    }

    private void dtX() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.mix + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

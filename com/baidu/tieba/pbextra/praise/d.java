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
    private String kiZ;
    private int kja;
    private int kjb;
    private int kjc;
    private final List<com.baidu.tieba.pbextra.praise.a> kjd;
    private a kje;
    private final HttpMessageListener kjf;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cK(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.kja;
        dVar.kja = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.kiZ = "";
        this.elr = true;
        this.kja = 1;
        this.kjb = 0;
        this.kjc = 0;
        this.kjd = new ArrayList(100);
        this.kje = null;
        this.kjf = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kje != null) {
                        d.this.kje.cK(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kje != null) {
                        d.this.kje.cK(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kje != null) {
                            d.this.kje.cK(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.kjd.add(aVar);
                        }
                    }
                    d.this.kjc = d.this.kjd.size();
                    d.this.kjb = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kja > 5) {
                        i = 1003;
                    }
                    if (d.this.kjc >= d.this.kjb) {
                        i = 1002;
                    }
                    if (d.this.kje != null) {
                        d.this.kje.a(d.this.kjb, d.this.kjd, i, d.this.kjb - d.this.kjc);
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
        this.kiZ = "";
        this.elr = true;
        this.kja = 1;
        this.kjb = 0;
        this.kjc = 0;
        this.kjd = new ArrayList(100);
        this.kje = null;
        this.kjf = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kje != null) {
                        d.this.kje.cK(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kje != null) {
                        d.this.kje.cK(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kje != null) {
                            d.this.kje.cK(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.kjd.add(aVar2);
                        }
                    }
                    d.this.kjc = d.this.kjd.size();
                    d.this.kjb = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kja > 5) {
                        i = 1003;
                    }
                    if (d.this.kjc >= d.this.kjb) {
                        i = 1002;
                    }
                    if (d.this.kje != null) {
                        d.this.kje.a(d.this.kjb, d.this.kjd, i, d.this.kjb - d.this.kjc);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.kiZ = str3;
        this.kje = aVar;
        this.elr = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.kjf);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean cJm() {
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
        bundle.putString(str, this.kiZ);
    }

    public void l(Bundle bundle, String str) {
        bundle.putInt(str, this.kjb);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.kjf);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cMN() {
        return this.kiZ;
    }

    public void Bd(int i) {
        this.kjb = i;
    }

    public com.baidu.tieba.pbextra.praise.a Be(int i) {
        if (i <= -1 || i >= this.kjd.size()) {
            return null;
        }
        return this.kjd.get(i);
    }

    public void Bf(int i) {
        cMO();
    }

    private void cMO() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.kja + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

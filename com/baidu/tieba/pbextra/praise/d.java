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
/* loaded from: classes7.dex */
public class d {
    private boolean dsP;
    private boolean isAuthor;
    private String jeg;
    private int jeh;
    private int jei;
    private int jej;
    private final List<com.baidu.tieba.pbextra.praise.a> jek;
    private a jel;
    private final HttpMessageListener jem;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void br(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jeh;
        dVar.jeh = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jeg = "";
        this.dsP = true;
        this.jeh = 1;
        this.jei = 0;
        this.jej = 0;
        this.jek = new ArrayList(100);
        this.jel = null;
        this.jem = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jel != null) {
                        d.this.jel.br(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jel != null) {
                        d.this.jel.br(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jel != null) {
                            d.this.jel.br(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jek.add(aVar);
                        }
                    }
                    d.this.jej = d.this.jek.size();
                    d.this.jei = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jeh > 5) {
                        i = 1003;
                    }
                    if (d.this.jej >= d.this.jei) {
                        i = 1002;
                    }
                    if (d.this.jel != null) {
                        d.this.jel.a(d.this.jei, d.this.jek, i, d.this.jei - d.this.jej);
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
        this.jeg = "";
        this.dsP = true;
        this.jeh = 1;
        this.jei = 0;
        this.jej = 0;
        this.jek = new ArrayList(100);
        this.jel = null;
        this.jem = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jel != null) {
                        d.this.jel.br(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jel != null) {
                        d.this.jel.br(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jel != null) {
                            d.this.jel.br(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jek.add(aVar2);
                        }
                    }
                    d.this.jej = d.this.jek.size();
                    d.this.jei = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jeh > 5) {
                        i = 1003;
                    }
                    if (d.this.jej >= d.this.jei) {
                        i = 1002;
                    }
                    if (d.this.jel != null) {
                        d.this.jel.a(d.this.jei, d.this.jek, i, d.this.jei - d.this.jej);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jeg = str3;
        this.jel = aVar;
        this.dsP = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jem);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean cpV() {
        return this.dsP;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dsP);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jeg);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jei);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jem);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cts() {
        return this.jeg;
    }

    public void zC(int i) {
        this.jei = i;
    }

    public com.baidu.tieba.pbextra.praise.a zD(int i) {
        if (i <= -1 || i >= this.jek.size()) {
            return null;
        }
        return this.jek.get(i);
    }

    public void zE(int i) {
        ctt();
    }

    private void ctt() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jeh + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

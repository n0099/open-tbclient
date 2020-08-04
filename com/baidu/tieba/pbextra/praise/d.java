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
/* loaded from: classes16.dex */
public class d {
    private boolean eAv;
    private boolean isAuthor;
    private String kMV;
    private int kMW;
    private int kMX;
    private int kMY;
    private final List<com.baidu.tieba.pbextra.praise.a> kMZ;
    private a kNa;
    private final HttpMessageListener kNb;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes16.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cJ(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.kMW;
        dVar.kMW = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.kMV = "";
        this.eAv = true;
        this.kMW = 1;
        this.kMX = 0;
        this.kMY = 0;
        this.kMZ = new ArrayList(100);
        this.kNa = null;
        this.kNb = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kNa != null) {
                        d.this.kNa.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kNa != null) {
                        d.this.kNa.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kNa != null) {
                            d.this.kNa.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.kMZ.add(aVar);
                        }
                    }
                    d.this.kMY = d.this.kMZ.size();
                    d.this.kMX = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kMW > 5) {
                        i = 1003;
                    }
                    if (d.this.kMY >= d.this.kMX) {
                        i = 1002;
                    }
                    if (d.this.kNa != null) {
                        d.this.kNa.a(d.this.kMX, d.this.kMZ, i, d.this.kMX - d.this.kMY);
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
        this.kMV = "";
        this.eAv = true;
        this.kMW = 1;
        this.kMX = 0;
        this.kMY = 0;
        this.kMZ = new ArrayList(100);
        this.kNa = null;
        this.kNb = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kNa != null) {
                        d.this.kNa.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kNa != null) {
                        d.this.kNa.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kNa != null) {
                            d.this.kNa.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.kMZ.add(aVar2);
                        }
                    }
                    d.this.kMY = d.this.kMZ.size();
                    d.this.kMX = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kMW > 5) {
                        i = 1003;
                    }
                    if (d.this.kMY >= d.this.kMX) {
                        i = 1002;
                    }
                    if (d.this.kNa != null) {
                        d.this.kNa.a(d.this.kMX, d.this.kMZ, i, d.this.kMX - d.this.kMY);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.kMV = str3;
        this.kNa = aVar;
        this.eAv = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.kNb);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean cRH() {
        return this.eAv;
    }

    public void h(Bundle bundle, String str) {
        bundle.putBoolean(str, this.eAv);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.kMV);
    }

    public void l(Bundle bundle, String str) {
        bundle.putInt(str, this.kMX);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.kNb);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cVl() {
        return this.kMV;
    }

    public void CH(int i) {
        this.kMX = i;
    }

    public com.baidu.tieba.pbextra.praise.a CI(int i) {
        if (i <= -1 || i >= this.kMZ.size()) {
            return null;
        }
        return this.kMZ.get(i);
    }

    public void CJ(int i) {
        cVm();
    }

    private void cVm() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.kMW + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

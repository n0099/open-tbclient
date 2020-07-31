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
    private String kMT;
    private int kMU;
    private int kMV;
    private int kMW;
    private final List<com.baidu.tieba.pbextra.praise.a> kMX;
    private a kMY;
    private final HttpMessageListener kMZ;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes16.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cJ(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.kMU;
        dVar.kMU = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.kMT = "";
        this.eAv = true;
        this.kMU = 1;
        this.kMV = 0;
        this.kMW = 0;
        this.kMX = new ArrayList(100);
        this.kMY = null;
        this.kMZ = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kMY != null) {
                        d.this.kMY.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kMY != null) {
                        d.this.kMY.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kMY != null) {
                            d.this.kMY.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.kMX.add(aVar);
                        }
                    }
                    d.this.kMW = d.this.kMX.size();
                    d.this.kMV = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kMU > 5) {
                        i = 1003;
                    }
                    if (d.this.kMW >= d.this.kMV) {
                        i = 1002;
                    }
                    if (d.this.kMY != null) {
                        d.this.kMY.a(d.this.kMV, d.this.kMX, i, d.this.kMV - d.this.kMW);
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
        this.kMT = "";
        this.eAv = true;
        this.kMU = 1;
        this.kMV = 0;
        this.kMW = 0;
        this.kMX = new ArrayList(100);
        this.kMY = null;
        this.kMZ = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.kMY != null) {
                        d.this.kMY.cJ(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.kMY != null) {
                        d.this.kMY.cJ(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.kMY != null) {
                            d.this.kMY.cJ(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.kMX.add(aVar2);
                        }
                    }
                    d.this.kMW = d.this.kMX.size();
                    d.this.kMV = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.kMU > 5) {
                        i = 1003;
                    }
                    if (d.this.kMW >= d.this.kMV) {
                        i = 1002;
                    }
                    if (d.this.kMY != null) {
                        d.this.kMY.a(d.this.kMV, d.this.kMX, i, d.this.kMV - d.this.kMW);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.kMT = str3;
        this.kMY = aVar;
        this.eAv = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.kMZ);
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
        bundle.putString(str, this.kMT);
    }

    public void l(Bundle bundle, String str) {
        bundle.putInt(str, this.kMV);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.kMZ);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cVl() {
        return this.kMT;
    }

    public void CH(int i) {
        this.kMV = i;
    }

    public com.baidu.tieba.pbextra.praise.a CI(int i) {
        if (i <= -1 || i >= this.kMX.size()) {
            return null;
        }
        return this.kMX.get(i);
    }

    public void CJ(int i) {
        cVm();
    }

    private void cVm() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.kMU + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

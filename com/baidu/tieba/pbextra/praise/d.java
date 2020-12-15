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
    private boolean fux;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;
    private String mhR;
    private int mhS;
    private int mhT;
    private int mhU;
    private final List<com.baidu.tieba.pbextra.praise.a> mhV;
    private a mhW;
    private final HttpMessageListener mhX;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cW(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.mhS;
        dVar.mhS = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.mhR = "";
        this.fux = true;
        this.mhS = 1;
        this.mhT = 0;
        this.mhU = 0;
        this.mhV = new ArrayList(100);
        this.mhW = null;
        this.mhX = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mhW != null) {
                        d.this.mhW.cW(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mhW != null) {
                        d.this.mhW.cW(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mhW != null) {
                            d.this.mhW.cW(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.mhV.add(aVar);
                        }
                    }
                    d.this.mhU = d.this.mhV.size();
                    d.this.mhT = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mhS > 5) {
                        i = 1003;
                    }
                    if (d.this.mhU >= d.this.mhT) {
                        i = 1002;
                    }
                    if (d.this.mhW != null) {
                        d.this.mhW.a(d.this.mhT, d.this.mhV, i, d.this.mhT - d.this.mhU);
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
        this.mhR = "";
        this.fux = true;
        this.mhS = 1;
        this.mhT = 0;
        this.mhU = 0;
        this.mhV = new ArrayList(100);
        this.mhW = null;
        this.mhX = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mhW != null) {
                        d.this.mhW.cW(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mhW != null) {
                        d.this.mhW.cW(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mhW != null) {
                            d.this.mhW.cW(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.mhV.add(aVar2);
                        }
                    }
                    d.this.mhU = d.this.mhV.size();
                    d.this.mhT = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mhS > 5) {
                        i = 1003;
                    }
                    if (d.this.mhU >= d.this.mhT) {
                        i = 1002;
                    }
                    if (d.this.mhW != null) {
                        d.this.mhW.a(d.this.mhT, d.this.mhV, i, d.this.mhT - d.this.mhU);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.mhR = str3;
        this.mhW = aVar;
        this.fux = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.mhX);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dun() {
        return this.fux;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fux);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.mhR);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.mhT);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.mhX);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dxY() {
        return this.mhR;
    }

    public void Id(int i) {
        this.mhT = i;
    }

    public com.baidu.tieba.pbextra.praise.a Ie(int i) {
        if (i <= -1 || i >= this.mhV.size()) {
            return null;
        }
        return this.mhV.get(i);
    }

    public void If(int i) {
        dxZ();
    }

    private void dxZ() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.mhS + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

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
    private boolean dxj;
    private boolean isAuthor;
    private a jfA;
    private final HttpMessageListener jfB;
    private String jfv;
    private int jfw;
    private int jfx;
    private int jfy;
    private final List<com.baidu.tieba.pbextra.praise.a> jfz;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void bt(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jfw;
        dVar.jfw = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jfv = "";
        this.dxj = true;
        this.jfw = 1;
        this.jfx = 0;
        this.jfy = 0;
        this.jfz = new ArrayList(100);
        this.jfA = null;
        this.jfB = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jfA != null) {
                        d.this.jfA.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jfA != null) {
                        d.this.jfA.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jfA != null) {
                            d.this.jfA.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jfz.add(aVar);
                        }
                    }
                    d.this.jfy = d.this.jfz.size();
                    d.this.jfx = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jfw > 5) {
                        i = 1003;
                    }
                    if (d.this.jfy >= d.this.jfx) {
                        i = 1002;
                    }
                    if (d.this.jfA != null) {
                        d.this.jfA.a(d.this.jfx, d.this.jfz, i, d.this.jfx - d.this.jfy);
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
        this.jfv = "";
        this.dxj = true;
        this.jfw = 1;
        this.jfx = 0;
        this.jfy = 0;
        this.jfz = new ArrayList(100);
        this.jfA = null;
        this.jfB = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jfA != null) {
                        d.this.jfA.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jfA != null) {
                        d.this.jfA.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jfA != null) {
                            d.this.jfA.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jfz.add(aVar2);
                        }
                    }
                    d.this.jfy = d.this.jfz.size();
                    d.this.jfx = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jfw > 5) {
                        i = 1003;
                    }
                    if (d.this.jfy >= d.this.jfx) {
                        i = 1002;
                    }
                    if (d.this.jfA != null) {
                        d.this.jfA.a(d.this.jfx, d.this.jfz, i, d.this.jfx - d.this.jfy);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jfv = str3;
        this.jfA = aVar;
        this.dxj = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jfB);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean crq() {
        return this.dxj;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dxj);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jfv);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jfx);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jfB);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cuQ() {
        return this.jfv;
    }

    public void zJ(int i) {
        this.jfx = i;
    }

    public com.baidu.tieba.pbextra.praise.a zK(int i) {
        if (i <= -1 || i >= this.jfz.size()) {
            return null;
        }
        return this.jfz.get(i);
    }

    public void zL(int i) {
        cuR();
    }

    private void cuR() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jfw + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

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
/* loaded from: classes4.dex */
public class d {
    private boolean cFB;
    private int ijA;
    private int ijB;
    private final List<com.baidu.tieba.pbextra.praise.a> ijC;
    private a ijD;
    private final HttpMessageListener ijE;
    private String ijy;
    private int ijz;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void bh(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ijz;
        dVar.ijz = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ijy = "";
        this.cFB = true;
        this.ijz = 1;
        this.ijA = 0;
        this.ijB = 0;
        this.ijC = new ArrayList(100);
        this.ijD = null;
        this.ijE = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ijD != null) {
                        d.this.ijD.bh(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ijD != null) {
                        d.this.ijD.bh(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ijD != null) {
                            d.this.ijD.bh(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.ijC.add(aVar);
                        }
                    }
                    d.this.ijB = d.this.ijC.size();
                    d.this.ijA = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ijz > 5) {
                        i = 1003;
                    }
                    if (d.this.ijB >= d.this.ijA) {
                        i = 1002;
                    }
                    if (d.this.ijD != null) {
                        d.this.ijD.a(d.this.ijA, d.this.ijC, i, d.this.ijA - d.this.ijB);
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
        this.ijy = "";
        this.cFB = true;
        this.ijz = 1;
        this.ijA = 0;
        this.ijB = 0;
        this.ijC = new ArrayList(100);
        this.ijD = null;
        this.ijE = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ijD != null) {
                        d.this.ijD.bh(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ijD != null) {
                        d.this.ijD.bh(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ijD != null) {
                            d.this.ijD.bh(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.ijC.add(aVar2);
                        }
                    }
                    d.this.ijB = d.this.ijC.size();
                    d.this.ijA = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ijz > 5) {
                        i = 1003;
                    }
                    if (d.this.ijB >= d.this.ijA) {
                        i = 1002;
                    }
                    if (d.this.ijD != null) {
                        d.this.ijD.a(d.this.ijA, d.this.ijC, i, d.this.ijA - d.this.ijB);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ijy = str3;
        this.ijD = aVar;
        this.cFB = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ijE);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bWW() {
        return this.cFB;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cFB);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.ijy);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.ijA);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ijE);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String bYU() {
        return this.ijy;
    }

    public void xm(int i) {
        this.ijA = i;
    }

    public com.baidu.tieba.pbextra.praise.a xn(int i) {
        if (i <= -1 || i >= this.ijC.size()) {
            return null;
        }
        return this.ijC.get(i);
    }

    public void xo(int i) {
        bYV();
    }

    private void bYV() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ijz + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

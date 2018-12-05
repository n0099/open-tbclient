package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private boolean aYF;
    private int gpA;
    private int gpB;
    private int gpC;
    private final List<com.baidu.tieba.pbextra.praise.a> gpD;
    private a gpE;
    private final HttpMessageListener gpF;
    private String gpz;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.gpA;
        dVar.gpA = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.gpz = "";
        this.aYF = true;
        this.gpA = 1;
        this.gpB = 0;
        this.gpC = 0;
        this.gpD = new ArrayList(100);
        this.gpE = null;
        this.gpF = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.gpE != null) {
                        d.this.gpE.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.gpE != null) {
                        d.this.gpE.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.gpE != null) {
                            d.this.gpE.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.gpD.add(aVar);
                        }
                    }
                    d.this.gpC = d.this.gpD.size();
                    d.this.gpB = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.gpA > 5) {
                        i = 1003;
                    }
                    if (d.this.gpC >= d.this.gpB) {
                        i = 1002;
                    }
                    if (d.this.gpE != null) {
                        d.this.gpE.a(d.this.gpB, d.this.gpD, i, d.this.gpB - d.this.gpC);
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
        this.gpz = "";
        this.aYF = true;
        this.gpA = 1;
        this.gpB = 0;
        this.gpC = 0;
        this.gpD = new ArrayList(100);
        this.gpE = null;
        this.gpF = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.gpE != null) {
                        d.this.gpE.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.gpE != null) {
                        d.this.gpE.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.gpE != null) {
                            d.this.gpE.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.gpD.add(aVar2);
                        }
                    }
                    d.this.gpC = d.this.gpD.size();
                    d.this.gpB = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.gpA > 5) {
                        i = 1003;
                    }
                    if (d.this.gpC >= d.this.gpB) {
                        i = 1002;
                    }
                    if (d.this.gpE != null) {
                        d.this.gpE.a(d.this.gpB, d.this.gpD, i, d.this.gpB - d.this.gpC);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.gpz = str3;
        this.gpE = aVar;
        this.aYF = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gpF);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bmt() {
        return this.aYF;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aYF);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.gpz);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.gpB);
    }

    public void bol() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.gpF);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bom() {
        return this.gpz;
    }

    public void sU(int i) {
        this.gpB = i;
    }

    public com.baidu.tieba.pbextra.praise.a sV(int i) {
        if (i <= -1 || i >= this.gpD.size()) {
            return null;
        }
        return this.gpD.get(i);
    }

    public void sW(int i) {
        bon();
    }

    private void bon() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.gpA + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

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
    private boolean aVi;
    private String giJ;
    private int giK;
    private int giL;
    private int giM;
    private final List<com.baidu.tieba.pbextra.praise.a> giN;
    private a giO;
    private final HttpMessageListener giP;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.giK;
        dVar.giK = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.giJ = "";
        this.aVi = true;
        this.giK = 1;
        this.giL = 0;
        this.giM = 0;
        this.giN = new ArrayList(100);
        this.giO = null;
        this.giP = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.giO != null) {
                        d.this.giO.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.giO != null) {
                        d.this.giO.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.giO != null) {
                            d.this.giO.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.giN.add(aVar);
                        }
                    }
                    d.this.giM = d.this.giN.size();
                    d.this.giL = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.giK > 5) {
                        i = 1003;
                    }
                    if (d.this.giM >= d.this.giL) {
                        i = 1002;
                    }
                    if (d.this.giO != null) {
                        d.this.giO.a(d.this.giL, d.this.giN, i, d.this.giL - d.this.giM);
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
        this.giJ = "";
        this.aVi = true;
        this.giK = 1;
        this.giL = 0;
        this.giM = 0;
        this.giN = new ArrayList(100);
        this.giO = null;
        this.giP = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.giO != null) {
                        d.this.giO.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.giO != null) {
                        d.this.giO.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.giO != null) {
                            d.this.giO.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.giN.add(aVar2);
                        }
                    }
                    d.this.giM = d.this.giN.size();
                    d.this.giL = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.giK > 5) {
                        i = 1003;
                    }
                    if (d.this.giM >= d.this.giL) {
                        i = 1002;
                    }
                    if (d.this.giO != null) {
                        d.this.giO.a(d.this.giL, d.this.giN, i, d.this.giL - d.this.giM);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.giJ = str3;
        this.giO = aVar;
        this.aVi = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.giP);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bkA() {
        return this.aVi;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aVi);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.giJ);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.giL);
    }

    public void bms() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.giP);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bmt() {
        return this.giJ;
    }

    public void sA(int i) {
        this.giL = i;
    }

    public com.baidu.tieba.pbextra.praise.a sB(int i) {
        if (i <= -1 || i >= this.giN.size()) {
            return null;
        }
        return this.giN.get(i);
    }

    public void sC(int i) {
        bmu();
    }

    private void bmu() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.giK + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

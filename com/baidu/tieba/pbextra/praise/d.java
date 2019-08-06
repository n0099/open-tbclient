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
/* loaded from: classes4.dex */
public class d {
    private boolean csy;
    private String iiP;
    private int iiQ;
    private int iiR;
    private int iiS;
    private final List<com.baidu.tieba.pbextra.praise.a> iiT;
    private a iiU;
    private final HttpMessageListener iiV;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.iiQ;
        dVar.iiQ = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.iiP = "";
        this.csy = true;
        this.iiQ = 1;
        this.iiR = 0;
        this.iiS = 0;
        this.iiT = new ArrayList(100);
        this.iiU = null;
        this.iiV = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.iiU != null) {
                        d.this.iiU.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.iiU != null) {
                        d.this.iiU.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.iiU != null) {
                            d.this.iiU.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.iiT.add(aVar);
                        }
                    }
                    d.this.iiS = d.this.iiT.size();
                    d.this.iiR = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.iiQ > 5) {
                        i = 1003;
                    }
                    if (d.this.iiS >= d.this.iiR) {
                        i = 1002;
                    }
                    if (d.this.iiU != null) {
                        d.this.iiU.a(d.this.iiR, d.this.iiT, i, d.this.iiR - d.this.iiS);
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
        this.iiP = "";
        this.csy = true;
        this.iiQ = 1;
        this.iiR = 0;
        this.iiS = 0;
        this.iiT = new ArrayList(100);
        this.iiU = null;
        this.iiV = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.iiU != null) {
                        d.this.iiU.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.iiU != null) {
                        d.this.iiU.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.iiU != null) {
                            d.this.iiU.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.iiT.add(aVar2);
                        }
                    }
                    d.this.iiS = d.this.iiT.size();
                    d.this.iiR = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.iiQ > 5) {
                        i = 1003;
                    }
                    if (d.this.iiS >= d.this.iiR) {
                        i = 1002;
                    }
                    if (d.this.iiU != null) {
                        d.this.iiU.a(d.this.iiR, d.this.iiT, i, d.this.iiR - d.this.iiS);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.iiP = str3;
        this.iiU = aVar;
        this.csy = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.iiV);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bZg() {
        return this.csy;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.csy);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.iiP);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.iiR);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.iiV);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String cbe() {
        return this.iiP;
    }

    public void yE(int i) {
        this.iiR = i;
    }

    public com.baidu.tieba.pbextra.praise.a yF(int i) {
        if (i <= -1 || i >= this.iiT.size()) {
            return null;
        }
        return this.iiT.get(i);
    }

    public void yG(int i) {
        cbf();
    }

    private void cbf() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.iiQ + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

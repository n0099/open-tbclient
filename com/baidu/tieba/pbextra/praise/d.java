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
    private boolean aMz;
    private final HttpMessageListener fSA;
    private String fSu;
    private int fSv;
    private int fSw;
    private int fSx;
    private final List<com.baidu.tieba.pbextra.praise.a> fSy;
    private a fSz;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fSv;
        dVar.fSv = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fSu = "";
        this.aMz = true;
        this.fSv = 1;
        this.fSw = 0;
        this.fSx = 0;
        this.fSy = new ArrayList(100);
        this.fSz = null;
        this.fSA = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fSz != null) {
                        d.this.fSz.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fSz != null) {
                        d.this.fSz.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fSz != null) {
                            d.this.fSz.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fSy.add(aVar);
                        }
                    }
                    d.this.fSx = d.this.fSy.size();
                    d.this.fSw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fSv > 5) {
                        i = 1003;
                    }
                    if (d.this.fSx >= d.this.fSw) {
                        i = 1002;
                    }
                    if (d.this.fSz != null) {
                        d.this.fSz.a(d.this.fSw, d.this.fSy, i, d.this.fSw - d.this.fSx);
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
        this.fSu = "";
        this.aMz = true;
        this.fSv = 1;
        this.fSw = 0;
        this.fSx = 0;
        this.fSy = new ArrayList(100);
        this.fSz = null;
        this.fSA = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fSz != null) {
                        d.this.fSz.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fSz != null) {
                        d.this.fSz.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fSz != null) {
                            d.this.fSz.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fSy.add(aVar2);
                        }
                    }
                    d.this.fSx = d.this.fSy.size();
                    d.this.fSw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fSv > 5) {
                        i = 1003;
                    }
                    if (d.this.fSx >= d.this.fSw) {
                        i = 1002;
                    }
                    if (d.this.fSz != null) {
                        d.this.fSz.a(d.this.fSw, d.this.fSy, i, d.this.fSw - d.this.fSx);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fSu = str3;
        this.fSz = aVar;
        this.aMz = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fSA);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bfo() {
        return this.aMz;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aMz);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.fSu);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.fSw);
    }

    public void bhl() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fSA);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bhm() {
        return this.fSu;
    }

    public void rn(int i) {
        this.fSw = i;
    }

    public com.baidu.tieba.pbextra.praise.a ro(int i) {
        if (i <= -1 || i >= this.fSy.size()) {
            return null;
        }
        return this.fSy.get(i);
    }

    public void rp(int i) {
        bhn();
    }

    private void bhn() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fSv + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

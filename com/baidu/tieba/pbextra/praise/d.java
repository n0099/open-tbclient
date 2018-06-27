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
    private boolean aMC;
    private String fSr;
    private int fSs;
    private int fSt;
    private int fSu;
    private final List<com.baidu.tieba.pbextra.praise.a> fSv;
    private a fSw;
    private final HttpMessageListener fSx;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fSs;
        dVar.fSs = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fSr = "";
        this.aMC = true;
        this.fSs = 1;
        this.fSt = 0;
        this.fSu = 0;
        this.fSv = new ArrayList(100);
        this.fSw = null;
        this.fSx = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fSw != null) {
                        d.this.fSw.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fSw != null) {
                        d.this.fSw.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fSw != null) {
                            d.this.fSw.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fSv.add(aVar);
                        }
                    }
                    d.this.fSu = d.this.fSv.size();
                    d.this.fSt = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fSs > 5) {
                        i = 1003;
                    }
                    if (d.this.fSu >= d.this.fSt) {
                        i = 1002;
                    }
                    if (d.this.fSw != null) {
                        d.this.fSw.a(d.this.fSt, d.this.fSv, i, d.this.fSt - d.this.fSu);
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
        this.fSr = "";
        this.aMC = true;
        this.fSs = 1;
        this.fSt = 0;
        this.fSu = 0;
        this.fSv = new ArrayList(100);
        this.fSw = null;
        this.fSx = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fSw != null) {
                        d.this.fSw.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fSw != null) {
                        d.this.fSw.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fSw != null) {
                            d.this.fSw.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fSv.add(aVar2);
                        }
                    }
                    d.this.fSu = d.this.fSv.size();
                    d.this.fSt = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fSs > 5) {
                        i = 1003;
                    }
                    if (d.this.fSu >= d.this.fSt) {
                        i = 1002;
                    }
                    if (d.this.fSw != null) {
                        d.this.fSw.a(d.this.fSt, d.this.fSv, i, d.this.fSt - d.this.fSu);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fSr = str3;
        this.fSw = aVar;
        this.aMC = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fSx);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bha() {
        return this.aMC;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aMC);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.fSr);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.fSt);
    }

    public void biX() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fSx);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String biY() {
        return this.fSr;
    }

    public void rq(int i) {
        this.fSt = i;
    }

    public com.baidu.tieba.pbextra.praise.a rr(int i) {
        if (i <= -1 || i >= this.fSv.size()) {
            return null;
        }
        return this.fSv.get(i);
    }

    public void rs(int i) {
        biZ();
    }

    private void biZ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fSs + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

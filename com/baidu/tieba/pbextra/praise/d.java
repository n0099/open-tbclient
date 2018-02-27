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
    private boolean bsG;
    private String ghf;
    private int ghg;
    private int ghh;
    private int ghi;
    private final List<com.baidu.tieba.pbextra.praise.a> ghj;
    private a ghk;
    private final HttpMessageListener ghl;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ghg;
        dVar.ghg = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ghf = "";
        this.bsG = true;
        this.ghg = 1;
        this.ghh = 0;
        this.ghi = 0;
        this.ghj = new ArrayList(100);
        this.ghk = null;
        this.ghl = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghk != null) {
                        d.this.ghk.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghk != null) {
                        d.this.ghk.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghk != null) {
                            d.this.ghk.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.ghj.add(aVar);
                        }
                    }
                    d.this.ghi = d.this.ghj.size();
                    d.this.ghh = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghg > 5) {
                        i = 1003;
                    }
                    if (d.this.ghi >= d.this.ghh) {
                        i = 1002;
                    }
                    if (d.this.ghk != null) {
                        d.this.ghk.a(d.this.ghh, d.this.ghj, i, d.this.ghh - d.this.ghi);
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
        this.ghf = "";
        this.bsG = true;
        this.ghg = 1;
        this.ghh = 0;
        this.ghi = 0;
        this.ghj = new ArrayList(100);
        this.ghk = null;
        this.ghl = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghk != null) {
                        d.this.ghk.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghk != null) {
                        d.this.ghk.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghk != null) {
                            d.this.ghk.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.ghj.add(aVar2);
                        }
                    }
                    d.this.ghi = d.this.ghj.size();
                    d.this.ghh = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghg > 5) {
                        i = 1003;
                    }
                    if (d.this.ghi >= d.this.ghh) {
                        i = 1002;
                    }
                    if (d.this.ghk != null) {
                        d.this.ghk.a(d.this.ghh, d.this.ghj, i, d.this.ghh - d.this.ghi);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ghf = str3;
        this.ghk = aVar;
        this.bsG = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ghl);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bgs() {
        return this.bsG;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.bsG);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.ghf);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.ghh);
    }

    public void biq() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ghl);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bir() {
        return this.ghf;
    }

    public void tA(int i) {
        this.ghh = i;
    }

    public com.baidu.tieba.pbextra.praise.a tB(int i) {
        if (i <= -1 || i >= this.ghj.size()) {
            return null;
        }
        return this.ghj.get(i);
    }

    public void tC(int i) {
        bis();
    }

    private void bis() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ghg + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

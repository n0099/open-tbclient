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
    private boolean aUs;
    private String ghm;
    private int ghn;
    private int gho;
    private int ghp;
    private final List<com.baidu.tieba.pbextra.praise.a> ghq;
    private a ghr;
    private final HttpMessageListener ghs;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ghn;
        dVar.ghn = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ghm = "";
        this.aUs = true;
        this.ghn = 1;
        this.gho = 0;
        this.ghp = 0;
        this.ghq = new ArrayList(100);
        this.ghr = null;
        this.ghs = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghr != null) {
                        d.this.ghr.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghr != null) {
                        d.this.ghr.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghr != null) {
                            d.this.ghr.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.ghq.add(aVar);
                        }
                    }
                    d.this.ghp = d.this.ghq.size();
                    d.this.gho = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghn > 5) {
                        i = 1003;
                    }
                    if (d.this.ghp >= d.this.gho) {
                        i = 1002;
                    }
                    if (d.this.ghr != null) {
                        d.this.ghr.a(d.this.gho, d.this.ghq, i, d.this.gho - d.this.ghp);
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
        this.ghm = "";
        this.aUs = true;
        this.ghn = 1;
        this.gho = 0;
        this.ghp = 0;
        this.ghq = new ArrayList(100);
        this.ghr = null;
        this.ghs = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghr != null) {
                        d.this.ghr.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghr != null) {
                        d.this.ghr.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghr != null) {
                            d.this.ghr.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.ghq.add(aVar2);
                        }
                    }
                    d.this.ghp = d.this.ghq.size();
                    d.this.gho = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghn > 5) {
                        i = 1003;
                    }
                    if (d.this.ghp >= d.this.gho) {
                        i = 1002;
                    }
                    if (d.this.ghr != null) {
                        d.this.ghr.a(d.this.gho, d.this.ghq, i, d.this.gho - d.this.ghp);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ghm = str3;
        this.ghr = aVar;
        this.aUs = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ghs);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean ble() {
        return this.aUs;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aUs);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.ghm);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.gho);
    }

    public void bmX() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ghs);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bmY() {
        return this.ghm;
    }

    public void sh(int i) {
        this.gho = i;
    }

    public com.baidu.tieba.pbextra.praise.a si(int i) {
        if (i <= -1 || i >= this.ghq.size()) {
            return null;
        }
        return this.ghq.get(i);
    }

    public void sj(int i) {
        bmZ();
    }

    private void bmZ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ghn + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

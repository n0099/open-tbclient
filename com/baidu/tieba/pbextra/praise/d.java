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
    private boolean bsT;
    private String ghq;
    private int ghr;
    private int ghs;
    private int ght;
    private final List<com.baidu.tieba.pbextra.praise.a> ghu;
    private a ghv;
    private final HttpMessageListener ghw;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ghr;
        dVar.ghr = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ghq = "";
        this.bsT = true;
        this.ghr = 1;
        this.ghs = 0;
        this.ght = 0;
        this.ghu = new ArrayList(100);
        this.ghv = null;
        this.ghw = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghv != null) {
                        d.this.ghv.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghv != null) {
                        d.this.ghv.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghv != null) {
                            d.this.ghv.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.ghu.add(aVar);
                        }
                    }
                    d.this.ght = d.this.ghu.size();
                    d.this.ghs = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghr > 5) {
                        i = 1003;
                    }
                    if (d.this.ght >= d.this.ghs) {
                        i = 1002;
                    }
                    if (d.this.ghv != null) {
                        d.this.ghv.a(d.this.ghs, d.this.ghu, i, d.this.ghs - d.this.ght);
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
        this.ghq = "";
        this.bsT = true;
        this.ghr = 1;
        this.ghs = 0;
        this.ght = 0;
        this.ghu = new ArrayList(100);
        this.ghv = null;
        this.ghw = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghv != null) {
                        d.this.ghv.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghv != null) {
                        d.this.ghv.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghv != null) {
                            d.this.ghv.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.ghu.add(aVar2);
                        }
                    }
                    d.this.ght = d.this.ghu.size();
                    d.this.ghs = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghr > 5) {
                        i = 1003;
                    }
                    if (d.this.ght >= d.this.ghs) {
                        i = 1002;
                    }
                    if (d.this.ghv != null) {
                        d.this.ghv.a(d.this.ghs, d.this.ghu, i, d.this.ghs - d.this.ght);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ghq = str3;
        this.ghv = aVar;
        this.bsT = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ghw);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bgt() {
        return this.bsT;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.bsT);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.ghq);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.ghs);
    }

    public void bir() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ghw);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bis() {
        return this.ghq;
    }

    public void tz(int i) {
        this.ghs = i;
    }

    public com.baidu.tieba.pbextra.praise.a tA(int i) {
        if (i <= -1 || i >= this.ghu.size()) {
            return null;
        }
        return this.ghu.get(i);
    }

    public void tB(int i) {
        bit();
    }

    private void bit() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ghr + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

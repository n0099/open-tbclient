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
    private boolean bsJ;
    private a ghA;
    private final HttpMessageListener ghB;
    private String ghv;
    private int ghw;
    private int ghx;
    private int ghy;
    private final List<com.baidu.tieba.pbextra.praise.a> ghz;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ghw;
        dVar.ghw = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ghv = "";
        this.bsJ = true;
        this.ghw = 1;
        this.ghx = 0;
        this.ghy = 0;
        this.ghz = new ArrayList(100);
        this.ghA = null;
        this.ghB = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghA != null) {
                        d.this.ghA.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghA != null) {
                        d.this.ghA.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghA != null) {
                            d.this.ghA.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.ghz.add(aVar);
                        }
                    }
                    d.this.ghy = d.this.ghz.size();
                    d.this.ghx = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghw > 5) {
                        i = 1003;
                    }
                    if (d.this.ghy >= d.this.ghx) {
                        i = 1002;
                    }
                    if (d.this.ghA != null) {
                        d.this.ghA.a(d.this.ghx, d.this.ghz, i, d.this.ghx - d.this.ghy);
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
        this.ghv = "";
        this.bsJ = true;
        this.ghw = 1;
        this.ghx = 0;
        this.ghy = 0;
        this.ghz = new ArrayList(100);
        this.ghA = null;
        this.ghB = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ghA != null) {
                        d.this.ghA.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ghA != null) {
                        d.this.ghA.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ghA != null) {
                            d.this.ghA.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.ghz.add(aVar2);
                        }
                    }
                    d.this.ghy = d.this.ghz.size();
                    d.this.ghx = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ghw > 5) {
                        i = 1003;
                    }
                    if (d.this.ghy >= d.this.ghx) {
                        i = 1002;
                    }
                    if (d.this.ghA != null) {
                        d.this.ghA.a(d.this.ghx, d.this.ghz, i, d.this.ghx - d.this.ghy);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ghv = str3;
        this.ghA = aVar;
        this.bsJ = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ghB);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bgt() {
        return this.bsJ;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.bsJ);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.ghv);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.ghx);
    }

    public void bir() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ghB);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bis() {
        return this.ghv;
    }

    public void tA(int i) {
        this.ghx = i;
    }

    public com.baidu.tieba.pbextra.praise.a tB(int i) {
        if (i <= -1 || i >= this.ghz.size()) {
            return null;
        }
        return this.ghz.get(i);
    }

    public void tC(int i) {
        bit();
    }

    private void bit() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ghw + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

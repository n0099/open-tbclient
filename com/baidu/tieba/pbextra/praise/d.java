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
    private boolean crd;
    private final HttpMessageListener ibA;
    private String ibu;
    private int ibv;
    private int ibw;
    private int ibx;
    private final List<com.baidu.tieba.pbextra.praise.a> iby;
    private a ibz;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.ibv;
        dVar.ibv = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.ibu = "";
        this.crd = true;
        this.ibv = 1;
        this.ibw = 0;
        this.ibx = 0;
        this.iby = new ArrayList(100);
        this.ibz = null;
        this.ibA = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ibz != null) {
                        d.this.ibz.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ibz != null) {
                        d.this.ibz.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ibz != null) {
                            d.this.ibz.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.iby.add(aVar);
                        }
                    }
                    d.this.ibx = d.this.iby.size();
                    d.this.ibw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ibv > 5) {
                        i = 1003;
                    }
                    if (d.this.ibx >= d.this.ibw) {
                        i = 1002;
                    }
                    if (d.this.ibz != null) {
                        d.this.ibz.a(d.this.ibw, d.this.iby, i, d.this.ibw - d.this.ibx);
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
        this.ibu = "";
        this.crd = true;
        this.ibv = 1;
        this.ibw = 0;
        this.ibx = 0;
        this.iby = new ArrayList(100);
        this.ibz = null;
        this.ibA = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.ibz != null) {
                        d.this.ibz.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.ibz != null) {
                        d.this.ibz.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.ibz != null) {
                            d.this.ibz.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.iby.add(aVar2);
                        }
                    }
                    d.this.ibx = d.this.iby.size();
                    d.this.ibw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.ibv > 5) {
                        i = 1003;
                    }
                    if (d.this.ibx >= d.this.ibw) {
                        i = 1002;
                    }
                    if (d.this.ibz != null) {
                        d.this.ibz.a(d.this.ibw, d.this.iby, i, d.this.ibw - d.this.ibx);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.ibu = str3;
        this.ibz = aVar;
        this.crd = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.ibA);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bWa() {
        return this.crd;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.crd);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.ibu);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.ibw);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.ibA);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bXW() {
        return this.ibu;
    }

    public void xX(int i) {
        this.ibw = i;
    }

    public com.baidu.tieba.pbextra.praise.a xY(int i) {
        if (i <= -1 || i >= this.iby.size()) {
            return null;
        }
        return this.iby.get(i);
    }

    public void xZ(int i) {
        bXX();
    }

    private void bXX() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.ibv + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

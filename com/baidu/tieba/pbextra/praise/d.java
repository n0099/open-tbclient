package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    private boolean dwW;
    private boolean isAuthor;
    private String jfj;
    private int jfk;
    private int jfl;
    private int jfm;
    private final List<com.baidu.tieba.pbextra.praise.a> jfn;
    private a jfo;
    private final HttpMessageListener jfp;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void bt(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jfk;
        dVar.jfk = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jfj = "";
        this.dwW = true;
        this.jfk = 1;
        this.jfl = 0;
        this.jfm = 0;
        this.jfn = new ArrayList(100);
        this.jfo = null;
        this.jfp = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jfo != null) {
                        d.this.jfo.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jfo != null) {
                        d.this.jfo.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jfo != null) {
                            d.this.jfo.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jfn.add(aVar);
                        }
                    }
                    d.this.jfm = d.this.jfn.size();
                    d.this.jfl = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jfk > 5) {
                        i = 1003;
                    }
                    if (d.this.jfm >= d.this.jfl) {
                        i = 1002;
                    }
                    if (d.this.jfo != null) {
                        d.this.jfo.a(d.this.jfl, d.this.jfn, i, d.this.jfl - d.this.jfm);
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
        this.jfj = "";
        this.dwW = true;
        this.jfk = 1;
        this.jfl = 0;
        this.jfm = 0;
        this.jfn = new ArrayList(100);
        this.jfo = null;
        this.jfp = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jfo != null) {
                        d.this.jfo.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jfo != null) {
                        d.this.jfo.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jfo != null) {
                            d.this.jfo.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jfn.add(aVar2);
                        }
                    }
                    d.this.jfm = d.this.jfn.size();
                    d.this.jfl = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jfk > 5) {
                        i = 1003;
                    }
                    if (d.this.jfm >= d.this.jfl) {
                        i = 1002;
                    }
                    if (d.this.jfo != null) {
                        d.this.jfo.a(d.this.jfl, d.this.jfn, i, d.this.jfl - d.this.jfm);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jfj = str3;
        this.jfo = aVar;
        this.dwW = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jfp);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean crp() {
        return this.dwW;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dwW);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jfj);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jfl);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jfp);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cuP() {
        return this.jfj;
    }

    public void zJ(int i) {
        this.jfl = i;
    }

    public com.baidu.tieba.pbextra.praise.a zK(int i) {
        if (i <= -1 || i >= this.jfn.size()) {
            return null;
        }
        return this.jfn.get(i);
    }

    public void zL(int i) {
        cuQ();
    }

    private void cuQ() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jfk + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

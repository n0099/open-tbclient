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
    private boolean dwV;
    private boolean isAuthor;
    private String jfh;
    private int jfi;
    private int jfj;
    private int jfk;
    private final List<com.baidu.tieba.pbextra.praise.a> jfl;
    private a jfm;
    private final HttpMessageListener jfn;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void bt(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jfi;
        dVar.jfi = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jfh = "";
        this.dwV = true;
        this.jfi = 1;
        this.jfj = 0;
        this.jfk = 0;
        this.jfl = new ArrayList(100);
        this.jfm = null;
        this.jfn = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jfm != null) {
                        d.this.jfm.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jfm != null) {
                        d.this.jfm.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jfm != null) {
                            d.this.jfm.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jfl.add(aVar);
                        }
                    }
                    d.this.jfk = d.this.jfl.size();
                    d.this.jfj = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jfi > 5) {
                        i = 1003;
                    }
                    if (d.this.jfk >= d.this.jfj) {
                        i = 1002;
                    }
                    if (d.this.jfm != null) {
                        d.this.jfm.a(d.this.jfj, d.this.jfl, i, d.this.jfj - d.this.jfk);
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
        this.jfh = "";
        this.dwV = true;
        this.jfi = 1;
        this.jfj = 0;
        this.jfk = 0;
        this.jfl = new ArrayList(100);
        this.jfm = null;
        this.jfn = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jfm != null) {
                        d.this.jfm.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jfm != null) {
                        d.this.jfm.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jfm != null) {
                            d.this.jfm.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jfl.add(aVar2);
                        }
                    }
                    d.this.jfk = d.this.jfl.size();
                    d.this.jfj = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jfi > 5) {
                        i = 1003;
                    }
                    if (d.this.jfk >= d.this.jfj) {
                        i = 1002;
                    }
                    if (d.this.jfm != null) {
                        d.this.jfm.a(d.this.jfj, d.this.jfl, i, d.this.jfj - d.this.jfk);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jfh = str3;
        this.jfm = aVar;
        this.dwV = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jfn);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean crn() {
        return this.dwV;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dwV);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jfh);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jfj);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jfn);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cuN() {
        return this.jfh;
    }

    public void zJ(int i) {
        this.jfj = i;
    }

    public com.baidu.tieba.pbextra.praise.a zK(int i) {
        if (i <= -1 || i >= this.jfl.size()) {
            return null;
        }
        return this.jfl.get(i);
    }

    public void zL(int i) {
        cuO();
    }

    private void cuO() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jfi + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

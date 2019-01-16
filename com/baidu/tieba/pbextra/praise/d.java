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
    private boolean aZs;
    private final HttpMessageListener gtA;
    private String gtu;
    private int gtv;
    private int gtw;
    private int gtx;
    private final List<com.baidu.tieba.pbextra.praise.a> gty;
    private a gtz;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.gtv;
        dVar.gtv = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.gtu = "";
        this.aZs = true;
        this.gtv = 1;
        this.gtw = 0;
        this.gtx = 0;
        this.gty = new ArrayList(100);
        this.gtz = null;
        this.gtA = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.gtz != null) {
                        d.this.gtz.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.gtz != null) {
                        d.this.gtz.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.gtz != null) {
                            d.this.gtz.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.gty.add(aVar);
                        }
                    }
                    d.this.gtx = d.this.gty.size();
                    d.this.gtw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.gtv > 5) {
                        i = 1003;
                    }
                    if (d.this.gtx >= d.this.gtw) {
                        i = 1002;
                    }
                    if (d.this.gtz != null) {
                        d.this.gtz.a(d.this.gtw, d.this.gty, i, d.this.gtw - d.this.gtx);
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
        this.gtu = "";
        this.aZs = true;
        this.gtv = 1;
        this.gtw = 0;
        this.gtx = 0;
        this.gty = new ArrayList(100);
        this.gtz = null;
        this.gtA = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.gtz != null) {
                        d.this.gtz.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.gtz != null) {
                        d.this.gtz.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.gtz != null) {
                            d.this.gtz.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.gty.add(aVar2);
                        }
                    }
                    d.this.gtx = d.this.gty.size();
                    d.this.gtw = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.gtv > 5) {
                        i = 1003;
                    }
                    if (d.this.gtx >= d.this.gtw) {
                        i = 1002;
                    }
                    if (d.this.gtz != null) {
                        d.this.gtz.a(d.this.gtw, d.this.gty, i, d.this.gtw - d.this.gtx);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.gtu = str3;
        this.gtz = aVar;
        this.aZs = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gtA);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bnM() {
        return this.aZs;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aZs);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.gtu);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.gtw);
    }

    public void bpF() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.gtA);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bpG() {
        return this.gtu;
    }

    public void tl(int i) {
        this.gtw = i;
    }

    public com.baidu.tieba.pbextra.praise.a tm(int i) {
        if (i <= -1 || i >= this.gty.size()) {
            return null;
        }
        return this.gty.get(i);
    }

    public void tn(int i) {
        bpH();
    }

    private void bpH() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.gtv + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

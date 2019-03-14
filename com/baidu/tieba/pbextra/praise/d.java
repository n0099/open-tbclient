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
    private boolean ciS;
    private String hJF;
    private int hJG;
    private int hJH;
    private int hJI;
    private final List<com.baidu.tieba.pbextra.praise.a> hJJ;
    private a hJK;
    private final HttpMessageListener hJL;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.hJG;
        dVar.hJG = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.hJF = "";
        this.ciS = true;
        this.hJG = 1;
        this.hJH = 0;
        this.hJI = 0;
        this.hJJ = new ArrayList(100);
        this.hJK = null;
        this.hJL = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.hJK != null) {
                        d.this.hJK.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.hJK != null) {
                        d.this.hJK.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.hJK != null) {
                            d.this.hJK.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.hJJ.add(aVar);
                        }
                    }
                    d.this.hJI = d.this.hJJ.size();
                    d.this.hJH = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.hJG > 5) {
                        i = 1003;
                    }
                    if (d.this.hJI >= d.this.hJH) {
                        i = 1002;
                    }
                    if (d.this.hJK != null) {
                        d.this.hJK.a(d.this.hJH, d.this.hJJ, i, d.this.hJH - d.this.hJI);
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
        this.hJF = "";
        this.ciS = true;
        this.hJG = 1;
        this.hJH = 0;
        this.hJI = 0;
        this.hJJ = new ArrayList(100);
        this.hJK = null;
        this.hJL = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.hJK != null) {
                        d.this.hJK.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.hJK != null) {
                        d.this.hJK.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.hJK != null) {
                            d.this.hJK.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.hJJ.add(aVar2);
                        }
                    }
                    d.this.hJI = d.this.hJJ.size();
                    d.this.hJH = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.hJG > 5) {
                        i = 1003;
                    }
                    if (d.this.hJI >= d.this.hJH) {
                        i = 1002;
                    }
                    if (d.this.hJK != null) {
                        d.this.hJK.a(d.this.hJH, d.this.hJJ, i, d.this.hJH - d.this.hJI);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.hJF = str3;
        this.hJK = aVar;
        this.ciS = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.hJL);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bOh() {
        return this.ciS;
    }

    public void f(Bundle bundle, String str) {
        bundle.putBoolean(str, this.ciS);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.hJF);
    }

    public void j(Bundle bundle, String str) {
        bundle.putInt(str, this.hJH);
    }

    public void bQd() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.hJL);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bQe() {
        return this.hJF;
    }

    public void wV(int i) {
        this.hJH = i;
    }

    public com.baidu.tieba.pbextra.praise.a wW(int i) {
        if (i <= -1 || i >= this.hJJ.size()) {
            return null;
        }
        return this.hJJ.get(i);
    }

    public void wX(int i) {
        bQf();
    }

    private void bQf() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.hJG + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

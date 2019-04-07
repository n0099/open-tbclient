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
    private boolean ciU;
    private String hJr;
    private int hJs;
    private int hJt;
    private int hJu;
    private final List<com.baidu.tieba.pbextra.praise.a> hJv;
    private a hJw;
    private final HttpMessageListener hJx;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.hJs;
        dVar.hJs = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.hJr = "";
        this.ciU = true;
        this.hJs = 1;
        this.hJt = 0;
        this.hJu = 0;
        this.hJv = new ArrayList(100);
        this.hJw = null;
        this.hJx = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.hJw != null) {
                        d.this.hJw.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.hJw != null) {
                        d.this.hJw.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.hJw != null) {
                            d.this.hJw.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.hJv.add(aVar);
                        }
                    }
                    d.this.hJu = d.this.hJv.size();
                    d.this.hJt = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.hJs > 5) {
                        i = 1003;
                    }
                    if (d.this.hJu >= d.this.hJt) {
                        i = 1002;
                    }
                    if (d.this.hJw != null) {
                        d.this.hJw.a(d.this.hJt, d.this.hJv, i, d.this.hJt - d.this.hJu);
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
        this.hJr = "";
        this.ciU = true;
        this.hJs = 1;
        this.hJt = 0;
        this.hJu = 0;
        this.hJv = new ArrayList(100);
        this.hJw = null;
        this.hJx = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.hJw != null) {
                        d.this.hJw.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.hJw != null) {
                        d.this.hJw.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.hJw != null) {
                            d.this.hJw.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.hJv.add(aVar2);
                        }
                    }
                    d.this.hJu = d.this.hJv.size();
                    d.this.hJt = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.hJs > 5) {
                        i = 1003;
                    }
                    if (d.this.hJu >= d.this.hJt) {
                        i = 1002;
                    }
                    if (d.this.hJw != null) {
                        d.this.hJw.a(d.this.hJt, d.this.hJv, i, d.this.hJt - d.this.hJu);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.hJr = str3;
        this.hJw = aVar;
        this.ciU = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.hJx);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bOe() {
        return this.ciU;
    }

    public void f(Bundle bundle, String str) {
        bundle.putBoolean(str, this.ciU);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.hJr);
    }

    public void j(Bundle bundle, String str) {
        bundle.putInt(str, this.hJt);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.hJx);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bQa() {
        return this.hJr;
    }

    public void wR(int i) {
        this.hJt = i;
    }

    public com.baidu.tieba.pbextra.praise.a wS(int i) {
        if (i <= -1 || i >= this.hJv.size()) {
            return null;
        }
        return this.hJv.get(i);
    }

    public void wT(int i) {
        bQb();
    }

    private void bQb() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.hJs + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

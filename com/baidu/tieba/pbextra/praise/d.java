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
    private boolean ciV;
    private String hJs;
    private int hJt;
    private int hJu;
    private int hJv;
    private final List<com.baidu.tieba.pbextra.praise.a> hJw;
    private a hJx;
    private final HttpMessageListener hJy;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.hJt;
        dVar.hJt = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.hJs = "";
        this.ciV = true;
        this.hJt = 1;
        this.hJu = 0;
        this.hJv = 0;
        this.hJw = new ArrayList(100);
        this.hJx = null;
        this.hJy = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.hJx != null) {
                        d.this.hJx.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.hJx != null) {
                        d.this.hJx.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.hJx != null) {
                            d.this.hJx.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.hJw.add(aVar);
                        }
                    }
                    d.this.hJv = d.this.hJw.size();
                    d.this.hJu = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.hJt > 5) {
                        i = 1003;
                    }
                    if (d.this.hJv >= d.this.hJu) {
                        i = 1002;
                    }
                    if (d.this.hJx != null) {
                        d.this.hJx.a(d.this.hJu, d.this.hJw, i, d.this.hJu - d.this.hJv);
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
        this.hJs = "";
        this.ciV = true;
        this.hJt = 1;
        this.hJu = 0;
        this.hJv = 0;
        this.hJw = new ArrayList(100);
        this.hJx = null;
        this.hJy = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.hJx != null) {
                        d.this.hJx.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.hJx != null) {
                        d.this.hJx.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.hJx != null) {
                            d.this.hJx.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.hJw.add(aVar2);
                        }
                    }
                    d.this.hJv = d.this.hJw.size();
                    d.this.hJu = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.hJt > 5) {
                        i = 1003;
                    }
                    if (d.this.hJv >= d.this.hJu) {
                        i = 1002;
                    }
                    if (d.this.hJx != null) {
                        d.this.hJx.a(d.this.hJu, d.this.hJw, i, d.this.hJu - d.this.hJv);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.hJs = str3;
        this.hJx = aVar;
        this.ciV = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.hJy);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bOe() {
        return this.ciV;
    }

    public void f(Bundle bundle, String str) {
        bundle.putBoolean(str, this.ciV);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.hJs);
    }

    public void j(Bundle bundle, String str) {
        bundle.putInt(str, this.hJu);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.hJy);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bQa() {
        return this.hJs;
    }

    public void wR(int i) {
        this.hJu = i;
    }

    public com.baidu.tieba.pbextra.praise.a wS(int i) {
        if (i <= -1 || i >= this.hJw.size()) {
            return null;
        }
        return this.hJw.get(i);
    }

    public void wT(int i) {
        bQb();
    }

    private void bQb() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.hJt + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

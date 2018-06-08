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
    private boolean aLG;
    private String fOo;
    private int fOp;
    private int fOq;
    private int fOr;
    private final List<com.baidu.tieba.pbextra.praise.a> fOs;
    private a fOt;
    private final HttpMessageListener fOu;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.fOp;
        dVar.fOp = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.fOo = "";
        this.aLG = true;
        this.fOp = 1;
        this.fOq = 0;
        this.fOr = 0;
        this.fOs = new ArrayList(100);
        this.fOt = null;
        this.fOu = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fOt != null) {
                        d.this.fOt.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fOt != null) {
                        d.this.fOt.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fOt != null) {
                            d.this.fOt.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.fOs.add(aVar);
                        }
                    }
                    d.this.fOr = d.this.fOs.size();
                    d.this.fOq = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fOp > 5) {
                        i = 1003;
                    }
                    if (d.this.fOr >= d.this.fOq) {
                        i = 1002;
                    }
                    if (d.this.fOt != null) {
                        d.this.fOt.a(d.this.fOq, d.this.fOs, i, d.this.fOq - d.this.fOr);
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
        this.fOo = "";
        this.aLG = true;
        this.fOp = 1;
        this.fOq = 0;
        this.fOr = 0;
        this.fOs = new ArrayList(100);
        this.fOt = null;
        this.fOu = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.fOt != null) {
                        d.this.fOt.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.fOt != null) {
                        d.this.fOt.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.fOt != null) {
                            d.this.fOt.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.fOs.add(aVar2);
                        }
                    }
                    d.this.fOr = d.this.fOs.size();
                    d.this.fOq = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.fOp > 5) {
                        i = 1003;
                    }
                    if (d.this.fOr >= d.this.fOq) {
                        i = 1002;
                    }
                    if (d.this.fOt != null) {
                        d.this.fOt.a(d.this.fOq, d.this.fOs, i, d.this.fOq - d.this.fOr);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.fOo = str3;
        this.fOt = aVar;
        this.aLG = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fOu);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bgs() {
        return this.aLG;
    }

    public void c(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aLG);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void e(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.fOo);
    }

    public void g(Bundle bundle, String str) {
        bundle.putInt(str, this.fOq);
    }

    public void bir() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.fOu);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String bis() {
        return this.fOo;
    }

    public void rh(int i) {
        this.fOq = i;
    }

    public com.baidu.tieba.pbextra.praise.a ri(int i) {
        if (i <= -1 || i >= this.fOs.size()) {
            return null;
        }
        return this.fOs.get(i);
    }

    public void rj(int i) {
        bit();
    }

    private void bit() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.fOp + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

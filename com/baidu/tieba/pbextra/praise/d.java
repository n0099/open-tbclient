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
/* loaded from: classes6.dex */
public class d {
    private boolean dsE;
    private boolean isAuthor;
    private String jaD;
    private int jaE;
    private int jaF;
    private int jaG;
    private final List<com.baidu.tieba.pbextra.praise.a> jaH;
    private a jaI;
    private final HttpMessageListener jaJ;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void br(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jaE;
        dVar.jaE = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jaD = "";
        this.dsE = true;
        this.jaE = 1;
        this.jaF = 0;
        this.jaG = 0;
        this.jaH = new ArrayList(100);
        this.jaI = null;
        this.jaJ = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jaI != null) {
                        d.this.jaI.br(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jaI != null) {
                        d.this.jaI.br(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jaI != null) {
                            d.this.jaI.br(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jaH.add(aVar);
                        }
                    }
                    d.this.jaG = d.this.jaH.size();
                    d.this.jaF = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jaE > 5) {
                        i = 1003;
                    }
                    if (d.this.jaG >= d.this.jaF) {
                        i = 1002;
                    }
                    if (d.this.jaI != null) {
                        d.this.jaI.a(d.this.jaF, d.this.jaH, i, d.this.jaF - d.this.jaG);
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
        this.jaD = "";
        this.dsE = true;
        this.jaE = 1;
        this.jaF = 0;
        this.jaG = 0;
        this.jaH = new ArrayList(100);
        this.jaI = null;
        this.jaJ = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jaI != null) {
                        d.this.jaI.br(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jaI != null) {
                        d.this.jaI.br(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jaI != null) {
                            d.this.jaI.br(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jaH.add(aVar2);
                        }
                    }
                    d.this.jaG = d.this.jaH.size();
                    d.this.jaF = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jaE > 5) {
                        i = 1003;
                    }
                    if (d.this.jaG >= d.this.jaF) {
                        i = 1002;
                    }
                    if (d.this.jaI != null) {
                        d.this.jaI.a(d.this.jaF, d.this.jaH, i, d.this.jaF - d.this.jaG);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jaD = str3;
        this.jaI = aVar;
        this.dsE = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jaJ);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean coO() {
        return this.dsE;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dsE);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jaD);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jaF);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jaJ);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String csl() {
        return this.jaD;
    }

    public void zx(int i) {
        this.jaF = i;
    }

    public com.baidu.tieba.pbextra.praise.a zy(int i) {
        if (i <= -1 || i >= this.jaH.size()) {
            return null;
        }
        return this.jaH.get(i);
    }

    public void zz(int i) {
        csm();
    }

    private void csm() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jaE + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

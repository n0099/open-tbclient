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
/* loaded from: classes22.dex */
public class d {
    private boolean fux;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;
    private String mhP;
    private int mhQ;
    private int mhR;
    private int mhS;
    private final List<com.baidu.tieba.pbextra.praise.a> mhT;
    private a mhU;
    private final HttpMessageListener mhV;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cW(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.mhQ;
        dVar.mhQ = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.mhP = "";
        this.fux = true;
        this.mhQ = 1;
        this.mhR = 0;
        this.mhS = 0;
        this.mhT = new ArrayList(100);
        this.mhU = null;
        this.mhV = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mhU != null) {
                        d.this.mhU.cW(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mhU != null) {
                        d.this.mhU.cW(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mhU != null) {
                            d.this.mhU.cW(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.mhT.add(aVar);
                        }
                    }
                    d.this.mhS = d.this.mhT.size();
                    d.this.mhR = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mhQ > 5) {
                        i = 1003;
                    }
                    if (d.this.mhS >= d.this.mhR) {
                        i = 1002;
                    }
                    if (d.this.mhU != null) {
                        d.this.mhU.a(d.this.mhR, d.this.mhT, i, d.this.mhR - d.this.mhS);
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
        this.mhP = "";
        this.fux = true;
        this.mhQ = 1;
        this.mhR = 0;
        this.mhS = 0;
        this.mhT = new ArrayList(100);
        this.mhU = null;
        this.mhV = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mhU != null) {
                        d.this.mhU.cW(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mhU != null) {
                        d.this.mhU.cW(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mhU != null) {
                            d.this.mhU.cW(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.mhT.add(aVar2);
                        }
                    }
                    d.this.mhS = d.this.mhT.size();
                    d.this.mhR = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mhQ > 5) {
                        i = 1003;
                    }
                    if (d.this.mhS >= d.this.mhR) {
                        i = 1002;
                    }
                    if (d.this.mhU != null) {
                        d.this.mhU.a(d.this.mhR, d.this.mhT, i, d.this.mhR - d.this.mhS);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.mhP = str3;
        this.mhU = aVar;
        this.fux = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.mhV);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dum() {
        return this.fux;
    }

    public void i(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fux);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void k(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.mhP);
    }

    public void m(Bundle bundle, String str) {
        bundle.putInt(str, this.mhR);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.mhV);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dxX() {
        return this.mhP;
    }

    public void Id(int i) {
        this.mhR = i;
    }

    public com.baidu.tieba.pbextra.praise.a Ie(int i) {
        if (i <= -1 || i >= this.mhT.size()) {
            return null;
        }
        return this.mhT.get(i);
    }

    public void If(int i) {
        dxY();
    }

    private void dxY() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.mhQ + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

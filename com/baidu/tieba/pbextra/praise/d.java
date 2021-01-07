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
/* loaded from: classes2.dex */
public class d {
    private boolean fEd;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;
    private String mna;
    private int mnb;
    private int mnc;
    private int mnd;
    private final List<com.baidu.tieba.pbextra.praise.a> mne;
    private a mnf;
    private final HttpMessageListener mng;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cP(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.mnb;
        dVar.mnb = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.mna = "";
        this.fEd = true;
        this.mnb = 1;
        this.mnc = 0;
        this.mnd = 0;
        this.mne = new ArrayList(100);
        this.mnf = null;
        this.mng = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mnf != null) {
                        d.this.mnf.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mnf != null) {
                        d.this.mnf.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mnf != null) {
                            d.this.mnf.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.mne.add(aVar);
                        }
                    }
                    d.this.mnd = d.this.mne.size();
                    d.this.mnc = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mnb > 5) {
                        i = 1003;
                    }
                    if (d.this.mnd >= d.this.mnc) {
                        i = 1002;
                    }
                    if (d.this.mnf != null) {
                        d.this.mnf.a(d.this.mnc, d.this.mne, i, d.this.mnc - d.this.mnd);
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
        this.mna = "";
        this.fEd = true;
        this.mnb = 1;
        this.mnc = 0;
        this.mnd = 0;
        this.mne = new ArrayList(100);
        this.mnf = null;
        this.mng = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mnf != null) {
                        d.this.mnf.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mnf != null) {
                        d.this.mnf.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mnf != null) {
                            d.this.mnf.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.mne.add(aVar2);
                        }
                    }
                    d.this.mnd = d.this.mne.size();
                    d.this.mnc = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mnb > 5) {
                        i = 1003;
                    }
                    if (d.this.mnd >= d.this.mnc) {
                        i = 1002;
                    }
                    if (d.this.mnf != null) {
                        d.this.mnf.a(d.this.mnc, d.this.mne, i, d.this.mnc - d.this.mnd);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.mna = str3;
        this.mnf = aVar;
        this.fEd = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.mng);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean dud() {
        return this.fEd;
    }

    public void k(Bundle bundle, String str) {
        bundle.putBoolean(str, this.fEd);
    }

    public void l(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void m(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void n(Bundle bundle, String str) {
        bundle.putString(str, this.mna);
    }

    public void o(Bundle bundle, String str) {
        bundle.putInt(str, this.mnc);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.mng);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dxO() {
        return this.mna;
    }

    public void HW(int i) {
        this.mnc = i;
    }

    public com.baidu.tieba.pbextra.praise.a HX(int i) {
        if (i <= -1 || i >= this.mne.size()) {
            return null;
        }
        return this.mne.get(i);
    }

    public void HY(int i) {
        dxP();
    }

    private void dxP() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.mnb + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

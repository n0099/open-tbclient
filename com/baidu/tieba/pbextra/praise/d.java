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
    private String mnb;
    private int mnc;
    private int mnd;
    private int mne;
    private final List<com.baidu.tieba.pbextra.praise.a> mnf;
    private a mng;
    private final HttpMessageListener mnh;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void cP(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.mnc;
        dVar.mnc = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.mnb = "";
        this.fEd = true;
        this.mnc = 1;
        this.mnd = 0;
        this.mne = 0;
        this.mnf = new ArrayList(100);
        this.mng = null;
        this.mnh = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mng != null) {
                        d.this.mng.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mng != null) {
                        d.this.mng.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mng != null) {
                            d.this.mng.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.mnf.add(aVar);
                        }
                    }
                    d.this.mne = d.this.mnf.size();
                    d.this.mnd = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mnc > 5) {
                        i = 1003;
                    }
                    if (d.this.mne >= d.this.mnd) {
                        i = 1002;
                    }
                    if (d.this.mng != null) {
                        d.this.mng.a(d.this.mnd, d.this.mnf, i, d.this.mnd - d.this.mne);
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
        this.mnb = "";
        this.fEd = true;
        this.mnc = 1;
        this.mnd = 0;
        this.mne = 0;
        this.mnf = new ArrayList(100);
        this.mng = null;
        this.mnh = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.mng != null) {
                        d.this.mng.cP(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.mng != null) {
                        d.this.mng.cP(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.mng != null) {
                            d.this.mng.cP(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.mnf.add(aVar2);
                        }
                    }
                    d.this.mne = d.this.mnf.size();
                    d.this.mnd = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.mnc > 5) {
                        i = 1003;
                    }
                    if (d.this.mne >= d.this.mnd) {
                        i = 1002;
                    }
                    if (d.this.mng != null) {
                        d.this.mng.a(d.this.mnd, d.this.mnf, i, d.this.mnd - d.this.mne);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.mnb = str3;
        this.mng = aVar;
        this.fEd = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.mnh);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean duc() {
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
        bundle.putString(str, this.mnb);
    }

    public void o(Bundle bundle, String str) {
        bundle.putInt(str, this.mnd);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.mnh);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String dxN() {
        return this.mnb;
    }

    public void HW(int i) {
        this.mnd = i;
    }

    public com.baidu.tieba.pbextra.praise.a HX(int i) {
        if (i <= -1 || i >= this.mnf.size()) {
            return null;
        }
        return this.mnf.get(i);
    }

    public void HY(int i) {
        dxO();
    }

    private void dxO() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.mnc + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

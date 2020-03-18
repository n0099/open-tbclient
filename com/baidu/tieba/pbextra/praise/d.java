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
    private boolean dxw;
    private boolean isAuthor;
    private String jgU;
    private int jgV;
    private int jgW;
    private int jgX;
    private final List<com.baidu.tieba.pbextra.praise.a> jgY;
    private a jgZ;
    private final HttpMessageListener jha;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void bt(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.jgV;
        dVar.jgV = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.jgU = "";
        this.dxw = true;
        this.jgV = 1;
        this.jgW = 0;
        this.jgX = 0;
        this.jgY = new ArrayList(100);
        this.jgZ = null;
        this.jha = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jgZ != null) {
                        d.this.jgZ.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jgZ != null) {
                        d.this.jgZ.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jgZ != null) {
                            d.this.jgZ.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.jgY.add(aVar);
                        }
                    }
                    d.this.jgX = d.this.jgY.size();
                    d.this.jgW = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jgV > 5) {
                        i = 1003;
                    }
                    if (d.this.jgX >= d.this.jgW) {
                        i = 1002;
                    }
                    if (d.this.jgZ != null) {
                        d.this.jgZ.a(d.this.jgW, d.this.jgY, i, d.this.jgW - d.this.jgX);
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
        this.jgU = "";
        this.dxw = true;
        this.jgV = 1;
        this.jgW = 0;
        this.jgX = 0;
        this.jgY = new ArrayList(100);
        this.jgZ = null;
        this.jha = new HttpMessageListener(1001400) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.jgZ != null) {
                        d.this.jgZ.bt(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.jgZ != null) {
                        d.this.jgZ.bt(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.jgZ != null) {
                            d.this.jgZ.bt(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.jgY.add(aVar2);
                        }
                    }
                    d.this.jgX = d.this.jgY.size();
                    d.this.jgW = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.jgV > 5) {
                        i = 1003;
                    }
                    if (d.this.jgX >= d.this.jgW) {
                        i = 1002;
                    }
                    if (d.this.jgZ != null) {
                        d.this.jgZ.a(d.this.jgW, d.this.jgY, i, d.this.jgW - d.this.jgX);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.jgU = str3;
        this.jgZ = aVar;
        this.dxw = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001400, TbConfig.SERVER_ADDRESS + Config.ZAN_LIST_URL);
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jha);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean crL() {
        return this.dxw;
    }

    public void g(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dxw);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void i(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void j(Bundle bundle, String str) {
        bundle.putString(str, this.jgU);
    }

    public void k(Bundle bundle, String str) {
        bundle.putInt(str, this.jgW);
    }

    public void unRegister() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.jha);
        messageManager.unRegisterTask(1003082);
        messageManager.unRegisterTask(CmdConfigSocket.CMD_GRAFFITI_LIST);
    }

    public String cvj() {
        return this.jgU;
    }

    public void zR(int i) {
        this.jgW = i;
    }

    public com.baidu.tieba.pbextra.praise.a zS(int i) {
        if (i <= -1 || i >= this.jgY.size()) {
            return null;
        }
        return this.jgY.get(i);
    }

    public void zT(int i) {
        cvk();
    }

    private void cvk() {
        HttpMessage httpMessage = new HttpMessage(1001400);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.jgV + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

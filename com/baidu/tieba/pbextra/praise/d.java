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
    private boolean aYI;
    private String gsq;
    private int gsr;
    private int gss;
    private int gst;
    private final List<com.baidu.tieba.pbextra.praise.a> gsu;
    private a gsv;
    private final HttpMessageListener gsw;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pbextra.praise.a> list, int i2, int i3);

        void onLoadFailed(String str);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.gsr;
        dVar.gsr = i + 1;
        return i;
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.gsq = "";
        this.aYI = true;
        this.gsr = 1;
        this.gss = 0;
        this.gst = 0;
        this.gsu = new ArrayList(100);
        this.gsv = null;
        this.gsw = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.gsv != null) {
                        d.this.gsv.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.gsv != null) {
                        d.this.gsv.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.gsv != null) {
                            d.this.gsv.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar : list) {
                            d.this.gsu.add(aVar);
                        }
                    }
                    d.this.gst = d.this.gsu.size();
                    d.this.gss = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.gsr > 5) {
                        i = 1003;
                    }
                    if (d.this.gst >= d.this.gss) {
                        i = 1002;
                    }
                    if (d.this.gsv != null) {
                        d.this.gsv.a(d.this.gss, d.this.gsu, i, d.this.gss - d.this.gst);
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
        this.gsq = "";
        this.aYI = true;
        this.gsr = 1;
        this.gss = 0;
        this.gst = 0;
        this.gsu = new ArrayList(100);
        this.gsv = null;
        this.gsw = new HttpMessageListener(CmdConfigHttp.PRAISE_LIST_HTTP_CMD) { // from class: com.baidu.tieba.pbextra.praise.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                    if (d.this.gsv != null) {
                        d.this.gsv.onLoadFailed(null);
                    }
                } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                    if (d.this.gsv != null) {
                        d.this.gsv.onLoadFailed(null);
                    }
                } else {
                    PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                    if (praiseListResponsedMessage.getError() != 0) {
                        if (d.this.gsv != null) {
                            d.this.gsv.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                            return;
                        }
                        return;
                    }
                    List<com.baidu.tieba.pbextra.praise.a> list = praiseListResponsedMessage.getmZanItemDataList();
                    if (list != null) {
                        for (com.baidu.tieba.pbextra.praise.a aVar2 : list) {
                            d.this.gsu.add(aVar2);
                        }
                    }
                    d.this.gst = d.this.gsu.size();
                    d.this.gss = praiseListResponsedMessage.getTotalNum();
                    d.c(d.this);
                    int i = 1001;
                    if (d.this.gsr > 5) {
                        i = 1003;
                    }
                    if (d.this.gst >= d.this.gss) {
                        i = 1002;
                    }
                    if (d.this.gsv != null) {
                        d.this.gsv.a(d.this.gss, d.this.gsu, i, d.this.gss - d.this.gst);
                    }
                }
            }
        };
        this.mThreadId = str;
        this.mPostId = str2;
        this.gsq = str3;
        this.gsv = aVar;
        this.aYI = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gsw);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean bne() {
        return this.aYI;
    }

    public void e(Bundle bundle, String str) {
        bundle.putBoolean(str, this.aYI);
    }

    public void f(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void g(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void h(Bundle bundle, String str) {
        bundle.putString(str, this.gsq);
    }

    public void i(Bundle bundle, String str) {
        bundle.putInt(str, this.gss);
    }

    public void boW() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.gsw);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String boX() {
        return this.gsq;
    }

    public void th(int i) {
        this.gss = i;
    }

    public com.baidu.tieba.pbextra.praise.a ti(int i) {
        if (i <= -1 || i >= this.gsu.size()) {
            return null;
        }
        return this.gsu.get(i);
    }

    public void tj(int i) {
        boY();
    }

    private void boY() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.mPostId + "");
        httpMessage.addParam("page_num", this.gsr + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private String cKE;
    private boolean cKF;
    private int cKG;
    private int cKH;
    private int cKI;
    private final List<com.baidu.tieba.pb.pb.praise.a> cKJ;
    private a cKK;
    private final HttpMessageListener cKL;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pb.pb.praise.a> list, int i2, int i3);

        void bN(String str);
    }

    public d() {
        this.mThreadId = "";
        this.mPostId = "";
        this.cKE = "";
        this.cKF = true;
        this.cKG = 1;
        this.cKH = 0;
        this.cKI = 0;
        this.cKJ = new ArrayList(100);
        this.cKK = null;
        this.cKL = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.cKE = "";
        this.cKF = true;
        this.cKG = 1;
        this.cKH = 0;
        this.cKI = 0;
        this.cKJ = new ArrayList(100);
        this.cKK = null;
        this.cKL = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.cKE = str3;
        this.cKK = aVar;
        this.cKF = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cKL);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean ans() {
        return this.cKF;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cKF);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.cKE);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.cKH);
    }

    public void ant() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cKL);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String anu() {
        return this.cKE;
    }

    public void kA(int i) {
        this.cKH = i;
    }

    public com.baidu.tieba.pb.pb.praise.a kB(int i) {
        if (i <= -1 || i >= this.cKJ.size()) {
            return null;
        }
        return this.cKJ.get(i);
    }

    public void Hm() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.cKG)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

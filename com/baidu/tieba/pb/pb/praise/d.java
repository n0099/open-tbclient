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
    private String cGF;
    private boolean cGG;
    private int cGH;
    private int cGI;
    private int cGJ;
    private final List<com.baidu.tieba.pb.pb.praise.a> cGK;
    private a cGL;
    private final HttpMessageListener cGM;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pb.pb.praise.a> list, int i2, int i3);

        void bK(String str);
    }

    public d() {
        this.mThreadId = "";
        this.mPostId = "";
        this.cGF = "";
        this.cGG = true;
        this.cGH = 1;
        this.cGI = 0;
        this.cGJ = 0;
        this.cGK = new ArrayList(100);
        this.cGL = null;
        this.cGM = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.cGF = "";
        this.cGG = true;
        this.cGH = 1;
        this.cGI = 0;
        this.cGJ = 0;
        this.cGK = new ArrayList(100);
        this.cGL = null;
        this.cGM = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.cGF = str3;
        this.cGL = aVar;
        this.cGG = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cGM);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean amg() {
        return this.cGG;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cGG);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.cGF);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.cGI);
    }

    public void amh() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cGM);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String ami() {
        return this.cGF;
    }

    public void kd(int i) {
        this.cGI = i;
    }

    public com.baidu.tieba.pb.pb.praise.a ke(int i) {
        if (i <= -1 || i >= this.cGK.size()) {
            return null;
        }
        return this.cGK.get(i);
    }

    public void Hx() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.cGH)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

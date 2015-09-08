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
    private boolean cgA;
    private int cgB;
    private int cgC;
    private int cgD;
    private final List<com.baidu.tieba.pb.pb.praise.a> cgE;
    private a cgF;
    private final HttpMessageListener cgG;
    private String cgz;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pb.pb.praise.a> list, int i2, int i3);

        void bF(String str);
    }

    public d() {
        this.mThreadId = "";
        this.mPostId = "";
        this.cgz = "";
        this.cgA = true;
        this.cgB = 1;
        this.cgC = 0;
        this.cgD = 0;
        this.cgE = new ArrayList(100);
        this.cgF = null;
        this.cgG = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.cgz = "";
        this.cgA = true;
        this.cgB = 1;
        this.cgC = 0;
        this.cgD = 0;
        this.cgE = new ArrayList(100);
        this.cgF = null;
        this.cgG = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.cgz = str3;
        this.cgF = aVar;
        this.cgA = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cgG);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean afc() {
        return this.cgA;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cgA);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.cgz);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.cgC);
    }

    public void afd() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cgG);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String afe() {
        return this.cgz;
    }

    public void iK(int i) {
        this.cgC = i;
    }

    public com.baidu.tieba.pb.pb.praise.a iL(int i) {
        if (i <= -1 || i >= this.cgE.size()) {
            return null;
        }
        return this.cgE.get(i);
    }

    public void GD() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.cgB)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

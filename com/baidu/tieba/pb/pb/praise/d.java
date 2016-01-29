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
    private String cTc;
    private boolean cTd;
    private int cTe;
    private int cTf;
    private int cTg;
    private final List<com.baidu.tieba.pb.pb.praise.a> cTh;
    private a cTi;
    private final HttpMessageListener cTj;
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
        this.cTc = "";
        this.cTd = true;
        this.cTe = 1;
        this.cTf = 0;
        this.cTg = 0;
        this.cTh = new ArrayList(100);
        this.cTi = null;
        this.cTj = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.cTc = "";
        this.cTd = true;
        this.cTe = 1;
        this.cTf = 0;
        this.cTg = 0;
        this.cTh = new ArrayList(100);
        this.cTi = null;
        this.cTj = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.cTc = str3;
        this.cTi = aVar;
        this.cTd = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cTj);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean arS() {
        return this.cTd;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cTd);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.cTc);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.cTf);
    }

    public void arT() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cTj);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String arU() {
        return this.cTc;
    }

    public void le(int i) {
        this.cTf = i;
    }

    public com.baidu.tieba.pb.pb.praise.a lf(int i) {
        if (i <= -1 || i >= this.cTh.size()) {
            return null;
        }
        return this.cTh.get(i);
    }

    public void IO() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.cTe)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

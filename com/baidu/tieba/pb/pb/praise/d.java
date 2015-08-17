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
    private String cfC;
    private boolean cfD;
    private int cfE;
    private int cfF;
    private int cfG;
    private final List<com.baidu.tieba.pb.pb.praise.a> cfH;
    private a cfI;
    private final HttpMessageListener cfJ;
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
        this.cfC = "";
        this.cfD = true;
        this.cfE = 1;
        this.cfF = 0;
        this.cfG = 0;
        this.cfH = new ArrayList(100);
        this.cfI = null;
        this.cfJ = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.cfC = "";
        this.cfD = true;
        this.cfE = 1;
        this.cfF = 0;
        this.cfG = 0;
        this.cfH = new ArrayList(100);
        this.cfI = null;
        this.cfJ = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.cfC = str3;
        this.cfI = aVar;
        this.cfD = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cfJ);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean aeO() {
        return this.cfD;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cfD);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.cfC);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.cfF);
    }

    public void aeP() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cfJ);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String aeQ() {
        return this.cfC;
    }

    public void iy(int i) {
        this.cfF = i;
    }

    public com.baidu.tieba.pb.pb.praise.a iz(int i) {
        if (i <= -1 || i >= this.cfH.size()) {
            return null;
        }
        return this.cfH.get(i);
    }

    public void GP() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.cfE)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

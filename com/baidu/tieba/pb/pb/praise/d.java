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
    private String clU;
    private boolean clV;
    private int clW;
    private int clX;
    private int clY;
    private final List<com.baidu.tieba.pb.pb.praise.a> clZ;
    private a cma;
    private final HttpMessageListener cmb;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pb.pb.praise.a> list, int i2, int i3);

        void bG(String str);
    }

    public d() {
        this.mThreadId = "";
        this.mPostId = "";
        this.clU = "";
        this.clV = true;
        this.clW = 1;
        this.clX = 0;
        this.clY = 0;
        this.clZ = new ArrayList(100);
        this.cma = null;
        this.cmb = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.clU = "";
        this.clV = true;
        this.clW = 1;
        this.clX = 0;
        this.clY = 0;
        this.clZ = new ArrayList(100);
        this.cma = null;
        this.cmb = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.clU = str3;
        this.cma = aVar;
        this.clV = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cmb);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean ahb() {
        return this.clV;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.clV);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.clU);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.clX);
    }

    public void ahc() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cmb);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String ahd() {
        return this.clU;
    }

    public void iU(int i) {
        this.clX = i;
    }

    public com.baidu.tieba.pb.pb.praise.a iV(int i) {
        if (i <= -1 || i >= this.clZ.size()) {
            return null;
        }
        return this.clZ.get(i);
    }

    public void Gx() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.clW)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

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
    private String cmg;
    private boolean cmh;
    private int cmi;
    private int cmj;
    private int cmk;
    private final List<com.baidu.tieba.pb.pb.praise.a> cml;
    private a cmm;
    private final HttpMessageListener cmn;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pb.pb.praise.a> list, int i2, int i3);

        void bH(String str);
    }

    public d() {
        this.mThreadId = "";
        this.mPostId = "";
        this.cmg = "";
        this.cmh = true;
        this.cmi = 1;
        this.cmj = 0;
        this.cmk = 0;
        this.cml = new ArrayList(100);
        this.cmm = null;
        this.cmn = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.cmg = "";
        this.cmh = true;
        this.cmi = 1;
        this.cmj = 0;
        this.cmk = 0;
        this.cml = new ArrayList(100);
        this.cmm = null;
        this.cmn = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.cmg = str3;
        this.cmm = aVar;
        this.cmh = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cmn);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean ahb() {
        return this.cmh;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cmh);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.cmg);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.cmj);
    }

    public void ahc() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cmn);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String ahd() {
        return this.cmg;
    }

    public void iU(int i) {
        this.cmj = i;
    }

    public com.baidu.tieba.pb.pb.praise.a iV(int i) {
        if (i <= -1 || i >= this.cml.size()) {
            return null;
        }
        return this.cml.get(i);
    }

    public void Gx() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.cmi)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

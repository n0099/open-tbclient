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
    private a cnA;
    private final HttpMessageListener cnB;
    private String cnu;
    private boolean cnv;
    private int cnw;
    private int cnx;
    private int cny;
    private final List<com.baidu.tieba.pb.pb.praise.a> cnz;
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
        this.cnu = "";
        this.cnv = true;
        this.cnw = 1;
        this.cnx = 0;
        this.cny = 0;
        this.cnz = new ArrayList(100);
        this.cnA = null;
        this.cnB = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.mThreadId = "";
        this.mPostId = "";
        this.cnu = "";
        this.cnv = true;
        this.cnw = 1;
        this.cnx = 0;
        this.cny = 0;
        this.cnz = new ArrayList(100);
        this.cnA = null;
        this.cnB = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.mThreadId = str;
        this.mPostId = str2;
        this.cnu = str3;
        this.cnA = aVar;
        this.cnv = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.cnB);
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean ahD() {
        return this.cnv;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.cnv);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.cnu);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.cnx);
    }

    public void ahE() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.cnB);
        messageManager.unRegisterTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
    }

    public String ahF() {
        return this.cnu;
    }

    public void jj(int i) {
        this.cnx = i;
    }

    public com.baidu.tieba.pb.pb.praise.a jk(int i) {
        if (i <= -1 || i >= this.cnz.size()) {
            return null;
        }
        return this.cnz.get(i);
    }

    public void Gq() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.cnw)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.praise.grffitiList.GraffitiListRequestData;
import com.baidu.tieba.pb.pb.praise.grffitiList.ResponseHttpGraffitiMessage;
import com.baidu.tieba.pb.pb.praise.grffitiList.ResponseSocketGraffitiMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private com.baidu.adp.framework.listener.a bOQ;
    private String dnW;
    private boolean dnX;
    private int dnY;
    private int dnZ;
    private int doa;
    private final List<com.baidu.tieba.pb.pb.praise.a> dob;
    private a dod;
    private final HttpMessageListener doe;
    private boolean isAuthor;
    private String mPostId;
    private String mThreadId;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<com.baidu.tieba.pb.pb.praise.a> list, int i2, int i3);

        void bL(String str);
    }

    public d() {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.dnW = "";
        this.dnX = true;
        this.dnY = 1;
        this.dnZ = 0;
        this.doa = 0;
        this.dob = new ArrayList(100);
        this.dod = null;
        this.doe = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.bOQ = new f(this, CmdConfigHttp.CMD_GRAFFITI_LIST, 309326);
        this.mThreadId = "";
        this.mPostId = "";
    }

    public d(String str, String str2, String str3, boolean z, a aVar) {
        this.isAuthor = false;
        this.mThreadId = "";
        this.mPostId = "";
        this.dnW = "";
        this.dnX = true;
        this.dnY = 1;
        this.dnZ = 0;
        this.doa = 0;
        this.dob = new ArrayList(100);
        this.dod = null;
        this.doe = new e(this, CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.bOQ = new f(this, CmdConfigHttp.CMD_GRAFFITI_LIST, 309326);
        this.mThreadId = str;
        this.mPostId = str2;
        this.dnW = str3;
        this.dod = aVar;
        this.dnX = z;
        com.baidu.tieba.tbadkCore.a.a.a(309326, ResponseSocketGraffitiMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309326, CmdConfigHttp.CMD_GRAFFITI_LIST, TbConfig.URL_GET_CONSENTLIST, ResponseHttpGraffitiMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.bOQ);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.doe);
    }

    public void setIsAuthor(boolean z) {
        this.isAuthor = z;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public boolean azB() {
        return this.dnX;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.dnX);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.mThreadId);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.mPostId);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.dnW);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.dnZ);
    }

    public void azC() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.bOQ);
        messageManager.unRegisterListener(this.doe);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public String azD() {
        return this.dnW;
    }

    public void mm(int i) {
        this.dnZ = i;
    }

    public com.baidu.tieba.pb.pb.praise.a mn(int i) {
        if (i <= -1 || i >= this.dob.size()) {
            return null;
        }
        return this.dob.get(i);
    }

    public void mo(int i) {
        switch (i) {
            case 1:
                azE();
                return;
            default:
                azF();
                return;
        }
    }

    private void azE() {
        MessageManager.getInstance().sendMessage(new GraffitiListRequestData(this.mThreadId, this.mPostId, this.dnY, this.isAuthor));
    }

    private void azF() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", new StringBuilder(String.valueOf(this.mPostId)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.dnY)).toString());
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

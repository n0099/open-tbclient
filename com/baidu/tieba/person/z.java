package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.e {
    private static final String aEy = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like";
    private static TbHttpMessageTask aEz = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, aEy);
    private n mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        aEz.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(aEz);
    }

    public z(Context context, boolean z) {
        super(context);
        this.mData = new n();
        this.mIsHost = z;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public n ZS() {
        return this.mData;
    }

    public void ZQ() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void f(boolean z, String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        if (!z) {
            httpMessage.addParam(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        super.sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}

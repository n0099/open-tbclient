package com.baidu.tieba.person;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.base.e {
    private static final String aEo = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/listFriend";
    private static TbHttpMessageTask aEp = new TbHttpMessageTask(1002000, aEo);
    private com.baidu.tieba.data.aj mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        aEp.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aEp);
    }

    public bd(Context context, boolean z) {
        super(context);
        this.mData = new com.baidu.tieba.data.aj();
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

    public void setData(com.baidu.tieba.data.aj ajVar) {
        this.mData = ajVar;
    }

    public com.baidu.tieba.data.aj getData() {
        return this.mData;
    }

    public void ZO() {
        super.sendMessage(new PersonFriendByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1002000);
        if (!z) {
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(i)).toString());
        httpMessage.addParam("res_num", new StringBuilder(String.valueOf(i2)).toString());
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

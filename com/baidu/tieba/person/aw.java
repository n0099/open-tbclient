package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.f {
    private static final String bkk = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/listFriend";
    private static TbHttpMessageTask bkl = new TbHttpMessageTask(1002000, bkk);
    private com.baidu.tbadk.core.data.q mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        bkl.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(bkl);
    }

    public aw(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new com.baidu.tbadk.core.data.q();
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

    public void setData(com.baidu.tbadk.core.data.q qVar) {
        this.mData = qVar;
    }

    public com.baidu.tbadk.core.data.q getData() {
        return this.mData;
    }

    public void CK() {
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

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}

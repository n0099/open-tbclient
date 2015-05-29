package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.base.f {
    private com.baidu.tieba.person.a.a mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;
    private static final String aAz = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/listFriend";
    private static TbHttpMessageTask aAA = new TbHttpMessageTask(CmdConfigHttp.PIC_FRIEND_CMD, aAz);

    static {
        aAA.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aAA);
    }

    public bm(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new com.baidu.tieba.person.a.a();
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

    public void setData(com.baidu.tieba.person.a.a aVar) {
        this.mData = aVar;
    }

    public com.baidu.tieba.person.a.a getData() {
        return this.mData;
    }

    public void Hh() {
        super.sendMessage(new PersonFriendByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_FRIEND_CMD);
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

package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.base.e {
    private static final String aKM = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/listFriend";
    private static TbHttpMessageTask aKN = new TbHttpMessageTask(CmdConfigHttp.PIC_FRIEND_CMD, aKM);
    private boolean bIW;
    private com.baidu.tbadk.core.data.af mData;
    private String mId;
    private int mSex;

    static {
        aKN.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aKN);
    }

    public bh(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new com.baidu.tbadk.core.data.af();
        this.bIW = z;
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

    public void setData(com.baidu.tbadk.core.data.af afVar) {
        this.mData = afVar;
    }

    public com.baidu.tbadk.core.data.af getData() {
        return this.mData;
    }

    public void asa() {
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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}

package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.base.e {
    private static final String aLH = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/r/friend/listFriend";
    private static TbHttpMessageTask aLI = new TbHttpMessageTask(CmdConfigHttp.PIC_FRIEND_CMD, aLH);
    private boolean bDs;
    private com.baidu.tieba.person.data.r mData;
    private String mId;
    private int mSex;

    static {
        aLI.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(aLI);
    }

    public bg(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new com.baidu.tieba.person.data.r();
        this.bDs = z;
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

    public void setData(com.baidu.tieba.person.data.r rVar) {
        this.mData = rVar;
    }

    public com.baidu.tieba.person.data.r getData() {
        return this.mData;
    }

    public void atB() {
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

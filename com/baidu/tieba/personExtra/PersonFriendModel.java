package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes6.dex */
public class PersonFriendModel extends BdBaseModel {
    private static final String djO = TbConfig.SERVER_ADDRESS + Config.GET_FRIEND_LIST_ADDRESS;
    private static TbHttpMessageTask task = new TbHttpMessageTask(1002001, djO);
    private ar mData;
    private String mId;
    private boolean mIsHost;
    private int mSex;

    static {
        task.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public PersonFriendModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.mData = new ar();
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

    public void d(ar arVar) {
        this.mData = arVar;
    }

    public ar caA() {
        return this.mData;
    }

    public void caa() {
        super.sendMessage(new PersonFriendByUidLocalMessage());
    }

    public void a(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1002001);
        if (!z) {
            httpMessage.addParam("friend_uid", str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_num", i + "");
        httpMessage.addParam("res_num", i2 + "");
        super.sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}

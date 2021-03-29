package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.b.h0.r.q.f1;
/* loaded from: classes5.dex */
public class PersonFriendModel extends BdBaseModel {

    /* renamed from: g  reason: collision with root package name */
    public static final String f20372g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f20373h;

    /* renamed from: e  reason: collision with root package name */
    public f1 f20374e;

    /* renamed from: f  reason: collision with root package name */
    public String f20375f;

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/r/friend/listFriend";
        f20372g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_FRIEND_CMD, str);
        f20373h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(f20373h);
    }

    public PersonFriendModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.f20374e = new f1();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String getId() {
        return this.f20375f;
    }

    public f1 s() {
        return this.f20374e;
    }

    public void setSex(int i) {
    }

    public void t() {
        super.sendMessage(new PersonFriendByUidLocalMessage());
    }

    public void u(boolean z, String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_FRIEND_CMD);
        if (!z) {
            httpMessage.addParam(TiebaStatic.Params.FRIEND_UID, str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam(SuggestAddrField.KEY_PAGE_NUM, i + "");
        httpMessage.addParam("res_num", i2 + "");
        super.sendMessage(httpMessage);
    }

    public void v(f1 f1Var) {
        this.f20374e = f1Var;
    }

    public void w(String str) {
        this.f20375f = str;
    }
}

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
import d.a.i0.r.q.f1;
/* loaded from: classes4.dex */
public class PersonFriendModel extends BdBaseModel {

    /* renamed from: g  reason: collision with root package name */
    public static final String f20583g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f20584h;

    /* renamed from: e  reason: collision with root package name */
    public f1 f20585e;

    /* renamed from: f  reason: collision with root package name */
    public String f20586f;

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/r/friend/listFriend";
        f20583g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_FRIEND_CMD, str);
        f20584h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(f20584h);
    }

    public PersonFriendModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.f20585e = new f1();
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
        return this.f20586f;
    }

    public f1 s() {
        return this.f20585e;
    }

    public void setSex(int i2) {
    }

    public void t() {
        super.sendMessage(new PersonFriendByUidLocalMessage());
    }

    public void u(boolean z, String str, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_FRIEND_CMD);
        if (!z) {
            httpMessage.addParam(TiebaStatic.Params.FRIEND_UID, str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam(SuggestAddrField.KEY_PAGE_NUM, i2 + "");
        httpMessage.addParam("res_num", i3 + "");
        super.sendMessage(httpMessage);
    }

    public void v(f1 f1Var) {
        this.f20585e = f1Var;
    }

    public void w(String str) {
        this.f20586f = str;
    }
}

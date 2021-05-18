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
import d.a.j0.r.q.f1;
/* loaded from: classes5.dex */
public class PersonFriendModel extends BdBaseModel {

    /* renamed from: g  reason: collision with root package name */
    public static final String f19871g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f19872h;

    /* renamed from: e  reason: collision with root package name */
    public f1 f19873e;

    /* renamed from: f  reason: collision with root package name */
    public String f19874f;

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/r/friend/listFriend";
        f19871g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_FRIEND_CMD, str);
        f19872h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(f19872h);
    }

    public PersonFriendModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.f19873e = new f1();
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
        return this.f19874f;
    }

    public f1 s() {
        return this.f19873e;
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
        this.f19873e = f1Var;
    }

    public void w(String str) {
        this.f19874f = str;
    }
}

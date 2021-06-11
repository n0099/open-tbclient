package com.baidu.tieba.personExtra;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.c.e.d.l;
import d.a.m0.r.r.a;
import d.a.n0.i2.b;
/* loaded from: classes5.dex */
public class PersonBarModel extends BdBaseModel {

    /* renamed from: i  reason: collision with root package name */
    public static final String f19821i;
    public static TbHttpMessageTask j;

    /* renamed from: e  reason: collision with root package name */
    public b f19822e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19823f;

    /* renamed from: g  reason: collision with root package name */
    public String f19824g;

    /* renamed from: h  reason: collision with root package name */
    public int f19825h;

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/f/forum/like";
        f19821i = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, str);
        j = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(j);
    }

    public PersonBarModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.f19822e = new b();
        this.f19823f = z;
    }

    public void A(String str) {
        if (this.f19825h == 1 && this.f19823f) {
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (str != null) {
                try {
                    l<String> g2 = a.f().g("tb.my_pages");
                    if (g2 != null) {
                        g2.e(id, str, 604800000L);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void B(int i2) {
        this.f19825h = i2;
    }

    public void C(String str) {
        this.f19824g = str;
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
        return this.f19824g;
    }

    public void setSex(int i2) {
    }

    public b w() {
        return this.f19822e;
    }

    public boolean x() {
        return this.f19823f;
    }

    public void y() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void z(boolean z, String str, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!x()) {
            httpMessage.addParam(TiebaStatic.Params.FRIEND_UID, str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_size", i3);
        httpMessage.addParam("page_no", i2);
        super.sendMessage(httpMessage);
    }
}

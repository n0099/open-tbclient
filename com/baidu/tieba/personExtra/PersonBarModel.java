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
import d.a.j0.r.r.a;
import d.a.k0.h2.b;
/* loaded from: classes5.dex */
public class PersonBarModel extends BdBaseModel {

    /* renamed from: i  reason: collision with root package name */
    public static final String f19822i;
    public static TbHttpMessageTask j;

    /* renamed from: e  reason: collision with root package name */
    public b f19823e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19824f;

    /* renamed from: g  reason: collision with root package name */
    public String f19825g;

    /* renamed from: h  reason: collision with root package name */
    public int f19826h;

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/f/forum/like";
        f19822i = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, str);
        j = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(j);
    }

    public PersonBarModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.f19823e = new b();
        this.f19824f = z;
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
        return this.f19825g;
    }

    public b s() {
        return this.f19823e;
    }

    public void setSex(int i2) {
    }

    public boolean t() {
        return this.f19824f;
    }

    public void u() {
        super.sendMessage(new PersonBarByUidLocalMessage());
    }

    public void v(boolean z, String str, int i2, int i3) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_LIKE_BAR_CMD);
        httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
        if (!t()) {
            httpMessage.addParam(TiebaStatic.Params.FRIEND_UID, str);
            httpMessage.addParam("is_guest", String.valueOf(1));
            httpMessage.setExtra(str);
        }
        httpMessage.addParam("page_size", i3);
        httpMessage.addParam("page_no", i2);
        super.sendMessage(httpMessage);
    }

    public void w(String str) {
        if (this.f19826h == 1 && this.f19824f) {
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

    public void x(int i2) {
        this.f19826h = i2;
    }

    public void y(String str) {
        this.f19825g = str;
    }
}

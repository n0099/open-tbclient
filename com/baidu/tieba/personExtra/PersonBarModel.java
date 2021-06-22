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
import d.a.n0.r.r.a;
import d.a.o0.i2.b;
/* loaded from: classes5.dex */
public class PersonBarModel extends BdBaseModel {

    /* renamed from: i  reason: collision with root package name */
    public static final String f19903i;
    public static TbHttpMessageTask j;

    /* renamed from: e  reason: collision with root package name */
    public b f19904e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19905f;

    /* renamed from: g  reason: collision with root package name */
    public String f19906g;

    /* renamed from: h  reason: collision with root package name */
    public int f19907h;

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/f/forum/like";
        f19903i = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, str);
        j = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(j);
    }

    public PersonBarModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.f19904e = new b();
        this.f19905f = z;
    }

    public void A(String str) {
        if (this.f19907h == 1 && this.f19905f) {
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
        this.f19907h = i2;
    }

    public void C(String str) {
        this.f19906g = str;
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
        return this.f19906g;
    }

    public void setSex(int i2) {
    }

    public b w() {
        return this.f19904e;
    }

    public boolean x() {
        return this.f19905f;
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

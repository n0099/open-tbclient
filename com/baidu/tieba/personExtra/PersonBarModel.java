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
import d.b.b.e.d.l;
import d.b.h0.r.r.a;
import d.b.i0.g2.b;
/* loaded from: classes5.dex */
public class PersonBarModel extends BdBaseModel {
    public static final String i;
    public static TbHttpMessageTask j;

    /* renamed from: e  reason: collision with root package name */
    public b f20324e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20325f;

    /* renamed from: g  reason: collision with root package name */
    public String f20326g;

    /* renamed from: h  reason: collision with root package name */
    public int f20327h;

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/f/forum/like";
        i = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_LIKE_BAR_CMD, str);
        j = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PersonBarResponseMessage.class);
        MessageManager.getInstance().registerTask(j);
    }

    public PersonBarModel(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.f20324e = new b();
        this.f20325f = z;
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
        return this.f20326g;
    }

    public b s() {
        return this.f20324e;
    }

    public void setSex(int i2) {
    }

    public boolean t() {
        return this.f20325f;
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
        if (this.f20327h == 1 && this.f20325f) {
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
        this.f20327h = i2;
    }

    public void y(String str) {
        this.f20326g = str;
    }
}

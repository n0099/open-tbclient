package com.baidu.tieba.setting.officialAccountPush;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetOfficialSwitch.OfficialList;
/* loaded from: classes5.dex */
public class OfficialAccountPushModel extends BdBaseModel {
    public static int NET_SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    public b f21324e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f21325f;
    public ArrayList<OfficialAccountPushInfo> list = new ArrayList<>();
    public List<OfficialList> official_list;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            OfficialAccountPushHttpResponseMessage officialAccountPushHttpResponseMessage;
            if (responsedMessage instanceof OfficialAccountPushSocketResponseMessage) {
                OfficialAccountPushSocketResponseMessage officialAccountPushSocketResponseMessage = (OfficialAccountPushSocketResponseMessage) responsedMessage;
                if (officialAccountPushSocketResponseMessage == null || officialAccountPushSocketResponseMessage.getList() == null) {
                    return;
                }
                OfficialAccountPushModel.this.f21324e.a(officialAccountPushSocketResponseMessage.getList(), officialAccountPushSocketResponseMessage.getError(), officialAccountPushSocketResponseMessage.getErrorString());
            }
            if (!(responsedMessage instanceof OfficialAccountPushHttpResponseMessage) || (officialAccountPushHttpResponseMessage = (OfficialAccountPushHttpResponseMessage) responsedMessage) == null) {
                return;
            }
            OfficialAccountPushModel.this.f21324e.a(officialAccountPushHttpResponseMessage.getList(), officialAccountPushHttpResponseMessage.getError(), officialAccountPushHttpResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(ArrayList<OfficialAccountPushInfo> arrayList, int i2, String str);
    }

    public OfficialAccountPushModel(b bVar) {
        a aVar = new a(CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, 309620);
        this.f21325f = aVar;
        this.f21324e = bVar;
        registerListener(aVar);
        d.a.j0.d3.d0.a.f(309620, OfficialAccountPushSocketResponseMessage.class, false);
        d.a.j0.d3.d0.a.c(309620, CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, TbConfig.CHECK_OFFICIAL_SWITCH_URL, OfficialAccountPushHttpResponseMessage.class, true, false, true, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f21325f);
    }

    public void t() {
        sendMessage(new OfficialAccountPushRequestMessage());
    }
}

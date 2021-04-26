package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.c.a.f;
import d.a.c.e.d.l;
import d.a.j0.j1.p.e;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoPageModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f18766e;

    /* renamed from: f  reason: collision with root package name */
    public b f18767f;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            String str;
            boolean z;
            int i2;
            if (responsedMessage == null || LegoPageModel.this.f18767f == null) {
                return;
            }
            boolean z2 = false;
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof LegoPageRequest) {
                    LegoPageRequest legoPageRequest = (LegoPageRequest) extra;
                    long tagCode = legoPageRequest.getTagCode();
                    String itemId = legoPageRequest.getItemId();
                    int pn = legoPageRequest.getPn();
                    boolean z3 = legoPageRequest.getPn() == 1;
                    j = tagCode;
                    z2 = legoPageRequest.getPageType() == 2;
                    str = itemId;
                    i2 = pn;
                    z = z3;
                    if (responsedMessage.getError() == 0) {
                        LegoPageModel.this.f18767f.b(j, str, responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    DataRes dataRes = null;
                    if (responsedMessage instanceof LegoSocketResponse) {
                        dataRes = ((LegoSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof LegoHttpResponse) {
                        dataRes = ((LegoHttpResponse) responsedMessage).getResultData();
                    }
                    if (!z2) {
                        LegoPageModel.this.f18767f.a(j, str, dataRes, z);
                    } else {
                        if (z && dataRes != null) {
                            l<byte[]> d2 = d.a.i0.r.r.a.f().d("tb.lego_update");
                            StringBuilder sb = new StringBuilder();
                            sb.append(j);
                            sb.append("_");
                            sb.append(TextUtils.isEmpty(str) ? "" : str);
                            d2.a(sb.toString(), dataRes.toByteArray());
                        }
                        LegoPageModel.this.f18767f.c(j, str, dataRes, z, i2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, dataRes));
                    return;
                }
            }
            j = 0;
            str = "";
            z = false;
            i2 = 1;
            if (responsedMessage.getError() == 0) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(long j, String str, DataRes dataRes, boolean z);

        void b(long j, String str, int i2, String str2);

        void c(long j, String str, DataRes dataRes, boolean z, int i2);
    }

    public LegoPageModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        this.f18766e = new a(CmdConfigHttp.CMD_ENTERTAINMENT, 309312);
        setUniqueId(bdUniqueId);
        u();
        this.f18766e.getSocketMessageListener().setSelfListener(true);
        this.f18766e.getHttpMessageListener().setSelfListener(true);
        registerListener(this.f18766e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void t(int i2, long j, String str, int i3, String str2) {
        LegoPageRequest legoPageRequest = new LegoPageRequest();
        legoPageRequest.setNetType(NetMessage.NetType.HTTP);
        legoPageRequest.setTag(getUniqueId());
        legoPageRequest.setPn(i3);
        legoPageRequest.setItemId(str);
        legoPageRequest.setLastRank(str2);
        legoPageRequest.setTagCode(j);
        legoPageRequest.setPageType(i2);
        e a2 = e.a(j, str);
        if (a2 != null) {
            legoPageRequest.setRn(a2.f55874d);
            legoPageRequest.setParams(a2.f55875e);
        }
        legoPageRequest.getHttpMessage().addParam("page_id", j);
        sendMessage(legoPageRequest);
    }

    public final void u() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ENTERTAINMENT, d.a.j0.d3.d0.a.a(TbConfig.ENTERTAINMENT_ADDRESS, 309312));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(LegoHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void v(b bVar) {
        this.f18767f = bVar;
    }
}

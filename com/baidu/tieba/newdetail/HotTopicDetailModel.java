package com.baidu.tieba.newdetail;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.r.q.z0;
import d.a.k0.c1.c.d;
import d.a.k0.c1.c.e;
import d.a.k0.c1.c.i;
/* loaded from: classes3.dex */
public class HotTopicDetailModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.x1.a f18522e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18523f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18524g;

    /* renamed from: h  reason: collision with root package name */
    public long f18525h;

    /* renamed from: i  reason: collision with root package name */
    public String f18526i;
    public String j;
    public double k;
    public int l;
    public int m;

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            e eVar;
            d dVar;
            boolean z = HotTopicDetailModel.this.f18523f;
            HotTopicDetailModel.this.f18523f = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z2 = responsedMessage instanceof ResponseHttpHotTopicMessage;
            if ((!z2 && !(responsedMessage instanceof ResponseSocketHotTopicMessage)) || responsedMessage.getOrginalMessage().getTag() != HotTopicDetailModel.this.getUniqueId()) {
                return;
            }
            if (z2) {
                ResponseHttpHotTopicMessage responseHttpHotTopicMessage = (ResponseHttpHotTopicMessage) responsedMessage;
                if (responseHttpHotTopicMessage.getHotTopicData() != null) {
                    eVar = responseHttpHotTopicMessage.getHotTopicData();
                    if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
                        ResponseSocketHotTopicMessage responseSocketHotTopicMessage = (ResponseSocketHotTopicMessage) responsedMessage;
                        if (responseSocketHotTopicMessage.getHotTopicData() != null) {
                            eVar = responseSocketHotTopicMessage.getHotTopicData();
                        }
                    }
                    if (eVar != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                        eVar.s = intValue;
                        dVar = eVar.k;
                        if (dVar != null) {
                            dVar.I3 = intValue;
                        }
                        if (eVar.s == -1) {
                            HotTopicDetailModel.this.f18523f = z;
                        }
                    }
                    if (eVar == null) {
                        HotTopicDetailModel.this.f18522e.netCallback(responsedMessage.getError(), eVar);
                        return;
                    } else {
                        HotTopicDetailModel.this.f18522e.netCallback(-1, null);
                        return;
                    }
                }
            }
            eVar = null;
            if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
            }
            if (eVar != null) {
                int intValue2 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                eVar.s = intValue2;
                dVar = eVar.k;
                if (dVar != null) {
                }
                if (eVar.s == -1) {
                }
            }
            if (eVar == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d dVar;
            HotTopicDetailModel.this.f18523f = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage;
            if ((!z && !(responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) || responsedMessage.getOrginalMessage().getTag() != HotTopicDetailModel.this.getUniqueId()) {
                return;
            }
            if (z) {
                ResponseHttpGetTopicRelateThreadMessage responseHttpGetTopicRelateThreadMessage = (ResponseHttpGetTopicRelateThreadMessage) responsedMessage;
                if (responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                    dVar = responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData();
                    if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
                        ResponseSocketGetTopicRelateThreadMessage responseSocketGetTopicRelateThreadMessage = (ResponseSocketGetTopicRelateThreadMessage) responsedMessage;
                        if (responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                            dVar = responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData();
                        }
                    }
                    if (dVar != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        dVar.I3 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    }
                    if (dVar == null) {
                        HotTopicDetailModel.this.f18522e.netLoadMoreCallback(responsedMessage.getError(), dVar);
                        return;
                    } else {
                        HotTopicDetailModel.this.f18522e.netLoadMoreCallback(-1, null);
                        return;
                    }
                }
            }
            dVar = null;
            if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
            }
            if (dVar != null) {
                dVar.I3 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
            }
            if (dVar == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            int i2;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BlessHttpResponseMessage;
            if ((z || (responsedMessage instanceof BlessSocketResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicDetailModel.this.getUniqueId()) {
                if (z) {
                    BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                    j = blessHttpResponseMessage.userPkId;
                    j2 = blessHttpResponseMessage.pkID;
                } else {
                    j = 0;
                    j2 = 0;
                }
                if (responsedMessage instanceof BlessSocketResponseMessage) {
                    BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                    j = blessSocketResponseMessage.userPkId;
                    j2 = blessSocketResponseMessage.pkID;
                }
                long j3 = j;
                long j4 = j2;
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                    i2 = -1;
                } else {
                    int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    if (intValue == 1 || intValue == 2) {
                        HotTopicDetailModel.this.f18524g = false;
                    }
                    i2 = intValue;
                }
                if (j4 != 0) {
                    HotTopicDetailModel.this.f18522e.netPkCallback(responsedMessage.getError(), j4, j3, i2);
                } else {
                    HotTopicDetailModel.this.f18522e.netPkCallback(-1, j4, j3, i2);
                }
            }
        }
    }

    public HotTopicDetailModel(TbPageContext<?> tbPageContext, d.a.k0.x1.a aVar) {
        super(tbPageContext);
        this.k = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.l = l.k(TbadkCoreApplication.getInst().getApp());
        this.m = l.i(TbadkCoreApplication.getInst().getApp());
        z();
        this.f18522e = aVar;
    }

    public void A() {
        if (j.A()) {
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.f18525h));
            requestHotTopicMessage.setTopicName(this.f18526i);
            requestHotTopicMessage.setCall_from(E(this.j));
            requestHotTopicMessage.setSort_type(1);
            requestHotTopicMessage.setScrH(Integer.valueOf(this.m));
            requestHotTopicMessage.setScrW(Integer.valueOf(this.l));
            requestHotTopicMessage.setSrcDip(Double.valueOf(this.k));
            if (requestHotTopicMessage.getHttpMessage() != null) {
                requestHotTopicMessage.getHttpMessage().setExtra(-1);
                requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestHotTopicMessage.getSocketMessage() != null) {
                requestHotTopicMessage.getSocketMessage().setExtra(-1);
                requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
            }
            requestHotTopicMessage.setTag(this.unique_id);
            MessageManager.getInstance().sendMessage(requestHotTopicMessage);
        }
    }

    public boolean B(d.a.k0.c1.c.a aVar) {
        if (aVar == null || !j.A()) {
            return false;
        }
        RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
        requestBlessMessage.setPkId(Long.valueOf(aVar.f52371g));
        requestBlessMessage.setTopicId(Long.valueOf(this.f18525h));
        requestBlessMessage.setPkIndex(1);
        requestBlessMessage.setClickType(aVar.f52372h != 0 ? 1 : 0);
        requestBlessMessage.setPkType(1);
        requestBlessMessage.setUserPkId(aVar.f52372h);
        requestBlessMessage.setTag(this.unique_id);
        if (requestBlessMessage.getHttpMessage() != null) {
            requestBlessMessage.getHttpMessage().setExtra(0);
            requestBlessMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestBlessMessage.getSocketMessage() != null) {
            requestBlessMessage.getSocketMessage().setExtra(0);
            requestBlessMessage.getSocketMessage().setTag(getUniqueId());
        }
        return MessageManager.getInstance().sendMessage(requestBlessMessage);
    }

    public boolean C(i iVar, int i2) {
        if (iVar == null || !j.A() || this.f18524g) {
            return false;
        }
        RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
        requestBlessMessage.setPkId(Long.valueOf(iVar.l));
        requestBlessMessage.setTopicId(Long.valueOf(this.f18525h));
        requestBlessMessage.setPkIndex(i2);
        requestBlessMessage.setClickType(iVar.m == 0 ? 0 : 1);
        requestBlessMessage.setPkType(0);
        requestBlessMessage.setUserPkId(iVar.m);
        requestBlessMessage.setTag(this.unique_id);
        if (requestBlessMessage.getHttpMessage() != null) {
            requestBlessMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
            requestBlessMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestBlessMessage.getSocketMessage() != null) {
            requestBlessMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
            requestBlessMessage.getSocketMessage().setTag(getUniqueId());
        }
        boolean sendMessage = MessageManager.getInstance().sendMessage(requestBlessMessage);
        this.f18524g = sendMessage;
        return sendMessage;
    }

    public void D(long j, String str) {
        this.f18525h = j;
        this.f18526i = str;
    }

    public final int E(String str) {
        if ("1".equals(str)) {
            return 1;
        }
        if ("2".equals(str)) {
            return 2;
        }
        if ("3".equals(str)) {
            return 3;
        }
        if ("4".equals(str)) {
            return 4;
        }
        return "5".equals(str) ? 5 : 1;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return s(1);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public boolean s(int i2) {
        if (!j.A() || this.f18523f) {
            return false;
        }
        cancelLoadData();
        RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
        requestHotTopicMessage.setTopicId(Long.valueOf(this.f18525h));
        requestHotTopicMessage.setTopicName(this.f18526i);
        requestHotTopicMessage.setCall_from(E(this.j));
        requestHotTopicMessage.setSort_type(Integer.valueOf(i2));
        requestHotTopicMessage.setScrH(Integer.valueOf(this.m));
        requestHotTopicMessage.setScrW(Integer.valueOf(this.l));
        requestHotTopicMessage.setSrcDip(Double.valueOf(this.k));
        if (requestHotTopicMessage.getHttpMessage() != null) {
            requestHotTopicMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
            requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestHotTopicMessage.getSocketMessage() != null) {
            requestHotTopicMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
            requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
        }
        requestHotTopicMessage.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(requestHotTopicMessage);
        this.f18523f = sendMessage;
        return sendMessage;
    }

    public void setFrom(String str) {
        this.j = str;
    }

    public boolean t(int i2) {
        if (!j.A() || this.f18523f) {
            return false;
        }
        cancelLoadData();
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.f18525h));
        requestGetTopicRelateThreadMessage.setTopicName(this.f18526i);
        requestGetTopicRelateThreadMessage.setRn(10);
        requestGetTopicRelateThreadMessage.setPageNo(1);
        requestGetTopicRelateThreadMessage.setLastId(0L);
        requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i2));
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.m));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.l));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.k));
        if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
            requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
            requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
        }
        requestGetTopicRelateThreadMessage.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
        this.f18523f = sendMessage;
        return sendMessage;
    }

    public boolean u(int i2, z0 z0Var, long j) {
        if (!j.A() || this.f18523f) {
            return false;
        }
        cancelLoadData();
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.f18525h));
        requestGetTopicRelateThreadMessage.setTopicName(this.f18526i);
        requestGetTopicRelateThreadMessage.setRn(10);
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(z0Var.a() + 1));
        requestGetTopicRelateThreadMessage.setLastId(Long.valueOf(j));
        requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i2));
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.m));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.l));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.k));
        if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
            requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
            requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
        }
        requestGetTopicRelateThreadMessage.setTag(this.unique_id);
        boolean sendMessage = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
        this.f18523f = sendMessage;
        return sendMessage;
    }

    public final void z() {
        registerListener(new a(CmdConfigHttp.CMD_HOT_TOPIC, 303050));
        registerListener(new b(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005));
        registerListener(new c(CmdConfigHttp.CMD_TOPIC_BLESS, 309085));
    }
}

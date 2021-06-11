package com.baidu.tieba.newlist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import d.a.n0.b2.b;
import d.a.n0.d1.c.j;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class HotTopicListModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f18790e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18791f;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar;
            int i2 = 0;
            HotTopicListModel.this.f18791f = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ResponseHttpHotRanklistMessage;
            if ((z || (responsedMessage instanceof ResponseSocketHotRanklistMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicListModel.this.getUniqueId()) {
                if (z) {
                    ResponseHttpHotRanklistMessage responseHttpHotRanklistMessage = (ResponseHttpHotRanklistMessage) responsedMessage;
                    if (responseHttpHotRanklistMessage.getHotRanklistData() != null) {
                        jVar = responseHttpHotRanklistMessage.getHotRanklistData();
                        if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                            ResponseSocketHotRanklistMessage responseSocketHotRanklistMessage = (ResponseSocketHotRanklistMessage) responsedMessage;
                            if (responseSocketHotRanklistMessage.getHotRanklistData() != null) {
                                jVar = responseSocketHotRanklistMessage.getHotRanklistData();
                            }
                        }
                        if (jVar != null) {
                            if (!ListUtils.isEmpty(jVar.f56282h)) {
                                LinkedList linkedList = new LinkedList();
                                int size = jVar.f56282h.size();
                                while (i2 < size) {
                                    linkedList.add(new d.a.n0.b2.d.b(jVar.f56282h.get(i2), i2));
                                    i2++;
                                }
                                HotTopicListModel.this.f18790e.netCallback(responsedMessage.getError(), linkedList);
                                i2 = 1;
                            }
                            if (i2 != 0) {
                                return;
                            }
                        }
                        HotTopicListModel.this.f18790e.netCallback(-1, null);
                    }
                }
                jVar = null;
                if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                }
                if (jVar != null) {
                }
                HotTopicListModel.this.f18790e.netCallback(-1, null);
            }
        }
    }

    public HotTopicListModel(TbPageContext<?> tbPageContext, b bVar) {
        super(tbPageContext);
        y();
        this.f18790e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!d.a.c.e.p.j.A() || this.f18791f) {
            return false;
        }
        cancelLoadData();
        RequestHotRanklistMessage requestHotRanklistMessage = new RequestHotRanklistMessage();
        requestHotRanklistMessage.setTag(this.unique_id);
        requestHotRanklistMessage.setCallFrom("newbang");
        requestHotRanklistMessage.setListType("all");
        requestHotRanklistMessage.setNeedTabList("0");
        requestHotRanklistMessage.setFid(0L);
        boolean sendMessage = MessageManager.getInstance().sendMessage(requestHotRanklistMessage);
        this.f18791f = sendMessage;
        return sendMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public final void y() {
        registerListener(new a(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289));
    }
}

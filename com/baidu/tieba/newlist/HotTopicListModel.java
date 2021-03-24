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
import d.b.i0.b1.c.j;
import d.b.i0.z1.b;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class HotTopicListModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f19372e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19373f;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
        @Override // d.b.b.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar;
            int i = 0;
            HotTopicListModel.this.f19373f = false;
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
                            if (!ListUtils.isEmpty(jVar.f52128h)) {
                                LinkedList linkedList = new LinkedList();
                                int size = jVar.f52128h.size();
                                while (i < size) {
                                    linkedList.add(new d.b.i0.z1.d.b(jVar.f52128h.get(i), i));
                                    i++;
                                }
                                HotTopicListModel.this.f19372e.netCallback(responsedMessage.getError(), linkedList);
                                i = 1;
                            }
                            if (i != 0) {
                                return;
                            }
                        }
                        HotTopicListModel.this.f19372e.netCallback(-1, null);
                    }
                }
                jVar = null;
                if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                }
                if (jVar != null) {
                }
                HotTopicListModel.this.f19372e.netCallback(-1, null);
            }
        }
    }

    public HotTopicListModel(TbPageContext<?> tbPageContext, b bVar) {
        super(tbPageContext);
        u();
        this.f19372e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!d.b.b.e.p.j.A() || this.f19373f) {
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
        this.f19373f = sendMessage;
        return sendMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public final void u() {
        registerListener(new a(CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289));
    }
}

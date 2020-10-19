package com.baidu.tieba.newlist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class HotTopicListModel extends BdBaseModel {
    private b kQB;
    private boolean mIsLoading;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotTopicListModel(TbPageContext<?> tbPageContext, b bVar) {
        super(tbPageContext);
        cER();
        this.kQB = bVar;
    }

    private void cER() {
        registerListener(new com.baidu.adp.framework.listener.a(1003078, CmdConfigSocket.CMD_HOT_TOPIC_RANKLIST) { // from class: com.baidu.tieba.newlist.HotTopicListModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                HotTopicListModel.this.mIsLoading = false;
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ResponseHttpHotRanklistMessage) || (responsedMessage instanceof ResponseSocketHotRanklistMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicListModel.this.getUniqueId()) {
                        j hotRanklistData = (!(responsedMessage instanceof ResponseHttpHotRanklistMessage) || ((ResponseHttpHotRanklistMessage) responsedMessage).getHotRanklistData() == null) ? null : ((ResponseHttpHotRanklistMessage) responsedMessage).getHotRanklistData();
                        if ((responsedMessage instanceof ResponseSocketHotRanklistMessage) && ((ResponseSocketHotRanklistMessage) responsedMessage).getHotRanklistData() != null) {
                            hotRanklistData = ((ResponseSocketHotRanklistMessage) responsedMessage).getHotRanklistData();
                        }
                        if (hotRanklistData != null) {
                            if (y.isEmpty(hotRanklistData.jxx)) {
                                z = false;
                            } else {
                                LinkedList linkedList = new LinkedList();
                                int size = hotRanklistData.jxx.size();
                                for (int i = 0; i < size; i++) {
                                    linkedList.add(new com.baidu.tieba.newlist.b.b(hotRanklistData.jxx.get(i), i));
                                }
                                HotTopicListModel.this.kQB.o(responsedMessage.getError(), linkedList);
                                z = true;
                            }
                            if (z) {
                                return;
                            }
                        }
                        HotTopicListModel.this.kQB.o(-1, null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        cancelLoadData();
        RequestHotRanklistMessage requestHotRanklistMessage = new RequestHotRanklistMessage();
        requestHotRanklistMessage.setTag(this.unique_id);
        requestHotRanklistMessage.setCallFrom("newbang");
        requestHotRanklistMessage.setListType("all");
        requestHotRanklistMessage.setNeedTabList("0");
        requestHotRanklistMessage.setFid(0L);
        this.mIsLoading = MessageManager.getInstance().sendMessage(requestHotRanklistMessage);
        return this.mIsLoading;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}

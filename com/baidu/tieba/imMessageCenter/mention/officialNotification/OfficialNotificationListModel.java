package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.im.chat.d;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class OfficialNotificationListModel extends CommonPersonalMsglistModel {
    private CustomMessageListener mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2012123) {
                    OfficialNotificationListModel.this.processServerMsg(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001147) {
                    OfficialNotificationListModel.this.processHistory(customResponsedMessage);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public OfficialNotificationListModel(TbPageContext tbPageContext) {
        this.mDatas = new MsgPageData();
        this.mPageContext = tbPageContext;
        registerListener();
        this.customGroupType = 4;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(d dVar) {
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 20;
        aVar.hIu = null;
        aVar.hIv = null;
        aVar.id = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialNotificationHistoryMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2 = 0;
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 20;
        if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.mDatas.getChatMessages().get(0).getMsgId();
            j2 = this.mDatas.getChatMessages().get(0).getRecordId();
        }
        aVar.hIu = String.valueOf(j);
        aVar.hIv = String.valueOf(j2);
        aVar.id = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialNotificationHistoryMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage genChatMessage() {
        return null;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected long getMaxMid() {
        return 0L;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void deleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    return Boolean.valueOf(l.bUV().dz(String.valueOf(OfficialNotificationListModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void markDeleteMsg(ChatMessage chatMessage) {
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected MsglistModel.CacheInfo getCacheInfo() {
        return null;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LOAD_HISTORY_OFFICICAL, this.mCustomMessageListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof OfficialChatMessage) {
                        if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        }
                    }
                }
                processMsgFromServerCommon(linkedList);
            }
        }
    }
}

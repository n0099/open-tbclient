package com.baidu.tieba.imMessageCenter.mention.officialNotification;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.j0.e1.f.c;
import d.b.j0.e1.h.l;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class OfficialNotificationListModel extends CommonPersonalMsglistModel {

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f18048e = new b(0);

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f18049a;

        public a(ChatMessage chatMessage) {
            this.f18049a = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(l.t().c(String.valueOf(OfficialNotificationListModel.this.mUser.getUserId()), String.valueOf(this.f18049a.getMsgId())));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012123) {
                OfficialNotificationListModel.this.processServerMsg(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001147) {
                OfficialNotificationListModel.this.processHistory(customResponsedMessage);
            }
        }
    }

    public OfficialNotificationListModel(TbPageContext tbPageContext) {
        this.mDatas = new MsgPageData();
        registerListener();
        this.customGroupType = 4;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void deleteMsg(ChatMessage chatMessage) {
        if (this.mUser == null || chatMessage == null) {
            return;
        }
        h0.c(new a(chatMessage), null);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public ChatMessage genChatMessage() {
        return null;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public MsglistModel.CacheInfo getCacheInfo() {
        return null;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        return 0L;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(c cVar) {
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f17727c = 20;
        aVar.f17725a = null;
        aVar.f17726b = null;
        aVar.f17728d = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialNotificationHistoryMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f17727c = 20;
        MsgPageData msgPageData = this.mDatas;
        long j2 = 0;
        if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j2 = this.mDatas.getChatMessages().get(0).getMsgId();
            j = this.mDatas.getChatMessages().get(0).getRecordId();
        }
        aVar.f17725a = String.valueOf(j2);
        aVar.f17726b = String.valueOf(j);
        aVar.f17728d = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialNotificationHistoryMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(ChatMessage chatMessage) {
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    public final void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
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

    public final void registerListener() {
        MessageManager.getInstance().registerListener(2012123, this.f18048e);
        MessageManager.getInstance().registerListener(2001147, this.f18048e);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        return false;
    }

    public final void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.f18048e);
    }
}

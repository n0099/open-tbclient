package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.al;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.j;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.RequestPersonalMsgReadMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.util.h;
import com.baidu.tieba.imMessageCenter.LoadPersonalDraftMessage;
import com.baidu.tieba.imMessageCenter.LoadPersonalHistoryMessage;
import com.baidu.tieba.imMessageCenter.PersonalSaveDraftMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {
    private String dbi;
    private CardStatus dbj;
    private ChatMessage dbk;
    private boolean dbl;
    private int isFriend;
    private CustomMessageListener mCustomMessageListener;

    /* loaded from: classes.dex */
    public enum CardStatus {
        APPLY,
        WAIT,
        AGREE,
        PASS;

        /* JADX DEBUG: Replace access to removed values field (dbo) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CardStatus[] valuesCustom() {
            CardStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            CardStatus[] cardStatusArr = new CardStatus[length];
            System.arraycopy(valuesCustom, 0, cardStatusArr, 0, length);
            return cardStatusArr;
        }
    }

    public PersonalMsglistModel() {
        this.mCustomMessageListener = new a(this, 0);
    }

    public PersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mCustomMessageListener = new a(this, 0);
        registerListener();
        this.customGroupType = 2;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage genChatMessage() {
        if (this.mUser == null) {
            return null;
        }
        PersonalChatMessage personalChatMessage = new PersonalChatMessage();
        personalChatMessage.setBornTime(System.currentTimeMillis());
        personalChatMessage.setToUserId(this.mUser.getUserIdLong());
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(this.mUser.getUserId()));
        userData.setUserName(this.mUser.getUserName());
        userData.setPortrait(this.mUser.getPortrait());
        personalChatMessage.setToUserInfo(userData);
        personalChatMessage.setIsFriend(this.isFriend);
        return personalChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(al alVar) {
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 20;
        aVar.cUe = null;
        aVar.cUf = null;
        aVar.id = new StringBuilder(String.valueOf(this.mUser.getUserIdLong())).toString();
        LoadPersonalHistoryMessage loadPersonalHistoryMessage = new LoadPersonalHistoryMessage(aVar);
        loadPersonalHistoryMessage.setCallback(alVar);
        super.sendMessage(loadPersonalHistoryMessage);
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2 = 0;
        if (this.mUser != null) {
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.limit = 20;
            if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.mDatas.getChatMessages().get(0).getMsgId();
                j2 = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            aVar.cUe = String.valueOf(j);
            aVar.cUf = String.valueOf(j2);
            aVar.id = new StringBuilder(String.valueOf(this.mUser.getUserIdLong())).toString();
            super.sendMessage(new LoadPersonalHistoryMessage(aVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mUser == null) {
            return false;
        }
        LoadDraftMessage.a aVar = new LoadDraftMessage.a();
        aVar.id = this.mUser.getUserId();
        super.sendMessage(new LoadPersonalDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        SaveDraftMessage.a aVar = new SaveDraftMessage.a();
        if (this.mUser == null) {
            return false;
        }
        aVar.mId = String.valueOf(String.valueOf(this.mUser.getUserId()));
        aVar.mDraft = str;
        super.sendMessage(new PersonalSaveDraftMessage(aVar));
        return true;
    }

    public CardStatus j(com.baidu.tieba.im.data.b bVar) {
        if (bVar == null) {
            return CardStatus.APPLY;
        }
        if (bVar.getStatus() == 0) {
            return CardStatus.APPLY;
        }
        if (bVar.getStatus() == 3) {
            return CardStatus.WAIT;
        }
        if (bVar.getStatus() == 1) {
            return CardStatus.AGREE;
        }
        return CardStatus.APPLY;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void deleteMsg(ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            t.b(new b(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void markDeleteMsg(ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            t.b(new c(this, chatMessage), null);
        }
    }

    private void registerListener() {
        registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.mCustomMessageListener);
        registerListener(CmdConfigCustom.CMD_LOAD_DRAFT_PERSONAL, this.mCustomMessageListener);
        registerListener(CmdConfigCustom.CMD_LOAD_HISTORY_PERSONAL, this.mCustomMessageListener);
    }

    protected void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        BdLog.i("see picUpLoading unregister");
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected boolean onAfterLoadFromDb() {
        ImMessageCenterPojo af;
        if (getUser() == null || (af = com.baidu.tieba.im.memorycache.b.arI().af(getUser().getUserId(), 2)) == null) {
            return false;
        }
        bS(af.getRead_msgId());
        auC();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                this.dbl = false;
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof PersonalChatMessage) {
                        if (chatMessage.getMsgType() == 22) {
                            if (this.dbk == null) {
                                this.dbk = chatMessage;
                            } else if (this.dbk.getMsgId() < chatMessage.getMsgId()) {
                                this.dbk = chatMessage;
                            }
                        } else if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            this.dbl = true;
                            linkedList.add(chatMessage);
                        }
                    }
                }
                processMsgFromServerCommon(linkedList);
                if (ChatStatusManager.getInst().getIsOpen(0)) {
                    auA();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected boolean onAfterProcessMsgFromServer() {
        if (this.dbk == null || this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0 || h.r(this.dbk)) {
            return false;
        }
        bS(j.f(this.dbk));
        return true;
    }

    private void bS(long j) {
        if (j > 0) {
            for (ChatMessage chatMessage : this.mDatas.getChatMessages()) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 3) {
                    if (chatMessage.getMsgId() <= j) {
                        chatMessage.setHasRead(true);
                    } else {
                        chatMessage.setHasRead(false);
                    }
                }
            }
        }
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public String auz() {
        return this.dbi;
    }

    public void li(String str) {
        this.dbi = str;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected MsglistModel.CacheInfo getCacheInfo() {
        if (this.mUser == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.id = this.mUser.getUserId();
        cacheInfo.customGroupType = 2;
        return cacheInfo;
    }

    public void auA() {
        if (this.dbl) {
            auC();
            this.dbl = false;
        }
    }

    public CardStatus auB() {
        return this.dbj;
    }

    public void a(CardStatus cardStatus) {
        this.dbj = cardStatus;
    }

    private void auC() {
        ImMessageCenterPojo af;
        if (getUser() != null) {
            long userIdLong = getUser().getUserIdLong();
            if (userIdLong != 0 && (af = com.baidu.tieba.im.memorycache.b.arI().af(getUser().getUserId(), 2)) != null) {
                long auD = auD();
                if (auD > af.getSent_msgId()) {
                    RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(com.baidu.tieba.im.util.g.bR(auD), userIdLong);
                    if (!MessageManager.getInstance().getSocketClient().a(requestPersonalMsgReadMessage)) {
                        MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
                    }
                }
            }
        }
    }

    private long auD() {
        if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0) {
            return -1L;
        }
        for (int size = this.mDatas.getChatMessages().size() - 1; size >= 0; size--) {
            ChatMessage chatMessage = this.mDatas.getChatMessages().get(size);
            if (chatMessage.getUserId() != 0 && !String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                return chatMessage.getMsgId();
            }
        }
        return -1L;
    }

    public void lj(String str) {
        t.b(new d(this), new e(this, str));
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected long getMaxMid() {
        return com.baidu.tieba.im.memorycache.b.arI().aj(String.valueOf(com.baidu.tieba.im.c.a.cWt), -1);
    }
}

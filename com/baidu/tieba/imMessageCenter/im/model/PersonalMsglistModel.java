package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.DealInfoIMData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.al;
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
import com.baidu.tieba.imMessageCenter.LoadPersonalDraftMessage;
import com.baidu.tieba.imMessageCenter.LoadPersonalHistoryMessage;
import com.baidu.tieba.imMessageCenter.PersonalSaveDraftMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {
    private String dcD;
    private CardStatus dcE;
    private ChatMessage dcF;
    private boolean dcG;
    private String dcH;
    private int isFriend;
    private CustomMessageListener mCustomMessageListener;

    /* loaded from: classes.dex */
    public enum CardStatus {
        APPLY,
        WAIT,
        AGREE,
        PASS;

        /* JADX DEBUG: Replace access to removed values field (dcN) with 'values()' method */
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
        aVar.cTy = null;
        aVar.cTz = null;
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
            aVar.cTy = String.valueOf(j);
            aVar.cTz = String.valueOf(j2);
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

    public CardStatus k(com.baidu.tieba.im.data.b bVar) {
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
        ImMessageCenterPojo ah;
        if (getUser() == null || (ah = com.baidu.tieba.im.memorycache.b.apn().ah(getUser().getUserId(), 2)) == null) {
            return false;
        }
        bO(ah.getRead_msgId());
        atl();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                this.dcG = false;
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof PersonalChatMessage) {
                        if (chatMessage.getMsgType() == 22) {
                            if (this.dcF == null) {
                                this.dcF = chatMessage;
                            } else if (this.dcF.getMsgId() < chatMessage.getMsgId()) {
                                this.dcF = chatMessage;
                            }
                        } else if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            this.dcG = true;
                            linkedList.add(chatMessage);
                        }
                    }
                }
                processMsgFromServerCommon(linkedList);
                if (ChatStatusManager.getInst().getIsOpen(0)) {
                    atj();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected boolean onAfterProcessMsgFromServer() {
        if (this.dcF == null || this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0 || com.baidu.tieba.im.util.h.t(this.dcF)) {
            return false;
        }
        bO(com.baidu.tieba.im.chat.receiveChatMsgHandler.j.h(this.dcF));
        return true;
    }

    private void bO(long j) {
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

    public String ath() {
        return this.dcD;
    }

    public void lD(String str) {
        this.dcD = str;
    }

    public String ati() {
        return this.dcH;
    }

    public void lE(String str) {
        this.dcH = str;
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

    public void atj() {
        if (this.dcG) {
            atl();
            this.dcG = false;
        }
    }

    public CardStatus atk() {
        return this.dcE;
    }

    public void a(CardStatus cardStatus) {
        this.dcE = cardStatus;
    }

    private void atl() {
        ImMessageCenterPojo ah;
        if (getUser() != null) {
            long userIdLong = getUser().getUserIdLong();
            if (userIdLong != 0 && (ah = com.baidu.tieba.im.memorycache.b.apn().ah(getUser().getUserId(), 2)) != null) {
                long atm = atm();
                if (atm > ah.getSent_msgId()) {
                    RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(com.baidu.tieba.im.util.g.bN(atm), userIdLong);
                    if (!MessageManager.getInstance().getSocketClient().a(requestPersonalMsgReadMessage)) {
                        MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
                    }
                }
            }
        }
    }

    private long atm() {
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

    public void lF(String str) {
        t.b(new d(this), new e(this, str));
    }

    public void lG(String str) {
        DealInfoIMData parseData = DealInfoIMData.parseData(str);
        if (parseData != null) {
            t.b(new h(this, parseData.orderId), new i(this, str));
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected long getMaxMid() {
        return com.baidu.tieba.im.memorycache.b.apn().al(String.valueOf(com.baidu.tieba.im.c.a.cVO), -1);
    }
}

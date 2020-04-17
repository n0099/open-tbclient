package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.d;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.a;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.RequestPersonalMsgReadMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.util.e;
import com.baidu.tieba.imMessageCenter.LoadPersonalDraftMessage;
import com.baidu.tieba.imMessageCenter.LoadPersonalHistoryMessage;
import com.baidu.tieba.imMessageCenter.PersonalSaveDraftMessage;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {
    private int followStatus;
    private int isFriend;
    private String iyN;
    private CardStatus iyO;
    private ChatMessage iyP;
    private boolean iyQ;
    private CustomMessageListener mCustomMessageListener;

    /* loaded from: classes9.dex */
    public enum CardStatus {
        APPLY,
        WAIT,
        AGREE,
        PASS
    }

    public PersonalMsglistModel() {
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d callback;
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2012121) {
                        PersonalMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001143) {
                        PersonalMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001146) {
                        boolean processHistory = PersonalMsglistModel.this.processHistory(customResponsedMessage);
                        if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                            callback.cda();
                        }
                    }
                }
            }
        };
    }

    public PersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d callback;
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2012121) {
                        PersonalMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001143) {
                        PersonalMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001146) {
                        boolean processHistory = PersonalMsglistModel.this.processHistory(customResponsedMessage);
                        if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                            callback.cda();
                        }
                    }
                }
            }
        };
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
        userData.setName_show(this.mUser.getName_show());
        personalChatMessage.setToUserInfo(userData);
        personalChatMessage.setIsFriend(this.isFriend);
        personalChatMessage.setFollowStatus(this.followStatus);
        return personalChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(d dVar) {
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 20;
        aVar.isk = null;
        aVar.isl = null;
        aVar.id = this.mUser.getUserIdLong() + "";
        LoadPersonalHistoryMessage loadPersonalHistoryMessage = new LoadPersonalHistoryMessage(aVar);
        loadPersonalHistoryMessage.setCallback(dVar);
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
            aVar.isk = String.valueOf(j);
            aVar.isl = String.valueOf(j2);
            aVar.id = this.mUser.getUserIdLong() + "";
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

    public CardStatus j(a aVar) {
        if (aVar == null) {
            return CardStatus.APPLY;
        }
        if (aVar.getStatus() == 0) {
            return CardStatus.APPLY;
        }
        if (aVar.getStatus() == 3) {
            return CardStatus.WAIT;
        }
        if (aVar.getStatus() == 1) {
            return CardStatus.AGREE;
        }
        return CardStatus.APPLY;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void deleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    return Boolean.valueOf(m.cfy().dO(String.valueOf(PersonalMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void markDeleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ab
                public Boolean doInBackground() {
                    return Boolean.valueOf(m.cfy().dN(String.valueOf(PersonalMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
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
        ImMessageCenterPojo bf;
        if (getUser() == null || (bf = b.chC().bf(getUser().getUserId(), 2)) == null) {
            return false;
        }
        eO(bf.getRead_msgId());
        ckf();
        return true;
    }

    protected void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                this.iyQ = false;
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof PersonalChatMessage) {
                        if (chatMessage.getMsgType() == 22) {
                            if (this.iyP == null) {
                                this.iyP = chatMessage;
                            } else if (this.iyP.getMsgId() < chatMessage.getMsgId()) {
                                this.iyP = chatMessage;
                            }
                        } else if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            this.iyQ = true;
                            linkedList.add(chatMessage);
                        }
                    }
                }
                processMsgFromServerCommon(linkedList);
                if (ChatStatusManager.getInst().getIsOpen(0)) {
                    ckd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected boolean onAfterProcessMsgFromServer() {
        if (this.iyP == null || this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0 || e.r(this.iyP)) {
            return false;
        }
        eO(com.baidu.tieba.im.chat.b.e.f(this.iyP));
        return true;
    }

    private void eO(long j) {
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

    public void setFollowStatus(int i) {
        this.followStatus = i;
    }

    public String ckc() {
        return this.iyN;
    }

    public void Fq(String str) {
        this.iyN = str;
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

    public void ckd() {
        if (this.iyQ) {
            ckf();
            this.iyQ = false;
        }
    }

    public CardStatus cke() {
        return this.iyO;
    }

    public void a(CardStatus cardStatus) {
        this.iyO = cardStatus;
    }

    private void ckf() {
        ImMessageCenterPojo bf;
        if (getUser() != null) {
            long userIdLong = getUser().getUserIdLong();
            if (userIdLong != 0 && (bf = b.chC().bf(getUser().getUserId(), 2)) != null) {
                long ckg = ckg();
                if (ckg > bf.getSent_msgId()) {
                    RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(com.baidu.tieba.im.util.d.eN(ckg), userIdLong);
                    if (!MessageManager.getInstance().getSocketClient().a(requestPersonalMsgReadMessage)) {
                        MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
                    }
                }
            }
        }
    }

    private long ckg() {
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

    public void Fr(final String str) {
        ac.b(new ab<CommonMsgPojo>() { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: ckh */
            public CommonMsgPojo doInBackground() {
                return m.cfy().bd(PersonalMsglistModel.this.getUser().getUserId(), 23);
            }
        }, new l<CommonMsgPojo>() { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(CommonMsgPojo commonMsgPojo) {
                if (commonMsgPojo == null) {
                    final ChatMessage createMessage = PersonalMsglistModel.this.createMessage((short) 23, str);
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
                    final LinkedList linkedList = new LinkedList();
                    CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(createMessage);
                    commonMsgPojo2.setRead_flag(0);
                    linkedList.add(commonMsgPojo2);
                    ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.5.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tbadk.util.ab
                        public Boolean doInBackground() {
                            return Boolean.valueOf(m.cfy().a(e.n(personalChatMessage), linkedList, false));
                        }
                    }, new l<Boolean>() { // from class: com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel.5.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.l
                        public void onReturnDataInUI(Boolean bool) {
                            if (bool != null && bool.booleanValue()) {
                                PersonalMsglistModel.this.mDatas.getChatMessages().add(createMessage);
                                PersonalMsglistModel.this.mLoadDataMode = 14;
                                PersonalMsglistModel.this.mLoadDataCallBack.callback(PersonalMsglistModel.this.mDatas);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected long getMaxMid() {
        return b.chC().bi(String.valueOf(com.baidu.tieba.im.sendmessage.a.iuz), -1);
    }
}

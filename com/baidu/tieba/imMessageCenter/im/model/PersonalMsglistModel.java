package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
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
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import d.a.n0.f1.h.m;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {

    /* renamed from: e  reason: collision with root package name */
    public int f17565e;

    /* renamed from: f  reason: collision with root package name */
    public int f17566f;

    /* renamed from: g  reason: collision with root package name */
    public String f17567g;

    /* renamed from: h  reason: collision with root package name */
    public CardStatus f17568h;

    /* renamed from: i  reason: collision with root package name */
    public ChatMessage f17569i;
    public boolean j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public enum CardStatus {
        APPLY,
        WAIT,
        AGREE,
        PASS
    }

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f17570a;

        public a(ChatMessage chatMessage) {
            this.f17570a = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(m.t().c(String.valueOf(PersonalMsglistModel.this.mUser.getUserId()), String.valueOf(this.f17570a.getMsgId())));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatMessage f17572a;

        public b(ChatMessage chatMessage) {
            this.f17572a = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(m.t().n(String.valueOf(PersonalMsglistModel.this.mUser.getUserId()), String.valueOf(this.f17572a.getMsgId())));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.f1.f.c callback;
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012121) {
                PersonalMsglistModel.this.processServerMsg(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001143) {
                PersonalMsglistModel.this.processDraft(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001146) {
                boolean processHistory = PersonalMsglistModel.this.processHistory(customResponsedMessage);
                if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                    callback.onFirstHistoryPageLoaded();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<CommonMsgPojo> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public CommonMsgPojo doInBackground() {
            return m.t().u(PersonalMsglistModel.this.getUser().getUserId(), 23);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements n<CommonMsgPojo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17576a;

        /* loaded from: classes4.dex */
        public class a extends f0<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonalChatMessage f17578a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LinkedList f17579b;

            public a(e eVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
                this.f17578a = personalChatMessage;
                this.f17579b = linkedList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.m0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(m.t().m(d.a.n0.f1.w.c.m(this.f17578a), this.f17579b, false));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements n<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ChatMessage f17580a;

            public b(ChatMessage chatMessage) {
                this.f17580a = chatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                PersonalMsglistModel.this.mDatas.getChatMessages().add(this.f17580a);
                PersonalMsglistModel.this.mLoadDataMode = 14;
                PersonalMsglistModel.this.mLoadDataCallBack.c(PersonalMsglistModel.this.mDatas);
            }
        }

        public e(String str) {
            this.f17576a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(CommonMsgPojo commonMsgPojo) {
            if (commonMsgPojo == null) {
                ChatMessage createMessage = PersonalMsglistModel.this.createMessage((short) 23, this.f17576a);
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(createMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList.add(commonMsgPojo2);
                h0.c(new a(this, (PersonalChatMessage) createMessage, linkedList), new b(createMessage));
            }
        }
    }

    public PersonalMsglistModel() {
        this.k = new c(0);
    }

    public CardStatus F() {
        return this.f17568h;
    }

    public CardStatus G(d.a.n0.f1.g.a aVar) {
        if (aVar == null) {
            return CardStatus.APPLY;
        }
        if (aVar.f() == 0) {
            return CardStatus.APPLY;
        }
        if (aVar.f() == 3) {
            return CardStatus.WAIT;
        }
        if (aVar.f() == 1) {
            return CardStatus.AGREE;
        }
        return CardStatus.APPLY;
    }

    public final long H() {
        MsgPageData msgPageData = this.mDatas;
        if (msgPageData != null && msgPageData.getChatMessages() != null && this.mDatas.getChatMessages().size() != 0) {
            for (int size = this.mDatas.getChatMessages().size() - 1; size >= 0; size--) {
                ChatMessage chatMessage = this.mDatas.getChatMessages().get(size);
                if (chatMessage.getUserId() != 0 && !String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                    return chatMessage.getMsgId();
                }
            }
        }
        return -1L;
    }

    public String I() {
        return this.f17567g;
    }

    public void J(String str) {
        h0.c(new d(), new e(str));
    }

    public final void K(long j) {
        if (j <= 0) {
            return;
        }
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

    public final void L() {
        ImMessageCenterPojo i2;
        if (getUser() == null) {
            return;
        }
        long userIdLong = getUser().getUserIdLong();
        if (userIdLong == 0 || (i2 = d.a.n0.f1.k.b.o().i(getUser().getUserId(), 2)) == null) {
            return;
        }
        long H = H();
        if (H > i2.getSent_msgId()) {
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(d.a.n0.f1.w.b.c(H), userIdLong);
            if (MessageManager.getInstance().getSocketClient().o(requestPersonalMsgReadMessage)) {
                return;
            }
            MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
        }
    }

    public void M() {
        if (this.j) {
            L();
            this.j = false;
        }
    }

    public void N(CardStatus cardStatus) {
        this.f17568h = cardStatus;
    }

    public void O(String str) {
        this.f17567g = str;
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
        personalChatMessage.setIsFriend(this.f17565e);
        personalChatMessage.setFollowStatus(this.f17566f);
        return personalChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public MsglistModel.CacheInfo getCacheInfo() {
        if (this.mUser == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.id = this.mUser.getUserId();
        cacheInfo.customGroupType = 2;
        return cacheInfo;
    }

    public int getFollowStatus() {
        return this.f17566f;
    }

    public int getIsFriend() {
        return this.f17565e;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        return d.a.n0.f1.k.b.o().p(String.valueOf(d.a.n0.f1.s.a.f58385i), -1);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mUser == null) {
            return false;
        }
        LoadDraftMessage.a aVar = new LoadDraftMessage.a();
        aVar.f17350a = this.mUser.getUserId();
        super.sendMessage(new LoadPersonalDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(d.a.n0.f1.f.c cVar) {
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f17354c = 20;
        aVar.f17352a = null;
        aVar.f17353b = null;
        aVar.f17355d = this.mUser.getUserIdLong() + "";
        LoadPersonalHistoryMessage loadPersonalHistoryMessage = new LoadPersonalHistoryMessage(aVar);
        loadPersonalHistoryMessage.setCallback(cVar);
        super.sendMessage(loadPersonalHistoryMessage);
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f17354c = 20;
        MsgPageData msgPageData = this.mDatas;
        long j2 = 0;
        if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j2 = this.mDatas.getChatMessages().get(0).getMsgId();
            j = this.mDatas.getChatMessages().get(0).getRecordId();
        }
        aVar.f17352a = String.valueOf(j2);
        aVar.f17353b = String.valueOf(j);
        aVar.f17355d = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadPersonalHistoryMessage(aVar));
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(ChatMessage chatMessage) {
        if (this.mUser == null || chatMessage == null) {
            return;
        }
        h0.c(new b(chatMessage), null);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean onAfterLoadFromDb() {
        ImMessageCenterPojo i2;
        if (getUser() == null || (i2 = d.a.n0.f1.k.b.o().i(getUser().getUserId(), 2)) == null) {
            return false;
        }
        K(i2.getRead_msgId());
        L();
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean onAfterProcessMsgFromServer() {
        MsgPageData msgPageData;
        if (this.f17569i == null || (msgPageData = this.mDatas) == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0 || d.a.n0.f1.w.c.p(this.f17569i)) {
            return false;
        }
        K(d.a.n0.f1.f.l.e.a(this.f17569i));
        return true;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                this.j = false;
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof PersonalChatMessage) {
                        if (chatMessage.getMsgType() == 22) {
                            ChatMessage chatMessage2 = this.f17569i;
                            if (chatMessage2 == null) {
                                this.f17569i = chatMessage;
                            } else if (chatMessage2.getMsgId() < chatMessage.getMsgId()) {
                                this.f17569i = chatMessage;
                            }
                        } else if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            this.j = true;
                            linkedList.add(chatMessage);
                        }
                    }
                }
                processMsgFromServerCommon(linkedList);
                if (ChatStatusManager.getInst().getIsOpen(0)) {
                    M();
                }
            }
        }
    }

    public final void registerListener() {
        registerListener(2012121, this.k);
        registerListener(2001143, this.k);
        registerListener(2001146, this.k);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        SaveDraftMessage.a aVar = new SaveDraftMessage.a();
        UserData userData = this.mUser;
        if (userData == null) {
            return false;
        }
        aVar.f17378b = String.valueOf(String.valueOf(userData.getUserId()));
        aVar.f17377a = str;
        super.sendMessage(new PersonalSaveDraftMessage(aVar));
        return true;
    }

    public void setFollowStatus(int i2) {
        this.f17566f = i2;
    }

    public void setIsFriend(int i2) {
        this.f17565e = i2;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.k);
        BdLog.i("see picUpLoading unregister");
    }

    public PersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.k = new c(0);
        registerListener();
        this.customGroupType = 2;
    }
}

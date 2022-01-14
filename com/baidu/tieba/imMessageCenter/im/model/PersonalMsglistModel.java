package com.baidu.tieba.imMessageCenter.im.model;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.e1.k0;
import c.a.s0.e1.n0;
import c.a.s0.e1.s;
import c.a.t0.s1.h.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes12.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45228e;

    /* renamed from: f  reason: collision with root package name */
    public int f45229f;

    /* renamed from: g  reason: collision with root package name */
    public String f45230g;

    /* renamed from: h  reason: collision with root package name */
    public CardStatus f45231h;

    /* renamed from: i  reason: collision with root package name */
    public ChatMessage f45232i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f45233j;
    public CustomMessageListener k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class CardStatus {
        public static final /* synthetic */ CardStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CardStatus AGREE;
        public static final CardStatus APPLY;
        public static final CardStatus PASS;
        public static final CardStatus WAIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1856351083, "Lcom/baidu/tieba/imMessageCenter/im/model/PersonalMsglistModel$CardStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1856351083, "Lcom/baidu/tieba/imMessageCenter/im/model/PersonalMsglistModel$CardStatus;");
                    return;
                }
            }
            APPLY = new CardStatus("APPLY", 0);
            WAIT = new CardStatus("WAIT", 1);
            AGREE = new CardStatus("AGREE", 2);
            CardStatus cardStatus = new CardStatus("PASS", 3);
            PASS = cardStatus;
            $VALUES = new CardStatus[]{APPLY, WAIT, AGREE, cardStatus};
        }

        public CardStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CardStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CardStatus) Enum.valueOf(CardStatus.class, str) : (CardStatus) invokeL.objValue;
        }

        public static CardStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CardStatus[]) $VALUES.clone() : (CardStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class a extends k0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalMsglistModel f45234b;

        public a(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalMsglistModel, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45234b = personalMsglistModel;
            this.a = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.s0.e1.k0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(m.t().c(String.valueOf(this.f45234b.mUser.getUserId()), String.valueOf(this.a.getMsgId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b extends k0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalMsglistModel f45235b;

        public b(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalMsglistModel, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45235b = personalMsglistModel;
            this.a = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.s0.e1.k0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(m.t().n(String.valueOf(this.f45235b.mUser.getUserId()), String.valueOf(this.a.getMsgId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalMsglistModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalMsglistModel personalMsglistModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalMsglistModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalMsglistModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.t0.s1.f.c callback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012121) {
                this.a.processServerMsg(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001143) {
                this.a.processDraft(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001146) {
                boolean processHistory = this.a.processHistory(customResponsedMessage);
                if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                    callback.onFirstHistoryPageLoaded();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends k0<CommonMsgPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalMsglistModel a;

        public d(PersonalMsglistModel personalMsglistModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalMsglistModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalMsglistModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.k0
        /* renamed from: a */
        public CommonMsgPojo doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m.t().u(this.a.getUser().getUserId(), 23) : (CommonMsgPojo) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class e implements s<CommonMsgPojo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalMsglistModel f45236b;

        /* loaded from: classes12.dex */
        public class a extends k0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatMessage a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LinkedList f45237b;

            public a(e eVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, personalChatMessage, linkedList};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = personalChatMessage;
                this.f45237b = linkedList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.s0.e1.k0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(m.t().m(c.a.t0.s1.w.c.m(this.a), this.f45237b, false)) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes12.dex */
        public class b implements s<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatMessage a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f45238b;

            public b(e eVar, ChatMessage chatMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, chatMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45238b = eVar;
                this.a = chatMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.e1.s
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && bool != null && bool.booleanValue()) {
                    this.f45238b.f45236b.mDatas.getChatMessages().add(this.a);
                    this.f45238b.f45236b.mLoadDataMode = 14;
                    this.f45238b.f45236b.mLoadDataCallBack.c(this.f45238b.f45236b.mDatas);
                }
            }
        }

        public e(PersonalMsglistModel personalMsglistModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalMsglistModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45236b = personalMsglistModel;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.s
        /* renamed from: a */
        public void onReturnDataInUI(CommonMsgPojo commonMsgPojo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, commonMsgPojo) == null) && commonMsgPojo == null) {
                ChatMessage createMessage = this.f45236b.createMessage((short) 23, this.a);
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(createMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList.add(commonMsgPojo2);
                n0.c(new a(this, (PersonalChatMessage) createMessage, linkedList), new b(this, createMessage));
            }
        }
    }

    public PersonalMsglistModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new c(this, 0);
    }

    public CardStatus F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45231h : (CardStatus) invokeV.objValue;
    }

    public CardStatus G(c.a.t0.s1.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
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
        return (CardStatus) invokeL.objValue;
    }

    public final long H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return invokeV.longValue;
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45230g : (String) invokeV.objValue;
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            n0.c(new d(this), new e(this, str));
        }
    }

    public final void K(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || j2 <= 0) {
            return;
        }
        for (ChatMessage chatMessage : this.mDatas.getChatMessages()) {
            if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 3) {
                if (chatMessage.getMsgId() <= j2) {
                    chatMessage.setHasRead(true);
                } else {
                    chatMessage.setHasRead(false);
                }
            }
        }
    }

    public final void L() {
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getUser() == null) {
            return;
        }
        long userIdLong = getUser().getUserIdLong();
        if (userIdLong == 0 || (i2 = c.a.t0.s1.k.b.o().i(getUser().getUserId(), 2)) == null) {
            return;
        }
        long H = H();
        if (H > i2.getSent_msgId()) {
            RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(c.a.t0.s1.w.b.c(H), userIdLong);
            if (MessageManager.getInstance().getSocketClient().o(requestPersonalMsgReadMessage)) {
                return;
            }
            MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f45233j) {
            L();
            this.f45233j = false;
        }
    }

    public void N(CardStatus cardStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cardStatus) == null) {
            this.f45231h = cardStatus;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f45230g = str;
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void deleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, chatMessage) == null) || this.mUser == null || chatMessage == null) {
            return;
        }
        n0.c(new a(this, chatMessage), null);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public ChatMessage genChatMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            personalChatMessage.setIsFriend(this.f45228e);
            personalChatMessage.setFollowStatus(this.f45229f);
            return personalChatMessage;
        }
        return (ChatMessage) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public MsglistModel.CacheInfo getCacheInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.mUser == null) {
                return null;
            }
            MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
            cacheInfo.id = this.mUser.getUserId();
            cacheInfo.customGroupType = 2;
            return cacheInfo;
        }
        return (MsglistModel.CacheInfo) invokeV.objValue;
    }

    public int getFollowStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f45229f : invokeV.intValue;
    }

    public int getIsFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f45228e : invokeV.intValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.a.t0.s1.k.b.o().p(String.valueOf(c.a.t0.s1.s.a.f22227i), -1) : invokeV.longValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mUser == null) {
                return false;
            }
            LoadDraftMessage.a aVar = new LoadDraftMessage.a();
            aVar.a = this.mUser.getUserId();
            super.sendMessage(new LoadPersonalDraftMessage(aVar));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(c.a.t0.s1.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cVar)) == null) {
            if (this.mUser == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.f45056c = 20;
            aVar.a = null;
            aVar.f45055b = null;
            aVar.f45057d = this.mUser.getUserIdLong() + "";
            LoadPersonalHistoryMessage loadPersonalHistoryMessage = new LoadPersonalHistoryMessage(aVar);
            loadPersonalHistoryMessage.setCallback(cVar);
            super.sendMessage(loadPersonalHistoryMessage);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.mUser == null) {
                return false;
            }
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.f45056c = 20;
            MsgPageData msgPageData = this.mDatas;
            long j3 = 0;
            if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j2 = 0;
            } else {
                j3 = this.mDatas.getChatMessages().get(0).getMsgId();
                j2 = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            aVar.a = String.valueOf(j3);
            aVar.f45055b = String.valueOf(j2);
            aVar.f45057d = this.mUser.getUserIdLong() + "";
            super.sendMessage(new LoadPersonalHistoryMessage(aVar));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, chatMessage) == null) || this.mUser == null || chatMessage == null) {
            return;
        }
        n0.c(new b(this, chatMessage), null);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean onAfterLoadFromDb() {
        InterceptResult invokeV;
        ImMessageCenterPojo i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (getUser() == null || (i2 = c.a.t0.s1.k.b.o().i(getUser().getUserId(), 2)) == null) {
                return false;
            }
            K(i2.getRead_msgId());
            L();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean onAfterProcessMsgFromServer() {
        InterceptResult invokeV;
        MsgPageData msgPageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f45232i == null || (msgPageData = this.mDatas) == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0 || c.a.t0.s1.w.c.p(this.f45232i)) {
                return false;
            }
            K(c.a.t0.s1.f.l.e.a(this.f45232i));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            unRegisterListener();
        }
    }

    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, customResponsedMessage) == null) && (customResponsedMessage instanceof GroupMsgData)) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                this.f45233j = false;
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof PersonalChatMessage) {
                        if (chatMessage.getMsgType() == 22) {
                            ChatMessage chatMessage2 = this.f45232i;
                            if (chatMessage2 == null) {
                                this.f45232i = chatMessage;
                            } else if (chatMessage2.getMsgId() < chatMessage.getMsgId()) {
                                this.f45232i = chatMessage;
                            }
                        } else if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            this.f45233j = true;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            registerListener(2012121, this.k);
            registerListener(2001143, this.k);
            registerListener(2001146, this.k);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            SaveDraftMessage.a aVar = new SaveDraftMessage.a();
            UserData userData = this.mUser;
            if (userData == null) {
                return false;
            }
            aVar.f45070b = String.valueOf(String.valueOf(userData.getUserId()));
            aVar.a = str;
            super.sendMessage(new PersonalSaveDraftMessage(aVar));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setFollowStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f45229f = i2;
        }
    }

    public void setIsFriend(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f45228e = i2;
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
            BdLog.i("see picUpLoading unregister");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MsglistActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new c(this, 0);
        registerListener();
        this.customGroupType = 2;
    }
}

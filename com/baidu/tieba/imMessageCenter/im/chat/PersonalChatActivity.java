package com.baidu.tieba.imMessageCenter.im.chat;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.i.a;
import c.a.o0.b1.h0;
import c.a.o0.b1.k0;
import c.a.o0.b1.n;
import c.a.p0.k1.a.e.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener addFriendStateChanged;
    public String curruntId;
    public c.a.e.c.g.c getLbsInfoListener;
    public CustomMessageListener getNewFriend;
    public CustomMessageListener joinGroupListener;
    public a.c locationCallBack;
    public PersonalMsglistModel mCurrentModel;
    public PersonalChatView mCurrentView;
    public Handler mHandler;
    public c.a.o0.t.f.b mLbs;
    public Runnable mRefreshTitleRunnable;
    public UserData mUser;
    public boolean sendFinishMessage;
    public long timeGrade;

    /* loaded from: classes7.dex */
    public class a implements AbsMsglistView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53029a;

        public a(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53029a = personalChatActivity;
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void b(VoiceData$VoiceModel voiceData$VoiceModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceData$VoiceModel) == null) || voiceData$VoiceModel == null) {
                return;
            }
            this.f53029a.mListModel.sendMsgVoice(voiceData$VoiceModel.voiceId, voiceData$VoiceModel.duration);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53030e;

        public b(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53030e = personalChatActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53030e.sendAutoMessage();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53031a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalChatActivity personalChatActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i2)};
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
            this.f53031a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                c.a.p0.j1.g.a data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus G = this.f53031a.mCurrentModel.G(data);
                this.f53031a.mCurrentModel.N(G);
                if (G != PersonalMsglistModel.CardStatus.AGREE) {
                    this.f53031a.mCurrentView.l(G, false, new String[0]);
                    return;
                }
                this.f53031a.mCurrentView.l(G, false, data.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53032e;

        public d(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53032e = personalChatActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53032e.mListView.refreshPersonalHeadFooter(this.f53032e.mUser.getName_show(), this.f53032e.mLbs);
                if (this.f53032e.timeGrade != 0) {
                    this.f53032e.mHandler.postDelayed(this.f53032e.mRefreshTitleRunnable, this.f53032e.timeGrade);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53033a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalChatActivity personalChatActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i2)};
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
            this.f53033a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001214 || this.f53033a.mListView == null || this.f53033a.mListView.getAdapter() == null) {
                return;
            }
            this.f53033a.mListView.getAdapter().g();
        }
    }

    /* loaded from: classes7.dex */
    public class f extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53034a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonalChatActivity personalChatActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53034a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                this.f53034a.mLbs = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (this.f53034a.mLbs == null || (user = ((PersonalMsglistModel) this.f53034a.mListModel).getUser()) == null) {
                    return;
                }
                this.f53034a.mListView.refreshPersonalHeadFooter(user.getName_show(), this.f53034a.mLbs);
                PersonalChatActivity personalChatActivity = this.f53034a;
                personalChatActivity.timeGrade = personalChatActivity.getTimeGrade(StringHelper.getTimeInterval(personalChatActivity.mLbs.c()));
                if (this.f53034a.timeGrade != 0) {
                    this.f53034a.mHandler.postDelayed(this.f53034a.mRefreshTitleRunnable, this.f53034a.timeGrade);
                }
                c.a.p0.k1.a.b.b.e b2 = PersonalChatActivityStatic.b();
                b2.a(this.f53034a.curruntId + "&" + user.getUserId(), new c.a.p0.k1.a.b.b.a(this.f53034a.mLbs, System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53035a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonalChatActivity personalChatActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i2)};
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
            this.f53035a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                return;
            }
            String cmd = p.getCmd();
            if (TextUtils.isEmpty(cmd)) {
                return;
            }
            String content = p.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject != null && optJSONObject.optLong("user_id") == c.a.e.e.m.b.f(this.f53035a.mCurrentModel.getUser().getUserId(), 0L)) {
                    String optString = optJSONObject.optString("message");
                    if (cmd.equals("apply_new_friend")) {
                        this.f53035a.mCurrentView.l(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                        this.f53035a.mCurrentModel.N(PersonalMsglistModel.CardStatus.AGREE);
                    } else if (cmd.equals("passed_new_friend")) {
                        this.f53035a.mCurrentView.l(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.f53035a.mCurrentModel.N(PersonalMsglistModel.CardStatus.PASS);
                        this.f53035a.mCurrentModel.setIsFriend(1);
                        this.f53035a.mCurrentModel.setFollowStatus(1);
                        this.f53035a.mCurrentView.getBtnGroupInfo().setVisibility(0);
                    } else if (cmd.equals("apply_add_friend")) {
                        this.f53035a.mCurrentView.l(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                        this.f53035a.mCurrentModel.N(PersonalMsglistModel.CardStatus.WAIT);
                    } else if (cmd.equals("apply_pass_friend")) {
                        this.f53035a.mCurrentView.l(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.f53035a.mCurrentModel.N(PersonalMsglistModel.CardStatus.PASS);
                        this.f53035a.mCurrentModel.setIsFriend(1);
                        this.f53035a.mCurrentModel.setFollowStatus(1);
                        this.f53035a.mCurrentView.getBtnGroupInfo().setVisibility(0);
                    }
                }
            } catch (JSONException e2) {
                BdLog.i(e2.getMessage());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53036a;

        public h(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53036a = personalChatActivity;
        }

        @Override // c.a.e.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) && i2 == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) this.f53036a.mListModel).getUser();
                if (user == null) {
                    return;
                }
                this.f53036a.mUser = user;
                this.f53036a.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f53037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53038b;

        public i(PersonalChatActivity personalChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53038b = personalChatActivity;
            this.f53037a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.o0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(c.a.p0.j1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f53037a.getUserId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53039a;

        public j(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53039a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.f53039a.mListView.closeNotNotify();
            } else {
                this.f53039a.mListView.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends h0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f53040a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalChatActivity f53041b;

        public k(PersonalChatActivity personalChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53041b = personalChatActivity;
            this.f53040a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.h0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.j1.t.e.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.f53040a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    public PersonalChatActivity() {
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
        this.getNewFriend = new c(this, 2001305);
        this.mHandler = new Handler();
        this.timeGrade = 0L;
        this.curruntId = TbadkCoreApplication.getCurrentAccount();
        this.mRefreshTitleRunnable = new d(this);
        this.joinGroupListener = new e(this, 2001214);
        this.getLbsInfoListener = new f(this, 205101, true);
        this.addFriendStateChanged = new g(this, 0);
        this.locationCallBack = new h(this);
        this.sendFinishMessage = false;
    }

    private boolean checkShowNotificationOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
            boolean g2 = c.a.o0.s.d0.b.j().g("key_private_chat_show_notification", false);
            if (areNotificationsEnabled || g2) {
                return false;
            }
            c.a.o0.t.h.a.f(getPageContext(), new boolean[]{true, false}, 3);
            c.a.o0.s.d0.b.j().t("key_private_chat_show_notification", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    private void dispatchFinishResponse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
        }
    }

    private void initCurId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel != null && (msglistModel instanceof PersonalMsglistModel)) {
                UserData user = ((PersonalMsglistModel) msglistModel).getUser();
                if (user != null) {
                    ChatStatusManager.getInst().setCurId(0, String.valueOf(user.getUserId()));
                    return;
                } else {
                    ChatStatusManager.getInst().setCurId(0, "");
                    return;
                }
            }
            ChatStatusManager.getInst().setCurId(0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAutoMessage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
        if (!c.a.e.e.p.k.isEmpty(stringExtra)) {
            getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            this.mListModel.sendExtraMessage(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
        if (c.a.e.e.p.k.isEmpty(stringExtra2) || stringExtra2.trim().length() <= 0) {
            return;
        }
        getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
        this.mListModel.sendTextMessage(stringExtra2);
    }

    private void sendCards() {
        boolean z;
        ChatMessage chatMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            Iterator<ChatMessage> it = this.mListModel.getData().getChatMessages().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                chatMessage = it.next();
                if (chatMessage.getMsgType() == 23) {
                    if (chatMessage.getLocalData().getStatus().shortValue() != 3) {
                        z = false;
                    }
                }
            }
            z = true;
            chatMessage = null;
            if (z) {
                return;
            }
            chatMessage.setSt_type("aio");
            this.mListModel.doSendText(chatMessage);
        }
    }

    private void showAddFriendStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || checkShowNotificationOpen()) {
            return;
        }
        super.finish();
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(c.a.p0.j1.f.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            this.mListModel.loadFirst(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    public PersonalMsglistModel getCurrentModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentModel : (PersonalMsglistModel) invokeV.objValue;
    }

    public long getTimeGrade(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            if (str.contains("分钟") || str.contains("刚刚")) {
                return 60000L;
            }
            if (str.contains("小时")) {
                return 3600000L;
            }
            return str.contains("天") ? 86400000L : 0L;
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public boolean initData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            try {
                registerListener(this.getLbsInfoListener);
                registerListener(2001172, this.addFriendStateChanged);
                registerListener(2001173, this.addFriendStateChanged);
                registerListener(2001219, this.addFriendStateChanged);
                registerListener(2001220, this.addFriendStateChanged);
                registerListener(2001221, this.addFriendStateChanged);
                registerListener(this.joinGroupListener);
                registerListener(this.getNewFriend);
                if (PersonalChatActivityStatic.b() == null) {
                    PersonalChatActivityStatic.d(new c.a.p0.k1.a.b.b.e());
                }
                PersonalMsglistModel personalMsglistModel = new PersonalMsglistModel(this);
                this.mListModel = personalMsglistModel;
                personalMsglistModel.setLoadDataCallBack(this.mMsgCallback);
                this.mCurrentModel = (PersonalMsglistModel) this.mListModel;
                if (bundle != null) {
                    initParam(bundle);
                } else {
                    initParam();
                }
                return checkParam();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mListView = new PersonalChatView(this, this.mListModel.getIsAcceptNotify());
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            this.mCurrentView = (PersonalChatView) this.mListView;
            long longValue = c.a.p0.j1.s.a.f20671i.longValue();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
                this.mUser = user;
                this.mListView.refreshPersonalHeadFooter(user.getName_show(), this.mLbs);
                this.mListView.bindDataAndRefresh(this.mListModel.getData(), longValue);
                this.mListView.setRecordCallback(new a(this));
                if (!isFriend()) {
                    showAddFriendStatus();
                }
                if (TextUtils.isEmpty(this.mCurrentModel.I())) {
                    return;
                }
                PersonalMsglistModel personalMsglistModel = this.mCurrentModel;
                personalMsglistModel.J(personalMsglistModel.I());
            }
        }
    }

    public boolean isFollow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ((PersonalMsglistModel) this.mListModel).getFollowStatus() == 1 : invokeV.booleanValue;
    }

    public boolean isFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ((PersonalMsglistModel) this.mListModel).getIsFriend() == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            super.onClick(view);
            if (view == this.mListView.getBtnGroupInfo()) {
                TiebaStatic.log("personal_chat_page_morebutton");
                MsglistModel msglistModel = this.mListModel;
                if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
                    if (user.getUserType() == 4) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                    } else {
                        sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                    }
                }
            } else if (view == this.mCurrentView.j()) {
                if (this.mCurrentModel.F() != PersonalMsglistModel.CardStatus.APPLY && this.mCurrentModel.F() != PersonalMsglistModel.CardStatus.WAIT) {
                    if (this.mCurrentModel.F() == PersonalMsglistModel.CardStatus.AGREE) {
                        c.a.o0.j0.a.a(c.a.e.e.m.b.f(this.mCurrentModel.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        TiebaStatic.eventStat(getActivity(), "add_fri_aio", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.mCurrentModel.getUser().getUserId(), this.mCurrentModel.getUser().getUserName(), this.mCurrentModel.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(0, "");
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mRefreshTitleRunnable);
            }
            c.a.e.e.i.a.l().q(this.locationCallBack);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onInitParam(bundle);
            initCurId();
            ((PersonalMsglistModel) this.mListModel).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
            ((PersonalMsglistModel) this.mListModel).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
            ((PersonalMsglistModel) this.mListModel).O(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, c.a.e.e.h.a
    public void onItemViewClick(View view, int i2, int i3, long j2) {
        ChatMessage msg;
        String f2;
        ChatMessage msg2;
        a.C0983a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.onItemViewClick(view, i2, i3, j2);
            if (i2 == 2) {
                ChatMessage msg3 = this.mListModel.getMsg(i3);
                if (msg3 == null || msg3.getUserInfo() == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName())));
            } else if (i2 != 4) {
                if (i2 != 14 || (msg2 = this.mListModel.getMsg(i3)) == null || msg2.getContent() == null || (a2 = c.a.p0.k1.a.e.a.a(msg2.getContent())) == null) {
                    return;
                }
                if (a2.f20972h == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(a2.f20969e, a2.f20970f, null, false)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a2.f20969e, a2.f20970f, null)));
                }
            } else if (isExStorageOk() && (msg = this.mListModel.getMsg(i3)) != null && c.a.p0.j1.w.c.s(msg) && (f2 = c.a.p0.j1.w.c.f(msg.getContent(), true)) != null) {
                MsglistModel msglistModel = this.mListModel;
                if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), f2, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg.getMsgId()))));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPageInited();
            this.handler.postDelayed(new b(this), 60L);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(0, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            if (!this.sendFinishMessage) {
                this.sendFinishMessage = true;
                dispatchFinishResponse();
            }
            ChatStatusManager.getInst().setIsOpen(0, true);
            String curId = ChatStatusManager.getInst().getCurId(0);
            c.a.o0.t.d.b.g0().s(curId);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel == null || !(msglistModel instanceof PersonalMsglistModel)) {
                return;
            }
            ((PersonalMsglistModel) msglistModel).M();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.mListModel).getIsFriend());
            bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.mListModel).I());
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.refreshHeadIcon();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
                k0.c(new i(this, user), new j(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, userData) == null) {
            k0.c(new k(this, userData), null);
        }
    }

    public void sendLbsMessage() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && TbadkCoreApplication.getInst().getLocationShared()) {
            String str = this.curruntId + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.b().b(str)) {
                c.a.e.e.i.a.l().i(true, this.locationCallBack);
                return;
            }
            c.a.o0.t.f.b c2 = PersonalChatActivityStatic.b().c(str);
            this.mListView.refreshPersonalHeadFooter(this.mUser.getName_show(), c2);
            long timeGrade = getTimeGrade(StringHelper.getTimeInterval(c2.c()));
            this.timeGrade = timeGrade;
            if (timeGrade != 0) {
                this.mHandler.postDelayed(this.mRefreshTitleRunnable, timeGrade);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void sendTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            sendCards();
            super.sendTextMsg();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            super.onInitParam(intent);
            initCurId();
            ((PersonalMsglistModel) this.mListModel).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
            ((PersonalMsglistModel) this.mListModel).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
            ((PersonalMsglistModel) this.mListModel).O(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
        }
    }
}

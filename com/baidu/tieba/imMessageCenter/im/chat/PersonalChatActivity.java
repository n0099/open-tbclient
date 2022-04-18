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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a97;
import com.repackage.ad5;
import com.repackage.b57;
import com.repackage.d87;
import com.repackage.dd5;
import com.repackage.dg;
import com.repackage.g75;
import com.repackage.gf;
import com.repackage.i97;
import com.repackage.ic5;
import com.repackage.jy4;
import com.repackage.m97;
import com.repackage.mg;
import com.repackage.ni;
import com.repackage.sy4;
import com.repackage.v77;
import com.repackage.v97;
import com.repackage.vt4;
import com.repackage.wx4;
import com.repackage.ya;
import com.repackage.z57;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener addFriendStateChanged;
    public String curruntId;
    public ya getLbsInfoListener;
    public CustomMessageListener getNewFriend;
    public CustomMessageListener joinGroupListener;
    public gf.c locationCallBack;
    public PersonalMsglistModel mCurrentModel;
    public PersonalChatView mCurrentView;
    public Handler mHandler;
    public jy4 mLbs;
    public Runnable mRefreshTitleRunnable;
    public UserData mUser;
    public CustomMessageListener overSelectToastListener;
    public boolean sendFinishMessage;
    public long timeGrade;

    /* loaded from: classes3.dex */
    public class a extends ad5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ PersonalChatActivity b;

        public a(PersonalChatActivity personalChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalChatActivity;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ad5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d87.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AbsMsglistView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public b(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.f
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) || voiceModel == null) {
                return;
            }
            this.a.mListModel.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public c(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.sendAutoMessage();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalChatActivity personalChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                z57 data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus I = this.a.mCurrentModel.I(data);
                this.a.mCurrentModel.R(I);
                if (I != PersonalMsglistModel.CardStatus.AGREE) {
                    this.a.mCurrentView.v(I, false, new String[0]);
                    return;
                }
                this.a.mCurrentView.v(I, false, data.a());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public e(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mListView.refreshPersonalHeadFooter(this.a.mUser.getName_show(), this.a.mLbs);
                if (this.a.timeGrade != 0) {
                    this.a.mHandler.postDelayed(this.a.mRefreshTitleRunnable, this.a.timeGrade);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonalChatActivity personalChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001214 || this.a.mListView == null || this.a.mListView.getAdapter() == null) {
                return;
            }
            this.a.mListView.getAdapter().g();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonalChatActivity personalChatActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UserData user;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
                this.a.mLbs = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
                if (this.a.mLbs == null || (user = ((PersonalMsglistModel) this.a.mListModel).getUser()) == null) {
                    return;
                }
                this.a.mListView.refreshPersonalHeadFooter(user.getName_show(), this.a.mLbs);
                PersonalChatActivity personalChatActivity = this.a;
                personalChatActivity.timeGrade = personalChatActivity.getTimeGrade(StringHelper.getTimeInterval(personalChatActivity.mLbs.c()));
                if (this.a.timeGrade != 0) {
                    this.a.mHandler.postDelayed(this.a.mRefreshTitleRunnable, this.a.timeGrade);
                }
                m97 b = PersonalChatActivityStatic.b();
                b.a(this.a.curruntId + "&" + user.getUserId(), new i97(this.a.mLbs, System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PersonalChatActivity personalChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this.a.getPageContext().getPageActivity());
            bdTopToast.i(false);
            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0a95));
            bdTopToast.j(this.a.mCurrentView.t());
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PersonalChatActivity personalChatActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
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
                if (optJSONObject != null && optJSONObject.optLong("user_id") == mg.g(this.a.mCurrentModel.getUser().getUserId(), 0L)) {
                    String optString = optJSONObject.optString("message");
                    if (cmd.equals("apply_new_friend")) {
                        this.a.mCurrentView.v(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                        this.a.mCurrentModel.R(PersonalMsglistModel.CardStatus.AGREE);
                    } else if (cmd.equals("passed_new_friend")) {
                        this.a.mCurrentView.v(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.a.mCurrentModel.R(PersonalMsglistModel.CardStatus.PASS);
                        this.a.mCurrentModel.setIsFriend(1);
                        this.a.mCurrentModel.setFollowStatus(1);
                        this.a.mCurrentView.getBtnGroupInfo().setVisibility(0);
                    } else if (cmd.equals("apply_add_friend")) {
                        this.a.mCurrentView.v(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                        this.a.mCurrentModel.R(PersonalMsglistModel.CardStatus.WAIT);
                    } else if (cmd.equals("apply_pass_friend")) {
                        this.a.mCurrentView.v(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.a.mCurrentModel.R(PersonalMsglistModel.CardStatus.PASS);
                        this.a.mCurrentModel.setIsFriend(1);
                        this.a.mCurrentModel.setFollowStatus(1);
                        this.a.mCurrentView.getBtnGroupInfo().setVisibility(0);
                    }
                }
            } catch (JSONException e) {
                BdLog.i(e.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements gf.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public j(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        @Override // com.repackage.gf.c
        public void a(int i, String str, Address address) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) && i == 0 && address != null) {
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                UserData user = ((PersonalMsglistModel) this.a.mListModel).getUser();
                if (user == null) {
                    return;
                }
                this.a.mUser = user;
                this.a.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends ad5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ PersonalChatActivity b;

        public k(PersonalChatActivity personalChatActivity, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalChatActivity;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.ad5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d87.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements ic5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public l(PersonalChatActivity personalChatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ic5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.a.mListView.closeNotNotify();
            } else {
                this.a.mListView.showNotNotfiy();
            }
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
        this.getNewFriend = new d(this, 2001305);
        this.mHandler = new Handler();
        this.timeGrade = 0L;
        this.curruntId = TbadkCoreApplication.getCurrentAccount();
        this.mRefreshTitleRunnable = new e(this);
        this.joinGroupListener = new f(this, 2001214);
        this.getLbsInfoListener = new g(this, 205101, true);
        this.overSelectToastListener = new h(this, 2921670);
        this.addFriendStateChanged = new i(this, 0);
        this.locationCallBack = new j(this);
        this.sendFinishMessage = false;
    }

    private boolean checkShowNotificationOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
            boolean h2 = vt4.k().h("key_private_chat_show_notification", false);
            if (areNotificationsEnabled || h2) {
                return false;
            }
            sy4.f(getPageContext(), new boolean[]{true, false}, 3);
            vt4.k().u("key_private_chat_show_notification", true);
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
        if (!ni.isEmpty(stringExtra)) {
            getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            this.mListModel.sendExtraMessage(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
        if (ni.isEmpty(stringExtra2) || stringExtra2.trim().length() <= 0) {
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

    public boolean checkUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (((PersonalMsglistModel) this.mListModel).getUser() == null || ((PersonalMsglistModel) this.mListModel).getUser().getUserIdLong() == 0) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || checkShowNotificationOpen()) {
            return;
        }
        super.finish();
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(b57 b57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b57Var)) == null) {
            this.mListModel.loadFirst(b57Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    public PersonalMsglistModel getCurrentModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurrentModel : (PersonalMsglistModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.if5
    public dg<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (dg) invokeV.objValue;
    }

    public long getTimeGrade(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundle)) == null) {
            try {
                registerListener(this.getLbsInfoListener);
                registerListener(2001172, this.addFriendStateChanged);
                registerListener(2001173, this.addFriendStateChanged);
                registerListener(2001219, this.addFriendStateChanged);
                registerListener(2001220, this.addFriendStateChanged);
                registerListener(2001221, this.addFriendStateChanged);
                registerListener(this.overSelectToastListener);
                registerListener(this.joinGroupListener);
                registerListener(this.getNewFriend);
                if (PersonalChatActivityStatic.b() == null) {
                    PersonalChatActivityStatic.d(new m97());
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mListView = new PersonalChatView(this, this.mListModel.getIsAcceptNotify());
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            this.mCurrentView = (PersonalChatView) this.mListView;
            long longValue = v77.i.longValue();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
                this.mUser = user;
                this.mListView.refreshPersonalHeadFooter(user.getName_show(), this.mLbs);
                this.mListView.bindDataAndRefresh(this.mListModel.getData(), longValue);
                this.mListView.setRecordCallback(new b(this));
                if (!isFriend()) {
                    showAddFriendStatus();
                }
                if (!TextUtils.isEmpty(this.mCurrentModel.L())) {
                    PersonalMsglistModel personalMsglistModel = this.mCurrentModel;
                    personalMsglistModel.N(personalMsglistModel.L());
                }
                TiebaStatic.log(new StatisticItem("c14573").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public boolean isFollow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ((PersonalMsglistModel) this.mListModel).getFollowStatus() == 1 : invokeV.booleanValue;
    }

    public boolean isFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ((PersonalMsglistModel) this.mListModel).getIsFriend() == 1 : invokeV.booleanValue;
    }

    public boolean isReportSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((PersonalMsglistModel) this.mListModel).J() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mListView.getBtnGroupInfo()) {
                if (((PersonalMsglistModel) this.mListModel).J()) {
                    TiebaStatic.log(new StatisticItem("c14578").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH, this.mCurrentView.s());
                    setResult(-1, intent);
                    finish();
                    return;
                }
                TiebaStatic.log("personal_chat_page_morebutton");
                MsglistModel msglistModel = this.mListModel;
                if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
                    if (user.getUserType() == 4) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                    } else {
                        sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                    }
                }
            } else if (view2 == this.mCurrentView.r()) {
                if (this.mCurrentModel.H() != PersonalMsglistModel.CardStatus.APPLY && this.mCurrentModel.H() != PersonalMsglistModel.CardStatus.WAIT) {
                    if (this.mCurrentModel.H() == PersonalMsglistModel.CardStatus.AGREE) {
                        g75.a(mg.g(this.mCurrentModel.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(0, "");
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mRefreshTitleRunnable);
            }
            gf.n().s(this.locationCallBack);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onInitParam(bundle);
            initCurId();
            ((PersonalMsglistModel) this.mListModel).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
            ((PersonalMsglistModel) this.mListModel).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
            ((PersonalMsglistModel) this.mListModel).S(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
            ((PersonalMsglistModel) this.mListModel).T(bundle.getBoolean(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT));
            ((PersonalMsglistModel) this.mListModel).setSelectList(bundle.getParcelableArrayList(PersonalChatActivityConfig.KEY_HAS_SELECT_MSG_LIST));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.repackage.ef
    public void onItemViewClick(View view2, int i2, int i3, long j2) {
        ChatMessage msg;
        ChatMessage msg2;
        String f2;
        ChatMessage msg3;
        v97.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.onItemViewClick(view2, i2, i3, j2);
            if (i2 == 2) {
                if (isReportSelect() || (msg = this.mListModel.getMsg(i3)) == null || msg.getUserInfo() == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg.getUserInfo().getUserId(), msg.getUserInfo().getUserName())));
            } else if (i2 != 4) {
                if (i2 != 14 || (msg3 = this.mListModel.getMsg(i3)) == null || msg3.getContent() == null || (a2 = v97.a(msg3.getContent())) == null) {
                    return;
                }
                if (a2.h == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(a2.e, a2.f, null, false)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a2.e, a2.f, null)));
                }
            } else if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i3)) != null && a97.s(msg2) && (f2 = a97.f(msg2.getContent(), true)) != null) {
                MsglistModel msglistModel = this.mListModel;
                if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                    return;
                }
                sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), f2, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPageInited();
            this.handler.postDelayed(new c(this), 60L);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(0, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            if (!this.sendFinishMessage) {
                this.sendFinishMessage = true;
                dispatchFinishResponse();
            }
            ChatStatusManager.getInst().setIsOpen(0, true);
            String curId = ChatStatusManager.getInst().getCurId(0);
            wx4.g0().s(curId);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel == null || !(msglistModel instanceof PersonalMsglistModel)) {
                return;
            }
            ((PersonalMsglistModel) msglistModel).Q();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.mListModel).getIsFriend());
            bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.mListModel).L());
            bundle.putBoolean(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, ((PersonalMsglistModel) this.mListModel).J());
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.refreshHeadIcon();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
                dd5.c(new k(this, user), new l(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, userData) == null) {
            dd5.c(new a(this, userData), null);
        }
    }

    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? ((PersonalMsglistModel) this.mListModel).M() : (ArrayList) invokeV.objValue;
    }

    public void sendLbsMessage() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && TbadkCoreApplication.getInst().getLocationShared()) {
            String str = this.curruntId + "&" + this.mUser.getUserId();
            if (!PersonalChatActivityStatic.b().b(str)) {
                gf.n().k(false, this.locationCallBack);
                return;
            }
            jy4 c2 = PersonalChatActivityStatic.b().c(str);
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
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            sendCards();
            super.sendTextMsg();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, intent) == null) {
            super.onInitParam(intent);
            initCurId();
            ((PersonalMsglistModel) this.mListModel).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
            ((PersonalMsglistModel) this.mListModel).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
            ((PersonalMsglistModel) this.mListModel).S(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
            ((PersonalMsglistModel) this.mListModel).T(intent.getBooleanExtra(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, false));
            ((PersonalMsglistModel) this.mListModel).setSelectList(intent.getParcelableArrayListExtra(PersonalChatActivityConfig.KEY_HAS_SELECT_MSG_LIST));
        }
    }
}

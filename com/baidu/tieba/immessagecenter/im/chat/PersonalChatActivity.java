package com.baidu.tieba.immessagecenter.im.chat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.GamePlayServiceData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.VirtualBarAssist;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.at8;
import com.baidu.tieba.bf8;
import com.baidu.tieba.bg;
import com.baidu.tieba.by5;
import com.baidu.tieba.cf8;
import com.baidu.tieba.cx5;
import com.baidu.tieba.ei;
import com.baidu.tieba.et8;
import com.baidu.tieba.fs5;
import com.baidu.tieba.gi8;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.IMUserListHttpReqMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.im.model.IceBreakEmotionModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.immessagecenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.immessagecenter.RequestNewFriendDataMessage;
import com.baidu.tieba.immessagecenter.im.model.GamePlayCanSendCardModel;
import com.baidu.tieba.immessagecenter.im.model.GamePlayServiceModel;
import com.baidu.tieba.immessagecenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.mh8;
import com.baidu.tieba.of5;
import com.baidu.tieba.oh8;
import com.baidu.tieba.oi8;
import com.baidu.tieba.re5;
import com.baidu.tieba.rs8;
import com.baidu.tieba.sj8;
import com.baidu.tieba.td8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wj8;
import com.baidu.tieba.xx5;
import com.baidu.tieba.zs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> implements VoiceManager.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rs8 A;
    public boolean B;
    public boolean C;
    public PersonalMsglistModel D;
    public PersonalChatView E;
    public IceBreakEmotionModel F;
    public IMUserListModel G;
    public VirtualBarAssist H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public VoiceManager O;
    public Runnable P;
    public CustomMessageListener Q;
    public CustomMessageListener R;
    public final CustomMessageListener S;

    /* renamed from: T  reason: collision with root package name */
    public final CustomMessageListener f1122T;
    public GamePlayServiceModel U;
    public String V;
    public GamePlayCanSendCardModel W;
    public GamePlayServiceData X;
    public final GamePlayServiceModel.a Y;
    public int Z;
    public String a0;
    public final GamePlayCanSendCardModel.a b0;
    public final Runnable c0;
    public final Runnable d0;
    public boolean e0;
    public HttpMessageListener f0;
    public CustomMessageListener v;
    public Handler w;
    public UserData x;
    public long y;
    public of5 z;

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tieba.h26
    public bg<ItemCardView> v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return null;
        }
        return (bg) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements GamePlayCanSendCardModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public a(PersonalChatActivity personalChatActivity) {
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

        @Override // com.baidu.tieba.immessagecenter.im.model.GamePlayCanSendCardModel.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                PersonalChatActivity personalChatActivity = this.a;
                personalChatActivity.Z = i;
                personalChatActivity.a0 = str;
                if ((personalChatActivity.b instanceof PersonalChatView) && this.a.w != null) {
                    this.a.w.post(this.a.d0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((PersonalChatView) this.a.b).T(this.a.X);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                PersonalChatActivity personalChatActivity = this.a;
                ((PersonalChatView) this.a.b).S(personalChatActivity.Z, personalChatActivity.a0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends xx5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ PersonalChatActivity b;

        public d(PersonalChatActivity personalChatActivity, UserData userData) {
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
        @Override // com.baidu.tieba.xx5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                oi8.a().saveToUserInfo(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements AbsMsglistView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void b(VoiceData.VoiceModel voiceModel) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) && voiceModel != null) {
                this.a.c.sendMsgVoice(voiceModel.getVoiceId(), voiceModel.getDuration());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public f(PersonalChatActivity personalChatActivity) {
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
                boolean k3 = this.a.k3();
                PersonalChatActivity personalChatActivity = this.a;
                personalChatActivity.N = personalChatActivity.h3();
                this.a.s3(true);
                boolean z = false;
                if (4 == this.a.getIntent().getIntExtra("key_from", 0)) {
                    z = true;
                }
                if (!k3) {
                    PersonalChatActivity personalChatActivity2 = this.a;
                    if (!personalChatActivity2.K && personalChatActivity2.N != -1 && !z) {
                        PersonalChatActivity personalChatActivity3 = this.a;
                        if (personalChatActivity3.J) {
                            personalChatActivity3.K = true;
                            personalChatActivity3.q3(personalChatActivity3.N);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public g(PersonalChatActivity personalChatActivity) {
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
                this.a.r3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements IceBreakEmotionModel.IceBreakRequestCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PersonalChatActivity b;

        public h(PersonalChatActivity personalChatActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalChatActivity;
            this.a = i;
        }

        @Override // com.baidu.tieba.im.model.IceBreakEmotionModel.IceBreakRequestCallback
        public void onSuccess(List<bf8> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                PersonalChatMessage personalChatMessage = new PersonalChatMessage();
                personalChatMessage.setIceBreakEmotions(list);
                if (!ListUtils.isEmpty(this.b.c.getData().getChatMessages())) {
                    personalChatMessage.setMsgId(this.b.c.getData().getChatMessages().get(this.b.c.getData().getChatMessages().size() - 1).getRecordId());
                }
                if (this.b.c.findIceBreakMsg() == null) {
                    this.b.c.getData().getChatMessages().add(this.a, personalChatMessage);
                    this.b.b.refreshNormalWithSelection(this.b.c.getData());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends HttpMessageListener {
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
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof IMUserListHttpResponseMsg)) {
                return;
            }
            IMUserListHttpResponseMsg iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage;
            HashMap<String, ImMessageCenterPojo> hashMap = iMUserListHttpResponseMsg.changedList;
            if (hashMap != null && !hashMap.isEmpty() && this.a.x != null && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(this.a.x.getUserId())) != null) {
                this.a.x.setName_show(imMessageCenterPojo.getNameShow());
                if (imMessageCenterPojo.getIsFriend() == 1) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (this.a.c instanceof PersonalMsglistModel) {
                    ((PersonalMsglistModel) this.a.c).setIsFriend(i);
                }
                if (this.a.b != null && this.a.b.getAdapter() != null) {
                    this.a.b.refreshPersonalHeadFooter(this.a.x.getName_show(), this.a.z);
                    this.a.b.getAdapter().g();
                }
                oh8.n().L(imMessageCenterPojo, false, 1);
            }
            if (!(httpResponsedMessage.getOrginalMessage() instanceof IMUserListHttpReqMessage) || !((IMUserListHttpReqMessage) httpResponsedMessage.getOrginalMessage()).hasCheckParam() || this.a.L) {
                return;
            }
            this.a.c3(iMUserListHttpResponseMsg.getUserDataResultList());
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PersonalChatActivity personalChatActivity, int i) {
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
                cf8 data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus W = this.a.D.W(data);
                this.a.D.f0(W);
                if (W == PersonalMsglistModel.CardStatus.AGREE) {
                    this.a.E.U(W, false, data.a());
                    return;
                }
                this.a.E.U(W, false, new String[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public k(PersonalChatActivity personalChatActivity) {
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
                this.a.b.refreshPersonalHeadFooter(this.a.x.getName_show(), this.a.z);
                if (this.a.y != 0) {
                    this.a.w.postDelayed(this.a.P, this.a.y);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PersonalChatActivity personalChatActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                new BdTopToast(this.a.getPageContext().getPageActivity()).setIcon(false).setContent(this.a.getString(R.string.obfuscated_res_0x7f0f0c6f)).show(this.a.E.Q());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(PersonalChatActivity personalChatActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
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
                    if (optJSONObject == null || optJSONObject.optLong("user_id") != JavaTypesHelper.toLong(this.a.D.getUser().getUserId(), 0L)) {
                        return;
                    }
                    String optString = optJSONObject.optString("message");
                    if (cmd.equals("apply_new_friend")) {
                        this.a.E.U(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                        this.a.D.f0(PersonalMsglistModel.CardStatus.AGREE);
                    } else if (cmd.equals("passed_new_friend")) {
                        this.a.E.U(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.a.D.f0(PersonalMsglistModel.CardStatus.PASS);
                        this.a.D.setIsFriend(1);
                        this.a.D.setFollowStatus(1);
                        this.a.E.getBtnGroupInfo().setVisibility(0);
                    } else if (cmd.equals("apply_add_friend")) {
                        this.a.E.U(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                        this.a.D.f0(PersonalMsglistModel.CardStatus.WAIT);
                    } else if (cmd.equals("apply_pass_friend")) {
                        this.a.E.U(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.a.D.f0(PersonalMsglistModel.CardStatus.PASS);
                        this.a.D.setIsFriend(1);
                        this.a.D.setFollowStatus(1);
                        this.a.E.getBtnGroupInfo().setVisibility(0);
                    }
                } catch (JSONException e) {
                    BdLog.i(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(PersonalChatActivity personalChatActivity, int i) {
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
            UpdateAttentionMessage.UpdateAttentionData data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && !TextUtils.isEmpty(data.toUid) && this.a.x != null && data.toUid.equals(this.a.x.getUserId()) && this.a.E != null) {
                sj8.a("关注状态变化 = " + data.isAttention);
                if (data.isAttention) {
                    this.a.E.hideFollowTip(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(PersonalChatActivity personalChatActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.E != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    PersonalChatActivity personalChatActivity = this.a;
                    BdUtilHelper.hideSoftKeyPad(personalChatActivity, personalChatActivity.getCurrentFocus());
                    this.a.E.hideMore();
                    this.a.E.showInputControlTouchInterceptView();
                    return;
                }
                this.a.E.hideInputControlTouchInterceptView();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends xx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ PersonalChatActivity b;

        public p(PersonalChatActivity personalChatActivity, UserData userData) {
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
        @Override // com.baidu.tieba.xx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(oi8.a().isAcceptNotify(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId())));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class q implements cx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public q(PersonalChatActivity personalChatActivity) {
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
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bool) != null) || bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                this.a.b.closeNotNotify();
            } else {
                this.a.b.showNotNotfiy();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements GamePlayServiceModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        public r(PersonalChatActivity personalChatActivity) {
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

        @Override // com.baidu.tieba.immessagecenter.im.model.GamePlayServiceModel.a
        public void a(GamePlayServiceData gamePlayServiceData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gamePlayServiceData) == null) {
                PersonalChatActivity personalChatActivity = this.a;
                personalChatActivity.X = gamePlayServiceData;
                if ((personalChatActivity.b instanceof PersonalChatView) && this.a.w != null) {
                    this.a.w.post(this.a.c0);
                }
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
        this.v = new j(this, 2001305);
        this.w = new Handler();
        this.y = 0L;
        TbadkCoreApplication.getCurrentAccount();
        this.B = false;
        this.C = false;
        this.J = true;
        this.N = -2;
        this.P = new k(this);
        this.Q = new l(this, 2921670);
        this.R = new m(this, 0);
        this.S = new n(this, 2001115);
        this.f1122T = new o(this, 2921720);
        this.Y = new r(this);
        this.b0 = new a(this);
        this.c0 = new b(this);
        this.d0 = new c(this);
        this.e0 = false;
        this.f0 = new i(this, CmdConfigHttp.CMD_GET_USER_LIST);
    }

    public void f3() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            long longValue = gi8.j.longValue();
            MsglistModel msglistModel = this.c;
            if (!(msglistModel instanceof PersonalMsglistModel) || (user = ((PersonalMsglistModel) msglistModel).getUser()) == null) {
                return;
            }
            this.x = user;
            this.V = user.getUserId();
            this.b.refreshPersonalHeadFooter(this.x.getName_show(), this.z);
            this.b.bindDataAndRefresh(this.c.getData(), longValue);
            if (!X1()) {
                p3();
            }
            if (!TextUtils.isEmpty(this.D.Z())) {
                PersonalMsglistModel personalMsglistModel = this.D;
                personalMsglistModel.b0(personalMsglistModel.Z());
            }
            if (g3()) {
                TiebaStatic.log(new StatisticItem("c14573").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (this.x != null) {
                TiebaStatic.log(new StatisticItem("c14626").param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.FRIEND_UID, this.x.getUserId()));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean U1(td8 td8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, td8Var)) == null) {
            this.c.loadFirst(td8Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void i2(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, userData) == null) {
            by5.c(new d(this, userData), null);
        }
    }

    public final void m3(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048605, this, j2) == null) && j2 > 0) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putBoolean("im_ice_break_msg_is_closed_" + j2, true);
            N1();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            ViewGroup Q = this.E.Q();
            if (Q != null) {
                SkinManager.setBackgroundColor(Q, R.color.CAM_X0201);
            }
            UtilHelper.setNavigationBarBg(this, SkinManager.getColor(R.color.CAM_X0201));
            AbsMsglistView absMsglistView = this.b;
            if (absMsglistView != null) {
                absMsglistView.onChangeSkinType(i2);
            }
        }
    }

    public final void q3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            sj8.a("触发展示破冰表情：showBreakIceEmotions");
            if (this.F == null) {
                IceBreakEmotionModel iceBreakEmotionModel = new IceBreakEmotionModel(getPageContext());
                this.F = iceBreakEmotionModel;
                iceBreakEmotionModel.setRequestCallback(new h(this, i2));
            }
            this.F.request();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void A1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int loadDataMode = this.c.getLoadDataMode();
            if (this.c.getData().getIsNewAdd() && this.c.getData().getNewAddNum() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (loadDataMode == 1) {
                z = this.B;
            } else if (loadDataMode == 4) {
                z = true;
            } else if (loadDataMode != 3) {
                if (loadDataMode == 5) {
                    if (!this.I && X1()) {
                        this.I = true;
                        if (getIntent() != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921700, new int[]{getIntent().getIntExtra("last_page_unique_id", 0), 2}));
                        }
                    }
                } else if (loadDataMode == 9) {
                    String draft = this.c.getDraft();
                    if (draft == null) {
                        n3();
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(draft);
                            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, "");
                            String optString2 = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, "");
                            if (TextUtils.isEmpty(optString) || (TextUtils.equals(optString, TbEnum.ChatInputStatus.INPUT_STATUS_TEXT) && TextUtils.isEmpty(optString2))) {
                                n3();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                z = false;
            }
            if (z) {
                this.B = false;
                if (TbadkCoreApplication.getInst().getCurrentActivity() != this) {
                    this.C = true;
                } else {
                    W2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.O == null) {
                VoiceManager voiceManager = new VoiceManager();
                this.O = voiceManager;
                voiceManager.setIsUseMediaPlayer(true);
                this.O.onCreate(getPageContext());
            }
            return this.O;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l3();
            super.S1();
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.A == null) {
                this.A = new rs8();
            }
            this.A.a(this.D, getListView());
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (((PersonalMsglistModel) this.c).getIsFriend() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (((PersonalMsglistModel) this.c).getUser() != null && ((PersonalMsglistModel) this.c).getUser().getUserIdLong() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b = new PersonalChatView(this, this.c.getIsAcceptNotify());
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.Z1();
            this.a.postDelayed(new f(this), 60L);
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void a2() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.a2();
            MsglistModel msglistModel = this.c;
            if (!(msglistModel instanceof CommonPersonalMsglistModel) || (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) == null) {
                return;
            }
            by5.c(new p(this, user), new q(this));
        }
    }

    public PersonalMsglistModel a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.D;
        }
        return (PersonalMsglistModel) invokeV.objValue;
    }

    public boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ((PersonalMsglistModel) this.c).X();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Resources resources = super.getResources();
            if (resources != null) {
                TbDimenManager tbDimenManager = TbDimenManager.getInstance();
                tbDimenManager.setDensity(resources.getDisplayMetrics(), tbDimenManager.getDefaultDensity(), tbDimenManager.getDefaultDensityDpi());
            }
            return resources;
        }
        return (Resources) invokeV.objValue;
    }

    public ArrayList<ReportPrivateMsgData> j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return ((PersonalMsglistModel) this.c).a0();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(0, false);
            VirtualBarAssist virtualBarAssist = this.H;
            if (virtualBarAssist != null) {
                virtualBarAssist.onPause();
            }
            VoiceManager R0 = R0();
            this.O = R0;
            if (R0 != null) {
                R0.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onStart();
            VoiceManager R0 = R0();
            this.O = R0;
            if (R0 != null) {
                R0.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStop();
            VoiceManager R0 = R0();
            this.O = R0;
            if (R0 != null) {
                R0.onStop(getPageContext());
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            sendMessage(new RequestNewFriendDataMessage(this.x.getUserIdLong()));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean W1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            try {
                registerListener(2001172, this.R);
                registerListener(2001173, this.R);
                registerListener(2001219, this.R);
                registerListener(2001220, this.R);
                registerListener(2001221, this.R);
                registerListener(this.Q);
                registerListener(this.v);
                registerListener(this.f0);
                registerListener(this.S);
                registerListener(this.f1122T);
                if (PersonalChatActivityStatic.b() == null) {
                    PersonalChatActivityStatic.d(new zs8());
                }
                PersonalMsglistModel personalMsglistModel = new PersonalMsglistModel(this);
                this.c = personalMsglistModel;
                personalMsglistModel.setLoadDataCallBack(this.r);
                this.D = (PersonalMsglistModel) this.c;
                this.G = new IMUserListModel(getPageContext(), getUniqueId());
                if (getIntent() != null) {
                    this.D.setFrom(getIntent().getIntExtra("key_from", 0));
                }
                if (!this.u) {
                    if (bundle != null) {
                        f2(bundle);
                    } else {
                        e2();
                    }
                    if (!d2()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public String b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!X2()) {
                return "";
            }
            return ((PersonalMsglistModel) this.c).getUser().getUserIdLong() + "";
        }
        return (String) invokeV.objValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MsglistModel msglistModel = this.c;
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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Y2();
            this.b.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            AbsMsglistView absMsglistView = this.b;
            this.E = (PersonalChatView) absMsglistView;
            absMsglistView.setRecordCallback(new e(this));
            if (!this.u) {
                f3();
            }
        }
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_DEFAULT_DRAFT);
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, stringExtra);
            hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, TbEnum.ChatInputStatus.INPUT_STATUS_TEXT);
            String jsonStrWithObject = OrmObject.jsonStrWithObject((AbsMsglistView.DraftContent) OrmObject.objectWithMap(hashMap, AbsMsglistView.DraftContent.class));
            this.b.setDraft(jsonStrWithObject);
            this.c.setDraft(jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onResume();
            if (!this.e0) {
                this.e0 = true;
                Z2();
            }
            if (!this.u) {
                resume();
            }
            VirtualBarAssist virtualBarAssist = this.H;
            if (virtualBarAssist != null) {
                virtualBarAssist.onResume();
            }
            VoiceManager R0 = R0();
            this.O = R0;
            if (R0 != null) {
                R0.onResume(getPageContext());
            }
        }
    }

    public final void c3(List<com.baidu.tbadk.data.UserData> list) {
        UserData userData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, list) == null) && list != null && (userData = this.x) != null && !TextUtils.isEmpty(userData.getUserId())) {
            for (com.baidu.tbadk.data.UserData userData2 : list) {
                if (this.x.getUserId().equals(userData2.getUserId())) {
                    this.L = true;
                    this.x.setRelation(userData2.getRelation());
                    this.x.setRelationReal(userData2.getRelationReal());
                    this.x.setIsBlocked(userData2.getIsBlocked());
                    this.x.setCanChat(userData2.getCanChat());
                    this.E.initFollowTip(this.x);
                    this.b.getAdapter().m(this.x.isRelationReal());
                    s3(false);
                    return;
                }
            }
        }
    }

    public final boolean d3(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048591, this, j2)) == null) {
            if (j2 <= 0) {
                return false;
            }
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            return sharedPrefHelper.getBoolean("im_ice_break_msg_is_closed_" + j2, false);
        }
        return invokeJ.booleanValue;
    }

    public void o3(@NonNull UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, userData) == null) {
            this.u = false;
            Intent intent = new Intent();
            intent.putExtra("user", userData);
            this.c.reset();
            g2(intent);
            this.b.getAdapter().o(true);
            f3();
            this.c.loadFirst(this);
            resume();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            super.onCreate(bundle);
            GamePlayServiceModel gamePlayServiceModel = new GamePlayServiceModel();
            this.U = gamePlayServiceModel;
            gamePlayServiceModel.loadGodInfo(this.V, this.Y);
            GamePlayCanSendCardModel gamePlayCanSendCardModel = new GamePlayCanSendCardModel();
            this.W = gamePlayCanSendCardModel;
            gamePlayCanSendCardModel.loadSendCardFromServer(this.V, this.b0);
            this.O = R0();
        }
    }

    public final void s3(boolean z) {
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && this.N >= -1 && this.L && !this.M && i3()) {
            this.M = true;
            Handler handler = this.a;
            g gVar = new g(this);
            if (z) {
                j2 = 0;
            } else {
                j2 = 61;
            }
            handler.postDelayed(gVar, j2);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void g2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            super.g2(intent);
            e3();
            ((PersonalMsglistModel) this.c).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
            ((PersonalMsglistModel) this.c).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
            ((PersonalMsglistModel) this.c).g0(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
            ((PersonalMsglistModel) this.c).h0(intent.getBooleanExtra(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, false));
            ((PersonalMsglistModel) this.c).setSelectList(intent.getParcelableArrayListExtra(PersonalChatActivityConfig.KEY_HAS_SELECT_MSG_LIST));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void h2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.h2(bundle);
            e3();
            ((PersonalMsglistModel) this.c).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
            ((PersonalMsglistModel) this.c).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
            ((PersonalMsglistModel) this.c).g0(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
            ((PersonalMsglistModel) this.c).h0(bundle.getBoolean(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT));
            ((PersonalMsglistModel) this.c).setSelectList(bundle.getParcelableArrayList(PersonalChatActivityConfig.KEY_HAS_SELECT_MSG_LIST));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.c).getIsFriend());
            bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.c).Z());
            bundle.putBoolean(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, ((PersonalMsglistModel) this.c).X());
            VoiceManager R0 = R0();
            this.O = R0;
            if (R0 != null) {
                R0.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final int h3() {
        InterceptResult invokeV;
        UserData userData;
        List<ChatMessage> chatMessages;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            MsglistModel msglistModel = this.c;
            if (msglistModel == null || msglistModel.getData() == null || (userData = this.x) == null || d3(JavaTypesHelper.toLong(userData.getUserId(), 0L)) || this.c.findIceBreakMsg() != null || (chatMessages = this.c.getData().getChatMessages()) == null) {
                return -1;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < chatMessages.size(); i3++) {
                ChatMessage chatMessage = chatMessages.get(i3);
                if (chatMessage.getUserId() == TbadkCoreApplication.getCurrentAccountId()) {
                    return -1;
                }
                if (chatMessage.getMsgType() == 30) {
                    i2 = i3 + 1;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && !this.x.canChat()) {
            sj8.a("触发展示陌生人提示");
            PersonalChatMessage personalChatMessage = new PersonalChatMessage();
            personalChatMessage.setMsgType(8001);
            personalChatMessage.setUserInfo(this.x);
            int i2 = this.N + 1;
            if (i2 > this.c.getData().size()) {
                this.c.getData().getChatMessages().add(personalChatMessage);
            } else {
                this.c.getData().getChatMessages().add(i2, personalChatMessage);
            }
            this.b.refreshNormal(this.c.getData());
            this.b.setSelectionFocusDown();
        }
    }

    public void resume() {
        IMUserListModel iMUserListModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            boolean z = true;
            ChatStatusManager.getInst().setIsOpen(0, true);
            String curId = ChatStatusManager.getInst().getCurId(0);
            ImMessageCenterPojo h2 = oh8.n().h(curId, 2);
            if (h2 != null) {
                if (h2.getUnread_count() <= 0) {
                    z = false;
                }
                this.B = z;
            }
            if (this.C) {
                this.C = false;
                W2();
            }
            re5.p0().r(curId);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
            MsglistModel msglistModel = this.c;
            if (msglistModel != null && (msglistModel instanceof PersonalMsglistModel)) {
                ((PersonalMsglistModel) msglistModel).e0();
            }
            UserData userData = this.x;
            if (userData != null && !TextUtils.isEmpty(userData.getUserId()) && (iMUserListModel = this.G) != null) {
                iMUserListModel.requestFroChatActivity(this.x);
            }
        }
    }

    public final boolean i3() {
        InterceptResult invokeV;
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            MsglistModel msglistModel = this.c;
            if (msglistModel == null || msglistModel.getData() == null || (userData = this.x) == null || !(this.c instanceof PersonalMsglistModel) || userData.getRelation() == 1) {
                return false;
            }
            List<ChatMessage> chatMessages = this.c.getData().getChatMessages();
            if (chatMessages != null) {
                for (int i2 = 0; i2 < chatMessages.size(); i2++) {
                    ChatMessage chatMessage = chatMessages.get(i2);
                    if (chatMessage.getUserId() > 0 && chatMessage.getUserId() != TbadkCoreApplication.getCurrentAccountId()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            boolean z = false;
            if (getIntent() == null) {
                return false;
            }
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!ei.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.c.sendExtraMessage(stringExtra);
                z = true;
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!ei.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.c.sendTextMessage(stringExtra2);
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void l3() {
        boolean z;
        ChatMessage chatMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            Iterator<ChatMessage> it = this.c.getData().getChatMessages().iterator();
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
            if (!z) {
                chatMessage.setSt_type("aio");
                this.c.doSendText(chatMessage);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(0, "");
            Handler handler = this.w;
            if (handler != null) {
                handler.removeCallbacks(this.P);
                this.w.removeCallbacks(this.c0);
                this.w.removeCallbacks(this.d0);
            }
            VirtualBarAssist virtualBarAssist = this.H;
            if (virtualBarAssist != null) {
                virtualBarAssist.onDestroy();
            }
            GamePlayServiceModel gamePlayServiceModel = this.U;
            if (gamePlayServiceModel != null) {
                gamePlayServiceModel.release();
                this.U = null;
            }
            GamePlayCanSendCardModel gamePlayCanSendCardModel = this.W;
            if (gamePlayCanSendCardModel != null) {
                gamePlayCanSendCardModel.release();
                this.W = null;
            }
            VoiceManager R0 = R0();
            this.O = R0;
            if (R0 != null) {
                R0.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.b.getBtnGroupInfo()) {
                if (((PersonalMsglistModel) this.c).X()) {
                    TiebaStatic.log(new StatisticItem("c14578").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH, this.E.P());
                    setResult(-1, intent);
                    finish();
                    return;
                }
                TiebaStatic.log("personal_chat_page_morebutton");
                MsglistModel msglistModel = this.c;
                if (!(msglistModel instanceof PersonalMsglistModel) || (user = ((PersonalMsglistModel) msglistModel).getUser()) == null) {
                    return;
                }
                if (user.getUserType() == 4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                    return;
                }
                sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                at8.a("c14627");
            } else if (view2 == this.E.O()) {
                if (this.D.V() != PersonalMsglistModel.CardStatus.APPLY && this.D.V() != PersonalMsglistModel.CardStatus.WAIT) {
                    if (this.D.V() == PersonalMsglistModel.CardStatus.AGREE) {
                        fs5.a(JavaTypesHelper.toLong(this.D.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.D.getUser().getUserId(), this.D.getUser().getUserName(), this.D.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tieba.gf
    public void y(View view2, int i2, int i3, long j2) {
        ChatMessage msg;
        ChatMessage msg2;
        String l2;
        et8.a a2;
        ChatMessage findIceBreakMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.y(view2, i2, i3, j2);
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 14) {
                        if (i2 != 18) {
                            if (i2 == 19 && !mh8.a(this) && (findIceBreakMsg = this.c.findIceBreakMsg()) != null && !ListUtils.isEmpty(findIceBreakMsg.getIceBreakEmotions()) && findIceBreakMsg.getIceBreakEmotions().size() > j2) {
                                bf8 bf8Var = findIceBreakMsg.getIceBreakEmotions().get((int) j2);
                                this.c.sendIceBreakEmotion(bf8Var.a, bf8Var.b, bf8Var.c, bf8Var.d);
                                return;
                            }
                            return;
                        }
                        UserData userData = this.x;
                        if (userData != null) {
                            m3(JavaTypesHelper.toLong(userData.getUserId(), 0L));
                            return;
                        }
                        return;
                    }
                    ChatMessage msg3 = this.c.getMsg(i3);
                    if (msg3 != null && msg3.getContent() != null && (a2 = et8.a(msg3.getContent())) != null) {
                        if (a2.h == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(a2.e, a2.f, null, false)));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a2.e, a2.f, null)));
                        }
                    }
                } else if (!H1() || (msg2 = this.c.getMsg(i3)) == null || !wj8.D(msg2) || (l2 = wj8.l(msg2.getContent(), true)) == null) {
                } else {
                    MsglistModel msglistModel = this.c;
                    if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                        return;
                    }
                    sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), l2, ((CommonPersonalMsglistModel) this.c).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
                }
            } else if (g3() || (msg = this.c.getMsg(i3)) == null || msg.getUserInfo() == null) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg.getUserInfo().getUserId(), msg.getUserInfo().getUserName())));
            }
        }
    }
}

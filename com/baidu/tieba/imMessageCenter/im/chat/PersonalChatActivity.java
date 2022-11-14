package com.baidu.tieba.imMessageCenter.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.permissions.PermissionsHelperActivity;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.VirtualBarAssist;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.aa7;
import com.baidu.tieba.ff7;
import com.baidu.tieba.id7;
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
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.model.GamePlayServiceModel;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.jb7;
import com.baidu.tieba.kb7;
import com.baidu.tieba.l35;
import com.baidu.tieba.mc7;
import com.baidu.tieba.nf7;
import com.baidu.tieba.nj5;
import com.baidu.tieba.of7;
import com.baidu.tieba.og;
import com.baidu.tieba.pc7;
import com.baidu.tieba.py4;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qd7;
import com.baidu.tieba.re7;
import com.baidu.tieba.rj5;
import com.baidu.tieba.sf7;
import com.baidu.tieba.si5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.we7;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.tieba.z35;
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
/* loaded from: classes4.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ff7 A;
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
    public Runnable O;
    public CustomMessageListener P;
    public CustomMessageListener Q;
    public CustomMessageListener R;
    public final CustomMessageListener S;
    public final CustomMessageListener T;
    public GamePlayServiceModel U;
    public String V;
    public GamePlayServiceData W;
    public final GamePlayServiceModel.a X;
    public final Runnable Y;
    public boolean Z;
    public HttpMessageListener a0;
    public CustomMessageListener v;
    public Handler w;
    public UserData x;
    public long y;
    public z35 z;

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tieba.an5
    public og<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements GamePlayServiceModel.a {
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

        @Override // com.baidu.tieba.imMessageCenter.im.model.GamePlayServiceModel.a
        public void a(GamePlayServiceData gamePlayServiceData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gamePlayServiceData) == null) {
                PersonalChatActivity personalChatActivity = this.a;
                personalChatActivity.W = gamePlayServiceData;
                if ((personalChatActivity.b instanceof PersonalChatView) && this.a.w != null) {
                    this.a.w.post(this.a.Y);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                ((PersonalChatView) this.a.b).D(this.a.W);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends nj5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ PersonalChatActivity b;

        public c(PersonalChatActivity personalChatActivity, UserData userData) {
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
        @Override // com.baidu.tieba.nj5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qd7.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsMsglistView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public d(PersonalChatActivity personalChatActivity) {
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
                this.a.c.sendMsgVoice(voiceModel.voiceId, voiceModel.duration);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                boolean H2 = this.a.H2();
                PersonalChatActivity personalChatActivity = this.a;
                personalChatActivity.N = personalChatActivity.E2();
                this.a.P2(true);
                boolean z = false;
                if (4 == this.a.getIntent().getIntExtra("key_from", 0)) {
                    z = true;
                }
                if (!H2) {
                    PersonalChatActivity personalChatActivity2 = this.a;
                    if (!personalChatActivity2.K && personalChatActivity2.N != -1 && !z) {
                        PersonalChatActivity personalChatActivity3 = this.a;
                        if (personalChatActivity3.J) {
                            personalChatActivity3.K = true;
                            personalChatActivity3.N2(personalChatActivity3.N);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.O2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements IceBreakEmotionModel.IceBreakRequestCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PersonalChatActivity b;

        public g(PersonalChatActivity personalChatActivity, int i) {
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
        public void onSuccess(List<jb7> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                PersonalChatMessage personalChatMessage = new PersonalChatMessage();
                personalChatMessage.setIceBreakEmotions(list);
                if (!ListUtils.isEmpty(this.b.c.getData().getChatMessages())) {
                    personalChatMessage.setMsgId(this.b.c.getData().getChatMessages().get(this.b.c.getData().getChatMessages().size() - 1).getRecordId());
                }
                if (this.b.c.findIceBreakMsg() == null) {
                    this.b.c.getData().getChatMessages().add(this.a, personalChatMessage);
                    this.b.b.refreshNormal(this.b.c.getData());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends HttpMessageListener {
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
                pc7.o().O(imMessageCenterPojo, false, 1);
            }
            if (!(httpResponsedMessage.getOrginalMessage() instanceof IMUserListHttpReqMessage) || !((IMUserListHttpReqMessage) httpResponsedMessage.getOrginalMessage()).hasCheckParam() || this.a.L) {
                return;
            }
            this.a.y2(iMUserListHttpResponseMsg.getUserDataResultList());
        }
    }

    /* loaded from: classes4.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof ResponseNewFriendDataMessage)) {
                kb7 data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus J = this.a.D.J(data);
                this.a.D.S(J);
                if (J == PersonalMsglistModel.CardStatus.AGREE) {
                    this.a.E.E(J, false, data.a());
                    return;
                }
                this.a.E.E(J, false, new String[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.refreshPersonalHeadFooter(this.a.x.getName_show(), this.a.z);
                if (this.a.y != 0) {
                    this.a.w.postDelayed(this.a.O, this.a.y);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PersonalChatActivity personalChatActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001214 && this.a.b != null && this.a.b.getAdapter() != null) {
                this.a.b.getAdapter().g();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                BdTopToast bdTopToast = new BdTopToast(this.a.getPageContext().getPageActivity());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0adb));
                bdTopToast.i(this.a.E.B());
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if (optJSONObject == null || optJSONObject.optLong("user_id") != xg.g(this.a.D.getUser().getUserId(), 0L)) {
                        return;
                    }
                    String optString = optJSONObject.optString("message");
                    if (cmd.equals("apply_new_friend")) {
                        this.a.E.E(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                        this.a.D.S(PersonalMsglistModel.CardStatus.AGREE);
                    } else if (cmd.equals("passed_new_friend")) {
                        this.a.E.E(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.a.D.S(PersonalMsglistModel.CardStatus.PASS);
                        this.a.D.setIsFriend(1);
                        this.a.D.setFollowStatus(1);
                        this.a.E.getBtnGroupInfo().setVisibility(0);
                    } else if (cmd.equals("apply_add_friend")) {
                        this.a.E.E(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                        this.a.D.S(PersonalMsglistModel.CardStatus.WAIT);
                    } else if (cmd.equals("apply_pass_friend")) {
                        this.a.E.E(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.a.D.S(PersonalMsglistModel.CardStatus.PASS);
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

    /* loaded from: classes4.dex */
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
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && (data = ((UpdateAttentionMessage) customResponsedMessage).getData()) != null && !TextUtils.isEmpty(data.c) && this.a.x != null && data.c.equals(this.a.x.getUserId()) && this.a.E != null) {
                re7.a("关注状态变化 = " + data.d);
                if (data.d) {
                    this.a.E.hideFollowTip(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    yi.z(personalChatActivity, personalChatActivity.getCurrentFocus());
                    this.a.E.hideMore();
                    this.a.E.showInputControlTouchInterceptView();
                    return;
                }
                this.a.E.hideInputControlTouchInterceptView();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends nj5<Boolean> {
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
        @Override // com.baidu.tieba.nj5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(qd7.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId())));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements si5<Boolean> {
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
        @Override // com.baidu.tieba.si5
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
        this.v = new i(this, 2001305);
        this.w = new Handler();
        this.y = 0L;
        TbadkCoreApplication.getCurrentAccount();
        this.B = false;
        this.C = false;
        this.J = true;
        this.N = -2;
        this.O = new j(this);
        this.P = new k(this, 2001214);
        this.Q = new l(this, 2921670);
        this.R = new m(this, 0);
        this.S = new n(this, 2001115);
        this.T = new o(this, 2921720);
        this.X = new a(this);
        this.Y = new b(this);
        this.Z = false;
        this.a0 = new h(this, CmdConfigHttp.CMD_GET_USER_LIST);
    }

    public final int E2() {
        InterceptResult invokeV;
        UserData userData;
        List<ChatMessage> chatMessages;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            MsglistModel msglistModel = this.c;
            if (msglistModel == null || msglistModel.getData() == null || (userData = this.x) == null || z2(xg.g(userData.getUserId(), 0L)) || this.c.findIceBreakMsg() != null || (chatMessages = this.c.getData().getChatMessages()) == null) {
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

    public final void O2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.x.canChat()) {
            re7.a("触发展示陌生人提示");
            PersonalChatMessage personalChatMessage = new PersonalChatMessage();
            personalChatMessage.setMsgType(PermissionsHelperActivity.b);
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
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            boolean z = true;
            ChatStatusManager.getInst().setIsOpen(0, true);
            String curId = ChatStatusManager.getInst().getCurId(0);
            ImMessageCenterPojo i2 = pc7.o().i(curId, 2);
            if (i2 != null) {
                if (i2.getUnread_count() <= 0) {
                    z = false;
                }
                this.B = z;
            }
            if (this.C) {
                this.C = false;
                t2();
            }
            l35.h0().r(curId);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
            MsglistModel msglistModel = this.c;
            if (msglistModel != null && (msglistModel instanceof PersonalMsglistModel)) {
                ((PersonalMsglistModel) msglistModel).R();
            }
            UserData userData = this.x;
            if (userData != null && !TextUtils.isEmpty(userData.getUserId()) && (iMUserListModel = this.G) != null) {
                iMUserListModel.requestFroChatActivity(this.x);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void F1(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, userData) == null) {
            rj5.c(new c(this, userData), null);
        }
    }

    public final void J2(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) && j2 > 0) {
            py4 k2 = py4.k();
            k2.u("im_ice_break_msg_is_closed_" + j2, true);
            l1();
        }
    }

    public final void N2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            re7.a("触发展示破冰表情：showBreakIceEmotions");
            if (this.F == null) {
                IceBreakEmotionModel iceBreakEmotionModel = new IceBreakEmotionModel(getPageContext());
                this.F = iceBreakEmotionModel;
                iceBreakEmotionModel.setRequestCallback(new g(this, i2));
            }
            this.F.request();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            if (C2() && this.H == null) {
                this.H = VirtualBarAssist.assistActivity(this);
            }
            GamePlayServiceModel gamePlayServiceModel = new GamePlayServiceModel();
            this.U = gamePlayServiceModel;
            gamePlayServiceModel.loadGodInfo(this.V, this.X);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean r1(aa7 aa7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, aa7Var)) == null) {
            this.c.loadFirst(aa7Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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

    public void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_DEFAULT_DRAFT);
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, stringExtra);
            hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, TbEnum.ChatInputStatus.INPUT_STATUS_TEXT);
            String jsonStrWithObject = OrmObject.jsonStrWithObject((AbsMsglistView.DraftContent) OrmObject.objectWithMap(hashMap, AbsMsglistView.DraftContent.class));
            this.b.setDraft(jsonStrWithObject);
            this.c.setDraft(jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            v2();
            this.b.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            AbsMsglistView absMsglistView = this.b;
            this.E = (PersonalChatView) absMsglistView;
            absMsglistView.setRecordCallback(new d(this));
            if (!this.u) {
                B2();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(0, "");
            Handler handler = this.w;
            if (handler != null) {
                handler.removeCallbacks(this.O);
                this.w.removeCallbacks(this.Y);
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
        }
    }

    public void B2() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long longValue = id7.j.longValue();
            MsglistModel msglistModel = this.c;
            if (!(msglistModel instanceof PersonalMsglistModel) || (user = ((PersonalMsglistModel) msglistModel).getUser()) == null) {
                return;
            }
            this.x = user;
            this.V = user.getUserId();
            this.b.refreshPersonalHeadFooter(this.x.getName_show(), this.z);
            this.b.bindDataAndRefresh(this.c.getData(), longValue);
            if (!t1()) {
                M2();
            }
            if (!TextUtils.isEmpty(this.D.M())) {
                PersonalMsglistModel personalMsglistModel = this.D;
                personalMsglistModel.O(personalMsglistModel.M());
            }
            if (D2()) {
                TiebaStatic.log(new StatisticItem("c14573").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            if (this.x != null) {
                TiebaStatic.log(new StatisticItem("c14626").param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.FRIEND_UID, this.x.getUserId()));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void D1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.D1(intent);
            A2();
            ((PersonalMsglistModel) this.c).setIsFriend(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FRIEND, 1));
            ((PersonalMsglistModel) this.c).setFollowStatus(intent.getIntExtra(PersonalChatActivityConfig.KEY_IS_FOLLOW, 1));
            ((PersonalMsglistModel) this.c).T(intent.getStringExtra(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
            ((PersonalMsglistModel) this.c).U(intent.getBooleanExtra(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, false));
            ((PersonalMsglistModel) this.c).setSelectList(intent.getParcelableArrayListExtra(PersonalChatActivityConfig.KEY_HAS_SELECT_MSG_LIST));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void E1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.E1(bundle);
            A2();
            ((PersonalMsglistModel) this.c).setIsFriend(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FRIEND));
            ((PersonalMsglistModel) this.c).setFollowStatus(bundle.getInt(PersonalChatActivityConfig.KEY_IS_FOLLOW));
            ((PersonalMsglistModel) this.c).T(bundle.getString(PersonalChatActivityConfig.KEY_REPLY_CONTENT));
            ((PersonalMsglistModel) this.c).U(bundle.getBoolean(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT));
            ((PersonalMsglistModel) this.c).setSelectList(bundle.getParcelableArrayList(PersonalChatActivityConfig.KEY_HAS_SELECT_MSG_LIST));
        }
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ((PersonalMsglistModel) this.c).K();
        }
        return invokeV.booleanValue;
    }

    public ArrayList<ReportPrivateMsgData> G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ((PersonalMsglistModel) this.c).N();
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            sendMessage(new RequestNewFriendDataMessage(this.x.getUserIdLong()));
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.MsglistActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(0, false);
            VirtualBarAssist virtualBarAssist = this.H;
            if (virtualBarAssist != null) {
                virtualBarAssist.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
            if (!this.Z) {
                this.Z = true;
                w2();
            }
            if (!this.u) {
                resume();
            }
            VirtualBarAssist virtualBarAssist = this.H;
            if (virtualBarAssist != null) {
                virtualBarAssist.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            I2();
            super.p1();
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (((PersonalMsglistModel) this.c).getIsFriend() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (this.A == null) {
                this.A = new ff7();
            }
            this.A.a(this.D, getListView());
        }
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (((PersonalMsglistModel) this.c).getUser() != null && ((PersonalMsglistModel) this.c).getUser().getUserIdLong() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.v1();
            this.a.postDelayed(new e(this), 60L);
        }
    }

    public void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.b = new PersonalChatView(this, this.c.getIsAcceptNotify());
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void x1() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.x1();
            MsglistModel msglistModel = this.c;
            if (!(msglistModel instanceof CommonPersonalMsglistModel) || (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) == null) {
                return;
            }
            rj5.c(new p(this, user), new q(this));
        }
    }

    public PersonalMsglistModel x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.D;
        }
        return (PersonalMsglistModel) invokeV.objValue;
    }

    public final boolean F2() {
        InterceptResult invokeV;
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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

    public final boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            boolean z = false;
            if (getIntent() == null) {
                return false;
            }
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!xi.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.c.sendExtraMessage(stringExtra);
                z = true;
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (!xi.isEmpty(stringExtra2) && stringExtra2.trim().length() > 0) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
                this.c.sendTextMessage(stringExtra2);
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void I2() {
        boolean z;
        ChatMessage chatMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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

    public void L2(@NonNull UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, userData) == null) {
            this.u = false;
            Intent intent = new Intent();
            intent.putExtra("user", userData);
            this.c.reset();
            D1(intent);
            this.b.getAdapter().n(true);
            B2();
            this.c.loadFirst(this);
            resume();
        }
    }

    public final void P2(boolean z) {
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && this.N >= -1 && this.L && !this.M && F2()) {
            this.M = true;
            Handler handler = this.a;
            f fVar = new f(this);
            if (z) {
                j2 = 0;
            } else {
                j2 = 61;
            }
            handler.postDelayed(fVar, j2);
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.c).getIsFriend());
            bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.c).M());
            bundle.putBoolean(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, ((PersonalMsglistModel) this.c).K());
        }
    }

    public final boolean z2(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048619, this, j2)) == null) {
            if (j2 <= 0) {
                return false;
            }
            py4 k2 = py4.k();
            return k2.h("im_ice_break_msg_is_closed_" + j2, false);
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void U0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
                    if (!this.I && t1()) {
                        this.I = true;
                        if (getIntent() != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921700, new int[]{getIntent().getIntExtra("last_page_unique_id", 0), 2}));
                        }
                    }
                } else if (loadDataMode == 9) {
                    String draft = this.c.getDraft();
                    if (draft == null) {
                        K2();
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(draft);
                            String optString = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, "");
                            String optString2 = jSONObject.optString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, "");
                            if (TextUtils.isEmpty(optString) || (TextUtils.equals(optString, TbEnum.ChatInputStatus.INPUT_STATUS_TEXT) && TextUtils.isEmpty(optString2))) {
                                K2();
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
                    t2();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.b.getBtnGroupInfo()) {
                if (((PersonalMsglistModel) this.c).K()) {
                    TiebaStatic.log(new StatisticItem("c14578").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH, this.E.A());
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
                of7.a("c14627");
            } else if (view2 == this.E.z()) {
                if (this.D.I() != PersonalMsglistModel.CardStatus.APPLY && this.D.I() != PersonalMsglistModel.CardStatus.WAIT) {
                    if (this.D.I() == PersonalMsglistModel.CardStatus.AGREE) {
                        qd5.a(xg.g(this.D.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        TiebaStatic.eventStat(getActivity(), "add_fri_aio", "click", 1, new Object[0]);
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), this.D.getUser().getUserId(), this.D.getUser().getUserName(), this.D.getUser().getPortrait(), "", false, AddFriendActivityConfig.TYPE_STRANGER_CHAT)));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tieba.rf
    public void q(View view2, int i2, int i3, long j2) {
        ChatMessage msg;
        ChatMessage msg2;
        String i4;
        sf7.a a2;
        ChatMessage findIceBreakMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.q(view2, i2, i3, j2);
            if (i2 != 2) {
                if (i2 != 4) {
                    if (i2 != 14) {
                        if (i2 != 18) {
                            if (i2 == 19 && !mc7.a(this) && (findIceBreakMsg = this.c.findIceBreakMsg()) != null && !ListUtils.isEmpty(findIceBreakMsg.getIceBreakEmotions()) && findIceBreakMsg.getIceBreakEmotions().size() > j2) {
                                jb7 jb7Var = findIceBreakMsg.getIceBreakEmotions().get((int) j2);
                                this.c.sendIceBreakEmotion(jb7Var.a, jb7Var.b, jb7Var.c, jb7Var.d);
                                return;
                            }
                            return;
                        }
                        UserData userData = this.x;
                        if (userData != null) {
                            J2(xg.g(userData.getUserId(), 0L));
                            return;
                        }
                        return;
                    }
                    ChatMessage msg3 = this.c.getMsg(i3);
                    if (msg3 != null && msg3.getContent() != null && (a2 = sf7.a(msg3.getContent())) != null) {
                        if (a2.h == 1) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(a2.e, a2.f, null, false)));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a2.e, a2.f, null)));
                        }
                    }
                } else if (!f1() || (msg2 = this.c.getMsg(i3)) == null || !we7.y(msg2) || (i4 = we7.i(msg2.getContent(), true)) == null) {
                } else {
                    MsglistModel msglistModel = this.c;
                    if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                        return;
                    }
                    sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), i4, ((CommonPersonalMsglistModel) this.c).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
                }
            } else if (D2() || (msg = this.c.getMsg(i3)) == null || msg.getUserInfo() == null) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg.getUserInfo().getUserId(), msg.getUserInfo().getUserName())));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean s1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, bundle)) == null) {
            try {
                registerListener(2001172, this.R);
                registerListener(2001173, this.R);
                registerListener(2001219, this.R);
                registerListener(2001220, this.R);
                registerListener(2001221, this.R);
                registerListener(this.Q);
                registerListener(this.P);
                registerListener(this.v);
                registerListener(this.a0);
                registerListener(this.S);
                registerListener(this.T);
                if (PersonalChatActivityStatic.b() == null) {
                    PersonalChatActivityStatic.d(new nf7());
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
                        C1(bundle);
                    } else {
                        B1();
                    }
                    if (!A1()) {
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

    public final void y2(List<com.baidu.tbadk.data.UserData> list) {
        UserData userData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, list) == null) && list != null && (userData = this.x) != null && !TextUtils.isEmpty(userData.getUserId())) {
            for (com.baidu.tbadk.data.UserData userData2 : list) {
                if (this.x.getUserId().equals(userData2.getUserId())) {
                    this.L = true;
                    this.x.setRelation(userData2.getRelation());
                    this.x.setIsBlocked(userData2.getIsBlocked());
                    this.x.setCanChat(userData2.getCanChat());
                    this.E.initFollowTip(this.x);
                    P2(false);
                    return;
                }
            }
        }
    }
}

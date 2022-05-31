package com.baidu.tieba.imMessageCenter.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.VirtualBarAssist;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.im.model.IceBreakEmotionModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag;
import com.repackage.cx4;
import com.repackage.e27;
import com.repackage.h77;
import com.repackage.j57;
import com.repackage.jg;
import com.repackage.ki;
import com.repackage.m37;
import com.repackage.mc5;
import com.repackage.n37;
import com.repackage.o77;
import com.repackage.p77;
import com.repackage.pc5;
import com.repackage.q47;
import com.repackage.qx4;
import com.repackage.r57;
import com.repackage.s77;
import com.repackage.t65;
import com.repackage.t67;
import com.repackage.tb5;
import com.repackage.y67;
import com.repackage.ys4;
import com.repackage.zx4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonalChatActivity extends CommonPersonalChatActivity<PersonalChatActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener addFriendStateChanged;
    public String curruntId;
    public boolean delayCheckEmoji;
    public h77 emojiAnimController;
    public CustomMessageListener getNewFriend;
    public boolean hasPageInit;
    public boolean hasShowPushPermission;
    public boolean hasUnread;
    public IceBreakEmotionModel iceBreakEmotionModel;
    public IMUserListModel imUserListModel;
    public CustomMessageListener joinGroupListener;
    public PersonalMsglistModel mCurrentModel;
    public PersonalChatView mCurrentView;
    public Handler mHandler;
    public qx4 mLbs;
    public Runnable mRefreshTitleRunnable;
    public UserData mUser;
    public VirtualBarAssist mVirtualBarAssist;
    public CustomMessageListener overSelectToastListener;
    public boolean sendFinishMessage;
    public long timeGrade;
    public HttpMessageListener userListMessageListener;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean sendAutoMessage = this.a.sendAutoMessage();
                int needShowBreakIceEmotions = this.a.needShowBreakIceEmotions();
                boolean z = 4 == this.a.getIntent().getIntExtra("key_from", 0);
                if (sendAutoMessage || this.a.hasPageInit || needShowBreakIceEmotions == -1 || z) {
                    return;
                }
                this.a.hasPageInit = true;
                this.a.showBreakIceEmotions(needShowBreakIceEmotions);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements IceBreakEmotionModel.IceBreakRequestCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PersonalChatActivity b;

        public b(PersonalChatActivity personalChatActivity, int i) {
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
        public void onSuccess(List<m37> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                PersonalChatMessage personalChatMessage = new PersonalChatMessage();
                personalChatMessage.setIceBreakEmotions(list);
                if (!ListUtils.isEmpty(this.b.mListModel.getData().getChatMessages())) {
                    personalChatMessage.setMsgId(this.b.mListModel.getData().getChatMessages().get(this.b.mListModel.getData().getChatMessages().size() - 1).getRecordId());
                }
                this.b.mListModel.getData().getChatMessages().add(this.a, personalChatMessage);
                this.b.mListView.refreshNormal(this.b.mListModel.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalChatActivity personalChatActivity, int i) {
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
            IMUserListHttpResponseMsg iMUserListHttpResponseMsg;
            HashMap<String, ImMessageCenterPojo> hashMap;
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || !(httpResponsedMessage instanceof IMUserListHttpResponseMsg) || (hashMap = (iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage).changedList) == null || hashMap.isEmpty() || this.a.mUser == null || (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(this.a.mUser.getUserId())) == null) {
                return;
            }
            this.a.mUser.setName_show(imMessageCenterPojo.getNameShow());
            int i = imMessageCenterPojo.getIsFriend() == 1 ? 1 : 0;
            if (this.a.mListModel instanceof PersonalMsglistModel) {
                ((PersonalMsglistModel) this.a.mListModel).setIsFriend(i);
            }
            if (this.a.mListView != null && this.a.mListView.getAdapter() != null) {
                this.a.mListView.refreshPersonalHeadFooter(this.a.mUser.getName_show(), this.a.mLbs);
                this.a.mListView.getAdapter().f();
            }
            q47.o().O(imMessageCenterPojo, false, 1);
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
                n37 data = ((ResponseNewFriendDataMessage) customResponsedMessage).getData();
                PersonalMsglistModel.CardStatus I = this.a.mCurrentModel.I(data);
                this.a.mCurrentModel.R(I);
                if (I != PersonalMsglistModel.CardStatus.AGREE) {
                    this.a.mCurrentView.y(I, false, new String[0]);
                    return;
                }
                this.a.mCurrentView.y(I, false, data.a());
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
            this.a.mListView.getAdapter().f();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PersonalChatActivity personalChatActivity, int i) {
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
            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0aa3));
            bdTopToast.j(this.a.mCurrentView.w());
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
                if (optJSONObject != null && optJSONObject.optLong("user_id") == jg.g(this.a.mCurrentModel.getUser().getUserId(), 0L)) {
                    String optString = optJSONObject.optString("message");
                    if (cmd.equals("apply_new_friend")) {
                        this.a.mCurrentView.y(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                        this.a.mCurrentModel.R(PersonalMsglistModel.CardStatus.AGREE);
                    } else if (cmd.equals("passed_new_friend")) {
                        this.a.mCurrentView.y(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                        this.a.mCurrentModel.R(PersonalMsglistModel.CardStatus.PASS);
                        this.a.mCurrentModel.setIsFriend(1);
                        this.a.mCurrentModel.setFollowStatus(1);
                        this.a.mCurrentView.getBtnGroupInfo().setVisibility(0);
                    } else if (cmd.equals("apply_add_friend")) {
                        this.a.mCurrentView.y(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                        this.a.mCurrentModel.R(PersonalMsglistModel.CardStatus.WAIT);
                    } else if (cmd.equals("apply_pass_friend")) {
                        this.a.mCurrentView.y(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
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
    public class i extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ PersonalChatActivity b;

        public i(PersonalChatActivity personalChatActivity, UserData userData) {
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
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(r57.j().c(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.getUserId()))) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements tb5<Boolean> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tb5
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

    /* loaded from: classes3.dex */
    public class k extends mc5<Void> {
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
        @Override // com.repackage.mc5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r57.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements AbsMsglistView.f {
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
        this.hasUnread = false;
        this.delayCheckEmoji = false;
        this.mRefreshTitleRunnable = new e(this);
        this.joinGroupListener = new f(this, 2001214);
        this.overSelectToastListener = new g(this, 2921670);
        this.addFriendStateChanged = new h(this, 0);
        this.sendFinishMessage = false;
        this.userListMessageListener = new c(this, CmdConfigHttp.CMD_GET_USER_LIST);
    }

    private void checkAndCallEmojiAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            if (this.emojiAnimController == null) {
                this.emojiAnimController = new h77();
            }
            this.emojiAnimController.a(this.mCurrentModel, getListView());
        }
    }

    private boolean checkShowNotificationOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled();
            boolean h2 = ys4.k().h("key_private_chat_show_notification", false);
            if (areNotificationsEnabled || h2 || UbsABTestHelper.isPushOpenNewStyle()) {
                return false;
            }
            zx4.h(getPageContext(), new boolean[]{true, false}, 3);
            ys4.k().u("key_private_chat_show_notification", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    private void dispatchFinishResponse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new PersonalChatDisplayResponse());
        }
    }

    private boolean hasCloseIceBreakMsg(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65571, this, j2)) == null) {
            if (j2 > 0) {
                ys4 k2 = ys4.k();
                return k2.h("im_ice_break_msg_is_closed_" + j2, false);
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    private void initCurId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
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
    public int needShowBreakIceEmotions() {
        InterceptResult invokeV;
        UserData userData;
        List<ChatMessage> chatMessages;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel == null || msglistModel.getData() == null || (userData = this.mUser) == null || hasCloseIceBreakMsg(jg.g(userData.getUserId(), 0L)) || this.mListModel.findIceBreakMsg() != null || (chatMessages = this.mListModel.getData().getChatMessages()) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendAutoMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            boolean z = false;
            if (getIntent() == null) {
                return false;
            }
            String stringExtra = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
            if (!ki.isEmpty(stringExtra)) {
                getIntent().removeExtra(PersonalChatActivityConfig.KEY_SHARE_MSG);
                this.mListModel.sendExtraMessage(stringExtra);
                z = true;
            }
            String stringExtra2 = getIntent().getStringExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            if (ki.isEmpty(stringExtra2) || stringExtra2.trim().length() <= 0) {
                return z;
            }
            getIntent().removeExtra(PersonalChatActivityConfig.KEY_LEAVE_MSG);
            this.mListModel.sendTextMessage(stringExtra2);
            return true;
        }
        return invokeV.booleanValue;
    }

    private void sendCards() {
        boolean z;
        ChatMessage chatMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
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

    private void setCloseIceBreakMsg(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65576, this, j2) == null) || j2 <= 0) {
            return;
        }
        ys4 k2 = ys4.k();
        k2.u("im_ice_break_msg_is_closed_" + j2, true);
        removeIceBreakMsg();
    }

    private void showAddFriendStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            sendMessage(new RequestNewFriendDataMessage(this.mUser.getUserIdLong()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBreakIceEmotions(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65578, this, i2) == null) {
            t67.a("触发展示破冰表情：showBreakIceEmotions");
            if (this.iceBreakEmotionModel == null) {
                IceBreakEmotionModel iceBreakEmotionModel = new IceBreakEmotionModel(getPageContext());
                this.iceBreakEmotionModel = iceBreakEmotionModel;
                iceBreakEmotionModel.setRequestCallback(new b(this, i2));
            }
            this.iceBreakEmotionModel.request();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void afterDataSet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int loadDataMode = this.mListModel.getLoadDataMode();
            boolean z = this.mListModel.getData().getIsNewAdd() && this.mListModel.getData().getNewAddNum() > 0;
            if (loadDataMode == 1) {
                z = this.hasUnread;
            } else if (loadDataMode == 4) {
                z = true;
            } else if (loadDataMode != 3) {
                if (loadDataMode == 5 && !this.hasShowPushPermission && isFriend()) {
                    this.hasShowPushPermission = true;
                    if (getIntent() != null && UbsABTestHelper.isPushOpenNewStyle()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921700, new int[]{getIntent().getIntExtra("last_page_unique_id", 0), 2}));
                    }
                }
                z = false;
            }
            if (z) {
                this.hasUnread = false;
                if (TbadkCoreApplication.getInst().getCurrentActivity() != this) {
                    this.delayCheckEmoji = true;
                } else {
                    checkAndCallEmojiAnim();
                }
            }
        }
    }

    public boolean checkUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (((PersonalMsglistModel) this.mListModel).getUser() == null || ((PersonalMsglistModel) this.mListModel).getUser().getUserIdLong() == 0) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || checkShowNotificationOpen()) {
            return;
        }
        super.finish();
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean first(e27 e27Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e27Var)) == null) {
            this.mListModel.loadFirst(e27Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    public PersonalMsglistModel getCurrentModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCurrentModel : (PersonalMsglistModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.ve5
    public ag<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public long getTimeGrade(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean initData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            try {
                registerListener(2001172, this.addFriendStateChanged);
                registerListener(2001173, this.addFriendStateChanged);
                registerListener(2001219, this.addFriendStateChanged);
                registerListener(2001220, this.addFriendStateChanged);
                registerListener(2001221, this.addFriendStateChanged);
                registerListener(this.overSelectToastListener);
                registerListener(this.joinGroupListener);
                registerListener(this.getNewFriend);
                registerListener(this.userListMessageListener);
                if (PersonalChatActivityStatic.b() == null) {
                    PersonalChatActivityStatic.d(new o77());
                }
                PersonalMsglistModel personalMsglistModel = new PersonalMsglistModel(this);
                this.mListModel = personalMsglistModel;
                personalMsglistModel.setLoadDataCallBack(this.mMsgCallback);
                this.mCurrentModel = (PersonalMsglistModel) this.mListModel;
                this.imUserListModel = new IMUserListModel(getPageContext(), getUniqueId());
                if (bundle != null) {
                    initParam(bundle);
                } else {
                    initParam();
                }
                if (getIntent() != null) {
                    this.mCurrentModel.setFrom(getIntent().getIntExtra("key_from", 0));
                }
                return checkParam();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void initView() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mListView = new PersonalChatView(this, this.mListModel.getIsAcceptNotify());
            this.mListView.setInputMethodManager((InputMethodManager) getSystemService("input_method"));
            this.mCurrentView = (PersonalChatView) this.mListView;
            long longValue = j57.j.longValue();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
                this.mUser = user;
                this.mListView.refreshPersonalHeadFooter(user.getName_show(), this.mLbs);
                this.mListView.bindDataAndRefresh(this.mListModel.getData(), longValue);
                this.mListView.setRecordCallback(new l(this));
                if (!isFriend()) {
                    showAddFriendStatus();
                }
                if (!TextUtils.isEmpty(this.mCurrentModel.L())) {
                    PersonalMsglistModel personalMsglistModel = this.mCurrentModel;
                    personalMsglistModel.N(personalMsglistModel.L());
                }
                if (isReportSelect()) {
                    TiebaStatic.log(new StatisticItem("c14573").param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
                if (this.mUser != null) {
                    TiebaStatic.log(new StatisticItem("c14626").param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.FRIEND_UID, this.mUser.getUserId()));
                }
            }
        }
    }

    public boolean isFollow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ((PersonalMsglistModel) this.mListModel).getFollowStatus() == 1 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public boolean isFriend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((PersonalMsglistModel) this.mListModel).getIsFriend() == 1 : invokeV.booleanValue;
    }

    public boolean isReportSelect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ((PersonalMsglistModel) this.mListModel).J() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mListView.getBtnGroupInfo()) {
                if (((PersonalMsglistModel) this.mListModel).J()) {
                    TiebaStatic.log(new StatisticItem("c14578").param("uid", TbadkCoreApplication.getCurrentAccount()));
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(PersonalChatActivityConfig.KEY_SELECT_MSG_LIST_FINISH, this.mCurrentView.v());
                    setResult(-1, intent);
                    finish();
                    return;
                }
                TiebaStatic.log("personal_chat_page_morebutton");
                MsglistModel msglistModel = this.mListModel;
                if ((msglistModel instanceof PersonalMsglistModel) && (user = ((PersonalMsglistModel) msglistModel).getUser()) != null) {
                    if (user.getUserType() == 4) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), user.getUserName(), user.getUserIdLong())));
                        return;
                    }
                    sendMessage(new CustomMessage(2002001, new PersonalTalkSettingActivityConfig(getPageContext().getPageActivity(), user.getUserIdLong())));
                    p77.a("c14627");
                }
            } else if (view2 == this.mCurrentView.u()) {
                if (this.mCurrentModel.H() != PersonalMsglistModel.CardStatus.APPLY && this.mCurrentModel.H() != PersonalMsglistModel.CardStatus.WAIT) {
                    if (this.mCurrentModel.H() == PersonalMsglistModel.CardStatus.AGREE) {
                        t65.a(jg.g(this.mCurrentModel.getUser().getUserId(), 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
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
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.mVirtualBarAssist == null) {
                this.mVirtualBarAssist = VirtualBarAssist.assistActivity(this);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            ChatStatusManager.getInst().setCurId(0, "");
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.mRefreshTitleRunnable);
            }
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
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
        String h2;
        s77.a a2;
        ChatMessage findIceBreakMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            super.onItemViewClick(view2, i2, i3, j2);
            if (i2 == 2) {
                if (isReportSelect() || (msg = this.mListModel.getMsg(i3)) == null || msg.getUserInfo() == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg.getUserInfo().getUserId(), msg.getUserInfo().getUserName())));
            } else if (i2 == 4) {
                if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i3)) != null && y67.w(msg2) && (h2 = y67.h(msg2.getContent(), true)) != null) {
                    MsglistModel msglistModel = this.mListModel;
                    if (!(msglistModel instanceof CommonPersonalMsglistModel) || ((CommonPersonalMsglistModel) msglistModel).getUser() == null) {
                        return;
                    }
                    sendMessage(new CustomMessage(2002001, new PersonalMsgImageActivityConfig(getPageContext().getContext(), h2, ((CommonPersonalMsglistModel) this.mListModel).getUser().getUserIdLong(), String.valueOf(msg2.getMsgId()))));
                }
            } else if (i2 == 14) {
                ChatMessage msg3 = this.mListModel.getMsg(i3);
                if (msg3 == null || msg3.getContent() == null || (a2 = s77.a(msg3.getContent())) == null) {
                    return;
                }
                if (a2.h == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(a2.e, a2.f, null, false)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(a2.e, a2.f, null)));
                }
            } else if (i2 != 18) {
                if (i2 == 19 && (findIceBreakMsg = this.mListModel.findIceBreakMsg()) != null && !ListUtils.isEmpty(findIceBreakMsg.getIceBreakEmotions()) && findIceBreakMsg.getIceBreakEmotions().size() > j2) {
                    m37 m37Var = findIceBreakMsg.getIceBreakEmotions().get((int) j2);
                    this.mListModel.sendIceBreakEmotion(m37Var.a, m37Var.b, m37Var.c, m37Var.d);
                }
            } else {
                UserData userData = this.mUser;
                if (userData != null) {
                    setCloseIceBreakMsg(jg.g(userData.getUserId(), 0L));
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void onPageInited() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPageInited();
            this.handler.postDelayed(new a(this), 60L);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            ChatStatusManager.getInst().setIsOpen(0, false);
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            if (!this.sendFinishMessage) {
                this.sendFinishMessage = true;
                dispatchFinishResponse();
            }
            ChatStatusManager.getInst().setIsOpen(0, true);
            String curId = ChatStatusManager.getInst().getCurId(0);
            ImMessageCenterPojo i2 = q47.o().i(curId, 2);
            if (i2 != null) {
                this.hasUnread = i2.getUnread_count() > 0;
            }
            if (this.delayCheckEmoji) {
                this.delayCheckEmoji = false;
                checkAndCallEmojiAnim();
            }
            cx4.f0().r(curId);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(curId, 2)));
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel != null && (msglistModel instanceof PersonalMsglistModel)) {
                ((PersonalMsglistModel) msglistModel).Q();
            }
            UserData userData = this.mUser;
            if (userData != null && !TextUtils.isEmpty(userData.getUserId()) && this.imUserListModel != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mUser.getUserId());
                this.imUserListModel.request(false, arrayList);
            }
            VirtualBarAssist virtualBarAssist = this.mVirtualBarAssist;
            if (virtualBarAssist != null) {
                virtualBarAssist.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity, com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(PersonalChatActivityConfig.KEY_IS_FRIEND, ((PersonalMsglistModel) this.mListModel).getIsFriend());
            bundle.putString(PersonalChatActivityConfig.KEY_REPLY_CONTENT, ((PersonalMsglistModel) this.mListModel).L());
            bundle.putBoolean(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, ((PersonalMsglistModel) this.mListModel).J());
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.refreshHeadIcon();
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
                pc5.c(new i(this, user), new j(this));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, userData) == null) {
            pc5.c(new k(this, userData), null);
        }
    }

    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? ((PersonalMsglistModel) this.mListModel).M() : (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public void sendTextMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            sendCards();
            super.sendTextMsg();
        }
    }

    @Override // com.baidu.tieba.im.chat.CommonPersonalChatActivity
    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
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

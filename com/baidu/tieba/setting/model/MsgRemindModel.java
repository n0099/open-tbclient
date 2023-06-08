package com.baidu.tieba.setting.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.k9;
import com.baidu.tieba.lb;
import com.baidu.tieba.n95;
import com.baidu.tieba.ne5;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerReqMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MsgRemindModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCEPT_MSG = 1;
    public static final int OFFICIAL_PUSH_MSG_ID = 1501754229;
    public static final int SWITCH_ALL = 14;
    public static final int SWITCH_AT_ME = 2;
    public static final int SWITCH_FANS = 3;
    public static final int SWITCH_FOLLOW_FRIENDS_PUSH_MSG = 34;
    public static final int SWITCH_FRIENDS_INVITATION_ANSWER_MSG = 33;
    public static final int SWITCH_FRIEND_MSG = 8;
    public static final int SWITCH_FRIEND_PRIVATE_MSG = 10;
    public static final int SWITCH_GROUP_CHAT_PUSH_MSG = 35;
    public static final int SWITCH_GROUP_MSG = 4;
    public static final int SWITCH_NO_DISTURB = 30;
    public static final int SWITCH_OFFICIAL_PUSH_MSG = 6;
    public static final int SWITCH_PRIVATE_MSG = 5;
    public static final int SWITCH_REMIND_FORUM_MSG = 7;
    public static final int SWITCH_REPLY_ME = 1;
    public static final int SWITCH_STRANGER_MSG = 9;
    public static final int SWITCH_TYPE_NUM = 8;
    public static final int SWITCH_YY_MSG = 6;
    public static final int SWITCH_ZAN = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public f b;
    public f c;
    public HttpMessageListener d;
    public lb e;
    public lb f;
    public lb g;

    /* loaded from: classes7.dex */
    public interface f {
        void a(int i, boolean z, boolean z2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindModel a;

        public a(MsgRemindModel msgRemindModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgRemindModel;
        }

        @Override // com.baidu.tieba.setting.model.MsgRemindModel.f
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (i == 2) {
                    if (z) {
                        ne5.d().M(z2);
                    }
                } else if (i == 3) {
                    if (z) {
                        ne5.d().Q(z2);
                    }
                } else if (i == 1) {
                    if (z) {
                        ne5.d().R(z2);
                    }
                } else if (i == 20) {
                    if (z) {
                        ne5.d().U(z2);
                    }
                } else if (i == 30) {
                    if (z) {
                        ne5.d().W(z2);
                    }
                } else if (i != 10) {
                    if (i == 7) {
                        if (z) {
                            ne5.d().Z(z2);
                        }
                    } else if (i == 35) {
                        if (z) {
                            ne5.d().K(z2);
                        }
                    } else if (i == 6) {
                        if (z) {
                            ne5.d().Y(z2);
                        }
                    } else if (i == 33) {
                        if (z) {
                            ne5.d().a0(z2);
                        }
                    } else if (i == 34 && z) {
                        ne5.d().J(z2);
                    }
                }
                if (this.a.c != null) {
                    this.a.c.a(i, z, z2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MsgRemindModel msgRemindModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i)};
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
            this.a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.X();
                if (!(httpResponsedMessage instanceof FriendAndStrangerSwitchResMsg) || !(httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                    return;
                }
                FriendAndStrangerReqMsg friendAndStrangerReqMsg = (FriendAndStrangerReqMsg) httpResponsedMessage.getOrginalMessage();
                FriendAndStrangerSwitchResMsg friendAndStrangerSwitchResMsg = (FriendAndStrangerSwitchResMsg) httpResponsedMessage;
                if (friendAndStrangerSwitchResMsg.getError() == 0) {
                    GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = friendAndStrangerReqMsg.mMaskType;
                    n95 m = n95.m();
                    m.z(TbadkCoreApplication.getCurrentAccount() + "key_friend_type", friendAndStrangerReqMsg.mMaskType);
                    GetFriendAndStrangerSwitchModel.FRIEND_PRIVATE_MESSAGE_PUSH_TYPE = friendAndStrangerReqMsg.mPushType;
                    n95 m2 = n95.m();
                    m2.z(TbadkCoreApplication.getCurrentAccount() + "key_friend_private_message_type", friendAndStrangerReqMsg.mPushType);
                }
                int i = friendAndStrangerReqMsg.mPushType;
                boolean z3 = false;
                boolean z4 = true;
                if (i == 1) {
                    MsgRemindModel msgRemindModel = this.a;
                    if (friendAndStrangerSwitchResMsg.getError() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    msgRemindModel.Y(10, z2, true, friendAndStrangerSwitchResMsg.getErrorString());
                } else if (i == 2) {
                    MsgRemindModel msgRemindModel2 = this.a;
                    if (friendAndStrangerSwitchResMsg.getError() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    msgRemindModel2.Y(10, z, false, friendAndStrangerSwitchResMsg.getErrorString());
                }
                int i2 = friendAndStrangerReqMsg.mMaskType;
                if (i2 == 3) {
                    MsgRemindModel msgRemindModel3 = this.a;
                    if (friendAndStrangerSwitchResMsg.getError() != 0) {
                        z4 = false;
                    }
                    msgRemindModel3.Y(8, z4, false, friendAndStrangerSwitchResMsg.getErrorString());
                } else if (i2 == 0) {
                    MsgRemindModel msgRemindModel4 = this.a;
                    if (friendAndStrangerSwitchResMsg.getError() == 0) {
                        z3 = true;
                    }
                    msgRemindModel4.Y(9, z3, true, friendAndStrangerSwitchResMsg.getErrorString());
                } else if (i2 == 1) {
                    int i3 = friendAndStrangerReqMsg.mRequestType;
                    if (i3 == 8) {
                        MsgRemindModel msgRemindModel5 = this.a;
                        if (friendAndStrangerSwitchResMsg.getError() == 0) {
                            z3 = true;
                        }
                        msgRemindModel5.Y(8, z3, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i3 == 9) {
                        MsgRemindModel msgRemindModel6 = this.a;
                        if (friendAndStrangerSwitchResMsg.getError() != 0) {
                            z4 = false;
                        }
                        msgRemindModel6.Y(9, z4, false, friendAndStrangerSwitchResMsg.getErrorString());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends lb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MsgRemindModel msgRemindModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i)};
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
            this.a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || !(socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) || !(socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                return;
            }
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
            MsgRemindModel msgRemindModel = this.a;
            int maskType = requestUpdateMaskInfoMessage.getMaskType();
            if (responseUpdateMaskInfoMessage.getError() == 0) {
                z = true;
            } else {
                z = false;
            }
            msgRemindModel.Y(maskType, z, requestUpdateMaskInfoMessage.isSettingMask(), responseUpdateMaskInfoMessage.getErrorString());
        }
    }

    /* loaded from: classes7.dex */
    public class d extends lb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MsgRemindModel msgRemindModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i)};
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
            this.a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) {
                this.a.X();
                if (!(socketResponsedMessage instanceof ResponseUpdateMaskMessage) || !(socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                    return;
                }
                ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                RequestUpdateMaskMessage requestUpdateMaskMessage = (RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage();
                MsgRemindModel msgRemindModel = this.a;
                if (responseUpdateMaskMessage.getError() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                msgRemindModel.Y(4, z, requestUpdateMaskMessage.isSettingMask(), responseUpdateMaskMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends lb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MsgRemindModel msgRemindModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i)};
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
            this.a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) {
                this.a.X();
                if (socketResponsedMessage instanceof ResponseUpdateForumMask) {
                    ResponseUpdateForumMask responseUpdateForumMask = (ResponseUpdateForumMask) socketResponsedMessage;
                    boolean z2 = false;
                    if (((RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage()).getFlag()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    MsgRemindModel msgRemindModel = this.a;
                    if (responseUpdateForumMask.getError() == 0) {
                        z2 = true;
                    }
                    msgRemindModel.Y(7, z2, z, responseUpdateForumMask.getErrorString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgRemindModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.d = new b(this, CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.e = new c(this, 104102);
        this.f = new d(this, 104101);
        this.g = new e(this, 104106);
        this.a = tbPageContext;
        registerListener(this.f);
        registerListener(this.e);
        registerListener(this.g);
        registerListener(this.d);
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof BaseActivity)) {
                ((BaseActivity) this.a.getPageActivity()).hideProgressBar();
            }
            TbPageContext<?> tbPageContext2 = this.a;
            if (tbPageContext2 != null && (tbPageContext2.getPageActivity() instanceof BaseFragmentActivity)) {
                ((BaseFragmentActivity) this.a.getPageActivity()).hideProgressBar();
            }
        }
    }

    public final void Y(int i, boolean z, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
            if (z) {
                this.b.a(i, true, z2);
                if (i != 14) {
                    if (!ne5.d().v() && !ne5.d().w() && !ne5.d().y() && !ne5.d().A() && !ne5.d().D() && !ne5.d().u() && !ne5.d().G() && !ne5.d().t()) {
                        this.b.a(14, true, false);
                        return;
                    }
                    return;
                }
                this.b.a(2, true, z2);
                this.b.a(3, true, z2);
                this.b.a(4, true, z2);
                this.b.a(5, true, z2);
                this.b.a(1, true, z2);
                this.b.a(20, true, z2);
                this.b.a(10, true, z2);
                this.b.a(35, true, z2);
                return;
            }
            if (this.a != null) {
                if (!TextUtils.isEmpty(str)) {
                    this.a.showToast(str);
                } else {
                    this.a.showToast((int) R.string.set_switch_fail);
                }
            }
            this.b.a(i, false, z2);
        }
    }

    public void Z(int i, boolean z, f fVar) {
        Message<?> friendAndStrangerReqMsg;
        Message<?> friendAndStrangerReqMsg2;
        Message<?> friendAndStrangerReqMsg3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), fVar}) == null) {
            if (i != 14 && i != 2 && i != 3 && i != 4 && i != 5 && i != 1 && i != 7 && i != 8 && i != 9 && i != 20 && i != 6 && i != 30 && i != 10 && i != 33 && i != 34 && i != 35) {
                return;
            }
            this.c = fVar;
            if (i == 4) {
                RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                requestUpdateMaskMessage.setSettingMask(z);
                sendMessage(requestUpdateMaskMessage);
            } else if (i == 7) {
                RequestUpdateForumMask requestUpdateForumMask = new RequestUpdateForumMask();
                requestUpdateForumMask.setType(1);
                requestUpdateForumMask.setFlag(z);
                sendMessage(requestUpdateForumMask);
            } else if (i == 8) {
                if (z) {
                    friendAndStrangerReqMsg3 = new FriendAndStrangerReqMsg(1, i, 0);
                } else {
                    friendAndStrangerReqMsg3 = new FriendAndStrangerReqMsg(3, i, 0);
                }
                sendMessage(friendAndStrangerReqMsg3);
            } else if (i == 9) {
                if (z) {
                    friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(0, i, 0);
                } else {
                    friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(1, i, 0);
                }
                sendMessage(friendAndStrangerReqMsg2);
            } else if (i == 6) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage.setMaskType(6);
                requestUpdateMaskInfoMessage.setG_id(1501754229L);
                if (z) {
                    requestUpdateMaskInfoMessage.setIsMask(1);
                } else {
                    requestUpdateMaskInfoMessage.setIsMask(0);
                }
                requestUpdateMaskInfoMessage.setCallFrom(5);
                MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
            } else if (i == 10) {
                if (z) {
                    friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(0, i, 1);
                } else {
                    friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(1, i, 2);
                }
                sendMessage(friendAndStrangerReqMsg);
            } else {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage2 = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage2.setMaskType(i);
                requestUpdateMaskInfoMessage2.setSettingMask(z);
                sendMessage(requestUpdateMaskInfoMessage2);
            }
        }
    }
}

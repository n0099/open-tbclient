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
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerReqMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.FriendAndStrangerSwitchResMsg;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bb;
import com.repackage.d9;
import com.repackage.ht4;
import com.repackage.rx4;
/* loaded from: classes4.dex */
public class MsgRemindModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCEPT_MSG = 1;
    public static final int OFFICIAL_PUSH_MSG_ID = 1501754229;
    public static final int SWITCH_ALL = 14;
    public static final int SWITCH_AT_ME = 2;
    public static final int SWITCH_FANS = 3;
    public static final int SWITCH_FRIEND_MSG = 8;
    public static final int SWITCH_FRIEND_PRIVATE_MSG = 10;
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
    public bb e;
    public bb f;
    public bb g;

    /* loaded from: classes4.dex */
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
                        rx4.d().H(z2);
                    }
                } else if (i == 3) {
                    if (z) {
                        rx4.d().L(z2);
                    }
                } else if (i == 1) {
                    if (z) {
                        rx4.d().M(z2);
                    }
                } else if (i == 20) {
                    if (z) {
                        rx4.d().P(z2);
                    }
                } else if (i == 30) {
                    if (z) {
                        rx4.d().R(z2);
                    }
                } else if (i != 10) {
                    if (i == 7) {
                        if (z) {
                            rx4.d().U(z2);
                        }
                    } else if (i == 6 && z) {
                        rx4.d().T(z2);
                    }
                }
                if (this.a.c != null) {
                    this.a.c.a(i, z, z2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.C();
                if ((httpResponsedMessage instanceof FriendAndStrangerSwitchResMsg) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                    FriendAndStrangerReqMsg friendAndStrangerReqMsg = (FriendAndStrangerReqMsg) httpResponsedMessage.getOrginalMessage();
                    FriendAndStrangerSwitchResMsg friendAndStrangerSwitchResMsg = (FriendAndStrangerSwitchResMsg) httpResponsedMessage;
                    if (friendAndStrangerSwitchResMsg.getError() == 0) {
                        GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = friendAndStrangerReqMsg.mMaskType;
                        ht4 k = ht4.k();
                        k.w(TbadkCoreApplication.getCurrentAccount() + "key_friend_type", friendAndStrangerReqMsg.mMaskType);
                        GetFriendAndStrangerSwitchModel.FRIEND_PRIVATE_MESSAGE_PUSH_TYPE = friendAndStrangerReqMsg.mPushType;
                        ht4 k2 = ht4.k();
                        k2.w(TbadkCoreApplication.getCurrentAccount() + "key_friend_private_message_type", friendAndStrangerReqMsg.mPushType);
                    }
                    int i = friendAndStrangerReqMsg.mPushType;
                    if (i == 1) {
                        this.a.D(10, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i == 2) {
                        this.a.D(10, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    }
                    int i2 = friendAndStrangerReqMsg.mMaskType;
                    if (i2 == 3) {
                        this.a.D(8, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i2 == 0) {
                        this.a.D(9, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i2 == 1) {
                        int i3 = friendAndStrangerReqMsg.mRequestType;
                        if (i3 == 8) {
                            this.a.D(8, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                        } else if (i3 == 9) {
                            this.a.D(9, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends bb {
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                this.a.D(requestUpdateMaskInfoMessage.getMaskType(), responseUpdateMaskInfoMessage.getError() == 0, requestUpdateMaskInfoMessage.isSettingMask(), responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends bb {
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.C();
                if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                    ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                    this.a.D(4, responseUpdateMaskMessage.getError() == 0, ((RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage()).isSettingMask(), responseUpdateMaskMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends bb {
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.C();
                if (socketResponsedMessage instanceof ResponseUpdateForumMask) {
                    ResponseUpdateForumMask responseUpdateForumMask = (ResponseUpdateForumMask) socketResponsedMessage;
                    this.a.D(7, responseUpdateForumMask.getError() == 0, !((RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage()).getFlag(), responseUpdateForumMask.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i, boolean z, boolean z2);
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
                super((d9) newInitContext.callArgs[0]);
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

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof BaseActivity)) {
                ((BaseActivity) this.a.getPageActivity()).hideProgressBar();
            }
            TbPageContext<?> tbPageContext2 = this.a;
            if (tbPageContext2 == null || !(tbPageContext2.getPageActivity() instanceof BaseFragmentActivity)) {
                return;
            }
            ((BaseFragmentActivity) this.a.getPageActivity()).hideProgressBar();
        }
    }

    public final void D(int i, boolean z, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
            if (z) {
                this.b.a(i, true, z2);
                if (i != 14) {
                    if (rx4.d().s() || rx4.d().t() || rx4.d().v() || rx4.d().x() || rx4.d().A() || rx4.d().r() || rx4.d().D()) {
                        return;
                    }
                    this.b.a(14, true, false);
                    return;
                }
                this.b.a(2, true, z2);
                this.b.a(3, true, z2);
                this.b.a(4, true, z2);
                this.b.a(5, true, z2);
                this.b.a(1, true, z2);
                this.b.a(20, true, z2);
                this.b.a(10, true, z2);
                return;
            }
            if (this.a != null) {
                if (!TextUtils.isEmpty(str)) {
                    this.a.showToast(str);
                } else {
                    this.a.showToast((int) R.string.obfuscated_res_0x7f0f112c);
                }
            }
            this.b.a(i, false, z2);
        }
    }

    public void E(int i, boolean z, f fVar) {
        Message<?> friendAndStrangerReqMsg;
        Message<?> friendAndStrangerReqMsg2;
        Message<?> friendAndStrangerReqMsg3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), fVar}) == null) {
            if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 7 || i == 8 || i == 9 || i == 20 || i == 6 || i == 30 || i == 10) {
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
}

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
import com.repackage.b9;
import com.repackage.iu4;
import com.repackage.my4;
import com.repackage.ya;
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
    public BaseActivity a;
    public e b;
    public HttpMessageListener c;
    public ya d;
    public ya e;
    public ya f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgRemindModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgRemindModel msgRemindModel, int i) {
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
                this.a.a.hideProgressBar();
                if ((httpResponsedMessage instanceof FriendAndStrangerSwitchResMsg) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                    FriendAndStrangerReqMsg friendAndStrangerReqMsg = (FriendAndStrangerReqMsg) httpResponsedMessage.getOrginalMessage();
                    FriendAndStrangerSwitchResMsg friendAndStrangerSwitchResMsg = (FriendAndStrangerSwitchResMsg) httpResponsedMessage;
                    if (friendAndStrangerSwitchResMsg.getError() == 0) {
                        GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = friendAndStrangerReqMsg.mMaskType;
                        iu4 k = iu4.k();
                        k.w(TbadkCoreApplication.getCurrentAccount() + "key_friend_type", friendAndStrangerReqMsg.mMaskType);
                        GetFriendAndStrangerSwitchModel.FRIEND_PRIVATE_MESSAGE_PUSH_TYPE = friendAndStrangerReqMsg.mPushType;
                        iu4 k2 = iu4.k();
                        k2.w(TbadkCoreApplication.getCurrentAccount() + "key_friend_private_message_type", friendAndStrangerReqMsg.mPushType);
                    }
                    int i = friendAndStrangerReqMsg.mPushType;
                    if (i == 1) {
                        this.a.A(10, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i == 2) {
                        this.a.A(10, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    }
                    int i2 = friendAndStrangerReqMsg.mMaskType;
                    if (i2 == 3) {
                        this.a.A(8, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i2 == 0) {
                        this.a.A(9, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i2 == 1) {
                        int i3 = friendAndStrangerReqMsg.mRequestType;
                        if (i3 == 8) {
                            this.a.A(8, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                        } else if (i3 == 9) {
                            this.a.A(9, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ya {
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                this.a.A(requestUpdateMaskInfoMessage.getMaskType(), responseUpdateMaskInfoMessage.getError() == 0, requestUpdateMaskInfoMessage.isSettingMask(), responseUpdateMaskInfoMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ya {
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.a.hideProgressBar();
                if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                    ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                    this.a.A(4, responseUpdateMaskMessage.getError() == 0, ((RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage()).isSettingMask(), responseUpdateMaskMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ya {
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
                this.a.a.hideProgressBar();
                if (socketResponsedMessage instanceof ResponseUpdateForumMask) {
                    ResponseUpdateForumMask responseUpdateForumMask = (ResponseUpdateForumMask) socketResponsedMessage;
                    this.a.A(7, responseUpdateForumMask.getError() == 0, !((RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage()).getFlag(), responseUpdateForumMask.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i, boolean z, boolean z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgRemindModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.d = new b(this, 104102);
        this.e = new c(this, 104101);
        this.f = new d(this, 104106);
        this.a = baseActivity;
        registerListener(this.e);
        registerListener(this.d);
        registerListener(this.f);
        registerListener(this.c);
    }

    public final void A(int i, boolean z, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
            if (z) {
                e eVar = this.b;
                if (eVar != null) {
                    eVar.a(i, true, z2);
                    if (i != 14) {
                        if (my4.d().s() || my4.d().t() || my4.d().v() || my4.d().x() || my4.d().A() || my4.d().r() || my4.d().D()) {
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
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.a.showToast(str);
            } else {
                this.a.showToast(R.string.obfuscated_res_0x7f0f1110);
            }
            e eVar2 = this.b;
            if (eVar2 != null) {
                eVar2.a(i, false, z2);
            }
        }
    }

    public void B(int i, boolean z, e eVar) {
        Message<?> friendAndStrangerReqMsg;
        Message<?> friendAndStrangerReqMsg2;
        Message<?> friendAndStrangerReqMsg3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), eVar}) == null) {
            if (i == 14 || i == 2 || i == 3 || i == 4 || i == 5 || i == 1 || i == 7 || i == 8 || i == 9 || i == 20 || i == 6 || i == 30 || i == 10) {
                this.b = eVar;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}

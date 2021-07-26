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
import d.a.d.a.f;
/* loaded from: classes4.dex */
public class MsgRemindModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCEPT_MSG = 1;
    public static final int OFFICIAL_PUSH_MSG_ID = 1501754229;
    public static final int SWITCH_ALL = 14;
    public static final int SWITCH_AT_ME = 2;
    public static final int SWITCH_FANS = 3;
    public static final int SWITCH_FRIEND_MSG = 8;
    public static final int SWITCH_GROUP_MSG = 4;
    public static final int SWITCH_OFFICIAL_PUSH_MSG = 6;
    public static final int SWITCH_PRIVATE_MSG = 5;
    public static final int SWITCH_REMIND_FORUM_MSG = 7;
    public static final int SWITCH_REPLY_ME = 1;
    public static final int SWITCH_STRANGER_MSG = 9;
    public static final int SWITCH_TYPE_NUM = 8;
    public static final int SWITCH_YY_MSG = 6;
    public static final int SWITCH_ZAN = 20;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f20871e;

    /* renamed from: f  reason: collision with root package name */
    public e f20872f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f20873g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.d.c.g.c f20874h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.d.c.g.c f20875i;
    public d.a.d.c.g.c j;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgRemindModel f20876a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MsgRemindModel msgRemindModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i2)};
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
            this.f20876a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f20876a.f20871e.hideProgressBar();
                if ((httpResponsedMessage instanceof FriendAndStrangerSwitchResMsg) && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
                    FriendAndStrangerReqMsg friendAndStrangerReqMsg = (FriendAndStrangerReqMsg) httpResponsedMessage.getOrginalMessage();
                    FriendAndStrangerSwitchResMsg friendAndStrangerSwitchResMsg = (FriendAndStrangerSwitchResMsg) httpResponsedMessage;
                    if (friendAndStrangerSwitchResMsg.getError() == 0) {
                        GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = friendAndStrangerReqMsg.mMaskType;
                    }
                    int i2 = friendAndStrangerReqMsg.mMaskType;
                    if (i2 == 3) {
                        this.f20876a.y(8, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i2 == 0) {
                        this.f20876a.y(9, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                    } else if (i2 == 1) {
                        int i3 = friendAndStrangerReqMsg.mRequestType;
                        if (i3 == 8) {
                            this.f20876a.y(8, friendAndStrangerSwitchResMsg.getError() == 0, true, friendAndStrangerSwitchResMsg.getErrorString());
                        } else if (i3 == 9) {
                            this.f20876a.y(9, friendAndStrangerSwitchResMsg.getError() == 0, false, friendAndStrangerSwitchResMsg.getErrorString());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgRemindModel f20877a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MsgRemindModel msgRemindModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i2)};
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
            this.f20877a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f20877a.f20871e.hideProgressBar();
                if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                    this.f20877a.y(requestUpdateMaskInfoMessage.getMaskType(), responseUpdateMaskInfoMessage.getError() == 0, requestUpdateMaskInfoMessage.isSettingMask(), responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgRemindModel f20878a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MsgRemindModel msgRemindModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i2)};
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
            this.f20878a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f20878a.f20871e.hideProgressBar();
                if ((socketResponsedMessage instanceof ResponseUpdateMaskMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskMessage)) {
                    ResponseUpdateMaskMessage responseUpdateMaskMessage = (ResponseUpdateMaskMessage) socketResponsedMessage;
                    this.f20878a.y(4, responseUpdateMaskMessage.getError() == 0, ((RequestUpdateMaskMessage) socketResponsedMessage.getOrginalMessage()).isSettingMask(), responseUpdateMaskMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgRemindModel f20879a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MsgRemindModel msgRemindModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgRemindModel, Integer.valueOf(i2)};
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
            this.f20879a = msgRemindModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f20879a.f20871e.hideProgressBar();
                if (socketResponsedMessage instanceof ResponseUpdateForumMask) {
                    ResponseUpdateForumMask responseUpdateForumMask = (ResponseUpdateForumMask) socketResponsedMessage;
                    this.f20879a.y(7, responseUpdateForumMask.getError() == 0, !((RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage()).getFlag(), responseUpdateForumMask.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2, boolean z, boolean z2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20873g = new a(this, CmdConfigHttp.CMD_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.f20874h = new b(this, 104102);
        this.f20875i = new c(this, 104101);
        this.j = new d(this, 104106);
        this.f20871e = baseActivity;
        registerListener(this.f20875i);
        registerListener(this.f20874h);
        registerListener(this.j);
        registerListener(this.f20873g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y(int i2, boolean z, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
            if (z) {
                BaseActivity baseActivity = this.f20871e;
                baseActivity.showToast(baseActivity.getResources().getString(R.string.success));
                e eVar = this.f20872f;
                if (eVar != null) {
                    eVar.a(i2, true, z2);
                    if (i2 != 14) {
                        if (d.a.p0.t.d.d.d().o() || d.a.p0.t.d.d.d().p() || d.a.p0.t.d.d.d().r() || d.a.p0.t.d.d.d().t() || d.a.p0.t.d.d.d().w() || d.a.p0.t.d.d.d().n() || d.a.p0.t.d.d.d().z()) {
                            return;
                        }
                        this.f20872f.a(14, true, false);
                        return;
                    }
                    this.f20872f.a(2, true, z2);
                    this.f20872f.a(3, true, z2);
                    this.f20872f.a(4, true, z2);
                    this.f20872f.a(5, true, z2);
                    this.f20872f.a(1, true, z2);
                    this.f20872f.a(20, true, z2);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f20871e.showToast(str);
            } else {
                this.f20871e.showToast(R.string.setdefualt_error);
            }
            e eVar2 = this.f20872f;
            if (eVar2 != null) {
                eVar2.a(i2, false, z2);
            }
        }
    }

    public void z(int i2, boolean z, e eVar) {
        Message<?> friendAndStrangerReqMsg;
        Message<?> friendAndStrangerReqMsg2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), eVar}) == null) {
            if (i2 == 14 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 1 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 20 || i2 == 6) {
                this.f20872f = eVar;
                if (i2 == 4) {
                    RequestUpdateMaskMessage requestUpdateMaskMessage = new RequestUpdateMaskMessage();
                    requestUpdateMaskMessage.setSettingMask(z);
                    sendMessage(requestUpdateMaskMessage);
                } else if (i2 == 7) {
                    RequestUpdateForumMask requestUpdateForumMask = new RequestUpdateForumMask();
                    requestUpdateForumMask.setType(1);
                    requestUpdateForumMask.setFlag(z);
                    sendMessage(requestUpdateForumMask);
                } else if (i2 == 8) {
                    if (z) {
                        friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(1, i2);
                    } else {
                        friendAndStrangerReqMsg2 = new FriendAndStrangerReqMsg(3, i2);
                    }
                    sendMessage(friendAndStrangerReqMsg2);
                } else if (i2 == 9) {
                    if (z) {
                        friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(0, i2);
                    } else {
                        friendAndStrangerReqMsg = new FriendAndStrangerReqMsg(1, i2);
                    }
                    sendMessage(friendAndStrangerReqMsg);
                } else if (i2 == 6) {
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
                } else {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage2 = new RequestUpdateMaskInfoMessage();
                    requestUpdateMaskInfoMessage2.setMaskType(i2);
                    requestUpdateMaskInfoMessage2.setSettingMask(z);
                    sendMessage(requestUpdateMaskInfoMessage2);
                }
                this.f20871e.showProgressBar();
            }
        }
    }
}

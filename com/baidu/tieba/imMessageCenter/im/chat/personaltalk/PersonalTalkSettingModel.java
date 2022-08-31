package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.a87;
import com.baidu.tieba.db;
import com.baidu.tieba.hf5;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import com.baidu.tieba.lf5;
import com.baidu.tieba.oe5;
import com.baidu.tieba.rz4;
import com.baidu.tieba.s97;
import com.baidu.tieba.userblock.UserBlockInfoModel;
import com.baidu.tieba.wm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import protobuf.QueryUserInfos.DataRes;
import tbclient.PermissionList;
/* loaded from: classes4.dex */
public class PersonalTalkSettingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rz4 a;
    public DataRes b;
    public boolean c;
    public boolean d;
    public boolean e;
    public BdUniqueId f;
    public final BlackListModel g;
    public PermissionList h;
    public UserBlockInfoModel i;
    public IMUserListModel j;
    public UserData k;
    public ImMessageCenterPojo l;
    public PersonalTalkSettingActivity m;
    public g n;
    public db o;
    public CustomMessageListener p;
    public HttpMessageListener q;

    /* loaded from: classes4.dex */
    public class a extends hf5<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(PersonalTalkSettingModel personalTalkSettingModel, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingModel, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf5
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? s97.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a)) : (PersonalSettingItemData) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements oe5<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ PersonalTalkSettingActivity b;
        public final /* synthetic */ PersonalTalkSettingModel c;

        public b(PersonalTalkSettingModel personalTalkSettingModel, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingModel, Long.valueOf(j), personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = personalTalkSettingModel;
            this.a = j;
            this.b = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oe5
        /* renamed from: a */
        public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, personalSettingItemData) == null) {
                if (personalSettingItemData != null) {
                    this.c.e = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(this.a);
                this.b.sendMessage(requestQueryUserInfoMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements wm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingModel a;

        public c(PersonalTalkSettingModel personalTalkSettingModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalTalkSettingModel;
        }

        @Override // com.baidu.tieba.wm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a.m == null) {
                return;
            }
            this.a.m.showToast(str);
        }

        @Override // com.baidu.tieba.wm4
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (obj instanceof tbclient.GetUserBlackInfo.DataRes)) {
                this.a.h = ((tbclient.GetUserBlackInfo.DataRes) obj).perm_list;
                if (this.a.n != null) {
                    this.a.n.K();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends db {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalTalkSettingModel personalTalkSettingModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingModel, Integer.valueOf(i)};
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
            this.a = personalTalkSettingModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 104102) {
                if (socketResponsedMessage instanceof ResponsedMessage) {
                    this.a.m.closeLoadingDialog();
                    if (socketResponsedMessage.getError() != 0) {
                        this.a.m.showToast(socketResponsedMessage.getErrorString());
                    }
                }
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                        if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                            this.a.d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                            if (this.a.n != null) {
                                this.a.n.K();
                            }
                        }
                    }
                }
            } else if (cmd != 205003) {
            } else {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                    this.a.m.hideProgressBar();
                    this.a.m.showToast(socketResponsedMessage.getErrorString());
                } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                    ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                    if (responseQueryUserInfoMessage.getResData() != null) {
                        this.a.b = responseQueryUserInfoMessage.getResData();
                        PersonalTalkSettingModel personalTalkSettingModel = this.a;
                        personalTalkSettingModel.c = personalTalkSettingModel.b.hasConcerned.intValue() == 1;
                        PersonalTalkSettingModel personalTalkSettingModel2 = this.a;
                        personalTalkSettingModel2.d = personalTalkSettingModel2.b.isBlacklist.intValue() == 1;
                        this.a.m.hideProgressBar();
                        if (this.a.n != null) {
                            this.a.n.K();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PersonalTalkSettingModel personalTalkSettingModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingModel, Integer.valueOf(i)};
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
            this.a = personalTalkSettingModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (this.a.m == null || TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        return;
                    }
                    this.a.m.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                this.a.c = updateAttentionMessage.isAttention();
                if (this.a.m != null) {
                    if (this.a.c) {
                        this.a.m.showToast(R.string.obfuscated_res_0x7f0f00d2);
                    } else {
                        this.a.m.showToast(R.string.obfuscated_res_0x7f0f0fd8);
                    }
                }
                if (this.a.n != null) {
                    this.a.n.K();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PersonalTalkSettingModel personalTalkSettingModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingModel, Integer.valueOf(i)};
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
            this.a = personalTalkSettingModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof IMUserListHttpResponseMsg)) {
                IMUserListHttpResponseMsg iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage;
                if (ListUtils.isEmpty(iMUserListHttpResponseMsg.getUserDataResultList())) {
                    return;
                }
                this.a.k = iMUserListHttpResponseMsg.getUserDataResultList().get(0);
                this.a.l = a87.f().g(String.valueOf(this.a.getUid()), 2);
                if (this.a.n != null) {
                    this.a.n.K();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void K();
    }

    public PersonalTalkSettingModel(PersonalTalkSettingActivity personalTalkSettingActivity, g gVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity, gVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.e = false;
        this.f = BdUniqueId.gen();
        this.o = new d(this, 0);
        this.p = new e(this, 0);
        this.q = new f(this, CmdConfigHttp.CMD_GET_USER_LIST);
        this.m = personalTalkSettingActivity;
        this.n = gVar;
        this.a = new rz4(personalTalkSettingActivity.getPageContext());
        this.g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        P();
        Q();
        this.i.F(j);
        this.j = new IMUserListModel(personalTalkSettingActivity.getPageContext(), getUniqueId());
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(j));
        this.j.request(false, arrayList);
        lf5.c(new a(this, j), new b(this, j, personalTalkSettingActivity));
    }

    public DataRes K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (DataRes) invokeV.objValue;
    }

    public PermissionList L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (PermissionList) invokeV.objValue;
    }

    public UserData M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (UserData) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rz4 rz4Var = this.a;
            if (rz4Var != null) {
                rz4Var.g();
            }
            BlackListModel blackListModel = this.g;
            if (blackListModel != null) {
                blackListModel.cancelLoadData();
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            registerListener(205003, this.o);
            registerListener(104102, this.o);
            registerListener(this.p);
            registerListener(this.q);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(this.m.getPageContext(), getUniqueId());
            this.i = userBlockInfoModel;
            userBlockInfoModel.G(new c(this));
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e = z;
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(9);
            requestUpdateMaskInfoMessage.setList(String.valueOf(getUid()));
            requestUpdateMaskInfoMessage.setMask(z);
            requestUpdateMaskInfoMessage.setTag(this.f);
            MessageManager.getInstance().removeMessage(104102, this.f);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ImMessageCenterPojo imMessageCenterPojo = this.l;
            if (imMessageCenterPojo != null) {
                return imMessageCenterPojo.getNameShow();
            }
            UserData userData = this.k;
            if (userData != null) {
                return userData.getName_show();
            }
            DataRes dataRes = this.b;
            return dataRes == null ? "" : dataRes.nameShow;
        }
        return (String) invokeV.objValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            DataRes dataRes = this.b;
            if (dataRes != null) {
                return dataRes.id.longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}

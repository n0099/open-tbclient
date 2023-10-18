package com.baidu.tieba.immessagecenter.im.chat.personaltalk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.SocketMessageListener;
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
import com.baidu.tbadk.coreExtra.model.AttentionModel;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.gs5;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.immessagecenter.RequestQueryUserInfoMessage;
import com.baidu.tieba.ks5;
import com.baidu.tieba.lr5;
import com.baidu.tieba.userblock.UserBlockInfoModel;
import com.baidu.tieba.vg8;
import com.baidu.tieba.xd8;
import com.baidu.tieba.yt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import protobuf.QueryUserInfos.DataRes;
import tbclient.PermissionList;
/* loaded from: classes6.dex */
public class PersonalTalkSettingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AttentionModel a;
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
    public f n;
    public SocketMessageListener o;
    public CustomMessageListener p;
    public HttpMessageListener q;

    /* loaded from: classes6.dex */
    public interface f {
        void q();
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

    /* loaded from: classes6.dex */
    public class a extends gs5<PersonalSettingItemData> {
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
        @Override // com.baidu.tieba.gs5
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return vg8.a().getSetting(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a));
            }
            return (PersonalSettingItemData) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lr5<PersonalSettingItemData> {
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
        @Override // com.baidu.tieba.lr5
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

    /* loaded from: classes6.dex */
    public class c extends SocketMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonalTalkSettingModel personalTalkSettingModel, int i) {
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
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, socketResponsedMessage) != null) || socketResponsedMessage == null) {
                return;
            }
            int cmd = socketResponsedMessage.getCmd();
            boolean z2 = false;
            if (cmd != 104102) {
                if (cmd == 205003) {
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                        this.a.m.hideProgressBar();
                        this.a.m.showToast(socketResponsedMessage.getErrorString());
                        return;
                    } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                        ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                        if (responseQueryUserInfoMessage.getResData() != null) {
                            this.a.b = responseQueryUserInfoMessage.getResData();
                            PersonalTalkSettingModel personalTalkSettingModel = this.a;
                            if (personalTalkSettingModel.b.hasConcerned.intValue() == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            personalTalkSettingModel.c = z;
                            PersonalTalkSettingModel personalTalkSettingModel2 = this.a;
                            if (personalTalkSettingModel2.b.isBlacklist.intValue() == 1) {
                                z2 = true;
                            }
                            personalTalkSettingModel2.d = z2;
                            this.a.m.hideProgressBar();
                            if (this.a.n != null) {
                                this.a.n.q();
                                return;
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
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
                        PersonalTalkSettingModel personalTalkSettingModel3 = this.a;
                        if (requestUpdateMaskInfoMessage.getIsMask() == 1) {
                            z2 = true;
                        }
                        personalTalkSettingModel3.d = z2;
                        if (this.a.n != null) {
                            this.a.n.q();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.isSucc()) {
                    this.a.c = updateAttentionMessage.isAttention();
                    if (this.a.m != null) {
                        if (this.a.c) {
                            this.a.m.showToast(R.string.add_success);
                        } else {
                            this.a.m.showToast(R.string.remove_succ);
                        }
                    }
                    if (this.a.n != null) {
                        this.a.n.q();
                    }
                } else if (this.a.m != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                    this.a.m.showToast(updateAttentionMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends HttpMessageListener {
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
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof IMUserListHttpResponseMsg)) {
                return;
            }
            IMUserListHttpResponseMsg iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage;
            if (!ListUtils.isEmpty(iMUserListHttpResponseMsg.getUserDataResultList())) {
                this.a.k = iMUserListHttpResponseMsg.getUserDataResultList().get(0);
                this.a.l = xd8.f().g(String.valueOf(this.a.getUid()), 2);
                if (this.a.n != null) {
                    this.a.n.q();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements yt4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<PersonalTalkSettingModel> a;

        public g(PersonalTalkSettingModel personalTalkSettingModel) {
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
            this.a = new WeakReference<>(personalTalkSettingModel);
        }

        @Override // com.baidu.tieba.yt4
        public void onError(int i, String str) {
            PersonalTalkSettingModel personalTalkSettingModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && (personalTalkSettingModel = this.a.get()) != null && personalTalkSettingModel.m != null) {
                personalTalkSettingModel.m.showToast(str);
            }
        }

        @Override // com.baidu.tieba.yt4
        public void onSuccess(Object obj) {
            PersonalTalkSettingModel personalTalkSettingModel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (personalTalkSettingModel = this.a.get()) != null && (obj instanceof tbclient.GetUserBlackInfo.DataRes)) {
                personalTalkSettingModel.b0((tbclient.GetUserBlackInfo.DataRes) obj);
            }
        }
    }

    public PersonalTalkSettingModel(PersonalTalkSettingActivity personalTalkSettingActivity, f fVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity, fVar, Long.valueOf(j)};
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
        this.o = new c(this, 0);
        this.p = new d(this, 0);
        this.q = new e(this, CmdConfigHttp.CMD_GET_USER_LIST);
        this.m = personalTalkSettingActivity;
        this.n = fVar;
        this.a = new AttentionModel(personalTalkSettingActivity.getPageContext());
        this.g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        c0();
        d0();
        this.i.T(j);
        this.j = new IMUserListModel(personalTalkSettingActivity.getPageContext(), getUniqueId());
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(j));
        this.j.request(false, arrayList);
        ks5.c(new a(this, j), new b(this, j, personalTalkSettingActivity));
    }

    public final void b0(@NonNull tbclient.GetUserBlackInfo.DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) {
            this.h = dataRes.perm_list;
            f fVar = this.n;
            if (fVar != null) {
                fVar.q();
            }
        }
    }

    public void setNotify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.e = z;
        }
    }

    public DataRes Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (DataRes) invokeV.objValue;
    }

    public PermissionList Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (PermissionList) invokeV.objValue;
    }

    public UserData a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return (UserData) invokeV.objValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(205003, this.o);
            registerListener(104102, this.o);
            registerListener(this.p);
            registerListener(this.q);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            UserBlockInfoModel userBlockInfoModel = new UserBlockInfoModel(this.m.getPageContext(), getUniqueId());
            this.i = userBlockInfoModel;
            userBlockInfoModel.U(new g(this));
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
            this.o = null;
            this.p = null;
            this.q = null;
        }
    }

    public String getNameShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImMessageCenterPojo imMessageCenterPojo = this.l;
            if (imMessageCenterPojo != null) {
                return imMessageCenterPojo.getNameShow();
            }
            UserData userData = this.k;
            if (userData != null) {
                return userData.getName_show();
            }
            DataRes dataRes = this.b;
            if (dataRes == null) {
                return "";
            }
            return dataRes.nameShow;
        }
        return (String) invokeV.objValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            DataRes dataRes = this.b;
            if (dataRes != null) {
                return dataRes.id.longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean isNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            AttentionModel attentionModel = this.a;
            if (attentionModel != null) {
                attentionModel.f();
            }
            BlackListModel blackListModel = this.g;
            if (blackListModel != null) {
                blackListModel.cancelLoadData();
            }
            cancelLoadData();
            f0();
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(9);
            requestUpdateMaskInfoMessage.setList(String.valueOf(getUid()));
            requestUpdateMaskInfoMessage.setMask(z);
            requestUpdateMaskInfoMessage.setTag(this.f);
            MessageManager.getInstance().removeMessage(104102, this.f);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        }
    }
}

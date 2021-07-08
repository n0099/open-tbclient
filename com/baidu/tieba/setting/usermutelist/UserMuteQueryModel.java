package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes4.dex */
public class UserMuteQueryModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public static int NET_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f20871e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f20872f;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserMuteQueryModel f20873a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UserMuteQueryModel userMuteQueryModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteQueryModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20873a = userMuteQueryModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof UserMuteQuerySocketResponsedMessage) {
                    UserMuteQuerySocketResponsedMessage userMuteQuerySocketResponsedMessage = (UserMuteQuerySocketResponsedMessage) responsedMessage;
                    if (userMuteQuerySocketResponsedMessage.getResult() == null) {
                        return;
                    }
                    List<MuteUser> list = userMuteQuerySocketResponsedMessage.getResult().mute_user;
                    ArrayList<MuteUser> arrayList = new ArrayList<>();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    this.f20873a.f20871e.a(arrayList, userMuteQuerySocketResponsedMessage.getError(), userMuteQuerySocketResponsedMessage.getErrorString());
                }
                if (responsedMessage instanceof UserMuteQueryHttpResponsedMessage) {
                    UserMuteQueryHttpResponsedMessage userMuteQueryHttpResponsedMessage = (UserMuteQueryHttpResponsedMessage) responsedMessage;
                    if (userMuteQueryHttpResponsedMessage.getResult() == null) {
                        return;
                    }
                    List<MuteUser> list2 = userMuteQueryHttpResponsedMessage.getResult().mute_user;
                    ArrayList<MuteUser> arrayList2 = new ArrayList<>();
                    if (list2 != null) {
                        for (MuteUser muteUser : list2) {
                            arrayList2.add(muteUser);
                        }
                    }
                    this.f20873a.f20871e.a(arrayList2, userMuteQueryHttpResponsedMessage.getError(), userMuteQueryHttpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ArrayList<MuteUser> arrayList, int i2, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(529427190, "Lcom/baidu/tieba/setting/usermutelist/UserMuteQueryModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(529427190, "Lcom/baidu/tieba/setting/usermutelist/UserMuteQueryModel;");
        }
    }

    public UserMuteQueryModel(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);
        this.f20872f = aVar;
        this.f20871e = bVar;
        registerListener(aVar);
        d.a.p0.h3.d0.a.f(303028, UserMuteQuerySocketResponsedMessage.class, false);
        d.a.p0.h3.d0.a.c(303028, CmdConfigHttp.CMD_USER_MUTE_QUERY, TbConfig.USER_MUTE_QUERY, UserMuteQueryHttpResponsedMessage.class, false, false, true, false);
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
            super.cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f20872f);
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            y(j, 1, 10);
        }
    }

    public void y(long j, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            UserMuteQueryRequestMessage userMuteQueryRequestMessage = new UserMuteQueryRequestMessage();
            userMuteQueryRequestMessage.setUserId(j);
            userMuteQueryRequestMessage.setPn(i2);
            userMuteQueryRequestMessage.setRn(i3);
            sendMessage(userMuteQueryRequestMessage);
        }
    }
}

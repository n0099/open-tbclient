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
/* loaded from: classes5.dex */
public class UserMuteQueryModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public static int NET_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.c.g.a f35931b;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteQueryModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UserMuteQueryModel userMuteQueryModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteQueryModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userMuteQueryModel;
        }

        @Override // c.a.d.c.g.a
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
                    this.a.a.a(arrayList, userMuteQuerySocketResponsedMessage.getError(), userMuteQuerySocketResponsedMessage.getErrorString());
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
                    this.a.a.a(arrayList2, userMuteQueryHttpResponsedMessage.getError(), userMuteQueryHttpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(ArrayList<MuteUser> arrayList, int i, String str);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);
        this.f35931b = aVar;
        this.a = bVar;
        registerListener(aVar);
        c.a.p0.a4.g0.a.f(303028, UserMuteQuerySocketResponsedMessage.class, false);
        c.a.p0.a4.g0.a.c(303028, CmdConfigHttp.CMD_USER_MUTE_QUERY, TbConfig.USER_MUTE_QUERY, UserMuteQueryHttpResponsedMessage.class, false, false, true, false);
    }

    public void A(long j, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            UserMuteQueryRequestMessage userMuteQueryRequestMessage = new UserMuteQueryRequestMessage();
            userMuteQueryRequestMessage.setUserId(j);
            userMuteQueryRequestMessage.setPn(i);
            userMuteQueryRequestMessage.setRn(i2);
            sendMessage(userMuteQueryRequestMessage);
        }
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f35931b);
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            A(j, 1, 10);
        }
    }
}

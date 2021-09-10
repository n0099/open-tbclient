package com.baidu.tieba.userblock;

import c.a.e.a.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.userblock.message.UserBlockSetHttpResponseMessage;
import com.baidu.tieba.userblock.message.UserBlockSetRequestMessage;
import com.baidu.tieba.userblock.message.UserBlockSetSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UserBlockSetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f57531e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.n.a f57532f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.c.g.a f57533g;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserBlockSetModel f57534a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UserBlockSetModel userBlockSetModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userBlockSetModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f57534a = userBlockSetModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UserBlockSetRequestMessage userBlockSetRequestMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f57534a.f57532f == null || responsedMessage == null || (userBlockSetRequestMessage = (UserBlockSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || userBlockSetRequestMessage.getBlockUserId() != this.f57534a.f57531e) {
                return;
            }
            if (!(responsedMessage instanceof UserBlockSetSocketResponseMessage) && !(responsedMessage instanceof UserBlockSetHttpResponseMessage)) {
                this.f57534a.f57532f.onError(-1, this.f57534a.A(R.string.block_user_fail));
                return;
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (error == 0 && !responsedMessage.hasError()) {
                if (StringUtils.isNull(errorString)) {
                    errorString = this.f57534a.A(R.string.block_user_success);
                }
                this.f57534a.f57532f.onSuccess(errorString);
            } else {
                if (StringUtils.isNull(errorString)) {
                    errorString = this.f57534a.A(R.string.block_user_fail);
                }
                this.f57534a.f57532f.onError(error, errorString);
            }
            this.f57534a.f57531e = -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBlockSetModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdUniqueId};
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
        this.f57533g = new a(this, CmdConfigHttp.CMD_USER_BLOCK_SET, 309697);
        setUniqueId(bdUniqueId);
        B();
    }

    public final String A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.j3.d0.a.h(309697, UserBlockSetSocketResponseMessage.class, false, false);
            c.a.r0.j3.d0.a.c(309697, CmdConfigHttp.CMD_USER_BLOCK_SET, TbConfig.URL_USER_BLOCK_SET, UserBlockSetHttpResponseMessage.class, true, false, true, false);
            this.f57533g.getHttpMessageListener().setSelfListener(true);
            this.f57533g.getSocketMessageListener().setSelfListener(true);
            registerListener(this.f57533g);
        }
    }

    public void C(long j2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.f57531e = j2;
            UserBlockSetRequestMessage userBlockSetRequestMessage = new UserBlockSetRequestMessage();
            userBlockSetRequestMessage.setFollow(i2);
            userBlockSetRequestMessage.setInteract(i3);
            userBlockSetRequestMessage.setChat(i4);
            userBlockSetRequestMessage.setBlockUserId(this.f57531e);
            sendMessage(userBlockSetRequestMessage);
        }
    }

    public void D(c.a.q0.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f57532f = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f57531e = -1L;
            MessageManager.getInstance().unRegisterListener(this.f57533g);
        }
    }
}

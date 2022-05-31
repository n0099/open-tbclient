package com.baidu.tieba.userblock;

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
import com.repackage.b9;
import com.repackage.el4;
import com.repackage.ig8;
import com.repackage.wa;
/* loaded from: classes4.dex */
public class UserBlockSetModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public el4 b;
    public wa c;

    /* loaded from: classes4.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserBlockSetModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UserBlockSetModel userBlockSetModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userBlockSetModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = userBlockSetModel;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UserBlockSetRequestMessage userBlockSetRequestMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.a.b == null || responsedMessage == null || (userBlockSetRequestMessage = (UserBlockSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || userBlockSetRequestMessage.getBlockUserId() != this.a.a) {
                return;
            }
            if (!(responsedMessage instanceof UserBlockSetSocketResponseMessage) && !(responsedMessage instanceof UserBlockSetHttpResponseMessage)) {
                this.a.b.onError(-1, this.a.C(R.string.obfuscated_res_0x7f0f0319));
                return;
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (error == 0 && !responsedMessage.hasError()) {
                if (StringUtils.isNull(errorString)) {
                    errorString = this.a.C(R.string.obfuscated_res_0x7f0f031b);
                }
                this.a.b.onSuccess(errorString);
            } else {
                if (StringUtils.isNull(errorString)) {
                    errorString = this.a.C(R.string.obfuscated_res_0x7f0f0319);
                }
                this.a.b.onError(error, errorString);
            }
            this.a.a = -1L;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBlockSetModel(b9 b9Var, BdUniqueId bdUniqueId) {
        super(b9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, bdUniqueId};
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
        this.c = new a(this, CmdConfigHttp.CMD_USER_BLOCK_SET, 309697);
        setUniqueId(bdUniqueId);
        D();
    }

    public final String C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ig8.h(309697, UserBlockSetSocketResponseMessage.class, false, false);
            ig8.c(309697, CmdConfigHttp.CMD_USER_BLOCK_SET, TbConfig.URL_USER_BLOCK_SET, UserBlockSetHttpResponseMessage.class, true, false, true, false);
            this.c.getHttpMessageListener().setSelfListener(true);
            this.c.getSocketMessageListener().setSelfListener(true);
            registerListener(this.c);
        }
    }

    public void E(long j, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.a = j;
            UserBlockSetRequestMessage userBlockSetRequestMessage = new UserBlockSetRequestMessage();
            userBlockSetRequestMessage.setFollow(i);
            userBlockSetRequestMessage.setInteract(i2);
            userBlockSetRequestMessage.setChat(i3);
            userBlockSetRequestMessage.setBlockUserId(this.a);
            sendMessage(userBlockSetRequestMessage);
        }
    }

    public void F(el4 el4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, el4Var) == null) {
            this.b = el4Var;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
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
            this.a = -1L;
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }
}

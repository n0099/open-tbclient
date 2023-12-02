package com.baidu.tieba.userblock;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.userblock.message.UserBlockInfoHttpResponseMessage;
import com.baidu.tieba.userblock.message.UserBlockInfoRequestMessage;
import com.baidu.tieba.uu4;
import com.baidu.tieba.vva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetUserBlackInfo.DataRes;
/* loaded from: classes8.dex */
public class UserBlockInfoModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public uu4 b;
    public NetMessageListener c;

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

    /* loaded from: classes8.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserBlockInfoModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(UserBlockInfoModel userBlockInfoModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userBlockInfoModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = userBlockInfoModel;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UserBlockInfoRequestMessage userBlockInfoRequestMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && this.a.b != null && responsedMessage != null && (userBlockInfoRequestMessage = (UserBlockInfoRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) != null && userBlockInfoRequestMessage.getBlockUserId() == this.a.a) {
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (error == 0 && !responsedMessage.hasError()) {
                    DataRes dataRes = null;
                    if (responsedMessage instanceof UserBlockInfoHttpResponseMessage) {
                        dataRes = ((UserBlockInfoHttpResponseMessage) responsedMessage).getData();
                    }
                    this.a.b.onSuccess(dataRes);
                    this.a.a = -1L;
                    return;
                }
                if (StringUtils.isNull(errorString)) {
                    errorString = this.a.S(R.string.obfuscated_res_0x7f0f06bc);
                }
                this.a.b.onError(error, errorString);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBlockInfoModel(BdPageContext bdPageContext, BdUniqueId bdUniqueId) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, 309698);
        setUniqueId(bdUniqueId);
        T();
    }

    public final String S(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return TbadkCoreApplication.getInst().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void U(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.a = j;
            UserBlockInfoRequestMessage userBlockInfoRequestMessage = new UserBlockInfoRequestMessage();
            userBlockInfoRequestMessage.setBlockUserId(j);
            sendMessage(userBlockInfoRequestMessage);
        }
    }

    public void V(uu4 uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uu4Var) == null) {
            this.b = uu4Var;
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            vva.c(309698, CmdConfigHttp.CMD_GET_USER_BLOCK_INFO, TbConfig.URL_GET_USER_BLOCK_INFO, UserBlockInfoHttpResponseMessage.class, true, false, true, false);
            this.c.getHttpMessageListener().setSelfListener(true);
            this.c.getSocketMessageListener().setSelfListener(true);
            registerListener(this.c);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = -1L;
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }
}

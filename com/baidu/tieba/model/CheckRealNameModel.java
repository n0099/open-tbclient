package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.a9;
import com.baidu.tieba.jb9;
import com.baidu.tieba.model.message.CheckRealNameHttpResponseMessage;
import com.baidu.tieba.model.message.CheckRealNameRequestNetMessage;
import com.baidu.tieba.model.message.CheckRealNameSocketResponseMessage;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CheckRealNameModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_APP_FIRST_START = "app_first_start";
    public static final String TYPE_LIVE_SHARE = "live_share";
    public static final String TYPE_PB_SHARE = "pb_share";
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public za b;

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, String str2, Object obj);
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

    /* loaded from: classes5.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CheckRealNameModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CheckRealNameModel checkRealNameModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {checkRealNameModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = checkRealNameModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if ((!(responsedMessage instanceof CheckRealNameHttpResponseMessage) && !(responsedMessage instanceof CheckRealNameSocketResponseMessage)) || !(responsedMessage.getOrginalMessage().getExtra() instanceof CheckRealNameRequestNetMessage)) {
                return;
            }
            CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = (CheckRealNameRequestNetMessage) responsedMessage.getOrginalMessage().getExtra();
            if (this.a.a != null) {
                this.a.a.a(responsedMessage.getError(), responsedMessage.getErrorString(), checkRealNameRequestNetMessage.getObjSource(), checkRealNameRequestNetMessage.getObjTag());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckRealNameModel(TbPageContext tbPageContext) {
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
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this, CmdConfigHttp.CMD_CHECK_REAL_NAME, 309456);
        U();
        registerListener(this.b);
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
            checkRealNameRequestNetMessage.setObjSource(str);
            sendMessage(checkRealNameRequestNetMessage);
        }
    }

    public void V(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void T(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
            checkRealNameRequestNetMessage.setObjSource(str);
            checkRealNameRequestNetMessage.setObjTag(obj);
            sendMessage(checkRealNameRequestNetMessage);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jb9.h(309456, CheckRealNameSocketResponseMessage.class, false, false);
            jb9.c(309456, CmdConfigHttp.CMD_CHECK_REAL_NAME, TbConfig.URL_CHECK_REAL_NAME, CheckRealNameHttpResponseMessage.class, false, false, false, false);
        }
    }
}

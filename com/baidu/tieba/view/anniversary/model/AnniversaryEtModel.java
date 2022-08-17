package com.baidu.tieba.view.anniversary.model;

import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab;
import com.repackage.d9;
import com.repackage.jk8;
import com.repackage.tw8;
import com.repackage.ww8;
import com.repackage.xw8;
/* loaded from: classes4.dex */
public class AnniversaryEtModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tw8 a;
    public xw8 b;
    public final ab c;

    /* loaded from: classes4.dex */
    public class a extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnniversaryEtModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AnniversaryEtModel anniversaryEtModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversaryEtModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = anniversaryEtModel;
        }

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.a.a == null || this.a.b == null) {
                return;
            }
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.a.a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                return;
            }
            ww8 ww8Var = null;
            if (responsedMessage instanceof AnniversaryEtSocketResMessage) {
                ww8Var = ((AnniversaryEtSocketResMessage) responsedMessage).getResultData();
            } else if (responsedMessage instanceof AnniversaryEtHttpResMessage) {
                ww8Var = ((AnniversaryEtHttpResMessage) responsedMessage).getResultData();
            }
            if (ww8Var != null) {
                this.a.a.J0(ww8Var);
            } else {
                this.a.a.onError(-1, "请求失败，请稍后重试");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnniversaryEtModel(@NonNull TbPageContext tbPageContext, tw8 tw8Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tw8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_HTTP_ET_VIDEO, 309725);
        this.a = tw8Var;
        this.b = new xw8(tbPageContext, tw8Var);
        init();
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            AnniversaryReqMsg anniversaryReqMsg = new AnniversaryReqMsg();
            anniversaryReqMsg.setmSource(i);
            anniversaryReqMsg.setTag(getUniqueId());
            sendMessage(anniversaryReqMsg);
        }
    }

    public void C(ww8 ww8Var) {
        xw8 xw8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ww8Var) == null) || (xw8Var = this.b) == null) {
            return;
        }
        xw8Var.m(ww8Var);
    }

    public void cancel() {
        xw8 xw8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (xw8Var = this.b) == null) {
            return;
        }
        xw8Var.i();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            jk8.h(309725, AnniversaryEtSocketResMessage.class, false, false);
            jk8.c(309725, CmdConfigHttp.CMD_HTTP_ET_VIDEO, "c/f/video/videoTemplate", AnniversaryEtHttpResMessage.class, true, true, true, false);
            registerListener(this.c);
        }
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
}

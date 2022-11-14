package com.baidu.tieba.view.anniversary.model;

import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.l19;
import com.baidu.tieba.o19;
import com.baidu.tieba.p19;
import com.baidu.tieba.qb;
import com.baidu.tieba.r9;
import com.baidu.tieba.to8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AnniversaryEtModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l19 a;
    public p19 b;
    public final qb c;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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

    /* loaded from: classes6.dex */
    public class a extends qb {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && this.a.a != null && this.a.b != null) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    o19 o19Var = null;
                    if (responsedMessage instanceof AnniversaryEtSocketResMessage) {
                        o19Var = ((AnniversaryEtSocketResMessage) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof AnniversaryEtHttpResMessage) {
                        o19Var = ((AnniversaryEtHttpResMessage) responsedMessage).getResultData();
                    }
                    if (o19Var != null) {
                        this.a.a.H0(o19Var);
                        return;
                    } else {
                        this.a.a.onError(-1, "请求失败，请稍后重试");
                        return;
                    }
                }
                this.a.a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnniversaryEtModel(@NonNull TbPageContext tbPageContext, l19 l19Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, l19Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_HTTP_ET_VIDEO, 309725);
        this.a = l19Var;
        this.b = new p19(tbPageContext, l19Var);
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

    public void C(o19 o19Var) {
        p19 p19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o19Var) == null) && (p19Var = this.b) != null) {
            p19Var.m(o19Var);
        }
    }

    public void cancel() {
        p19 p19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (p19Var = this.b) != null) {
            p19Var.i();
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            to8.h(309725, AnniversaryEtSocketResMessage.class, false, false);
            to8.c(309725, CmdConfigHttp.CMD_HTTP_ET_VIDEO, "c/f/video/videoTemplate", AnniversaryEtHttpResMessage.class, true, true, true, false);
            registerListener(this.c);
        }
    }
}

package com.baidu.tieba.view.anniversary.model;

import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.a9;
import com.baidu.tieba.q2a;
import com.baidu.tieba.t2a;
import com.baidu.tieba.u2a;
import com.baidu.tieba.xo9;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AnniversaryEtModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q2a a;
    public u2a b;
    public final za c;

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
    public class a extends za {
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

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && this.a.a != null && this.a.b != null) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    t2a t2aVar = null;
                    if (responsedMessage instanceof AnniversaryEtSocketResMessage) {
                        t2aVar = ((AnniversaryEtSocketResMessage) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof AnniversaryEtHttpResMessage) {
                        t2aVar = ((AnniversaryEtHttpResMessage) responsedMessage).getResultData();
                    }
                    if (t2aVar != null) {
                        this.a.a.E0(t2aVar);
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
    public AnniversaryEtModel(@NonNull TbPageContext tbPageContext, q2a q2aVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, q2aVar};
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
        this.c = new a(this, CmdConfigHttp.CMD_HTTP_ET_VIDEO, 309725);
        this.a = q2aVar;
        this.b = new u2a(tbPageContext, q2aVar);
        init();
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            AnniversaryReqMsg anniversaryReqMsg = new AnniversaryReqMsg();
            anniversaryReqMsg.setmSource(i);
            anniversaryReqMsg.setTag(getUniqueId());
            sendMessage(anniversaryReqMsg);
        }
    }

    public void Y(t2a t2aVar) {
        u2a u2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t2aVar) == null) && (u2aVar = this.b) != null) {
            u2aVar.m(t2aVar);
        }
    }

    public void cancel() {
        u2a u2aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (u2aVar = this.b) != null) {
            u2aVar.i();
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xo9.h(309725, AnniversaryEtSocketResMessage.class, false, false);
            xo9.c(309725, CmdConfigHttp.CMD_HTTP_ET_VIDEO, "c/f/video/videoTemplate", AnniversaryEtHttpResMessage.class, true, true, true, false);
            registerListener(this.c);
        }
    }
}

package com.baidu.tieba.view.anniversary.model;

import androidx.annotation.NonNull;
import c.a.d.a.f;
import c.a.p0.q4.j.b;
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
/* loaded from: classes6.dex */
public class AnniversaryEtModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.q4.j.e.a f37012b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.d.c.g.a f37013c;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.c.g.a {
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

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.a.a == null || this.a.f37012b == null) {
                return;
            }
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                this.a.a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                return;
            }
            c.a.p0.q4.j.d.b bVar = null;
            if (responsedMessage instanceof AnniversaryEtSocketResMessage) {
                bVar = ((AnniversaryEtSocketResMessage) responsedMessage).getResultData();
            } else if (responsedMessage instanceof AnniversaryEtHttpResMessage) {
                bVar = ((AnniversaryEtHttpResMessage) responsedMessage).getResultData();
            }
            if (bVar != null) {
                this.a.a.onResponeSucess(bVar);
            } else {
                this.a.a.onError(-1, "请求失败，请稍后重试");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnniversaryEtModel(@NonNull TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37013c = new a(this, CmdConfigHttp.CMD_HTTP_ET_VIDEO, 309725);
        this.a = bVar;
        this.f37012b = new c.a.p0.q4.j.e.a(tbPageContext, bVar);
        init();
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            AnniversaryReqMsg anniversaryReqMsg = new AnniversaryReqMsg();
            anniversaryReqMsg.setmSource(i);
            anniversaryReqMsg.setTag(getUniqueId());
            sendMessage(anniversaryReqMsg);
        }
    }

    public void B(c.a.p0.q4.j.d.b bVar) {
        c.a.p0.q4.j.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || (aVar = this.f37012b) == null) {
            return;
        }
        aVar.m(bVar);
    }

    public void cancel() {
        c.a.p0.q4.j.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f37012b) == null) {
            return;
        }
        aVar.i();
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
            c.a.p0.a4.g0.a.h(309725, AnniversaryEtSocketResMessage.class, false, false);
            c.a.p0.a4.g0.a.c(309725, CmdConfigHttp.CMD_HTTP_ET_VIDEO, "c/f/video/videoTemplate", AnniversaryEtHttpResMessage.class, true, true, true, false);
            registerListener(this.f37013c);
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

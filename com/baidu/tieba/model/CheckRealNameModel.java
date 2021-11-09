package com.baidu.tieba.model;

import b.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.CheckRealNameHttpResponseMessage;
import com.baidu.tieba.model.message.CheckRealNameRequestNetMessage;
import com.baidu.tieba.model.message.CheckRealNameSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CheckRealNameModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_APP_FIRST_START = "app_first_start";
    public static final String TYPE_LIVE_SHARE = "live_share";
    public static final String TYPE_PB_SHARE = "pb_share";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f51629e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.c.g.a f51630f;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CheckRealNameModel f51631a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CheckRealNameModel checkRealNameModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {checkRealNameModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f51631a = checkRealNameModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (((responsedMessage instanceof CheckRealNameHttpResponseMessage) || (responsedMessage instanceof CheckRealNameSocketResponseMessage)) && (responsedMessage.getOrginalMessage().getExtra() instanceof CheckRealNameRequestNetMessage)) {
                CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = (CheckRealNameRequestNetMessage) responsedMessage.getOrginalMessage().getExtra();
                if (this.f51631a.f51629e != null) {
                    this.f51631a.f51629e.a(responsedMessage.getError(), responsedMessage.getErrorString(), checkRealNameRequestNetMessage.getObjSource(), checkRealNameRequestNetMessage.getObjTag());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i2, String str, String str2, Object obj);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51630f = new a(this, CmdConfigHttp.CMD_CHECK_REAL_NAME, 309456);
        z();
        registerListener(this.f51630f);
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f51629e = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
            checkRealNameRequestNetMessage.setObjSource(str);
            sendMessage(checkRealNameRequestNetMessage);
        }
    }

    public void y(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, obj) == null) {
            CheckRealNameRequestNetMessage checkRealNameRequestNetMessage = new CheckRealNameRequestNetMessage();
            checkRealNameRequestNetMessage.setObjSource(str);
            checkRealNameRequestNetMessage.setObjTag(obj);
            sendMessage(checkRealNameRequestNetMessage);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.l3.f0.a.h(309456, CheckRealNameSocketResponseMessage.class, false, false);
            b.a.r0.l3.f0.a.c(309456, CmdConfigHttp.CMD_CHECK_REAL_NAME, TbConfig.URL_CHECK_REAL_NAME, CheckRealNameHttpResponseMessage.class, false, false, false, false);
        }
    }
}

package com.baidu.tieba.setting.more.youngster.model;

import c.a.d.a.f;
import c.a.t0.n3.g;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.setting.more.youngster.message.YoungsterVerifyHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class YoungsterVerifyModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f47877e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f47878f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f47879g;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YoungsterVerifyModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(YoungsterVerifyModel youngsterVerifyModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterVerifyModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = youngsterVerifyModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            this.a.mErrorCode = httpResponsedMessage.getError();
            this.a.mErrorString = httpResponsedMessage.getErrorString();
            if (!StringUtils.isNull(this.a.mErrorString)) {
                str = this.a.mErrorString;
            } else {
                str = TbadkCoreApplication.getInst().getResources().getString(g.neterror);
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.a.mErrorCode);
            errorData.setError_msg(str);
            YoungsterVerifyHttpResponsedMessage youngsterVerifyHttpResponsedMessage = httpResponsedMessage instanceof YoungsterVerifyHttpResponsedMessage ? (YoungsterVerifyHttpResponsedMessage) httpResponsedMessage : null;
            if (youngsterVerifyHttpResponsedMessage != null && youngsterVerifyHttpResponsedMessage.getData() != null && youngsterVerifyHttpResponsedMessage.getData().a) {
                this.a.f47877e.onSuccess();
            } else {
                this.a.f47877e.onError(errorData);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void onError(ErrorData errorData);

        void onSuccess();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoungsterVerifyModel(TbPageContext<?> tbPageContext, b bVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
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
        a aVar = new a(this, CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
        this.f47879g = aVar;
        this.f47878f = tbPageContext;
        aVar.setSelfListener(true);
        registerListener(this.f47879g);
        this.f47877e = bVar;
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
            httpMessage.addParam(YoungsterVerifyActivityConfig.PARAMA_AUTH_ID, str);
            httpMessage.addParam("scene", YoungsterVerifyActivityConfig.PARAMA_TIEBA_AUTH);
            this.f47878f.sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
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
}

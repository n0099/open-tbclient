package com.baidu.tieba.stamp.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.hj9;
import com.baidu.tieba.lj9;
import com.baidu.tieba.sm;
import com.baidu.tieba.stamp.model.msg.GetStampResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class FetchStampModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public lj9 b;
    public int c;
    public bg<sm> d;
    public String e;
    public HttpMessageListener f;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FetchStampModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FetchStampModel fetchStampModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fetchStampModel, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fetchStampModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003522 && (httpResponsedMessage instanceof GetStampResponseMessage)) {
                List<hj9> stampList = ((GetStampResponseMessage) httpResponsedMessage).getStampList();
                if (httpResponsedMessage.getError() == 0) {
                    this.a.T(stampList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends bg<sm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hj9 a;
        public final /* synthetic */ FetchStampModel b;

        public b(FetchStampModel fetchStampModel, hj9 hj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fetchStampModel, hj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fetchStampModel;
            this.a = hj9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(sm smVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, smVar, str, i) == null) {
                super.onLoaded((b) smVar, str, i);
                if (smVar != null && smVar.w()) {
                    this.b.b.a(this.a);
                }
            }
        }
    }

    public FetchStampModel(TbPageContext tbPageContext, lj9 lj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lj9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 10;
        this.f = new a(this, CmdConfigHttp.CMD_FETCH_STAMP, true);
        this.a = tbPageContext;
        this.b = lj9Var;
        S();
        registerListener();
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FETCH_STAMP, TbConfig.SERVER_ADDRESS + "c/s/getIconToast");
            tbHttpMessageTask.setResponsedClass(GetStampResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!StringUtils.isNull(this.e) && this.d != null) {
                cg.h().d(this.e, this.c, this.d);
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_FETCH_STAMP);
            MessageManager.getInstance().unRegisterListener(this.f);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T(List<hj9> list) {
        hj9 hj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list == null || list.size() <= 0 || (hj9Var = list.get(0)) == null) {
            return;
        }
        String a2 = hj9Var.a();
        this.e = a2;
        if (StringUtils.isNull(a2)) {
            return;
        }
        if (this.d == null) {
            this.d = new b(this, hj9Var);
        }
        sm smVar = (sm) cg.h().n(this.e, this.c, new Object[0]);
        if (smVar != null && smVar.w()) {
            this.b.a(hj9Var);
        } else if (this.a != null) {
            cg.h().m(this.e, this.c, this.d, this.a.getUniqueId());
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_FETCH_STAMP));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().registerListener(this.f);
        }
    }
}

package com.baidu.tieba.tbadkCore;

import c.a.d.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class PraiseModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIKE = 1;
    public static final int UN_LIKE = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final String f48146g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f48147h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f48148e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f48149f;

    /* loaded from: classes13.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PraiseModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PraiseModel praiseModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {praiseModel, Integer.valueOf(i2)};
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
            this.a = praiseModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
                int statusCode = httpResponsedMessage.getStatusCode();
                if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                    if (this.a.f48148e != null) {
                        this.a.f48148e.b(statusCode, null);
                        return;
                    }
                    return;
                }
                PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
                if (praiseResponseMessage.getError() == 0) {
                    this.a.f48148e.a(praiseResponseMessage.getErrMsg());
                } else if (this.a.f48148e != null) {
                    this.a.f48148e.b(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        void a(String str);

        void b(int i2, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337401938, "Lcom/baidu/tieba/tbadkCore/PraiseModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337401938, "Lcom/baidu/tieba/tbadkCore/PraiseModel;");
                return;
            }
        }
        String str = TbConfig.SERVER_ADDRESS + TbConfig.COMMON_PRAISE_URL;
        f48146g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, str);
        f48147h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(f48147h);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PraiseModel(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48148e = null;
        this.f48149f = new a(this, CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.f48148e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f48149f.setSelfListener(true);
            this.f48149f.setTag(getUniqueId());
            registerListener(this.f48149f);
        }
    }
}

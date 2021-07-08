package com.baidu.tieba.tbadkCore;

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
import d.a.c.a.f;
/* loaded from: classes4.dex */
public class PraiseModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIKE = 1;
    public static final int UN_LIKE = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final String f21123g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f21124h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f21125e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f21126f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PraiseModel f21127a;

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
            this.f21127a = praiseModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
                int statusCode = httpResponsedMessage.getStatusCode();
                if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                    if (this.f21127a.f21125e != null) {
                        this.f21127a.f21125e.b(statusCode, null);
                        return;
                    }
                    return;
                }
                PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
                if (praiseResponseMessage.getError() == 0) {
                    this.f21127a.f21125e.a(praiseResponseMessage.getErrMsg());
                } else if (this.f21127a.f21125e != null) {
                    this.f21127a.f21125e.b(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        f21123g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, str);
        f21124h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(f21124h);
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
        this.f21125e = null;
        this.f21126f = new a(this, CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.f21125e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21126f.setSelfListener(true);
            this.f21126f.setTag(getUniqueId());
            registerListener(this.f21126f);
        }
    }
}

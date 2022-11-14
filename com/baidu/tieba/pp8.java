package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.write.message.AddPostHttpResponse;
import com.baidu.tieba.write.message.AddPostRequest;
import com.baidu.tieba.write.message.AddThreadHttpResponse;
import com.baidu.tieba.write.message.AddThreadRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public final BdUniqueId b;
    public HttpMessageListener c;
    public HttpMessageListener d;

    /* loaded from: classes5.dex */
    public interface e {
        void a(nr8 nr8Var);
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pp8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pp8 pp8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pp8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pp8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                cr4.b(AlbumActivityConfig.FROM_WRITE, "threadRES");
                if ((httpResponsedMessage instanceof AddThreadHttpResponse) && this.a.a != null) {
                    JSONObject resultData = ((AddThreadHttpResponse) httpResponsedMessage).getResultData();
                    nr8 nr8Var = new nr8();
                    if (httpResponsedMessage.hasError()) {
                        nr8Var.i(true);
                        nr8Var.f(httpResponsedMessage.getError());
                        nr8Var.h(httpResponsedMessage.getErrorString());
                    } else {
                        nr8Var.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(resultData);
                        nr8Var.f(errorData.getError_code());
                        nr8Var.h(errorData.getError_msg());
                        nr8Var.g(errorData.getError_data());
                    }
                    nr8Var.j(resultData);
                    this.a.a.a(nr8Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pp8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pp8 pp8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pp8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pp8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                cr4.b(AlbumActivityConfig.FROM_WRITE, "postRES");
                if ((httpResponsedMessage instanceof AddPostHttpResponse) && this.a.a != null) {
                    JSONObject resultData = ((AddPostHttpResponse) httpResponsedMessage).getResultData();
                    nr8 nr8Var = new nr8();
                    if (httpResponsedMessage.hasError()) {
                        nr8Var.i(true);
                        nr8Var.f(httpResponsedMessage.getError());
                        nr8Var.h(httpResponsedMessage.getErrorString());
                    } else {
                        nr8Var.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(resultData);
                        nr8Var.f(errorData.getError_code());
                        nr8Var.h(errorData.getError_msg());
                        nr8Var.g(errorData.getError_data());
                    }
                    nr8Var.j(resultData);
                    this.a.a.a(nr8Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddThreadRequest a;

        public c(pp8 pp8Var, AddThreadRequest addThreadRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pp8Var, addThreadRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addThreadRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddPostRequest a;

        public d(pp8 pp8Var, AddPostRequest addPostRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pp8Var, addPostRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = addPostRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948069841, "Lcom/baidu/tieba/pp8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948069841, "Lcom/baidu/tieba/pp8;");
                return;
            }
        }
        d();
    }

    public pp8(r9<?> r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = BdUniqueId.gen();
        this.c = new a(this, CmdConfigHttp.CMD_WRITE_THREAD_ADD);
        this.d = new b(this, CmdConfigHttp.CMD_WRITE_POST_ADD);
        this.c.setTag(this.b);
        this.c.setSelfListener(true);
        this.d.setTag(this.b);
        this.d.setSelfListener(true);
        if (r9Var != null) {
            r9Var.registerListener(this.c);
            r9Var.registerListener(this.d);
            return;
        }
        MessageManager.getInstance().registerListener(this.c);
        MessageManager.getInstance().registerListener(this.d);
    }

    public void b(NetWork netWork) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, netWork) == null) {
            AddPostRequest addPostRequest = new AddPostRequest();
            addPostRequest.setRequestData(netWork.getPostDataMap());
            addPostRequest.setNetType(NetMessage.NetType.HTTP);
            addPostRequest.setTag(this.b);
            ah.a().post(new d(this, addPostRequest));
        }
    }

    public void c(NetWork netWork) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netWork) == null) {
            AddThreadRequest addThreadRequest = new AddThreadRequest();
            addThreadRequest.setRequestData(netWork.getPostDataMap());
            addThreadRequest.setNetType(NetMessage.NetType.HTTP);
            addThreadRequest.setTag(this.b);
            ah.a().post(new c(this, addThreadRequest));
        }
    }

    public pp8 e(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            this.a = eVar;
            return this;
        }
        return (pp8) invokeL.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_WRITE_THREAD_ADD, to8.a(TbConfig.POST_THREAD_ADDRESS, 309730));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(AddThreadHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_WRITE_POST_ADD, to8.a(TbConfig.REPLY_THREAD_ADDRESS, 309731));
            tbHttpMessageTask2.setIsNeedAddCommenParam(true);
            tbHttpMessageTask2.setResponsedClass(AddPostHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        }
    }
}

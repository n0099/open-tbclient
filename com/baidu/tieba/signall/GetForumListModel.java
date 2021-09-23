package com.baidu.tieba.signall;

import c.a.e.a.f;
import c.a.r0.f3.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f56937e;

    /* renamed from: f  reason: collision with root package name */
    public b f56938f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessage f56939g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56940h;

    /* renamed from: i  reason: collision with root package name */
    public final BdUniqueId f56941i;

    /* renamed from: j  reason: collision with root package name */
    public ResponsedMessage<?> f56942j;
    public final HttpMessageListener k;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetForumListModel f56943a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetForumListModel getForumListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getForumListModel, Integer.valueOf(i2)};
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
            this.f56943a = getForumListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                int error = httpResponsedMessage.getError();
                this.f56943a.f56942j = httpResponsedMessage;
                if (!httpResponsedMessage.isSuccess()) {
                    if (error == 110001) {
                        this.f56943a.C(httpResponsedMessage);
                    }
                    this.f56943a.f56938f.onNetError(httpResponsedMessage.getErrorString());
                } else if (error == 0) {
                    this.f56943a.f56937e = ((GetForumResponsed) httpResponsedMessage).listData;
                    if (this.f56943a.f56938f != null) {
                        if (this.f56943a.f56937e != null) {
                            this.f56943a.f56938f.a(this.f56943a.f56937e);
                        } else {
                            String errorString = httpResponsedMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                            }
                            this.f56943a.f56938f.onNetError(errorString);
                        }
                    }
                } else {
                    this.f56943a.f56938f.onNetError(httpResponsedMessage.getErrorString());
                }
                this.f56943a.f56939g = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(c cVar);

        void onNetError(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1725150164, "Lcom/baidu/tieba/signall/GetForumListModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1725150164, "Lcom/baidu/tieba/signall/GetForumListModel;");
                return;
            }
        }
        l = TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
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
        this.f56937e = null;
        this.f56938f = null;
        this.f56941i = BdUniqueId.gen();
        this.k = new a(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        this.f56940h = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.f56937e = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, l);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.k);
    }

    public final void C(HttpResponsedMessage httpResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            try {
                Field declaredField = HttpMessage.class.getDeclaredField("mParams");
                declaredField.setAccessible(true);
                if (declaredField.get(httpMessage) instanceof HashMap) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : ((HashMap) declaredField.get(httpMessage)).entrySet()) {
                        Object value = entry.getValue();
                        sb.append("key=");
                        sb.append((String) entry.getKey());
                        sb.append("value=");
                        sb.append(value.toString());
                        sb.append("&");
                    }
                    c.a.q0.s.z.a.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", 110001, sb.toString(), new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56940h : invokeV.booleanValue;
    }

    public void E(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f56938f = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f56939g != null) {
                return false;
            }
            this.f56939g = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            this.f56939g.addParam("user_id", currentAccountObj != null ? currentAccountObj.getID() : null);
            this.f56939g.setTag(this.f56941i);
            MessageManager.getInstance().sendMessage(this.f56939g);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f56939g != null) {
                MessageManager.getInstance().removeHttpMessage(this.f56941i);
                this.f56939g = null;
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
            return true;
        }
        return invokeV.booleanValue;
    }

    public ResponsedMessage<?> getResponsedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56942j : (ResponsedMessage) invokeV.objValue;
    }
}

package com.baidu.tieba.signall;

import c.a.d.a.f;
import c.a.s0.q3.c;
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
/* loaded from: classes12.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f49543e;

    /* renamed from: f  reason: collision with root package name */
    public b f49544f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessage f49545g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49546h;

    /* renamed from: i  reason: collision with root package name */
    public final BdUniqueId f49547i;

    /* renamed from: j  reason: collision with root package name */
    public ResponsedMessage<?> f49548j;

    /* renamed from: k  reason: collision with root package name */
    public final HttpMessageListener f49549k;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GetForumListModel a;

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
            this.a = getForumListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                int error = httpResponsedMessage.getError();
                this.a.f49548j = httpResponsedMessage;
                if (!httpResponsedMessage.isSuccess()) {
                    if (error == 110001) {
                        this.a.C(httpResponsedMessage);
                    }
                    this.a.f49544f.onNetError(httpResponsedMessage.getErrorString());
                } else if (error == 0) {
                    this.a.f49543e = ((GetForumResponsed) httpResponsedMessage).listData;
                    if (this.a.f49544f != null) {
                        if (this.a.f49543e != null) {
                            this.a.f49544f.a(this.a.f49543e);
                        } else {
                            String errorString = httpResponsedMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                            }
                            this.a.f49544f.onNetError(errorString);
                        }
                    }
                } else {
                    this.a.f49544f.onNetError(httpResponsedMessage.getErrorString());
                }
                this.a.f49545g = null;
            }
        }
    }

    /* loaded from: classes12.dex */
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
        this.f49543e = null;
        this.f49544f = null;
        this.f49547i = BdUniqueId.gen();
        this.f49549k = new a(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        this.f49546h = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.f49543e = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, l);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.f49549k);
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
                    c.a.r0.s.c0.a.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", 110001, sb.toString(), new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49546h : invokeV.booleanValue;
    }

    public void E(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f49544f = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f49545g != null) {
                MessageManager.getInstance().removeHttpMessage(this.f49547i);
                this.f49545g = null;
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
            return true;
        }
        return invokeV.booleanValue;
    }

    public ResponsedMessage<?> getResponsedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49548j : (ResponsedMessage) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f49545g != null) {
                return false;
            }
            this.f49545g = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            this.f49545g.addParam("user_id", currentAccountObj != null ? currentAccountObj.getID() : null);
            this.f49545g.setTag(this.f49547i);
            MessageManager.getInstance().sendMessage(this.f49545g);
            return true;
        }
        return invokeV.booleanValue;
    }
}

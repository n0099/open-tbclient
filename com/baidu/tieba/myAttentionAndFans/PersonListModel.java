package com.baidu.tieba.myAttentionAndFans;

import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.q0.s.q.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.message.ResponseFollowListSwitchMsg;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHETIME = 604800000;
    public static final BdUniqueId FOLLOWME;
    public static final BdUniqueId MYFOLLOW;
    public static final int SWITCH_TYPE_ALL = 1;
    public static final int SWITCH_TYPE_TIEBA = 2;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener customListener;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54506e;

    /* renamed from: f  reason: collision with root package name */
    public String f54507f;

    /* renamed from: g  reason: collision with root package name */
    public int f54508g;

    /* renamed from: h  reason: collision with root package name */
    public d f54509h;
    public HttpMessageListener httpListener;

    /* renamed from: i  reason: collision with root package name */
    public int f54510i;

    /* renamed from: j  reason: collision with root package name */
    public PersonListActivity f54511j;
    public c.a.q0.t.e.a k;
    public int l;
    public int m;
    public HttpMessageListener mFollowSwitchListener;
    public String n;
    public int o;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonListModel f54512a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonListModel personListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListModel, Integer.valueOf(i2)};
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
            this.f54512a = personListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002005) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0) {
                    this.f54512a.K();
                    return;
                }
                BdLog.e("follow switch request fail");
                if (this.f54512a.f54509h != null) {
                    this.f54512a.f54509h.b("follow switch request fail", false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonListModel f54513a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonListModel personListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListModel, Integer.valueOf(i2)};
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
            this.f54513a = personListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                if (this.f54513a.getUniqueId().getId() != Integer.parseInt((String) ((HashMap) httpResponsedMessage.getOrginalMessage().getExtra()).get("pageid"))) {
                    return;
                }
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    if (this.f54513a.f54509h != null) {
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.f54513a.f54511j.getResources().getString(R.string.neterror);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        this.f54513a.f54509h.b(errorString, false);
                        return;
                    }
                    return;
                }
                i1 data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                if (data != null) {
                    if (!StringUtils.isNull(data.f14239g)) {
                        this.f54513a.n = data.f14239g;
                        this.f54513a.m = data.f14240h;
                    }
                    data.f14240h = this.f54513a.m;
                    data.f14239g = this.f54513a.n;
                }
                if (this.f54513a.f54509h != null) {
                    this.f54513a.f54509h.a(data, false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonListModel f54514a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonListModel personListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListModel, Integer.valueOf(i2)};
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
            this.f54514a = personListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
                i1 data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                if (data2 == null) {
                    if (this.f54514a.f54509h != null) {
                        this.f54514a.f54509h.b("", true);
                        return;
                    }
                    return;
                }
                if (!StringUtils.isNull(data2.f14239g)) {
                    this.f54514a.n = data2.f14239g;
                    this.f54514a.m = data2.f14240h;
                }
                data2.f14240h = this.f54514a.m;
                data2.f14239g = this.f54514a.n;
                if (this.f54514a.f54509h != null) {
                    this.f54514a.f54509h.a(data2, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        i1 a(i1 i1Var, boolean z);

        void b(String str, boolean z);
    }

    /* loaded from: classes7.dex */
    public static class e extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f54515a;

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54515a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.f54515a == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ERR_URL);
                netWork.addPostData("portrait", this.f54515a);
                return netWork.postNetData();
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1447768321, "Lcom/baidu/tieba/myAttentionAndFans/PersonListModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1447768321, "Lcom/baidu/tieba/myAttentionAndFans/PersonListModel;");
                return;
            }
        }
        MYFOLLOW = BdUniqueId.gen();
        FOLLOWME = BdUniqueId.gen();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonListModel(PersonListActivity personListActivity, d dVar) {
        super(personListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personListActivity, dVar};
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
        this.f54510i = 0;
        this.l = 0;
        this.o = 0;
        this.mFollowSwitchListener = new a(this, CmdConfigHttp.CMD_FOLLOW_SWITCH);
        this.httpListener = new b(this, CmdConfigHttp.PIC_PERSONAL_LIST);
        this.customListener = new c(this, 2001188);
        this.f54511j = personListActivity;
        c.a.q0.t.e.a aVar = new c.a.q0.t.e.a(personListActivity.getPageContext());
        this.k = aVar;
        aVar.k(this.mLoadDataCallBack);
        this.f54506e = true;
        this.f54507f = null;
        this.f54509h = dVar;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54506e : invokeV.booleanValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.intValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54510i : invokeV.intValue;
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.l = i2;
            this.f54510i = 0;
            K();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FOLLOW_SWITCH, TbConfig.SERVER_ADDRESS + "c/c/user/setFollowListSwitch");
            tbHttpMessageTask.setResponsedClass(ResponseFollowListSwitchMsg.class);
            messageManager.registerTask(tbHttpMessageTask);
            registerListener(this.mFollowSwitchListener);
        }
    }

    public void H() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (this.f54506e) {
                str = TbConfig.SERVER_ADDRESS + "c/u/follow/followList";
            } else {
                str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
            }
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
            tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            registerListener(this.httpListener);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.customListener);
            MessageManager.getInstance().unRegisterListener(this.httpListener);
            MessageManager.getInstance().unRegisterListener(this.mFollowSwitchListener);
        }
    }

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.o = i2;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FOLLOW_SWITCH);
            httpMessage.addParam("follow_list_switch", i2);
            sendMessage(httpMessage);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
            HashMap hashMap = new HashMap();
            if (this.f54506e) {
                httpMessage.setTag(FOLLOWME);
            } else {
                httpMessage.setTag(MYFOLLOW);
            }
            String str = this.f54507f;
            if (str != null && !str.equals(TbadkCoreApplication.getCurrentAccount())) {
                httpMessage.addParam("uid", this.f54507f);
            }
            hashMap.put("id", String.valueOf(this.f54507f));
            int i2 = this.f54510i;
            if (i2 != 0) {
                int i3 = i2 + 1;
                this.f54510i = i3;
                httpMessage.addParam("pn", String.valueOf(i3));
            }
            httpMessage.addParam("tab", this.l);
            httpMessage.addParam("follow_list_switch", this.o);
            hashMap.put("page", String.valueOf(this.f54510i));
            hashMap.put("pageid", String.valueOf(getUniqueId().getId()));
            httpMessage.setExtra(hashMap);
            sendMessage(httpMessage);
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f54507f = str;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f54506e = z;
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f54510i = i2;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            new e(str).execute(new Void[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f54507f : (String) invokeV.objValue;
    }

    public int getSex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f54508g : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f54508g = i2;
        }
    }
}

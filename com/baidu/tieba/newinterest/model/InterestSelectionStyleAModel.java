package com.baidu.tieba.newinterest.model;

import c.a.t0.p2.c.b;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.model.msg.GetInterestClassListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class InterestSelectionStyleAModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.p2.a.a f46343e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f46344f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.p2.f.a f46345g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f46346h;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterestSelectionStyleAModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterestSelectionStyleAModel interestSelectionStyleAModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestSelectionStyleAModel, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interestSelectionStyleAModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003509 && (httpResponsedMessage instanceof GetInterestClassListResponseMessage)) {
                this.a.f46344f = ((GetInterestClassListResponseMessage) httpResponsedMessage).getInterestSelectionInfoList();
                if (httpResponsedMessage.getError() == 0) {
                    if (this.a.f46344f == null || this.a.f46344f.size() <= 0) {
                        if (this.a.f46345g != null) {
                            this.a.f46345g.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        }
                        return;
                    }
                    InterestSelectionStyleAModel interestSelectionStyleAModel = this.a;
                    interestSelectionStyleAModel.f46343e.c(interestSelectionStyleAModel.f46344f);
                    this.a.f46343e.notifyDataSetChanged();
                    if (this.a.f46345g != null) {
                        this.a.f46345g.a(this.a.f46344f);
                    }
                } else if (this.a.f46345g != null) {
                    this.a.f46345g.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    public InterestSelectionStyleAModel(c.a.t0.p2.a.a aVar, c.a.t0.p2.f.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46344f = new ArrayList();
        this.f46346h = new a(this, CmdConfigHttp.CMD_INTERESTED_GET_CLASS_LIST, true);
        this.f46345g = aVar2;
        this.f46343e = aVar;
        A();
        registerListener();
        B();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_INTERESTED_GET_CLASS_LIST, TbConfig.SERVER_ADDRESS + "c/f/forum/getInterestClassList");
            tbHttpMessageTask.setResponsedClass(GetInterestClassListResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sendMessage(z());
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_INTERESTED_GET_CLASS_LIST);
            MessageManager.getInstance().unRegisterListener(this.f46346h);
        }
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            C();
        }
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().registerListener(this.f46346h);
        }
    }

    public final HttpMessage z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new HttpMessage(CmdConfigHttp.CMD_INTERESTED_GET_CLASS_LIST) : (HttpMessage) invokeV.objValue;
    }
}

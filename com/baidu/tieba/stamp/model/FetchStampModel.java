package com.baidu.tieba.stamp.model;

import c.a.d.f.l.c;
import c.a.r0.u3.d;
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

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f46652e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.u3.h.a f46653f;

    /* renamed from: g  reason: collision with root package name */
    public int f46654g;

    /* renamed from: h  reason: collision with root package name */
    public c<c.a.d.o.d.a> f46655h;

    /* renamed from: i  reason: collision with root package name */
    public String f46656i;

    /* renamed from: j  reason: collision with root package name */
    public HttpMessageListener f46657j;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FetchStampModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FetchStampModel fetchStampModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fetchStampModel, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.a = fetchStampModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003522 && (httpResponsedMessage instanceof GetStampResponseMessage)) {
                List<d> stampList = ((GetStampResponseMessage) httpResponsedMessage).getStampList();
                if (httpResponsedMessage.getError() == 0) {
                    this.a.z(stampList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FetchStampModel f46658b;

        public b(FetchStampModel fetchStampModel, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fetchStampModel, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46658b = fetchStampModel;
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    return;
                }
                this.f46658b.f46653f.a(this.a);
            }
        }
    }

    public FetchStampModel(TbPageContext tbPageContext, c.a.r0.u3.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46654g = 10;
        this.f46657j = new a(this, CmdConfigHttp.CMD_FETCH_STAMP, true);
        this.f46652e = tbPageContext;
        this.f46653f = aVar;
        y();
        registerListener();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f46656i) && this.f46655h != null) {
                c.a.d.f.l.d.h().d(this.f46656i, this.f46654g, this.f46655h);
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_FETCH_STAMP);
            MessageManager.getInstance().unRegisterListener(this.f46657j);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_FETCH_STAMP));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.f46657j);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FETCH_STAMP, TbConfig.SERVER_ADDRESS + "c/s/getIconToast");
            tbHttpMessageTask.setResponsedClass(GetStampResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void z(List<d> list) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null || list.size() <= 0 || (dVar = list.get(0)) == null) {
            return;
        }
        String a2 = dVar.a();
        this.f46656i = a2;
        if (StringUtils.isNull(a2)) {
            return;
        }
        if (this.f46655h == null) {
            this.f46655h = new b(this, dVar);
        }
        c.a.d.o.d.a aVar = (c.a.d.o.d.a) c.a.d.f.l.d.h().n(this.f46656i, this.f46654g, new Object[0]);
        if (aVar != null && aVar.w()) {
            this.f46653f.a(dVar);
        } else if (this.f46652e != null) {
            c.a.d.f.l.d.h().m(this.f46656i, this.f46654g, this.f46655h, this.f46652e.getUniqueId());
        }
    }
}

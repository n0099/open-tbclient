package com.baidu.tieba.pb.pb.main.emotion.model;

import b.a.e.e.m.e;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.SuggestEmotionResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SuggestEmotionModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f52495e;

    /* renamed from: f  reason: collision with root package name */
    public String f52496f;

    /* renamed from: g  reason: collision with root package name */
    public String f52497g;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f52498h;

    /* renamed from: i  reason: collision with root package name */
    public final HttpMessageListener f52499i;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SuggestEmotionModel f52500a;

        /* renamed from: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1754a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f52501e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f52502f;

            public RunnableC1754a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52502f = aVar;
                this.f52501e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
                    httpMessage.addParam("forum_id", this.f52502f.f52500a.f52496f);
                    httpMessage.addParam("forum_name", this.f52502f.f52500a.f52497g);
                    httpMessage.addParam("has_pkg", (String) this.f52501e.getData());
                    this.f52502f.f52500a.sendMessage(httpMessage);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SuggestEmotionModel suggestEmotionModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suggestEmotionModel, Integer.valueOf(i2)};
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
            this.f52500a = suggestEmotionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                e.a().post(new RunnableC1754a(this, customResponsedMessage));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SuggestEmotionModel f52503a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SuggestEmotionModel suggestEmotionModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suggestEmotionModel, Integer.valueOf(i2)};
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
            this.f52503a = suggestEmotionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003329 && (httpResponsedMessage instanceof SuggestEmotionResponseMessage) && this.f52503a.f52495e != null) {
                SuggestEmotionResponseMessage suggestEmotionResponseMessage = (SuggestEmotionResponseMessage) httpResponsedMessage;
                if (suggestEmotionResponseMessage.getData() != null) {
                    this.f52503a.f52495e.a(suggestEmotionResponseMessage.getData());
                } else {
                    this.f52503a.f52495e.onFail(suggestEmotionResponseMessage.getError(), suggestEmotionResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(b.a.r0.k2.u.f.b1.e.a aVar);

        void onFail(int i2, String str);
    }

    public SuggestEmotionModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52498h = new a(this, 2921322);
        this.f52499i = new b(this, CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
        registerTask();
        this.f52499i.setTag(getUniqueId());
        this.f52499i.setSelfListener(true);
        registerListener(this.f52499i);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f52499i);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
            MessageManager.getInstance().unRegisterListener(this.f52498h);
            return true;
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

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/suggest");
            tbHttpMessageTask.setResponsedClass(SuggestEmotionResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            MessageManager.getInstance().registerListener(this.f52498h);
        }
    }

    public void z(String str, String str2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, cVar) == null) {
            this.f52495e = cVar;
            this.f52496f = str;
            this.f52497g = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004612, new Integer(2921322)));
        }
    }
}

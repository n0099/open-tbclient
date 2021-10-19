package com.baidu.tieba.pb.pb.main.emotion.model;

import c.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.GetSugMatchWordsResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.T;
/* loaded from: classes7.dex */
public class GetSugMatchWordsModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static List<String> f55301g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f55302e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f55303f;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetSugMatchWordsModel f55304a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetSugMatchWordsModel getSugMatchWordsModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getSugMatchWordsModel, Integer.valueOf(i2)};
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
            this.f55304a = getSugMatchWordsModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003370 && (httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) && this.f55304a.f55302e != null) {
                GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
                if (!ListUtils.isEmpty(getSugMatchWordsResponseMessage.getData())) {
                    this.f55304a.f55302e.onSuccess(getSugMatchWordsResponseMessage.getData());
                    GetSugMatchWordsModel.f55301g.clear();
                    GetSugMatchWordsModel.f55301g.addAll(getSugMatchWordsResponseMessage.getData());
                    return;
                }
                this.f55304a.f55302e.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onFail(int i2, String str);

        void onSuccess(List<String> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1754245241, "Lcom/baidu/tieba/pb/pb/main/emotion/model/GetSugMatchWordsModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1754245241, "Lcom/baidu/tieba/pb/pb/main/emotion/model/GetSugMatchWordsModel;");
                return;
            }
        }
        f55301g = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSugMatchWordsModel(f<T> fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
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
        this.f55303f = new a(this, CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
        registerTask();
        this.f55303f.setSelfListener(true);
        registerListener(this.f55303f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f55303f);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
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
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS, TbConfig.SERVER_ADDRESS + "c/e/meme/getSugKeyWords");
            tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void y(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f55302e = bVar;
            if (bVar == null) {
                return;
            }
            if (!ListUtils.isEmpty(f55301g)) {
                this.f55302e.onSuccess(f55301g);
            } else {
                sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS));
            }
        }
    }
}

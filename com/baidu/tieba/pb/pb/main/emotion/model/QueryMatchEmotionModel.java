package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
import b.a.e.a.f;
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
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.message.QueryMatchEmotionResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tbclient.T;
/* loaded from: classes9.dex */
public class QueryMatchEmotionModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static LinkedHashMap<String, List<EmotionImageData>> f52490g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f52491e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f52492f;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ QueryMatchEmotionModel f52493a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QueryMatchEmotionModel queryMatchEmotionModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {queryMatchEmotionModel, Integer.valueOf(i2)};
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
            this.f52493a = queryMatchEmotionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003369 && (httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) && this.f52493a.f52491e != null) {
                QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
                if (queryMatchEmotionResponseMessage.getData() == null) {
                    this.f52493a.f52491e.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
                } else if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                } else {
                    String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                    this.f52493a.f52491e.a(str, queryMatchEmotionResponseMessage.getData());
                    this.f52493a.A(str, queryMatchEmotionResponseMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(String str, List<EmotionImageData> list);

        void onFail(int i2, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2059462482, "Lcom/baidu/tieba/pb/pb/main/emotion/model/QueryMatchEmotionModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2059462482, "Lcom/baidu/tieba/pb/pb/main/emotion/model/QueryMatchEmotionModel;");
                return;
            }
        }
        f52490g = new LinkedHashMap<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryMatchEmotionModel(f<T> fVar) {
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
        this.f52492f = new a(this, CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        registerTask();
        this.f52492f.setSelfListener(true);
        registerListener(this.f52492f);
    }

    public final void A(String str, List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) || TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
            return;
        }
        if (f52490g == null) {
            f52490g = new LinkedHashMap<>();
        }
        if (f52490g.containsKey(str)) {
            return;
        }
        if (f52490g.size() > 10) {
            Map.Entry<String, List<EmotionImageData>> next = f52490g.entrySet().iterator().next();
            if (next != null) {
                f52490g.remove(next.getKey());
            } else {
                f52490g.clear();
            }
        }
        f52490g.put(str, list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f52492f);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/sugQuery");
            tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final List<EmotionImageData> y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            LinkedHashMap<String, List<EmotionImageData>> linkedHashMap = f52490g;
            if (linkedHashMap == null || !linkedHashMap.containsKey(str)) {
                return null;
            }
            return f52490g.get(str);
        }
        return (List) invokeL.objValue;
    }

    public void z(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bVar) == null) {
            this.f52491e = bVar;
            if (bVar == null) {
                return;
            }
            if (!ListUtils.isEmpty(y(str))) {
                this.f52491e.a(str, f52490g.get(str));
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
            httpMessage.addParam("sug_query", str);
            httpMessage.setExtra(str);
            sendMessage(httpMessage);
        }
    }
}

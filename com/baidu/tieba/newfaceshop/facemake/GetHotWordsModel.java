package com.baidu.tieba.newfaceshop.facemake;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class GetHotWordsModel extends FaceBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f51872e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f51873f;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetHotWordsModel f51874a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetHotWordsModel getHotWordsModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getHotWordsModel, Integer.valueOf(i2)};
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
            this.f51874a = getHotWordsModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003352 && (httpResponsedMessage instanceof GetHotWordsMessage) && this.f51874a.f51872e != null) {
                GetHotWordsMessage getHotWordsMessage = (GetHotWordsMessage) httpResponsedMessage;
                if (getHotWordsMessage.getData() != null) {
                    this.f51874a.f51872e.onSuccess(getHotWordsMessage.getData());
                } else {
                    this.f51874a.f51872e.onFail(getHotWordsMessage.getError(), getHotWordsMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onFail(int i2, String str);

        void onSuccess(List<String> list);
    }

    public GetHotWordsModel() {
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
        this.f51873f = new a(this, CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f51873f.setTag(getUniqueId());
        this.f51873f.setSelfListener(true);
        registerListener(this.f51873f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f51873f);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS);
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
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS, TbConfig.SERVER_ADDRESS + "c/e/meme/getHotWords");
            tbHttpMessageTask.setResponsedClass(GetHotWordsMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void x(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f51872e = bVar;
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS));
        }
    }
}
